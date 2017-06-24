package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Status extends AbstractSafeParcelable implements C1857g, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new C1875q();
    public static final Status f6333a = new Status(0);
    public static final Status f6334b = new Status(14);
    public static final Status f6335c = new Status(8);
    public static final Status f6336d = new Status(15);
    public static final Status f6337e = new Status(16);
    public static final Status f6338f = new Status(17);
    public static final Status f6339g = new Status(18);
    private final int f6340h;
    private final int f6341i;
    private final String f6342j;
    private final PendingIntent f6343k;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.f6340h = i;
        this.f6341i = i2;
        this.f6342j = str;
        this.f6343k = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String m10560g() {
        return this.f6342j != null ? this.f6342j : C1865b.m10579a(this.f6341i);
    }

    public Status mo1642a() {
        return this;
    }

    PendingIntent m10562b() {
        return this.f6343k;
    }

    public String m10563c() {
        return this.f6342j;
    }

    int m10564d() {
        return this.f6340h;
    }

    public boolean m10565e() {
        return this.f6341i <= 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f6340h == status.f6340h && this.f6341i == status.f6341i && C1895b.m10789a(this.f6342j, status.f6342j) && C1895b.m10789a(this.f6343k, status.f6343k);
    }

    public int m10566f() {
        return this.f6341i;
    }

    public int hashCode() {
        return C1895b.m10787a(Integer.valueOf(this.f6340h), Integer.valueOf(this.f6341i), this.f6342j, this.f6343k);
    }

    public String toString() {
        return C1895b.m10788a((Object) this).m10786a("statusCode", m10560g()).m10786a("resolution", this.f6343k).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1875q.m10602a(this, parcel, i);
    }
}
