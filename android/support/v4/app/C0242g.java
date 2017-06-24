package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;

public final class C0242g {
    private static final C0240b f864a;

    private static class C0240b {
        private C0240b() {
        }

        public int mo184a(Context context, String str, String str2) {
            return 1;
        }

        public String mo185a(String str) {
            return null;
        }
    }

    private static class C0241a extends C0240b {
        private C0241a() {
            super();
        }

        public int mo184a(Context context, String str, String str2) {
            return C0243h.m1339a(context, str, str2);
        }

        public String mo185a(String str) {
            return C0243h.m1340a(str);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f864a = new C0241a();
        } else {
            f864a = new C0240b();
        }
    }

    public static int m1337a(Context context, String str, String str2) {
        return f864a.mo184a(context, str, str2);
    }

    public static String m1338a(String str) {
        return f864a.mo185a(str);
    }
}
