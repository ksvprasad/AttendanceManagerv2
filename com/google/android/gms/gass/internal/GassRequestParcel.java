package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GassRequestParcel extends AbstractSafeParcelable {
    public static final Creator<GassRequestParcel> CREATOR = new C1999c();
    public final int f6633a;
    public final String f6634b;
    public final String f6635c;

    GassRequestParcel(int i, String str, String str2) {
        this.f6633a = i;
        this.f6634b = str;
        this.f6635c = str2;
    }

    public GassRequestParcel(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1999c.m11168a(this, parcel, i);
    }
}
