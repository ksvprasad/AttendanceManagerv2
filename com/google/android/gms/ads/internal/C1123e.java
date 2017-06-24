package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl.C1632a;

@id
public class C1123e {
    private final Context f3286a;
    private final AutoClickProtectionConfigurationParcel f3287b;
    private boolean f3288c;

    public C1123e(Context context) {
        this(context, false);
    }

    public C1123e(Context context, C1632a c1632a) {
        this.f3286a = context;
        if (c1632a == null || c1632a.f5409b.f3771G == null) {
            this.f3287b = new AutoClickProtectionConfigurationParcel();
        } else {
            this.f3287b = c1632a.f5409b.f3771G;
        }
    }

    public C1123e(Context context, boolean z) {
        this.f3286a = context;
        this.f3287b = new AutoClickProtectionConfigurationParcel(z);
    }

    public void m6299a() {
        this.f3288c = true;
    }

    public void m6300a(String str) {
        if (str == null) {
            str = "";
        }
        C1324b.m7232c("Action was blocked because no touch was detected.");
        if (this.f3287b.f3806b && this.f3287b.f3807c != null) {
            for (String str2 : this.f3287b.f3807c) {
                if (!TextUtils.isEmpty(str2)) {
                    C1319u.m7183e().m9216a(this.f3286a, "", str2.replace("{NAVIGATION_URL}", Uri.encode(str)));
                }
            }
        }
    }

    public boolean m6301b() {
        return !this.f3287b.f3806b || this.f3288c;
    }
}
