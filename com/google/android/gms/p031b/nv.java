package com.google.android.gms.p031b;

public interface nv {

    public static final class C1807a extends C1357z {
        private static volatile C1807a[] f6100d;
        public Integer f6101a;
        public C1811e[] f6102b;
        public C1808b[] f6103c;

        public C1807a() {
            m10214c();
        }

        public static C1807a[] m10209b() {
            if (f6100d == null) {
                synchronized (C1847x.f6277c) {
                    if (f6100d == null) {
                        f6100d = new C1807a[0];
                    }
                }
            }
            return f6100d;
        }

        protected int mo1230a() {
            int i = 0;
            int a = super.mo1230a();
            if (this.f6101a != null) {
                a += C1843s.m10420b(1, this.f6101a.intValue());
            }
            if (this.f6102b != null && this.f6102b.length > 0) {
                int i2 = a;
                for (C1357z c1357z : this.f6102b) {
                    if (c1357z != null) {
                        i2 += C1843s.m10428c(2, c1357z);
                    }
                }
                a = i2;
            }
            if (this.f6103c != null && this.f6103c.length > 0) {
                while (i < this.f6103c.length) {
                    C1357z c1357z2 = this.f6103c[i];
                    if (c1357z2 != null) {
                        a += C1843s.m10428c(3, c1357z2);
                    }
                    i++;
                }
            }
            return a;
        }

        public C1807a m10211a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                Object obj;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6101a = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 18:
                        b = ac.m7339b(c1841r, 18);
                        a = this.f6102b == null ? 0 : this.f6102b.length;
                        obj = new C1811e[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6102b, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1811e();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1811e();
                        c1841r.m10384a(obj[a]);
                        this.f6102b = obj;
                        continue;
                    case 26:
                        b = ac.m7339b(c1841r, 26);
                        a = this.f6103c == null ? 0 : this.f6103c.length;
                        obj = new C1808b[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6103c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1808b();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1808b();
                        c1841r.m10384a(obj[a]);
                        this.f6103c = obj;
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
            if (this.f6101a != null) {
                c1843s.m10448a(1, this.f6101a.intValue());
            }
            if (this.f6102b != null && this.f6102b.length > 0) {
                for (C1357z c1357z : this.f6102b) {
                    if (c1357z != null) {
                        c1843s.m10450a(2, c1357z);
                    }
                }
            }
            if (this.f6103c != null && this.f6103c.length > 0) {
                while (i < this.f6103c.length) {
                    C1357z c1357z2 = this.f6103c[i];
                    if (c1357z2 != null) {
                        c1843s.m10450a(3, c1357z2);
                    }
                    i++;
                }
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10211a(c1841r);
        }

        public C1807a m10214c() {
            this.f6101a = null;
            this.f6102b = C1811e.m10232b();
            this.f6103c = C1808b.m10215b();
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1807a)) {
                return false;
            }
            C1807a c1807a = (C1807a) obj;
            if (this.f6101a == null) {
                if (c1807a.f6101a != null) {
                    return false;
                }
            } else if (!this.f6101a.equals(c1807a.f6101a)) {
                return false;
            }
            return !C1847x.m10502a(this.f6102b, c1807a.f6102b) ? false : C1847x.m10502a(this.f6103c, c1807a.f6103c);
        }

        public int hashCode() {
            return (((((this.f6101a == null ? 0 : this.f6101a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + C1847x.m10497a(this.f6102b)) * 31) + C1847x.m10497a(this.f6103c);
        }
    }

    public static final class C1808b extends C1357z {
        private static volatile C1808b[] f6104f;
        public Integer f6105a;
        public String f6106b;
        public C1809c[] f6107c;
        public Boolean f6108d;
        public C1810d f6109e;

        public C1808b() {
            m10220c();
        }

        public static C1808b[] m10215b() {
            if (f6104f == null) {
                synchronized (C1847x.f6277c) {
                    if (f6104f == null) {
                        f6104f = new C1808b[0];
                    }
                }
            }
            return f6104f;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6105a != null) {
                a += C1843s.m10420b(1, this.f6105a.intValue());
            }
            if (this.f6106b != null) {
                a += C1843s.m10422b(2, this.f6106b);
            }
            if (this.f6107c != null && this.f6107c.length > 0) {
                int i = a;
                for (C1357z c1357z : this.f6107c) {
                    if (c1357z != null) {
                        i += C1843s.m10428c(3, c1357z);
                    }
                }
                a = i;
            }
            if (this.f6108d != null) {
                a += C1843s.m10423b(4, this.f6108d.booleanValue());
            }
            return this.f6109e != null ? a + C1843s.m10428c(5, this.f6109e) : a;
        }

        public C1808b m10217a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6105a = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 18:
                        this.f6106b = c1841r.m10398i();
                        continue;
                    case 26:
                        int b = ac.m7339b(c1841r, 26);
                        a = this.f6107c == null ? 0 : this.f6107c.length;
                        Object obj = new C1809c[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6107c, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1809c();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1809c();
                        c1841r.m10384a(obj[a]);
                        this.f6107c = obj;
                        continue;
                    case 32:
                        this.f6108d = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 42:
                        if (this.f6109e == null) {
                            this.f6109e = new C1810d();
                        }
                        c1841r.m10384a(this.f6109e);
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
            if (this.f6105a != null) {
                c1843s.m10448a(1, this.f6105a.intValue());
            }
            if (this.f6106b != null) {
                c1843s.m10451a(2, this.f6106b);
            }
            if (this.f6107c != null && this.f6107c.length > 0) {
                for (C1357z c1357z : this.f6107c) {
                    if (c1357z != null) {
                        c1843s.m10450a(3, c1357z);
                    }
                }
            }
            if (this.f6108d != null) {
                c1843s.m10452a(4, this.f6108d.booleanValue());
            }
            if (this.f6109e != null) {
                c1843s.m10450a(5, this.f6109e);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10217a(c1841r);
        }

        public C1808b m10220c() {
            this.f6105a = null;
            this.f6106b = null;
            this.f6107c = C1809c.m10221b();
            this.f6108d = null;
            this.f6109e = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1808b)) {
                return false;
            }
            C1808b c1808b = (C1808b) obj;
            if (this.f6105a == null) {
                if (c1808b.f6105a != null) {
                    return false;
                }
            } else if (!this.f6105a.equals(c1808b.f6105a)) {
                return false;
            }
            if (this.f6106b == null) {
                if (c1808b.f6106b != null) {
                    return false;
                }
            } else if (!this.f6106b.equals(c1808b.f6106b)) {
                return false;
            }
            if (!C1847x.m10502a(this.f6107c, c1808b.f6107c)) {
                return false;
            }
            if (this.f6108d == null) {
                if (c1808b.f6108d != null) {
                    return false;
                }
            } else if (!this.f6108d.equals(c1808b.f6108d)) {
                return false;
            }
            return this.f6109e == null ? c1808b.f6109e == null : this.f6109e.equals(c1808b.f6109e);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6108d == null ? 0 : this.f6108d.hashCode()) + (((((this.f6106b == null ? 0 : this.f6106b.hashCode()) + (((this.f6105a == null ? 0 : this.f6105a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + C1847x.m10497a(this.f6107c)) * 31)) * 31;
            if (this.f6109e != null) {
                i = this.f6109e.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1809c extends C1357z {
        private static volatile C1809c[] f6110e;
        public C1812f f6111a;
        public C1810d f6112b;
        public Boolean f6113c;
        public String f6114d;

        public C1809c() {
            m10226c();
        }

        public static C1809c[] m10221b() {
            if (f6110e == null) {
                synchronized (C1847x.f6277c) {
                    if (f6110e == null) {
                        f6110e = new C1809c[0];
                    }
                }
            }
            return f6110e;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6111a != null) {
                a += C1843s.m10428c(1, this.f6111a);
            }
            if (this.f6112b != null) {
                a += C1843s.m10428c(2, this.f6112b);
            }
            if (this.f6113c != null) {
                a += C1843s.m10423b(3, this.f6113c.booleanValue());
            }
            return this.f6114d != null ? a + C1843s.m10422b(4, this.f6114d) : a;
        }

        public C1809c m10223a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        if (this.f6111a == null) {
                            this.f6111a = new C1812f();
                        }
                        c1841r.m10384a(this.f6111a);
                        continue;
                    case 18:
                        if (this.f6112b == null) {
                            this.f6112b = new C1810d();
                        }
                        c1841r.m10384a(this.f6112b);
                        continue;
                    case 24:
                        this.f6113c = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 34:
                        this.f6114d = c1841r.m10398i();
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
            if (this.f6111a != null) {
                c1843s.m10450a(1, this.f6111a);
            }
            if (this.f6112b != null) {
                c1843s.m10450a(2, this.f6112b);
            }
            if (this.f6113c != null) {
                c1843s.m10452a(3, this.f6113c.booleanValue());
            }
            if (this.f6114d != null) {
                c1843s.m10451a(4, this.f6114d);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10223a(c1841r);
        }

        public C1809c m10226c() {
            this.f6111a = null;
            this.f6112b = null;
            this.f6113c = null;
            this.f6114d = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1809c)) {
                return false;
            }
            C1809c c1809c = (C1809c) obj;
            if (this.f6111a == null) {
                if (c1809c.f6111a != null) {
                    return false;
                }
            } else if (!this.f6111a.equals(c1809c.f6111a)) {
                return false;
            }
            if (this.f6112b == null) {
                if (c1809c.f6112b != null) {
                    return false;
                }
            } else if (!this.f6112b.equals(c1809c.f6112b)) {
                return false;
            }
            if (this.f6113c == null) {
                if (c1809c.f6113c != null) {
                    return false;
                }
            } else if (!this.f6113c.equals(c1809c.f6113c)) {
                return false;
            }
            return this.f6114d == null ? c1809c.f6114d == null : this.f6114d.equals(c1809c.f6114d);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6113c == null ? 0 : this.f6113c.hashCode()) + (((this.f6112b == null ? 0 : this.f6112b.hashCode()) + (((this.f6111a == null ? 0 : this.f6111a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.f6114d != null) {
                i = this.f6114d.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1810d extends C1357z {
        public Integer f6115a;
        public Boolean f6116b;
        public String f6117c;
        public String f6118d;
        public String f6119e;

        public C1810d() {
            m10230b();
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6115a != null) {
                a += C1843s.m10420b(1, this.f6115a.intValue());
            }
            if (this.f6116b != null) {
                a += C1843s.m10423b(2, this.f6116b.booleanValue());
            }
            if (this.f6117c != null) {
                a += C1843s.m10422b(3, this.f6117c);
            }
            if (this.f6118d != null) {
                a += C1843s.m10422b(4, this.f6118d);
            }
            return this.f6119e != null ? a + C1843s.m10422b(5, this.f6119e) : a;
        }

        public C1810d m10228a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = c1841r.m10396g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.f6115a = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.f6116b = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 26:
                        this.f6117c = c1841r.m10398i();
                        continue;
                    case 34:
                        this.f6118d = c1841r.m10398i();
                        continue;
                    case 42:
                        this.f6119e = c1841r.m10398i();
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
            if (this.f6115a != null) {
                c1843s.m10448a(1, this.f6115a.intValue());
            }
            if (this.f6116b != null) {
                c1843s.m10452a(2, this.f6116b.booleanValue());
            }
            if (this.f6117c != null) {
                c1843s.m10451a(3, this.f6117c);
            }
            if (this.f6118d != null) {
                c1843s.m10451a(4, this.f6118d);
            }
            if (this.f6119e != null) {
                c1843s.m10451a(5, this.f6119e);
            }
            super.mo1231a(c1843s);
        }

        public C1810d m10230b() {
            this.f6116b = null;
            this.f6117c = null;
            this.f6118d = null;
            this.f6119e = null;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10228a(c1841r);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1810d)) {
                return false;
            }
            C1810d c1810d = (C1810d) obj;
            if (this.f6115a == null) {
                if (c1810d.f6115a != null) {
                    return false;
                }
            } else if (!this.f6115a.equals(c1810d.f6115a)) {
                return false;
            }
            if (this.f6116b == null) {
                if (c1810d.f6116b != null) {
                    return false;
                }
            } else if (!this.f6116b.equals(c1810d.f6116b)) {
                return false;
            }
            if (this.f6117c == null) {
                if (c1810d.f6117c != null) {
                    return false;
                }
            } else if (!this.f6117c.equals(c1810d.f6117c)) {
                return false;
            }
            if (this.f6118d == null) {
                if (c1810d.f6118d != null) {
                    return false;
                }
            } else if (!this.f6118d.equals(c1810d.f6118d)) {
                return false;
            }
            return this.f6119e == null ? c1810d.f6119e == null : this.f6119e.equals(c1810d.f6119e);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6118d == null ? 0 : this.f6118d.hashCode()) + (((this.f6117c == null ? 0 : this.f6117c.hashCode()) + (((this.f6116b == null ? 0 : this.f6116b.hashCode()) + (((this.f6115a == null ? 0 : this.f6115a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f6119e != null) {
                i = this.f6119e.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1811e extends C1357z {
        private static volatile C1811e[] f6120d;
        public Integer f6121a;
        public String f6122b;
        public C1809c f6123c;

        public C1811e() {
            m10237c();
        }

        public static C1811e[] m10232b() {
            if (f6120d == null) {
                synchronized (C1847x.f6277c) {
                    if (f6120d == null) {
                        f6120d = new C1811e[0];
                    }
                }
            }
            return f6120d;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f6121a != null) {
                a += C1843s.m10420b(1, this.f6121a.intValue());
            }
            if (this.f6122b != null) {
                a += C1843s.m10422b(2, this.f6122b);
            }
            return this.f6123c != null ? a + C1843s.m10428c(3, this.f6123c) : a;
        }

        public C1811e m10234a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f6121a = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 18:
                        this.f6122b = c1841r.m10398i();
                        continue;
                    case 26:
                        if (this.f6123c == null) {
                            this.f6123c = new C1809c();
                        }
                        c1841r.m10384a(this.f6123c);
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
            if (this.f6121a != null) {
                c1843s.m10448a(1, this.f6121a.intValue());
            }
            if (this.f6122b != null) {
                c1843s.m10451a(2, this.f6122b);
            }
            if (this.f6123c != null) {
                c1843s.m10450a(3, this.f6123c);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10234a(c1841r);
        }

        public C1811e m10237c() {
            this.f6121a = null;
            this.f6122b = null;
            this.f6123c = null;
            this.V = -1;
            return this;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1811e)) {
                return false;
            }
            C1811e c1811e = (C1811e) obj;
            if (this.f6121a == null) {
                if (c1811e.f6121a != null) {
                    return false;
                }
            } else if (!this.f6121a.equals(c1811e.f6121a)) {
                return false;
            }
            if (this.f6122b == null) {
                if (c1811e.f6122b != null) {
                    return false;
                }
            } else if (!this.f6122b.equals(c1811e.f6122b)) {
                return false;
            }
            return this.f6123c == null ? c1811e.f6123c == null : this.f6123c.equals(c1811e.f6123c);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6122b == null ? 0 : this.f6122b.hashCode()) + (((this.f6121a == null ? 0 : this.f6121a.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.f6123c != null) {
                i = this.f6123c.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1812f extends C1357z {
        public Integer f6124a;
        public String f6125b;
        public Boolean f6126c;
        public String[] f6127d;

        public C1812f() {
            m10241b();
        }

        protected int mo1230a() {
            int i = 0;
            int a = super.mo1230a();
            if (this.f6124a != null) {
                a += C1843s.m10420b(1, this.f6124a.intValue());
            }
            if (this.f6125b != null) {
                a += C1843s.m10422b(2, this.f6125b);
            }
            if (this.f6126c != null) {
                a += C1843s.m10423b(3, this.f6126c.booleanValue());
            }
            if (this.f6127d == null || this.f6127d.length <= 0) {
                return a;
            }
            int i2 = 0;
            int i3 = 0;
            while (i < this.f6127d.length) {
                String str = this.f6127d[i];
                if (str != null) {
                    i3++;
                    i2 += C1843s.m10425b(str);
                }
                i++;
            }
            return (a + i2) + (i3 * 1);
        }

        public C1812f m10239a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        a = c1841r.m10396g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.f6124a = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f6125b = c1841r.m10398i();
                        continue;
                    case 24:
                        this.f6126c = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 34:
                        int b = ac.m7339b(c1841r, 34);
                        a = this.f6127d == null ? 0 : this.f6127d.length;
                        Object obj = new String[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f6127d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10398i();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10398i();
                        this.f6127d = obj;
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
            if (this.f6124a != null) {
                c1843s.m10448a(1, this.f6124a.intValue());
            }
            if (this.f6125b != null) {
                c1843s.m10451a(2, this.f6125b);
            }
            if (this.f6126c != null) {
                c1843s.m10452a(3, this.f6126c.booleanValue());
            }
            if (this.f6127d != null && this.f6127d.length > 0) {
                for (String str : this.f6127d) {
                    if (str != null) {
                        c1843s.m10451a(4, str);
                    }
                }
            }
            super.mo1231a(c1843s);
        }

        public C1812f m10241b() {
            this.f6125b = null;
            this.f6126c = null;
            this.f6127d = ac.f4056f;
            this.V = -1;
            return this;
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m10239a(c1841r);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1812f)) {
                return false;
            }
            C1812f c1812f = (C1812f) obj;
            if (this.f6124a == null) {
                if (c1812f.f6124a != null) {
                    return false;
                }
            } else if (!this.f6124a.equals(c1812f.f6124a)) {
                return false;
            }
            if (this.f6125b == null) {
                if (c1812f.f6125b != null) {
                    return false;
                }
            } else if (!this.f6125b.equals(c1812f.f6125b)) {
                return false;
            }
            if (this.f6126c == null) {
                if (c1812f.f6126c != null) {
                    return false;
                }
            } else if (!this.f6126c.equals(c1812f.f6126c)) {
                return false;
            }
            return C1847x.m10502a(this.f6127d, c1812f.f6127d);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f6125b == null ? 0 : this.f6125b.hashCode()) + (((this.f6124a == null ? 0 : this.f6124a.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.f6126c != null) {
                i = this.f6126c.hashCode();
            }
            return ((hashCode + i) * 31) + C1847x.m10497a(this.f6127d);
        }
    }
}
