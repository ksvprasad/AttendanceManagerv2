package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public final class ag {
    static final C0456m f1244a;

    interface C0456m {
        Mode mo361A(View view);

        void mo362B(View view);

        boolean mo363C(View view);

        float mo364D(View view);

        boolean mo365E(View view);

        boolean mo366F(View view);

        int mo367a(int i, int i2);

        int mo368a(int i, int i2, int i3);

        int mo369a(View view);

        bd mo370a(View view, bd bdVar);

        void mo371a(View view, float f);

        void mo372a(View view, int i, int i2);

        void mo373a(View view, int i, int i2, int i3, int i4);

        void mo374a(View view, int i, Paint paint);

        void mo375a(View view, ColorStateList colorStateList);

        void mo376a(View view, Mode mode);

        void mo377a(View view, C0124a c0124a);

        void mo378a(View view, aa aaVar);

        void mo379a(View view, Runnable runnable);

        void mo380a(View view, Runnable runnable, long j);

        void mo381a(View view, boolean z);

        boolean mo382a(View view, int i);

        bd mo383b(View view, bd bdVar);

        void mo384b(View view, float f);

        void mo385b(View view, boolean z);

        boolean mo386b(View view);

        boolean mo387b(View view, int i);

        void mo388c(View view, float f);

        void mo389c(View view, int i);

        void mo390c(View view, boolean z);

        boolean mo391c(View view);

        void mo392d(View view);

        void mo393d(View view, float f);

        void mo394d(View view, int i);

        int mo395e(View view);

        void mo396e(View view, int i);

        float mo397f(View view);

        void mo398f(View view, int i);

        int mo399g(View view);

        int mo400h(View view);

        int mo401i(View view);

        int mo402j(View view);

        int mo403k(View view);

        int mo404l(View view);

        boolean mo405m(View view);

        float mo406n(View view);

        float mo407o(View view);

        int mo408p(View view);

        int mo409q(View view);

        aw mo410r(View view);

        int mo411s(View view);

        void mo412t(View view);

        boolean mo413w(View view);

        void mo414x(View view);

        boolean mo415y(View view);

        ColorStateList mo416z(View view);
    }

    static class C0457a implements C0456m {
        WeakHashMap<View, aw> f1241a = null;

        C0457a() {
        }

        private boolean m2377a(ac acVar, int i) {
            int computeHorizontalScrollOffset = acVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = acVar.computeHorizontalScrollRange() - acVar.computeHorizontalScrollExtent();
            return computeHorizontalScrollRange == 0 ? false : i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
        }

        private boolean m2378b(ac acVar, int i) {
            int computeVerticalScrollOffset = acVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = acVar.computeVerticalScrollRange() - acVar.computeVerticalScrollExtent();
            return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
        }

        public Mode mo361A(View view) {
            return ah.m2563b(view);
        }

        public void mo362B(View view) {
            if (view instanceof C0051w) {
                ((C0051w) view).stopNestedScroll();
            }
        }

        public boolean mo363C(View view) {
            return ah.m2565c(view);
        }

        public float mo364D(View view) {
            return mo419v(view) + mo418u(view);
        }

        public boolean mo365E(View view) {
            return ah.m2568f(view);
        }

        public boolean mo366F(View view) {
            return false;
        }

        public int mo367a(int i, int i2) {
            return i | i2;
        }

        public int mo368a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int mo369a(View view) {
            return 2;
        }

        long mo417a() {
            return 10;
        }

        public bd mo370a(View view, bd bdVar) {
            return bdVar;
        }

        public void mo371a(View view, float f) {
        }

        public void mo372a(View view, int i, int i2) {
        }

        public void mo373a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void mo374a(View view, int i, Paint paint) {
        }

        public void mo375a(View view, ColorStateList colorStateList) {
            ah.m2561a(view, colorStateList);
        }

        public void mo376a(View view, Mode mode) {
            ah.m2562a(view, mode);
        }

        public void mo377a(View view, C0124a c0124a) {
        }

        public void mo378a(View view, aa aaVar) {
        }

        public void mo379a(View view, Runnable runnable) {
            view.postDelayed(runnable, mo417a());
        }

        public void mo380a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, mo417a() + j);
        }

        public void mo381a(View view, boolean z) {
        }

        public boolean mo382a(View view, int i) {
            return (view instanceof ac) && m2377a((ac) view, i);
        }

        public bd mo383b(View view, bd bdVar) {
            return bdVar;
        }

        public void mo384b(View view, float f) {
        }

        public void mo385b(View view, boolean z) {
        }

        public boolean mo386b(View view) {
            return false;
        }

        public boolean mo387b(View view, int i) {
            return (view instanceof ac) && m2378b((ac) view, i);
        }

        public void mo388c(View view, float f) {
        }

        public void mo389c(View view, int i) {
        }

        public void mo390c(View view, boolean z) {
        }

        public boolean mo391c(View view) {
            return false;
        }

        public void mo392d(View view) {
            view.invalidate();
        }

        public void mo393d(View view, float f) {
        }

        public void mo394d(View view, int i) {
        }

        public int mo395e(View view) {
            return 0;
        }

        public void mo396e(View view, int i) {
            ah.m2564b(view, i);
        }

        public float mo397f(View view) {
            return 1.0f;
        }

        public void mo398f(View view, int i) {
            ah.m2560a(view, i);
        }

        public int mo399g(View view) {
            return 0;
        }

        public int mo400h(View view) {
            return 0;
        }

        public int mo401i(View view) {
            return view.getMeasuredWidth();
        }

        public int mo402j(View view) {
            return 0;
        }

        public int mo403k(View view) {
            return view.getPaddingLeft();
        }

        public int mo404l(View view) {
            return view.getPaddingRight();
        }

        public boolean mo405m(View view) {
            return true;
        }

        public float mo406n(View view) {
            return 0.0f;
        }

        public float mo407o(View view) {
            return 0.0f;
        }

        public int mo408p(View view) {
            return ah.m2566d(view);
        }

        public int mo409q(View view) {
            return ah.m2567e(view);
        }

        public aw mo410r(View view) {
            return new aw(view);
        }

        public int mo411s(View view) {
            return 0;
        }

        public void mo412t(View view) {
        }

        public float mo418u(View view) {
            return 0.0f;
        }

        public float mo419v(View view) {
            return 0.0f;
        }

        public boolean mo413w(View view) {
            return false;
        }

        public void mo414x(View view) {
        }

        public boolean mo415y(View view) {
            return false;
        }

        public ColorStateList mo416z(View view) {
            return ah.m2559a(view);
        }
    }

    static class C0458b extends C0457a {
        C0458b() {
        }
    }

    static class C0459c extends C0458b {
        C0459c() {
        }

        public int mo369a(View view) {
            return ai.m2569a(view);
        }
    }

    static class C0460d extends C0459c {
        C0460d() {
        }

        public int mo367a(int i, int i2) {
            return aj.m2571a(i, i2);
        }

        public int mo368a(int i, int i2, int i3) {
            return aj.m2572a(i, i2, i3);
        }

        long mo417a() {
            return aj.m2573a();
        }

        public void mo371a(View view, float f) {
            aj.m2574a(view, f);
        }

        public void mo374a(View view, int i, Paint paint) {
            aj.m2576a(view, i, paint);
        }

        public void mo384b(View view, float f) {
            aj.m2579b(view, f);
        }

        public void mo385b(View view, boolean z) {
            aj.m2577a(view, z);
        }

        public void mo388c(View view, float f) {
            aj.m2583c(view, f);
        }

        public void mo390c(View view, boolean z) {
            aj.m2581b(view, z);
        }

        public void mo396e(View view, int i) {
            aj.m2580b(view, i);
        }

        public float mo397f(View view) {
            return aj.m2570a(view);
        }

        public void mo398f(View view, int i) {
            aj.m2575a(view, i);
        }

        public int mo399g(View view) {
            return aj.m2578b(view);
        }

        public int mo401i(View view) {
            return aj.m2582c(view);
        }

        public int mo402j(View view) {
            return aj.m2584d(view);
        }

        public float mo406n(View view) {
            return aj.m2585e(view);
        }

        public float mo407o(View view) {
            return aj.m2586f(view);
        }

        public void mo414x(View view) {
            aj.m2587g(view);
        }
    }

    static class C0461f extends C0460d {
        static Field f1242b;
        static boolean f1243c = false;

        C0461f() {
        }

        public void mo377a(View view, C0124a c0124a) {
            ak.m2589a(view, c0124a == null ? null : c0124a.m847a());
        }

        public void mo381a(View view, boolean z) {
            ak.m2590a(view, z);
        }

        public boolean mo382a(View view, int i) {
            return ak.m2591a(view, i);
        }

        public boolean mo386b(View view) {
            boolean z = true;
            if (f1243c) {
                return false;
            }
            if (f1242b == null) {
                try {
                    f1242b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f1242b.setAccessible(true);
                } catch (Throwable th) {
                    f1243c = true;
                    return false;
                }
            }
            try {
                if (f1242b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f1243c = true;
                return false;
            }
        }

        public boolean mo387b(View view, int i) {
            return ak.m2592b(view, i);
        }

        public aw mo410r(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            aw awVar = (aw) this.a.get(view);
            if (awVar != null) {
                return awVar;
            }
            awVar = new aw(view);
            this.a.put(view, awVar);
            return awVar;
        }
    }

    static class C0462e extends C0461f {
        C0462e() {
        }

        public boolean mo366F(View view) {
            return al.m2593a(view);
        }
    }

    static class C0463g extends C0462e {
        C0463g() {
        }

        public void mo379a(View view, Runnable runnable) {
            am.m2595a(view, runnable);
        }

        public void mo380a(View view, Runnable runnable, long j) {
            am.m2596a(view, runnable, j);
        }

        public void mo389c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            am.m2594a(view, i);
        }

        public boolean mo391c(View view) {
            return am.m2597a(view);
        }

        public void mo392d(View view) {
            am.m2598b(view);
        }

        public int mo395e(View view) {
            return am.m2599c(view);
        }

        public boolean mo405m(View view) {
            return am.m2604h(view);
        }

        public int mo408p(View view) {
            return am.m2600d(view);
        }

        public int mo409q(View view) {
            return am.m2601e(view);
        }

        public void mo412t(View view) {
            am.m2602f(view);
        }

        public boolean mo413w(View view) {
            return am.m2603g(view);
        }
    }

    static class C0464h extends C0463g {
        C0464h() {
        }

        public void mo373a(View view, int i, int i2, int i3, int i4) {
            an.m2606a(view, i, i2, i3, i4);
        }

        public int mo400h(View view) {
            return an.m2605a(view);
        }

        public int mo403k(View view) {
            return an.m2607b(view);
        }

        public int mo404l(View view) {
            return an.m2608c(view);
        }

        public int mo411s(View view) {
            return an.m2609d(view);
        }

        public boolean mo415y(View view) {
            return an.m2610e(view);
        }
    }

    static class C0465i extends C0464h {
        C0465i() {
        }
    }

    static class C0466j extends C0465i {
        C0466j() {
        }

        public boolean mo363C(View view) {
            return ao.m2612a(view);
        }

        public boolean mo365E(View view) {
            return ao.m2613b(view);
        }

        public void mo389c(View view, int i) {
            am.m2594a(view, i);
        }

        public void mo394d(View view, int i) {
            ao.m2611a(view, i);
        }
    }

    static class C0467k extends C0466j {
        C0467k() {
        }

        public Mode mo361A(View view) {
            return ap.m2627e(view);
        }

        public void mo362B(View view) {
            ap.m2628f(view);
        }

        public float mo364D(View view) {
            return ap.m2629g(view);
        }

        public bd mo370a(View view, bd bdVar) {
            return ap.m2615a(view, bdVar);
        }

        public void mo375a(View view, ColorStateList colorStateList) {
            ap.m2619a(view, colorStateList);
        }

        public void mo376a(View view, Mode mode) {
            ap.m2620a(view, mode);
        }

        public void mo378a(View view, aa aaVar) {
            ap.m2621a(view, aaVar);
        }

        public bd mo383b(View view, bd bdVar) {
            return ap.m2623b(view, bdVar);
        }

        public void mo393d(View view, float f) {
            ap.m2617a(view, f);
        }

        public void mo396e(View view, int i) {
            ap.m2624b(view, i);
        }

        public void mo398f(View view, int i) {
            ap.m2618a(view, i);
        }

        public void mo412t(View view) {
            ap.m2616a(view);
        }

        public float mo418u(View view) {
            return ap.m2622b(view);
        }

        public float mo419v(View view) {
            return ap.m2625c(view);
        }

        public ColorStateList mo416z(View view) {
            return ap.m2626d(view);
        }
    }

    static class C0468l extends C0467k {
        C0468l() {
        }

        public void mo372a(View view, int i, int i2) {
            aq.m2631a(view, i, i2);
        }

        public void mo396e(View view, int i) {
            aq.m2632b(view, i);
        }

        public void mo398f(View view, int i) {
            aq.m2630a(view, i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1244a = new C0468l();
        } else if (i >= 21) {
            f1244a = new C0467k();
        } else if (i >= 19) {
            f1244a = new C0466j();
        } else if (i >= 17) {
            f1244a = new C0464h();
        } else if (i >= 16) {
            f1244a = new C0463g();
        } else if (i >= 15) {
            f1244a = new C0462e();
        } else if (i >= 14) {
            f1244a = new C0461f();
        } else if (i >= 11) {
            f1244a = new C0460d();
        } else if (i >= 9) {
            f1244a = new C0459c();
        } else if (i >= 7) {
            f1244a = new C0458b();
        } else {
            f1244a = new C0457a();
        }
    }

    public static boolean m2503A(View view) {
        return f1244a.mo363C(view);
    }

    public static float m2504B(View view) {
        return f1244a.mo364D(view);
    }

    public static boolean m2505C(View view) {
        return f1244a.mo365E(view);
    }

    public static boolean m2506D(View view) {
        return f1244a.mo366F(view);
    }

    public static int m2507a(int i, int i2) {
        return f1244a.mo367a(i, i2);
    }

    public static int m2508a(int i, int i2, int i3) {
        return f1244a.mo368a(i, i2, i3);
    }

    public static int m2509a(View view) {
        return f1244a.mo369a(view);
    }

    public static bd m2510a(View view, bd bdVar) {
        return f1244a.mo370a(view, bdVar);
    }

    public static void m2511a(View view, float f) {
        f1244a.mo371a(view, f);
    }

    public static void m2512a(View view, int i, int i2) {
        f1244a.mo372a(view, i, i2);
    }

    public static void m2513a(View view, int i, int i2, int i3, int i4) {
        f1244a.mo373a(view, i, i2, i3, i4);
    }

    public static void m2514a(View view, int i, Paint paint) {
        f1244a.mo374a(view, i, paint);
    }

    public static void m2515a(View view, ColorStateList colorStateList) {
        f1244a.mo375a(view, colorStateList);
    }

    public static void m2516a(View view, Mode mode) {
        f1244a.mo376a(view, mode);
    }

    public static void m2517a(View view, C0124a c0124a) {
        f1244a.mo377a(view, c0124a);
    }

    public static void m2518a(View view, aa aaVar) {
        f1244a.mo378a(view, aaVar);
    }

    public static void m2519a(View view, Runnable runnable) {
        f1244a.mo379a(view, runnable);
    }

    public static void m2520a(View view, Runnable runnable, long j) {
        f1244a.mo380a(view, runnable, j);
    }

    public static void m2521a(View view, boolean z) {
        f1244a.mo381a(view, z);
    }

    public static boolean m2522a(View view, int i) {
        return f1244a.mo382a(view, i);
    }

    public static bd m2523b(View view, bd bdVar) {
        return f1244a.mo383b(view, bdVar);
    }

    public static void m2524b(View view, float f) {
        f1244a.mo384b(view, f);
    }

    public static void m2525b(View view, boolean z) {
        f1244a.mo385b(view, z);
    }

    public static boolean m2526b(View view) {
        return f1244a.mo386b(view);
    }

    public static boolean m2527b(View view, int i) {
        return f1244a.mo387b(view, i);
    }

    public static void m2528c(View view, float f) {
        f1244a.mo388c(view, f);
    }

    public static void m2529c(View view, int i) {
        f1244a.mo389c(view, i);
    }

    public static void m2530c(View view, boolean z) {
        f1244a.mo390c(view, z);
    }

    public static boolean m2531c(View view) {
        return f1244a.mo391c(view);
    }

    public static void m2532d(View view) {
        f1244a.mo392d(view);
    }

    public static void m2533d(View view, float f) {
        f1244a.mo393d(view, f);
    }

    public static void m2534d(View view, int i) {
        f1244a.mo394d(view, i);
    }

    public static int m2535e(View view) {
        return f1244a.mo395e(view);
    }

    public static void m2536e(View view, int i) {
        f1244a.mo398f(view, i);
    }

    public static float m2537f(View view) {
        return f1244a.mo397f(view);
    }

    public static void m2538f(View view, int i) {
        f1244a.mo396e(view, i);
    }

    public static int m2539g(View view) {
        return f1244a.mo399g(view);
    }

    public static int m2540h(View view) {
        return f1244a.mo400h(view);
    }

    public static int m2541i(View view) {
        return f1244a.mo401i(view);
    }

    public static int m2542j(View view) {
        return f1244a.mo402j(view);
    }

    public static int m2543k(View view) {
        return f1244a.mo403k(view);
    }

    public static int m2544l(View view) {
        return f1244a.mo404l(view);
    }

    public static float m2545m(View view) {
        return f1244a.mo406n(view);
    }

    public static float m2546n(View view) {
        return f1244a.mo407o(view);
    }

    public static int m2547o(View view) {
        return f1244a.mo408p(view);
    }

    public static int m2548p(View view) {
        return f1244a.mo409q(view);
    }

    public static aw m2549q(View view) {
        return f1244a.mo410r(view);
    }

    public static int m2550r(View view) {
        return f1244a.mo411s(view);
    }

    public static void m2551s(View view) {
        f1244a.mo412t(view);
    }

    public static boolean m2552t(View view) {
        return f1244a.mo413w(view);
    }

    public static void m2553u(View view) {
        f1244a.mo414x(view);
    }

    public static boolean m2554v(View view) {
        return f1244a.mo405m(view);
    }

    public static boolean m2555w(View view) {
        return f1244a.mo415y(view);
    }

    public static ColorStateList m2556x(View view) {
        return f1244a.mo416z(view);
    }

    public static Mode m2557y(View view) {
        return f1244a.mo361A(view);
    }

    public static void m2558z(View view) {
        f1244a.mo362B(view);
    }
}
