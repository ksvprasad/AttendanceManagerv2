package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1099k implements Creator<SearchAdRequestParcel> {
    static void m6212a(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, searchAdRequestParcel.f3114a);
        C1938b.m10933a(parcel, 2, searchAdRequestParcel.f3115b);
        C1938b.m10933a(parcel, 3, searchAdRequestParcel.f3116c);
        C1938b.m10933a(parcel, 4, searchAdRequestParcel.f3117d);
        C1938b.m10933a(parcel, 5, searchAdRequestParcel.f3118e);
        C1938b.m10933a(parcel, 6, searchAdRequestParcel.f3119f);
        C1938b.m10933a(parcel, 7, searchAdRequestParcel.f3120g);
        C1938b.m10933a(parcel, 8, searchAdRequestParcel.f3121h);
        C1938b.m10933a(parcel, 9, searchAdRequestParcel.f3122i);
        C1938b.m10942a(parcel, 10, searchAdRequestParcel.f3123j, false);
        C1938b.m10933a(parcel, 11, searchAdRequestParcel.f3124k);
        C1938b.m10942a(parcel, 12, searchAdRequestParcel.f3125l, false);
        C1938b.m10933a(parcel, 13, searchAdRequestParcel.f3126m);
        C1938b.m10933a(parcel, 14, searchAdRequestParcel.f3127n);
        C1938b.m10942a(parcel, 15, searchAdRequestParcel.f3128o, false);
        C1938b.m10931a(parcel, a);
    }

    public SearchAdRequestParcel m6213a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 3:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 4:
                    i4 = C1937a.m10915d(parcel, a);
                    break;
                case 5:
                    i5 = C1937a.m10915d(parcel, a);
                    break;
                case 6:
                    i6 = C1937a.m10915d(parcel, a);
                    break;
                case 7:
                    i7 = C1937a.m10915d(parcel, a);
                    break;
                case 8:
                    i8 = C1937a.m10915d(parcel, a);
                    break;
                case 9:
                    i9 = C1937a.m10915d(parcel, a);
                    break;
                case 10:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 11:
                    i10 = C1937a.m10915d(parcel, a);
                    break;
                case 12:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 13:
                    i11 = C1937a.m10915d(parcel, a);
                    break;
                case 14:
                    i12 = C1937a.m10915d(parcel, a);
                    break;
                case 15:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public SearchAdRequestParcel[] m6214a(int i) {
        return new SearchAdRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m6213a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m6214a(i);
    }
}
