package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2094w implements Creator<EventParcel> {
    static void m11969a(EventParcel eventParcel, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, eventParcel.f6672a);
        C1938b.m10942a(parcel, 2, eventParcel.f6673b, false);
        C1938b.m10937a(parcel, 3, eventParcel.f6674c, i, false);
        C1938b.m10942a(parcel, 4, eventParcel.f6675d, false);
        C1938b.m10934a(parcel, 5, eventParcel.f6676e);
        C1938b.m10931a(parcel, a);
    }

    public EventParcel m11970a(Parcel parcel) {
        String str = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
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
                    eventParams = (EventParams) C1937a.m10907a(parcel, a, EventParams.CREATOR);
                    break;
                case 4:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    j = C1937a.m10917f(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public EventParcel[] m11971a(int i) {
        return new EventParcel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m11970a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m11971a(i);
    }
}
