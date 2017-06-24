package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1827b;
import com.google.android.gms.common.api.C1864a.C1830a.C1831a;
import com.google.android.gms.common.api.C1864a.C1860g;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.C1927n;
import com.google.android.gms.signin.internal.C2107g;

public final class nz {
    public static final C1860g<C2107g> f6214a = new C1860g();
    public static final C1860g<C2107g> f6215b = new C1860g();
    public static final C1827b<C2107g, ob> f6216c = new C18281();
    static final C1827b<C2107g, C1832a> f6217d = new C18292();
    public static final Scope f6218e = new Scope("profile");
    public static final Scope f6219f = new Scope("email");
    public static final C1864a<ob> f6220g = new C1864a("SignIn.API", f6216c, f6214a);
    public static final C1864a<C1832a> f6221h = new C1864a("SignIn.INTERNAL_API", f6217d, f6215b);

    class C18281 extends C1827b<C2107g, ob> {
        C18281() {
        }

        public C2107g m10327a(Context context, Looper looper, C1927n c1927n, ob obVar, C1742b c1742b, C1733c c1733c) {
            return new C2107g(context, looper, true, c1927n, obVar == null ? ob.f6222a : obVar, c1742b, c1733c);
        }
    }

    class C18292 extends C1827b<C2107g, C1832a> {
        C18292() {
        }

        public C2107g m10329a(Context context, Looper looper, C1927n c1927n, C1832a c1832a, C1742b c1742b, C1733c c1733c) {
            return new C2107g(context, looper, false, c1927n, c1832a.m10330a(), c1742b, c1733c);
        }
    }

    public static class C1832a implements C1831a {
        public Bundle m10330a() {
            return null;
        }
    }
}
