package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.p015g.C0370a;
import android.view.View;
import com.google.android.gms.common.C1877b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1830a;
import com.google.android.gms.common.api.C1864a.C1830a.C1835c;
import com.google.android.gms.common.api.C1864a.C1861h;
import com.google.android.gms.common.api.C1864a.C1862i;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.common.internal.C1899f;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.common.internal.C1927n.C1926a;
import com.google.android.gms.p031b.ma;
import com.google.android.gms.p031b.mc.C1714a;
import com.google.android.gms.p031b.mf;
import com.google.android.gms.p031b.ml;
import com.google.android.gms.p031b.mu;
import com.google.android.gms.p031b.ng;
import com.google.android.gms.p031b.nz;
import com.google.android.gms.p031b.oa;
import com.google.android.gms.p031b.ob;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

public abstract class C1767c {
    private static final Set<C1767c> f5922a = Collections.newSetFromMap(new WeakHashMap());

    public interface C1733c {
        void mo1564a(ConnectionResult connectionResult);
    }

    public interface C1742b {
        void mo1574a(int i);

        void mo1575a(Bundle bundle);
    }

    public static final class C1866a {
        private Account f6349a;
        private final Set<Scope> f6350b = new HashSet();
        private final Set<Scope> f6351c = new HashSet();
        private int f6352d;
        private View f6353e;
        private String f6354f;
        private String f6355g;
        private final Map<C1864a<?>, C1926a> f6356h = new C0370a();
        private final Context f6357i;
        private final Map<C1864a<?>, C1830a> f6358j = new C0370a();
        private mu f6359k;
        private int f6360l = -1;
        private C1733c f6361m;
        private Looper f6362n;
        private C1877b f6363o = C1877b.m10617a();
        private C1827b<? extends oa, ob> f6364p = nz.f6216c;
        private final ArrayList<C1742b> f6365q = new ArrayList();
        private final ArrayList<C1733c> f6366r = new ArrayList();

        public C1866a(Context context) {
            this.f6357i = context;
            this.f6362n = context.getMainLooper();
            this.f6354f = context.getPackageName();
            this.f6355g = context.getClass().getName();
        }

        private static <C extends C1722f, O> C m10580a(C1827b<C, O> c1827b, Object obj, Context context, Looper looper, C1927n c1927n, C1742b c1742b, C1733c c1733c) {
            return c1827b.mo1639a(context, looper, c1927n, obj, c1742b, c1733c);
        }

        private static <C extends C1861h, O> C1899f m10581a(C1862i<C, O> c1862i, Object obj, Context context, Looper looper, C1927n c1927n, C1742b c1742b, C1733c c1733c) {
            return new C1899f(context, looper, c1862i.m10571b(), c1742b, c1733c, c1927n, c1862i.m10572b(obj));
        }

        private void m10582a(C1767c c1767c) {
            ma.m9771a(this.f6359k).m9774a(this.f6360l, c1767c, this.f6361m);
        }

        private C1767c m10583c() {
            C1927n a = m10585a();
            C1864a c1864a = null;
            Map e = a.m10873e();
            Map c0370a = new C0370a();
            Map c0370a2 = new C0370a();
            ArrayList arrayList = new ArrayList();
            C1864a c1864a2 = null;
            for (C1864a c1864a3 : this.f6358j.keySet()) {
                C1864a c1864a32;
                C1722f a2;
                C1864a c1864a4;
                Object obj = this.f6358j.get(c1864a32);
                int i = 0;
                if (e.get(c1864a32) != null) {
                    i = ((C1926a) e.get(c1864a32)).f6479b ? 1 : 2;
                }
                c0370a.put(c1864a32, Integer.valueOf(i));
                C1742b mfVar = new mf(c1864a32, i);
                arrayList.add(mfVar);
                C1864a c1864a5;
                if (c1864a32.m10577e()) {
                    C1862i c = c1864a32.m10575c();
                    c1864a5 = c.m10323a() == 1 ? c1864a32 : c1864a2;
                    a2 = C1866a.m10581a(c, obj, this.f6357i, this.f6362n, a, mfVar, (C1733c) mfVar);
                    c1864a4 = c1864a5;
                } else {
                    C1827b b = c1864a32.m10574b();
                    c1864a5 = b.m10323a() == 1 ? c1864a32 : c1864a2;
                    a2 = C1866a.m10580a(b, obj, this.f6357i, this.f6362n, a, mfVar, (C1733c) mfVar);
                    c1864a4 = c1864a5;
                }
                c0370a2.put(c1864a32.m10576d(), a2);
                if (!a2.m9696h()) {
                    c1864a32 = c1864a;
                } else if (c1864a != null) {
                    String valueOf = String.valueOf(c1864a32.m10578f());
                    String valueOf2 = String.valueOf(c1864a.m10578f());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                c1864a2 = c1864a4;
                c1864a = c1864a32;
            }
            if (c1864a != null) {
                if (c1864a2 != null) {
                    valueOf = String.valueOf(c1864a.m10578f());
                    valueOf2 = String.valueOf(c1864a2.m10578f());
                    throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 21) + String.valueOf(valueOf2).length()).append(valueOf).append(" cannot be used with ").append(valueOf2).toString());
                }
                C1896c.m10796a(this.f6349a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c1864a.m10578f());
                C1896c.m10796a(this.f6350b.equals(this.f6351c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c1864a.m10578f());
            }
            return new ml(this.f6357i, new ReentrantLock(), this.f6362n, a, this.f6363o, this.f6364p, c0370a, this.f6365q, this.f6366r, c0370a2, this.f6360l, ml.m9957a(c0370a2.values(), true), arrayList);
        }

        public C1866a m10584a(C1864a<? extends C1835c> c1864a) {
            C1896c.m10791a((Object) c1864a, (Object) "Api must not be null");
            this.f6358j.put(c1864a, null);
            Collection a = c1864a.m10573a().m10324a(null);
            this.f6351c.addAll(a);
            this.f6350b.addAll(a);
            return this;
        }

        public C1927n m10585a() {
            ob obVar = ob.f6222a;
            if (this.f6358j.containsKey(nz.f6220g)) {
                obVar = (ob) this.f6358j.get(nz.f6220g);
            }
            return new C1927n(this.f6349a, this.f6350b, this.f6356h, this.f6352d, this.f6353e, this.f6354f, this.f6355g, obVar);
        }

        public C1767c m10586b() {
            C1896c.m10799b(!this.f6358j.isEmpty(), "must call addApi() to add at least one API");
            C1767c c = m10583c();
            synchronized (C1767c.f5922a) {
                C1767c.f5922a.add(c);
            }
            if (this.f6360l >= 0) {
                m10582a(c);
            }
            return c;
        }
    }

    public Looper mo1604a() {
        throw new UnsupportedOperationException();
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1605a(T t) {
        throw new UnsupportedOperationException();
    }

    public void mo1606a(int i) {
        throw new UnsupportedOperationException();
    }

    public void mo1607a(ng ngVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1608a(C1733c c1733c);

    public abstract void mo1609a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1610b(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1611b();

    public void mo1612b(ng ngVar) {
        throw new UnsupportedOperationException();
    }

    public abstract void mo1613b(C1733c c1733c);

    public abstract void mo1614c();
}
