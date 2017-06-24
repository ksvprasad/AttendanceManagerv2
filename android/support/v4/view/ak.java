package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ak {
    public static void m2589a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }

    public static void m2590a(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static boolean m2591a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m2592b(View view, int i) {
        return view.canScrollVertically(i);
    }
}
