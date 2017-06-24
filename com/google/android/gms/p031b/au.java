package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class au extends bh {
    private static volatile Long f4174i = null;
    private static final Object f4175j = new Object();

    public au(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4638C = Long.valueOf(-1);
        if (f4174i == null) {
            synchronized (f4175j) {
                if (f4174i == null) {
                    f4174i = (Long) this.f.invoke(null, new Object[]{this.b.m7493a()});
                }
            }
        }
        synchronized (this.e) {
            this.e.f4638C = f4174i;
        }
    }
}
