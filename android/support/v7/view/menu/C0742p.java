package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p010b.C0195a;
import android.support.v7.view.menu.C0727f.C0638a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class C0742p extends C0727f implements SubMenu {
    private C0727f f1926d;
    private C0730h f1927e;

    public C0742p(Context context, C0727f c0727f, C0730h c0730h) {
        super(context);
        this.f1926d = c0727f;
        this.f1927e = c0730h;
    }

    public String mo657a() {
        int itemId = this.f1927e != null ? this.f1927e.getItemId() : 0;
        return itemId == 0 ? null : super.mo657a() + ":" + itemId;
    }

    public void mo658a(C0638a c0638a) {
        this.f1926d.mo658a(c0638a);
    }

    boolean mo659a(C0727f c0727f, MenuItem menuItem) {
        return super.mo659a(c0727f, menuItem) || this.f1926d.mo659a(c0727f, menuItem);
    }

    public boolean mo660b() {
        return this.f1926d.mo660b();
    }

    public boolean mo661c() {
        return this.f1926d.mo661c();
    }

    public boolean mo662c(C0730h c0730h) {
        return this.f1926d.mo662c(c0730h);
    }

    public boolean mo663d(C0730h c0730h) {
        return this.f1926d.mo663d(c0730h);
    }

    public MenuItem getItem() {
        return this.f1927e;
    }

    public C0727f mo664p() {
        return this.f1926d;
    }

    public Menu m3933s() {
        return this.f1926d;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m3807a(C0195a.m1224a(m3836e(), i));
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m3807a(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m3809a(m3836e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m3809a(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m3808a(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1927e.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1927e.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.f1926d.setQwertyMode(z);
    }
}
