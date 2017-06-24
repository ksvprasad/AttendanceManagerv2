package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2100a implements Creator<AuthAccountResult> {
    static void m12031a(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, authAccountResult.f7039a);
        C1938b.m10933a(parcel, 2, authAccountResult.m12023b());
        C1938b.m10937a(parcel, 3, authAccountResult.m12024c(), i, false);
        C1938b.m10931a(parcel, a);
    }

    public AuthAccountResult m12032a(Parcel parcel) {
        int i = 0;
        int b = C1937a.m10910b(parcel);
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 3:
                    intent = (Intent) C1937a.m10907a(parcel, a, Intent.CREATOR);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountResult(i2, i, intent);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountResult[] m12033a(int i) {
        return new AuthAccountResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12032a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12033a(i);
    }
}
