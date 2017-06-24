package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.view.p016a.C0426c.C0425k;
import android.support.v7.widget.LinearLayoutManager.C0765a;
import android.support.v7.widget.LinearLayoutManager.C0766b;
import android.support.v7.widget.LinearLayoutManager.C0767c;
import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean f2083a = false;
    int f2084b = -1;
    int[] f2085c;
    View[] f2086d;
    final SparseIntArray f2087e = new SparseIntArray();
    final SparseIntArray f2088f = new SparseIntArray();
    C0759c f2089g = new C0760a();
    final Rect f2090h = new Rect();

    public static abstract class C0759c {
        final SparseIntArray f2051a = new SparseIntArray();
        private boolean f2052b = false;

        public abstract int mo701a(int i);

        public int mo702a(int i, int i2) {
            int a = mo701a(i);
            if (a == i2) {
                return 0;
            }
            int b;
            int a2;
            int i3;
            if (this.f2052b && this.f2051a.size() > 0) {
                b = m4065b(i);
                if (b >= 0) {
                    a2 = this.f2051a.get(b) + mo701a(b);
                    b++;
                    i3 = b;
                    while (i3 < i) {
                        b = mo701a(i3);
                        a2 += b;
                        if (a2 == i2) {
                            b = 0;
                        } else if (a2 <= i2) {
                            b = a2;
                        }
                        i3++;
                        a2 = b;
                    }
                    return a2 + a > i2 ? a2 : 0;
                }
            }
            b = 0;
            a2 = 0;
            i3 = b;
            while (i3 < i) {
                b = mo701a(i3);
                a2 += b;
                if (a2 == i2) {
                    b = 0;
                } else if (a2 <= i2) {
                    b = a2;
                }
                i3++;
                a2 = b;
            }
            if (a2 + a > i2) {
            }
        }

        public void m4064a() {
            this.f2051a.clear();
        }

        int m4065b(int i) {
            int i2 = 0;
            int size = this.f2051a.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f2051a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            size = i2 - 1;
            return (size < 0 || size >= this.f2051a.size()) ? -1 : this.f2051a.keyAt(size);
        }

        int m4066b(int i, int i2) {
            if (!this.f2052b) {
                return mo702a(i, i2);
            }
            int i3 = this.f2051a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i3 = mo702a(i, i2);
            this.f2051a.put(i, i3);
            return i3;
        }

        public int m4067c(int i, int i2) {
            int a = mo701a(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int a2 = mo701a(i3);
                i5 += a2;
                if (i5 == i2) {
                    i4++;
                    a2 = 0;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    a2 = i5;
                }
                i3++;
                i5 = a2;
            }
            return i5 + a > i2 ? i4 + 1 : i4;
        }
    }

    public static final class C0760a extends C0759c {
        public int mo701a(int i) {
            return 1;
        }

        public int mo702a(int i, int i2) {
            return i % i2;
        }
    }

    public static class C0762b extends C0761i {
        private int f2057e = -1;
        private int f2058f = 0;

        public C0762b(int i, int i2) {
            super(i, i2);
        }

        public C0762b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0762b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0762b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int m4077a() {
            return this.f2057e;
        }

        public int m4078b() {
            return this.f2058f;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        m4299a(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        m4299a(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m4299a(C0763h.m4081a(context, attributeSet, i, i2).f2134b);
    }

    private void m4278I() {
        this.f2087e.clear();
        this.f2088f.clear();
    }

    private void m4279J() {
        int t = m4204t();
        for (int i = 0; i < t; i++) {
            C0762b c0762b = (C0762b) m4186h(i).getLayoutParams();
            int e = c0762b.m4072e();
            this.f2087e.put(e, c0762b.m4078b());
            this.f2088f.put(e, c0762b.m4077a());
        }
    }

    private void m4280K() {
        m4291l(m4268f() == 1 ? (m4207w() - m4091A()) - m4209y() : (m4208x() - m4092B()) - m4210z());
    }

    private void m4281L() {
        if (this.f2086d == null || this.f2086d.length != this.f2084b) {
            this.f2086d = new View[this.f2084b];
        }
    }

    private int m4282a(C0793n c0793n, C0798r c0798r, int i) {
        if (!c0798r.m4536a()) {
            return this.f2089g.m4067c(i, this.f2084b);
        }
        int b = c0793n.m4474b(i);
        if (b != -1) {
            return this.f2089g.m4067c(b, this.f2084b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private void m4283a(float f, int i) {
        m4291l(Math.max(Math.round(((float) this.f2084b) * f), i));
    }

    private void m4284a(C0793n c0793n, C0798r c0798r, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = 0;
        } else {
            i4 = i - 1;
            i3 = -1;
            i = -1;
        }
        if (this.i == 1 && m4271g()) {
            i5 = this.f2084b - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.f2086d[i5];
            C0762b c0762b = (C0762b) view.getLayoutParams();
            c0762b.f2058f = m4290c(c0793n, c0798r, m4167d(view));
            if (i6 != -1 || c0762b.f2058f <= 1) {
                c0762b.f2057e = i7;
            } else {
                c0762b.f2057e = i7 - (c0762b.f2058f - 1);
            }
            i7 += c0762b.f2058f * i6;
        }
    }

    private void m4285a(View view, int i, int i2, boolean z, boolean z2) {
        m4126a(view, this.f2090h);
        C0761i c0761i = (C0761i) view.getLayoutParams();
        if (z || this.i == 1) {
            i = m4287b(i, c0761i.leftMargin + this.f2090h.left, c0761i.rightMargin + this.f2090h.right);
        }
        if (z || this.i == 0) {
            i2 = m4287b(i2, c0761i.topMargin + this.f2090h.top, c0761i.bottomMargin + this.f2090h.bottom);
        }
        if (z2 ? m4139a(view, i, i2, c0761i) : m4153b(view, i, i2, c0761i)) {
            view.measure(i, i2);
        }
    }

    static int[] m4286a(int[] iArr, int i, int i2) {
        int i3 = 0;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        iArr[0] = 0;
        int i4 = i2 / i;
        int i5 = i2 % i;
        int i6 = 0;
        for (int i7 = 1; i7 <= i; i7++) {
            int i8;
            i3 += i5;
            if (i3 <= 0 || i - i3 >= i5) {
                i8 = i4;
            } else {
                i8 = i4 + 1;
                i3 -= i;
            }
            i6 += i8;
            iArr[i7] = i6;
        }
        return iArr;
    }

    private int m4287b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m4288b(C0793n c0793n, C0798r c0798r, int i) {
        if (!c0798r.m4536a()) {
            return this.f2089g.m4066b(i, this.f2084b);
        }
        int i2 = this.f2088f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0793n.m4474b(i);
        if (i2 != -1) {
            return this.f2089g.m4066b(i2, this.f2084b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private void m4289b(C0793n c0793n, C0798r c0798r, C0765a c0765a, int i) {
        Object obj = 1;
        if (i != 1) {
            obj = null;
        }
        int b = m4288b(c0793n, c0798r, c0765a.f2094a);
        if (obj != null) {
            while (b > 0 && c0765a.f2094a > 0) {
                c0765a.f2094a--;
                b = m4288b(c0793n, c0798r, c0765a.f2094a);
            }
            return;
        }
        int e = c0798r.m4540e() - 1;
        int i2 = c0765a.f2094a;
        int i3 = b;
        while (i2 < e) {
            b = m4288b(c0793n, c0798r, i2 + 1);
            if (b <= i3) {
                break;
            }
            i2++;
            i3 = b;
        }
        c0765a.f2094a = i2;
    }

    private int m4290c(C0793n c0793n, C0798r c0798r, int i) {
        if (!c0798r.m4536a()) {
            return this.f2089g.mo701a(i);
        }
        int i2 = this.f2087e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        i2 = c0793n.m4474b(i);
        if (i2 != -1) {
            return this.f2089g.mo701a(i2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void m4291l(int i) {
        this.f2085c = m4286a(this.f2085c, this.f2084b, i);
    }

    public int mo703a(int i, C0793n c0793n, C0798r c0798r) {
        m4280K();
        m4281L();
        return super.mo703a(i, c0793n, c0798r);
    }

    public int mo725a(C0793n c0793n, C0798r c0798r) {
        return this.i == 0 ? this.f2084b : c0798r.m4540e() < 1 ? 0 : m4282a(c0793n, c0798r, c0798r.m4540e() - 1) + 1;
    }

    public C0761i mo704a() {
        return this.i == 0 ? new C0762b(-2, -1) : new C0762b(-1, -2);
    }

    public C0761i mo726a(Context context, AttributeSet attributeSet) {
        return new C0762b(context, attributeSet);
    }

    public C0761i mo727a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0762b((MarginLayoutParams) layoutParams) : new C0762b(layoutParams);
    }

    View mo728a(C0793n c0793n, C0798r c0798r, int i, int i2, int i3) {
        View view = null;
        m4272h();
        int c = this.j.mo810c();
        int d = this.j.mo812d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m4186h(i);
            int d2 = m4167d(h);
            if (d2 >= 0 && d2 < i3) {
                if (m4288b(c0793n, c0798r, d2) != 0) {
                    view3 = view;
                    h = view2;
                } else if (((C0761i) h.getLayoutParams()).m4070c()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.j.mo807a(h) < d && this.j.mo809b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = h;
            }
            view3 = view;
            h = view2;
            i += i4;
            view = view3;
            view2 = h;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public View mo705a(View view, int i, C0793n c0793n, C0798r c0798r) {
        View e = m4174e(view);
        if (e == null) {
            return null;
        }
        C0762b c0762b = (C0762b) e.getLayoutParams();
        int a = c0762b.f2057e;
        int a2 = c0762b.f2057e + c0762b.f2058f;
        if (super.mo705a(view, i, c0793n, c0798r) == null) {
            return null;
        }
        int t;
        int i2;
        int i3;
        if (((m4265e(i) == 1) != this.k ? 1 : null) != null) {
            t = m4204t() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            t = 0;
            i2 = 1;
            i3 = m4204t();
        }
        Object obj = (this.i == 1 && m4271g()) ? 1 : null;
        View view2 = null;
        int i4 = -1;
        int i5 = 0;
        int i6 = t;
        while (i6 != i3) {
            View h = m4186h(i6);
            if (h == e) {
                break;
            }
            View view3;
            if (h.isFocusable()) {
                c0762b = (C0762b) h.getLayoutParams();
                int a3 = c0762b.f2057e;
                int a4 = c0762b.f2057e + c0762b.f2058f;
                if (a3 == a && a4 == a2) {
                    return h;
                }
                Object obj2 = null;
                if (view2 == null) {
                    obj2 = 1;
                } else {
                    int min = Math.min(a4, a2) - Math.max(a3, a);
                    if (min > i5) {
                        obj2 = 1;
                    } else if (min == i5) {
                        if (obj == (a3 > i4 ? 1 : null)) {
                            obj2 = 1;
                        }
                    }
                }
                if (obj2 != null) {
                    i5 = c0762b.f2057e;
                    t = Math.min(a4, a2) - Math.max(a3, a);
                    view3 = h;
                } else {
                    t = i5;
                    i5 = i4;
                    view3 = view2;
                }
            } else {
                t = i5;
                i5 = i4;
                view3 = view2;
            }
            i6 += i2;
            view2 = view3;
            i4 = i5;
            i5 = t;
        }
        return view2;
    }

    public void m4299a(int i) {
        if (i != this.f2084b) {
            this.f2083a = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.f2084b = i;
            this.f2089g.m4064a();
        }
    }

    public void mo729a(Rect rect, int i, int i2) {
        if (this.f2085c == null) {
            super.mo729a(rect, i, i2);
        }
        int A = m4091A() + m4209y();
        int z = m4210z() + m4092B();
        if (this.i == 1) {
            z = C0763h.m4079a(i2, z + rect.height(), m4095E());
            A = C0763h.m4079a(i, A + this.f2085c[this.f2085c.length - 1], m4094D());
        } else {
            A = C0763h.m4079a(i, A + rect.width(), m4094D());
            z = C0763h.m4079a(i2, z + this.f2085c[this.f2085c.length - 1], m4095E());
        }
        m4170d(A, z);
    }

    void mo730a(C0793n c0793n, C0798r c0798r, C0765a c0765a, int i) {
        super.mo730a(c0793n, c0798r, c0765a, i);
        m4280K();
        if (c0798r.m4540e() > 0 && !c0798r.m4536a()) {
            m4289b(c0793n, c0798r, c0765a, i);
        }
        m4281L();
    }

    void mo731a(C0793n c0793n, C0798r c0798r, C0767c c0767c, C0766b c0766b) {
        int i = this.j.mo818i();
        Object obj = i != 1073741824 ? 1 : null;
        int i2 = m4204t() > 0 ? this.f2085c[this.f2084b] : 0;
        if (obj != null) {
            m4280K();
        }
        boolean z = c0767c.f2106e == 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.f2084b;
        if (!z) {
            i5 = m4288b(c0793n, c0798r, c0767c.f2105d) + m4290c(c0793n, c0798r, c0767c.f2105d);
        }
        while (i3 < this.f2084b && c0767c.m4330a(c0798r) && i5 > 0) {
            int i6 = c0767c.f2105d;
            int c = m4290c(c0793n, c0798r, i6);
            if (c <= this.f2084b) {
                i5 -= c;
                if (i5 >= 0) {
                    View a = c0767c.m4327a(c0793n);
                    if (a == null) {
                        break;
                    }
                    i4 += c;
                    this.f2086d[i3] = a;
                    i3++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i6 + " requires " + c + " spans but GridLayoutManager has only " + this.f2084b + " spans.");
        }
        if (i3 == 0) {
            c0766b.f2099b = true;
            return;
        }
        View view;
        int a2;
        int a3;
        m4284a(c0793n, c0798r, i3, i4, z);
        int i7 = 0;
        float f = 0.0f;
        c = 0;
        while (i7 < i3) {
            View view2 = this.f2086d[i7];
            if (c0767c.f2112k == null) {
                if (z) {
                    m4150b(view2);
                } else {
                    m4151b(view2, 0);
                }
            } else if (z) {
                m4121a(view2);
            } else {
                m4122a(view2, 0);
            }
            C0762b c0762b = (C0762b) view2.getLayoutParams();
            int a4 = C0763h.m4080a(this.f2085c[c0762b.f2057e + c0762b.f2058f] - this.f2085c[c0762b.f2057e], i, 0, this.i == 0 ? c0762b.height : c0762b.width, false);
            int a5 = C0763h.m4080a(this.j.mo815f(), this.j.mo817h(), 0, this.i == 1 ? c0762b.height : c0762b.width, true);
            if (this.i == 1) {
                m4285a(view2, a4, a5, c0762b.height == -1, false);
            } else {
                m4285a(view2, a5, a4, c0762b.width == -1, false);
            }
            i6 = this.j.mo811c(view2);
            if (i6 <= c) {
                i6 = c;
            }
            float d = (1.0f * ((float) this.j.mo813d(view2))) / ((float) c0762b.f2058f);
            if (d <= f) {
                d = f;
            }
            i7++;
            f = d;
            c = i6;
        }
        if (obj != null) {
            m4283a(f, i2);
            c = 0;
            int i8 = 0;
            while (i8 < i3) {
                view = this.f2086d[i8];
                c0762b = (C0762b) view.getLayoutParams();
                a2 = C0763h.m4080a(this.f2085c[c0762b.f2057e + c0762b.f2058f] - this.f2085c[c0762b.f2057e], 1073741824, 0, this.i == 0 ? c0762b.height : c0762b.width, false);
                a3 = C0763h.m4080a(this.j.mo815f(), this.j.mo817h(), 0, this.i == 1 ? c0762b.height : c0762b.width, true);
                if (this.i == 1) {
                    m4285a(view, a2, a3, false, true);
                } else {
                    m4285a(view, a3, a2, false, true);
                }
                i5 = this.j.mo811c(view);
                if (i5 <= c) {
                    i5 = c;
                }
                i8++;
                c = i5;
            }
        }
        a3 = MeasureSpec.makeMeasureSpec(c, 1073741824);
        for (i6 = 0; i6 < i3; i6++) {
            view = this.f2086d[i6];
            if (this.j.mo811c(view) != c) {
                c0762b = (C0762b) view.getLayoutParams();
                a2 = C0763h.m4080a(this.f2085c[c0762b.f2057e + c0762b.f2058f] - this.f2085c[c0762b.f2057e], 1073741824, 0, this.i == 0 ? c0762b.height : c0762b.width, false);
                if (this.i == 1) {
                    m4285a(view, a2, a3, true, true);
                } else {
                    m4285a(view, a3, a2, true, true);
                }
            }
        }
        c0766b.f2098a = c;
        i6 = 0;
        i5 = 0;
        if (this.i == 1) {
            if (c0767c.f2107f == -1) {
                i5 = c0767c.f2103b;
                i6 = i5 - c;
                c = 0;
                i4 = 0;
            } else {
                i6 = c0767c.f2103b;
                i5 = i6 + c;
                c = 0;
                i4 = 0;
            }
        } else if (c0767c.f2107f == -1) {
            i4 = c0767c.f2103b;
            int i9 = i4;
            i4 -= c;
            c = i9;
        } else {
            i4 = c0767c.f2103b;
            c += i4;
        }
        int i10 = 0;
        a2 = i4;
        i4 = c;
        c = i6;
        i6 = i5;
        while (i10 < i3) {
            int i11;
            int i12;
            view = this.f2086d[i10];
            c0762b = (C0762b) view.getLayoutParams();
            if (this.i != 1) {
                c = this.f2085c[c0762b.f2057e] + m4210z();
                i6 = this.j.mo813d(view) + c;
                i11 = i4;
                i12 = a2;
            } else if (m4271g()) {
                i4 = m4209y() + this.f2085c[c0762b.f2057e + c0762b.f2058f];
                i11 = i4;
                i12 = i4 - this.j.mo813d(view);
            } else {
                a2 = this.f2085c[c0762b.f2057e] + m4209y();
                i11 = this.j.mo813d(view) + a2;
                i12 = a2;
            }
            m4124a(view, i12 + c0762b.leftMargin, c + c0762b.topMargin, i11 - c0762b.rightMargin, i6 - c0762b.bottomMargin);
            if (c0762b.m4070c() || c0762b.m4071d()) {
                c0766b.f2100c = true;
            }
            c0766b.f2101d |= view.isFocusable();
            i10++;
            i4 = i11;
            a2 = i12;
        }
        Arrays.fill(this.f2086d, null);
    }

    public void mo732a(C0793n c0793n, C0798r c0798r, View view, C0426c c0426c) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0762b) {
            C0762b c0762b = (C0762b) layoutParams;
            int a = m4282a(c0793n, c0798r, c0762b.m4072e());
            if (this.i == 0) {
                int a2 = c0762b.m4077a();
                int b = c0762b.m4078b();
                boolean z = this.f2084b > 1 && c0762b.m4078b() == this.f2084b;
                c0426c.m2197b(C0425k.m2183a(a2, b, a, 1, z, false));
                return;
            }
            int a3 = c0762b.m4077a();
            int b2 = c0762b.m4078b();
            boolean z2 = this.f2084b > 1 && c0762b.m4078b() == this.f2084b;
            c0426c.m2197b(C0425k.m2183a(a, 1, a3, b2, z2, false));
            return;
        }
        super.m4127a(view, c0426c);
    }

    public void mo733a(RecyclerView recyclerView) {
        this.f2089g.m4064a();
    }

    public void mo734a(RecyclerView recyclerView, int i, int i2) {
        this.f2089g.m4064a();
    }

    public void mo735a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f2089g.m4064a();
    }

    public void mo736a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f2089g.m4064a();
    }

    public void mo737a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo737a(false);
    }

    public boolean mo738a(C0761i c0761i) {
        return c0761i instanceof C0762b;
    }

    public int mo710b(int i, C0793n c0793n, C0798r c0798r) {
        m4280K();
        m4281L();
        return super.mo710b(i, c0793n, c0798r);
    }

    public int mo739b(C0793n c0793n, C0798r c0798r) {
        return this.i == 1 ? this.f2084b : c0798r.m4540e() < 1 ? 0 : m4282a(c0793n, c0798r, c0798r.m4540e() - 1) + 1;
    }

    public void mo740b(RecyclerView recyclerView, int i, int i2) {
        this.f2089g.m4064a();
    }

    public boolean mo712b() {
        return this.n == null && !this.f2083a;
    }

    public void mo716c(C0793n c0793n, C0798r c0798r) {
        if (c0798r.m4536a()) {
            m4279J();
        }
        super.mo716c(c0793n, c0798r);
        m4278I();
        if (!c0798r.m4536a()) {
            this.f2083a = false;
        }
    }
}
