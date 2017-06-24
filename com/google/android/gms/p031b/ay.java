package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class ay extends bh {
    private long f4180i;

    public ay(ao aoVar, String str, String str2, C1487a c1487a, long j, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
        this.f4180i = j;
    }

    protected void mo1239a() {
        long longValue = ((Long) this.f.invoke(null, new Object[0])).longValue();
        synchronized (this.e) {
            this.e.f4654S = Long.valueOf(longValue);
            if (this.f4180i != 0) {
                this.e.f4672q = Long.valueOf(longValue - this.f4180i);
                this.e.f4677v = Long.valueOf(this.f4180i);
            }
        }
    }
}
