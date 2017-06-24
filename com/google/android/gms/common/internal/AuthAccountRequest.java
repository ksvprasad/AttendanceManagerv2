package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new C1903j();
    final int f6398a;
    final IBinder f6399b;
    final Scope[] f6400c;
    Integer f6401d;
    Integer f6402e;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f6398a = i;
        this.f6399b = iBinder;
        this.f6400c = scopeArr;
        this.f6401d = num;
        this.f6402e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1903j.m10817a(this, parcel, i);
    }
}
