package android.support.v7.p018a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0196a;
import android.support.v4.app.C0260n;
import android.support.v4.app.C0290z;
import android.support.v4.app.at;
import android.support.v4.app.at.C0228a;
import android.support.v4.view.C0513g;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bj;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class C0633d extends C0260n implements C0228a, C0630e {
    private C0634f f1521m;
    private int f1522n = 0;
    private boolean f1523o;
    private Resources f1524p;

    public Intent mo516a() {
        return C0290z.m1674a(this);
    }

    public C0679b mo511a(C0657a c0657a) {
        return null;
    }

    public void m3329a(at atVar) {
        atVar.m1318a((Activity) this);
    }

    public void mo512a(C0679b c0679b) {
    }

    public void m3331a(Toolbar toolbar) {
        m3340j().mo544a(toolbar);
    }

    public boolean m3332a(Intent intent) {
        return C0290z.m1676a((Activity) this, intent);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m3340j().mo552b(view, layoutParams);
    }

    public void m3333b(Intent intent) {
        C0290z.m1679b((Activity) this, intent);
    }

    public void m3334b(at atVar) {
    }

    public void mo513b(C0679b c0679b) {
    }

    public void mo517d() {
        m3340j().mo558e();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (C0513g.m2810a(keyEvent, 4096) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0614a g = m3337g();
                if (g != null && g.mo586b() && g.mo594g()) {
                    this.f1523o = true;
                    return true;
                }
            } else if (action == 1 && this.f1523o) {
                this.f1523o = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public View findViewById(int i) {
        return m3340j().mo539a(i);
    }

    public C0614a m3337g() {
        return m3340j().mo532a();
    }

    public MenuInflater getMenuInflater() {
        return m3340j().mo534b();
    }

    public Resources getResources() {
        if (this.f1524p == null && bj.m5278a()) {
            this.f1524p = new bj(this, super.getResources());
        }
        return this.f1524p == null ? super.getResources() : this.f1524p;
    }

    public boolean m3338h() {
        Intent a = mo516a();
        if (a == null) {
            return false;
        }
        if (m3332a(a)) {
            at a2 = at.m1317a((Context) this);
            m3329a(a2);
            m3334b(a2);
            a2.m1321a();
            try {
                C0196a.m1228a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m3333b(a);
        }
        return true;
    }

    @Deprecated
    public void m3339i() {
    }

    public void invalidateOptionsMenu() {
        m3340j().mo558e();
    }

    public C0634f m3340j() {
        if (this.f1521m == null) {
            this.f1521m = C0634f.m3341a((Activity) this, (C0630e) this);
        }
        return this.f1521m;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m3340j().mo541a(configuration);
        if (this.f1524p != null) {
            this.f1524p.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        m3339i();
    }

    protected void onCreate(Bundle bundle) {
        C0634f j = m3340j();
        j.mo559g();
        j.mo542a(bundle);
        if (j.mo537h() && this.f1522n != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1522n, false);
            } else {
                setTheme(this.f1522n);
            }
        }
        super.onCreate(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        m3340j().mo536f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0614a g = m3337g();
        return (menuItem.getItemId() != 16908332 || g == null || (g.mo578a() & 4) == 0) ? false : m3338h();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m3340j().mo551b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        m3340j().mo557d();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m3340j().mo535c(bundle);
    }

    protected void onStop() {
        super.onStop();
        m3340j().mo555c();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m3340j().mo533a(charSequence);
    }

    public void setContentView(int i) {
        m3340j().mo550b(i);
    }

    public void setContentView(View view) {
        m3340j().mo545a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m3340j().mo546a(view, layoutParams);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f1522n = i;
    }
}
