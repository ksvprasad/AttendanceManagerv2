package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p012d.p013a.C0336b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class C0535p {
    static final C0530d f1289a;

    interface C0530d {
        MenuItem mo457a(MenuItem menuItem, View view);

        View mo458a(MenuItem menuItem);

        void mo459a(MenuItem menuItem, int i);

        MenuItem mo460b(MenuItem menuItem, int i);

        boolean mo461b(MenuItem menuItem);

        boolean mo462c(MenuItem menuItem);
    }

    static class C0531a implements C0530d {
        C0531a() {
        }

        public MenuItem mo457a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public View mo458a(MenuItem menuItem) {
            return null;
        }

        public void mo459a(MenuItem menuItem, int i) {
        }

        public MenuItem mo460b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public boolean mo461b(MenuItem menuItem) {
            return false;
        }

        public boolean mo462c(MenuItem menuItem) {
            return false;
        }
    }

    static class C0532b implements C0530d {
        C0532b() {
        }

        public MenuItem mo457a(MenuItem menuItem, View view) {
            return C0536q.m2866a(menuItem, view);
        }

        public View mo458a(MenuItem menuItem) {
            return C0536q.m2867a(menuItem);
        }

        public void mo459a(MenuItem menuItem, int i) {
            C0536q.m2868a(menuItem, i);
        }

        public MenuItem mo460b(MenuItem menuItem, int i) {
            return C0536q.m2869b(menuItem, i);
        }

        public boolean mo461b(MenuItem menuItem) {
            return false;
        }

        public boolean mo462c(MenuItem menuItem) {
            return false;
        }
    }

    static class C0533c extends C0532b {
        C0533c() {
        }

        public boolean mo461b(MenuItem menuItem) {
            return C0537r.m2870a(menuItem);
        }

        public boolean mo462c(MenuItem menuItem) {
            return C0537r.m2871b(menuItem);
        }
    }

    public interface C0534e {
        boolean mo650a(MenuItem menuItem);

        boolean mo651b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f1289a = new C0533c();
        } else if (i >= 11) {
            f1289a = new C0532b();
        } else {
            f1289a = new C0531a();
        }
    }

    public static MenuItem m2859a(MenuItem menuItem, C0503d c0503d) {
        if (menuItem instanceof C0336b) {
            return ((C0336b) menuItem).mo625a(c0503d);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem m2860a(MenuItem menuItem, View view) {
        return menuItem instanceof C0336b ? ((C0336b) menuItem).setActionView(view) : f1289a.mo457a(menuItem, view);
    }

    public static View m2861a(MenuItem menuItem) {
        return menuItem instanceof C0336b ? ((C0336b) menuItem).getActionView() : f1289a.mo458a(menuItem);
    }

    public static void m2862a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0336b) {
            ((C0336b) menuItem).setShowAsAction(i);
        } else {
            f1289a.mo459a(menuItem, i);
        }
    }

    public static MenuItem m2863b(MenuItem menuItem, int i) {
        return menuItem instanceof C0336b ? ((C0336b) menuItem).setActionView(i) : f1289a.mo460b(menuItem, i);
    }

    public static boolean m2864b(MenuItem menuItem) {
        return menuItem instanceof C0336b ? ((C0336b) menuItem).expandActionView() : f1289a.mo461b(menuItem);
    }

    public static boolean m2865c(MenuItem menuItem) {
        return menuItem instanceof C0336b ? ((C0336b) menuItem).isActionViewExpanded() : f1289a.mo462c(menuItem);
    }
}
