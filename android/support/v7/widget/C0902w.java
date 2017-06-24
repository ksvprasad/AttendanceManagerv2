package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p019b.C0694a.C0683a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class C0902w extends SeekBar {
    private C0903x f2752a;
    private C0893m f2753b;

    public C0902w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0683a.seekBarStyle);
    }

    public C0902w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2753b = C0893m.m5425a();
        this.f2752a = new C0903x(this, this.f2753b);
        this.f2752a.mo870a(attributeSet, i);
    }
}
