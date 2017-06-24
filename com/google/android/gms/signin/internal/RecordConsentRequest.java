package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new C2106f();
    final int f7045a;
    private final Account f7046b;
    private final Scope[] f7047c;
    private final String f7048d;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.f7045a = i;
        this.f7046b = account;
        this.f7047c = scopeArr;
        this.f7048d = str;
    }

    public Account m12025a() {
        return this.f7046b;
    }

    public Scope[] m12026b() {
        return this.f7047c;
    }

    public String m12027c() {
        return this.f7048d;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2106f.m12063a(this, parcel, i);
    }
}
