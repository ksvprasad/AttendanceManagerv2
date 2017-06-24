package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.C0498b.C0401a;
import android.support.v4.view.C0500c.C0406a;
import android.support.v4.view.p016a.C0426c;
import android.support.v4.view.p016a.C0440i;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class C0124a {
    private static final C0403b f509a;
    private static final Object f510c = f509a.mo293a();
    final Object f511b = f509a.mo294a(this);

    interface C0403b {
        C0440i mo292a(Object obj, View view);

        Object mo293a();

        Object mo294a(C0124a c0124a);

        void mo295a(Object obj, View view, int i);

        void mo296a(Object obj, View view, C0426c c0426c);

        boolean mo297a(Object obj, View view, int i, Bundle bundle);

        boolean mo298a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean mo299a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void mo300b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo301c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void mo302d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    static class C0404d implements C0403b {
        C0404d() {
        }

        public C0440i mo292a(Object obj, View view) {
            return null;
        }

        public Object mo293a() {
            return null;
        }

        public Object mo294a(C0124a c0124a) {
            return null;
        }

        public void mo295a(Object obj, View view, int i) {
        }

        public void mo296a(Object obj, View view, C0426c c0426c) {
        }

        public boolean mo297a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean mo298a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public boolean mo299a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void mo300b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo301c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void mo302d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    static class C0405a extends C0404d {
        C0405a() {
        }

        public Object mo293a() {
            return C0498b.m2749a();
        }

        public Object mo294a(final C0124a c0124a) {
            return C0498b.m2750a(new C0401a(this) {
                final /* synthetic */ C0405a f1222b;

                public void mo285a(View view, int i) {
                    c0124a.m848a(view, i);
                }

                public void mo286a(View view, Object obj) {
                    c0124a.mo113a(view, new C0426c(obj));
                }

                public boolean mo287a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0124a.m855d(view, accessibilityEvent);
                }

                public boolean mo288a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0124a.m852a(viewGroup, view, accessibilityEvent);
                }

                public void mo289b(View view, AccessibilityEvent accessibilityEvent) {
                    c0124a.mo114a(view, accessibilityEvent);
                }

                public void mo290c(View view, AccessibilityEvent accessibilityEvent) {
                    c0124a.mo115b(view, accessibilityEvent);
                }

                public void mo291d(View view, AccessibilityEvent accessibilityEvent) {
                    c0124a.m854c(view, accessibilityEvent);
                }
            });
        }

        public void mo295a(Object obj, View view, int i) {
            C0498b.m2751a(obj, view, i);
        }

        public void mo296a(Object obj, View view, C0426c c0426c) {
            C0498b.m2752a(obj, view, c0426c.m2187a());
        }

        public boolean mo298a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0498b.m2753a(obj, view, accessibilityEvent);
        }

        public boolean mo299a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0498b.m2754a(obj, viewGroup, view, accessibilityEvent);
        }

        public void mo300b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0498b.m2755b(obj, view, accessibilityEvent);
        }

        public void mo301c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0498b.m2756c(obj, view, accessibilityEvent);
        }

        public void mo302d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0498b.m2757d(obj, view, accessibilityEvent);
        }
    }

    static class C0408c extends C0405a {
        C0408c() {
        }

        public C0440i mo292a(Object obj, View view) {
            Object a = C0500c.m2775a(obj, view);
            return a != null ? new C0440i(a) : null;
        }

        public Object mo294a(final C0124a c0124a) {
            return C0500c.m2774a(new C0406a(this) {
                final /* synthetic */ C0408c f1224b;

                public Object mo303a(View view) {
                    C0440i a = c0124a.m846a(view);
                    return a != null ? a.m2265a() : null;
                }

                public void mo304a(View view, int i) {
                    c0124a.m848a(view, i);
                }

                public void mo305a(View view, Object obj) {
                    c0124a.mo113a(view, new C0426c(obj));
                }

                public boolean mo306a(View view, int i, Bundle bundle) {
                    return c0124a.mo284a(view, i, bundle);
                }

                public boolean mo307a(View view, AccessibilityEvent accessibilityEvent) {
                    return c0124a.m855d(view, accessibilityEvent);
                }

                public boolean mo308a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0124a.m852a(viewGroup, view, accessibilityEvent);
                }

                public void mo309b(View view, AccessibilityEvent accessibilityEvent) {
                    c0124a.mo114a(view, accessibilityEvent);
                }

                public void mo310c(View view, AccessibilityEvent accessibilityEvent) {
                    c0124a.mo115b(view, accessibilityEvent);
                }

                public void mo311d(View view, AccessibilityEvent accessibilityEvent) {
                    c0124a.m854c(view, accessibilityEvent);
                }
            });
        }

        public boolean mo297a(Object obj, View view, int i, Bundle bundle) {
            return C0500c.m2776a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f509a = new C0408c();
        } else if (VERSION.SDK_INT >= 14) {
            f509a = new C0405a();
        } else {
            f509a = new C0404d();
        }
    }

    public C0440i m846a(View view) {
        return f509a.mo292a(f510c, view);
    }

    Object m847a() {
        return this.f511b;
    }

    public void m848a(View view, int i) {
        f509a.mo295a(f510c, view, i);
    }

    public void mo113a(View view, C0426c c0426c) {
        f509a.mo296a(f510c, view, c0426c);
    }

    public void mo114a(View view, AccessibilityEvent accessibilityEvent) {
        f509a.mo300b(f510c, view, accessibilityEvent);
    }

    public boolean mo284a(View view, int i, Bundle bundle) {
        return f509a.mo297a(f510c, view, i, bundle);
    }

    public boolean m852a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f509a.mo299a(f510c, viewGroup, view, accessibilityEvent);
    }

    public void mo115b(View view, AccessibilityEvent accessibilityEvent) {
        f509a.mo301c(f510c, view, accessibilityEvent);
    }

    public void m854c(View view, AccessibilityEvent accessibilityEvent) {
        f509a.mo302d(f510c, view, accessibilityEvent);
    }

    public boolean m855d(View view, AccessibilityEvent accessibilityEvent) {
        return f509a.mo298a(f510c, view, accessibilityEvent);
    }
}
