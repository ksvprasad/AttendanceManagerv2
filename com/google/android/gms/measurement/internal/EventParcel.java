package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class EventParcel extends AbstractSafeParcelable {
    public static final C2094w CREATOR = new C2094w();
    public final int f6672a;
    public final String f6673b;
    public final EventParams f6674c;
    public final String f6675d;
    public final long f6676e;

    EventParcel(int i, String str, EventParams eventParams, String str2, long j) {
        this.f6672a = i;
        this.f6673b = str;
        this.f6674c = eventParams;
        this.f6675d = str2;
        this.f6676e = j;
    }

    public EventParcel(String str, EventParams eventParams, String str2, long j) {
        this.f6672a = 1;
        this.f6673b = str;
        this.f6674c = eventParams;
        this.f6675d = str2;
        this.f6676e = j;
    }

    public String toString() {
        String str = this.f6675d;
        String str2 = this.f6673b;
        String valueOf = String.valueOf(this.f6674c);
        return new StringBuilder(((String.valueOf(str).length() + 21) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C2094w.m11969a(this, parcel, i);
    }
}
