package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

class C0903x extends C0899t {
    private static final int[] f2754b = new int[]{16843074};
    private final SeekBar f2755c;

    C0903x(SeekBar seekBar, C0893m c0893m) {
        super(seekBar, c0893m);
        this.f2755c = seekBar;
    }

    void mo870a(AttributeSet attributeSet, int i) {
        super.mo870a(attributeSet, i);
        bh a = bh.m5210a(this.f2755c.getContext(), attributeSet, f2754b, i, 0);
        Drawable b = a.m5217b(0);
        if (b != null) {
            this.f2755c.setThumb(b);
        }
        a.m5214a();
    }
}
