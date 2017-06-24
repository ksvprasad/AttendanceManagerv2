package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class UserAttributeParcel extends AbstractSafeParcelable {
    public static final C2080k CREATOR = new C2080k();
    public final int f6677a;
    public final String f6678b;
    public final long f6679c;
    public final Long f6680d;
    public final Float f6681e;
    public final String f6682f;
    public final String f6683g;
    public final Double f6684h;

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.f6677a = i;
        this.f6678b = str;
        this.f6679c = j;
        this.f6680d = l;
        this.f6681e = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.f6684h = d2;
        } else {
            this.f6684h = d;
        }
        this.f6682f = str2;
        this.f6683g = str3;
    }

    UserAttributeParcel(C2081l c2081l) {
        this(c2081l.f6962b, c2081l.f6963c, c2081l.f6964d, c2081l.f6961a);
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        C1896c.m10792a(str);
        this.f6677a = 2;
        this.f6678b = str;
        this.f6679c = j;
        this.f6683g = str2;
        if (obj == null) {
            this.f6680d = null;
            this.f6681e = null;
            this.f6684h = null;
            this.f6682f = null;
        } else if (obj instanceof Long) {
            this.f6680d = (Long) obj;
            this.f6681e = null;
            this.f6684h = null;
            this.f6682f = null;
        } else if (obj instanceof String) {
            this.f6680d = null;
            this.f6681e = null;
            this.f6684h = null;
            this.f6682f = (String) obj;
        } else if (obj instanceof Double) {
            this.f6680d = null;
            this.f6681e = null;
            this.f6684h = (Double) obj;
            this.f6682f = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object m11201a() {
        return this.f6680d != null ? this.f6680d : this.f6684h != null ? this.f6684h : this.f6682f != null ? this.f6682f : null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2080k.m11731a(this, parcel, i);
    }
}
