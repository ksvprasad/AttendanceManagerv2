package com.prolificinteractive.materialcalendarview;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

class C2149g extends ImageView {
    public C2149g(Context context) {
        this(context, null);
    }

    public C2149g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(C2149g.m12303a(context));
    }

    private static int m12303a(Context context) {
        int identifier = context.getResources().getIdentifier("selectableItemBackgroundBorderless", "attr", context.getPackageName());
        if (identifier == 0) {
            identifier = VERSION.SDK_INT >= 21 ? 16843868 : 16843534;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(identifier, typedValue, true);
        return typedValue.resourceId;
    }

    public void m12304a(int i) {
        setColorFilter(i, Mode.SRC_ATOP);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setAlpha(z ? 1.0f : 0.1f);
    }
}
