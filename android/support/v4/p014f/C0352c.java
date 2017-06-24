package android.support.v4.p014f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0352c {
    private static Method f1082a;
    private static Method f1083b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1082a = cls.getMethod("getScript", new Class[]{String.class});
                f1083b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f1082a = null;
            f1083b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    private static String m1841a(String str) {
        try {
            if (f1082a != null) {
                return (String) f1082a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m1842a(Locale locale) {
        String b = C0352c.m1843b(locale);
        return b != null ? C0352c.m1841a(b) : null;
    }

    private static String m1843b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1083b != null) {
                return (String) f1083b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
