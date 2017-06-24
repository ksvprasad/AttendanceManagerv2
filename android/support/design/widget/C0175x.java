package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.C0170v.C0169e;
import android.support.design.widget.C0170v.C0169e.C0165b;
import android.support.design.widget.C0170v.C0169e.C0167a;
import android.view.animation.Interpolator;

class C0175x extends C0169e {
    final ValueAnimator f712a = new ValueAnimator();

    C0175x() {
    }

    public void mo152a() {
        this.f712a.start();
    }

    public void mo153a(float f, float f2) {
        this.f712a.setFloatValues(new float[]{f, f2});
    }

    public void mo154a(int i) {
        this.f712a.setDuration((long) i);
    }

    public void mo155a(int i, int i2) {
        this.f712a.setIntValues(new int[]{i, i2});
    }

    public void mo156a(final C0167a c0167a) {
        this.f712a.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ C0175x f711b;

            public void onAnimationCancel(Animator animator) {
                c0167a.mo151c();
            }

            public void onAnimationEnd(Animator animator) {
                c0167a.mo150b();
            }

            public void onAnimationStart(Animator animator) {
                c0167a.mo149a();
            }
        });
    }

    public void mo157a(final C0165b c0165b) {
        this.f712a.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ C0175x f709b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                c0165b.mo148a();
            }
        });
    }

    public void mo158a(Interpolator interpolator) {
        this.f712a.setInterpolator(interpolator);
    }

    public boolean mo159b() {
        return this.f712a.isRunning();
    }

    public int mo160c() {
        return ((Integer) this.f712a.getAnimatedValue()).intValue();
    }

    public float mo161d() {
        return ((Float) this.f712a.getAnimatedValue()).floatValue();
    }

    public void mo162e() {
        this.f712a.cancel();
    }

    public float mo163f() {
        return this.f712a.getAnimatedFraction();
    }

    public long mo164g() {
        return this.f712a.getDuration();
    }
}
