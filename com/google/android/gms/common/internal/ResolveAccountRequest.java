package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new C1897d();
    final int f6412a;
    private final Account f6413b;
    private final int f6414c;
    private final GoogleSignInAccount f6415d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f6412a = i;
        this.f6413b = account;
        this.f6414c = i2;
        this.f6415d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account m10670a() {
        return this.f6413b;
    }

    public int m10671b() {
        return this.f6414c;
    }

    public GoogleSignInAccount m10672c() {
        return this.f6415d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1897d.m10801a(this, parcel, i);
    }
}
