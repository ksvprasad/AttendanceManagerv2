package com.google.android.gms.p031b;

import com.google.android.gms.ads.p035c.C1025a;
import com.google.android.gms.ads.p035c.C1025a.C1023a;
import com.google.android.gms.p031b.C1493f.C1487a;
import java.io.IOException;

public class az extends bh {
    public az(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    private void m7528a(String str) {
    }

    private void m7529c() {
        synchronized (this.e) {
            this.e.f4650O = (String) this.f.invoke(null, new Object[]{this.b.m7493a()});
        }
    }

    private void m7530d() {
        C1025a m = this.b.m7507m();
        if (m == null) {
            m7528a("E1");
            return;
        }
        try {
            C1023a b = m.m5788b();
            String a = ap.m7511a(b.m5776a());
            if (a != null) {
                synchronized (this.e) {
                    this.e.f4650O = a;
                    this.e.f4652Q = Boolean.valueOf(b.m5777b());
                    this.e.f4651P = Integer.valueOf(5);
                }
                return;
            }
            m7528a("E");
        } catch (IOException e) {
            m7528a("E");
        }
    }

    protected void mo1239a() {
        if (this.b.m7501g()) {
            m7530d();
        } else {
            m7529c();
        }
    }
}
