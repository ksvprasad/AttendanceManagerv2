package com.google.android.gms.ads.internal.reward.mediation.client;

import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p029d.C1028a;
import com.google.android.gms.ads.p029d.p030a.C0958a;
import com.google.android.gms.ads.p029d.p030a.C1027b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C1001b;

@id
public class C1311b implements C1027b {
    private final C1308a f3911a;

    public C1311b(C1308a c1308a) {
        this.f3911a = c1308a;
    }

    public void mo1221a(C0958a c0958a) {
        C1896c.m10797b("onInitializationSucceeded must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onInitializationSucceeded.");
        try {
            this.f3911a.mo1211a(C1001b.m5713a((Object) c0958a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onInitializationSucceeded.", e);
        }
    }

    public void mo1222a(C0958a c0958a, int i) {
        C1896c.m10797b("onAdFailedToLoad must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdFailedToLoad.");
        try {
            this.f3911a.mo1215b(C1001b.m5713a((Object) c0958a), i);
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void mo1223a(C0958a c0958a, C1028a c1028a) {
        C1896c.m10797b("onRewarded must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onRewarded.");
        if (c1028a != null) {
            try {
                this.f3911a.mo1213a(C1001b.m5713a((Object) c0958a), new RewardItemParcel(c1028a));
                return;
            } catch (Throwable e) {
                C1324b.m7235d("Could not call onRewarded.", e);
                return;
            }
        }
        this.f3911a.mo1213a(C1001b.m5713a((Object) c0958a), new RewardItemParcel(c0958a.getClass().getName(), 1));
    }

    public void mo1224b(C0958a c0958a) {
        C1896c.m10797b("onAdLoaded must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLoaded.");
        try {
            this.f3911a.mo1214b(C1001b.m5713a((Object) c0958a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLoaded.", e);
        }
    }

    public void mo1225c(C0958a c0958a) {
        C1896c.m10797b("onAdOpened must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdOpened.");
        try {
            this.f3911a.mo1216c(C1001b.m5713a((Object) c0958a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdOpened.", e);
        }
    }

    public void mo1226d(C0958a c0958a) {
        C1896c.m10797b("onVideoStarted must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onVideoStarted.");
        try {
            this.f3911a.mo1217d(C1001b.m5713a((Object) c0958a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onVideoStarted.", e);
        }
    }

    public void mo1227e(C0958a c0958a) {
        C1896c.m10797b("onAdClosed must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdClosed.");
        try {
            this.f3911a.mo1218e(C1001b.m5713a((Object) c0958a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdClosed.", e);
        }
    }

    public void mo1228f(C0958a c0958a) {
        C1896c.m10797b("onAdLeftApplication must be called on the main UI thread.");
        C1324b.m7227a("Adapter called onAdLeftApplication.");
        try {
            this.f3911a.mo1220g(C1001b.m5713a((Object) c0958a));
        } catch (Throwable e) {
            C1324b.m7235d("Could not call onAdLeftApplication.", e);
        }
    }
}
