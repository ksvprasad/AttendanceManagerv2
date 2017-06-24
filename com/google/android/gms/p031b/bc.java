package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class bc extends bh {
    private long f4186i = -1;

    public bc(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4667l = Long.valueOf(-1);
        if (this.f4186i == -1) {
            this.f4186i = (long) ((Integer) this.f.invoke(null, new Object[]{this.b.m7493a()})).intValue();
        }
        synchronized (this.e) {
            this.e.f4667l = Long.valueOf(this.f4186i);
        }
    }
}
