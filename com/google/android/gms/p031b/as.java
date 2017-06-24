package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class as extends bh {
    private static volatile String f4170i = null;
    private static final Object f4171j = new Object();

    public as(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4679x = "E";
        if (f4170i == null) {
            synchronized (f4171j) {
                if (f4170i == null) {
                    f4170i = (String) this.f.invoke(null, new Object[]{this.b.m7493a()});
                }
            }
        }
        synchronized (this.e) {
            this.e.f4679x = C1563h.m8703a(f4170i.getBytes(), true);
        }
    }
}
