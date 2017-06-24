package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class av extends Drawable {
    private float f2499a;
    private final Paint f2500b;
    private final RectF f2501c;
    private final Rect f2502d;
    private float f2503e;
    private boolean f2504f = false;
    private boolean f2505g = true;
    private PorterDuffColorFilter f2506h;
    private ColorStateList f2507i;
    private Mode f2508j = Mode.SRC_IN;

    public av(int i, float f) {
        this.f2499a = f;
        this.f2500b = new Paint(5);
        this.f2500b.setColor(i);
        this.f2501c = new RectF();
        this.f2502d = new Rect();
    }

    private PorterDuffColorFilter m5130a(ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void m5131a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2501c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f2502d.set(rect);
        if (this.f2504f) {
            float a = aw.m5137a(this.f2503e, this.f2499a, this.f2505g);
            this.f2502d.inset((int) Math.ceil((double) aw.m5139b(this.f2503e, this.f2499a, this.f2505g)), (int) Math.ceil((double) a));
            this.f2501c.set(this.f2502d);
        }
    }

    float m5132a() {
        return this.f2503e;
    }

    void m5133a(float f) {
        if (f != this.f2499a) {
            this.f2499a = f;
            m5131a(null);
            invalidateSelf();
        }
    }

    void m5134a(float f, boolean z, boolean z2) {
        if (f != this.f2503e || this.f2504f != z || this.f2505g != z2) {
            this.f2503e = f;
            this.f2504f = z;
            this.f2505g = z2;
            m5131a(null);
            invalidateSelf();
        }
    }

    public void m5135a(int i) {
        this.f2500b.setColor(i);
        invalidateSelf();
    }

    public float m5136b() {
        return this.f2499a;
    }

    public void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.f2500b;
        if (this.f2506h == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.f2506h);
            obj = 1;
        }
        canvas.drawRoundRect(this.f2501c, this.f2499a, this.f2499a, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2502d, this.f2499a);
    }

    public boolean isStateful() {
        return (this.f2507i != null && this.f2507i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m5131a(rect);
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f2507i == null || this.f2508j == null) {
            return false;
        }
        this.f2506h = m5130a(this.f2507i, this.f2508j);
        return true;
    }

    public void setAlpha(int i) {
        this.f2500b.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2500b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2507i = colorStateList;
        this.f2506h = m5130a(this.f2507i, this.f2508j);
        invalidateSelf();
    }

    public void setTintMode(Mode mode) {
        this.f2508j = mode;
        this.f2506h = m5130a(this.f2507i, this.f2508j);
        invalidateSelf();
    }
}
