package com.google.android.gms.p031b;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.lb.C1148a;

@id
public class hq extends hn {
    private ho f5053g;

    hq(Context context, C1632a c1632a, la laVar, C1042a c1042a) {
        super(context, c1632a, laVar, c1042a);
    }

    protected void mo1433b() {
        int i;
        int i2;
        AdSizeParcel k = this.c.mo1518k();
        if (k.f3107e) {
            DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = k.f3109g;
            i2 = k.f3106d;
        }
        this.f5053g = new ho(this, this.c, i, i2);
        this.c.mo1519l().m9463a((C1148a) this);
        this.f5053g.m8753a(this.e);
    }

    protected int mo1434c() {
        if (!this.f5053g.m8756c()) {
            return !this.f5053g.m8757d() ? 2 : -2;
        } else {
            C1324b.m7227a("Ad-Network indicated no fill with passback URL.");
            return 3;
        }
    }
}
