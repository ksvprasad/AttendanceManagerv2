package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable implements C1857g {
    public static final Creator<AuthAccountResult> CREATOR = new C2100a();
    final int f7039a;
    private int f7040b;
    private Intent f7041c;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f7039a = i;
        this.f7040b = i2;
        this.f7041c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status mo1642a() {
        return this.f7040b == 0 ? Status.f6333a : Status.f6337e;
    }

    public int m12023b() {
        return this.f7040b;
    }

    public Intent m12024c() {
        return this.f7041c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2100a.m12031a(this, parcel, i);
    }
}
