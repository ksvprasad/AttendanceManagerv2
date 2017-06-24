package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p018a.C0632c;
import android.support.v7.p018a.C0632c.C0629a;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.view.menu.C0721l.C0654a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class C0728g implements OnClickListener, OnDismissListener, OnKeyListener, C0654a {
    C0726e f1866a;
    private C0727f f1867b;
    private C0632c f1868c;
    private C0654a f1869d;

    public C0728g(C0727f c0727f) {
        this.f1867b = c0727f;
    }

    public void m3850a() {
        if (this.f1868c != null) {
            this.f1868c.dismiss();
        }
    }

    public void m3851a(IBinder iBinder) {
        C0727f c0727f = this.f1867b;
        C0629a c0629a = new C0629a(c0727f.m3836e());
        this.f1866a = new C0726e(c0629a.m3303a(), C0690h.abc_list_menu_item_layout);
        this.f1866a.m3791a((C0654a) this);
        this.f1867b.m3816a(this.f1866a);
        c0629a.m3307a(this.f1866a.m3788a(), (OnClickListener) this);
        View o = c0727f.m3846o();
        if (o != null) {
            c0629a.m3306a(o);
        } else {
            c0629a.m3305a(c0727f.m3845n()).m3308a(c0727f.m3844m());
        }
        c0629a.m3304a((OnKeyListener) this);
        this.f1868c = c0629a.m3314b();
        this.f1868c.setOnDismissListener(this);
        LayoutParams attributes = this.f1868c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1868c.show();
    }

    public void mo570a(C0727f c0727f, boolean z) {
        if (z || c0727f == this.f1867b) {
            m3850a();
        }
        if (this.f1869d != null) {
            this.f1869d.mo570a(c0727f, z);
        }
    }

    public boolean mo571a(C0727f c0727f) {
        return this.f1869d != null ? this.f1869d.mo571a(c0727f) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1867b.m3822a((C0730h) this.f1866a.m3788a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1866a.mo637a(this.f1867b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1868c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1868c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1867b.m3820a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1867b.performShortcut(i, keyEvent, 0);
    }
}
