package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class bf extends bh {
    private static volatile Long f4190i = null;
    private static final Object f4191j = new Object();

    public bf(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        if (f4190i == null) {
            synchronized (f4191j) {
                if (f4190i == null) {
                    f4190i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f4636A = f4190i;
        }
    }
}
