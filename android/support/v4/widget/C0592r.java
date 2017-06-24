package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class C0592r {
    private static Method f1399a;
    private static boolean f1400b;

    static void m3142a(PopupWindow popupWindow, int i) {
        if (!f1400b) {
            try {
                f1399a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1399a.setAccessible(true);
            } catch (Exception e) {
            }
            f1400b = true;
        }
        if (f1399a != null) {
            try {
                f1399a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
