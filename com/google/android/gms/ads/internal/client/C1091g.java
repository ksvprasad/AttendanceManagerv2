package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.ads.C0970a;
import com.google.android.gms.ads.C1033g;
import com.google.android.gms.ads.internal.reward.client.C1306g;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p029d.C0963b;
import com.google.android.gms.ads.p034a.C1006a;
import com.google.android.gms.ads.p034a.C1008c;
import com.google.android.gms.ads.p034a.C1010e;
import com.google.android.gms.ads.purchase.C1350b;
import com.google.android.gms.ads.purchase.C1352d;
import com.google.android.gms.p031b.dd;
import com.google.android.gms.p031b.fw;
import com.google.android.gms.p031b.hi;
import com.google.android.gms.p031b.hm;
import com.google.android.gms.p031b.id;

@id
public class C1091g {
    private final fw f3200a;
    private final Context f3201b;
    private final C1108t f3202c;
    private C0970a f3203d;
    private C0971a f3204e;
    private ag f3205f;
    private String f3206g;
    private String f3207h;
    private C1006a f3208i;
    private C1352d f3209j;
    private C1350b f3210k;
    private C1010e f3211l;
    private C1008c f3212m;
    private C1033g f3213n;
    private C0963b f3214o;
    private boolean f3215p;

    public C1091g(Context context) {
        this(context, C1108t.m6240a(), null);
    }

    public C1091g(Context context, C1108t c1108t, C1010e c1010e) {
        this.f3200a = new fw();
        this.f3201b = context;
        this.f3202c = c1108t;
        this.f3211l = c1010e;
    }

    private void m6166b(String str) {
        if (this.f3206g == null) {
            m6167c(str);
        }
        this.f3205f = C1120y.m6295b().m6291b(this.f3201b, this.f3215p ? AdSizeParcel.m5967a() : new AdSizeParcel(), this.f3206g, this.f3200a);
        if (this.f3203d != null) {
            this.f3205f.mo952a(new C1103o(this.f3203d));
        }
        if (this.f3204e != null) {
            this.f3205f.mo951a(new C1102n(this.f3204e));
        }
        if (this.f3208i != null) {
            this.f3205f.mo953a(new C1110v(this.f3208i));
        }
        if (this.f3210k != null) {
            this.f3205f.mo957a(new hi(this.f3210k));
        }
        if (this.f3209j != null) {
            this.f3205f.mo958a(new hm(this.f3209j), this.f3207h);
        }
        if (this.f3212m != null) {
            this.f3205f.mo956a(new dd(this.f3212m));
        }
        if (this.f3213n != null) {
            this.f3205f.mo954a(this.f3213n.m5824a());
        }
        if (this.f3214o != null) {
            this.f3205f.mo955a(new C1306g(this.f3214o));
        }
    }

    private void m6167c(String str) {
        if (this.f3205f == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public void m6168a() {
        try {
            m6167c("show");
            this.f3205f.mo986f();
        } catch (Throwable e) {
            C1324b.m7235d("Failed to show interstitial.", e);
        }
    }

    public void m6169a(C0970a c0970a) {
        try {
            this.f3203d = c0970a;
            if (this.f3205f != null) {
                this.f3205f.mo952a(c0970a != null ? new C1103o(c0970a) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the AdListener.", e);
        }
    }

    public void m6170a(C0963b c0963b) {
        try {
            this.f3214o = c0963b;
            if (this.f3205f != null) {
                this.f3205f.mo955a(c0963b != null ? new C1306g(c0963b) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the AdListener.", e);
        }
    }

    public void m6171a(C0971a c0971a) {
        try {
            this.f3204e = c0971a;
            if (this.f3205f != null) {
                this.f3205f.mo951a(c0971a != null ? new C1102n(c0971a) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the AdClickListener.", e);
        }
    }

    public void m6172a(C1088e c1088e) {
        try {
            if (this.f3205f == null) {
                m6166b("loadAd");
            }
            if (this.f3205f.mo964a(this.f3202c.m6241a(this.f3201b, c1088e))) {
                this.f3200a.m8392a(c1088e.m6125j());
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to load ad.", e);
        }
    }

    public void m6173a(String str) {
        if (this.f3206g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f3206g = str;
    }

    public void m6174a(boolean z) {
        this.f3215p = z;
    }
}
