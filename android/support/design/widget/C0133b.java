package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p004c.C0334a;

class C0133b extends Drawable {
    final Paint f548a = new Paint(1);
    final Rect f549b = new Rect();
    final RectF f550c = new RectF();
    float f551d;
    private int f552e;
    private int f553f;
    private int f554g;
    private int f555h;
    private ColorStateList f556i;
    private int f557j;
    private boolean f558k = true;
    private float f559l;

    public C0133b() {
        this.f548a.setStyle(Style.STROKE);
    }

    private Shader m893a() {
        Rect rect = this.f549b;
        copyBounds(rect);
        float height = this.f551d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0334a.m1820a(this.f552e, this.f557j), C0334a.m1820a(this.f553f, this.f557j), C0334a.m1820a(C0334a.m1822b(this.f553f, 0), this.f557j), C0334a.m1820a(C0334a.m1822b(this.f555h, 0), this.f557j), C0334a.m1820a(this.f555h, this.f557j), C0334a.m1820a(this.f554g, this.f557j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    void m894a(float f) {
        if (this.f551d != f) {
            this.f551d = f;
            this.f548a.setStrokeWidth(1.3333f * f);
            this.f558k = true;
            invalidateSelf();
        }
    }

    void m895a(int i, int i2, int i3, int i4) {
        this.f552e = i;
        this.f553f = i2;
        this.f554g = i3;
        this.f555h = i4;
    }

    void m896a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f557j = colorStateList.getColorForState(getState(), this.f557j);
        }
        this.f556i = colorStateList;
        this.f558k = true;
        invalidateSelf();
    }

    final void m897b(float f) {
        if (f != this.f559l) {
            this.f559l = f;
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        if (this.f558k) {
            this.f548a.setShader(m893a());
            this.f558k = false;
        }
        float strokeWidth = this.f548a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f550c;
        copyBounds(this.f549b);
        rectF.set(this.f549b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f559l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f548a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.f551d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f551d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.f556i != null && this.f556i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.f558k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f556i != null) {
            int colorForState = this.f556i.getColorForState(iArr, this.f557j);
            if (colorForState != this.f557j) {
                this.f558k = true;
                this.f557j = colorForState;
            }
        }
        if (this.f558k) {
            invalidateSelf();
        }
        return this.f558k;
    }

    public void setAlpha(int i) {
        this.f548a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f548a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
