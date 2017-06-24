package android.support.v7.widget;

import android.support.v4.p015g.C0370a;
import android.support.v4.p015g.C0374e;
import android.support.v4.p015g.C0385i.C0382a;
import android.support.v4.p015g.C0385i.C0383b;
import android.support.v7.widget.RecyclerView.C0785e.C0784c;
import android.support.v7.widget.RecyclerView.C0801u;

class bk {
    final C0370a<C0801u, C0862a> f2624a = new C0370a();
    final C0374e<C0801u> f2625b = new C0374e();

    interface C0771b {
        void mo741a(C0801u c0801u);

        void mo742a(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        void mo743b(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        void mo744c(C0801u c0801u, C0784c c0784c, C0784c c0784c2);
    }

    static class C0862a {
        static C0382a<C0862a> f2620d = new C0383b(20);
        int f2621a;
        C0784c f2622b;
        C0784c f2623c;

        private C0862a() {
        }

        static C0862a m5280a() {
            C0862a c0862a = (C0862a) f2620d.mo282a();
            return c0862a == null ? new C0862a() : c0862a;
        }

        static void m5281a(C0862a c0862a) {
            c0862a.f2621a = 0;
            c0862a.f2622b = null;
            c0862a.f2623c = null;
            f2620d.mo283a(c0862a);
        }

        static void m5282b() {
            do {
            } while (f2620d.mo282a() != null);
        }
    }

    bk() {
    }

    private C0784c m5283a(C0801u c0801u, int i) {
        C0784c c0784c = null;
        int a = this.f2624a.m1894a((Object) c0801u);
        if (a >= 0) {
            C0862a c0862a = (C0862a) this.f2624a.m1901c(a);
            if (!(c0862a == null || (c0862a.f2621a & i) == 0)) {
                c0862a.f2621a &= i ^ -1;
                if (i == 4) {
                    c0784c = c0862a.f2622b;
                } else if (i == 8) {
                    c0784c = c0862a.f2623c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((c0862a.f2621a & 12) == 0) {
                    this.f2624a.m1902d(a);
                    C0862a.m5281a(c0862a);
                }
            }
        }
        return c0784c;
    }

    C0801u m5284a(long j) {
        return (C0801u) this.f2625b.m1915a(j);
    }

    void m5285a() {
        this.f2624a.clear();
        this.f2625b.m1923c();
    }

    void m5286a(long j, C0801u c0801u) {
        this.f2625b.m1921b(j, c0801u);
    }

    void m5287a(C0801u c0801u, C0784c c0784c) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        if (c0862a == null) {
            c0862a = C0862a.m5280a();
            this.f2624a.put(c0801u, c0862a);
        }
        c0862a.f2622b = c0784c;
        c0862a.f2621a |= 4;
    }

    void m5288a(C0771b c0771b) {
        for (int size = this.f2624a.size() - 1; size >= 0; size--) {
            C0801u c0801u = (C0801u) this.f2624a.m1900b(size);
            C0862a c0862a = (C0862a) this.f2624a.m1902d(size);
            if ((c0862a.f2621a & 3) == 3) {
                c0771b.mo741a(c0801u);
            } else if ((c0862a.f2621a & 1) != 0) {
                if (c0862a.f2622b == null) {
                    c0771b.mo741a(c0801u);
                } else {
                    c0771b.mo742a(c0801u, c0862a.f2622b, c0862a.f2623c);
                }
            } else if ((c0862a.f2621a & 14) == 14) {
                c0771b.mo743b(c0801u, c0862a.f2622b, c0862a.f2623c);
            } else if ((c0862a.f2621a & 12) == 12) {
                c0771b.mo744c(c0801u, c0862a.f2622b, c0862a.f2623c);
            } else if ((c0862a.f2621a & 4) != 0) {
                c0771b.mo742a(c0801u, c0862a.f2622b, null);
            } else if ((c0862a.f2621a & 8) != 0) {
                c0771b.mo743b(c0801u, c0862a.f2622b, c0862a.f2623c);
            } else if ((c0862a.f2621a & 2) != 0) {
            }
            C0862a.m5281a(c0862a);
        }
    }

    boolean m5289a(C0801u c0801u) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        return (c0862a == null || (c0862a.f2621a & 1) == 0) ? false : true;
    }

    C0784c m5290b(C0801u c0801u) {
        return m5283a(c0801u, 4);
    }

    void m5291b() {
        C0862a.m5282b();
    }

    void m5292b(C0801u c0801u, C0784c c0784c) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        if (c0862a == null) {
            c0862a = C0862a.m5280a();
            this.f2624a.put(c0801u, c0862a);
        }
        c0862a.f2621a |= 2;
        c0862a.f2622b = c0784c;
    }

    C0784c m5293c(C0801u c0801u) {
        return m5283a(c0801u, 8);
    }

    void m5294c(C0801u c0801u, C0784c c0784c) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        if (c0862a == null) {
            c0862a = C0862a.m5280a();
            this.f2624a.put(c0801u, c0862a);
        }
        c0862a.f2623c = c0784c;
        c0862a.f2621a |= 8;
    }

    boolean m5295d(C0801u c0801u) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        return (c0862a == null || (c0862a.f2621a & 4) == 0) ? false : true;
    }

    void m5296e(C0801u c0801u) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        if (c0862a == null) {
            c0862a = C0862a.m5280a();
            this.f2624a.put(c0801u, c0862a);
        }
        r0.f2621a |= 1;
    }

    void m5297f(C0801u c0801u) {
        C0862a c0862a = (C0862a) this.f2624a.get(c0801u);
        if (c0862a != null) {
            c0862a.f2621a &= -2;
        }
    }

    void m5298g(C0801u c0801u) {
        for (int b = this.f2625b.m1918b() - 1; b >= 0; b--) {
            if (c0801u == this.f2625b.m1922c(b)) {
                this.f2625b.m1917a(b);
                break;
            }
        }
        C0862a c0862a = (C0862a) this.f2624a.remove(c0801u);
        if (c0862a != null) {
            C0862a.m5281a(c0862a);
        }
    }

    public void m5299h(C0801u c0801u) {
        m5297f(c0801u);
    }
}
