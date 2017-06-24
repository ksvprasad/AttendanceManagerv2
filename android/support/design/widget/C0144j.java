package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.C0048a.C0041c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class C0144j {
    static final int[] f619h = new int[]{16842919, 16842910};
    static final int[] f620i = new int[]{16842908, 16842910};
    static final int[] f621j = new int[0];
    private final Rect f622a = new Rect();
    Drawable f623b;
    Drawable f624c;
    C0133b f625d;
    Drawable f626e;
    float f627f;
    float f628g;
    final ae f629k;
    final C0086p f630l;
    private OnPreDrawListener f631m;

    interface C0082a {
        void mo83a();

        void mo84b();
    }

    class C01491 implements OnPreDrawListener {
        final /* synthetic */ C0144j f644a;

        C01491(C0144j c0144j) {
            this.f644a = c0144j;
        }

        public boolean onPreDraw() {
            this.f644a.mo136e();
            return true;
        }
    }

    C0144j(ae aeVar, C0086p c0086p) {
        this.f629k = aeVar;
        this.f630l = c0086p;
    }

    private void m947l() {
        if (this.f631m == null) {
            this.f631m = new C01491(this);
        }
    }

    abstract float mo122a();

    C0133b m949a(int i, ColorStateList colorStateList) {
        Resources resources = this.f629k.getResources();
        C0133b j = mo138j();
        j.m895a(resources.getColor(C0041c.design_fab_stroke_top_outer_color), resources.getColor(C0041c.design_fab_stroke_top_inner_color), resources.getColor(C0041c.design_fab_stroke_end_inner_color), resources.getColor(C0041c.design_fab_stroke_end_outer_color));
        j.m894a((float) i);
        j.m896a(colorStateList);
        return j;
    }

    abstract void mo123a(float f);

    abstract void mo124a(int i);

    abstract void mo125a(ColorStateList colorStateList);

    abstract void mo126a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void mo127a(Mode mode);

    abstract void mo128a(Rect rect);

    abstract void mo129a(C0082a c0082a, boolean z);

    abstract void mo130a(int[] iArr);

    abstract void mo131b();

    abstract void mo132b(float f);

    void mo137b(Rect rect) {
    }

    abstract void mo133b(C0082a c0082a, boolean z);

    abstract void mo134c();

    final void m963c(float f) {
        if (this.f627f != f) {
            this.f627f = f;
            mo123a(f);
        }
    }

    final void m964d(float f) {
        if (this.f628g != f) {
            this.f628g = f;
            mo132b(f);
        }
    }

    boolean mo135d() {
        return false;
    }

    void mo136e() {
    }

    final Drawable m967f() {
        return this.f626e;
    }

    final void m968g() {
        Rect rect = this.f622a;
        mo128a(rect);
        mo137b(rect);
        this.f630l.mo87a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m969h() {
        if (mo135d()) {
            m947l();
            this.f629k.getViewTreeObserver().addOnPreDrawListener(this.f631m);
        }
    }

    void m970i() {
        if (this.f631m != null) {
            this.f629k.getViewTreeObserver().removeOnPreDrawListener(this.f631m);
            this.f631m = null;
        }
    }

    C0133b mo138j() {
        return new C0133b();
    }

    GradientDrawable m972k() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
