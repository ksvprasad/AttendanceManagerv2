package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new C1901h();
    final int f6421a;
    final IBinder f6422b;
    private final int f6423c;
    private final Scope[] f6424d;
    private final Bundle f6425e;
    private final String f6426f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f6421a = i;
        this.f6423c = i2;
        this.f6422b = iBinder;
        this.f6424d = scopeArr;
        this.f6425e = bundle;
        this.f6426f = str;
    }

    public int m10677a() {
        return this.f6423c;
    }

    public Scope[] m10678b() {
        return this.f6424d;
    }

    public String m10679c() {
        return this.f6426f;
    }

    public Bundle m10680d() {
        return this.f6425e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1901h.m10813a(this, parcel, i);
    }
}
