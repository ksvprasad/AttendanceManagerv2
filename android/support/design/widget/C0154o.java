package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.design.C0048a.C0041c;
import android.support.v7.p007d.p008a.C0153a;

class C0154o extends C0153a {
    static final double f651a = Math.cos(Math.toRadians(45.0d));
    final Paint f652b;
    final Paint f653c;
    final RectF f654d;
    float f655e;
    Path f656f;
    float f657g;
    float f658h;
    float f659i;
    float f660j;
    private boolean f661k = true;
    private final int f662l;
    private final int f663m;
    private final int f664n;
    private boolean f665o = true;
    private float f666p;
    private boolean f667q = false;

    public C0154o(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f662l = resources.getColor(C0041c.design_fab_shadow_start_color);
        this.f663m = resources.getColor(C0041c.design_fab_shadow_mid_color);
        this.f664n = resources.getColor(C0041c.design_fab_shadow_end_color);
        this.f652b = new Paint(5);
        this.f652b.setStyle(Style.FILL);
        this.f655e = (float) Math.round(f);
        this.f654d = new RectF();
        this.f653c = new Paint(this.f652b);
        this.f653c.setAntiAlias(false);
        m1020a(f2, f3);
    }

    public static float m1012a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f651a) * ((double) f2))) : 1.5f * f;
    }

    private void m1013a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f666p, this.f654d.centerX(), this.f654d.centerY());
        float f = (-this.f655e) - this.f659i;
        float f2 = this.f655e;
        Object obj = this.f654d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f654d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f660j - (this.f660j * 0.5f)) + f2);
        float f4 = f2 / ((this.f660j - (this.f660j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f660j - (this.f660j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f654d.left + f2, this.f654d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f656f, this.f652b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f654d.width() - (2.0f * f2), -this.f655e, this.f653c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f654d.right - f2, this.f654d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f656f, this.f652b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f654d.width() - (2.0f * f2), this.f659i + (-this.f655e), this.f653c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f654d.left + f2, this.f654d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f656f, this.f652b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f654d.height() - (2.0f * f2), -this.f655e, this.f653c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f654d.right - f2, this.f654d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f656f, this.f652b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f654d.height() - (2.0f * f2), -this.f655e, this.f653c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m1014a(Rect rect) {
        float f = this.f658h * 1.5f;
        this.f654d.set(((float) rect.left) + this.f658h, ((float) rect.top) + f, ((float) rect.right) - this.f658h, ((float) rect.bottom) - f);
        m1011b().setBounds((int) this.f654d.left, (int) this.f654d.top, (int) this.f654d.right, (int) this.f654d.bottom);
        m1016c();
    }

    public static float m1015b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f651a) * ((double) f2))) : f;
    }

    private void m1016c() {
        RectF rectF = new RectF(-this.f655e, -this.f655e, this.f655e, this.f655e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f659i, -this.f659i);
        if (this.f656f == null) {
            this.f656f = new Path();
        } else {
            this.f656f.reset();
        }
        this.f656f.setFillType(FillType.EVEN_ODD);
        this.f656f.moveTo(-this.f655e, 0.0f);
        this.f656f.rLineTo(-this.f659i, 0.0f);
        this.f656f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f656f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f656f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f655e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f652b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f662l, this.f663m, this.f664n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f653c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f662l, this.f663m, this.f664n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f653c.setAntiAlias(false);
    }

    private static int m1017d(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public float m1018a() {
        return this.f660j;
    }

    final void m1019a(float f) {
        if (this.f666p != f) {
            this.f666p = f;
            invalidateSelf();
        }
    }

    void m1020a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float d = (float) C0154o.m1017d(f);
        float d2 = (float) C0154o.m1017d(f2);
        if (d > d2) {
            if (!this.f667q) {
                this.f667q = true;
            }
            d = d2;
        }
        if (this.f660j != d || this.f658h != d2) {
            this.f660j = d;
            this.f658h = d2;
            this.f659i = (float) Math.round(d * 1.5f);
            this.f657g = d2;
            this.f661k = true;
            invalidateSelf();
        }
    }

    public void m1021a(boolean z) {
        this.f665o = z;
        invalidateSelf();
    }

    public void m1022b(float f) {
        m1020a(f, this.f658h);
    }

    public void m1023c(float f) {
        m1020a(this.f660j, f);
    }

    public void draw(Canvas canvas) {
        if (this.f661k) {
            m1014a(getBounds());
            this.f661k = false;
        }
        m1013a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C0154o.m1012a(this.f658h, this.f655e, this.f665o));
        int ceil2 = (int) Math.ceil((double) C0154o.m1015b(this.f658h, this.f655e, this.f665o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f661k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f652b.setAlpha(i);
        this.f653c.setAlpha(i);
    }
}
