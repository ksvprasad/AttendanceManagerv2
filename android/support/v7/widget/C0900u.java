package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p010b.C0195a;
import android.support.v4.widget.ac;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class C0900u extends RadioButton implements ac {
    private C0893m f2748a;
    private C0887l f2749b;

    public C0900u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.radioButtonStyle);
    }

    public C0900u(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f2748a = C0893m.m5425a();
        this.f2749b = new C0887l(this, this.f2748a);
        this.f2749b.m5409a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2749b != null ? this.f2749b.m5405a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2749b != null ? this.f2749b.m5406a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f2749b != null ? this.f2749b.m5410b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2748a != null ? this.f2748a.m5448a(getContext(), i) : C0195a.m1224a(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2749b != null) {
            this.f2749b.m5411c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2749b != null) {
            this.f2749b.m5407a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2749b != null) {
            this.f2749b.m5408a(mode);
        }
    }
}
