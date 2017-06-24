package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.C0170v.C0128d;
import android.view.View;

class ac {
    static final C0128d f546a = new C01291();
    private static final C0130a f547b;

    static class C01291 implements C0128d {
        C01291() {
        }

        public C0170v mo116a() {
            return new C0170v(VERSION.SDK_INT >= 12 ? new C0175x() : new C0172w());
        }
    }

    private interface C0130a {
        void mo117a(View view);
    }

    private static class C0131b implements C0130a {
        private C0131b() {
        }

        public void mo117a(View view) {
        }
    }

    private static class C0132c implements C0130a {
        private C0132c() {
        }

        public void mo117a(View view) {
            ad.m892a(view);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f547b = new C0132c();
        } else {
            f547b = new C0131b();
        }
    }

    static C0170v m890a() {
        return f546a.mo116a();
    }

    static void m891a(View view) {
        f547b.mo117a(view);
    }
}
