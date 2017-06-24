package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class C0157q {
    private static C0157q f671a;
    private final Object f672b = new Object();
    private final Handler f673c = new Handler(Looper.getMainLooper(), new C01551(this));
    private C0156b f674d;
    private C0156b f675e;

    interface C0090a {
        void mo91a();

        void mo92a(int i);
    }

    class C01551 implements Callback {
        final /* synthetic */ C0157q f668a;

        C01551(C0157q c0157q) {
            this.f668a = c0157q;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.f668a.m1033b((C0156b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    private static class C0156b {
        private final WeakReference<C0090a> f669a;
        private int f670b;

        C0156b(int i, C0090a c0090a) {
            this.f669a = new WeakReference(c0090a);
            this.f670b = i;
        }

        boolean m1027a(C0090a c0090a) {
            return c0090a != null && this.f669a.get() == c0090a;
        }
    }

    private C0157q() {
    }

    static C0157q m1028a() {
        if (f671a == null) {
            f671a = new C0157q();
        }
        return f671a;
    }

    private void m1029a(C0156b c0156b) {
        if (c0156b.f670b != -2) {
            int i = 2750;
            if (c0156b.f670b > 0) {
                i = c0156b.f670b;
            } else if (c0156b.f670b == -1) {
                i = 1500;
            }
            this.f673c.removeCallbacksAndMessages(c0156b);
            this.f673c.sendMessageDelayed(Message.obtain(this.f673c, 0, c0156b), (long) i);
        }
    }

    private boolean m1031a(C0156b c0156b, int i) {
        C0090a c0090a = (C0090a) c0156b.f669a.get();
        if (c0090a == null) {
            return false;
        }
        this.f673c.removeCallbacksAndMessages(c0156b);
        c0090a.mo92a(i);
        return true;
    }

    private void m1032b() {
        if (this.f675e != null) {
            this.f674d = this.f675e;
            this.f675e = null;
            C0090a c0090a = (C0090a) this.f674d.f669a.get();
            if (c0090a != null) {
                c0090a.mo91a();
            } else {
                this.f674d = null;
            }
        }
    }

    private void m1033b(C0156b c0156b) {
        synchronized (this.f672b) {
            if (this.f674d == c0156b || this.f675e == c0156b) {
                m1031a(c0156b, 2);
            }
        }
    }

    private boolean m1034f(C0090a c0090a) {
        return this.f674d != null && this.f674d.m1027a(c0090a);
    }

    private boolean m1035g(C0090a c0090a) {
        return this.f675e != null && this.f675e.m1027a(c0090a);
    }

    public void m1036a(int i, C0090a c0090a) {
        synchronized (this.f672b) {
            if (m1034f(c0090a)) {
                this.f674d.f670b = i;
                this.f673c.removeCallbacksAndMessages(this.f674d);
                m1029a(this.f674d);
                return;
            }
            if (m1035g(c0090a)) {
                this.f675e.f670b = i;
            } else {
                this.f675e = new C0156b(i, c0090a);
            }
            if (this.f674d == null || !m1031a(this.f674d, 4)) {
                this.f674d = null;
                m1032b();
                return;
            }
        }
    }

    public void m1037a(C0090a c0090a) {
        synchronized (this.f672b) {
            if (m1034f(c0090a)) {
                this.f674d = null;
                if (this.f675e != null) {
                    m1032b();
                }
            }
        }
    }

    public void m1038a(C0090a c0090a, int i) {
        synchronized (this.f672b) {
            if (m1034f(c0090a)) {
                m1031a(this.f674d, i);
            } else if (m1035g(c0090a)) {
                m1031a(this.f675e, i);
            }
        }
    }

    public void m1039b(C0090a c0090a) {
        synchronized (this.f672b) {
            if (m1034f(c0090a)) {
                m1029a(this.f674d);
            }
        }
    }

    public void m1040c(C0090a c0090a) {
        synchronized (this.f672b) {
            if (m1034f(c0090a)) {
                this.f673c.removeCallbacksAndMessages(this.f674d);
            }
        }
    }

    public void m1041d(C0090a c0090a) {
        synchronized (this.f672b) {
            if (m1034f(c0090a)) {
                m1029a(this.f674d);
            }
        }
    }

    public boolean m1042e(C0090a c0090a) {
        boolean z;
        synchronized (this.f672b) {
            z = m1034f(c0090a) || m1035g(c0090a);
        }
        return z;
    }
}
