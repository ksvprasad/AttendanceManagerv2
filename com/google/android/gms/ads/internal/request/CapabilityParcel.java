package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public class CapabilityParcel extends AbstractSafeParcelable {
    public static final Creator<CapabilityParcel> CREATOR = new C1276j();
    public final int f3808a;
    public final boolean f3809b;
    public final boolean f3810c;
    public final boolean f3811d;

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        this.f3808a = i;
        this.f3809b = z;
        this.f3810c = z2;
        this.f3811d = z3;
    }

    public CapabilityParcel(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public Bundle m6891a() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.f3809b);
        bundle.putBoolean("default_iap_supported", this.f3810c);
        bundle.putBoolean("app_streaming_supported", this.f3811d);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1276j.m7000a(this, parcel, i);
    }
}
