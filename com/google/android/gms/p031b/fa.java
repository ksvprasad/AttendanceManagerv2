package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.C1173l;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1081c;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ag.C1039a;
import com.google.android.gms.ads.internal.client.ai;
import com.google.android.gms.ads.internal.client.ak;
import com.google.android.gms.ads.internal.reward.client.C1301d;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.ez.C1485a;
import com.google.android.gms.p033a.C0998a;

@id
public class fa extends C1039a {
    private String f4699a;
    private eu f4700b;
    private C1173l f4701c;
    private ew f4702d;
    private hh f4703e;
    private String f4704f;

    public fa(Context context, String str, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        this(str, new eu(context, fxVar, versionInfoParcel, c1122d));
    }

    fa(String str, eu euVar) {
        this.f4699a = str;
        this.f4700b = euVar;
        this.f4702d = new ew();
        C1319u.m7194p().m8139a(euVar);
    }

    static boolean m8191b(AdRequestParcel adRequestParcel) {
        Bundle a = ex.m8128a(adRequestParcel);
        return a != null && a.containsKey("gw");
    }

    static boolean m8192c(AdRequestParcel adRequestParcel) {
        Bundle a = ex.m8128a(adRequestParcel);
        return a != null && a.containsKey("_ad");
    }

    private void m8193n() {
        if (this.f4701c != null && this.f4703e != null) {
            this.f4701c.mo958a(this.f4703e, this.f4704f);
        }
    }

    public C0998a mo948a() {
        return this.f4701c != null ? this.f4701c.mo948a() : null;
    }

    public void mo949a(AdSizeParcel adSizeParcel) {
        if (this.f4701c != null) {
            this.f4701c.mo949a(adSizeParcel);
        }
    }

    public void mo950a(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public void mo951a(ab abVar) {
        this.f4702d.f4615e = abVar;
        if (this.f4701c != null) {
            this.f4702d.m8127a(this.f4701c);
        }
    }

    public void mo952a(ac acVar) {
        this.f4702d.f4611a = acVar;
        if (this.f4701c != null) {
            this.f4702d.m8127a(this.f4701c);
        }
    }

    public void mo953a(ai aiVar) {
        this.f4702d.f4612b = aiVar;
        if (this.f4701c != null) {
            this.f4702d.m8127a(this.f4701c);
        }
    }

    public void mo954a(ak akVar) {
        m8217m();
        if (this.f4701c != null) {
            this.f4701c.mo954a(akVar);
        }
    }

    public void mo955a(C1301d c1301d) {
        this.f4702d.f4616f = c1301d;
        if (this.f4701c != null) {
            this.f4702d.m8127a(this.f4701c);
        }
    }

    public void mo956a(dc dcVar) {
        this.f4702d.f4614d = dcVar;
        if (this.f4701c != null) {
            this.f4702d.m8127a(this.f4701c);
        }
    }

    public void mo957a(hd hdVar) {
        this.f4702d.f4613c = hdVar;
        if (this.f4701c != null) {
            this.f4702d.m8127a(this.f4701c);
        }
    }

    public void mo958a(hh hhVar, String str) {
        this.f4703e = hhVar;
        this.f4704f = str;
        m8193n();
    }

    public void mo960a(String str) {
    }

    public void mo963a(boolean z) {
        m8217m();
        if (this.f4701c != null) {
            this.f4701c.mo963a(z);
        }
    }

    public boolean mo964a(AdRequestParcel adRequestParcel) {
        if (!fa.m8191b(adRequestParcel)) {
            m8217m();
        }
        if (ex.m8134c(adRequestParcel)) {
            m8217m();
        }
        if (adRequestParcel.f3094j != null) {
            m8217m();
        }
        if (this.f4701c != null) {
            return this.f4701c.mo964a(adRequestParcel);
        }
        ex p = C1319u.m7194p();
        if (fa.m8192c(adRequestParcel)) {
            p.m8141b(adRequestParcel, this.f4699a);
        }
        C1485a a = p.m8137a(adRequestParcel, this.f4699a);
        if (a != null) {
            if (!a.f4625e) {
                a.m8146a();
            }
            this.f4701c = a.f4621a;
            a.f4623c.m8121a(this.f4702d);
            this.f4702d.m8127a(this.f4701c);
            m8193n();
            return a.f4626f;
        }
        m8217m();
        return this.f4701c.mo964a(adRequestParcel);
    }

    public void mo965b() {
        if (this.f4701c != null) {
            this.f4701c.mo965b();
        }
    }

    public boolean mo967c() {
        return this.f4701c != null && this.f4701c.mo967c();
    }

    public void c_() {
        if (this.f4701c != null) {
            this.f4701c.c_();
        }
    }

    public void mo969d() {
        if (this.f4701c != null) {
            this.f4701c.mo969d();
        }
    }

    public void mo986f() {
        if (this.f4701c != null) {
            this.f4701c.mo986f();
        } else {
            C1324b.m7234d("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void g_() {
        if (this.f4701c != null) {
            this.f4701c.g_();
        }
    }

    public void mo971h() {
        if (this.f4701c != null) {
            this.f4701c.mo971h();
        } else {
            C1324b.m7234d("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public AdSizeParcel mo972i() {
        return this.f4701c != null ? this.f4701c.mo972i() : null;
    }

    public String mo989j() {
        return this.f4701c != null ? this.f4701c.mo989j() : null;
    }

    public boolean mo973k() {
        return this.f4701c != null && this.f4701c.mo973k();
    }

    public C1081c mo974l() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    void m8217m() {
        if (this.f4701c == null) {
            this.f4701c = this.f4700b.m8081a(this.f4699a);
            this.f4702d.m8127a(this.f4701c);
            m8193n();
        }
    }
}
