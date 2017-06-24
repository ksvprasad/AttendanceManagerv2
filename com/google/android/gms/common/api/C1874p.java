package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1874p implements Creator<Scope> {
    static void m10599a(Scope scope, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, scope.f6331a);
        C1938b.m10942a(parcel, 2, scope.m10558a(), false);
        C1938b.m10931a(parcel, a);
    }

    public Scope m10600a(Parcel parcel) {
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
            return new Scope(i, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public Scope[] m10601a(int i) {
        return new Scope[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10600a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10601a(i);
    }
}
