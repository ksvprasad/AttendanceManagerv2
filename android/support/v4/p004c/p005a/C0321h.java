package android.support.v4.p004c.p005a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0321h {
    public static Drawable m1794a(Drawable drawable) {
        return !(drawable instanceof C0022o) ? new C0333n(drawable) : drawable;
    }

    public static void m1795a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m1796a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m1797a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m1798a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m1799a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void m1800a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1801a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static boolean m1802b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m1803c(Drawable drawable) {
        return drawable.getColorFilter();
    }
}
