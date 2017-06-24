package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1109u implements Creator<AdSizeParcel> {
    static void m6242a(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, adSizeParcel.f3103a);
        C1938b.m10942a(parcel, 2, adSizeParcel.f3104b, false);
        C1938b.m10933a(parcel, 3, adSizeParcel.f3105c);
        C1938b.m10933a(parcel, 4, adSizeParcel.f3106d);
        C1938b.m10944a(parcel, 5, adSizeParcel.f3107e);
        C1938b.m10933a(parcel, 6, adSizeParcel.f3108f);
        C1938b.m10933a(parcel, 7, adSizeParcel.f3109g);
        C1938b.m10947a(parcel, 8, adSizeParcel.f3110h, i, false);
        C1938b.m10944a(parcel, 9, adSizeParcel.f3111i);
        C1938b.m10944a(parcel, 10, adSizeParcel.f3112j);
        C1938b.m10944a(parcel, 11, adSizeParcel.f3113k);
        C1938b.m10931a(parcel, a);
    }

    public AdSizeParcel m6243a(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int b = C1937a.m10910b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i5 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    i4 = C1937a.m10915d(parcel, a);
                    break;
                case 4:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 5:
                    z4 = C1937a.m10914c(parcel, a);
                    break;
                case 6:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 7:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) C1937a.m10912b(parcel, a, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z3 = C1937a.m10914c(parcel, a);
                    break;
                case 10:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 11:
                    z = C1937a.m10914c(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AdSizeParcel[] m6244a(int i) {
        return new AdSizeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6243a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6244a(i);
    }
}
