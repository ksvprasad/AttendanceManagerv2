package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.lb.C1148a;

@id
public class ht extends hn implements C1148a {
    ht(Context context, C1632a c1632a, la laVar, C1042a c1042a) {
        super(context, c1632a, laVar, c1042a);
    }

    protected void mo1433b() {
        if (this.e.f3783e == -2) {
            this.c.mo1519l().m9463a((C1148a) this);
            mo1436f();
            C1324b.m7227a("Loading HTML in WebView.");
            this.c.loadDataWithBaseURL(C1319u.m7183e().m9207a(this.e.f3780b), this.e.f3781c, "text/html", "UTF-8", null);
        }
    }

    protected void mo1436f() {
    }
}
