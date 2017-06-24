package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.C0971a;
import com.google.android.gms.ads.internal.client.C1091g;
import com.google.android.gms.ads.p029d.C0963b;

public final class C1034h {
    private final C1091g f3044a;

    public C1034h(Context context) {
        this.f3044a = new C1091g(context);
    }

    public void m5825a() {
        this.f3044a.m6168a();
    }

    public void m5826a(C0970a c0970a) {
        this.f3044a.m6169a(c0970a);
        if (c0970a != null && (c0970a instanceof C0971a)) {
            this.f3044a.m6171a((C0971a) c0970a);
        } else if (c0970a == null) {
            this.f3044a.m6171a(null);
        }
    }

    public void m5827a(C1026c c1026c) {
        this.f3044a.m6172a(c1026c.m5790a());
    }

    public void m5828a(C0963b c0963b) {
        this.f3044a.m6170a(c0963b);
    }

    public void m5829a(String str) {
        this.f3044a.m6173a(str);
    }

    public void m5830a(boolean z) {
        this.f3044a.m6174a(z);
    }
}
