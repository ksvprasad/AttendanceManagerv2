package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class C0803g extends AutoCompleteTextView implements ad {
    private static final int[] f2200a = new int[]{16843126};
    private C0893m f2201b;
    private C0883h f2202c;
    private C0822z f2203d;

    public C0803g(Context context) {
        this(context, null);
    }

    public C0803g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.autoCompleteTextViewStyle);
    }

    public C0803g(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f2201b = C0893m.m5425a();
        bh a = bh.m5210a(getContext(), attributeSet, f2200a, i, 0);
        if (a.m5225f(0)) {
            setDropDownBackgroundDrawable(a.m5213a(0));
        }
        a.m5214a();
        this.f2202c = new C0883h(this, this.f2201b);
        this.f2202c.m5401a(attributeSet, i);
        this.f2203d = C0822z.m4833a((TextView) this);
        this.f2203d.mo773a(attributeSet, i);
        this.f2203d.mo772a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2202c != null) {
            this.f2202c.m5404c();
        }
        if (this.f2203d != null) {
            this.f2203d.mo772a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2202c != null ? this.f2202c.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2202c != null ? this.f2202c.m5402b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2202c != null) {
            this.f2202c.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2202c != null) {
            this.f2202c.m5397a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f2201b != null) {
            setDropDownBackgroundDrawable(this.f2201b.m5448a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2202c != null) {
            this.f2202c.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2202c != null) {
            this.f2202c.m5399a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2203d != null) {
            this.f2203d.m4835a(context, i);
        }
    }
}
