package com.google.android.gms.p031b;

public final class C1841r {
    private final byte[] f6252a;
    private int f6253b;
    private int f6254c;
    private int f6255d;
    private int f6256e;
    private int f6257f;
    private int f6258g = Integer.MAX_VALUE;
    private int f6259h;
    private int f6260i = 64;
    private int f6261j = 67108864;

    private C1841r(byte[] bArr, int i, int i2) {
        this.f6252a = bArr;
        this.f6253b = i;
        this.f6254c = i + i2;
        this.f6256e = i;
    }

    public static long m10378a(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static C1841r m10379a(byte[] bArr) {
        return C1841r.m10380a(bArr, 0, bArr.length);
    }

    public static C1841r m10380a(byte[] bArr, int i, int i2) {
        return new C1841r(bArr, i, i2);
    }

    private void m10381t() {
        this.f6254c += this.f6255d;
        int i = this.f6254c;
        if (i > this.f6258g) {
            this.f6255d = i - this.f6258g;
            this.f6254c -= this.f6255d;
            return;
        }
        this.f6255d = 0;
    }

    public int m10382a() {
        if (m10406q()) {
            this.f6257f = 0;
            return 0;
        }
        this.f6257f = m10401l();
        if (this.f6257f != 0) {
            return this.f6257f;
        }
        throw C1848y.m10507d();
    }

    public void m10383a(int i) {
        if (this.f6257f != i) {
            throw C1848y.m10508e();
        }
    }

    public void m10384a(C1357z c1357z) {
        int l = m10401l();
        if (this.f6259h >= this.f6260i) {
            throw C1848y.m10510g();
        }
        l = m10389c(l);
        this.f6259h++;
        c1357z.mo1234b(this);
        m10383a(0);
        this.f6259h--;
        m10391d(l);
    }

    public byte[] m10385a(int i, int i2) {
        if (i2 == 0) {
            return ac.f4058h;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.f6252a, this.f6253b + i, obj, 0, i2);
        return obj;
    }

    public void m10386b() {
        int a;
        do {
            a = m10382a();
            if (a == 0) {
                return;
            }
        } while (m10387b(a));
    }

    public boolean m10387b(int i) {
        switch (ac.m7335a(i)) {
            case 0:
                m10396g();
                return true;
            case 1:
                m10404o();
                return true;
            case 2:
                m10395f(m10401l());
                return true;
            case 3:
                m10386b();
                m10383a(ac.m7336a(ac.m7338b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m10403n();
                return true;
            default:
                throw C1848y.m10509f();
        }
    }

    public double m10388c() {
        return Double.longBitsToDouble(m10404o());
    }

    public int m10389c(int i) {
        if (i < 0) {
            throw C1848y.m10505b();
        }
        int i2 = this.f6256e + i;
        int i3 = this.f6258g;
        if (i2 > i3) {
            throw C1848y.m10504a();
        }
        this.f6258g = i2;
        m10381t();
        return i3;
    }

    public float m10390d() {
        return Float.intBitsToFloat(m10403n());
    }

    public void m10391d(int i) {
        this.f6258g = i;
        m10381t();
    }

    public long m10392e() {
        return m10402m();
    }

    public void m10393e(int i) {
        if (i > this.f6256e - this.f6253b) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f6256e - this.f6253b));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f6256e = this.f6253b + i;
        }
    }

    public long m10394f() {
        return m10402m();
    }

    public void m10395f(int i) {
        if (i < 0) {
            throw C1848y.m10505b();
        } else if (this.f6256e + i > this.f6258g) {
            m10395f(this.f6258g - this.f6256e);
            throw C1848y.m10504a();
        } else if (i <= this.f6254c - this.f6256e) {
            this.f6256e += i;
        } else {
            throw C1848y.m10504a();
        }
    }

    public int m10396g() {
        return m10401l();
    }

    public boolean m10397h() {
        return m10401l() != 0;
    }

    public String m10398i() {
        int l = m10401l();
        if (l < 0) {
            throw C1848y.m10505b();
        } else if (l > this.f6254c - this.f6256e) {
            throw C1848y.m10504a();
        } else {
            String str = new String(this.f6252a, this.f6256e, l, C1847x.f6275a);
            this.f6256e = l + this.f6256e;
            return str;
        }
    }

    public byte[] m10399j() {
        int l = m10401l();
        if (l < 0) {
            throw C1848y.m10505b();
        } else if (l == 0) {
            return ac.f4058h;
        } else {
            if (l > this.f6254c - this.f6256e) {
                throw C1848y.m10504a();
            }
            Object obj = new byte[l];
            System.arraycopy(this.f6252a, this.f6256e, obj, 0, l);
            this.f6256e = l + this.f6256e;
            return obj;
        }
    }

    public long m10400k() {
        return C1841r.m10378a(m10402m());
    }

    public int m10401l() {
        byte s = m10408s();
        if (s >= (byte) 0) {
            return s;
        }
        int i = s & 127;
        byte s2 = m10408s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 7);
        }
        i |= (s2 & 127) << 7;
        s2 = m10408s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 14);
        }
        i |= (s2 & 127) << 14;
        s2 = m10408s();
        if (s2 >= (byte) 0) {
            return i | (s2 << 21);
        }
        i |= (s2 & 127) << 21;
        s2 = m10408s();
        i |= s2 << 28;
        if (s2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m10408s() >= (byte) 0) {
                return i;
            }
        }
        throw C1848y.m10506c();
    }

    public long m10402m() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte s = m10408s();
            j |= ((long) (s & 127)) << i;
            if ((s & 128) == 0) {
                return j;
            }
        }
        throw C1848y.m10506c();
    }

    public int m10403n() {
        return (((m10408s() & 255) | ((m10408s() & 255) << 8)) | ((m10408s() & 255) << 16)) | ((m10408s() & 255) << 24);
    }

    public long m10404o() {
        byte s = m10408s();
        byte s2 = m10408s();
        return ((((((((((long) s2) & 255) << 8) | (((long) s) & 255)) | ((((long) m10408s()) & 255) << 16)) | ((((long) m10408s()) & 255) << 24)) | ((((long) m10408s()) & 255) << 32)) | ((((long) m10408s()) & 255) << 40)) | ((((long) m10408s()) & 255) << 48)) | ((((long) m10408s()) & 255) << 56);
    }

    public int m10405p() {
        if (this.f6258g == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f6258g - this.f6256e;
    }

    public boolean m10406q() {
        return this.f6256e == this.f6254c;
    }

    public int m10407r() {
        return this.f6256e - this.f6253b;
    }

    public byte m10408s() {
        if (this.f6256e == this.f6254c) {
            throw C1848y.m10504a();
        }
        byte[] bArr = this.f6252a;
        int i = this.f6256e;
        this.f6256e = i + 1;
        return bArr[i];
    }
}
