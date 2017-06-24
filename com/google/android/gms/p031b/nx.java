package com.google.android.gms.p031b;

public interface nx {

    public static final class C1816a extends C1357z {
        private static volatile C1816a[] f6141e;
        public Integer f6142a;
        public C1821f f6143b;
        public C1821f f6144c;
        public Boolean f6145d;

        public C1816a() {
            m10265c();
        }

        public static C1816a[] m10260b() {
            if (f6141e == null) {
                synchronized (C1847x.f6277c) {
                    if (f6141e == null) {
                        f6141e = new C1816a[0];
                    }
                }
            }
            return f6141e;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6142a != null) {
                a += C1843s.m10420b(1, this.f6142a.intValue());
            }
            if (this.f6143b != null) {
                a += C1843s.m10428c(2, this.f6143b);
            }
            if (this.f6144c != null) {
                a += C1843s.m10428c(3, this.f6144c);
            }
            return this.f6145d != null ? a + C1843s.m10423b(4, this.f6145d.booleanValue()) : a;
        }

        public C1816a m10262a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6142a = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 18:
                        if (this.f6143b == null) {
                            this.f6143b = new C1821f();
                        }
                        c1841r.m10384a(this.f6143b);
                        continue;
                    case 26:
                        if (this.f6144c == null) {
                            this.f6144c = new C1821f();
                        }
                        c1841r.m10384a(this.f6144c);
                        continue;
                    case 32:
                        this.f6145d = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f6142a != null) {
                c1843s.m10448a(1, this.f6142a.intValue());
            }
            if (this.f6143b != null) {
                c1843s.m10450a(2, this.f6143b);
            }
            if (this.f6144c != null) {
                c1843s.m10450a(3, this.f6144c);
            }
            if (this.f6145d != null) {
                c1843s.m10452a(4, this.f6145d.booleanValue());
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10262a(c1841r);
        }

        public C1816a m10265c() {
            this.f6142a = null;
            this.f6143b = null;
            this.f6144c = null;
            this.f6145d = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1816a)) {
                return false;
            }
            C1816a c1816a = (C1816a) obj;
            if (this.f6142a == null) {
                if (c1816a.f6142a != null) {
                    return false;
                }
            } else if (!this.f6142a.equals(c1816a.f6142a)) {
                return false;
            }
            if (this.f6143b == null) {
                if (c1816a.f6143b != null) {
                    return false;
                }
            } else if (!this.f6143b.equals(c1816a.f6143b)) {
                return false;
            }
            if (this.f6144c == null) {
                if (c1816a.f6144c != null) {
                    return false;
                }
            } else if (!this.f6144c.equals(c1816a.f6144c)) {
                return false;
            }
            return this.f6145d == null ? c1816a.f6145d == null : this.f6145d.equals(c1816a.f6145d);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6144c == null ? 0 : this.f6144c.hashCode()) + (((this.f6143b == null ? 0 : this.f6143b.hashCode()) + (((this.f6142a == null ? 0 : this.f6142a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.f6145d != null) {
                i = this.f6145d.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1817b extends C1357z {
        private static volatile C1817b[] f6146f;
        public C1818c[] f6147a;
        public String f6148b;
        public Long f6149c;
        public Long f6150d;
        public Integer f6151e;

        public C1817b() {
            m10271c();
        }

        public static C1817b[] m10266b() {
            if (f6146f == null) {
                synchronized (C1847x.f6277c) {
                    if (f6146f == null) {
                        f6146f = new C1817b[0];
                    }
                }
            }
            return f6146f;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6147a != null && this.f6147a.length > 0) {
                for (C1357z c1357z : this.f6147a) {
                    if (c1357z != null) {
                        a += C1843s.m10428c(1, c1357z);
                    }
                }
            }
            if (this.f6148b != null) {
                a += C1843s.m10422b(2, this.f6148b);
            }
            if (this.f6149c != null) {
                a += C1843s.m10432d(3, this.f6149c.longValue());
            }
            if (this.f6150d != null) {
                a += C1843s.m10432d(4, this.f6150d.longValue());
            }
            return this.f6151e != null ? a + C1843s.m10420b(5, this.f6151e.intValue()) : a;
        }

        public C1817b m10268a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = ac.m7339b(c1841r, 10);
                        a = this.f6147a == null ? 0 : this.f6147a.length;
                        Object obj = new C1818c[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6147a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1818c();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1818c();
                        c1841r.m10384a(obj[a]);
                        this.f6147a = obj;
                        continue;
                    case 18:
                        this.f6148b = c1841r.m10398i();
                        continue;
                    case 24:
                        this.f6149c = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 32:
                        this.f6150d = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 40:
                        this.f6151e = Integer.valueOf(c1841r.m10396g());
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f6147a != null && this.f6147a.length > 0) {
                for (C1357z c1357z : this.f6147a) {
                    if (c1357z != null) {
                        c1843s.m10450a(1, c1357z);
                    }
                }
            }
            if (this.f6148b != null) {
                c1843s.m10451a(2, this.f6148b);
            }
            if (this.f6149c != null) {
                c1843s.m10459b(3, this.f6149c.longValue());
            }
            if (this.f6150d != null) {
                c1843s.m10459b(4, this.f6150d.longValue());
            }
            if (this.f6151e != null) {
                c1843s.m10448a(5, this.f6151e.intValue());
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10268a(c1841r);
        }

        public C1817b m10271c() {
            this.f6147a = C1818c.m10272b();
            this.f6148b = null;
            this.f6149c = null;
            this.f6150d = null;
            this.f6151e = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1817b)) {
                return false;
            }
            C1817b c1817b = (C1817b) obj;
            if (!C1847x.m10502a(this.f6147a, c1817b.f6147a)) {
                return false;
            }
            if (this.f6148b == null) {
                if (c1817b.f6148b != null) {
                    return false;
                }
            } else if (!this.f6148b.equals(c1817b.f6148b)) {
                return false;
            }
            if (this.f6149c == null) {
                if (c1817b.f6149c != null) {
                    return false;
                }
            } else if (!this.f6149c.equals(c1817b.f6149c)) {
                return false;
            }
            if (this.f6150d == null) {
                if (c1817b.f6150d != null) {
                    return false;
                }
            } else if (!this.f6150d.equals(c1817b.f6150d)) {
                return false;
            }
            return this.f6151e == null ? c1817b.f6151e == null : this.f6151e.equals(c1817b.f6151e);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6150d == null ? 0 : this.f6150d.hashCode()) + (((this.f6149c == null ? 0 : this.f6149c.hashCode()) + (((this.f6148b == null ? 0 : this.f6148b.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + C1847x.m10497a(this.f6147a)) * 31)) * 31)) * 31)) * 31;
            if (this.f6151e != null) {
                i = this.f6151e.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1818c extends C1357z {
        private static volatile C1818c[] f6152f;
        public String f6153a;
        public String f6154b;
        public Long f6155c;
        public Float f6156d;
        public Double f6157e;

        public C1818c() {
            m10277c();
        }

        public static C1818c[] m10272b() {
            if (f6152f == null) {
                synchronized (C1847x.f6277c) {
                    if (f6152f == null) {
                        f6152f = new C1818c[0];
                    }
                }
            }
            return f6152f;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6153a != null) {
                a += C1843s.m10422b(1, this.f6153a);
            }
            if (this.f6154b != null) {
                a += C1843s.m10422b(2, this.f6154b);
            }
            if (this.f6155c != null) {
                a += C1843s.m10432d(3, this.f6155c.longValue());
            }
            if (this.f6156d != null) {
                a += C1843s.m10419b(4, this.f6156d.floatValue());
            }
            return this.f6157e != null ? a + C1843s.m10418b(5, this.f6157e.doubleValue()) : a;
        }

        public C1818c m10274a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f6153a = c1841r.m10398i();
                        continue;
                    case 18:
                        this.f6154b = c1841r.m10398i();
                        continue;
                    case 24:
                        this.f6155c = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 37:
                        this.f6156d = Float.valueOf(c1841r.m10390d());
                        continue;
                    case 41:
                        this.f6157e = Double.valueOf(c1841r.m10388c());
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f6153a != null) {
                c1843s.m10451a(1, this.f6153a);
            }
            if (this.f6154b != null) {
                c1843s.m10451a(2, this.f6154b);
            }
            if (this.f6155c != null) {
                c1843s.m10459b(3, this.f6155c.longValue());
            }
            if (this.f6156d != null) {
                c1843s.m10447a(4, this.f6156d.floatValue());
            }
            if (this.f6157e != null) {
                c1843s.m10446a(5, this.f6157e.doubleValue());
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10274a(c1841r);
        }

        public C1818c m10277c() {
            this.f6153a = null;
            this.f6154b = null;
            this.f6155c = null;
            this.f6156d = null;
            this.f6157e = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1818c)) {
                return false;
            }
            C1818c c1818c = (C1818c) obj;
            if (this.f6153a == null) {
                if (c1818c.f6153a != null) {
                    return false;
                }
            } else if (!this.f6153a.equals(c1818c.f6153a)) {
                return false;
            }
            if (this.f6154b == null) {
                if (c1818c.f6154b != null) {
                    return false;
                }
            } else if (!this.f6154b.equals(c1818c.f6154b)) {
                return false;
            }
            if (this.f6155c == null) {
                if (c1818c.f6155c != null) {
                    return false;
                }
            } else if (!this.f6155c.equals(c1818c.f6155c)) {
                return false;
            }
            if (this.f6156d == null) {
                if (c1818c.f6156d != null) {
                    return false;
                }
            } else if (!this.f6156d.equals(c1818c.f6156d)) {
                return false;
            }
            return this.f6157e == null ? c1818c.f6157e == null : this.f6157e.equals(c1818c.f6157e);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6156d == null ? 0 : this.f6156d.hashCode()) + (((this.f6155c == null ? 0 : this.f6155c.hashCode()) + (((this.f6154b == null ? 0 : this.f6154b.hashCode()) + (((this.f6153a == null ? 0 : this.f6153a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f6157e != null) {
                i = this.f6157e.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1819d extends C1357z {
        public C1820e[] f6158a;

        public C1819d() {
            m10281b();
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6158a != null && this.f6158a.length > 0) {
                for (C1357z c1357z : this.f6158a) {
                    if (c1357z != null) {
                        a += C1843s.m10428c(1, c1357z);
                    }
                }
            }
            return a;
        }

        public C1819d m10279a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = ac.m7339b(c1841r, 10);
                        a = this.f6158a == null ? 0 : this.f6158a.length;
                        Object obj = new C1820e[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6158a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1820e();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1820e();
                        c1841r.m10384a(obj[a]);
                        this.f6158a = obj;
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f6158a != null && this.f6158a.length > 0) {
                for (C1357z c1357z : this.f6158a) {
                    if (c1357z != null) {
                        c1843s.m10450a(1, c1357z);
                    }
                }
            }
            super.mo1231a(c1843s);
        }

        public C1819d m10281b() {
            this.f6158a = C1820e.m10283b();
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10279a(c1841r);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1819d)) {
                return false;
            }
            return C1847x.m10502a(this.f6158a, ((C1819d) obj).f6158a);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + C1847x.m10497a(this.f6158a);
        }
    }

    public static final class C1820e extends C1357z {
        private static volatile C1820e[] f6159G;
        public C1816a[] f6160A;
        public String f6161B;
        public Integer f6162C;
        public Integer f6163D;
        public Integer f6164E;
        public String f6165F;
        public Integer f6166a;
        public C1817b[] f6167b;
        public C1822g[] f6168c;
        public Long f6169d;
        public Long f6170e;
        public Long f6171f;
        public Long f6172g;
        public Long f6173h;
        public String f6174i;
        public String f6175j;
        public String f6176k;
        public String f6177l;
        public Integer f6178m;
        public String f6179n;
        public String f6180o;
        public String f6181p;
        public Long f6182q;
        public Long f6183r;
        public String f6184s;
        public Boolean f6185t;
        public String f6186u;
        public Long f6187v;
        public Integer f6188w;
        public String f6189x;
        public String f6190y;
        public Boolean f6191z;

        public C1820e() {
            m10288c();
        }

        public static C1820e[] m10283b() {
            if (f6159G == null) {
                synchronized (C1847x.f6277c) {
                    if (f6159G == null) {
                        f6159G = new C1820e[0];
                    }
                }
            }
            return f6159G;
        }

        protected int mo1230a() {
            int i;
            int i2 = 0;
            int a = super.mo1230a();
            if (this.f6166a != null) {
                a += C1843s.m10420b(1, this.f6166a.intValue());
            }
            if (this.f6167b != null && this.f6167b.length > 0) {
                i = a;
                for (C1357z c1357z : this.f6167b) {
                    if (c1357z != null) {
                        i += C1843s.m10428c(2, c1357z);
                    }
                }
                a = i;
            }
            if (this.f6168c != null && this.f6168c.length > 0) {
                i = a;
                for (C1357z c1357z2 : this.f6168c) {
                    if (c1357z2 != null) {
                        i += C1843s.m10428c(3, c1357z2);
                    }
                }
                a = i;
            }
            if (this.f6169d != null) {
                a += C1843s.m10432d(4, this.f6169d.longValue());
            }
            if (this.f6170e != null) {
                a += C1843s.m10432d(5, this.f6170e.longValue());
            }
            if (this.f6171f != null) {
                a += C1843s.m10432d(6, this.f6171f.longValue());
            }
            if (this.f6173h != null) {
                a += C1843s.m10432d(7, this.f6173h.longValue());
            }
            if (this.f6174i != null) {
                a += C1843s.m10422b(8, this.f6174i);
            }
            if (this.f6175j != null) {
                a += C1843s.m10422b(9, this.f6175j);
            }
            if (this.f6176k != null) {
                a += C1843s.m10422b(10, this.f6176k);
            }
            if (this.f6177l != null) {
                a += C1843s.m10422b(11, this.f6177l);
            }
            if (this.f6178m != null) {
                a += C1843s.m10420b(12, this.f6178m.intValue());
            }
            if (this.f6179n != null) {
                a += C1843s.m10422b(13, this.f6179n);
            }
            if (this.f6180o != null) {
                a += C1843s.m10422b(14, this.f6180o);
            }
            if (this.f6181p != null) {
                a += C1843s.m10422b(16, this.f6181p);
            }
            if (this.f6182q != null) {
                a += C1843s.m10432d(17, this.f6182q.longValue());
            }
            if (this.f6183r != null) {
                a += C1843s.m10432d(18, this.f6183r.longValue());
            }
            if (this.f6184s != null) {
                a += C1843s.m10422b(19, this.f6184s);
            }
            if (this.f6185t != null) {
                a += C1843s.m10423b(20, this.f6185t.booleanValue());
            }
            if (this.f6186u != null) {
                a += C1843s.m10422b(21, this.f6186u);
            }
            if (this.f6187v != null) {
                a += C1843s.m10432d(22, this.f6187v.longValue());
            }
            if (this.f6188w != null) {
                a += C1843s.m10420b(23, this.f6188w.intValue());
            }
            if (this.f6189x != null) {
                a += C1843s.m10422b(24, this.f6189x);
            }
            if (this.f6190y != null) {
                a += C1843s.m10422b(25, this.f6190y);
            }
            if (this.f6172g != null) {
                a += C1843s.m10432d(26, this.f6172g.longValue());
            }
            if (this.f6191z != null) {
                a += C1843s.m10423b(28, this.f6191z.booleanValue());
            }
            if (this.f6160A != null && this.f6160A.length > 0) {
                while (i2 < this.f6160A.length) {
                    C1357z c1357z3 = this.f6160A[i2];
                    if (c1357z3 != null) {
                        a += C1843s.m10428c(29, c1357z3);
                    }
                    i2++;
                }
            }
            if (this.f6161B != null) {
                a += C1843s.m10422b(30, this.f6161B);
            }
            if (this.f6162C != null) {
                a += C1843s.m10420b(31, this.f6162C.intValue());
            }
            if (this.f6163D != null) {
                a += C1843s.m10420b(32, this.f6163D.intValue());
            }
            if (this.f6164E != null) {
                a += C1843s.m10420b(33, this.f6164E.intValue());
            }
            return this.f6165F != null ? a + C1843s.m10422b(34, this.f6165F) : a;
        }

        public C1820e m10285a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6166a = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 18:
                        b = ac.m7339b(c1841r, 18);
                        a = this.f6167b == null ? 0 : this.f6167b.length;
                        obj = new C1817b[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6167b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1817b();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1817b();
                        c1841r.m10384a(obj[a]);
                        this.f6167b = obj;
                        continue;
                    case 26:
                        b = ac.m7339b(c1841r, 26);
                        a = this.f6168c == null ? 0 : this.f6168c.length;
                        obj = new C1822g[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6168c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1822g();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1822g();
                        c1841r.m10384a(obj[a]);
                        this.f6168c = obj;
                        continue;
                    case 32:
                        this.f6169d = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 40:
                        this.f6170e = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 48:
                        this.f6171f = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 56:
                        this.f6173h = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 66:
                        this.f6174i = c1841r.m10398i();
                        continue;
                    case 74:
                        this.f6175j = c1841r.m10398i();
                        continue;
                    case 82:
                        this.f6176k = c1841r.m10398i();
                        continue;
                    case 90:
                        this.f6177l = c1841r.m10398i();
                        continue;
                    case 96:
                        this.f6178m = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 106:
                        this.f6179n = c1841r.m10398i();
                        continue;
                    case 114:
                        this.f6180o = c1841r.m10398i();
                        continue;
                    case 130:
                        this.f6181p = c1841r.m10398i();
                        continue;
                    case 136:
                        this.f6182q = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 144:
                        this.f6183r = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 154:
                        this.f6184s = c1841r.m10398i();
                        continue;
                    case 160:
                        this.f6185t = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 170:
                        this.f6186u = c1841r.m10398i();
                        continue;
                    case 176:
                        this.f6187v = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 184:
                        this.f6188w = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 194:
                        this.f6189x = c1841r.m10398i();
                        continue;
                    case 202:
                        this.f6190y = c1841r.m10398i();
                        continue;
                    case 208:
                        this.f6172g = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 224:
                        this.f6191z = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 234:
                        b = ac.m7339b(c1841r, 234);
                        a = this.f6160A == null ? 0 : this.f6160A.length;
                        obj = new C1816a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6160A, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1816a();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1816a();
                        c1841r.m10384a(obj[a]);
                        this.f6160A = obj;
                        continue;
                    case 242:
                        this.f6161B = c1841r.m10398i();
                        continue;
                    case 248:
                        this.f6162C = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 256:
                        this.f6163D = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 264:
                        this.f6164E = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 274:
                        this.f6165F = c1841r.m10398i();
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            int i = 0;
            if (this.f6166a != null) {
                c1843s.m10448a(1, this.f6166a.intValue());
            }
            if (this.f6167b != null && this.f6167b.length > 0) {
                for (C1357z c1357z : this.f6167b) {
                    if (c1357z != null) {
                        c1843s.m10450a(2, c1357z);
                    }
                }
            }
            if (this.f6168c != null && this.f6168c.length > 0) {
                for (C1357z c1357z2 : this.f6168c) {
                    if (c1357z2 != null) {
                        c1843s.m10450a(3, c1357z2);
                    }
                }
            }
            if (this.f6169d != null) {
                c1843s.m10459b(4, this.f6169d.longValue());
            }
            if (this.f6170e != null) {
                c1843s.m10459b(5, this.f6170e.longValue());
            }
            if (this.f6171f != null) {
                c1843s.m10459b(6, this.f6171f.longValue());
            }
            if (this.f6173h != null) {
                c1843s.m10459b(7, this.f6173h.longValue());
            }
            if (this.f6174i != null) {
                c1843s.m10451a(8, this.f6174i);
            }
            if (this.f6175j != null) {
                c1843s.m10451a(9, this.f6175j);
            }
            if (this.f6176k != null) {
                c1843s.m10451a(10, this.f6176k);
            }
            if (this.f6177l != null) {
                c1843s.m10451a(11, this.f6177l);
            }
            if (this.f6178m != null) {
                c1843s.m10448a(12, this.f6178m.intValue());
            }
            if (this.f6179n != null) {
                c1843s.m10451a(13, this.f6179n);
            }
            if (this.f6180o != null) {
                c1843s.m10451a(14, this.f6180o);
            }
            if (this.f6181p != null) {
                c1843s.m10451a(16, this.f6181p);
            }
            if (this.f6182q != null) {
                c1843s.m10459b(17, this.f6182q.longValue());
            }
            if (this.f6183r != null) {
                c1843s.m10459b(18, this.f6183r.longValue());
            }
            if (this.f6184s != null) {
                c1843s.m10451a(19, this.f6184s);
            }
            if (this.f6185t != null) {
                c1843s.m10452a(20, this.f6185t.booleanValue());
            }
            if (this.f6186u != null) {
                c1843s.m10451a(21, this.f6186u);
            }
            if (this.f6187v != null) {
                c1843s.m10459b(22, this.f6187v.longValue());
            }
            if (this.f6188w != null) {
                c1843s.m10448a(23, this.f6188w.intValue());
            }
            if (this.f6189x != null) {
                c1843s.m10451a(24, this.f6189x);
            }
            if (this.f6190y != null) {
                c1843s.m10451a(25, this.f6190y);
            }
            if (this.f6172g != null) {
                c1843s.m10459b(26, this.f6172g.longValue());
            }
            if (this.f6191z != null) {
                c1843s.m10452a(28, this.f6191z.booleanValue());
            }
            if (this.f6160A != null && this.f6160A.length > 0) {
                while (i < this.f6160A.length) {
                    C1357z c1357z3 = this.f6160A[i];
                    if (c1357z3 != null) {
                        c1843s.m10450a(29, c1357z3);
                    }
                    i++;
                }
            }
            if (this.f6161B != null) {
                c1843s.m10451a(30, this.f6161B);
            }
            if (this.f6162C != null) {
                c1843s.m10448a(31, this.f6162C.intValue());
            }
            if (this.f6163D != null) {
                c1843s.m10448a(32, this.f6163D.intValue());
            }
            if (this.f6164E != null) {
                c1843s.m10448a(33, this.f6164E.intValue());
            }
            if (this.f6165F != null) {
                c1843s.m10451a(34, this.f6165F);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10285a(c1841r);
        }

        public C1820e m10288c() {
            this.f6166a = null;
            this.f6167b = C1817b.m10266b();
            this.f6168c = C1822g.m10294b();
            this.f6169d = null;
            this.f6170e = null;
            this.f6171f = null;
            this.f6172g = null;
            this.f6173h = null;
            this.f6174i = null;
            this.f6175j = null;
            this.f6176k = null;
            this.f6177l = null;
            this.f6178m = null;
            this.f6179n = null;
            this.f6180o = null;
            this.f6181p = null;
            this.f6182q = null;
            this.f6183r = null;
            this.f6184s = null;
            this.f6185t = null;
            this.f6186u = null;
            this.f6187v = null;
            this.f6188w = null;
            this.f6189x = null;
            this.f6190y = null;
            this.f6191z = null;
            this.f6160A = C1816a.m10260b();
            this.f6161B = null;
            this.f6162C = null;
            this.f6163D = null;
            this.f6164E = null;
            this.f6165F = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1820e)) {
                return false;
            }
            C1820e c1820e = (C1820e) obj;
            if (this.f6166a == null) {
                if (c1820e.f6166a != null) {
                    return false;
                }
            } else if (!this.f6166a.equals(c1820e.f6166a)) {
                return false;
            }
            if (!C1847x.m10502a(this.f6167b, c1820e.f6167b)) {
                return false;
            }
            if (!C1847x.m10502a(this.f6168c, c1820e.f6168c)) {
                return false;
            }
            if (this.f6169d == null) {
                if (c1820e.f6169d != null) {
                    return false;
                }
            } else if (!this.f6169d.equals(c1820e.f6169d)) {
                return false;
            }
            if (this.f6170e == null) {
                if (c1820e.f6170e != null) {
                    return false;
                }
            } else if (!this.f6170e.equals(c1820e.f6170e)) {
                return false;
            }
            if (this.f6171f == null) {
                if (c1820e.f6171f != null) {
                    return false;
                }
            } else if (!this.f6171f.equals(c1820e.f6171f)) {
                return false;
            }
            if (this.f6172g == null) {
                if (c1820e.f6172g != null) {
                    return false;
                }
            } else if (!this.f6172g.equals(c1820e.f6172g)) {
                return false;
            }
            if (this.f6173h == null) {
                if (c1820e.f6173h != null) {
                    return false;
                }
            } else if (!this.f6173h.equals(c1820e.f6173h)) {
                return false;
            }
            if (this.f6174i == null) {
                if (c1820e.f6174i != null) {
                    return false;
                }
            } else if (!this.f6174i.equals(c1820e.f6174i)) {
                return false;
            }
            if (this.f6175j == null) {
                if (c1820e.f6175j != null) {
                    return false;
                }
            } else if (!this.f6175j.equals(c1820e.f6175j)) {
                return false;
            }
            if (this.f6176k == null) {
                if (c1820e.f6176k != null) {
                    return false;
                }
            } else if (!this.f6176k.equals(c1820e.f6176k)) {
                return false;
            }
            if (this.f6177l == null) {
                if (c1820e.f6177l != null) {
                    return false;
                }
            } else if (!this.f6177l.equals(c1820e.f6177l)) {
                return false;
            }
            if (this.f6178m == null) {
                if (c1820e.f6178m != null) {
                    return false;
                }
            } else if (!this.f6178m.equals(c1820e.f6178m)) {
                return false;
            }
            if (this.f6179n == null) {
                if (c1820e.f6179n != null) {
                    return false;
                }
            } else if (!this.f6179n.equals(c1820e.f6179n)) {
                return false;
            }
            if (this.f6180o == null) {
                if (c1820e.f6180o != null) {
                    return false;
                }
            } else if (!this.f6180o.equals(c1820e.f6180o)) {
                return false;
            }
            if (this.f6181p == null) {
                if (c1820e.f6181p != null) {
                    return false;
                }
            } else if (!this.f6181p.equals(c1820e.f6181p)) {
                return false;
            }
            if (this.f6182q == null) {
                if (c1820e.f6182q != null) {
                    return false;
                }
            } else if (!this.f6182q.equals(c1820e.f6182q)) {
                return false;
            }
            if (this.f6183r == null) {
                if (c1820e.f6183r != null) {
                    return false;
                }
            } else if (!this.f6183r.equals(c1820e.f6183r)) {
                return false;
            }
            if (this.f6184s == null) {
                if (c1820e.f6184s != null) {
                    return false;
                }
            } else if (!this.f6184s.equals(c1820e.f6184s)) {
                return false;
            }
            if (this.f6185t == null) {
                if (c1820e.f6185t != null) {
                    return false;
                }
            } else if (!this.f6185t.equals(c1820e.f6185t)) {
                return false;
            }
            if (this.f6186u == null) {
                if (c1820e.f6186u != null) {
                    return false;
                }
            } else if (!this.f6186u.equals(c1820e.f6186u)) {
                return false;
            }
            if (this.f6187v == null) {
                if (c1820e.f6187v != null) {
                    return false;
                }
            } else if (!this.f6187v.equals(c1820e.f6187v)) {
                return false;
            }
            if (this.f6188w == null) {
                if (c1820e.f6188w != null) {
                    return false;
                }
            } else if (!this.f6188w.equals(c1820e.f6188w)) {
                return false;
            }
            if (this.f6189x == null) {
                if (c1820e.f6189x != null) {
                    return false;
                }
            } else if (!this.f6189x.equals(c1820e.f6189x)) {
                return false;
            }
            if (this.f6190y == null) {
                if (c1820e.f6190y != null) {
                    return false;
                }
            } else if (!this.f6190y.equals(c1820e.f6190y)) {
                return false;
            }
            if (this.f6191z == null) {
                if (c1820e.f6191z != null) {
                    return false;
                }
            } else if (!this.f6191z.equals(c1820e.f6191z)) {
                return false;
            }
            if (!C1847x.m10502a(this.f6160A, c1820e.f6160A)) {
                return false;
            }
            if (this.f6161B == null) {
                if (c1820e.f6161B != null) {
                    return false;
                }
            } else if (!this.f6161B.equals(c1820e.f6161B)) {
                return false;
            }
            if (this.f6162C == null) {
                if (c1820e.f6162C != null) {
                    return false;
                }
            } else if (!this.f6162C.equals(c1820e.f6162C)) {
                return false;
            }
            if (this.f6163D == null) {
                if (c1820e.f6163D != null) {
                    return false;
                }
            } else if (!this.f6163D.equals(c1820e.f6163D)) {
                return false;
            }
            if (this.f6164E == null) {
                if (c1820e.f6164E != null) {
                    return false;
                }
            } else if (!this.f6164E.equals(c1820e.f6164E)) {
                return false;
            }
            return this.f6165F == null ? c1820e.f6165F == null : this.f6165F.equals(c1820e.f6165F);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6164E == null ? 0 : this.f6164E.hashCode()) + (((this.f6163D == null ? 0 : this.f6163D.hashCode()) + (((this.f6162C == null ? 0 : this.f6162C.hashCode()) + (((this.f6161B == null ? 0 : this.f6161B.hashCode()) + (((((this.f6191z == null ? 0 : this.f6191z.hashCode()) + (((this.f6190y == null ? 0 : this.f6190y.hashCode()) + (((this.f6189x == null ? 0 : this.f6189x.hashCode()) + (((this.f6188w == null ? 0 : this.f6188w.hashCode()) + (((this.f6187v == null ? 0 : this.f6187v.hashCode()) + (((this.f6186u == null ? 0 : this.f6186u.hashCode()) + (((this.f6185t == null ? 0 : this.f6185t.hashCode()) + (((this.f6184s == null ? 0 : this.f6184s.hashCode()) + (((this.f6183r == null ? 0 : this.f6183r.hashCode()) + (((this.f6182q == null ? 0 : this.f6182q.hashCode()) + (((this.f6181p == null ? 0 : this.f6181p.hashCode()) + (((this.f6180o == null ? 0 : this.f6180o.hashCode()) + (((this.f6179n == null ? 0 : this.f6179n.hashCode()) + (((this.f6178m == null ? 0 : this.f6178m.hashCode()) + (((this.f6177l == null ? 0 : this.f6177l.hashCode()) + (((this.f6176k == null ? 0 : this.f6176k.hashCode()) + (((this.f6175j == null ? 0 : this.f6175j.hashCode()) + (((this.f6174i == null ? 0 : this.f6174i.hashCode()) + (((this.f6173h == null ? 0 : this.f6173h.hashCode()) + (((this.f6172g == null ? 0 : this.f6172g.hashCode()) + (((this.f6171f == null ? 0 : this.f6171f.hashCode()) + (((this.f6170e == null ? 0 : this.f6170e.hashCode()) + (((this.f6169d == null ? 0 : this.f6169d.hashCode()) + (((((((this.f6166a == null ? 0 : this.f6166a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + C1847x.m10497a(this.f6167b)) * 31) + C1847x.m10497a(this.f6168c)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + C1847x.m10497a(this.f6160A)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f6165F != null) {
                i = this.f6165F.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1821f extends C1357z {
        public long[] f6192a;
        public long[] f6193b;

        public C1821f() {
            m10292b();
        }

        protected int mo1230a() {
            int i;
            int i2;
            int i3 = 0;
            int a = super.mo1230a();
            if (this.f6192a == null || this.f6192a.length <= 0) {
                i = a;
            } else {
                i2 = 0;
                for (long d : this.f6192a) {
                    i2 += C1843s.m10433d(d);
                }
                i = (a + i2) + (this.f6192a.length * 1);
            }
            if (this.f6193b == null || this.f6193b.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.f6193b.length) {
                i2 += C1843s.m10433d(this.f6193b[i3]);
                i3++;
            }
            return (i + i2) + (this.f6193b.length * 1);
        }

        public C1821f m10290a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                Object obj;
                int c;
                Object obj2;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        b = ac.m7339b(c1841r, 8);
                        a = this.f6192a == null ? 0 : this.f6192a.length;
                        obj = new long[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6192a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10392e();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10392e();
                        this.f6192a = obj;
                        continue;
                    case 10:
                        c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10392e();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f6192a == null ? 0 : this.f6192a.length;
                        obj2 = new long[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f6192a, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10392e();
                            b++;
                        }
                        this.f6192a = obj2;
                        c1841r.m10391d(c);
                        continue;
                    case 16:
                        b = ac.m7339b(c1841r, 16);
                        a = this.f6193b == null ? 0 : this.f6193b.length;
                        obj = new long[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6193b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10392e();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10392e();
                        this.f6193b = obj;
                        continue;
                    case 18:
                        c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10392e();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f6193b == null ? 0 : this.f6193b.length;
                        obj2 = new long[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f6193b, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10392e();
                            b++;
                        }
                        this.f6193b = obj2;
                        c1841r.m10391d(c);
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            int i = 0;
            if (this.f6192a != null && this.f6192a.length > 0) {
                for (long a : this.f6192a) {
                    c1843s.m10449a(1, a);
                }
            }
            if (this.f6193b != null && this.f6193b.length > 0) {
                while (i < this.f6193b.length) {
                    c1843s.m10449a(2, this.f6193b[i]);
                    i++;
                }
            }
            super.mo1231a(c1843s);
        }

        public C1821f m10292b() {
            this.f6192a = ac.f4052b;
            this.f6193b = ac.f4052b;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10290a(c1841r);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1821f)) {
                return false;
            }
            C1821f c1821f = (C1821f) obj;
            return !C1847x.m10501a(this.f6192a, c1821f.f6192a) ? false : C1847x.m10501a(this.f6193b, c1821f.f6193b);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + C1847x.m10496a(this.f6192a)) * 31) + C1847x.m10496a(this.f6193b);
        }
    }

    public static final class C1822g extends C1357z {
        private static volatile C1822g[] f6194g;
        public Long f6195a;
        public String f6196b;
        public String f6197c;
        public Long f6198d;
        public Float f6199e;
        public Double f6200f;

        public C1822g() {
            m10299c();
        }

        public static C1822g[] m10294b() {
            if (f6194g == null) {
                synchronized (C1847x.f6277c) {
                    if (f6194g == null) {
                        f6194g = new C1822g[0];
                    }
                }
            }
            return f6194g;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6195a != null) {
                a += C1843s.m10432d(1, this.f6195a.longValue());
            }
            if (this.f6196b != null) {
                a += C1843s.m10422b(2, this.f6196b);
            }
            if (this.f6197c != null) {
                a += C1843s.m10422b(3, this.f6197c);
            }
            if (this.f6198d != null) {
                a += C1843s.m10432d(4, this.f6198d.longValue());
            }
            if (this.f6199e != null) {
                a += C1843s.m10419b(5, this.f6199e.floatValue());
            }
            return this.f6200f != null ? a + C1843s.m10418b(6, this.f6200f.doubleValue()) : a;
        }

        public C1822g m10296a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6195a = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 18:
                        this.f6196b = c1841r.m10398i();
                        continue;
                    case 26:
                        this.f6197c = c1841r.m10398i();
                        continue;
                    case 32:
                        this.f6198d = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 45:
                        this.f6199e = Float.valueOf(c1841r.m10390d());
                        continue;
                    case 49:
                        this.f6200f = Double.valueOf(c1841r.m10388c());
                        continue;
                    default:
                        if (!ac.m7337a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f6195a != null) {
                c1843s.m10459b(1, this.f6195a.longValue());
            }
            if (this.f6196b != null) {
                c1843s.m10451a(2, this.f6196b);
            }
            if (this.f6197c != null) {
                c1843s.m10451a(3, this.f6197c);
            }
            if (this.f6198d != null) {
                c1843s.m10459b(4, this.f6198d.longValue());
            }
            if (this.f6199e != null) {
                c1843s.m10447a(5, this.f6199e.floatValue());
            }
            if (this.f6200f != null) {
                c1843s.m10446a(6, this.f6200f.doubleValue());
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10296a(c1841r);
        }

        public C1822g m10299c() {
            this.f6195a = null;
            this.f6196b = null;
            this.f6197c = null;
            this.f6198d = null;
            this.f6199e = null;
            this.f6200f = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1822g)) {
                return false;
            }
            C1822g c1822g = (C1822g) obj;
            if (this.f6195a == null) {
                if (c1822g.f6195a != null) {
                    return false;
                }
            } else if (!this.f6195a.equals(c1822g.f6195a)) {
                return false;
            }
            if (this.f6196b == null) {
                if (c1822g.f6196b != null) {
                    return false;
                }
            } else if (!this.f6196b.equals(c1822g.f6196b)) {
                return false;
            }
            if (this.f6197c == null) {
                if (c1822g.f6197c != null) {
                    return false;
                }
            } else if (!this.f6197c.equals(c1822g.f6197c)) {
                return false;
            }
            if (this.f6198d == null) {
                if (c1822g.f6198d != null) {
                    return false;
                }
            } else if (!this.f6198d.equals(c1822g.f6198d)) {
                return false;
            }
            if (this.f6199e == null) {
                if (c1822g.f6199e != null) {
                    return false;
                }
            } else if (!this.f6199e.equals(c1822g.f6199e)) {
                return false;
            }
            return this.f6200f == null ? c1822g.f6200f == null : this.f6200f.equals(c1822g.f6200f);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6199e == null ? 0 : this.f6199e.hashCode()) + (((this.f6198d == null ? 0 : this.f6198d.hashCode()) + (((this.f6197c == null ? 0 : this.f6197c.hashCode()) + (((this.f6196b == null ? 0 : this.f6196b.hashCode()) + (((this.f6195a == null ? 0 : this.f6195a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f6200f != null) {
                i = this.f6200f.hashCode();
            }
            return hashCode + i;
        }
    }
}
