package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import com.google.android.gms.p031b.id;

@id
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel adSizeParcel) {
        super(adSizeParcel.f3103a, adSizeParcel.f3104b, adSizeParcel.f3105c, adSizeParcel.f3106d, adSizeParcel.f3107e, adSizeParcel.f3108f, adSizeParcel.f3109g, adSizeParcel.f3110h, adSizeParcel.f3111i, adSizeParcel.f3112j, adSizeParcel.f3113k);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, this.a);
        C1938b.m10942a(parcel, 2, this.b, false);
        C1938b.m10933a(parcel, 3, this.c);
        C1938b.m10933a(parcel, 6, this.f);
        C1938b.m10931a(parcel, a);
    }
}
