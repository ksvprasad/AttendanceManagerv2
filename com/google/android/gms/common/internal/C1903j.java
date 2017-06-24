package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1903j implements Creator<AuthAccountRequest> {
    static void m10817a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, authAccountRequest.f6398a);
        C1938b.m10936a(parcel, 2, authAccountRequest.f6399b, false);
        C1938b.m10947a(parcel, 3, authAccountRequest.f6400c, i, false);
        C1938b.m10940a(parcel, 4, authAccountRequest.f6401d, false);
        C1938b.m10940a(parcel, 5, authAccountRequest.f6402e, false);
        C1938b.m10931a(parcel, a);
    }

    public AuthAccountRequest m10818a(Parcel parcel) {
        Integer num = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    iBinder = C1937a.m10923l(parcel, a);
                    break;
                case 3:
                    scopeArr = (Scope[]) C1937a.m10912b(parcel, a, Scope.CREATOR);
                    break;
                case 4:
                    num2 = C1937a.m10916e(parcel, a);
                    break;
                case 5:
                    num = C1937a.m10916e(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public AuthAccountRequest[] m10819a(int i) {
        return new AuthAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10818a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10819a(i);
    }
}
