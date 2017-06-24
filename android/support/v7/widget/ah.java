package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0801u;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class ah {
    final C0773b f2374a;
    final C0826a f2375b = new C0826a();
    final List<View> f2376c = new ArrayList();

    interface C0773b {
        int mo745a();

        int mo746a(View view);

        void mo747a(int i);

        void mo748a(View view, int i);

        void mo749a(View view, int i, LayoutParams layoutParams);

        C0801u mo750b(View view);

        View mo751b(int i);

        void mo752b();

        void mo753c(int i);

        void mo754c(View view);

        void mo755d(View view);
    }

    static class C0826a {
        long f2372a = 0;
        C0826a f2373b;

        C0826a() {
        }

        private void m4889b() {
            if (this.f2373b == null) {
                this.f2373b = new C0826a();
            }
        }

        void m4890a() {
            this.f2372a = 0;
            if (this.f2373b != null) {
                this.f2373b.m4890a();
            }
        }

        void m4891a(int i) {
            if (i >= 64) {
                m4889b();
                this.f2373b.m4891a(i - 64);
                return;
            }
            this.f2372a |= 1 << i;
        }

        void m4892a(int i, boolean z) {
            if (i >= 64) {
                m4889b();
                this.f2373b.m4892a(i - 64, z);
                return;
            }
            boolean z2 = (this.f2372a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f2372a = (((j ^ -1) & this.f2372a) << 1) | (this.f2372a & j);
            if (z) {
                m4891a(i);
            } else {
                m4893b(i);
            }
            if (z2 || this.f2373b != null) {
                m4889b();
                this.f2373b.m4892a(0, z2);
            }
        }

        void m4893b(int i) {
            if (i < 64) {
                this.f2372a &= (1 << i) ^ -1;
            } else if (this.f2373b != null) {
                this.f2373b.m4893b(i - 64);
            }
        }

        boolean m4894c(int i) {
            if (i < 64) {
                return (this.f2372a & (1 << i)) != 0;
            } else {
                m4889b();
                return this.f2373b.m4894c(i - 64);
            }
        }

        boolean m4895d(int i) {
            if (i >= 64) {
                m4889b();
                return this.f2373b.m4895d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f2372a & j) != 0;
            this.f2372a &= j ^ -1;
            j--;
            this.f2372a = Long.rotateRight((j ^ -1) & this.f2372a, 1) | (this.f2372a & j);
            if (this.f2373b == null) {
                return z;
            }
            if (this.f2373b.m4894c(0)) {
                m4891a(63);
            }
            this.f2373b.m4895d(0);
            return z;
        }

        int m4896e(int i) {
            return this.f2373b == null ? i >= 64 ? Long.bitCount(this.f2372a) : Long.bitCount(this.f2372a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f2372a & ((1 << i) - 1)) : this.f2373b.m4896e(i - 64) + Long.bitCount(this.f2372a);
        }

        public String toString() {
            return this.f2373b == null ? Long.toBinaryString(this.f2372a) : this.f2373b.toString() + "xx" + Long.toBinaryString(this.f2372a);
        }
    }

    ah(C0773b c0773b) {
        this.f2374a = c0773b;
    }

    private int m4897e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f2374a.mo745a();
        int i2 = i;
        while (i2 < a) {
            int e = i - (i2 - this.f2375b.m4896e(i2));
            if (e == 0) {
                while (this.f2375b.m4894c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += e;
        }
        return -1;
    }

    private void m4898g(View view) {
        this.f2376c.add(view);
        this.f2374a.mo754c(view);
    }

    private boolean m4899h(View view) {
        if (!this.f2376c.remove(view)) {
            return false;
        }
        this.f2374a.mo755d(view);
        return true;
    }

    View m4900a(int i, int i2) {
        int size = this.f2376c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) this.f2376c.get(i3);
            C0801u b = this.f2374a.mo750b(view);
            if (b.m4577d() == i && !b.m4587n() && !b.m4590q() && (i2 == -1 || b.m4581h() == i2)) {
                return view;
            }
        }
        return null;
    }

    void m4901a() {
        this.f2375b.m4890a();
        for (int size = this.f2376c.size() - 1; size >= 0; size--) {
            this.f2374a.mo755d((View) this.f2376c.get(size));
            this.f2376c.remove(size);
        }
        this.f2374a.mo752b();
    }

    void m4902a(int i) {
        int e = m4897e(i);
        View b = this.f2374a.mo751b(e);
        if (b != null) {
            if (this.f2375b.m4895d(e)) {
                m4899h(b);
            }
            this.f2374a.mo747a(e);
        }
    }

    void m4903a(View view) {
        int a = this.f2374a.mo746a(view);
        if (a >= 0) {
            if (this.f2375b.m4895d(a)) {
                m4899h(view);
            }
            this.f2374a.mo747a(a);
        }
    }

    void m4904a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a = i < 0 ? this.f2374a.mo745a() : m4897e(i);
        this.f2375b.m4892a(a, z);
        if (z) {
            m4898g(view);
        }
        this.f2374a.mo749a(view, a, layoutParams);
    }

    void m4905a(View view, int i, boolean z) {
        int a = i < 0 ? this.f2374a.mo745a() : m4897e(i);
        this.f2375b.m4892a(a, z);
        if (z) {
            m4898g(view);
        }
        this.f2374a.mo748a(view, a);
    }

    void m4906a(View view, boolean z) {
        m4905a(view, -1, z);
    }

    int m4907b() {
        return this.f2374a.mo745a() - this.f2376c.size();
    }

    int m4908b(View view) {
        int a = this.f2374a.mo746a(view);
        return (a == -1 || this.f2375b.m4894c(a)) ? -1 : a - this.f2375b.m4896e(a);
    }

    View m4909b(int i) {
        return this.f2374a.mo751b(m4897e(i));
    }

    int m4910c() {
        return this.f2374a.mo745a();
    }

    View m4911c(int i) {
        return this.f2374a.mo751b(i);
    }

    boolean m4912c(View view) {
        return this.f2376c.contains(view);
    }

    void m4913d(int i) {
        int e = m4897e(i);
        this.f2375b.m4895d(e);
        this.f2374a.mo753c(e);
    }

    void m4914d(View view) {
        int a = this.f2374a.mo746a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f2375b.m4891a(a);
        m4898g(view);
    }

    void m4915e(View view) {
        int a = this.f2374a.mo746a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f2375b.m4894c(a)) {
            this.f2375b.m4893b(a);
            m4899h(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    boolean m4916f(View view) {
        int a = this.f2374a.mo746a(view);
        if (a == -1) {
            return m4899h(view) ? true : true;
        } else {
            if (!this.f2375b.m4894c(a)) {
                return false;
            }
            this.f2375b.m4895d(a);
            if (m4899h(view)) {
                this.f2374a.mo747a(a);
            } else {
                this.f2374a.mo747a(a);
            }
            return true;
        }
    }

    public String toString() {
        return this.f2375b.toString() + ", hidden list:" + this.f2376c.size();
    }
}
