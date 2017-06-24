package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class aw extends bh {
    public aw(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4660e = Long.valueOf(-1);
        this.e.f4661f = Long.valueOf(-1);
        int[] iArr = (int[]) this.f.invoke(null, new Object[]{this.b.m7493a()});
        synchronized (this.e) {
            this.e.f4660e = Long.valueOf((long) iArr[0]);
            this.e.f4661f = Long.valueOf((long) iArr[1]);
        }
    }
}
