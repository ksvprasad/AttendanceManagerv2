package android.support.v7.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p016a.C0413a;
import android.support.v4.view.p016a.C0450l;
import android.support.v7.widget.RecyclerView.C0761i;
import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0763h.C0788a;
import android.support.v7.widget.RecyclerView.C0793n;
import android.support.v7.widget.RecyclerView.C0798r;
import android.support.v7.widget.RecyclerView.C0801u;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends C0763h {
    private C0767c f2070a;
    private boolean f2071b;
    private boolean f2072c;
    private boolean f2073d;
    private boolean f2074e;
    private boolean f2075f;
    int f2076i;
    as f2077j;
    boolean f2078k;
    int f2079l;
    int f2080m;
    SavedState f2081n;
    final C0765a f2082o;

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C07641();
        int f2091a;
        int f2092b;
        boolean f2093c;

        static class C07641 implements Creator<SavedState> {
            C07641() {
            }

            public SavedState m4315a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4316a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4315a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4316a(i);
            }
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.f2091a = parcel.readInt();
            this.f2092b = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2093c = z;
        }

        public SavedState(SavedState savedState) {
            this.f2091a = savedState.f2091a;
            this.f2092b = savedState.f2092b;
            this.f2093c = savedState.f2093c;
        }

        boolean m4317a() {
            return this.f2091a >= 0;
        }

        void m4318b() {
            this.f2091a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2091a);
            parcel.writeInt(this.f2092b);
            parcel.writeInt(this.f2093c ? 1 : 0);
        }
    }

    class C0765a {
        int f2094a;
        int f2095b;
        boolean f2096c;
        final /* synthetic */ LinearLayoutManager f2097d;

        C0765a(LinearLayoutManager linearLayoutManager) {
            this.f2097d = linearLayoutManager;
        }

        private boolean m4320a(View view, C0798r c0798r) {
            C0761i c0761i = (C0761i) view.getLayoutParams();
            return !c0761i.m4070c() && c0761i.m4072e() >= 0 && c0761i.m4072e() < c0798r.m4540e();
        }

        void m4321a() {
            this.f2094a = -1;
            this.f2095b = Integer.MIN_VALUE;
            this.f2096c = false;
        }

        public void m4322a(View view) {
            int b = this.f2097d.f2077j.m5087b();
            if (b >= 0) {
                m4324b(view);
                return;
            }
            this.f2094a = this.f2097d.m4167d(view);
            int c;
            if (this.f2096c) {
                b = (this.f2097d.f2077j.mo812d() - b) - this.f2097d.f2077j.mo809b(view);
                this.f2095b = this.f2097d.f2077j.mo812d() - b;
                if (b > 0) {
                    c = this.f2095b - this.f2097d.f2077j.mo811c(view);
                    int c2 = this.f2097d.f2077j.mo810c();
                    c -= c2 + Math.min(this.f2097d.f2077j.mo807a(view) - c2, 0);
                    if (c < 0) {
                        this.f2095b = Math.min(b, -c) + this.f2095b;
                        return;
                    }
                    return;
                }
                return;
            }
            c = this.f2097d.f2077j.mo807a(view);
            c2 = c - this.f2097d.f2077j.mo810c();
            this.f2095b = c;
            if (c2 > 0) {
                b = (this.f2097d.f2077j.mo812d() - Math.min(0, (this.f2097d.f2077j.mo812d() - b) - this.f2097d.f2077j.mo809b(view))) - (c + this.f2097d.f2077j.mo811c(view));
                if (b < 0) {
                    this.f2095b -= Math.min(c2, -b);
                }
            }
        }

        void m4323b() {
            this.f2095b = this.f2096c ? this.f2097d.f2077j.mo812d() : this.f2097d.f2077j.mo810c();
        }

        public void m4324b(View view) {
            if (this.f2096c) {
                this.f2095b = this.f2097d.f2077j.mo809b(view) + this.f2097d.f2077j.m5087b();
            } else {
                this.f2095b = this.f2097d.f2077j.mo807a(view);
            }
            this.f2094a = this.f2097d.m4167d(view);
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f2094a + ", mCoordinate=" + this.f2095b + ", mLayoutFromEnd=" + this.f2096c + '}';
        }
    }

    protected static class C0766b {
        public int f2098a;
        public boolean f2099b;
        public boolean f2100c;
        public boolean f2101d;

        protected C0766b() {
        }

        void m4325a() {
            this.f2098a = 0;
            this.f2099b = false;
            this.f2100c = false;
            this.f2101d = false;
        }
    }

    static class C0767c {
        boolean f2102a = true;
        int f2103b;
        int f2104c;
        int f2105d;
        int f2106e;
        int f2107f;
        int f2108g;
        int f2109h = 0;
        boolean f2110i = false;
        int f2111j;
        List<C0801u> f2112k = null;
        boolean f2113l;

        C0767c() {
        }

        private View m4326b() {
            int size = this.f2112k.size();
            for (int i = 0; i < size; i++) {
                View view = ((C0801u) this.f2112k.get(i)).f2183a;
                C0761i c0761i = (C0761i) view.getLayoutParams();
                if (!c0761i.m4070c() && this.f2105d == c0761i.m4072e()) {
                    m4329a(view);
                    return view;
                }
            }
            return null;
        }

        View m4327a(C0793n c0793n) {
            if (this.f2112k != null) {
                return m4326b();
            }
            View c = c0793n.m4480c(this.f2105d);
            this.f2105d += this.f2106e;
            return c;
        }

        public void m4328a() {
            m4329a(null);
        }

        public void m4329a(View view) {
            View b = m4331b(view);
            if (b == null) {
                this.f2105d = -1;
            } else {
                this.f2105d = ((C0761i) b.getLayoutParams()).m4072e();
            }
        }

        boolean m4330a(C0798r c0798r) {
            return this.f2105d >= 0 && this.f2105d < c0798r.m4540e();
        }

        public View m4331b(View view) {
            int size = this.f2112k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            while (i2 < size) {
                int i3;
                View view3;
                View view4 = ((C0801u) this.f2112k.get(i2)).f2183a;
                C0761i c0761i = (C0761i) view4.getLayoutParams();
                if (view4 != view) {
                    if (c0761i.m4070c()) {
                        i3 = i;
                        view3 = view2;
                    } else {
                        i3 = (c0761i.m4072e() - this.f2105d) * this.f2106e;
                        if (i3 < 0) {
                            i3 = i;
                            view3 = view2;
                        } else if (i3 < i) {
                            if (i3 == 0) {
                                return view4;
                            }
                            view3 = view4;
                        }
                    }
                    i2++;
                    view2 = view3;
                    i = i3;
                }
                i3 = i;
                view3 = view2;
                i2++;
                view2 = view3;
                i = i3;
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f2072c = false;
        this.f2078k = false;
        this.f2073d = false;
        this.f2074e = true;
        this.f2079l = -1;
        this.f2080m = Integer.MIN_VALUE;
        this.f2081n = null;
        this.f2082o = new C0765a(this);
        m4254b(i);
        m4255b(z);
        m4164c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2072c = false;
        this.f2078k = false;
        this.f2073d = false;
        this.f2074e = true;
        this.f2079l = -1;
        this.f2080m = Integer.MIN_VALUE;
        this.f2081n = null;
        this.f2082o = new C0765a(this);
        C0788a a = C0763h.m4081a(context, attributeSet, i, i2);
        m4254b(a.f2133a);
        m4255b(a.f2135c);
        mo737a(a.f2136d);
        m4164c(true);
    }

    private void m4211I() {
        boolean z = true;
        if (this.f2076i == 1 || !m4271g()) {
            this.f2078k = this.f2072c;
            return;
        }
        if (this.f2072c) {
            z = false;
        }
        this.f2078k = z;
    }

    private View m4212J() {
        return m4186h(this.f2078k ? m4204t() - 1 : 0);
    }

    private View m4213K() {
        return m4186h(this.f2078k ? 0 : m4204t() - 1);
    }

    private int m4214a(int i, C0793n c0793n, C0798r c0798r, boolean z) {
        int d = this.f2077j.mo812d() - i;
        if (d <= 0) {
            return 0;
        }
        d = -m4257c(-d, c0793n, c0798r);
        int i2 = i + d;
        if (!z) {
            return d;
        }
        i2 = this.f2077j.mo812d() - i2;
        if (i2 <= 0) {
            return d;
        }
        this.f2077j.mo808a(i2);
        return d + i2;
    }

    private View m4215a(boolean z, boolean z2) {
        return this.f2078k ? m4242a(m4204t() - 1, -1, z, z2) : m4242a(0, m4204t(), z, z2);
    }

    private void m4216a(int i, int i2, boolean z, C0798r c0798r) {
        int i3 = -1;
        int i4 = 1;
        this.f2070a.f2113l = m4274j();
        this.f2070a.f2109h = m4240a(c0798r);
        this.f2070a.f2107f = i;
        View K;
        C0767c c0767c;
        if (i == 1) {
            C0767c c0767c2 = this.f2070a;
            c0767c2.f2109h += this.f2077j.mo816g();
            K = m4213K();
            c0767c = this.f2070a;
            if (!this.f2078k) {
                i3 = 1;
            }
            c0767c.f2106e = i3;
            this.f2070a.f2105d = m4167d(K) + this.f2070a.f2106e;
            this.f2070a.f2103b = this.f2077j.mo809b(K);
            i3 = this.f2077j.mo809b(K) - this.f2077j.mo812d();
        } else {
            K = m4212J();
            c0767c = this.f2070a;
            c0767c.f2109h += this.f2077j.mo810c();
            c0767c = this.f2070a;
            if (!this.f2078k) {
                i4 = -1;
            }
            c0767c.f2106e = i4;
            this.f2070a.f2105d = m4167d(K) + this.f2070a.f2106e;
            this.f2070a.f2103b = this.f2077j.mo807a(K);
            i3 = (-this.f2077j.mo807a(K)) + this.f2077j.mo810c();
        }
        this.f2070a.f2104c = i2;
        if (z) {
            C0767c c0767c3 = this.f2070a;
            c0767c3.f2104c -= i3;
        }
        this.f2070a.f2108g = i3;
    }

    private void m4217a(C0765a c0765a) {
        m4229e(c0765a.f2094a, c0765a.f2095b);
    }

    private void m4218a(C0793n c0793n, int i) {
        if (i >= 0) {
            int t = m4204t();
            int i2;
            if (this.f2078k) {
                for (i2 = t - 1; i2 >= 0; i2--) {
                    if (this.f2077j.mo809b(m4186h(i2)) > i) {
                        m4219a(c0793n, t - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = 0; i2 < t; i2++) {
                if (this.f2077j.mo809b(m4186h(i2)) > i) {
                    m4219a(c0793n, 0, i2);
                    return;
                }
            }
        }
    }

    private void m4219a(C0793n c0793n, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    m4106a(i3, c0793n);
                }
                return;
            }
            while (i > i2) {
                m4106a(i, c0793n);
                i--;
            }
        }
    }

    private void m4220a(C0793n c0793n, C0767c c0767c) {
        if (c0767c.f2102a && !c0767c.f2113l) {
            if (c0767c.f2107f == -1) {
                m4226b(c0793n, c0767c.f2108g);
            } else {
                m4218a(c0793n, c0767c.f2108g);
            }
        }
    }

    private void m4221a(C0793n c0793n, C0798r c0798r, C0765a c0765a) {
        if (!m4222a(c0798r, c0765a) && !m4228b(c0793n, c0798r, c0765a)) {
            c0765a.m4323b();
            c0765a.f2094a = this.f2073d ? c0798r.m4540e() - 1 : 0;
        }
    }

    private boolean m4222a(C0798r c0798r, C0765a c0765a) {
        boolean z = false;
        if (c0798r.m4536a() || this.f2079l == -1) {
            return false;
        }
        if (this.f2079l < 0 || this.f2079l >= c0798r.m4540e()) {
            this.f2079l = -1;
            this.f2080m = Integer.MIN_VALUE;
            return false;
        }
        c0765a.f2094a = this.f2079l;
        if (this.f2081n != null && this.f2081n.m4317a()) {
            c0765a.f2096c = this.f2081n.f2093c;
            if (c0765a.f2096c) {
                c0765a.f2095b = this.f2077j.mo812d() - this.f2081n.f2092b;
                return true;
            }
            c0765a.f2095b = this.f2077j.mo810c() + this.f2081n.f2092b;
            return true;
        } else if (this.f2080m == Integer.MIN_VALUE) {
            View c = mo715c(this.f2079l);
            if (c == null) {
                if (m4204t() > 0) {
                    if ((this.f2079l < m4167d(m4186h(0))) == this.f2078k) {
                        z = true;
                    }
                    c0765a.f2096c = z;
                }
                c0765a.m4323b();
                return true;
            } else if (this.f2077j.mo811c(c) > this.f2077j.mo815f()) {
                c0765a.m4323b();
                return true;
            } else if (this.f2077j.mo807a(c) - this.f2077j.mo810c() < 0) {
                c0765a.f2095b = this.f2077j.mo810c();
                c0765a.f2096c = false;
                return true;
            } else if (this.f2077j.mo812d() - this.f2077j.mo809b(c) < 0) {
                c0765a.f2095b = this.f2077j.mo812d();
                c0765a.f2096c = true;
                return true;
            } else {
                c0765a.f2095b = c0765a.f2096c ? this.f2077j.mo809b(c) + this.f2077j.m5087b() : this.f2077j.mo807a(c);
                return true;
            }
        } else {
            c0765a.f2096c = this.f2078k;
            if (this.f2078k) {
                c0765a.f2095b = this.f2077j.mo812d() - this.f2080m;
                return true;
            }
            c0765a.f2095b = this.f2077j.mo810c() + this.f2080m;
            return true;
        }
    }

    private int m4223b(int i, C0793n c0793n, C0798r c0798r, boolean z) {
        int c = i - this.f2077j.mo810c();
        if (c <= 0) {
            return 0;
        }
        c = -m4257c(c, c0793n, c0798r);
        int i2 = i + c;
        if (!z) {
            return c;
        }
        i2 -= this.f2077j.mo810c();
        if (i2 <= 0) {
            return c;
        }
        this.f2077j.mo808a(-i2);
        return c - i2;
    }

    private View m4224b(boolean z, boolean z2) {
        return this.f2078k ? m4242a(0, m4204t(), z, z2) : m4242a(m4204t() - 1, -1, z, z2);
    }

    private void m4225b(C0765a c0765a) {
        m4231f(c0765a.f2094a, c0765a.f2095b);
    }

    private void m4226b(C0793n c0793n, int i) {
        int t = m4204t();
        if (i >= 0) {
            int e = this.f2077j.mo814e() - i;
            int i2;
            if (this.f2078k) {
                for (i2 = 0; i2 < t; i2++) {
                    if (this.f2077j.mo807a(m4186h(i2)) < e) {
                        m4219a(c0793n, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (i2 = t - 1; i2 >= 0; i2--) {
                if (this.f2077j.mo807a(m4186h(i2)) < e) {
                    m4219a(c0793n, t - 1, i2);
                    return;
                }
            }
        }
    }

    private void m4227b(C0793n c0793n, C0798r c0798r, int i, int i2) {
        if (c0798r.m4537b() && m4204t() != 0 && !c0798r.m4536a() && mo712b()) {
            int i3 = 0;
            int i4 = 0;
            List b = c0793n.m4475b();
            int size = b.size();
            int d = m4167d(m4186h(0));
            int i5 = 0;
            while (i5 < size) {
                int i6;
                int i7;
                C0801u c0801u = (C0801u) b.get(i5);
                if (c0801u.m4590q()) {
                    i6 = i4;
                    i7 = i3;
                } else {
                    if (((c0801u.m4577d() < d) != this.f2078k ? -1 : 1) == -1) {
                        i7 = this.f2077j.mo811c(c0801u.f2183a) + i3;
                        i6 = i4;
                    } else {
                        i6 = this.f2077j.mo811c(c0801u.f2183a) + i4;
                        i7 = i3;
                    }
                }
                i5++;
                i3 = i7;
                i4 = i6;
            }
            this.f2070a.f2112k = b;
            if (i3 > 0) {
                m4231f(m4167d(m4212J()), i);
                this.f2070a.f2109h = i3;
                this.f2070a.f2104c = 0;
                this.f2070a.m4328a();
                m4239a(c0793n, this.f2070a, c0798r, false);
            }
            if (i4 > 0) {
                m4229e(m4167d(m4213K()), i2);
                this.f2070a.f2109h = i4;
                this.f2070a.f2104c = 0;
                this.f2070a.m4328a();
                m4239a(c0793n, this.f2070a, c0798r, false);
            }
            this.f2070a.f2112k = null;
        }
    }

    private boolean m4228b(C0793n c0793n, C0798r c0798r, C0765a c0765a) {
        boolean z = false;
        if (m4204t() == 0) {
            return false;
        }
        View C = m4093C();
        if (C != null && c0765a.m4320a(C, c0798r)) {
            c0765a.m4322a(C);
            return true;
        } else if (this.f2071b != this.f2073d) {
            return false;
        } else {
            C = c0765a.f2096c ? m4230f(c0793n, c0798r) : m4232g(c0793n, c0798r);
            if (C == null) {
                return false;
            }
            c0765a.m4324b(C);
            if (!c0798r.m4536a() && mo712b()) {
                if (this.f2077j.mo807a(C) >= this.f2077j.mo812d() || this.f2077j.mo809b(C) < this.f2077j.mo810c()) {
                    z = true;
                }
                if (z) {
                    c0765a.f2095b = c0765a.f2096c ? this.f2077j.mo812d() : this.f2077j.mo810c();
                }
            }
            return true;
        }
    }

    private void m4229e(int i, int i2) {
        this.f2070a.f2104c = this.f2077j.mo812d() - i2;
        this.f2070a.f2106e = this.f2078k ? -1 : 1;
        this.f2070a.f2105d = i;
        this.f2070a.f2107f = 1;
        this.f2070a.f2103b = i2;
        this.f2070a.f2108g = Integer.MIN_VALUE;
    }

    private View m4230f(C0793n c0793n, C0798r c0798r) {
        return this.f2078k ? m4234h(c0793n, c0798r) : m4236i(c0793n, c0798r);
    }

    private void m4231f(int i, int i2) {
        this.f2070a.f2104c = i2 - this.f2077j.mo810c();
        this.f2070a.f2105d = i;
        this.f2070a.f2106e = this.f2078k ? 1 : -1;
        this.f2070a.f2107f = -1;
        this.f2070a.f2103b = i2;
        this.f2070a.f2108g = Integer.MIN_VALUE;
    }

    private View m4232g(C0793n c0793n, C0798r c0798r) {
        return this.f2078k ? m4236i(c0793n, c0798r) : m4234h(c0793n, c0798r);
    }

    private int m4233h(C0798r c0798r) {
        boolean z = false;
        if (m4204t() == 0) {
            return 0;
        }
        m4272h();
        as asVar = this.f2077j;
        View a = m4215a(!this.f2074e, true);
        if (!this.f2074e) {
            z = true;
        }
        return ay.m5163a(c0798r, asVar, a, m4224b(z, true), this, this.f2074e, this.f2078k);
    }

    private View m4234h(C0793n c0793n, C0798r c0798r) {
        return mo728a(c0793n, c0798r, 0, m4204t(), c0798r.m4540e());
    }

    private int m4235i(C0798r c0798r) {
        boolean z = false;
        if (m4204t() == 0) {
            return 0;
        }
        m4272h();
        as asVar = this.f2077j;
        View a = m4215a(!this.f2074e, true);
        if (!this.f2074e) {
            z = true;
        }
        return ay.m5162a(c0798r, asVar, a, m4224b(z, true), this, this.f2074e);
    }

    private View m4236i(C0793n c0793n, C0798r c0798r) {
        return mo728a(c0793n, c0798r, m4204t() - 1, -1, c0798r.m4540e());
    }

    private int m4237j(C0798r c0798r) {
        boolean z = false;
        if (m4204t() == 0) {
            return 0;
        }
        m4272h();
        as asVar = this.f2077j;
        View a = m4215a(!this.f2074e, true);
        if (!this.f2074e) {
            z = true;
        }
        return ay.m5164b(c0798r, asVar, a, m4224b(z, true), this, this.f2074e);
    }

    public int mo703a(int i, C0793n c0793n, C0798r c0798r) {
        return this.f2076i == 1 ? 0 : m4257c(i, c0793n, c0798r);
    }

    int m4239a(C0793n c0793n, C0767c c0767c, C0798r c0798r, boolean z) {
        int i = c0767c.f2104c;
        if (c0767c.f2108g != Integer.MIN_VALUE) {
            if (c0767c.f2104c < 0) {
                c0767c.f2108g += c0767c.f2104c;
            }
            m4220a(c0793n, c0767c);
        }
        int i2 = c0767c.f2104c + c0767c.f2109h;
        C0766b c0766b = new C0766b();
        while (true) {
            if ((!c0767c.f2113l && i2 <= 0) || !c0767c.m4330a(c0798r)) {
                break;
            }
            c0766b.m4325a();
            mo731a(c0793n, c0798r, c0767c, c0766b);
            if (!c0766b.f2099b) {
                c0767c.f2103b += c0766b.f2098a * c0767c.f2107f;
                if (!(c0766b.f2100c && this.f2070a.f2112k == null && c0798r.m4536a())) {
                    c0767c.f2104c -= c0766b.f2098a;
                    i2 -= c0766b.f2098a;
                }
                if (c0767c.f2108g != Integer.MIN_VALUE) {
                    c0767c.f2108g += c0766b.f2098a;
                    if (c0767c.f2104c < 0) {
                        c0767c.f2108g += c0767c.f2104c;
                    }
                    m4220a(c0793n, c0767c);
                }
                if (z && c0766b.f2101d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0767c.f2104c;
    }

    protected int m4240a(C0798r c0798r) {
        return c0798r.m4539d() ? this.f2077j.mo815f() : 0;
    }

    public C0761i mo704a() {
        return new C0761i(-2, -2);
    }

    View m4242a(int i, int i2, boolean z, boolean z2) {
        m4272h();
        int c = this.f2077j.mo810c();
        int d = this.f2077j.mo812d();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View h = m4186h(i);
            int a = this.f2077j.mo807a(h);
            int b = this.f2077j.mo809b(h);
            if (a < d && b > c) {
                if (!z) {
                    return h;
                }
                if (a >= c && b <= d) {
                    return h;
                }
                if (z2 && view == null) {
                    i += i3;
                    view = h;
                }
            }
            h = view;
            i += i3;
            view = h;
        }
        return view;
    }

    View mo728a(C0793n c0793n, C0798r c0798r, int i, int i2, int i3) {
        View view = null;
        m4272h();
        int c = this.f2077j.mo810c();
        int d = this.f2077j.mo812d();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View view3;
            View h = m4186h(i);
            int d2 = m4167d(h);
            if (d2 >= 0 && d2 < i3) {
                if (((C0761i) h.getLayoutParams()).m4070c()) {
                    if (view2 == null) {
                        view3 = view;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                } else if (this.f2077j.mo807a(h) < d && this.f2077j.mo809b(h) >= c) {
                    return h;
                } else {
                    if (view == null) {
                        view3 = h;
                        h = view2;
                        i += i4;
                        view = view3;
                        view2 = h;
                    }
                }
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
        m4211I();
        if (m4204t() == 0) {
            return null;
        }
        int e = m4265e(i);
        if (e == Integer.MIN_VALUE) {
            return null;
        }
        m4272h();
        View g = e == -1 ? m4232g(c0793n, c0798r) : m4230f(c0793n, c0798r);
        if (g == null) {
            return null;
        }
        m4272h();
        m4216a(e, (int) (0.33333334f * ((float) this.f2077j.mo815f())), false, c0798r);
        this.f2070a.f2108g = Integer.MIN_VALUE;
        this.f2070a.f2102a = false;
        m4239a(c0793n, this.f2070a, c0798r, true);
        View J = e == -1 ? m4212J() : m4213K();
        return (J == g || !J.isFocusable()) ? null : J;
    }

    public void mo706a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f2081n = (SavedState) parcelable;
            m4197n();
        }
    }

    void mo730a(C0793n c0793n, C0798r c0798r, C0765a c0765a, int i) {
    }

    void mo731a(C0793n c0793n, C0798r c0798r, C0767c c0767c, C0766b c0766b) {
        View a = c0767c.m4327a(c0793n);
        if (a == null) {
            c0766b.f2099b = true;
            return;
        }
        int w;
        int d;
        int i;
        int i2;
        C0761i c0761i = (C0761i) a.getLayoutParams();
        if (c0767c.f2112k == null) {
            if (this.f2078k == (c0767c.f2107f == -1)) {
                m4150b(a);
            } else {
                m4151b(a, 0);
            }
        } else {
            if (this.f2078k == (c0767c.f2107f == -1)) {
                m4121a(a);
            } else {
                m4122a(a, 0);
            }
        }
        m4123a(a, 0, 0);
        c0766b.f2098a = this.f2077j.mo811c(a);
        if (this.f2076i == 1) {
            if (m4271g()) {
                w = m4207w() - m4091A();
                d = w - this.f2077j.mo813d(a);
            } else {
                d = m4209y();
                w = this.f2077j.mo813d(a) + d;
            }
            if (c0767c.f2107f == -1) {
                i = c0767c.f2103b - c0766b.f2098a;
                i2 = w;
                w = c0767c.f2103b;
            } else {
                i = c0767c.f2103b;
                i2 = w;
                w = c0767c.f2103b + c0766b.f2098a;
            }
        } else {
            i = m4210z();
            w = this.f2077j.mo813d(a) + i;
            if (c0767c.f2107f == -1) {
                d = c0767c.f2103b - c0766b.f2098a;
                i2 = c0767c.f2103b;
            } else {
                d = c0767c.f2103b;
                i2 = c0767c.f2103b + c0766b.f2098a;
            }
        }
        m4124a(a, d + c0761i.leftMargin, i + c0761i.topMargin, i2 - c0761i.rightMargin, w - c0761i.bottomMargin);
        if (c0761i.m4070c() || c0761i.m4071d()) {
            c0766b.f2100c = true;
        }
        c0766b.f2101d = a.isFocusable();
    }

    public void mo707a(RecyclerView recyclerView, C0793n c0793n) {
        super.mo707a(recyclerView, c0793n);
        if (this.f2075f) {
            m4158c(c0793n);
            c0793n.m4466a();
        }
    }

    public void mo708a(AccessibilityEvent accessibilityEvent) {
        super.mo708a(accessibilityEvent);
        if (m4204t() > 0) {
            C0450l a = C0413a.m2088a(accessibilityEvent);
            a.m2297b(m4276l());
            a.m2298c(m4277m());
        }
    }

    public void mo709a(String str) {
        if (this.f2081n == null) {
            super.mo709a(str);
        }
    }

    public void mo737a(boolean z) {
        mo709a(null);
        if (this.f2073d != z) {
            this.f2073d = z;
            m4197n();
        }
    }

    public int mo710b(int i, C0793n c0793n, C0798r c0798r) {
        return this.f2076i == 0 ? 0 : m4257c(i, c0793n, c0798r);
    }

    public int mo711b(C0798r c0798r) {
        return m4233h(c0798r);
    }

    public void m4254b(int i) {
        if (i == 0 || i == 1) {
            mo709a(null);
            if (i != this.f2076i) {
                this.f2076i = i;
                this.f2077j = null;
                m4197n();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i);
    }

    public void m4255b(boolean z) {
        mo709a(null);
        if (z != this.f2072c) {
            this.f2072c = z;
            m4197n();
        }
    }

    public boolean mo712b() {
        return this.f2081n == null && this.f2071b == this.f2073d;
    }

    int m4257c(int i, C0793n c0793n, C0798r c0798r) {
        if (m4204t() == 0 || i == 0) {
            return 0;
        }
        this.f2070a.f2102a = true;
        m4272h();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        m4216a(i2, abs, true, c0798r);
        int a = this.f2070a.f2108g + m4239a(c0793n, this.f2070a, c0798r, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.f2077j.mo808a(-i);
        this.f2070a.f2111j = i;
        return i;
    }

    public int mo713c(C0798r c0798r) {
        return m4233h(c0798r);
    }

    public Parcelable mo714c() {
        if (this.f2081n != null) {
            return new SavedState(this.f2081n);
        }
        Parcelable savedState = new SavedState();
        if (m4204t() > 0) {
            m4272h();
            boolean z = this.f2071b ^ this.f2078k;
            savedState.f2093c = z;
            View K;
            if (z) {
                K = m4213K();
                savedState.f2092b = this.f2077j.mo812d() - this.f2077j.mo809b(K);
                savedState.f2091a = m4167d(K);
                return savedState;
            }
            K = m4212J();
            savedState.f2091a = m4167d(K);
            savedState.f2092b = this.f2077j.mo807a(K) - this.f2077j.mo810c();
            return savedState;
        }
        savedState.m4318b();
        return savedState;
    }

    public View mo715c(int i) {
        int t = m4204t();
        if (t == 0) {
            return null;
        }
        int d = i - m4167d(m4186h(0));
        if (d >= 0 && d < t) {
            View h = m4186h(d);
            if (m4167d(h) == i) {
                return h;
            }
        }
        return super.mo715c(i);
    }

    public void mo716c(C0793n c0793n, C0798r c0798r) {
        if (!(this.f2081n == null && this.f2079l == -1) && c0798r.m4540e() == 0) {
            m4158c(c0793n);
            return;
        }
        int i;
        int d;
        if (this.f2081n != null && this.f2081n.m4317a()) {
            this.f2079l = this.f2081n.f2091a;
        }
        m4272h();
        this.f2070a.f2102a = false;
        m4211I();
        this.f2082o.m4321a();
        this.f2082o.f2096c = this.f2078k ^ this.f2073d;
        m4221a(c0793n, c0798r, this.f2082o);
        int a = m4240a(c0798r);
        if (this.f2070a.f2111j >= 0) {
            i = 0;
        } else {
            i = a;
            a = 0;
        }
        i += this.f2077j.mo810c();
        a += this.f2077j.mo816g();
        if (!(!c0798r.m4536a() || this.f2079l == -1 || this.f2080m == Integer.MIN_VALUE)) {
            View c = mo715c(this.f2079l);
            if (c != null) {
                d = this.f2078k ? (this.f2077j.mo812d() - this.f2077j.mo809b(c)) - this.f2080m : this.f2080m - (this.f2077j.mo807a(c) - this.f2077j.mo810c());
                if (d > 0) {
                    i += d;
                } else {
                    a -= d;
                }
            }
        }
        d = this.f2082o.f2096c ? this.f2078k ? 1 : -1 : this.f2078k ? -1 : 1;
        mo730a(c0793n, c0798r, this.f2082o, d);
        m4111a(c0793n);
        this.f2070a.f2113l = m4274j();
        this.f2070a.f2110i = c0798r.m4536a();
        int i2;
        if (this.f2082o.f2096c) {
            m4225b(this.f2082o);
            this.f2070a.f2109h = i;
            m4239a(c0793n, this.f2070a, c0798r, false);
            i = this.f2070a.f2103b;
            i2 = this.f2070a.f2105d;
            if (this.f2070a.f2104c > 0) {
                a += this.f2070a.f2104c;
            }
            m4217a(this.f2082o);
            this.f2070a.f2109h = a;
            C0767c c0767c = this.f2070a;
            c0767c.f2105d += this.f2070a.f2106e;
            m4239a(c0793n, this.f2070a, c0798r, false);
            d = this.f2070a.f2103b;
            if (this.f2070a.f2104c > 0) {
                a = this.f2070a.f2104c;
                m4231f(i2, i);
                this.f2070a.f2109h = a;
                m4239a(c0793n, this.f2070a, c0798r, false);
                a = this.f2070a.f2103b;
            } else {
                a = i;
            }
            i = a;
            a = d;
        } else {
            m4217a(this.f2082o);
            this.f2070a.f2109h = a;
            m4239a(c0793n, this.f2070a, c0798r, false);
            a = this.f2070a.f2103b;
            d = this.f2070a.f2105d;
            if (this.f2070a.f2104c > 0) {
                i += this.f2070a.f2104c;
            }
            m4225b(this.f2082o);
            this.f2070a.f2109h = i;
            C0767c c0767c2 = this.f2070a;
            c0767c2.f2105d += this.f2070a.f2106e;
            m4239a(c0793n, this.f2070a, c0798r, false);
            i = this.f2070a.f2103b;
            if (this.f2070a.f2104c > 0) {
                i2 = this.f2070a.f2104c;
                m4229e(d, a);
                this.f2070a.f2109h = i2;
                m4239a(c0793n, this.f2070a, c0798r, false);
                a = this.f2070a.f2103b;
            }
        }
        if (m4204t() > 0) {
            int b;
            if ((this.f2078k ^ this.f2073d) != 0) {
                d = m4214a(a, c0793n, c0798r, true);
                i += d;
                a += d;
                b = m4223b(i, c0793n, c0798r, false);
                i += b;
                a += b;
            } else {
                d = m4223b(i, c0793n, c0798r, true);
                i += d;
                a += d;
                b = m4214a(a, c0793n, c0798r, false);
                i += b;
                a += b;
            }
        }
        m4227b(c0793n, c0798r, i, a);
        if (!c0798r.m4536a()) {
            this.f2079l = -1;
            this.f2080m = Integer.MIN_VALUE;
            this.f2077j.m5085a();
        }
        this.f2071b = this.f2073d;
        this.f2081n = null;
    }

    public int mo717d(C0798r c0798r) {
        return m4235i(c0798r);
    }

    public void mo718d(int i) {
        this.f2079l = i;
        this.f2080m = Integer.MIN_VALUE;
        if (this.f2081n != null) {
            this.f2081n.m4318b();
        }
        m4197n();
    }

    public boolean mo719d() {
        return this.f2076i == 0;
    }

    int m4265e(int i) {
        int i2 = 1;
        int i3 = Integer.MIN_VALUE;
        switch (i) {
            case 1:
                return -1;
            case 2:
                return 1;
            case 17:
                return this.f2076i != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.f2076i != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                if (this.f2076i != 0) {
                    i2 = Integer.MIN_VALUE;
                }
                return i2;
            case 130:
                if (this.f2076i == 1) {
                    i3 = 1;
                }
                return i3;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int mo720e(C0798r c0798r) {
        return m4235i(c0798r);
    }

    public boolean mo721e() {
        return this.f2076i == 1;
    }

    public int m4268f() {
        return this.f2076i;
    }

    public int mo722f(C0798r c0798r) {
        return m4237j(c0798r);
    }

    public int mo723g(C0798r c0798r) {
        return m4237j(c0798r);
    }

    protected boolean m4271g() {
        return m4202r() == 1;
    }

    void m4272h() {
        if (this.f2070a == null) {
            this.f2070a = m4273i();
        }
        if (this.f2077j == null) {
            this.f2077j = as.m5082a(this, this.f2076i);
        }
    }

    C0767c m4273i() {
        return new C0767c();
    }

    boolean m4274j() {
        return this.f2077j.mo817h() == 0 && this.f2077j.mo814e() == 0;
    }

    boolean mo724k() {
        return (m4206v() == 1073741824 || m4205u() == 1073741824 || !m4098H()) ? false : true;
    }

    public int m4276l() {
        View a = m4242a(0, m4204t(), false, true);
        return a == null ? -1 : m4167d(a);
    }

    public int m4277m() {
        View a = m4242a(m4204t() - 1, -1, false, true);
        return a == null ? -1 : m4167d(a);
    }
}
