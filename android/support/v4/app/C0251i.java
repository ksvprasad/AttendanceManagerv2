package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.C0280w.C0244b;
import android.support.v4.app.C0280w.C0279a;
import android.support.v4.p015g.C0370a;
import android.support.v4.p015g.C0373d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class C0251i extends C0250v implements Runnable {
    static final boolean f894a = (VERSION.SDK_INT >= 21);
    final C0272s f895b;
    C0248a f896c;
    C0248a f897d;
    int f898e;
    int f899f;
    int f900g;
    int f901h;
    int f902i;
    int f903j;
    int f904k;
    boolean f905l;
    boolean f906m = true;
    String f907n;
    boolean f908o;
    int f909p = -1;
    int f910q;
    CharSequence f911r;
    int f912s;
    CharSequence f913t;
    ArrayList<String> f914u;
    ArrayList<String> f915v;

    static final class C0248a {
        C0248a f880a;
        C0248a f881b;
        int f882c;
        Fragment f883d;
        int f884e;
        int f885f;
        int f886g;
        int f887h;
        ArrayList<Fragment> f888i;

        C0248a() {
        }
    }

    public class C0249b {
        public C0370a<String, String> f889a = new C0370a();
        public ArrayList<View> f890b = new ArrayList();
        public C0279a f891c = new C0279a();
        public View f892d;
        final /* synthetic */ C0251i f893e;

        public C0249b(C0251i c0251i) {
            this.f893e = c0251i;
        }
    }

    public C0251i(C0272s c0272s) {
        this.f895b = c0272s;
    }

    private C0249b m1352a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        int i = 0;
        C0249b c0249b = new C0249b(this);
        c0249b.f892d = new View(this.f895b.f984o.m1430g());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4 = m1373a(sparseArray.keyAt(i2), c0249b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2) ? 1 : i3;
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m1373a(i4, c0249b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : c0249b;
    }

    private C0370a<String, View> m1353a(C0249b c0249b, Fragment fragment, boolean z) {
        C0370a c0370a = new C0370a();
        if (this.f914u != null) {
            C0280w.m1629a((Map) c0370a, fragment.m1210r());
            if (z) {
                c0370a.m1904a(this.f915v);
            } else {
                c0370a = C0251i.m1356a(this.f914u, this.f915v, c0370a);
            }
        }
        if (z) {
            if (fragment.ag != null) {
                fragment.ag.m1314a(this.f915v, c0370a);
            }
            m1363a(c0249b, c0370a, false);
        } else {
            if (fragment.ah != null) {
                fragment.ah.m1314a(this.f915v, c0370a);
            }
            m1376b(c0249b, c0370a, false);
        }
        return c0370a;
    }

    private C0370a<String, View> m1354a(C0249b c0249b, boolean z, Fragment fragment) {
        C0370a b = m1374b(c0249b, fragment, z);
        if (z) {
            if (fragment.ah != null) {
                fragment.ah.m1314a(this.f915v, b);
            }
            m1363a(c0249b, b, true);
        } else {
            if (fragment.ag != null) {
                fragment.ag.m1314a(this.f915v, b);
            }
            m1376b(c0249b, b, true);
        }
        return b;
    }

    private static C0370a<String, View> m1356a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0370a<String, View> c0370a) {
        if (c0370a.isEmpty()) {
            return c0370a;
        }
        C0370a<String, View> c0370a2 = new C0370a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0370a.get(arrayList.get(i));
            if (view != null) {
                c0370a2.put(arrayList2.get(i), view);
            }
        }
        return c0370a2;
    }

    private static Object m1357a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return C0280w.m1634b(z ? fragment2.m1141C() : fragment.m1140B());
    }

    private static Object m1358a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0280w.m1615a(z ? fragment.m1139A() : fragment.m1216x());
    }

    private static Object m1359a(Object obj, Fragment fragment, ArrayList<View> arrayList, C0370a<String, View> c0370a, View view) {
        return obj != null ? C0280w.m1616a(obj, fragment.m1210r(), arrayList, c0370a, view) : obj;
    }

    private void m1360a(int i, Fragment fragment, String str, int i2) {
        fragment.f735B = this.f895b;
        if (str != null) {
            if (fragment.f741H == null || str.equals(fragment.f741H)) {
                fragment.f741H = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f741H + " now " + str);
            }
        }
        if (i != 0) {
            if (fragment.f739F == 0 || fragment.f739F == i) {
                fragment.f739F = i;
                fragment.f740G = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f739F + " now " + i);
            }
        }
        C0248a c0248a = new C0248a();
        c0248a.f882c = i2;
        c0248a.f883d = fragment;
        m1387a(c0248a);
    }

    private void m1361a(C0249b c0249b, int i, Object obj) {
        if (this.f895b.f976g != null) {
            for (int i2 = 0; i2 < this.f895b.f976g.size(); i2++) {
                Fragment fragment = (Fragment) this.f895b.f976g.get(i2);
                if (!(fragment.f751R == null || fragment.f750Q == null || fragment.f740G != i)) {
                    if (!fragment.f742I) {
                        C0280w.m1624a(obj, fragment.f751R, false);
                        c0249b.f890b.remove(fragment.f751R);
                    } else if (!c0249b.f890b.contains(fragment.f751R)) {
                        C0280w.m1624a(obj, fragment.f751R, true);
                        c0249b.f890b.add(fragment.f751R);
                    }
                }
            }
        }
    }

    private void m1362a(C0249b c0249b, Fragment fragment, Fragment fragment2, boolean z, C0370a<String, View> c0370a) {
        ar arVar = z ? fragment2.ag : fragment.ag;
        if (arVar != null) {
            arVar.m1315b(new ArrayList(c0370a.keySet()), new ArrayList(c0370a.values()), null);
        }
    }

    private void m1363a(C0249b c0249b, C0370a<String, View> c0370a, boolean z) {
        int size = this.f915v == null ? 0 : this.f915v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f914u.get(i);
            View view = (View) c0370a.get((String) this.f915v.get(i));
            if (view != null) {
                String a = C0280w.m1618a(view);
                if (z) {
                    C0251i.m1370a(c0249b.f889a, str, a);
                } else {
                    C0251i.m1370a(c0249b.f889a, a, str);
                }
            }
        }
    }

    private void m1364a(C0249b c0249b, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        final View view2 = view;
        final Object obj2 = obj;
        final ArrayList<View> arrayList2 = arrayList;
        final C0249b c0249b2 = c0249b;
        final boolean z2 = z;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0251i f874h;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                if (obj2 != null) {
                    C0280w.m1626a(obj2, arrayList2);
                    arrayList2.clear();
                    C0370a a = this.f874h.m1354a(c0249b2, z2, fragment3);
                    C0280w.m1623a(obj2, c0249b2.f892d, (Map) a, arrayList2);
                    this.f874h.m1369a(a, c0249b2);
                    this.f874h.m1362a(c0249b2, fragment3, fragment4, z2, a);
                }
                return true;
            }
        });
    }

    private static void m1365a(C0249b c0249b, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0251i.m1370a(c0249b.f889a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m1369a(C0370a<String, View> c0370a, C0249b c0249b) {
        if (this.f915v != null && !c0370a.isEmpty()) {
            View view = (View) c0370a.get(this.f915v.get(0));
            if (view != null) {
                c0249b.f891c.f1026a = view;
            }
        }
    }

    private static void m1370a(C0370a<String, String> c0370a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0370a.size(); i++) {
                if (str.equals(c0370a.m1901c(i))) {
                    c0370a.m1896a(i, (Object) str2);
                    return;
                }
            }
            c0370a.put(str, str2);
        }
    }

    private static void m1371a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f740G;
            if (i != 0 && !fragment.m1208p()) {
                if (fragment.m1206n() && fragment.m1210r() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, fragment);
                }
                if (sparseArray2.get(i) == fragment) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m1372a(View view, C0249b c0249b, int i, Object obj) {
        final View view2 = view;
        final C0249b c0249b2 = c0249b;
        final int i2 = i;
        final Object obj2 = obj;
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ C0251i f879e;

            public boolean onPreDraw() {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f879e.m1361a(c0249b2, i2, obj2);
                return true;
            }
        });
    }

    private boolean m1373a(int i, C0249b c0249b, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view = (ViewGroup) this.f895b.f985p.mo167a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        C0244b c02451;
        ArrayList arrayList2;
        Map c0370a;
        boolean z2;
        Object a2;
        final Fragment fragment = (Fragment) sparseArray2.get(i);
        Fragment fragment2 = (Fragment) sparseArray.get(i);
        Object a3 = C0251i.m1358a(fragment, z);
        Object a4 = C0251i.m1357a(fragment, fragment2, z);
        Object b = C0251i.m1375b(fragment2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m1353a(c0249b, fragment2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0251i.m1359a(b, fragment2, arrayList, (C0370a) map, c0249b.f892d);
                if (!(this.f915v == null || map == null)) {
                    view2 = (View) map.get(this.f915v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            C0280w.m1622a(a, view2);
                        }
                        if (obj != null) {
                            C0280w.m1622a(obj, view2);
                        }
                    }
                }
                c02451 = new C0244b(this) {
                    final /* synthetic */ C0251i f866b;

                    public View mo186a() {
                        return fragment.m1210r();
                    }
                };
                arrayList2 = new ArrayList();
                c0370a = new C0370a();
                z2 = true;
                if (fragment != null) {
                    z2 = z ? fragment.m1143E() : fragment.m1142D();
                }
                a2 = C0280w.m1617a(a3, a, obj, z2);
                if (a2 != null) {
                    C0280w.m1625a(a3, obj, view, c02451, c0249b.f892d, c0249b.f891c, (Map) c0249b.f889a, arrayList2, map, c0370a, arrayList3);
                    m1372a(view, c0249b, i, a2);
                    C0280w.m1624a(a2, c0249b.f892d, true);
                    m1361a(c0249b, i, a2);
                    C0280w.m1621a((ViewGroup) view, a2);
                    C0280w.m1620a(view, c0249b.f892d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0249b.f890b, c0370a);
                }
                return a2 == null;
            } else {
                ar arVar = z ? fragment2.ag : fragment.ag;
                if (arVar != null) {
                    arVar.m1313a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
                }
                m1364a(c0249b, view, a4, fragment, fragment2, z, arrayList3);
            }
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0251i.m1359a(b, fragment2, arrayList, (C0370a) map, c0249b.f892d);
        view2 = (View) map.get(this.f915v.get(0));
        if (view2 != null) {
            if (a != null) {
                C0280w.m1622a(a, view2);
            }
            if (obj != null) {
                C0280w.m1622a(obj, view2);
            }
        }
        c02451 = /* anonymous class already generated */;
        arrayList2 = new ArrayList();
        c0370a = new C0370a();
        z2 = true;
        if (fragment != null) {
            if (z) {
            }
        }
        a2 = C0280w.m1617a(a3, a, obj, z2);
        if (a2 != null) {
            C0280w.m1625a(a3, obj, view, c02451, c0249b.f892d, c0249b.f891c, (Map) c0249b.f889a, arrayList2, map, c0370a, arrayList3);
            m1372a(view, c0249b, i, a2);
            C0280w.m1624a(a2, c0249b.f892d, true);
            m1361a(c0249b, i, a2);
            C0280w.m1621a((ViewGroup) view, a2);
            C0280w.m1620a(view, c0249b.f892d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0249b.f890b, c0370a);
        }
        if (a2 == null) {
        }
    }

    private C0370a<String, View> m1374b(C0249b c0249b, Fragment fragment, boolean z) {
        C0370a c0370a = new C0370a();
        View r = fragment.m1210r();
        if (r == null || this.f914u == null) {
            return c0370a;
        }
        C0280w.m1629a((Map) c0370a, r);
        if (z) {
            return C0251i.m1356a(this.f914u, this.f915v, c0370a);
        }
        c0370a.m1904a(this.f915v);
        return c0370a;
    }

    private static Object m1375b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return C0280w.m1615a(z ? fragment.m1217y() : fragment.m1218z());
    }

    private void m1376b(C0249b c0249b, C0370a<String, View> c0370a, boolean z) {
        int size = c0370a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0370a.m1900b(i);
            String a = C0280w.m1618a((View) c0370a.m1901c(i));
            if (z) {
                C0251i.m1370a(c0249b.f889a, str, a);
            } else {
                C0251i.m1370a(c0249b.f889a, a, str);
            }
        }
    }

    private void m1377b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f895b.f985p.mo168a()) {
            for (C0248a c0248a = this.f896c; c0248a != null; c0248a = c0248a.f880a) {
                switch (c0248a.f882c) {
                    case 1:
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 2:
                        Fragment fragment = c0248a.f883d;
                        if (this.f895b.f976g != null) {
                            Fragment fragment2 = fragment;
                            for (int i = 0; i < this.f895b.f976g.size(); i++) {
                                Fragment fragment3 = (Fragment) this.f895b.f976g.get(i);
                                if (fragment2 == null || fragment3.f740G == fragment2.f740G) {
                                    if (fragment3 == fragment2) {
                                        fragment2 = null;
                                        sparseArray2.remove(fragment3.f740G);
                                    } else {
                                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, fragment3);
                                    }
                                }
                            }
                        }
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 3:
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 4:
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 5:
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 6:
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 7:
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void m1378b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, Fragment fragment) {
        if (fragment != null) {
            int i = fragment.f740G;
            if (i != 0) {
                if (!fragment.m1206n()) {
                    sparseArray2.put(i, fragment);
                }
                if (sparseArray.get(i) == fragment) {
                    sparseArray.remove(i);
                }
            }
            if (fragment.f760k < 1 && this.f895b.f983n >= 1) {
                this.f895b.m1552d(fragment);
                this.f895b.m1531a(fragment, 1, 0, 0, false);
            }
        }
    }

    public int mo187a() {
        return m1380a(false);
    }

    int m1380a(boolean z) {
        if (this.f908o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0272s.f969a) {
            Log.v("FragmentManager", "Commit: " + this);
            m1389a("  ", null, new PrintWriter(new C0373d("FragmentManager")), null);
        }
        this.f908o = true;
        if (this.f905l) {
            this.f909p = this.f895b.m1515a(this);
        } else {
            this.f909p = -1;
        }
        this.f895b.m1534a((Runnable) this, z);
        return this.f909p;
    }

    public C0249b m1381a(boolean z, C0249b c0249b, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (C0272s.f969a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m1389a("  ", null, new PrintWriter(new C0373d("FragmentManager")), null);
        }
        if (f894a && this.f895b.f983n >= 1) {
            if (c0249b == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0249b = m1352a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0251i.m1365a(c0249b, this.f915v, this.f914u);
            }
        }
        m1386a(-1);
        int i = c0249b != null ? 0 : this.f904k;
        int i2 = c0249b != null ? 0 : this.f903j;
        C0248a c0248a = this.f897d;
        while (c0248a != null) {
            int i3 = c0249b != null ? 0 : c0248a.f886g;
            int i4 = c0249b != null ? 0 : c0248a.f887h;
            Fragment fragment;
            Fragment fragment2;
            switch (c0248a.f882c) {
                case 1:
                    fragment = c0248a.f883d;
                    fragment.f749P = i4;
                    this.f895b.m1530a(fragment, C0272s.m1513c(i2), i);
                    break;
                case 2:
                    fragment = c0248a.f883d;
                    if (fragment != null) {
                        fragment.f749P = i4;
                        this.f895b.m1530a(fragment, C0272s.m1513c(i2), i);
                    }
                    if (c0248a.f888i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0248a.f888i.size(); i5++) {
                        fragment2 = (Fragment) c0248a.f888i.get(i5);
                        fragment2.f749P = i3;
                        this.f895b.m1532a(fragment2, false);
                    }
                    break;
                case 3:
                    fragment2 = c0248a.f883d;
                    fragment2.f749P = i3;
                    this.f895b.m1532a(fragment2, false);
                    break;
                case 4:
                    fragment2 = c0248a.f883d;
                    fragment2.f749P = i3;
                    this.f895b.m1549c(fragment2, C0272s.m1513c(i2), i);
                    break;
                case 5:
                    fragment = c0248a.f883d;
                    fragment.f749P = i4;
                    this.f895b.m1543b(fragment, C0272s.m1513c(i2), i);
                    break;
                case 6:
                    fragment2 = c0248a.f883d;
                    fragment2.f749P = i3;
                    this.f895b.m1555e(fragment2, C0272s.m1513c(i2), i);
                    break;
                case 7:
                    fragment2 = c0248a.f883d;
                    fragment2.f749P = i3;
                    this.f895b.m1553d(fragment2, C0272s.m1513c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0248a.f882c);
            }
            c0248a = c0248a.f881b;
        }
        if (z) {
            this.f895b.m1524a(this.f895b.f983n, C0272s.m1513c(i2), i, true);
            c0249b = null;
        }
        if (this.f909p >= 0) {
            this.f895b.m1541b(this.f909p);
            this.f909p = -1;
        }
        return c0249b;
    }

    public C0250v mo188a(int i, Fragment fragment) {
        m1360a(i, fragment, null, 1);
        return this;
    }

    public C0250v mo189a(int i, Fragment fragment, String str) {
        m1360a(i, fragment, str, 1);
        return this;
    }

    public C0250v mo190a(Fragment fragment) {
        C0248a c0248a = new C0248a();
        c0248a.f882c = 3;
        c0248a.f883d = fragment;
        m1387a(c0248a);
        return this;
    }

    public C0250v mo191a(Fragment fragment, String str) {
        m1360a(0, fragment, str, 1);
        return this;
    }

    void m1386a(int i) {
        if (this.f905l) {
            if (C0272s.f969a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0248a c0248a = this.f896c; c0248a != null; c0248a = c0248a.f880a) {
                Fragment fragment;
                if (c0248a.f883d != null) {
                    fragment = c0248a.f883d;
                    fragment.f734A += i;
                    if (C0272s.f969a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0248a.f883d + " to " + c0248a.f883d.f734A);
                    }
                }
                if (c0248a.f888i != null) {
                    for (int size = c0248a.f888i.size() - 1; size >= 0; size--) {
                        fragment = (Fragment) c0248a.f888i.get(size);
                        fragment.f734A += i;
                        if (C0272s.f969a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f734A);
                        }
                    }
                }
            }
        }
    }

    void m1387a(C0248a c0248a) {
        if (this.f896c == null) {
            this.f897d = c0248a;
            this.f896c = c0248a;
        } else {
            c0248a.f881b = this.f897d;
            this.f897d.f880a = c0248a;
            this.f897d = c0248a;
        }
        c0248a.f884e = this.f899f;
        c0248a.f885f = this.f900g;
        c0248a.f886g = this.f901h;
        c0248a.f887h = this.f902i;
        this.f898e++;
    }

    public void m1388a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.f895b.f985p.mo168a()) {
            for (C0248a c0248a = this.f897d; c0248a != null; c0248a = c0248a.f881b) {
                switch (c0248a.f882c) {
                    case 1:
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 2:
                        if (c0248a.f888i != null) {
                            for (int size = c0248a.f888i.size() - 1; size >= 0; size--) {
                                m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, (Fragment) c0248a.f888i.get(size));
                            }
                        }
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 3:
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 4:
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 5:
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 6:
                        m1378b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    case 7:
                        C0251i.m1371a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0248a.f883d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m1389a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m1390a(str, printWriter, true);
    }

    public void m1390a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f907n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f909p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f908o);
            if (this.f903j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f903j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f904k));
            }
            if (!(this.f899f == 0 && this.f900g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f899f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f900g));
            }
            if (!(this.f901h == 0 && this.f902i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f901h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f902i));
            }
            if (!(this.f910q == 0 && this.f911r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f910q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f911r);
            }
            if (!(this.f912s == 0 && this.f913t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f912s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f913t);
            }
        }
        if (this.f896c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0248a c0248a = this.f896c;
            while (c0248a != null) {
                String str3;
                switch (c0248a.f882c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0248a.f882c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0248a.f883d);
                if (z) {
                    if (!(c0248a.f884e == 0 && c0248a.f885f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0248a.f884e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0248a.f885f));
                    }
                    if (!(c0248a.f886g == 0 && c0248a.f887h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0248a.f886g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0248a.f887h));
                    }
                }
                if (c0248a.f888i != null && c0248a.f888i.size() > 0) {
                    for (int i2 = 0; i2 < c0248a.f888i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0248a.f888i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0248a.f888i.get(i2));
                    }
                }
                c0248a = c0248a.f880a;
                i++;
            }
        }
    }

    public int mo192b() {
        return m1380a(true);
    }

    public C0250v mo193b(int i, Fragment fragment) {
        return m1393b(i, fragment, null);
    }

    public C0250v m1393b(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m1360a(i, fragment, str, 2);
        return this;
    }

    public C0250v mo194b(Fragment fragment) {
        C0248a c0248a = new C0248a();
        c0248a.f882c = 6;
        c0248a.f883d = fragment;
        m1387a(c0248a);
        return this;
    }

    public C0250v mo195c(Fragment fragment) {
        C0248a c0248a = new C0248a();
        c0248a.f882c = 7;
        c0248a.f883d = fragment;
        m1387a(c0248a);
        return this;
    }

    public String m1396c() {
        return this.f907n;
    }

    public void run() {
        if (C0272s.f969a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f905l || this.f909p >= 0) {
            C0249b c0249b;
            m1386a(1);
            if (!f894a || this.f895b.f983n < 1) {
                c0249b = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m1377b(sparseArray, sparseArray2);
                c0249b = m1352a(sparseArray, sparseArray2, false);
            }
            int i = c0249b != null ? 0 : this.f904k;
            int i2 = c0249b != null ? 0 : this.f903j;
            C0248a c0248a = this.f896c;
            while (c0248a != null) {
                int i3 = c0249b != null ? 0 : c0248a.f884e;
                int i4 = c0249b != null ? 0 : c0248a.f885f;
                Fragment fragment;
                switch (c0248a.f882c) {
                    case 1:
                        fragment = c0248a.f883d;
                        fragment.f749P = i3;
                        this.f895b.m1532a(fragment, false);
                        break;
                    case 2:
                        Fragment fragment2 = c0248a.f883d;
                        int i5 = fragment2.f740G;
                        if (this.f895b.f976g != null) {
                            int size = this.f895b.f976g.size() - 1;
                            while (size >= 0) {
                                fragment = (Fragment) this.f895b.f976g.get(size);
                                if (C0272s.f969a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment2 + " old=" + fragment);
                                }
                                if (fragment.f740G == i5) {
                                    if (fragment == fragment2) {
                                        fragment = null;
                                        c0248a.f883d = null;
                                        size--;
                                        fragment2 = fragment;
                                    } else {
                                        if (c0248a.f888i == null) {
                                            c0248a.f888i = new ArrayList();
                                        }
                                        c0248a.f888i.add(fragment);
                                        fragment.f749P = i4;
                                        if (this.f905l) {
                                            fragment.f734A++;
                                            if (C0272s.f969a) {
                                                Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.f734A);
                                            }
                                        }
                                        this.f895b.m1530a(fragment, i2, i);
                                    }
                                }
                                fragment = fragment2;
                                size--;
                                fragment2 = fragment;
                            }
                        }
                        if (fragment2 == null) {
                            break;
                        }
                        fragment2.f749P = i3;
                        this.f895b.m1532a(fragment2, false);
                        break;
                    case 3:
                        fragment = c0248a.f883d;
                        fragment.f749P = i4;
                        this.f895b.m1530a(fragment, i2, i);
                        break;
                    case 4:
                        fragment = c0248a.f883d;
                        fragment.f749P = i4;
                        this.f895b.m1543b(fragment, i2, i);
                        break;
                    case 5:
                        fragment = c0248a.f883d;
                        fragment.f749P = i3;
                        this.f895b.m1549c(fragment, i2, i);
                        break;
                    case 6:
                        fragment = c0248a.f883d;
                        fragment.f749P = i4;
                        this.f895b.m1553d(fragment, i2, i);
                        break;
                    case 7:
                        fragment = c0248a.f883d;
                        fragment.f749P = i3;
                        this.f895b.m1555e(fragment, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0248a.f882c);
                }
                c0248a = c0248a.f880a;
            }
            this.f895b.m1524a(this.f895b.f983n, i2, i, true);
            if (this.f905l) {
                this.f895b.m1544b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f909p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f909p);
        }
        if (this.f907n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f907n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
