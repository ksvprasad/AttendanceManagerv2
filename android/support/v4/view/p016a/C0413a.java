package android.support.v4.view.p016a;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityEvent;

public final class C0413a {
    private static final C0409d f1225a;

    interface C0409d {
        int mo312a(AccessibilityEvent accessibilityEvent);

        void mo313a(AccessibilityEvent accessibilityEvent, int i);
    }

    static class C0410c implements C0409d {
        C0410c() {
        }

        public int mo312a(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void mo313a(AccessibilityEvent accessibilityEvent, int i) {
        }
    }

    static class C0411a extends C0410c {
        C0411a() {
        }
    }

    static class C0412b extends C0411a {
        C0412b() {
        }

        public int mo312a(AccessibilityEvent accessibilityEvent) {
            return C0414b.m2091a(accessibilityEvent);
        }

        public void mo313a(AccessibilityEvent accessibilityEvent, int i) {
            C0414b.m2092a(accessibilityEvent, i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f1225a = new C0412b();
        } else if (VERSION.SDK_INT >= 14) {
            f1225a = new C0411a();
        } else {
            f1225a = new C0410c();
        }
    }

    public static C0450l m2088a(AccessibilityEvent accessibilityEvent) {
        return new C0450l(accessibilityEvent);
    }

    public static void m2089a(AccessibilityEvent accessibilityEvent, int i) {
        f1225a.mo313a(accessibilityEvent, i);
    }

    public static int m2090b(AccessibilityEvent accessibilityEvent) {
        return f1225a.mo312a(accessibilityEvent);
    }
}
