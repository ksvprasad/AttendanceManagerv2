package com.google.android.gms.p031b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.C1896c;

@id
public class kg {
    private HandlerThread f5617a = null;
    private Handler f5618b = null;
    private int f5619c = 0;
    private final Object f5620d = new Object();

    class C16831 implements Runnable {
        final /* synthetic */ kg f5616a;

        C16831(kg kgVar) {
            this.f5616a = kgVar;
        }

        public void run() {
            synchronized (this.f5616a.f5620d) {
                jv.m9152e("Suspending the looper thread");
                while (this.f5616a.f5619c == 0) {
                    try {
                        this.f5616a.f5620d.wait();
                        jv.m9152e("Looper thread resumed");
                    } catch (InterruptedException e) {
                        jv.m9152e("Looper thread interrupted.");
                    }
                }
            }
        }
    }

    public Looper m9342a() {
        Looper looper;
        synchronized (this.f5620d) {
            if (this.f5619c != 0) {
                C1896c.m10791a(this.f5617a, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f5617a == null) {
                jv.m9152e("Starting the looper thread.");
                this.f5617a = new HandlerThread("LooperProvider");
                this.f5617a.start();
                this.f5618b = new Handler(this.f5617a.getLooper());
                jv.m9152e("Looper thread started.");
            } else {
                jv.m9152e("Resuming the looper thread");
                this.f5620d.notifyAll();
            }
            this.f5619c++;
            looper = this.f5617a.getLooper();
        }
        return looper;
    }

    public void m9343b() {
        synchronized (this.f5620d) {
            C1896c.m10799b(this.f5619c > 0, "Invalid state: release() called more times than expected.");
            int i = this.f5619c - 1;
            this.f5619c = i;
            if (i == 0) {
                this.f5618b.post(new C16831(this));
            }
        }
    }
}
