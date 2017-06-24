package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.C0048a.C0046h;
import android.support.design.C0048a.C0047i;
import android.support.design.widget.C0170v.C0054c;
import android.support.design.widget.CoordinatorLayout.C0059b;
import android.support.design.widget.CoordinatorLayout.C0076c;
import android.support.design.widget.CoordinatorLayout.C0078e;
import android.support.v4.p006e.C0056d;
import android.support.v4.p006e.C0341c;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@C0076c(a = Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean f274a;
    private int f275b;
    private int f276c;
    private int f277d;
    private float f278e;
    private int f279f;
    private bd f280g;
    private final List<C0063b> f281h;

    class C00531 implements aa {
        final /* synthetic */ AppBarLayout f242a;

        C00531(AppBarLayout appBarLayout) {
            this.f242a = appBarLayout;
        }

        public bd mo38a(View view, bd bdVar) {
            return this.f242a.m446a(bdVar);
        }
    }

    public static class Behavior extends C0060l<AppBarLayout> {
        private int f259a;
        private boolean f260b;
        private boolean f261c;
        private C0170v f262d;
        private int f263e = -1;
        private boolean f264f;
        private float f265g;
        private WeakReference<View> f266h;
        private C0058a f267i;

        protected static class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = C0341c.m1829a(new C00571());
            int f246a;
            float f247b;
            boolean f248c;

            static class C00571 implements C0056d<SavedState> {
                C00571() {
                }

                public SavedState m343a(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                public SavedState[] m344a(int i) {
                    return new SavedState[i];
                }

                public /* synthetic */ Object mo40b(Parcel parcel, ClassLoader classLoader) {
                    return m343a(parcel, classLoader);
                }

                public /* synthetic */ Object[] mo41b(int i) {
                    return m344a(i);
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel);
                this.f246a = parcel.readInt();
                this.f247b = parcel.readFloat();
                this.f248c = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f246a);
                parcel.writeFloat(this.f247b);
                parcel.writeByte((byte) (this.f248c ? 1 : 0));
            }
        }

        public static abstract class C0058a {
            public abstract boolean m347a(AppBarLayout appBarLayout);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int m385a(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (childAt.getTop() <= (-i) && childAt.getBottom() >= (-i)) {
                    return i2;
                }
            }
            return -1;
        }

        private static boolean m386a(int i, int i2) {
            return (i & i2) == i2;
        }

        private int m387b(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = appBarLayout.getChildAt(i2);
                C0062a c0062a = (C0062a) childAt.getLayoutParams();
                Interpolator b = c0062a.m443b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i2++;
                } else if (b == null) {
                    return i;
                } else {
                    int height;
                    i2 = c0062a.m442a();
                    if ((i2 & 1) != 0) {
                        height = (c0062a.bottomMargin + (childAt.getHeight() + c0062a.topMargin)) + 0;
                        if ((i2 & 2) != 0) {
                            height -= ag.m2548p(childAt);
                        }
                    } else {
                        height = 0;
                    }
                    if (ag.m2552t(childAt)) {
                        height -= appBarLayout.getTopInset();
                    }
                    if (height <= 0) {
                        return i;
                    }
                    return Integer.signum(i) * (Math.round(b.getInterpolation(((float) (abs - childAt.getTop())) / ((float) height)) * ((float) height)) + childAt.getTop());
                }
            }
            return i;
        }

        private void m388b(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int a = mo45a();
            if (a != i) {
                if (this.f262d == null) {
                    this.f262d = ac.m890a();
                    this.f262d.m1081a(C0127a.f540e);
                    this.f262d.m1080a(new C0054c(this) {
                        final /* synthetic */ Behavior f245c;

                        public void mo39a(C0170v c0170v) {
                            this.f245c.a_(coordinatorLayout, appBarLayout, c0170v.m1083c());
                        }
                    });
                } else {
                    this.f262d.m1085e();
                }
                this.f262d.m1077a(Math.round(((((float) Math.abs(a - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.f262d.m1078a(a, i);
                this.f262d.m1075a();
            } else if (this.f262d != null && this.f262d.m1082b()) {
                this.f262d.m1085e();
            }
        }

        private void m389c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int a = mo45a();
            int a2 = m385a(appBarLayout, a);
            if (a2 >= 0) {
                View childAt = appBarLayout.getChildAt(a2);
                int a3 = ((C0062a) childAt.getLayoutParams()).m442a();
                if ((a3 & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (a2 == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (m386a(a3, 2)) {
                        i2 += ag.m2548p(childAt);
                        a2 = i;
                    } else if (m386a(a3, 5)) {
                        a2 = ag.m2548p(childAt) + i2;
                        if (a >= a2) {
                            i2 = a2;
                            a2 = i;
                        }
                    } else {
                        a2 = i;
                    }
                    if (a >= (i2 + a2) / 2) {
                        i2 = a2;
                    }
                    m388b(coordinatorLayout, appBarLayout, C0152n.m1009a(i2, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        private void m390d(AppBarLayout appBarLayout) {
            List i = appBarLayout.f281h;
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0063b c0063b = (C0063b) i.get(i2);
                if (c0063b != null) {
                    c0063b.mo75a(appBarLayout, mo57b());
                }
            }
        }

        int mo45a() {
            return mo57b() + this.f259a;
        }

        int m392a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int a = mo45a();
            if (i2 == 0 || a < i2 || a > i3) {
                this.f259a = 0;
                return 0;
            }
            int a2 = C0152n.m1009a(i, i2, i3);
            if (a == a2) {
                return 0;
            }
            int b = appBarLayout.m451c() ? m387b(appBarLayout, a2) : a2;
            boolean a3 = mo53a(b);
            a -= a2;
            this.f259a = a2 - b;
            if (!a3 && appBarLayout.m451c()) {
                coordinatorLayout.m605c((View) appBarLayout);
            }
            m390d(appBarLayout);
            return a;
        }

        /* synthetic */ int mo47a(View view) {
            return m420c((AppBarLayout) view);
        }

        void m395a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            m389c(coordinatorLayout, appBarLayout);
        }

        public void m396a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.mo49a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.f263e = savedState.f246a;
                this.f265g = savedState.f247b;
                this.f264f = savedState.f248c;
                return;
            }
            super.mo49a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.f263e = -1;
        }

        public void m397a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!this.f261c) {
                m389c(coordinatorLayout, appBarLayout);
            }
            this.f260b = false;
            this.f261c = false;
            this.f266h = new WeakReference(view);
        }

        public void m398a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4) {
            if (i4 < 0) {
                m380b(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
                this.f260b = true;
                return;
            }
            this.f260b = false;
        }

        public void m399a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr) {
            if (i2 != 0 && !this.f260b) {
                int i3;
                int b;
                if (i2 < 0) {
                    i3 = -appBarLayout.getTotalScrollRange();
                    b = i3 + appBarLayout.getDownNestedPreScrollRange();
                } else {
                    i3 = -appBarLayout.getUpNestedPreScrollRange();
                    b = 0;
                }
                iArr[1] = m380b(coordinatorLayout, appBarLayout, i2, i3, b);
            }
        }

        boolean m406a(AppBarLayout appBarLayout) {
            if (this.f267i != null) {
                return this.f267i.m347a(appBarLayout);
            }
            if (this.f266h == null) {
                return true;
            }
            View view = (View) this.f266h.get();
            return (view == null || !view.isShown() || ag.m2527b(view, -1)) ? false : true;
        }

        public boolean m407a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            boolean a = super.mo42a(coordinatorLayout, appBarLayout, i);
            int f = appBarLayout.getPendingAction();
            if (f != 0) {
                int i2 = (f & 4) != 0 ? 1 : 0;
                if ((f & 2) != 0) {
                    f = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        m388b(coordinatorLayout, appBarLayout, f);
                    } else {
                        a_(coordinatorLayout, appBarLayout, f);
                    }
                } else if ((f & 1) != 0) {
                    if (i2 != 0) {
                        m388b(coordinatorLayout, appBarLayout, 0);
                    } else {
                        a_(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.f263e >= 0) {
                View childAt = appBarLayout.getChildAt(this.f263e);
                f = -childAt.getBottom();
                mo53a(this.f264f ? ag.m2548p(childAt) + f : Math.round(((float) childAt.getHeight()) * this.f265g) + f);
            }
            appBarLayout.m455e();
            this.f263e = -1;
            mo53a(C0152n.m1009a(mo57b(), -appBarLayout.getTotalScrollRange(), 0));
            m390d(appBarLayout);
            return a;
        }

        public boolean m408a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((C0078e) appBarLayout.getLayoutParams()).height != -2) {
                return super.mo54a(coordinatorLayout, (View) appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.m593a(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean m409a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f, float f2, boolean z) {
            boolean z2 = false;
            if (!z) {
                z2 = m378a(coordinatorLayout, (View) appBarLayout, -appBarLayout.getTotalScrollRange(), 0, -f2);
            } else if (f2 < 0.0f) {
                r1 = (-appBarLayout.getTotalScrollRange()) + appBarLayout.getDownNestedPreScrollRange();
                if (mo45a() < r1) {
                    m388b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            } else {
                r1 = -appBarLayout.getUpNestedPreScrollRange();
                if (mo45a() > r1) {
                    m388b(coordinatorLayout, appBarLayout, r1);
                    z2 = true;
                }
            }
            this.f261c = z2;
            return z2;
        }

        public boolean m410a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i) {
            boolean z = (i & 2) != 0 && appBarLayout.m453d() && coordinatorLayout.getHeight() - view.getHeight() <= appBarLayout.getHeight();
            if (z && this.f262d != null) {
                this.f262d.m1085e();
            }
            this.f266h = null;
            return z;
        }

        public /* bridge */ /* synthetic */ int mo57b() {
            return super.mo57b();
        }

        int m416b(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        public Parcelable m418b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z = false;
            Parcelable b = super.mo59b(coordinatorLayout, appBarLayout);
            int b2 = mo57b();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + b2;
                if (childAt.getTop() + b2 > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.f246a = i;
                    if (bottom == ag.m2548p(childAt)) {
                        z = true;
                    }
                    savedState.f248c = z;
                    savedState.f247b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        int m420c(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        /* synthetic */ boolean mo60c(View view) {
            return m406a((AppBarLayout) view);
        }
    }

    public static class ScrollingViewBehavior extends C0061m {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.ScrollingViewBehavior_Params);
            m428b(obtainStyledAttributes.getDimensionPixelSize(C0047i.ScrollingViewBehavior_Params_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int m431a(AppBarLayout appBarLayout) {
            C0059b b = ((C0078e) appBarLayout.getLayoutParams()).m558b();
            return b instanceof Behavior ? ((Behavior) b).mo45a() : 0;
        }

        private void m432e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            C0059b b = ((C0078e) view2.getLayoutParams()).m558b();
            if (b instanceof Behavior) {
                Behavior behavior = (Behavior) b;
                behavior.mo45a();
                ag.m2536e(view, ((behavior.f259a + (view2.getBottom() - view.getTop())) + m424a()) - m430c(view2));
            }
        }

        float mo62a(View view) {
            if (!(view instanceof AppBarLayout)) {
                return 0.0f;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int b = appBarLayout.getDownNestedPreScrollRange();
            int a = m431a(appBarLayout);
            if (b != 0 && totalScrollRange + a <= b) {
                return 0.0f;
            }
            totalScrollRange -= b;
            return totalScrollRange != 0 ? 1.0f + (((float) a) / ((float) totalScrollRange)) : 0.0f;
        }

        View mo63a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean mo42a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.mo42a(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean mo54a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.mo54a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ int mo57b() {
            return super.mo57b();
        }

        int mo64b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.mo64b(view);
        }

        public boolean mo65b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean mo66c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m432e(coordinatorLayout, view, view2);
            return false;
        }
    }

    public static class C0062a extends LayoutParams {
        int f272a = 1;
        Interpolator f273b;

        public C0062a(int i, int i2) {
            super(i, i2);
        }

        public C0062a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.AppBarLayout_LayoutParams);
            this.f272a = obtainStyledAttributes.getInt(C0047i.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C0047i.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
                this.f273b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0047i.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public C0062a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0062a(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0062a(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int m442a() {
            return this.f272a;
        }

        public Interpolator m443b() {
            return this.f273b;
        }
    }

    public interface C0063b {
        void mo75a(AppBarLayout appBarLayout, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f275b = -1;
        this.f276c = -1;
        this.f277d = -1;
        this.f279f = 0;
        setOrientation(1);
        C0164u.m1053a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.AppBarLayout, 0, C0046h.Widget_Design_AppBarLayout);
        this.f278e = (float) obtainStyledAttributes.getDimensionPixelSize(C0047i.AppBarLayout_elevation, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(C0047i.AppBarLayout_android_background));
        if (obtainStyledAttributes.hasValue(C0047i.AppBarLayout_expanded)) {
            setExpanded(obtainStyledAttributes.getBoolean(C0047i.AppBarLayout_expanded, false));
        }
        obtainStyledAttributes.recycle();
        ac.m891a(this);
        this.f281h = new ArrayList();
        ag.m2533d((View) this, this.f278e);
        ag.m2518a((View) this, new C00531(this));
    }

    private bd m446a(bd bdVar) {
        bd bdVar2 = null;
        if (ag.m2552t(this)) {
            bdVar2 = bdVar;
        }
        if (bdVar2 != this.f280g) {
            this.f280g = bdVar2;
            m449b();
        }
        return bdVar;
    }

    private void m449b() {
        this.f275b = -1;
        this.f276c = -1;
        this.f277d = -1;
    }

    private boolean m451c() {
        return this.f274a;
    }

    private boolean m453d() {
        return getTotalScrollRange() != 0;
    }

    private void m455e() {
        this.f279f = 0;
    }

    private int getDownNestedPreScrollRange() {
        if (this.f276c != -1) {
            return this.f276c;
        }
        int i;
        int childCount = getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C0062a c0062a = (C0062a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0062a.f272a;
            if ((i3 & 5) == 5) {
                i = (c0062a.bottomMargin + c0062a.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + ag.m2548p(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - ag.m2548p(childAt)) : i + measuredHeight;
            } else if (i2 > 0) {
                break;
            } else {
                i = i2;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2 - getTopInset());
        this.f276c = i;
        return i;
    }

    private int getDownNestedScrollRange() {
        if (this.f277d != -1) {
            return this.f277d;
        }
        int i;
        int childCount = getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            C0062a c0062a = (C0062a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (c0062a.topMargin + c0062a.bottomMargin);
            i = c0062a.f272a;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (ag.m2548p(childAt) + getTopInset());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        this.f277d = i;
        return i;
    }

    private int getPendingAction() {
        return this.f279f;
    }

    private int getTopInset() {
        return this.f280g != null ? this.f280g.mo443b() : 0;
    }

    private int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    protected C0062a m460a() {
        return new C0062a(-1, -2);
    }

    public C0062a m461a(AttributeSet attributeSet) {
        return new C0062a(getContext(), attributeSet);
    }

    protected C0062a m462a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new C0062a((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new C0062a((MarginLayoutParams) layoutParams) : new C0062a(layoutParams);
    }

    public void m463a(C0063b c0063b) {
        if (c0063b != null && !this.f281h.contains(c0063b)) {
            this.f281h.add(c0063b);
        }
    }

    public void m464a(boolean z, boolean z2) {
        this.f279f = (z2 ? 4 : 0) | (z ? 1 : 2);
        requestLayout();
    }

    public void m465b(C0063b c0063b) {
        if (c0063b != null) {
            this.f281h.remove(c0063b);
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0062a;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m460a();
    }

    protected /* synthetic */ LayoutParams m12897generateDefaultLayoutParams() {
        return m460a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m461a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m462a(layoutParams);
    }

    public /* synthetic */ LayoutParams m12898generateLayoutParams(AttributeSet attributeSet) {
        return m461a(attributeSet);
    }

    protected /* synthetic */ LayoutParams m12899generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m462a(layoutParams);
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int p = ag.m2548p(this);
        if (p != 0) {
            return topInset + (p * 2);
        }
        p = getChildCount();
        return p >= 1 ? topInset + (ag.m2548p(getChildAt(p - 1)) * 2) : 0;
    }

    public float getTargetElevation() {
        return this.f278e;
    }

    public final int getTotalScrollRange() {
        if (this.f275b != -1) {
            return this.f275b;
        }
        int p;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0062a c0062a = (C0062a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0062a.f272a;
            if ((i3 & 1) == 0) {
                break;
            }
            i += c0062a.bottomMargin + (measuredHeight + c0062a.topMargin);
            if ((i3 & 2) != 0) {
                p = i - ag.m2548p(childAt);
                break;
            }
        }
        p = i;
        p = Math.max(0, p - getTopInset());
        this.f275b = p;
        return p;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m449b();
        this.f274a = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((C0062a) getChildAt(i5).getLayoutParams()).m443b() != null) {
                this.f274a = true;
                return;
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m449b();
    }

    public void setExpanded(boolean z) {
        m464a(z, ag.m2503A(this));
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setTargetElevation(float f) {
        this.f278e = f;
    }
}
