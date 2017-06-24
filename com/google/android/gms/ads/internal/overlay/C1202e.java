package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.p031b.id;

@id
public class C1202e {
    public void m6680a(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        m6681a(context, adOverlayInfoParcel, true);
    }

    public void m6681a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.f3485l == 4 && adOverlayInfoParcel.f3477d == null) {
            if (adOverlayInfoParcel.f3476c != null) {
                adOverlayInfoParcel.f3476c.mo915e();
            }
            C1319u.m7180b().m6596a(context, adOverlayInfoParcel.f3475b, adOverlayInfoParcel.f3483j);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f3487n.f3960e);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.m6588a(intent, adOverlayInfoParcel);
        if (!C1979l.m11116j()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        C1319u.m7183e().m9214a(context, intent);
    }
}
