package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class ar {
    static final C0470e f1251a;

    interface C0470e {
        int mo420a(ViewConfiguration viewConfiguration);

        boolean mo421b(ViewConfiguration viewConfiguration);
    }

    static class C0471a implements C0470e {
        C0471a() {
        }

        public int mo420a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean mo421b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class C0472b extends C0471a {
        C0472b() {
        }

        public int mo420a(ViewConfiguration viewConfiguration) {
            return as.m2642a(viewConfiguration);
        }
    }

    static class C0473c extends C0472b {
        C0473c() {
        }

        public boolean mo421b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class C0474d extends C0473c {
        C0474d() {
        }

        public boolean mo421b(ViewConfiguration viewConfiguration) {
            return at.m2643a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f1251a = new C0474d();
        } else if (VERSION.SDK_INT >= 11) {
            f1251a = new C0473c();
        } else if (VERSION.SDK_INT >= 8) {
            f1251a = new C0472b();
        } else {
            f1251a = new C0471a();
        }
    }

    public static int m2640a(ViewConfiguration viewConfiguration) {
        return f1251a.mo420a(viewConfiguration);
    }

    public static boolean m2641b(ViewConfiguration viewConfiguration) {
        return f1251a.mo421b(viewConfiguration);
    }
}
