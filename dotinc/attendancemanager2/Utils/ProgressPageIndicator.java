package dotinc.attendancemanager2.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0115f;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dotinc.attendancemanager2.C2295a.C2265a;

public class ProgressPageIndicator extends LinearLayout implements C0115f {
    private float f7729a;
    private float f7730b;
    private float f7731c;
    private int f7732d;
    private int f7733e;
    private int f7734f;
    private int f7735g;
    private ShapeDrawable f7736h;
    private GradientDrawable f7737i;
    private ViewPager f7738j;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C22551();
        int f7728a;

        static class C22551 implements Creator<SavedState> {
            C22551() {
            }

            public SavedState m12689a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m12690a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m12689a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m12690a(i);
            }
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f7728a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f7728a);
        }
    }

    public ProgressPageIndicator(Context context) {
        this(context, null);
    }

    public ProgressPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressPageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7729a = 20.0f;
        this.f7730b = 2.0f;
        this.f7731c = 10.0f;
        this.f7734f = Color.parseColor("#ffffff");
        this.f7735g = Color.parseColor("#ffffff");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2265a.ProgressPageIndicator, i, 0);
        this.f7729a = obtainStyledAttributes.getDimension(2, 20.0f);
        this.f7731c = obtainStyledAttributes.getDimension(4, 10.0f);
        this.f7730b = obtainStyledAttributes.getDimension(3, 2.0f);
        this.f7735g = obtainStyledAttributes.getColor(0, Color.parseColor("#ffffff"));
        this.f7734f = obtainStyledAttributes.getColor(1, Color.parseColor("#ffffff"));
        obtainStyledAttributes.recycle();
        m12691a();
    }

    private void m12691a() {
        this.f7736h = new ShapeDrawable(new OvalShape());
        this.f7736h.getPaint().setStyle(Style.FILL);
        this.f7736h.getPaint().setColor(this.f7735g);
        this.f7736h.getPaint().setAntiAlias(true);
        this.f7736h.setIntrinsicHeight((int) this.f7729a);
        this.f7736h.setIntrinsicWidth((int) this.f7729a);
        this.f7737i = new GradientDrawable();
        this.f7737i.setColor(0);
        this.f7737i.setShape(1);
        this.f7737i.setStroke((int) this.f7730b, this.f7734f);
        this.f7737i.setSize((int) this.f7729a, (int) this.f7729a);
    }

    private void m12692b() {
        m12693c();
        m12694d();
    }

    private void m12693c() {
        removeAllViews();
        for (int i = 0; i < this.f7733e; i++) {
            View imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.f7729a, (int) this.f7729a);
            if (i != 0) {
                if (getOrientation() == 0) {
                    layoutParams.setMargins((int) this.f7731c, 0, 0, 0);
                } else {
                    layoutParams.setMargins(0, (int) this.f7731c, 0, 0);
                }
            }
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(this.f7737i);
            imageView.setId(i);
            addView(imageView);
        }
    }

    private void m12694d() {
        int i;
        for (i = 0; i <= this.f7732d; i++) {
            ((ImageView) findViewById(i)).setImageDrawable(this.f7736h.getCurrent());
        }
        for (i = this.f7732d + 1; i < this.f7733e; i++) {
            ((ImageView) findViewById(i)).setImageDrawable(this.f7737i.getCurrent());
        }
    }

    public void mo107a(int i) {
    }

    public void mo108a(int i, float f, int i2) {
    }

    public void m12697a(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentPage(i);
        m12692b();
    }

    public void mo109b(int i) {
        this.f7732d = i;
        m12694d();
    }

    public void invalidate() {
        super.invalidate();
        m12691a();
        m12692b();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f7732d = savedState.f7728a;
        m12692b();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7728a = this.f7732d;
        return savedState;
    }

    public void setCurrentPage(int i) {
        this.f7732d = i;
    }

    public void setDotGap(int i) {
        this.f7731c = (float) i;
        invalidate();
    }

    public void setFillColor(int i) {
        this.f7735g = i;
        invalidate();
    }

    public void setRadius(int i) {
        this.f7729a = (float) i;
        invalidate();
    }

    public void setStrokeColor(int i) {
        this.f7734f = i;
        invalidate();
    }

    public void setStrokeRadius(int i) {
        this.f7730b = (float) i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f7738j != viewPager) {
            if (this.f7738j != null) {
                this.f7738j.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f7738j = viewPager;
            this.f7738j.setOnPageChangeListener(this);
            this.f7733e = this.f7738j.getAdapter().mo879b();
            m12692b();
        }
    }
}
