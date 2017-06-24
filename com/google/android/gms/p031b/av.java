package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class av extends bh {
    private static volatile String f4176i = null;
    private static final Object f4177j = new Object();

    public av(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4637B = "E";
        if (f4176i == null) {
            synchronized (f4177j) {
                if (f4176i == null) {
                    f4176i = (String) this.f.invoke(null, new Object[]{this.b.m7493a()});
                }
            }
        }
        synchronized (this.e) {
            this.e.f4637B = f4176i;
        }
    }
}
