package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.view.C0503d;
import android.support.v4.view.C0503d.C0501a;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0689g;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p023g.C0703a;
import android.support.v7.view.C0704a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0717b;
import android.support.v7.view.menu.C0052m;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.view.menu.C0722b;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0730h;
import android.support.v7.view.menu.C0739k;
import android.support.v7.view.menu.C0742p;
import android.support.v7.widget.ActionMenuView.C0718a;
import android.support.v7.widget.ap.C0715b;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class C0873d extends C0722b implements C0501a {
    private C0866b f2640A;
    final C0872f f2641g = new C0872f();
    int f2642h;
    private C0870d f2643i;
    private Drawable f2644j;
    private boolean f2645k;
    private boolean f2646l;
    private boolean f2647m;
    private int f2648n;
    private int f2649o;
    private int f2650p;
    private boolean f2651q;
    private boolean f2652r;
    private boolean f2653s;
    private boolean f2654t;
    private int f2655u;
    private final SparseBooleanArray f2656v = new SparseBooleanArray();
    private View f2657w;
    private C0871e f2658x;
    private C0865a f2659y;
    private C0867c f2660z;

    private class C0865a extends C0739k {
        final /* synthetic */ C0873d f2627c;
        private C0742p f2628d;

        public C0865a(C0873d c0873d, Context context, C0742p c0742p) {
            boolean z = false;
            this.f2627c = c0873d;
            super(context, c0742p, null, false, C0683a.actionOverflowMenuStyle);
            this.f2628d = c0742p;
            if (!((C0730h) c0742p.getItem()).m3878j()) {
                m3911a(c0873d.f2643i == null ? (View) c0873d.f : c0873d.f2643i);
            }
            m3910a(c0873d.f2641g);
            int size = c0742p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0742p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            m3912a(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.f2627c.f2659y = null;
            this.f2627c.f2642h = 0;
        }
    }

    private class C0866b extends C0717b {
        final /* synthetic */ C0873d f2629a;

        private C0866b(C0873d c0873d) {
            this.f2629a = c0873d;
        }

        public ap mo857a() {
            return this.f2629a.f2659y != null ? this.f2629a.f2659y.m3918c() : null;
        }
    }

    private class C0867c implements Runnable {
        final /* synthetic */ C0873d f2630a;
        private C0871e f2631b;

        public C0867c(C0873d c0873d, C0871e c0871e) {
            this.f2630a = c0873d;
            this.f2631b = c0871e;
        }

        public void run() {
            this.f2630a.c.m3837f();
            View view = (View) this.f2630a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f2631b.m3919d())) {
                this.f2630a.f2658x = this.f2631b;
            }
            this.f2630a.f2660z = null;
        }
    }

    private class C0870d extends C0869q implements C0718a {
        final /* synthetic */ C0873d f2636a;
        private final float[] f2637b = new float[2];

        public C0870d(final C0873d c0873d, Context context) {
            this.f2636a = c0873d;
            super(context, null, C0683a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C0715b(this, this) {
                final /* synthetic */ C0870d f2633b;

                public ap mo620a() {
                    return this.f2633b.f2636a.f2658x == null ? null : this.f2633b.f2636a.f2658x.m3918c();
                }

                public boolean mo621b() {
                    this.f2633b.f2636a.m5342d();
                    return true;
                }

                public boolean mo858c() {
                    if (this.f2633b.f2636a.f2660z != null) {
                        return false;
                    }
                    this.f2633b.f2636a.m5343e();
                    return true;
                }
            });
        }

        public boolean mo622c() {
            return false;
        }

        public boolean mo623d() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f2636a.m5342d();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0314a.m1765a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class C0871e extends C0739k {
        final /* synthetic */ C0873d f2638c;

        public C0871e(C0873d c0873d, Context context, C0727f c0727f, View view, boolean z) {
            this.f2638c = c0873d;
            super(context, c0727f, view, z, C0683a.actionOverflowMenuStyle);
            m3907a(8388613);
            m3910a(c0873d.f2641g);
        }

        public void onDismiss() {
            super.onDismiss();
            if (this.f2638c.c != null) {
                this.f2638c.c.close();
            }
            this.f2638c.f2658x = null;
        }
    }

    private class C0872f implements C0654a {
        final /* synthetic */ C0873d f2639a;

        private C0872f(C0873d c0873d) {
            this.f2639a = c0873d;
        }

        public void mo570a(C0727f c0727f, boolean z) {
            if (c0727f instanceof C0742p) {
                ((C0742p) c0727f).mo664p().m3820a(false);
            }
            C0654a a = this.f2639a.m3762a();
            if (a != null) {
                a.mo570a(c0727f, z);
            }
        }

        public boolean mo571a(C0727f c0727f) {
            if (c0727f == null) {
                return false;
            }
            this.f2639a.f2642h = ((C0742p) c0727f).getItem().getItemId();
            C0654a a = this.f2639a.m3762a();
            return a != null ? a.mo571a(c0727f) : false;
        }
    }

    public C0873d(Context context) {
        super(context, C0690h.abc_action_menu_layout, C0690h.abc_action_menu_item_layout);
    }

    private View m5316a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0050a) && ((C0050a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public C0052m mo859a(ViewGroup viewGroup) {
        C0052m a = super.mo859a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View mo860a(C0730h c0730h, View view, ViewGroup viewGroup) {
        View actionView = c0730h.getActionView();
        if (actionView == null || c0730h.m3882n()) {
            actionView = super.mo860a(c0730h, view, viewGroup);
        }
        actionView.setVisibility(c0730h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3999a(layoutParams));
        }
        return actionView;
    }

    public void mo636a(Context context, C0727f c0727f) {
        super.mo636a(context, c0727f);
        Resources resources = context.getResources();
        C0704a a = C0704a.m3646a(context);
        if (!this.f2647m) {
            this.f2646l = a.m3648b();
        }
        if (!this.f2653s) {
            this.f2648n = a.m3649c();
        }
        if (!this.f2651q) {
            this.f2650p = a.m3647a();
        }
        int i = this.f2648n;
        if (this.f2646l) {
            if (this.f2643i == null) {
                this.f2643i = new C0870d(this, this.a);
                if (this.f2645k) {
                    this.f2643i.setImageDrawable(this.f2644j);
                    this.f2644j = null;
                    this.f2645k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2643i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2643i.getMeasuredWidth();
        } else {
            this.f2643i = null;
        }
        this.f2649o = i;
        this.f2655u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2657w = null;
    }

    public void m5328a(Configuration configuration) {
        if (!this.f2651q) {
            this.f2650p = this.b.getResources().getInteger(C0689g.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m3828b(true);
        }
    }

    public void m5329a(Drawable drawable) {
        if (this.f2643i != null) {
            this.f2643i.setImageDrawable(drawable);
            return;
        }
        this.f2645k = true;
        this.f2644j = drawable;
    }

    public void mo637a(C0727f c0727f, boolean z) {
        m5344f();
        super.mo637a(c0727f, z);
    }

    public void mo861a(C0730h c0730h, C0050a c0050a) {
        c0050a.mo27a(c0730h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0050a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2640A == null) {
            this.f2640A = new C0866b();
        }
        actionMenuItemView.setPopupCallback(this.f2640A);
    }

    public void m5332a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo37a(this.c);
    }

    public void mo862a(boolean z) {
        if (z) {
            super.mo639a(null);
        } else {
            this.c.m3820a(false);
        }
    }

    public boolean mo863a(int i, C0730h c0730h) {
        return c0730h.m3878j();
    }

    public boolean mo639a(C0742p c0742p) {
        if (!c0742p.hasVisibleItems()) {
            return false;
        }
        C0742p c0742p2 = c0742p;
        while (c0742p2.m3933s() != this.c) {
            c0742p2 = (C0742p) c0742p2.m3933s();
        }
        View a = m5316a(c0742p2.getItem());
        if (a == null) {
            if (this.f2643i == null) {
                return false;
            }
            a = this.f2643i;
        }
        this.f2642h = c0742p.getItem().getItemId();
        this.f2659y = new C0865a(this, this.b, c0742p);
        this.f2659y.m3911a(a);
        this.f2659y.m3906a();
        super.mo639a(c0742p);
        return true;
    }

    public boolean mo864a(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.f2643i ? false : super.mo864a(viewGroup, i);
    }

    public void mo640b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0703a.m3645a(viewGroup);
        }
        super.mo640b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m3842k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0503d a = ((C0730h) k.get(i)).mo627a();
                if (a != null) {
                    a.m2781a((C0501a) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m3843l() : null;
        if (this.f2646l && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0730h) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2643i == null) {
                this.f2643i = new C0870d(this, this.a);
            }
            viewGroup = (ViewGroup) this.f2643i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2643i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2643i, actionMenuView.m4008c());
            }
        } else if (this.f2643i != null && this.f2643i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2643i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2646l);
    }

    public boolean mo641b() {
        int i;
        ArrayList i2 = this.c.m3840i();
        int size = i2.size();
        int i3 = this.f2650p;
        int i4 = this.f2649o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0730h c0730h = (C0730h) i2.get(i7);
            if (c0730h.m3880l()) {
                i5++;
            } else if (c0730h.m3879k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.f2654t && c0730h.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.f2646l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f2656v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2652r) {
            i = i4 / this.f2655u;
            i6 = ((i4 % this.f2655u) / i) + this.f2655u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0730h = (C0730h) i2.get(i8);
            int i10;
            if (c0730h.m3880l()) {
                View a = mo860a(c0730h, this.f2657w, viewGroup);
                if (this.f2657w == null) {
                    this.f2657w = a;
                }
                if (this.f2652r) {
                    i9 -= ActionMenuView.m3994a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0730h.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0730h.m3871d(true);
                i = i10;
                i3 = i7;
            } else if (c0730h.m3879k()) {
                boolean z;
                int groupId = c0730h.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f2652r || i9 > 0);
                if (z3) {
                    View a2 = mo860a(c0730h, this.f2657w, viewGroup);
                    if (this.f2657w == null) {
                        this.f2657w = a2;
                    }
                    boolean z4;
                    if (this.f2652r) {
                        int a3 = ActionMenuView.m3994a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f2652r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0730h c0730h2 = (C0730h) i2.get(i7);
                        if (c0730h2.getGroupId() == groupId) {
                            if (c0730h2.m3878j()) {
                                i5++;
                            }
                            c0730h2.m3871d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0730h.m3871d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0730h.m3871d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public Drawable m5339c() {
        return this.f2643i != null ? this.f2643i.getDrawable() : this.f2645k ? this.f2644j : null;
    }

    public void m5340c(boolean z) {
        this.f2646l = z;
        this.f2647m = true;
    }

    public void m5341d(boolean z) {
        this.f2654t = z;
    }

    public boolean m5342d() {
        if (!this.f2646l || m5346h() || this.c == null || this.f == null || this.f2660z != null || this.c.m3843l().isEmpty()) {
            return false;
        }
        this.f2660z = new C0867c(this, new C0871e(this, this.b, this.c, this.f2643i, true));
        ((View) this.f).post(this.f2660z);
        super.mo639a(null);
        return true;
    }

    public boolean m5343e() {
        if (this.f2660z == null || this.f == null) {
            C0739k c0739k = this.f2658x;
            if (c0739k == null) {
                return false;
            }
            c0739k.m3920e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2660z);
        this.f2660z = null;
        return true;
    }

    public boolean m5344f() {
        return m5343e() | m5345g();
    }

    public boolean m5345g() {
        if (this.f2659y == null) {
            return false;
        }
        this.f2659y.m3920e();
        return true;
    }

    public boolean m5346h() {
        return this.f2658x != null && this.f2658x.m3921f();
    }

    public boolean m5347i() {
        return this.f2660z != null || m5346h();
    }
}
