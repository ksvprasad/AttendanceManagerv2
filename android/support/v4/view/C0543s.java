package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class C0543s {
    static final C0538e f1290a;

    interface C0538e {
        int mo463a(MotionEvent motionEvent);

        int mo464a(MotionEvent motionEvent, int i);

        int mo465b(MotionEvent motionEvent);

        int mo466b(MotionEvent motionEvent, int i);

        float mo467c(MotionEvent motionEvent, int i);

        float mo468d(MotionEvent motionEvent, int i);

        float mo469e(MotionEvent motionEvent, int i);
    }

    static class C0539a implements C0538e {
        C0539a() {
        }

        public int mo463a(MotionEvent motionEvent) {
            return 1;
        }

        public int mo464a(MotionEvent motionEvent, int i) {
            return i == 0 ? 0 : -1;
        }

        public int mo465b(MotionEvent motionEvent) {
            return 0;
        }

        public int mo466b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo467c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo468d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float mo469e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class C0540b extends C0539a {
        C0540b() {
        }

        public int mo463a(MotionEvent motionEvent) {
            return C0544t.m2902a(motionEvent);
        }

        public int mo464a(MotionEvent motionEvent, int i) {
            return C0544t.m2903a(motionEvent, i);
        }

        public int mo466b(MotionEvent motionEvent, int i) {
            return C0544t.m2904b(motionEvent, i);
        }

        public float mo467c(MotionEvent motionEvent, int i) {
            return C0544t.m2905c(motionEvent, i);
        }

        public float mo468d(MotionEvent motionEvent, int i) {
            return C0544t.m2906d(motionEvent, i);
        }
    }

    static class C0541c extends C0540b {
        C0541c() {
        }

        public int mo465b(MotionEvent motionEvent) {
            return C0545u.m2907a(motionEvent);
        }
    }

    static class C0542d extends C0541c {
        C0542d() {
        }

        public float mo469e(MotionEvent motionEvent, int i) {
            return C0546v.m2908a(motionEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            f1290a = new C0542d();
        } else if (VERSION.SDK_INT >= 9) {
            f1290a = new C0541c();
        } else if (VERSION.SDK_INT >= 5) {
            f1290a = new C0540b();
        } else {
            f1290a = new C0539a();
        }
    }

    public static int m2893a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m2894a(MotionEvent motionEvent, int i) {
        return f1290a.mo464a(motionEvent, i);
    }

    public static int m2895b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m2896b(MotionEvent motionEvent, int i) {
        return f1290a.mo466b(motionEvent, i);
    }

    public static float m2897c(MotionEvent motionEvent, int i) {
        return f1290a.mo467c(motionEvent, i);
    }

    public static int m2898c(MotionEvent motionEvent) {
        return f1290a.mo463a(motionEvent);
    }

    public static float m2899d(MotionEvent motionEvent, int i) {
        return f1290a.mo468d(motionEvent, i);
    }

    public static int m2900d(MotionEvent motionEvent) {
        return f1290a.mo465b(motionEvent);
    }

    public static float m2901e(MotionEvent motionEvent, int i) {
        return f1290a.mo469e(motionEvent, i);
    }
}
