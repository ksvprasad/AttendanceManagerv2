package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR = new C2101c();
    final int f7042a;
    final boolean f7043b;
    final List<Scope> f7044c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f7042a = i;
        this.f7043b = z;
        this.f7044c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2101c.m12034a(this, parcel, i);
    }
}
