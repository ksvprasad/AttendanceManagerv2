package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new C1966g();
    final int f6551a;
    private final long f6552b;
    private int f6553c;
    private final String f6554d;
    private final String f6555e;
    private final String f6556f;
    private final int f6557g;
    private final List<String> f6558h;
    private final String f6559i;
    private final long f6560j;
    private int f6561k;
    private final String f6562l;
    private final float f6563m;
    private final long f6564n;
    private long f6565o;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.f6551a = i;
        this.f6552b = j;
        this.f6553c = i2;
        this.f6554d = str;
        this.f6555e = str3;
        this.f6556f = str5;
        this.f6557g = i3;
        this.f6565o = -1;
        this.f6558h = list;
        this.f6559i = str2;
        this.f6560j = j2;
        this.f6561k = i4;
        this.f6562l = str4;
        this.f6563m = f;
        this.f6564n = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    public long mo1719a() {
        return this.f6552b;
    }

    public int mo1720b() {
        return this.f6553c;
    }

    public String m11023c() {
        return this.f6554d;
    }

    public String m11024d() {
        return this.f6555e;
    }

    public String m11025e() {
        return this.f6556f;
    }

    public int m11026f() {
        return this.f6557g;
    }

    public List<String> m11027g() {
        return this.f6558h;
    }

    public String m11028h() {
        return this.f6559i;
    }

    public long mo1721i() {
        return this.f6565o;
    }

    public long m11030j() {
        return this.f6560j;
    }

    public int m11031k() {
        return this.f6561k;
    }

    public String mo1722l() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(m11023c());
        String valueOf3 = String.valueOf("\t");
        int f = m11026f();
        String valueOf4 = String.valueOf("\t");
        String join = m11027g() == null ? "" : TextUtils.join(",", m11027g());
        String valueOf5 = String.valueOf("\t");
        int k = m11031k();
        String valueOf6 = String.valueOf("\t");
        String d = m11024d() == null ? "" : m11024d();
        String valueOf7 = String.valueOf("\t");
        String m = m11033m() == null ? "" : m11033m();
        String valueOf8 = String.valueOf("\t");
        float n = m11034n();
        String valueOf9 = String.valueOf("\t");
        String e = m11025e() == null ? "" : m11025e();
        return new StringBuilder(((((((((((((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(join).length()) + String.valueOf(valueOf5).length()) + String.valueOf(valueOf6).length()) + String.valueOf(d).length()) + String.valueOf(valueOf7).length()) + String.valueOf(m).length()) + String.valueOf(valueOf8).length()) + String.valueOf(valueOf9).length()) + String.valueOf(e).length()).append(valueOf).append(valueOf2).append(valueOf3).append(f).append(valueOf4).append(join).append(valueOf5).append(k).append(valueOf6).append(d).append(valueOf7).append(m).append(valueOf8).append(n).append(valueOf9).append(e).toString();
    }

    public String m11033m() {
        return this.f6562l;
    }

    public float m11034n() {
        return this.f6563m;
    }

    public long m11035o() {
        return this.f6564n;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1966g.m11061a(this, parcel, i);
    }
}
