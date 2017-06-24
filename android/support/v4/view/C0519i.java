package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class C0519i {
    static final C0515a f1284a;

    interface C0515a {
        C0271m mo453a(LayoutInflater layoutInflater);

        void mo454a(LayoutInflater layoutInflater, C0271m c0271m);
    }

    static class C0516b implements C0515a {
        C0516b() {
        }

        public C0271m mo453a(LayoutInflater layoutInflater) {
            return C0521j.m2822a(layoutInflater);
        }

        public void mo454a(LayoutInflater layoutInflater, C0271m c0271m) {
            C0521j.m2823a(layoutInflater, c0271m);
        }
    }

    static class C0517c extends C0516b {
        C0517c() {
        }

        public void mo454a(LayoutInflater layoutInflater, C0271m c0271m) {
            C0523k.m2824a(layoutInflater, c0271m);
        }
    }

    static class C0518d extends C0517c {
        C0518d() {
        }

        public void mo454a(LayoutInflater layoutInflater, C0271m c0271m) {
            C0524l.m2826a(layoutInflater, c0271m);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1284a = new C0518d();
        } else if (i >= 11) {
            f1284a = new C0517c();
        } else {
            f1284a = new C0516b();
        }
    }

    public static C0271m m2820a(LayoutInflater layoutInflater) {
        return f1284a.mo453a(layoutInflater);
    }

    public static void m2821a(LayoutInflater layoutInflater, C0271m c0271m) {
        f1284a.mo454a(layoutInflater, c0271m);
    }
}
