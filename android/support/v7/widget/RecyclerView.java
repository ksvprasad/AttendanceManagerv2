package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.p006e.C0344g;
import android.support.v4.view.C0051w;
import android.support.v4.view.C0543s;
import android.support.v4.view.C0547x;
import android.support.v4.view.ac;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.support.v4.view.ar;
import android.support.v4.view.p016a.C0413a;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.view.p016a.C0426c.C0424j;
import android.support.v4.view.p016a.C0426c.C0425k;
import android.support.v4.view.p016a.C0450l;
import android.support.v4.widget.C0576h;
import android.support.v4.widget.C0599u;
import android.support.v7.p021e.C0701a.C0700a;
import android.support.v7.widget.C0882f.C0775a;
import android.support.v7.widget.C0882f.C0881b;
import android.support.v7.widget.ah.C0773b;
import android.support.v7.widget.bk.C0771b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements ac, C0051w {
    static final boolean f193a = (VERSION.SDK_INT >= 23);
    private static final Interpolator aq = new C07703();
    private static final int[] f194k = new int[]{16843830};
    private static final boolean f195l;
    private static final Class<?>[] f196m = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private int f197A;
    private boolean f198B;
    private boolean f199C;
    private boolean f200D;
    private int f201E;
    private boolean f202F;
    private final boolean f203G;
    private final AccessibilityManager f204H;
    private List<C0789j> f205I;
    private boolean f206J;
    private int f207K;
    private C0576h f208L;
    private C0576h f209M;
    private C0576h f210N;
    private C0576h f211O;
    private int f212P;
    private int f213Q;
    private VelocityTracker f214R;
    private int f215S;
    private int f216T;
    private int f217U;
    private int f218V;
    private int f219W;
    private final int aa;
    private final int ab;
    private float ac;
    private final C0800t ad;
    private C0791l ae;
    private List<C0791l> af;
    private C0783b ag;
    private boolean ah;
    private at ai;
    private C0781d aj;
    private final int[] ak;
    private C0547x al;
    private final int[] am;
    private final int[] an;
    private final int[] ao;
    private Runnable ap;
    private final C0771b ar;
    final C0793n f220b;
    C0882f f221c;
    ah f222d;
    final bk f223e;
    C0763h f224f;
    C0785e f225g;
    final C0798r f226h;
    boolean f227i;
    boolean f228j;
    private final C0795p f229n;
    private SavedState f230o;
    private boolean f231p;
    private final Runnable f232q;
    private final Rect f233r;
    private C0778a f234s;
    private C0794o f235t;
    private final ArrayList<C0787g> f236u;
    private final ArrayList<C0790k> f237v;
    private C0790k f238w;
    private boolean f239x;
    private boolean f240y;
    private boolean f241z;

    public static class C0761i extends MarginLayoutParams {
        C0801u f2053a;
        final Rect f2054b = new Rect();
        boolean f2055c = true;
        boolean f2056d = false;

        public C0761i(int i, int i2) {
            super(i, i2);
        }

        public C0761i(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0761i(C0761i c0761i) {
            super(c0761i);
        }

        public C0761i(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0761i(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean m4070c() {
            return this.f2053a.m4590q();
        }

        public boolean m4071d() {
            return this.f2053a.m4597x();
        }

        public int m4072e() {
            return this.f2053a.m4577d();
        }
    }

    public static abstract class C0763h {
        private boolean f2059a = false;
        private boolean f2060b = false;
        private boolean f2061c = true;
        private int f2062d;
        private int f2063e;
        private int f2064f;
        private int f2065g;
        ah f2066p;
        RecyclerView f2067q;
        C0797q f2068r;
        boolean f2069s = false;

        public static class C0788a {
            public int f2133a;
            public int f2134b;
            public boolean f2135c;
            public boolean f2136d;
        }

        public static int m4079a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public static int m4080a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static C0788a m4081a(Context context, AttributeSet attributeSet, int i, int i2) {
            C0788a c0788a = new C0788a();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0700a.RecyclerView, i, i2);
            c0788a.f2133a = obtainStyledAttributes.getInt(C0700a.RecyclerView_android_orientation, 1);
            c0788a.f2134b = obtainStyledAttributes.getInt(C0700a.RecyclerView_spanCount, 1);
            c0788a.f2135c = obtainStyledAttributes.getBoolean(C0700a.RecyclerView_reverseLayout, false);
            c0788a.f2136d = obtainStyledAttributes.getBoolean(C0700a.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return c0788a;
        }

        private void m4082a(int i, View view) {
            this.f2066p.m4913d(i);
        }

        private void m4084a(C0793n c0793n, int i, View view) {
            C0801u c = RecyclerView.m251c(view);
            if (!c.m4576c()) {
                if (!c.m4587n() || c.m4590q() || this.f2067q.f234s.m4397b()) {
                    m4184g(i);
                    c0793n.m4484c(view);
                    this.f2067q.f223e.m5299h(c);
                    return;
                }
                m4180f(i);
                c0793n.m4478b(c);
            }
        }

        private void m4085a(C0797q c0797q) {
            if (this.f2068r == c0797q) {
                this.f2068r = null;
            }
        }

        private void m4086a(View view, int i, boolean z) {
            C0801u c = RecyclerView.m251c(view);
            if (z || c.m4590q()) {
                this.f2067q.f223e.m5296e(c);
            } else {
                this.f2067q.f223e.m5297f(c);
            }
            C0761i c0761i = (C0761i) view.getLayoutParams();
            if (c.m4584k() || c.m4582i()) {
                if (c.m4582i()) {
                    c.m4583j();
                } else {
                    c.m4585l();
                }
                this.f2066p.m4904a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f2067q) {
                int b = this.f2066p.m4908b(view);
                if (i == -1) {
                    i = this.f2066p.m4907b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f2067q.indexOfChild(view));
                } else if (b != i) {
                    this.f2067q.f224f.m4157c(b, i);
                }
            } else {
                this.f2066p.m4905a(view, i, false);
                c0761i.f2055c = true;
                if (this.f2068r != null && this.f2068r.m4515c()) {
                    this.f2068r.m4513b(view);
                }
            }
            if (c0761i.f2056d) {
                c.f2183a.invalidate();
                c0761i.f2056d = false;
            }
        }

        private static boolean m4089b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }

        public int m4091A() {
            return this.f2067q != null ? this.f2067q.getPaddingRight() : 0;
        }

        public int m4092B() {
            return this.f2067q != null ? this.f2067q.getPaddingBottom() : 0;
        }

        public View m4093C() {
            if (this.f2067q == null) {
                return null;
            }
            View focusedChild = this.f2067q.getFocusedChild();
            return (focusedChild == null || this.f2066p.m4912c(focusedChild)) ? null : focusedChild;
        }

        public int m4094D() {
            return ag.m2547o(this.f2067q);
        }

        public int m4095E() {
            return ag.m2548p(this.f2067q);
        }

        void m4096F() {
            if (this.f2068r != null) {
                this.f2068r.m4509a();
            }
        }

        public void m4097G() {
            this.f2059a = true;
        }

        boolean m4098H() {
            int t = m4204t();
            for (int i = 0; i < t; i++) {
                LayoutParams layoutParams = m4186h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int mo703a(int i, C0793n c0793n, C0798r c0798r) {
            return 0;
        }

        public int mo725a(C0793n c0793n, C0798r c0798r) {
            return (this.f2067q == null || this.f2067q.f234s == null || !mo721e()) ? 1 : this.f2067q.f234s.mo1796a();
        }

        public abstract C0761i mo704a();

        public C0761i mo726a(Context context, AttributeSet attributeSet) {
            return new C0761i(context, attributeSet);
        }

        public C0761i mo727a(LayoutParams layoutParams) {
            return layoutParams instanceof C0761i ? new C0761i((C0761i) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0761i((MarginLayoutParams) layoutParams) : new C0761i(layoutParams);
        }

        public View mo705a(View view, int i, C0793n c0793n, C0798r c0798r) {
            return null;
        }

        void m4105a(int i, int i2) {
            this.f2064f = MeasureSpec.getSize(i);
            this.f2062d = MeasureSpec.getMode(i);
            if (this.f2062d == 0 && !RecyclerView.f193a) {
                this.f2064f = 0;
            }
            this.f2065g = MeasureSpec.getSize(i2);
            this.f2063e = MeasureSpec.getMode(i2);
            if (this.f2063e == 0 && !RecyclerView.f193a) {
                this.f2065g = 0;
            }
        }

        public void m4106a(int i, C0793n c0793n) {
            View h = m4186h(i);
            m4180f(i);
            c0793n.m4472a(h);
        }

        public void mo729a(Rect rect, int i, int i2) {
            m4170d(C0763h.m4079a(i, (rect.width() + m4209y()) + m4091A(), m4094D()), C0763h.m4079a(i2, (rect.height() + m4210z()) + m4092B(), m4095E()));
        }

        public void mo706a(Parcelable parcelable) {
        }

        void m4109a(C0426c c0426c) {
            m4113a(this.f2067q.f220b, this.f2067q.f226h, c0426c);
        }

        public void m4110a(C0778a c0778a, C0778a c0778a2) {
        }

        public void m4111a(C0793n c0793n) {
            for (int t = m4204t() - 1; t >= 0; t--) {
                m4084a(c0793n, t, m4186h(t));
            }
        }

        public void m4112a(C0793n c0793n, C0798r c0798r, int i, int i2) {
            this.f2067q.m315d(i, i2);
        }

        public void m4113a(C0793n c0793n, C0798r c0798r, C0426c c0426c) {
            if (ag.m2527b(this.f2067q, -1) || ag.m2522a(this.f2067q, -1)) {
                c0426c.m2188a(8192);
                c0426c.m2193a(true);
            }
            if (ag.m2527b(this.f2067q, 1) || ag.m2522a(this.f2067q, 1)) {
                c0426c.m2188a(4096);
                c0426c.m2193a(true);
            }
            c0426c.m2192a(C0424j.m2182a(mo725a(c0793n, c0798r), mo739b(c0793n, c0798r), m4177e(c0793n, c0798r), m4165d(c0793n, c0798r)));
        }

        public void mo732a(C0793n c0793n, C0798r c0798r, View view, C0426c c0426c) {
            c0426c.m2197b(C0425k.m2183a(mo721e() ? m4167d(view) : 0, 1, mo719d() ? m4167d(view) : 0, 1, false, false));
        }

        public void m4115a(C0793n c0793n, C0798r c0798r, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            C0450l a = C0413a.m2088a(accessibilityEvent);
            if (this.f2067q != null && a != null) {
                if (!(ag.m2527b(this.f2067q, 1) || ag.m2527b(this.f2067q, -1) || ag.m2522a(this.f2067q, -1) || ag.m2522a(this.f2067q, 1))) {
                    z = false;
                }
                a.m2296a(z);
                if (this.f2067q.f234s != null) {
                    a.m2295a(this.f2067q.f234s.mo1796a());
                }
            }
        }

        public void mo733a(RecyclerView recyclerView) {
        }

        public void mo734a(RecyclerView recyclerView, int i, int i2) {
        }

        public void mo735a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void mo736a(RecyclerView recyclerView, int i, int i2, Object obj) {
            m4161c(recyclerView, i, i2);
        }

        public void mo707a(RecyclerView recyclerView, C0793n c0793n) {
            m4175e(recyclerView);
        }

        public void m4121a(View view) {
            m4122a(view, -1);
        }

        public void m4122a(View view, int i) {
            m4086a(view, i, true);
        }

        public void m4123a(View view, int i, int i2) {
            C0761i c0761i = (C0761i) view.getLayoutParams();
            Rect g = this.f2067q.m322g(view);
            int i3 = (g.left + g.right) + i;
            int i4 = (g.bottom + g.top) + i2;
            i3 = C0763h.m4080a(m4207w(), m4205u(), i3 + (((m4209y() + m4091A()) + c0761i.leftMargin) + c0761i.rightMargin), c0761i.width, mo719d());
            i4 = C0763h.m4080a(m4208x(), m4206v(), i4 + (((m4210z() + m4092B()) + c0761i.topMargin) + c0761i.bottomMargin), c0761i.height, mo721e());
            if (m4153b(view, i3, i4, c0761i)) {
                view.measure(i3, i4);
            }
        }

        public void m4124a(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((C0761i) view.getLayoutParams()).f2054b;
            view.layout(rect.left + i, rect.top + i2, i3 - rect.right, i4 - rect.bottom);
        }

        public void m4125a(View view, int i, C0761i c0761i) {
            C0801u c = RecyclerView.m251c(view);
            if (c.m4590q()) {
                this.f2067q.f223e.m5296e(c);
            } else {
                this.f2067q.f223e.m5297f(c);
            }
            this.f2066p.m4904a(view, i, c0761i, c.m4590q());
        }

        public void m4126a(View view, Rect rect) {
            if (this.f2067q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.f2067q.m322g(view));
            }
        }

        void m4127a(View view, C0426c c0426c) {
            C0801u c = RecyclerView.m251c(view);
            if (c != null && !c.m4590q() && !this.f2066p.m4912c(c.f2183a)) {
                mo732a(this.f2067q.f220b, this.f2067q.f226h, view, c0426c);
            }
        }

        public void m4128a(View view, C0793n c0793n) {
            m4162c(view);
            c0793n.m4472a(view);
        }

        public void mo708a(AccessibilityEvent accessibilityEvent) {
            m4115a(this.f2067q.f220b, this.f2067q.f226h, accessibilityEvent);
        }

        public void mo709a(String str) {
            if (this.f2067q != null) {
                this.f2067q.m301a(str);
            }
        }

        boolean m4131a(int i, Bundle bundle) {
            return m4133a(this.f2067q.f220b, this.f2067q.f226h, i, bundle);
        }

        public boolean mo738a(C0761i c0761i) {
            return c0761i != null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean m4133a(android.support.v7.widget.RecyclerView.C0793n r7, android.support.v7.widget.RecyclerView.C0798r r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.f2067q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.f2067q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.f2067q;
            r0 = android.support.v4.view.ag.m2527b(r0, r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.m4208x();
            r3 = r6.m4210z();
            r0 = r0 - r3;
            r3 = r6.m4092B();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.f2067q;
            r3 = android.support.v4.view.ag.m2522a(r3, r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.m4207w();
            r4 = r6.m4209y();
            r3 = r3 - r4;
            r4 = r6.m4091A();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.f2067q;
            r0 = android.support.v4.view.ag.m2527b(r0, r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.m4208x();
            r3 = r6.m4210z();
            r0 = r0 - r3;
            r3 = r6.m4092B();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.f2067q;
            r3 = android.support.v4.view.ag.m2522a(r3, r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.m4207w();
            r4 = r6.m4209y();
            r3 = r3 - r4;
            r4 = r6.m4091A();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.h.a(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$r, int, android.os.Bundle):boolean");
        }

        public boolean m4134a(C0793n c0793n, C0798r c0798r, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean m4135a(RecyclerView recyclerView, C0798r c0798r, View view, View view2) {
            return m4137a(recyclerView, view, view2);
        }

        public boolean m4136a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int y = m4209y();
            int z2 = m4210z();
            int w = m4207w() - m4091A();
            int x = m4208x() - m4092B();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - y);
            int min2 = Math.min(0, top - z2);
            int max = Math.max(0, width - w);
            x = Math.max(0, height - x);
            if (m4202r() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - w);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - y, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - z2, x);
            if (min == 0 && max == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(min, max);
            } else {
                recyclerView.m298a(min, max);
            }
            return true;
        }

        @Deprecated
        public boolean m4137a(RecyclerView recyclerView, View view, View view2) {
            return m4201q() || recyclerView.m328j();
        }

        public boolean m4138a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        boolean m4139a(View view, int i, int i2, C0761i c0761i) {
            return (this.f2061c && C0763h.m4089b(view.getMeasuredWidth(), i, c0761i.width) && C0763h.m4089b(view.getMeasuredHeight(), i2, c0761i.height)) ? false : true;
        }

        boolean m4140a(View view, int i, Bundle bundle) {
            return m4134a(this.f2067q.f220b, this.f2067q.f226h, view, i, bundle);
        }

        public boolean m4141a(Runnable runnable) {
            return this.f2067q != null ? this.f2067q.removeCallbacks(runnable) : false;
        }

        public int mo710b(int i, C0793n c0793n, C0798r c0798r) {
            return 0;
        }

        public int mo739b(C0793n c0793n, C0798r c0798r) {
            return (this.f2067q == null || this.f2067q.f234s == null || !mo719d()) ? 1 : this.f2067q.f234s.mo1796a();
        }

        public int mo711b(C0798r c0798r) {
            return 0;
        }

        void m4145b(int i, int i2) {
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int t = m4204t();
            if (t == 0) {
                this.f2067q.m315d(i, i2);
                return;
            }
            int i5 = 0;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MAX_VALUE;
            while (i5 < t) {
                View h = m4186h(i5);
                C0761i c0761i = (C0761i) h.getLayoutParams();
                int h2 = m4185h(h) - c0761i.leftMargin;
                int j = c0761i.rightMargin + m4189j(h);
                int i8 = m4187i(h) - c0761i.topMargin;
                int k = c0761i.bottomMargin + m4191k(h);
                if (h2 >= i7) {
                    h2 = i7;
                }
                if (j <= i6) {
                    j = i6;
                }
                if (i8 >= i3) {
                    i8 = i3;
                }
                if (k <= i4) {
                    k = i4;
                }
                i5++;
                i6 = j;
                i3 = i8;
                i7 = h2;
                i4 = k;
            }
            this.f2067q.f233r.set(i7, i3, i6, i4);
            mo729a(this.f2067q.f233r, i, i2);
        }

        void m4146b(C0793n c0793n) {
            int d = c0793n.m4485d();
            for (int i = d - 1; i >= 0; i--) {
                View e = c0793n.m4488e(i);
                C0801u c = RecyclerView.m251c(e);
                if (!c.m4576c()) {
                    c.m4572a(false);
                    if (c.m4591r()) {
                        this.f2067q.removeDetachedView(e, false);
                    }
                    if (this.f2067q.f225g != null) {
                        this.f2067q.f225g.mo801c(c);
                    }
                    c.m4572a(true);
                    c0793n.m4479b(e);
                }
            }
            c0793n.m4489e();
            if (d > 0) {
                this.f2067q.invalidate();
            }
        }

        void m4147b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.f2067q = null;
                this.f2066p = null;
                this.f2064f = 0;
                this.f2065g = 0;
            } else {
                this.f2067q = recyclerView;
                this.f2066p = recyclerView.f222d;
                this.f2064f = recyclerView.getWidth();
                this.f2065g = recyclerView.getHeight();
            }
            this.f2062d = 1073741824;
            this.f2063e = 1073741824;
        }

        public void mo740b(RecyclerView recyclerView, int i, int i2) {
        }

        void m4149b(RecyclerView recyclerView, C0793n c0793n) {
            this.f2069s = false;
            mo707a(recyclerView, c0793n);
        }

        public void m4150b(View view) {
            m4151b(view, -1);
        }

        public void m4151b(View view, int i) {
            m4086a(view, i, false);
        }

        public boolean mo712b() {
            return false;
        }

        boolean m4153b(View view, int i, int i2, C0761i c0761i) {
            return (!view.isLayoutRequested() && this.f2061c && C0763h.m4089b(view.getWidth(), i, c0761i.width) && C0763h.m4089b(view.getHeight(), i2, c0761i.height)) ? false : true;
        }

        public int mo713c(C0798r c0798r) {
            return 0;
        }

        public Parcelable mo714c() {
            return null;
        }

        public View mo715c(int i) {
            int t = m4204t();
            for (int i2 = 0; i2 < t; i2++) {
                View h = m4186h(i2);
                C0801u c = RecyclerView.m251c(h);
                if (c != null && c.m4577d() == i && !c.m4576c() && (this.f2067q.f226h.m4536a() || !c.m4590q())) {
                    return h;
                }
            }
            return null;
        }

        public void m4157c(int i, int i2) {
            View h = m4186h(i);
            if (h == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i);
            }
            m4184g(i);
            m4163c(h, i2);
        }

        public void m4158c(C0793n c0793n) {
            for (int t = m4204t() - 1; t >= 0; t--) {
                if (!RecyclerView.m251c(m4186h(t)).m4576c()) {
                    m4106a(t, c0793n);
                }
            }
        }

        public void mo716c(C0793n c0793n, C0798r c0798r) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        void m4160c(RecyclerView recyclerView) {
            this.f2069s = true;
            m4171d(recyclerView);
        }

        public void m4161c(RecyclerView recyclerView, int i, int i2) {
        }

        public void m4162c(View view) {
            this.f2066p.m4903a(view);
        }

        public void m4163c(View view, int i) {
            m4125a(view, i, (C0761i) view.getLayoutParams());
        }

        public void m4164c(boolean z) {
            this.f2060b = z;
        }

        public int m4165d(C0793n c0793n, C0798r c0798r) {
            return 0;
        }

        public int mo717d(C0798r c0798r) {
            return 0;
        }

        public int m4167d(View view) {
            return ((C0761i) view.getLayoutParams()).m4072e();
        }

        public View m4168d(View view, int i) {
            return null;
        }

        public void mo718d(int i) {
        }

        public void m4170d(int i, int i2) {
            this.f2067q.setMeasuredDimension(i, i2);
        }

        public void m4171d(RecyclerView recyclerView) {
        }

        public boolean mo719d() {
            return false;
        }

        public int mo720e(C0798r c0798r) {
            return 0;
        }

        public View m4174e(View view) {
            if (this.f2067q == null) {
                return null;
            }
            View b = this.f2067q.m305b(view);
            return (b == null || this.f2066p.m4912c(b)) ? null : b;
        }

        @Deprecated
        public void m4175e(RecyclerView recyclerView) {
        }

        public boolean mo721e() {
            return false;
        }

        public boolean m4177e(C0793n c0793n, C0798r c0798r) {
            return false;
        }

        public int mo722f(C0798r c0798r) {
            return 0;
        }

        public int m4179f(View view) {
            Rect rect = ((C0761i) view.getLayoutParams()).f2054b;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public void m4180f(int i) {
            if (m4186h(i) != null) {
                this.f2066p.m4902a(i);
            }
        }

        void m4181f(RecyclerView recyclerView) {
            m4105a(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int mo723g(C0798r c0798r) {
            return 0;
        }

        public int m4183g(View view) {
            Rect rect = ((C0761i) view.getLayoutParams()).f2054b;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void m4184g(int i) {
            m4082a(i, m4186h(i));
        }

        public int m4185h(View view) {
            return view.getLeft() - m4196n(view);
        }

        public View m4186h(int i) {
            return this.f2066p != null ? this.f2066p.m4909b(i) : null;
        }

        public int m4187i(View view) {
            return view.getTop() - m4194l(view);
        }

        public void mo768i(int i) {
            if (this.f2067q != null) {
                this.f2067q.m307b(i);
            }
        }

        public int m4189j(View view) {
            return view.getRight() + m4198o(view);
        }

        public void mo769j(int i) {
            if (this.f2067q != null) {
                this.f2067q.m297a(i);
            }
        }

        public int m4191k(View view) {
            return view.getBottom() + m4195m(view);
        }

        public void mo770k(int i) {
        }

        boolean mo724k() {
            return false;
        }

        public int m4194l(View view) {
            return ((C0761i) view.getLayoutParams()).f2054b.top;
        }

        public int m4195m(View view) {
            return ((C0761i) view.getLayoutParams()).f2054b.bottom;
        }

        public int m4196n(View view) {
            return ((C0761i) view.getLayoutParams()).f2054b.left;
        }

        public void m4197n() {
            if (this.f2067q != null) {
                this.f2067q.requestLayout();
            }
        }

        public int m4198o(View view) {
            return ((C0761i) view.getLayoutParams()).f2054b.right;
        }

        public boolean m4199o() {
            return this.f2069s;
        }

        public boolean m4200p() {
            return this.f2067q != null && this.f2067q.f231p;
        }

        public boolean m4201q() {
            return this.f2068r != null && this.f2068r.m4515c();
        }

        public int m4202r() {
            return ag.m2540h(this.f2067q);
        }

        public int m4203s() {
            return -1;
        }

        public int m4204t() {
            return this.f2066p != null ? this.f2066p.m4907b() : 0;
        }

        public int m4205u() {
            return this.f2062d;
        }

        public int m4206v() {
            return this.f2063e;
        }

        public int m4207w() {
            return this.f2064f;
        }

        public int m4208x() {
            return this.f2065g;
        }

        public int m4209y() {
            return this.f2067q != null ? this.f2067q.getPaddingLeft() : 0;
        }

        public int m4210z() {
            return this.f2067q != null ? this.f2067q.getPaddingTop() : 0;
        }
    }

    class C07681 implements Runnable {
        final /* synthetic */ RecyclerView f2114a;

        C07681(RecyclerView recyclerView) {
            this.f2114a = recyclerView;
        }

        public void run() {
            if (this.f2114a.f241z && !this.f2114a.isLayoutRequested()) {
                if (this.f2114a.f199C) {
                    this.f2114a.f198B = true;
                } else {
                    this.f2114a.m284t();
                }
            }
        }
    }

    class C07692 implements Runnable {
        final /* synthetic */ RecyclerView f2115a;

        C07692(RecyclerView recyclerView) {
            this.f2115a = recyclerView;
        }

        public void run() {
            if (this.f2115a.f225g != null) {
                this.f2115a.f225g.mo793a();
            }
            this.f2115a.ah = false;
        }
    }

    static class C07703 implements Interpolator {
        C07703() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C07724 implements C0771b {
        final /* synthetic */ RecyclerView f2116a;

        C07724(RecyclerView recyclerView) {
            this.f2116a = recyclerView;
        }

        public void mo741a(C0801u c0801u) {
            this.f2116a.f224f.m4128a(c0801u.f2183a, this.f2116a.f220b);
        }

        public void mo742a(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
            this.f2116a.f220b.m4487d(c0801u);
            this.f2116a.m243b(c0801u, c0784c, c0784c2);
        }

        public void mo743b(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
            this.f2116a.m228a(c0801u, c0784c, c0784c2);
        }

        public void mo744c(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
            c0801u.m4572a(false);
            if (this.f2116a.f206J) {
                if (this.f2116a.f225g.mo789a(c0801u, c0801u, c0784c, c0784c2)) {
                    this.f2116a.m214C();
                }
            } else if (this.f2116a.f225g.mo791c(c0801u, c0784c, c0784c2)) {
                this.f2116a.m214C();
            }
        }
    }

    class C07745 implements C0773b {
        final /* synthetic */ RecyclerView f2117a;

        C07745(RecyclerView recyclerView) {
            this.f2117a = recyclerView;
        }

        public int mo745a() {
            return this.f2117a.getChildCount();
        }

        public int mo746a(View view) {
            return this.f2117a.indexOfChild(view);
        }

        public void mo747a(int i) {
            View childAt = this.f2117a.getChildAt(i);
            if (childAt != null) {
                this.f2117a.m268i(childAt);
            }
            this.f2117a.removeViewAt(i);
        }

        public void mo748a(View view, int i) {
            this.f2117a.addView(view, i);
            this.f2117a.m270j(view);
        }

        public void mo749a(View view, int i, LayoutParams layoutParams) {
            C0801u c = RecyclerView.m251c(view);
            if (c != null) {
                if (c.m4591r() || c.m4576c()) {
                    c.m4586m();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + c);
                }
            }
            this.f2117a.attachViewToParent(view, i, layoutParams);
        }

        public C0801u mo750b(View view) {
            return RecyclerView.m251c(view);
        }

        public View mo751b(int i) {
            return this.f2117a.getChildAt(i);
        }

        public void mo752b() {
            int a = mo745a();
            for (int i = 0; i < a; i++) {
                this.f2117a.m268i(mo751b(i));
            }
            this.f2117a.removeAllViews();
        }

        public void mo753c(int i) {
            View b = mo751b(i);
            if (b != null) {
                C0801u c = RecyclerView.m251c(b);
                if (c != null) {
                    if (!c.m4591r() || c.m4576c()) {
                        c.m4575b(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + c);
                    }
                }
            }
            this.f2117a.detachViewFromParent(i);
        }

        public void mo754c(View view) {
            C0801u c = RecyclerView.m251c(view);
            if (c != null) {
                c.m4565z();
            }
        }

        public void mo755d(View view) {
            C0801u c = RecyclerView.m251c(view);
            if (c != null) {
                c.m4553A();
            }
        }
    }

    class C07766 implements C0775a {
        final /* synthetic */ RecyclerView f2118a;

        C07766(RecyclerView recyclerView) {
            this.f2118a = recyclerView;
        }

        public C0801u mo756a(int i) {
            C0801u a = this.f2118a.m294a(i, true);
            return (a == null || this.f2118a.f222d.m4912c(a.f2183a)) ? null : a;
        }

        public void mo757a(int i, int i2) {
            this.f2118a.m300a(i, i2, true);
            this.f2118a.f227i = true;
            C0798r.m4519a(this.f2118a.f226h, i2);
        }

        public void mo758a(int i, int i2, Object obj) {
            this.f2118a.m299a(i, i2, obj);
            this.f2118a.f228j = true;
        }

        public void mo759a(C0881b c0881b) {
            m4377c(c0881b);
        }

        public void mo760b(int i, int i2) {
            this.f2118a.m300a(i, i2, false);
            this.f2118a.f227i = true;
        }

        public void mo761b(C0881b c0881b) {
            m4377c(c0881b);
        }

        public void mo762c(int i, int i2) {
            this.f2118a.m320f(i, i2);
            this.f2118a.f227i = true;
        }

        void m4377c(C0881b c0881b) {
            switch (c0881b.f2684a) {
                case 1:
                    this.f2118a.f224f.mo734a(this.f2118a, c0881b.f2685b, c0881b.f2687d);
                    return;
                case 2:
                    this.f2118a.f224f.mo740b(this.f2118a, c0881b.f2685b, c0881b.f2687d);
                    return;
                case 4:
                    this.f2118a.f224f.mo736a(this.f2118a, c0881b.f2685b, c0881b.f2687d, c0881b.f2686c);
                    return;
                case 8:
                    this.f2118a.f224f.mo735a(this.f2118a, c0881b.f2685b, c0881b.f2687d, 1);
                    return;
                default:
                    return;
            }
        }

        public void mo763d(int i, int i2) {
            this.f2118a.m317e(i, i2);
            this.f2118a.f227i = true;
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C07771();
        Parcelable f2119a;

        static class C07771 implements Creator<SavedState> {
            C07771() {
            }

            public SavedState m4379a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4380a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4379a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4380a(i);
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2119a = parcel.readParcelable(C0763h.class.getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void m4381a(SavedState savedState) {
            this.f2119a = savedState.f2119a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f2119a, 0);
        }
    }

    public static abstract class C0778a<VH extends C0801u> {
        private final C0779b f2120a = new C0779b();
        private boolean f2121b = false;

        public abstract int mo1796a();

        public int m4384a(int i) {
            return 0;
        }

        public abstract VH mo1797a(ViewGroup viewGroup, int i);

        public final void m4386a(int i, int i2) {
            this.f2120a.m4404a(i, i2);
        }

        public void m4387a(C0780c c0780c) {
            this.f2120a.registerObserver(c0780c);
        }

        public void m4388a(VH vh) {
        }

        public abstract void mo1798a(VH vh, int i);

        public void m4390a(VH vh, int i, List<Object> list) {
            mo1798a((C0801u) vh, i);
        }

        public void m4391a(RecyclerView recyclerView) {
        }

        public long m4392b(int i) {
            return -1;
        }

        public final VH m4393b(ViewGroup viewGroup, int i) {
            C0344g.m1832a("RV CreateView");
            VH a = mo1797a(viewGroup, i);
            a.f2187e = i;
            C0344g.m1831a();
            return a;
        }

        public void m4394b(C0780c c0780c) {
            this.f2120a.unregisterObserver(c0780c);
        }

        public final void m4395b(VH vh, int i) {
            vh.f2184b = i;
            if (m4397b()) {
                vh.f2186d = m4392b(i);
            }
            vh.m4567a(1, 519);
            C0344g.m1832a("RV OnBindView");
            m4390a(vh, i, vh.m4594u());
            vh.m4593t();
            C0344g.m1831a();
        }

        public void m4396b(RecyclerView recyclerView) {
        }

        public final boolean m4397b() {
            return this.f2121b;
        }

        public boolean m4398b(VH vh) {
            return false;
        }

        public final void m4399c() {
            this.f2120a.m4403a();
        }

        public final void m4400c(int i) {
            this.f2120a.m4406b(i, 1);
        }

        public void m4401c(VH vh) {
        }

        public void m4402d(VH vh) {
        }
    }

    static class C0779b extends Observable<C0780c> {
        C0779b() {
        }

        public void m4403a() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0780c) this.mObservers.get(size)).mo765a();
            }
        }

        public void m4404a(int i, int i2) {
            m4405a(i, i2, null);
        }

        public void m4405a(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0780c) this.mObservers.get(size)).mo766a(i, i2, obj);
            }
        }

        public void m4406b(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((C0780c) this.mObservers.get(size)).mo767b(i, i2);
            }
        }
    }

    public static abstract class C0780c {
        public void mo765a() {
        }

        public void m4408a(int i, int i2) {
        }

        public void mo766a(int i, int i2, Object obj) {
            m4408a(i, i2);
        }

        public void mo767b(int i, int i2) {
        }
    }

    public interface C0781d {
        int m4411a(int i, int i2);
    }

    public static abstract class C0785e {
        private C0783b f2126a = null;
        private ArrayList<C0782a> f2127b = new ArrayList();
        private long f2128c = 120;
        private long f2129d = 120;
        private long f2130e = 250;
        private long f2131f = 250;

        public interface C0782a {
            void m4412a();
        }

        interface C0783b {
            void mo764a(C0801u c0801u);
        }

        public static class C0784c {
            public int f2122a;
            public int f2123b;
            public int f2124c;
            public int f2125d;

            public C0784c m4414a(C0801u c0801u) {
                return m4415a(c0801u, 0);
            }

            public C0784c m4415a(C0801u c0801u, int i) {
                View view = c0801u.f2183a;
                this.f2122a = view.getLeft();
                this.f2123b = view.getTop();
                this.f2124c = view.getRight();
                this.f2125d = view.getBottom();
                return this;
            }
        }

        static int m4416d(C0801u c0801u) {
            int f = c0801u.f2194l & 14;
            if (c0801u.m4587n()) {
                return 4;
            }
            if ((f & 4) != 0) {
                return f;
            }
            int f2 = c0801u.m4579f();
            int e = c0801u.m4578e();
            return (f2 == -1 || e == -1 || f2 == e) ? f : f | 2048;
        }

        public C0784c m4417a(C0798r c0798r, C0801u c0801u) {
            return m4437i().m4414a(c0801u);
        }

        public C0784c m4418a(C0798r c0798r, C0801u c0801u, int i, List<Object> list) {
            return m4437i().m4414a(c0801u);
        }

        public abstract void mo793a();

        void m4420a(C0783b c0783b) {
            this.f2126a = c0783b;
        }

        public abstract boolean mo788a(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        public abstract boolean mo789a(C0801u c0801u, C0801u c0801u2, C0784c c0784c, C0784c c0784c2);

        public boolean mo797a(C0801u c0801u, List<Object> list) {
            return mo792g(c0801u);
        }

        public abstract boolean mo798b();

        public abstract boolean mo790b(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        public abstract void mo800c();

        public abstract void mo801c(C0801u c0801u);

        public abstract boolean mo791c(C0801u c0801u, C0784c c0784c, C0784c c0784c2);

        public long m4429d() {
            return this.f2130e;
        }

        public long m4430e() {
            return this.f2128c;
        }

        public final void m4431e(C0801u c0801u) {
            m4433f(c0801u);
            if (this.f2126a != null) {
                this.f2126a.mo764a(c0801u);
            }
        }

        public long m4432f() {
            return this.f2129d;
        }

        public void m4433f(C0801u c0801u) {
        }

        public long m4434g() {
            return this.f2131f;
        }

        public boolean mo792g(C0801u c0801u) {
            return true;
        }

        public final void m4436h() {
            int size = this.f2127b.size();
            for (int i = 0; i < size; i++) {
                ((C0782a) this.f2127b.get(i)).m4412a();
            }
            this.f2127b.clear();
        }

        public C0784c m4437i() {
            return new C0784c();
        }
    }

    private class C0786f implements C0783b {
        final /* synthetic */ RecyclerView f2132a;

        private C0786f(RecyclerView recyclerView) {
            this.f2132a = recyclerView;
        }

        public void mo764a(C0801u c0801u) {
            c0801u.m4572a(true);
            if (c0801u.f2189g != null && c0801u.f2190h == null) {
                c0801u.f2189g = null;
            }
            c0801u.f2190h = null;
            if (!c0801u.m4554B() && !this.f2132a.m265h(c0801u.f2183a) && c0801u.m4591r()) {
                this.f2132a.removeDetachedView(c0801u.f2183a, false);
            }
        }
    }

    public static abstract class C0787g {
        @Deprecated
        public void m4439a(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m4440a(Canvas canvas, RecyclerView recyclerView, C0798r c0798r) {
            m4439a(canvas, recyclerView);
        }

        @Deprecated
        public void m4441a(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void m4442a(Rect rect, View view, RecyclerView recyclerView, C0798r c0798r) {
            m4441a(rect, ((C0761i) view.getLayoutParams()).m4072e(), recyclerView);
        }

        @Deprecated
        public void m4443b(Canvas canvas, RecyclerView recyclerView) {
        }

        public void m4444b(Canvas canvas, RecyclerView recyclerView, C0798r c0798r) {
            m4443b(canvas, recyclerView);
        }
    }

    public interface C0789j {
        void m4445a(View view);

        void m4446b(View view);
    }

    public interface C0790k {
        void m4447a(boolean z);

        boolean m4448a(RecyclerView recyclerView, MotionEvent motionEvent);

        void m4449b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class C0791l {
        public void m4450a(RecyclerView recyclerView, int i) {
        }

        public void m4451a(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class C0792m {
        private SparseArray<ArrayList<C0801u>> f2137a = new SparseArray();
        private SparseIntArray f2138b = new SparseIntArray();
        private int f2139c = 0;

        private ArrayList<C0801u> m4452b(int i) {
            ArrayList<C0801u> arrayList = (ArrayList) this.f2137a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f2137a.put(i, arrayList);
                if (this.f2138b.indexOfKey(i) < 0) {
                    this.f2138b.put(i, 5);
                }
            }
            return arrayList;
        }

        public C0801u m4453a(int i) {
            ArrayList arrayList = (ArrayList) this.f2137a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            C0801u c0801u = (C0801u) arrayList.get(size);
            arrayList.remove(size);
            return c0801u;
        }

        public void m4454a() {
            this.f2137a.clear();
        }

        void m4455a(C0778a c0778a) {
            this.f2139c++;
        }

        void m4456a(C0778a c0778a, C0778a c0778a2, boolean z) {
            if (c0778a != null) {
                m4458b();
            }
            if (!z && this.f2139c == 0) {
                m4454a();
            }
            if (c0778a2 != null) {
                m4455a(c0778a2);
            }
        }

        public void m4457a(C0801u c0801u) {
            int h = c0801u.m4581h();
            ArrayList b = m4452b(h);
            if (this.f2138b.get(h) > b.size()) {
                c0801u.m4595v();
                b.add(c0801u);
            }
        }

        void m4458b() {
            this.f2139c--;
        }
    }

    public final class C0793n {
        final ArrayList<C0801u> f2140a = new ArrayList();
        final ArrayList<C0801u> f2141b = new ArrayList();
        final /* synthetic */ RecyclerView f2142c;
        private ArrayList<C0801u> f2143d = null;
        private final List<C0801u> f2144e = Collections.unmodifiableList(this.f2140a);
        private int f2145f = 2;
        private C0792m f2146g;
        private C0799s f2147h;

        public C0793n(RecyclerView recyclerView) {
            this.f2142c = recyclerView;
        }

        private void m4460a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m4460a((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        private void m4461d(View view) {
            if (this.f2142c.m327i()) {
                if (ag.m2535e(view) == 0) {
                    ag.m2529c(view, 1);
                }
                if (!ag.m2526b(view)) {
                    ag.m2517a(view, this.f2142c.ai.m5129b());
                }
            }
        }

        private void m4462f(C0801u c0801u) {
            if (c0801u.f2183a instanceof ViewGroup) {
                m4460a((ViewGroup) c0801u.f2183a, false);
            }
        }

        C0801u m4463a(int i, int i2, boolean z) {
            View a;
            int i3 = 0;
            int size = this.f2140a.size();
            int i4 = 0;
            while (i4 < size) {
                C0801u c0801u = (C0801u) this.f2140a.get(i4);
                if (c0801u.m4584k() || c0801u.m4577d() != i || c0801u.m4587n() || (!this.f2142c.f226h.f2170h && c0801u.m4590q())) {
                    i4++;
                } else if (i2 == -1 || c0801u.m4581h() == i2) {
                    c0801u.m4575b(32);
                    return c0801u;
                } else {
                    Log.e("RecyclerView", "Scrap view for position " + i + " isn't dirty but has" + " wrong view type! (found " + c0801u.m4581h() + " but expected " + i2 + ")");
                    if (!z) {
                        a = this.f2142c.f222d.m4900a(i, i2);
                        if (a != null) {
                            c0801u = RecyclerView.m251c(a);
                            this.f2142c.f222d.m4915e(a);
                            i3 = this.f2142c.f222d.m4908b(a);
                            if (i3 != -1) {
                                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0801u);
                            }
                            this.f2142c.f222d.m4913d(i3);
                            m4484c(a);
                            c0801u.m4575b(8224);
                            return c0801u;
                        }
                    }
                    i4 = this.f2141b.size();
                    while (i3 < i4) {
                        c0801u = (C0801u) this.f2141b.get(i3);
                        if (c0801u.m4587n() || c0801u.m4577d() != i) {
                            i3++;
                        } else if (z) {
                            return c0801u;
                        } else {
                            this.f2141b.remove(i3);
                            return c0801u;
                        }
                    }
                    return null;
                }
            }
            if (z) {
                a = this.f2142c.f222d.m4900a(i, i2);
                if (a != null) {
                    c0801u = RecyclerView.m251c(a);
                    this.f2142c.f222d.m4915e(a);
                    i3 = this.f2142c.f222d.m4908b(a);
                    if (i3 != -1) {
                        this.f2142c.f222d.m4913d(i3);
                        m4484c(a);
                        c0801u.m4575b(8224);
                        return c0801u;
                    }
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + c0801u);
                }
            }
            i4 = this.f2141b.size();
            while (i3 < i4) {
                c0801u = (C0801u) this.f2141b.get(i3);
                if (c0801u.m4587n()) {
                }
                i3++;
            }
            return null;
        }

        C0801u m4464a(long j, int i, boolean z) {
            int size;
            for (size = this.f2140a.size() - 1; size >= 0; size--) {
                C0801u c0801u = (C0801u) this.f2140a.get(size);
                if (c0801u.m4580g() == j && !c0801u.m4584k()) {
                    if (i == c0801u.m4581h()) {
                        c0801u.m4575b(32);
                        if (!c0801u.m4590q() || this.f2142c.f226h.m4536a()) {
                            return c0801u;
                        }
                        c0801u.m4567a(2, 14);
                        return c0801u;
                    } else if (!z) {
                        this.f2140a.remove(size);
                        this.f2142c.removeDetachedView(c0801u.f2183a, false);
                        m4479b(c0801u.f2183a);
                    }
                }
            }
            for (size = this.f2141b.size() - 1; size >= 0; size--) {
                c0801u = (C0801u) this.f2141b.get(size);
                if (c0801u.m4580g() == j) {
                    if (i == c0801u.m4581h()) {
                        if (z) {
                            return c0801u;
                        }
                        this.f2141b.remove(size);
                        return c0801u;
                    } else if (!z) {
                        m4486d(size);
                    }
                }
            }
            return null;
        }

        View m4465a(int i, boolean z) {
            boolean z2 = true;
            if (i < 0 || i >= this.f2142c.f226h.m4540e()) {
                throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + this.f2142c.f226h.m4540e());
            }
            C0801u f;
            boolean z3;
            C0801u c0801u;
            boolean z4;
            int b;
            boolean z5;
            int b2;
            LayoutParams layoutParams;
            C0761i c0761i;
            if (this.f2142c.f226h.m4536a()) {
                f = m4492f(i);
                C0801u c0801u2 = f;
                z3 = f != null;
                c0801u = c0801u2;
            } else {
                c0801u = null;
                z3 = false;
            }
            if (c0801u == null) {
                c0801u = m4463a(i, -1, z);
                if (c0801u != null) {
                    if (m4473a(c0801u)) {
                        z4 = true;
                    } else {
                        if (!z) {
                            c0801u.m4575b(4);
                            if (c0801u.m4582i()) {
                                this.f2142c.removeDetachedView(c0801u.f2183a, false);
                                c0801u.m4583j();
                            } else if (c0801u.m4584k()) {
                                c0801u.m4585l();
                            }
                            m4478b(c0801u);
                        }
                        c0801u = null;
                        z4 = z3;
                    }
                    if (c0801u == null) {
                        b = this.f2142c.f221c.m5387b(i);
                        if (b >= 0 || b >= this.f2142c.f234s.mo1796a()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2142c.f226h.m4540e());
                        }
                        int a = this.f2142c.f234s.m4384a(b);
                        if (this.f2142c.f234s.m4397b()) {
                            c0801u = m4464a(this.f2142c.f234s.m4392b(b), a, z);
                            if (c0801u != null) {
                                c0801u.f2184b = b;
                                z4 = true;
                            }
                        }
                        if (c0801u == null && this.f2147h != null) {
                            View a2 = this.f2147h.m4541a(this, i, a);
                            if (a2 != null) {
                                c0801u = this.f2142c.m295a(a2);
                                if (c0801u == null) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                                } else if (c0801u.m4576c()) {
                                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                                }
                            }
                        }
                        if (c0801u == null) {
                            c0801u = m4491f().m4453a(a);
                            if (c0801u != null) {
                                c0801u.m4595v();
                                if (RecyclerView.f195l) {
                                    m4462f(c0801u);
                                }
                            }
                        }
                        if (c0801u == null) {
                            f = this.f2142c.f234s.m4393b(this.f2142c, a);
                            z5 = z4;
                            if (z5 && !this.f2142c.f226h.m4536a() && f.m4573a(8192)) {
                                f.m4567a(0, 8192);
                                if (this.f2142c.f226h.f2171i) {
                                    this.f2142c.m227a(f, this.f2142c.f225g.m4418a(this.f2142c.f226h, f, C0785e.m4416d(f) | 4096, f.m4594u()));
                                }
                            }
                            int i2;
                            if (!this.f2142c.f226h.m4536a() && f.m4589p()) {
                                f.f2188f = i;
                                i2 = 0;
                            } else if (f.m4589p() || f.m4588o() || f.m4587n()) {
                                b2 = this.f2142c.f221c.m5387b(i);
                                f.f2193k = this.f2142c;
                                this.f2142c.f234s.m4395b(f, b2);
                                m4461d(f.f2183a);
                                if (this.f2142c.f226h.m4536a()) {
                                    f.f2188f = i;
                                }
                                z4 = true;
                            } else {
                                i2 = 0;
                            }
                            layoutParams = f.f2183a.getLayoutParams();
                            if (layoutParams != null) {
                                c0761i = (C0761i) this.f2142c.generateDefaultLayoutParams();
                                f.f2183a.setLayoutParams(c0761i);
                            } else if (this.f2142c.checkLayoutParams(layoutParams)) {
                                c0761i = (C0761i) layoutParams;
                            } else {
                                c0761i = (C0761i) this.f2142c.generateLayoutParams(layoutParams);
                                f.f2183a.setLayoutParams(c0761i);
                            }
                            c0761i.f2053a = f;
                            if (!z5 || r3 == 0) {
                                z2 = false;
                            }
                            c0761i.f2056d = z2;
                            return f.f2183a;
                        }
                    }
                    f = c0801u;
                    z5 = z4;
                    f.m4567a(0, 8192);
                    if (this.f2142c.f226h.f2171i) {
                        this.f2142c.m227a(f, this.f2142c.f225g.m4418a(this.f2142c.f226h, f, C0785e.m4416d(f) | 4096, f.m4594u()));
                    }
                    if (!this.f2142c.f226h.m4536a()) {
                    }
                    if (f.m4589p()) {
                    }
                    b2 = this.f2142c.f221c.m5387b(i);
                    f.f2193k = this.f2142c;
                    this.f2142c.f234s.m4395b(f, b2);
                    m4461d(f.f2183a);
                    if (this.f2142c.f226h.m4536a()) {
                        f.f2188f = i;
                    }
                    z4 = true;
                    layoutParams = f.f2183a.getLayoutParams();
                    if (layoutParams != null) {
                        c0761i = (C0761i) this.f2142c.generateDefaultLayoutParams();
                        f.f2183a.setLayoutParams(c0761i);
                    } else if (this.f2142c.checkLayoutParams(layoutParams)) {
                        c0761i = (C0761i) layoutParams;
                    } else {
                        c0761i = (C0761i) this.f2142c.generateLayoutParams(layoutParams);
                        f.f2183a.setLayoutParams(c0761i);
                    }
                    c0761i.f2053a = f;
                    z2 = false;
                    c0761i.f2056d = z2;
                    return f.f2183a;
                }
            }
            z4 = z3;
            if (c0801u == null) {
                b = this.f2142c.f221c.m5387b(i);
                if (b >= 0) {
                }
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + b + ")." + "state:" + this.f2142c.f226h.m4540e());
            }
            f = c0801u;
            z5 = z4;
            f.m4567a(0, 8192);
            if (this.f2142c.f226h.f2171i) {
                this.f2142c.m227a(f, this.f2142c.f225g.m4418a(this.f2142c.f226h, f, C0785e.m4416d(f) | 4096, f.m4594u()));
            }
            if (!this.f2142c.f226h.m4536a()) {
            }
            if (f.m4589p()) {
            }
            b2 = this.f2142c.f221c.m5387b(i);
            f.f2193k = this.f2142c;
            this.f2142c.f234s.m4395b(f, b2);
            m4461d(f.f2183a);
            if (this.f2142c.f226h.m4536a()) {
                f.f2188f = i;
            }
            z4 = true;
            layoutParams = f.f2183a.getLayoutParams();
            if (layoutParams != null) {
                c0761i = (C0761i) this.f2142c.generateDefaultLayoutParams();
                f.f2183a.setLayoutParams(c0761i);
            } else if (this.f2142c.checkLayoutParams(layoutParams)) {
                c0761i = (C0761i) this.f2142c.generateLayoutParams(layoutParams);
                f.f2183a.setLayoutParams(c0761i);
            } else {
                c0761i = (C0761i) layoutParams;
            }
            c0761i.f2053a = f;
            z2 = false;
            c0761i.f2056d = z2;
            return f.f2183a;
        }

        public void m4466a() {
            this.f2140a.clear();
            m4481c();
        }

        public void m4467a(int i) {
            this.f2145f = i;
            for (int size = this.f2141b.size() - 1; size >= 0 && this.f2141b.size() > i; size--) {
                m4486d(size);
            }
        }

        void m4468a(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i4 = i2;
                i5 = i;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.f2141b.size();
            for (int i6 = 0; i6 < size; i6++) {
                C0801u c0801u = (C0801u) this.f2141b.get(i6);
                if (c0801u != null && c0801u.f2184b >= r3 && c0801u.f2184b <= r2) {
                    if (c0801u.f2184b == i) {
                        c0801u.m4569a(i2 - i, false);
                    } else {
                        c0801u.m4569a(i3, false);
                    }
                }
            }
        }

        void m4469a(C0778a c0778a, C0778a c0778a2, boolean z) {
            m4466a();
            m4491f().m4456a(c0778a, c0778a2, z);
        }

        void m4470a(C0792m c0792m) {
            if (this.f2146g != null) {
                this.f2146g.m4458b();
            }
            this.f2146g = c0792m;
            if (c0792m != null) {
                this.f2146g.m4455a(this.f2142c.getAdapter());
            }
        }

        void m4471a(C0799s c0799s) {
            this.f2147h = c0799s;
        }

        public void m4472a(View view) {
            C0801u c = RecyclerView.m251c(view);
            if (c.m4591r()) {
                this.f2142c.removeDetachedView(view, false);
            }
            if (c.m4582i()) {
                c.m4583j();
            } else if (c.m4584k()) {
                c.m4585l();
            }
            m4478b(c);
        }

        boolean m4473a(C0801u c0801u) {
            if (c0801u.m4590q()) {
                return this.f2142c.f226h.m4536a();
            }
            if (c0801u.f2184b >= 0 && c0801u.f2184b < this.f2142c.f234s.mo1796a()) {
                return (this.f2142c.f226h.m4536a() || this.f2142c.f234s.m4384a(c0801u.f2184b) == c0801u.m4581h()) ? !this.f2142c.f234s.m4397b() || c0801u.m4580g() == this.f2142c.f234s.m4392b(c0801u.f2184b) : false;
            } else {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + c0801u);
            }
        }

        public int m4474b(int i) {
            if (i >= 0 && i < this.f2142c.f226h.m4540e()) {
                return !this.f2142c.f226h.m4536a() ? i : this.f2142c.f221c.m5387b(i);
            } else {
                throw new IndexOutOfBoundsException("invalid position " + i + ". State " + "item count is " + this.f2142c.f226h.m4540e());
            }
        }

        public List<C0801u> m4475b() {
            return this.f2144e;
        }

        void m4476b(int i, int i2) {
            int size = this.f2141b.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0801u c0801u = (C0801u) this.f2141b.get(i3);
                if (c0801u != null && c0801u.f2184b >= i) {
                    c0801u.m4569a(i2, true);
                }
            }
        }

        void m4477b(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f2141b.size() - 1; size >= 0; size--) {
                C0801u c0801u = (C0801u) this.f2141b.get(size);
                if (c0801u != null) {
                    if (c0801u.f2184b >= i3) {
                        c0801u.m4569a(-i2, z);
                    } else if (c0801u.f2184b >= i) {
                        c0801u.m4575b(8);
                        m4486d(size);
                    }
                }
            }
        }

        void m4478b(C0801u c0801u) {
            boolean z = true;
            int i = 0;
            if (c0801u.m4582i() || c0801u.f2183a.getParent() != null) {
                StringBuilder append = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(c0801u.m4582i()).append(" isAttached:");
                if (c0801u.f2183a.getParent() == null) {
                    z = false;
                }
                throw new IllegalArgumentException(append.append(z).toString());
            } else if (c0801u.m4591r()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + c0801u);
            } else if (c0801u.m4576c()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            } else {
                int i2;
                boolean c = c0801u.m4555C();
                boolean z2 = this.f2142c.f234s != null && c && this.f2142c.f234s.m4398b(c0801u);
                if (z2 || c0801u.m4596w()) {
                    if (!c0801u.m4573a(14)) {
                        int size = this.f2141b.size();
                        if (size == this.f2145f && size > 0) {
                            m4486d(0);
                        }
                        if (size < this.f2145f) {
                            this.f2141b.add(c0801u);
                            z2 = true;
                            if (z2) {
                                m4483c(c0801u);
                                i = 1;
                                i2 = z2;
                            } else {
                                z = z2;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        z = z2;
                    } else {
                        m4483c(c0801u);
                        i = 1;
                        i2 = z2;
                    }
                } else {
                    i2 = 0;
                }
                this.f2142c.f223e.m5298g(c0801u);
                if (i2 == 0 && r1 == 0 && c) {
                    c0801u.f2193k = null;
                }
            }
        }

        void m4479b(View view) {
            C0801u c = RecyclerView.m251c(view);
            c.f2196o = null;
            c.f2197p = false;
            c.m4585l();
            m4478b(c);
        }

        public View m4480c(int i) {
            return m4465a(i, false);
        }

        void m4481c() {
            for (int size = this.f2141b.size() - 1; size >= 0; size--) {
                m4486d(size);
            }
            this.f2141b.clear();
        }

        void m4482c(int i, int i2) {
            int i3 = i + i2;
            for (int size = this.f2141b.size() - 1; size >= 0; size--) {
                C0801u c0801u = (C0801u) this.f2141b.get(size);
                if (c0801u != null) {
                    int d = c0801u.m4577d();
                    if (d >= i && d < i3) {
                        c0801u.m4575b(2);
                        m4486d(size);
                    }
                }
            }
        }

        void m4483c(C0801u c0801u) {
            ag.m2517a(c0801u.f2183a, null);
            m4490e(c0801u);
            c0801u.f2193k = null;
            m4491f().m4457a(c0801u);
        }

        void m4484c(View view) {
            C0801u c = RecyclerView.m251c(view);
            if (!c.m4573a(12) && c.m4597x() && !this.f2142c.m255c(c)) {
                if (this.f2143d == null) {
                    this.f2143d = new ArrayList();
                }
                c.m4570a(this, true);
                this.f2143d.add(c);
            } else if (!c.m4587n() || c.m4590q() || this.f2142c.f234s.m4397b()) {
                c.m4570a(this, false);
                this.f2140a.add(c);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
        }

        int m4485d() {
            return this.f2140a.size();
        }

        void m4486d(int i) {
            m4483c((C0801u) this.f2141b.get(i));
            this.f2141b.remove(i);
        }

        void m4487d(C0801u c0801u) {
            if (c0801u.f2197p) {
                this.f2143d.remove(c0801u);
            } else {
                this.f2140a.remove(c0801u);
            }
            c0801u.f2196o = null;
            c0801u.f2197p = false;
            c0801u.m4585l();
        }

        View m4488e(int i) {
            return ((C0801u) this.f2140a.get(i)).f2183a;
        }

        void m4489e() {
            this.f2140a.clear();
            if (this.f2143d != null) {
                this.f2143d.clear();
            }
        }

        void m4490e(C0801u c0801u) {
            if (this.f2142c.f235t != null) {
                this.f2142c.f235t.m4497a(c0801u);
            }
            if (this.f2142c.f234s != null) {
                this.f2142c.f234s.m4388a(c0801u);
            }
            if (this.f2142c.f226h != null) {
                this.f2142c.f223e.m5298g(c0801u);
            }
        }

        C0792m m4491f() {
            if (this.f2146g == null) {
                this.f2146g = new C0792m();
            }
            return this.f2146g;
        }

        C0801u m4492f(int i) {
            int i2 = 0;
            if (this.f2143d != null) {
                int size = this.f2143d.size();
                if (size != 0) {
                    C0801u c0801u;
                    int i3 = 0;
                    while (i3 < size) {
                        c0801u = (C0801u) this.f2143d.get(i3);
                        if (c0801u.m4584k() || c0801u.m4577d() != i) {
                            i3++;
                        } else {
                            c0801u.m4575b(32);
                            return c0801u;
                        }
                    }
                    if (this.f2142c.f234s.m4397b()) {
                        int b = this.f2142c.f221c.m5387b(i);
                        if (b > 0 && b < this.f2142c.f234s.mo1796a()) {
                            long b2 = this.f2142c.f234s.m4392b(b);
                            while (i2 < size) {
                                c0801u = (C0801u) this.f2143d.get(i2);
                                if (c0801u.m4584k() || c0801u.m4580g() != b2) {
                                    i2++;
                                } else {
                                    c0801u.m4575b(32);
                                    return c0801u;
                                }
                            }
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        void m4493g() {
            int size = this.f2141b.size();
            for (int i = 0; i < size; i++) {
                C0801u c0801u = (C0801u) this.f2141b.get(i);
                if (c0801u != null) {
                    c0801u.m4575b(512);
                }
            }
        }

        void m4494h() {
            if (this.f2142c.f234s == null || !this.f2142c.f234s.m4397b()) {
                m4481c();
                return;
            }
            int size = this.f2141b.size();
            for (int i = 0; i < size; i++) {
                C0801u c0801u = (C0801u) this.f2141b.get(i);
                if (c0801u != null) {
                    c0801u.m4575b(6);
                    c0801u.m4571a(null);
                }
            }
        }

        void m4495i() {
            int i;
            int i2 = 0;
            int size = this.f2141b.size();
            for (i = 0; i < size; i++) {
                ((C0801u) this.f2141b.get(i)).m4566a();
            }
            size = this.f2140a.size();
            for (i = 0; i < size; i++) {
                ((C0801u) this.f2140a.get(i)).m4566a();
            }
            if (this.f2143d != null) {
                i = this.f2143d.size();
                while (i2 < i) {
                    ((C0801u) this.f2143d.get(i2)).m4566a();
                    i2++;
                }
            }
        }

        void m4496j() {
            int size = this.f2141b.size();
            for (int i = 0; i < size; i++) {
                C0761i c0761i = (C0761i) ((C0801u) this.f2141b.get(i)).f2183a.getLayoutParams();
                if (c0761i != null) {
                    c0761i.f2055c = true;
                }
            }
        }
    }

    public interface C0794o {
        void m4497a(C0801u c0801u);
    }

    private class C0795p extends C0780c {
        final /* synthetic */ RecyclerView f2148a;

        private C0795p(RecyclerView recyclerView) {
            this.f2148a = recyclerView;
        }

        public void mo765a() {
            this.f2148a.m301a(null);
            if (this.f2148a.f234s.m4397b()) {
                this.f2148a.f226h.f2169g = true;
                this.f2148a.m220I();
            } else {
                this.f2148a.f226h.f2169g = true;
                this.f2148a.m220I();
            }
            if (!this.f2148a.f221c.m5392d()) {
                this.f2148a.requestLayout();
            }
        }

        public void mo766a(int i, int i2, Object obj) {
            this.f2148a.m301a(null);
            if (this.f2148a.f221c.m5386a(i, i2, obj)) {
                m4500b();
            }
        }

        void m4500b() {
            if (this.f2148a.f203G && this.f2148a.f240y && this.f2148a.f239x) {
                ag.m2519a(this.f2148a, this.f2148a.f232q);
                return;
            }
            this.f2148a.f202F = true;
            this.f2148a.requestLayout();
        }

        public void mo767b(int i, int i2) {
            this.f2148a.m301a(null);
            if (this.f2148a.f221c.m5389b(i, i2)) {
                m4500b();
            }
        }
    }

    public static abstract class C0797q {
        private int f2156a;
        private RecyclerView f2157b;
        private C0763h f2158c;
        private boolean f2159d;
        private boolean f2160e;
        private View f2161f;
        private final C0796a f2162g;

        public static class C0796a {
            private int f2149a;
            private int f2150b;
            private int f2151c;
            private int f2152d;
            private Interpolator f2153e;
            private boolean f2154f;
            private int f2155g;

            private void m4503a(RecyclerView recyclerView) {
                if (this.f2152d >= 0) {
                    int i = this.f2152d;
                    this.f2152d = -1;
                    recyclerView.m260e(i);
                    this.f2154f = false;
                } else if (this.f2154f) {
                    m4504b();
                    if (this.f2153e != null) {
                        recyclerView.ad.m4550a(this.f2149a, this.f2150b, this.f2151c, this.f2153e);
                    } else if (this.f2151c == Integer.MIN_VALUE) {
                        recyclerView.ad.m4552b(this.f2149a, this.f2150b);
                    } else {
                        recyclerView.ad.m4548a(this.f2149a, this.f2150b, this.f2151c);
                    }
                    this.f2155g++;
                    if (this.f2155g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2154f = false;
                } else {
                    this.f2155g = 0;
                }
            }

            private void m4504b() {
                if (this.f2153e != null && this.f2151c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f2151c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean m4505a() {
                return this.f2152d >= 0;
            }
        }

        private void m4506a(int i, int i2) {
            RecyclerView recyclerView = this.f2157b;
            if (!this.f2160e || this.f2156a == -1 || recyclerView == null) {
                m4509a();
            }
            this.f2159d = false;
            if (this.f2161f != null) {
                if (m4508a(this.f2161f) == this.f2156a) {
                    m4512a(this.f2161f, recyclerView.f226h, this.f2162g);
                    this.f2162g.m4503a(recyclerView);
                    m4509a();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2161f = null;
                }
            }
            if (this.f2160e) {
                m4511a(i, i2, recyclerView.f226h, this.f2162g);
                boolean a = this.f2162g.m4505a();
                this.f2162g.m4503a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.f2160e) {
                    this.f2159d = true;
                    recyclerView.ad.m4546a();
                    return;
                }
                m4509a();
            }
        }

        public int m4508a(View view) {
            return this.f2157b.m312d(view);
        }

        protected final void m4509a() {
            if (this.f2160e) {
                m4517e();
                this.f2157b.f226h.f2164b = -1;
                this.f2161f = null;
                this.f2156a = -1;
                this.f2159d = false;
                this.f2160e = false;
                this.f2158c.m4085a(this);
                this.f2158c = null;
                this.f2157b = null;
            }
        }

        public void m4510a(int i) {
            this.f2156a = i;
        }

        protected abstract void m4511a(int i, int i2, C0798r c0798r, C0796a c0796a);

        protected abstract void m4512a(View view, C0798r c0798r, C0796a c0796a);

        protected void m4513b(View view) {
            if (m4508a(view) == m4516d()) {
                this.f2161f = view;
            }
        }

        public boolean m4514b() {
            return this.f2159d;
        }

        public boolean m4515c() {
            return this.f2160e;
        }

        public int m4516d() {
            return this.f2156a;
        }

        protected abstract void m4517e();
    }

    public static class C0798r {
        int f2163a = 0;
        private int f2164b = -1;
        private int f2165c = 1;
        private SparseArray<Object> f2166d;
        private int f2167e = 0;
        private int f2168f = 0;
        private boolean f2169g = false;
        private boolean f2170h = false;
        private boolean f2171i = false;
        private boolean f2172j = false;
        private boolean f2173k = false;
        private boolean f2174l = false;

        static /* synthetic */ int m4519a(C0798r c0798r, int i) {
            int i2 = c0798r.f2168f + i;
            c0798r.f2168f = i2;
            return i2;
        }

        void m4535a(int i) {
            if ((this.f2165c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f2165c));
            }
        }

        public boolean m4536a() {
            return this.f2170h;
        }

        public boolean m4537b() {
            return this.f2172j;
        }

        public int m4538c() {
            return this.f2164b;
        }

        public boolean m4539d() {
            return this.f2164b != -1;
        }

        public int m4540e() {
            return this.f2170h ? this.f2167e - this.f2168f : this.f2163a;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2164b + ", mData=" + this.f2166d + ", mItemCount=" + this.f2163a + ", mPreviousLayoutItemCount=" + this.f2167e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2168f + ", mStructureChanged=" + this.f2169g + ", mInPreLayout=" + this.f2170h + ", mRunSimpleAnimations=" + this.f2171i + ", mRunPredictiveAnimations=" + this.f2172j + '}';
        }
    }

    public static abstract class C0799s {
        public abstract View m4541a(C0793n c0793n, int i, int i2);
    }

    private class C0800t implements Runnable {
        final /* synthetic */ RecyclerView f2175a;
        private int f2176b;
        private int f2177c;
        private C0599u f2178d;
        private Interpolator f2179e = RecyclerView.aq;
        private boolean f2180f = false;
        private boolean f2181g = false;

        public C0800t(RecyclerView recyclerView) {
            this.f2175a = recyclerView;
            this.f2178d = C0599u.m3190a(recyclerView.getContext(), RecyclerView.aq);
        }

        private float m4542a(float f) {
            return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        }

        private int m4543b(int i, int i2, int i3, int i4) {
            int round;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            Object obj = abs > abs2 ? 1 : null;
            int sqrt = (int) Math.sqrt((double) ((i3 * i3) + (i4 * i4)));
            int sqrt2 = (int) Math.sqrt((double) ((i * i) + (i2 * i2)));
            int width = obj != null ? this.f2175a.getWidth() : this.f2175a.getHeight();
            int i5 = width / 2;
            float a = (m4542a(Math.min(1.0f, (((float) sqrt2) * 1.0f) / ((float) width))) * ((float) i5)) + ((float) i5);
            if (sqrt > 0) {
                round = Math.round(1000.0f * Math.abs(a / ((float) sqrt))) * 4;
            } else {
                round = (int) (((((float) (obj != null ? abs : abs2)) / ((float) width)) + 1.0f) * 300.0f);
            }
            return Math.min(round, 2000);
        }

        private void m4544c() {
            this.f2181g = false;
            this.f2180f = true;
        }

        private void m4545d() {
            this.f2180f = false;
            if (this.f2181g) {
                m4546a();
            }
        }

        void m4546a() {
            if (this.f2180f) {
                this.f2181g = true;
                return;
            }
            this.f2175a.removeCallbacks(this);
            ag.m2519a(this.f2175a, (Runnable) this);
        }

        public void m4547a(int i, int i2) {
            this.f2175a.setScrollState(2);
            this.f2177c = 0;
            this.f2176b = 0;
            this.f2178d.m3193a(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            m4546a();
        }

        public void m4548a(int i, int i2, int i3) {
            m4550a(i, i2, i3, RecyclerView.aq);
        }

        public void m4549a(int i, int i2, int i3, int i4) {
            m4548a(i, i2, m4543b(i, i2, i3, i4));
        }

        public void m4550a(int i, int i2, int i3, Interpolator interpolator) {
            if (this.f2179e != interpolator) {
                this.f2179e = interpolator;
                this.f2178d = C0599u.m3190a(this.f2175a.getContext(), interpolator);
            }
            this.f2175a.setScrollState(2);
            this.f2177c = 0;
            this.f2176b = 0;
            this.f2178d.m3192a(0, 0, i, i2, i3);
            m4546a();
        }

        public void m4551b() {
            this.f2175a.removeCallbacks(this);
            this.f2178d.m3203h();
        }

        public void m4552b(int i, int i2) {
            m4549a(i, i2, 0, 0);
        }

        public void run() {
            if (this.f2175a.f224f == null) {
                m4551b();
                return;
            }
            m4544c();
            this.f2175a.m284t();
            C0599u c0599u = this.f2178d;
            C0797q c0797q = this.f2175a.f224f.f2068r;
            if (c0599u.m3202g()) {
                int e;
                int i;
                int f;
                int i2;
                Object obj;
                Object obj2;
                int b = c0599u.m3197b();
                int c = c0599u.m3198c();
                int i3 = b - this.f2176b;
                int i4 = c - this.f2177c;
                int i5 = 0;
                int i6 = 0;
                this.f2176b = b;
                this.f2177c = c;
                int i7 = 0;
                int i8 = 0;
                if (this.f2175a.f234s != null) {
                    this.f2175a.m306b();
                    this.f2175a.m292z();
                    C0344g.m1832a("RV Scroll");
                    if (i3 != 0) {
                        i5 = this.f2175a.f224f.mo703a(i3, this.f2175a.f220b, this.f2175a.f226h);
                        i7 = i3 - i5;
                    }
                    if (i4 != 0) {
                        i6 = this.f2175a.f224f.mo710b(i4, this.f2175a.f220b, this.f2175a.f226h);
                        i8 = i4 - i6;
                    }
                    C0344g.m1831a();
                    this.f2175a.m221J();
                    this.f2175a.m212A();
                    this.f2175a.m302a(false);
                    if (!(c0797q == null || c0797q.m4514b() || !c0797q.m4515c())) {
                        e = this.f2175a.f226h.m4540e();
                        if (e == 0) {
                            c0797q.m4509a();
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else if (c0797q.m4516d() >= e) {
                            c0797q.m4510a(e - 1);
                            c0797q.m4506a(i3 - i7, i4 - i8);
                            i = i7;
                            i7 = i6;
                            i6 = i;
                        } else {
                            c0797q.m4506a(i3 - i7, i4 - i8);
                        }
                        if (!this.f2175a.f236u.isEmpty()) {
                            this.f2175a.invalidate();
                        }
                        if (ag.m2509a(this.f2175a) != 2) {
                            this.f2175a.m266i(i3, i4);
                        }
                        if (!(i6 == 0 && i8 == 0)) {
                            f = (int) c0599u.m3201f();
                            if (i6 == b) {
                                e = i6 >= 0 ? -f : i6 <= 0 ? f : 0;
                                i2 = e;
                            } else {
                                i2 = 0;
                            }
                            if (i8 != c) {
                                f = 0;
                            } else if (i8 < 0) {
                                f = -f;
                            } else if (i8 <= 0) {
                                f = 0;
                            }
                            if (ag.m2509a(this.f2175a) != 2) {
                                this.f2175a.m311c(i2, f);
                            }
                            if ((i2 != 0 || i6 == b || c0599u.m3199d() == 0) && (f != 0 || i8 == c || c0599u.m3200e() == 0)) {
                                c0599u.m3203h();
                            }
                        }
                        if (!(i5 == 0 && i7 == 0)) {
                            this.f2175a.m326h(i5, i7);
                        }
                        if (!this.f2175a.awakenScrollBars()) {
                            this.f2175a.invalidate();
                        }
                        obj = (i4 == 0 && this.f2175a.f224f.mo721e() && i7 == i4) ? 1 : null;
                        obj2 = (i3 == 0 && this.f2175a.f224f.mo719d() && i5 == i3) ? 1 : null;
                        obj2 = ((i3 == 0 || i4 != 0) && obj2 == null && obj == null) ? null : 1;
                        if (!c0599u.m3195a() || obj2 == null) {
                            this.f2175a.setScrollState(0);
                        } else {
                            m4546a();
                        }
                    }
                }
                i = i7;
                i7 = i6;
                i6 = i;
                if (this.f2175a.f236u.isEmpty()) {
                    this.f2175a.invalidate();
                }
                if (ag.m2509a(this.f2175a) != 2) {
                    this.f2175a.m266i(i3, i4);
                }
                f = (int) c0599u.m3201f();
                if (i6 == b) {
                    i2 = 0;
                } else {
                    if (i6 >= 0) {
                        if (i6 <= 0) {
                        }
                    }
                    i2 = e;
                }
                if (i8 != c) {
                    f = 0;
                } else if (i8 < 0) {
                    f = -f;
                } else if (i8 <= 0) {
                    f = 0;
                }
                if (ag.m2509a(this.f2175a) != 2) {
                    this.f2175a.m311c(i2, f);
                }
                c0599u.m3203h();
                this.f2175a.m326h(i5, i7);
                if (this.f2175a.awakenScrollBars()) {
                    this.f2175a.invalidate();
                }
                if (i4 == 0) {
                }
                if (i3 == 0) {
                }
                if (i3 == 0) {
                }
                if (c0599u.m3195a()) {
                }
                this.f2175a.setScrollState(0);
            }
            if (c0797q != null) {
                if (c0797q.m4514b()) {
                    c0797q.m4506a(0, 0);
                }
                if (!this.f2181g) {
                    c0797q.m4509a();
                }
            }
            m4545d();
        }
    }

    public static abstract class C0801u {
        private static final List<Object> f2182m = Collections.EMPTY_LIST;
        public final View f2183a;
        int f2184b = -1;
        int f2185c = -1;
        long f2186d = -1;
        int f2187e = -1;
        int f2188f = -1;
        C0801u f2189g = null;
        C0801u f2190h = null;
        List<Object> f2191i = null;
        List<Object> f2192j = null;
        RecyclerView f2193k;
        private int f2194l;
        private int f2195n = 0;
        private C0793n f2196o = null;
        private boolean f2197p = false;
        private int f2198q = 0;

        public C0801u(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f2183a = view;
        }

        private void m4553A() {
            ag.m2529c(this.f2183a, this.f2198q);
            this.f2198q = 0;
        }

        private boolean m4554B() {
            return (this.f2194l & 16) != 0;
        }

        private boolean m4555C() {
            return (this.f2194l & 16) == 0 && ag.m2531c(this.f2183a);
        }

        private void m4564y() {
            if (this.f2191i == null) {
                this.f2191i = new ArrayList();
                this.f2192j = Collections.unmodifiableList(this.f2191i);
            }
        }

        private void m4565z() {
            this.f2198q = ag.m2535e(this.f2183a);
            ag.m2529c(this.f2183a, 4);
        }

        void m4566a() {
            this.f2185c = -1;
            this.f2188f = -1;
        }

        void m4567a(int i, int i2) {
            this.f2194l = (this.f2194l & (i2 ^ -1)) | (i & i2);
        }

        void m4568a(int i, int i2, boolean z) {
            m4575b(8);
            m4569a(i2, z);
            this.f2184b = i;
        }

        void m4569a(int i, boolean z) {
            if (this.f2185c == -1) {
                this.f2185c = this.f2184b;
            }
            if (this.f2188f == -1) {
                this.f2188f = this.f2184b;
            }
            if (z) {
                this.f2188f += i;
            }
            this.f2184b += i;
            if (this.f2183a.getLayoutParams() != null) {
                ((C0761i) this.f2183a.getLayoutParams()).f2055c = true;
            }
        }

        void m4570a(C0793n c0793n, boolean z) {
            this.f2196o = c0793n;
            this.f2197p = z;
        }

        void m4571a(Object obj) {
            if (obj == null) {
                m4575b(1024);
            } else if ((this.f2194l & 1024) == 0) {
                m4564y();
                this.f2191i.add(obj);
            }
        }

        public final void m4572a(boolean z) {
            this.f2195n = z ? this.f2195n - 1 : this.f2195n + 1;
            if (this.f2195n < 0) {
                this.f2195n = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && this.f2195n == 1) {
                this.f2194l |= 16;
            } else if (z && this.f2195n == 0) {
                this.f2194l &= -17;
            }
        }

        boolean m4573a(int i) {
            return (this.f2194l & i) != 0;
        }

        void m4574b() {
            if (this.f2185c == -1) {
                this.f2185c = this.f2184b;
            }
        }

        void m4575b(int i) {
            this.f2194l |= i;
        }

        boolean m4576c() {
            return (this.f2194l & 128) != 0;
        }

        public final int m4577d() {
            return this.f2188f == -1 ? this.f2184b : this.f2188f;
        }

        public final int m4578e() {
            return this.f2193k == null ? -1 : this.f2193k.m258d(this);
        }

        public final int m4579f() {
            return this.f2185c;
        }

        public final long m4580g() {
            return this.f2186d;
        }

        public final int m4581h() {
            return this.f2187e;
        }

        boolean m4582i() {
            return this.f2196o != null;
        }

        void m4583j() {
            this.f2196o.m4487d(this);
        }

        boolean m4584k() {
            return (this.f2194l & 32) != 0;
        }

        void m4585l() {
            this.f2194l &= -33;
        }

        void m4586m() {
            this.f2194l &= -257;
        }

        boolean m4587n() {
            return (this.f2194l & 4) != 0;
        }

        boolean m4588o() {
            return (this.f2194l & 2) != 0;
        }

        boolean m4589p() {
            return (this.f2194l & 1) != 0;
        }

        boolean m4590q() {
            return (this.f2194l & 8) != 0;
        }

        boolean m4591r() {
            return (this.f2194l & 256) != 0;
        }

        boolean m4592s() {
            return (this.f2194l & 512) != 0 || m4587n();
        }

        void m4593t() {
            if (this.f2191i != null) {
                this.f2191i.clear();
            }
            this.f2194l &= -1025;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.f2184b + " id=" + this.f2186d + ", oldPos=" + this.f2185c + ", pLpos:" + this.f2188f);
            if (m4582i()) {
                stringBuilder.append(" scrap ").append(this.f2197p ? "[changeScrap]" : "[attachedScrap]");
            }
            if (m4587n()) {
                stringBuilder.append(" invalid");
            }
            if (!m4589p()) {
                stringBuilder.append(" unbound");
            }
            if (m4588o()) {
                stringBuilder.append(" update");
            }
            if (m4590q()) {
                stringBuilder.append(" removed");
            }
            if (m4576c()) {
                stringBuilder.append(" ignored");
            }
            if (m4591r()) {
                stringBuilder.append(" tmpDetached");
            }
            if (!m4596w()) {
                stringBuilder.append(" not recyclable(" + this.f2195n + ")");
            }
            if (m4592s()) {
                stringBuilder.append(" undefined adapter position");
            }
            if (this.f2183a.getParent() == null) {
                stringBuilder.append(" no parent");
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        List<Object> m4594u() {
            return (this.f2194l & 1024) == 0 ? (this.f2191i == null || this.f2191i.size() == 0) ? f2182m : this.f2192j : f2182m;
        }

        void m4595v() {
            this.f2194l = 0;
            this.f2184b = -1;
            this.f2185c = -1;
            this.f2186d = -1;
            this.f2188f = -1;
            this.f2195n = 0;
            this.f2189g = null;
            this.f2190h = null;
            m4593t();
            this.f2198q = 0;
        }

        public final boolean m4596w() {
            return (this.f2194l & 16) == 0 && !ag.m2531c(this.f2183a);
        }

        boolean m4597x() {
            return (this.f2194l & 2) != 0;
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        f195l = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        boolean z = true;
        super(context, attributeSet, i);
        this.f229n = new C0795p();
        this.f220b = new C0793n(this);
        this.f223e = new bk();
        this.f232q = new C07681(this);
        this.f233r = new Rect();
        this.f236u = new ArrayList();
        this.f237v = new ArrayList();
        this.f197A = 0;
        this.f206J = false;
        this.f207K = 0;
        this.f225g = new ak();
        this.f212P = 0;
        this.f213Q = -1;
        this.ac = Float.MIN_VALUE;
        this.ad = new C0800t(this);
        this.f226h = new C0798r();
        this.f227i = false;
        this.f228j = false;
        this.ag = new C0786f();
        this.ah = false;
        this.ak = new int[2];
        this.am = new int[2];
        this.an = new int[2];
        this.ao = new int[2];
        this.ap = new C07692(this);
        this.ar = new C07724(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        this.f203G = VERSION.SDK_INT >= 16;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f219W = viewConfiguration.getScaledTouchSlop();
        this.aa = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ab = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(ag.m2509a(this) == 2);
        this.f225g.m4420a(this.ag);
        m296a();
        m283s();
        if (ag.m2535e(this) == 0) {
            ag.m2529c((View) this, 1);
        }
        this.f204H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new at(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0700a.RecyclerView, i, 0);
            String string = obtainStyledAttributes.getString(C0700a.RecyclerView_layoutManager);
            obtainStyledAttributes.recycle();
            m225a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f194k, i, 0);
                z = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        }
        setNestedScrollingEnabled(z);
    }

    private void m212A() {
        this.f207K--;
        if (this.f207K < 1) {
            this.f207K = 0;
            m213B();
        }
    }

    private void m213B() {
        int i = this.f201E;
        this.f201E = 0;
        if (i != 0 && m327i()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            C0413a.m2089a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void m214C() {
        if (!this.ah && this.f239x) {
            ag.m2519a((View) this, this.ap);
            this.ah = true;
        }
    }

    private boolean m215D() {
        return this.f225g != null && this.f224f.mo712b();
    }

    private void m216E() {
        boolean z = true;
        if (this.f206J) {
            this.f221c.m5381a();
            m333o();
            this.f224f.mo733a(this);
        }
        if (m215D()) {
            this.f221c.m5388b();
        } else {
            this.f221c.m5393e();
        }
        boolean z2 = this.f227i || this.f228j;
        C0798r c0798r = this.f226h;
        boolean z3 = this.f241z && this.f225g != null && ((this.f206J || z2 || this.f224f.f2059a) && (!this.f206J || this.f234s.m4397b()));
        c0798r.f2171i = z3;
        C0798r c0798r2 = this.f226h;
        if (!(this.f226h.f2171i && z2 && !this.f206J && m215D())) {
            z = false;
        }
        c0798r2.f2172j = z;
    }

    private void m217F() {
        int b;
        int i;
        C0801u c;
        boolean z = true;
        this.f226h.m4535a(1);
        this.f226h.f2174l = false;
        m306b();
        this.f223e.m5285a();
        m292z();
        m216E();
        C0798r c0798r = this.f226h;
        if (!(this.f226h.f2171i && this.f228j)) {
            z = false;
        }
        c0798r.f2173k = z;
        this.f228j = false;
        this.f227i = false;
        this.f226h.f2170h = this.f226h.f2172j;
        this.f226h.f2163a = this.f234s.mo1796a();
        m236a(this.ak);
        if (this.f226h.f2171i) {
            b = this.f222d.m4907b();
            for (i = 0; i < b; i++) {
                c = m251c(this.f222d.m4909b(i));
                if (!c.m4576c() && (!c.m4587n() || this.f234s.m4397b())) {
                    this.f223e.m5287a(c, this.f225g.m4418a(this.f226h, c, C0785e.m4416d(c), c.m4594u()));
                    if (!(!this.f226h.f2173k || !c.m4597x() || c.m4590q() || c.m4576c() || c.m4587n())) {
                        this.f223e.m5286a(m293a(c), c);
                    }
                }
            }
        }
        if (this.f226h.f2172j) {
            m331m();
            z = this.f226h.f2169g;
            this.f226h.f2169g = false;
            this.f224f.mo716c(this.f220b, this.f226h);
            this.f226h.f2169g = z;
            for (i = 0; i < this.f222d.m4907b(); i++) {
                c = m251c(this.f222d.m4909b(i));
                if (!(c.m4576c() || this.f223e.m5295d(c))) {
                    b = C0785e.m4416d(c);
                    boolean a = c.m4573a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    C0784c a2 = this.f225g.m4418a(this.f226h, c, b, c.m4594u());
                    if (a) {
                        m227a(c, a2);
                    } else {
                        this.f223e.m5292b(c, a2);
                    }
                }
            }
            m332n();
        } else {
            m332n();
        }
        m212A();
        m302a(false);
        this.f226h.f2165c = 2;
    }

    private void m218G() {
        m306b();
        m292z();
        this.f226h.m4535a(6);
        this.f221c.m5393e();
        this.f226h.f2163a = this.f234s.mo1796a();
        this.f226h.f2168f = 0;
        this.f226h.f2170h = false;
        this.f224f.mo716c(this.f220b, this.f226h);
        this.f226h.f2169g = false;
        this.f230o = null;
        C0798r c0798r = this.f226h;
        boolean z = this.f226h.f2171i && this.f225g != null;
        c0798r.f2171i = z;
        this.f226h.f2165c = 4;
        m212A();
        m302a(false);
    }

    private void m219H() {
        this.f226h.m4535a(4);
        m306b();
        m292z();
        this.f226h.f2165c = 1;
        if (this.f226h.f2171i) {
            for (int b = this.f222d.m4907b() - 1; b >= 0; b--) {
                C0801u c = m251c(this.f222d.m4909b(b));
                if (!c.m4576c()) {
                    long a = m293a(c);
                    C0784c a2 = this.f225g.m4417a(this.f226h, c);
                    C0801u a3 = this.f223e.m5284a(a);
                    if (a3 == null || a3.m4576c()) {
                        this.f223e.m5294c(c, a2);
                    } else {
                        boolean a4 = this.f223e.m5289a(a3);
                        boolean a5 = this.f223e.m5289a(c);
                        if (a4 && a3 == c) {
                            this.f223e.m5294c(c, a2);
                        } else {
                            C0784c b2 = this.f223e.m5290b(a3);
                            this.f223e.m5294c(c, a2);
                            C0784c c2 = this.f223e.m5293c(c);
                            if (b2 == null) {
                                m224a(a, c, a3);
                            } else {
                                m229a(a3, c, b2, c2, a4, a5);
                            }
                        }
                    }
                }
            }
            this.f223e.m5288a(this.ar);
        }
        this.f224f.m4146b(this.f220b);
        this.f226h.f2167e = this.f226h.f2163a;
        this.f206J = false;
        this.f226h.f2171i = false;
        this.f226h.f2172j = false;
        this.f224f.f2059a = false;
        if (this.f220b.f2143d != null) {
            this.f220b.f2143d.clear();
        }
        m212A();
        m302a(false);
        this.f223e.m5285a();
        if (m271j(this.ak[0], this.ak[1])) {
            m326h(0, 0);
        }
    }

    private void m220I() {
        if (!this.f206J) {
            this.f206J = true;
            int c = this.f222d.m4910c();
            for (int i = 0; i < c; i++) {
                C0801u c2 = m251c(this.f222d.m4911c(i));
                if (!(c2 == null || c2.m4576c())) {
                    c2.m4575b(512);
                }
            }
            this.f220b.m4493g();
        }
    }

    private void m221J() {
        int b = this.f222d.m4907b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f222d.m4909b(i);
            C0801u a = m295a(b2);
            if (!(a == null || a.f2190h == null)) {
                View view = a.f2190h.f2183a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    private String m222a(Context context, String str) {
        return str.charAt(0) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m223a(float r8, float r9, float r10, float r11) {
        /*
        r7 = this;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = 1;
        r5 = 0;
        r1 = 0;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x0050;
    L_0x0009:
        r7.m313d();
        r2 = r7.f208L;
        r3 = -r9;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r4 = r6 - r4;
        r2 = r2.m3105a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r1 = r0;
    L_0x0025:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x006f;
    L_0x0029:
        r7.m319f();
        r2 = r7.f209M;
        r3 = -r11;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r2 = r2.m3105a(r3, r4);
        if (r2 == 0) goto L_0x008e;
    L_0x0042:
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 != 0) goto L_0x004c;
    L_0x0048:
        r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r0 == 0) goto L_0x004f;
    L_0x004c:
        android.support.v4.view.ag.m2532d(r7);
    L_0x004f:
        return;
    L_0x0050:
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x0025;
    L_0x0054:
        r7.m316e();
        r2 = r7.f210N;
        r3 = r7.getWidth();
        r3 = (float) r3;
        r3 = r9 / r3;
        r4 = r7.getHeight();
        r4 = (float) r4;
        r4 = r10 / r4;
        r2 = r2.m3105a(r3, r4);
        if (r2 == 0) goto L_0x0025;
    L_0x006d:
        r1 = r0;
        goto L_0x0025;
    L_0x006f:
        r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1));
        if (r2 <= 0) goto L_0x008e;
    L_0x0073:
        r7.m323g();
        r2 = r7.f211O;
        r3 = r7.getHeight();
        r3 = (float) r3;
        r3 = r11 / r3;
        r4 = r7.getWidth();
        r4 = (float) r4;
        r4 = r8 / r4;
        r4 = r6 - r4;
        r2 = r2.m3105a(r3, r4);
        if (r2 != 0) goto L_0x0042;
    L_0x008e:
        r0 = r1;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void m224a(long j, C0801u c0801u, C0801u c0801u2) {
        int b = this.f222d.m4907b();
        int i = 0;
        while (i < b) {
            C0801u c = m251c(this.f222d.m4909b(i));
            if (c == c0801u || m293a(c) != j) {
                i++;
            } else if (this.f234s == null || !this.f234s.m4397b()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + c + " \n View Holder 2:" + c0801u);
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + c + " \n View Holder 2:" + c0801u);
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + c0801u2 + " cannot be found but it is necessary for " + c0801u);
    }

    private void m225a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                String a = m222a(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(a).asSubclass(C0763h.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(f196m);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((C0763h) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private void m226a(C0778a c0778a, boolean z, boolean z2) {
        if (this.f234s != null) {
            this.f234s.m4394b(this.f229n);
            this.f234s.m4396b(this);
        }
        if (!z || z2) {
            if (this.f225g != null) {
                this.f225g.mo800c();
            }
            if (this.f224f != null) {
                this.f224f.m4158c(this.f220b);
                this.f224f.m4146b(this.f220b);
            }
            this.f220b.m4466a();
        }
        this.f221c.m5381a();
        C0778a c0778a2 = this.f234s;
        this.f234s = c0778a;
        if (c0778a != null) {
            c0778a.m4387a(this.f229n);
            c0778a.m4391a(this);
        }
        if (this.f224f != null) {
            this.f224f.m4110a(c0778a2, this.f234s);
        }
        this.f220b.m4469a(c0778a2, this.f234s, z);
        this.f226h.f2169g = true;
        m333o();
    }

    private void m227a(C0801u c0801u, C0784c c0784c) {
        c0801u.m4567a(0, 8192);
        if (this.f226h.f2173k && c0801u.m4597x() && !c0801u.m4590q() && !c0801u.m4576c()) {
            this.f223e.m5286a(m293a(c0801u), c0801u);
        }
        this.f223e.m5287a(c0801u, c0784c);
    }

    private void m228a(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        c0801u.m4572a(false);
        if (this.f225g.mo790b(c0801u, c0784c, c0784c2)) {
            m214C();
        }
    }

    private void m229a(C0801u c0801u, C0801u c0801u2, C0784c c0784c, C0784c c0784c2, boolean z, boolean z2) {
        c0801u.m4572a(false);
        if (z) {
            m242b(c0801u);
        }
        if (c0801u != c0801u2) {
            if (z2) {
                m242b(c0801u2);
            }
            c0801u.f2189g = c0801u2;
            m242b(c0801u);
            this.f220b.m4487d(c0801u);
            c0801u2.m4572a(false);
            c0801u2.f2190h = c0801u;
        }
        if (this.f225g.mo789a(c0801u, c0801u2, c0784c, c0784c2)) {
            m214C();
        }
    }

    private void m236a(int[] iArr) {
        int b = this.f222d.m4907b();
        if (b == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            int i4;
            C0801u c = m251c(this.f222d.m4909b(i3));
            if (c.m4576c()) {
                i4 = i;
            } else {
                i4 = c.m4577d();
                if (i4 < i) {
                    i = i4;
                }
                if (i4 > i2) {
                    i2 = i4;
                    i4 = i;
                } else {
                    i4 = i;
                }
            }
            i3++;
            i = i4;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean m240a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.f238w = null;
        }
        int size = this.f237v.size();
        int i = 0;
        while (i < size) {
            C0790k c0790k = (C0790k) this.f237v.get(i);
            if (!c0790k.m4448a(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.f238w = c0790k;
                return true;
            }
        }
        return false;
    }

    private void m242b(C0801u c0801u) {
        View view = c0801u.f2183a;
        boolean z = view.getParent() == this;
        this.f220b.m4487d(m295a(view));
        if (c0801u.m4591r()) {
            this.f222d.m4904a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f222d.m4914d(view);
        } else {
            this.f222d.m4906a(view, true);
        }
    }

    private void m243b(C0801u c0801u, C0784c c0784c, C0784c c0784c2) {
        m242b(c0801u);
        c0801u.m4572a(false);
        if (this.f225g.mo788a(c0801u, c0784c, c0784c2)) {
            m214C();
        }
    }

    private boolean m250b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f238w != null) {
            if (action == 0) {
                this.f238w = null;
            } else {
                this.f238w.m4449b(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.f238w = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.f237v.size();
            for (int i = 0; i < size; i++) {
                C0790k c0790k = (C0790k) this.f237v.get(i);
                if (c0790k.m4448a(this, motionEvent)) {
                    this.f238w = c0790k;
                    return true;
                }
            }
        }
        return false;
    }

    static C0801u m251c(View view) {
        return view == null ? null : ((C0761i) view.getLayoutParams()).f2053a;
    }

    private void m254c(MotionEvent motionEvent) {
        int b = C0543s.m2895b(motionEvent);
        if (C0543s.m2896b(motionEvent, b) == this.f213Q) {
            b = b == 0 ? 1 : 0;
            this.f213Q = C0543s.m2896b(motionEvent, b);
            int c = (int) (C0543s.m2897c(motionEvent, b) + 0.5f);
            this.f217U = c;
            this.f215S = c;
            b = (int) (C0543s.m2899d(motionEvent, b) + 0.5f);
            this.f218V = b;
            this.f216T = b;
        }
    }

    private boolean m255c(C0801u c0801u) {
        return this.f225g == null || this.f225g.mo797a(c0801u, c0801u.m4594u());
    }

    private int m258d(C0801u c0801u) {
        return (c0801u.m4573a(524) || !c0801u.m4589p()) ? -1 : this.f221c.m5390c(c0801u.f2184b);
    }

    private void m260e(int i) {
        if (this.f224f != null) {
            this.f224f.mo718d(i);
            awakenScrollBars();
        }
    }

    private float getScrollFactor() {
        if (this.ac == Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, typedValue, true)) {
                return 0.0f;
            }
            this.ac = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.ac;
    }

    private C0547x getScrollingChildHelper() {
        if (this.al == null) {
            this.al = new C0547x(this);
        }
        return this.al;
    }

    private boolean m265h(View view) {
        m306b();
        boolean f = this.f222d.m4916f(view);
        if (f) {
            C0801u c = m251c(view);
            this.f220b.m4487d(c);
            this.f220b.m4478b(c);
        }
        m302a(!f);
        return f;
    }

    private void m266i(int i, int i2) {
        int i3 = 0;
        if (!(this.f208L == null || this.f208L.m3103a() || i <= 0)) {
            i3 = this.f208L.m3109c();
        }
        if (!(this.f210N == null || this.f210N.m3103a() || i >= 0)) {
            i3 |= this.f210N.m3109c();
        }
        if (!(this.f209M == null || this.f209M.m3103a() || i2 <= 0)) {
            i3 |= this.f209M.m3109c();
        }
        if (!(this.f211O == null || this.f211O.m3103a() || i2 >= 0)) {
            i3 |= this.f211O.m3109c();
        }
        if (i3 != 0) {
            ag.m2532d(this);
        }
    }

    private void m268i(View view) {
        C0801u c = m251c(view);
        m321f(view);
        if (!(this.f234s == null || c == null)) {
            this.f234s.m4402d(c);
        }
        if (this.f205I != null) {
            for (int size = this.f205I.size() - 1; size >= 0; size--) {
                ((C0789j) this.f205I.get(size)).m4446b(view);
            }
        }
    }

    private void m270j(View view) {
        C0801u c = m251c(view);
        m318e(view);
        if (!(this.f234s == null || c == null)) {
            this.f234s.m4401c(c);
        }
        if (this.f205I != null) {
            for (int size = this.f205I.size() - 1; size >= 0; size--) {
                ((C0789j) this.f205I.get(size)).m4445a(view);
            }
        }
    }

    private boolean m271j(int i, int i2) {
        if (this.f222d.m4907b() == 0) {
            return (i == 0 && i2 == 0) ? false : true;
        } else {
            m236a(this.ak);
            return (this.ak[0] == i && this.ak[1] == i2) ? false : true;
        }
    }

    private void m283s() {
        this.f222d = new ah(new C07745(this));
    }

    private void setScrollState(int i) {
        if (i != this.f212P) {
            this.f212P = i;
            if (i != 2) {
                m288v();
            }
            m314d(i);
        }
    }

    private void m284t() {
        if (!this.f241z) {
            return;
        }
        if (this.f206J) {
            C0344g.m1832a("RV FullInvalidate");
            m329k();
            C0344g.m1831a();
        } else if (!this.f221c.m5392d()) {
        } else {
            if (this.f221c.m5385a(4) && !this.f221c.m5385a(11)) {
                C0344g.m1832a("RV PartialInvalidate");
                m306b();
                this.f221c.m5388b();
                if (!this.f198B) {
                    if (m287u()) {
                        m329k();
                    } else {
                        this.f221c.m5391c();
                    }
                }
                m302a(true);
                C0344g.m1831a();
            } else if (this.f221c.m5392d()) {
                C0344g.m1832a("RV FullInvalidate");
                m329k();
                C0344g.m1831a();
            }
        }
    }

    private boolean m287u() {
        int b = this.f222d.m4907b();
        for (int i = 0; i < b; i++) {
            C0801u c = m251c(this.f222d.m4909b(i));
            if (c != null && !c.m4576c() && c.m4597x()) {
                return true;
            }
        }
        return false;
    }

    private void m288v() {
        this.ad.m4551b();
        if (this.f224f != null) {
            this.f224f.m4096F();
        }
    }

    private void m289w() {
        int i = 0;
        if (this.f208L != null) {
            i = this.f208L.m3109c();
        }
        if (this.f209M != null) {
            i |= this.f209M.m3109c();
        }
        if (this.f210N != null) {
            i |= this.f210N.m3109c();
        }
        if (this.f211O != null) {
            i |= this.f211O.m3109c();
        }
        if (i != 0) {
            ag.m2532d(this);
        }
    }

    private void m290x() {
        if (this.f214R != null) {
            this.f214R.clear();
        }
        stopNestedScroll();
        m289w();
    }

    private void m291y() {
        m290x();
        setScrollState(0);
    }

    private void m292z() {
        this.f207K++;
    }

    long m293a(C0801u c0801u) {
        return this.f234s.m4397b() ? c0801u.m4580g() : (long) c0801u.f2184b;
    }

    C0801u m294a(int i, boolean z) {
        int c = this.f222d.m4910c();
        for (int i2 = 0; i2 < c; i2++) {
            C0801u c2 = m251c(this.f222d.m4911c(i2));
            if (!(c2 == null || c2.m4590q())) {
                if (z) {
                    if (c2.f2184b == i) {
                        return c2;
                    }
                } else if (c2.m4577d() == i) {
                    return c2;
                }
            }
        }
        return null;
    }

    public C0801u m295a(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return m251c(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void m296a() {
        this.f221c = new C0882f(new C07766(this));
    }

    public void m297a(int i) {
        int b = this.f222d.m4907b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f222d.m4909b(i2).offsetTopAndBottom(i);
        }
    }

    public void m298a(int i, int i2) {
        int i3 = 0;
        if (this.f224f == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f199C) {
            if (!this.f224f.mo719d()) {
                i = 0;
            }
            if (this.f224f.mo721e()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.ad.m4552b(i, i3);
            }
        }
    }

    void m299a(int i, int i2, Object obj) {
        int c = this.f222d.m4910c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View c2 = this.f222d.m4911c(i4);
            C0801u c3 = m251c(c2);
            if (c3 != null && !c3.m4576c() && c3.f2184b >= i && c3.f2184b < i3) {
                c3.m4575b(2);
                c3.m4571a(obj);
                ((C0761i) c2.getLayoutParams()).f2055c = true;
            }
        }
        this.f220b.m4482c(i, i2);
    }

    void m300a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f222d.m4910c();
        for (int i4 = 0; i4 < c; i4++) {
            C0801u c2 = m251c(this.f222d.m4911c(i4));
            if (!(c2 == null || c2.m4576c())) {
                if (c2.f2184b >= i3) {
                    c2.m4569a(-i2, z);
                    this.f226h.f2169g = true;
                } else if (c2.f2184b >= i) {
                    c2.m4568a(i - 1, -i2, z);
                    this.f226h.f2169g = true;
                }
            }
        }
        this.f220b.m4477b(i, i2, z);
        requestLayout();
    }

    void m301a(String str) {
        if (!m328j()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
        }
        throw new IllegalStateException(str);
    }

    void m302a(boolean z) {
        if (this.f197A < 1) {
            this.f197A = 1;
        }
        if (!z) {
            this.f198B = false;
        }
        if (this.f197A == 1) {
            if (!(!z || !this.f198B || this.f199C || this.f224f == null || this.f234s == null)) {
                m329k();
            }
            if (!this.f199C) {
                this.f198B = false;
            }
        }
        this.f197A--;
    }

    boolean m303a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        m284t();
        if (this.f234s != null) {
            int b;
            m306b();
            m292z();
            C0344g.m1832a("RV Scroll");
            if (i != 0) {
                a = this.f224f.mo703a(i, this.f220b, this.f226h);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.f224f.mo710b(i2, this.f220b, this.f226h);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            C0344g.m1831a();
            m221J();
            m212A();
            m302a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.f236u.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.am)) {
            this.f217U -= this.am[0];
            this.f218V -= this.am[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.am[0], (float) this.am[1]);
            }
            int[] iArr = this.ao;
            iArr[0] = iArr[0] + this.am[0];
            iArr = this.ao;
            iArr[1] = iArr[1] + this.am[1];
        } else if (ag.m2509a(this) != 2) {
            if (motionEvent != null) {
                m223a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            m266i(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            m326h(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && a == 0) ? false : true;
    }

    boolean m304a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!m328j()) {
            return false;
        }
        int b = accessibilityEvent != null ? C0413a.m2090b(accessibilityEvent) : 0;
        if (b != 0) {
            i = b;
        }
        this.f201E = i | this.f201E;
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.f224f == null || !this.f224f.m4138a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public View m305b(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent == this ? view2 : null;
    }

    void m306b() {
        this.f197A++;
        if (this.f197A == 1 && !this.f199C) {
            this.f198B = false;
        }
    }

    public void m307b(int i) {
        int b = this.f222d.m4907b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f222d.m4909b(i2).offsetLeftAndRight(i);
        }
    }

    public boolean m308b(int i, int i2) {
        if (this.f224f == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f199C) {
            return false;
        } else {
            boolean d = this.f224f.mo719d();
            boolean e = this.f224f.mo721e();
            if (!d || Math.abs(i) < this.aa) {
                i = 0;
            }
            if (!e || Math.abs(i2) < this.aa) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            d = d || e;
            dispatchNestedFling((float) i, (float) i2, d);
            if (!d) {
                return false;
            }
            this.ad.m4547a(Math.max(-this.ab, Math.min(i, this.ab)), Math.max(-this.ab, Math.min(i2, this.ab)));
            return true;
        }
    }

    public void m309c() {
        setScrollState(0);
        m288v();
    }

    public void m310c(int i) {
    }

    void m311c(int i, int i2) {
        if (i < 0) {
            m313d();
            this.f208L.m3106a(-i);
        } else if (i > 0) {
            m316e();
            this.f210N.m3106a(i);
        }
        if (i2 < 0) {
            m319f();
            this.f209M.m3106a(-i2);
        } else if (i2 > 0) {
            m323g();
            this.f211O.m3106a(i2);
        }
        if (i != 0 || i2 != 0) {
            ag.m2532d(this);
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0761i) && this.f224f.mo738a((C0761i) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return (this.f224f != null && this.f224f.mo719d()) ? this.f224f.mo717d(this.f226h) : 0;
    }

    public int computeHorizontalScrollOffset() {
        return (this.f224f != null && this.f224f.mo719d()) ? this.f224f.mo711b(this.f226h) : 0;
    }

    public int computeHorizontalScrollRange() {
        return (this.f224f != null && this.f224f.mo719d()) ? this.f224f.mo722f(this.f226h) : 0;
    }

    public int computeVerticalScrollExtent() {
        return (this.f224f != null && this.f224f.mo721e()) ? this.f224f.mo720e(this.f226h) : 0;
    }

    public int computeVerticalScrollOffset() {
        return (this.f224f != null && this.f224f.mo721e()) ? this.f224f.mo713c(this.f226h) : 0;
    }

    public int computeVerticalScrollRange() {
        return (this.f224f != null && this.f224f.mo721e()) ? this.f224f.mo723g(this.f226h) : 0;
    }

    public int m312d(View view) {
        C0801u c = m251c(view);
        return c != null ? c.m4577d() : -1;
    }

    void m313d() {
        if (this.f208L == null) {
            this.f208L = new C0576h(getContext());
            if (this.f231p) {
                this.f208L.m3102a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f208L.m3102a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m314d(int i) {
        if (this.f224f != null) {
            this.f224f.mo770k(i);
        }
        m310c(i);
        if (this.ae != null) {
            this.ae.m4450a(this, i);
        }
        if (this.af != null) {
            for (int size = this.af.size() - 1; size >= 0; size--) {
                ((C0791l) this.af.get(size)).m4450a(this, i);
            }
        }
    }

    void m315d(int i, int i2) {
        setMeasuredDimension(C0763h.m4079a(i, getPaddingLeft() + getPaddingRight(), ag.m2547o(this)), C0763h.m4079a(i2, getPaddingTop() + getPaddingBottom(), ag.m2548p(this)));
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m2912a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m2911a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m2915a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2914a(i, i2, i3, i4, iArr);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.f236u.size();
        for (i = 0; i < size; i++) {
            ((C0787g) this.f236u.get(i)).m4444b(canvas, this, this.f226h);
        }
        if (this.f208L == null || this.f208L.m3103a()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.f231p ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.f208L == null || !this.f208L.m3107a(canvas)) ? 0 : 1;
            canvas.restoreToCount(i);
        }
        if (!(this.f209M == null || this.f209M.m3103a())) {
            size = canvas.save();
            if (this.f231p) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.f209M == null || !this.f209M.m3107a(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f210N == null || this.f210N.m3103a())) {
            size = canvas.save();
            int width = getWidth();
            i = this.f231p ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.f210N == null || !this.f210N.m3107a(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.f211O == null || this.f211O.m3103a())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.f231p) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.f211O != null && this.f211O.m3107a(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.f225g == null || this.f236u.size() <= 0 || !this.f225g.mo798b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ag.m2532d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void m316e() {
        if (this.f210N == null) {
            this.f210N = new C0576h(getContext());
            if (this.f231p) {
                this.f210N.m3102a((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.f210N.m3102a(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void m317e(int i, int i2) {
        int i3;
        int c = this.f222d.m4910c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            C0801u c2 = m251c(this.f222d.m4911c(i6));
            if (c2 != null && c2.f2184b >= r3 && c2.f2184b <= r2) {
                if (c2.f2184b == i) {
                    c2.m4569a(i2 - i, false);
                } else {
                    c2.m4569a(i3, false);
                }
                this.f226h.f2169g = true;
            }
        }
        this.f220b.m4468a(i, i2);
        requestLayout();
    }

    public void m318e(View view) {
    }

    void m319f() {
        if (this.f209M == null) {
            this.f209M = new C0576h(getContext());
            if (this.f231p) {
                this.f209M.m3102a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f209M.m3102a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void m320f(int i, int i2) {
        int c = this.f222d.m4910c();
        for (int i3 = 0; i3 < c; i3++) {
            C0801u c2 = m251c(this.f222d.m4911c(i3));
            if (!(c2 == null || c2.m4576c() || c2.f2184b < i)) {
                c2.m4569a(i2, false);
                this.f226h.f2169g = true;
            }
        }
        this.f220b.m4476b(i, i2);
        requestLayout();
    }

    public void m321f(View view) {
    }

    public View focusSearch(View view, int i) {
        View d = this.f224f.m4168d(view, i);
        if (d != null) {
            return d;
        }
        d = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (!(d != null || this.f234s == null || this.f224f == null || m328j() || this.f199C)) {
            m306b();
            d = this.f224f.mo705a(view, i, this.f220b, this.f226h);
            m302a(false);
        }
        return d == null ? super.focusSearch(view, i) : d;
    }

    Rect m322g(View view) {
        C0761i c0761i = (C0761i) view.getLayoutParams();
        if (!c0761i.f2055c) {
            return c0761i.f2054b;
        }
        Rect rect = c0761i.f2054b;
        rect.set(0, 0, 0, 0);
        int size = this.f236u.size();
        for (int i = 0; i < size; i++) {
            this.f233r.set(0, 0, 0, 0);
            ((C0787g) this.f236u.get(i)).m4442a(this.f233r, view, this, this.f226h);
            rect.left += this.f233r.left;
            rect.top += this.f233r.top;
            rect.right += this.f233r.right;
            rect.bottom += this.f233r.bottom;
        }
        c0761i.f2055c = false;
        return rect;
    }

    void m323g() {
        if (this.f211O == null) {
            this.f211O = new C0576h(getContext());
            if (this.f231p) {
                this.f211O.m3102a((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.f211O.m3102a(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void m324g(int i, int i2) {
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.f224f != null) {
            return this.f224f.mo704a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.f224f != null) {
            return this.f224f.mo726a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        if (this.f224f != null) {
            return this.f224f.mo727a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public C0778a getAdapter() {
        return this.f234s;
    }

    public int getBaseline() {
        return this.f224f != null ? this.f224f.m4203s() : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.aj == null ? super.getChildDrawingOrder(i, i2) : this.aj.m4411a(i, i2);
    }

    public at getCompatAccessibilityDelegate() {
        return this.ai;
    }

    public C0785e getItemAnimator() {
        return this.f225g;
    }

    public C0763h getLayoutManager() {
        return this.f224f;
    }

    public int getMaxFlingVelocity() {
        return this.ab;
    }

    public int getMinFlingVelocity() {
        return this.aa;
    }

    public C0792m getRecycledViewPool() {
        return this.f220b.m4491f();
    }

    public int getScrollState() {
        return this.f212P;
    }

    void m325h() {
        this.f211O = null;
        this.f209M = null;
        this.f210N = null;
        this.f208L = null;
    }

    void m326h(int i, int i2) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        m324g(i, i2);
        if (this.ae != null) {
            this.ae.m4451a(this, i, i2);
        }
        if (this.af != null) {
            for (scrollY = this.af.size() - 1; scrollY >= 0; scrollY--) {
                ((C0791l) this.af.get(scrollY)).m4451a(this, i, i2);
            }
        }
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m2916b();
    }

    boolean m327i() {
        return this.f204H != null && this.f204H.isEnabled();
    }

    public boolean isAttachedToWindow() {
        return this.f239x;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m2910a();
    }

    public boolean m328j() {
        return this.f207K > 0;
    }

    void m329k() {
        if (this.f234s == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f224f == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.f226h.f2174l = false;
            if (this.f226h.f2165c == 1) {
                m217F();
                this.f224f.m4181f(this);
                m218G();
            } else if (!this.f221c.m5394f() && this.f224f.m4207w() == getWidth() && this.f224f.m4208x() == getHeight()) {
                this.f224f.m4181f(this);
            } else {
                this.f224f.m4181f(this);
                m218G();
            }
            m219H();
        }
    }

    void m330l() {
        int c = this.f222d.m4910c();
        for (int i = 0; i < c; i++) {
            ((C0761i) this.f222d.m4911c(i).getLayoutParams()).f2055c = true;
        }
        this.f220b.m4496j();
    }

    void m331m() {
        int c = this.f222d.m4910c();
        for (int i = 0; i < c; i++) {
            C0801u c2 = m251c(this.f222d.m4911c(i));
            if (!c2.m4576c()) {
                c2.m4574b();
            }
        }
    }

    void m332n() {
        int c = this.f222d.m4910c();
        for (int i = 0; i < c; i++) {
            C0801u c2 = m251c(this.f222d.m4911c(i));
            if (!c2.m4576c()) {
                c2.m4566a();
            }
        }
        this.f220b.m4495i();
    }

    void m333o() {
        int c = this.f222d.m4910c();
        for (int i = 0; i < c; i++) {
            C0801u c2 = m251c(this.f222d.m4911c(i));
            if (!(c2 == null || c2.m4576c())) {
                c2.m4575b(6);
            }
        }
        m330l();
        this.f220b.m4494h();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f207K = 0;
        this.f239x = true;
        this.f241z = false;
        if (this.f224f != null) {
            this.f224f.m4160c(this);
        }
        this.ah = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f225g != null) {
            this.f225g.mo800c();
        }
        this.f241z = false;
        m309c();
        this.f239x = false;
        if (this.f224f != null) {
            this.f224f.m4149b(this, this.f220b);
        }
        removeCallbacks(this.ap);
        this.f223e.m5291b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f236u.size();
        for (int i = 0; i < size; i++) {
            ((C0787g) this.f236u.get(i)).m4440a(canvas, this, this.f226h);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.f224f == null || this.f199C || (C0543s.m2900d(motionEvent) & 2) == 0 || motionEvent.getAction() != 8)) {
            float f = this.f224f.mo721e() ? -C0543s.m2901e(motionEvent, 9) : 0.0f;
            float e = this.f224f.mo719d() ? C0543s.m2901e(motionEvent, 10) : 0.0f;
            if (!(f == 0.0f && e == 0.0f)) {
                float scrollFactor = getScrollFactor();
                m303a((int) (e * scrollFactor), (int) (f * scrollFactor), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = -1;
        boolean z = true;
        if (this.f199C) {
            return false;
        }
        if (m240a(motionEvent)) {
            m291y();
            return true;
        } else if (this.f224f == null) {
            return false;
        } else {
            boolean d = this.f224f.mo719d();
            boolean e = this.f224f.mo721e();
            if (this.f214R == null) {
                this.f214R = VelocityTracker.obtain();
            }
            this.f214R.addMovement(motionEvent);
            int a = C0543s.m2893a(motionEvent);
            int b = C0543s.m2895b(motionEvent);
            int i2;
            switch (a) {
                case 0:
                    if (this.f200D) {
                        this.f200D = false;
                    }
                    this.f213Q = C0543s.m2896b(motionEvent, 0);
                    i = (int) (motionEvent.getX() + 0.5f);
                    this.f217U = i;
                    this.f215S = i;
                    i = (int) (motionEvent.getY() + 0.5f);
                    this.f218V = i;
                    this.f216T = i;
                    if (this.f212P == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.ao;
                    this.ao[1] = 0;
                    iArr[0] = 0;
                    i2 = d ? 1 : 0;
                    if (e) {
                        i2 |= 2;
                    }
                    startNestedScroll(i2);
                    break;
                case 1:
                    this.f214R.clear();
                    stopNestedScroll();
                    break;
                case 2:
                    a = C0543s.m2894a(motionEvent, this.f213Q);
                    if (a >= 0) {
                        b = (int) (C0543s.m2897c(motionEvent, a) + 0.5f);
                        a = (int) (C0543s.m2899d(motionEvent, a) + 0.5f);
                        if (this.f212P != 1) {
                            b -= this.f215S;
                            a -= this.f216T;
                            if (!d || Math.abs(b) <= this.f219W) {
                                d = false;
                            } else {
                                this.f217U = ((b < 0 ? -1 : 1) * this.f219W) + this.f215S;
                                d = true;
                            }
                            if (e && Math.abs(a) > this.f219W) {
                                i2 = this.f216T;
                                int i3 = this.f219W;
                                if (a >= 0) {
                                    i = 1;
                                }
                                this.f218V = i2 + (i * i3);
                                d = true;
                            }
                            if (d) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f213Q + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m291y();
                    break;
                case 5:
                    this.f213Q = C0543s.m2896b(motionEvent, b);
                    i2 = (int) (C0543s.m2897c(motionEvent, b) + 0.5f);
                    this.f217U = i2;
                    this.f215S = i2;
                    i2 = (int) (C0543s.m2899d(motionEvent, b) + 0.5f);
                    this.f218V = i2;
                    this.f216T = i2;
                    break;
                case 6:
                    m254c(motionEvent);
                    break;
            }
            if (this.f212P != 1) {
                z = false;
            }
            return z;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0344g.m1832a("RV OnLayout");
        m329k();
        C0344g.m1831a();
        this.f241z = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.f224f == null) {
            m315d(i, i2);
        } else if (this.f224f.f2060b) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.f224f.m4112a(this.f220b, this.f226h, i, i2);
            if (!z && this.f234s != null) {
                if (this.f226h.f2165c == 1) {
                    m217F();
                }
                this.f224f.m4105a(i, i2);
                this.f226h.f2174l = true;
                m218G();
                this.f224f.m4145b(i, i2);
                if (this.f224f.mo724k()) {
                    this.f224f.m4105a(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.f226h.f2174l = true;
                    m218G();
                    this.f224f.m4145b(i, i2);
                }
            }
        } else if (this.f240y) {
            this.f224f.m4112a(this.f220b, this.f226h, i, i2);
        } else {
            if (this.f202F) {
                m306b();
                m216E();
                if (this.f226h.f2172j) {
                    this.f226h.f2170h = true;
                } else {
                    this.f221c.m5393e();
                    this.f226h.f2170h = false;
                }
                this.f202F = false;
                m302a(false);
            }
            if (this.f234s != null) {
                this.f226h.f2163a = this.f234s.mo1796a();
            } else {
                this.f226h.f2163a = 0;
            }
            m306b();
            this.f224f.m4112a(this.f220b, this.f226h, i, i2);
            m302a(false);
            this.f226h.f2170h = false;
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f230o = (SavedState) parcelable;
            super.onRestoreInstanceState(this.f230o.getSuperState());
            if (this.f224f != null && this.f230o.f2119a != null) {
                this.f224f.mo706a(this.f230o.f2119a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f230o != null) {
            savedState.m4381a(this.f230o);
        } else if (this.f224f != null) {
            savedState.f2119a = this.f224f.mo714c();
        } else {
            savedState.f2119a = null;
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            m325h();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f199C || this.f200D) {
            return false;
        }
        if (m250b(motionEvent)) {
            m291y();
            return true;
        } else if (this.f224f == null) {
            return false;
        } else {
            boolean d = this.f224f.mo719d();
            boolean e = this.f224f.mo721e();
            if (this.f214R == null) {
                this.f214R = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int a = C0543s.m2893a(motionEvent);
            int b = C0543s.m2895b(motionEvent);
            if (a == 0) {
                int[] iArr = this.ao;
                this.ao[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.ao[0], (float) this.ao[1]);
            switch (a) {
                case 0:
                    this.f213Q = C0543s.m2896b(motionEvent, 0);
                    a = (int) (motionEvent.getX() + 0.5f);
                    this.f217U = a;
                    this.f215S = a;
                    a = (int) (motionEvent.getY() + 0.5f);
                    this.f218V = a;
                    this.f216T = a;
                    a = d ? 1 : 0;
                    if (e) {
                        a |= 2;
                    }
                    startNestedScroll(a);
                    break;
                case 1:
                    this.f214R.addMovement(obtain);
                    this.f214R.computeCurrentVelocity(1000, (float) this.ab);
                    float f = d ? -ae.m2317a(this.f214R, this.f213Q) : 0.0f;
                    float f2 = e ? -ae.m2318b(this.f214R, this.f213Q) : 0.0f;
                    if ((f == 0.0f && f2 == 0.0f) || !m308b((int) f, (int) f2)) {
                        setScrollState(0);
                    }
                    m290x();
                    z = true;
                    break;
                case 2:
                    a = C0543s.m2894a(motionEvent, this.f213Q);
                    if (a >= 0) {
                        int c = (int) (C0543s.m2897c(motionEvent, a) + 0.5f);
                        int d2 = (int) (C0543s.m2899d(motionEvent, a) + 0.5f);
                        int i = this.f217U - c;
                        a = this.f218V - d2;
                        if (dispatchNestedPreScroll(i, a, this.an, this.am)) {
                            i -= this.an[0];
                            a -= this.an[1];
                            obtain.offsetLocation((float) this.am[0], (float) this.am[1]);
                            int[] iArr2 = this.ao;
                            iArr2[0] = iArr2[0] + this.am[0];
                            iArr2 = this.ao;
                            iArr2[1] = iArr2[1] + this.am[1];
                        }
                        if (this.f212P != 1) {
                            boolean z2;
                            if (!d || Math.abs(i) <= this.f219W) {
                                z2 = false;
                            } else {
                                i = i > 0 ? i - this.f219W : i + this.f219W;
                                z2 = true;
                            }
                            if (e && Math.abs(a) > this.f219W) {
                                a = a > 0 ? a - this.f219W : a + this.f219W;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.f212P == 1) {
                            this.f217U = c - this.am[0];
                            this.f218V = d2 - this.am[1];
                            if (!d) {
                                i = 0;
                            }
                            if (!e) {
                                a = 0;
                            }
                            if (m303a(i, a, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f213Q + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    m291y();
                    break;
                case 5:
                    this.f213Q = C0543s.m2896b(motionEvent, b);
                    a = (int) (C0543s.m2897c(motionEvent, b) + 0.5f);
                    this.f217U = a;
                    this.f215S = a;
                    a = (int) (C0543s.m2899d(motionEvent, b) + 0.5f);
                    this.f218V = a;
                    this.f216T = a;
                    break;
                case 6:
                    m254c(motionEvent);
                    break;
            }
            if (!z) {
                this.f214R.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    public boolean m334p() {
        return !this.f241z || this.f206J || this.f221c.m5392d();
    }

    protected void removeDetachedView(View view, boolean z) {
        C0801u c = m251c(view);
        if (c != null) {
            if (c.m4591r()) {
                c.m4586m();
            } else if (!c.m4576c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + c);
            }
        }
        m268i(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.f224f.m4135a(this, this.f226h, view, view2) || view2 == null)) {
            this.f233r.set(0, 0, view2.getWidth(), view2.getHeight());
            LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof C0761i) {
                C0761i c0761i = (C0761i) layoutParams;
                if (!c0761i.f2055c) {
                    Rect rect = c0761i.f2054b;
                    Rect rect2 = this.f233r;
                    rect2.left -= rect.left;
                    rect2 = this.f233r;
                    rect2.right += rect.right;
                    rect2 = this.f233r;
                    rect2.top -= rect.top;
                    rect2 = this.f233r;
                    rect2.bottom = rect.bottom + rect2.bottom;
                }
            }
            offsetDescendantRectToMyCoords(view2, this.f233r);
            offsetRectIntoDescendantCoords(view, this.f233r);
            requestChildRectangleOnScreen(view, this.f233r, !this.f241z);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f224f.m4136a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.f237v.size();
        for (int i = 0; i < size; i++) {
            ((C0790k) this.f237v.get(i)).m4447a(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.f197A != 0 || this.f199C) {
            this.f198B = true;
        } else {
            super.requestLayout();
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.f224f == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f199C) {
            boolean d = this.f224f.mo719d();
            boolean e = this.f224f.mo721e();
            if (d || e) {
                if (!d) {
                    i = 0;
                }
                if (!e) {
                    i2 = 0;
                }
                m303a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!m304a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(at atVar) {
        this.ai = atVar;
        ag.m2517a((View) this, this.ai);
    }

    public void setAdapter(C0778a c0778a) {
        setLayoutFrozen(false);
        m226a(c0778a, false, true);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(C0781d c0781d) {
        if (c0781d != this.aj) {
            this.aj = c0781d;
            setChildrenDrawingOrderEnabled(this.aj != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.f231p) {
            m325h();
        }
        this.f231p = z;
        super.setClipToPadding(z);
        if (this.f241z) {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean z) {
        this.f240y = z;
    }

    public void setItemAnimator(C0785e c0785e) {
        if (this.f225g != null) {
            this.f225g.mo800c();
            this.f225g.m4420a(null);
        }
        this.f225g = c0785e;
        if (this.f225g != null) {
            this.f225g.m4420a(this.ag);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.f220b.m4467a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.f199C) {
            m301a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.f199C = true;
                this.f200D = true;
                m309c();
                return;
            }
            this.f199C = false;
            if (!(!this.f198B || this.f224f == null || this.f234s == null)) {
                requestLayout();
            }
            this.f198B = false;
        }
    }

    public void setLayoutManager(C0763h c0763h) {
        if (c0763h != this.f224f) {
            m309c();
            if (this.f224f != null) {
                if (this.f239x) {
                    this.f224f.m4149b(this, this.f220b);
                }
                this.f224f.m4147b(null);
            }
            this.f220b.m4466a();
            this.f222d.m4901a();
            this.f224f = c0763h;
            if (c0763h != null) {
                if (c0763h.f2067q != null) {
                    throw new IllegalArgumentException("LayoutManager " + c0763h + " is already attached to a RecyclerView: " + c0763h.f2067q);
                }
                this.f224f.m4147b(this);
                if (this.f239x) {
                    this.f224f.m4160c(this);
                }
            }
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().m2909a(z);
    }

    @Deprecated
    public void setOnScrollListener(C0791l c0791l) {
        this.ae = c0791l;
    }

    public void setRecycledViewPool(C0792m c0792m) {
        this.f220b.m4470a(c0792m);
    }

    public void setRecyclerListener(C0794o c0794o) {
        this.f235t = c0794o;
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.f219W = ar.m2640a(viewConfiguration);
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.f219W = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(C0799s c0799s) {
        this.f220b.m4471a(c0799s);
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m2913a(i);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().m2917c();
    }
}
