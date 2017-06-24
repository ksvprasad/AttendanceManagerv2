package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1886w.C1887a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new C1932q();
    final int f6403a;
    final int f6404b;
    int f6405c;
    String f6406d;
    IBinder f6407e;
    Scope[] f6408f;
    Bundle f6409g;
    Account f6410h;
    long f6411i;

    public GetServiceRequest(int i) {
        this.f6403a = 3;
        this.f6405c = C1876j.f6382b;
        this.f6404b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.f6403a = i;
        this.f6404b = i2;
        this.f6405c = i3;
        this.f6406d = str;
        if (i < 2) {
            this.f6410h = m10664a(iBinder);
        } else {
            this.f6407e = iBinder;
            this.f6410h = account;
        }
        this.f6408f = scopeArr;
        this.f6409g = bundle;
        this.f6411i = j;
    }

    private Account m10664a(IBinder iBinder) {
        return iBinder != null ? C1888a.m10683a(C1887a.m10682a(iBinder)) : null;
    }

    public GetServiceRequest m10665a(Account account) {
        this.f6410h = account;
        return this;
    }

    public GetServiceRequest m10666a(Bundle bundle) {
        this.f6409g = bundle;
        return this;
    }

    public GetServiceRequest m10667a(C1886w c1886w) {
        if (c1886w != null) {
            this.f6407e = c1886w.asBinder();
        }
        return this;
    }

    public GetServiceRequest m10668a(String str) {
        this.f6406d = str;
        return this;
    }

    public GetServiceRequest m10669a(Collection<Scope> collection) {
        this.f6408f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1932q.m10890a(this, parcel, i);
    }
}
