package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p004c.p005a.C0314a;
import android.support.v4.widget.C0562b;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class C0887l {
    private final CompoundButton f2709a;
    private final C0893m f2710b;
    private ColorStateList f2711c = null;
    private Mode f2712d = null;
    private boolean f2713e = false;
    private boolean f2714f = false;
    private boolean f2715g;

    C0887l(CompoundButton compoundButton, C0893m c0893m) {
        this.f2709a = compoundButton;
        this.f2710b = c0893m;
    }

    int m5405a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0562b.m3051a(this.f2709a);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList m5406a() {
        return this.f2711c;
    }

    void m5407a(ColorStateList colorStateList) {
        this.f2711c = colorStateList;
        this.f2713e = true;
        m5412d();
    }

    void m5408a(Mode mode) {
        this.f2712d = mode;
        this.f2714f = true;
        m5412d();
    }

    void m5409a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2709a.getContext().obtainStyledAttributes(attributeSet, C0693k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0693k.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0693k.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f2709a.setButtonDrawable(this.f2710b.m5448a(this.f2709a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0693k.CompoundButton_buttonTint)) {
                C0562b.m3052a(this.f2709a, obtainStyledAttributes.getColorStateList(C0693k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0693k.CompoundButton_buttonTintMode)) {
                C0562b.m3053a(this.f2709a, al.m5018a(obtainStyledAttributes.getInt(C0693k.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m5410b() {
        return this.f2712d;
    }

    void m5411c() {
        if (this.f2715g) {
            this.f2715g = false;
            return;
        }
        this.f2715g = true;
        m5412d();
    }

    void m5412d() {
        Drawable a = C0562b.m3051a(this.f2709a);
        if (a == null) {
            return;
        }
        if (this.f2713e || this.f2714f) {
            a = C0314a.m1776f(a).mutate();
            if (this.f2713e) {
                C0314a.m1766a(a, this.f2711c);
            }
            if (this.f2714f) {
                C0314a.m1769a(a, this.f2712d);
            }
            if (a.isStateful()) {
                a.setState(this.f2709a.getDrawableState());
            }
            this.f2709a.setButtonDrawable(a);
        }
    }
}
