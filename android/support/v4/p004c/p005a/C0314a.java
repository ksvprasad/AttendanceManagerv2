package android.support.v4.p004c.p005a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class C0314a {
    static final C0306b f1061a;

    interface C0306b {
        void mo245a(Drawable drawable);

        void mo246a(Drawable drawable, float f, float f2);

        void mo247a(Drawable drawable, int i);

        void mo248a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo249a(Drawable drawable, ColorStateList colorStateList);

        void mo250a(Drawable drawable, Theme theme);

        void mo251a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void mo252a(Drawable drawable, Mode mode);

        void mo253a(Drawable drawable, boolean z);

        void mo254b(Drawable drawable, int i);

        boolean mo255b(Drawable drawable);

        Drawable mo256c(Drawable drawable);

        int mo257d(Drawable drawable);

        int mo258e(Drawable drawable);

        boolean mo259f(Drawable drawable);

        ColorFilter mo260g(Drawable drawable);
    }

    static class C0307a implements C0306b {
        C0307a() {
        }

        public void mo245a(Drawable drawable) {
        }

        public void mo246a(Drawable drawable, float f, float f2) {
        }

        public void mo247a(Drawable drawable, int i) {
            C0316c.m1781a(drawable, i);
        }

        public void mo248a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo249a(Drawable drawable, ColorStateList colorStateList) {
            C0316c.m1782a(drawable, colorStateList);
        }

        public void mo250a(Drawable drawable, Theme theme) {
        }

        public void mo251a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0316c.m1783a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void mo252a(Drawable drawable, Mode mode) {
            C0316c.m1784a(drawable, mode);
        }

        public void mo253a(Drawable drawable, boolean z) {
        }

        public void mo254b(Drawable drawable, int i) {
        }

        public boolean mo255b(Drawable drawable) {
            return false;
        }

        public Drawable mo256c(Drawable drawable) {
            return C0316c.m1780a(drawable);
        }

        public int mo257d(Drawable drawable) {
            return 0;
        }

        public int mo258e(Drawable drawable) {
            return 0;
        }

        public boolean mo259f(Drawable drawable) {
            return false;
        }

        public ColorFilter mo260g(Drawable drawable) {
            return null;
        }
    }

    static class C0308c extends C0307a {
        C0308c() {
        }

        public Drawable mo256c(Drawable drawable) {
            return C0317d.m1785a(drawable);
        }
    }

    static class C0309d extends C0308c {
        C0309d() {
        }

        public void mo245a(Drawable drawable) {
            C0318e.m1786a(drawable);
        }

        public Drawable mo256c(Drawable drawable) {
            return C0318e.m1787b(drawable);
        }
    }

    static class C0310e extends C0309d {
        C0310e() {
        }

        public void mo254b(Drawable drawable, int i) {
            C0319f.m1789a(drawable, i);
        }

        public int mo257d(Drawable drawable) {
            int a = C0319f.m1788a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    static class C0311f extends C0310e {
        C0311f() {
        }

        public void mo253a(Drawable drawable, boolean z) {
            C0320g.m1790a(drawable, z);
        }

        public boolean mo255b(Drawable drawable) {
            return C0320g.m1791a(drawable);
        }

        public Drawable mo256c(Drawable drawable) {
            return C0320g.m1792b(drawable);
        }

        public int mo258e(Drawable drawable) {
            return C0320g.m1793c(drawable);
        }
    }

    static class C0312g extends C0311f {
        C0312g() {
        }

        public void mo246a(Drawable drawable, float f, float f2) {
            C0321h.m1795a(drawable, f, f2);
        }

        public void mo247a(Drawable drawable, int i) {
            C0321h.m1796a(drawable, i);
        }

        public void mo248a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0321h.m1797a(drawable, i, i2, i3, i4);
        }

        public void mo249a(Drawable drawable, ColorStateList colorStateList) {
            C0321h.m1798a(drawable, colorStateList);
        }

        public void mo250a(Drawable drawable, Theme theme) {
            C0321h.m1799a(drawable, theme);
        }

        public void mo251a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0321h.m1800a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void mo252a(Drawable drawable, Mode mode) {
            C0321h.m1801a(drawable, mode);
        }

        public Drawable mo256c(Drawable drawable) {
            return C0321h.m1794a(drawable);
        }

        public boolean mo259f(Drawable drawable) {
            return C0321h.m1802b(drawable);
        }

        public ColorFilter mo260g(Drawable drawable) {
            return C0321h.m1803c(drawable);
        }
    }

    static class C0313h extends C0312g {
        C0313h() {
        }

        public void mo254b(Drawable drawable, int i) {
            C0315b.m1779a(drawable, i);
        }

        public Drawable mo256c(Drawable drawable) {
            return drawable;
        }

        public int mo257d(Drawable drawable) {
            return C0315b.m1778a(drawable);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1061a = new C0313h();
        } else if (i >= 21) {
            f1061a = new C0312g();
        } else if (i >= 19) {
            f1061a = new C0311f();
        } else if (i >= 17) {
            f1061a = new C0310e();
        } else if (i >= 11) {
            f1061a = new C0309d();
        } else if (i >= 5) {
            f1061a = new C0308c();
        } else {
            f1061a = new C0307a();
        }
    }

    public static void m1762a(Drawable drawable) {
        f1061a.mo245a(drawable);
    }

    public static void m1763a(Drawable drawable, float f, float f2) {
        f1061a.mo246a(drawable, f, f2);
    }

    public static void m1764a(Drawable drawable, int i) {
        f1061a.mo247a(drawable, i);
    }

    public static void m1765a(Drawable drawable, int i, int i2, int i3, int i4) {
        f1061a.mo248a(drawable, i, i2, i3, i4);
    }

    public static void m1766a(Drawable drawable, ColorStateList colorStateList) {
        f1061a.mo249a(drawable, colorStateList);
    }

    public static void m1767a(Drawable drawable, Theme theme) {
        f1061a.mo250a(drawable, theme);
    }

    public static void m1768a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f1061a.mo251a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1769a(Drawable drawable, Mode mode) {
        f1061a.mo252a(drawable, mode);
    }

    public static void m1770a(Drawable drawable, boolean z) {
        f1061a.mo253a(drawable, z);
    }

    public static void m1771b(Drawable drawable, int i) {
        f1061a.mo254b(drawable, i);
    }

    public static boolean m1772b(Drawable drawable) {
        return f1061a.mo255b(drawable);
    }

    public static int m1773c(Drawable drawable) {
        return f1061a.mo258e(drawable);
    }

    public static boolean m1774d(Drawable drawable) {
        return f1061a.mo259f(drawable);
    }

    public static ColorFilter m1775e(Drawable drawable) {
        return f1061a.mo260g(drawable);
    }

    public static Drawable m1776f(Drawable drawable) {
        return f1061a.mo256c(drawable);
    }

    public static int m1777g(Drawable drawable) {
        return f1061a.mo257d(drawable);
    }
}
