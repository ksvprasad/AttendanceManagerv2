package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AppMetadata extends AbstractSafeParcelable {
    public static final C2083n CREATOR = new C2083n();
    public final int f6656a;
    public final String f6657b;
    public final String f6658c;
    public final String f6659d;
    public final String f6660e;
    public final long f6661f;
    public final long f6662g;
    public final String f6663h;
    public final boolean f6664i;
    public final boolean f6665j;
    public final long f6666k;
    public final String f6667l;

    AppMetadata(int i, String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6) {
        this.f6656a = i;
        this.f6657b = str;
        this.f6658c = str2;
        this.f6659d = str3;
        if (i < 5) {
            j3 = -2147483648L;
        }
        this.f6666k = j3;
        this.f6660e = str4;
        this.f6661f = j;
        this.f6662g = j2;
        this.f6663h = str5;
        if (i >= 3) {
            this.f6664i = z;
        } else {
            this.f6664i = true;
        }
        this.f6665j = z2;
        this.f6667l = str6;
    }

    AppMetadata(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6) {
        C1896c.m10792a(str);
        this.f6656a = 6;
        this.f6657b = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.f6658c = str2;
        this.f6659d = str3;
        this.f6666k = j;
        this.f6660e = str4;
        this.f6661f = j2;
        this.f6662g = j3;
        this.f6663h = str5;
        this.f6664i = z;
        this.f6665j = z2;
        this.f6667l = str6;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2083n.m11807a(this, parcel, i);
    }
}
