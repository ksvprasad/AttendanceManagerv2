package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1312c implements Creator<RewardItemParcel> {
    static void m7127a(RewardItemParcel rewardItemParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, rewardItemParcel.f3907a);
        C1938b.m10942a(parcel, 2, rewardItemParcel.f3908b, false);
        C1938b.m10933a(parcel, 3, rewardItemParcel.f3909c);
        C1938b.m10931a(parcel, a);
    }

    public RewardItemParcel m7128a(Parcel parcel) {
        int i = 0;
        int b = C1937a.m10910b(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    i = C1937a.m10915d(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new RewardItemParcel(i2, str, i);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public RewardItemParcel[] m7129a(int i) {
        return new RewardItemParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7128a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7129a(i);
    }
}
