package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1276j implements Creator<CapabilityParcel> {
    static void m7000a(CapabilityParcel capabilityParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, capabilityParcel.f3808a);
        C1938b.m10944a(parcel, 2, capabilityParcel.f3809b);
        C1938b.m10944a(parcel, 3, capabilityParcel.f3810c);
        C1938b.m10944a(parcel, 4, capabilityParcel.f3811d);
        C1938b.m10931a(parcel, a);
    }

    public CapabilityParcel m7001a(Parcel parcel) {
        boolean z = false;
        int b = C1937a.m10910b(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    z3 = C1937a.m10914c(parcel, a);
                    break;
                case 3:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 4:
                    z = C1937a.m10914c(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CapabilityParcel(i, z3, z2, z);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public CapabilityParcel[] m7002a(int i) {
        return new CapabilityParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m7001a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m7002a(i);
    }
}
