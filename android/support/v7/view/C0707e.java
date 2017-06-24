package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class C0707e extends C0679b implements C0638a {
    private Context f1703a;
    private ActionBarContextView f1704b;
    private C0657a f1705c;
    private WeakReference<View> f1706d;
    private boolean f1707e;
    private boolean f1708f;
    private C0727f f1709g;

    public C0707e(Context context, ActionBarContextView actionBarContextView, C0657a c0657a, boolean z) {
        this.f1703a = context;
        this.f1704b = actionBarContextView;
        this.f1705c = c0657a;
        this.f1709g = new C0727f(actionBarContextView.getContext()).m3806a(1);
        this.f1709g.mo658a((C0638a) this);
        this.f1708f = z;
    }

    public MenuInflater mo597a() {
        return new C0712g(this.f1704b.getContext());
    }

    public void mo598a(int i) {
        mo604b(this.f1703a.getString(i));
    }

    public void mo543a(C0727f c0727f) {
        mo606d();
        this.f1704b.mo667a();
    }

    public void mo599a(View view) {
        this.f1704b.setCustomView(view);
        this.f1706d = view != null ? new WeakReference(view) : null;
    }

    public void mo600a(CharSequence charSequence) {
        this.f1704b.setSubtitle(charSequence);
    }

    public void mo601a(boolean z) {
        super.mo601a(z);
        this.f1704b.setTitleOptional(z);
    }

    public boolean mo548a(C0727f c0727f, MenuItem menuItem) {
        return this.f1705c.mo574a((C0679b) this, menuItem);
    }

    public Menu mo602b() {
        return this.f1709g;
    }

    public void mo603b(int i) {
        mo600a(this.f1703a.getString(i));
    }

    public void mo604b(CharSequence charSequence) {
        this.f1704b.setTitle(charSequence);
    }

    public void mo605c() {
        if (!this.f1707e) {
            this.f1707e = true;
            this.f1704b.sendAccessibilityEvent(32);
            this.f1705c.mo572a(this);
        }
    }

    public void mo606d() {
        this.f1705c.mo575b(this, this.f1709g);
    }

    public CharSequence mo607f() {
        return this.f1704b.getTitle();
    }

    public CharSequence mo608g() {
        return this.f1704b.getSubtitle();
    }

    public boolean mo609h() {
        return this.f1704b.m3950d();
    }

    public View mo610i() {
        return this.f1706d != null ? (View) this.f1706d.get() : null;
    }
}
