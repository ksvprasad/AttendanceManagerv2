package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0052m;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.view.menu.C0727f.C0719b;
import android.support.v7.view.menu.C0730h;
import android.support.v7.widget.ao.C0752a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends ao implements C0719b, C0052m {
    private C0727f f2000a;
    private Context f2001b;
    private int f2002c;
    private boolean f2003d;
    private C0873d f2004e;
    private C0654a f2005f;
    private C0638a f2006g;
    private boolean f2007h;
    private int f2008i;
    private int f2009j;
    private int f2010k;
    private C0755e f2011l;

    public interface C0718a {
        boolean mo622c();

        boolean mo623d();
    }

    private class C0751b implements C0654a {
        final /* synthetic */ ActionMenuView f1990a;

        private C0751b(ActionMenuView actionMenuView) {
            this.f1990a = actionMenuView;
        }

        public void mo570a(C0727f c0727f, boolean z) {
        }

        public boolean mo571a(C0727f c0727f) {
            return false;
        }
    }

    public static class C0753c extends C0752a {
        @ExportedProperty
        public boolean f1993a;
        @ExportedProperty
        public int f1994b;
        @ExportedProperty
        public int f1995c;
        @ExportedProperty
        public boolean f1996d;
        @ExportedProperty
        public boolean f1997e;
        boolean f1998f;

        public C0753c(int i, int i2) {
            super(i, i2);
            this.f1993a = false;
        }

        public C0753c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0753c(C0753c c0753c) {
            super(c0753c);
            this.f1993a = c0753c.f1993a;
        }

        public C0753c(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class C0754d implements C0638a {
        final /* synthetic */ ActionMenuView f1999a;

        private C0754d(ActionMenuView actionMenuView) {
            this.f1999a = actionMenuView;
        }

        public void mo543a(C0727f c0727f) {
            if (this.f1999a.f2006g != null) {
                this.f1999a.f2006g.mo543a(c0727f);
            }
        }

        public boolean mo548a(C0727f c0727f, MenuItem menuItem) {
            return this.f1999a.f2011l != null && this.f1999a.f2011l.mo771a(menuItem);
        }
    }

    public interface C0755e {
        boolean mo771a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f2009j = (int) (56.0f * f);
        this.f2010k = (int) (f * 4.0f);
        this.f2001b = context;
        this.f2002c = 0;
    }

    static int m3994a(View view, int i, int i2, int i3, int i4) {
        int i5;
        boolean z = false;
        C0753c c0753c = (C0753c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m3737b();
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z2 && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0753c.f1993a && z2) {
            z = true;
        }
        c0753c.f1996d = z;
        c0753c.f1994b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    private void m3997c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f2009j;
        size = i3 % this.f2009j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        Object obj;
        int i5 = this.f2009j + (size / i4);
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        paddingLeft = 0;
        Object obj2 = null;
        long j = 0;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            int i10;
            long j2;
            int i11;
            int i12;
            int i13;
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                i10 = paddingLeft;
                j2 = j;
                i11 = i6;
                i12 = i4;
                i4 = i7;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i13 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f2010k, 0, this.f2010k, 0);
                }
                C0753c c0753c = (C0753c) childAt.getLayoutParams();
                c0753c.f1998f = false;
                c0753c.f1995c = 0;
                c0753c.f1994b = 0;
                c0753c.f1996d = false;
                c0753c.leftMargin = 0;
                c0753c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m3737b();
                c0753c.f1997e = z2;
                int a = m3994a(childAt, i5, c0753c.f1993a ? 1 : i4, childMeasureSpec, paddingTop);
                i7 = Math.max(i7, a);
                paddingLeft = c0753c.f1996d ? i8 + 1 : i8;
                obj = c0753c.f1993a ? 1 : obj2;
                int i14 = i4 - a;
                i8 = Math.max(i6, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i9)) | j;
                    i11 = i8;
                    i12 = i14;
                    i8 = paddingLeft;
                    obj2 = obj;
                    j2 = j3;
                    i4 = i7;
                    i10 = i13;
                } else {
                    i10 = i13;
                    i4 = i7;
                    long j4 = j;
                    i11 = i8;
                    i12 = i14;
                    obj2 = obj;
                    i8 = paddingLeft;
                    j2 = j4;
                }
            }
            i9++;
            i7 = i4;
            i6 = i11;
            i4 = i12;
            j = j2;
            paddingLeft = i10;
        }
        Object obj3 = (obj2 == null || paddingLeft != 2) ? null : 1;
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i8 > 0 && paddingTop > 0) {
            i13 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0753c = (C0753c) getChildAt(i15).getLayoutParams();
                if (!c0753c.f1996d) {
                    size = i4;
                    i4 = i13;
                } else if (c0753c.f1994b < i13) {
                    i4 = c0753c.f1994b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0753c.f1994b == i13) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i13;
                } else {
                    size = i4;
                    i4 = i13;
                }
                i15++;
                i13 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i13 + 1;
            i13 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i13 < childCount) {
                View childAt2 = getChildAt(i13);
                c0753c = (C0753c) childAt2.getLayoutParams();
                if ((((long) (1 << i13)) & j) != 0) {
                    if (obj3 != null && c0753c.f1997e && i4 == 1) {
                        childAt2.setPadding(this.f2010k + i5, 0, this.f2010k, 0);
                    }
                    c0753c.f1994b++;
                    c0753c.f1998f = true;
                    size = i4 - 1;
                } else if (c0753c.f1994b == i15) {
                    j6 |= (long) (1 << i13);
                    size = i4;
                } else {
                    size = i4;
                }
                i13++;
                i4 = size;
            }
            j5 = j6;
            i9 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj2 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i7 <= 1)) {
            obj3 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0753c) getChildAt(0).getLayoutParams()).f1997e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0753c) getChildAt(childCount - 1).getLayoutParams()).f1997e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i5)) / f) : 0;
                    i4 = 0;
                    obj3 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj3;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0753c = (C0753c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0753c.f1995c = paddingLeft;
                                c0753c.f1998f = true;
                                if (i4 == 0 && !c0753c.f1997e) {
                                    c0753c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0753c.f1993a) {
                                if (i4 != 0) {
                                    c0753c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0753c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj3;
                            } else {
                                c0753c.f1995c = paddingLeft;
                                c0753c.f1998f = true;
                                c0753c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj3 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj3 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0753c = (C0753c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0753c.f1995c = paddingLeft;
                        c0753c.f1998f = true;
                        c0753c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0753c.f1993a) {
                        if (i4 != 0) {
                            c0753c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0753c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj3;
                    } else {
                        c0753c.f1995c = paddingLeft;
                        c0753c.f1998f = true;
                        c0753c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj3;
                }
                i4++;
                obj3 = obj;
            }
        }
        if (obj3 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0753c = (C0753c) childAt.getLayoutParams();
                if (c0753c.f1998f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0753c.f1995c + (c0753c.f1994b * i5), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i6 = size2;
        }
        setMeasuredDimension(i3, i6);
    }

    public C0753c m3998a(AttributeSet attributeSet) {
        return new C0753c(getContext(), attributeSet);
    }

    protected C0753c m3999a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m4005b();
        }
        C0753c c0753c = layoutParams instanceof C0753c ? new C0753c((C0753c) layoutParams) : new C0753c(layoutParams);
        if (c0753c.h > 0) {
            return c0753c;
        }
        c0753c.h = 16;
        return c0753c;
    }

    public void mo37a(C0727f c0727f) {
        this.f2000a = c0727f;
    }

    public void m4001a(C0654a c0654a, C0638a c0638a) {
        this.f2005f = c0654a;
        this.f2006g = c0638a;
    }

    public boolean m4002a() {
        return this.f2003d;
    }

    protected boolean m4003a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0718a)) {
            z = 0 | ((C0718a) childAt).mo623d();
        }
        return (i <= 0 || !(childAt2 instanceof C0718a)) ? z : ((C0718a) childAt2).mo622c() | z;
    }

    public boolean mo624a(C0730h c0730h) {
        return this.f2000a.m3822a((MenuItem) c0730h, 0);
    }

    protected C0753c m4005b() {
        C0753c c0753c = new C0753c(-2, -2);
        c0753c.h = 16;
        return c0753c;
    }

    public /* synthetic */ C0752a mo685b(AttributeSet attributeSet) {
        return m3998a(attributeSet);
    }

    protected /* synthetic */ C0752a mo686b(LayoutParams layoutParams) {
        return m3999a(layoutParams);
    }

    public C0753c m4008c() {
        C0753c b = m4005b();
        b.f1993a = true;
        return b;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0753c);
    }

    public C0727f m4009d() {
        return this.f2000a;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean m4010e() {
        return this.f2004e != null && this.f2004e.m5342d();
    }

    public boolean m4011f() {
        return this.f2004e != null && this.f2004e.m5343e();
    }

    public boolean m4012g() {
        return this.f2004e != null && this.f2004e.m5346h();
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m4005b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3998a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3999a(layoutParams);
    }

    public Menu getMenu() {
        if (this.f2000a == null) {
            Context context = getContext();
            this.f2000a = new C0727f(context);
            this.f2000a.mo658a(new C0754d());
            this.f2004e = new C0873d(context);
            this.f2004e.m5340c(true);
            this.f2004e.m3769a(this.f2005f != null ? this.f2005f : new C0751b());
            this.f2000a.m3817a(this.f2004e, this.f2001b);
            this.f2004e.m5332a(this);
        }
        return this.f2000a;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f2004e.m5339c();
    }

    public int getPopupTheme() {
        return this.f2002c;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean m4013h() {
        return this.f2004e != null && this.f2004e.m5347i();
    }

    public void m4014i() {
        if (this.f2004e != null) {
            this.f2004e.m5344f();
        }
    }

    protected /* synthetic */ C0752a mo691j() {
        return m4005b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f2004e != null) {
            this.f2004e.mo640b(false);
            if (this.f2004e.m5346h()) {
                this.f2004e.m5343e();
                this.f2004e.m5342d();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m4014i();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2007h) {
            int i5;
            int i6;
            C0753c c0753c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bl.m5302a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0753c = (C0753c) childAt.getLayoutParams();
                    if (c0753c.f1993a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m4003a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0753c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0753c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0753c.leftMargin) + c0753c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m4003a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0753c = (C0753c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0753c.f1993a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0753c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0753c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0753c = (C0753c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0753c.f1993a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0753c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0753c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f2007h;
        this.f2007h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f2007h) {
            this.f2008i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f2007h || this.f2000a == null || size == this.f2008i)) {
            this.f2008i = size;
            this.f2000a.m3828b(true);
        }
        int childCount = getChildCount();
        if (!this.f2007h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0753c c0753c = (C0753c) getChildAt(i3).getLayoutParams();
                c0753c.rightMargin = 0;
                c0753c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m3997c(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f2004e.m5341d(z);
    }

    public void setOnMenuItemClickListener(C0755e c0755e) {
        this.f2011l = c0755e;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f2004e.m5329a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f2003d = z;
    }

    public void setPopupTheme(int i) {
        if (this.f2002c != i) {
            this.f2002c = i;
            if (i == 0) {
                this.f2001b = getContext();
            } else {
                this.f2001b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0873d c0873d) {
        this.f2004e = c0873d;
        this.f2004e.m5332a(this);
    }
}
