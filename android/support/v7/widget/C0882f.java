package android.support.v7.widget;

import android.support.v4.p015g.C0385i.C0382a;
import android.support.v4.p015g.C0385i.C0383b;
import android.support.v7.widget.RecyclerView.C0801u;
import android.support.v7.widget.ar.C0850a;
import java.util.ArrayList;
import java.util.List;

class C0882f implements C0850a {
    final ArrayList<C0881b> f2688a;
    final ArrayList<C0881b> f2689b;
    final C0775a f2690c;
    Runnable f2691d;
    final boolean f2692e;
    final ar f2693f;
    private C0382a<C0881b> f2694g;
    private int f2695h;

    interface C0775a {
        C0801u mo756a(int i);

        void mo757a(int i, int i2);

        void mo758a(int i, int i2, Object obj);

        void mo759a(C0881b c0881b);

        void mo760b(int i, int i2);

        void mo761b(C0881b c0881b);

        void mo762c(int i, int i2);

        void mo763d(int i, int i2);
    }

    static class C0881b {
        int f2684a;
        int f2685b;
        Object f2686c;
        int f2687d;

        C0881b(int i, int i2, int i3, Object obj) {
            this.f2684a = i;
            this.f2685b = i2;
            this.f2687d = i3;
            this.f2686c = obj;
        }

        String m5370a() {
            switch (this.f2684a) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                case 4:
                    return "up";
                case 8:
                    return "mv";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0881b c0881b = (C0881b) obj;
            return this.f2684a != c0881b.f2684a ? false : (this.f2684a == 8 && Math.abs(this.f2687d - this.f2685b) == 1 && this.f2687d == c0881b.f2685b && this.f2685b == c0881b.f2687d) ? true : this.f2687d != c0881b.f2687d ? false : this.f2685b != c0881b.f2685b ? false : this.f2686c != null ? this.f2686c.equals(c0881b.f2686c) : c0881b.f2686c == null;
        }

        public int hashCode() {
            return (((this.f2684a * 31) + this.f2685b) * 31) + this.f2687d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m5370a() + ",s:" + this.f2685b + "c:" + this.f2687d + ",p:" + this.f2686c + "]";
        }
    }

    C0882f(C0775a c0775a) {
        this(c0775a, false);
    }

    C0882f(C0775a c0775a, boolean z) {
        this.f2694g = new C0383b(30);
        this.f2688a = new ArrayList();
        this.f2689b = new ArrayList();
        this.f2695h = 0;
        this.f2690c = c0775a;
        this.f2692e = z;
        this.f2693f = new ar(this);
    }

    private void m5371b(C0881b c0881b) {
        m5378g(c0881b);
    }

    private int m5372c(int i, int i2) {
        int i3;
        int i4 = i;
        for (int size = this.f2689b.size() - 1; size >= 0; size--) {
            C0881b c0881b = (C0881b) this.f2689b.get(size);
            if (c0881b.f2684a == 8) {
                int i5;
                int i6;
                if (c0881b.f2685b < c0881b.f2687d) {
                    i5 = c0881b.f2685b;
                    i3 = c0881b.f2687d;
                } else {
                    i5 = c0881b.f2687d;
                    i3 = c0881b.f2685b;
                }
                if (i4 < i5 || i4 > r2) {
                    if (i4 < c0881b.f2685b) {
                        if (i2 == 1) {
                            c0881b.f2685b++;
                            c0881b.f2687d++;
                            i6 = i4;
                        } else if (i2 == 2) {
                            c0881b.f2685b--;
                            c0881b.f2687d--;
                        }
                    }
                    i6 = i4;
                } else if (i5 == c0881b.f2685b) {
                    if (i2 == 1) {
                        c0881b.f2687d++;
                    } else if (i2 == 2) {
                        c0881b.f2687d--;
                    }
                    i6 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c0881b.f2685b++;
                    } else if (i2 == 2) {
                        c0881b.f2685b--;
                    }
                    i6 = i4 - 1;
                }
                i4 = i6;
            } else if (c0881b.f2685b <= i4) {
                if (c0881b.f2684a == 1) {
                    i4 -= c0881b.f2687d;
                } else if (c0881b.f2684a == 2) {
                    i4 += c0881b.f2687d;
                }
            } else if (i2 == 1) {
                c0881b.f2685b++;
            } else if (i2 == 2) {
                c0881b.f2685b--;
            }
        }
        for (i3 = this.f2689b.size() - 1; i3 >= 0; i3--) {
            c0881b = (C0881b) this.f2689b.get(i3);
            if (c0881b.f2684a == 8) {
                if (c0881b.f2687d == c0881b.f2685b || c0881b.f2687d < 0) {
                    this.f2689b.remove(i3);
                    mo866a(c0881b);
                }
            } else if (c0881b.f2687d <= 0) {
                this.f2689b.remove(i3);
                mo866a(c0881b);
            }
        }
        return i4;
    }

    private void m5373c(C0881b c0881b) {
        int i = c0881b.f2685b;
        int i2 = c0881b.f2685b + c0881b.f2687d;
        Object obj = -1;
        int i3 = c0881b.f2685b;
        int i4 = 0;
        while (i3 < i2) {
            Object obj2;
            int i5;
            if (this.f2690c.mo756a(i3) != null || m5375d(i3)) {
                if (obj == null) {
                    m5376e(mo865a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = 1;
            } else {
                if (obj == 1) {
                    m5378g(mo865a(2, i, i4, null));
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                obj = null;
            }
            if (obj2 != null) {
                i5 = i3 - i4;
                i3 = i2 - i4;
                i2 = 1;
            } else {
                int i6 = i3;
                i3 = i2;
                i2 = i4 + 1;
                i5 = i6;
            }
            i4 = i2;
            i2 = i3;
            i3 = i5 + 1;
        }
        if (i4 != c0881b.f2687d) {
            mo866a(c0881b);
            c0881b = mo865a(2, i, i4, null);
        }
        if (obj == null) {
            m5376e(c0881b);
        } else {
            m5378g(c0881b);
        }
    }

    private void m5374d(C0881b c0881b) {
        int i = c0881b.f2685b;
        int i2 = c0881b.f2685b + c0881b.f2687d;
        int i3 = c0881b.f2685b;
        Object obj = -1;
        int i4 = 0;
        while (i3 < i2) {
            int i5;
            Object obj2;
            if (this.f2690c.mo756a(i3) != null || m5375d(i3)) {
                if (obj == null) {
                    m5376e(mo865a(4, i, i4, c0881b.f2686c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = 1;
            } else {
                if (obj == 1) {
                    m5378g(mo865a(4, i, i4, c0881b.f2686c));
                    i4 = 0;
                    i = i3;
                }
                i5 = i;
                i = i4;
                obj2 = null;
            }
            i3++;
            Object obj3 = obj2;
            i4 = i + 1;
            i = i5;
            obj = obj3;
        }
        if (i4 != c0881b.f2687d) {
            Object obj4 = c0881b.f2686c;
            mo866a(c0881b);
            c0881b = mo865a(4, i, i4, obj4);
        }
        if (obj == null) {
            m5376e(c0881b);
        } else {
            m5378g(c0881b);
        }
    }

    private boolean m5375d(int i) {
        int size = this.f2689b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0881b c0881b = (C0881b) this.f2689b.get(i2);
            if (c0881b.f2684a == 8) {
                if (m5379a(c0881b.f2687d, i2 + 1) == i) {
                    return true;
                }
            } else if (c0881b.f2684a == 1) {
                int i3 = c0881b.f2685b + c0881b.f2687d;
                for (int i4 = c0881b.f2685b; i4 < i3; i4++) {
                    if (m5379a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void m5376e(C0881b c0881b) {
        if (c0881b.f2684a == 1 || c0881b.f2684a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int c = m5372c(c0881b.f2685b, c0881b.f2684a);
        int i2 = c0881b.f2685b;
        switch (c0881b.f2684a) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + c0881b);
        }
        int i3 = 1;
        int i4 = c;
        c = i2;
        for (i2 = 1; i2 < c0881b.f2687d; i2++) {
            Object obj;
            int c2 = m5372c(c0881b.f2685b + (i * i2), c0881b.f2684a);
            int i5;
            switch (c0881b.f2684a) {
                case 2:
                    if (c2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (c2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                C0881b a = mo865a(c0881b.f2684a, i4, i3, c0881b.f2686c);
                m5383a(a, c);
                mo866a(a);
                if (c0881b.f2684a == 4) {
                    c += i3;
                }
                i3 = 1;
                i4 = c2;
            }
        }
        Object obj2 = c0881b.f2686c;
        mo866a(c0881b);
        if (i3 > 0) {
            C0881b a2 = mo865a(c0881b.f2684a, i4, i3, obj2);
            m5383a(a2, c);
            mo866a(a2);
        }
    }

    private void m5377f(C0881b c0881b) {
        m5378g(c0881b);
    }

    private void m5378g(C0881b c0881b) {
        this.f2689b.add(c0881b);
        switch (c0881b.f2684a) {
            case 1:
                this.f2690c.mo762c(c0881b.f2685b, c0881b.f2687d);
                return;
            case 2:
                this.f2690c.mo760b(c0881b.f2685b, c0881b.f2687d);
                return;
            case 4:
                this.f2690c.mo758a(c0881b.f2685b, c0881b.f2687d, c0881b.f2686c);
                return;
            case 8:
                this.f2690c.mo763d(c0881b.f2685b, c0881b.f2687d);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + c0881b);
        }
    }

    int m5379a(int i, int i2) {
        int size = this.f2689b.size();
        int i3 = i;
        while (i2 < size) {
            C0881b c0881b = (C0881b) this.f2689b.get(i2);
            if (c0881b.f2684a == 8) {
                if (c0881b.f2685b == i3) {
                    i3 = c0881b.f2687d;
                } else {
                    if (c0881b.f2685b < i3) {
                        i3--;
                    }
                    if (c0881b.f2687d <= i3) {
                        i3++;
                    }
                }
            } else if (c0881b.f2685b > i3) {
                continue;
            } else if (c0881b.f2684a == 2) {
                if (i3 < c0881b.f2685b + c0881b.f2687d) {
                    return -1;
                }
                i3 -= c0881b.f2687d;
            } else if (c0881b.f2684a == 1) {
                i3 += c0881b.f2687d;
            }
            i2++;
        }
        return i3;
    }

    public C0881b mo865a(int i, int i2, int i3, Object obj) {
        C0881b c0881b = (C0881b) this.f2694g.mo282a();
        if (c0881b == null) {
            return new C0881b(i, i2, i3, obj);
        }
        c0881b.f2684a = i;
        c0881b.f2685b = i2;
        c0881b.f2687d = i3;
        c0881b.f2686c = obj;
        return c0881b;
    }

    void m5381a() {
        m5384a(this.f2688a);
        m5384a(this.f2689b);
        this.f2695h = 0;
    }

    public void mo866a(C0881b c0881b) {
        if (!this.f2692e) {
            c0881b.f2686c = null;
            this.f2694g.mo283a(c0881b);
        }
    }

    void m5383a(C0881b c0881b, int i) {
        this.f2690c.mo759a(c0881b);
        switch (c0881b.f2684a) {
            case 2:
                this.f2690c.mo757a(i, c0881b.f2687d);
                return;
            case 4:
                this.f2690c.mo758a(i, c0881b.f2687d, c0881b.f2686c);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void m5384a(List<C0881b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo866a((C0881b) list.get(i));
        }
        list.clear();
    }

    boolean m5385a(int i) {
        return (this.f2695h & i) != 0;
    }

    boolean m5386a(int i, int i2, Object obj) {
        this.f2688a.add(mo865a(4, i, i2, obj));
        this.f2695h |= 4;
        return this.f2688a.size() == 1;
    }

    int m5387b(int i) {
        return m5379a(i, 0);
    }

    void m5388b() {
        this.f2693f.m5078a(this.f2688a);
        int size = this.f2688a.size();
        for (int i = 0; i < size; i++) {
            C0881b c0881b = (C0881b) this.f2688a.get(i);
            switch (c0881b.f2684a) {
                case 1:
                    m5377f(c0881b);
                    break;
                case 2:
                    m5373c(c0881b);
                    break;
                case 4:
                    m5374d(c0881b);
                    break;
                case 8:
                    m5371b(c0881b);
                    break;
            }
            if (this.f2691d != null) {
                this.f2691d.run();
            }
        }
        this.f2688a.clear();
    }

    boolean m5389b(int i, int i2) {
        this.f2688a.add(mo865a(2, i, i2, null));
        this.f2695h |= 2;
        return this.f2688a.size() == 1;
    }

    public int m5390c(int i) {
        int size = this.f2688a.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C0881b c0881b = (C0881b) this.f2688a.get(i3);
            switch (c0881b.f2684a) {
                case 1:
                    if (c0881b.f2685b > i2) {
                        break;
                    }
                    i2 += c0881b.f2687d;
                    break;
                case 2:
                    if (c0881b.f2685b <= i2) {
                        if (c0881b.f2685b + c0881b.f2687d <= i2) {
                            i2 -= c0881b.f2687d;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (c0881b.f2685b != i2) {
                        if (c0881b.f2685b < i2) {
                            i2--;
                        }
                        if (c0881b.f2687d > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c0881b.f2687d;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    void m5391c() {
        int size = this.f2689b.size();
        for (int i = 0; i < size; i++) {
            this.f2690c.mo761b((C0881b) this.f2689b.get(i));
        }
        m5384a(this.f2689b);
        this.f2695h = 0;
    }

    boolean m5392d() {
        return this.f2688a.size() > 0;
    }

    void m5393e() {
        m5391c();
        int size = this.f2688a.size();
        for (int i = 0; i < size; i++) {
            C0881b c0881b = (C0881b) this.f2688a.get(i);
            switch (c0881b.f2684a) {
                case 1:
                    this.f2690c.mo761b(c0881b);
                    this.f2690c.mo762c(c0881b.f2685b, c0881b.f2687d);
                    break;
                case 2:
                    this.f2690c.mo761b(c0881b);
                    this.f2690c.mo757a(c0881b.f2685b, c0881b.f2687d);
                    break;
                case 4:
                    this.f2690c.mo761b(c0881b);
                    this.f2690c.mo758a(c0881b.f2685b, c0881b.f2687d, c0881b.f2686c);
                    break;
                case 8:
                    this.f2690c.mo761b(c0881b);
                    this.f2690c.mo763d(c0881b.f2685b, c0881b.f2687d);
                    break;
            }
            if (this.f2691d != null) {
                this.f2691d.run();
            }
        }
        m5384a(this.f2688a);
        this.f2695h = 0;
    }

    boolean m5394f() {
        return (this.f2689b.isEmpty() || this.f2688a.isEmpty()) ? false : true;
    }
}
