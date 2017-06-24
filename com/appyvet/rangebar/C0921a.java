package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

public class C0921a {
    private final Paint f2828a = new Paint();
    private final Paint f2829b;
    private final float f2830c;
    private final float f2831d;
    private final float f2832e;
    private int f2833f;
    private float f2834g;
    private final float f2835h;

    public C0921a(Context context, float f, float f2, float f3, int i, float f4, int i2, float f5, int i3) {
        this.f2830c = f;
        this.f2831d = f + f3;
        this.f2832e = f2;
        this.f2833f = i - 1;
        this.f2834g = f3 / ((float) this.f2833f);
        this.f2835h = TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
        this.f2828a.setColor(i3);
        this.f2828a.setStrokeWidth(f5);
        this.f2828a.setAntiAlias(true);
        this.f2829b = new Paint();
        this.f2829b.setColor(i2);
        this.f2829b.setStrokeWidth(f5);
        this.f2829b.setAntiAlias(true);
    }

    public float m5506a() {
        return this.f2830c;
    }

    public float m5507a(C0923c c0923c) {
        int b = m5510b(c0923c);
        return (((float) b) * this.f2834g) + this.f2830c;
    }

    public void m5508a(Canvas canvas) {
        canvas.drawLine(this.f2830c, this.f2832e, this.f2831d, this.f2832e, this.f2828a);
    }

    public float m5509b() {
        return this.f2831d;
    }

    public int m5510b(C0923c c0923c) {
        return (int) (((c0923c.getX() - this.f2830c) + (this.f2834g / 2.0f)) / this.f2834g);
    }

    public void m5511b(Canvas canvas) {
        for (int i = 0; i < this.f2833f; i++) {
            canvas.drawCircle((((float) i) * this.f2834g) + this.f2830c, this.f2832e, this.f2835h, this.f2829b);
        }
        canvas.drawCircle(this.f2831d, this.f2832e, this.f2835h, this.f2829b);
    }
}
