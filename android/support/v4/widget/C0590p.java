package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class C0590p {
    private static Field f1398a;

    static {
        try {
            f1398a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1398a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m3139a(PopupWindow popupWindow, boolean z) {
        if (f1398a != null) {
            try {
                f1398a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
