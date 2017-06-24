package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p015g.C0369j;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class C0257q<E> extends C0187o {
    private final Activity f926a;
    final Context f927b;
    final int f928c;
    final C0272s f929d;
    private final Handler f930e;
    private C0369j<String, C0282x> f931f;
    private boolean f932g;
    private C0286y f933h;
    private boolean f934i;
    private boolean f935j;

    C0257q(Activity activity, Context context, Handler handler, int i) {
        this.f929d = new C0272s();
        this.f926a = activity;
        this.f927b = context;
        this.f930e = handler;
        this.f928c = i;
    }

    C0257q(C0260n c0260n) {
        this(c0260n, c0260n, c0260n.f940a, 0);
    }

    C0286y m1414a(String str, boolean z, boolean z2) {
        if (this.f931f == null) {
            this.f931f = new C0369j();
        }
        C0286y c0286y = (C0286y) this.f931f.get(str);
        if (c0286y != null) {
            c0286y.m1651a(this);
            return c0286y;
        } else if (!z2) {
            return c0286y;
        } else {
            c0286y = new C0286y(str, this, z);
            this.f931f.put(str, c0286y);
            return c0286y;
        }
    }

    public View mo167a(int i) {
        return null;
    }

    public void mo206a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f927b.startActivity(intent);
    }

    void m1417a(C0369j<String, C0282x> c0369j) {
        this.f931f = c0369j;
    }

    void m1418a(String str) {
        if (this.f931f != null) {
            C0286y c0286y = (C0286y) this.f931f.get(str);
            if (c0286y != null && !c0286y.f1047f) {
                c0286y.m1660h();
                this.f931f.remove(str);
            }
        }
    }

    public void mo207a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void m1420a(boolean z) {
        this.f932g = z;
        if (this.f933h != null && this.f935j) {
            this.f935j = false;
            if (z) {
                this.f933h.m1656d();
            } else {
                this.f933h.m1655c();
            }
        }
    }

    public boolean mo168a() {
        return true;
    }

    public boolean mo208a(Fragment fragment) {
        return true;
    }

    public LayoutInflater mo209b() {
        return (LayoutInflater) this.f927b.getSystemService("layout_inflater");
    }

    void mo210b(Fragment fragment) {
    }

    void m1425b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f935j);
        if (this.f933h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f933h)));
            printWriter.println(":");
            this.f933h.m1652a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void mo211c() {
    }

    public boolean mo212d() {
        return true;
    }

    public int mo213e() {
        return this.f928c;
    }

    Activity m1429f() {
        return this.f926a;
    }

    Context m1430g() {
        return this.f927b;
    }

    Handler m1431h() {
        return this.f930e;
    }

    C0272s m1432i() {
        return this.f929d;
    }

    boolean m1433j() {
        return this.f932g;
    }

    void m1434k() {
        if (!this.f935j) {
            this.f935j = true;
            if (this.f933h != null) {
                this.f933h.m1654b();
            } else if (!this.f934i) {
                this.f933h = m1414a("(root)", this.f935j, false);
                if (!(this.f933h == null || this.f933h.f1046e)) {
                    this.f933h.m1654b();
                }
            }
            this.f934i = true;
        }
    }

    void m1435l() {
        if (this.f933h != null) {
            this.f933h.m1660h();
        }
    }

    void m1436m() {
        if (this.f931f != null) {
            int size = this.f931f.size();
            C0286y[] c0286yArr = new C0286y[size];
            for (int i = size - 1; i >= 0; i--) {
                c0286yArr[i] = (C0286y) this.f931f.m1901c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                C0286y c0286y = c0286yArr[i2];
                c0286y.m1657e();
                c0286y.m1659g();
            }
        }
    }

    C0369j<String, C0282x> m1437n() {
        int i;
        int i2 = 0;
        if (this.f931f != null) {
            int size = this.f931f.size();
            C0286y[] c0286yArr = new C0286y[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                c0286yArr[i3] = (C0286y) this.f931f.m1901c(i3);
            }
            i = 0;
            while (i2 < size) {
                C0286y c0286y = c0286yArr[i2];
                if (c0286y.f1047f) {
                    i = 1;
                } else {
                    c0286y.m1660h();
                    this.f931f.remove(c0286y.f1045d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f931f : null;
    }
}
