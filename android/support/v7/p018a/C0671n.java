package android.support.v7.p018a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.support.v4.view.ag;
import android.support.v7.p018a.C0614a.C0612b;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p019b.C0694a.C0692j;
import android.support.v7.view.C0635i;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.view.menu.C0726e;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0665c;
import android.support.v7.widget.aj;
import android.support.v7.widget.bi;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

class C0671n extends C0614a {
    private aj f1631a;
    private boolean f1632b;
    private Callback f1633c;
    private boolean f1634d;
    private boolean f1635e;
    private ArrayList<C0612b> f1636f = new ArrayList();
    private C0726e f1637g;
    private final Runnable f1638h = new C06641(this);
    private final C0665c f1639i = new C06662(this);

    class C06641 implements Runnable {
        final /* synthetic */ C0671n f1624a;

        C06641(C0671n c0671n) {
            this.f1624a = c0671n;
        }

        public void run() {
            this.f1624a.m3545j();
        }
    }

    class C06662 implements C0665c {
        final /* synthetic */ C0671n f1625a;

        C06662(C0671n c0671n) {
            this.f1625a = c0671n;
        }

        public boolean mo576a(MenuItem menuItem) {
            return this.f1625a.f1633c.onMenuItemSelected(0, menuItem);
        }
    }

    private final class C0667a implements C0654a {
        final /* synthetic */ C0671n f1626a;
        private boolean f1627b;

        private C0667a(C0671n c0671n) {
            this.f1626a = c0671n;
        }

        public void mo570a(C0727f c0727f, boolean z) {
            if (!this.f1627b) {
                this.f1627b = true;
                this.f1626a.f1631a.mo851n();
                if (this.f1626a.f1633c != null) {
                    this.f1626a.f1633c.onPanelClosed(108, c0727f);
                }
                this.f1627b = false;
            }
        }

        public boolean mo571a(C0727f c0727f) {
            if (this.f1626a.f1633c == null) {
                return false;
            }
            this.f1626a.f1633c.onMenuOpened(108, c0727f);
            return true;
        }
    }

    private final class C0668b implements C0638a {
        final /* synthetic */ C0671n f1628a;

        private C0668b(C0671n c0671n) {
            this.f1628a = c0671n;
        }

        public void mo543a(C0727f c0727f) {
            if (this.f1628a.f1633c == null) {
                return;
            }
            if (this.f1628a.f1631a.mo846i()) {
                this.f1628a.f1633c.onPanelClosed(108, c0727f);
            } else if (this.f1628a.f1633c.onPreparePanel(0, null, c0727f)) {
                this.f1628a.f1633c.onMenuOpened(108, c0727f);
            }
        }

        public boolean mo548a(C0727f c0727f, MenuItem menuItem) {
            return false;
        }
    }

    private final class C0669c implements C0654a {
        final /* synthetic */ C0671n f1629a;

        private C0669c(C0671n c0671n) {
            this.f1629a = c0671n;
        }

        public void mo570a(C0727f c0727f, boolean z) {
            if (this.f1629a.f1633c != null) {
                this.f1629a.f1633c.onPanelClosed(0, c0727f);
            }
        }

        public boolean mo571a(C0727f c0727f) {
            if (c0727f == null && this.f1629a.f1633c != null) {
                this.f1629a.f1633c.onMenuOpened(0, c0727f);
            }
            return true;
        }
    }

    private class C0670d extends C0635i {
        final /* synthetic */ C0671n f1630a;

        public C0670d(C0671n c0671n, Callback callback) {
            this.f1630a = c0671n;
            super(callback);
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu r = this.f1630a.f1631a.mo855r();
                    if (onPreparePanel(i, null, r) && onMenuOpened(i, r)) {
                        return this.f1630a.m3518a(r);
                    }
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.f1630a.f1632b) {
                this.f1630a.f1631a.mo850m();
                this.f1630a.f1632b = true;
            }
            return onPreparePanel;
        }
    }

    public C0671n(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f1631a = new bi(toolbar, false);
        this.f1633c = new C0670d(this, callback);
        this.f1631a.mo832a(this.f1633c);
        toolbar.setOnMenuItemClickListener(this.f1639i);
        this.f1631a.mo833a(charSequence);
    }

    private View m3518a(Menu menu) {
        m3521b(menu);
        return (menu == null || this.f1637g == null || this.f1637g.m3788a().getCount() <= 0) ? null : (View) this.f1637g.m3787a(this.f1631a.mo826a());
    }

    private void m3521b(Menu menu) {
        if (this.f1637g == null && (menu instanceof C0727f)) {
            C0727f c0727f = (C0727f) menu;
            Context b = this.f1631a.mo835b();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = b.getResources().newTheme();
            newTheme.setTo(b.getTheme());
            newTheme.resolveAttribute(C0683a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0683a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0692j.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(b, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1637g = new C0726e(contextThemeWrapper, C0690h.abc_list_menu_item_layout);
            this.f1637g.m3791a(new C0669c());
            c0727f.m3816a(this.f1637g);
        }
    }

    private Menu m3524k() {
        if (!this.f1634d) {
            this.f1631a.mo829a(new C0667a(), new C0668b());
            this.f1634d = true;
        }
        return this.f1631a.mo855r();
    }

    public int mo578a() {
        return this.f1631a.mo852o();
    }

    public void mo579a(float f) {
        ag.m2533d(this.f1631a.mo826a(), f);
    }

    public void m3527a(int i, int i2) {
        this.f1631a.mo839c((this.f1631a.mo852o() & (i2 ^ -1)) | (i & i2));
    }

    public void mo580a(Configuration configuration) {
        super.mo580a(configuration);
    }

    public void mo581a(CharSequence charSequence) {
        this.f1631a.mo837b(charSequence);
    }

    public void mo582a(boolean z) {
        m3527a(z ? 4 : 0, 4);
    }

    public boolean mo583a(int i, KeyEvent keyEvent) {
        Menu k = m3524k();
        if (k != null) {
            k.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            k.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public void mo584b(CharSequence charSequence) {
        this.f1631a.mo833a(charSequence);
    }

    public void mo585b(boolean z) {
        m3527a(z ? 8 : 0, 8);
    }

    public boolean mo586b() {
        return this.f1631a.mo854q() == 0;
    }

    public Context mo587c() {
        return this.f1631a.mo835b();
    }

    public void mo588c(boolean z) {
    }

    public void mo589e(boolean z) {
    }

    public boolean mo590e() {
        this.f1631a.mo826a().removeCallbacks(this.f1638h);
        ag.m2519a(this.f1631a.mo826a(), this.f1638h);
        return true;
    }

    public void mo591f(boolean z) {
    }

    public boolean mo592f() {
        if (!this.f1631a.mo840c()) {
            return false;
        }
        this.f1631a.mo841d();
        return true;
    }

    public void mo593g(boolean z) {
        if (z != this.f1635e) {
            this.f1635e = z;
            int size = this.f1636f.size();
            for (int i = 0; i < size; i++) {
                ((C0612b) this.f1636f.get(i)).m3231a(z);
            }
        }
    }

    public boolean mo594g() {
        ViewGroup a = this.f1631a.mo826a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    void mo595h() {
        this.f1631a.mo826a().removeCallbacks(this.f1638h);
    }

    public Callback m3544i() {
        return this.f1633c;
    }

    void m3545j() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0030 in list [B:12:0x002d]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.m3524k();
        r2 = r1 instanceof android.support.v7.view.menu.C0727f;
        if (r2 == 0) goto L_0x0031;
    L_0x0009:
        r0 = r1;
        r0 = (android.support.v7.view.menu.C0727f) r0;
        r2 = r0;
    L_0x000d:
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r2.m3838g();
    L_0x0012:
        r1.clear();	 Catch:{ all -> 0x0033 }
        r0 = r5.f1633c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onCreatePanelMenu(r3, r1);	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x0033 }
    L_0x001e:
        r0 = r5.f1633c;	 Catch:{ all -> 0x0033 }
        r3 = 0;	 Catch:{ all -> 0x0033 }
        r4 = 0;	 Catch:{ all -> 0x0033 }
        r0 = r0.onPreparePanel(r3, r4, r1);	 Catch:{ all -> 0x0033 }
        if (r0 != 0) goto L_0x002b;	 Catch:{ all -> 0x0033 }
    L_0x0028:
        r1.clear();	 Catch:{ all -> 0x0033 }
    L_0x002b:
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.m3839h();
    L_0x0030:
        return;
    L_0x0031:
        r2 = r0;
        goto L_0x000d;
    L_0x0033:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0039;
    L_0x0036:
        r2.m3839h();
    L_0x0039:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.n.j():void");
    }
}
