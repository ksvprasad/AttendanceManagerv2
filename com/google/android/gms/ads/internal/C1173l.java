package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Window;
import com.google.ads.mediation.C0962a;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.ef;
import com.google.android.gms.p031b.ek;
import com.google.android.gms.p031b.ek.C1172a;
import com.google.android.gms.p031b.fg;
import com.google.android.gms.p031b.fm;
import com.google.android.gms.p031b.fo;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.ig;
import com.google.android.gms.p031b.jf;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.ju;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.la;
import com.google.android.gms.p031b.lb;
import java.util.Collections;
import java.util.concurrent.Future;
import org.json.JSONObject;

@id
public class C1173l extends C1057c implements ef, C1172a {
    protected transient boolean f3442l = false;
    private int f3443m = -1;
    private boolean f3444n;
    private float f3445o;

    @id
    private class C1171a extends ju {
        final /* synthetic */ C1173l f3440a;
        private final int f3441b;

        public C1171a(C1173l c1173l, int i) {
            this.f3440a = c1173l;
            this.f3441b = i;
        }

        public void mo1108a() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.f3440a.f.f3980G, this.f3440a.m6534G(), this.f3440a.f3444n, this.f3440a.f3445o, this.f3440a.f.f3980G ? this.f3441b : -1);
            int q = this.f3440a.f.f3997j.f5424b.mo1529q();
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(this.f3440a, this.f3440a, this.f3440a, this.f3440a.f.f3997j.f5424b, q == -1 ? this.f3440a.f.f3997j.f5429g : q, this.f3440a.f.f3992e, this.f3440a.f.f3997j.f5418C, interstitialAdParameterParcel);
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ C1171a f3436b;

                public void run() {
                    C1319u.m7181c().m6680a(this.f3436b.f3440a.f.f3990c, adOverlayInfoParcel);
                }
            });
        }

        public void mo1109b() {
        }
    }

    public C1173l(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        super(context, adSizeParcel, str, fxVar, versionInfoParcel, c1122d);
    }

    private void m6530a(Bundle bundle) {
        C1319u.m7183e().m9235b(this.f.f3990c, this.f.f3992e.f3957b, "gmob-apps", bundle, false);
    }

    private C1632a m6533b(C1632a c1632a) {
        try {
            String jSONObject = ig.m8898a(c1632a.f5409b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C0962a.AD_UNIT_ID_PARAMETER, c1632a.f5408a.f3743e);
            fo foVar = new fo(Collections.singletonList(new fm(jSONObject, null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList())), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, null, 0, -1, -1, false);
            AdResponseParcel adResponseParcel = c1632a.f5409b;
            return new C1632a(c1632a.f5408a, new AdResponseParcel(c1632a.f5408a, adResponseParcel.f3780b, adResponseParcel.f3781c, adResponseParcel.f3782d, adResponseParcel.f3784f, adResponseParcel.f3785g, true, adResponseParcel.f3787i, adResponseParcel.f3788j, adResponseParcel.f3789k, adResponseParcel.f3790l, adResponseParcel.f3791m, adResponseParcel.f3792n, adResponseParcel.f3793o, adResponseParcel.f3794p, adResponseParcel.f3795q, adResponseParcel.f3796r, adResponseParcel.f3797s, adResponseParcel.f3798t, adResponseParcel.f3799u, adResponseParcel.f3800v, adResponseParcel.f3801w, adResponseParcel.f3804z, adResponseParcel.f3765A, adResponseParcel.f3766B, adResponseParcel.f3767C, adResponseParcel.f3768D, adResponseParcel.f3769E, adResponseParcel.f3770F, adResponseParcel.f3771G, adResponseParcel.f3772H, adResponseParcel.f3773I, adResponseParcel.f3774J, adResponseParcel.f3775K, adResponseParcel.f3776L, adResponseParcel.f3777M), foVar, c1632a.f5411d, c1632a.f5412e, c1632a.f5413f, c1632a.f5414g, c1632a.f5415h);
        } catch (Throwable e) {
            C1324b.m7231b("Unable to generate ad state for an interstitial ad with pooling.", e);
            return c1632a;
        }
    }

    protected boolean m6534G() {
        if (!(this.f.f3990c instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.f.f3990c).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void m6535H() {
        C1319u.m7200v().m9346b(Integer.valueOf(this.f3443m));
        if (this.f.m7250e()) {
            this.f.m7247b();
            this.f.f3997j = null;
            this.f.f3980G = false;
            this.f3442l = false;
        }
    }

    public void mo1110I() {
        if (!(this.f.f3997j == null || this.f.f3997j.f5447y == null)) {
            C1319u.m7183e().m9218a(this.f.f3990c, this.f.f3992e.f3957b, this.f.f3997j.f5447y);
        }
        m5910s();
    }

    protected la mo1048a(C1632a c1632a, C1123e c1123e, jf jfVar) {
        la a = C1319u.m7184f().m9481a(this.f.f3990c, this.f.f3996i, false, false, this.f.f3991d, this.f.f3992e, this.a, this, this.i);
        a.mo1519l().m9459a(this, null, this, this, ((Boolean) cq.f4382W.m7801c()).booleanValue(), this, this, c1123e, null, jfVar);
        m5962a((fg) a);
        a.mo1506b(c1632a.f5408a.f3761w);
        ek.m8044a(a, (C1172a) this);
        return a;
    }

    public void mo1002a(C1632a c1632a, cy cyVar) {
        Object obj = 1;
        if (!((Boolean) cq.ah.m7801c()).booleanValue()) {
            super.mo1002a(c1632a, cyVar);
        } else if (c1632a.f5412e != -2) {
            super.mo1002a(c1632a, cyVar);
        } else {
            Bundle bundle = c1632a.f5408a.f3741c.f3097m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            Object obj2 = (bundle == null || !bundle.containsKey("gw")) ? 1 : null;
            if (c1632a.f5409b.f3786h) {
                obj = null;
            }
            if (!(obj2 == null || r2 == null)) {
                this.f.f3998k = m6533b(c1632a);
            }
            super.mo1002a(this.f.f3998k, cyVar);
        }
    }

    public void mo1111a(boolean z, float f) {
        this.f3444n = z;
        this.f3445o = f;
    }

    public boolean mo980a(AdRequestParcel adRequestParcel, cy cyVar) {
        if (this.f.f3997j == null) {
            return super.mo980a(adRequestParcel, cyVar);
        }
        C1324b.m7234d("An interstitial is already loading. Aborting.");
        return false;
    }

    protected boolean mo1112a(AdRequestParcel adRequestParcel, jl jlVar, boolean z) {
        if (this.f.m7250e() && jlVar.f5424b != null) {
            C1319u.m7185g().m9273a(jlVar.f5424b);
        }
        return this.e.m6889d();
    }

    public boolean mo982a(jl jlVar, jl jlVar2) {
        if (!super.mo982a(jlVar, jlVar2)) {
            return false;
        }
        if (!(this.f.m7250e() || this.f.f3977D == null || jlVar2.f5432j == null)) {
            this.h.m7656a(this.f.f3996i, jlVar2, this.f.f3977D);
        }
        return true;
    }

    public void mo1113b(RewardItemParcel rewardItemParcel) {
        if (this.f.f3997j != null) {
            if (this.f.f3997j.f5448z != null) {
                C1319u.m7183e().m9218a(this.f.f3990c, this.f.f3992e.f3957b, this.f.f3997j.f5448z);
            }
            if (this.f.f3997j.f5446x != null) {
                rewardItemParcel = this.f.f3997j.f5446x;
            }
        }
        m5877a(rewardItemParcel);
    }

    public void mo1114b(boolean z) {
        this.f.f3980G = z;
    }

    public void e_() {
        m5923A();
        super.e_();
        if (this.f.f3997j != null && this.f.f3997j.f5424b != null) {
            lb l = this.f.f3997j.f5424b.mo1519l();
            if (l != null) {
                l.m9475e();
            }
        }
    }

    public void mo986f() {
        C1896c.m10797b("showInterstitial must be called on the main UI thread.");
        if (this.f.f3997j == null) {
            C1324b.m7234d("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) cq.ax.m7801c()).booleanValue()) {
            Bundle bundle;
            String packageName = this.f.f3990c.getApplicationContext() != null ? this.f.f3990c.getApplicationContext().getPackageName() : this.f.f3990c.getPackageName();
            if (!this.f3442l) {
                C1324b.m7234d("It is not recommended to show an interstitial before onAdLoaded completes.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                m6530a(bundle);
            }
            if (!C1319u.m7183e().m9250g(this.f.f3990c)) {
                C1324b.m7234d("It is not recommended to show an interstitial when app is not in foreground.");
                bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_app_not_in_foreground");
                m6530a(bundle);
            }
        }
        if (!this.f.m7251f()) {
            if (this.f.f3997j.f5436n && this.f.f3997j.f5438p != null) {
                try {
                    this.f.f3997j.f5438p.mo1359b();
                } catch (Throwable e) {
                    C1324b.m7235d("Could not show interstitial.", e);
                    m6535H();
                }
            } else if (this.f.f3997j.f5424b == null) {
                C1324b.m7234d("The interstitial failed to load.");
            } else if (this.f.f3997j.f5424b.mo1528p()) {
                C1324b.m7234d("The interstitial is already showing.");
            } else {
                this.f.f3997j.f5424b.mo1502a(true);
                if (this.f.f3997j.f5432j != null) {
                    this.h.m7655a(this.f.f3996i, this.f.f3997j);
                }
                Bitmap h = this.f.f3980G ? C1319u.m7183e().m9251h(this.f.f3990c) : null;
                this.f3443m = C1319u.m7200v().m9344a(h);
                if (!((Boolean) cq.bd.m7801c()).booleanValue() || h == null) {
                    InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.f.f3980G, m6534G(), false, 0.0f, -1);
                    int q = this.f.f3997j.f5424b.mo1529q();
                    if (q == -1) {
                        q = this.f.f3997j.f5429g;
                    }
                    C1319u.m7181c().m6680a(this.f.f3990c, new AdOverlayInfoParcel(this, this, this, this.f.f3997j.f5424b, q, this.f.f3992e, this.f.f3997j.f5418C, interstitialAdParameterParcel));
                    return;
                }
                Future future = (Future) new C1171a(this, this.f3443m).mo1107e();
            }
        }
    }

    protected void mo1115o() {
        m6535H();
        super.mo1115o();
    }

    protected void mo1116r() {
        super.mo1116r();
        this.f3442l = true;
    }
}
