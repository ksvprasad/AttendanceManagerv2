package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class au {
    static final C0475b f1252a;

    interface C0475b {
        void mo422a(ViewParent viewParent, View view);

        void mo423a(ViewParent viewParent, View view, int i, int i2, int i3, int i4);

        void mo424a(ViewParent viewParent, View view, int i, int i2, int[] iArr);

        boolean mo425a(ViewParent viewParent, View view, float f, float f2);

        boolean mo426a(ViewParent viewParent, View view, float f, float f2, boolean z);

        boolean mo427a(ViewParent viewParent, View view, View view2, int i);

        void mo428b(ViewParent viewParent, View view, View view2, int i);
    }

    static class C0476e implements C0475b {
        C0476e() {
        }

        public void mo422a(ViewParent viewParent, View view) {
            if (viewParent instanceof C0081y) {
                ((C0081y) viewParent).onStopNestedScroll(view);
            }
        }

        public void mo423a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof C0081y) {
                ((C0081y) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void mo424a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof C0081y) {
                ((C0081y) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean mo425a(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof C0081y ? ((C0081y) viewParent).onNestedPreFling(view, f, f2) : false;
        }

        public boolean mo426a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof C0081y ? ((C0081y) viewParent).onNestedFling(view, f, f2, z) : false;
        }

        public boolean mo427a(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof C0081y ? ((C0081y) viewParent).onStartNestedScroll(view, view2, i) : false;
        }

        public void mo428b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof C0081y) {
                ((C0081y) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static class C0477a extends C0476e {
        C0477a() {
        }
    }

    static class C0478c extends C0477a {
        C0478c() {
        }
    }

    static class C0479d extends C0478c {
        C0479d() {
        }

        public void mo422a(ViewParent viewParent, View view) {
            av.m2672a(viewParent, view);
        }

        public void mo423a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            av.m2673a(viewParent, view, i, i2, i3, i4);
        }

        public void mo424a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            av.m2674a(viewParent, view, i, i2, iArr);
        }

        public boolean mo425a(ViewParent viewParent, View view, float f, float f2) {
            return av.m2675a(viewParent, view, f, f2);
        }

        public boolean mo426a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return av.m2676a(viewParent, view, f, f2, z);
        }

        public boolean mo427a(ViewParent viewParent, View view, View view2, int i) {
            return av.m2677a(viewParent, view, view2, i);
        }

        public void mo428b(ViewParent viewParent, View view, View view2, int i) {
            av.m2678b(viewParent, view, view2, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1252a = new C0479d();
        } else if (i >= 19) {
            f1252a = new C0478c();
        } else if (i >= 14) {
            f1252a = new C0477a();
        } else {
            f1252a = new C0476e();
        }
    }

    public static void m2665a(ViewParent viewParent, View view) {
        f1252a.mo422a(viewParent, view);
    }

    public static void m2666a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f1252a.mo423a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2667a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f1252a.mo424a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2668a(ViewParent viewParent, View view, float f, float f2) {
        return f1252a.mo425a(viewParent, view, f, f2);
    }

    public static boolean m2669a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1252a.mo426a(viewParent, view, f, f2, z);
    }

    public static boolean m2670a(ViewParent viewParent, View view, View view2, int i) {
        return f1252a.mo427a(viewParent, view, view2, i);
    }

    public static void m2671b(ViewParent viewParent, View view, View view2, int i) {
        f1252a.mo428b(viewParent, view, view2, i);
    }
}
