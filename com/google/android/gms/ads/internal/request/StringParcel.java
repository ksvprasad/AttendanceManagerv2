package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public class StringParcel extends AbstractSafeParcelable {
    public static final Creator<StringParcel> CREATOR = new C1291o();
    final int f3819a;
    String f3820b;

    StringParcel(int i, String str) {
        this.f3819a = i;
        this.f3820b = str;
    }

    public StringParcel(String str) {
        this.f3819a = 1;
        this.f3820b = str;
    }

    public String m6894a() {
        return this.f3820b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1291o.m7032a(this, parcel, i);
    }
}
