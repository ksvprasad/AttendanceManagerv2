package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.util.AttributeSet;
import android.widget.TextView;

public class ab extends TextView implements ad {
    private C0893m f1771a;
    private C0883h f1772b;
    private C0822z f1773c;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f1771a = C0893m.m5425a();
        this.f1772b = new C0883h(this, this.f1771a);
        this.f1772b.m5401a(attributeSet, i);
        this.f1773c = C0822z.m4833a((TextView) this);
        this.f1773c.mo773a(attributeSet, i);
        this.f1773c.mo772a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1772b != null) {
            this.f1772b.m5404c();
        }
        if (this.f1773c != null) {
            this.f1773c.mo772a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1772b != null ? this.f1772b.m5396a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1772b != null ? this.f1772b.m5402b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1772b != null) {
            this.f1772b.m5400a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1772b != null) {
            this.f1772b.m5397a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1772b != null) {
            this.f1772b.m5398a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1772b != null) {
            this.f1772b.m5399a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1773c != null) {
            this.f1773c.m4835a(context, i);
        }
    }
}
