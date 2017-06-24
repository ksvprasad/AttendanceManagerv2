package com.google.android.gms.p031b;

import java.lang.reflect.Array;

public class C1844u<M extends C1358t<M>, T> {
    protected final int f6263a;
    protected final Class<T> f6264b;
    public final int f6265c;
    protected final boolean f6266d;

    int m10473a(Object obj) {
        return this.f6266d ? m10475b(obj) : m10477c(obj);
    }

    void m10474a(Object obj, C1843s c1843s) {
        if (this.f6266d) {
            m10478c(obj, c1843s);
        } else {
            m10476b(obj, c1843s);
        }
    }

    protected int m10475b(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += m10477c(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected void m10476b(Object obj, C1843s c1843s) {
        try {
            c1843s.m10469e(this.f6265c);
            switch (this.f6263a) {
                case 10:
                    C1357z c1357z = (C1357z) obj;
                    int b = ac.m7338b(this.f6265c);
                    c1843s.m10455a(c1357z);
                    c1843s.m10465c(b, 4);
                    return;
                case 11:
                    c1843s.m10461b((C1357z) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.f6263a);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected int m10477c(Object obj) {
        int b = ac.m7338b(this.f6265c);
        switch (this.f6263a) {
            case 10:
                return C1843s.m10421b(b, (C1357z) obj);
            case 11:
                return C1843s.m10428c(b, (C1357z) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.f6263a);
        }
    }

    protected void m10478c(Object obj, C1843s c1843s) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                m10476b(obj2, c1843s);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1844u)) {
            return false;
        }
        C1844u c1844u = (C1844u) obj;
        return this.f6263a == c1844u.f6263a && this.f6264b == c1844u.f6264b && this.f6265c == c1844u.f6265c && this.f6266d == c1844u.f6266d;
    }

    public int hashCode() {
        return (this.f6266d ? 1 : 0) + ((((((this.f6263a + 1147) * 31) + this.f6264b.hashCode()) * 31) + this.f6265c) * 31);
    }
}
