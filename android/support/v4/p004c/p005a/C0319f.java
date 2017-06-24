package android.support.v4.p004c.p005a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class C0319f {
    private static Method f1062a;
    private static boolean f1063b;
    private static Method f1064c;
    private static boolean f1065d;

    public static int m1788a(Drawable drawable) {
        if (!f1065d) {
            try {
                f1064c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f1064c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f1065d = true;
        }
        if (f1064c != null) {
            try {
                return ((Integer) f1064c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f1064c = null;
            }
        }
        return -1;
    }

    public static void m1789a(Drawable drawable, int i) {
        if (!f1063b) {
            try {
                f1062a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f1062a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f1063b = true;
        }
        if (f1062a != null) {
            try {
                f1062a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f1062a = null;
            }
        }
    }
}
