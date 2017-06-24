package com.google.android.gms.p031b;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;

@id
public abstract class hr extends ju {
    protected final C1042a f5058a;
    protected final Context f5059b;
    protected final Object f5060c = new Object();
    protected final Object f5061d = new Object();
    protected final C1632a f5062e;
    protected AdResponseParcel f5063f;

    class C15761 implements Runnable {
        final /* synthetic */ hr f5054a;

        C15761(hr hrVar) {
            this.f5054a = hrVar;
        }

        public void run() {
            this.f5054a.mo1109b();
        }
    }

    protected static final class C1578a extends Exception {
        private final int f5057a;

        public C1578a(String str, int i) {
            super(str);
            this.f5057a = i;
        }

        public int m8760a() {
            return this.f5057a;
        }
    }

    protected hr(Context context, C1632a c1632a, C1042a c1042a) {
        super(true);
        this.f5059b = context;
        this.f5062e = c1632a;
        this.f5063f = c1632a.f5409b;
        this.f5058a = c1042a;
    }

    protected abstract jl mo1437a(int i);

    public void mo1108a() {
        int a;
        synchronized (this.f5060c) {
            C1324b.m7227a("AdRendererBackgroundTask started.");
            int i = this.f5062e.f5412e;
            try {
                mo1438a(SystemClock.elapsedRealtime());
            } catch (C1578a e) {
                a = e.m8760a();
                if (a == 3 || a == -1) {
                    C1324b.m7232c(e.getMessage());
                } else {
                    C1324b.m7234d(e.getMessage());
                }
                if (this.f5063f == null) {
                    this.f5063f = new AdResponseParcel(a);
                } else {
                    this.f5063f = new AdResponseParcel(a, this.f5063f.f3789k);
                }
                jz.f5567a.post(new C15761(this));
                i = a;
            }
            final jl a2 = mo1437a(i);
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ hr f5056b;

                public void run() {
                    synchronized (this.f5056b.f5060c) {
                        this.f5056b.m8764a(a2);
                    }
                }
            });
        }
    }

    protected abstract void mo1438a(long j);

    protected void m8764a(jl jlVar) {
        this.f5058a.mo966b(jlVar);
    }

    public void mo1109b() {
    }
}
