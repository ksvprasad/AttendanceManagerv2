package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2080k implements Creator<UserAttributeParcel> {
    static void m11731a(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, userAttributeParcel.f6677a);
        C1938b.m10942a(parcel, 2, userAttributeParcel.f6678b, false);
        C1938b.m10934a(parcel, 3, userAttributeParcel.f6679c);
        C1938b.m10941a(parcel, 4, userAttributeParcel.f6680d, false);
        C1938b.m10939a(parcel, 5, userAttributeParcel.f6681e, false);
        C1938b.m10942a(parcel, 6, userAttributeParcel.f6682f, false);
        C1938b.m10942a(parcel, 7, userAttributeParcel.f6683g, false);
        C1938b.m10938a(parcel, 8, userAttributeParcel.f6684h, false);
        C1938b.m10931a(parcel, a);
    }

    public UserAttributeParcel m11732a(Parcel parcel) {
        Double d = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str3 = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    j = C1937a.m10917f(parcel, a);
                    break;
                case 4:
                    l = C1937a.m10918g(parcel, a);
                    break;
                case 5:
                    f = C1937a.m10920i(parcel, a);
                    break;
                case 6:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 7:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 8:
                    d = C1937a.m10921j(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str, d);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public UserAttributeParcel[] m11733a(int i) {
        return new UserAttributeParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11732a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11733a(i);
    }
}
