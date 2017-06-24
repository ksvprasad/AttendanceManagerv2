package android.support.v4.p015g;

import java.util.Map;

public class C0369j<K, V> {
    static Object[] f1105b;
    static int f1106c;
    static Object[] f1107d;
    static int f1108e;
    int[] f1109f;
    Object[] f1110g;
    int f1111h;

    public C0369j() {
        this.f1109f = C0371b.f1113a;
        this.f1110g = C0371b.f1115c;
        this.f1111h = 0;
    }

    public C0369j(int i) {
        if (i == 0) {
            this.f1109f = C0371b.f1113a;
            this.f1110g = C0371b.f1115c;
        } else {
            m1892e(i);
        }
        this.f1111h = 0;
    }

    private static void m1891a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0370a.class) {
                if (f1108e < 10) {
                    objArr[0] = f1107d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1107d = objArr;
                    f1108e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0370a.class) {
                if (f1106c < 10) {
                    objArr[0] = f1105b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1105b = objArr;
                    f1106c++;
                }
            }
        }
    }

    private void m1892e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0370a.class) {
                if (f1107d != null) {
                    objArr = f1107d;
                    this.f1110g = objArr;
                    f1107d = (Object[]) objArr[0];
                    this.f1109f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1108e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0370a.class) {
                if (f1105b != null) {
                    objArr = f1105b;
                    this.f1110g = objArr;
                    f1105b = (Object[]) objArr[0];
                    this.f1109f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1106c--;
                    return;
                }
            }
        }
        this.f1109f = new int[i];
        this.f1110g = new Object[(i << 1)];
    }

    int m1893a() {
        int i = this.f1111h;
        if (i == 0) {
            return -1;
        }
        int a = C0371b.m1906a(this.f1109f, i, 0);
        if (a < 0 || this.f1110g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1109f[i2] == 0) {
            if (this.f1110g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f1109f[a] == 0) {
            if (this.f1110g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int m1894a(Object obj) {
        return obj == null ? m1893a() : m1895a(obj, obj.hashCode());
    }

    int m1895a(Object obj, int i) {
        int i2 = this.f1111h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0371b.m1906a(this.f1109f, i2, i);
        if (a < 0 || obj.equals(this.f1110g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1109f[i3] == i) {
            if (obj.equals(this.f1110g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f1109f[a] == i) {
            if (obj.equals(this.f1110g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V m1896a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f1110g[i2];
        this.f1110g[i2] = v;
        return v2;
    }

    public void m1897a(int i) {
        if (this.f1109f.length < i) {
            Object obj = this.f1109f;
            Object obj2 = this.f1110g;
            m1892e(i);
            if (this.f1111h > 0) {
                System.arraycopy(obj, 0, this.f1109f, 0, this.f1111h);
                System.arraycopy(obj2, 0, this.f1110g, 0, this.f1111h << 1);
            }
            C0369j.m1891a(obj, obj2, this.f1111h);
        }
    }

    public void m1898a(C0369j<? extends K, ? extends V> c0369j) {
        int i = 0;
        int i2 = c0369j.f1111h;
        m1897a(this.f1111h + i2);
        if (this.f1111h != 0) {
            while (i < i2) {
                put(c0369j.m1900b(i), c0369j.m1901c(i));
                i++;
            }
        } else if (i2 > 0) {
            System.arraycopy(c0369j.f1109f, 0, this.f1109f, 0, i2);
            System.arraycopy(c0369j.f1110g, 0, this.f1110g, 0, i2 << 1);
            this.f1111h = i2;
        }
    }

    int m1899b(Object obj) {
        int i = 1;
        int i2 = this.f1111h * 2;
        Object[] objArr = this.f1110g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K m1900b(int i) {
        return this.f1110g[i << 1];
    }

    public V m1901c(int i) {
        return this.f1110g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f1111h != 0) {
            C0369j.m1891a(this.f1109f, this.f1110g, this.f1111h);
            this.f1109f = C0371b.f1113a;
            this.f1110g = C0371b.f1115c;
            this.f1111h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return m1894a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1899b(obj) >= 0;
    }

    public V m1902d(int i) {
        int i2 = 8;
        V v = this.f1110g[(i << 1) + 1];
        if (this.f1111h <= 1) {
            C0369j.m1891a(this.f1109f, this.f1110g, this.f1111h);
            this.f1109f = C0371b.f1113a;
            this.f1110g = C0371b.f1115c;
            this.f1111h = 0;
        } else if (this.f1109f.length <= 8 || this.f1111h >= this.f1109f.length / 3) {
            this.f1111h--;
            if (i < this.f1111h) {
                System.arraycopy(this.f1109f, i + 1, this.f1109f, i, this.f1111h - i);
                System.arraycopy(this.f1110g, (i + 1) << 1, this.f1110g, i << 1, (this.f1111h - i) << 1);
            }
            this.f1110g[this.f1111h << 1] = null;
            this.f1110g[(this.f1111h << 1) + 1] = null;
        } else {
            if (this.f1111h > 8) {
                i2 = this.f1111h + (this.f1111h >> 1);
            }
            Object obj = this.f1109f;
            Object obj2 = this.f1110g;
            m1892e(i2);
            this.f1111h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f1109f, 0, i);
                System.arraycopy(obj2, 0, this.f1110g, 0, i << 1);
            }
            if (i < this.f1111h) {
                System.arraycopy(obj, i + 1, this.f1109f, i, this.f1111h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f1110g, i << 1, (this.f1111h - i) << 1);
            }
        }
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f1111h) {
            try {
                Object b = m1900b(i);
                Object c = m1901c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int a = m1894a(obj);
        return a >= 0 ? this.f1110g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f1109f;
        Object[] objArr = this.f1110g;
        int i = this.f1111h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f1111h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m1893a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1895a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f1110g[i3];
            this.f1110g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f1111h >= this.f1109f.length) {
            if (this.f1111h >= 8) {
                i2 = this.f1111h + (this.f1111h >> 1);
            } else if (this.f1111h < 4) {
                i2 = 4;
            }
            Object obj = this.f1109f;
            Object obj2 = this.f1110g;
            m1892e(i2);
            if (this.f1109f.length > 0) {
                System.arraycopy(obj, 0, this.f1109f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f1110g, 0, obj2.length);
            }
            C0369j.m1891a(obj, obj2, this.f1111h);
        }
        if (a < this.f1111h) {
            System.arraycopy(this.f1109f, a, this.f1109f, a + 1, this.f1111h - a);
            System.arraycopy(this.f1110g, a << 1, this.f1110g, (a + 1) << 1, (this.f1111h - a) << 1);
        }
        this.f1109f[a] = i;
        this.f1110g[a << 1] = k;
        this.f1110g[(a << 1) + 1] = v;
        this.f1111h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m1894a(obj);
        return a >= 0 ? m1902d(a) : null;
    }

    public int size() {
        return this.f1111h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1111h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1111h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0369j b = m1900b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1901c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
