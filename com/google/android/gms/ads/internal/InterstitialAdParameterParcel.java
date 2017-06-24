package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public final class InterstitialAdParameterParcel extends AbstractSafeParcelable {
    public static final C1174m CREATOR = new C1174m();
    public final int f3048a;
    public final boolean f3049b;
    public final boolean f3050c;
    public final String f3051d;
    public final boolean f3052e;
    public final float f3053f;
    public final int f3054g;

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f, int i2) {
        this.f3048a = i;
        this.f3049b = z;
        this.f3050c = z2;
        this.f3051d = str;
        this.f3052e = z3;
        this.f3053f = f;
        this.f3054g = i2;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2, boolean z3, float f, int i) {
        this(3, z, z2, null, z3, f, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1174m.m6548a(this, parcel, i);
    }
}
