package android.support.v4.view;

import android.view.View;

class am {
    public static void m2594a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void m2595a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m2596a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static boolean m2597a(View view) {
        return view.hasTransientState();
    }

    public static void m2598b(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int m2599c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int m2600d(View view) {
        return view.getMinimumWidth();
    }

    public static int m2601e(View view) {
        return view.getMinimumHeight();
    }

    public static void m2602f(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m2603g(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m2604h(View view) {
        return view.hasOverlappingRendering();
    }
}
