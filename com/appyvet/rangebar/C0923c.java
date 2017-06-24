package com.appyvet.rangebar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import com.appyvet.rangebar.C0926d.C0924a;

class C0923c extends View {
    private float f2838a;
    private boolean f2839b = false;
    private float f2840c;
    private float f2841d;
    private Paint f2842e;
    private Drawable f2843f;
    private String f2844g;
    private int f2845h;
    private ColorFilter f2846i;
    private float f2847j;
    private float f2848k;
    private Rect f2849l = new Rect();
    private Resources f2850m;
    private Paint f2851n;
    private float f2852o;

    public C0923c(Context context) {
        super(context);
    }

    private static void m5514a(Paint paint, String str, float f, float f2, float f3) {
        paint.setTextSize(10.0f);
        paint.setTextSize(Math.max(Math.min((f3 / paint.measureText(str)) * 10.0f, f2), f));
    }

    public void m5515a() {
        this.f2839b = true;
    }

    public void m5516a(float f, float f2) {
        this.f2847j = (float) ((int) f2);
        this.f2845h = (int) f;
        invalidate();
    }

    public void m5517a(Context context, float f, float f2, int i, int i2, float f3, int i3) {
        this.f2850m = context.getResources();
        this.f2843f = context.getResources().getDrawable(C0924a.rotate);
        this.f2847j = (float) ((int) TypedValue.applyDimension(1, 15.0f, this.f2850m.getDisplayMetrics()));
        this.f2852o = f3;
        this.f2848k = (float) ((int) TypedValue.applyDimension(1, 3.5f, this.f2850m.getDisplayMetrics()));
        if (f2 == -1.0f) {
            this.f2845h = (int) TypedValue.applyDimension(1, 14.0f, this.f2850m.getDisplayMetrics());
        } else {
            this.f2845h = (int) TypedValue.applyDimension(1, f2, this.f2850m.getDisplayMetrics());
        }
        int applyDimension = (int) TypedValue.applyDimension(2, 15.0f, this.f2850m.getDisplayMetrics());
        this.f2842e = new Paint();
        this.f2842e.setColor(i2);
        this.f2842e.setAntiAlias(true);
        this.f2842e.setTextSize((float) applyDimension);
        this.f2851n = new Paint();
        this.f2851n.setColor(i3);
        this.f2851n.setAntiAlias(true);
        this.f2846i = new LightingColorFilter(i, i);
        this.f2838a = TypedValue.applyDimension(1, (float) ((int) Math.max(24.0f, (float) this.f2845h)), this.f2850m.getDisplayMetrics());
        this.f2840c = f;
    }

    public void m5518a(String str) {
        this.f2844g = str;
    }

    public void m5519b() {
        this.f2839b = false;
    }

    public boolean m5520b(float f, float f2) {
        return Math.abs(f - this.f2841d) <= this.f2838a && Math.abs((f2 - this.f2840c) + this.f2847j) <= this.f2838a;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(this.f2841d, this.f2840c, this.f2852o, this.f2851n);
        if (this.f2845h > 0) {
            this.f2849l.set(((int) this.f2841d) - this.f2845h, (((int) this.f2840c) - (this.f2845h * 2)) - ((int) this.f2847j), ((int) this.f2841d) + this.f2845h, ((int) this.f2840c) - ((int) this.f2847j));
            this.f2843f.setBounds(this.f2849l);
            String str = this.f2844g;
            if (this.f2844g.length() > 4) {
                str = this.f2844g.substring(0, 4);
            }
            C0923c.m5514a(this.f2842e, str, 8.0f, 24.0f, (float) this.f2849l.width());
            this.f2842e.getTextBounds(str, 0, str.length(), this.f2849l);
            this.f2842e.setTextAlign(Align.CENTER);
            this.f2843f.setColorFilter(this.f2846i);
            this.f2843f.draw(canvas);
            canvas.drawText(str, this.f2841d, ((this.f2840c - ((float) this.f2845h)) - this.f2847j) + this.f2848k, this.f2842e);
        }
    }

    public float getX() {
        return this.f2841d;
    }

    public boolean isPressed() {
        return this.f2839b;
    }

    public void setX(float f) {
        this.f2841d = f;
    }
}
