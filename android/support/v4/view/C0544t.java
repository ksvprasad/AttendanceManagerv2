package android.support.v4.view;

import android.view.MotionEvent;

class C0544t {
    public static int m2902a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m2903a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m2904b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m2905c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m2906d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
