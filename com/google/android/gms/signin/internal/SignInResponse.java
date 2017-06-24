package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse extends AbstractSafeParcelable {
    public static final Creator<SignInResponse> CREATOR = new C2109i();
    final int f7051a;
    private final ConnectionResult f7052b;
    private final ResolveAccountResponse f7053c;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f7051a = i;
        this.f7052b = connectionResult;
        this.f7053c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult m12029a() {
        return this.f7052b;
    }

    public ResolveAccountResponse m12030b() {
        return this.f7053c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2109i.m12081a(this, parcel, i);
    }
}
