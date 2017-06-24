package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2109i implements Creator<SignInResponse> {
    static void m12081a(SignInResponse signInResponse, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, signInResponse.f7051a);
        C1938b.m10937a(parcel, 2, signInResponse.m12029a(), i, false);
        C1938b.m10937a(parcel, 3, signInResponse.m12030b(), i, false);
        C1938b.m10931a(parcel, a);
    }

    public SignInResponse m12082a(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse = null;
        int b = C1937a.m10910b(parcel);
        int i = 0;
        ConnectionResult connectionResult = null;
        while (parcel.dataPosition() < b) {
            ConnectionResult connectionResult2;
            int d;
            ResolveAccountResponse resolveAccountResponse2;
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = C1937a.m10915d(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse3;
                    break;
                case 2:
                    d = i;
                    ConnectionResult connectionResult3 = (ConnectionResult) C1937a.m10907a(parcel, a, ConnectionResult.CREATOR);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse2 = (ResolveAccountResponse) C1937a.m10907a(parcel, a, ResolveAccountResponse.CREATOR);
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    resolveAccountResponse2 = resolveAccountResponse;
                    connectionResult2 = connectionResult;
                    d = i;
                    break;
            }
            i = d;
            connectionResult = connectionResult2;
            resolveAccountResponse = resolveAccountResponse2;
        }
        if (parcel.dataPosition() == b) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public SignInResponse[] m12083a(int i) {
        return new SignInResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12082a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12083a(i);
    }
}
