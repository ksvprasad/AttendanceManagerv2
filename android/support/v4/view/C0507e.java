package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

public final class C0507e {
    static final C0504a f1282a;

    interface C0504a {
        int mo448a(int i, int i2);

        void mo449a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    static class C0505b implements C0504a {
        C0505b() {
        }

        public int mo448a(int i, int i2) {
            return -8388609 & i;
        }

        public void mo449a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            Gravity.apply(i, i2, i3, rect, rect2);
        }
    }

    static class C0506c implements C0504a {
        C0506c() {
        }

        public int mo448a(int i, int i2) {
            return C0508f.m2798a(i, i2);
        }

        public void mo449a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            C0508f.m2799a(i, i2, i3, rect, rect2, i4);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1282a = new C0506c();
        } else {
            f1282a = new C0505b();
        }
    }

    public static int m2796a(int i, int i2) {
        return f1282a.mo448a(i, i2);
    }

    public static void m2797a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f1282a.mo449a(i, i2, i3, rect, rect2, i4);
    }
}
