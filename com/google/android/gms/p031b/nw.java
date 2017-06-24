package com.google.android.gms.p031b;

import com.google.android.gms.p031b.nv.C1807a;

public interface nw {

    public static final class C1813a extends C1357z {
        private static volatile C1813a[] f6128d;
        public String f6129a;
        public Boolean f6130b;
        public Boolean f6131c;

        public C1813a() {
            m10248c();
        }

        public static C1813a[] m10243b() {
            if (f6128d == null) {
                synchronized (C1847x.f6277c) {
                    if (f6128d == null) {
                        f6128d = new C1813a[0];
                    }
                }
            }
            return f6128d;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6129a != null) {
                a += C1843s.m10422b(1, this.f6129a);
            }
            if (this.f6130b != null) {
                a += C1843s.m10423b(2, this.f6130b.booleanValue());
            }
            return this.f6131c != null ? a + C1843s.m10423b(3, this.f6131c.booleanValue()) : a;
        }

        public C1813a m10245a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f6129a = c1841r.m10398i();
                        continue;
                    case 16:
                        this.f6130b = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 24:
                        this.f6131c = Boolean.valueOf(c1841r.m10397h());
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
            if (this.f6129a != null) {
                c1843s.m10451a(1, this.f6129a);
            }
            if (this.f6130b != null) {
                c1843s.m10452a(2, this.f6130b.booleanValue());
            }
            if (this.f6131c != null) {
                c1843s.m10452a(3, this.f6131c.booleanValue());
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10245a(c1841r);
        }

        public C1813a m10248c() {
            this.f6129a = null;
            this.f6130b = null;
            this.f6131c = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1813a)) {
                return false;
            }
            C1813a c1813a = (C1813a) obj;
            if (this.f6129a == null) {
                if (c1813a.f6129a != null) {
                    return false;
                }
            } else if (!this.f6129a.equals(c1813a.f6129a)) {
                return false;
            }
            if (this.f6130b == null) {
                if (c1813a.f6130b != null) {
                    return false;
                }
            } else if (!this.f6130b.equals(c1813a.f6130b)) {
                return false;
            }
            return this.f6131c == null ? c1813a.f6131c == null : this.f6131c.equals(c1813a.f6131c);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6130b == null ? 0 : this.f6130b.hashCode()) + (((this.f6129a == null ? 0 : this.f6129a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.f6131c != null) {
                i = this.f6131c.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1814b extends C1357z {
        public Long f6132a;
        public String f6133b;
        public Integer f6134c;
        public C1815c[] f6135d;
        public C1813a[] f6136e;
        public C1807a[] f6137f;

        public C1814b() {
            m10252b();
        }

        protected int mo1230a() {
            int i;
            int i2 = 0;
            int a = super.mo1230a();
            if (this.f6132a != null) {
                a += C1843s.m10432d(1, this.f6132a.longValue());
            }
            if (this.f6133b != null) {
                a += C1843s.m10422b(2, this.f6133b);
            }
            if (this.f6134c != null) {
                a += C1843s.m10420b(3, this.f6134c.intValue());
            }
            if (this.f6135d != null && this.f6135d.length > 0) {
                i = a;
                for (C1357z c1357z : this.f6135d) {
                    if (c1357z != null) {
                        i += C1843s.m10428c(4, c1357z);
                    }
                }
                a = i;
            }
            if (this.f6136e != null && this.f6136e.length > 0) {
                i = a;
                for (C1357z c1357z2 : this.f6136e) {
                    if (c1357z2 != null) {
                        i += C1843s.m10428c(5, c1357z2);
                    }
                }
                a = i;
            }
            if (this.f6137f != null && this.f6137f.length > 0) {
                while (i2 < this.f6137f.length) {
                    C1357z c1357z3 = this.f6137f[i2];
                    if (c1357z3 != null) {
                        a += C1843s.m10428c(6, c1357z3);
                    }
                    i2++;
                }
            }
            return a;
        }

        public C1814b m10250a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6132a = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 18:
                        this.f6133b = c1841r.m10398i();
                        continue;
                    case 24:
                        this.f6134c = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 34:
                        b = ac.m7339b(c1841r, 34);
                        a = this.f6135d == null ? 0 : this.f6135d.length;
                        obj = new C1815c[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6135d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1815c();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1815c();
                        c1841r.m10384a(obj[a]);
                        this.f6135d = obj;
                        continue;
                    case 42:
                        b = ac.m7339b(c1841r, 42);
                        a = this.f6136e == null ? 0 : this.f6136e.length;
                        obj = new C1813a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6136e, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1813a();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1813a();
                        c1841r.m10384a(obj[a]);
                        this.f6136e = obj;
                        continue;
                    case 50:
                        b = ac.m7339b(c1841r, 50);
                        a = this.f6137f == null ? 0 : this.f6137f.length;
                        obj = new C1807a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6137f, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1807a();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1807a();
                        c1841r.m10384a(obj[a]);
                        this.f6137f = obj;
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
            if (this.f6132a != null) {
                c1843s.m10459b(1, this.f6132a.longValue());
            }
            if (this.f6133b != null) {
                c1843s.m10451a(2, this.f6133b);
            }
            if (this.f6134c != null) {
                c1843s.m10448a(3, this.f6134c.intValue());
            }
            if (this.f6135d != null && this.f6135d.length > 0) {
                for (C1357z c1357z : this.f6135d) {
                    if (c1357z != null) {
                        c1843s.m10450a(4, c1357z);
                    }
                }
            }
            if (this.f6136e != null && this.f6136e.length > 0) {
                for (C1357z c1357z2 : this.f6136e) {
                    if (c1357z2 != null) {
                        c1843s.m10450a(5, c1357z2);
                    }
                }
            }
            if (this.f6137f != null && this.f6137f.length > 0) {
                while (i < this.f6137f.length) {
                    C1357z c1357z3 = this.f6137f[i];
                    if (c1357z3 != null) {
                        c1843s.m10450a(6, c1357z3);
                    }
                    i++;
                }
            }
            super.mo1231a(c1843s);
        }

        public C1814b m10252b() {
            this.f6132a = null;
            this.f6133b = null;
            this.f6134c = null;
            this.f6135d = C1815c.m10254b();
            this.f6136e = C1813a.m10243b();
            this.f6137f = C1807a.m10209b();
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10250a(c1841r);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1814b)) {
                return false;
            }
            C1814b c1814b = (C1814b) obj;
            if (this.f6132a == null) {
                if (c1814b.f6132a != null) {
                    return false;
                }
            } else if (!this.f6132a.equals(c1814b.f6132a)) {
                return false;
            }
            if (this.f6133b == null) {
                if (c1814b.f6133b != null) {
                    return false;
                }
            } else if (!this.f6133b.equals(c1814b.f6133b)) {
                return false;
            }
            if (this.f6134c == null) {
                if (c1814b.f6134c != null) {
                    return false;
                }
            } else if (!this.f6134c.equals(c1814b.f6134c)) {
                return false;
            }
            return !C1847x.m10502a(this.f6135d, c1814b.f6135d) ? false : !C1847x.m10502a(this.f6136e, c1814b.f6136e) ? false : C1847x.m10502a(this.f6137f, c1814b.f6137f);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6133b == null ? 0 : this.f6133b.hashCode()) + (((this.f6132a == null ? 0 : this.f6132a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.f6134c != null) {
                i = this.f6134c.hashCode();
            }
            return ((((((hashCode + i) * 31) + C1847x.m10497a(this.f6135d)) * 31) + C1847x.m10497a(this.f6136e)) * 31) + C1847x.m10497a(this.f6137f);
        }
    }

    public static final class C1815c extends C1357z {
        private static volatile C1815c[] f6138c;
        public String f6139a;
        public String f6140b;

        public C1815c() {
            m10259c();
        }

        public static C1815c[] m10254b() {
            if (f6138c == null) {
                synchronized (C1847x.f6277c) {
                    if (f6138c == null) {
                        f6138c = new C1815c[0];
                    }
                }
            }
            return f6138c;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6139a != null) {
                a += C1843s.m10422b(1, this.f6139a);
            }
            return this.f6140b != null ? a + C1843s.m10422b(2, this.f6140b) : a;
        }

        public C1815c m10256a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f6139a = c1841r.m10398i();
                        continue;
                    case 18:
                        this.f6140b = c1841r.m10398i();
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
            if (this.f6139a != null) {
                c1843s.m10451a(1, this.f6139a);
            }
            if (this.f6140b != null) {
                c1843s.m10451a(2, this.f6140b);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10256a(c1841r);
        }

        public C1815c m10259c() {
            this.f6139a = null;
            this.f6140b = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1815c)) {
                return false;
            }
            C1815c c1815c = (C1815c) obj;
            if (this.f6139a == null) {
                if (c1815c.f6139a != null) {
                    return false;
                }
            } else if (!this.f6139a.equals(c1815c.f6139a)) {
                return false;
            }
            return this.f6140b == null ? c1815c.f6140b == null : this.f6140b.equals(c1815c.f6140b);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6139a == null ? 0 : this.f6139a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.f6140b != null) {
                i = this.f6140b.hashCode();
            }
            return hashCode + i;
        }
    }
}
