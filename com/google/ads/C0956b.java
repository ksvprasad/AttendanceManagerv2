package com.google.ads;

import com.google.android.gms.ads.C1029d;

@Deprecated
public final class C0956b {
    public static final C0956b f2928a = new C0956b(-1, -2, "mb");
    public static final C0956b f2929b = new C0956b(320, 50, "mb");
    public static final C0956b f2930c = new C0956b(300, 250, "as");
    public static final C0956b f2931d = new C0956b(468, 60, "as");
    public static final C0956b f2932e = new C0956b(728, 90, "as");
    public static final C0956b f2933f = new C0956b(160, 600, "as");
    private final C1029d f2934g;

    private C0956b(int i, int i2, String str) {
        this(new C1029d(i, i2));
    }

    public C0956b(C1029d c1029d) {
        this.f2934g = c1029d;
    }

    public int m5601a() {
        return this.f2934g.m5803b();
    }

    public int m5602b() {
        return this.f2934g.m5801a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0956b)) {
            return false;
        }
        return this.f2934g.equals(((C0956b) obj).f2934g);
    }

    public int hashCode() {
        return this.f2934g.hashCode();
    }

    public String toString() {
        return this.f2934g.toString();
    }
}
