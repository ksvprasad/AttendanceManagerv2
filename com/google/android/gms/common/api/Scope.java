package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new C1874p();
    final int f6331a;
    private final String f6332b;

    Scope(int i, String str) {
        C1896c.m10793a(str, (Object) "scopeUri must not be null or empty");
        this.f6331a = i;
        this.f6332b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public String m10558a() {
        return this.f6332b;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f6332b.equals(((Scope) obj).f6332b);
    }

    public int hashCode() {
        return this.f6332b.hashCode();
    }

    public String toString() {
        return this.f6332b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1874p.m10599a(this, parcel, i);
    }
}
