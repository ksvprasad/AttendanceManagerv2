package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1307h implements Creator<RewardedVideoAdRequestParcel> {
    static void m7092a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, rewardedVideoAdRequestParcel.f3898a);
        C1938b.m10937a(parcel, 2, rewardedVideoAdRequestParcel.f3899b, i, false);
        C1938b.m10942a(parcel, 3, rewardedVideoAdRequestParcel.f3900c, false);
        C1938b.m10931a(parcel, a);
    }

    public RewardedVideoAdRequestParcel m7093a(Parcel parcel) {
        String str = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        AdRequestParcel adRequestParcel = null;
        while (parcel.dataPosition() < b) {
            AdRequestParcel adRequestParcel2;
            int d;
            String str2;
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    String str3 = str;
                    adRequestParcel2 = adRequestParcel;
                    d = C1937a.m10915d(parcel, a);
                    str2 = str3;
                    break;
                case 2:
                    d = i;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) C1937a.m10907a(parcel, a, AdRequestParcel.CREATOR);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel3;
                    break;
                case 3:
                    str2 = C1937a.m10922k(parcel, a);
                    adRequestParcel2 = adRequestParcel;
                    d = i;
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    str2 = str;
                    adRequestParcel2 = adRequestParcel;
                    d = i;
                    break;
            }
            i = d;
            adRequestParcel = adRequestParcel2;
            str = str2;
        }
        if (parcel.dataPosition() == b) {
            return new RewardedVideoAdRequestParcel(i, adRequestParcel, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public RewardedVideoAdRequestParcel[] m7094a(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7093a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7094a(i);
    }
}
