package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1291o implements Creator<StringParcel> {
    static void m7032a(StringParcel stringParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, stringParcel.f3819a);
        C1938b.m10942a(parcel, 2, stringParcel.f3820b, false);
        C1938b.m10931a(parcel, a);
    }

    public StringParcel m7033a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    str = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StringParcel(i, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public StringParcel[] m7034a(int i) {
        return new StringParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7033a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7034a(i);
    }
}
