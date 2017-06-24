package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.util.AttributeSet;
import android.widget.ImageView;

public class C0869q extends ImageView implements ad {
    private C0883h f2634a;
    private C0895p f2635b;

    public C0869q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0869q(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        C0893m a = C0893m.m5425a();
        this.f2634a = new C0883h(this, a);
        this.f2634a.m5401a(attributeSet, i);
        this.f2635b = new C0895p(this, a);
        this.f2635b.m5453a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2634a != null) {
            this.f2634a.m5404c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2634a != null ? this.f2634a.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2634a != null ? this.f2634a.m5402b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2634a != null) {
            this.f2634a.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2634a != null) {
            this.f2634a.m5397a(i);
        }
    }

    public void setImageResource(int i) {
        this.f2635b.m5452a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2634a != null) {
            this.f2634a.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2634a != null) {
            this.f2634a.m5399a(mode);
        }
    }
}
