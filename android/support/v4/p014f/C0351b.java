package android.support.v4.p014f;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0351b {
    private static Method f1081a;

    static {
        try {
            f1081a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m1840a(Locale locale) {
        try {
            return ((Locale) f1081a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
