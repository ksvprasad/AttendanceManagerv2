package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class C0138g {
    private static Method f605a;
    private static boolean f606b;
    private static Field f607c;
    private static boolean f608d;

    static boolean m941a(DrawableContainer drawableContainer, ConstantState constantState) {
        return VERSION.SDK_INT >= 9 ? C0138g.m942b(drawableContainer, constantState) : C0138g.m943c(drawableContainer, constantState);
    }

    private static boolean m942b(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!f606b) {
            try {
                f605a = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                f605a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f606b = true;
        }
        if (f605a != null) {
            try {
                f605a.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }

    private static boolean m943c(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!f608d) {
            try {
                f607c = DrawableContainer.class.getDeclaredField("mDrawableContainerStateField");
                f607c.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("DrawableUtils", "Could not fetch mDrawableContainerStateField. Oh well.");
            }
            f608d = true;
        }
        if (f607c != null) {
            try {
                f607c.set(drawableContainer, constantState);
                return true;
            } catch (Exception e2) {
                Log.e("DrawableUtils", "Could not set mDrawableContainerStateField. Oh well.");
            }
        }
        return false;
    }
}
