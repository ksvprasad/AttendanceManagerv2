package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

class C0180y {
    private static final C0177a f713a;

    private interface C0177a {
        void mo165a(ViewGroup viewGroup, View view, Rect rect);
    }

    private static class C0178b implements C0177a {
        private C0178b() {
        }

        public void mo165a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    private static class C0179c implements C0177a {
        private C0179c() {
        }

        public void mo165a(ViewGroup viewGroup, View view, Rect rect) {
            C0181z.m1121a(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f713a = new C0179c();
        } else {
            f713a = new C0178b();
        }
    }

    static void m1119a(ViewGroup viewGroup, View view, Rect rect) {
        f713a.mo165a(viewGroup, view, rect);
    }

    static void m1120b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        C0180y.m1119a(viewGroup, view, rect);
    }
}
