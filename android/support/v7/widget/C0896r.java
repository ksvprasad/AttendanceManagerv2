package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class C0896r extends MultiAutoCompleteTextView implements ad {
    private static final int[] f2735a = new int[]{16843126};
    private C0893m f2736b;
    private C0883h f2737c;
    private C0822z f2738d;

    public C0896r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.autoCompleteTextViewStyle);
    }

    public C0896r(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f2736b = C0893m.m5425a();
        bh a = bh.m5210a(getContext(), attributeSet, f2735a, i, 0);
        if (a.m5225f(0)) {
            setDropDownBackgroundDrawable(a.m5213a(0));
        }
        a.m5214a();
        this.f2737c = new C0883h(this, this.f2736b);
        this.f2737c.m5401a(attributeSet, i);
        this.f2738d = C0822z.m4833a((TextView) this);
        this.f2738d.mo773a(attributeSet, i);
        this.f2738d.mo772a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2737c != null) {
            this.f2737c.m5404c();
        }
        if (this.f2738d != null) {
            this.f2738d.mo772a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2737c != null ? this.f2737c.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2737c != null ? this.f2737c.m5402b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2737c != null) {
            this.f2737c.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2737c != null) {
            this.f2737c.m5397a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f2736b != null) {
            setDropDownBackgroundDrawable(this.f2736b.m5448a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2737c != null) {
            this.f2737c.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2737c != null) {
            this.f2737c.m5399a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2738d != null) {
            this.f2738d.m4835a(context, i);
        }
    }
}
