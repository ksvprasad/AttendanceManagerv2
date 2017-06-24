package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

class aj {
    public static float m2570a(View view) {
        return view.getAlpha();
    }

    public static int m2571a(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int m2572a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    static long m2573a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m2574a(View view, float f) {
        view.setTranslationX(f);
    }

    static void m2575a(View view, int i) {
        view.offsetTopAndBottom(i);
        m2588h(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m2588h((View) parent);
        }
    }

    public static void m2576a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void m2577a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static int m2578b(View view) {
        return view.getLayerType();
    }

    public static void m2579b(View view, float f) {
        view.setTranslationY(f);
    }

    static void m2580b(View view, int i) {
        view.offsetLeftAndRight(i);
        m2588h(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m2588h((View) parent);
        }
    }

    public static void m2581b(View view, boolean z) {
        view.setActivated(z);
    }

    public static int m2582c(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static void m2583c(View view, float f) {
        view.setAlpha(f);
    }

    public static int m2584d(View view) {
        return view.getMeasuredState();
    }

    public static float m2585e(View view) {
        return view.getTranslationX();
    }

    public static float m2586f(View view) {
        return view.getTranslationY();
    }

    public static void m2587g(View view) {
        view.jumpDrawablesToCurrentState();
    }

    private static void m2588h(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
