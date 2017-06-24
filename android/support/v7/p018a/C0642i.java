package android.support.v7.p018a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.p018a.C0637g.C0636a;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.view.C0709f.C0708a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0642i extends C0640h {
    private static C0675p f1569r;
    private int f1570s = -100;
    private boolean f1571t;
    private boolean f1572u = true;

    class C0641a extends C0636a {
        final /* synthetic */ C0642i f1568b;

        C0641a(C0642i c0642i, Callback callback) {
            this.f1568b = c0642i;
            super(c0642i, callback);
        }

        final ActionMode m3459a(ActionMode.Callback callback) {
            Object c0708a = new C0708a(this.f1568b.a, callback);
            C0679b b = this.f1568b.m3440b((C0657a) c0708a);
            return b != null ? c0708a.m3679b(b) : null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f1568b.mo565n() ? m3459a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    C0642i(Context context, Window window, C0630e c0630e) {
        super(context, window, c0630e);
    }

    private boolean m3460e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private C0675p m3461s() {
        if (f1569r == null) {
            f1569r = new C0675p(this.a.getApplicationContext());
        }
        return f1569r;
    }

    Callback mo563a(Callback callback) {
        return new C0641a(this, callback);
    }

    public void mo542a(Bundle bundle) {
        super.mo542a(bundle);
        if (bundle != null && this.f1570s == -100) {
            this.f1570s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void mo535c(Bundle bundle) {
        super.mo535c(bundle);
        if (this.f1570s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f1570s);
        }
    }

    int mo564d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                return m3461s().m3552a() ? 2 : 1;
            default:
                return i;
        }
    }

    public boolean mo537h() {
        this.f1571t = true;
        int d = mo564d(this.f1570s == -100 ? C0634f.m3344i() : this.f1570s);
        return d != -1 ? m3460e(d) : false;
    }

    public boolean mo565n() {
        return this.f1572u;
    }
}
