package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.C1329j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public class VideoOptionsParcel extends AbstractSafeParcelable {
    public static final C1101m CREATOR = new C1101m();
    public final int f3129a;
    public final boolean f3130b;

    public VideoOptionsParcel(int i, boolean z) {
        this.f3129a = i;
        this.f3130b = z;
    }

    public VideoOptionsParcel(C1329j c1329j) {
        this(1, c1329j.m7256a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1101m.m6219a(this, parcel, i);
    }
}
