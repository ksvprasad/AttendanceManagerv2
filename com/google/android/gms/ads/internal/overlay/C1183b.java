package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1183b implements Creator<AdLauncherIntentInfoParcel> {
    static void m6597a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, adLauncherIntentInfoParcel.f3465a);
        C1938b.m10942a(parcel, 2, adLauncherIntentInfoParcel.f3466b, false);
        C1938b.m10942a(parcel, 3, adLauncherIntentInfoParcel.f3467c, false);
        C1938b.m10942a(parcel, 4, adLauncherIntentInfoParcel.f3468d, false);
        C1938b.m10942a(parcel, 5, adLauncherIntentInfoParcel.f3469e, false);
        C1938b.m10942a(parcel, 6, adLauncherIntentInfoParcel.f3470f, false);
        C1938b.m10942a(parcel, 7, adLauncherIntentInfoParcel.f3471g, false);
        C1938b.m10942a(parcel, 8, adLauncherIntentInfoParcel.f3472h, false);
        C1938b.m10937a(parcel, 9, adLauncherIntentInfoParcel.f3473i, i, false);
        C1938b.m10931a(parcel, a);
    }

    public AdLauncherIntentInfoParcel m6598a(Parcel parcel) {
        Intent intent = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str7 = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    str6 = C1937a.m10922k(parcel, a);
                    break;
                case 4:
                    str5 = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    str4 = C1937a.m10922k(parcel, a);
                    break;
                case 6:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 7:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 8:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 9:
                    intent = (Intent) C1937a.m10907a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdLauncherIntentInfoParcel(i, str7, str6, str5, str4, str3, str2, str, intent);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AdLauncherIntentInfoParcel[] m6599a(int i) {
        return new AdLauncherIntentInfoParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6598a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6599a(i);
    }
}
