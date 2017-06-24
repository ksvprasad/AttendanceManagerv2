package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class C0886k extends CheckedTextView {
    private static final int[] f2706a = new int[]{16843016};
    private C0893m f2707b;
    private C0822z f2708c;

    public C0886k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0886k(Context context, AttributeSet attributeSet, int i) {
        super(be.m5206a(context), attributeSet, i);
        this.f2708c = C0822z.m4833a((TextView) this);
        this.f2708c.mo773a(attributeSet, i);
        this.f2708c.mo772a();
        this.f2707b = C0893m.m5425a();
        bh a = bh.m5210a(getContext(), attributeSet, f2706a, i, 0);
        setCheckMarkDrawable(a.m5213a(0));
        a.m5214a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2708c != null) {
            this.f2708c.mo772a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f2707b != null) {
            setCheckMarkDrawable(this.f2707b.m5448a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2708c != null) {
            this.f2708c.m4835a(context, i);
        }
    }
}
