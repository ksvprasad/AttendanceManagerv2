package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jz;

@id
class C1222y implements Runnable {
    private C1208k f3616a;
    private boolean f3617b = false;

    C1222y(C1208k c1208k) {
        this.f3616a = c1208k;
    }

    public void m6781a() {
        this.f3617b = true;
        jz.f5567a.removeCallbacks(this);
    }

    public void m6782b() {
        jz.f5567a.postDelayed(this, 250);
    }

    public void run() {
        if (!this.f3617b) {
            this.f3616a.m6723n();
            m6782b();
        }
    }
}
