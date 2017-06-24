package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;

public class bb extends bh {
    private static volatile Long f4184i = null;
    private static final Object f4185j = new Object();

    public bb(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        if (f4184i == null) {
            synchronized (f4185j) {
                if (f4184i == null) {
                    f4184i = (Long) this.f.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.e) {
            this.e.f4676u = f4184i;
        }
    }
}
