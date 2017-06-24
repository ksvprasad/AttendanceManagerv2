package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.C1305f;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.p031b.dt;
import com.google.android.gms.p031b.gw;
import com.google.android.gms.p031b.hj;
import com.google.android.gms.p031b.id;

@id
public class C1120y {
    private static final Object f3277a = new Object();
    private static C1120y f3278b;
    private final C1323a f3279c = new C1323a();
    private final C1119x f3280d = new C1119x(new C1105q(), new C1104p(), new C1092h(), new dt(), new C1305f(), new hj(), new gw());

    static {
        C1120y.m6294a(new C1120y());
    }

    protected C1120y() {
    }

    public static C1323a m6293a() {
        return C1120y.m6296c().f3279c;
    }

    protected static void m6294a(C1120y c1120y) {
        synchronized (f3277a) {
            f3278b = c1120y;
        }
    }

    public static C1119x m6295b() {
        return C1120y.m6296c().f3280d;
    }

    private static C1120y m6296c() {
        C1120y c1120y;
        synchronized (f3277a) {
            c1120y = f3278b;
        }
        return c1120y;
    }
}
