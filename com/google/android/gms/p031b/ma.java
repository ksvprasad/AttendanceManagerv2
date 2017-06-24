package com.google.android.gms.p031b;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.internal.C1896c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ma extends md {
    private final SparseArray<C1734a> f5847e = new SparseArray();

    private class C1734a implements C1733c {
        public final int f5836a;
        public final C1767c f5837b;
        public final C1733c f5838c;
        final /* synthetic */ ma f5839d;

        public C1734a(ma maVar, int i, C1767c c1767c, C1733c c1733c) {
            this.f5839d = maVar;
            this.f5836a = i;
            this.f5837b = c1767c;
            this.f5838c = c1733c;
            c1767c.mo1608a((C1733c) this);
        }

        public void m9749a() {
            this.f5837b.mo1613b((C1733c) this);
            this.f5837b.mo1614c();
        }

        public void mo1564a(ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            this.f5839d.m9768b(connectionResult, this.f5836a);
        }

        public void m9751a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.f5836a);
            printWriter.println(":");
            this.f5837b.mo1609a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }
    }

    private ma(mw mwVar) {
        super(mwVar);
        this.d.mo1618a("AutoManageHelper", (mv) this);
    }

    public static ma m9771a(mu muVar) {
        mw b = mv.m9752b(muVar);
        ma maVar = (ma) b.mo1617a("AutoManageHelper", ma.class);
        return maVar != null ? maVar : new ma(b);
    }

    public void mo1565a() {
        super.mo1565a();
        boolean z = this.a;
        String valueOf = String.valueOf(this.f5847e);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.b) {
            for (int i = 0; i < this.f5847e.size(); i++) {
                ((C1734a) this.f5847e.valueAt(i)).f5837b.mo1611b();
            }
        }
    }

    public void m9773a(int i) {
        C1734a c1734a = (C1734a) this.f5847e.get(i);
        this.f5847e.remove(i);
        if (c1734a != null) {
            c1734a.m9749a();
        }
    }

    public void m9774a(int i, C1767c c1767c, C1733c c1733c) {
        C1896c.m10791a((Object) c1767c, (Object) "GoogleApiClient instance cannot be null");
        C1896c.m10795a(this.f5847e.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        Log.d("AutoManageHelper", "starting AutoManage for client " + i + " " + this.a + " " + this.b);
        this.f5847e.put(i, new C1734a(this, i, c1767c, c1733c));
        if (this.a && !this.b) {
            String valueOf = String.valueOf(c1767c);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            c1767c.mo1611b();
        }
    }

    protected void mo1570a(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C1734a c1734a = (C1734a) this.f5847e.get(i);
        if (c1734a != null) {
            m9773a(i);
            C1733c c1733c = c1734a.f5838c;
            if (c1733c != null) {
                c1733c.mo1564a(connectionResult);
            }
        }
    }

    public void mo1571a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f5847e.size(); i++) {
            ((C1734a) this.f5847e.valueAt(i)).m9751a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public void mo1568b() {
        super.mo1568b();
        for (int i = 0; i < this.f5847e.size(); i++) {
            ((C1734a) this.f5847e.valueAt(i)).f5837b.mo1614c();
        }
    }

    protected void mo1572c() {
        for (int i = 0; i < this.f5847e.size(); i++) {
            ((C1734a) this.f5847e.valueAt(i)).f5837b.mo1611b();
        }
    }
}
