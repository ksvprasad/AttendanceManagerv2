package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import android.support.v7.p020c.C0699a.C0695a;
import android.support.v7.p020c.C0699a.C0696b;

class aw extends Drawable {
    static final double f2509a = Math.cos(Math.toRadians(45.0d));
    static C0823a f2510c;
    final int f2511b;
    Paint f2512d;
    Paint f2513e;
    Paint f2514f;
    final RectF f2515g;
    float f2516h;
    Path f2517i;
    float f2518j;
    float f2519k;
    float f2520l;
    float f2521m;
    private boolean f2522n = true;
    private final int f2523o;
    private final int f2524p;
    private boolean f2525q = true;
    private boolean f2526r = false;

    interface C0823a {
        void mo787a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    aw(Resources resources, int i, float f, float f2, float f3) {
        this.f2523o = resources.getColor(C0695a.cardview_shadow_start_color);
        this.f2524p = resources.getColor(C0695a.cardview_shadow_end_color);
        this.f2511b = resources.getDimensionPixelSize(C0696b.cardview_compat_inset_shadow);
        this.f2512d = new Paint(5);
        this.f2512d.setColor(i);
        this.f2513e = new Paint(5);
        this.f2513e.setStyle(Style.FILL);
        this.f2516h = (float) ((int) (0.5f + f));
        this.f2515g = new RectF();
        this.f2514f = new Paint(this.f2513e);
        this.f2514f.setAntiAlias(false);
        m5145a(f2, f3);
    }

    static float m5137a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f2509a) * ((double) f2))) : 1.5f * f;
    }

    private void m5138a(Canvas canvas) {
        float f = (-this.f2516h) - this.f2520l;
        float f2 = (this.f2516h + ((float) this.f2511b)) + (this.f2521m / 2.0f);
        Object obj = this.f2515g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f2515g.height() - (2.0f * f2) > 0.0f ? 1 : null;
        int save = canvas.save();
        canvas.translate(this.f2515g.left + f2, this.f2515g.top + f2);
        canvas.drawPath(this.f2517i, this.f2513e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2515g.width() - (2.0f * f2), -this.f2516h, this.f2514f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f2515g.right - f2, this.f2515g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2517i, this.f2513e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f2515g.width() - (2.0f * f2), this.f2520l + (-this.f2516h), this.f2514f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f2515g.left + f2, this.f2515g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2517i, this.f2513e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2515g.height() - (2.0f * f2), -this.f2516h, this.f2514f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f2515g.right - f2, this.f2515g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2517i, this.f2513e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f2515g.height() - (2.0f * f2), -this.f2516h, this.f2514f);
        }
        canvas.restoreToCount(save2);
    }

    static float m5139b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f2509a) * ((double) f2))) : f;
    }

    private void m5140b(Rect rect) {
        float f = this.f2519k * 1.5f;
        this.f2515g.set(((float) rect.left) + this.f2519k, ((float) rect.top) + f, ((float) rect.right) - this.f2519k, ((float) rect.bottom) - f);
        m5142f();
    }

    private int m5141d(float f) {
        int i = (int) (0.5f + f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void m5142f() {
        RectF rectF = new RectF(-this.f2516h, -this.f2516h, this.f2516h, this.f2516h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f2520l, -this.f2520l);
        if (this.f2517i == null) {
            this.f2517i = new Path();
        } else {
            this.f2517i.reset();
        }
        this.f2517i.setFillType(FillType.EVEN_ODD);
        this.f2517i.moveTo(-this.f2516h, 0.0f);
        this.f2517i.rLineTo(-this.f2520l, 0.0f);
        this.f2517i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2517i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2517i.close();
        float f = this.f2516h / (this.f2516h + this.f2520l);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.f2513e.setShader(new RadialGradient(0.0f, f, this.f2516h + this.f2520l, new int[]{this.f2523o, this.f2523o, this.f2524p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f2514f.setShader(new LinearGradient(0.0f, (-this.f2516h) + this.f2520l, f2, (-this.f2516h) - this.f2520l, new int[]{this.f2523o, this.f2523o, this.f2524p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f2514f.setAntiAlias(false);
    }

    float m5143a() {
        return this.f2516h;
    }

    void m5144a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.f2516h != f2) {
            this.f2516h = f2;
            this.f2522n = true;
            invalidateSelf();
        }
    }

    void m5145a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float d = (float) m5141d(f);
            float d2 = (float) m5141d(f2);
            if (d > d2) {
                if (!this.f2526r) {
                    this.f2526r = true;
                }
                d = d2;
            }
            if (this.f2521m != d || this.f2519k != d2) {
                this.f2521m = d;
                this.f2519k = d2;
                this.f2520l = (float) ((int) (((d * 1.5f) + ((float) this.f2511b)) + 0.5f));
                this.f2518j = ((float) this.f2511b) + d2;
                this.f2522n = true;
                invalidateSelf();
            }
        }
    }

    public void m5146a(int i) {
        this.f2512d.setColor(i);
        invalidateSelf();
    }

    void m5147a(Rect rect) {
        getPadding(rect);
    }

    public void m5148a(boolean z) {
        this.f2525q = z;
        invalidateSelf();
    }

    float m5149b() {
        return this.f2521m;
    }

    void m5150b(float f) {
        m5145a(f, this.f2519k);
    }

    float m5151c() {
        return this.f2519k;
    }

    void m5152c(float f) {
        m5145a(this.f2521m, f);
    }

    float m5153d() {
        return (Math.max(this.f2519k, (this.f2516h + ((float) this.f2511b)) + (this.f2519k / 2.0f)) * 2.0f) + ((this.f2519k + ((float) this.f2511b)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.f2522n) {
            m5140b(getBounds());
            this.f2522n = false;
        }
        canvas.translate(0.0f, this.f2521m / 2.0f);
        m5138a(canvas);
        canvas.translate(0.0f, (-this.f2521m) / 2.0f);
        f2510c.mo787a(canvas, this.f2515g, this.f2516h, this.f2512d);
    }

    float m5154e() {
        return (Math.max(this.f2519k, (this.f2516h + ((float) this.f2511b)) + ((this.f2519k * 1.5f) / 2.0f)) * 2.0f) + (((this.f2519k * 1.5f) + ((float) this.f2511b)) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m5137a(this.f2519k, this.f2516h, this.f2525q));
        int ceil2 = (int) Math.ceil((double) m5139b(this.f2519k, this.f2516h, this.f2525q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2522n = true;
    }

    public void setAlpha(int i) {
        this.f2512d.setAlpha(i);
        this.f2513e.setAlpha(i);
        this.f2514f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2512d.setColorFilter(colorFilter);
    }
}
