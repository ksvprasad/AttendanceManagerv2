package android.support.v4.p004c.p005a;

import android.graphics.drawable.Drawable;

class C0320g {
    public static void m1790a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m1791a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m1792b(Drawable drawable) {
        return !(drawable instanceof C0022o) ? new C0331m(drawable) : drawable;
    }

    public static int m1793c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
