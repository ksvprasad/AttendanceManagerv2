package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.p004c.p005a.C0322i;
import android.support.v7.p007d.p008a.C0153a;

public class al {
    public static final Rect f2424a = new Rect();
    private static Class<?> f2425b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f2425b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static Mode m5018a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }

    static void m5019a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m5021c(drawable);
        }
    }

    public static boolean m5020b(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            return VERSION.SDK_INT >= 16;
        } else if (drawable instanceof InsetDrawable) {
            return VERSION.SDK_INT >= 14;
        } else {
            if (drawable instanceof StateListDrawable) {
                return VERSION.SDK_INT >= 8;
            } else {
                if (drawable instanceof GradientDrawable) {
                    return VERSION.SDK_INT >= 14;
                } else {
                    if (!(drawable instanceof DrawableContainer)) {
                        return drawable instanceof C0322i ? m5020b(((C0322i) drawable).mo262a()) : drawable instanceof C0153a ? m5020b(((C0153a) drawable).m1011b()) : drawable instanceof ScaleDrawable ? m5020b(((ScaleDrawable) drawable).getDrawable()) : true;
                    } else {
                        ConstantState constantState = drawable.getConstantState();
                        if (!(constantState instanceof DrawableContainerState)) {
                            return true;
                        }
                        for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                            if (!m5020b(b)) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    private static void m5021c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(bc.f2580e);
        } else {
            drawable.setState(bc.f2583h);
        }
        drawable.setState(state);
    }
}
