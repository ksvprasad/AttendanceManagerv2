package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.ab;
import android.view.View;
import android.view.ViewGroup;

public abstract class C0273t extends ab {
    private final C0263r f997a;
    private C0250v f998b = null;
    private Fragment f999c = null;

    public C0273t(C0263r c0263r) {
        this.f997a = c0263r;
    }

    private static String m1595a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public Parcelable mo231a() {
        return null;
    }

    public abstract Fragment mo1788a(int i);

    public Object mo232a(ViewGroup viewGroup, int i) {
        if (this.f998b == null) {
            this.f998b = this.f997a.mo224a();
        }
        long b = m1603b(i);
        Fragment a = this.f997a.mo223a(C0273t.m1595a(viewGroup.getId(), b));
        if (a != null) {
            this.f998b.mo195c(a);
        } else {
            a = mo1788a(i);
            this.f998b.mo189a(viewGroup.getId(), a, C0273t.m1595a(viewGroup.getId(), b));
        }
        if (a != this.f999c) {
            a.m1190e(false);
            a.m1193f(false);
        }
        return a;
    }

    public void mo233a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void mo234a(ViewGroup viewGroup) {
    }

    public void mo235a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f998b == null) {
            this.f998b = this.f997a.mo224a();
        }
        this.f998b.mo194b((Fragment) obj);
    }

    public boolean mo236a(View view, Object obj) {
        return ((Fragment) obj).m1210r() == view;
    }

    public long m1603b(int i) {
        return (long) i;
    }

    public void mo237b(ViewGroup viewGroup) {
        if (this.f998b != null) {
            this.f998b.mo192b();
            this.f998b = null;
            this.f997a.mo229b();
        }
    }

    public void mo238b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f999c) {
            if (this.f999c != null) {
                this.f999c.m1190e(false);
                this.f999c.m1193f(false);
            }
            if (fragment != null) {
                fragment.m1190e(true);
                fragment.m1193f(true);
            }
            this.f999c = fragment;
        }
    }
}
