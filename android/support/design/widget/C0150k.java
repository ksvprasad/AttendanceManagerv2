package android.support.design.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.support.v4.p004c.p005a.C0314a;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
class C0150k extends C0148i {
    private final Interpolator f645m;
    private InsetDrawable f646n;

    C0150k(ae aeVar, C0086p c0086p) {
        super(aeVar, c0086p);
        this.f645m = aeVar.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    private Animator m995a(Animator animator) {
        animator.setInterpolator(this.f645m);
        return animator;
    }

    public float mo122a() {
        return this.k.getElevation();
    }

    public void mo123a(float f) {
        this.k.setElevation(f);
        if (this.l.mo89b()) {
            m968g();
        }
    }

    void mo124a(int i) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(i));
        } else {
            super.mo124a(i);
        }
    }

    void mo126a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable layerDrawable;
        this.b = C0314a.m1776f(m972k());
        C0314a.m1766a(this.b, colorStateList);
        if (mode != null) {
            C0314a.m1769a(this.b, mode);
        }
        if (i2 > 0) {
            this.d = m949a(i2, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.d, this.b});
        } else {
            this.d = null;
            layerDrawable = this.b;
        }
        this.c = new RippleDrawable(ColorStateList.valueOf(i), layerDrawable, null);
        this.e = this.c;
        this.l.mo88a(this.c);
    }

    void mo128a(Rect rect) {
        if (this.l.mo89b()) {
            float a = this.l.mo86a();
            float a2 = mo122a() + this.g;
            int ceil = (int) Math.ceil((double) C0154o.m1015b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) C0154o.m1012a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void mo130a(int[] iArr) {
    }

    void mo131b() {
    }

    void mo132b(float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(h, m995a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{f})));
        stateListAnimator.addState(i, m995a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{f})));
        stateListAnimator.addState(j, m995a(ObjectAnimator.ofFloat(this.k, "translationZ", new float[]{0.0f})));
        this.k.setStateListAnimator(stateListAnimator);
        if (this.l.mo89b()) {
            m968g();
        }
    }

    void mo137b(Rect rect) {
        if (this.l.mo89b()) {
            this.f646n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.mo88a(this.f646n);
            return;
        }
        this.l.mo88a(this.c);
    }

    void mo134c() {
        m968g();
    }

    boolean mo135d() {
        return false;
    }

    C0133b mo138j() {
        return new C0134c();
    }
}
