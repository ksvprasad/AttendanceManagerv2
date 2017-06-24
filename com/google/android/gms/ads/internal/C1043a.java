package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.C1328v.C1327a;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.client.C1081c;
import com.google.android.gms.ads.internal.client.C1106r;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.ab;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ag.C1039a;
import com.google.android.gms.ads.internal.client.ai;
import com.google.android.gms.ads.internal.client.ak;
import com.google.android.gms.ads.internal.overlay.C1040p;
import com.google.android.gms.ads.internal.request.C1251a.C1041a;
import com.google.android.gms.ads.internal.reward.client.C1301d;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.util.C1973f;
import com.google.android.gms.p031b.bt;
import com.google.android.gms.p031b.by;
import com.google.android.gms.p031b.cb;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.cw;
import com.google.android.gms.p031b.cy;
import com.google.android.gms.p031b.dc;
import com.google.android.gms.p031b.dx;
import com.google.android.gms.p031b.hd;
import com.google.android.gms.p031b.hh;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.iu;
import com.google.android.gms.p031b.jl;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.jm;
import com.google.android.gms.p031b.jq;
import com.google.android.gms.p031b.js;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@id
public abstract class C1043a extends C1039a implements C0971a, C1040p, C1041a, dx, C1042a, jq {
    protected cy f3058a;
    protected cw f3059b;
    protected cw f3060c;
    protected boolean f3061d = false;
    protected final C1248r f3062e;
    protected final C1328v f3063f;
    protected transient AdRequestParcel f3064g;
    protected final bt f3065h;
    protected final C1122d f3066i;

    C1043a(C1328v c1328v, C1248r c1248r, C1122d c1122d) {
        this.f3063f = c1328v;
        if (c1248r == null) {
            c1248r = new C1248r(this);
        }
        this.f3062e = c1248r;
        this.f3066i = c1122d;
        C1319u.m7183e().m9236b(this.f3063f.f3990c);
        C1319u.m7186h().m9111a(this.f3063f.f3990c, this.f3063f.f3992e);
        this.f3065h = C1319u.m7186h().m9135n();
        mo990t();
    }

    private TimerTask m5863a(final Timer timer, final CountDownLatch countDownLatch) {
        return new TimerTask(this) {
            final /* synthetic */ C1043a f3057c;

            public void run() {
                if (((long) ((Integer) cq.bo.m7801c()).intValue()) != countDownLatch.getCount()) {
                    C1324b.m7227a("Stopping method tracing");
                    Debug.stopMethodTracing();
                    if (countDownLatch.getCount() == 0) {
                        timer.cancel();
                        return;
                    }
                }
                String concat = String.valueOf(this.f3057c.f3063f.f3990c.getPackageName()).concat("_adsTrace_");
                try {
                    C1324b.m7227a("Starting method tracing");
                    countDownLatch.countDown();
                    Debug.startMethodTracing(new StringBuilder(String.valueOf(concat).length() + 20).append(concat).append(C1319u.m7187i().mo1723a()).toString(), ((Integer) cq.bp.m7801c()).intValue());
                } catch (Throwable e) {
                    C1324b.m7235d("Exception occurred while starting method tracing.", e);
                }
            }
        };
    }

    private AdRequestParcel mo1050d(AdRequestParcel adRequestParcel) {
        return (!C1973f.m11093b(this.f3063f.f3990c) || adRequestParcel.f3095k == null) ? adRequestParcel : new C1106r(adRequestParcel).m6235a(null).m6234a();
    }

    private void mo990t() {
        if (((Boolean) cq.bm.m7801c()).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(m5863a(timer, new CountDownLatch(((Integer) cq.bo.m7801c()).intValue())), 0, ((Long) cq.bn.m7801c()).longValue());
        }
    }

    Bundle m5866a(cb cbVar) {
        if (cbVar == null) {
            return null;
        }
        String b;
        String c;
        if (cbVar.m7758f()) {
            cbVar.m7756d();
        }
        by c2 = cbVar.m7755c();
        if (c2 != null) {
            b = c2.m7690b();
            c = c2.m7692c();
            String str = "In AdManager: loadAd, ";
            String valueOf = String.valueOf(c2.toString());
            C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            if (b != null) {
                C1319u.m7186h().m9110a(b);
            }
        } else {
            c = null;
            b = C1319u.m7186h().m9130i();
        }
        if (b == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", b);
        if (b.equals(c)) {
            return bundle;
        }
        bundle.putString("v_fp", c);
        return bundle;
    }

    public C0998a mo948a() {
        C1896c.m10797b("getAdFrame must be called on the main UI thread.");
        return C1001b.m5713a(this.f3063f.f3993f);
    }

    protected void m5868a(int i) {
        C1324b.m7234d("Failed to load ad: " + i);
        this.f3061d = false;
        if (this.f3063f.f4001n != null) {
            try {
                this.f3063f.f4001n.mo1007a(i);
            } catch (Throwable e) {
                C1324b.m7235d("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.f3063f.f4013z != null) {
            try {
                this.f3063f.f4013z.mo1203a(i);
            } catch (Throwable e2) {
                C1324b.m7235d("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    protected void m5869a(View view) {
        C1327a c1327a = this.f3063f.f3993f;
        if (c1327a != null) {
            c1327a.addView(view, C1319u.m7185g().mo1481d());
        }
    }

    public void mo949a(AdSizeParcel adSizeParcel) {
        C1896c.m10797b("setAdSize must be called on the main UI thread.");
        this.f3063f.f3996i = adSizeParcel;
        if (!(this.f3063f.f3997j == null || this.f3063f.f3997j.f5424b == null || this.f3063f.f3978E != 0)) {
            this.f3063f.f3997j.f5424b.mo1496a(adSizeParcel);
        }
        if (this.f3063f.f3993f != null) {
            if (this.f3063f.f3993f.getChildCount() > 1) {
                this.f3063f.f3993f.removeView(this.f3063f.f3993f.getNextView());
            }
            this.f3063f.f3993f.setMinimumWidth(adSizeParcel.f3109g);
            this.f3063f.f3993f.setMinimumHeight(adSizeParcel.f3106d);
            this.f3063f.f3993f.requestLayout();
        }
    }

    public void mo950a(VideoOptionsParcel videoOptionsParcel) {
        C1896c.m10797b("setVideoOptions must be called on the main UI thread.");
        this.f3063f.f4011x = videoOptionsParcel;
    }

    public void mo951a(ab abVar) {
        C1896c.m10797b("setAdListener must be called on the main UI thread.");
        this.f3063f.f4000m = abVar;
    }

    public void mo952a(ac acVar) {
        C1896c.m10797b("setAdListener must be called on the main UI thread.");
        this.f3063f.f4001n = acVar;
    }

    public void mo953a(ai aiVar) {
        C1896c.m10797b("setAppEventListener must be called on the main UI thread.");
        this.f3063f.f4002o = aiVar;
    }

    public void mo954a(ak akVar) {
        C1896c.m10797b("setCorrelationIdProvider must be called on the main UI thread");
        this.f3063f.f4003p = akVar;
    }

    public void mo955a(C1301d c1301d) {
        C1896c.m10797b("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f3063f.f4013z = c1301d;
    }

    protected void m5877a(RewardItemParcel rewardItemParcel) {
        if (this.f3063f.f4013z != null) {
            try {
                String str = "";
                int i = 0;
                if (rewardItemParcel != null) {
                    str = rewardItemParcel.f3908b;
                    i = rewardItemParcel.f3909c;
                }
                this.f3063f.f4013z.mo1204a(new iu(str, i));
            } catch (Throwable e) {
                C1324b.m7235d("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void mo956a(dc dcVar) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void mo957a(hd hdVar) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void mo958a(hh hhVar, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void mo959a(C1632a c1632a) {
        if (!(c1632a.f5409b.f3792n == -1 || TextUtils.isEmpty(c1632a.f5409b.f3803y))) {
            long b = m5891b(c1632a.f5409b.f3803y);
            if (b != -1) {
                cw a = this.f3058a.m7862a(b + c1632a.f5409b.f3792n);
                this.f3058a.m7867a(a, "stc");
            }
        }
        this.f3058a.m7864a(c1632a.f5409b.f3803y);
        this.f3058a.m7867a(this.f3059b, "arf");
        this.f3060c = this.f3058a.m7861a();
        this.f3058a.m7865a("gqi", c1632a.f5409b.f3804z);
        this.f3063f.f3994g = null;
        this.f3063f.f3998k = c1632a;
        mo1002a(c1632a, this.f3058a);
    }

    protected abstract void mo1002a(C1632a c1632a, cy cyVar);

    public void mo960a(String str) {
        C1324b.m7234d("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void mo961a(String str, String str2) {
        if (this.f3063f.f4002o != null) {
            try {
                this.f3063f.f4002o.mo1024a(str, str2);
            } catch (Throwable e) {
                C1324b.m7235d("Could not call the AppEventListener.", e);
            }
        }
    }

    public void mo962a(HashSet<jm> hashSet) {
        this.f3063f.m7245a((HashSet) hashSet);
    }

    public void mo963a(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public boolean mo964a(AdRequestParcel adRequestParcel) {
        C1896c.m10797b("loadAd must be called on the main UI thread.");
        AdRequestParcel d = mo1050d(adRequestParcel);
        if (this.f3063f.f3994g == null && this.f3063f.f3995h == null) {
            C1324b.m7232c("Starting ad request.");
            m5905n();
            this.f3059b = this.f3058a.m7861a();
            if (!d.f3090f) {
                String valueOf = String.valueOf(C1120y.m6293a().m7210a(this.f3063f.f3990c));
                C1324b.m7232c(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.f3061d = mo980a(d, this.f3058a);
            return this.f3061d;
        }
        if (this.f3064g != null) {
            C1324b.m7234d("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            C1324b.m7234d("Loading already in progress, saving this object for future refreshes.");
        }
        this.f3064g = d;
        return false;
    }

    protected abstract boolean mo980a(AdRequestParcel adRequestParcel, cy cyVar);

    boolean mo981a(jl jlVar) {
        return false;
    }

    protected abstract boolean mo982a(jl jlVar, jl jlVar2);

    long m5891b(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            C1324b.m7234d("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            C1324b.m7234d("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }

    public void mo965b() {
        C1896c.m10797b("destroy must be called on the main UI thread.");
        this.f3062e.m6884a();
        this.f3065h.m7663c(this.f3063f.f3997j);
        this.f3063f.m7255j();
    }

    public void mo966b(jl jlVar) {
        this.f3058a.m7867a(this.f3060c, "awr");
        this.f3063f.f3995h = null;
        if (!(jlVar.f5426d == -2 || jlVar.f5426d == 3)) {
            C1319u.m7186h().m9118a(this.f3063f.m7244a());
        }
        if (jlVar.f5426d == -1) {
            this.f3061d = false;
            return;
        }
        if (mo981a(jlVar)) {
            C1324b.m7227a("Ad refresh scheduled.");
        }
        if (jlVar.f5426d != -2) {
            m5868a(jlVar.f5426d);
            return;
        }
        if (this.f3063f.f3976C == null) {
            this.f3063f.f3976C = new js(this.f3063f.f3989b);
        }
        this.f3065h.m7662b(this.f3063f.f3997j);
        if (mo982a(this.f3063f.f3997j, jlVar)) {
            this.f3063f.f3997j = jlVar;
            this.f3063f.m7254i();
            this.f3058a.m7865a("is_mraid", this.f3063f.f3997j.m9083a() ? "1" : "0");
            this.f3058a.m7865a("is_mediation", this.f3063f.f3997j.f5436n ? "1" : "0");
            if (!(this.f3063f.f3997j.f5424b == null || this.f3063f.f3997j.f5424b.mo1519l() == null)) {
                this.f3058a.m7865a("is_delay_pl", this.f3063f.f3997j.f5424b.mo1519l().m9473c() ? "1" : "0");
            }
            this.f3058a.m7867a(this.f3059b, "ttc");
            if (C1319u.m7186h().m9126e() != null) {
                C1319u.m7186h().m9126e().m7843a(this.f3058a);
            }
            if (this.f3063f.m7250e()) {
                mo1116r();
            }
        }
        if (jlVar.f5422G != null) {
            C1319u.m7183e().m9221a(this.f3063f.f3990c, jlVar.f5422G);
        }
    }

    protected boolean mo983b(AdRequestParcel adRequestParcel) {
        if (this.f3063f.f3993f == null) {
            return false;
        }
        ViewParent parent = this.f3063f.f3993f.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return C1319u.m7183e().m9227a(view, view.getContext());
    }

    public void m5895c(AdRequestParcel adRequestParcel) {
        if (mo983b(adRequestParcel)) {
            mo964a(adRequestParcel);
            return;
        }
        C1324b.m7232c("Ad is not visible. Not refreshing ad.");
        this.f3062e.m6885a(adRequestParcel);
    }

    protected void m5896c(jl jlVar) {
        if (jlVar == null) {
            C1324b.m7234d("Ad state was null when trying to ping impression URLs.");
            return;
        }
        C1324b.m7227a("Pinging Impression URLs.");
        this.f3063f.f3999l.m9088a();
        if (jlVar.f5427e != null && !jlVar.f5420E) {
            C1319u.m7183e().m9218a(this.f3063f.f3990c, this.f3063f.f3992e.f3957b, jlVar.f5427e);
            jlVar.f5420E = true;
        }
    }

    public boolean mo967c() {
        C1896c.m10797b("isLoaded must be called on the main UI thread.");
        return this.f3063f.f3994g == null && this.f3063f.f3995h == null && this.f3063f.f3997j != null;
    }

    public void c_() {
        C1896c.m10797b("resume must be called on the main UI thread.");
    }

    public void mo969d() {
        C1896c.m10797b("pause must be called on the main UI thread.");
    }

    public void mo915e() {
        if (this.f3063f.f3997j == null) {
            C1324b.m7234d("Ad state was null when trying to ping click URLs.");
            return;
        }
        C1324b.m7227a("Pinging click URLs.");
        this.f3063f.f3999l.m9092b();
        if (this.f3063f.f3997j.f5425c != null) {
            C1319u.m7183e().m9218a(this.f3063f.f3990c, this.f3063f.f3992e.f3957b, this.f3063f.f3997j.f5425c);
        }
        if (this.f3063f.f4000m != null) {
            try {
                this.f3063f.f4000m.mo1005a();
            } catch (Throwable e) {
                C1324b.m7235d("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void g_() {
        C1896c.m10797b("stopLoading must be called on the main UI thread.");
        this.f3061d = false;
        this.f3063f.m7246a(true);
    }

    public void mo971h() {
        C1896c.m10797b("recordManualImpression must be called on the main UI thread.");
        if (this.f3063f.f3997j == null) {
            C1324b.m7234d("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        C1324b.m7227a("Pinging manual tracking URLs.");
        if (this.f3063f.f3997j.f5428f != null && !this.f3063f.f3997j.f5421F) {
            C1319u.m7183e().m9218a(this.f3063f.f3990c, this.f3063f.f3992e.f3957b, this.f3063f.f3997j.f5428f);
            this.f3063f.f3997j.f5421F = true;
        }
    }

    public AdSizeParcel mo972i() {
        C1896c.m10797b("getAdSize must be called on the main UI thread.");
        return this.f3063f.f3996i == null ? null : new ThinAdSizeParcel(this.f3063f.f3996i);
    }

    public boolean mo973k() {
        return this.f3061d;
    }

    public C1081c mo974l() {
        return null;
    }

    public void mo975m() {
        m5907p();
    }

    public void m5905n() {
        this.f3058a = new cy(((Boolean) cq.f4367H.m7801c()).booleanValue(), "load_ad", this.f3063f.f3996i.f3104b);
        this.f3059b = new cw(-1, null, null);
        this.f3060c = new cw(-1, null, null);
    }

    protected void mo1115o() {
        C1324b.m7232c("Ad closing.");
        if (this.f3063f.f4001n != null) {
            try {
                this.f3063f.f4001n.mo1006a();
            } catch (Throwable e) {
                C1324b.m7235d("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.f3063f.f4013z != null) {
            try {
                this.f3063f.f4013z.mo1207d();
            } catch (Throwable e2) {
                C1324b.m7235d("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    protected void m5907p() {
        C1324b.m7232c("Ad leaving application.");
        if (this.f3063f.f4001n != null) {
            try {
                this.f3063f.f4001n.mo1008b();
            } catch (Throwable e) {
                C1324b.m7235d("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.f3063f.f4013z != null) {
            try {
                this.f3063f.f4013z.mo1208e();
            } catch (Throwable e2) {
                C1324b.m7235d("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    protected void m5908q() {
        C1324b.m7232c("Ad opening.");
        if (this.f3063f.f4001n != null) {
            try {
                this.f3063f.f4001n.mo1010d();
            } catch (Throwable e) {
                C1324b.m7235d("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.f3063f.f4013z != null) {
            try {
                this.f3063f.f4013z.mo1205b();
            } catch (Throwable e2) {
                C1324b.m7235d("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    protected void mo1116r() {
        C1324b.m7232c("Ad finished loading.");
        this.f3061d = false;
        if (this.f3063f.f4001n != null) {
            try {
                this.f3063f.f4001n.mo1009c();
            } catch (Throwable e) {
                C1324b.m7235d("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.f3063f.f4013z != null) {
            try {
                this.f3063f.f4013z.mo1202a();
            } catch (Throwable e2) {
                C1324b.m7235d("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    protected void m5910s() {
        if (this.f3063f.f4013z != null) {
            try {
                this.f3063f.f4013z.mo1206c();
            } catch (Throwable e) {
                C1324b.m7235d("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }
}
