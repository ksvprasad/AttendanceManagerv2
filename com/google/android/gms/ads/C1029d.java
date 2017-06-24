package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1120y;

public final class C1029d {
    public static final C1029d f3015a = new C1029d(320, 50, "320x50_mb");
    public static final C1029d f3016b = new C1029d(468, 60, "468x60_as");
    public static final C1029d f3017c = new C1029d(320, 100, "320x100_as");
    public static final C1029d f3018d = new C1029d(728, 90, "728x90_as");
    public static final C1029d f3019e = new C1029d(300, 250, "300x250_as");
    public static final C1029d f3020f = new C1029d(160, 600, "160x600_as");
    public static final C1029d f3021g = new C1029d(-1, -2, "smart_banner");
    public static final C1029d f3022h = new C1029d(-3, -4, "fluid");
    public static final C1029d f3023i = new C1029d(-3, 0, "search_v2");
    private final int f3024j;
    private final int f3025k;
    private final String f3026l;

    public C1029d(int i, int i2) {
        String valueOf = i == -1 ? "FULL" : String.valueOf(i);
        String valueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        String valueOf3 = String.valueOf("_as");
        this(i, i2, new StringBuilder(((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append(valueOf).append("x").append(valueOf2).append(valueOf3).toString());
    }

    C1029d(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.f3024j = i;
            this.f3025k = i2;
            this.f3026l = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public int m5801a() {
        return this.f3025k;
    }

    public int m5802a(Context context) {
        switch (this.f3025k) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.m5969b(context.getResources().getDisplayMetrics());
            default:
                return C1120y.m6293a().m7208a(context, this.f3025k);
        }
    }

    public int m5803b() {
        return this.f3024j;
    }

    public int m5804b(Context context) {
        switch (this.f3024j) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.m5966a(context.getResources().getDisplayMetrics());
            default:
                return C1120y.m6293a().m7208a(context, this.f3024j);
        }
    }

    public boolean m5805c() {
        return this.f3024j == -3 && this.f3025k == -4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1029d)) {
            return false;
        }
        C1029d c1029d = (C1029d) obj;
        return this.f3024j == c1029d.f3024j && this.f3025k == c1029d.f3025k && this.f3026l.equals(c1029d.f3026l);
    }

    public int hashCode() {
        return this.f3026l.hashCode();
    }

    public String toString() {
        return this.f3026l;
    }
}
