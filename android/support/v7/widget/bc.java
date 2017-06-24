package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p004c.C0334a;
import android.util.TypedValue;

class bc {
    static final int[] f2576a = new int[]{-16842910};
    static final int[] f2577b = new int[]{16842908};
    static final int[] f2578c = new int[]{16843518};
    static final int[] f2579d = new int[]{16842919};
    static final int[] f2580e = new int[]{16842912};
    static final int[] f2581f = new int[]{16842913};
    static final int[] f2582g = new int[]{-16842919, -16842908};
    static final int[] f2583h = new int[0];
    private static final ThreadLocal<TypedValue> f2584i = new ThreadLocal();
    private static final int[] f2585j = new int[1];

    public static int m5199a(Context context, int i) {
        f2585j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2585j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int m5200a(Context context, int i, float f) {
        int a = m5199a(context, i);
        return C0334a.m1822b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    private static TypedValue m5201a() {
        TypedValue typedValue = (TypedValue) f2584i.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        f2584i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList m5202b(Context context, int i) {
        f2585j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f2585j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m5203c(Context context, int i) {
        ColorStateList b = m5202b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f2576a, b.getDefaultColor());
        }
        TypedValue a = m5201a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m5200a(context, i, a.getFloat());
    }
}
