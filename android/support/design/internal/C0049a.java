package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0048a.C0047i;
import android.support.v7.widget.ao;
import android.util.AttributeSet;
import android.view.Gravity;

public class C0049a extends ao {
    protected boolean f181a;
    boolean f182b;
    private Drawable f183c;
    private final Rect f184d;
    private final Rect f185e;
    private int f186f;

    public C0049a(Context context) {
        this(context, null);
    }

    public C0049a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0049a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f184d = new Rect();
        this.f185e = new Rect();
        this.f186f = 119;
        this.f181a = true;
        this.f182b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0047i.ForegroundLinearLayout, i, 0);
        this.f186f = obtainStyledAttributes.getInt(C0047i.ForegroundLinearLayout_android_foregroundGravity, this.f186f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0047i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f181a = obtainStyledAttributes.getBoolean(C0047i.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f183c != null) {
            Drawable drawable = this.f183c;
            if (this.f182b) {
                this.f182b = false;
                Rect rect = this.f184d;
                Rect rect2 = this.f185e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f181a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f186f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f183c != null) {
            this.f183c.setHotspot(f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f183c != null && this.f183c.isStateful()) {
            this.f183c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f183c;
    }

    public int getForegroundGravity() {
        return this.f186f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f183c != null) {
            this.f183c.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f182b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f182b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.f183c != drawable) {
            if (this.f183c != null) {
                this.f183c.setCallback(null);
                unscheduleDrawable(this.f183c);
            }
            this.f183c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f186f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f186f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f186f = i2;
            if (this.f186f == 119 && this.f183c != null) {
                this.f183c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f183c;
    }
}
