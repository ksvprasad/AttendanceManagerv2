package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ag;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class C0901v extends RatingBar {
    private C0899t f2750a;
    private C0893m f2751b;

    public C0901v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.ratingBarStyle);
    }

    public C0901v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2751b = C0893m.m5425a();
        this.f2750a = new C0899t(this, this.f2751b);
        this.f2750a.mo870a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f2750a.m5459a();
        if (a != null) {
            setMeasuredDimension(ag.m2508a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
