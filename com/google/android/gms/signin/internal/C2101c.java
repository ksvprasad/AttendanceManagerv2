package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;
import java.util.List;

public class C2101c implements Creator<CheckServerAuthResult> {
    static void m12034a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, checkServerAuthResult.f7042a);
        C1938b.m10944a(parcel, 2, checkServerAuthResult.f7043b);
        C1938b.m10953b(parcel, 3, checkServerAuthResult.f7044c, false);
        C1938b.m10931a(parcel, a);
    }

    public CheckServerAuthResult m12035a(Parcel parcel) {
        boolean z = false;
        int b = C1937a.m10910b(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    z = C1937a.m10914c(parcel, a);
                    break;
                case 3:
                    list = C1937a.m10913c(parcel, a, Scope.CREATOR);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public CheckServerAuthResult[] m12036a(int i) {
        return new CheckServerAuthResult[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12035a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12036a(i);
    }
}
