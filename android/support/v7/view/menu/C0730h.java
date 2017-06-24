package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.view.C0503d;
import android.support.v4.view.C0503d.C0502b;
import android.support.v4.view.C0535p.C0534e;
import android.support.v7.view.menu.C0052m.C0050a;
import android.support.v7.widget.C0893m;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class C0730h implements C0336b {
    private static String f1871w;
    private static String f1872x;
    private static String f1873y;
    private static String f1874z;
    private final int f1875a;
    private final int f1876b;
    private final int f1877c;
    private final int f1878d;
    private CharSequence f1879e;
    private CharSequence f1880f;
    private Intent f1881g;
    private char f1882h;
    private char f1883i;
    private Drawable f1884j;
    private int f1885k = 0;
    private C0727f f1886l;
    private C0742p f1887m;
    private Runnable f1888n;
    private OnMenuItemClickListener f1889o;
    private int f1890p = 16;
    private int f1891q = 0;
    private View f1892r;
    private C0503d f1893s;
    private C0534e f1894t;
    private boolean f1895u = false;
    private ContextMenuInfo f1896v;

    class C07291 implements C0502b {
        final /* synthetic */ C0730h f1870a;

        C07291(C0730h c0730h) {
            this.f1870a = c0730h;
        }

        public void mo643a(boolean z) {
            this.f1870a.f1886l.m3815a(this.f1870a);
        }
    }

    C0730h(C0727f c0727f, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1886l = c0727f;
        this.f1875a = i2;
        this.f1876b = i;
        this.f1877c = i3;
        this.f1878d = i4;
        this.f1879e = charSequence;
        this.f1891q = i5;
    }

    public C0336b m3856a(int i) {
        Context e = this.f1886l.m3836e();
        m3859a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public C0336b mo625a(C0503d c0503d) {
        if (this.f1893s != null) {
            this.f1893s.m2789f();
        }
        this.f1892r = null;
        this.f1893s = c0503d;
        this.f1886l.m3828b(true);
        if (this.f1893s != null) {
            this.f1893s.mo653a(new C07291(this));
        }
        return this;
    }

    public C0336b mo626a(C0534e c0534e) {
        this.f1894t = c0534e;
        return this;
    }

    public C0336b m3859a(View view) {
        this.f1892r = view;
        this.f1893s = null;
        if (view != null && view.getId() == -1 && this.f1875a > 0) {
            view.setId(this.f1875a);
        }
        this.f1886l.m3826b(this);
        return this;
    }

    public C0503d mo627a() {
        return this.f1893s;
    }

    CharSequence m3861a(C0050a c0050a) {
        return (c0050a == null || !c0050a.mo28a()) ? getTitle() : getTitleCondensed();
    }

    public void m3862a(C0742p c0742p) {
        this.f1887m = c0742p;
        c0742p.setHeaderTitle(getTitle());
    }

    void m3863a(ContextMenuInfo contextMenuInfo) {
        this.f1896v = contextMenuInfo;
    }

    public void m3864a(boolean z) {
        this.f1890p = (z ? 4 : 0) | (this.f1890p & -5);
    }

    public C0336b m3865b(int i) {
        setShowAsAction(i);
        return this;
    }

    void m3866b(boolean z) {
        int i = this.f1890p;
        this.f1890p = (z ? 2 : 0) | (this.f1890p & -3);
        if (i != this.f1890p) {
            this.f1886l.m3828b(false);
        }
    }

    public boolean m3867b() {
        if ((this.f1889o != null && this.f1889o.onMenuItemClick(this)) || this.f1886l.mo659a(this.f1886l.mo664p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1888n != null) {
            this.f1888n.run();
            return true;
        }
        if (this.f1881g != null) {
            try {
                this.f1886l.m3836e().startActivity(this.f1881g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1893s != null && this.f1893s.mo646d();
    }

    public int m3868c() {
        return this.f1878d;
    }

    boolean m3869c(boolean z) {
        int i = this.f1890p;
        this.f1890p = (z ? 0 : 8) | (this.f1890p & -9);
        return i != this.f1890p;
    }

    public boolean collapseActionView() {
        return (this.f1891q & 8) == 0 ? false : this.f1892r == null ? true : (this.f1894t == null || this.f1894t.mo651b(this)) ? this.f1886l.mo663d(this) : false;
    }

    char m3870d() {
        return this.f1886l.mo660b() ? this.f1883i : this.f1882h;
    }

    public void m3871d(boolean z) {
        if (z) {
            this.f1890p |= 32;
        } else {
            this.f1890p &= -33;
        }
    }

    String m3872e() {
        char d = m3870d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1871w);
        switch (d) {
            case '\b':
                stringBuilder.append(f1873y);
                break;
            case '\n':
                stringBuilder.append(f1872x);
                break;
            case ' ':
                stringBuilder.append(f1874z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void m3873e(boolean z) {
        this.f1895u = z;
        this.f1886l.m3828b(false);
    }

    public boolean expandActionView() {
        return !m3882n() ? false : (this.f1894t == null || this.f1894t.mo650a(this)) ? this.f1886l.mo662c(this) : false;
    }

    boolean m3874f() {
        return this.f1886l.mo661c() && m3870d() != '\u0000';
    }

    public boolean m3875g() {
        return (this.f1890p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f1892r != null) {
            return this.f1892r;
        }
        if (this.f1893s == null) {
            return null;
        }
        this.f1892r = this.f1893s.mo652a((MenuItem) this);
        return this.f1892r;
    }

    public char getAlphabeticShortcut() {
        return this.f1883i;
    }

    public int getGroupId() {
        return this.f1876b;
    }

    public Drawable getIcon() {
        if (this.f1884j != null) {
            return this.f1884j;
        }
        if (this.f1885k == 0) {
            return null;
        }
        Drawable a = C0893m.m5425a().m5448a(this.f1886l.m3836e(), this.f1885k);
        this.f1885k = 0;
        this.f1884j = a;
        return a;
    }

    public Intent getIntent() {
        return this.f1881g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1875a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1896v;
    }

    public char getNumericShortcut() {
        return this.f1882h;
    }

    public int getOrder() {
        return this.f1877c;
    }

    public SubMenu getSubMenu() {
        return this.f1887m;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1879e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1880f != null ? this.f1880f : this.f1879e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public void m3876h() {
        this.f1886l.m3826b(this);
    }

    public boolean hasSubMenu() {
        return this.f1887m != null;
    }

    public boolean m3877i() {
        return this.f1886l.m3848q();
    }

    public boolean isActionViewExpanded() {
        return this.f1895u;
    }

    public boolean isCheckable() {
        return (this.f1890p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f1890p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f1890p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1893s == null || !this.f1893s.mo654b()) ? (this.f1890p & 8) == 0 : (this.f1890p & 8) == 0 && this.f1893s.mo655c();
    }

    public boolean m3878j() {
        return (this.f1890p & 32) == 32;
    }

    public boolean m3879k() {
        return (this.f1891q & 1) == 1;
    }

    public boolean m3880l() {
        return (this.f1891q & 2) == 2;
    }

    public boolean m3881m() {
        return (this.f1891q & 4) == 4;
    }

    public boolean m3882n() {
        if ((this.f1891q & 8) == 0) {
            return false;
        }
        if (this.f1892r == null && this.f1893s != null) {
            this.f1892r = this.f1893s.mo652a((MenuItem) this);
        }
        return this.f1892r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3856a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3859a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1883i != c) {
            this.f1883i = Character.toLowerCase(c);
            this.f1886l.m3828b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1890p;
        this.f1890p = (z ? 1 : 0) | (this.f1890p & -2);
        if (i != this.f1890p) {
            this.f1886l.m3828b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1890p & 4) != 0) {
            this.f1886l.m3818a((MenuItem) this);
        } else {
            m3866b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1890p |= 16;
        } else {
            this.f1890p &= -17;
        }
        this.f1886l.m3828b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1884j = null;
        this.f1885k = i;
        this.f1886l.m3828b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1885k = 0;
        this.f1884j = drawable;
        this.f1886l.m3828b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1881g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1882h != c) {
            this.f1882h = c;
            this.f1886l.m3828b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1889o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1882h = c;
        this.f1883i = Character.toLowerCase(c2);
        this.f1886l.m3828b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1891q = i;
                this.f1886l.m3826b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3865b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1886l.m3836e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1879e = charSequence;
        this.f1886l.m3828b(false);
        if (this.f1887m != null) {
            this.f1887m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1880f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1879e;
        }
        this.f1886l.m3828b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (m3869c(z)) {
            this.f1886l.m3815a(this);
        }
        return this;
    }

    public String toString() {
        return this.f1879e != null ? this.f1879e.toString() : null;
    }
}
