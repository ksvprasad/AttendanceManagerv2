package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p012d.p013a.C0337c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class C0743q extends C0741o implements SubMenu {
    C0743q(Context context, C0337c c0337c) {
        super(context, c0337c);
    }

    public C0337c m3934b() {
        return (C0337c) this.b;
    }

    public void clearHeader() {
        m3934b().clearHeader();
    }

    public MenuItem getItem() {
        return m3779a(m3934b().getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        m3934b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3934b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        m3934b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3934b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3934b().setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        m3934b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3934b().setIcon(drawable);
        return this;
    }
}
