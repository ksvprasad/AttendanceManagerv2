package com.google.android.gms.p031b;

public interface C1436e {

    public static final class C1435a extends C1358t<C1435a> {
        public String f4483a;
        public Long f4484b;
        public String f4485c;
        public String f4486d;
        public String f4487e;
        public Long f4488f;
        public Long f4489g;
        public String f4490h;
        public Long f4491i;
        public String f4492j;

        public C1435a() {
            this.f4483a = null;
            this.f4484b = null;
            this.f4485c = null;
            this.f4486d = null;
            this.f4487e = null;
            this.f4488f = null;
            this.f4489g = null;
            this.f4490h = null;
            this.f4491i = null;
            this.f4492j = null;
            this.V = -1;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f4483a != null) {
                a += C1843s.m10422b(1, this.f4483a);
            }
            if (this.f4484b != null) {
                a += C1843s.m10432d(2, this.f4484b.longValue());
            }
            if (this.f4485c != null) {
                a += C1843s.m10422b(3, this.f4485c);
            }
            if (this.f4486d != null) {
                a += C1843s.m10422b(4, this.f4486d);
            }
            if (this.f4487e != null) {
                a += C1843s.m10422b(5, this.f4487e);
            }
            if (this.f4488f != null) {
                a += C1843s.m10432d(6, this.f4488f.longValue());
            }
            if (this.f4489g != null) {
                a += C1843s.m10432d(7, this.f4489g.longValue());
            }
            if (this.f4490h != null) {
                a += C1843s.m10422b(8, this.f4490h);
            }
            if (this.f4491i != null) {
                a += C1843s.m10432d(9, this.f4491i.longValue());
            }
            return this.f4492j != null ? a + C1843s.m10422b(10, this.f4492j) : a;
        }

        public C1435a m7991a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f4483a = c1841r.m10398i();
                        continue;
                    case 16:
                        this.f4484b = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 26:
                        this.f4485c = c1841r.m10398i();
                        continue;
                    case 34:
                        this.f4486d = c1841r.m10398i();
                        continue;
                    case 42:
                        this.f4487e = c1841r.m10398i();
                        continue;
                    case 48:
                        this.f4488f = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 56:
                        this.f4489g = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 66:
                        this.f4490h = c1841r.m10398i();
                        continue;
                    case 72:
                        this.f4491i = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 82:
                        this.f4492j = c1841r.m10398i();
                        continue;
                    default:
                        if (!super.m7352a(c1841r, a)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public void mo1231a(C1843s c1843s) {
            if (this.f4483a != null) {
                c1843s.m10451a(1, this.f4483a);
            }
            if (this.f4484b != null) {
                c1843s.m10459b(2, this.f4484b.longValue());
            }
            if (this.f4485c != null) {
                c1843s.m10451a(3, this.f4485c);
            }
            if (this.f4486d != null) {
                c1843s.m10451a(4, this.f4486d);
            }
            if (this.f4487e != null) {
                c1843s.m10451a(5, this.f4487e);
            }
            if (this.f4488f != null) {
                c1843s.m10459b(6, this.f4488f.longValue());
            }
            if (this.f4489g != null) {
                c1843s.m10459b(7, this.f4489g.longValue());
            }
            if (this.f4490h != null) {
                c1843s.m10451a(8, this.f4490h);
            }
            if (this.f4491i != null) {
                c1843s.m10459b(9, this.f4491i.longValue());
            }
            if (this.f4492j != null) {
                c1843s.m10451a(10, this.f4492j);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m7991a(c1841r);
        }
    }
}
