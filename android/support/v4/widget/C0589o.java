package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public final class C0589o {
    static final C0583f f1397a;

    interface C0583f {
        void mo489a(PopupWindow popupWindow, int i);

        void mo490a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void mo491a(PopupWindow popupWindow, boolean z);
    }

    static class C0584c implements C0583f {
        C0584c() {
        }

        public void mo489a(PopupWindow popupWindow, int i) {
        }

        public void mo490a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo491a(PopupWindow popupWindow, boolean z) {
        }
    }

    static class C0585d extends C0584c {
        C0585d() {
        }

        public void mo489a(PopupWindow popupWindow, int i) {
            C0592r.m3142a(popupWindow, i);
        }
    }

    static class C0586e extends C0585d {
        C0586e() {
        }

        public void mo490a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C0593s.m3143a(popupWindow, view, i, i2, i3);
        }
    }

    static class C0587a extends C0586e {
        C0587a() {
        }

        public void mo491a(PopupWindow popupWindow, boolean z) {
            C0590p.m3139a(popupWindow, z);
        }
    }

    static class C0588b extends C0587a {
        C0588b() {
        }

        public void mo489a(PopupWindow popupWindow, int i) {
            C0591q.m3140a(popupWindow, i);
        }

        public void mo491a(PopupWindow popupWindow, boolean z) {
            C0591q.m3141a(popupWindow, z);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1397a = new C0588b();
        } else if (i >= 21) {
            f1397a = new C0587a();
        } else if (i >= 19) {
            f1397a = new C0586e();
        } else if (i >= 9) {
            f1397a = new C0585d();
        } else {
            f1397a = new C0584c();
        }
    }

    public static void m3136a(PopupWindow popupWindow, int i) {
        f1397a.mo489a(popupWindow, i);
    }

    public static void m3137a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1397a.mo490a(popupWindow, view, i, i2, i3);
    }

    public static void m3138a(PopupWindow popupWindow, boolean z) {
        f1397a.mo491a(popupWindow, z);
    }
}
