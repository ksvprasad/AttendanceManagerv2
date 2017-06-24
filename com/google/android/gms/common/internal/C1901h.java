package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1901h implements Creator<ValidateAccountRequest> {
    static void m10813a(ValidateAccountRequest validateAccountRequest, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, validateAccountRequest.f6421a);
        C1938b.m10933a(parcel, 2, validateAccountRequest.m10677a());
        C1938b.m10936a(parcel, 3, validateAccountRequest.f6422b, false);
        C1938b.m10947a(parcel, 4, validateAccountRequest.m10678b(), i, false);
        C1938b.m10935a(parcel, 5, validateAccountRequest.m10680d(), false);
        C1938b.m10942a(parcel, 6, validateAccountRequest.m10679c(), false);
        C1938b.m10931a(parcel, a);
    }

    public ValidateAccountRequest m10814a(Parcel parcel) {
        int i = 0;
        String str = null;
        int b = C1937a.m10910b(parcel);
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
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
                    iBinder = C1937a.m10923l(parcel, a);
                    break;
                case 4:
                    scopeArr = (Scope[]) C1937a.m10912b(parcel, a, Scope.CREATOR);
                    break;
                case 5:
                    bundle = C1937a.m10924m(parcel, a);
                    break;
                case 6:
                    str = C1937a.m10922k(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ValidateAccountRequest(i2, i, iBinder, scopeArr, bundle, str);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public ValidateAccountRequest[] m10815a(int i) {
        return new ValidateAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10814a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10815a(i);
    }
}
