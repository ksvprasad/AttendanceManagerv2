package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class C0679b {
    private Object f1656a;
    private boolean f1657b;

    public interface C0657a {
        void mo572a(C0679b c0679b);

        boolean mo573a(C0679b c0679b, Menu menu);

        boolean mo574a(C0679b c0679b, MenuItem menuItem);

        boolean mo575b(C0679b c0679b, Menu menu);
    }

    public abstract MenuInflater mo597a();

    public abstract void mo598a(int i);

    public abstract void mo599a(View view);

    public abstract void mo600a(CharSequence charSequence);

    public void m3560a(Object obj) {
        this.f1656a = obj;
    }

    public void mo601a(boolean z) {
        this.f1657b = z;
    }

    public abstract Menu mo602b();

    public abstract void mo603b(int i);

    public abstract void mo604b(CharSequence charSequence);

    public abstract void mo605c();

    public abstract void mo606d();

    public abstract CharSequence mo607f();

    public abstract CharSequence mo608g();

    public boolean mo609h() {
        return false;
    }

    public abstract View mo610i();

    public Object m3571j() {
        return this.f1656a;
    }

    public boolean m3572k() {
        return this.f1657b;
    }
}
