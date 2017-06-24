package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p012d.p013a.C0335a;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.p015g.C0369j;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.view.menu.C0740n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public class C0709f extends ActionMode {
    final Context f1714a;
    final C0679b f1715b;

    public static class C0708a implements C0657a {
        final Callback f1710a;
        final Context f1711b;
        final ArrayList<C0709f> f1712c = new ArrayList();
        final C0369j<Menu, Menu> f1713d = new C0369j();

        public C0708a(Context context, Callback callback) {
            this.f1711b = context;
            this.f1710a = callback;
        }

        private Menu m3675a(Menu menu) {
            Menu menu2 = (Menu) this.f1713d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0740n.m3922a(this.f1711b, (C0335a) menu);
            this.f1713d.put(menu, menu2);
            return menu2;
        }

        public void mo572a(C0679b c0679b) {
            this.f1710a.onDestroyActionMode(m3679b(c0679b));
        }

        public boolean mo573a(C0679b c0679b, Menu menu) {
            return this.f1710a.onCreateActionMode(m3679b(c0679b), m3675a(menu));
        }

        public boolean mo574a(C0679b c0679b, MenuItem menuItem) {
            return this.f1710a.onActionItemClicked(m3679b(c0679b), C0740n.m3923a(this.f1711b, (C0336b) menuItem));
        }

        public ActionMode m3679b(C0679b c0679b) {
            int size = this.f1712c.size();
            for (int i = 0; i < size; i++) {
                C0709f c0709f = (C0709f) this.f1712c.get(i);
                if (c0709f != null && c0709f.f1715b == c0679b) {
                    return c0709f;
                }
            }
            ActionMode c0709f2 = new C0709f(this.f1711b, c0679b);
            this.f1712c.add(c0709f2);
            return c0709f2;
        }

        public boolean mo575b(C0679b c0679b, Menu menu) {
            return this.f1710a.onPrepareActionMode(m3679b(c0679b), m3675a(menu));
        }
    }

    public C0709f(Context context, C0679b c0679b) {
        this.f1714a = context;
        this.f1715b = c0679b;
    }

    public void finish() {
        this.f1715b.mo605c();
    }

    public View getCustomView() {
        return this.f1715b.mo610i();
    }

    public Menu getMenu() {
        return C0740n.m3922a(this.f1714a, (C0335a) this.f1715b.mo602b());
    }

    public MenuInflater getMenuInflater() {
        return this.f1715b.mo597a();
    }

    public CharSequence getSubtitle() {
        return this.f1715b.mo608g();
    }

    public Object getTag() {
        return this.f1715b.m3571j();
    }

    public CharSequence getTitle() {
        return this.f1715b.mo607f();
    }

    public boolean getTitleOptionalHint() {
        return this.f1715b.m3572k();
    }

    public void invalidate() {
        this.f1715b.mo606d();
    }

    public boolean isTitleOptional() {
        return this.f1715b.mo609h();
    }

    public void setCustomView(View view) {
        this.f1715b.mo599a(view);
    }

    public void setSubtitle(int i) {
        this.f1715b.mo603b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1715b.mo600a(charSequence);
    }

    public void setTag(Object obj) {
        this.f1715b.m3560a(obj);
    }

    public void setTitle(int i) {
        this.f1715b.mo598a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1715b.mo604b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1715b.mo601a(z);
    }
}
