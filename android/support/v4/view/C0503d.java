package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class C0503d {
    private final Context f1279a;
    private C0501a f1280b;
    private C0502b f1281c;

    public interface C0501a {
        void mo862a(boolean z);
    }

    public interface C0502b {
        void mo643a(boolean z);
    }

    public C0503d(Context context) {
        this.f1279a = context;
    }

    public abstract View mo644a();

    public View mo652a(MenuItem menuItem) {
        return mo644a();
    }

    public void m2781a(C0501a c0501a) {
        this.f1280b = c0501a;
    }

    public void mo653a(C0502b c0502b) {
        if (!(this.f1281c == null || c0502b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1281c = c0502b;
    }

    public void mo645a(SubMenu subMenu) {
    }

    public void m2784a(boolean z) {
        if (this.f1280b != null) {
            this.f1280b.mo862a(z);
        }
    }

    public boolean mo654b() {
        return false;
    }

    public boolean mo655c() {
        return true;
    }

    public boolean mo646d() {
        return false;
    }

    public boolean mo647e() {
        return false;
    }

    public void m2789f() {
        this.f1281c = null;
        this.f1280b = null;
    }
}
