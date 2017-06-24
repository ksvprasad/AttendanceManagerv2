package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2000d implements Creator<GassResponseParcel> {
    static void m11171a(GassResponseParcel gassResponseParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, gassResponseParcel.f6636a);
        C1938b.m10945a(parcel, 2, gassResponseParcel.m11152a(), false);
        C1938b.m10931a(parcel, a);
    }

    public GassResponseParcel m11172a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    bArr = C1937a.m10925n(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GassResponseParcel(i, bArr);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public GassResponseParcel[] m11173a(int i) {
        return new GassResponseParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11172a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11173a(i);
    }
}
