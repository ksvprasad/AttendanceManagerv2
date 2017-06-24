package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.C1767c.C1866a;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p031b.ob;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class C1927n {
    private final Account f6480a;
    private final Set<Scope> f6481b;
    private final Set<Scope> f6482c;
    private final Map<C1864a<?>, C1926a> f6483d;
    private final int f6484e;
    private final View f6485f;
    private final String f6486g;
    private final String f6487h;
    private final ob f6488i;
    private Integer f6489j;

    public static final class C1926a {
        public final Set<Scope> f6478a;
        public final boolean f6479b;
    }

    public C1927n(Account account, Set<Scope> set, Map<C1864a<?>, C1926a> map, int i, View view, String str, String str2, ob obVar) {
        Map map2;
        this.f6480a = account;
        this.f6481b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f6483d = map2;
        this.f6485f = view;
        this.f6484e = i;
        this.f6486g = str;
        this.f6487h = str2;
        this.f6488i = obVar;
        Set hashSet = new HashSet(this.f6481b);
        for (C1926a c1926a : this.f6483d.values()) {
            hashSet.addAll(c1926a.f6478a);
        }
        this.f6482c = Collections.unmodifiableSet(hashSet);
    }

    public static C1927n m10867a(Context context) {
        return new C1866a(context).m10585a();
    }

    public Account m10868a() {
        return this.f6480a;
    }

    public void m10869a(Integer num) {
        this.f6489j = num;
    }

    public Account m10870b() {
        return this.f6480a != null ? this.f6480a : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> m10871c() {
        return this.f6481b;
    }

    public Set<Scope> m10872d() {
        return this.f6482c;
    }

    public Map<C1864a<?>, C1926a> m10873e() {
        return this.f6483d;
    }

    public String m10874f() {
        return this.f6486g;
    }

    public String m10875g() {
        return this.f6487h;
    }

    public ob m10876h() {
        return this.f6488i;
    }

    public Integer m10877i() {
        return this.f6489j;
    }
}
