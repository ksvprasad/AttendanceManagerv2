package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

class ap {
    private static ThreadLocal<Rect> f1250a;

    private static Rect m2614a() {
        if (f1250a == null) {
            f1250a = new ThreadLocal();
        }
        Rect rect = (Rect) f1250a.get();
        if (rect == null) {
            rect = new Rect();
            f1250a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static bd m2615a(View view, bd bdVar) {
        if (!(bdVar instanceof be)) {
            return bdVar;
        }
        WindowInsets g = ((be) bdVar).m2773g();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(g);
        return onApplyWindowInsets != g ? new be(onApplyWindowInsets) : bdVar;
    }

    public static void m2616a(View view) {
        view.requestApplyInsets();
    }

    public static void m2617a(View view, float f) {
        view.setElevation(f);
    }

    static void m2618a(View view, int i) {
        Object obj;
        Rect a = m2614a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        aj.m2575a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void m2619a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static void m2620a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static void m2621a(View view, final aa aaVar) {
        if (aaVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ((be) aaVar.mo38a(view, new be(windowInsets))).m2773g();
                }
            });
        }
    }

    public static float m2622b(View view) {
        return view.getElevation();
    }

    public static bd m2623b(View view, bd bdVar) {
        if (!(bdVar instanceof be)) {
            return bdVar;
        }
        WindowInsets g = ((be) bdVar).m2773g();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(g);
        return dispatchApplyWindowInsets != g ? new be(dispatchApplyWindowInsets) : bdVar;
    }

    static void m2624b(View view, int i) {
        Object obj;
        Rect a = m2614a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        aj.m2580b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    public static float m2625c(View view) {
        return view.getTranslationZ();
    }

    static ColorStateList m2626d(View view) {
        return view.getBackgroundTintList();
    }

    static Mode m2627e(View view) {
        return view.getBackgroundTintMode();
    }

    public static void m2628f(View view) {
        view.stopNestedScroll();
    }

    public static float m2629g(View view) {
        return view.getZ();
    }
}
