package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1886w.C1887a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new C1898e();
    final int f6416a;
    IBinder f6417b;
    private ConnectionResult f6418c;
    private boolean f6419d;
    private boolean f6420e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f6416a = i;
        this.f6417b = iBinder;
        this.f6418c = connectionResult;
        this.f6419d = z;
        this.f6420e = z2;
    }

    public C1886w m10673a() {
        return C1887a.m10682a(this.f6417b);
    }

    public ConnectionResult m10674b() {
        return this.f6418c;
    }

    public boolean m10675c() {
        return this.f6419d;
    }

    public boolean m10676d() {
        return this.f6420e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f6418c.equals(resolveAccountResponse.f6418c) && m10673a().equals(resolveAccountResponse.m10673a());
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1898e.m10804a(this, parcel, i);
    }
}
