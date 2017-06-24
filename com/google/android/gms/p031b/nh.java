package com.google.android.gms.p031b;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.support.v4.p015g.C0370a;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1859d;
import com.google.android.gms.common.api.C1873o;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p031b.mc.C1714a;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class nh {
    private static final C1714a<?, ?>[] f6047b = new C1714a[0];
    final Set<C1714a<?, ?>> f6048a;
    private final C1781b f6049c;
    private final Map<C1859d<?>, C1722f> f6050d;
    private C1771c f6051e;

    interface C1771c {
        void mo1615a();
    }

    interface C1781b {
        void mo1622a(C1714a<?, ?> c1714a);
    }

    class C17821 implements C1781b {
        final /* synthetic */ nh f6043a;

        C17821(nh nhVar) {
            this.f6043a = nhVar;
        }

        public void mo1622a(C1714a<?, ?> c1714a) {
            this.f6043a.f6048a.remove(c1714a);
            if (!(c1714a.mo1546a() == null || null == null)) {
                null.m10598a(c1714a.mo1546a().intValue());
            }
            if (this.f6043a.f6051e != null && this.f6043a.f6048a.isEmpty()) {
                this.f6043a.f6051e.mo1615a();
            }
        }
    }

    private static class C1783a implements DeathRecipient, C1781b {
        private final WeakReference<C1714a<?, ?>> f6044a;
        private final WeakReference<C1873o> f6045b;
        private final WeakReference<IBinder> f6046c;

        private C1783a(C1714a<?, ?> c1714a, C1873o c1873o, IBinder iBinder) {
            this.f6045b = new WeakReference(c1873o);
            this.f6044a = new WeakReference(c1714a);
            this.f6046c = new WeakReference(iBinder);
        }

        private void m10129a() {
            C1714a c1714a = (C1714a) this.f6044a.get();
            C1873o c1873o = (C1873o) this.f6045b.get();
            if (!(c1873o == null || c1714a == null)) {
                c1873o.m10598a(c1714a.mo1546a().intValue());
            }
            IBinder iBinder = (IBinder) this.f6046c.get();
            if (this.f6046c != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void mo1622a(C1714a<?, ?> c1714a) {
            m10129a();
        }

        public void binderDied() {
            m10129a();
        }
    }

    public nh(C1859d<?> c1859d, C1722f c1722f) {
        this.f6048a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f6049c = new C17821(this);
        this.f6051e = null;
        this.f6050d = new C0370a();
        this.f6050d.put(c1859d, c1722f);
    }

    public nh(Map<C1859d<?>, C1722f> map) {
        this.f6048a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f6049c = new C17821(this);
        this.f6051e = null;
        this.f6050d = map;
    }

    private static void m10132a(C1714a<?, ?> c1714a, C1873o c1873o, IBinder iBinder) {
        if (c1714a.m9650f()) {
            c1714a.m9657a(new C1783a(c1714a, c1873o, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            c1714a.m9657a(null);
            c1714a.m9651g();
            c1873o.m10598a(c1714a.mo1546a().intValue());
        } else {
            C1781b c1783a = new C1783a(c1714a, c1873o, iBinder);
            c1714a.m9657a(c1783a);
            try {
                iBinder.linkToDeath(c1783a, 0);
            } catch (RemoteException e) {
                c1714a.m9651g();
                c1873o.m10598a(c1714a.mo1546a().intValue());
            }
        }
    }

    public void m10134a() {
        for (C1714a c1714a : (C1714a[]) this.f6048a.toArray(f6047b)) {
            c1714a.m9657a(null);
            if (c1714a.mo1546a() != null) {
                c1714a.m9664d();
                nh.m10132a(c1714a, null, ((C1722f) this.f6050d.get(c1714a.mo1550b())).m9698j());
                this.f6048a.remove(c1714a);
            } else if (c1714a.m9652h()) {
                this.f6048a.remove(c1714a);
            }
        }
    }

    <A extends C1721c> void m10135a(C1714a<? extends C1857g, A> c1714a) {
        this.f6048a.add(c1714a);
        c1714a.m9657a(this.f6049c);
    }

    public void m10136a(C1771c c1771c) {
        if (this.f6048a.isEmpty()) {
            c1771c.mo1615a();
        }
        this.f6051e = c1771c;
    }

    public void m10137a(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f6048a.size());
    }

    public void m10138b() {
        for (C1714a d : (C1714a[]) this.f6048a.toArray(f6047b)) {
            d.m9648d(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean m10139c() {
        for (C1714a f : (C1714a[]) this.f6048a.toArray(f6047b)) {
            if (!f.m9650f()) {
                return true;
            }
        }
        return false;
    }
}
