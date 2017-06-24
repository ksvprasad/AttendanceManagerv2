package android.support.v4.view;

import android.view.KeyEvent;

class C0514h {
    public static int m2811a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m2812a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m2813b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
