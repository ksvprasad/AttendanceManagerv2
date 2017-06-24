package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1900g;
import com.google.android.gms.common.util.C1981n;

public final class C2113b {
    private final String f7075a;
    private final String f7076b;
    private final String f7077c;
    private final String f7078d;
    private final String f7079e;
    private final String f7080f;

    private C2113b(String str, String str2, String str3, String str4, String str5, String str6) {
        C1896c.m10795a(!C1981n.m11122a(str), (Object) "ApplicationId must be set.");
        this.f7076b = str;
        this.f7075a = str2;
        this.f7077c = str3;
        this.f7078d = str4;
        this.f7079e = str5;
        this.f7080f = str6;
    }

    public static C2113b m12103a(Context context) {
        C1900g c1900g = new C1900g(context);
        Object a = c1900g.m10812a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new C2113b(a, c1900g.m10812a("google_api_key"), c1900g.m10812a("firebase_database_url"), c1900g.m10812a("ga_trackingId"), c1900g.m10812a("gcm_defaultSenderId"), c1900g.m10812a("google_storage_bucket"));
    }

    public String m12104a() {
        return this.f7076b;
    }

    public String m12105b() {
        return this.f7079e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2113b)) {
            return false;
        }
        C2113b c2113b = (C2113b) obj;
        return C1895b.m10789a(this.f7076b, c2113b.f7076b) && C1895b.m10789a(this.f7075a, c2113b.f7075a) && C1895b.m10789a(this.f7077c, c2113b.f7077c) && C1895b.m10789a(this.f7078d, c2113b.f7078d) && C1895b.m10789a(this.f7079e, c2113b.f7079e) && C1895b.m10789a(this.f7080f, c2113b.f7080f);
    }

    public int hashCode() {
        return C1895b.m10787a(this.f7076b, this.f7075a, this.f7077c, this.f7078d, this.f7079e, this.f7080f);
    }

    public String toString() {
        return C1895b.m10788a((Object) this).m10786a("applicationId", this.f7076b).m10786a("apiKey", this.f7075a).m10786a("databaseUrl", this.f7077c).m10786a("gcmSenderId", this.f7079e).m10786a("storageBucket", this.f7080f).toString();
    }
}
