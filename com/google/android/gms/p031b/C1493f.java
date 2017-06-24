package com.google.android.gms.p031b;

public interface C1493f {

    public static final class C1487a extends C1358t<C1487a> {
        public Long f4636A;
        public String f4637B;
        public Long f4638C;
        public Long f4639D;
        public Long f4640E;
        public C1488b f4641F;
        public Long f4642G;
        public Long f4643H;
        public Long f4644I;
        public Long f4645J;
        public Long f4646K;
        public Long f4647L;
        public C1486a[] f4648M;
        public Long f4649N;
        public String f4650O;
        public Integer f4651P;
        public Boolean f4652Q;
        public String f4653R;
        public Long f4654S;
        public C1491e f4655T;
        public String f4656a;
        public String f4657b;
        public Long f4658c;
        public Long f4659d;
        public Long f4660e;
        public Long f4661f;
        public Long f4662g;
        public Long f4663h;
        public Long f4664i;
        public Long f4665j;
        public Long f4666k;
        public Long f4667l;
        public String f4668m;
        public Long f4669n;
        public Long f4670o;
        public Long f4671p;
        public Long f4672q;
        public Long f4673r;
        public Long f4674s;
        public Long f4675t;
        public Long f4676u;
        public Long f4677v;
        public String f4678w;
        public String f4679x;
        public Long f4680y;
        public Long f4681z;

        public static final class C1486a extends C1358t<C1486a> {
            private static volatile C1486a[] f4633c;
            public Long f4634a;
            public Long f4635b;

            public C1486a() {
                this.f4634a = null;
                this.f4635b = null;
                this.V = -1;
            }

            public static C1486a[] m8160b() {
                if (f4633c == null) {
                    synchronized (C1847x.f6277c) {
                        if (f4633c == null) {
                            f4633c = new C1486a[0];
                        }
                    }
                }
                return f4633c;
            }

            protected int mo1230a() {
                int a = super.mo1230a();
                if (this.f4634a != null) {
                    a += C1843s.m10432d(1, this.f4634a.longValue());
                }
                return this.f4635b != null ? a + C1843s.m10432d(2, this.f4635b.longValue()) : a;
            }

            public C1486a m8162a(C1841r c1841r) {
                while (true) {
                    int a = c1841r.m10382a();
                    switch (a) {
                        case 0:
                            break;
                        case 8:
                            this.f4634a = Long.valueOf(c1841r.m10394f());
                            continue;
                        case 16:
                            this.f4635b = Long.valueOf(c1841r.m10394f());
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
                if (this.f4634a != null) {
                    c1843s.m10459b(1, this.f4634a.longValue());
                }
                if (this.f4635b != null) {
                    c1843s.m10459b(2, this.f4635b.longValue());
                }
                super.mo1231a(c1843s);
            }

            public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
                return m8162a(c1841r);
            }
        }

        public C1487a() {
            this.f4656a = null;
            this.f4657b = null;
            this.f4658c = null;
            this.f4659d = null;
            this.f4660e = null;
            this.f4661f = null;
            this.f4662g = null;
            this.f4663h = null;
            this.f4664i = null;
            this.f4665j = null;
            this.f4666k = null;
            this.f4667l = null;
            this.f4668m = null;
            this.f4669n = null;
            this.f4670o = null;
            this.f4671p = null;
            this.f4672q = null;
            this.f4673r = null;
            this.f4674s = null;
            this.f4675t = null;
            this.f4676u = null;
            this.f4677v = null;
            this.f4678w = null;
            this.f4679x = null;
            this.f4680y = null;
            this.f4681z = null;
            this.f4636A = null;
            this.f4637B = null;
            this.f4638C = null;
            this.f4639D = null;
            this.f4640E = null;
            this.f4642G = null;
            this.f4643H = null;
            this.f4644I = null;
            this.f4645J = null;
            this.f4646K = null;
            this.f4647L = null;
            this.f4648M = C1486a.m8160b();
            this.f4649N = null;
            this.f4650O = null;
            this.f4651P = null;
            this.f4652Q = null;
            this.f4653R = null;
            this.f4654S = null;
            this.V = -1;
        }

        public static C1487a m8165a(byte[] bArr) {
            return (C1487a) C1357z.m7340a(new C1487a(), bArr);
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f4656a != null) {
                a += C1843s.m10422b(1, this.f4656a);
            }
            if (this.f4657b != null) {
                a += C1843s.m10422b(2, this.f4657b);
            }
            if (this.f4658c != null) {
                a += C1843s.m10432d(3, this.f4658c.longValue());
            }
            if (this.f4659d != null) {
                a += C1843s.m10432d(4, this.f4659d.longValue());
            }
            if (this.f4660e != null) {
                a += C1843s.m10432d(5, this.f4660e.longValue());
            }
            if (this.f4661f != null) {
                a += C1843s.m10432d(6, this.f4661f.longValue());
            }
            if (this.f4662g != null) {
                a += C1843s.m10432d(7, this.f4662g.longValue());
            }
            if (this.f4663h != null) {
                a += C1843s.m10432d(8, this.f4663h.longValue());
            }
            if (this.f4664i != null) {
                a += C1843s.m10432d(9, this.f4664i.longValue());
            }
            if (this.f4665j != null) {
                a += C1843s.m10432d(10, this.f4665j.longValue());
            }
            if (this.f4666k != null) {
                a += C1843s.m10432d(11, this.f4666k.longValue());
            }
            if (this.f4667l != null) {
                a += C1843s.m10432d(12, this.f4667l.longValue());
            }
            if (this.f4668m != null) {
                a += C1843s.m10422b(13, this.f4668m);
            }
            if (this.f4669n != null) {
                a += C1843s.m10432d(14, this.f4669n.longValue());
            }
            if (this.f4670o != null) {
                a += C1843s.m10432d(15, this.f4670o.longValue());
            }
            if (this.f4671p != null) {
                a += C1843s.m10432d(16, this.f4671p.longValue());
            }
            if (this.f4672q != null) {
                a += C1843s.m10432d(17, this.f4672q.longValue());
            }
            if (this.f4673r != null) {
                a += C1843s.m10432d(18, this.f4673r.longValue());
            }
            if (this.f4674s != null) {
                a += C1843s.m10432d(19, this.f4674s.longValue());
            }
            if (this.f4675t != null) {
                a += C1843s.m10432d(20, this.f4675t.longValue());
            }
            if (this.f4649N != null) {
                a += C1843s.m10432d(21, this.f4649N.longValue());
            }
            if (this.f4676u != null) {
                a += C1843s.m10432d(22, this.f4676u.longValue());
            }
            if (this.f4677v != null) {
                a += C1843s.m10432d(23, this.f4677v.longValue());
            }
            if (this.f4650O != null) {
                a += C1843s.m10422b(24, this.f4650O);
            }
            if (this.f4654S != null) {
                a += C1843s.m10432d(25, this.f4654S.longValue());
            }
            if (this.f4651P != null) {
                a += C1843s.m10420b(26, this.f4651P.intValue());
            }
            if (this.f4678w != null) {
                a += C1843s.m10422b(27, this.f4678w);
            }
            if (this.f4652Q != null) {
                a += C1843s.m10423b(28, this.f4652Q.booleanValue());
            }
            if (this.f4679x != null) {
                a += C1843s.m10422b(29, this.f4679x);
            }
            if (this.f4653R != null) {
                a += C1843s.m10422b(30, this.f4653R);
            }
            if (this.f4680y != null) {
                a += C1843s.m10432d(31, this.f4680y.longValue());
            }
            if (this.f4681z != null) {
                a += C1843s.m10432d(32, this.f4681z.longValue());
            }
            if (this.f4636A != null) {
                a += C1843s.m10432d(33, this.f4636A.longValue());
            }
            if (this.f4637B != null) {
                a += C1843s.m10422b(34, this.f4637B);
            }
            if (this.f4638C != null) {
                a += C1843s.m10432d(35, this.f4638C.longValue());
            }
            if (this.f4639D != null) {
                a += C1843s.m10432d(36, this.f4639D.longValue());
            }
            if (this.f4640E != null) {
                a += C1843s.m10432d(37, this.f4640E.longValue());
            }
            if (this.f4641F != null) {
                a += C1843s.m10428c(38, this.f4641F);
            }
            if (this.f4642G != null) {
                a += C1843s.m10432d(39, this.f4642G.longValue());
            }
            if (this.f4643H != null) {
                a += C1843s.m10432d(40, this.f4643H.longValue());
            }
            if (this.f4644I != null) {
                a += C1843s.m10432d(41, this.f4644I.longValue());
            }
            if (this.f4645J != null) {
                a += C1843s.m10432d(42, this.f4645J.longValue());
            }
            if (this.f4648M != null && this.f4648M.length > 0) {
                int i = a;
                for (C1357z c1357z : this.f4648M) {
                    if (c1357z != null) {
                        i += C1843s.m10428c(43, c1357z);
                    }
                }
                a = i;
            }
            if (this.f4646K != null) {
                a += C1843s.m10432d(44, this.f4646K.longValue());
            }
            if (this.f4647L != null) {
                a += C1843s.m10432d(45, this.f4647L.longValue());
            }
            return this.f4655T != null ? a + C1843s.m10428c(201, this.f4655T) : a;
        }

        public C1487a m8167a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f4656a = c1841r.m10398i();
                        continue;
                    case 18:
                        this.f4657b = c1841r.m10398i();
                        continue;
                    case 24:
                        this.f4658c = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 32:
                        this.f4659d = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 40:
                        this.f4660e = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 48:
                        this.f4661f = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 56:
                        this.f4662g = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 64:
                        this.f4663h = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 72:
                        this.f4664i = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 80:
                        this.f4665j = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 88:
                        this.f4666k = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 96:
                        this.f4667l = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 106:
                        this.f4668m = c1841r.m10398i();
                        continue;
                    case 112:
                        this.f4669n = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 120:
                        this.f4670o = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 128:
                        this.f4671p = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 136:
                        this.f4672q = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 144:
                        this.f4673r = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 152:
                        this.f4674s = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 160:
                        this.f4675t = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 168:
                        this.f4649N = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 176:
                        this.f4676u = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 184:
                        this.f4677v = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 194:
                        this.f4650O = c1841r.m10398i();
                        continue;
                    case 200:
                        this.f4654S = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 208:
                        a = c1841r.m10396g();
                        switch (a) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.f4651P = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.f4678w = c1841r.m10398i();
                        continue;
                    case 224:
                        this.f4652Q = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 234:
                        this.f4679x = c1841r.m10398i();
                        continue;
                    case 242:
                        this.f4653R = c1841r.m10398i();
                        continue;
                    case 248:
                        this.f4680y = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 256:
                        this.f4681z = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 264:
                        this.f4636A = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 274:
                        this.f4637B = c1841r.m10398i();
                        continue;
                    case 280:
                        this.f4638C = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 288:
                        this.f4639D = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 296:
                        this.f4640E = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 306:
                        if (this.f4641F == null) {
                            this.f4641F = new C1488b();
                        }
                        c1841r.m10384a(this.f4641F);
                        continue;
                    case 312:
                        this.f4642G = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 320:
                        this.f4643H = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 328:
                        this.f4644I = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 336:
                        this.f4645J = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 346:
                        int b = ac.m7339b(c1841r, 346);
                        a = this.f4648M == null ? 0 : this.f4648M.length;
                        Object obj = new C1486a[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4648M, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = new C1486a();
                            c1841r.m10384a(obj[a]);
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = new C1486a();
                        c1841r.m10384a(obj[a]);
                        this.f4648M = obj;
                        continue;
                    case 352:
                        this.f4646K = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 360:
                        this.f4647L = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 1610:
                        if (this.f4655T == null) {
                            this.f4655T = new C1491e();
                        }
                        c1841r.m10384a(this.f4655T);
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
            if (this.f4656a != null) {
                c1843s.m10451a(1, this.f4656a);
            }
            if (this.f4657b != null) {
                c1843s.m10451a(2, this.f4657b);
            }
            if (this.f4658c != null) {
                c1843s.m10459b(3, this.f4658c.longValue());
            }
            if (this.f4659d != null) {
                c1843s.m10459b(4, this.f4659d.longValue());
            }
            if (this.f4660e != null) {
                c1843s.m10459b(5, this.f4660e.longValue());
            }
            if (this.f4661f != null) {
                c1843s.m10459b(6, this.f4661f.longValue());
            }
            if (this.f4662g != null) {
                c1843s.m10459b(7, this.f4662g.longValue());
            }
            if (this.f4663h != null) {
                c1843s.m10459b(8, this.f4663h.longValue());
            }
            if (this.f4664i != null) {
                c1843s.m10459b(9, this.f4664i.longValue());
            }
            if (this.f4665j != null) {
                c1843s.m10459b(10, this.f4665j.longValue());
            }
            if (this.f4666k != null) {
                c1843s.m10459b(11, this.f4666k.longValue());
            }
            if (this.f4667l != null) {
                c1843s.m10459b(12, this.f4667l.longValue());
            }
            if (this.f4668m != null) {
                c1843s.m10451a(13, this.f4668m);
            }
            if (this.f4669n != null) {
                c1843s.m10459b(14, this.f4669n.longValue());
            }
            if (this.f4670o != null) {
                c1843s.m10459b(15, this.f4670o.longValue());
            }
            if (this.f4671p != null) {
                c1843s.m10459b(16, this.f4671p.longValue());
            }
            if (this.f4672q != null) {
                c1843s.m10459b(17, this.f4672q.longValue());
            }
            if (this.f4673r != null) {
                c1843s.m10459b(18, this.f4673r.longValue());
            }
            if (this.f4674s != null) {
                c1843s.m10459b(19, this.f4674s.longValue());
            }
            if (this.f4675t != null) {
                c1843s.m10459b(20, this.f4675t.longValue());
            }
            if (this.f4649N != null) {
                c1843s.m10459b(21, this.f4649N.longValue());
            }
            if (this.f4676u != null) {
                c1843s.m10459b(22, this.f4676u.longValue());
            }
            if (this.f4677v != null) {
                c1843s.m10459b(23, this.f4677v.longValue());
            }
            if (this.f4650O != null) {
                c1843s.m10451a(24, this.f4650O);
            }
            if (this.f4654S != null) {
                c1843s.m10459b(25, this.f4654S.longValue());
            }
            if (this.f4651P != null) {
                c1843s.m10448a(26, this.f4651P.intValue());
            }
            if (this.f4678w != null) {
                c1843s.m10451a(27, this.f4678w);
            }
            if (this.f4652Q != null) {
                c1843s.m10452a(28, this.f4652Q.booleanValue());
            }
            if (this.f4679x != null) {
                c1843s.m10451a(29, this.f4679x);
            }
            if (this.f4653R != null) {
                c1843s.m10451a(30, this.f4653R);
            }
            if (this.f4680y != null) {
                c1843s.m10459b(31, this.f4680y.longValue());
            }
            if (this.f4681z != null) {
                c1843s.m10459b(32, this.f4681z.longValue());
            }
            if (this.f4636A != null) {
                c1843s.m10459b(33, this.f4636A.longValue());
            }
            if (this.f4637B != null) {
                c1843s.m10451a(34, this.f4637B);
            }
            if (this.f4638C != null) {
                c1843s.m10459b(35, this.f4638C.longValue());
            }
            if (this.f4639D != null) {
                c1843s.m10459b(36, this.f4639D.longValue());
            }
            if (this.f4640E != null) {
                c1843s.m10459b(37, this.f4640E.longValue());
            }
            if (this.f4641F != null) {
                c1843s.m10450a(38, this.f4641F);
            }
            if (this.f4642G != null) {
                c1843s.m10459b(39, this.f4642G.longValue());
            }
            if (this.f4643H != null) {
                c1843s.m10459b(40, this.f4643H.longValue());
            }
            if (this.f4644I != null) {
                c1843s.m10459b(41, this.f4644I.longValue());
            }
            if (this.f4645J != null) {
                c1843s.m10459b(42, this.f4645J.longValue());
            }
            if (this.f4648M != null && this.f4648M.length > 0) {
                for (C1357z c1357z : this.f4648M) {
                    if (c1357z != null) {
                        c1843s.m10450a(43, c1357z);
                    }
                }
            }
            if (this.f4646K != null) {
                c1843s.m10459b(44, this.f4646K.longValue());
            }
            if (this.f4647L != null) {
                c1843s.m10459b(45, this.f4647L.longValue());
            }
            if (this.f4655T != null) {
                c1843s.m10450a(201, this.f4655T);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m8167a(c1841r);
        }
    }

    public static final class C1488b extends C1358t<C1488b> {
        public Long f4682a;
        public Integer f4683b;
        public Boolean f4684c;
        public int[] f4685d;

        public C1488b() {
            this.f4682a = null;
            this.f4683b = null;
            this.f4684c = null;
            this.f4685d = ac.f4051a;
            this.V = -1;
        }

        protected int mo1230a() {
            int i = 0;
            int a = super.mo1230a();
            if (this.f4682a != null) {
                a += C1843s.m10432d(1, this.f4682a.longValue());
            }
            if (this.f4683b != null) {
                a += C1843s.m10420b(2, this.f4683b.intValue());
            }
            if (this.f4684c != null) {
                a += C1843s.m10423b(3, this.f4684c.booleanValue());
            }
            if (this.f4685d == null || this.f4685d.length <= 0) {
                return a;
            }
            int i2 = 0;
            while (i < this.f4685d.length) {
                i2 += C1843s.m10417b(this.f4685d[i]);
                i++;
            }
            return (a + i2) + (this.f4685d.length * 1);
        }

        public C1488b m8171a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                int b;
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f4682a = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 16:
                        this.f4683b = Integer.valueOf(c1841r.m10396g());
                        continue;
                    case 24:
                        this.f4684c = Boolean.valueOf(c1841r.m10397h());
                        continue;
                    case 32:
                        b = ac.m7339b(c1841r, 32);
                        a = this.f4685d == null ? 0 : this.f4685d.length;
                        Object obj = new int[(b + a)];
                        if (a != 0) {
                            System.arraycopy(this.f4685d, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10396g();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10396g();
                        this.f4685d = obj;
                        continue;
                    case 34:
                        int c = c1841r.m10389c(c1841r.m10401l());
                        b = c1841r.m10407r();
                        a = 0;
                        while (c1841r.m10405p() > 0) {
                            c1841r.m10396g();
                            a++;
                        }
                        c1841r.m10393e(b);
                        b = this.f4685d == null ? 0 : this.f4685d.length;
                        Object obj2 = new int[(a + b)];
                        if (b != 0) {
                            System.arraycopy(this.f4685d, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = c1841r.m10396g();
                            b++;
                        }
                        this.f4685d = obj2;
                        c1841r.m10391d(c);
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
            if (this.f4682a != null) {
                c1843s.m10459b(1, this.f4682a.longValue());
            }
            if (this.f4683b != null) {
                c1843s.m10448a(2, this.f4683b.intValue());
            }
            if (this.f4684c != null) {
                c1843s.m10452a(3, this.f4684c.booleanValue());
            }
            if (this.f4685d != null && this.f4685d.length > 0) {
                for (int a : this.f4685d) {
                    c1843s.m10448a(4, a);
                }
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m8171a(c1841r);
        }
    }

    public static final class C1489c extends C1358t<C1489c> {
        public byte[] f4686a;
        public byte[] f4687b;

        public C1489c() {
            this.f4686a = null;
            this.f4687b = null;
            this.V = -1;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f4686a != null) {
                a += C1843s.m10424b(1, this.f4686a);
            }
            return this.f4687b != null ? a + C1843s.m10424b(2, this.f4687b) : a;
        }

        public C1489c m8175a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f4686a = c1841r.m10399j();
                        continue;
                    case 18:
                        this.f4687b = c1841r.m10399j();
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
            if (this.f4686a != null) {
                c1843s.m10453a(1, this.f4686a);
            }
            if (this.f4687b != null) {
                c1843s.m10453a(2, this.f4687b);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m8175a(c1841r);
        }
    }

    public static final class C1490d extends C1358t<C1490d> {
        public byte[] f4688a;
        public byte[] f4689b;
        public byte[] f4690c;
        public byte[] f4691d;

        public C1490d() {
            this.f4688a = null;
            this.f4689b = null;
            this.f4690c = null;
            this.f4691d = null;
            this.V = -1;
        }

        public static C1490d m8178a(byte[] bArr) {
            return (C1490d) C1357z.m7340a(new C1490d(), bArr);
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f4688a != null) {
                a += C1843s.m10424b(1, this.f4688a);
            }
            if (this.f4689b != null) {
                a += C1843s.m10424b(2, this.f4689b);
            }
            if (this.f4690c != null) {
                a += C1843s.m10424b(3, this.f4690c);
            }
            return this.f4691d != null ? a + C1843s.m10424b(4, this.f4691d) : a;
        }

        public C1490d m8180a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        this.f4688a = c1841r.m10399j();
                        continue;
                    case 18:
                        this.f4689b = c1841r.m10399j();
                        continue;
                    case 26:
                        this.f4690c = c1841r.m10399j();
                        continue;
                    case 34:
                        this.f4691d = c1841r.m10399j();
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
            if (this.f4688a != null) {
                c1843s.m10453a(1, this.f4688a);
            }
            if (this.f4689b != null) {
                c1843s.m10453a(2, this.f4689b);
            }
            if (this.f4690c != null) {
                c1843s.m10453a(3, this.f4690c);
            }
            if (this.f4691d != null) {
                c1843s.m10453a(4, this.f4691d);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m8180a(c1841r);
        }
    }

    public static final class C1491e extends C1358t<C1491e> {
        public Long f4692a;
        public String f4693b;
        public byte[] f4694c;

        public C1491e() {
            this.f4692a = null;
            this.f4693b = null;
            this.f4694c = null;
            this.V = -1;
        }

        protected int mo1230a() {
            int a = super.mo1230a();
            if (this.f4692a != null) {
                a += C1843s.m10432d(1, this.f4692a.longValue());
            }
            if (this.f4693b != null) {
                a += C1843s.m10422b(3, this.f4693b);
            }
            return this.f4694c != null ? a + C1843s.m10424b(4, this.f4694c) : a;
        }

        public C1491e m8184a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 8:
                        this.f4692a = Long.valueOf(c1841r.m10394f());
                        continue;
                    case 26:
                        this.f4693b = c1841r.m10398i();
                        continue;
                    case 34:
                        this.f4694c = c1841r.m10399j();
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
            if (this.f4692a != null) {
                c1843s.m10459b(1, this.f4692a.longValue());
            }
            if (this.f4693b != null) {
                c1843s.m10451a(3, this.f4693b);
            }
            if (this.f4694c != null) {
                c1843s.m10453a(4, this.f4694c);
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m8184a(c1841r);
        }
    }

    public static final class C1492f extends C1358t<C1492f> {
        public byte[][] f4695a;
        public byte[] f4696b;
        public Integer f4697c;
        public Integer f4698d;

        public C1492f() {
            this.f4695a = ac.f4057g;
            this.f4696b = null;
            this.f4697c = null;
            this.f4698d = null;
            this.V = -1;
        }

        protected int mo1230a() {
            int i = 0;
            int a = super.mo1230a();
            if (this.f4695a == null || this.f4695a.length <= 0) {
                i = a;
            } else {
                int i2 = 0;
                int i3 = 0;
                while (i < this.f4695a.length) {
                    byte[] bArr = this.f4695a[i];
                    if (bArr != null) {
                        i3++;
                        i2 += C1843s.m10430c(bArr);
                    }
                    i++;
                }
                i = (a + i2) + (i3 * 1);
            }
            if (this.f4696b != null) {
                i += C1843s.m10424b(2, this.f4696b);
            }
            if (this.f4697c != null) {
                i += C1843s.m10420b(3, this.f4697c.intValue());
            }
            return this.f4698d != null ? i + C1843s.m10420b(4, this.f4698d.intValue()) : i;
        }

        public C1492f m8188a(C1841r c1841r) {
            while (true) {
                int a = c1841r.m10382a();
                switch (a) {
                    case 0:
                        break;
                    case 10:
                        int b = ac.m7339b(c1841r, 10);
                        a = this.f4695a == null ? 0 : this.f4695a.length;
                        Object obj = new byte[(b + a)][];
                        if (a != 0) {
                            System.arraycopy(this.f4695a, 0, obj, 0, a);
                        }
                        while (a < obj.length - 1) {
                            obj[a] = c1841r.m10399j();
                            c1841r.m10382a();
                            a++;
                        }
                        obj[a] = c1841r.m10399j();
                        this.f4695a = obj;
                        continue;
                    case 18:
                        this.f4696b = c1841r.m10399j();
                        continue;
                    case 24:
                        a = c1841r.m10396g();
                        switch (a) {
                            case 0:
                            case 1:
                                this.f4697c = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        a = c1841r.m10396g();
                        switch (a) {
                            case 0:
                            case 1:
                                this.f4698d = Integer.valueOf(a);
                                break;
                            default:
                                continue;
                        }
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
            if (this.f4695a != null && this.f4695a.length > 0) {
                for (byte[] bArr : this.f4695a) {
                    if (bArr != null) {
                        c1843s.m10453a(1, bArr);
                    }
                }
            }
            if (this.f4696b != null) {
                c1843s.m10453a(2, this.f4696b);
            }
            if (this.f4697c != null) {
                c1843s.m10448a(3, this.f4697c.intValue());
            }
            if (this.f4698d != null) {
                c1843s.m10448a(4, this.f4698d.intValue());
            }
            super.mo1231a(c1843s);
        }

        public /* synthetic */ C1357z mo1234b(C1841r c1841r) {
            return m8188a(c1841r);
        }
    }
}
