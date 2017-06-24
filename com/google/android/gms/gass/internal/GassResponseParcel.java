package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.C1357z;
import com.google.android.gms.p031b.C1493f.C1487a;

public final class GassResponseParcel extends AbstractSafeParcelable {
    public static final Creator<GassResponseParcel> CREATOR = new C2000d();
    public final int f6636a;
    private C1487a f6637b = null;
    private byte[] f6638c;

    GassResponseParcel(int i, byte[] bArr) {
        this.f6636a = i;
        this.f6638c = bArr;
        m11151e();
    }

    private boolean m11149c() {
        return this.f6637b != null;
    }

    private void m11150d() {
        if (!m11149c()) {
            try {
                this.f6637b = C1487a.m8165a(this.f6638c);
                this.f6638c = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        m11151e();
    }

    private void m11151e() {
        if (this.f6637b == null && this.f6638c != null) {
            return;
        }
        if (this.f6637b != null && this.f6638c == null) {
            return;
        }
        if (this.f6637b != null && this.f6638c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.f6637b == null && this.f6638c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public byte[] m11152a() {
        return this.f6638c != null ? this.f6638c : C1357z.m7342a(this.f6637b);
    }

    public C1487a m11153b() {
        m11150d();
        return this.f6637b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2000d.m11171a(this, parcel, i);
    }
}
