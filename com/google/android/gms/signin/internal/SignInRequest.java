package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest extends AbstractSafeParcelable {
    public static final Creator<SignInRequest> CREATOR = new C2108h();
    final int f7049a;
    final ResolveAccountRequest f7050b;

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f7049a = i;
        this.f7050b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest m12028a() {
        return this.f7050b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2108h.m12078a(this, parcel, i);
    }
}
