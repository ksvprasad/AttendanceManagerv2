package com.google.android.gms.p031b;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.C1208k;
import com.google.android.gms.common.internal.C1896c;

@id
public class kz {
    private final la f5666a;
    private final Context f5667b;
    private final ViewGroup f5668c;
    private C1208k f5669d;

    public kz(Context context, ViewGroup viewGroup, la laVar) {
        this(context, viewGroup, laVar, null);
    }

    kz(Context context, ViewGroup viewGroup, la laVar, C1208k c1208k) {
        this.f5667b = context;
        this.f5668c = viewGroup;
        this.f5666a = laVar;
        this.f5669d = c1208k;
    }

    public C1208k m9388a() {
        C1896c.m10797b("getAdVideoUnderlay must be called from the UI thread.");
        return this.f5669d;
    }

    public void m9389a(int i, int i2, int i3, int i4) {
        C1896c.m10797b("The underlay may only be modified from the UI thread.");
        if (this.f5669d != null) {
            this.f5669d.m6707a(i, i2, i3, i4);
        }
    }

    public void m9390a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (this.f5669d == null) {
            cu.m7848a(this.f5666a.mo1543y().m7858a(), this.f5666a.mo1542x(), "vpr");
            cw a = cu.m7845a(this.f5666a.mo1543y().m7858a());
            this.f5669d = new C1208k(this.f5667b, this.f5666a, i5, z, this.f5666a.mo1543y().m7858a(), a);
            this.f5668c.addView(this.f5669d, 0, new LayoutParams(-1, -1));
            this.f5669d.m6707a(i, i2, i3, i4);
            this.f5666a.mo1519l().m9467a(false);
        }
    }

    public void m9391b() {
        C1896c.m10797b("onPause must be called from the UI thread.");
        if (this.f5669d != null) {
            this.f5669d.m6717h();
        }
    }

    public void m9392c() {
        C1896c.m10797b("onDestroy must be called from the UI thread.");
        if (this.f5669d != null) {
            this.f5669d.m6722m();
            this.f5668c.removeView(this.f5669d);
            this.f5669d = null;
        }
    }
}
