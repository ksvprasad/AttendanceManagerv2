package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1049s;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@id
public class lc {
    public la m9480a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, aj ajVar, VersionInfoParcel versionInfoParcel) {
        return m9481a(context, adSizeParcel, z, z2, ajVar, versionInfoParcel, null, null, null);
    }

    public la m9481a(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, aj ajVar, VersionInfoParcel versionInfoParcel, cy cyVar, C1049s c1049s, C1122d c1122d) {
        la ldVar = new ld(le.m9542a(context, adSizeParcel, z, z2, ajVar, versionInfoParcel, cyVar, c1049s, c1122d));
        ldVar.setWebViewClient(C1319u.m7185g().mo1466a(ldVar, z2));
        ldVar.setWebChromeClient(C1319u.m7185g().mo1471c(ldVar));
        return ldVar;
    }
}
