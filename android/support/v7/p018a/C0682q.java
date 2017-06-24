package android.support.v7.p018a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v4.view.aw;
import android.support.v4.view.ba;
import android.support.v4.view.bb;
import android.support.v4.view.bc;
import android.support.v7.p018a.C0614a.C0612b;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.view.C0704a;
import android.support.v7.view.C0712g;
import android.support.v7.view.C0714h;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0681a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aj;
import android.support.v7.widget.az;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class C0682q extends C0614a implements C0681a {
    static final /* synthetic */ boolean f1663h = (!C0682q.class.desiredAssertionStatus());
    private static final Interpolator f1664i = new AccelerateInterpolator();
    private static final Interpolator f1665j = new DecelerateInterpolator();
    private static final boolean f1666k;
    private boolean f1667A;
    private int f1668B = 0;
    private boolean f1669C = true;
    private boolean f1670D;
    private boolean f1671E;
    private boolean f1672F;
    private boolean f1673G = true;
    private C0714h f1674H;
    private boolean f1675I;
    C0680a f1676a;
    C0679b f1677b;
    C0657a f1678c;
    boolean f1679d;
    final ba f1680e = new C06761(this);
    final ba f1681f = new C06772(this);
    final bc f1682g = new C06783(this);
    private Context f1683l;
    private Context f1684m;
    private Activity f1685n;
    private Dialog f1686o;
    private ActionBarOverlayLayout f1687p;
    private ActionBarContainer f1688q;
    private aj f1689r;
    private ActionBarContextView f1690s;
    private View f1691t;
    private az f1692u;
    private ArrayList<Object> f1693v = new ArrayList();
    private int f1694w = -1;
    private boolean f1695x;
    private boolean f1696y;
    private ArrayList<C0612b> f1697z = new ArrayList();

    class C06761 extends bb {
        final /* synthetic */ C0682q f1653a;

        C06761(C0682q c0682q) {
            this.f1653a = c0682q;
        }

        public void mo99b(View view) {
            if (this.f1653a.f1669C && this.f1653a.f1691t != null) {
                ag.m2524b(this.f1653a.f1691t, 0.0f);
                ag.m2524b(this.f1653a.f1688q, 0.0f);
            }
            this.f1653a.f1688q.setVisibility(8);
            this.f1653a.f1688q.setTransitioning(false);
            this.f1653a.f1674H = null;
            this.f1653a.m3635i();
            if (this.f1653a.f1687p != null) {
                ag.m2551s(this.f1653a.f1687p);
            }
        }
    }

    class C06772 extends bb {
        final /* synthetic */ C0682q f1654a;

        C06772(C0682q c0682q) {
            this.f1654a = c0682q;
        }

        public void mo99b(View view) {
            this.f1654a.f1674H = null;
            this.f1654a.f1688q.requestLayout();
        }
    }

    class C06783 implements bc {
        final /* synthetic */ C0682q f1655a;

        C06783(C0682q c0682q) {
            this.f1655a = c0682q;
        }

        public void mo596a(View view) {
            ((View) this.f1655a.f1688q.getParent()).invalidate();
        }
    }

    public class C0680a extends C0679b implements C0638a {
        final /* synthetic */ C0682q f1658a;
        private final Context f1659b;
        private final C0727f f1660c;
        private C0657a f1661d;
        private WeakReference<View> f1662e;

        public C0680a(C0682q c0682q, Context context, C0657a c0657a) {
            this.f1658a = c0682q;
            this.f1659b = context;
            this.f1661d = c0657a;
            this.f1660c = new C0727f(context).m3806a(1);
            this.f1660c.mo658a((C0638a) this);
        }

        public MenuInflater mo597a() {
            return new C0712g(this.f1659b);
        }

        public void mo598a(int i) {
            mo604b(this.f1658a.f1683l.getResources().getString(i));
        }

        public void mo543a(C0727f c0727f) {
            if (this.f1661d != null) {
                mo606d();
                this.f1658a.f1690s.mo667a();
            }
        }

        public void mo599a(View view) {
            this.f1658a.f1690s.setCustomView(view);
            this.f1662e = new WeakReference(view);
        }

        public void mo600a(CharSequence charSequence) {
            this.f1658a.f1690s.setSubtitle(charSequence);
        }

        public void mo601a(boolean z) {
            super.mo601a(z);
            this.f1658a.f1690s.setTitleOptional(z);
        }

        public boolean mo548a(C0727f c0727f, MenuItem menuItem) {
            return this.f1661d != null ? this.f1661d.mo574a((C0679b) this, menuItem) : false;
        }

        public Menu mo602b() {
            return this.f1660c;
        }

        public void mo603b(int i) {
            mo600a(this.f1658a.f1683l.getResources().getString(i));
        }

        public void mo604b(CharSequence charSequence) {
            this.f1658a.f1690s.setTitle(charSequence);
        }

        public void mo605c() {
            if (this.f1658a.f1676a == this) {
                if (C0682q.m3602b(this.f1658a.f1670D, this.f1658a.f1671E, false)) {
                    this.f1661d.mo572a(this);
                } else {
                    this.f1658a.f1677b = this;
                    this.f1658a.f1678c = this.f1661d;
                }
                this.f1661d = null;
                this.f1658a.m3640k(false);
                this.f1658a.f1690s.m3948b();
                this.f1658a.f1689r.mo826a().sendAccessibilityEvent(32);
                this.f1658a.f1687p.setHideOnContentScrollEnabled(this.f1658a.f1679d);
                this.f1658a.f1676a = null;
            }
        }

        public void mo606d() {
            if (this.f1658a.f1676a == this) {
                this.f1660c.m3838g();
                try {
                    this.f1661d.mo575b(this, this.f1660c);
                } finally {
                    this.f1660c.m3839h();
                }
            }
        }

        public boolean m3585e() {
            this.f1660c.m3838g();
            try {
                boolean a = this.f1661d.mo573a((C0679b) this, this.f1660c);
                return a;
            } finally {
                this.f1660c.m3839h();
            }
        }

        public CharSequence mo607f() {
            return this.f1658a.f1690s.getTitle();
        }

        public CharSequence mo608g() {
            return this.f1658a.f1690s.getSubtitle();
        }

        public boolean mo609h() {
            return this.f1658a.f1690s.m3950d();
        }

        public View mo610i() {
            return this.f1662e != null ? (View) this.f1662e.get() : null;
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1666k = z;
    }

    public C0682q(Activity activity, boolean z) {
        this.f1685n = activity;
        View decorView = activity.getWindow().getDecorView();
        m3597a(decorView);
        if (!z) {
            this.f1691t = decorView.findViewById(16908290);
        }
    }

    public C0682q(Dialog dialog) {
        this.f1686o = dialog;
        m3597a(dialog.getWindow().getDecorView());
    }

    private void m3597a(View view) {
        this.f1687p = (ActionBarOverlayLayout) view.findViewById(C0688f.decor_content_parent);
        if (this.f1687p != null) {
            this.f1687p.setActionBarVisibilityCallback(this);
        }
        this.f1689r = m3600b(view.findViewById(C0688f.action_bar));
        this.f1690s = (ActionBarContextView) view.findViewById(C0688f.action_context_bar);
        this.f1688q = (ActionBarContainer) view.findViewById(C0688f.action_bar_container);
        if (this.f1689r == null || this.f1690s == null || this.f1688q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1683l = this.f1689r.mo835b();
        boolean z = (this.f1689r.mo852o() & 4) != 0;
        if (z) {
            this.f1695x = true;
        }
        C0704a a = C0704a.m3646a(this.f1683l);
        z = a.m3652f() || z;
        mo588c(z);
        m3610l(a.m3650d());
        TypedArray obtainStyledAttributes = this.f1683l.obtainStyledAttributes(null, C0693k.ActionBar, C0683a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0693k.ActionBar_hideOnContentScroll, false)) {
            mo614d(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0693k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo579a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private aj m3600b(View view) {
        if (view instanceof aj) {
            return (aj) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean m3602b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void m3610l(boolean z) {
        boolean z2 = true;
        this.f1667A = z;
        if (this.f1667A) {
            this.f1688q.setTabContainer(null);
            this.f1689r.mo830a(this.f1692u);
        } else {
            this.f1689r.mo830a(null);
            this.f1688q.setTabContainer(this.f1692u);
        }
        boolean z3 = m3637j() == 2;
        if (this.f1692u != null) {
            if (z3) {
                this.f1692u.setVisibility(0);
                if (this.f1687p != null) {
                    ag.m2551s(this.f1687p);
                }
            } else {
                this.f1692u.setVisibility(8);
            }
        }
        aj ajVar = this.f1689r;
        boolean z4 = !this.f1667A && z3;
        ajVar.mo834a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1687p;
        if (this.f1667A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m3611m(boolean z) {
        if (C0682q.m3602b(this.f1670D, this.f1671E, this.f1672F)) {
            if (!this.f1673G) {
                this.f1673G = true;
                m3636i(z);
            }
        } else if (this.f1673G) {
            this.f1673G = false;
            m3638j(z);
        }
    }

    private void m3612p() {
        if (!this.f1672F) {
            this.f1672F = true;
            if (this.f1687p != null) {
                this.f1687p.setShowingForActionMode(true);
            }
            m3611m(false);
        }
    }

    private void m3613q() {
        if (this.f1672F) {
            this.f1672F = false;
            if (this.f1687p != null) {
                this.f1687p.setShowingForActionMode(false);
            }
            m3611m(false);
        }
    }

    public int mo578a() {
        return this.f1689r.mo852o();
    }

    public C0679b mo611a(C0657a c0657a) {
        if (this.f1676a != null) {
            this.f1676a.mo605c();
        }
        this.f1687p.setHideOnContentScrollEnabled(false);
        this.f1690s.m3949c();
        C0679b c0680a = new C0680a(this, this.f1690s.getContext(), c0657a);
        if (!c0680a.m3585e()) {
            return null;
        }
        c0680a.mo606d();
        this.f1690s.m3946a(c0680a);
        m3640k(true);
        this.f1690s.sendAccessibilityEvent(32);
        this.f1676a = c0680a;
        return c0680a;
    }

    public void mo579a(float f) {
        ag.m2533d(this.f1688q, f);
    }

    public void mo612a(int i) {
        this.f1668B = i;
    }

    public void m3618a(int i, int i2) {
        int o = this.f1689r.mo852o();
        if ((i2 & 4) != 0) {
            this.f1695x = true;
        }
        this.f1689r.mo839c((o & (i2 ^ -1)) | (i & i2));
    }

    public void mo580a(Configuration configuration) {
        m3610l(C0704a.m3646a(this.f1683l).m3650d());
    }

    public void mo581a(CharSequence charSequence) {
        this.f1689r.mo837b(charSequence);
    }

    public void mo582a(boolean z) {
        m3618a(z ? 4 : 0, 4);
    }

    public void mo584b(CharSequence charSequence) {
        this.f1689r.mo833a(charSequence);
    }

    public void mo585b(boolean z) {
        m3618a(z ? 8 : 0, 8);
    }

    public boolean mo586b() {
        int k = m3639k();
        return this.f1673G && (k == 0 || mo613d() < k);
    }

    public Context mo587c() {
        if (this.f1684m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1683l.getTheme().resolveAttribute(C0683a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1684m = new ContextThemeWrapper(this.f1683l, i);
            } else {
                this.f1684m = this.f1683l;
            }
        }
        return this.f1684m;
    }

    public void mo588c(boolean z) {
        this.f1689r.mo838b(z);
    }

    public int mo613d() {
        return this.f1687p.getActionBarHideOffset();
    }

    public void mo614d(boolean z) {
        if (!z || this.f1687p.m3979a()) {
            this.f1679d = z;
            this.f1687p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void mo589e(boolean z) {
        if (!this.f1695x) {
            mo582a(z);
        }
    }

    public void mo591f(boolean z) {
        this.f1675I = z;
        if (!z && this.f1674H != null) {
            this.f1674H.m3713b();
        }
    }

    public boolean mo592f() {
        if (this.f1689r == null || !this.f1689r.mo840c()) {
            return false;
        }
        this.f1689r.mo841d();
        return true;
    }

    public void mo593g(boolean z) {
        if (z != this.f1696y) {
            this.f1696y = z;
            int size = this.f1697z.size();
            for (int i = 0; i < size; i++) {
                ((C0612b) this.f1697z.get(i)).m3231a(z);
            }
        }
    }

    public boolean mo594g() {
        ViewGroup a = this.f1689r.mo826a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void mo615h(boolean z) {
        this.f1669C = z;
    }

    void m3635i() {
        if (this.f1678c != null) {
            this.f1678c.mo572a(this.f1677b);
            this.f1677b = null;
            this.f1678c = null;
        }
    }

    public void m3636i(boolean z) {
        if (this.f1674H != null) {
            this.f1674H.m3713b();
        }
        this.f1688q.setVisibility(0);
        if (this.f1668B == 0 && f1666k && (this.f1675I || z)) {
            ag.m2524b(this.f1688q, 0.0f);
            float f = (float) (-this.f1688q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1688q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ag.m2524b(this.f1688q, f);
            C0714h c0714h = new C0714h();
            aw c = ag.m2549q(this.f1688q).m2735c(0.0f);
            c.m2730a(this.f1682g);
            c0714h.m3708a(c);
            if (this.f1669C && this.f1691t != null) {
                ag.m2524b(this.f1691t, f);
                c0714h.m3708a(ag.m2549q(this.f1691t).m2735c(0.0f));
            }
            c0714h.m3711a(f1665j);
            c0714h.m3707a(250);
            c0714h.m3710a(this.f1681f);
            this.f1674H = c0714h;
            c0714h.m3712a();
        } else {
            ag.m2528c(this.f1688q, 1.0f);
            ag.m2524b(this.f1688q, 0.0f);
            if (this.f1669C && this.f1691t != null) {
                ag.m2524b(this.f1691t, 0.0f);
            }
            this.f1681f.mo99b(null);
        }
        if (this.f1687p != null) {
            ag.m2551s(this.f1687p);
        }
    }

    public int m3637j() {
        return this.f1689r.mo853p();
    }

    public void m3638j(boolean z) {
        if (this.f1674H != null) {
            this.f1674H.m3713b();
        }
        if (this.f1668B == 0 && f1666k && (this.f1675I || z)) {
            ag.m2528c(this.f1688q, 1.0f);
            this.f1688q.setTransitioning(true);
            C0714h c0714h = new C0714h();
            float f = (float) (-this.f1688q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1688q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            aw c = ag.m2549q(this.f1688q).m2735c(f);
            c.m2730a(this.f1682g);
            c0714h.m3708a(c);
            if (this.f1669C && this.f1691t != null) {
                c0714h.m3708a(ag.m2549q(this.f1691t).m2735c(f));
            }
            c0714h.m3711a(f1664i);
            c0714h.m3707a(250);
            c0714h.m3710a(this.f1680e);
            this.f1674H = c0714h;
            c0714h.m3712a();
            return;
        }
        this.f1680e.mo99b(null);
    }

    public int m3639k() {
        return this.f1688q.getHeight();
    }

    public void m3640k(boolean z) {
        aw a;
        aw a2;
        if (z) {
            m3612p();
        } else {
            m3613q();
        }
        if (z) {
            a = this.f1689r.mo825a(4, 100);
            a2 = this.f1690s.mo666a(0, 200);
        } else {
            a2 = this.f1689r.mo825a(0, 200);
            a = this.f1690s.mo666a(8, 100);
        }
        C0714h c0714h = new C0714h();
        c0714h.m3709a(a, a2);
        c0714h.m3712a();
    }

    public void mo616l() {
        if (this.f1671E) {
            this.f1671E = false;
            m3611m(true);
        }
    }

    public void mo617m() {
        if (!this.f1671E) {
            this.f1671E = true;
            m3611m(true);
        }
    }

    public void mo618n() {
        if (this.f1674H != null) {
            this.f1674H.m3713b();
            this.f1674H = null;
        }
    }

    public void mo619o() {
    }
}
