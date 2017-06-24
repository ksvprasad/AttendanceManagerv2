package com.google.android.gms.p031b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class C1846w implements Cloneable {
    private C1844u<?, ?> f6272a;
    private Object f6273b;
    private List<ab> f6274c = new ArrayList();

    C1846w() {
    }

    private byte[] m10490c() {
        byte[] bArr = new byte[m10491a()];
        m10493a(C1843s.m10412a(bArr));
        return bArr;
    }

    int m10491a() {
        if (this.f6273b != null) {
            return this.f6272a.m10473a(this.f6273b);
        }
        int i = 0;
        for (ab a : this.f6274c) {
            i = a.m7333a() + i;
        }
        return i;
    }

    void m10492a(ab abVar) {
        this.f6274c.add(abVar);
    }

    void m10493a(C1843s c1843s) {
        if (this.f6273b != null) {
            this.f6272a.m10474a(this.f6273b, c1843s);
            return;
        }
        for (ab a : this.f6274c) {
            a.m7334a(c1843s);
        }
    }

    public final C1846w m10494b() {
        C1846w c1846w = new C1846w();
        try {
            c1846w.f6272a = this.f6272a;
            if (this.f6274c == null) {
                c1846w.f6274c = null;
            } else {
                c1846w.f6274c.addAll(this.f6274c);
            }
            if (this.f6273b != null) {
                if (this.f6273b instanceof C1357z) {
                    c1846w.f6273b = (C1357z) ((C1357z) this.f6273b).clone();
                } else if (this.f6273b instanceof byte[]) {
                    c1846w.f6273b = ((byte[]) this.f6273b).clone();
                } else if (this.f6273b instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.f6273b;
                    r4 = new byte[bArr.length][];
                    c1846w.f6273b = r4;
                    for (r2 = 0; r2 < bArr.length; r2++) {
                        r4[r2] = (byte[]) bArr[r2].clone();
                    }
                } else if (this.f6273b instanceof boolean[]) {
                    c1846w.f6273b = ((boolean[]) this.f6273b).clone();
                } else if (this.f6273b instanceof int[]) {
                    c1846w.f6273b = ((int[]) this.f6273b).clone();
                } else if (this.f6273b instanceof long[]) {
                    c1846w.f6273b = ((long[]) this.f6273b).clone();
                } else if (this.f6273b instanceof float[]) {
                    c1846w.f6273b = ((float[]) this.f6273b).clone();
                } else if (this.f6273b instanceof double[]) {
                    c1846w.f6273b = ((double[]) this.f6273b).clone();
                } else if (this.f6273b instanceof C1357z[]) {
                    C1357z[] c1357zArr = (C1357z[]) this.f6273b;
                    r4 = new C1357z[c1357zArr.length];
                    c1846w.f6273b = r4;
                    for (r2 = 0; r2 < c1357zArr.length; r2++) {
                        r4[r2] = (C1357z) c1357zArr[r2].clone();
                    }
                }
            }
            return c1846w;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Object clone() {
        return m10494b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1846w)) {
            return false;
        }
        C1846w c1846w = (C1846w) obj;
        if (this.f6273b != null && c1846w.f6273b != null) {
            return this.f6272a == c1846w.f6272a ? !this.f6272a.f6264b.isArray() ? this.f6273b.equals(c1846w.f6273b) : this.f6273b instanceof byte[] ? Arrays.equals((byte[]) this.f6273b, (byte[]) c1846w.f6273b) : this.f6273b instanceof int[] ? Arrays.equals((int[]) this.f6273b, (int[]) c1846w.f6273b) : this.f6273b instanceof long[] ? Arrays.equals((long[]) this.f6273b, (long[]) c1846w.f6273b) : this.f6273b instanceof float[] ? Arrays.equals((float[]) this.f6273b, (float[]) c1846w.f6273b) : this.f6273b instanceof double[] ? Arrays.equals((double[]) this.f6273b, (double[]) c1846w.f6273b) : this.f6273b instanceof boolean[] ? Arrays.equals((boolean[]) this.f6273b, (boolean[]) c1846w.f6273b) : Arrays.deepEquals((Object[]) this.f6273b, (Object[]) c1846w.f6273b) : false;
        } else {
            if (this.f6274c != null && c1846w.f6274c != null) {
                return this.f6274c.equals(c1846w.f6274c);
            }
            try {
                return Arrays.equals(m10490c(), c1846w.m10490c());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(m10490c()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
