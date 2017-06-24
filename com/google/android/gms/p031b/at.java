package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;
import java.nio.ByteBuffer;

public class at extends bh {
    private static volatile String f4172i = null;
    private static final Object f4173j = new Object();

    public at(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4678w = "E";
        if (f4172i == null) {
            synchronized (f4173j) {
                if (f4172i == null) {
                    f4172i = C1563h.m8703a(((ByteBuffer) this.f.invoke(null, new Object[]{this.b.m7493a()})).array(), true);
                }
            }
        }
        synchronized (this.e) {
            this.e.f4678w = f4172i;
        }
    }
}
