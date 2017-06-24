package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.overlay.C1047g;
import com.google.android.gms.ads.internal.purchase.C1048j;
import com.google.android.gms.ads.internal.purchase.C1227c;
import com.google.android.gms.ads.internal.purchase.C1229d;
import com.google.android.gms.ads.internal.purchase.C1232f;
import com.google.android.gms.ads.internal.purchase.C1234g;
import com.google.android.gms.ads.internal.purchase.C1239k;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C1249a;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.ed;
import com.google.android.gms.p031b.fp;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.ha;
import com.google.android.gms.p031b.hc;
import com.google.android.gms.p031b.hd;
import com.google.android.gms.p031b.hh;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jm;
import com.google.android.gms.p031b.jn;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.la;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@id
public abstract class C1050b extends C1043a implements C1047g, C1048j, C1049s, ed, fp {
    protected final fx f3071j;
    protected transient boolean f3072k;
    private final Messenger f3073l;

    class C10452 implements Runnable {
        final /* synthetic */ C1050b f3069a;

        C10452(C1050b c1050b) {
            this.f3069a = c1050b;
        }

        public void run() {
            this.f3069a.e.m6887b();
        }
    }

    class C10463 implements Runnable {
        final /* synthetic */ C1050b f3070a;

        C10463(C1050b c1050b) {
            this.f3070a = c1050b;
        }

        public void run() {
            this.f3070a.e.m6888c();
        }
    }

    public C1050b(Context context, AdSizeParcel adSizeParcel, String str, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        this(new C1328v(context, adSizeParcel, str, versionInfoParcel), fxVar, null, c1122d);
    }

    protected C1050b(C1328v c1328v, fx fxVar, C1248r c1248r, C1122d c1122d) {
        super(c1328v, c1248r, c1122d);
        this.f3071j = fxVar;
        this.f3073l = new Messenger(new ha(this.f.f3990c));
        this.f3072k = false;
    }

    private C1249a m5922a(AdRequestParcel adRequestParcel, Bundle bundle, jn jnVar) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.f.f3990c.getApplicationInfo();
        try {
            packageInfo = this.f.f3990c.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.f.f3990c.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.f.f3993f == null || this.f.f3993f.getParent() == null)) {
            int[] iArr = new int[2];
            this.f.f3993f.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.f.f3993f.getWidth();
            int height = this.f.f3993f.getHeight();
            int i3 = 0;
            if (this.f.f3993f.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String c = C1319u.m7186h().m9123c();
        this.f.f3999l = new jm(c, this.f.f3989b);
        this.f.f3999l.m9090a(adRequestParcel);
        String a = C1319u.m7183e().m9202a(this.f.f3990c, this.f.f3993f, this.f.f3996i);
        long j = 0;
        if (this.f.f4003p != null) {
            try {
                j = this.f.f4003p.mo1025a();
            } catch (RemoteException e2) {
                C1324b.m7234d("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle a2 = C1319u.m7186h().m9105a(this.f.f3990c, this, c);
        List arrayList = new ArrayList();
        for (i = 0; i < this.f.f4009v.size(); i++) {
            arrayList.add((String) this.f.f4009v.m1900b(i));
        }
        boolean z = this.f.f4004q != null;
        boolean z2 = this.f.f4005r != null && C1319u.m7186h().m9137p();
        boolean a3 = this.i.f3284c.mo1160a(this.f.f3990c);
        String str = "";
        if (((Boolean) cq.bQ.m7801c()).booleanValue()) {
            C1324b.m7227a("Getting webview cookie from CookieManager.");
            CookieManager b = C1319u.m7185g().mo1482b(this.f.f3990c);
            if (b != null) {
                str = b.getCookie("googleads.g.doubleclick.net");
            }
        }
        String str2 = null;
        if (jnVar != null) {
            str2 = jnVar.m9102c();
        }
        return new C1249a(bundle2, adRequestParcel, this.f.f3996i, this.f.f3989b, applicationInfo, packageInfo, c, C1319u.m7186h().m9107a(), this.f.f3992e, a2, this.f.f3974A, arrayList, bundle, C1319u.m7186h().m9128g(), this.f3073l, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, a, j, uuid, cq.m7827a(), this.f.f3988a, this.f.f4010w, new CapabilityParcel(z, z2, a3), this.f.m7253h(), C1319u.m7183e().m9249g(), C1319u.m7183e().m9252h(), C1319u.m7183e().m9256k(this.f.f3990c), C1319u.m7183e().m9231b(this.f.f3993f), this.f.f3990c instanceof Activity, C1319u.m7186h().m9132k(), str, str2, C1319u.m7186h().m9133l(), C1319u.m7202x().m8056a(), C1319u.m7183e().m9254i());
    }

    public void m5923A() {
        mo1049a(this.f.f3997j, false);
    }

    public void mo976B() {
        C1319u.m7183e().m9222a(new C10452(this));
    }

    public void mo977C() {
        C1319u.m7183e().m9222a(new C10463(this));
    }

    public void mo957a(hd hdVar) {
        C1896c.m10797b("setInAppPurchaseListener must be called on the main UI thread.");
        this.f.f4004q = hdVar;
    }

    public void mo958a(hh hhVar, String str) {
        C1896c.m10797b("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f.f3975B = new C1239k(str);
        this.f.f4005r = hhVar;
        if (!C1319u.m7186h().m9127f() && hhVar != null) {
            Future future = (Future) new C1227c(this.f.f3990c, this.f.f4005r, this.f.f3975B).mo1107e();
        }
    }

    protected void mo1049a(jl jlVar, boolean z) {
        if (jlVar == null) {
            C1324b.m7234d("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.m5896c(jlVar);
        if (!(jlVar.f5440r == null || jlVar.f5440r.f4814d == null)) {
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, jlVar, this.f.f3989b, z, jlVar.f5440r.f4814d);
        }
        if (jlVar.f5437o != null && jlVar.f5437o.f4796g != null) {
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, jlVar, this.f.f3989b, z, jlVar.f5437o.f4796g);
        }
    }

    public void mo978a(String str, ArrayList<String> arrayList) {
        hc c1229d = new C1229d(str, arrayList, this.f.f3990c, this.f.f3992e.f3957b);
        if (this.f.f4004q == null) {
            C1324b.m7234d("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!C1120y.m6293a().m7223b(this.f.f3990c)) {
                C1324b.m7234d("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.f.f4005r == null) {
                C1324b.m7234d("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.f.f3975B == null) {
                C1324b.m7234d("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.f.f3979F) {
                C1324b.m7234d("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.f.f3979F = true;
                try {
                    if (this.f.f4005r.mo1432a(str)) {
                        C1319u.m7193o().m6850a(this.f.f3990c, this.f.f3992e.f3960e, new GInAppPurchaseManagerInfoParcel(this.f.f3990c, this.f.f3975B, c1229d, this));
                        return;
                    } else {
                        this.f.f3979F = false;
                        return;
                    }
                } catch (RemoteException e) {
                    C1324b.m7234d("Could not start In-App purchase.");
                    this.f.f3979F = false;
                    return;
                }
            }
        }
        try {
            this.f.f4004q.mo1312a(c1229d);
        } catch (RemoteException e2) {
            C1324b.m7234d("Could not start In-App purchase.");
        }
    }

    public void mo979a(String str, boolean z, int i, final Intent intent, C1232f c1232f) {
        try {
            if (this.f.f4005r != null) {
                this.f.f4005r.mo1431a(new C1234g(this.f.f3990c, str, z, i, intent, c1232f));
            }
        } catch (RemoteException e) {
            C1324b.m7234d("Fail to invoke PlayStorePurchaseListener.");
        }
        jz.f5567a.postDelayed(new Runnable(this) {
            final /* synthetic */ C1050b f3068b;

            public void run() {
                int a = C1319u.m7193o().m6846a(intent);
                C1319u.m7193o();
                if (!(a != 0 || this.f3068b.f.f3997j == null || this.f3068b.f.f3997j.f5424b == null || this.f3068b.f.f3997j.f5424b.mo1516i() == null)) {
                    this.f3068b.f.f3997j.f5424b.mo1516i().m6653a();
                }
                this.f3068b.f.f3979F = false;
            }
        }, 500);
    }

    public boolean mo980a(AdRequestParcel adRequestParcel, cy cyVar) {
        String str = null;
        if (!mo990t()) {
            return false;
        }
        jn m;
        Bundle a = m5866a(C1319u.m7186h().m9106a(this.f.f3990c));
        this.e.m6884a();
        this.f.f3978E = 0;
        if (((Boolean) cq.bw.m7801c()).booleanValue()) {
            m = C1319u.m7186h().m9134m();
            C1164g w = C1319u.m7201w();
            Context context = this.f.f3990c;
            VersionInfoParcel versionInfoParcel = this.f.f3992e;
            if (m != null) {
                str = m.m9103d();
            }
            w.m6479a(context, versionInfoParcel, false, m, str, this.f.f3989b);
        } else {
            m = null;
        }
        C1249a a2 = m5922a(adRequestParcel, a, m);
        cyVar.m7865a("seq_num", a2.f3704g);
        cyVar.m7865a("request_id", a2.f3719v);
        cyVar.m7865a("session_id", a2.f3705h);
        if (a2.f3703f != null) {
            cyVar.m7865a("app_version", String.valueOf(a2.f3703f.versionCode));
        }
        this.f.f3994g = C1319u.m7178a().m6895a(this.f.f3990c, a2, this.f.f3991d, this);
        return true;
    }

    protected boolean mo1112a(AdRequestParcel adRequestParcel, jl jlVar, boolean z) {
        if (!z && this.f.m7250e()) {
            if (jlVar.f5430h > 0) {
                this.e.m6886a(adRequestParcel, jlVar.f5430h);
            } else if (jlVar.f5440r != null && jlVar.f5440r.f4819i > 0) {
                this.e.m6886a(adRequestParcel, jlVar.f5440r.f4819i);
            } else if (!jlVar.f5436n && jlVar.f5426d == 2) {
                this.e.m6885a(adRequestParcel);
            }
        }
        return this.e.m6889d();
    }

    boolean mo981a(jl jlVar) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.g != null) {
            adRequestParcel = this.g;
            this.g = null;
        } else {
            adRequestParcel = jlVar.f5423a;
            if (adRequestParcel.f3087c != null) {
                z = adRequestParcel.f3087c.getBoolean("_noRefresh", false);
            }
        }
        return mo1112a(adRequestParcel, jlVar, z);
    }

    protected boolean mo982a(jl jlVar, jl jlVar2) {
        int i;
        int i2 = 0;
        if (!(jlVar == null || jlVar.f5441s == null)) {
            jlVar.f5441s.m8329a(null);
        }
        if (jlVar2.f5441s != null) {
            jlVar2.f5441s.m8329a((fp) this);
        }
        if (jlVar2.f5440r != null) {
            i = jlVar2.f5440r.f4825o;
            i2 = jlVar2.f5440r.f4826p;
        } else {
            i = 0;
        }
        this.f.f3976C.m9146a(i, i2);
        return true;
    }

    public void mo966b(jl jlVar) {
        super.mo966b(jlVar);
        if (jlVar.f5437o != null) {
            C1324b.m7227a("Pinging network fill URLs.");
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, jlVar, this.f.f3989b, false, jlVar.f5437o.f4797h);
            if (jlVar.f5440r.f4816f != null && jlVar.f5440r.f4816f.size() > 0) {
                C1324b.m7227a("Pinging urls remotely");
                C1319u.m7183e().m9221a(this.f.f3990c, jlVar.f5440r.f4816f);
            }
        }
        if (jlVar.f5426d == 3 && jlVar.f5440r != null && jlVar.f5440r.f4815e != null) {
            C1324b.m7227a("Pinging no fill URLs.");
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, jlVar, this.f.f3989b, false, jlVar.f5440r.f4815e);
        }
    }

    protected boolean mo983b(AdRequestParcel adRequestParcel) {
        return super.mo983b(adRequestParcel) && !this.f3072k;
    }

    public void c_() {
        C1896c.m10797b("resume must be called on the main UI thread.");
        la laVar = null;
        if (!(this.f.f3997j == null || this.f.f3997j.f5424b == null)) {
            laVar = this.f.f3997j.f5424b;
        }
        if (laVar != null && this.f.m7250e()) {
            C1319u.m7185g().m9277b(this.f.f3997j.f5424b);
        }
        if (!(this.f.f3997j == null || this.f.f3997j.f5438p == null)) {
            try {
                this.f.f3997j.f5438p.mo1362e();
            } catch (RemoteException e) {
                C1324b.m7234d("Could not resume mediation adapter.");
            }
        }
        if (laVar == null || !laVar.mo1539u()) {
            this.e.m6888c();
        }
        this.h.m7665e(this.f.f3997j);
    }

    public void mo969d() {
        C1896c.m10797b("pause must be called on the main UI thread.");
        if (!(this.f.f3997j == null || this.f.f3997j.f5424b == null || !this.f.m7250e())) {
            C1319u.m7185g().m9273a(this.f.f3997j.f5424b);
        }
        if (!(this.f.f3997j == null || this.f.f3997j.f5438p == null)) {
            try {
                this.f.f3997j.f5438p.mo1361d();
            } catch (RemoteException e) {
                C1324b.m7234d("Could not pause mediation adapter.");
            }
        }
        this.h.m7664d(this.f.f3997j);
        this.e.m6887b();
    }

    public void d_() {
        this.h.m7662b(this.f.f3997j);
        this.f3072k = false;
        mo1115o();
        this.f.f3999l.m9095c();
    }

    public void mo915e() {
        if (this.f.f3997j == null) {
            C1324b.m7234d("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.f.f3997j.f5440r == null || this.f.f3997j.f5440r.f4813c == null)) {
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, this.f.f3997j, this.f.f3989b, false, this.f.f3997j.f5440r.f4813c);
        }
        if (!(this.f.f3997j.f5437o == null || this.f.f3997j.f5437o.f4795f == null)) {
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, this.f.f3997j, this.f.f3989b, false, this.f.f3997j.f5437o.f4795f);
        }
        super.mo915e();
    }

    public void e_() {
        this.f3072k = true;
        m5908q();
    }

    public void mo986f() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void f_() {
        this.h.m7664d(this.f.f3997j);
    }

    public void mo988g() {
        this.h.m7665e(this.f.f3997j);
    }

    public String mo989j() {
        return this.f.f3997j == null ? null : this.f.f3997j.f5439q;
    }

    protected boolean mo990t() {
        return C1319u.m7183e().m9226a(this.f.f3990c.getPackageManager(), this.f.f3990c.getPackageName(), "android.permission.INTERNET") && C1319u.m7183e().m9225a(this.f.f3990c);
    }

    public void mo991u() {
        mo915e();
    }

    public void mo992v() {
        d_();
    }

    public void mo993w() {
        mo975m();
    }

    public void mo994x() {
        e_();
    }

    public void mo995y() {
        if (this.f.f3997j != null) {
            String str = this.f.f3997j.f5439q;
            C1324b.m7234d(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        mo1049a(this.f.f3997j, true);
        mo1116r();
    }

    public void mo996z() {
        m5923A();
    }
}
