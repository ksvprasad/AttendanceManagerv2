package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ConnectionEvent extends StatsEvent {
    public static final Creator<ConnectionEvent> CREATOR = new C1958a();
    final int f6539a;
    private final long f6540b;
    private int f6541c;
    private final String f6542d;
    private final String f6543e;
    private final String f6544f;
    private final String f6545g;
    private final String f6546h;
    private final String f6547i;
    private final long f6548j;
    private final long f6549k;
    private long f6550l;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.f6539a = i;
        this.f6540b = j;
        this.f6541c = i2;
        this.f6542d = str;
        this.f6543e = str2;
        this.f6544f = str3;
        this.f6545g = str4;
        this.f6550l = -1;
        this.f6546h = str5;
        this.f6547i = str6;
        this.f6548j = j2;
        this.f6549k = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public long mo1719a() {
        return this.f6540b;
    }

    public int mo1720b() {
        return this.f6541c;
    }

    public String m11011c() {
        return this.f6542d;
    }

    public String m11012d() {
        return this.f6543e;
    }

    public String m11013e() {
        return this.f6544f;
    }

    public String m11014f() {
        return this.f6545g;
    }

    public String m11015g() {
        return this.f6546h;
    }

    public String m11016h() {
        return this.f6547i;
    }

    public long mo1721i() {
        return this.f6550l;
    }

    public long m11018j() {
        return this.f6549k;
    }

    public long m11019k() {
        return this.f6548j;
    }

    public String mo1722l() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(m11011c());
        String valueOf3 = String.valueOf(m11012d());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(m11013e());
        String valueOf6 = String.valueOf(m11014f());
        String valueOf7 = String.valueOf("\t");
        String str = this.f6546h == null ? "" : this.f6546h;
        String valueOf8 = String.valueOf("\t");
        return new StringBuilder(((((((((String.valueOf(valueOf).length() + 22) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(valueOf7).length()) + String.valueOf(str).length()) + String.valueOf(valueOf8).length()).append(valueOf).append(valueOf2).append("/").append(valueOf3).append(valueOf4).append(valueOf5).append("/").append(valueOf6).append(valueOf7).append(str).append(valueOf8).append(m11018j()).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1958a.m11036a(this, parcel, i);
    }
}
