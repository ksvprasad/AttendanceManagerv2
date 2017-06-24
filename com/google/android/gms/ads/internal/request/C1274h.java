package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C1274h implements Creator<AdResponseParcel> {
    static void m6994a(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, adResponseParcel.f3779a);
        C1938b.m10942a(parcel, 2, adResponseParcel.f3780b, false);
        C1938b.m10942a(parcel, 3, adResponseParcel.f3781c, false);
        C1938b.m10943a(parcel, 4, adResponseParcel.f3782d, false);
        C1938b.m10933a(parcel, 5, adResponseParcel.f3783e);
        C1938b.m10943a(parcel, 6, adResponseParcel.f3784f, false);
        C1938b.m10934a(parcel, 7, adResponseParcel.f3785g);
        C1938b.m10944a(parcel, 8, adResponseParcel.f3786h);
        C1938b.m10934a(parcel, 9, adResponseParcel.f3787i);
        C1938b.m10943a(parcel, 10, adResponseParcel.f3788j, false);
        C1938b.m10934a(parcel, 11, adResponseParcel.f3789k);
        C1938b.m10933a(parcel, 12, adResponseParcel.f3790l);
        C1938b.m10942a(parcel, 13, adResponseParcel.f3791m, false);
        C1938b.m10934a(parcel, 14, adResponseParcel.f3792n);
        C1938b.m10942a(parcel, 15, adResponseParcel.f3793o, false);
        C1938b.m10944a(parcel, 18, adResponseParcel.f3794p);
        C1938b.m10942a(parcel, 19, adResponseParcel.f3795q, false);
        C1938b.m10942a(parcel, 21, adResponseParcel.f3796r, false);
        C1938b.m10944a(parcel, 22, adResponseParcel.f3797s);
        C1938b.m10944a(parcel, 23, adResponseParcel.f3798t);
        C1938b.m10944a(parcel, 24, adResponseParcel.f3799u);
        C1938b.m10944a(parcel, 25, adResponseParcel.f3800v);
        C1938b.m10944a(parcel, 26, adResponseParcel.f3801w);
        C1938b.m10937a(parcel, 28, adResponseParcel.f3802x, i, false);
        C1938b.m10942a(parcel, 29, adResponseParcel.f3803y, false);
        C1938b.m10942a(parcel, 30, adResponseParcel.f3804z, false);
        C1938b.m10944a(parcel, 31, adResponseParcel.f3765A);
        C1938b.m10944a(parcel, 32, adResponseParcel.f3766B);
        C1938b.m10937a(parcel, 33, adResponseParcel.f3767C, i, false);
        C1938b.m10943a(parcel, 34, adResponseParcel.f3768D, false);
        C1938b.m10943a(parcel, 35, adResponseParcel.f3769E, false);
        C1938b.m10944a(parcel, 36, adResponseParcel.f3770F);
        C1938b.m10937a(parcel, 37, adResponseParcel.f3771G, i, false);
        C1938b.m10944a(parcel, 38, adResponseParcel.f3772H);
        C1938b.m10942a(parcel, 39, adResponseParcel.f3773I, false);
        C1938b.m10943a(parcel, 40, adResponseParcel.f3774J, false);
        C1938b.m10942a(parcel, 41, adResponseParcel.f3775K, false);
        C1938b.m10944a(parcel, 42, adResponseParcel.f3776L);
        C1938b.m10942a(parcel, 43, adResponseParcel.f3777M, false);
        C1938b.m10931a(parcel, a);
    }

    public AdResponseParcel m6995a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        RewardItemParcel rewardItemParcel = null;
        List list4 = null;
        List list5 = null;
        boolean z10 = false;
        AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel = null;
        boolean z11 = false;
        String str9 = null;
        List list6 = null;
        String str10 = null;
        boolean z12 = false;
        String str11 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 4:
                    list = C1937a.m10929r(parcel, a);
                    break;
                case 5:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 6:
                    list2 = C1937a.m10929r(parcel, a);
                    break;
                case 7:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 8:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 9:
                    j2 = C1937a.m10917f(parcel, a);
                    break;
                case 10:
                    list3 = C1937a.m10929r(parcel, a);
                    break;
                case 11:
                    j3 = C1937a.m10917f(parcel, a);
                    break;
                case 12:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 13:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 14:
                    j4 = C1937a.m10917f(parcel, a);
                    break;
                case 15:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 18:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 19:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                case 21:
                    str6 = C1937a.m10922k(parcel, a);
                    break;
                case 22:
                    z3 = C1937a.m10914c(parcel, a);
                    break;
                case 23:
                    z4 = C1937a.m10914c(parcel, a);
                    break;
                case 24:
                    z5 = C1937a.m10914c(parcel, a);
                    break;
                case 25:
                    z6 = C1937a.m10914c(parcel, a);
                    break;
                case 26:
                    z7 = C1937a.m10914c(parcel, a);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) C1937a.m10907a(parcel, a, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = C1937a.m10922k(parcel, a);
                    break;
                case 30:
                    str8 = C1937a.m10922k(parcel, a);
                    break;
                case 31:
                    z8 = C1937a.m10914c(parcel, a);
                    break;
                case 32:
                    z9 = C1937a.m10914c(parcel, a);
                    break;
                case 33:
                    rewardItemParcel = (RewardItemParcel) C1937a.m10907a(parcel, a, (Creator) RewardItemParcel.CREATOR);
                    break;
                case 34:
                    list4 = C1937a.m10929r(parcel, a);
                    break;
                case 35:
                    list5 = C1937a.m10929r(parcel, a);
                    break;
                case 36:
                    z10 = C1937a.m10914c(parcel, a);
                    break;
                case 37:
                    autoClickProtectionConfigurationParcel = (AutoClickProtectionConfigurationParcel) C1937a.m10907a(parcel, a, (Creator) AutoClickProtectionConfigurationParcel.CREATOR);
                    break;
                case 38:
                    z11 = C1937a.m10914c(parcel, a);
                    break;
                case 39:
                    str9 = C1937a.m10922k(parcel, a);
                    break;
                case 40:
                    list6 = C1937a.m10929r(parcel, a);
                    break;
                case 41:
                    str10 = C1937a.m10922k(parcel, a);
                    break;
                case 42:
                    z12 = C1937a.m10914c(parcel, a);
                    break;
                case 43:
                    str11 = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdResponseParcel(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, largeParcelTeleporter, str7, str8, z8, z9, rewardItemParcel, list4, list5, z10, autoClickProtectionConfigurationParcel, z11, str9, list6, str10, z12, str11);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AdResponseParcel[] m6996a(int i) {
        return new AdResponseParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6995a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6996a(i);
    }
}
