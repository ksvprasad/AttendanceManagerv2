package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.C1937a;
import com.google.android.gms.common.internal.safeparcel.C1937a.C1936a;
import com.google.android.gms.common.internal.safeparcel.C1938b;

public class C1897d implements Creator<ResolveAccountRequest> {
    static void m10801a(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int a = C1938b.m10930a(parcel);
        C1938b.m10933a(parcel, 1, resolveAccountRequest.f6412a);
        C1938b.m10937a(parcel, 2, resolveAccountRequest.m10670a(), i, false);
        C1938b.m10933a(parcel, 3, resolveAccountRequest.m10671b());
        C1938b.m10937a(parcel, 4, resolveAccountRequest.m10672c(), i, false);
        C1938b.m10931a(parcel, a);
    }

    public ResolveAccountRequest m10802a(Parcel parcel) {
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int b = C1937a.m10910b(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < b) {
            int i3;
            Account account2;
            int d;
            GoogleSignInAccount googleSignInAccount2;
            int a = C1937a.m10905a(parcel);
            GoogleSignInAccount googleSignInAccount3;
            switch (C1937a.m10904a(a)) {
                case 1:
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = C1937a.m10915d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 2:
                    d = i2;
                    int i4 = i;
                    account2 = (Account) C1937a.m10907a(parcel, a, Account.CREATOR);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i4;
                    break;
                case 3:
                    account2 = account;
                    d = i2;
                    googleSignInAccount3 = googleSignInAccount;
                    i3 = C1937a.m10915d(parcel, a);
                    googleSignInAccount2 = googleSignInAccount3;
                    break;
                case 4:
                    googleSignInAccount2 = (GoogleSignInAccount) C1937a.m10907a(parcel, a, GoogleSignInAccount.CREATOR);
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
                default:
                    C1937a.m10911b(parcel, a);
                    googleSignInAccount2 = googleSignInAccount;
                    i3 = i;
                    account2 = account;
                    d = i2;
                    break;
            }
            i2 = d;
            account = account2;
            i = i3;
            googleSignInAccount = googleSignInAccount2;
        }
        if (parcel.dataPosition() == b) {
            return new ResolveAccountRequest(i2, account, i, googleSignInAccount);
        }
        throw new C1936a("Overread allowed size end=" + b, parcel);
    }

    public ResolveAccountRequest[] m10803a(int i) {
        return new ResolveAccountRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10802a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10803a(i);
    }
}
