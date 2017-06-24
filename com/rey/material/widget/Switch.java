package com.rey.material.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Checkable;
import com.rey.material.C2167a.C2162b;
import com.rey.material.p040a.C2166a;
import com.rey.material.p040a.C2166a.C2164b;
import com.rey.material.p040a.C2166a.C2165c;
import com.rey.material.p041b.C2171a;
import com.rey.material.p042c.C2173a;
import com.rey.material.p042c.C2174b;
import com.rey.material.p042c.C2176d;

public class Switch extends View implements Checkable, C2165c {
    private int f7317A;
    private Path f7318B;
    private Paint f7319C;
    private boolean f7320D;
    private C2179a f7321E;
    private final Runnable f7322F;
    protected int f7323a;
    protected int f7324b;
    private C2181a f7325c;
    private boolean f7326d;
    private Paint f7327e;
    private RectF f7328f;
    private RectF f7329g;
    private Path f7330h;
    private int f7331i;
    private ColorStateList f7332j;
    private Cap f7333k;
    private int f7334l;
    private ColorStateList f7335m;
    private float f7336n;
    private int f7337o;
    private Interpolator f7338p;
    private int f7339q;
    private boolean f7340r;
    private float f7341s;
    private float f7342t;
    private float f7343u;
    private long f7344v;
    private int f7345w;
    private float f7346x;
    private int[] f7347y;
    private int f7348z;

    class C21771 implements Runnable {
        final /* synthetic */ Switch f7315a;

        C21771(Switch switchR) {
            this.f7315a = switchR;
        }

        public void run() {
            this.f7315a.m12418e();
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C21781();
        boolean f7316a;

        static class C21781 implements Creator<SavedState> {
            C21781() {
            }

            public SavedState m12407a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m12408a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m12407a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m12408a(i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7316a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "Switch.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " checked=" + this.f7316a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f7316a));
        }
    }

    public interface C2179a {
        void mo1795a(Switch switchR, boolean z);
    }

    public Switch(Context context) {
        super(context);
        this.f7324b = Integer.MIN_VALUE;
        this.f7326d = false;
        this.f7331i = -1;
        this.f7333k = Cap.ROUND;
        this.f7334l = -1;
        this.f7337o = -1;
        this.f7339q = 16;
        this.f7340r = false;
        this.f7347y = new int[2];
        this.f7348z = -1;
        this.f7317A = -1;
        this.f7320D = false;
        this.f7322F = new C21771(this);
        m12420a(context, null, 0, 0);
    }

    public Switch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7324b = Integer.MIN_VALUE;
        this.f7326d = false;
        this.f7331i = -1;
        this.f7333k = Cap.ROUND;
        this.f7334l = -1;
        this.f7337o = -1;
        this.f7339q = 16;
        this.f7340r = false;
        this.f7347y = new int[2];
        this.f7348z = -1;
        this.f7317A = -1;
        this.f7320D = false;
        this.f7322F = new C21771(this);
        m12420a(context, attributeSet, 0, 0);
    }

    public Switch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7324b = Integer.MIN_VALUE;
        this.f7326d = false;
        this.f7331i = -1;
        this.f7333k = Cap.ROUND;
        this.f7334l = -1;
        this.f7337o = -1;
        this.f7339q = 16;
        this.f7340r = false;
        this.f7347y = new int[2];
        this.f7348z = -1;
        this.f7317A = -1;
        this.f7320D = false;
        this.f7322F = new C21771(this);
        m12420a(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public Switch(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f7324b = Integer.MIN_VALUE;
        this.f7326d = false;
        this.f7331i = -1;
        this.f7333k = Cap.ROUND;
        this.f7334l = -1;
        this.f7337o = -1;
        this.f7339q = 16;
        this.f7340r = false;
        this.f7347y = new int[2];
        this.f7348z = -1;
        this.f7317A = -1;
        this.f7320D = false;
        this.f7322F = new C21771(this);
        m12420a(context, attributeSet, i, i2);
    }

    private int m12410a(boolean z) {
        this.f7347y[0] = isEnabled() ? 16842910 : -16842910;
        this.f7347y[1] = z ? 16842912 : -16842912;
        return this.f7332j.getColorForState(this.f7347y, 0);
    }

    private void m12411a() {
        if (this.f7348z > 0) {
            if (this.f7319C == null) {
                this.f7319C = new Paint(5);
                this.f7319C.setStyle(Style.FILL);
                this.f7319C.setDither(true);
            }
            float f = ((float) this.f7334l) / ((float) ((this.f7334l + this.f7348z) + this.f7317A));
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.f7319C.setShader(new RadialGradient(0.0f, f, (float) (this.f7334l + this.f7348z), new int[]{1275068416, 1275068416, 0}, fArr, TileMode.CLAMP));
            if (this.f7318B == null) {
                this.f7318B = new Path();
                this.f7318B.setFillType(FillType.EVEN_ODD);
            } else {
                this.f7318B.reset();
            }
            float f2 = (float) (this.f7334l + this.f7348z);
            this.f7329g.set(-f2, -f2, f2, f2);
            this.f7318B.addOval(this.f7329g, Direction.CW);
            f2 = (float) (this.f7334l - 1);
            this.f7329g.set(-f2, (-f2) - ((float) this.f7317A), f2, f2 - ((float) this.f7317A));
            this.f7318B.addOval(this.f7329g, Direction.CW);
        }
    }

    private void m12412a(float f, float f2, float f3) {
        float f4 = ((float) this.f7331i) / 2.0f;
        this.f7330h.reset();
        float asin;
        if (this.f7333k != Cap.ROUND) {
            this.f7329g.set((f - f3) + 1.0f, (f2 - f3) + 1.0f, (f + f3) - 1.0f, (f2 + f3) - 1.0f);
            asin = (float) ((Math.asin((double) (f4 / (f3 - 1.0f))) / 3.141592653589793d) * 180.0d);
            if (f - f3 > this.f7328f.left) {
                this.f7330h.moveTo(this.f7328f.left, f2 - f4);
                this.f7330h.arcTo(this.f7329g, 180.0f + asin, (-asin) * 2.0f);
                this.f7330h.lineTo(this.f7328f.left, f2 + f4);
                this.f7330h.close();
            }
            if (f + f3 < this.f7328f.right) {
                this.f7330h.moveTo(this.f7328f.right, f2 - f4);
                this.f7330h.arcTo(this.f7329g, -asin, asin * 2.0f);
                this.f7330h.lineTo(this.f7328f.right, f4 + f2);
                this.f7330h.close();
                return;
            }
            return;
        }
        asin = (float) ((Math.asin((double) (f4 / (f3 - 1.0f))) / 3.141592653589793d) * 180.0d);
        if (f - f3 > this.f7328f.left) {
            float acos = (float) ((Math.acos((double) Math.max(0.0f, (((this.f7328f.left + f4) - f) + f3) / f4)) / 3.141592653589793d) * 180.0d);
            this.f7329g.set(this.f7328f.left, f2 - f4, this.f7328f.left + ((float) this.f7331i), f2 + f4);
            this.f7330h.arcTo(this.f7329g, 180.0f - acos, acos * 2.0f);
            this.f7329g.set((f - f3) + 1.0f, (f2 - f3) + 1.0f, (f + f3) - 1.0f, (f2 + f3) - 1.0f);
            this.f7330h.arcTo(this.f7329g, 180.0f + asin, (-asin) * 2.0f);
            this.f7330h.close();
        }
        if (f + f3 < this.f7328f.right) {
            acos = (float) Math.acos((double) Math.max(0.0f, (((f + f3) - this.f7328f.right) + f4) / f4));
            this.f7330h.moveTo((float) (((double) (this.f7328f.right - f4)) + (Math.cos((double) acos) * ((double) f4))), (float) (((double) f2) + (Math.sin((double) acos) * ((double) f4))));
            acos = (float) ((((double) acos) / 3.141592653589793d) * 180.0d);
            this.f7329g.set(this.f7328f.right - ((float) this.f7331i), f2 - f4, this.f7328f.right, f4 + f2);
            this.f7330h.arcTo(this.f7329g, acos, (-acos) * 2.0f);
            this.f7329g.set((f - f3) + 1.0f, (f2 - f3) + 1.0f, (f + f3) - 1.0f, (f2 + f3) - 1.0f);
            this.f7330h.arcTo(this.f7329g, -asin, asin * 2.0f);
            this.f7330h.close();
        }
    }

    private int m12414b(boolean z) {
        this.f7347y[0] = isEnabled() ? 16842910 : -16842910;
        this.f7347y[1] = z ? 16842912 : -16842912;
        return this.f7335m.getColorForState(this.f7347y, 0);
    }

    private void m12415b() {
        this.f7344v = SystemClock.uptimeMillis();
        this.f7346x = this.f7336n;
        this.f7345w = (int) ((this.f7340r ? 1.0f - this.f7346x : this.f7346x) * ((float) this.f7337o));
    }

    private void m12416c() {
        if (getHandler() != null) {
            m12415b();
            this.f7326d = true;
            getHandler().postAtTime(this.f7322F, SystemClock.uptimeMillis() + 16);
        } else {
            this.f7336n = this.f7340r ? 1.0f : 0.0f;
        }
        invalidate();
    }

    private void m12417d() {
        this.f7326d = false;
        this.f7336n = this.f7340r ? 1.0f : 0.0f;
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.f7322F);
        }
        invalidate();
    }

    private void m12418e() {
        float min = Math.min(1.0f, ((float) (SystemClock.uptimeMillis() - this.f7344v)) / ((float) this.f7345w));
        float interpolation = this.f7338p.getInterpolation(min);
        if (this.f7340r) {
            interpolation += this.f7346x * (1.0f - interpolation);
        } else {
            interpolation = (1.0f - interpolation) * this.f7346x;
        }
        this.f7336n = interpolation;
        if (min == 1.0f) {
            m12417d();
        }
        if (this.f7326d) {
            if (getHandler() != null) {
                getHandler().postAtTime(this.f7322F, SystemClock.uptimeMillis() + 16);
            } else {
                m12417d();
            }
        }
        invalidate();
    }

    public void m12419a(int i) {
        C2176d.m12401a((View) this, i);
        m12422b(getContext(), null, 0, i);
    }

    protected void m12420a(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f7327e = new Paint(1);
        this.f7328f = new RectF();
        this.f7329g = new RectF();
        this.f7330h = new Path();
        this.f7343u = (float) ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        m12422b(context, attributeSet, i, i2);
        if (!isInEditMode()) {
            this.f7323a = C2166a.m12336a(context, attributeSet, i, i2);
        }
    }

    public void m12421a(C2164b c2164b) {
        int a = C2166a.m12337a().m12340a(this.f7323a);
        if (this.f7324b != a) {
            this.f7324b = a;
            m12419a(this.f7324b);
        }
    }

    protected void m12422b(Context context, AttributeSet attributeSet, int i, int i2) {
        getRippleManager().m12429a(this, context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2162b.Switch, i, i2);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == C2162b.Switch_sw_trackSize) {
                this.f7331i = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == C2162b.Switch_sw_trackColor) {
                this.f7332j = obtainStyledAttributes.getColorStateList(index);
            } else if (index == C2162b.Switch_sw_trackCap) {
                index = obtainStyledAttributes.getInteger(index, 0);
                if (index == 0) {
                    this.f7333k = Cap.BUTT;
                } else if (index == 1) {
                    this.f7333k = Cap.ROUND;
                } else {
                    this.f7333k = Cap.SQUARE;
                }
            } else if (index == C2162b.Switch_sw_thumbColor) {
                this.f7335m = obtainStyledAttributes.getColorStateList(index);
            } else if (index == C2162b.Switch_sw_thumbRadius) {
                this.f7334l = obtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == C2162b.Switch_sw_thumbElevation) {
                this.f7348z = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                this.f7317A = this.f7348z / 2;
            } else if (index == C2162b.Switch_sw_animDuration) {
                this.f7337o = obtainStyledAttributes.getInt(index, 0);
            } else if (index == C2162b.Switch_android_gravity) {
                this.f7339q = obtainStyledAttributes.getInt(index, 0);
            } else if (index == C2162b.Switch_android_checked) {
                setCheckedImmediately(obtainStyledAttributes.getBoolean(index, this.f7340r));
            } else if (index == C2162b.Switch_sw_interpolator) {
                index = obtainStyledAttributes.getResourceId(C2162b.Switch_sw_interpolator, 0);
                if (index != 0) {
                    this.f7338p = AnimationUtils.loadInterpolator(context, index);
                }
            }
        }
        obtainStyledAttributes.recycle();
        if (this.f7331i < 0) {
            this.f7331i = C2174b.m12394a(context, 2);
        }
        if (this.f7334l < 0) {
            this.f7334l = C2174b.m12394a(context, 8);
        }
        if (this.f7348z < 0) {
            this.f7348z = C2174b.m12394a(context, 2);
            this.f7317A = this.f7348z / 2;
        }
        if (this.f7337o < 0) {
            this.f7337o = context.getResources().getInteger(17694721);
        }
        if (this.f7338p == null) {
            this.f7338p = new DecelerateInterpolator();
        }
        if (this.f7332j == null) {
            r0 = new int[2][];
            r0[0] = new int[]{-16842912};
            r0[1] = new int[]{16842912};
            this.f7332j = new ColorStateList(r0, new int[]{C2173a.m12391a(C2174b.m12397b(context, -16777216), 0.5f), C2173a.m12391a(C2174b.m12398c(context, -16777216), 0.5f)});
        }
        if (this.f7335m == null) {
            r0 = new int[2][];
            r0[0] = new int[]{-16842912};
            r0[1] = new int[]{16842912};
            this.f7335m = new ColorStateList(r0, new int[]{16448250, C2174b.m12398c(context, -16777216)});
        }
        this.f7327e.setStrokeCap(this.f7333k);
        m12411a();
        invalidate();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        float width = (((this.f7328f.width() - ((float) (this.f7334l * 2))) * this.f7336n) + this.f7328f.left) + ((float) this.f7334l);
        if (this.f7320D) {
            width = (2.0f * this.f7328f.centerX()) - width;
        }
        float centerY = this.f7328f.centerY();
        m12412a(width, centerY, (float) this.f7334l);
        this.f7327e.setColor(C2173a.m12392a(m12410a(false), m12410a(true), this.f7336n));
        this.f7327e.setStyle(Style.FILL);
        canvas.drawPath(this.f7330h, this.f7327e);
        if (this.f7348z > 0) {
            int save = canvas.save();
            canvas.translate(width, ((float) this.f7317A) + centerY);
            canvas.drawPath(this.f7318B, this.f7319C);
            canvas.restoreToCount(save);
        }
        this.f7327e.setColor(C2173a.m12392a(m12414b(false), m12414b(true), this.f7336n));
        this.f7327e.setStyle(Style.FILL);
        canvas.drawCircle(width, centerY, (float) this.f7334l, this.f7327e);
    }

    protected C2181a getRippleManager() {
        if (this.f7325c == null) {
            synchronized (C2181a.class) {
                if (this.f7325c == null) {
                    this.f7325c = new C2181a();
                }
            }
        }
        return this.f7325c;
    }

    public int getSuggestedMinimumHeight() {
        return ((this.f7334l * 2) + Math.max(this.f7348z - this.f7317A, getPaddingTop())) + Math.max(this.f7348z + this.f7317A, getPaddingBottom());
    }

    public int getSuggestedMinimumWidth() {
        return ((this.f7334l * 4) + Math.max(this.f7348z, getPaddingLeft())) + Math.max(this.f7348z, getPaddingRight());
    }

    public boolean isChecked() {
        return this.f7340r;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f7323a != 0) {
            C2166a.m12337a().m12342a((C2165c) this);
            m12421a(null);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C2181a.m12423a((View) this);
        if (this.f7323a != 0) {
            C2166a.m12337a().m12343b((C2165c) this);
        }
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                size = Math.min(size, getSuggestedMinimumWidth());
                break;
            case 0:
                size = getSuggestedMinimumWidth();
                break;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = Math.min(size2, getSuggestedMinimumHeight());
                break;
            case 0:
                size2 = getSuggestedMinimumHeight();
                break;
        }
        setMeasuredDimension(size, size2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f7316a);
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        if (this.f7320D != z) {
            this.f7320D = z;
            invalidate();
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7316a = isChecked();
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f7328f.left = (float) Math.max(this.f7348z, getPaddingLeft());
        this.f7328f.right = (float) (i - Math.max(this.f7348z, getPaddingRight()));
        int i5 = this.f7334l * 2;
        switch (this.f7339q & 112) {
            case 48:
                this.f7328f.top = (float) Math.max(this.f7348z - this.f7317A, getPaddingTop());
                this.f7328f.bottom = ((float) i5) + this.f7328f.top;
                return;
            case 80:
                this.f7328f.bottom = (float) (i2 - Math.max(this.f7348z + this.f7317A, getPaddingBottom()));
                this.f7328f.top = this.f7328f.bottom - ((float) i5);
                return;
            default:
                this.f7328f.top = ((float) (i2 - i5)) / 2.0f;
                this.f7328f.bottom = ((float) i5) + this.f7328f.top;
                return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        super.onTouchEvent(motionEvent);
        getRippleManager().m12430a((View) this, motionEvent);
        float x = motionEvent.getX();
        if (this.f7320D) {
            x = (2.0f * this.f7328f.centerX()) - x;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.f7341s = x;
                this.f7342t = this.f7341s;
                this.f7344v = SystemClock.uptimeMillis();
                break;
            case 1:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                x = ((x - this.f7342t) / ((float) (SystemClock.uptimeMillis() - this.f7344v))) * 1000.0f;
                if (Math.abs(x) < this.f7343u) {
                    if ((!this.f7340r && this.f7336n < 0.1f) || (this.f7340r && this.f7336n > 0.9f)) {
                        toggle();
                        break;
                    }
                    if (this.f7336n > 0.5f) {
                        z = true;
                    }
                    setChecked(z);
                    break;
                }
                setChecked(x > 0.0f);
                break;
            case 2:
                this.f7336n = Math.min(1.0f, Math.max(0.0f, ((x - this.f7341s) / (this.f7328f.width() - ((float) (this.f7334l * 2)))) + this.f7336n));
                this.f7341s = x;
                invalidate();
                break;
            case 3:
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                if (this.f7336n > 0.5f) {
                    z = true;
                }
                setChecked(z);
                break;
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Drawable background = getBackground();
        if (!(background instanceof C2171a) || (drawable instanceof C2171a)) {
            super.setBackgroundDrawable(drawable);
        } else {
            ((C2171a) background).m12380a(drawable);
        }
    }

    public void setChecked(boolean z) {
        if (this.f7340r != z) {
            this.f7340r = z;
            if (this.f7321E != null) {
                this.f7321E.mo1795a(this, this.f7340r);
            }
        }
        if (this.f7336n != (this.f7340r ? 1.0f : 0.0f)) {
            m12416c();
        }
    }

    public void setCheckedImmediately(boolean z) {
        if (this.f7340r != z) {
            this.f7340r = z;
            if (this.f7321E != null) {
                this.f7321E.mo1795a(this, this.f7340r);
            }
        }
        this.f7336n = this.f7340r ? 1.0f : 0.0f;
        invalidate();
    }

    public void setOnCheckedChangeListener(C2179a c2179a) {
        this.f7321E = c2179a;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        OnClickListener rippleManager = getRippleManager();
        if (onClickListener == rippleManager) {
            super.setOnClickListener(onClickListener);
            return;
        }
        rippleManager.m12428a(onClickListener);
        setOnClickListener(rippleManager);
    }

    public void toggle() {
        if (isEnabled()) {
            setChecked(!this.f7340r);
        }
    }
}
