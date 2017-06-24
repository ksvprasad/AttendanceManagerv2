package p000a.p001a;

import p000a.p001a.C0004a.C0000a;

final class C0010c {
    private final C0004a f43a;
    private boolean f44b;
    private C0000a f45c;
    private int f46d;
    private int f47e;
    private int f48f;
    private int f49g;
    private int f50h;
    private int f51i;
    private int f52j;
    private Integer f53k;
    private Integer f54l;
    private Integer f55m;
    private Integer f56n;
    private Integer f57o;
    private Integer f58p;
    private Integer f59q;

    C0010c(C0004a c0004a, C0000a c0000a) {
        int i = 1;
        int i2 = 0;
        this.f43a = c0004a;
        m69a();
        this.f53k = Integer.valueOf(this.f43a.m21a() == null ? 1 : this.f43a.m21a().intValue());
        this.f54l = Integer.valueOf(this.f43a.m27b() == null ? 1 : this.f43a.m27b().intValue());
        if (this.f43a.m31c() != null) {
            i = this.f43a.m31c().intValue();
        }
        this.f55m = Integer.valueOf(i);
        this.f56n = Integer.valueOf(this.f43a.m32d() == null ? 0 : this.f43a.m32d().intValue());
        this.f57o = Integer.valueOf(this.f43a.m33e() == null ? 0 : this.f43a.m33e().intValue());
        this.f58p = Integer.valueOf(this.f43a.m34f() == null ? 0 : this.f43a.m34f().intValue());
        if (this.f43a.m35g() != null) {
            i2 = this.f43a.m35g().intValue();
        }
        this.f59q = Integer.valueOf(i2);
        this.f45c = c0000a;
    }

    private C0004a m68a(boolean z, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.f44b = z;
        this.f46d = num.intValue();
        this.f47e = num2.intValue();
        this.f48f = num3.intValue();
        this.f49g = num4.intValue();
        this.f50h = num5.intValue();
        this.f51i = num6.intValue();
        this.f52j = num7.intValue();
        m71a(Integer.valueOf(this.f46d), "Year");
        m71a(Integer.valueOf(this.f47e), "Month");
        m71a(Integer.valueOf(this.f48f), "Day");
        m71a(Integer.valueOf(this.f49g), "Hour");
        m71a(Integer.valueOf(this.f50h), "Minute");
        m71a(Integer.valueOf(this.f51i), "Second");
        m70a(Integer.valueOf(this.f52j));
        m72b();
        m73c();
        m87q();
        m74d();
        m75e();
        m76f();
        m77g();
        m78h();
        return new C0004a(this.f53k, this.f54l, this.f55m, this.f56n, this.f57o, this.f58p, this.f59q);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m69a() {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 0;
        r0 = 1;
        r2 = r8.f43a;
        r3 = 6;
        r3 = new p000a.p001a.C0004a.C0003d[r3];
        r4 = p000a.p001a.C0004a.C0003d.YEAR;
        r3[r1] = r4;
        r4 = p000a.p001a.C0004a.C0003d.MONTH;
        r3[r0] = r4;
        r4 = p000a.p001a.C0004a.C0003d.DAY;
        r3[r6] = r4;
        r4 = p000a.p001a.C0004a.C0003d.HOUR;
        r3[r7] = r4;
        r4 = 4;
        r5 = p000a.p001a.C0004a.C0003d.MINUTE;
        r3[r4] = r5;
        r4 = 5;
        r5 = p000a.p001a.C0004a.C0003d.SECOND;
        r3[r4] = r5;
        r2 = r2.m24a(r3);
        if (r2 == 0) goto L_0x0033;
    L_0x0029:
        if (r0 != 0) goto L_0x008d;
    L_0x002b:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "For interval calculations, DateTime must have year-month-day, or hour-minute-second, or both.";
        r0.<init>(r1);
        throw r0;
    L_0x0033:
        r2 = r8.f43a;
        r3 = new p000a.p001a.C0004a.C0003d[r7];
        r4 = p000a.p001a.C0004a.C0003d.YEAR;
        r3[r1] = r4;
        r4 = p000a.p001a.C0004a.C0003d.MONTH;
        r3[r0] = r4;
        r4 = p000a.p001a.C0004a.C0003d.DAY;
        r3[r6] = r4;
        r2 = r2.m24a(r3);
        if (r2 == 0) goto L_0x005f;
    L_0x0049:
        r2 = r8.f43a;
        r3 = new p000a.p001a.C0004a.C0003d[r7];
        r4 = p000a.p001a.C0004a.C0003d.HOUR;
        r3[r1] = r4;
        r4 = p000a.p001a.C0004a.C0003d.MINUTE;
        r3[r0] = r4;
        r4 = p000a.p001a.C0004a.C0003d.SECOND;
        r3[r6] = r4;
        r2 = r2.m29b(r3);
        if (r2 != 0) goto L_0x0029;
    L_0x005f:
        r2 = r8.f43a;
        r3 = new p000a.p001a.C0004a.C0003d[r7];
        r4 = p000a.p001a.C0004a.C0003d.YEAR;
        r3[r1] = r4;
        r4 = p000a.p001a.C0004a.C0003d.MONTH;
        r3[r0] = r4;
        r4 = p000a.p001a.C0004a.C0003d.DAY;
        r3[r6] = r4;
        r2 = r2.m29b(r3);
        if (r2 == 0) goto L_0x008b;
    L_0x0075:
        r2 = r8.f43a;
        r3 = new p000a.p001a.C0004a.C0003d[r7];
        r4 = p000a.p001a.C0004a.C0003d.HOUR;
        r3[r1] = r4;
        r4 = p000a.p001a.C0004a.C0003d.MINUTE;
        r3[r0] = r4;
        r4 = p000a.p001a.C0004a.C0003d.SECOND;
        r3[r6] = r4;
        r2 = r2.m24a(r3);
        if (r2 != 0) goto L_0x0029;
    L_0x008b:
        r0 = r1;
        goto L_0x0029;
    L_0x008d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.c.a():void");
    }

    private void m70a(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 999999999) {
            throw new IllegalArgumentException("Nanosecond interval is not in the range 0..999999999");
        }
    }

    private void m71a(Integer num, String str) {
        if (num.intValue() < 0 || num.intValue() > 9999) {
            throw new IllegalArgumentException(str + " is not in the range " + 0 + ".." + 9999);
        }
    }

    private void m72b() {
        if (this.f44b) {
            this.f53k = Integer.valueOf(this.f53k.intValue() + this.f46d);
        } else {
            this.f53k = Integer.valueOf(this.f43a.m21a().intValue() - this.f46d);
        }
    }

    private void m73c() {
        for (int i = 0; i < this.f47e; i++) {
            m80j();
        }
    }

    private void m74d() {
        for (int i = 0; i < this.f48f; i++) {
            m81k();
        }
    }

    private void m75e() {
        for (int i = 0; i < this.f49g; i++) {
            m84n();
        }
    }

    private void m76f() {
        for (int i = 0; i < this.f50h; i++) {
            m85o();
        }
    }

    private void m77g() {
        for (int i = 0; i < this.f51i; i++) {
            m86p();
        }
    }

    private void m78h() {
        if (this.f44b) {
            this.f59q = Integer.valueOf(this.f59q.intValue() + this.f52j);
        } else {
            this.f59q = Integer.valueOf(this.f59q.intValue() - this.f52j);
        }
        if (this.f59q.intValue() > 999999999) {
            m86p();
            this.f59q = Integer.valueOf((this.f59q.intValue() - 999999999) - 1);
        } else if (this.f59q.intValue() < 0) {
            m86p();
            this.f59q = Integer.valueOf((this.f59q.intValue() + 999999999) + 1);
        }
    }

    private void m79i() {
        if (this.f44b) {
            this.f53k = Integer.valueOf(this.f53k.intValue() + 1);
        } else {
            this.f53k = Integer.valueOf(this.f53k.intValue() - 1);
        }
    }

    private void m80j() {
        if (this.f44b) {
            this.f54l = Integer.valueOf(this.f54l.intValue() + 1);
        } else {
            this.f54l = Integer.valueOf(this.f54l.intValue() - 1);
        }
        if (this.f54l.intValue() > 12) {
            this.f54l = Integer.valueOf(1);
            m79i();
        } else if (this.f54l.intValue() < 1) {
            this.f54l = Integer.valueOf(12);
            m79i();
        }
    }

    private void m81k() {
        if (this.f44b) {
            this.f55m = Integer.valueOf(this.f55m.intValue() + 1);
        } else {
            this.f55m = Integer.valueOf(this.f55m.intValue() - 1);
        }
        if (this.f55m.intValue() > m82l()) {
            this.f55m = Integer.valueOf(1);
            m80j();
        } else if (this.f55m.intValue() < 1) {
            this.f55m = Integer.valueOf(m83m());
            m80j();
        }
    }

    private int m82l() {
        return C0004a.m4a(this.f53k, this.f54l).intValue();
    }

    private int m83m() {
        return this.f54l.intValue() > 1 ? C0004a.m4a(this.f53k, Integer.valueOf(this.f54l.intValue() - 1)).intValue() : C0004a.m4a(Integer.valueOf(this.f53k.intValue() - 1), Integer.valueOf(12)).intValue();
    }

    private void m84n() {
        if (this.f44b) {
            this.f56n = Integer.valueOf(this.f56n.intValue() + 1);
        } else {
            this.f56n = Integer.valueOf(this.f56n.intValue() - 1);
        }
        if (this.f56n.intValue() > 23) {
            this.f56n = Integer.valueOf(0);
            m81k();
        } else if (this.f56n.intValue() < 0) {
            this.f56n = Integer.valueOf(23);
            m81k();
        }
    }

    private void m85o() {
        if (this.f44b) {
            this.f57o = Integer.valueOf(this.f57o.intValue() + 1);
        } else {
            this.f57o = Integer.valueOf(this.f57o.intValue() - 1);
        }
        if (this.f57o.intValue() > 59) {
            this.f57o = Integer.valueOf(0);
            m84n();
        } else if (this.f57o.intValue() < 0) {
            this.f57o = Integer.valueOf(59);
            m84n();
        }
    }

    private void m86p() {
        if (this.f44b) {
            this.f58p = Integer.valueOf(this.f58p.intValue() + 1);
        } else {
            this.f58p = Integer.valueOf(this.f58p.intValue() - 1);
        }
        if (this.f58p.intValue() > 59) {
            this.f58p = Integer.valueOf(0);
            m85o();
        } else if (this.f58p.intValue() < 0) {
            this.f58p = Integer.valueOf(59);
            m85o();
        }
    }

    private void m87q() {
        int l = m82l();
        if (this.f55m.intValue() <= l) {
            return;
        }
        if (C0000a.Abort == this.f45c) {
            throw new RuntimeException("Day Overflow: Year:" + this.f53k + " Month:" + this.f54l + " has " + l + " days, but day has value:" + this.f55m + " To avoid these exceptions, please specify a different DayOverflow policy.");
        } else if (C0000a.FirstDay == this.f45c) {
            this.f55m = Integer.valueOf(1);
            m80j();
        } else if (C0000a.LastDay == this.f45c) {
            this.f55m = Integer.valueOf(l);
        } else if (C0000a.Spillover == this.f45c) {
            this.f55m = Integer.valueOf(this.f55m.intValue() - l);
            m80j();
        }
    }

    C0004a m88a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return m68a(true, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }

    C0004a m89b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return m68a(false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
    }
}
