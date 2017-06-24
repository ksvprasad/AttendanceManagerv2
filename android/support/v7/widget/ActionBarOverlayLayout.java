package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0081y;
import android.support.v4.view.C0548z;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v4.view.bb;
import android.support.v4.widget.C0599u;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.view.menu.C0721l.C0654a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements C0081y, ai {
    static final int[] f1962a = new int[]{C0683a.actionBarSize, 16842841};
    private final Runnable f1963A;
    private final C0548z f1964B;
    private int f1965b;
    private int f1966c;
    private ContentFrameLayout f1967d;
    private ActionBarContainer f1968e;
    private aj f1969f;
    private Drawable f1970g;
    private boolean f1971h;
    private boolean f1972i;
    private boolean f1973j;
    private boolean f1974k;
    private boolean f1975l;
    private int f1976m;
    private int f1977n;
    private final Rect f1978o;
    private final Rect f1979p;
    private final Rect f1980q;
    private final Rect f1981r;
    private final Rect f1982s;
    private final Rect f1983t;
    private C0681a f1984u;
    private final int f1985v;
    private C0599u f1986w;
    private aw f1987x;
    private final ba f1988y;
    private final Runnable f1989z;

    public interface C0681a {
        void mo612a(int i);

        void mo615h(boolean z);

        void mo616l();

        void mo617m();

        void mo618n();

        void mo619o();
    }

    class C07461 extends bb {
        final /* synthetic */ ActionBarOverlayLayout f1959a;

        C07461(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1959a = actionBarOverlayLayout;
        }

        public void mo99b(View view) {
            this.f1959a.f1987x = null;
            this.f1959a.f1975l = false;
        }

        public void mo100c(View view) {
            this.f1959a.f1987x = null;
            this.f1959a.f1975l = false;
        }
    }

    class C07472 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1960a;

        C07472(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1960a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1960a.m3971k();
            this.f1960a.f1987x = ag.m2549q(this.f1960a.f1968e).m2735c(0.0f).m2729a(this.f1960a.f1988y);
        }
    }

    class C07483 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1961a;

        C07483(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1961a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1961a.m3971k();
            this.f1961a.f1987x = ag.m2549q(this.f1961a.f1968e).m2735c((float) (-this.f1961a.f1968e.getHeight())).m2729a(this.f1961a.f1988y);
        }
    }

    public static class C0749b extends MarginLayoutParams {
        public C0749b(int i, int i2) {
            super(i, i2);
        }

        public C0749b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0749b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1966c = 0;
        this.f1978o = new Rect();
        this.f1979p = new Rect();
        this.f1980q = new Rect();
        this.f1981r = new Rect();
        this.f1982s = new Rect();
        this.f1983t = new Rect();
        this.f1985v = 600;
        this.f1988y = new C07461(this);
        this.f1989z = new C07472(this);
        this.f1963A = new C07483(this);
        m3964a(context);
        this.f1964B = new C0548z(this);
    }

    private aj m3963a(View view) {
        if (view instanceof aj) {
            return (aj) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void m3964a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1962a);
        this.f1965b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1970g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1970g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1971h = z;
        this.f1986w = C0599u.m3189a(context);
    }

    private boolean m3966a(float f, float f2) {
        this.f1986w.m3193a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1986w.m3200e() > this.f1968e.getHeight();
    }

    private boolean m3968a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0749b c0749b = (C0749b) view.getLayoutParams();
        if (z && c0749b.leftMargin != rect.left) {
            c0749b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0749b.topMargin != rect.top) {
            c0749b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0749b.rightMargin != rect.right) {
            c0749b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0749b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0749b.bottomMargin = rect.bottom;
        return true;
    }

    private void m3971k() {
        removeCallbacks(this.f1989z);
        removeCallbacks(this.f1963A);
        if (this.f1987x != null) {
            this.f1987x.m2734b();
        }
    }

    private void m3972l() {
        m3971k();
        postDelayed(this.f1989z, 600);
    }

    private void m3973m() {
        m3971k();
        postDelayed(this.f1963A, 600);
    }

    private void m3974n() {
        m3971k();
        this.f1989z.run();
    }

    private void m3975o() {
        m3971k();
        this.f1963A.run();
    }

    public C0749b m3976a(AttributeSet attributeSet) {
        return new C0749b(getContext(), attributeSet);
    }

    public void mo674a(int i) {
        m3981c();
        switch (i) {
            case 2:
                this.f1969f.mo843f();
                return;
            case 5:
                this.f1969f.mo844g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void mo675a(Menu menu, C0654a c0654a) {
        m3981c();
        this.f1969f.mo831a(menu, c0654a);
    }

    public boolean m3979a() {
        return this.f1972i;
    }

    protected C0749b m3980b() {
        return new C0749b(-1, -1);
    }

    void m3981c() {
        if (this.f1967d == null) {
            this.f1967d = (ContentFrameLayout) findViewById(C0688f.action_bar_activity_content);
            this.f1968e = (ActionBarContainer) findViewById(C0688f.action_bar_container);
            this.f1969f = m3963a(findViewById(C0688f.action_bar));
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0749b;
    }

    public boolean mo676d() {
        m3981c();
        return this.f1969f.mo845h();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1970g != null && !this.f1971h) {
            int bottom = this.f1968e.getVisibility() == 0 ? (int) ((((float) this.f1968e.getBottom()) + ag.m2546n(this.f1968e)) + 0.5f) : 0;
            this.f1970g.setBounds(0, bottom, getWidth(), this.f1970g.getIntrinsicHeight() + bottom);
            this.f1970g.draw(canvas);
        }
    }

    public boolean mo677e() {
        m3981c();
        return this.f1969f.mo846i();
    }

    public boolean mo678f() {
        m3981c();
        return this.f1969f.mo847j();
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m3981c();
        if ((ag.m2550r(this) & 256) != 0) {
            a = m3968a(this.f1968e, rect, true, true, false, true);
            this.f1981r.set(rect);
            bl.m5301a(this, this.f1981r, this.f1978o);
        } else {
            a = m3968a(this.f1968e, rect, true, true, false, true);
            this.f1981r.set(rect);
            bl.m5301a(this, this.f1981r, this.f1978o);
        }
        if (!this.f1979p.equals(this.f1978o)) {
            this.f1979p.set(this.f1978o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    public boolean mo679g() {
        m3981c();
        return this.f1969f.mo848k();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3980b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3976a(attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0749b(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.f1968e != null ? -((int) ag.m2546n(this.f1968e)) : 0;
    }

    public int getNestedScrollAxes() {
        return this.f1964B.m2918a();
    }

    public CharSequence getTitle() {
        m3981c();
        return this.f1969f.mo842e();
    }

    public boolean mo680h() {
        m3981c();
        return this.f1969f.mo849l();
    }

    public void mo681i() {
        m3981c();
        this.f1969f.mo850m();
    }

    public void mo682j() {
        m3981c();
        this.f1969f.mo851n();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m3964a(getContext());
        ag.m2551s(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3971k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0749b c0749b = (C0749b) childAt.getLayoutParams();
                int i6 = c0749b.leftMargin + paddingLeft;
                paddingRight = c0749b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        m3981c();
        measureChildWithMargins(this.f1968e, i, 0, i2, 0);
        C0749b c0749b = (C0749b) this.f1968e.getLayoutParams();
        int max = Math.max(0, (this.f1968e.getMeasuredWidth() + c0749b.leftMargin) + c0749b.rightMargin);
        int max2 = Math.max(0, c0749b.bottomMargin + (this.f1968e.getMeasuredHeight() + c0749b.topMargin));
        int a = bl.m5300a(0, ag.m2542j(this.f1968e));
        Object obj = (ag.m2550r(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f1965b;
            if (this.f1973j && this.f1968e.getTabContainer() != null) {
                i3 += this.f1965b;
            }
        } else {
            i3 = this.f1968e.getVisibility() != 8 ? this.f1968e.getMeasuredHeight() : 0;
        }
        this.f1980q.set(this.f1978o);
        this.f1982s.set(this.f1981r);
        Rect rect;
        Rect rect2;
        if (this.f1972i || obj != null) {
            rect = this.f1982s;
            rect.top = i3 + rect.top;
            rect2 = this.f1982s;
            rect2.bottom += 0;
        } else {
            rect = this.f1980q;
            rect.top = i3 + rect.top;
            rect2 = this.f1980q;
            rect2.bottom += 0;
        }
        m3968a(this.f1967d, this.f1980q, true, true, true, true);
        if (!this.f1983t.equals(this.f1982s)) {
            this.f1983t.set(this.f1982s);
            this.f1967d.m3495a(this.f1982s);
        }
        measureChildWithMargins(this.f1967d, i, 0, i2, 0);
        c0749b = (C0749b) this.f1967d.getLayoutParams();
        int max3 = Math.max(max, (this.f1967d.getMeasuredWidth() + c0749b.leftMargin) + c0749b.rightMargin);
        i3 = Math.max(max2, c0749b.bottomMargin + (this.f1967d.getMeasuredHeight() + c0749b.topMargin));
        int a2 = bl.m5300a(a, ag.m2542j(this.f1967d));
        setMeasuredDimension(ag.m2508a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ag.m2508a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1974k || !z) {
            return false;
        }
        if (m3966a(f, f2)) {
            m3975o();
        } else {
            m3974n();
        }
        this.f1975l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1976m += i2;
        setActionBarHideOffset(this.f1976m);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1964B.m2920a(view, view2, i);
        this.f1976m = getActionBarHideOffset();
        m3971k();
        if (this.f1984u != null) {
            this.f1984u.mo618n();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.f1968e.getVisibility() != 0) ? false : this.f1974k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1974k && !this.f1975l) {
            if (this.f1976m <= this.f1968e.getHeight()) {
                m3972l();
            } else {
                m3973m();
            }
        }
        if (this.f1984u != null) {
            this.f1984u.mo619o();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3981c();
        int i2 = this.f1977n ^ i;
        this.f1977n = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.f1984u != null) {
            C0681a c0681a = this.f1984u;
            if (z3) {
                z = false;
            }
            c0681a.mo615h(z);
            if (z2 || !z3) {
                this.f1984u.mo616l();
            } else {
                this.f1984u.mo617m();
            }
        }
        if ((i2 & 256) != 0 && this.f1984u != null) {
            ag.m2551s(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1966c = i;
        if (this.f1984u != null) {
            this.f1984u.mo612a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m3971k();
        ag.m2524b(this.f1968e, (float) (-Math.max(0, Math.min(i, this.f1968e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(C0681a c0681a) {
        this.f1984u = c0681a;
        if (getWindowToken() != null) {
            this.f1984u.mo612a(this.f1966c);
            if (this.f1977n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1977n);
                ag.m2551s(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1973j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1974k) {
            this.f1974k = z;
            if (!z) {
                m3971k();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        m3981c();
        this.f1969f.mo827a(i);
    }

    public void setIcon(Drawable drawable) {
        m3981c();
        this.f1969f.mo828a(drawable);
    }

    public void setLogo(int i) {
        m3981c();
        this.f1969f.mo836b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1972i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1971h = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Callback callback) {
        m3981c();
        this.f1969f.mo832a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m3981c();
        this.f1969f.mo833a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
