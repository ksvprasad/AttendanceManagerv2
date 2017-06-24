package android.support.v4.p015g;

public class C0386k<E> implements Cloneable {
    private static final Object f1148a = new Object();
    private boolean f1149b;
    private int[] f1150c;
    private Object[] f1151d;
    private int f1152e;

    public C0386k() {
        this(10);
    }

    public C0386k(int i) {
        this.f1149b = false;
        if (i == 0) {
            this.f1150c = C0371b.f1113a;
            this.f1151d = C0371b.f1115c;
        } else {
            int a = C0371b.m1905a(i);
            this.f1150c = new int[a];
            this.f1151d = new Object[a];
        }
        this.f1152e = 0;
    }

    private void m1942d() {
        int i = this.f1152e;
        int[] iArr = this.f1150c;
        Object[] objArr = this.f1151d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1148a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1149b = false;
        this.f1152e = i2;
    }

    public C0386k<E> m1943a() {
        try {
            C0386k<E> c0386k = (C0386k) super.clone();
            try {
                c0386k.f1150c = (int[]) this.f1150c.clone();
                c0386k.f1151d = (Object[]) this.f1151d.clone();
                return c0386k;
            } catch (CloneNotSupportedException e) {
                return c0386k;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1944a(int i) {
        return m1945a(i, null);
    }

    public E m1945a(int i, E e) {
        int a = C0371b.m1906a(this.f1150c, this.f1152e, i);
        return (a < 0 || this.f1151d[a] == f1148a) ? e : this.f1151d[a];
    }

    public int m1946b() {
        if (this.f1149b) {
            m1942d();
        }
        return this.f1152e;
    }

    public void m1947b(int i) {
        int a = C0371b.m1906a(this.f1150c, this.f1152e, i);
        if (a >= 0 && this.f1151d[a] != f1148a) {
            this.f1151d[a] = f1148a;
            this.f1149b = true;
        }
    }

    public void m1948b(int i, E e) {
        int a = C0371b.m1906a(this.f1150c, this.f1152e, i);
        if (a >= 0) {
            this.f1151d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1152e || this.f1151d[a] != f1148a) {
            if (this.f1149b && this.f1152e >= this.f1150c.length) {
                m1942d();
                a = C0371b.m1906a(this.f1150c, this.f1152e, i) ^ -1;
            }
            if (this.f1152e >= this.f1150c.length) {
                int a2 = C0371b.m1905a(this.f1152e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f1150c, 0, obj, 0, this.f1150c.length);
                System.arraycopy(this.f1151d, 0, obj2, 0, this.f1151d.length);
                this.f1150c = obj;
                this.f1151d = obj2;
            }
            if (this.f1152e - a != 0) {
                System.arraycopy(this.f1150c, a, this.f1150c, a + 1, this.f1152e - a);
                System.arraycopy(this.f1151d, a, this.f1151d, a + 1, this.f1152e - a);
            }
            this.f1150c[a] = i;
            this.f1151d[a] = e;
            this.f1152e++;
            return;
        }
        this.f1150c[a] = i;
        this.f1151d[a] = e;
    }

    public void m1949c() {
        int i = this.f1152e;
        Object[] objArr = this.f1151d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1152e = 0;
        this.f1149b = false;
    }

    public void m1950c(int i) {
        m1947b(i);
    }

    public /* synthetic */ Object clone() {
        return m1943a();
    }

    public int m1951d(int i) {
        if (this.f1149b) {
            m1942d();
        }
        return this.f1150c[i];
    }

    public E m1952e(int i) {
        if (this.f1149b) {
            m1942d();
        }
        return this.f1151d[i];
    }

    public int m1953f(int i) {
        if (this.f1149b) {
            m1942d();
        }
        return C0371b.m1906a(this.f1150c, this.f1152e, i);
    }

    public String toString() {
        if (m1946b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1152e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1152e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1951d(i));
            stringBuilder.append('=');
            C0386k e = m1952e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
