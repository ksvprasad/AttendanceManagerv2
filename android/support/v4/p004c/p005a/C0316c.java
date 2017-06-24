package android.support.v4.p004c.p005a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0316c {
    public static Drawable m1780a(Drawable drawable) {
        return !(drawable instanceof C0022o) ? new C0325j(drawable) : drawable;
    }

    public static void m1781a(Drawable drawable, int i) {
        if (drawable instanceof C0022o) {
            ((C0022o) drawable).setTint(i);
        }
    }

    public static void m1782a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0022o) {
            ((C0022o) drawable).setTintList(colorStateList);
        }
    }

    public static void m1783a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void m1784a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0022o) {
            ((C0022o) drawable).setTintMode(mode);
        }
    }
}
