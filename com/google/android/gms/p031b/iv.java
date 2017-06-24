package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.C1295b.C1297a;
import com.google.android.gms.ads.internal.reward.client.C1301d;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@id
public class iv extends C1297a {
    private final Context f5302a;
    private final VersionInfoParcel f5303b;
    private final iw f5304c;
    private final Object f5305d = new Object();

    public iv(Context context, C1122d c1122d, fx fxVar, VersionInfoParcel versionInfoParcel) {
        this.f5302a = context;
        this.f5303b = versionInfoParcel;
        this.f5304c = new iw(context, c1122d, AdSizeParcel.m5967a(), fxVar, versionInfoParcel);
    }

    public void mo1190a() {
        synchronized (this.f5305d) {
            this.f5304c.m9001D();
        }
    }

    public void mo1191a(C0998a c0998a) {
        synchronized (this.f5305d) {
            this.f5304c.mo969d();
        }
    }

    public void mo1192a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.f5305d) {
            this.f5304c.m9009a(rewardedVideoAdRequestParcel);
        }
    }

    public void mo1193a(C1301d c1301d) {
        synchronized (this.f5305d) {
            this.f5304c.mo955a(c1301d);
        }
    }

    public void mo1194a(String str) {
        C1324b.m7234d("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void mo1195b(C0998a c0998a) {
        synchronized (this.f5305d) {
            Context context = c0998a == null ? null : (Context) C1001b.m5714a(c0998a);
            if (context != null) {
                try {
                    this.f5304c.m9008a(context);
                } catch (Throwable e) {
                    C1324b.m7235d("Unable to extract updated context.", e);
                }
            }
            this.f5304c.c_();
        }
    }

    public boolean mo1196b() {
        boolean E;
        synchronized (this.f5305d) {
            E = this.f5304c.m9002E();
        }
        return E;
    }

    public void mo1197c() {
        mo1191a(null);
    }

    public void mo1198c(C0998a c0998a) {
        synchronized (this.f5305d) {
            this.f5304c.mo965b();
        }
    }

    public void mo1199d() {
        mo1195b(null);
    }

    public void mo1200e() {
        mo1198c(null);
    }
}
