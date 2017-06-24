package com.appyvet.rangebar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.appyvet.rangebar.C0926d.C0925b;
import java.util.HashMap;

public class RangeBar extends View {
    private int f2790A;
    private boolean f2791B = true;
    private float f2792C = 16.0f;
    private float f2793D = 24.0f;
    private int f2794E;
    private int f2795F;
    private int f2796G;
    private int f2797H;
    private int f2798I;
    private int f2799J;
    private float f2800K;
    private float f2801L;
    private float f2802a = 1.0f;
    private float f2803b = 0.0f;
    private float f2804c = 5.0f;
    private float f2805d = 1.0f;
    private float f2806e = 2.0f;
    private int f2807f = -3355444;
    private int f2808g = -12627531;
    private int f2809h = -1;
    private float f2810i = 4.0f;
    private int f2811j = -12627531;
    private float f2812k = 14.0f;
    private int f2813l = -16777216;
    private float f2814m = 14.0f;
    private int f2815n = -12627531;
    private float f2816o = 5.0f;
    private boolean f2817p = true;
    private int f2818q = 500;
    private int f2819r = 150;
    private int f2820s = (((int) ((this.f2804c - this.f2803b) / this.f2805d)) + 1);
    private C0923c f2821t;
    private C0923c f2822u;
    private C0921a f2823v;
    private C0922b f2824w;
    private C0920a f2825x;
    private HashMap<Float, String> f2826y;
    private int f2827z;

    public interface C0920a {
        void mo1794a(RangeBar rangeBar, int i, int i2, String str, String str2);
    }

    public RangeBar(Context context) {
        super(context);
    }

    public RangeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5494a(context, attributeSet);
    }

    public RangeBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5494a(context, attributeSet);
    }

    private void m5491a() {
        this.f2823v = new C0921a(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.f2820s, this.f2802a, this.f2813l, this.f2806e, this.f2807f);
        invalidate();
    }

    private void m5492a(float f) {
        if (this.f2791B && this.f2821t.isPressed()) {
            m5496a(this.f2821t, f);
        } else if (this.f2822u.isPressed()) {
            m5496a(this.f2822u, f);
        }
        if (this.f2791B && this.f2821t.getX() > this.f2822u.getX()) {
            C0923c c0923c = this.f2821t;
            this.f2821t = this.f2822u;
            this.f2822u = c0923c;
        }
        int b = this.f2791B ? this.f2823v.m5510b(this.f2821t) : 0;
        int b2 = this.f2823v.m5510b(this.f2822u);
        if (b != this.f2827z || b2 != this.f2790A) {
            this.f2827z = b;
            this.f2790A = b2;
            if (this.f2791B) {
                this.f2821t.m5518a(m5499b(this.f2827z));
            }
            this.f2822u.m5518a(m5499b(this.f2790A));
            if (this.f2825x != null) {
                this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
            }
        }
    }

    private void m5493a(float f, float f2) {
        if (this.f2791B) {
            if (!this.f2822u.isPressed() && this.f2821t.m5520b(f, f2)) {
                m5495a(this.f2821t);
            } else if (!this.f2821t.isPressed() && this.f2822u.m5520b(f, f2)) {
                m5495a(this.f2822u);
            }
        } else if (this.f2822u.m5520b(f, f2)) {
            m5495a(this.f2822u);
        }
    }

    private void m5494a(Context context, AttributeSet attributeSet) {
        if (this.f2826y == null) {
            this.f2826y = new HashMap();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0925b.RangeBar, 0, 0);
        try {
            float f = obtainStyledAttributes.getFloat(C0925b.RangeBar_tickStart, 0.0f);
            float f2 = obtainStyledAttributes.getFloat(C0925b.RangeBar_tickEnd, 5.0f);
            float f3 = obtainStyledAttributes.getFloat(C0925b.RangeBar_tickInterval, 1.0f);
            int i = ((int) ((f2 - f) / f3)) + 1;
            if (m5497a(i)) {
                this.f2820s = i;
                this.f2803b = f;
                this.f2804c = f2;
                this.f2805d = f3;
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            } else {
                Log.e("RangeBar", "tickCount less than 2; invalid tickCount. XML input ignored.");
            }
            this.f2802a = obtainStyledAttributes.getDimension(C0925b.RangeBar_tickHeight, 1.0f);
            this.f2806e = obtainStyledAttributes.getDimension(C0925b.RangeBar_barWeight, 2.0f);
            this.f2807f = obtainStyledAttributes.getColor(C0925b.RangeBar_barColor, -3355444);
            this.f2809h = obtainStyledAttributes.getColor(C0925b.RangeBar_textColor, -1);
            this.f2808g = obtainStyledAttributes.getColor(C0925b.RangeBar_pinColor, -12627531);
            this.f2795F = this.f2807f;
            this.f2816o = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(C0925b.RangeBar_selectorSize, 5.0f), getResources().getDisplayMetrics());
            this.f2815n = obtainStyledAttributes.getColor(C0925b.RangeBar_selectorColor, -12627531);
            this.f2797H = this.f2815n;
            this.f2813l = obtainStyledAttributes.getColor(C0925b.RangeBar_tickColor, -16777216);
            this.f2796G = this.f2813l;
            this.f2810i = obtainStyledAttributes.getDimension(C0925b.RangeBar_connectingLineWeight, 4.0f);
            this.f2811j = obtainStyledAttributes.getColor(C0925b.RangeBar_connectingLineColor, -12627531);
            this.f2794E = this.f2811j;
            this.f2814m = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(C0925b.RangeBar_pinRadius, 14.0f), getResources().getDisplayMetrics());
            this.f2792C = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(C0925b.RangeBar_pinPadding, 16.0f), getResources().getDisplayMetrics());
            this.f2793D = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(C0925b.RangeBar_barPaddingBottom, 24.0f), getResources().getDisplayMetrics());
            this.f2791B = obtainStyledAttributes.getBoolean(C0925b.RangeBar_rangeBar, true);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void m5495a(final C0923c c0923c) {
        if (this.f2817p) {
            this.f2817p = false;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.f2814m});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ RangeBar f2787b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f2787b.f2812k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c0923c.m5516a(this.f2787b.f2812k, this.f2787b.f2792C * valueAnimator.getAnimatedFraction());
                this.f2787b.invalidate();
            }
        });
        ofFloat.start();
        c0923c.m5515a();
    }

    private void m5496a(C0923c c0923c, float f) {
        if (f >= this.f2823v.m5506a() && f <= this.f2823v.m5509b()) {
            c0923c.setX(f);
            invalidate();
        }
    }

    private boolean m5497a(int i) {
        return i > 1;
    }

    private String m5499b(int i) {
        float f = i == this.f2820s + -1 ? this.f2804c : (((float) i) * this.f2805d) + this.f2803b;
        String str = (String) this.f2826y.get(Float.valueOf(f));
        return str == null ? ((double) f) == Math.ceil((double) f) ? String.valueOf((int) f) : String.valueOf(f) : str;
    }

    private void m5500b() {
        this.f2824w = new C0922b(getContext(), getYPos(), this.f2810i, this.f2811j);
        invalidate();
    }

    private void m5501b(float f, float f2) {
        if (this.f2791B && this.f2821t.isPressed()) {
            m5502b(this.f2821t);
        } else if (this.f2822u.isPressed()) {
            m5502b(this.f2822u);
        } else {
            if ((this.f2791B ? Math.abs(this.f2821t.getX() - f) : 0.0f) >= Math.abs(this.f2822u.getX() - f)) {
                this.f2822u.setX(f);
                m5502b(this.f2822u);
            } else if (this.f2791B) {
                this.f2821t.setX(f);
                m5502b(this.f2821t);
            }
            int b = this.f2791B ? this.f2823v.m5510b(this.f2821t) : 0;
            int b2 = this.f2823v.m5510b(this.f2822u);
            if (b != this.f2827z || b2 != this.f2790A) {
                this.f2827z = b;
                this.f2790A = b2;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
        }
    }

    private void m5502b(final C0923c c0923c) {
        c0923c.setX(this.f2823v.m5507a(c0923c));
        c0923c.m5518a(m5499b(this.f2823v.m5510b(c0923c)));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f2814m, 0.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            final /* synthetic */ RangeBar f2789b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f2789b.f2812k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c0923c.m5516a(this.f2789b.f2812k, this.f2789b.f2792C - (this.f2789b.f2792C * valueAnimator.getAnimatedFraction()));
                this.f2789b.invalidate();
            }
        });
        ofFloat.start();
        c0923c.m5519b();
    }

    private boolean m5503b(int i, int i2) {
        return i < 0 || i >= this.f2820s || i2 < 0 || i2 >= this.f2820s;
    }

    private void m5504c() {
        Context context = getContext();
        float yPos = getYPos();
        if (this.f2791B) {
            this.f2821t = new C0923c(context);
            this.f2821t.m5517a(context, yPos, 0.0f, this.f2808g, this.f2809h, this.f2816o, this.f2815n);
        }
        this.f2822u = new C0923c(context);
        this.f2822u.m5517a(context, yPos, 0.0f, this.f2808g, this.f2809h, this.f2816o, this.f2815n);
        float marginLeft = getMarginLeft();
        float barLength = getBarLength();
        if (this.f2791B) {
            this.f2821t.setX(((((float) this.f2827z) / ((float) (this.f2820s - 1))) * barLength) + marginLeft);
            this.f2821t.m5518a(m5499b(this.f2827z));
        }
        this.f2822u.setX(marginLeft + (barLength * (((float) this.f2790A) / ((float) (this.f2820s - 1)))));
        this.f2822u.m5518a(m5499b(this.f2790A));
        invalidate();
    }

    private float getBarLength() {
        return ((float) getWidth()) - (2.0f * getMarginLeft());
    }

    private float getMarginLeft() {
        return this.f2814m;
    }

    private float getYPos() {
        return ((float) getHeight()) - this.f2793D;
    }

    public void m5505a(int i, int i2) {
        if (m5503b(i, i2)) {
            Log.e("RangeBar", "Pin index left " + i + ", or right " + i2 + " is out of bounds. Check that it is greater than the minimum (" + this.f2803b + ") and less than the maximum value (" + this.f2804c + ")");
            throw new IllegalArgumentException("Pin index left " + i + ", or right " + i2 + " is out of bounds. Check that it is greater than the minimum (" + this.f2803b + ") and less than the maximum value (" + this.f2804c + ")");
        }
        if (this.f2817p) {
            this.f2817p = false;
        }
        this.f2827z = i;
        this.f2790A = i2;
        m5504c();
        if (this.f2825x != null) {
            this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
        }
        invalidate();
        requestLayout();
    }

    public int getLeftIndex() {
        return this.f2827z;
    }

    public int getRightIndex() {
        return this.f2790A;
    }

    public int getTickCount() {
        return this.f2820s;
    }

    public float getTickEnd() {
        return this.f2804c;
    }

    public double getTickInterval() {
        return (double) this.f2805d;
    }

    public float getTickStart() {
        return this.f2803b;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2823v.m5508a(canvas);
        if (this.f2791B) {
            this.f2824w.m5513a(canvas, this.f2821t, this.f2822u);
            this.f2823v.m5511b(canvas);
            this.f2821t.draw(canvas);
        } else {
            this.f2824w.m5512a(canvas, getMarginLeft(), this.f2822u);
            this.f2823v.m5511b(canvas);
        }
        this.f2822u.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (!(mode == Integer.MIN_VALUE || mode == 1073741824)) {
            size = this.f2818q;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(this.f2819r, size2);
        } else if (mode2 != 1073741824) {
            size2 = this.f2819r;
        }
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f2820s = bundle.getInt("TICK_COUNT");
            this.f2803b = bundle.getFloat("TICK_START");
            this.f2804c = bundle.getFloat("TICK_END");
            this.f2805d = bundle.getFloat("TICK_INTERVAL");
            this.f2813l = bundle.getInt("TICK_COLOR");
            this.f2802a = bundle.getFloat("TICK_HEIGHT_DP");
            this.f2806e = bundle.getFloat("BAR_WEIGHT");
            this.f2807f = bundle.getInt("BAR_COLOR");
            this.f2816o = bundle.getFloat("CIRCLE_SIZE");
            this.f2815n = bundle.getInt("CIRCLE_COLOR");
            this.f2810i = bundle.getFloat("CONNECTING_LINE_WEIGHT");
            this.f2811j = bundle.getInt("CONNECTING_LINE_COLOR");
            this.f2812k = bundle.getFloat("THUMB_RADIUS_DP");
            this.f2814m = bundle.getFloat("EXPANDED_PIN_RADIUS_DP");
            this.f2792C = bundle.getFloat("PIN_PADDING");
            this.f2793D = bundle.getFloat("BAR_PADDING_BOTTOM");
            this.f2791B = bundle.getBoolean("IS_RANGE_BAR");
            this.f2827z = bundle.getInt("LEFT_INDEX");
            this.f2790A = bundle.getInt("RIGHT_INDEX");
            this.f2817p = bundle.getBoolean("FIRST_SET_TICK_COUNT");
            m5505a(this.f2827z, this.f2790A);
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("TICK_COUNT", this.f2820s);
        bundle.putFloat("TICK_START", this.f2803b);
        bundle.putFloat("TICK_END", this.f2804c);
        bundle.putFloat("TICK_INTERVAL", this.f2805d);
        bundle.putInt("TICK_COLOR", this.f2813l);
        bundle.putFloat("TICK_HEIGHT_DP", this.f2802a);
        bundle.putFloat("BAR_WEIGHT", this.f2806e);
        bundle.putInt("BAR_COLOR", this.f2807f);
        bundle.putFloat("CONNECTING_LINE_WEIGHT", this.f2810i);
        bundle.putInt("CONNECTING_LINE_COLOR", this.f2811j);
        bundle.putFloat("CIRCLE_SIZE", this.f2816o);
        bundle.putInt("CIRCLE_COLOR", this.f2815n);
        bundle.putFloat("THUMB_RADIUS_DP", this.f2812k);
        bundle.putFloat("EXPANDED_PIN_RADIUS_DP", this.f2814m);
        bundle.putFloat("PIN_PADDING", this.f2792C);
        bundle.putFloat("BAR_PADDING_BOTTOM", this.f2793D);
        bundle.putBoolean("IS_RANGE_BAR", this.f2791B);
        bundle.putInt("LEFT_INDEX", this.f2827z);
        bundle.putInt("RIGHT_INDEX", this.f2790A);
        bundle.putBoolean("FIRST_SET_TICK_COUNT", this.f2817p);
        return bundle;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Context context = getContext();
        float f = ((float) i2) - this.f2793D;
        if (this.f2791B) {
            this.f2821t = new C0923c(context);
            this.f2821t.m5517a(context, f, 0.0f, this.f2808g, this.f2809h, this.f2816o, this.f2815n);
        }
        this.f2822u = new C0923c(context);
        this.f2822u.m5517a(context, f, 0.0f, this.f2808g, this.f2809h, this.f2816o, this.f2815n);
        float f2 = this.f2814m;
        float f3 = ((float) i) - (2.0f * f2);
        this.f2823v = new C0921a(context, f2, f, f3, this.f2820s, this.f2802a, this.f2813l, this.f2806e, this.f2807f);
        if (this.f2791B) {
            this.f2821t.setX(((((float) this.f2827z) / ((float) (this.f2820s - 1))) * f3) + f2);
            this.f2821t.m5518a(m5499b(this.f2827z));
        }
        this.f2822u.setX(((((float) this.f2790A) / ((float) (this.f2820s - 1))) * f3) + f2);
        this.f2822u.m5518a(m5499b(this.f2790A));
        int b = this.f2791B ? this.f2823v.m5510b(this.f2821t) : 0;
        int b2 = this.f2823v.m5510b(this.f2822u);
        if (!((b == this.f2827z && b2 == this.f2790A) || this.f2825x == null)) {
            this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
        }
        this.f2824w = new C0922b(context, f, this.f2810i, this.f2811j);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f2798I = 0;
                this.f2799J = 0;
                this.f2800K = motionEvent.getX();
                this.f2801L = motionEvent.getY();
                m5493a(motionEvent.getX(), motionEvent.getY());
                return true;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                m5501b(motionEvent.getX(), motionEvent.getY());
                return true;
            case 2:
                m5492a(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f2798I = (int) (((float) this.f2798I) + Math.abs(x - this.f2800K));
                this.f2799J = (int) (((float) this.f2799J) + Math.abs(y - this.f2801L));
                this.f2800K = x;
                this.f2801L = y;
                if (this.f2798I >= this.f2799J) {
                    return true;
                }
                getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            default:
                return false;
        }
    }

    public void setBarColor(int i) {
        this.f2807f = i;
        m5491a();
    }

    public void setBarWeight(float f) {
        this.f2806e = f;
        m5491a();
    }

    public void setConnectingLineColor(int i) {
        this.f2811j = i;
        m5500b();
    }

    public void setConnectingLineWeight(float f) {
        this.f2810i = f;
        m5500b();
    }

    public void setEnabled(boolean z) {
        if (z) {
            this.f2807f = this.f2795F;
            this.f2811j = this.f2794E;
            this.f2815n = this.f2797H;
            this.f2813l = this.f2796G;
        } else {
            this.f2807f = -3355444;
            this.f2811j = -3355444;
            this.f2815n = -3355444;
            this.f2813l = -3355444;
        }
        m5491a();
        m5504c();
        m5500b();
        super.setEnabled(z);
    }

    public void setOnRangeBarChangeListener(C0920a c0920a) {
        this.f2825x = c0920a;
    }

    public void setPinColor(int i) {
        this.f2808g = i;
        m5504c();
    }

    public void setPinRadius(float f) {
        this.f2814m = f;
        m5504c();
    }

    public void setPinTextColor(int i) {
        this.f2809h = i;
        m5504c();
    }

    public void setRangeBarEnabled(boolean z) {
        this.f2791B = z;
        invalidate();
    }

    public void setSeekPinByIndex(int i) {
        if (i < 0 || i > this.f2820s) {
            Log.e("RangeBar", "Pin index " + i + " is out of bounds. Check that it is greater than the minimum (" + 0 + ") and less than the maximum value (" + this.f2820s + ")");
            throw new IllegalArgumentException("Pin index " + i + " is out of bounds. Check that it is greater than the minimum (" + 0 + ") and less than the maximum value (" + this.f2820s + ")");
        }
        if (this.f2817p) {
            this.f2817p = false;
        }
        this.f2790A = i;
        m5504c();
        if (this.f2825x != null) {
            this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
        }
        invalidate();
        requestLayout();
    }

    public void setSeekPinByValue(float f) {
        if (f > this.f2804c || f < this.f2803b) {
            Log.e("RangeBar", "Pin value " + f + " is out of bounds. Check that it is greater than the minimum (" + this.f2803b + ") and less than the maximum value (" + this.f2804c + ")");
            throw new IllegalArgumentException("Pin value " + f + " is out of bounds. Check that it is greater than the minimum (" + this.f2803b + ") and less than the maximum value (" + this.f2804c + ")");
        }
        if (this.f2817p) {
            this.f2817p = false;
        }
        this.f2790A = (int) ((f - this.f2803b) / this.f2805d);
        m5504c();
        if (this.f2825x != null) {
            this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
        }
        invalidate();
        requestLayout();
    }

    public void setSelectorColor(int i) {
        this.f2815n = i;
        m5504c();
    }

    public void setTickColor(int i) {
        this.f2813l = i;
        m5491a();
    }

    public void setTickEnd(float f) {
        int i = ((int) ((f - this.f2803b) / this.f2805d)) + 1;
        if (m5497a(i)) {
            this.f2820s = i;
            this.f2804c = f;
            if (this.f2817p) {
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
            if (m5503b(this.f2827z, this.f2790A)) {
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
            m5491a();
            m5504c();
            return;
        }
        Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }

    public void setTickHeight(float f) {
        this.f2802a = f;
        m5491a();
    }

    public void setTickInterval(float f) {
        int i = ((int) ((this.f2804c - this.f2803b) / f)) + 1;
        if (m5497a(i)) {
            this.f2820s = i;
            this.f2805d = f;
            if (this.f2817p) {
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
            if (m5503b(this.f2827z, this.f2790A)) {
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
            m5491a();
            m5504c();
            return;
        }
        Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }

    public void setTickStart(float f) {
        int i = ((int) ((this.f2804c - f) / this.f2805d)) + 1;
        if (m5497a(i)) {
            this.f2820s = i;
            this.f2803b = f;
            if (this.f2817p) {
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
            if (m5503b(this.f2827z, this.f2790A)) {
                this.f2827z = 0;
                this.f2790A = this.f2820s - 1;
                if (this.f2825x != null) {
                    this.f2825x.mo1794a(this, this.f2827z, this.f2790A, m5499b(this.f2827z), m5499b(this.f2790A));
                }
            }
            m5491a();
            m5504c();
            return;
        }
        Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
        throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
    }
}
