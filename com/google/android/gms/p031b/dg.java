package com.google.android.gms.p031b;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p032b.C1013a.C1012a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@id
public class dg extends C1012a {
    private final df f4454a;
    private final Drawable f4455b;
    private final Uri f4456c;
    private final double f4457d;

    public dg(df dfVar) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.f4454a = dfVar;
        try {
            C0998a a = this.f4454a.mo1051a();
            if (a != null) {
                drawable = (Drawable) C1001b.m5714a(a);
                this.f4455b = drawable;
                uri = this.f4454a.mo1052b();
                this.f4456c = uri;
                d = 1.0d;
                d = this.f4454a.mo1053c();
                this.f4457d = d;
            }
        } catch (Throwable e) {
            C1324b.m7231b("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.f4455b = drawable;
        try {
            uri = this.f4454a.mo1052b();
        } catch (Throwable e2) {
            C1324b.m7231b("Failed to get uri.", e2);
        }
        this.f4456c = uri;
        d = 1.0d;
        try {
            d = this.f4454a.mo1053c();
        } catch (Throwable e3) {
            C1324b.m7231b("Failed to get scale.", e3);
        }
        this.f4457d = d;
    }

    public Drawable mo1281a() {
        return this.f4455b;
    }

    public Uri mo1282b() {
        return this.f4456c;
    }

    public double mo1283c() {
        return this.f4457d;
    }
}
