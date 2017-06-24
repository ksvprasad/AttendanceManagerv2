package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.view.View;

class C0883h {
    private final View f2696a;
    private final C0893m f2697b;
    private bf f2698c;
    private bf f2699d;
    private bf f2700e;

    C0883h(View view, C0893m c0893m) {
        this.f2696a = view;
        this.f2697b = c0893m;
    }

    private boolean m5395b(Drawable drawable) {
        if (this.f2700e == null) {
            this.f2700e = new bf();
        }
        bf bfVar = this.f2700e;
        bfVar.m5208a();
        ColorStateList x = ag.m2556x(this.f2696a);
        if (x != null) {
            bfVar.f2592d = true;
            bfVar.f2589a = x;
        }
        Mode y = ag.m2557y(this.f2696a);
        if (y != null) {
            bfVar.f2591c = true;
            bfVar.f2590b = y;
        }
        if (!bfVar.f2592d && !bfVar.f2591c) {
            return false;
        }
        C0893m.m5428a(drawable, bfVar, this.f2696a.getDrawableState());
        return true;
    }

    ColorStateList m5396a() {
        return this.f2699d != null ? this.f2699d.f2589a : null;
    }

    void m5397a(int i) {
        m5403b(this.f2697b != null ? this.f2697b.m5451b(this.f2696a.getContext(), i) : null);
    }

    void m5398a(ColorStateList colorStateList) {
        if (this.f2699d == null) {
            this.f2699d = new bf();
        }
        this.f2699d.f2589a = colorStateList;
        this.f2699d.f2592d = true;
        m5404c();
    }

    void m5399a(Mode mode) {
        if (this.f2699d == null) {
            this.f2699d = new bf();
        }
        this.f2699d.f2590b = mode;
        this.f2699d.f2591c = true;
        m5404c();
    }

    void m5400a(Drawable drawable) {
        m5403b(null);
    }

    void m5401a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2696a.getContext().obtainStyledAttributes(attributeSet, C0693k.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0693k.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f2697b.m5451b(this.f2696a.getContext(), obtainStyledAttributes.getResourceId(C0693k.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m5403b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(C0693k.ViewBackgroundHelper_backgroundTint)) {
                ag.m2515a(this.f2696a, obtainStyledAttributes.getColorStateList(C0693k.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0693k.ViewBackgroundHelper_backgroundTintMode)) {
                ag.m2516a(this.f2696a, al.m5018a(obtainStyledAttributes.getInt(C0693k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m5402b() {
        return this.f2699d != null ? this.f2699d.f2590b : null;
    }

    void m5403b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2698c == null) {
                this.f2698c = new bf();
            }
            this.f2698c.f2589a = colorStateList;
            this.f2698c.f2592d = true;
        } else {
            this.f2698c = null;
        }
        m5404c();
    }

    void m5404c() {
        Drawable background = this.f2696a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m5395b(background)) {
            if (this.f2699d != null) {
                C0893m.m5428a(background, this.f2699d, this.f2696a.getDrawableState());
            } else if (this.f2698c != null) {
                C0893m.m5428a(background, this.f2698c, this.f2696a.getDrawableState());
            }
        }
    }
}
