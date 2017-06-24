package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.C0970a;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.C1033g;
import com.google.android.gms.ads.C1036i;
import com.google.android.gms.ads.C1329j;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p034a.C1006a;
import com.google.android.gms.ads.p034a.C1008c;
import com.google.android.gms.ads.purchase.C1350b;
import com.google.android.gms.ads.purchase.C1352d;
import com.google.android.gms.p031b.dd;
import com.google.android.gms.p031b.fw;
import com.google.android.gms.p031b.hi;
import com.google.android.gms.p031b.hm;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.concurrent.atomic.AtomicBoolean;

@id
public class C1090f {
    final aa f3180a;
    private final fw f3181b;
    private final C1108t f3182c;
    private final AtomicBoolean f3183d;
    private final C1036i f3184e;
    private C0971a f3185f;
    private C0970a f3186g;
    private C1029d[] f3187h;
    private C1006a f3188i;
    private C1033g f3189j;
    private ag f3190k;
    private C1350b f3191l;
    private C1008c f3192m;
    private C1352d f3193n;
    private C1329j f3194o;
    private String f3195p;
    private String f3196q;
    private ViewGroup f3197r;
    private boolean f3198s;
    private boolean f3199t;

    class C10891 extends aa {
        final /* synthetic */ C1090f f3179a;

        C10891(C1090f c1090f) {
            this.f3179a = c1090f;
        }

        public void mo910a() {
            this.f3179a.f3184e.m5833a(this.f3179a.m6162m());
            super.mo910a();
        }

        public void mo911a(int i) {
            this.f3179a.f3184e.m5833a(this.f3179a.m6162m());
            super.mo911a(i);
        }
    }

    C1090f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C1108t c1108t, ag agVar, boolean z2) {
        this.f3181b = new fw();
        this.f3184e = new C1036i();
        this.f3180a = new C10891(this);
        this.f3197r = viewGroup;
        this.f3182c = c1108t;
        this.f3190k = agVar;
        this.f3183d = new AtomicBoolean(false);
        this.f3198s = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                C1111w c1111w = new C1111w(context, attributeSet);
                this.f3187h = c1111w.m6248a(z);
                this.f3195p = c1111w.m6247a();
                if (viewGroup.isInEditMode()) {
                    C1120y.m6293a().m7216a(viewGroup, C1090f.m6134a(context, this.f3187h[0], this.f3198s), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                C1120y.m6293a().m7217a(viewGroup, new AdSizeParcel(context, C1029d.f3015a), e.getMessage(), e.getMessage());
            }
        }
    }

    C1090f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C1108t c1108t, boolean z2) {
        this(viewGroup, attributeSet, z, c1108t, null, z2);
    }

    public C1090f(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, C1108t.m6240a(), z2);
    }

    public C1090f(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, C1108t.m6240a(), z);
    }

    private static AdSizeParcel m6134a(Context context, C1029d c1029d, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, c1029d);
        adSizeParcel.m5971a(z);
        return adSizeParcel;
    }

    private static AdSizeParcel m6135a(Context context, C1029d[] c1029dArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, c1029dArr);
        adSizeParcel.m5971a(z);
        return adSizeParcel;
    }

    private void m6136q() {
        try {
            C0998a a = this.f3190k.mo948a();
            if (a != null) {
                this.f3197r.addView((View) C1001b.m5714a(a));
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to get an ad frame.", e);
        }
    }

    public void m6137a() {
        try {
            if (this.f3190k != null) {
                this.f3190k.mo965b();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to destroy AdView.", e);
        }
    }

    public void m6138a(C1006a c1006a) {
        try {
            this.f3188i = c1006a;
            if (this.f3190k != null) {
                this.f3190k.mo953a(c1006a != null ? new C1110v(c1006a) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the AppEventListener.", e);
        }
    }

    public void m6139a(C1008c c1008c) {
        this.f3192m = c1008c;
        try {
            if (this.f3190k != null) {
                this.f3190k.mo956a(c1008c != null ? new dd(c1008c) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void m6140a(C0970a c0970a) {
        this.f3186g = c0970a;
        this.f3180a.m5975a(c0970a);
    }

    public void m6141a(C1033g c1033g) {
        this.f3189j = c1033g;
        try {
            if (this.f3190k != null) {
                this.f3190k.mo954a(this.f3189j == null ? null : this.f3189j.m5824a());
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set correlator.", e);
        }
    }

    public void m6142a(C0971a c0971a) {
        try {
            this.f3185f = c0971a;
            if (this.f3190k != null) {
                this.f3190k.mo951a(c0971a != null ? new C1102n(c0971a) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the AdClickListener.", e);
        }
    }

    public void m6143a(C1088e c1088e) {
        try {
            if (this.f3190k == null) {
                m6164o();
            }
            if (this.f3190k.mo964a(this.f3182c.m6241a(this.f3197r.getContext(), c1088e))) {
                this.f3181b.m8392a(c1088e.m6125j());
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to load ad.", e);
        }
    }

    public void m6144a(C1329j c1329j) {
        this.f3194o = c1329j;
        try {
            if (this.f3190k != null) {
                this.f3190k.mo950a(c1329j == null ? null : new VideoOptionsParcel(c1329j));
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set video options.", e);
        }
    }

    public void m6145a(C1350b c1350b) {
        if (this.f3193n != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f3191l = c1350b;
            if (this.f3190k != null) {
                this.f3190k.mo957a(c1350b != null ? new hi(c1350b) : null);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void m6146a(String str) {
        if (this.f3195p != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f3195p = str;
    }

    public void m6147a(boolean z) {
        this.f3199t = z;
        try {
            if (this.f3190k != null) {
                this.f3190k.mo963a(this.f3199t);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set manual impressions.", e);
        }
    }

    public void m6148a(C1029d... c1029dArr) {
        if (this.f3187h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m6151b(c1029dArr);
    }

    public boolean m6149a(AdSizeParcel adSizeParcel) {
        return "search_v2".equals(adSizeParcel.f3104b);
    }

    public C0970a m6150b() {
        return this.f3186g;
    }

    public void m6151b(C1029d... c1029dArr) {
        this.f3187h = c1029dArr;
        try {
            if (this.f3190k != null) {
                this.f3190k.mo949a(C1090f.m6135a(this.f3197r.getContext(), this.f3187h, this.f3198s));
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to set the ad size.", e);
        }
        this.f3197r.requestLayout();
    }

    public C1029d m6152c() {
        try {
            if (this.f3190k != null) {
                AdSizeParcel i = this.f3190k.mo972i();
                if (i != null) {
                    return i.m5972b();
                }
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to get the current AdSize.", e);
        }
        return this.f3187h != null ? this.f3187h[0] : null;
    }

    public C1029d[] m6153d() {
        return this.f3187h;
    }

    public String m6154e() {
        return this.f3195p;
    }

    public C1006a m6155f() {
        return this.f3188i;
    }

    public C1350b m6156g() {
        return this.f3191l;
    }

    public C1008c m6157h() {
        return this.f3192m;
    }

    public void m6158i() {
        try {
            if (this.f3190k != null) {
                this.f3190k.mo969d();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to call pause.", e);
        }
    }

    public void m6159j() {
        try {
            if (this.f3190k != null) {
                this.f3190k.c_();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to call resume.", e);
        }
    }

    public String m6160k() {
        try {
            if (this.f3190k != null) {
                return this.f3190k.mo989j();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public C1036i m6161l() {
        return this.f3184e;
    }

    public C1081c m6162m() {
        C1081c c1081c = null;
        if (this.f3190k != null) {
            try {
                c1081c = this.f3190k.mo974l();
            } catch (Throwable e) {
                C1324b.m7235d("Failed to retrieve VideoController.", e);
            }
        }
        return c1081c;
    }

    public C1329j m6163n() {
        return this.f3194o;
    }

    void m6164o() {
        if ((this.f3187h == null || this.f3195p == null) && this.f3190k == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f3190k = m6165p();
        this.f3190k.mo952a(new C1103o(this.f3180a));
        if (this.f3185f != null) {
            this.f3190k.mo951a(new C1102n(this.f3185f));
        }
        if (this.f3188i != null) {
            this.f3190k.mo953a(new C1110v(this.f3188i));
        }
        if (this.f3191l != null) {
            this.f3190k.mo957a(new hi(this.f3191l));
        }
        if (this.f3193n != null) {
            this.f3190k.mo958a(new hm(this.f3193n), this.f3196q);
        }
        if (this.f3192m != null) {
            this.f3190k.mo956a(new dd(this.f3192m));
        }
        if (this.f3189j != null) {
            this.f3190k.mo954a(this.f3189j.m5824a());
        }
        if (this.f3194o != null) {
            this.f3190k.mo950a(new VideoOptionsParcel(this.f3194o));
        }
        this.f3190k.mo963a(this.f3199t);
        m6136q();
    }

    protected ag m6165p() {
        Context context = this.f3197r.getContext();
        AdSizeParcel a = C1090f.m6135a(context, this.f3187h, this.f3198s);
        return m6149a(a) ? C1120y.m6295b().m6288a(context, a, this.f3195p) : C1120y.m6295b().m6289a(context, a, this.f3195p, this.f3181b);
    }
}
