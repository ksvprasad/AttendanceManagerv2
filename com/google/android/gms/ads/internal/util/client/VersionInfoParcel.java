package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final C1326d CREATOR = new C1326d();
    public final int f3956a;
    public String f3957b;
    public int f3958c;
    public int f3959d;
    public boolean f3960e;

    public VersionInfoParcel(int i, int i2, boolean z) {
        this(i, i2, z, false);
    }

    public VersionInfoParcel(int i, int i2, boolean z, boolean z2) {
        String valueOf = String.valueOf("afma-sdk-a-v");
        String str = z ? "0" : z2 ? "2" : "1";
        this(1, new StringBuilder((String.valueOf(valueOf).length() + 24) + String.valueOf(str).length()).append(valueOf).append(i).append(".").append(i2).append(".").append(str).toString(), i, i2, z);
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.f3956a = i;
        this.f3957b = str;
        this.f3958c = i2;
        this.f3959d = i3;
        this.f3960e = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1326d.m7237a(this, parcel, i);
    }
}
