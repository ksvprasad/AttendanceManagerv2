package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class bd extends bh {
    private static volatile String f4187i = null;
    private static final Object f4188j = new Object();

    public bd(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4656a = "E";
        if (f4187i == null) {
            synchronized (f4188j) {
                if (f4187i == null) {
                    f4187i = (String) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f4656a = f4187i;
        }
    }
}
