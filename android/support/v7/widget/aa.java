package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

class aa extends C0822z {
    private static final int[] f2366b = new int[]{16843666, 16843667};
    private bf f2367c;
    private bf f2368d;

    aa(TextView textView) {
        super(textView);
    }

    void mo772a() {
        super.mo772a();
        if (this.f2367c != null || this.f2368d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m4836a(compoundDrawablesRelative[0], this.f2367c);
            m4836a(compoundDrawablesRelative[2], this.f2368d);
        }
    }

    void mo773a(AttributeSet attributeSet, int i) {
        super.mo773a(attributeSet, i);
        Context context = this.a.getContext();
        C0893m a = C0893m.m5425a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2366b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2367c = C0822z.m4832a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2368d = C0822z.m4832a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
