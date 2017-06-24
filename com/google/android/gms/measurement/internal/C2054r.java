package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.C1896c;

abstract class C2054r {
    private static volatile Handler f6898b;
    private final aj f6899a;
    private final Runnable f6900c = new C20891(this);
    private volatile long f6901d;
    private boolean f6902e = true;

    class C20891 implements Runnable {
        final /* synthetic */ C2054r f6975a;

        C20891(C2054r c2054r) {
            this.f6975a = c2054r;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f6975a.f6899a.m11504h().m11424a((Runnable) this);
                return;
            }
            boolean b = this.f6975a.m11609b();
            this.f6975a.f6901d = 0;
            if (b && this.f6975a.f6902e) {
                this.f6975a.mo1759a();
            }
        }
    }

    C2054r(aj ajVar) {
        C1896c.m10790a((Object) ajVar);
        this.f6899a = ajVar;
    }

    private Handler m11606d() {
        if (f6898b != null) {
            return f6898b;
        }
        Handler handler;
        synchronized (C2054r.class) {
            if (f6898b == null) {
                f6898b = new Handler(this.f6899a.m11513q().getMainLooper());
            }
            handler = f6898b;
        }
        return handler;
    }

    public abstract void mo1759a();

    public void m11608a(long j) {
        m11610c();
        if (j >= 0) {
            this.f6901d = this.f6899a.m11514r().mo1723a();
            if (!m11606d().postDelayed(this.f6900c, j)) {
                this.f6899a.m11502f().m11290f().m11250a("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public boolean m11609b() {
        return this.f6901d != 0;
    }

    public void m11610c() {
        this.f6901d = 0;
        m11606d().removeCallbacks(this.f6900c);
    }
}
