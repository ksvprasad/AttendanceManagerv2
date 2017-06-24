package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class C0513g {
    static final C0509d f1283a;

    interface C0509d {
        boolean mo450a(int i, int i2);

        boolean mo451b(int i);
    }

    static class C0510a implements C0509d {
        C0510a() {
        }

        private static int m2802a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 == null) {
                return obj != null ? i & (i3 ^ -1) : i;
            } else {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            }
        }

        public int mo452a(int i) {
            int i2 = (i & 192) != 0 ? i | 1 : i;
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean mo450a(int i, int i2) {
            return C0510a.m2802a(C0510a.m2802a(mo452a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
        }

        public boolean mo451b(int i) {
            return (mo452a(i) & 247) == 0;
        }
    }

    static class C0511b extends C0510a {
        C0511b() {
        }
    }

    static class C0512c extends C0511b {
        C0512c() {
        }

        public int mo452a(int i) {
            return C0514h.m2811a(i);
        }

        public boolean mo450a(int i, int i2) {
            return C0514h.m2812a(i, i2);
        }

        public boolean mo451b(int i) {
            return C0514h.m2813b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1283a = new C0512c();
        } else {
            f1283a = new C0510a();
        }
    }

    public static boolean m2809a(KeyEvent keyEvent) {
        return f1283a.mo451b(keyEvent.getMetaState());
    }

    public static boolean m2810a(KeyEvent keyEvent, int i) {
        return f1283a.mo450a(keyEvent.getMetaState(), i);
    }
}
