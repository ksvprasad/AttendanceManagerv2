package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.C0048a.C0043e;
import android.support.design.C0048a.C0046h;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.AppBarLayout.C0063b;
import android.support.design.widget.C0170v.C0054c;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.p010b.C0195a;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.bd;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class CollapsingToolbarLayout extends FrameLayout {
    private boolean f311a;
    private int f312b;
    private Toolbar f313c;
    private View f314d;
    private View f315e;
    private int f316f;
    private int f317g;
    private int f318h;
    private int f319i;
    private final Rect f320j;
    private final C0135d f321k;
    private boolean f322l;
    private boolean f323m;
    private Drawable f324n;
    private Drawable f325o;
    private int f326p;
    private boolean f327q;
    private C0170v f328r;
    private C0063b f329s;
    private int f330t;
    private bd f331u;

    class C00691 implements aa {
        final /* synthetic */ CollapsingToolbarLayout f306a;

        C00691(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f306a = collapsingToolbarLayout;
        }

        public bd mo38a(View view, bd bdVar) {
            return this.f306a.m527a(bdVar);
        }
    }

    class C00702 implements C0054c {
        final /* synthetic */ CollapsingToolbarLayout f307a;

        C00702(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f307a = collapsingToolbarLayout;
        }

        public void mo39a(C0170v c0170v) {
            this.f307a.setScrimAlpha(c0170v.m1083c());
        }
    }

    public static class C0071a extends LayoutParams {
        int f308a = 0;
        float f309b = 0.5f;

        public C0071a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.CollapsingAppBarLayout_LayoutParams);
            this.f308a = obtainStyledAttributes.getInt(C0047i.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
            m522a(obtainStyledAttributes.getFloat(C0047i.f165xad49a364, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public C0071a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0071a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void m522a(float f) {
            this.f309b = f;
        }
    }

    private class C0072b implements C0063b {
        final /* synthetic */ CollapsingToolbarLayout f310a;

        private C0072b(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f310a = collapsingToolbarLayout;
        }

        public void mo75a(AppBarLayout appBarLayout, int i) {
            boolean z = false;
            this.f310a.f330t = i;
            int b = this.f310a.f331u != null ? this.f310a.f331u.mo443b() : 0;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int childCount = this.f310a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f310a.getChildAt(i2);
                C0071a c0071a = (C0071a) childAt.getLayoutParams();
                ab a = CollapsingToolbarLayout.m537d(childAt);
                switch (c0071a.f308a) {
                    case 1:
                        if ((this.f310a.getHeight() - b) + i < childAt.getHeight()) {
                            break;
                        }
                        a.m882a(-i);
                        break;
                    case 2:
                        a.m882a(Math.round(c0071a.f309b * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            if (!(this.f310a.f324n == null && this.f310a.f325o == null)) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.f310a;
                if (this.f310a.getHeight() + i < this.f310a.getScrimTriggerOffset() + b) {
                    z = true;
                }
                collapsingToolbarLayout.setScrimsShown(z);
            }
            if (this.f310a.f325o != null && b > 0) {
                ag.m2532d(this.f310a);
            }
            this.f310a.f321k.m921b(((float) Math.abs(i)) / ((float) ((this.f310a.getHeight() - ag.m2548p(this.f310a)) - b)));
            if (Math.abs(i) == totalScrollRange) {
                ag.m2533d((View) appBarLayout, appBarLayout.getTargetElevation());
            } else {
                ag.m2533d((View) appBarLayout, 0.0f);
            }
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f311a = true;
        this.f320j = new Rect();
        C0164u.m1053a(context);
        this.f321k = new C0135d(this);
        this.f321k.m918a(C0127a.f540e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.CollapsingToolbarLayout, i, C0046h.Widget_Design_CollapsingToolbar);
        this.f321k.m927c(obtainStyledAttributes.getInt(C0047i.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.f321k.m930d(obtainStyledAttributes.getInt(C0047i.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0047i.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f319i = dimensionPixelSize;
        this.f318h = dimensionPixelSize;
        this.f317g = dimensionPixelSize;
        this.f316f = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(C0047i.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f316f = obtainStyledAttributes.getDimensionPixelSize(C0047i.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(C0047i.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f318h = obtainStyledAttributes.getDimensionPixelSize(C0047i.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(C0047i.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f317g = obtainStyledAttributes.getDimensionPixelSize(C0047i.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(C0047i.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.f319i = obtainStyledAttributes.getDimensionPixelSize(C0047i.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.f322l = obtainStyledAttributes.getBoolean(C0047i.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(C0047i.CollapsingToolbarLayout_title));
        this.f321k.m934f(C0046h.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.f321k.m932e(C0046h.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(C0047i.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.f321k.m934f(obtainStyledAttributes.getResourceId(C0047i.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(C0047i.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.f321k.m932e(obtainStyledAttributes.getResourceId(C0047i.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        setContentScrim(obtainStyledAttributes.getDrawable(C0047i.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(C0047i.CollapsingToolbarLayout_statusBarScrim));
        this.f312b = obtainStyledAttributes.getResourceId(C0047i.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ag.m2518a((View) this, new C00691(this));
    }

    private bd m527a(bd bdVar) {
        if (this.f331u != bdVar) {
            this.f331u = bdVar;
            requestLayout();
        }
        return bdVar.mo447f();
    }

    private void m528a(int i) {
        m533b();
        if (this.f328r == null) {
            this.f328r = ac.m890a();
            this.f328r.m1077a(600);
            this.f328r.m1081a(i > this.f326p ? C0127a.f538c : C0127a.f539d);
            this.f328r.m1080a(new C00702(this));
        } else if (this.f328r.m1082b()) {
            this.f328r.m1085e();
        }
        this.f328r.m1078a(this.f326p, i);
        this.f328r.m1075a();
    }

    private View m532b(View view) {
        CollapsingToolbarLayout parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    private void m533b() {
        if (this.f311a) {
            this.f313c = null;
            this.f314d = null;
            if (this.f312b != -1) {
                this.f313c = (Toolbar) findViewById(this.f312b);
                if (this.f313c != null) {
                    this.f314d = m532b(this.f313c);
                }
            }
            if (this.f313c == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                toolbar = null;
                this.f313c = toolbar;
            }
            m536c();
            this.f311a = false;
        }
    }

    private static int m534c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    private void m536c() {
        if (!(this.f322l || this.f315e == null)) {
            ViewParent parent = this.f315e.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f315e);
            }
        }
        if (this.f322l && this.f313c != null) {
            if (this.f315e == null) {
                this.f315e = new View(getContext());
            }
            if (this.f315e.getParent() == null) {
                this.f313c.addView(this.f315e, -1, -1);
            }
        }
    }

    private static ab m537d(View view) {
        ab abVar = (ab) view.getTag(C0043e.view_offset_helper);
        if (abVar != null) {
            return abVar;
        }
        abVar = new ab(view);
        view.setTag(C0043e.view_offset_helper, abVar);
        return abVar;
    }

    private void setScrimAlpha(int i) {
        if (i != this.f326p) {
            if (!(this.f324n == null || this.f313c == null)) {
                ag.m2532d(this.f313c);
            }
            this.f326p = i;
            ag.m2532d(this);
        }
    }

    protected C0071a m539a() {
        return new C0071a(super.generateDefaultLayoutParams());
    }

    protected LayoutParams m540a(ViewGroup.LayoutParams layoutParams) {
        return new C0071a(layoutParams);
    }

    public void m541a(boolean z, boolean z2) {
        int i = 255;
        if (this.f327q != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m528a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.f327q = z;
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0071a;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m533b();
        if (this.f313c == null && this.f324n != null && this.f326p > 0) {
            this.f324n.mutate().setAlpha(this.f326p);
            this.f324n.draw(canvas);
        }
        if (this.f322l && this.f323m) {
            this.f321k.m916a(canvas);
        }
        if (this.f325o != null && this.f326p > 0) {
            int b = this.f331u != null ? this.f331u.mo443b() : 0;
            if (b > 0) {
                this.f325o.setBounds(0, -this.f330t, getWidth(), b - this.f330t);
                this.f325o.mutate().setAlpha(this.f326p);
                this.f325o.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        m533b();
        if (view == this.f313c && this.f324n != null && this.f326p > 0) {
            this.f324n.mutate().setAlpha(this.f326p);
            this.f324n.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f325o;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f324n;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m539a();
    }

    protected /* synthetic */ LayoutParams m12900generateDefaultLayoutParams() {
        return m539a();
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m540a(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0071a(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.f321k.m926c();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f321k.m929d();
    }

    public Drawable getContentScrim() {
        return this.f324n;
    }

    public int getExpandedTitleGravity() {
        return this.f321k.m920b();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f319i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f318h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f316f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f317g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f321k.m931e();
    }

    final int getScrimTriggerOffset() {
        return ag.m2548p(this) * 2;
    }

    public Drawable getStatusBarScrim() {
        return this.f325o;
    }

    public CharSequence getTitle() {
        return this.f322l ? this.f321k.m937i() : null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f329s == null) {
                this.f329s = new C0072b();
            }
            ((AppBarLayout) parent).m463a(this.f329s);
        }
        ag.m2551s(this);
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.f329s != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m465b(this.f329s);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f322l && this.f315e != null) {
            boolean z2 = ag.m2505C(this.f315e) && this.f315e.getVisibility() == 0;
            this.f323m = z2;
            if (this.f323m) {
                i5 = (this.f314d == null || this.f314d == this) ? 0 : ((C0071a) this.f314d.getLayoutParams()).bottomMargin;
                C0180y.m1120b(this, this.f315e, this.f320j);
                this.f321k.m923b(this.f320j.left, (i4 - this.f320j.height()) - i5, this.f320j.right, i4 - i5);
                if (ag.m2540h(this) != 1) {
                    i6 = 0;
                }
                this.f321k.m915a(i6 != 0 ? this.f318h : this.f316f, this.f320j.bottom + this.f317g, (i3 - i) - (i6 != 0 ? this.f316f : this.f318h), (i4 - i2) - this.f319i);
                this.f321k.m936h();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            View childAt = getChildAt(i7);
            if (!(this.f331u == null || ag.m2552t(childAt))) {
                int b = this.f331u.mo443b();
                if (childAt.getTop() < b) {
                    ag.m2536e(childAt, b);
                }
            }
            m537d(childAt).m881a();
            i7++;
        }
        if (this.f313c != null) {
            if (this.f322l && TextUtils.isEmpty(this.f321k.m937i())) {
                this.f321k.m919a(this.f313c.getTitle());
            }
            if (this.f314d == null || this.f314d == this) {
                setMinimumHeight(m534c(this.f313c));
            } else {
                setMinimumHeight(m534c(this.f314d));
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m533b();
        super.onMeasure(i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f324n != null) {
            this.f324n.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.f321k.m930d(i);
    }

    public void setCollapsedTitleTextAppearance(int i) {
        this.f321k.m932e(i);
    }

    public void setCollapsedTitleTextColor(int i) {
        this.f321k.m914a(i);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f321k.m917a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f324n != drawable) {
            if (this.f324n != null) {
                this.f324n.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f324n = drawable2;
            if (this.f324n != null) {
                this.f324n.setBounds(0, 0, getWidth(), getHeight());
                this.f324n.setCallback(this);
                this.f324n.setAlpha(this.f326p);
            }
            ag.m2532d(this);
        }
    }

    public void setContentScrimColor(int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(int i) {
        setContentScrim(C0195a.m1224a(getContext(), i));
    }

    public void setExpandedTitleColor(int i) {
        this.f321k.m922b(i);
    }

    public void setExpandedTitleGravity(int i) {
        this.f321k.m927c(i);
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f319i = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f318h = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f316f = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f317g = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i) {
        this.f321k.m934f(i);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f321k.m924b(typeface);
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = ag.m2503A(this) && !isInEditMode();
        m541a(z, z2);
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = null;
        if (this.f325o != drawable) {
            if (this.f325o != null) {
                this.f325o.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.f325o = drawable2;
            if (this.f325o != null) {
                if (this.f325o.isStateful()) {
                    this.f325o.setState(getDrawableState());
                }
                C0314a.m1771b(this.f325o, ag.m2540h(this));
                this.f325o.setVisible(getVisibility() == 0, false);
                this.f325o.setCallback(this);
                this.f325o.setAlpha(this.f326p);
            }
            ag.m2532d(this);
        }
    }

    public void setStatusBarScrimColor(int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(int i) {
        setStatusBarScrim(C0195a.m1224a(getContext(), i));
    }

    public void setTitle(CharSequence charSequence) {
        this.f321k.m919a(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f322l) {
            this.f322l = z;
            m536c();
            requestLayout();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.f325o == null || this.f325o.isVisible() == z)) {
            this.f325o.setVisible(z, false);
        }
        if (this.f324n != null && this.f324n.isVisible() != z) {
            this.f324n.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f324n || drawable == this.f325o;
    }
}
