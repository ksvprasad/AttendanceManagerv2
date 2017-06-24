package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class C0894o extends ImageButton implements ad {
    private C0883h f2731a;
    private C0895p f2732b;

    public C0894o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.imageButtonStyle);
    }

    public C0894o(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        C0893m a = C0893m.m5425a();
        this.f2731a = new C0883h(this, a);
        this.f2731a.m5401a(attributeSet, i);
        this.f2732b = new C0895p(this, a);
        this.f2732b.m5453a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2731a != null) {
            this.f2731a.m5404c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2731a != null ? this.f2731a.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2731a != null ? this.f2731a.m5402b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2731a != null) {
            this.f2731a.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2731a != null) {
            this.f2731a.m5397a(i);
        }
    }

    public void setImageResource(int i) {
        this.f2732b.m5452a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2731a != null) {
            this.f2731a.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2731a != null) {
            this.f2731a.m5399a(mode);
        }
    }
}
