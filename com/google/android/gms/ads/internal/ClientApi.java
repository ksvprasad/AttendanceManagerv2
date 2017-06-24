package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Keep;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ae;
import com.google.android.gms.ads.internal.client.ag;
import com.google.android.gms.ads.internal.client.aj.C1037a;
import com.google.android.gms.ads.internal.client.al;
import com.google.android.gms.ads.internal.formats.C1159k;
import com.google.android.gms.ads.internal.overlay.C1201d;
import com.google.android.gms.ads.internal.purchase.C1231e;
import com.google.android.gms.ads.internal.reward.client.C1295b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1914l;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.dh;
import com.google.android.gms.p031b.fa;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.gx;
import com.google.android.gms.p031b.he;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.iv;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@Keep
@id
@DynamiteApi
public class ClientApi extends C1037a {
    public ae createAdLoaderBuilder(C0998a c0998a, String str, fx fxVar, int i) {
        return new C1169k((Context) C1001b.m5714a(c0998a), str, fxVar, new VersionInfoParcel(C1914l.f6455a, i, true), C1122d.m6298a());
    }

    public gx createAdOverlay(C0998a c0998a) {
        return new C1201d((Activity) C1001b.m5714a(c0998a));
    }

    public ag createBannerAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, fx fxVar, int i) {
        return new C1130f((Context) C1001b.m5714a(c0998a), adSizeParcel, str, fxVar, new VersionInfoParcel(C1914l.f6455a, i, true), C1122d.m6298a());
    }

    public he createInAppPurchaseManager(C0998a c0998a) {
        return new C1231e((Activity) C1001b.m5714a(c0998a));
    }

    public ag createInterstitialAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, fx fxVar, int i) {
        Context context = (Context) C1001b.m5714a(c0998a);
        cq.m7828a(context);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(C1914l.f6455a, i, true);
        boolean equals = "reward_mb".equals(adSizeParcel.f3104b);
        Object obj = ((equals || !((Boolean) cq.ah.m7801c()).booleanValue()) && !(equals && ((Boolean) cq.ai.m7801c()).booleanValue())) ? null : 1;
        if (obj != null) {
            return new fa(context, str, fxVar, versionInfoParcel, C1122d.m6298a());
        }
        return new C1173l(context, adSizeParcel, str, fxVar, versionInfoParcel, C1122d.m6298a());
    }

    public dh createNativeAdViewDelegate(C0998a c0998a, C0998a c0998a2) {
        return new C1159k((FrameLayout) C1001b.m5714a(c0998a), (FrameLayout) C1001b.m5714a(c0998a2));
    }

    public C1295b createRewardedVideoAd(C0998a c0998a, fx fxVar, int i) {
        return new iv((Context) C1001b.m5714a(c0998a), C1122d.m6298a(), fxVar, new VersionInfoParcel(C1914l.f6455a, i, true));
    }

    public ag createSearchAdManager(C0998a c0998a, AdSizeParcel adSizeParcel, String str, int i) {
        return new C1318t((Context) C1001b.m5714a(c0998a), adSizeParcel, str, new VersionInfoParcel(C1914l.f6455a, i, true));
    }

    public al getMobileAdsSettingsManager(C0998a c0998a) {
        return null;
    }

    public al getMobileAdsSettingsManagerWithClientJarVersion(C0998a c0998a, int i) {
        return C1181o.m6578a((Context) C1001b.m5714a(c0998a), new VersionInfoParcel(C1914l.f6455a, i, true));
    }
}
