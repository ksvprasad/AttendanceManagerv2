package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@id
public final class bs {
    private final String f4250a;
    private final JSONObject f4251b;
    private final String f4252c;
    private final String f4253d;
    private final boolean f4254e;
    private final boolean f4255f;

    public bs(String str, VersionInfoParcel versionInfoParcel, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.f4253d = versionInfoParcel.f3957b;
        this.f4251b = jSONObject;
        this.f4252c = str;
        this.f4250a = str2;
        this.f4254e = z;
        this.f4255f = z2;
    }

    public String m7648a() {
        return this.f4250a;
    }

    public String m7649b() {
        return this.f4253d;
    }

    public JSONObject m7650c() {
        return this.f4251b;
    }

    public String m7651d() {
        return this.f4252c;
    }

    public boolean m7652e() {
        return this.f4254e;
    }

    public boolean m7653f() {
        return this.f4255f;
    }
}
