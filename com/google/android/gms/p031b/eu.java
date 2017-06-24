package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.C1173l;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@id
public class eu {
    private Context f4572a;
    private final fx f4573b;
    private final VersionInfoParcel f4574c;
    private final C1122d f4575d;

    eu(Context context, fx fxVar, VersionInfoParcel versionInfoParcel, C1122d c1122d) {
        this.f4572a = context;
        this.f4573b = fxVar;
        this.f4574c = versionInfoParcel;
        this.f4575d = c1122d;
    }

    public Context m8080a() {
        return this.f4572a.getApplicationContext();
    }

    public C1173l m8081a(String str) {
        return new C1173l(this.f4572a, new AdSizeParcel(), str, this.f4573b, this.f4574c, this.f4575d);
    }

    public C1173l m8082b(String str) {
        return new C1173l(this.f4572a.getApplicationContext(), new AdSizeParcel(), str, this.f4573b, this.f4574c, this.f4575d);
    }

    public eu m8083b() {
        return new eu(m8080a(), this.f4573b, this.f4574c, this.f4575d);
    }
}
