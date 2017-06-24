package com.rey.material.p041b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.rey.material.C2167a.C2162b;
import com.rey.material.p042c.C2173a;
import com.rey.material.p042c.C2174b;

public class C2171a extends Drawable implements Animatable, OnTouchListener {
    private static final float[] f7259A = new float[]{0.0f, 0.99f, 1.0f};
    private final Runnable f7260B;
    private boolean f7261a;
    private Paint f7262b;
    private Paint f7263c;
    private C2170b f7264d;
    private RadialGradient f7265e;
    private RadialGradient f7266f;
    private Matrix f7267g;
    private int f7268h;
    private Drawable f7269i;
    private RectF f7270j;
    private Path f7271k;
    private int f7272l;
    private int f7273m;
    private float f7274n;
    private PointF f7275o;
    private float f7276p;
    private int f7277q;
    private int f7278r;
    private int f7279s;
    private int f7280t;
    private float f7281u;
    private int f7282v;
    private Interpolator f7283w;
    private Interpolator f7284x;
    private long f7285y;
    private int f7286z;

    class C21681 implements Runnable {
        final /* synthetic */ C2171a f7233a;

        C21681(C2171a c2171a) {
            this.f7233a = c2171a;
        }

        public void run() {
            switch (this.f7233a.f7277q) {
                case -1:
                case 0:
                    this.f7233a.m12375e();
                    return;
                case 1:
                    this.f7233a.m12376f();
                    return;
                default:
                    return;
            }
        }
    }

    public static class C2169a {
        private Drawable f7234a;
        private int f7235b;
        private int f7236c;
        private int f7237d;
        private int f7238e;
        private int f7239f;
        private int f7240g;
        private int f7241h;
        private Interpolator f7242i;
        private Interpolator f7243j;
        private int f7244k;
        private int f7245l;
        private int f7246m;
        private int f7247n;
        private int f7248o;
        private int f7249p;
        private int f7250q;
        private int f7251r;
        private int f7252s;

        public C2169a() {
            this.f7235b = 200;
            this.f7239f = 400;
        }

        public C2169a(Context context, int i) {
            this(context, null, 0, i);
        }

        public C2169a(Context context, AttributeSet attributeSet, int i, int i2) {
            this.f7235b = 200;
            this.f7239f = 400;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2162b.RippleDrawable, i, i2);
            m12348b(obtainStyledAttributes.getColor(C2162b.RippleDrawable_rd_backgroundColor, 0));
            m12344a(obtainStyledAttributes.getInteger(C2162b.RippleDrawable_rd_backgroundAnimDuration, context.getResources().getInteger(17694721)));
            m12350c(obtainStyledAttributes.getInteger(C2162b.RippleDrawable_rd_rippleType, 0));
            m12351d(obtainStyledAttributes.getInteger(C2162b.RippleDrawable_rd_delayClick, 0));
            int a = C2174b.m12396a(obtainStyledAttributes, C2162b.RippleDrawable_rd_maxRippleRadius);
            if (a < 16 || a > 31) {
                m12352e(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_maxRippleRadius, C2174b.m12394a(context, 48)));
            } else {
                m12352e(obtainStyledAttributes.getInteger(C2162b.RippleDrawable_rd_maxRippleRadius, -1));
            }
            m12354g(obtainStyledAttributes.getColor(C2162b.RippleDrawable_rd_rippleColor, C2174b.m12399d(context, 0)));
            m12353f(obtainStyledAttributes.getInteger(C2162b.RippleDrawable_rd_rippleAnimDuration, context.getResources().getInteger(17694721)));
            a = obtainStyledAttributes.getResourceId(C2162b.RippleDrawable_rd_inInterpolator, 0);
            if (a != 0) {
                m12346a(AnimationUtils.loadInterpolator(context, a));
            }
            a = obtainStyledAttributes.getResourceId(C2162b.RippleDrawable_rd_outInterpolator, 0);
            if (a != 0) {
                m12349b(AnimationUtils.loadInterpolator(context, a));
            }
            m12355h(obtainStyledAttributes.getInteger(C2162b.RippleDrawable_rd_maskType, 0));
            m12356i(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_cornerRadius, 0));
            m12357j(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_topLeftCornerRadius, this.f7245l));
            m12358k(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_topRightCornerRadius, this.f7246m));
            m12360m(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_bottomRightCornerRadius, this.f7248o));
            m12359l(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_bottomLeftCornerRadius, this.f7247n));
            m12361n(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_padding, 0));
            m12362o(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_leftPadding, this.f7249p));
            m12364q(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_rightPadding, this.f7251r));
            m12363p(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_topPadding, this.f7250q));
            m12365r(obtainStyledAttributes.getDimensionPixelSize(C2162b.RippleDrawable_rd_bottomPadding, this.f7252s));
            obtainStyledAttributes.recycle();
        }

        public C2169a m12344a(int i) {
            this.f7235b = i;
            return this;
        }

        public C2169a m12345a(Drawable drawable) {
            this.f7234a = drawable;
            return this;
        }

        public C2169a m12346a(Interpolator interpolator) {
            this.f7242i = interpolator;
            return this;
        }

        public C2171a m12347a() {
            if (this.f7242i == null) {
                this.f7242i = new AccelerateInterpolator();
            }
            if (this.f7243j == null) {
                this.f7243j = new DecelerateInterpolator();
            }
            return new C2171a(this.f7234a, this.f7235b, this.f7236c, this.f7237d, this.f7241h, this.f7238e, this.f7239f, this.f7240g, this.f7242i, this.f7243j, this.f7244k, this.f7245l, this.f7246m, this.f7248o, this.f7247n, this.f7249p, this.f7250q, this.f7251r, this.f7252s);
        }

        public C2169a m12348b(int i) {
            this.f7236c = i;
            return this;
        }

        public C2169a m12349b(Interpolator interpolator) {
            this.f7243j = interpolator;
            return this;
        }

        public C2169a m12350c(int i) {
            this.f7237d = i;
            return this;
        }

        public C2169a m12351d(int i) {
            this.f7241h = i;
            return this;
        }

        public C2169a m12352e(int i) {
            this.f7238e = i;
            return this;
        }

        public C2169a m12353f(int i) {
            this.f7239f = i;
            return this;
        }

        public C2169a m12354g(int i) {
            this.f7240g = i;
            return this;
        }

        public C2169a m12355h(int i) {
            this.f7244k = i;
            return this;
        }

        public C2169a m12356i(int i) {
            this.f7245l = i;
            this.f7246m = i;
            this.f7247n = i;
            this.f7248o = i;
            return this;
        }

        public C2169a m12357j(int i) {
            this.f7245l = i;
            return this;
        }

        public C2169a m12358k(int i) {
            this.f7246m = i;
            return this;
        }

        public C2169a m12359l(int i) {
            this.f7247n = i;
            return this;
        }

        public C2169a m12360m(int i) {
            this.f7248o = i;
            return this;
        }

        public C2169a m12361n(int i) {
            this.f7249p = i;
            this.f7250q = i;
            this.f7251r = i;
            this.f7252s = i;
            return this;
        }

        public C2169a m12362o(int i) {
            this.f7249p = i;
            return this;
        }

        public C2169a m12363p(int i) {
            this.f7250q = i;
            return this;
        }

        public C2169a m12364q(int i) {
            this.f7251r = i;
            return this;
        }

        public C2169a m12365r(int i) {
            this.f7252s = i;
            return this;
        }
    }

    public static class C2170b {
        final int f7253a;
        final float[] f7254b = new float[8];
        final int f7255c;
        final int f7256d;
        final int f7257e;
        final int f7258f;

        public C2170b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f7253a = i;
            this.f7254b[0] = (float) i2;
            this.f7254b[1] = (float) i2;
            this.f7254b[2] = (float) i3;
            this.f7254b[3] = (float) i3;
            this.f7254b[4] = (float) i4;
            this.f7254b[5] = (float) i4;
            this.f7254b[6] = (float) i5;
            this.f7254b[7] = (float) i5;
            this.f7255c = i6;
            this.f7256d = i7;
            this.f7257e = i8;
            this.f7258f = i9;
        }
    }

    private C2171a(Drawable drawable, int i, int i2, int i3, int i4, int i5, int i6, int i7, Interpolator interpolator, Interpolator interpolator2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f7261a = false;
        this.f7268h = 255;
        this.f7286z = 0;
        this.f7260B = new C21681(this);
        m12380a(drawable);
        this.f7272l = i;
        this.f7273m = i2;
        this.f7277q = i3;
        m12378a(i4);
        this.f7278r = i5;
        this.f7279s = i6;
        this.f7280t = i7;
        if (this.f7277q == 0 && this.f7278r <= 0) {
            this.f7277q = -1;
        }
        this.f7283w = interpolator;
        this.f7284x = interpolator2;
        m12379a(i8, i9, i10, i11, i12, i13, i14, i15, i16);
        this.f7263c = new Paint(1);
        this.f7263c.setStyle(Style.FILL);
        this.f7262b = new Paint(1);
        this.f7262b.setStyle(Style.FILL);
        this.f7271k = new Path();
        this.f7270j = new RectF();
        this.f7275o = new PointF();
        this.f7267g = new Matrix();
        this.f7265e = new RadialGradient(0.0f, 0.0f, 16.0f, new int[]{this.f7280t, this.f7280t, 0}, f7259A, TileMode.CLAMP);
        if (this.f7277q == 1) {
            this.f7266f = new RadialGradient(0.0f, 0.0f, 16.0f, new int[]{0, C2173a.m12391a(this.f7280t, 0.0f), this.f7280t}, f7259A, TileMode.CLAMP);
        }
    }

    private int m12366a(float f, float f2) {
        return (int) Math.round(Math.sqrt(Math.pow((double) ((f2 < this.f7270j.centerY() ? this.f7270j.bottom : this.f7270j.top) - f2), 2.0d) + Math.pow((double) ((f < this.f7270j.centerX() ? this.f7270j.right : this.f7270j.left) - f), 2.0d)));
    }

    private void m12368a(Canvas canvas) {
        if (this.f7286z != 0) {
            if (this.f7274n > 0.0f) {
                this.f7263c.setColor(this.f7273m);
                this.f7263c.setAlpha(Math.round(((float) this.f7268h) * this.f7274n));
                canvas.drawPath(this.f7271k, this.f7263c);
            }
            if (this.f7276p > 0.0f && this.f7281u > 0.0f) {
                this.f7262b.setAlpha(Math.round(((float) this.f7268h) * this.f7281u));
                this.f7262b.setShader(this.f7265e);
                canvas.drawPath(this.f7271k, this.f7262b);
            }
        }
    }

    private boolean m12369a(float f, float f2, float f3) {
        if (this.f7275o.x == f && this.f7275o.y == f2 && this.f7276p == f3) {
            return false;
        }
        this.f7275o.set(f, f2);
        this.f7276p = f3;
        float f4 = this.f7276p / 16.0f;
        this.f7267g.reset();
        this.f7267g.postTranslate(f, f2);
        this.f7267g.postScale(f4, f4, f, f2);
        this.f7265e.setLocalMatrix(this.f7267g);
        if (this.f7266f != null) {
            this.f7266f.setLocalMatrix(this.f7267g);
        }
        return true;
    }

    private void m12370b(int i) {
        if (this.f7286z == i) {
            return;
        }
        if (this.f7286z != 0 || i == 1) {
            this.f7286z = i;
            if (this.f7286z == 0 || this.f7286z == 2) {
                stop();
            } else {
                start();
            }
        }
    }

    private void m12371b(Canvas canvas) {
        if (this.f7286z == 0) {
            return;
        }
        if (this.f7286z == 4) {
            if (this.f7276p == 0.0f) {
                this.f7263c.setColor(this.f7280t);
                canvas.drawPath(this.f7271k, this.f7263c);
                return;
            }
            this.f7262b.setShader(this.f7266f);
            canvas.drawPath(this.f7271k, this.f7262b);
        } else if (this.f7276p > 0.0f) {
            this.f7262b.setShader(this.f7265e);
            canvas.drawPath(this.f7271k, this.f7262b);
        }
    }

    private void m12374d() {
        this.f7285y = SystemClock.uptimeMillis();
    }

    private void m12375e() {
        int i = 4;
        float min;
        if (this.f7286z != 4) {
            min = Math.min(1.0f, ((float) (SystemClock.uptimeMillis() - this.f7285y)) / ((float) this.f7272l));
            this.f7274n = (this.f7283w.getInterpolation(min) * ((float) Color.alpha(this.f7273m))) / 255.0f;
            float min2 = Math.min(1.0f, ((float) (SystemClock.uptimeMillis() - this.f7285y)) / ((float) this.f7279s));
            this.f7281u = this.f7283w.getInterpolation(min2);
            m12369a(this.f7275o.x, this.f7275o.y, ((float) this.f7278r) * this.f7283w.getInterpolation(min2));
            if (min == 1.0f && min2 == 1.0f) {
                this.f7285y = SystemClock.uptimeMillis();
                if (this.f7286z == 1) {
                    i = 2;
                }
                m12370b(i);
            }
        } else {
            float min3 = Math.min(1.0f, ((float) (SystemClock.uptimeMillis() - this.f7285y)) / ((float) this.f7272l));
            this.f7274n = ((1.0f - this.f7284x.getInterpolation(min3)) * ((float) Color.alpha(this.f7273m))) / 255.0f;
            min = Math.min(1.0f, ((float) (SystemClock.uptimeMillis() - this.f7285y)) / ((float) this.f7279s));
            this.f7281u = 1.0f - this.f7284x.getInterpolation(min);
            m12369a(this.f7275o.x, this.f7275o.y, ((float) this.f7278r) * ((0.5f * this.f7284x.getInterpolation(min)) + 1.0f));
            if (min3 == 1.0f && min == 1.0f) {
                m12370b(0);
            }
        }
        if (isRunning()) {
            scheduleSelf(this.f7260B, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }

    private void m12376f() {
        float min = Math.min(1.0f, ((float) (SystemClock.uptimeMillis() - this.f7285y)) / ((float) this.f7279s));
        if (this.f7286z != 4) {
            m12369a(this.f7275o.x, this.f7275o.y, ((float) this.f7278r) * this.f7283w.getInterpolation(min));
            if (min == 1.0f) {
                this.f7285y = SystemClock.uptimeMillis();
                if (this.f7286z == 1) {
                    m12370b(2);
                } else {
                    m12369a(this.f7275o.x, this.f7275o.y, 0.0f);
                    m12370b(4);
                }
            }
        } else {
            m12369a(this.f7275o.x, this.f7275o.y, ((float) this.f7278r) * this.f7284x.getInterpolation(min));
            if (min == 1.0f) {
                m12370b(0);
            }
        }
        if (isRunning()) {
            scheduleSelf(this.f7260B, SystemClock.uptimeMillis() + 16);
        }
        invalidateSelf();
    }

    public Drawable m12377a() {
        return this.f7269i;
    }

    public void m12378a(int i) {
        this.f7282v = i;
    }

    public void m12379a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f7264d = new C2170b(i, i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public void m12380a(Drawable drawable) {
        this.f7269i = drawable;
        if (this.f7269i != null) {
            this.f7269i.setBounds(getBounds());
        }
    }

    public long m12381b() {
        switch (this.f7282v) {
            case 1:
                return this.f7286z == 3 ? ((long) Math.max(this.f7272l, this.f7279s)) - (SystemClock.uptimeMillis() - this.f7285y) : -1;
            case 2:
                return this.f7286z == 3 ? ((long) (Math.max(this.f7272l, this.f7279s) * 2)) - (SystemClock.uptimeMillis() - this.f7285y) : this.f7286z == 4 ? ((long) Math.max(this.f7272l, this.f7279s)) - (SystemClock.uptimeMillis() - this.f7285y) : -1;
            default:
                return -1;
        }
    }

    public void m12382c() {
        m12370b(0);
    }

    public void draw(Canvas canvas) {
        if (this.f7269i != null) {
            this.f7269i.draw(canvas);
        }
        switch (this.f7277q) {
            case -1:
            case 0:
                m12368a(canvas);
                return;
            case 1:
                m12371b(canvas);
                return;
            default:
                return;
        }
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return (this.f7286z == 0 || this.f7286z == 2 || !this.f7261a) ? false : true;
    }

    public boolean isStateful() {
        return this.f7269i != null && this.f7269i.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f7269i != null) {
            this.f7269i.setBounds(rect);
        }
        this.f7270j.set((float) (rect.left + this.f7264d.f7255c), (float) (rect.top + this.f7264d.f7256d), (float) (rect.right - this.f7264d.f7257e), (float) (rect.bottom - this.f7264d.f7258f));
        this.f7271k.reset();
        switch (this.f7264d.f7253a) {
            case 0:
                this.f7271k.addRoundRect(this.f7270j, this.f7264d.f7254b, Direction.CW);
                return;
            case 1:
                this.f7271k.addOval(this.f7270j, Direction.CW);
                return;
            default:
                return;
        }
    }

    protected boolean onStateChange(int[] iArr) {
        return this.f7269i != null && this.f7269i.setState(iArr);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                if (this.f7286z != 0 && this.f7286z != 4) {
                    if (this.f7277q == 0 && m12369a(motionEvent.getX(), motionEvent.getY(), this.f7276p)) {
                        invalidateSelf();
                        break;
                    }
                }
                if (this.f7277q == 1 || this.f7277q == -1) {
                    this.f7278r = m12366a(motionEvent.getX(), motionEvent.getY());
                }
                m12369a(motionEvent.getX(), motionEvent.getY(), 0.0f);
                m12370b(1);
                break;
                break;
            case 1:
            case 3:
                if (this.f7286z != 0) {
                    if (this.f7286z != 2) {
                        m12370b(3);
                        break;
                    }
                    if (this.f7277q == 1 || this.f7277q == -1) {
                        m12369a(this.f7275o.x, this.f7275o.y, 0.0f);
                    }
                    m12370b(4);
                    break;
                }
                break;
        }
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        this.f7261a = true;
        super.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f7268h = i;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f7263c.setColorFilter(colorFilter);
        this.f7262b.setColorFilter(colorFilter);
    }

    public void start() {
        if (!isRunning()) {
            m12374d();
            scheduleSelf(this.f7260B, SystemClock.uptimeMillis() + 16);
            invalidateSelf();
        }
    }

    public void stop() {
        this.f7261a = false;
        unscheduleSelf(this.f7260B);
        invalidateSelf();
    }
}
