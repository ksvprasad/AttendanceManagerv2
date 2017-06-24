package android.support.v4.p014f;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0350a {
    private static final C0346a f1080a;

    interface C0346a {
        String mo268a(Locale locale);
    }

    static class C0347b implements C0346a {
        C0347b() {
        }

        public String mo268a(Locale locale) {
            return null;
        }
    }

    static class C0348c implements C0346a {
        C0348c() {
        }

        public String mo268a(Locale locale) {
            return C0352c.m1842a(locale);
        }
    }

    static class C0349d implements C0346a {
        C0349d() {
        }

        public String mo268a(Locale locale) {
            return C0351b.m1840a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1080a = new C0349d();
        } else if (i >= 14) {
            f1080a = new C0348c();
        } else {
            f1080a = new C0347b();
        }
    }

    public static String m1839a(Locale locale) {
        return f1080a.mo268a(locale);
    }
}
