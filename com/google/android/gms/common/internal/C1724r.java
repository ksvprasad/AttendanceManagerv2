package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.C1877b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1864a.C1722f;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1268k.C1265b;
import com.google.android.gms.common.internal.C1268k.C1266c;
import com.google.android.gms.common.internal.C1935s.C1723a;
import java.util.Set;

public abstract class C1724r<T extends IInterface> extends C1268k<T> implements C1722f, C1723a {
    private final C1927n f5814a;
    private final Set<Scope> f5815e;
    private final Account f5816f;

    class C19331 implements C1265b {
        final /* synthetic */ C1742b f6497a;

        C19331(C1742b c1742b) {
            this.f6497a = c1742b;
        }

        public void mo1178a(int i) {
            this.f6497a.mo1574a(i);
        }

        public void mo1179a(Bundle bundle) {
            this.f6497a.mo1575a(bundle);
        }
    }

    class C19342 implements C1266c {
        final /* synthetic */ C1733c f6498a;

        C19342(C1733c c1733c) {
            this.f6498a = c1733c;
        }

        public void mo1180a(ConnectionResult connectionResult) {
            this.f6498a.mo1564a(connectionResult);
        }
    }

    protected C1724r(Context context, Looper looper, int i, C1927n c1927n, C1742b c1742b, C1733c c1733c) {
        this(context, looper, C1939t.m10955a(context), C1877b.m10617a(), i, c1927n, (C1742b) C1896c.m10790a((Object) c1742b), (C1733c) C1896c.m10790a((Object) c1733c));
    }

    protected C1724r(Context context, Looper looper, C1939t c1939t, C1877b c1877b, int i, C1927n c1927n, C1742b c1742b, C1733c c1733c) {
        super(context, looper, c1939t, c1877b, i, C1724r.m9701a(c1742b), C1724r.m9702a(c1733c), c1927n.m10875g());
        this.f5814a = c1927n;
        this.f5816f = c1927n.m10868a();
        this.f5815e = m9703b(c1927n.m10872d());
    }

    private static C1265b m9701a(C1742b c1742b) {
        return c1742b == null ? null : new C19331(c1742b);
    }

    private static C1266c m9702a(C1733c c1733c) {
        return c1733c == null ? null : new C19342(c1733c);
    }

    private Set<Scope> m9703b(Set<Scope> set) {
        Set<Scope> a = m9704a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> m9704a(Set<Scope> set) {
        return set;
    }

    public final Account mo1556p() {
        return this.f5816f;
    }

    protected final Set<Scope> mo1557w() {
        return this.f5815e;
    }
}
