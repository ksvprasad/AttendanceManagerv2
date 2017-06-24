package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class C0564d {
    private static Field f1380a;
    private static boolean f1381b;

    static Drawable m3055a(CompoundButton compoundButton) {
        if (!f1381b) {
            try {
                f1380a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1380a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1381b = true;
        }
        if (f1380a != null) {
            try {
                return (Drawable) f1380a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1380a = null;
            }
        }
        return null;
    }

    static void m3056a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof ac) {
            ((ac) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m3057a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof ac) {
            ((ac) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
