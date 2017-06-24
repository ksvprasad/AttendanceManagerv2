package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ah {
    private static Field f1245a;
    private static boolean f1246b;
    private static Field f1247c;
    private static boolean f1248d;

    static ColorStateList m2559a(View view) {
        return view instanceof ad ? ((ad) view).getSupportBackgroundTintList() : null;
    }

    static void m2560a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m2561a(View view, ColorStateList colorStateList) {
        if (view instanceof ad) {
            ((ad) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void m2562a(View view, Mode mode) {
        if (view instanceof ad) {
            ((ad) view).setSupportBackgroundTintMode(mode);
        }
    }

    static Mode m2563b(View view) {
        return view instanceof ad ? ((ad) view).getSupportBackgroundTintMode() : null;
    }

    static void m2564b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }

    static boolean m2565c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m2566d(View view) {
        if (!f1246b) {
            try {
                f1245a = View.class.getDeclaredField("mMinWidth");
                f1245a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1246b = true;
        }
        if (f1245a != null) {
            try {
                return ((Integer) f1245a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m2567e(View view) {
        if (!f1248d) {
            try {
                f1247c = View.class.getDeclaredField("mMinHeight");
                f1247c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1248d = true;
        }
        if (f1247c != null) {
            try {
                return ((Integer) f1247c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m2568f(View view) {
        return view.getWindowToken() != null;
    }
}
