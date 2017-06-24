package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.view.C0503d;
import android.support.v4.view.C0535p.C0534e;
import android.support.v7.view.C0705c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class C0735i extends C0724c<C0336b> implements MenuItem {
    private Method f1902c;

    class C0731a extends C0503d {
        final ActionProvider f1897a;
        final /* synthetic */ C0735i f1898b;

        public C0731a(C0735i c0735i, Context context, ActionProvider actionProvider) {
            this.f1898b = c0735i;
            super(context);
            this.f1897a = actionProvider;
        }

        public View mo644a() {
            return this.f1897a.onCreateActionView();
        }

        public void mo645a(SubMenu subMenu) {
            this.f1897a.onPrepareSubMenu(this.f1898b.m3780a(subMenu));
        }

        public boolean mo646d() {
            return this.f1897a.onPerformDefaultAction();
        }

        public boolean mo647e() {
            return this.f1897a.hasSubMenu();
        }
    }

    static class C0732b extends FrameLayout implements C0705c {
        final CollapsibleActionView f1899a;

        C0732b(View view) {
            super(view.getContext());
            this.f1899a = (CollapsibleActionView) view;
            addView(view);
        }

        public void mo648a() {
            this.f1899a.onActionViewExpanded();
        }

        public void mo649b() {
            this.f1899a.onActionViewCollapsed();
        }

        View m3889c() {
            return (View) this.f1899a;
        }
    }

    private class C0733c extends C0723d<OnActionExpandListener> implements C0534e {
        final /* synthetic */ C0735i f1900a;

        C0733c(C0735i c0735i, OnActionExpandListener onActionExpandListener) {
            this.f1900a = c0735i;
            super(onActionExpandListener);
        }

        public boolean mo650a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1900a.m3779a(menuItem));
        }

        public boolean mo651b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1900a.m3779a(menuItem));
        }
    }

    private class C0734d extends C0723d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0735i f1901a;

        C0734d(C0735i c0735i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1901a = c0735i;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1901a.m3779a(menuItem));
        }
    }

    C0735i(Context context, C0336b c0336b) {
        super(context, c0336b);
    }

    C0731a mo656a(ActionProvider actionProvider) {
        return new C0731a(this, this.a, actionProvider);
    }

    public void m3893a(boolean z) {
        try {
            if (this.f1902c == null) {
                this.f1902c = ((C0336b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1902c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0336b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0336b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0503d a = ((C0336b) this.b).mo627a();
        return a instanceof C0731a ? ((C0731a) a).f1897a : null;
    }

    public View getActionView() {
        View actionView = ((C0336b) this.b).getActionView();
        return actionView instanceof C0732b ? ((C0732b) actionView).m3889c() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0336b) this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0336b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0336b) this.b).getIcon();
    }

    public Intent getIntent() {
        return ((C0336b) this.b).getIntent();
    }

    public int getItemId() {
        return ((C0336b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0336b) this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0336b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0336b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m3780a(((C0336b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0336b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0336b) this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0336b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0336b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0336b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0336b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0336b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0336b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0336b) this.b).mo625a(actionProvider != null ? mo656a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0336b) this.b).setActionView(i);
        View actionView = ((C0336b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0336b) this.b).setActionView(new C0732b(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0732b(view);
        }
        ((C0336b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0336b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0336b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0336b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0336b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0336b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0336b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0336b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0336b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0336b) this.b).mo626a(onActionExpandListener != null ? new C0733c(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0336b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0734d(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0336b) this.b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0336b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0336b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0336b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0336b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0336b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0336b) this.b).setVisible(z);
    }
}
