package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0051w;
import android.support.v4.view.C0081y;
import android.support.v4.view.C0124a;
import android.support.v4.view.C0543s;
import android.support.v4.view.C0547x;
import android.support.v4.view.C0548z;
import android.support.v4.view.ac;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.support.v4.view.p016a.C0413a;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.view.p016a.C0450l;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
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
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import java.util.List;

public class NestedScrollView extends FrameLayout implements ac, C0051w, C0081y {
    private static final C0550a f1298v = new C0550a();
    private static final int[] f1299w = new int[]{16843130};
    private C0551b f1300A;
    private long f1301a;
    private final Rect f1302b;
    private C0599u f1303c;
    private C0576h f1304d;
    private C0576h f1305e;
    private int f1306f;
    private boolean f1307g;
    private boolean f1308h;
    private View f1309i;
    private boolean f1310j;
    private VelocityTracker f1311k;
    private boolean f1312l;
    private boolean f1313m;
    private int f1314n;
    private int f1315o;
    private int f1316p;
    private int f1317q;
    private final int[] f1318r;
    private final int[] f1319s;
    private int f1320t;
    private SavedState f1321u;
    private final C0548z f1322x;
    private final C0547x f1323y;
    private float f1324z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C05491();
        public int f1297a;

        static class C05491 implements Creator<SavedState> {
            C05491() {
            }

            public SavedState m2921a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2922a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2921a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2922a(i);
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1297a = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1297a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1297a);
        }
    }

    static class C0550a extends C0124a {
        C0550a() {
        }

        public void mo113a(View view, C0426c c0426c) {
            super.mo113a(view, c0426c);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0426c.m2191a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    c0426c.m2193a(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0426c.m2188a(8192);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        c0426c.m2188a(4096);
                    }
                }
            }
        }

        public void mo114a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo114a(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0450l a = C0413a.m2088a(accessibilityEvent);
            a.m2296a(nestedScrollView.getScrollRange() > 0);
            a.m2299d(nestedScrollView.getScrollX());
            a.m2300e(nestedScrollView.getScrollY());
            a.m2301f(nestedScrollView.getScrollX());
            a.m2302g(nestedScrollView.getScrollRange());
        }

        public boolean mo284a(View view, int i, Bundle bundle) {
            if (super.mo284a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2952b(0, min);
                    return true;
                case 8192:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2952b(0, min);
                    return true;
                default:
                    return false;
            }
        }
    }

    public interface C0551b {
        void mo510a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1302b = new Rect();
        this.f1307g = true;
        this.f1308h = false;
        this.f1309i = null;
        this.f1310j = false;
        this.f1313m = true;
        this.f1317q = -1;
        this.f1318r = new int[2];
        this.f1319s = new int[2];
        m2929a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1299w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1322x = new C0548z(this);
        this.f1323y = new C0547x(this);
        setNestedScrollingEnabled(true);
        ag.m2517a((View) this, f1298v);
    }

    private View m2928a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    private void m2929a() {
        this.f1303c = C0599u.m3190a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1314n = viewConfiguration.getScaledTouchSlop();
        this.f1315o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1316p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void m2930a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (C0543s.m2896b(motionEvent, action) == this.f1317q) {
            action = action == 0 ? 1 : 0;
            this.f1306f = (int) C0543s.m2899d(motionEvent, action);
            this.f1317q = C0543s.m2896b(motionEvent, action);
            if (this.f1311k != null) {
                this.f1311k.clear();
            }
        }
    }

    private boolean m2931a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2928a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2943e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    private boolean m2932a(Rect rect, boolean z) {
        int a = m2947a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2948a(0, a);
            }
        }
        return z2;
    }

    private boolean m2933a(View view) {
        return !m2934a(view, 0, getHeight());
    }

    private boolean m2934a(View view, int i, int i2) {
        view.getDrawingRect(this.f1302b);
        offsetDescendantRectToMyCoords(view, this.f1302b);
        return this.f1302b.bottom + i >= getScrollY() && this.f1302b.top - i <= getScrollY() + i2;
    }

    private static boolean m2935a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2935a((View) parent, view2);
        return z;
    }

    private static int m2936b(int i, int i2, int i3) {
        return (i2 >= i3 || i < 0) ? 0 : i2 + i > i3 ? i3 - i2 : i;
    }

    private void m2937b(View view) {
        view.getDrawingRect(this.f1302b);
        offsetDescendantRectToMyCoords(view, this.f1302b);
        int a = m2947a(this.f1302b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2938b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
    }

    private void m2939c() {
        if (this.f1311k == null) {
            this.f1311k = VelocityTracker.obtain();
        } else {
            this.f1311k.clear();
        }
    }

    private boolean m2940c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    private void m2941d() {
        if (this.f1311k == null) {
            this.f1311k = VelocityTracker.obtain();
        }
    }

    private void m2942e() {
        if (this.f1311k != null) {
            this.f1311k.recycle();
            this.f1311k = null;
        }
    }

    private void m2943e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1313m) {
            m2948a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    private void m2944f() {
        this.f1310j = false;
        m2942e();
        stopNestedScroll();
        if (this.f1304d != null) {
            this.f1304d.m3109c();
            this.f1305e.m3109c();
        }
    }

    private void m2945f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2955d(i);
            }
        }
    }

    private void m2946g() {
        if (ag.m2509a(this) == 2) {
            this.f1304d = null;
            this.f1305e = null;
        } else if (this.f1304d == null) {
            Context context = getContext();
            this.f1304d = new C0576h(context);
            this.f1305e = new C0576h(context);
        }
    }

    private int getScrollRange() {
        return getChildCount() > 0 ? Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())) : 0;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1324z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1324z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1324z;
    }

    protected int m2947a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            scrollY = Math.min(rect.height() > height ? (rect.top - scrollY) + 0 : (rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            scrollY = Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
        return scrollY;
    }

    public final void m2948a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1301a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1303c.m3191a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ag.m2532d(this);
            } else {
                if (!this.f1303c.m3195a()) {
                    this.f1303c.m3203h();
                }
                scrollBy(i, i2);
            }
            this.f1301a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public boolean m2949a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1302b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1302b.top + height > childAt.getBottom()) {
                    this.f1302b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1302b.top = getScrollY() - height;
            if (this.f1302b.top < 0) {
                this.f1302b.top = 0;
            }
        }
        this.f1302b.bottom = this.f1302b.top + height;
        return m2931a(i, this.f1302b.top, this.f1302b.bottom);
    }

    boolean m2950a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = ag.m2509a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f1303c.m3196a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        return z2 || z3;
    }

    public boolean m2951a(KeyEvent keyEvent) {
        int i = 33;
        this.f1302b.setEmpty();
        if (m2938b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    return !keyEvent.isAltPressed() ? m2954c(33) : m2953b(33);
                case 20:
                    return !keyEvent.isAltPressed() ? m2954c(130) : m2953b(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2949a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            boolean z = (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) ? false : true;
            return z;
        }
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public final void m2952b(int i, int i2) {
        m2948a(i - getScrollX(), i2 - getScrollY());
    }

    public boolean m2953b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1302b.top = 0;
        this.f1302b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1302b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1302b.top = this.f1302b.bottom - height;
            }
        }
        return m2931a(i, this.f1302b.top, this.f1302b.bottom);
    }

    public boolean m2954c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2934a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2943e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1302b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1302b);
            m2943e(m2947a(this.f1302b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2933a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        if (this.f1303c.m3202g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1303c.m3197b();
            int c = this.f1303c.m3198c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ag.m2509a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m2950a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2946g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1304d.m3106a((int) this.f1303c.m3201f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1305e.m3106a((int) this.f1303c.m3201f());
                    }
                }
            }
        }
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > height ? bottom + (scrollY - height) : bottom;
    }

    public void m2955d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1303c.m3194a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ag.m2532d(this);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2951a(keyEvent);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1323y.m2912a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1323y.m2911a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1323y.m2915a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1323y.m2914a(i, i2, i3, i4, iArr);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1304d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1304d.m3103a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1304d.m3102a(width, getHeight());
                if (this.f1304d.m3107a(canvas)) {
                    ag.m2532d(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1305e.m3103a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.f1305e.m3102a(width, height);
                if (this.f1305e.m3107a(canvas)) {
                    ag.m2532d(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    public int getNestedScrollAxes() {
        return this.f1322x.m2918a();
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public boolean hasNestedScrollingParent() {
        return this.f1323y.m2916b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1323y.m2910a();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void onAttachedToWindow() {
        this.f1308h = false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((C0543s.m2900d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1310j) {
                    return false;
                }
                float e = C0543s.m2901e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1310j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m2940c((int) motionEvent.getX(), action)) {
                    this.f1310j = false;
                    m2942e();
                    break;
                }
                this.f1306f = action;
                this.f1317q = C0543s.m2896b(motionEvent, 0);
                m2939c();
                this.f1311k.addMovement(motionEvent);
                this.f1303c.m3202g();
                if (!this.f1303c.m3195a()) {
                    z = true;
                }
                this.f1310j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f1310j = false;
                this.f1317q = -1;
                m2942e();
                if (this.f1303c.m3196a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ag.m2532d(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f1317q;
                if (action != -1) {
                    int a = C0543s.m2894a(motionEvent, action);
                    if (a != -1) {
                        action = (int) C0543s.m2899d(motionEvent, a);
                        if (Math.abs(action - this.f1306f) > this.f1314n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1310j = true;
                            this.f1306f = action;
                            m2941d();
                            this.f1311k.addMovement(motionEvent);
                            this.f1320t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m2930a(motionEvent);
                break;
        }
        return this.f1310j;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1307g = false;
        if (this.f1309i != null && m2935a(this.f1309i, (View) this)) {
            m2937b(this.f1309i);
        }
        this.f1309i = null;
        if (!this.f1308h) {
            if (this.f1321u != null) {
                scrollTo(getScrollX(), this.f1321u.f1297a);
                this.f1321u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1308h = true;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1312l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2945f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1322x.m2920a(view, view2, i);
        startNestedScroll(2);
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        return (findNextFocus == null || m2933a(findNextFocus)) ? false : findNextFocus.requestFocus(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f1321u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1297a = getScrollY();
        return savedState;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1300A != null) {
            this.f1300A.mo510a(this, i, i2, i3, i4);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2934a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1302b);
            offsetDescendantRectToMyCoords(findFocus, this.f1302b);
            m2943e(m2947a(this.f1302b));
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f1322x.m2919a(view);
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2941d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0543s.m2893a(motionEvent);
        if (a == 0) {
            this.f1320t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1320t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f1303c.m3195a();
                    this.f1310j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1303c.m3195a()) {
                        this.f1303c.m3203h();
                    }
                    this.f1306f = (int) motionEvent.getY();
                    this.f1317q = C0543s.m2896b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.f1310j) {
                    VelocityTracker velocityTracker = this.f1311k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1316p);
                    a = (int) ae.m2318b(velocityTracker, this.f1317q);
                    if (Math.abs(a) > this.f1315o) {
                        m2945f(-a);
                    } else if (this.f1303c.m3196a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ag.m2532d(this);
                    }
                }
                this.f1317q = -1;
                m2944f();
                break;
            case 2:
                int a2 = C0543s.m2894a(motionEvent, this.f1317q);
                if (a2 != -1) {
                    int i;
                    int d = (int) C0543s.m2899d(motionEvent, a2);
                    a = this.f1306f - d;
                    if (dispatchNestedPreScroll(0, a, this.f1319s, this.f1318r)) {
                        a -= this.f1319s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1318r[1]);
                        this.f1320t += this.f1318r[1];
                    }
                    if (this.f1310j || Math.abs(a) <= this.f1314n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1310j = true;
                        i = a > 0 ? a - this.f1314n : a + this.f1314n;
                    }
                    if (this.f1310j) {
                        this.f1306f = d - this.f1318r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ag.m2509a(this);
                        Object obj = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : null;
                        if (m2950a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1311k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1318r)) {
                            if (obj != null) {
                                m2946g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1304d.m3105a(((float) i) / ((float) getHeight()), C0543s.m2897c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f1305e.m3103a()) {
                                        this.f1305e.m3109c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1305e.m3105a(((float) i) / ((float) getHeight()), 1.0f - (C0543s.m2897c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f1304d.m3103a()) {
                                        this.f1304d.m3109c();
                                    }
                                }
                                if (!(this.f1304d == null || (this.f1304d.m3103a() && this.f1305e.m3103a()))) {
                                    ag.m2532d(this);
                                    break;
                                }
                            }
                        }
                        this.f1306f -= this.f1318r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1318r[1]);
                        this.f1320t += this.f1318r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1317q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f1310j && getChildCount() > 0 && this.f1303c.m3196a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ag.m2532d(this);
                }
                this.f1317q = -1;
                m2944f();
                break;
            case 5:
                a = C0543s.m2895b(motionEvent);
                this.f1306f = (int) C0543s.m2899d(motionEvent, a);
                this.f1317q = C0543s.m2896b(motionEvent, a);
                break;
            case 6:
                m2930a(motionEvent);
                this.f1306f = (int) C0543s.m2899d(motionEvent, C0543s.m2894a(motionEvent, this.f1317q));
                break;
        }
        if (this.f1311k != null) {
            this.f1311k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1307g) {
            this.f1309i = view2;
        } else {
            m2937b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2932a(rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2942e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        this.f1307g = true;
        super.requestLayout();
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2936b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2936b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1312l) {
            this.f1312l = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1323y.m2909a(z);
    }

    public void setOnScrollChangeListener(C0551b c0551b) {
        this.f1300A = c0551b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1313m = z;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public boolean startNestedScroll(int i) {
        return this.f1323y.m2913a(i);
    }

    public void stopNestedScroll() {
        this.f1323y.m2917c();
    }
}
