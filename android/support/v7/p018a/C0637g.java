package android.support.v7.p018a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.view.C0635i;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.view.C0712g;
import android.support.v7.view.menu.C0727f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class C0637g extends C0634f {
    final Context f1529a;
    final Window f1530b;
    final Callback f1531c = this.f1530b.getCallback();
    final Callback f1532d;
    final C0630e f1533e;
    C0614a f1534f;
    MenuInflater f1535g;
    boolean f1536h;
    boolean f1537i;
    boolean f1538j;
    boolean f1539k;
    boolean f1540l;
    private CharSequence f1541m;
    private boolean f1542n;

    class C0636a extends C0635i {
        final /* synthetic */ C0637g f1528a;

        C0636a(C0637g c0637g, Callback callback) {
            this.f1528a = c0637g;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1528a.mo549a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f1528a.mo547a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof C0727f)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f1528a.mo554b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f1528a.mo540a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0727f c0727f = menu instanceof C0727f ? (C0727f) menu : null;
            if (i == 0 && c0727f == null) {
                return false;
            }
            if (c0727f != null) {
                c0727f.m3831c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0727f == null) {
                return onPreparePanel;
            }
            c0727f.m3831c(false);
            return onPreparePanel;
        }
    }

    C0637g(Context context, Window window, C0630e c0630e) {
        this.f1529a = context;
        this.f1530b = window;
        this.f1533e = c0630e;
        if (this.f1531c instanceof C0636a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1532d = mo563a(this.f1531c);
        this.f1530b.setCallback(this.f1532d);
    }

    public C0614a mo532a() {
        mo560k();
        return this.f1534f;
    }

    abstract C0679b mo538a(C0657a c0657a);

    Callback mo563a(Callback callback) {
        return new C0636a(this, callback);
    }

    abstract void mo540a(int i, Menu menu);

    public final void mo533a(CharSequence charSequence) {
        this.f1541m = charSequence;
        mo553b(charSequence);
    }

    abstract boolean mo547a(int i, KeyEvent keyEvent);

    abstract boolean mo549a(KeyEvent keyEvent);

    public MenuInflater mo534b() {
        if (this.f1535g == null) {
            mo560k();
            this.f1535g = new C0712g(this.f1534f != null ? this.f1534f.mo587c() : this.f1529a);
        }
        return this.f1535g;
    }

    abstract void mo553b(CharSequence charSequence);

    abstract boolean mo554b(int i, Menu menu);

    public void mo535c(Bundle bundle) {
    }

    public void mo536f() {
        this.f1542n = true;
    }

    public boolean mo537h() {
        return false;
    }

    abstract void mo560k();

    final C0614a m3380l() {
        return this.f1534f;
    }

    final Context m3381m() {
        Context context = null;
        C0614a a = mo532a();
        if (a != null) {
            context = a.mo587c();
        }
        return context == null ? this.f1529a : context;
    }

    public boolean mo565n() {
        return false;
    }

    final boolean m3383o() {
        return this.f1542n;
    }

    final Callback m3384p() {
        return this.f1530b.getCallback();
    }

    final CharSequence m3385q() {
        return this.f1531c instanceof Activity ? ((Activity) this.f1531c).getTitle() : this.f1541m;
    }
}
