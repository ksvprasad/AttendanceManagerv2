package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1999c implements Creator<GassRequestParcel> {
    static void m11168a(GassRequestParcel gassRequestParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, gassRequestParcel.f6633a);
        C1938b.m10942a(parcel, 2, gassRequestParcel.f6634b, false);
        C1938b.m10942a(parcel, 3, gassRequestParcel.f6635c, false);
        C1938b.m10931a(parcel, a);
    }

    public GassRequestParcel m11169a(Parcel parcel) {
        String str = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str2 = C1937a.m10922k(parcel, a);
                    break;
                case 3:
                    str = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GassRequestParcel(i, str2, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public GassRequestParcel[] m11170a(int i) {
        return new GassRequestParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11169a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11170a(i);
    }
}
