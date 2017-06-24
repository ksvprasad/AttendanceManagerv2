package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1323a;
import java.util.ArrayList;
import java.util.List;

@id
class kr {
    private final Object f5645a = new Object();
    private final List<Runnable> f5646b = new ArrayList();
    private final List<Runnable> f5647c = new ArrayList();
    private boolean f5648d = false;

    private void m9365c(Runnable runnable) {
        jy.m9180a(runnable);
    }

    private void m9366d(Runnable runnable) {
        C1323a.f3964a.post(runnable);
    }

    public void m9367a() {
        synchronized (this.f5645a) {
            if (this.f5648d) {
                return;
            }
            for (Runnable c : this.f5646b) {
                m9365c(c);
            }
            for (Runnable c2 : this.f5647c) {
                m9366d(c2);
            }
            this.f5646b.clear();
            this.f5647c.clear();
            this.f5648d = true;
        }
    }

    public void m9368a(Runnable runnable) {
        synchronized (this.f5645a) {
            if (this.f5648d) {
                m9365c(runnable);
            } else {
                this.f5646b.add(runnable);
            }
        }
    }

    public void m9369b(Runnable runnable) {
        synchronized (this.f5645a) {
            if (this.f5648d) {
                m9366d(runnable);
            } else {
                this.f5647c.add(runnable);
            }
        }
    }
}
