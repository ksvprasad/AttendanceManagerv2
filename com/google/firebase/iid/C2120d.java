package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class C2120d {
    static Map<String, C2120d> f7103a = new HashMap();
    static String f7104f;
    private static C2124g f7105g;
    private static C2123f f7106h;
    Context f7107b;
    KeyPair f7108c;
    String f7109d = "";
    long f7110e;

    protected C2120d(Context context, String str, Bundle bundle) {
        this.f7107b = context.getApplicationContext();
        this.f7109d = str;
    }

    public static synchronized C2120d m12156a(Context context, Bundle bundle) {
        C2120d c2120d;
        synchronized (C2120d.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (f7105g == null) {
                f7105g = new C2124g(applicationContext);
                f7106h = new C2123f(applicationContext);
            }
            f7104f = Integer.toString(FirebaseInstanceId.m12111b(applicationContext));
            c2120d = (C2120d) f7103a.get(str);
            if (c2120d == null) {
                c2120d = new C2120d(applicationContext, str, bundle);
                f7103a.put(str, c2120d);
            }
        }
        return c2120d;
    }

    KeyPair m12157a() {
        if (this.f7108c == null) {
            this.f7108c = f7105g.m12197c(this.f7109d);
        }
        if (this.f7108c == null) {
            this.f7110e = System.currentTimeMillis();
            this.f7108c = f7105g.m12191a(this.f7109d, this.f7110e);
        }
        return this.f7108c;
    }

    public void m12158a(String str, String str2, Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        f7105g.m12195b(this.f7109d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.f7109d) ? str : this.f7109d);
        String str3 = "X-subtype";
        if (!"".equals(this.f7109d)) {
            str = this.f7109d;
        }
        bundle.putString(str3, str);
        f7106h.m12182b(f7106h.m12176a(bundle, m12157a()));
    }

    public String m12159b(String str, String str2, Bundle bundle) {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String a = m12164e() ? null : f7105g.m12190a(this.f7109d, str, str2);
        if (a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString("type"))) {
                obj = obj2;
            }
            a = m12162c(str, str2, bundle);
            if (!(a == null || r1 == null)) {
                f7105g.m12193a(this.f7109d, str, str2, a, f7104f);
            }
        }
        return a;
    }

    public void m12160b() {
        this.f7110e = 0;
        f7105g.m12199d(this.f7109d);
        this.f7108c = null;
    }

    public C2124g m12161c() {
        return f7105g;
    }

    public String m12162c(String str, String str2, Bundle bundle) {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.f7109d) ? str : this.f7109d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return f7106h.m12182b(f7106h.m12176a(bundle, m12157a()));
    }

    public C2123f m12163d() {
        return f7106h;
    }

    boolean m12164e() {
        String a = f7105g.m12188a("appVersion");
        if (a == null || !a.equals(f7104f)) {
            return true;
        }
        a = f7105g.m12188a("lastToken");
        if (a == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }
}
