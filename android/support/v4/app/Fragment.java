package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p015g.C0369j;
import android.support.v4.p015g.C0372c;
import android.support.v4.view.C0519i;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0369j<String, Class<?>> f732a = new C0369j();
    static final Object f733j = new Object();
    int f734A;
    C0272s f735B;
    C0257q f736C;
    C0272s f737D;
    Fragment f738E;
    int f739F;
    int f740G;
    String f741H;
    boolean f742I;
    boolean f743J;
    boolean f744K;
    boolean f745L;
    boolean f746M;
    boolean f747N = true;
    boolean f748O;
    int f749P;
    ViewGroup f750Q;
    View f751R;
    View f752S;
    boolean f753T;
    boolean f754U = true;
    C0286y f755V;
    boolean f756W;
    boolean f757X;
    Object f758Y = null;
    Object f759Z = f733j;
    Object aa = null;
    Object ab = f733j;
    Object ac = null;
    Object ad = f733j;
    Boolean ae;
    Boolean af;
    ar ag = null;
    ar ah = null;
    int f760k = 0;
    View f761l;
    int f762m;
    Bundle f763n;
    SparseArray<Parcelable> f764o;
    int f765p = -1;
    String f766q;
    Bundle f767r;
    Fragment f768s;
    int f769t = -1;
    int f770u;
    boolean f771v;
    boolean f772w;
    boolean f773x;
    boolean f774y;
    boolean f775z;

    class C01881 extends C0187o {
        final /* synthetic */ Fragment f730a;

        C01881(Fragment fragment) {
            this.f730a = fragment;
        }

        public View mo167a(int i) {
            if (this.f730a.f751R != null) {
                return this.f730a.f751R.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean mo168a() {
            return this.f730a.f751R != null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new C01891();
        final Bundle f731a;

        static class C01891 implements Creator<SavedState> {
            C01891() {
            }

            public SavedState m1134a(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            public SavedState[] m1135a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m1134a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m1135a(i);
            }
        }

        SavedState(Bundle bundle) {
            this.f731a = bundle;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f731a = parcel.readBundle();
            if (classLoader != null && this.f731a != null) {
                this.f731a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f731a);
        }
    }

    public static class C0190a extends RuntimeException {
        public C0190a(String str, Exception exception) {
            super(str, exception);
        }
    }

    public static Fragment m1136a(Context context, String str) {
        return m1137a(context, str, null);
    }

    public static Fragment m1137a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f732a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f732a.put(str, cls);
            }
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.f767r = bundle;
            }
            return fragment;
        } catch (Exception e) {
            throw new C0190a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0190a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0190a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean m1138b(Context context, String str) {
        try {
            Class cls = (Class) f732a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f732a.put(str, cls);
            }
            return Fragment.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public Object m1139A() {
        return this.ab == f733j ? m1218z() : this.ab;
    }

    public Object m1140B() {
        return this.ac;
    }

    public Object m1141C() {
        return this.ad == f733j ? m1140B() : this.ad;
    }

    public boolean m1142D() {
        return this.af == null ? true : this.af.booleanValue();
    }

    public boolean m1143E() {
        return this.ae == null ? true : this.ae.booleanValue();
    }

    void m1144F() {
        this.f737D = new C0272s();
        this.f737D.m1533a(this.f736C, new C01881(this), this);
    }

    void m1145G() {
        if (this.f737D != null) {
            this.f737D.m1562i();
            this.f737D.m1556e();
        }
        this.f760k = 4;
        this.f748O = false;
        mo201d();
        if (this.f748O) {
            if (this.f737D != null) {
                this.f737D.m1565l();
            }
            if (this.f755V != null) {
                this.f755V.m1659g();
                return;
            }
            return;
        }
        throw new as("Fragment " + this + " did not call through to super.onStart()");
    }

    void m1146H() {
        if (this.f737D != null) {
            this.f737D.m1562i();
            this.f737D.m1556e();
        }
        this.f760k = 5;
        this.f748O = false;
        m1211s();
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.f737D != null) {
            this.f737D.m1566m();
            this.f737D.m1556e();
        }
    }

    void m1147I() {
        onLowMemory();
        if (this.f737D != null) {
            this.f737D.m1572s();
        }
    }

    void m1148J() {
        if (this.f737D != null) {
            this.f737D.m1567n();
        }
        this.f760k = 4;
        this.f748O = false;
        m1212t();
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void m1149K() {
        if (this.f737D != null) {
            this.f737D.m1568o();
        }
        this.f760k = 3;
        this.f748O = false;
        mo203e();
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    void m1150L() {
        if (this.f737D != null) {
            this.f737D.m1569p();
        }
        this.f760k = 2;
        if (this.f756W) {
            this.f756W = false;
            if (!this.f757X) {
                this.f757X = true;
                this.f755V = this.f736C.m1414a(this.f766q, this.f756W, false);
            }
            if (this.f755V == null) {
                return;
            }
            if (this.f736C.m1433j()) {
                this.f755V.m1656d();
            } else {
                this.f755V.m1655c();
            }
        }
    }

    void m1151M() {
        if (this.f737D != null) {
            this.f737D.m1570q();
        }
        this.f760k = 1;
        this.f748O = false;
        mo205f();
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.f755V != null) {
            this.f755V.m1658f();
        }
    }

    void m1152N() {
        if (this.f737D != null) {
            this.f737D.m1571r();
        }
        this.f760k = 0;
        this.f748O = false;
        m1213u();
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    Fragment m1153a(String str) {
        return str.equals(this.f766q) ? this : this.f737D != null ? this.f737D.m1540b(str) : null;
    }

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public Animation m1155a(int i, boolean z, int i2) {
        return null;
    }

    public void mo1619a(int i, int i2, Intent intent) {
    }

    final void m1157a(int i, Fragment fragment) {
        this.f765p = i;
        if (fragment != null) {
            this.f766q = fragment.f766q + ":" + this.f765p;
        } else {
            this.f766q = "android:fragment:" + this.f765p;
        }
    }

    public void m1158a(int i, String[] strArr, int[] iArr) {
    }

    @Deprecated
    public void mo197a(Activity activity) {
        this.f748O = true;
    }

    @Deprecated
    public void m1160a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f748O = true;
    }

    public void m1161a(Context context) {
        this.f748O = true;
        Activity f = this.f736C == null ? null : this.f736C.m1429f();
        if (f != null) {
            this.f748O = false;
            mo197a(f);
        }
    }

    public void m1162a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f748O = true;
        Activity f = this.f736C == null ? null : this.f736C.m1429f();
        if (f != null) {
            this.f748O = false;
            m1160a(f, attributeSet, bundle);
        }
    }

    public void m1163a(Intent intent) {
        m1165a(intent, null);
    }

    public void m1164a(Intent intent, int i, Bundle bundle) {
        if (this.f736C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f736C.mo206a(this, intent, i, bundle);
    }

    public void m1165a(Intent intent, Bundle bundle) {
        if (this.f736C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f736C.mo206a(this, intent, -1, bundle);
    }

    void m1166a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f737D != null) {
            this.f737D.m1527a(configuration);
        }
    }

    public void mo198a(Bundle bundle) {
        this.f748O = true;
    }

    public void m1168a(SavedState savedState) {
        if (this.f765p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (savedState == null || savedState.f731a == null) ? null : savedState.f731a;
        this.f763n = bundle;
    }

    public void m1169a(Menu menu) {
    }

    public void m1170a(Menu menu, MenuInflater menuInflater) {
    }

    public void mo1787a(View view, Bundle bundle) {
    }

    public void mo1620a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f739F));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f740G));
        printWriter.print(" mTag=");
        printWriter.println(this.f741H);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f760k);
        printWriter.print(" mIndex=");
        printWriter.print(this.f765p);
        printWriter.print(" mWho=");
        printWriter.print(this.f766q);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f734A);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f771v);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f772w);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f773x);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f774y);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f742I);
        printWriter.print(" mDetached=");
        printWriter.print(this.f743J);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f747N);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f746M);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f744K);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f745L);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f754U);
        if (this.f735B != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f735B);
        }
        if (this.f736C != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f736C);
        }
        if (this.f738E != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f738E);
        }
        if (this.f767r != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f767r);
        }
        if (this.f763n != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f763n);
        }
        if (this.f764o != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f764o);
        }
        if (this.f768s != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f768s);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f770u);
        }
        if (this.f749P != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.f749P);
        }
        if (this.f750Q != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f750Q);
        }
        if (this.f751R != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f751R);
        }
        if (this.f752S != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f751R);
        }
        if (this.f761l != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.f761l);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.f762m);
        }
        if (this.f755V != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f755V.m1652a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f737D != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f737D + ":");
            this.f737D.mo228a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public boolean m1173a(MenuItem menuItem) {
        return false;
    }

    public LayoutInflater mo199b(Bundle bundle) {
        LayoutInflater b = this.f736C.mo209b();
        m1205m();
        C0519i.m2821a(b, this.f737D.m1573t());
        return b;
    }

    View m1175b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f737D != null) {
            this.f737D.m1562i();
        }
        return mo1786a(layoutInflater, viewGroup, bundle);
    }

    public void m1176b(Menu menu) {
    }

    boolean m1177b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f742I) {
            return false;
        }
        if (this.f746M && this.f747N) {
            z = true;
            m1170a(menu, menuInflater);
        }
        return this.f737D != null ? z | this.f737D.m1538a(menu, menuInflater) : z;
    }

    public boolean m1178b(MenuItem menuItem) {
        return false;
    }

    public void mo200c() {
        this.f748O = true;
    }

    public void m1180c(boolean z) {
    }

    boolean m1181c(Menu menu) {
        boolean z = false;
        if (this.f742I) {
            return false;
        }
        if (this.f746M && this.f747N) {
            z = true;
            m1169a(menu);
        }
        return this.f737D != null ? z | this.f737D.m1537a(menu) : z;
    }

    boolean m1182c(MenuItem menuItem) {
        if (!this.f742I) {
            if (this.f746M && this.f747N && m1173a(menuItem)) {
                return true;
            }
            if (this.f737D != null && this.f737D.m1539a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void mo201d() {
        this.f748O = true;
        if (!this.f756W) {
            this.f756W = true;
            if (!this.f757X) {
                this.f757X = true;
                this.f755V = this.f736C.m1414a(this.f766q, this.f756W, false);
            }
            if (this.f755V != null) {
                this.f755V.m1654b();
            }
        }
    }

    public void mo202d(Bundle bundle) {
        this.f748O = true;
    }

    void m1185d(Menu menu) {
        if (!this.f742I) {
            if (this.f746M && this.f747N) {
                m1176b(menu);
            }
            if (this.f737D != null) {
                this.f737D.m1545b(menu);
            }
        }
    }

    public void m1186d(boolean z) {
        if (!z || this.f738E == null) {
            this.f744K = z;
            return;
        }
        throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
    }

    boolean m1187d(MenuItem menuItem) {
        if (!this.f742I) {
            if (m1178b(menuItem)) {
                return true;
            }
            if (this.f737D != null && this.f737D.m1547b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void mo203e() {
        this.f748O = true;
    }

    public void mo204e(Bundle bundle) {
    }

    public void m1190e(boolean z) {
        if (this.f747N != z) {
            this.f747N = z;
            if (this.f746M && m1206n() && !m1208p()) {
                this.f736C.mo211c();
            }
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void mo205f() {
        this.f748O = true;
    }

    final void m1192f(Bundle bundle) {
        if (this.f764o != null) {
            this.f752S.restoreHierarchyState(this.f764o);
            this.f764o = null;
        }
        this.f748O = false;
        m1197h(bundle);
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void m1193f(boolean z) {
        if (!this.f754U && z && this.f760k < 4) {
            this.f735B.m1542b(this);
        }
        this.f754U = z;
        this.f753T = !z;
    }

    public void m1194g(Bundle bundle) {
        if (this.f765p >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f767r = bundle;
    }

    final boolean m1195g() {
        return this.f734A > 0;
    }

    public final Bundle m1196h() {
        return this.f767r;
    }

    public void m1197h(Bundle bundle) {
        this.f748O = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public Context m1198i() {
        return this.f736C == null ? null : this.f736C.m1430g();
    }

    void m1199i(Bundle bundle) {
        if (this.f737D != null) {
            this.f737D.m1562i();
        }
        this.f760k = 1;
        this.f748O = false;
        mo198a(bundle);
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onCreate()");
        } else if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.f737D == null) {
                    m1144F();
                }
                this.f737D.m1529a(parcelable, null);
                this.f737D.m1563j();
            }
        }
    }

    public final C0260n m1200j() {
        return this.f736C == null ? null : (C0260n) this.f736C.m1429f();
    }

    void m1201j(Bundle bundle) {
        if (this.f737D != null) {
            this.f737D.m1562i();
        }
        this.f760k = 2;
        this.f748O = false;
        mo202d(bundle);
        if (!this.f748O) {
            throw new as("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.f737D != null) {
            this.f737D.m1564k();
        }
    }

    public final Resources m1202k() {
        if (this.f736C != null) {
            return this.f736C.m1430g().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    void m1203k(Bundle bundle) {
        mo204e(bundle);
        if (this.f737D != null) {
            Parcelable h = this.f737D.m1561h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    public final C0263r m1204l() {
        return this.f735B;
    }

    public final C0263r m1205m() {
        if (this.f737D == null) {
            m1144F();
            if (this.f760k >= 5) {
                this.f737D.m1566m();
            } else if (this.f760k >= 4) {
                this.f737D.m1565l();
            } else if (this.f760k >= 2) {
                this.f737D.m1564k();
            } else if (this.f760k >= 1) {
                this.f737D.m1563j();
            }
        }
        return this.f737D;
    }

    public final boolean m1206n() {
        return this.f736C != null && this.f771v;
    }

    public final boolean m1207o() {
        return this.f772w;
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f748O = true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        m1200j().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onLowMemory() {
        this.f748O = true;
    }

    public final boolean m1208p() {
        return this.f742I;
    }

    public final boolean m1209q() {
        return this.f744K;
    }

    public View m1210r() {
        return this.f751R;
    }

    public void m1211s() {
        this.f748O = true;
    }

    public void startActivityForResult(Intent intent, int i) {
        m1164a(intent, i, null);
    }

    public void m1212t() {
        this.f748O = true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0372c.m1911a(this, stringBuilder);
        if (this.f765p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f765p);
        }
        if (this.f739F != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f739F));
        }
        if (this.f741H != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f741H);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void m1213u() {
        this.f748O = true;
        if (!this.f757X) {
            this.f757X = true;
            this.f755V = this.f736C.m1414a(this.f766q, this.f756W, false);
        }
        if (this.f755V != null) {
            this.f755V.m1660h();
        }
    }

    void m1214v() {
        this.f765p = -1;
        this.f766q = null;
        this.f771v = false;
        this.f772w = false;
        this.f773x = false;
        this.f774y = false;
        this.f775z = false;
        this.f734A = 0;
        this.f735B = null;
        this.f737D = null;
        this.f736C = null;
        this.f739F = 0;
        this.f740G = 0;
        this.f741H = null;
        this.f742I = false;
        this.f743J = false;
        this.f745L = false;
        this.f755V = null;
        this.f756W = false;
        this.f757X = false;
    }

    public void m1215w() {
    }

    public Object m1216x() {
        return this.f758Y;
    }

    public Object m1217y() {
        return this.f759Z == f733j ? m1216x() : this.f759Z;
    }

    public Object m1218z() {
        return this.aa;
    }
}
