package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;

@id
public final class RewardedVideoAdRequestParcel extends AbstractSafeParcelable {
    public static final C1307h CREATOR = new C1307h();
    public final int f3898a;
    public final AdRequestParcel f3899b;
    public final String f3900c;

    public RewardedVideoAdRequestParcel(int i, AdRequestParcel adRequestParcel, String str) {
        this.f3898a = i;
        this.f3899b = adRequestParcel;
        this.f3900c = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1307h.m7092a(this, parcel, i);
    }
}
