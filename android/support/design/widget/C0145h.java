package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.C0048a.C0039a;
import android.support.design.widget.C0127a.C0126a;
import android.support.design.widget.C0144j.C0082a;
import android.support.v4.p004c.p005a.C0314a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class C0145h extends C0144j {
    C0154o f632a;
    private int f633m;
    private C0160r f634n = new C0160r();
    private boolean f635o;

    private abstract class C0141a extends Animation {
        final /* synthetic */ C0145h f614a;
        private float f615b;
        private float f616c;

        private C0141a(C0145h c0145h) {
            this.f614a = c0145h;
        }

        protected abstract float mo121a();

        protected void applyTransformation(float f, Transformation transformation) {
            this.f614a.f632a.m1022b(this.f615b + (this.f616c * f));
        }

        public void reset() {
            super.reset();
            this.f615b = this.f614a.f632a.m1018a();
            this.f616c = mo121a() - this.f615b;
        }
    }

    private class C0142b extends C0141a {
        final /* synthetic */ C0145h f617b;

        private C0142b(C0145h c0145h) {
            this.f617b = c0145h;
            super();
        }

        protected float mo121a() {
            return this.f617b.f + this.f617b.g;
        }
    }

    private class C0143c extends C0141a {
        final /* synthetic */ C0145h f618b;

        private C0143c(C0145h c0145h) {
            this.f618b = c0145h;
            super();
        }

        protected float mo121a() {
            return this.f618b.f;
        }
    }

    C0145h(ae aeVar, C0086p c0086p) {
        super(aeVar, c0086p);
        this.f633m = aeVar.getResources().getInteger(17694720);
        this.f634n.m1049a((View) aeVar);
        this.f634n.m1051a(h, m973a(new C0142b()));
        this.f634n.m1051a(i, m973a(new C0142b()));
        this.f634n.m1051a(j, m973a(new C0143c()));
    }

    private Animation m973a(Animation animation) {
        animation.setInterpolator(C0127a.f537b);
        animation.setDuration((long) this.f633m);
        return animation;
    }

    private static ColorStateList m975b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{i, i, h};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    float mo122a() {
        return this.f;
    }

    void mo123a(float f) {
        if (this.f632a != null) {
            this.f632a.m1020a(f, this.g + f);
            m968g();
        }
    }

    void mo124a(int i) {
        if (this.c != null) {
            C0314a.m1766a(this.c, C0145h.m975b(i));
        }
    }

    void mo125a(ColorStateList colorStateList) {
        if (this.b != null) {
            C0314a.m1766a(this.b, colorStateList);
        }
        if (this.d != null) {
            this.d.m896a(colorStateList);
        }
    }

    void mo126a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.b = C0314a.m1776f(m972k());
        C0314a.m1766a(this.b, colorStateList);
        if (mode != null) {
            C0314a.m1769a(this.b, mode);
        }
        this.c = C0314a.m1776f(m972k());
        C0314a.m1766a(this.c, C0145h.m975b(i));
        if (i2 > 0) {
            this.d = m949a(i2, colorStateList);
            drawableArr = new Drawable[]{this.d, this.b, this.c};
        } else {
            this.d = null;
            drawableArr = new Drawable[]{this.b, this.c};
        }
        this.e = new LayerDrawable(drawableArr);
        this.f632a = new C0154o(this.k.getResources(), this.e, this.l.mo86a(), this.f, this.f + this.g);
        this.f632a.m1021a(false);
        this.l.mo88a(this.f632a);
    }

    void mo127a(Mode mode) {
        if (this.b != null) {
            C0314a.m1769a(this.b, mode);
        }
    }

    void mo128a(Rect rect) {
        this.f632a.getPadding(rect);
    }

    void mo129a(final C0082a c0082a, final boolean z) {
        if (!this.f635o && this.k.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0039a.design_fab_out);
            loadAnimation.setInterpolator(C0127a.f538c);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new C0126a(this) {
                final /* synthetic */ C0145h f611c;

                public void onAnimationEnd(Animation animation) {
                    this.f611c.f635o = false;
                    this.f611c.k.m637a(8, z);
                    if (c0082a != null) {
                        c0082a.mo84b();
                    }
                }

                public void onAnimationStart(Animation animation) {
                    this.f611c.f635o = true;
                }
            });
            this.k.startAnimation(loadAnimation);
        } else if (c0082a != null) {
            c0082a.mo84b();
        }
    }

    void mo130a(int[] iArr) {
        this.f634n.m1050a(iArr);
    }

    void mo131b() {
        this.f634n.m1052b();
    }

    void mo132b(float f) {
        if (this.f632a != null) {
            this.f632a.m1023c(this.f + f);
            m968g();
        }
    }

    void mo133b(final C0082a c0082a, boolean z) {
        if (this.k.getVisibility() != 0 || this.f635o) {
            this.k.clearAnimation();
            this.k.m637a(0, z);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.k.getContext(), C0039a.design_fab_in);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(C0127a.f539d);
            loadAnimation.setAnimationListener(new C0126a(this) {
                final /* synthetic */ C0145h f613b;

                public void onAnimationEnd(Animation animation) {
                    if (c0082a != null) {
                        c0082a.mo83a();
                    }
                }
            });
            this.k.startAnimation(loadAnimation);
        } else if (c0082a != null) {
            c0082a.mo83a();
        }
    }

    void mo134c() {
    }
}
