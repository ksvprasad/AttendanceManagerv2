package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class ax extends bh {
    private static volatile Long f4178i = null;
    private static final Object f4179j = new Object();

    public ax(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        if (f4178i == null) {
            synchronized (f4179j) {
                if (f4178i == null) {
                    f4178i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f4646K = f4178i;
        }
    }
}
