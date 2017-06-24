package com.rey.material.p041b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.rey.material.p042c.C2176d;

public class C2172b extends Drawable implements Animatable {
    private static final float[] f7287x = new float[]{0.0f, 0.99f, 1.0f};
    private boolean f7288a;
    private Paint f7289b;
    private Paint f7290c;
    private RadialGradient f7291d;
    private RadialGradient f7292e;
    private Matrix f7293f;
    private int f7294g;
    private RectF f7295h;
    private Path f7296i;
    private int f7297j;
    private int f7298k;
    private float f7299l;
    private PointF f7300m;
    private float f7301n;
    private int f7302o;
    private int f7303p;
    private int f7304q;
    private int f7305r;
    private float f7306s;
    private int f7307t;
    private long f7308u;
    private boolean f7309v;
    private int f7310w;
    private final Runnable f7311y;

    private int m12383a(float f, float f2) {
        return (int) Math.round(Math.sqrt(Math.pow((double) ((f2 < this.f7295h.centerY() ? this.f7295h.bottom : this.f7295h.top) - f2), 2.0d) + Math.pow((double) ((f < this.f7295h.centerX() ? this.f7295h.right : this.f7295h.left) - f), 2.0d)));
    }

    private void m12384a(int i) {
        if (this.f7310w != i) {
            this.f7310w = i;
            if (this.f7310w == 0) {
                stop();
            } else if (this.f7310w != 2) {
                start();
            } else {
                stop();
            }
        }
    }

    private void m12385a(Canvas canvas) {
        if (this.f7310w != 0) {
            if (this.f7299l > 0.0f) {
                this.f7290c.setColor(this.f7298k);
                this.f7290c.setAlpha(Math.round(((float) this.f7294g) * this.f7299l));
                canvas.drawPath(this.f7296i, this.f7290c);
            }
            if (this.f7301n > 0.0f && this.f7306s > 0.0f) {
                this.f7289b.setAlpha(Math.round(((float) this.f7294g) * this.f7306s));
                this.f7289b.setShader(this.f7291d);
                canvas.drawPath(this.f7296i, this.f7289b);
            }
        }
    }

    private boolean m12386a(float f, float f2, float f3) {
        if (this.f7300m.x == f && this.f7300m.y == f2 && this.f7301n == f3) {
            return false;
        }
        this.f7300m.set(f, f2);
        this.f7301n = f3;
        float f4 = this.f7301n / 16.0f;
        this.f7293f.reset();
        this.f7293f.postTranslate(f, f2);
        this.f7293f.postScale(f4, f4, f, f2);
        this.f7291d.setLocalMatrix(this.f7293f);
        if (this.f7292e != null) {
            this.f7292e.setLocalMatrix(this.f7293f);
        }
        return true;
    }

    private void m12387b(Canvas canvas) {
        if (this.f7310w == 0) {
            return;
        }
        if (this.f7310w == 4) {
            if (this.f7301n == 0.0f) {
                this.f7290c.setColor(this.f7305r);
                canvas.drawPath(this.f7296i, this.f7290c);
                return;
            }
            this.f7289b.setShader(this.f7292e);
            canvas.drawPath(this.f7296i, this.f7289b);
        } else if (this.f7301n > 0.0f) {
            this.f7289b.setShader(this.f7291d);
            canvas.drawPath(this.f7296i, this.f7289b);
        }
    }

    private void m12388c() {
        this.f7308u = SystemClock.uptimeMillis();
    }

    public long m12389a() {
        switch (this.f7307t) {
            case 1:
                return this.f7310w == 3 ? ((long) Math.max(this.f7297j, this.f7304q)) - (SystemClock.uptimeMillis() - this.f7308u) : -1;
            case 2:
                return this.f7310w == 3 ? ((long) (Math.max(this.f7297j, this.f7304q) * 2)) - (SystemClock.uptimeMillis() - this.f7308u) : this.f7310w == 4 ? ((long) Math.max(this.f7297j, this.f7304q)) - (SystemClock.uptimeMillis() - this.f7308u) : -1;
            default:
                return -1;
        }
    }

    public void m12390b() {
        m12384a(0);
    }

    public void draw(Canvas canvas) {
        switch (this.f7302o) {
            case -1:
            case 0:
                m12385a(canvas);
                return;
            case 1:
                m12387b(canvas);
                return;
            default:
                return;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f7288a;
    }

    public boolean isStateful() {
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f7295h.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f7296i.reset();
        this.f7296i.addRect(this.f7295h, Direction.CW);
    }

    protected boolean onStateChange(int[] iArr) {
        boolean a = C2176d.m12406a(iArr, 16842919);
        if (this.f7309v == a) {
            return false;
        }
        this.f7309v = a;
        if (this.f7309v) {
            Rect bounds = getBounds();
            if (this.f7310w == 0 || this.f7310w == 4) {
                if (this.f7302o == 1 || this.f7302o == -1) {
                    this.f7303p = m12383a(bounds.exactCenterX(), bounds.exactCenterY());
                }
                m12386a(bounds.exactCenterX(), bounds.exactCenterY(), 0.0f);
                m12384a(1);
                return true;
            } else if (this.f7302o != 0) {
                return true;
            } else {
                m12386a(bounds.exactCenterX(), bounds.exactCenterY(), this.f7301n);
                return true;
            }
        } else if (this.f7310w == 0) {
            return true;
        } else {
            if (this.f7310w == 2) {
                if (this.f7302o == 1 || this.f7302o == -1) {
                    m12386a(this.f7300m.x, this.f7300m.y, 0.0f);
                }
                m12384a(4);
                return true;
            }
            m12384a(3);
            return true;
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        this.f7288a = true;
        super.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f7294g = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7290c.setColorFilter(colorFilter);
        this.f7289b.setColorFilter(colorFilter);
    }

    public void start() {
        if (!isRunning()) {
            m12388c();
            scheduleSelf(this.f7311y, SystemClock.uptimeMillis() + 16);
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning()) {
            this.f7288a = false;
            unscheduleSelf(this.f7311y);
            invalidateSelf();
        }
    }
}
