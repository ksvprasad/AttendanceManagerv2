package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1898e implements Creator<ResolveAccountResponse> {
    static void m10804a(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, resolveAccountResponse.f6416a);
        C1938b.m10936a(parcel, 2, resolveAccountResponse.f6417b, false);
        C1938b.m10937a(parcel, 3, resolveAccountResponse.m10674b(), i, false);
        C1938b.m10944a(parcel, 4, resolveAccountResponse.m10675c());
        C1938b.m10944a(parcel, 5, resolveAccountResponse.m10676d());
        C1938b.m10931a(parcel, a);
    }

    public ResolveAccountResponse m10805a(Parcel parcel) {
        ConnectionResult connectionResult = null;
        boolean z = false;
        int b = C1937a.m10910b(parcel);
        boolean z2 = false;
        IBinder iBinder = null;
        int i = 0;
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
                    connectionResult = (ConnectionResult) C1937a.m10907a(parcel, a, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z2 = C1937a.m10914c(parcel, a);
                    break;
                case 5:
                    z = C1937a.m10914c(parcel, a);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z2, z);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountResponse[] m10806a(int i) {
        return new ResolveAccountResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10805a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10806a(i);
    }
}
