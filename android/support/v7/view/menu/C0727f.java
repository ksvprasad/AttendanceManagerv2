package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p010b.C0195a;
import android.support.v4.p012d.p013a.C0335a;
import android.support.v4.view.C0503d;
import android.support.v4.view.C0535p;
import android.support.v7.p019b.C0694a.C0684b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class C0727f implements C0335a {
    private static final int[] f1841d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f1842a;
    Drawable f1843b;
    View f1844c;
    private final Context f1845e;
    private final Resources f1846f;
    private boolean f1847g;
    private boolean f1848h;
    private C0638a f1849i;
    private ArrayList<C0730h> f1850j;
    private ArrayList<C0730h> f1851k;
    private boolean f1852l;
    private ArrayList<C0730h> f1853m;
    private ArrayList<C0730h> f1854n;
    private boolean f1855o;
    private int f1856p = 0;
    private ContextMenuInfo f1857q;
    private boolean f1858r = false;
    private boolean f1859s = false;
    private boolean f1860t = false;
    private boolean f1861u = false;
    private ArrayList<C0730h> f1862v = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0721l>> f1863w = new CopyOnWriteArrayList();
    private C0730h f1864x;
    private boolean f1865y;

    public interface C0638a {
        void mo543a(C0727f c0727f);

        boolean mo548a(C0727f c0727f, MenuItem menuItem);
    }

    public interface C0719b {
        boolean mo624a(C0730h c0730h);
    }

    public C0727f(Context context) {
        this.f1845e = context;
        this.f1846f = context.getResources();
        this.f1850j = new ArrayList();
        this.f1851k = new ArrayList();
        this.f1852l = true;
        this.f1853m = new ArrayList();
        this.f1854n = new ArrayList();
        this.f1855o = true;
        m3804e(true);
    }

    private static int m3797a(ArrayList<C0730h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0730h) arrayList.get(size)).m3868c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0730h m3798a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0730h(this, i, i2, i3, i4, charSequence, i5);
    }

    private void m3799a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m3834d();
        if (view != null) {
            this.f1844c = view;
            this.f1842a = null;
            this.f1843b = null;
        } else {
            if (i > 0) {
                this.f1842a = d.getText(i);
            } else if (charSequence != null) {
                this.f1842a = charSequence;
            }
            if (i2 > 0) {
                this.f1843b = C0195a.m1224a(m3836e(), i2);
            } else if (drawable != null) {
                this.f1843b = drawable;
            }
            this.f1844c = null;
        }
        m3828b(false);
    }

    private void m3800a(int i, boolean z) {
        if (i >= 0 && i < this.f1850j.size()) {
            this.f1850j.remove(i);
            if (z) {
                m3828b(true);
            }
        }
    }

    private boolean m3801a(C0742p c0742p, C0721l c0721l) {
        boolean z = false;
        if (this.f1863w.isEmpty()) {
            return false;
        }
        if (c0721l != null) {
            z = c0721l.mo639a(c0742p);
        }
        Iterator it = this.f1863w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0721l c0721l2 = (C0721l) weakReference.get();
            if (c0721l2 == null) {
                this.f1863w.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0721l2.mo639a(c0742p) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private static int m3802d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1841d.length) {
            return (f1841d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void m3803d(boolean z) {
        if (!this.f1863w.isEmpty()) {
            m3838g();
            Iterator it = this.f1863w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0721l c0721l = (C0721l) weakReference.get();
                if (c0721l == null) {
                    this.f1863w.remove(weakReference);
                } else {
                    c0721l.mo640b(z);
                }
            }
            m3839h();
        }
    }

    private void m3804e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1846f.getConfiguration().keyboard != 1 && this.f1846f.getBoolean(C0684b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1848h = z2;
    }

    public int m3805a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0730h) this.f1850j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0727f m3806a(int i) {
        this.f1856p = i;
        return this;
    }

    protected C0727f m3807a(Drawable drawable) {
        m3799a(0, null, 0, drawable, null);
        return this;
    }

    protected C0727f m3808a(View view) {
        m3799a(0, null, 0, null, view);
        return this;
    }

    protected C0727f m3809a(CharSequence charSequence) {
        m3799a(0, charSequence, 0, null, null);
        return this;
    }

    C0730h m3810a(int i, KeyEvent keyEvent) {
        List list = this.f1862v;
        list.clear();
        m3819a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0730h) list.get(0);
        }
        boolean b = mo660b();
        for (int i2 = 0; i2 < size; i2++) {
            C0730h c0730h = (C0730h) list.get(i2);
            char alphabeticShortcut = b ? c0730h.getAlphabeticShortcut() : c0730h.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0730h;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0730h;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0730h;
            }
        }
        return null;
    }

    protected MenuItem m3811a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0727f.m3802d(i3);
        MenuItem a = m3798a(i, i2, i3, d, charSequence, this.f1856p);
        if (this.f1857q != null) {
            a.m3863a(this.f1857q);
        }
        this.f1850j.add(C0727f.m3797a(this.f1850j, d), a);
        m3828b(true);
        return a;
    }

    protected String mo657a() {
        return "android:menu:actionviewstates";
    }

    public void m3813a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0535p.m2861a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0535p.m2865c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0742p) item.getSubMenu()).m3813a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo657a(), sparseArray);
        }
    }

    public void mo658a(C0638a c0638a) {
        this.f1849i = c0638a;
    }

    void m3815a(C0730h c0730h) {
        this.f1852l = true;
        m3828b(true);
    }

    public void m3816a(C0721l c0721l) {
        m3817a(c0721l, this.f1845e);
    }

    public void m3817a(C0721l c0721l, Context context) {
        this.f1863w.add(new WeakReference(c0721l));
        c0721l.mo636a(context, this);
        this.f1855o = true;
    }

    void m3818a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1850j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0730h) this.f1850j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3875g() && menuItem2.isCheckable()) {
                menuItem2.m3866b(menuItem2 == menuItem);
            }
        }
    }

    void m3819a(List<C0730h> list, int i, KeyEvent keyEvent) {
        boolean b = mo660b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1850j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0730h c0730h = (C0730h) this.f1850j.get(i2);
                if (c0730h.hasSubMenu()) {
                    ((C0727f) c0730h.getSubMenu()).m3819a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0730h.getAlphabeticShortcut() : c0730h.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0730h.isEnabled())) {
                    list.add(c0730h);
                }
            }
        }
    }

    public final void m3820a(boolean z) {
        if (!this.f1861u) {
            this.f1861u = true;
            Iterator it = this.f1863w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0721l c0721l = (C0721l) weakReference.get();
                if (c0721l == null) {
                    this.f1863w.remove(weakReference);
                } else {
                    c0721l.mo637a(this, z);
                }
            }
            this.f1861u = false;
        }
    }

    boolean mo659a(C0727f c0727f, MenuItem menuItem) {
        return this.f1849i != null && this.f1849i.mo548a(c0727f, menuItem);
    }

    public boolean m3822a(MenuItem menuItem, int i) {
        return m3823a(menuItem, null, i);
    }

    public boolean m3823a(MenuItem menuItem, C0721l c0721l, int i) {
        C0730h c0730h = (C0730h) menuItem;
        if (c0730h == null || !c0730h.isEnabled()) {
            return false;
        }
        boolean b = c0730h.m3867b();
        C0503d a = c0730h.mo627a();
        boolean z = a != null && a.mo647e();
        boolean expandActionView;
        if (c0730h.m3882n()) {
            expandActionView = c0730h.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3820a(true);
            return expandActionView;
        } else if (c0730h.hasSubMenu() || z) {
            m3820a(false);
            if (!c0730h.hasSubMenu()) {
                c0730h.m3862a(new C0742p(m3836e(), this, c0730h));
            }
            C0742p c0742p = (C0742p) c0730h.getSubMenu();
            if (z) {
                a.mo645a((SubMenu) c0742p);
            }
            expandActionView = m3801a(c0742p, c0721l) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3820a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3820a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return m3811a(0, 0, 0, this.f1846f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3811a(i, i2, i3, this.f1846f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3811a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3811a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1845e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1846f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1846f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0730h c0730h = (C0730h) m3811a(i, i2, i3, charSequence);
        C0742p c0742p = new C0742p(this.f1845e, this, c0730h);
        c0730h.m3862a(c0742p);
        return c0742p;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m3824b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0730h) this.f1850j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m3825b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo657a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = C0535p.m2861a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0742p) item.getSubMenu()).m3825b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    C0535p.m2864b(item);
                }
            }
        }
    }

    void m3826b(C0730h c0730h) {
        this.f1855o = true;
        m3828b(true);
    }

    public void m3827b(C0721l c0721l) {
        Iterator it = this.f1863w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0721l c0721l2 = (C0721l) weakReference.get();
            if (c0721l2 == null || c0721l2 == c0721l) {
                this.f1863w.remove(weakReference);
            }
        }
    }

    public void m3828b(boolean z) {
        if (this.f1858r) {
            this.f1859s = true;
            return;
        }
        if (z) {
            this.f1852l = true;
            this.f1855o = true;
        }
        m3803d(z);
    }

    boolean mo660b() {
        return this.f1847g;
    }

    public int m3830c(int i) {
        return m3805a(i, 0);
    }

    public void m3831c(boolean z) {
        this.f1865y = z;
    }

    public boolean mo661c() {
        return this.f1848h;
    }

    public boolean mo662c(C0730h c0730h) {
        boolean z = false;
        if (!this.f1863w.isEmpty()) {
            m3838g();
            Iterator it = this.f1863w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0721l c0721l = (C0721l) weakReference.get();
                if (c0721l == null) {
                    this.f1863w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0721l.mo638a(this, c0730h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3839h();
            if (z) {
                this.f1864x = c0730h;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f1864x != null) {
            mo663d(this.f1864x);
        }
        this.f1850j.clear();
        m3828b(true);
    }

    public void clearHeader() {
        this.f1843b = null;
        this.f1842a = null;
        this.f1844c = null;
        m3828b(false);
    }

    public void close() {
        m3820a(true);
    }

    Resources m3834d() {
        return this.f1846f;
    }

    public boolean mo663d(C0730h c0730h) {
        boolean z = false;
        if (!this.f1863w.isEmpty() && this.f1864x == c0730h) {
            m3838g();
            Iterator it = this.f1863w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0721l c0721l = (C0721l) weakReference.get();
                if (c0721l == null) {
                    this.f1863w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0721l.mo642b(this, c0730h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3839h();
            if (z) {
                this.f1864x = null;
            }
        }
        return z;
    }

    public Context m3836e() {
        return this.f1845e;
    }

    public void m3837f() {
        if (this.f1849i != null) {
            this.f1849i.mo543a(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0730h c0730h = (C0730h) this.f1850j.get(i2);
            if (c0730h.getItemId() == i) {
                return c0730h;
            }
            if (c0730h.hasSubMenu()) {
                MenuItem findItem = c0730h.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m3838g() {
        if (!this.f1858r) {
            this.f1858r = true;
            this.f1859s = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1850j.get(i);
    }

    public void m3839h() {
        this.f1858r = false;
        if (this.f1859s) {
            this.f1859s = false;
            m3828b(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1865y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0730h) this.f1850j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<C0730h> m3840i() {
        if (!this.f1852l) {
            return this.f1851k;
        }
        this.f1851k.clear();
        int size = this.f1850j.size();
        for (int i = 0; i < size; i++) {
            C0730h c0730h = (C0730h) this.f1850j.get(i);
            if (c0730h.isVisible()) {
                this.f1851k.add(c0730h);
            }
        }
        this.f1852l = false;
        this.f1855o = true;
        return this.f1851k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3810a(i, keyEvent) != null;
    }

    public void m3841j() {
        ArrayList i = m3840i();
        if (this.f1855o) {
            Iterator it = this.f1863w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0721l c0721l = (C0721l) weakReference.get();
                if (c0721l == null) {
                    this.f1863w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0721l.mo641b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1853m.clear();
                this.f1854n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0730h c0730h = (C0730h) i.get(i4);
                    if (c0730h.m3878j()) {
                        this.f1853m.add(c0730h);
                    } else {
                        this.f1854n.add(c0730h);
                    }
                }
            } else {
                this.f1853m.clear();
                this.f1854n.clear();
                this.f1854n.addAll(m3840i());
            }
            this.f1855o = false;
        }
    }

    public ArrayList<C0730h> m3842k() {
        m3841j();
        return this.f1853m;
    }

    public ArrayList<C0730h> m3843l() {
        m3841j();
        return this.f1854n;
    }

    public CharSequence m3844m() {
        return this.f1842a;
    }

    public Drawable m3845n() {
        return this.f1843b;
    }

    public View m3846o() {
        return this.f1844c;
    }

    public C0727f mo664p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3822a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3810a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3822a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3820a(true);
        }
        return z;
    }

    boolean m3848q() {
        return this.f1860t;
    }

    public C0730h m3849r() {
        return this.f1864x;
    }

    public void removeGroup(int i) {
        int c = m3830c(i);
        if (c >= 0) {
            int size = this.f1850j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0730h) this.f1850j.get(c)).getGroupId() != i) {
                    m3828b(true);
                } else {
                    m3800a(c, false);
                    i2 = i3;
                }
            }
            m3828b(true);
        }
    }

    public void removeItem(int i) {
        m3800a(m3824b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1850j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0730h c0730h = (C0730h) this.f1850j.get(i2);
            if (c0730h.getGroupId() == i) {
                c0730h.m3864a(z2);
                c0730h.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1850j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0730h c0730h = (C0730h) this.f1850j.get(i2);
            if (c0730h.getGroupId() == i) {
                c0730h.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1850j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0730h c0730h = (C0730h) this.f1850j.get(i2);
            boolean z3 = (c0730h.getGroupId() == i && c0730h.m3869c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3828b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f1847g = z;
        m3828b(false);
    }

    public int size() {
        return this.f1850j.size();
    }
}
