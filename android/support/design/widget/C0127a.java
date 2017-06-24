package android.support.design.widget;

import android.support.v4.view.p017b.C0495a;
import android.support.v4.view.p017b.C0496b;
import android.support.v4.view.p017b.C0497c;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class C0127a {
    static final Interpolator f536a = new LinearInterpolator();
    static final Interpolator f537b = new C0496b();
    static final Interpolator f538c = new C0495a();
    static final Interpolator f539d = new C0497c();
    static final Interpolator f540e = new DecelerateInterpolator();

    static class C0126a implements AnimationListener {
        C0126a() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    static float m878a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int m879a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
