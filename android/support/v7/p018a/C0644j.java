package android.support.v7.p018a;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.p018a.C0642i.C0641a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0644j extends C0642i {
    private final UiModeManager f1574r;

    class C0643a extends C0641a {
        final /* synthetic */ C0644j f1573c;

        C0643a(C0644j c0644j, Callback callback) {
            this.f1573c = c0644j;
            super(c0644j, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f1573c.mo565n()) {
                switch (i) {
                    case 0:
                        return m3459a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    C0644j(Context context, Window window, C0630e c0630e) {
        super(context, window, c0630e);
        this.f1574r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback mo563a(Callback callback) {
        return new C0643a(this, callback);
    }

    int mo564d(int i) {
        return (i == 0 && this.f1574r.getNightMode() == 0) ? -1 : super.mo564d(i);
    }
}
