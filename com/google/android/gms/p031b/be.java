package com.google.android.gms.p031b;

import com.google.android.gms.p031b.C1493f.C1487a;
import java.util.List;

public class be extends bh {
    private List<Long> f4189i = null;

    public be(ao aoVar, String str, String str2, C1487a c1487a, int i, int i2) {
        super(aoVar, str, str2, c1487a, i, i2);
    }

    protected void mo1239a() {
        this.e.f4680y = Long.valueOf(-1);
        this.e.f4681z = Long.valueOf(-1);
        if (this.f4189i == null) {
            this.f4189i = (List) this.f.invoke(null, new Object[]{this.b.m7493a()});
        }
        if (this.f4189i != null && this.f4189i.size() == 2) {
            synchronized (this.e) {
                this.e.f4680y = Long.valueOf(((Long) this.f4189i.get(0)).longValue());
                this.e.f4681z = Long.valueOf(((Long) this.f4189i.get(1)).longValue());
            }
        }
    }
}
