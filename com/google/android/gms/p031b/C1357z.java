package com.google.android.gms.p031b;

import java.io.IOException;

public abstract class C1357z {
    protected volatile int f4059V = -1;

    public static final <T extends C1357z> T m7340a(T t, byte[] bArr) {
        return C1357z.m7343b(t, bArr, 0, bArr.length);
    }

    public static final void m7341a(C1357z c1357z, byte[] bArr, int i, int i2) {
        try {
            C1843s a = C1843s.m10413a(bArr, i, i2);
            c1357z.mo1231a(a);
            a.m10458b();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] m7342a(C1357z c1357z) {
        byte[] bArr = new byte[c1357z.m7349f()];
        C1357z.m7341a(c1357z, bArr, 0, bArr.length);
        return bArr;
    }

    public static final <T extends C1357z> T m7343b(T t, byte[] bArr, int i, int i2) {
        try {
            C1841r a = C1841r.m10380a(bArr, i, i2);
            t.mo1234b(a);
            a.m10383a(0);
            return t;
        } catch (C1848y e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    protected int mo1230a() {
        return 0;
    }

    public void mo1231a(C1843s c1843s) {
    }

    public abstract C1357z mo1234b(C1841r c1841r);

    public /* synthetic */ Object clone() {
        return mo1233d();
    }

    public C1357z mo1233d() {
        return (C1357z) super.clone();
    }

    public int m7348e() {
        if (this.f4059V < 0) {
            m7349f();
        }
        return this.f4059V;
    }

    public int m7349f() {
        int a = mo1230a();
        this.f4059V = a;
        return a;
    }

    public String toString() {
        return aa.m7327a(this);
    }
}
