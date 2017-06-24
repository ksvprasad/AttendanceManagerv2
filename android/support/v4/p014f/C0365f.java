package android.support.v4.p014f;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0365f {
    public static final Locale f1097a = new Locale("", "");
    private static final C0363a f1098b;
    private static String f1099c = "Arab";
    private static String f1100d = "Hebr";

    private static class C0363a {
        private C0363a() {
        }

        private static int m1857b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }

        public int mo272a(Locale locale) {
            if (!(locale == null || locale.equals(C0365f.f1097a))) {
                String a = C0350a.m1839a(locale);
                if (a == null) {
                    return C0363a.m1857b(locale);
                }
                if (a.equalsIgnoreCase(C0365f.f1099c) || a.equalsIgnoreCase(C0365f.f1100d)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    private static class C0364b extends C0363a {
        private C0364b() {
            super();
        }

        public int mo272a(Locale locale) {
            return C0366g.m1863a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1098b = new C0364b();
        } else {
            f1098b = new C0363a();
        }
    }

    public static int m1860a(Locale locale) {
        return f1098b.mo272a(locale);
    }
}
