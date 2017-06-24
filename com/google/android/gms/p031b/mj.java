package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.C1876j;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1268k.C1751f;
import com.google.android.gms.common.internal.C1886w;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.common.internal.C1927n.C1926a;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.mo.C1747a;
import com.google.android.gms.signin.internal.C1761b;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class mj implements mm {
    private final mo f5897a;
    private final Lock f5898b;
    private final Context f5899c;
    private final C1876j f5900d;
    private ConnectionResult f5901e;
    private int f5902f;
    private int f5903g = 0;
    private int f5904h;
    private final Bundle f5905i = new Bundle();
    private final Set<C1859d> f5906j = new HashSet();
    private oa f5907k;
    private int f5908l;
    private boolean f5909m;
    private boolean f5910n;
    private C1886w f5911o;
    private boolean f5912p;
    private boolean f5913q;
    private final C1927n f5914r;
    private final Map<C1864a<?>, Integer> f5915s;
    private final C1827b<? extends oa, ob> f5916t;
    private ArrayList<Future<?>> f5917u = new ArrayList();

    class C17501 implements Runnable {
        final /* synthetic */ mj f5879a;

        C17501(mj mjVar) {
            this.f5879a = mjVar;
        }

        public void run() {
            this.f5879a.f5900d.m10616c(this.f5879a.f5899c);
        }
    }

    private static class C1752a implements C1751f {
        private final WeakReference<mj> f5880a;
        private final C1864a<?> f5881b;
        private final int f5882c;

        public C1752a(mj mjVar, C1864a<?> c1864a, int i) {
            this.f5880a = new WeakReference(mjVar);
            this.f5881b = c1864a;
            this.f5882c = i;
        }

        public void mo1595a(ConnectionResult connectionResult) {
            boolean z = false;
            mj mjVar = (mj) this.f5880a.get();
            if (mjVar != null) {
                if (Looper.myLooper() == mjVar.f5897a.f5954g.mo1604a()) {
                    z = true;
                }
                C1896c.m10795a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                mjVar.f5898b.lock();
                try {
                    if (mjVar.m9905b(0)) {
                        if (!connectionResult.m10547b()) {
                            mjVar.m9904b(connectionResult, this.f5881b, this.f5882c);
                        }
                        if (mjVar.m9912d()) {
                            mjVar.m9913e();
                        }
                        mjVar.f5898b.unlock();
                    }
                } finally {
                    mjVar.f5898b.unlock();
                }
            }
        }
    }

    private abstract class C1755f implements Runnable {
        final /* synthetic */ mj f5887b;

        private C1755f(mj mjVar) {
            this.f5887b = mjVar;
        }

        protected abstract void mo1596a();

        public void run() {
            this.f5887b.f5898b.lock();
            try {
                if (!Thread.interrupted()) {
                    mo1596a();
                    this.f5887b.f5898b.unlock();
                }
            } catch (RuntimeException e) {
                this.f5887b.f5897a.m9996a(e);
            } finally {
                this.f5887b.f5898b.unlock();
            }
        }
    }

    private class C1756b extends C1755f {
        final /* synthetic */ mj f5888a;
        private final Map<C1722f, C1752a> f5889c;

        public C1756b(mj mjVar, Map<C1722f, C1752a> map) {
            this.f5888a = mjVar;
            super();
            this.f5889c = map;
        }

        public void mo1596a() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (C1722f c1722f : this.f5889c.keySet()) {
                if (!c1722f.m9695g()) {
                    i = 0;
                    i4 = i5;
                } else if (((C1752a) this.f5889c.get(c1722f)).f5882c == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = this.f5888a.f5900d.mo1643a(this.f5888a.f5899c);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.f5888a.f5909m) {
                    this.f5888a.f5907k.mo1773l();
                }
                for (C1722f c1722f2 : this.f5889c.keySet()) {
                    final C1751f c1751f = (C1751f) this.f5889c.get(c1722f2);
                    if (!c1722f2.m9695g() || i3 == 0) {
                        c1722f2.m9688a(c1751f);
                    } else {
                        this.f5888a.f5897a.m9993a(new C1747a(this, this.f5888a) {
                            final /* synthetic */ C1756b f5886b;

                            public void mo1586a() {
                                c1751f.mo1595a(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i3, null);
            this.f5888a.f5897a.m9993a(new C1747a(this, this.f5888a) {
                final /* synthetic */ C1756b f5884b;

                public void mo1586a() {
                    this.f5884b.f5888a.m9910c(connectionResult);
                }
            });
        }
    }

    private class C1757c extends C1755f {
        final /* synthetic */ mj f5890a;
        private final ArrayList<C1722f> f5891c;

        public C1757c(mj mjVar, ArrayList<C1722f> arrayList) {
            this.f5890a = mjVar;
            super();
            this.f5891c = arrayList;
        }

        public void mo1596a() {
            this.f5890a.f5897a.f5954g.f5926d = this.f5890a.m9923j();
            Iterator it = this.f5891c.iterator();
            while (it.hasNext()) {
                ((C1722f) it.next()).m9689a(this.f5890a.f5911o, this.f5890a.f5897a.f5954g.f5926d);
            }
        }
    }

    private static class C1762d extends C1761b {
        private final WeakReference<mj> f5895a;

        C1762d(mj mjVar) {
            this.f5895a = new WeakReference(mjVar);
        }

        public void mo1600a(final SignInResponse signInResponse) {
            final mj mjVar = (mj) this.f5895a.get();
            if (mjVar != null) {
                mjVar.f5897a.m9993a(new C1747a(this, mjVar) {
                    final /* synthetic */ C1762d f5894c;

                    public void mo1586a() {
                        mjVar.m9898a(signInResponse);
                    }
                });
            }
        }
    }

    private class C1763e implements C1742b, C1733c {
        final /* synthetic */ mj f5896a;

        private C1763e(mj mjVar) {
            this.f5896a = mjVar;
        }

        public void mo1574a(int i) {
        }

        public void mo1575a(Bundle bundle) {
            this.f5896a.f5907k.mo1771a(new C1762d(this.f5896a));
        }

        public void mo1564a(ConnectionResult connectionResult) {
            this.f5896a.f5898b.lock();
            try {
                if (this.f5896a.m9907b(connectionResult)) {
                    this.f5896a.m9920h();
                    this.f5896a.m9913e();
                } else {
                    this.f5896a.m9910c(connectionResult);
                }
                this.f5896a.f5898b.unlock();
            } catch (Throwable th) {
                this.f5896a.f5898b.unlock();
            }
        }
    }

    public mj(mo moVar, C1927n c1927n, Map<C1864a<?>, Integer> map, C1876j c1876j, C1827b<? extends oa, ob> c1827b, Lock lock, Context context) {
        this.f5897a = moVar;
        this.f5914r = c1927n;
        this.f5915s = map;
        this.f5900d = c1876j;
        this.f5916t = c1827b;
        this.f5898b = lock;
        this.f5899c = context;
    }

    private void m9898a(SignInResponse signInResponse) {
        if (m9905b(0)) {
            ConnectionResult a = signInResponse.m12029a();
            if (a.m10547b()) {
                ResolveAccountResponse b = signInResponse.m12030b();
                ConnectionResult b2 = b.m10674b();
                if (b2.m10547b()) {
                    this.f5910n = true;
                    this.f5911o = b.m10673a();
                    this.f5912p = b.m10675c();
                    this.f5913q = b.m10676d();
                    m9913e();
                    return;
                }
                String valueOf = String.valueOf(b2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m9910c(b2);
            } else if (m9907b(a)) {
                m9920h();
                m9913e();
            } else {
                m9910c(a);
            }
        }
    }

    private void m9899a(boolean z) {
        if (this.f5907k != null) {
            if (this.f5907k.m9692d() && z) {
                this.f5907k.mo1702k();
            }
            this.f5907k.m9691c();
            this.f5911o = null;
        }
    }

    private boolean m9900a(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || m9902a(connectionResult)) ? this.f5901e == null || i < this.f5902f : false;
    }

    private boolean m9902a(ConnectionResult connectionResult) {
        return connectionResult.m10546a() || this.f5900d.mo1650b(connectionResult.m10548c()) != null;
    }

    private void m9904b(ConnectionResult connectionResult, C1864a<?> c1864a, int i) {
        if (i != 2) {
            int a = c1864a.m10573a().m10323a();
            if (m9900a(a, i, connectionResult)) {
                this.f5901e = connectionResult;
                this.f5902f = a;
            }
        }
        this.f5897a.f5949b.put(c1864a.m10576d(), connectionResult);
    }

    private boolean m9905b(int i) {
        if (this.f5903g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f5897a.f5954g.m9985j());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.f5904h);
        valueOf = String.valueOf(m9908c(this.f5903g));
        String valueOf2 = String.valueOf(m9908c(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m9910c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m9907b(ConnectionResult connectionResult) {
        return this.f5908l != 2 ? this.f5908l == 1 && !connectionResult.m10546a() : true;
    }

    private String m9908c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m9910c(ConnectionResult connectionResult) {
        m9921i();
        m9899a(!connectionResult.m10546a());
        this.f5897a.m9994a(connectionResult);
        this.f5897a.f5955h.mo1578a(connectionResult);
    }

    private boolean m9912d() {
        this.f5904h--;
        if (this.f5904h > 0) {
            return false;
        }
        if (this.f5904h < 0) {
            Log.w("GoogleApiClientConnecting", this.f5897a.f5954g.m9985j());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m9910c(new ConnectionResult(8, null));
            return false;
        } else if (this.f5901e == null) {
            return true;
        } else {
            this.f5897a.f5953f = this.f5902f;
            m9910c(this.f5901e);
            return false;
        }
    }

    private void m9913e() {
        if (this.f5904h == 0) {
            if (!this.f5909m || this.f5910n) {
                m9916f();
            }
        }
    }

    private void m9916f() {
        ArrayList arrayList = new ArrayList();
        this.f5903g = 1;
        this.f5904h = this.f5897a.f5948a.size();
        for (C1859d c1859d : this.f5897a.f5948a.keySet()) {
            if (!this.f5897a.f5949b.containsKey(c1859d)) {
                arrayList.add((C1722f) this.f5897a.f5948a.get(c1859d));
            } else if (m9912d()) {
                m9918g();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f5917u.add(mp.m10005a().submit(new C1757c(this, arrayList)));
        }
    }

    private void m9918g() {
        this.f5897a.m10003f();
        mp.m10005a().execute(new C17501(this));
        if (this.f5907k != null) {
            if (this.f5912p) {
                this.f5907k.mo1770a(this.f5911o, this.f5913q);
            }
            m9899a(false);
        }
        for (C1859d c1859d : this.f5897a.f5949b.keySet()) {
            ((C1722f) this.f5897a.f5948a.get(c1859d)).m9691c();
        }
        this.f5897a.f5955h.mo1577a(this.f5905i.isEmpty() ? null : this.f5905i);
    }

    private void m9920h() {
        this.f5909m = false;
        this.f5897a.f5954g.f5926d = Collections.emptySet();
        for (C1859d c1859d : this.f5906j) {
            if (!this.f5897a.f5949b.containsKey(c1859d)) {
                this.f5897a.f5949b.put(c1859d, new ConnectionResult(17, null));
            }
        }
    }

    private void m9921i() {
        Iterator it = this.f5917u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f5917u.clear();
    }

    private Set<Scope> m9923j() {
        if (this.f5914r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f5914r.m10871c());
        Map e = this.f5914r.m10873e();
        for (C1864a c1864a : e.keySet()) {
            if (!this.f5897a.f5949b.containsKey(c1864a.m10576d())) {
                hashSet.addAll(((C1926a) e.get(c1864a)).f6478a);
            }
        }
        return hashSet;
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1587a(T t) {
        this.f5897a.f5954g.f5923a.add(t);
        return t;
    }

    public void mo1588a() {
        this.f5897a.f5949b.clear();
        this.f5909m = false;
        this.f5901e = null;
        this.f5903g = 0;
        this.f5908l = 2;
        this.f5910n = false;
        this.f5912p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (C1864a c1864a : this.f5915s.keySet()) {
            C1722f c1722f = (C1722f) this.f5897a.f5948a.get(c1864a.m10576d());
            int intValue = ((Integer) this.f5915s.get(c1864a)).intValue();
            int i2 = (c1864a.m10573a().m10323a() == 1 ? 1 : 0) | i;
            if (c1722f.mo1772f()) {
                this.f5909m = true;
                if (intValue < this.f5908l) {
                    this.f5908l = intValue;
                }
                if (intValue != 0) {
                    this.f5906j.add(c1864a.m10576d());
                }
            }
            hashMap.put(c1722f, new C1752a(this, c1864a, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f5909m = false;
        }
        if (this.f5909m) {
            this.f5914r.m10869a(Integer.valueOf(this.f5897a.f5954g.m9986k()));
            C1742b c1763e = new C1763e();
            this.f5907k = (oa) this.f5916t.mo1639a(this.f5899c, this.f5897a.f5954g.mo1604a(), this.f5914r, this.f5914r.m10876h(), c1763e, c1763e);
        }
        this.f5904h = this.f5897a.f5948a.size();
        this.f5917u.add(mp.m10005a().submit(new C1756b(this, hashMap)));
    }

    public void mo1589a(int i) {
        m9910c(new ConnectionResult(8, null));
    }

    public void mo1590a(Bundle bundle) {
        if (m9905b(1)) {
            if (bundle != null) {
                this.f5905i.putAll(bundle);
            }
            if (m9912d()) {
                m9918g();
            }
        }
    }

    public void mo1591a(ConnectionResult connectionResult, C1864a<?> c1864a, int i) {
        if (m9905b(1)) {
            m9904b(connectionResult, c1864a, i);
            if (m9912d()) {
                m9918g();
            }
        }
    }

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1592b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean mo1593b() {
        m9921i();
        m9899a(true);
        this.f5897a.m9994a(null);
        return true;
    }

    public void mo1594c() {
    }
}
