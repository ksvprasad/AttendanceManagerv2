package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.p036e.C1030a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public final class SearchAdRequestParcel extends AbstractSafeParcelable {
    public static final C1099k CREATOR = new C1099k();
    public final int f3114a;
    public final int f3115b;
    public final int f3116c;
    public final int f3117d;
    public final int f3118e;
    public final int f3119f;
    public final int f3120g;
    public final int f3121h;
    public final int f3122i;
    public final String f3123j;
    public final int f3124k;
    public final String f3125l;
    public final int f3126m;
    public final int f3127n;
    public final String f3128o;

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.f3114a = i;
        this.f3115b = i2;
        this.f3116c = i3;
        this.f3117d = i4;
        this.f3118e = i5;
        this.f3119f = i6;
        this.f3120g = i7;
        this.f3121h = i8;
        this.f3122i = i9;
        this.f3123j = str;
        this.f3124k = i10;
        this.f3125l = str2;
        this.f3126m = i11;
        this.f3127n = i12;
        this.f3128o = str3;
    }

    public SearchAdRequestParcel(C1030a c1030a) {
        this.f3114a = 1;
        this.f3115b = c1030a.m5806a();
        this.f3116c = c1030a.m5807b();
        this.f3117d = c1030a.m5808c();
        this.f3118e = c1030a.m5809d();
        this.f3119f = c1030a.m5810e();
        this.f3120g = c1030a.m5811f();
        this.f3121h = c1030a.m5812g();
        this.f3122i = c1030a.m5813h();
        this.f3123j = c1030a.m5814i();
        this.f3124k = c1030a.m5815j();
        this.f3125l = c1030a.m5816k();
        this.f3126m = c1030a.m5817l();
        this.f3127n = c1030a.m5818m();
        this.f3128o = c1030a.m5819n();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1099k.m6212a(this, parcel, i);
    }
}
