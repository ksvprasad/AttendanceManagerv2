package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p010b.C0195a;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.view.C0503d;
import android.support.v4.view.C0535p.C0534e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class C0720a implements C0336b {
    private final int f1802a;
    private final int f1803b;
    private final int f1804c;
    private final int f1805d;
    private CharSequence f1806e;
    private CharSequence f1807f;
    private Intent f1808g;
    private char f1809h;
    private char f1810i;
    private Drawable f1811j;
    private int f1812k = 0;
    private Context f1813l;
    private OnMenuItemClickListener f1814m;
    private int f1815n = 16;

    public C0720a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1813l = context;
        this.f1802a = i2;
        this.f1803b = i;
        this.f1804c = i3;
        this.f1805d = i4;
        this.f1806e = charSequence;
    }

    public C0336b m3749a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0336b mo625a(C0503d c0503d) {
        throw new UnsupportedOperationException();
    }

    public C0336b mo626a(C0534e c0534e) {
        return this;
    }

    public C0336b m3752a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0503d mo627a() {
        return null;
    }

    public C0336b m3754b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f1810i;
    }

    public int getGroupId() {
        return this.f1803b;
    }

    public Drawable getIcon() {
        return this.f1811j;
    }

    public Intent getIntent() {
        return this.f1808g;
    }

    public int getItemId() {
        return this.f1802a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1809h;
    }

    public int getOrder() {
        return this.f1805d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1806e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1807f != null ? this.f1807f : this.f1806e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1815n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1815n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1815n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1815n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3749a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3752a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1810i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1815n = (z ? 1 : 0) | (this.f1815n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1815n = (z ? 2 : 0) | (this.f1815n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1815n = (z ? 16 : 0) | (this.f1815n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1812k = i;
        this.f1811j = C0195a.m1224a(this.f1813l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1811j = drawable;
        this.f1812k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1808g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1809h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1814m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1809h = c;
        this.f1810i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3754b(i);
    }

    public MenuItem setTitle(int i) {
        this.f1806e = this.f1813l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1806e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1807f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1815n = (z ? 0 : 8) | (this.f1815n & 8);
        return this;
    }
}
