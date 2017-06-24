package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.C1877b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1767c;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.common.internal.C1935s;
import com.google.android.gms.common.internal.C1935s.C1723a;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.mr.C1736a;
import com.google.android.gms.p031b.mt.C1744a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class ml extends C1767c implements C1744a {
    final Queue<C1714a<?, ?>> f5923a = new LinkedList();
    mr f5924b;
    final Map<C1859d<?>, C1722f> f5925c;
    Set<Scope> f5926d = new HashSet();
    final C1927n f5927e;
    final Map<C1864a<?>, Integer> f5928f;
    final C1827b<? extends oa, ob> f5929g;
    Set<ng> f5930h = null;
    final nh f5931i;
    private final Lock f5932j;
    private final C1935s f5933k;
    private mt f5934l = null;
    private final int f5935m;
    private final Context f5936n;
    private final Looper f5937o;
    private volatile boolean f5938p;
    private long f5939q = 120000;
    private long f5940r = 5000;
    private final C1765a f5941s;
    private final C1877b f5942t;
    private final na f5943u = new na();
    private final ArrayList<mf> f5944v;
    private Integer f5945w = null;
    private final C1723a f5946x = new C17641(this);

    class C17641 implements C1723a {
        final /* synthetic */ ml f5919a;

        C17641(ml mlVar) {
            this.f5919a = mlVar;
        }

        public boolean mo1602d() {
            return this.f5919a.m9980e();
        }

        public Bundle mo1603t() {
            return null;
        }
    }

    final class C1765a extends Handler {
        final /* synthetic */ ml f5920a;

        C1765a(ml mlVar, Looper looper) {
            this.f5920a = mlVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f5920a.m9964n();
                    return;
                case 2:
                    this.f5920a.m9963m();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    static class C1766b extends C1736a {
        private WeakReference<ml> f5921a;

        C1766b(ml mlVar) {
            this.f5921a = new WeakReference(mlVar);
        }

        public void mo1573a() {
            ml mlVar = (ml) this.f5921a.get();
            if (mlVar != null) {
                mlVar.m9963m();
            }
        }
    }

    public ml(Context context, Lock lock, Looper looper, C1927n c1927n, C1877b c1877b, C1827b<? extends oa, ob> c1827b, Map<C1864a<?>, Integer> map, List<C1742b> list, List<C1733c> list2, Map<C1859d<?>, C1722f> map2, int i, int i2, ArrayList<mf> arrayList) {
        this.f5936n = context;
        this.f5932j = lock;
        this.f5933k = new C1935s(looper, this.f5946x);
        this.f5937o = looper;
        this.f5941s = new C1765a(this, looper);
        this.f5942t = c1877b;
        this.f5935m = i;
        if (this.f5935m >= 0) {
            this.f5945w = Integer.valueOf(i2);
        }
        this.f5928f = map;
        this.f5925c = map2;
        this.f5944v = arrayList;
        this.f5931i = new nh(this.f5925c);
        for (C1742b a : list) {
            this.f5933k.m10900a(a);
        }
        for (C1733c a2 : list2) {
            this.f5933k.m10901a(a2);
        }
        this.f5927e = c1927n;
        this.f5929g = c1827b;
    }

    public static int m9957a(Iterable<C1722f> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (C1722f c1722f : iterable) {
            if (c1722f.mo1772f()) {
                i2 = 1;
            }
            i = c1722f.m9696h() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    static String m9959b(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m9961c(int i) {
        if (this.f5945w == null) {
            this.f5945w = Integer.valueOf(i);
        } else if (this.f5945w.intValue() != i) {
            String valueOf = String.valueOf(ml.m9959b(i));
            String valueOf2 = String.valueOf(ml.m9959b(this.f5945w.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f5934l == null) {
            Object obj = null;
            Object obj2 = null;
            for (C1722f c1722f : this.f5925c.values()) {
                if (c1722f.mo1772f()) {
                    obj2 = 1;
                }
                obj = c1722f.m9696h() ? 1 : obj;
            }
            switch (this.f5945w.intValue()) {
                case 1:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj2 != null) {
                        this.f5934l = mg.m9813a(this.f5936n, this, this.f5932j, this.f5937o, this.f5942t, this.f5925c, this.f5927e, this.f5928f, this.f5929g, this.f5944v);
                        return;
                    }
                    break;
            }
            this.f5934l = new mo(this.f5936n, this, this.f5932j, this.f5937o, this.f5942t, this.f5925c, this.f5927e, this.f5928f, this.f5929g, this.f5944v, this);
        }
    }

    private void m9962l() {
        this.f5933k.m10902b();
        this.f5934l.mo1580a();
    }

    private void m9963m() {
        this.f5932j.lock();
        try {
            if (m9981f()) {
                m9962l();
            }
            this.f5932j.unlock();
        } catch (Throwable th) {
            this.f5932j.unlock();
        }
    }

    private void m9964n() {
        this.f5932j.lock();
        try {
            if (m9983h()) {
                m9962l();
            }
            this.f5932j.unlock();
        } catch (Throwable th) {
            this.f5932j.unlock();
        }
    }

    public Looper mo1604a() {
        return this.f5937o;
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1605a(T t) {
        C1896c.m10799b(t.mo1550b() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f5925c.containsKey(t.mo1550b());
        String f = t.m9662c() != null ? t.m9662c().m10578f() : "the API";
        C1896c.m10799b(containsKey, new StringBuilder(String.valueOf(f).length() + 65).append("GoogleApiClient is not configured to use ").append(f).append(" required for this call.").toString());
        this.f5932j.lock();
        try {
            if (this.f5934l == null) {
                this.f5923a.add(t);
            } else {
                t = this.f5934l.mo1579a(t);
                this.f5932j.unlock();
            }
            return t;
        } finally {
            this.f5932j.unlock();
        }
    }

    <C extends C1722f> C m9967a(C1859d<?> c1859d) {
        Object obj = (C1722f) this.f5925c.get(c1859d);
        C1896c.m10791a(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void mo1606a(int i) {
        boolean z = true;
        this.f5932j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            C1896c.m10799b(z, "Illegal sign-in mode: " + i);
            m9961c(i);
            m9962l();
        } finally {
            this.f5932j.unlock();
        }
    }

    public void mo1576a(int i, boolean z) {
        if (i == 1 && !z) {
            m9982g();
        }
        this.f5931i.m10138b();
        this.f5933k.m10897a(i);
        this.f5933k.m10896a();
        if (i == 2) {
            m9962l();
        }
    }

    public void mo1577a(Bundle bundle) {
        while (!this.f5923a.isEmpty()) {
            mo1610b((C1714a) this.f5923a.remove());
        }
        this.f5933k.m10898a(bundle);
    }

    public void mo1607a(ng ngVar) {
        this.f5932j.lock();
        try {
            if (this.f5930h == null) {
                this.f5930h = new HashSet();
            }
            this.f5930h.add(ngVar);
        } finally {
            this.f5932j.unlock();
        }
    }

    public void mo1578a(ConnectionResult connectionResult) {
        if (!this.f5942t.mo1648a(this.f5936n, connectionResult.m10548c())) {
            m9983h();
        }
        if (!m9981f()) {
            this.f5933k.m10899a(connectionResult);
            this.f5933k.m10896a();
        }
    }

    public void mo1608a(C1733c c1733c) {
        this.f5933k.m10901a(c1733c);
    }

    public void mo1609a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f5936n);
        printWriter.append(str).append("mResuming=").print(this.f5938p);
        printWriter.append(" mWorkQueue.size()=").print(this.f5923a.size());
        this.f5931i.m10137a(printWriter);
        if (this.f5934l != null) {
            this.f5934l.mo1581a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1610b(T t) {
        C1896c.m10799b(t.mo1550b() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f5925c.containsKey(t.mo1550b());
        String f = t.m9662c() != null ? t.m9662c().m10578f() : "the API";
        C1896c.m10799b(containsKey, new StringBuilder(String.valueOf(f).length() + 65).append("GoogleApiClient is not configured to use ").append(f).append(" required for this call.").toString());
        this.f5932j.lock();
        try {
            if (this.f5934l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m9981f()) {
                this.f5923a.add(t);
                while (!this.f5923a.isEmpty()) {
                    C1714a c1714a = (C1714a) this.f5923a.remove();
                    this.f5931i.m10135a(c1714a);
                    c1714a.m9663c(Status.f6335c);
                }
            } else {
                t = this.f5934l.mo1582b(t);
                this.f5932j.unlock();
            }
            return t;
        } finally {
            this.f5932j.unlock();
        }
    }

    public void mo1611b() {
        boolean z = false;
        this.f5932j.lock();
        try {
            if (this.f5935m >= 0) {
                if (this.f5945w != null) {
                    z = true;
                }
                C1896c.m10795a(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f5945w == null) {
                this.f5945w = Integer.valueOf(ml.m9957a(this.f5925c.values(), false));
            } else if (this.f5945w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo1606a(this.f5945w.intValue());
        } finally {
            this.f5932j.unlock();
        }
    }

    public void mo1612b(ng ngVar) {
        this.f5932j.lock();
        try {
            if (this.f5930h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f5930h.remove(ngVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m9984i()) {
                this.f5934l.mo1585d();
            }
            this.f5932j.unlock();
        } catch (Throwable th) {
            this.f5932j.unlock();
        }
    }

    public void mo1613b(C1733c c1733c) {
        this.f5933k.m10903b(c1733c);
    }

    public void mo1614c() {
        this.f5932j.lock();
        try {
            this.f5931i.m10134a();
            if (this.f5934l != null) {
                this.f5934l.mo1583b();
            }
            this.f5943u.m10088a();
            for (C1714a c1714a : this.f5923a) {
                c1714a.m9657a(null);
                c1714a.m9651g();
            }
            this.f5923a.clear();
            if (this.f5934l != null) {
                m9983h();
                this.f5933k.m10896a();
                this.f5932j.unlock();
            }
        } finally {
            this.f5932j.unlock();
        }
    }

    public boolean m9980e() {
        return this.f5934l != null && this.f5934l.mo1584c();
    }

    boolean m9981f() {
        return this.f5938p;
    }

    void m9982g() {
        if (!m9981f()) {
            this.f5938p = true;
            if (this.f5924b == null) {
                this.f5924b = this.f5942t.m10626a(this.f5936n.getApplicationContext(), new C1766b(this));
            }
            this.f5941s.sendMessageDelayed(this.f5941s.obtainMessage(1), this.f5939q);
            this.f5941s.sendMessageDelayed(this.f5941s.obtainMessage(2), this.f5940r);
        }
    }

    boolean m9983h() {
        if (!m9981f()) {
            return false;
        }
        this.f5938p = false;
        this.f5941s.removeMessages(2);
        this.f5941s.removeMessages(1);
        if (this.f5924b != null) {
            this.f5924b.m10065a();
            this.f5924b = null;
        }
        return true;
    }

    boolean m9984i() {
        boolean z = false;
        this.f5932j.lock();
        try {
            if (this.f5930h != null) {
                if (!this.f5930h.isEmpty()) {
                    z = true;
                }
                this.f5932j.unlock();
            }
            return z;
        } finally {
            this.f5932j.unlock();
        }
    }

    String m9985j() {
        Writer stringWriter = new StringWriter();
        mo1609a("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public int m9986k() {
        return System.identityHashCode(this);
    }
}
