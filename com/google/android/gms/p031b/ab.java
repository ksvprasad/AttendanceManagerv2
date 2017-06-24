package com.google.android.gms.p031b;

import java.util.Arrays;

final class ab {
    final int f4049a;
    final byte[] f4050b;

    ab(int i, byte[] bArr) {
        this.f4049a = i;
        this.f4050b = bArr;
    }

    int m7333a() {
        return (C1843s.m10437f(this.f4049a) + 0) + this.f4050b.length;
    }

    void m7334a(C1843s c1843s) {
        c1843s.m10469e(this.f4049a);
        c1843s.m10468d(this.f4050b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return this.f4049a == abVar.f4049a && Arrays.equals(this.f4050b, abVar.f4050b);
    }

    public int hashCode() {
        return ((this.f4049a + 527) * 31) + Arrays.hashCode(this.f4050b);
    }
}
