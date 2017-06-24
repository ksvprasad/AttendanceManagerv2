package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.p012d.p013a.C0337c;
import android.support.v4.p015g.C0370a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class C0724c<T> extends C0723d<T> {
    final Context f1827a;
    private Map<C0336b, MenuItem> f1828c;
    private Map<C0337c, SubMenu> f1829d;

    C0724c(Context context, T t) {
        super(t);
        this.f1827a = context;
    }

    final MenuItem m3779a(MenuItem menuItem) {
        if (!(menuItem instanceof C0336b)) {
            return menuItem;
        }
        C0336b c0336b = (C0336b) menuItem;
        if (this.f1828c == null) {
            this.f1828c = new C0370a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1828c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0740n.m3923a(this.f1827a, c0336b);
        this.f1828c.put(c0336b, menuItem2);
        return menuItem2;
    }

    final SubMenu m3780a(SubMenu subMenu) {
        if (!(subMenu instanceof C0337c)) {
            return subMenu;
        }
        C0337c c0337c = (C0337c) subMenu;
        if (this.f1829d == null) {
            this.f1829d = new C0370a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1829d.get(c0337c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0740n.m3924a(this.f1827a, c0337c);
        this.f1829d.put(c0337c, subMenu2);
        return subMenu2;
    }

    final void m3781a() {
        if (this.f1828c != null) {
            this.f1828c.clear();
        }
        if (this.f1829d != null) {
            this.f1829d.clear();
        }
    }

    final void m3782a(int i) {
        if (this.f1828c != null) {
            Iterator it = this.f1828c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m3783b(int i) {
        if (this.f1828c != null) {
            Iterator it = this.f1828c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
