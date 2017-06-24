package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.p032b.C1016b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public class NativeAdOptionsParcel extends AbstractSafeParcelable {
    public static final C1156j CREATOR = new C1156j();
    public final int f3297a;
    public final boolean f3298b;
    public final int f3299c;
    public final boolean f3300d;
    public final int f3301e;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2, int i3) {
        this.f3297a = i;
        this.f3298b = z;
        this.f3299c = i2;
        this.f3300d = z2;
        this.f3301e = i3;
    }

    public NativeAdOptionsParcel(C1016b c1016b) {
        this(2, c1016b.m5746a(), c1016b.m5747b(), c1016b.m5748c(), c1016b.m5749d());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1156j.m6452a(this, parcel, i);
    }
}
