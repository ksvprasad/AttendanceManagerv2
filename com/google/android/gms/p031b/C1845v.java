package com.google.android.gms.p031b;

public final class C1845v implements Cloneable {
    private static final C1846w f6267a = new C1846w();
    private boolean f6268b;
    private int[] f6269c;
    private C1846w[] f6270d;
    private int f6271e;

    C1845v() {
        this(10);
    }

    C1845v(int i) {
        this.f6268b = false;
        int c = m10481c(i);
        this.f6269c = new int[c];
        this.f6270d = new C1846w[c];
        this.f6271e = 0;
    }

    private boolean m10479a(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean m10480a(C1846w[] c1846wArr, C1846w[] c1846wArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!c1846wArr[i2].equals(c1846wArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int m10481c(int i) {
        return m10482d(i * 4) / 4;
    }

    private int m10482d(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int m10483e(int i) {
        int i2 = 0;
        int i3 = this.f6271e - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.f6269c[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    int m10484a() {
        return this.f6271e;
    }

    C1846w m10485a(int i) {
        int e = m10483e(i);
        return (e < 0 || this.f6270d[e] == f6267a) ? null : this.f6270d[e];
    }

    void m10486a(int i, C1846w c1846w) {
        int e = m10483e(i);
        if (e >= 0) {
            this.f6270d[e] = c1846w;
            return;
        }
        e ^= -1;
        if (e >= this.f6271e || this.f6270d[e] != f6267a) {
            if (this.f6271e >= this.f6269c.length) {
                int c = m10481c(this.f6271e + 1);
                Object obj = new int[c];
                Object obj2 = new C1846w[c];
                System.arraycopy(this.f6269c, 0, obj, 0, this.f6269c.length);
                System.arraycopy(this.f6270d, 0, obj2, 0, this.f6270d.length);
                this.f6269c = obj;
                this.f6270d = obj2;
            }
            if (this.f6271e - e != 0) {
                System.arraycopy(this.f6269c, e, this.f6269c, e + 1, this.f6271e - e);
                System.arraycopy(this.f6270d, e, this.f6270d, e + 1, this.f6271e - e);
            }
            this.f6269c[e] = i;
            this.f6270d[e] = c1846w;
            this.f6271e++;
            return;
        }
        this.f6269c[e] = i;
        this.f6270d[e] = c1846w;
    }

    C1846w m10487b(int i) {
        return this.f6270d[i];
    }

    public boolean m10488b() {
        return m10484a() == 0;
    }

    public final C1845v m10489c() {
        int a = m10484a();
        C1845v c1845v = new C1845v(a);
        System.arraycopy(this.f6269c, 0, c1845v.f6269c, 0, a);
        for (int i = 0; i < a; i++) {
            if (this.f6270d[i] != null) {
                c1845v.f6270d[i] = (C1846w) this.f6270d[i].clone();
            }
        }
        c1845v.f6271e = a;
        return c1845v;
    }

    public /* synthetic */ Object clone() {
        return m10489c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1845v)) {
            return false;
        }
        C1845v c1845v = (C1845v) obj;
        return m10484a() != c1845v.m10484a() ? false : m10479a(this.f6269c, c1845v.f6269c, this.f6271e) && m10480a(this.f6270d, c1845v.f6270d, this.f6271e);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.f6271e; i2++) {
            i = (((i * 31) + this.f6269c[i2]) * 31) + this.f6270d[i2].hashCode();
        }
        return i;
    }
}
