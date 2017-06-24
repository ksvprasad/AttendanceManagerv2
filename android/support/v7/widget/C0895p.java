package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.p010b.C0195a;
import android.support.v7.p019b.C0694a.C0693k;
import android.util.AttributeSet;
import android.widget.ImageView;

public class C0895p {
    private final ImageView f2733a;
    private final C0893m f2734b;

    public C0895p(ImageView imageView, C0893m c0893m) {
        this.f2733a = imageView;
        this.f2734b = c0893m;
    }

    public void m5452a(int i) {
        if (i != 0) {
            Drawable a = this.f2734b != null ? this.f2734b.m5448a(this.f2733a.getContext(), i) : C0195a.m1224a(this.f2733a.getContext(), i);
            if (a != null) {
                al.m5019a(a);
            }
            this.f2733a.setImageDrawable(a);
            return;
        }
        this.f2733a.setImageDrawable(null);
    }

    public void m5453a(AttributeSet attributeSet, int i) {
        bh a = bh.m5210a(this.f2733a.getContext(), attributeSet, C0693k.AppCompatImageView, i, 0);
        try {
            Drawable b = a.m5217b(C0693k.AppCompatImageView_android_src);
            if (b != null) {
                this.f2733a.setImageDrawable(b);
            }
            int g = a.m5226g(C0693k.AppCompatImageView_srcCompat, -1);
            if (g != -1) {
                b = this.f2734b.m5448a(this.f2733a.getContext(), g);
                if (b != null) {
                    this.f2733a.setImageDrawable(b);
                }
            }
            b = this.f2733a.getDrawable();
            if (b != null) {
                al.m5019a(b);
            }
            a.m5214a();
        } catch (Throwable th) {
            a.m5214a();
        }
    }
}
