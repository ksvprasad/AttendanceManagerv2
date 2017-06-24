package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public final class ae {
    static final C0453c f1240a;

    interface C0453c {
        float mo359a(VelocityTracker velocityTracker, int i);

        float mo360b(VelocityTracker velocityTracker, int i);
    }

    static class C0454a implements C0453c {
        C0454a() {
        }

        public float mo359a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity();
        }

        public float mo360b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity();
        }
    }

    static class C0455b implements C0453c {
        C0455b() {
        }

        public float mo359a(VelocityTracker velocityTracker, int i) {
            return af.m2319a(velocityTracker, i);
        }

        public float mo360b(VelocityTracker velocityTracker, int i) {
            return af.m2320b(velocityTracker, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f1240a = new C0455b();
        } else {
            f1240a = new C0454a();
        }
    }

    public static float m2317a(VelocityTracker velocityTracker, int i) {
        return f1240a.mo359a(velocityTracker, i);
    }

    public static float m2318b(VelocityTracker velocityTracker, int i) {
        return f1240a.mo360b(velocityTracker, i);
    }
}
