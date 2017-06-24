package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.C1029d;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.mediation.C0959c;
import com.google.android.gms.ads.mediation.C0960g;
import com.google.android.gms.ads.mediation.C0961e;
import com.google.android.gms.ads.mediation.C1331a;
import com.google.android.gms.ads.mediation.C1344d;
import com.google.android.gms.ads.mediation.C1345f;
import com.google.android.gms.ads.mediation.C1346h;
import com.google.android.gms.ads.mediation.C1347l;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements C0959c, C0961e, C0960g {
    C1340b f4023a;
    C1342e f4024b;
    C1343g f4025c;
    private View f4026d;

    static final class C1334a implements C1333c {
        private final CustomEventAdapter f4016a;
        private final C1344d f4017b;

        public C1334a(CustomEventAdapter customEventAdapter, C1344d c1344d) {
            this.f4016a = customEventAdapter;
            this.f4017b = c1344d;
        }
    }

    class C1336b implements C1335f {
        final /* synthetic */ CustomEventAdapter f4018a;
        private final CustomEventAdapter f4019b;
        private final C1345f f4020c;

        public C1336b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, C1345f c1345f) {
            this.f4018a = customEventAdapter;
            this.f4019b = customEventAdapter2;
            this.f4020c = c1345f;
        }
    }

    static class C1338c implements C1337h {
        private final CustomEventAdapter f4021a;
        private final C1346h f4022b;

        public C1338c(CustomEventAdapter customEventAdapter, C1346h c1346h) {
            this.f4021a = customEventAdapter;
            this.f4022b = c1346h;
        }
    }

    private static <T> T m7267a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    C1336b m7268a(C1345f c1345f) {
        return new C1336b(this, this, c1345f);
    }

    public View getBannerView() {
        return this.f4026d;
    }

    public void onDestroy() {
        if (this.f4023a != null) {
            this.f4023a.m7269a();
        }
        if (this.f4024b != null) {
            this.f4024b.m7269a();
        }
        if (this.f4025c != null) {
            this.f4025c.m7269a();
        }
    }

    public void onPause() {
        if (this.f4023a != null) {
            this.f4023a.m7270b();
        }
        if (this.f4024b != null) {
            this.f4024b.m7270b();
        }
        if (this.f4025c != null) {
            this.f4025c.m7270b();
        }
    }

    public void onResume() {
        if (this.f4023a != null) {
            this.f4023a.m7271c();
        }
        if (this.f4024b != null) {
            this.f4024b.m7271c();
        }
        if (this.f4025c != null) {
            this.f4025c.m7271c();
        }
    }

    public void requestBannerAd(Context context, C1344d c1344d, Bundle bundle, C1029d c1029d, C1331a c1331a, Bundle bundle2) {
        this.f4023a = (C1340b) m7267a(bundle.getString("class_name"));
        if (this.f4023a == null) {
            c1344d.mo1406a(this, 0);
            return;
        }
        this.f4023a.m7272a(context, new C1334a(this, c1344d), bundle.getString("parameter"), c1029d, c1331a, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, C1345f c1345f, Bundle bundle, C1331a c1331a, Bundle bundle2) {
        this.f4024b = (C1342e) m7267a(bundle.getString("class_name"));
        if (this.f4024b == null) {
            c1345f.mo1408a(this, 0);
            return;
        }
        this.f4024b.m7274a(context, m7268a(c1345f), bundle.getString("parameter"), c1331a, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void requestNativeAd(Context context, C1346h c1346h, Bundle bundle, C1347l c1347l, Bundle bundle2) {
        this.f4025c = (C1343g) m7267a(bundle.getString("class_name"));
        if (this.f4025c == null) {
            c1346h.mo1410a((C0960g) this, 0);
            return;
        }
        this.f4025c.m7276a(context, new C1338c(this, c1346h), bundle.getString("parameter"), c1347l, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
    }

    public void showInterstitial() {
        this.f4024b.m7275d();
    }
}
