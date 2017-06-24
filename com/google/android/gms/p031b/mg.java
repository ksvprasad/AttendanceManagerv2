package com.google.android.gms.p031b;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.p015g.C0370a;
import android.util.Log;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.mt.C1744a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

final class mg implements mt {
    private final Context f5860a;
    private final ml f5861b;
    private final Looper f5862c;
    private final mo f5863d;
    private final mo f5864e;
    private final Map<C1859d<?>, mo> f5865f;
    private final Set<nd> f5866g = Collections.newSetFromMap(new WeakHashMap());
    private final C1722f f5867h;
    private Bundle f5868i;
    private ConnectionResult f5869j = null;
    private ConnectionResult f5870k = null;
    private boolean f5871l = false;
    private final Lock f5872m;
    private int f5873n = 0;

    class C17431 implements Runnable {
        final /* synthetic */ mg f5857a;

        public void run() {
            this.f5857a.f5872m.lock();
            try {
                this.f5857a.m9831g();
            } finally {
                this.f5857a.f5872m.unlock();
            }
        }
    }

    private class C1745a implements C1744a {
        final /* synthetic */ mg f5858a;

        private C1745a(mg mgVar) {
            this.f5858a = mgVar;
        }

        public void mo1576a(int i, boolean z) {
            this.f5858a.f5872m.lock();
            try {
                if (this.f5858a.f5871l || this.f5858a.f5870k == null || !this.f5858a.f5870k.m10547b()) {
                    this.f5858a.f5871l = false;
                    this.f5858a.m9816a(i, z);
                    return;
                }
                this.f5858a.f5871l = true;
                this.f5858a.f5864e.m9991a(i);
                this.f5858a.f5872m.unlock();
            } finally {
                this.f5858a.f5872m.unlock();
            }
        }

        public void mo1577a(Bundle bundle) {
            this.f5858a.f5872m.lock();
            try {
                this.f5858a.m9817a(bundle);
                this.f5858a.f5869j = ConnectionResult.f6323a;
                this.f5858a.m9831g();
            } finally {
                this.f5858a.f5872m.unlock();
            }
        }

        public void mo1578a(ConnectionResult connectionResult) {
            this.f5858a.f5872m.lock();
            try {
                this.f5858a.f5869j = connectionResult;
                this.f5858a.m9831g();
            } finally {
                this.f5858a.f5872m.unlock();
            }
        }
    }

    private class C1746b implements C1744a {
        final /* synthetic */ mg f5859a;

        private C1746b(mg mgVar) {
            this.f5859a = mgVar;
        }

        public void mo1576a(int i, boolean z) {
            this.f5859a.f5872m.lock();
            try {
                if (this.f5859a.f5871l) {
                    this.f5859a.f5871l = false;
                    this.f5859a.m9816a(i, z);
                    return;
                }
                this.f5859a.f5871l = true;
                this.f5859a.f5863d.m9991a(i);
                this.f5859a.f5872m.unlock();
            } finally {
                this.f5859a.f5872m.unlock();
            }
        }

        public void mo1577a(Bundle bundle) {
            this.f5859a.f5872m.lock();
            try {
                this.f5859a.f5870k = ConnectionResult.f6323a;
                this.f5859a.m9831g();
            } finally {
                this.f5859a.f5872m.unlock();
            }
        }

        public void mo1578a(ConnectionResult connectionResult) {
            this.f5859a.f5872m.lock();
            try {
                this.f5859a.f5870k = connectionResult;
                this.f5859a.m9831g();
            } finally {
                this.f5859a.f5872m.unlock();
            }
        }
    }

    private mg(Context context, ml mlVar, Lock lock, Looper looper, C1876j c1876j, Map<C1859d<?>, C1722f> map, Map<C1859d<?>, C1722f> map2, C1927n c1927n, C1827b<? extends oa, ob> c1827b, C1722f c1722f, ArrayList<mf> arrayList, ArrayList<mf> arrayList2, Map<C1864a<?>, Integer> map3, Map<C1864a<?>, Integer> map4) {
        this.f5860a = context;
        this.f5861b = mlVar;
        this.f5872m = lock;
        this.f5862c = looper;
        this.f5867h = c1722f;
        this.f5863d = new mo(context, this.f5861b, lock, looper, c1876j, map2, null, map4, null, arrayList2, new C1745a());
        this.f5864e = new mo(context, this.f5861b, lock, looper, c1876j, map, c1927n, map3, c1827b, arrayList, new C1746b());
        Map c0370a = new C0370a();
        for (C1859d put : map2.keySet()) {
            c0370a.put(put, this.f5863d);
        }
        for (C1859d put2 : map.keySet()) {
            c0370a.put(put2, this.f5864e);
        }
        this.f5865f = Collections.unmodifiableMap(c0370a);
    }

    public static mg m9813a(Context context, ml mlVar, Lock lock, Looper looper, C1876j c1876j, Map<C1859d<?>, C1722f> map, C1927n c1927n, Map<C1864a<?>, Integer> map2, C1827b<? extends oa, ob> c1827b, ArrayList<mf> arrayList) {
        C1722f c1722f = null;
        Map c0370a = new C0370a();
        Map c0370a2 = new C0370a();
        for (Entry entry : map.entrySet()) {
            C1722f c1722f2 = (C1722f) entry.getValue();
            if (c1722f2.m9696h()) {
                c1722f = c1722f2;
            }
            if (c1722f2.mo1772f()) {
                c0370a.put((C1859d) entry.getKey(), c1722f2);
            } else {
                c0370a2.put((C1859d) entry.getKey(), c1722f2);
            }
        }
        C1896c.m10795a(!c0370a.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map c0370a3 = new C0370a();
        Map c0370a4 = new C0370a();
        for (C1864a c1864a : map2.keySet()) {
            C1859d d = c1864a.m10576d();
            if (c0370a.containsKey(d)) {
                c0370a3.put(c1864a, (Integer) map2.get(c1864a));
            } else if (c0370a2.containsKey(d)) {
                c0370a4.put(c1864a, (Integer) map2.get(c1864a));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            mf mfVar = (mf) it.next();
            if (c0370a3.containsKey(mfVar.f5854a)) {
                arrayList2.add(mfVar);
            } else if (c0370a4.containsKey(mfVar.f5854a)) {
                arrayList3.add(mfVar);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new mg(context, mlVar, lock, looper, c1876j, c0370a, c0370a2, c1927n, c1827b, c1722f, arrayList2, arrayList3, c0370a3, c0370a4);
    }

    private void m9816a(int i, boolean z) {
        this.f5861b.mo1576a(i, z);
        this.f5870k = null;
        this.f5869j = null;
    }

    private void m9817a(Bundle bundle) {
        if (this.f5868i == null) {
            this.f5868i = bundle;
        } else if (bundle != null) {
            this.f5868i.putAll(bundle);
        }
    }

    private void m9820a(ConnectionResult connectionResult) {
        switch (this.f5873n) {
            case 1:
                break;
            case 2:
                this.f5861b.mo1578a(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m9833i();
        this.f5873n = 0;
    }

    private static boolean m9824b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m10547b();
    }

    private boolean m9825c(C1714a<? extends C1857g, ? extends C1721c> c1714a) {
        C1859d b = c1714a.mo1550b();
        C1896c.m10799b(this.f5865f.containsKey(b), "GoogleApiClient is not configured to use the API required for this call.");
        return ((mo) this.f5865f.get(b)).equals(this.f5864e);
    }

    private void m9830f() {
        this.f5870k = null;
        this.f5869j = null;
        this.f5863d.mo1580a();
        this.f5864e.mo1580a();
    }

    private void m9831g() {
        if (mg.m9824b(this.f5869j)) {
            if (mg.m9824b(this.f5870k) || m9834j()) {
                m9832h();
            } else if (this.f5870k == null) {
            } else {
                if (this.f5873n == 1) {
                    m9833i();
                    return;
                }
                m9820a(this.f5870k);
                this.f5863d.mo1583b();
            }
        } else if (this.f5869j != null && mg.m9824b(this.f5870k)) {
            this.f5864e.mo1583b();
            m9820a(this.f5869j);
        } else if (this.f5869j != null && this.f5870k != null) {
            ConnectionResult connectionResult = this.f5869j;
            if (this.f5864e.f5953f < this.f5863d.f5953f) {
                connectionResult = this.f5870k;
            }
            m9820a(connectionResult);
        }
    }

    private void m9832h() {
        switch (this.f5873n) {
            case 1:
                break;
            case 2:
                this.f5861b.mo1577a(this.f5868i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m9833i();
        this.f5873n = 0;
    }

    private void m9833i() {
        for (nd a : this.f5866g) {
            a.m10094a();
        }
        this.f5866g.clear();
    }

    private boolean m9834j() {
        return this.f5870k != null && this.f5870k.m10548c() == 4;
    }

    private PendingIntent m9835k() {
        return this.f5867h == null ? null : PendingIntent.getActivity(this.f5860a, this.f5861b.m9986k(), this.f5867h.m9697i(), 134217728);
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1579a(T t) {
        if (!m9825c((C1714a) t)) {
            return this.f5863d.mo1579a((C1714a) t);
        }
        if (!m9834j()) {
            return this.f5864e.mo1579a((C1714a) t);
        }
        t.m9663c(new Status(4, null, m9835k()));
        return t;
    }

    public void mo1580a() {
        this.f5873n = 2;
        this.f5871l = false;
        m9830f();
    }

    public void mo1581a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f5864e.mo1581a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f5863d.mo1581a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1582b(T t) {
        if (!m9825c((C1714a) t)) {
            return this.f5863d.mo1582b((C1714a) t);
        }
        if (!m9834j()) {
            return this.f5864e.mo1582b((C1714a) t);
        }
        t.m9663c(new Status(4, null, m9835k()));
        return t;
    }

    public void mo1583b() {
        this.f5870k = null;
        this.f5869j = null;
        this.f5873n = 0;
        this.f5863d.mo1583b();
        this.f5864e.mo1583b();
        m9833i();
    }

    public boolean mo1584c() {
        boolean z = true;
        this.f5872m.lock();
        try {
            if (!(this.f5863d.mo1584c() && (m9843e() || m9834j() || this.f5873n == 1))) {
                z = false;
            }
            this.f5872m.unlock();
            return z;
        } catch (Throwable th) {
            this.f5872m.unlock();
        }
    }

    public void mo1585d() {
        this.f5863d.mo1585d();
        this.f5864e.mo1585d();
    }

    public boolean m9843e() {
        return this.f5864e.mo1584c();
    }
}
