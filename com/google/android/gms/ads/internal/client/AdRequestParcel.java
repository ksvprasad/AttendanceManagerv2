package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;
import java.util.List;

@id
public final class AdRequestParcel extends AbstractSafeParcelable {
    public static final C1107s CREATOR = new C1107s();
    public final int f3085a;
    public final long f3086b;
    public final Bundle f3087c;
    public final int f3088d;
    public final List<String> f3089e;
    public final boolean f3090f;
    public final int f3091g;
    public final boolean f3092h;
    public final String f3093i;
    public final SearchAdRequestParcel f3094j;
    public final Location f3095k;
    public final String f3096l;
    public final Bundle f3097m;
    public final Bundle f3098n;
    public final List<String> f3099o;
    public final String f3100p;
    public final String f3101q;
    public final boolean f3102r;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.f3085a = i;
        this.f3086b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f3087c = bundle;
        this.f3088d = i2;
        this.f3089e = list;
        this.f3090f = z;
        this.f3091g = i3;
        this.f3092h = z2;
        this.f3093i = str;
        this.f3094j = searchAdRequestParcel;
        this.f3095k = location;
        this.f3096l = str2;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        this.f3097m = bundle2;
        this.f3098n = bundle3;
        this.f3099o = list2;
        this.f3100p = str3;
        this.f3101q = str4;
        this.f3102r = z3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.f3085a == adRequestParcel.f3085a && this.f3086b == adRequestParcel.f3086b && C1895b.m10789a(this.f3087c, adRequestParcel.f3087c) && this.f3088d == adRequestParcel.f3088d && C1895b.m10789a(this.f3089e, adRequestParcel.f3089e) && this.f3090f == adRequestParcel.f3090f && this.f3091g == adRequestParcel.f3091g && this.f3092h == adRequestParcel.f3092h && C1895b.m10789a(this.f3093i, adRequestParcel.f3093i) && C1895b.m10789a(this.f3094j, adRequestParcel.f3094j) && C1895b.m10789a(this.f3095k, adRequestParcel.f3095k) && C1895b.m10789a(this.f3096l, adRequestParcel.f3096l) && C1895b.m10789a(this.f3097m, adRequestParcel.f3097m) && C1895b.m10789a(this.f3098n, adRequestParcel.f3098n) && C1895b.m10789a(this.f3099o, adRequestParcel.f3099o) && C1895b.m10789a(this.f3100p, adRequestParcel.f3100p) && C1895b.m10789a(this.f3101q, adRequestParcel.f3101q) && this.f3102r == adRequestParcel.f3102r;
    }

    public int hashCode() {
        return C1895b.m10787a(Integer.valueOf(this.f3085a), Long.valueOf(this.f3086b), this.f3087c, Integer.valueOf(this.f3088d), this.f3089e, Boolean.valueOf(this.f3090f), Integer.valueOf(this.f3091g), Boolean.valueOf(this.f3092h), this.f3093i, this.f3094j, this.f3095k, this.f3096l, this.f3097m, this.f3098n, this.f3099o, this.f3100p, this.f3101q, Boolean.valueOf(this.f3102r));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1107s.m6237a(this, parcel, i);
    }
}
