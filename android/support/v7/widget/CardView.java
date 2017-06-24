package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p020c.C0699a.C0695a;
import android.support.v7.p020c.C0699a.C0697c;
import android.support.v7.p020c.C0699a.C0698d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] f2040a = new int[]{16842801};
    private static final af f2041b;
    private boolean f2042c;
    private boolean f2043d;
    private int f2044e;
    private int f2045f;
    private final Rect f2046g = new Rect();
    private final Rect f2047h = new Rect();
    private final ad f2048i = new C07581(this);

    class C07581 implements ad {
        final /* synthetic */ CardView f2038a;
        private Drawable f2039b;

        C07581(CardView cardView) {
            this.f2038a = cardView;
        }

        public void mo693a(int i, int i2) {
            if (i > this.f2038a.f2044e) {
                super.setMinimumWidth(i);
            }
            if (i2 > this.f2038a.f2045f) {
                super.setMinimumHeight(i2);
            }
        }

        public void mo694a(int i, int i2, int i3, int i4) {
            this.f2038a.f2047h.set(i, i2, i3, i4);
            super.setPadding(this.f2038a.f2046g.left + i, this.f2038a.f2046g.top + i2, this.f2038a.f2046g.right + i3, this.f2038a.f2046g.bottom + i4);
        }

        public void mo695a(Drawable drawable) {
            this.f2039b = drawable;
            this.f2038a.setBackgroundDrawable(drawable);
        }

        public boolean mo696a() {
            return this.f2038a.getUseCompatPadding();
        }

        public boolean mo697b() {
            return this.f2038a.getPreventCornerOverlap();
        }

        public Drawable mo698c() {
            return this.f2039b;
        }

        public View mo699d() {
            return this.f2038a;
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f2041b = new ac();
        } else if (VERSION.SDK_INT >= 17) {
            f2041b = new ag();
        } else {
            f2041b = new ae();
        }
        f2041b.mo775a();
    }

    public CardView(Context context) {
        super(context);
        m4055a(context, null, 0);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4055a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4055a(context, attributeSet, i);
    }

    private void m4055a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0698d.CardView, i, C0697c.CardView);
        if (obtainStyledAttributes.hasValue(C0698d.CardView_cardBackgroundColor)) {
            color = obtainStyledAttributes.getColor(C0698d.CardView_cardBackgroundColor, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f2040a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(C0695a.cardview_light_background) : getResources().getColor(C0695a.cardview_dark_background);
        }
        float dimension = obtainStyledAttributes.getDimension(C0698d.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0698d.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0698d.CardView_cardMaxElevation, 0.0f);
        this.f2042c = obtainStyledAttributes.getBoolean(C0698d.CardView_cardUseCompatPadding, false);
        this.f2043d = obtainStyledAttributes.getBoolean(C0698d.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_contentPadding, 0);
        this.f2046g.left = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f2046g.top = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_contentPaddingTop, dimensionPixelSize);
        this.f2046g.right = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_contentPaddingRight, dimensionPixelSize);
        this.f2046g.bottom = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.f2044e = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_android_minWidth, 0);
        this.f2045f = obtainStyledAttributes.getDimensionPixelSize(C0698d.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f2041b.mo778a(this.f2048i, context, color, dimension, dimension2, dimension3);
    }

    public float getCardElevation() {
        return f2041b.mo784e(this.f2048i);
    }

    public int getContentPaddingBottom() {
        return this.f2046g.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2046g.left;
    }

    public int getContentPaddingRight() {
        return this.f2046g.right;
    }

    public int getContentPaddingTop() {
        return this.f2046g.top;
    }

    public float getMaxCardElevation() {
        return f2041b.mo774a(this.f2048i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2043d;
    }

    public float getRadius() {
        return f2041b.mo783d(this.f2048i);
    }

    public boolean getUseCompatPadding() {
        return this.f2042c;
    }

    protected void onMeasure(int i, int i2) {
        if (f2041b instanceof ac) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2041b.mo779b(this.f2048i)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f2041b.mo781c(this.f2048i)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f2041b.mo777a(this.f2048i, i);
    }

    public void setCardElevation(float f) {
        f2041b.mo782c(this.f2048i, f);
    }

    public void setMaxCardElevation(float f) {
        f2041b.mo780b(this.f2048i, f);
    }

    public void setMinimumHeight(int i) {
        this.f2045f = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.f2044e = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f2043d) {
            this.f2043d = z;
            f2041b.mo786h(this.f2048i);
        }
    }

    public void setRadius(float f) {
        f2041b.mo776a(this.f2048i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2042c != z) {
            this.f2042c = z;
            f2041b.mo785g(this.f2048i);
        }
    }
}
