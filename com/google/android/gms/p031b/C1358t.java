package com.google.android.gms.p031b;

public abstract class C1358t<M extends C1358t<M>> extends C1357z {
    protected C1845v f4060U;

    protected int mo1230a() {
        int i = 0;
        if (this.f4060U == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.f4060U.m10484a()) {
            i2 += this.f4060U.m10487b(i).m10491a();
            i++;
        }
        return i2;
    }

    public void mo1231a(C1843s c1843s) {
        if (this.f4060U != null) {
            for (int i = 0; i < this.f4060U.m10484a(); i++) {
                this.f4060U.m10487b(i).m10493a(c1843s);
            }
        }
    }

    protected final boolean m7352a(C1841r c1841r, int i) {
        int r = c1841r.m10407r();
        if (!c1841r.m10387b(i)) {
            return false;
        }
        int b = ac.m7338b(i);
        ab abVar = new ab(i, c1841r.m10385a(r, c1841r.m10407r() - r));
        C1846w c1846w = null;
        if (this.f4060U == null) {
            this.f4060U = new C1845v();
        } else {
            c1846w = this.f4060U.m10485a(b);
        }
        if (c1846w == null) {
            c1846w = new C1846w();
            this.f4060U.m10486a(b, c1846w);
        }
        c1846w.m10492a(abVar);
        return true;
    }

    public M mo1235c() {
        C1358t c1358t = (C1358t) super.mo1233d();
        C1847x.m10499a(this, c1358t);
        return c1358t;
    }

    public /* synthetic */ Object clone() {
        return mo1235c();
    }

    public /* synthetic */ C1357z mo1233d() {
        return (C1358t) clone();
    }
}
