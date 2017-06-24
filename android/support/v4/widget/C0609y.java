package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class C0609y {
    private static Field f1407a;
    private static boolean f1408b;
    private static Field f1409c;
    private static boolean f1410d;

    static int m3227a(TextView textView) {
        if (!f1410d) {
            f1409c = C0609y.m3229a("mMaxMode");
            f1410d = true;
        }
        if (f1409c != null && C0609y.m3228a(f1409c, textView) == 1) {
            if (!f1408b) {
                f1407a = C0609y.m3229a("mMaximum");
                f1408b = true;
            }
            if (f1407a != null) {
                return C0609y.m3228a(f1407a, textView);
            }
        }
        return -1;
    }

    private static int m3228a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    private static Field m3229a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }
}
