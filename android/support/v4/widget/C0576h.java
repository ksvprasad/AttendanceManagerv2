package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public final class C0576h {
    private static final C0572c f1394b;
    private Object f1395a;

    interface C0572c {
        Object mo477a(Context context);

        void mo478a(Object obj, int i, int i2);

        boolean mo479a(Object obj);

        boolean mo480a(Object obj, float f);

        boolean mo481a(Object obj, float f, float f2);

        boolean mo482a(Object obj, int i);

        boolean mo483a(Object obj, Canvas canvas);

        void mo484b(Object obj);

        boolean mo485c(Object obj);
    }

    static class C0573a implements C0572c {
        C0573a() {
        }

        public Object mo477a(Context context) {
            return null;
        }

        public void mo478a(Object obj, int i, int i2) {
        }

        public boolean mo479a(Object obj) {
            return true;
        }

        public boolean mo480a(Object obj, float f) {
            return false;
        }

        public boolean mo481a(Object obj, float f, float f2) {
            return false;
        }

        public boolean mo482a(Object obj, int i) {
            return false;
        }

        public boolean mo483a(Object obj, Canvas canvas) {
            return false;
        }

        public void mo484b(Object obj) {
        }

        public boolean mo485c(Object obj) {
            return false;
        }
    }

    static class C0574b implements C0572c {
        C0574b() {
        }

        public Object mo477a(Context context) {
            return C0577i.m3110a(context);
        }

        public void mo478a(Object obj, int i, int i2) {
            C0577i.m3111a(obj, i, i2);
        }

        public boolean mo479a(Object obj) {
            return C0577i.m3112a(obj);
        }

        public boolean mo480a(Object obj, float f) {
            return C0577i.m3113a(obj, f);
        }

        public boolean mo481a(Object obj, float f, float f2) {
            return C0577i.m3113a(obj, f);
        }

        public boolean mo482a(Object obj, int i) {
            return C0577i.m3114a(obj, i);
        }

        public boolean mo483a(Object obj, Canvas canvas) {
            return C0577i.m3115a(obj, canvas);
        }

        public void mo484b(Object obj) {
            C0577i.m3116b(obj);
        }

        public boolean mo485c(Object obj) {
            return C0577i.m3117c(obj);
        }
    }

    static class C0575d extends C0574b {
        C0575d() {
        }

        public boolean mo481a(Object obj, float f, float f2) {
            return C0578j.m3118a(obj, f, f2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f1394b = new C0575d();
        } else if (VERSION.SDK_INT >= 14) {
            f1394b = new C0574b();
        } else {
            f1394b = new C0573a();
        }
    }

    public C0576h(Context context) {
        this.f1395a = f1394b.mo477a(context);
    }

    public void m3102a(int i, int i2) {
        f1394b.mo478a(this.f1395a, i, i2);
    }

    public boolean m3103a() {
        return f1394b.mo479a(this.f1395a);
    }

    public boolean m3104a(float f) {
        return f1394b.mo480a(this.f1395a, f);
    }

    public boolean m3105a(float f, float f2) {
        return f1394b.mo481a(this.f1395a, f, f2);
    }

    public boolean m3106a(int i) {
        return f1394b.mo482a(this.f1395a, i);
    }

    public boolean m3107a(Canvas canvas) {
        return f1394b.mo483a(this.f1395a, canvas);
    }

    public void m3108b() {
        f1394b.mo484b(this.f1395a);
    }

    public boolean m3109c() {
        return f1394b.mo485c(this.f1395a);
    }
}
