package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.design.widget.C0144j.C0082a;
import android.support.v4.view.ag;

class C0148i extends C0145h {
    private boolean f643m;

    C0148i(ae aeVar, C0086p c0086p) {
        super(aeVar, c0086p);
    }

    private void m990e(float f) {
        if (this.a != null) {
            this.a.m1019a(-f);
        }
        if (this.d != null) {
            this.d.m897b(-f);
        }
    }

    void mo129a(final C0082a c0082a, final boolean z) {
        if (this.f643m || this.k.getVisibility() != 0) {
            if (c0082a != null) {
                c0082a.mo84b();
            }
        } else if (!ag.m2503A(this.k) || this.k.isInEditMode()) {
            this.k.m637a(8, z);
            if (c0082a != null) {
                c0082a.mo84b();
            }
        } else {
            this.k.animate().cancel();
            this.k.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(C0127a.f538c).setListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ C0148i f638c;
                private boolean f639d;

                public void onAnimationCancel(Animator animator) {
                    this.f638c.f643m = false;
                    this.f639d = true;
                }

                public void onAnimationEnd(Animator animator) {
                    this.f638c.f643m = false;
                    if (!this.f639d) {
                        this.f638c.k.m637a(8, z);
                        if (c0082a != null) {
                            c0082a.mo84b();
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    this.f638c.f643m = true;
                    this.f639d = false;
                    this.f638c.k.m637a(0, z);
                }
            });
        }
    }

    void mo133b(final C0082a c0082a, final boolean z) {
        if (!this.f643m && this.k.getVisibility() == 0) {
            return;
        }
        if (!ag.m2503A(this.k) || this.k.isInEditMode()) {
            this.k.m637a(0, z);
            this.k.setAlpha(1.0f);
            this.k.setScaleY(1.0f);
            this.k.setScaleX(1.0f);
            if (c0082a != null) {
                c0082a.mo83a();
                return;
            }
            return;
        }
        this.k.animate().cancel();
        if (this.k.getVisibility() != 0) {
            this.k.setAlpha(0.0f);
            this.k.setScaleY(0.0f);
            this.k.setScaleX(0.0f);
        }
        this.k.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(C0127a.f539d).setListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ C0148i f642c;

            public void onAnimationEnd(Animator animator) {
                if (c0082a != null) {
                    c0082a.mo83a();
                }
            }

            public void onAnimationStart(Animator animator) {
                this.f642c.k.m637a(0, z);
            }
        });
    }

    boolean mo135d() {
        return true;
    }

    void mo136e() {
        m990e(this.k.getRotation());
    }
}
