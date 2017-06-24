package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2093v implements Creator<EventParams> {
    static void m11966a(EventParams eventParams, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, eventParams.f6670a);
        C1938b.m10935a(parcel, 2, eventParams.m11200b(), false);
        C1938b.m10931a(parcel, a);
    }

    public EventParams m11967a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    bundle = C1937a.m10924m(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParams(i, bundle);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public EventParams[] m11968a(int i) {
        return new EventParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11967a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11968a(i);
    }
}
