package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.support.v4.p015g.C0370a;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.C1877b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1830a;
import com.google.android.gms.common.api.C1864a.C1862i;
import com.google.android.gms.common.api.C1872n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1268k.C1751f;
import com.google.android.gms.common.internal.C1899f;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.p031b.ly.C1731a;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.nh.C1771c;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class mq implements Callback {
    private static final Object f5984d = new Object();
    private static mq f5985e;
    private long f5986a;
    private long f5987b;
    private long f5988c;
    private final Context f5989f;
    private final C1877b f5990g;
    private int f5991h;
    private final SparseArray<C1773c<?>> f5992i;
    private final Map<lz<?>, C1773c<?>> f5993j;
    private mh f5994k;
    private final Set<lz<?>> f5995l;
    private final Handler f5996m;
    private final ReferenceQueue<C1872n<?>> f5997n;
    private final SparseArray<C1769a> f5998o;
    private C1770b f5999p;

    private final class C1769a extends PhantomReference<C1872n<?>> {
        final /* synthetic */ mq f5964a;
        private final int f5965b;

        public C1769a(mq mqVar, C1872n c1872n, int i, ReferenceQueue<C1872n<?>> referenceQueue) {
            this.f5964a = mqVar;
            super(c1872n, referenceQueue);
            this.f5965b = i;
        }

        public void m10007a() {
            this.f5964a.f5996m.sendMessage(this.f5964a.f5996m.obtainMessage(2, this.f5965b, 2));
        }
    }

    private static final class C1770b extends Thread {
        private final ReferenceQueue<C1872n<?>> f5966a;
        private final SparseArray<C1769a> f5967b;
        private final AtomicBoolean f5968c = new AtomicBoolean();

        public C1770b(ReferenceQueue<C1872n<?>> referenceQueue, SparseArray<C1769a> sparseArray) {
            super("GoogleApiCleanup");
            this.f5966a = referenceQueue;
            this.f5967b = sparseArray;
        }

        public void run() {
            this.f5968c.set(true);
            Process.setThreadPriority(10);
            while (this.f5968c.get()) {
                try {
                    C1769a c1769a = (C1769a) this.f5966a.remove();
                    this.f5967b.remove(c1769a.f5965b);
                    c1769a.m10007a();
                } catch (InterruptedException e) {
                } finally {
                    this.f5968c.set(false);
                }
            }
        }
    }

    private class C1773c<O extends C1830a> implements C1742b, C1733c {
        final /* synthetic */ mq f5971a;
        private final Queue<ly> f5972b = new LinkedList();
        private final C1722f f5973c;
        private final C1721c f5974d;
        private final lz<O> f5975e;
        private final SparseArray<nh> f5976f = new SparseArray();
        private final Set<mb> f5977g = new HashSet();
        private final SparseArray<Map<Object, C1714a>> f5978h = new SparseArray();
        private boolean f5979i;
        private ConnectionResult f5980j = null;

        public C1773c(mq mqVar, C1872n<O> c1872n) {
            this.f5971a = mqVar;
            this.f5973c = m10011a((C1872n) c1872n);
            if (this.f5973c instanceof C1899f) {
                this.f5974d = ((C1899f) this.f5973c).mo1702k();
            } else {
                this.f5974d = this.f5973c;
            }
            this.f5975e = c1872n.m10596d();
        }

        private C1722f m10011a(C1872n c1872n) {
            C1864a b = c1872n.m10594b();
            if (!b.m10577e()) {
                return c1872n.m10594b().m10574b().mo1639a(c1872n.m10597e(), this.f5971a.f5996m.getLooper(), C1927n.m10867a(c1872n.m10597e()), c1872n.m10595c(), this, this);
            }
            C1862i c = b.m10575c();
            return new C1899f(c1872n.m10597e(), this.f5971a.f5996m.getLooper(), c.m10571b(), this, this, C1927n.m10867a(c1872n.m10597e()), c.m10572b(c1872n.m10595c()));
        }

        private void m10014a(Status status) {
            for (ly a : this.f5972b) {
                a.mo1561a(status);
            }
            this.f5972b.clear();
        }

        private void m10015b(ly lyVar) {
            lyVar.mo1560a(this.f5976f);
            Map map;
            if (lyVar.f5827b == 3) {
                try {
                    Map map2;
                    map = (Map) this.f5978h.get(lyVar.f5826a);
                    if (map == null) {
                        C0370a c0370a = new C0370a(1);
                        this.f5978h.put(lyVar.f5826a, c0370a);
                        map2 = c0370a;
                    } else {
                        map2 = map;
                    }
                    C1714a c1714a = ((C1731a) lyVar).f5828c;
                    map2.put(((my) c1714a).m10086a(), c1714a);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (lyVar.f5827b == 4) {
                try {
                    map = (Map) this.f5978h.get(lyVar.f5826a);
                    my myVar = (my) ((C1731a) lyVar).f5828c;
                    if (map != null) {
                        map.remove(myVar.m10086a());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                lyVar.mo1562a(this.f5974d);
            } catch (DeadObjectException e3) {
                this.f5973c.m9691c();
                mo1574a(1);
            }
        }

        private void m10017b(ConnectionResult connectionResult) {
            for (mb a : this.f5977g) {
                a.m9781a(this.f5975e, connectionResult);
            }
            this.f5977g.clear();
        }

        private void m10021e() {
            if (this.f5979i) {
                m10026j();
            }
        }

        private void m10022f() {
            if (this.f5979i) {
                this.f5971a.f5996m.removeMessages(9, this.f5975e);
                this.f5971a.f5996m.removeMessages(8, this.f5975e);
                this.f5979i = false;
            }
        }

        private void m10023g() {
            if (this.f5979i) {
                m10022f();
                m10014a(this.f5971a.f5990g.mo1643a(this.f5971a.f5989f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f5973c.m9691c();
            }
        }

        private void m10024h() {
            this.f5971a.f5996m.removeMessages(10, this.f5975e);
            this.f5971a.f5996m.sendMessageDelayed(this.f5971a.f5996m.obtainMessage(10, this.f5975e), this.f5971a.f5988c);
        }

        private void m10025i() {
            if (this.f5973c.m9692d() && this.f5978h.size() == 0) {
                for (int i = 0; i < this.f5976f.size(); i++) {
                    if (((nh) this.f5976f.get(this.f5976f.keyAt(i))).m10139c()) {
                        m10024h();
                        return;
                    }
                }
                this.f5973c.m9691c();
            }
        }

        private void m10026j() {
            if (!this.f5973c.m9692d() && !this.f5973c.m9693e()) {
                if (this.f5973c.m9695g() && this.f5971a.f5991h != 0) {
                    this.f5971a.f5991h = this.f5971a.f5990g.mo1643a(this.f5971a.f5989f);
                    if (this.f5971a.f5991h != 0) {
                        mo1564a(new ConnectionResult(this.f5971a.f5991h, null));
                        return;
                    }
                }
                this.f5973c.m9688a(new C1774d(this.f5971a, this.f5973c, this.f5975e));
            }
        }

        public void m10027a() {
            while (this.f5973c.m9692d() && !this.f5972b.isEmpty()) {
                m10015b((ly) this.f5972b.remove());
            }
        }

        public void mo1574a(int i) {
            m10034b();
            this.f5979i = true;
            this.f5971a.f5996m.sendMessageDelayed(Message.obtain(this.f5971a.f5996m, 8, this.f5975e), this.f5971a.f5986a);
            this.f5971a.f5996m.sendMessageDelayed(Message.obtain(this.f5971a.f5996m, 9, this.f5975e), this.f5971a.f5987b);
            this.f5971a.f5991h = -1;
        }

        public void m10029a(int i, boolean z) {
            Iterator it = this.f5972b.iterator();
            while (it.hasNext()) {
                ly lyVar = (ly) it.next();
                if (lyVar.f5826a == i && lyVar.f5827b != 1 && lyVar.mo1563a()) {
                    it.remove();
                }
            }
            ((nh) this.f5976f.get(i)).m10134a();
            this.f5978h.delete(i);
            if (!z) {
                this.f5976f.remove(i);
                this.f5971a.f5998o.remove(i);
                if (this.f5976f.size() == 0 && this.f5972b.isEmpty()) {
                    m10022f();
                    this.f5973c.m9691c();
                    this.f5971a.f5993j.remove(this.f5975e);
                    synchronized (mq.f5984d) {
                        this.f5971a.f5995l.remove(this.f5975e);
                    }
                }
            }
        }

        public void mo1575a(Bundle bundle) {
            m10034b();
            m10017b(ConnectionResult.f6323a);
            m10022f();
            for (int i = 0; i < this.f5978h.size(); i++) {
                for (C1714a b : ((Map) this.f5978h.get(this.f5978h.keyAt(i))).values()) {
                    try {
                        b.m9661b(this.f5974d);
                    } catch (DeadObjectException e) {
                        this.f5973c.m9691c();
                        mo1574a(1);
                    }
                }
            }
            m10027a();
            m10024h();
        }

        public void m10031a(ly lyVar) {
            if (this.f5973c.m9692d()) {
                m10015b(lyVar);
                m10024h();
                return;
            }
            this.f5972b.add(lyVar);
            if (this.f5980j == null || !this.f5980j.m10546a()) {
                m10026j();
            } else {
                mo1564a(this.f5980j);
            }
        }

        public void m10032a(mb mbVar) {
            this.f5977g.add(mbVar);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo1564a(com.google.android.gms.common.ConnectionResult r6) {
            /*
            r5 = this;
            r5.m10034b();
            r0 = r5.f5971a;
            r1 = -1;
            r0.f5991h = r1;
            r5.m10017b(r6);
            r0 = r5.f5976f;
            r1 = 0;
            r0 = r0.keyAt(r1);
            r1 = r5.f5972b;
            r1 = r1.isEmpty();
            if (r1 == 0) goto L_0x001e;
        L_0x001b:
            r5.f5980j = r6;
        L_0x001d:
            return;
        L_0x001e:
            r1 = com.google.android.gms.p031b.mq.f5984d;
            monitor-enter(r1);
            r2 = r5.f5971a;	 Catch:{ all -> 0x0044 }
            r2 = null;	 Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047;
        L_0x002b:
            r2 = r5.f5971a;	 Catch:{ all -> 0x0044 }
            r2 = r2.f5995l;	 Catch:{ all -> 0x0044 }
            r3 = r5.f5975e;	 Catch:{ all -> 0x0044 }
            r2 = r2.contains(r3);	 Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047;
        L_0x0039:
            r2 = r5.f5971a;	 Catch:{ all -> 0x0044 }
            r2 = null;	 Catch:{ all -> 0x0044 }
            r2.m9768b(r6, r0);	 Catch:{ all -> 0x0044 }
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            goto L_0x001d;
        L_0x0044:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            throw r0;
        L_0x0047:
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            r1 = r5.f5971a;
            r0 = r1.m10062a(r6, r0);
            if (r0 != 0) goto L_0x001d;
        L_0x0050:
            r0 = r6.m10548c();
            r1 = 18;
            if (r0 != r1) goto L_0x005b;
        L_0x0058:
            r0 = 1;
            r5.f5979i = r0;
        L_0x005b:
            r0 = r5.f5979i;
            if (r0 == 0) goto L_0x007d;
        L_0x005f:
            r0 = r5.f5971a;
            r0 = r0.f5996m;
            r1 = r5.f5971a;
            r1 = r1.f5996m;
            r2 = 8;
            r3 = r5.f5975e;
            r1 = android.os.Message.obtain(r1, r2, r3);
            r2 = r5.f5971a;
            r2 = r2.f5986a;
            r0.sendMessageDelayed(r1, r2);
            goto L_0x001d;
        L_0x007d:
            r0 = new com.google.android.gms.common.api.Status;
            r1 = 17;
            r2 = r5.f5975e;
            r2 = r2.m9744b();
            r2 = java.lang.String.valueOf(r2);
            r3 = new java.lang.StringBuilder;
            r4 = java.lang.String.valueOf(r2);
            r4 = r4.length();
            r4 = r4 + 38;
            r3.<init>(r4);
            r4 = "API: ";
            r3 = r3.append(r4);
            r2 = r3.append(r2);
            r3 = " is not available on this device.";
            r2 = r2.append(r3);
            r2 = r2.toString();
            r0.<init>(r1, r2);
            r5.m10014a(r0);
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.mq.c.a(com.google.android.gms.common.ConnectionResult):void");
        }

        public void m10034b() {
            this.f5980j = null;
        }

        public void m10035b(int i) {
            this.f5976f.put(i, new nh(this.f5975e.m9743a(), this.f5973c));
        }

        ConnectionResult m10036c() {
            return this.f5980j;
        }

        public void m10037c(final int i) {
            ((nh) this.f5976f.get(i)).m10136a(new C1771c(this) {
                final /* synthetic */ C1773c f5970b;

                public void mo1615a() {
                    if (this.f5970b.f5972b.isEmpty()) {
                        this.f5970b.m10029a(i, false);
                    }
                }
            });
        }

        boolean m10038d() {
            return this.f5973c.m9692d();
        }
    }

    private class C1774d implements C1751f {
        final /* synthetic */ mq f5981a;
        private final C1722f f5982b;
        private final lz<?> f5983c;

        public C1774d(mq mqVar, C1722f c1722f, lz<?> lzVar) {
            this.f5981a = mqVar;
            this.f5982b = c1722f;
            this.f5983c = lzVar;
        }

        public void mo1595a(ConnectionResult connectionResult) {
            if (connectionResult.m10547b()) {
                this.f5982b.m9689a(null, Collections.emptySet());
            } else {
                ((C1773c) this.f5981a.f5993j.get(this.f5983c)).mo1564a(connectionResult);
            }
        }
    }

    public static mq m10042a() {
        mq mqVar;
        synchronized (f5984d) {
            mqVar = f5985e;
        }
        return mqVar;
    }

    private void m10043a(int i) {
        C1773c c1773c = (C1773c) this.f5992i.get(i);
        if (c1773c != null) {
            this.f5992i.delete(i);
            c1773c.m10037c(i);
            return;
        }
        Log.wtf("GoogleApiManager", "onCleanupLeakInternal received for unknown instance: " + i, new Exception());
    }

    private void m10044a(ly lyVar) {
        ((C1773c) this.f5992i.get(lyVar.f5826a)).m10031a(lyVar);
    }

    private void m10045a(C1872n<?> c1872n, int i) {
        lz d = c1872n.m10596d();
        if (!this.f5993j.containsKey(d)) {
            this.f5993j.put(d, new C1773c(this, c1872n));
        }
        C1773c c1773c = (C1773c) this.f5993j.get(d);
        c1773c.m10035b(i);
        this.f5992i.put(i, c1773c);
        c1773c.m10026j();
        this.f5998o.put(i, new C1769a(this, c1872n, i, this.f5997n));
        if (this.f5999p == null || !this.f5999p.f5968c.get()) {
            this.f5999p = new C1770b(this.f5997n, this.f5998o);
            this.f5999p.start();
        }
    }

    private void m10047b(int i, boolean z) {
        C1773c c1773c = (C1773c) this.f5992i.get(i);
        if (c1773c != null) {
            if (!z) {
                this.f5992i.delete(i);
            }
            c1773c.m10029a(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void m10051d() {
        for (C1773c c1773c : this.f5993j.values()) {
            c1773c.m10034b();
            c1773c.m10026j();
        }
    }

    public void m10059a(int i, boolean z) {
        this.f5996m.sendMessage(this.f5996m.obtainMessage(7, i, z ? 1 : 2));
    }

    public void m10060a(mb mbVar) {
        for (lz lzVar : mbVar.mo1550b()) {
            C1773c c1773c = (C1773c) this.f5993j.get(lzVar);
            if (c1773c == null) {
                mbVar.m9651g();
                return;
            } else if (c1773c.m10038d()) {
                mbVar.m9781a(lzVar, ConnectionResult.f6323a);
            } else if (c1773c.m10036c() != null) {
                mbVar.m9781a(lzVar, c1773c.m10036c());
            } else {
                c1773c.m10032a(mbVar);
            }
        }
    }

    public void m10061a(mh mhVar) {
        synchronized (f5984d) {
            if (mhVar == null) {
                this.f5994k = null;
                this.f5995l.clear();
            }
        }
    }

    boolean m10062a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.m10546a() && !this.f5990g.mo1647a(connectionResult.m10548c())) {
            return false;
        }
        this.f5990g.m10628a(this.f5989f, connectionResult, i);
        return true;
    }

    public void m10063b() {
        this.f5996m.sendMessage(this.f5996m.obtainMessage(3));
    }

    public void m10064b(ConnectionResult connectionResult, int i) {
        if (!m10062a(connectionResult, i)) {
            this.f5996m.sendMessage(this.f5996m.obtainMessage(5, i, 0));
        }
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                m10060a((mb) message.obj);
                break;
            case 2:
                m10043a(message.arg1);
                break;
            case 3:
                m10051d();
                break;
            case 4:
                m10044a((ly) message.obj);
                break;
            case 5:
                if (this.f5992i.get(message.arg1) != null) {
                    ((C1773c) this.f5992i.get(message.arg1)).m10014a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                m10045a((C1872n) message.obj, message.arg1);
                break;
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                m10047b(i, z);
                break;
            case 8:
                if (this.f5993j.containsKey(message.obj)) {
                    ((C1773c) this.f5993j.get(message.obj)).m10021e();
                    break;
                }
                break;
            case 9:
                if (this.f5993j.containsKey(message.obj)) {
                    ((C1773c) this.f5993j.get(message.obj)).m10023g();
                    break;
                }
                break;
            case 10:
                if (this.f5993j.containsKey(message.obj)) {
                    ((C1773c) this.f5993j.get(message.obj)).m10025i();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
