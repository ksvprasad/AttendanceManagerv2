package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;

@id
public class kj {
    private long f5625a;
    private long f5626b = Long.MIN_VALUE;
    private Object f5627c = new Object();

    public kj(long j) {
        this.f5625a = j;
    }

    public boolean m9349a() {
        boolean z;
        synchronized (this.f5627c) {
            long b = C1319u.m7187i().mo1724b();
            if (this.f5626b + this.f5625a > b) {
                z = false;
            } else {
                this.f5626b = b;
                z = true;
            }
        }
        return z;
    }
}
