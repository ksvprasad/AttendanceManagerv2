package com.google.android.gms.p031b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C1047g;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.mediation.C0961e;
import com.google.android.gms.ads.mediation.C1331a;
import com.google.android.gms.ads.mediation.C1345f;
import com.google.android.gms.p031b.de.C1416a;

@id
public class gm implements C0961e {
    private Activity f4940a;
    private de f4941b;
    private C1345f f4942c;
    private Uri f4943d;

    class C15501 implements C1416a {
        final /* synthetic */ gm f4936a;

        C15501(gm gmVar) {
            this.f4936a = gmVar;
        }
    }

    class C15512 implements C1047g {
        final /* synthetic */ gm f4937a;

        C15512(gm gmVar) {
            this.f4937a = gmVar;
        }

        public void d_() {
            C1324b.m7227a("AdMobCustomTabsAdapter overlay is closed.");
            this.f4937a.f4942c.mo1416c(this.f4937a);
            this.f4937a.f4941b.m7896a(this.f4937a.f4940a);
        }

        public void e_() {
            C1324b.m7227a("Opening AdMobCustomTabsAdapter overlay.");
            this.f4937a.f4942c.mo1413b(this.f4937a);
        }

        public void f_() {
            C1324b.m7227a("AdMobCustomTabsAdapter overlay is paused.");
        }

        public void mo988g() {
            C1324b.m7227a("AdMobCustomTabsAdapter overlay is resumed.");
        }
    }

    public static boolean m8630a(Context context) {
        return de.m7894a(context);
    }

    public void onDestroy() {
        C1324b.m7227a("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.f4941b.m7896a(this.f4940a);
        } catch (Throwable e) {
            C1324b.m7231b("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        C1324b.m7227a("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        C1324b.m7227a("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, C1345f c1345f, Bundle bundle, C1331a c1331a, Bundle bundle2) {
        this.f4942c = c1345f;
        if (this.f4942c == null) {
            C1324b.m7234d("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            C1324b.m7234d("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f4942c.mo1408a(this, 0);
        } else if (gm.m8630a(context)) {
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                C1324b.m7234d("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f4942c.mo1408a(this, 0);
                return;
            }
            this.f4940a = (Activity) context;
            this.f4943d = Uri.parse(string);
            this.f4941b = new de();
            this.f4941b.m7897a(new C15501(this));
            this.f4941b.m7898b(this.f4940a);
            this.f4942c.mo1407a(this);
        } else {
            C1324b.m7234d("Default browser does not support custom tabs. Bailing out.");
            this.f4942c.mo1408a(this, 0);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new Builder(this.f4941b.m7895a()).build();
        build.intent.setData(this.f4943d);
        final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(new AdLauncherIntentInfoParcel(build.intent), null, new C15512(this), null, new VersionInfoParcel(0, 0, false));
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ gm f4939b;

            public void run() {
                C1319u.m7181c().m6680a(this.f4939b.f4940a, adOverlayInfoParcel);
            }
        });
        C1319u.m7186h().m9121b(false);
    }
}
