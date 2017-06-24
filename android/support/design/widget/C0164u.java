package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0048a.C0040b;

class C0164u {
    private static final int[] f690a = new int[]{C0040b.colorPrimary};

    static void m1053a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f690a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
