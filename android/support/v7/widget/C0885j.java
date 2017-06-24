package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p010b.C0195a;
import android.support.v4.widget.ac;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class C0885j extends CheckBox implements ac {
    private C0893m f2704a;
    private C0887l f2705b;

    public C0885j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.checkboxStyle);
    }

    public C0885j(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f2704a = C0893m.m5425a();
        this.f2705b = new C0887l(this, this.f2704a);
        this.f2705b.m5409a(attributeSet, i);
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2705b != null ? this.f2705b.m5405a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2705b != null ? this.f2705b.m5406a() : null;
    }

    public Mode getSupportButtonTintMode() {
        return this.f2705b != null ? this.f2705b.m5410b() : null;
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2704a != null ? this.f2704a.m5448a(getContext(), i) : C0195a.m1224a(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2705b != null) {
            this.f2705b.m5411c();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2705b != null) {
            this.f2705b.m5407a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2705b != null) {
            this.f2705b.m5408a(mode);
        }
    }
}
