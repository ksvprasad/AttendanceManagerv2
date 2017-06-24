package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C2108h implements Creator<SignInRequest> {
    static void m12078a(SignInRequest signInRequest, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, signInRequest.f7049a);
        C1938b.m10937a(parcel, 2, signInRequest.m12028a(), i, false);
        C1938b.m10931a(parcel, a);
    }

    public SignInRequest m12079a(Parcel parcel) {
        int b = C1937a.m10910b(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < b) {
            int a = C1937a.m10905a(parcel);
            switch (C1937a.m10904a(a)) {
                case 1:
                    i = C1937a.m10915d(parcel, a);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) C1937a.m10907a(parcel, a, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public SignInRequest[] m12080a(int i) {
        return new SignInRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m12079a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m12080a(i);
    }
}
