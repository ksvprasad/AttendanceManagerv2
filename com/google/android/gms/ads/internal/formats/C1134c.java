package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.p031b.df.C1133a;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;

@id
public class C1134c extends C1133a {
    private final Drawable f3316a;
    private final Uri f3317b;
    private final double f3318c;

    public C1134c(Drawable drawable, Uri uri, double d) {
        this.f3316a = drawable;
        this.f3317b = uri;
        this.f3318c = d;
    }

    public C0998a mo1051a() {
        return C1001b.m5713a(this.f3316a);
    }

    public Uri mo1052b() {
        return this.f3317b;
    }

    public double mo1053c() {
        return this.f3318c;
    }
}
