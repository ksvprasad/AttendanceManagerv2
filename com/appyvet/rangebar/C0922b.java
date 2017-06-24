package com.appyvet.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.util.TypedValue;

public class C0922b {
    private final Paint f2836a = new Paint();
    private final float f2837b;

    public C0922b(Context context, float f, float f2, int i) {
        float applyDimension = TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
        this.f2836a.setColor(i);
        this.f2836a.setStrokeWidth(applyDimension);
        this.f2836a.setStrokeCap(Cap.ROUND);
        this.f2836a.setAntiAlias(true);
        this.f2837b = f;
    }

    public void m5512a(Canvas canvas, float f, C0923c c0923c) {
        canvas.drawLine(f, this.f2837b, c0923c.getX(), this.f2837b, this.f2836a);
    }

    public void m5513a(Canvas canvas, C0923c c0923c, C0923c c0923c2) {
        canvas.drawLine(c0923c.getX(), this.f2837b, c0923c2.getX(), this.f2837b, this.f2836a);
    }
}
