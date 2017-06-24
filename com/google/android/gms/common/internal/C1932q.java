package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1932q implements Creator<GetServiceRequest> {
    static void m10890a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, getServiceRequest.f6403a);
        C1938b.m10933a(parcel, 2, getServiceRequest.f6404b);
        C1938b.m10933a(parcel, 3, getServiceRequest.f6405c);
        C1938b.m10942a(parcel, 4, getServiceRequest.f6406d, false);
        C1938b.m10936a(parcel, 5, getServiceRequest.f6407e, false);
        C1938b.m10947a(parcel, 6, getServiceRequest.f6408f, i, false);
        C1938b.m10935a(parcel, 7, getServiceRequest.f6409g, false);
        C1938b.m10937a(parcel, 8, getServiceRequest.f6410h, i, false);
        C1938b.m10934a(parcel, 9, getServiceRequest.f6411i);
        C1938b.m10931a(parcel, a);
    }

    public GetServiceRequest m10891a(Parcel parcel) {
        int i = 0;
        Account account = null;
        int b = C1937a.m10910b(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i3 = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    i2 = C1937a.m10915d(parcel, a);
                    break;
                case 3:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 4:
                    str = C1937a.m10922k(parcel, a);
                    break;
                case 5:
                    iBinder = C1937a.m10923l(parcel, a);
                    break;
                case 6:
                    scopeArr = (Scope[]) C1937a.m10912b(parcel, a, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C1937a.m10924m(parcel, a);
                    break;
                case 8:
                    account = (Account) C1937a.m10907a(parcel, a, Account.CREATOR);
                    break;
                case 9:
                    j = C1937a.m10917f(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public GetServiceRequest[] m10892a(int i) {
        return new GetServiceRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10891a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10892a(i);
    }
}
