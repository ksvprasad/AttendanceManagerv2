package android.support.v4.p015g;

public class C0374e<E> implements Cloneable {
    private static final Object f1118a = new Object();
    private boolean f1119b;
    private long[] f1120c;
    private Object[] f1121d;
    private int f1122e;

    public C0374e() {
        this(10);
    }

    public C0374e(int i) {
        this.f1119b = false;
        if (i == 0) {
            this.f1120c = C0371b.f1114b;
            this.f1121d = C0371b.f1115c;
        } else {
            int b = C0371b.m1909b(i);
            this.f1120c = new long[b];
            this.f1121d = new Object[b];
        }
        this.f1122e = 0;
    }

    private void m1913d() {
        int i = this.f1122e;
        long[] jArr = this.f1120c;
        Object[] objArr = this.f1121d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1118a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1119b = false;
        this.f1122e = i2;
    }

    public C0374e<E> m1914a() {
        try {
            C0374e<E> c0374e = (C0374e) super.clone();
            try {
                c0374e.f1120c = (long[]) this.f1120c.clone();
                c0374e.f1121d = (Object[]) this.f1121d.clone();
                return c0374e;
            } catch (CloneNotSupportedException e) {
                return c0374e;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1915a(long j) {
        return m1916a(j, null);
    }

    public E m1916a(long j, E e) {
        int a = C0371b.m1907a(this.f1120c, this.f1122e, j);
        return (a < 0 || this.f1121d[a] == f1118a) ? e : this.f1121d[a];
    }

    public void m1917a(int i) {
        if (this.f1121d[i] != f1118a) {
            this.f1121d[i] = f1118a;
            this.f1119b = true;
        }
    }

    public int m1918b() {
        if (this.f1119b) {
            m1913d();
        }
        return this.f1122e;
    }

    public long m1919b(int i) {
        if (this.f1119b) {
            m1913d();
        }
        return this.f1120c[i];
    }

    public void m1920b(long j) {
        int a = C0371b.m1907a(this.f1120c, this.f1122e, j);
        if (a >= 0 && this.f1121d[a] != f1118a) {
            this.f1121d[a] = f1118a;
            this.f1119b = true;
        }
    }

    public void m1921b(long j, E e) {
        int a = C0371b.m1907a(this.f1120c, this.f1122e, j);
        if (a >= 0) {
            this.f1121d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1122e || this.f1121d[a] != f1118a) {
            if (this.f1119b && this.f1122e >= this.f1120c.length) {
                m1913d();
                a = C0371b.m1907a(this.f1120c, this.f1122e, j) ^ -1;
            }
            if (this.f1122e >= this.f1120c.length) {
                int b = C0371b.m1909b(this.f1122e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f1120c, 0, obj, 0, this.f1120c.length);
                System.arraycopy(this.f1121d, 0, obj2, 0, this.f1121d.length);
                this.f1120c = obj;
                this.f1121d = obj2;
            }
            if (this.f1122e - a != 0) {
                System.arraycopy(this.f1120c, a, this.f1120c, a + 1, this.f1122e - a);
                System.arraycopy(this.f1121d, a, this.f1121d, a + 1, this.f1122e - a);
            }
            this.f1120c[a] = j;
            this.f1121d[a] = e;
            this.f1122e++;
            return;
        }
        this.f1120c[a] = j;
        this.f1121d[a] = e;
    }

    public E m1922c(int i) {
        if (this.f1119b) {
            m1913d();
        }
        return this.f1121d[i];
    }

    public void m1923c() {
        int i = this.f1122e;
        Object[] objArr = this.f1121d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1122e = 0;
        this.f1119b = false;
    }

    public /* synthetic */ Object clone() {
        return m1914a();
    }

    public String toString() {
        if (m1918b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1122e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1122e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1919b(i));
            stringBuilder.append('=');
            C0374e c = m1922c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
