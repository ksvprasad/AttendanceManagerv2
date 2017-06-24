package android.support.v7.widget;

import android.support.v7.widget.C0882f.C0881b;
import java.util.List;

class ar {
    final C0850a f2492a;

    interface C0850a {
        C0881b mo865a(int i, int i2, int i3, Object obj);

        void mo866a(C0881b c0881b);
    }

    public ar(C0850a c0850a) {
        this.f2492a = c0850a;
    }

    private void m5075a(List<C0881b> list, int i, int i2) {
        C0881b c0881b = (C0881b) list.get(i);
        C0881b c0881b2 = (C0881b) list.get(i2);
        switch (c0881b2.f2684a) {
            case 1:
                m5077c(list, i, c0881b, i2, c0881b2);
                return;
            case 2:
                m5079a(list, i, c0881b, i2, c0881b2);
                return;
            case 4:
                m5080b(list, i, c0881b, i2, c0881b2);
                return;
            default:
                return;
        }
    }

    private int m5076b(List<C0881b> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C0881b) list.get(size)).f2684a != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }

    private void m5077c(List<C0881b> list, int i, C0881b c0881b, int i2, C0881b c0881b2) {
        int i3 = 0;
        if (c0881b.f2687d < c0881b2.f2685b) {
            i3 = -1;
        }
        if (c0881b.f2685b < c0881b2.f2685b) {
            i3++;
        }
        if (c0881b2.f2685b <= c0881b.f2685b) {
            c0881b.f2685b += c0881b2.f2687d;
        }
        if (c0881b2.f2685b <= c0881b.f2687d) {
            c0881b.f2687d += c0881b2.f2687d;
        }
        c0881b2.f2685b = i3 + c0881b2.f2685b;
        list.set(i, c0881b2);
        list.set(i2, c0881b);
    }

    void m5078a(List<C0881b> list) {
        while (true) {
            int b = m5076b(list);
            if (b != -1) {
                m5075a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    void m5079a(List<C0881b> list, int i, C0881b c0881b, int i2, C0881b c0881b2) {
        int i3;
        C0881b c0881b3;
        int i4 = 0;
        if (c0881b.f2685b < c0881b.f2687d) {
            i3 = (c0881b2.f2685b == c0881b.f2685b && c0881b2.f2687d == c0881b.f2687d - c0881b.f2685b) ? 1 : 0;
        } else if (c0881b2.f2685b == c0881b.f2687d + 1 && c0881b2.f2687d == c0881b.f2685b - c0881b.f2687d) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c0881b.f2687d < c0881b2.f2685b) {
            c0881b2.f2685b--;
        } else if (c0881b.f2687d < c0881b2.f2685b + c0881b2.f2687d) {
            c0881b2.f2687d--;
            c0881b.f2684a = 2;
            c0881b.f2687d = 1;
            if (c0881b2.f2687d == 0) {
                list.remove(i2);
                this.f2492a.mo866a(c0881b2);
                return;
            }
            return;
        }
        if (c0881b.f2685b <= c0881b2.f2685b) {
            c0881b2.f2685b++;
            c0881b3 = null;
        } else if (c0881b.f2685b < c0881b2.f2685b + c0881b2.f2687d) {
            c0881b3 = this.f2492a.mo865a(2, c0881b.f2685b + 1, (c0881b2.f2685b + c0881b2.f2687d) - c0881b.f2685b, null);
            c0881b2.f2687d = c0881b.f2685b - c0881b2.f2685b;
        } else {
            c0881b3 = null;
        }
        if (i3 != 0) {
            list.set(i, c0881b2);
            list.remove(i2);
            this.f2492a.mo866a(c0881b);
            return;
        }
        if (i4 != 0) {
            if (c0881b3 != null) {
                if (c0881b.f2685b > c0881b3.f2685b) {
                    c0881b.f2685b -= c0881b3.f2687d;
                }
                if (c0881b.f2687d > c0881b3.f2685b) {
                    c0881b.f2687d -= c0881b3.f2687d;
                }
            }
            if (c0881b.f2685b > c0881b2.f2685b) {
                c0881b.f2685b -= c0881b2.f2687d;
            }
            if (c0881b.f2687d > c0881b2.f2685b) {
                c0881b.f2687d -= c0881b2.f2687d;
            }
        } else {
            if (c0881b3 != null) {
                if (c0881b.f2685b >= c0881b3.f2685b) {
                    c0881b.f2685b -= c0881b3.f2687d;
                }
                if (c0881b.f2687d >= c0881b3.f2685b) {
                    c0881b.f2687d -= c0881b3.f2687d;
                }
            }
            if (c0881b.f2685b >= c0881b2.f2685b) {
                c0881b.f2685b -= c0881b2.f2687d;
            }
            if (c0881b.f2687d >= c0881b2.f2685b) {
                c0881b.f2687d -= c0881b2.f2687d;
            }
        }
        list.set(i, c0881b2);
        if (c0881b.f2685b != c0881b.f2687d) {
            list.set(i2, c0881b);
        } else {
            list.remove(i2);
        }
        if (c0881b3 != null) {
            list.add(i, c0881b3);
        }
    }

    void m5080b(List<C0881b> list, int i, C0881b c0881b, int i2, C0881b c0881b2) {
        Object obj;
        Object obj2 = null;
        if (c0881b.f2687d < c0881b2.f2685b) {
            c0881b2.f2685b--;
            obj = null;
        } else if (c0881b.f2687d < c0881b2.f2685b + c0881b2.f2687d) {
            c0881b2.f2687d--;
            obj = this.f2492a.mo865a(4, c0881b.f2685b, 1, c0881b2.f2686c);
        } else {
            obj = null;
        }
        if (c0881b.f2685b <= c0881b2.f2685b) {
            c0881b2.f2685b++;
        } else if (c0881b.f2685b < c0881b2.f2685b + c0881b2.f2687d) {
            int i3 = (c0881b2.f2685b + c0881b2.f2687d) - c0881b.f2685b;
            obj2 = this.f2492a.mo865a(4, c0881b.f2685b + 1, i3, c0881b2.f2686c);
            c0881b2.f2687d -= i3;
        }
        list.set(i2, c0881b);
        if (c0881b2.f2687d > 0) {
            list.set(i, c0881b2);
        } else {
            list.remove(i);
            this.f2492a.mo866a(c0881b2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }
}
