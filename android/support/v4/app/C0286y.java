package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.C0282x.C0281a;
import android.support.v4.p010b.C0303h;
import android.support.v4.p010b.C0303h.C0283a;
import android.support.v4.p010b.C0303h.C0284b;
import android.support.v4.p015g.C0372c;
import android.support.v4.p015g.C0386k;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class C0286y extends C0282x {
    static boolean f1042a = false;
    final C0386k<C0285a> f1043b = new C0386k();
    final C0386k<C0285a> f1044c = new C0386k();
    final String f1045d;
    boolean f1046e;
    boolean f1047f;
    private C0257q f1048g;

    final class C0285a implements C0283a<Object>, C0284b<Object> {
        final int f1027a;
        final Bundle f1028b;
        C0281a<Object> f1029c;
        C0303h<Object> f1030d;
        boolean f1031e;
        boolean f1032f;
        Object f1033g;
        boolean f1034h;
        boolean f1035i;
        boolean f1036j;
        boolean f1037k;
        boolean f1038l;
        boolean f1039m;
        C0285a f1040n;
        final /* synthetic */ C0286y f1041o;

        void m1642a() {
            if (this.f1035i && this.f1036j) {
                this.f1034h = true;
            } else if (!this.f1034h) {
                this.f1034h = true;
                if (C0286y.f1042a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f1030d == null && this.f1029c != null) {
                    this.f1030d = this.f1029c.m1638a(this.f1027a, this.f1028b);
                }
                if (this.f1030d == null) {
                    return;
                }
                if (!this.f1030d.getClass().isMemberClass() || Modifier.isStatic(this.f1030d.getClass().getModifiers())) {
                    if (!this.f1039m) {
                        this.f1030d.m1694a(this.f1027a, this);
                        this.f1030d.m1695a((C0283a) this);
                        this.f1039m = true;
                    }
                    this.f1030d.m1693a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f1030d);
            }
        }

        void m1643a(C0303h<Object> c0303h, Object obj) {
            String str;
            if (this.f1029c != null) {
                if (this.f1041o.f1048g != null) {
                    String str2 = this.f1041o.f1048g.f929d.f990v;
                    this.f1041o.f1048g.f929d.f990v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (C0286y.f1042a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0303h + ": " + c0303h.m1692a(obj));
                    }
                    this.f1029c.m1640a((C0303h) c0303h, obj);
                    this.f1032f = true;
                } finally {
                    if (this.f1041o.f1048g != null) {
                        this.f1041o.f1048g.f929d.f990v = str;
                    }
                }
            }
        }

        public void m1644a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f1027a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f1028b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f1029c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f1030d);
            if (this.f1030d != null) {
                this.f1030d.m1697a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f1031e || this.f1032f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f1031e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f1032f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f1033g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1034h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f1037k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f1038l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f1035i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f1036j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f1039m);
            if (this.f1040n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f1040n);
                printWriter.println(":");
                this.f1040n.m1644a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        void m1645b() {
            if (C0286y.f1042a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f1035i = true;
            this.f1036j = this.f1034h;
            this.f1034h = false;
            this.f1029c = null;
        }

        void m1646c() {
            if (this.f1035i) {
                if (C0286y.f1042a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f1035i = false;
                if (!(this.f1034h == this.f1036j || this.f1034h)) {
                    m1648e();
                }
            }
            if (this.f1034h && this.f1031e && !this.f1037k) {
                m1643a(this.f1030d, this.f1033g);
            }
        }

        void m1647d() {
            if (this.f1034h && this.f1037k) {
                this.f1037k = false;
                if (this.f1031e) {
                    m1643a(this.f1030d, this.f1033g);
                }
            }
        }

        void m1648e() {
            if (C0286y.f1042a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f1034h = false;
            if (!this.f1035i && this.f1030d != null && this.f1039m) {
                this.f1039m = false;
                this.f1030d.m1696a((C0284b) this);
                this.f1030d.m1699b(this);
                this.f1030d.m1700c();
            }
        }

        void m1649f() {
            String str;
            C0281a c0281a = null;
            if (C0286y.f1042a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f1038l = true;
            boolean z = this.f1032f;
            this.f1032f = false;
            if (this.f1029c != null && this.f1030d != null && this.f1031e && z) {
                if (C0286y.f1042a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f1041o.f1048g != null) {
                    String str2 = this.f1041o.f1048g.f929d.f990v;
                    this.f1041o.f1048g.f929d.f990v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f1029c.m1639a(this.f1030d);
                } finally {
                    c0281a = this.f1041o.f1048g;
                    if (c0281a != null) {
                        c0281a = this.f1041o.f1048g.f929d;
                        c0281a.f990v = str;
                    }
                }
            }
            this.f1029c = c0281a;
            this.f1033g = c0281a;
            this.f1031e = false;
            if (this.f1030d != null) {
                if (this.f1039m) {
                    this.f1039m = false;
                    this.f1030d.m1696a((C0284b) this);
                    this.f1030d.m1699b(this);
                }
                this.f1030d.m1702e();
            }
            if (this.f1040n != null) {
                this.f1040n.m1649f();
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f1027a);
            stringBuilder.append(" : ");
            C0372c.m1911a(this.f1030d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    C0286y(String str, C0257q c0257q, boolean z) {
        this.f1045d = str;
        this.f1048g = c0257q;
        this.f1046e = z;
    }

    void m1651a(C0257q c0257q) {
        this.f1048g = c0257q;
    }

    public void m1652a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f1043b.m1946b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f1043b.m1946b(); i2++) {
                C0285a c0285a = (C0285a) this.f1043b.m1952e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f1043b.m1951d(i2));
                printWriter.print(": ");
                printWriter.println(c0285a.toString());
                c0285a.m1644a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f1044c.m1946b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f1044c.m1946b()) {
                c0285a = (C0285a) this.f1044c.m1952e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f1044c.m1951d(i));
                printWriter.print(": ");
                printWriter.println(c0285a.toString());
                c0285a.m1644a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean mo239a() {
        int b = this.f1043b.m1946b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            C0285a c0285a = (C0285a) this.f1043b.m1952e(i);
            int i2 = (!c0285a.f1034h || c0285a.f1032f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m1654b() {
        if (f1042a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f1046e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f1046e = true;
        for (int b = this.f1043b.m1946b() - 1; b >= 0; b--) {
            ((C0285a) this.f1043b.m1952e(b)).m1642a();
        }
    }

    void m1655c() {
        if (f1042a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f1046e) {
            for (int b = this.f1043b.m1946b() - 1; b >= 0; b--) {
                ((C0285a) this.f1043b.m1952e(b)).m1648e();
            }
            this.f1046e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m1656d() {
        if (f1042a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f1046e) {
            this.f1047f = true;
            this.f1046e = false;
            for (int b = this.f1043b.m1946b() - 1; b >= 0; b--) {
                ((C0285a) this.f1043b.m1952e(b)).m1645b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m1657e() {
        if (this.f1047f) {
            if (f1042a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f1047f = false;
            for (int b = this.f1043b.m1946b() - 1; b >= 0; b--) {
                ((C0285a) this.f1043b.m1952e(b)).m1646c();
            }
        }
    }

    void m1658f() {
        for (int b = this.f1043b.m1946b() - 1; b >= 0; b--) {
            ((C0285a) this.f1043b.m1952e(b)).f1037k = true;
        }
    }

    void m1659g() {
        for (int b = this.f1043b.m1946b() - 1; b >= 0; b--) {
            ((C0285a) this.f1043b.m1952e(b)).m1647d();
        }
    }

    void m1660h() {
        int b;
        if (!this.f1047f) {
            if (f1042a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f1043b.m1946b() - 1; b >= 0; b--) {
                ((C0285a) this.f1043b.m1952e(b)).m1649f();
            }
            this.f1043b.m1949c();
        }
        if (f1042a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f1044c.m1946b() - 1; b >= 0; b--) {
            ((C0285a) this.f1044c.m1952e(b)).m1649f();
        }
        this.f1044c.m1949c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0372c.m1911a(this.f1048g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
