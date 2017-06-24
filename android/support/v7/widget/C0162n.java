package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class C0162n extends EditText implements ad {
    private C0893m f687a;
    private C0883h f688b;
    private C0822z f689c;

    public C0162n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.editTextStyle);
    }

    public C0162n(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f687a = C0893m.m5425a();
        this.f688b = new C0883h(this, this.f687a);
        this.f688b.m5401a(attributeSet, i);
        this.f689c = C0822z.m4833a((TextView) this);
        this.f689c.mo773a(attributeSet, i);
        this.f689c.mo772a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f688b != null) {
            this.f688b.m5404c();
        }
        if (this.f689c != null) {
            this.f689c.mo772a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f688b != null ? this.f688b.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f688b != null ? this.f688b.m5402b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f688b != null) {
            this.f688b.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f688b != null) {
            this.f688b.m5397a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f688b != null) {
            this.f688b.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f688b != null) {
            this.f688b.m5399a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f689c != null) {
            this.f689c.m4835a(context, i);
        }
    }
}
