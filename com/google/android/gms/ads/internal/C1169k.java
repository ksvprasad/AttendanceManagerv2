package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.p015g.C0369j;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.ac;
import com.google.android.gms.ads.internal.client.ad;
import com.google.android.gms.ads.internal.client.ae.C1065a;
import com.google.android.gms.ads.internal.client.ak;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.dp;
import com.google.android.gms.p031b.dq;
import com.google.android.gms.p031b.dr;
import com.google.android.gms.p031b.ds;
import com.google.android.gms.p031b.fx;
import com.google.android.gms.p031b.id;

@id
public class C1169k extends C1065a {
    private ac f3423a;
    private dp f3424b;
    private dq f3425c;
    private C0369j<String, dr> f3426d = new C0369j();
    private C0369j<String, ds> f3427e = new C0369j();
    private NativeAdOptionsParcel f3428f;
    private ak f3429g;
    private final Context f3430h;
    private final fx f3431i;
    private final String f3432j;
    private final VersionInfoParcel f3433k;
    private final C1122d f3434l;

    public C1169k(Context context, String str, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        this.f3430h = context;
        this.f3432j = str;
        this.f3431i = fxVar;
        this.f3433k = versionInfoParcel;
        this.f3434l = c1122d;
    }

    public ad mo1014a() {
        return new C1168j(this.f3430h, this.f3432j, this.f3431i, this.f3433k, this.f3423a, this.f3424b, this.f3425c, this.f3427e, this.f3426d, this.f3428f, this.f3429g, this.f3434l);
    }

    public void mo1015a(ac acVar) {
        this.f3423a = acVar;
    }

    public void mo1016a(ak akVar) {
        this.f3429g = akVar;
    }

    public void mo1017a(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.f3428f = nativeAdOptionsParcel;
    }

    public void mo1018a(dp dpVar) {
        this.f3424b = dpVar;
    }

    public void mo1019a(dq dqVar) {
        this.f3425c = dqVar;
    }

    public void mo1020a(String str, ds dsVar, dr drVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f3427e.put(str, dsVar);
        this.f3426d.put(str, drVar);
    }
}
