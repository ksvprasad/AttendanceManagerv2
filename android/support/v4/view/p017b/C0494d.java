package android.support.v4.view.p017b;

import android.view.animation.Interpolator;

abstract class C0494d implements Interpolator {
    private final float[] f1272a;
    private final float f1273b = (1.0f / ((float) (this.f1272a.length - 1)));

    public C0494d(float[] fArr) {
        this.f1272a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f1272a.length - 1)) * f), this.f1272a.length - 2);
        float f2 = (f - (((float) min) * this.f1273b)) / this.f1273b;
        return ((this.f1272a[min + 1] - this.f1272a[min]) * f2) + this.f1272a[min];
    }
}
