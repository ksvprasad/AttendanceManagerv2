package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class C0600v {
    public static Object m3204a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static void m3205a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m3206a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m3207a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m3208a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static boolean m3209a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static boolean m3210a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return ((OverScroller) obj).springBack(i, i2, i3, i4, i5, i6);
    }

    public static int m3211b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m3212c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m3213d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m3214e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m3215f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m3216g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
