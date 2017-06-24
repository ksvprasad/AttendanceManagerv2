package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class C0528n {
    static final C0525a f1288a;

    interface C0525a {
        int mo455a(MarginLayoutParams marginLayoutParams);

        int mo456b(MarginLayoutParams marginLayoutParams);
    }

    static class C0526b implements C0525a {
        C0526b() {
        }

        public int mo455a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int mo456b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    static class C0527c implements C0525a {
        C0527c() {
        }

        public int mo455a(MarginLayoutParams marginLayoutParams) {
            return C0529o.m2835a(marginLayoutParams);
        }

        public int mo456b(MarginLayoutParams marginLayoutParams) {
            return C0529o.m2836b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1288a = new C0527c();
        } else {
            f1288a = new C0526b();
        }
    }

    public static int m2833a(MarginLayoutParams marginLayoutParams) {
        return f1288a.mo455a(marginLayoutParams);
    }

    public static int m2834b(MarginLayoutParams marginLayoutParams) {
        return f1288a.mo456b(marginLayoutParams);
    }
}
