package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p012d.p013a.C0335a;
import android.support.v4.view.C0503d;
import android.support.v4.view.C0535p;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.menu.C0730h;
import android.support.v7.view.menu.C0735i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class C0712g extends MenuInflater {
    private static final Class<?>[] f1745a = new Class[]{Context.class};
    private static final Class<?>[] f1746b = f1745a;
    private final Object[] f1747c;
    private final Object[] f1748d = this.f1747c;
    private Context f1749e;
    private Object f1750f;

    private static class C0710a implements OnMenuItemClickListener {
        private static final Class<?>[] f1716a = new Class[]{MenuItem.class};
        private Object f1717b;
        private Method f1718c;

        public C0710a(Object obj, String str) {
            this.f1717b = obj;
            Class cls = obj.getClass();
            try {
                this.f1718c = cls.getMethod(str, f1716a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1718c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1718c.invoke(this.f1717b, new Object[]{menuItem})).booleanValue();
                }
                this.f1718c.invoke(this.f1717b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class C0711b {
        final /* synthetic */ C0712g f1719a;
        private Menu f1720b;
        private int f1721c;
        private int f1722d;
        private int f1723e;
        private int f1724f;
        private boolean f1725g;
        private boolean f1726h;
        private boolean f1727i;
        private int f1728j;
        private int f1729k;
        private CharSequence f1730l;
        private CharSequence f1731m;
        private int f1732n;
        private char f1733o;
        private char f1734p;
        private int f1735q;
        private boolean f1736r;
        private boolean f1737s;
        private boolean f1738t;
        private int f1739u;
        private int f1740v;
        private String f1741w;
        private String f1742x;
        private String f1743y;
        private C0503d f1744z;

        public C0711b(C0712g c0712g, Menu menu) {
            this.f1719a = c0712g;
            this.f1720b = menu;
            m3685a();
        }

        private char m3681a(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        private <T> T m3683a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f1719a.f1749e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void m3684a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1736r).setVisible(this.f1737s).setEnabled(this.f1738t).setCheckable(this.f1735q >= 1).setTitleCondensed(this.f1731m).setIcon(this.f1732n).setAlphabeticShortcut(this.f1733o).setNumericShortcut(this.f1734p);
            if (this.f1739u >= 0) {
                C0535p.m2862a(menuItem, this.f1739u);
            }
            if (this.f1743y != null) {
                if (this.f1719a.f1749e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0710a(this.f1719a.m3697c(), this.f1743y));
            }
            if (menuItem instanceof C0730h) {
                C0730h c0730h = (C0730h) menuItem;
            }
            if (this.f1735q >= 2) {
                if (menuItem instanceof C0730h) {
                    ((C0730h) menuItem).m3864a(true);
                } else if (menuItem instanceof C0735i) {
                    ((C0735i) menuItem).m3893a(true);
                }
            }
            if (this.f1741w != null) {
                C0535p.m2860a(menuItem, (View) m3683a(this.f1741w, C0712g.f1745a, this.f1719a.f1747c));
            } else {
                z = false;
            }
            if (this.f1740v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0535p.m2863b(menuItem, this.f1740v);
                }
            }
            if (this.f1744z != null) {
                C0535p.m2859a(menuItem, this.f1744z);
            }
        }

        public void m3685a() {
            this.f1721c = 0;
            this.f1722d = 0;
            this.f1723e = 0;
            this.f1724f = 0;
            this.f1725g = true;
            this.f1726h = true;
        }

        public void m3686a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f1719a.f1749e.obtainStyledAttributes(attributeSet, C0693k.MenuGroup);
            this.f1721c = obtainStyledAttributes.getResourceId(C0693k.MenuGroup_android_id, 0);
            this.f1722d = obtainStyledAttributes.getInt(C0693k.MenuGroup_android_menuCategory, 0);
            this.f1723e = obtainStyledAttributes.getInt(C0693k.MenuGroup_android_orderInCategory, 0);
            this.f1724f = obtainStyledAttributes.getInt(C0693k.MenuGroup_android_checkableBehavior, 0);
            this.f1725g = obtainStyledAttributes.getBoolean(C0693k.MenuGroup_android_visible, true);
            this.f1726h = obtainStyledAttributes.getBoolean(C0693k.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m3687b() {
            this.f1727i = true;
            m3684a(this.f1720b.add(this.f1721c, this.f1728j, this.f1729k, this.f1730l));
        }

        public void m3688b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f1719a.f1749e.obtainStyledAttributes(attributeSet, C0693k.MenuItem);
            this.f1728j = obtainStyledAttributes.getResourceId(C0693k.MenuItem_android_id, 0);
            this.f1729k = (obtainStyledAttributes.getInt(C0693k.MenuItem_android_menuCategory, this.f1722d) & -65536) | (obtainStyledAttributes.getInt(C0693k.MenuItem_android_orderInCategory, this.f1723e) & 65535);
            this.f1730l = obtainStyledAttributes.getText(C0693k.MenuItem_android_title);
            this.f1731m = obtainStyledAttributes.getText(C0693k.MenuItem_android_titleCondensed);
            this.f1732n = obtainStyledAttributes.getResourceId(C0693k.MenuItem_android_icon, 0);
            this.f1733o = m3681a(obtainStyledAttributes.getString(C0693k.MenuItem_android_alphabeticShortcut));
            this.f1734p = m3681a(obtainStyledAttributes.getString(C0693k.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0693k.MenuItem_android_checkable)) {
                this.f1735q = obtainStyledAttributes.getBoolean(C0693k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1735q = this.f1724f;
            }
            this.f1736r = obtainStyledAttributes.getBoolean(C0693k.MenuItem_android_checked, false);
            this.f1737s = obtainStyledAttributes.getBoolean(C0693k.MenuItem_android_visible, this.f1725g);
            this.f1738t = obtainStyledAttributes.getBoolean(C0693k.MenuItem_android_enabled, this.f1726h);
            this.f1739u = obtainStyledAttributes.getInt(C0693k.MenuItem_showAsAction, -1);
            this.f1743y = obtainStyledAttributes.getString(C0693k.MenuItem_android_onClick);
            this.f1740v = obtainStyledAttributes.getResourceId(C0693k.MenuItem_actionLayout, 0);
            this.f1741w = obtainStyledAttributes.getString(C0693k.MenuItem_actionViewClass);
            this.f1742x = obtainStyledAttributes.getString(C0693k.MenuItem_actionProviderClass);
            if (this.f1742x == null) {
                z = false;
            }
            if (z && this.f1740v == 0 && this.f1741w == null) {
                this.f1744z = (C0503d) m3683a(this.f1742x, C0712g.f1746b, this.f1719a.f1748d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1744z = null;
            }
            obtainStyledAttributes.recycle();
            this.f1727i = false;
        }

        public SubMenu m3689c() {
            this.f1727i = true;
            SubMenu addSubMenu = this.f1720b.addSubMenu(this.f1721c, this.f1728j, this.f1729k, this.f1730l);
            m3684a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m3690d() {
            return this.f1727i;
        }
    }

    public C0712g(Context context) {
        super(context);
        this.f1749e = context;
        this.f1747c = new Object[]{context};
    }

    private Object m3692a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m3692a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3693a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m3686a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m3688b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m3689c();
        r10.m3693a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m3685a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.m3690d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1744z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.f1744z;
        r3 = r3.mo647e();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.m3689c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.m3687b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object m3697c() {
        if (this.f1750f == null) {
            this.f1750f = m3692a(this.f1749e);
        }
        return this.f1750f;
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0335a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1749e.getResources().getLayout(i);
                m3693a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
