package android.support.v7.p018a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0290z;
import android.support.v4.view.C0271m;
import android.support.v4.view.C0519i;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.ar;
import android.support.v4.view.aw;
import android.support.v4.view.bb;
import android.support.v4.view.bd;
import android.support.v4.widget.C0589o;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0685c;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p019b.C0694a.C0692j;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.C0679b;
import android.support.v7.view.C0679b.C0657a;
import android.support.v7.view.C0706d;
import android.support.v7.view.C0707e;
import android.support.v7.view.menu.C0052m;
import android.support.v7.view.menu.C0721l.C0654a;
import android.support.v7.view.menu.C0726e;
import android.support.v7.view.menu.C0727f;
import android.support.v7.view.menu.C0727f.C0638a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0893m;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0649a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ai;
import android.support.v7.widget.am;
import android.support.v7.widget.am.C0647a;
import android.support.v7.widget.bj;
import android.support.v7.widget.bl;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class C0639k extends C0637g implements C0271m, C0638a {
    private boolean f1543A;
    private C0660d[] f1544B;
    private C0660d f1545C;
    private boolean f1546D;
    private boolean f1547E;
    private int f1548F;
    private final Runnable f1549G = new C06451(this);
    private boolean f1550H;
    private Rect f1551I;
    private Rect f1552J;
    private C0663m f1553K;
    C0679b f1554m;
    ActionBarContextView f1555n;
    PopupWindow f1556o;
    Runnable f1557p;
    aw f1558q = null;
    private ai f1559r;
    private C0655a f1560s;
    private C0661e f1561t;
    private boolean f1562u;
    private ViewGroup f1563v;
    private TextView f1564w;
    private View f1565x;
    private boolean f1566y;
    private boolean f1567z;

    class C06451 implements Runnable {
        final /* synthetic */ C0639k f1575a;

        C06451(C0639k c0639k) {
            this.f1575a = c0639k;
        }

        public void run() {
            if ((this.f1575a.f1548F & 1) != 0) {
                this.f1575a.m3417f(0);
            }
            if ((this.f1575a.f1548F & 4096) != 0) {
                this.f1575a.m3417f(108);
            }
            this.f1575a.f1547E = false;
            this.f1575a.f1548F = 0;
        }
    }

    class C06462 implements aa {
        final /* synthetic */ C0639k f1576a;

        C06462(C0639k c0639k) {
            this.f1576a = c0639k;
        }

        public bd mo38a(View view, bd bdVar) {
            int b = bdVar.mo443b();
            int c = this.f1576a.m3418g(b);
            if (b != c) {
                bdVar = bdVar.mo442a(bdVar.mo441a(), c, bdVar.mo444c(), bdVar.mo445d());
            }
            return ag.m2510a(view, bdVar);
        }
    }

    class C06483 implements C0647a {
        final /* synthetic */ C0639k f1577a;

        C06483(C0639k c0639k) {
            this.f1577a = c0639k;
        }

        public void mo567a(Rect rect) {
            rect.top = this.f1577a.m3418g(rect.top);
        }
    }

    class C06504 implements C0649a {
        final /* synthetic */ C0639k f1578a;

        C06504(C0639k c0639k) {
            this.f1578a = c0639k;
        }

        public void mo568a() {
        }

        public void mo569b() {
            this.f1578a.m3425x();
        }
    }

    class C06525 implements Runnable {
        final /* synthetic */ C0639k f1580a;

        class C06511 extends bb {
            final /* synthetic */ C06525 f1579a;

            C06511(C06525 c06525) {
                this.f1579a = c06525;
            }

            public void mo98a(View view) {
                this.f1579a.f1580a.f1555n.setVisibility(0);
            }

            public void mo99b(View view) {
                ag.m2528c(this.f1579a.f1580a.f1555n, 1.0f);
                this.f1579a.f1580a.f1558q.m2729a(null);
                this.f1579a.f1580a.f1558q = null;
            }
        }

        C06525(C0639k c0639k) {
            this.f1580a = c0639k;
        }

        public void run() {
            this.f1580a.f1556o.showAtLocation(this.f1580a.f1555n, 55, 0, 0);
            this.f1580a.m3423v();
            ag.m2528c(this.f1580a.f1555n, 0.0f);
            this.f1580a.f1558q = ag.m2549q(this.f1580a.f1555n).m2727a(1.0f);
            this.f1580a.f1558q.m2729a(new C06511(this));
        }
    }

    class C06536 extends bb {
        final /* synthetic */ C0639k f1581a;

        C06536(C0639k c0639k) {
            this.f1581a = c0639k;
        }

        public void mo98a(View view) {
            this.f1581a.f1555n.setVisibility(0);
            this.f1581a.f1555n.sendAccessibilityEvent(32);
            if (this.f1581a.f1555n.getParent() != null) {
                ag.m2551s((View) this.f1581a.f1555n.getParent());
            }
        }

        public void mo99b(View view) {
            ag.m2528c(this.f1581a.f1555n, 1.0f);
            this.f1581a.f1558q.m2729a(null);
            this.f1581a.f1558q = null;
        }
    }

    private final class C0655a implements C0654a {
        final /* synthetic */ C0639k f1582a;

        private C0655a(C0639k c0639k) {
            this.f1582a = c0639k;
        }

        public void mo570a(C0727f c0727f, boolean z) {
            this.f1582a.m3406b(c0727f);
        }

        public boolean mo571a(C0727f c0727f) {
            Callback p = this.f1582a.m3384p();
            if (p != null) {
                p.onMenuOpened(108, c0727f);
            }
            return true;
        }
    }

    class C0658b implements C0657a {
        final /* synthetic */ C0639k f1584a;
        private C0657a f1585b;

        class C06561 extends bb {
            final /* synthetic */ C0658b f1583a;

            C06561(C0658b c0658b) {
                this.f1583a = c0658b;
            }

            public void mo99b(View view) {
                this.f1583a.f1584a.f1555n.setVisibility(8);
                if (this.f1583a.f1584a.f1556o != null) {
                    this.f1583a.f1584a.f1556o.dismiss();
                } else if (this.f1583a.f1584a.f1555n.getParent() instanceof View) {
                    ag.m2551s((View) this.f1583a.f1584a.f1555n.getParent());
                }
                this.f1583a.f1584a.f1555n.removeAllViews();
                this.f1583a.f1584a.f1558q.m2729a(null);
                this.f1583a.f1584a.f1558q = null;
            }
        }

        public C0658b(C0639k c0639k, C0657a c0657a) {
            this.f1584a = c0639k;
            this.f1585b = c0657a;
        }

        public void mo572a(C0679b c0679b) {
            this.f1585b.mo572a(c0679b);
            if (this.f1584a.f1556o != null) {
                this.f1584a.b.getDecorView().removeCallbacks(this.f1584a.f1557p);
            }
            if (this.f1584a.f1555n != null) {
                this.f1584a.m3423v();
                this.f1584a.f1558q = ag.m2549q(this.f1584a.f1555n).m2727a(0.0f);
                this.f1584a.f1558q.m2729a(new C06561(this));
            }
            if (this.f1584a.e != null) {
                this.f1584a.e.mo513b(this.f1584a.f1554m);
            }
            this.f1584a.f1554m = null;
        }

        public boolean mo573a(C0679b c0679b, Menu menu) {
            return this.f1585b.mo573a(c0679b, menu);
        }

        public boolean mo574a(C0679b c0679b, MenuItem menuItem) {
            return this.f1585b.mo574a(c0679b, menuItem);
        }

        public boolean mo575b(C0679b c0679b, Menu menu) {
            return this.f1585b.mo575b(c0679b, menu);
        }
    }

    private class C0659c extends ContentFrameLayout {
        final /* synthetic */ C0639k f1594a;

        public C0659c(C0639k c0639k, Context context) {
            this.f1594a = c0639k;
            super(context);
        }

        private boolean m3496a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1594a.mo549a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m3496a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f1594a.mo564d(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0893m.m5425a().m5448a(getContext(), i));
        }
    }

    private static final class C0660d {
        int f1595a;
        int f1596b;
        int f1597c;
        int f1598d;
        int f1599e;
        int f1600f;
        ViewGroup f1601g;
        View f1602h;
        View f1603i;
        C0727f f1604j;
        C0726e f1605k;
        Context f1606l;
        boolean f1607m;
        boolean f1608n;
        boolean f1609o;
        public boolean f1610p;
        boolean f1611q = false;
        boolean f1612r;
        Bundle f1613s;

        C0660d(int i) {
            this.f1595a = i;
        }

        C0052m m3497a(C0654a c0654a) {
            if (this.f1604j == null) {
                return null;
            }
            if (this.f1605k == null) {
                this.f1605k = new C0726e(this.f1606l, C0690h.abc_list_menu_item_layout);
                this.f1605k.m3791a(c0654a);
                this.f1604j.m3816a(this.f1605k);
            }
            return this.f1605k.m3787a(this.f1601g);
        }

        void m3498a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
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
            Context c0706d = new C0706d(context, 0);
            c0706d.getTheme().setTo(newTheme);
            this.f1606l = c0706d;
            TypedArray obtainStyledAttributes = c0706d.obtainStyledAttributes(C0693k.AppCompatTheme);
            this.f1596b = obtainStyledAttributes.getResourceId(C0693k.AppCompatTheme_panelBackground, 0);
            this.f1600f = obtainStyledAttributes.getResourceId(C0693k.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m3499a(C0727f c0727f) {
            if (c0727f != this.f1604j) {
                if (this.f1604j != null) {
                    this.f1604j.m3827b(this.f1605k);
                }
                this.f1604j = c0727f;
                if (c0727f != null && this.f1605k != null) {
                    c0727f.m3816a(this.f1605k);
                }
            }
        }

        public boolean m3500a() {
            return this.f1602h == null ? false : this.f1603i != null || this.f1605k.m3788a().getCount() > 0;
        }
    }

    private final class C0661e implements C0654a {
        final /* synthetic */ C0639k f1614a;

        private C0661e(C0639k c0639k) {
            this.f1614a = c0639k;
        }

        public void mo570a(C0727f c0727f, boolean z) {
            Menu menu;
            Menu p = c0727f.mo664p();
            boolean z2 = p != c0727f;
            C0639k c0639k = this.f1614a;
            if (z2) {
                menu = p;
            }
            C0660d a = c0639k.m3391a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f1614a.m3392a(a.f1595a, a, p);
                this.f1614a.m3394a(a, true);
                return;
            }
            this.f1614a.m3394a(a, z);
        }

        public boolean mo571a(C0727f c0727f) {
            if (c0727f == null && this.f1614a.h) {
                Callback p = this.f1614a.m3384p();
                if (!(p == null || this.f1614a.m3383o())) {
                    p.onMenuOpened(108, c0727f);
                }
            }
            return true;
        }
    }

    C0639k(Context context, Window window, C0630e c0630e) {
        super(context, window, c0630e);
    }

    private C0660d m3389a(int i, boolean z) {
        Object obj = this.f1544B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C0660d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1544B = obj2;
            obj = obj2;
        }
        C0660d c0660d = obj[i];
        if (c0660d != null) {
            return c0660d;
        }
        c0660d = new C0660d(i);
        obj[i] = c0660d;
        return c0660d;
    }

    private C0660d m3391a(Menu menu) {
        C0660d[] c0660dArr = this.f1544B;
        int length = c0660dArr != null ? c0660dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0660d c0660d = c0660dArr[i];
            if (c0660d != null && c0660d.f1604j == menu) {
                return c0660d;
            }
        }
        return null;
    }

    private void m3392a(int i, C0660d c0660d, Menu menu) {
        if (menu == null) {
            if (c0660d == null && i >= 0 && i < this.f1544B.length) {
                c0660d = this.f1544B[i];
            }
            if (c0660d != null) {
                menu = c0660d.f1604j;
            }
        }
        if ((c0660d == null || c0660d.f1609o) && !m3383o()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3393a(android.support.v7.p018a.C0639k.C0660d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1609o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m3383o();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1595a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m3384p();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1595a;
        r5 = r11.f1604j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m3394a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m3408b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1601g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1611q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1601g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m3400a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1601g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m3411c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m3500a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1602h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1596b;
        r4 = r11.f1601g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1602h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1602h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1601g;
        r4 = r11.f1602h;
        r0.addView(r4, r1);
        r0 = r11.f1602h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1602h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1608n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1598d;
        r4 = r11.f1599e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1597c;
        r0.gravity = r1;
        r1 = r11.f1600f;
        r0.windowAnimations = r1;
        r1 = r11.f1601g;
        r8.addView(r1, r0);
        r11.f1609o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1611q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1601g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1601g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1603i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1603i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.k.a(android.support.v7.a.k$d, android.view.KeyEvent):void");
    }

    private void m3394a(C0660d c0660d, boolean z) {
        if (z && c0660d.f1595a == 0 && this.f1559r != null && this.f1559r.mo677e()) {
            m3406b(c0660d.f1604j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0660d.f1609o || c0660d.f1601g == null)) {
            windowManager.removeView(c0660d.f1601g);
            if (z) {
                m3392a(c0660d.f1595a, c0660d, null);
            }
        }
        c0660d.f1607m = false;
        c0660d.f1608n = false;
        c0660d.f1609o = false;
        c0660d.f1602h = null;
        c0660d.f1611q = true;
        if (this.f1545C == c0660d) {
            this.f1545C = null;
        }
    }

    private void m3399a(C0727f c0727f, boolean z) {
        if (this.f1559r == null || !this.f1559r.mo676d() || (ar.m2641b(ViewConfiguration.get(this.a)) && !this.f1559r.mo678f())) {
            C0660d a = m3389a(0, true);
            a.f1611q = true;
            m3394a(a, false);
            m3393a(a, null);
            return;
        }
        Callback p = m3384p();
        if (this.f1559r.mo677e() && z) {
            this.f1559r.mo680h();
            if (!m3383o()) {
                p.onPanelClosed(108, m3389a(0, true).f1604j);
            }
        } else if (p != null && !m3383o()) {
            if (this.f1547E && (this.f1548F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f1549G);
                this.f1549G.run();
            }
            C0660d a2 = m3389a(0, true);
            if (a2.f1604j != null && !a2.f1612r && p.onPreparePanel(0, a2.f1603i, a2.f1604j)) {
                p.onMenuOpened(108, a2.f1604j);
                this.f1559r.mo679g();
            }
        }
    }

    private boolean m3400a(C0660d c0660d) {
        c0660d.m3498a(m3381m());
        c0660d.f1601g = new C0659c(this, c0660d.f1606l);
        c0660d.f1597c = 81;
        return true;
    }

    private boolean m3401a(C0660d c0660d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c0660d.f1607m || m3408b(c0660d, keyEvent)) && c0660d.f1604j != null) {
                z = c0660d.f1604j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1559r == null) {
                m3394a(c0660d, true);
            }
        }
        return z;
    }

    private boolean m3403a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ag.m2505C((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private void m3406b(C0727f c0727f) {
        if (!this.f1543A) {
            this.f1543A = true;
            this.f1559r.mo682j();
            Callback p = m3384p();
            if (!(p == null || m3383o())) {
                p.onPanelClosed(108, c0727f);
            }
            this.f1543A = false;
        }
    }

    private boolean m3407b(C0660d c0660d) {
        Context c0706d;
        C0727f c0727f;
        Context context = this.a;
        if ((c0660d.f1595a == 0 || c0660d.f1595a == 108) && this.f1559r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0683a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0683a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0683a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0706d = new C0706d(context, 0);
                c0706d.getTheme().setTo(theme3);
                c0727f = new C0727f(c0706d);
                c0727f.mo658a((C0638a) this);
                c0660d.m3499a(c0727f);
                return true;
            }
        }
        c0706d = context;
        c0727f = new C0727f(c0706d);
        c0727f.mo658a((C0638a) this);
        c0660d.m3499a(c0727f);
        return true;
    }

    private boolean m3408b(C0660d c0660d, KeyEvent keyEvent) {
        if (m3383o()) {
            return false;
        }
        if (c0660d.f1607m) {
            return true;
        }
        if (!(this.f1545C == null || this.f1545C == c0660d)) {
            m3394a(this.f1545C, false);
        }
        Callback p = m3384p();
        if (p != null) {
            c0660d.f1603i = p.onCreatePanelView(c0660d.f1595a);
        }
        boolean z = c0660d.f1595a == 0 || c0660d.f1595a == 108;
        if (z && this.f1559r != null) {
            this.f1559r.mo681i();
        }
        if (c0660d.f1603i == null && !(z && (m3380l() instanceof C0671n))) {
            if (c0660d.f1604j == null || c0660d.f1612r) {
                if (c0660d.f1604j == null && (!m3407b(c0660d) || c0660d.f1604j == null)) {
                    return false;
                }
                if (z && this.f1559r != null) {
                    if (this.f1560s == null) {
                        this.f1560s = new C0655a();
                    }
                    this.f1559r.mo675a(c0660d.f1604j, this.f1560s);
                }
                c0660d.f1604j.m3838g();
                if (p.onCreatePanelMenu(c0660d.f1595a, c0660d.f1604j)) {
                    c0660d.f1612r = false;
                } else {
                    c0660d.m3499a(null);
                    if (!z || this.f1559r == null) {
                        return false;
                    }
                    this.f1559r.mo675a(null, this.f1560s);
                    return false;
                }
            }
            c0660d.f1604j.m3838g();
            if (c0660d.f1613s != null) {
                c0660d.f1604j.m3825b(c0660d.f1613s);
                c0660d.f1613s = null;
            }
            if (p.onPreparePanel(0, c0660d.f1603i, c0660d.f1604j)) {
                c0660d.f1610p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                c0660d.f1604j.setQwertyMode(c0660d.f1610p);
                c0660d.f1604j.m3839h();
            } else {
                if (z && this.f1559r != null) {
                    this.f1559r.mo675a(null, this.f1560s);
                }
                c0660d.f1604j.m3839h();
                return false;
            }
        }
        c0660d.f1607m = true;
        c0660d.f1608n = false;
        this.f1545C = c0660d;
        return true;
    }

    private boolean m3411c(C0660d c0660d) {
        if (c0660d.f1603i != null) {
            c0660d.f1602h = c0660d.f1603i;
            return true;
        } else if (c0660d.f1604j == null) {
            return false;
        } else {
            if (this.f1561t == null) {
                this.f1561t = new C0661e();
            }
            c0660d.f1602h = (View) c0660d.m3497a(this.f1561t);
            return c0660d.f1602h != null;
        }
    }

    private void mo564d(int i) {
        m3394a(m3389a(i, true), true);
    }

    private boolean m3414d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0660d a = m3389a(i, true);
            if (!a.f1609o) {
                return m3408b(a, keyEvent);
            }
        }
        return false;
    }

    private void m3415e(int i) {
        this.f1548F |= 1 << i;
        if (!this.f1547E) {
            ag.m2519a(this.b.getDecorView(), this.f1549G);
            this.f1547E = true;
        }
    }

    private boolean m3416e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1554m != null) {
            return false;
        }
        C0660d a = m3389a(i, true);
        if (i != 0 || this.f1559r == null || !this.f1559r.mo676d() || ar.m2641b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f1609o || a.f1608n) {
                z2 = a.f1609o;
                m3394a(a, true);
                z = z2;
            } else {
                if (a.f1607m) {
                    if (a.f1612r) {
                        a.f1607m = false;
                        z2 = m3408b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m3393a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1559r.mo677e()) {
            z = this.f1559r.mo680h();
        } else {
            if (!m3383o() && m3408b(a, keyEvent)) {
                z = this.f1559r.mo679g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m3417f(int i) {
        C0660d a = m3389a(i, true);
        if (a.f1604j != null) {
            Bundle bundle = new Bundle();
            a.f1604j.m3813a(bundle);
            if (bundle.size() > 0) {
                a.f1613s = bundle;
            }
            a.f1604j.m3838g();
            a.f1604j.clear();
        }
        a.f1612r = true;
        a.f1611q = true;
        if ((i == 108 || i == 0) && this.f1559r != null) {
            a = m3389a(0, false);
            if (a != null) {
                a.f1607m = false;
                m3408b(a, null);
            }
        }
    }

    private int m3418g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1555n == null || !(this.f1555n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1555n.getLayoutParams();
            if (this.f1555n.isShown()) {
                if (this.f1551I == null) {
                    this.f1551I = new Rect();
                    this.f1552J = new Rect();
                }
                Rect rect = this.f1551I;
                Rect rect2 = this.f1552J;
                rect.set(0, i, 0, 0);
                bl.m5301a(this.f1563v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1565x == null) {
                        this.f1565x = new View(this.a);
                        this.f1565x.setBackgroundColor(this.a.getResources().getColor(C0685c.abc_input_method_navigation_guard));
                        this.f1563v.addView(this.f1565x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1565x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1565x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1565x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1555n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1565x != null) {
            View view = this.f1565x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private int m3419h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void m3420s() {
        if (!this.f1562u) {
            this.f1563v = m3421t();
            CharSequence q = m3385q();
            if (!TextUtils.isEmpty(q)) {
                mo553b(q);
            }
            m3422u();
            m3436a(this.f1563v);
            this.f1562u = true;
            C0660d a = m3389a(0, false);
            if (!m3383o()) {
                if (a == null || a.f1604j == null) {
                    m3415e(108);
                }
            }
        }
    }

    private ViewGroup m3421t() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0693k.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0693k.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0693k.AppCompatTheme_windowNoTitle, false)) {
                mo556c(1);
            } else if (obtainStyledAttributes.getBoolean(C0693k.AppCompatTheme_windowActionBar, false)) {
                mo556c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0693k.AppCompatTheme_windowActionBarOverlay, false)) {
                mo556c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0693k.AppCompatTheme_windowActionModeOverlay, false)) {
                mo556c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0693k.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2 = this.j ? (ViewGroup) from.inflate(C0690h.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(C0690h.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    ag.m2518a(view2, new C06462(this));
                    view = view2;
                } else {
                    ((am) view2).setOnFitSystemWindowsListener(new C06483(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0690h.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0683a.actionBarTheme, typedValue, true);
                r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0706d(this.a, typedValue.resourceId) : this.a).inflate(C0690h.abc_screen_toolbar, null);
                this.f1559r = (ai) r0.findViewById(C0688f.decor_content_parent);
                this.f1559r.setWindowCallback(m3384p());
                if (this.i) {
                    this.f1559r.mo674a(109);
                }
                if (this.f1566y) {
                    this.f1559r.mo674a(2);
                }
                if (this.f1567z) {
                    this.f1559r.mo674a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1559r == null) {
                this.f1564w = (TextView) view.findViewById(C0688f.title);
            }
            bl.m5303b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0688f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new C06504(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void m3422u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1563v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m3494a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0693k.AppCompatTheme);
        obtainStyledAttributes.getValue(C0693k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0693k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0693k.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0693k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0693k.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0693k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0693k.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0693k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0693k.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0693k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void m3423v() {
        if (this.f1558q != null) {
            this.f1558q.m2734b();
        }
    }

    private void m3424w() {
        if (this.f1562u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void m3425x() {
        if (this.f1559r != null) {
            this.f1559r.mo682j();
        }
        if (this.f1556o != null) {
            this.b.getDecorView().removeCallbacks(this.f1557p);
            if (this.f1556o.isShowing()) {
                try {
                    this.f1556o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1556o = null;
        }
        m3423v();
        C0660d a = m3389a(0, false);
        if (a != null && a.f1604j != null) {
            a.f1604j.close();
        }
    }

    C0679b mo538a(C0657a c0657a) {
        C0679b c0679b;
        m3423v();
        if (this.f1554m != null) {
            this.f1554m.mo605c();
        }
        C0657a c0658b = new C0658b(this, c0657a);
        if (this.e == null || m3383o()) {
            c0679b = null;
        } else {
            try {
                c0679b = this.e.mo511a(c0658b);
            } catch (AbstractMethodError e) {
                c0679b = null;
            }
        }
        if (c0679b != null) {
            this.f1554m = c0679b;
        } else {
            if (this.f1555n == null) {
                if (this.k) {
                    Context c0706d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0683a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0706d = new C0706d(this.a, 0);
                        c0706d.getTheme().setTo(newTheme);
                    } else {
                        c0706d = this.a;
                    }
                    this.f1555n = new ActionBarContextView(c0706d);
                    this.f1556o = new PopupWindow(c0706d, null, C0683a.actionModePopupWindowStyle);
                    C0589o.m3136a(this.f1556o, 2);
                    this.f1556o.setContentView(this.f1555n);
                    this.f1556o.setWidth(-1);
                    c0706d.getTheme().resolveAttribute(C0683a.actionBarSize, typedValue, true);
                    this.f1555n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0706d.getResources().getDisplayMetrics()));
                    this.f1556o.setHeight(-2);
                    this.f1557p = new C06525(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1563v.findViewById(C0688f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m3381m()));
                        this.f1555n = (ActionBarContextView) viewStubCompat.m4827a();
                    }
                }
            }
            if (this.f1555n != null) {
                m3423v();
                this.f1555n.m3949c();
                C0679b c0707e = new C0707e(this.f1555n.getContext(), this.f1555n, c0658b, this.f1556o == null);
                if (c0657a.mo573a(c0707e, c0707e.mo602b())) {
                    c0707e.mo606d();
                    this.f1555n.m3946a(c0707e);
                    this.f1554m = c0707e;
                    ag.m2528c(this.f1555n, 0.0f);
                    this.f1558q = ag.m2549q(this.f1555n).m2727a(1.0f);
                    this.f1558q.m2729a(new C06536(this));
                    if (this.f1556o != null) {
                        this.b.getDecorView().post(this.f1557p);
                    }
                } else {
                    this.f1554m = null;
                }
            }
        }
        if (!(this.f1554m == null || this.e == null)) {
            this.e.mo512a(this.f1554m);
        }
        return this.f1554m;
    }

    public View mo539a(int i) {
        m3420s();
        return this.b.findViewById(i);
    }

    public final View mo225a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = mo561b(view, str, context, attributeSet);
        return b != null ? b : m3448c(view, str, context, attributeSet);
    }

    void mo540a(int i, Menu menu) {
        if (i == 108) {
            C0614a a = mo532a();
            if (a != null) {
                a.mo593g(false);
            }
        } else if (i == 0) {
            C0660d a2 = m3389a(i, true);
            if (a2.f1609o) {
                m3394a(a2, false);
            }
        }
    }

    public void mo541a(Configuration configuration) {
        if (this.h && this.f1562u) {
            C0614a a = mo532a();
            if (a != null) {
                a.mo580a(configuration);
            }
        }
        mo537h();
    }

    public void mo542a(Bundle bundle) {
        if ((this.c instanceof Activity) && C0290z.m1677b((Activity) this.c) != null) {
            C0614a l = m3380l();
            if (l == null) {
                this.f1550H = true;
            } else {
                l.mo589e(true);
            }
        }
    }

    public void mo543a(C0727f c0727f) {
        m3399a(c0727f, true);
    }

    public void mo544a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            C0614a a = mo532a();
            if (a instanceof C0682q) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.mo595h();
            }
            if (toolbar != null) {
                C0614a c0671n = new C0671n(toolbar, ((Activity) this.a).getTitle(), this.d);
                this.f = c0671n;
                this.b.setCallback(c0671n.m3544i());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            mo558e();
        }
    }

    public void mo545a(View view) {
        m3420s();
        ViewGroup viewGroup = (ViewGroup) this.f1563v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void mo546a(View view, LayoutParams layoutParams) {
        m3420s();
        ViewGroup viewGroup = (ViewGroup) this.f1563v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m3436a(ViewGroup viewGroup) {
    }

    boolean mo547a(int i, KeyEvent keyEvent) {
        C0614a a = mo532a();
        if (a != null && a.mo583a(i, keyEvent)) {
            return true;
        }
        if (this.f1545C == null || !m3401a(this.f1545C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1545C == null) {
                C0660d a2 = m3389a(0, true);
                m3408b(a2, keyEvent);
                boolean a3 = m3401a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1607m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1545C == null) {
            return true;
        } else {
            this.f1545C.f1608n = true;
            return true;
        }
    }

    public boolean mo548a(C0727f c0727f, MenuItem menuItem) {
        Callback p = m3384p();
        if (!(p == null || m3383o())) {
            C0660d a = m3391a(c0727f.mo664p());
            if (a != null) {
                return p.onMenuItemSelected(a.f1595a, menuItem);
            }
        }
        return false;
    }

    boolean mo549a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m3451c(keyCode, keyEvent) : m3446b(keyCode, keyEvent);
    }

    public C0679b m3440b(C0657a c0657a) {
        if (c0657a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1554m != null) {
            this.f1554m.mo605c();
        }
        C0657a c0658b = new C0658b(this, c0657a);
        C0614a a = mo532a();
        if (a != null) {
            this.f1554m = a.mo611a(c0658b);
            if (!(this.f1554m == null || this.e == null)) {
                this.e.mo512a(this.f1554m);
            }
        }
        if (this.f1554m == null) {
            this.f1554m = mo538a(c0658b);
        }
        return this.f1554m;
    }

    View mo561b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public void mo550b(int i) {
        m3420s();
        ViewGroup viewGroup = (ViewGroup) this.f1563v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void mo551b(Bundle bundle) {
        m3420s();
    }

    public void mo552b(View view, LayoutParams layoutParams) {
        m3420s();
        ((ViewGroup) this.f1563v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void mo553b(CharSequence charSequence) {
        if (this.f1559r != null) {
            this.f1559r.setWindowTitle(charSequence);
        } else if (m3380l() != null) {
            m3380l().mo584b(charSequence);
        } else if (this.f1564w != null) {
            this.f1564w.setText(charSequence);
        }
    }

    boolean m3446b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f1546D;
                this.f1546D = false;
                C0660d a = m3389a(0, false);
                if (a == null || !a.f1609o) {
                    if (m3457r()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m3394a(a, true);
                    return true;
                }
                break;
            case 82:
                m3416e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean mo554b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0614a a = mo532a();
        if (a == null) {
            return true;
        }
        a.mo593g(true);
        return true;
    }

    public View m3448c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = VERSION.SDK_INT < 21;
        if (this.f1553K == null) {
            this.f1553K = new C0663m();
        }
        boolean z2 = z && m3403a((ViewParent) view);
        return this.f1553K.m3508a(view, str, context, attributeSet, z2, z, true, bj.m5278a());
    }

    public void mo555c() {
        C0614a a = mo532a();
        if (a != null) {
            a.mo591f(false);
        }
    }

    public boolean mo556c(int i) {
        int h = m3419h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                m3424w();
                this.l = true;
                return true;
            case 2:
                m3424w();
                this.f1566y = true;
                return true;
            case 5:
                m3424w();
                this.f1567z = true;
                return true;
            case 10:
                m3424w();
                this.j = true;
                return true;
            case 108:
                m3424w();
                this.h = true;
                return true;
            case 109:
                m3424w();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean m3451c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1546D = z;
                break;
            case 82:
                m3414d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            mo547a(i, keyEvent);
        }
        return false;
    }

    public void mo557d() {
        C0614a a = mo532a();
        if (a != null) {
            a.mo591f(true);
        }
    }

    public void mo558e() {
        C0614a a = mo532a();
        if (a == null || !a.mo590e()) {
            m3415e(0);
        }
    }

    public void mo536f() {
        super.mo536f();
        if (this.f != null) {
            this.f.mo595h();
        }
    }

    public void mo559g() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0519i.m2821a(from, this);
        } else if (!(C0519i.m2820a(from) instanceof C0639k)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void mo560k() {
        m3420s();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new C0682q((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new C0682q((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.mo589e(this.f1550H);
            }
        }
    }

    boolean m3457r() {
        if (this.f1554m != null) {
            this.f1554m.mo605c();
            return true;
        }
        C0614a a = mo532a();
        return a != null && a.mo592f();
    }
}
