package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1173l;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.C1896c;
import java.util.Iterator;
import java.util.LinkedList;

@id
class ez {
    private final LinkedList<C1485a> f4628a = new LinkedList();
    private AdRequestParcel f4629b;
    private final String f4630c;
    private final int f4631d;
    private boolean f4632e;

    class C1485a {
        C1173l f4621a;
        AdRequestParcel f4622b;
        ev f4623c;
        long f4624d;
        boolean f4625e;
        boolean f4626f;
        final /* synthetic */ ez f4627g;

        C1485a(ez ezVar, eu euVar) {
            this.f4627g = ezVar;
            this.f4621a = euVar.m8082b(ezVar.f4630c);
            this.f4623c = new ev();
            this.f4623c.m8120a(this.f4621a);
        }

        C1485a(ez ezVar, eu euVar, AdRequestParcel adRequestParcel) {
            this(ezVar, euVar);
            this.f4622b = adRequestParcel;
        }

        void m8146a() {
            if (!this.f4625e) {
                this.f4626f = this.f4621a.mo964a(ex.m8132b(this.f4622b != null ? this.f4622b : this.f4627g.f4629b));
                this.f4625e = true;
                this.f4624d = C1319u.m7187i().mo1723a();
            }
        }
    }

    ez(AdRequestParcel adRequestParcel, String str, int i) {
        C1896c.m10790a((Object) adRequestParcel);
        C1896c.m10790a((Object) str);
        this.f4629b = adRequestParcel;
        this.f4630c = str;
        this.f4631d = i;
    }

    AdRequestParcel m8149a() {
        return this.f4629b;
    }

    C1485a m8150a(AdRequestParcel adRequestParcel) {
        if (adRequestParcel != null) {
            this.f4629b = adRequestParcel;
        }
        return (C1485a) this.f4628a.remove();
    }

    void m8151a(eu euVar) {
        C1485a c1485a = new C1485a(this, euVar);
        this.f4628a.add(c1485a);
        c1485a.m8146a();
    }

    void m8152a(eu euVar, AdRequestParcel adRequestParcel) {
        this.f4628a.add(new C1485a(this, euVar, adRequestParcel));
    }

    int m8153b() {
        return this.f4631d;
    }

    String m8154c() {
        return this.f4630c;
    }

    int m8155d() {
        return this.f4628a.size();
    }

    int m8156e() {
        Iterator it = this.f4628a.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((C1485a) it.next()).f4625e ? i + 1 : i;
        }
        return i;
    }

    void m8157f() {
        Iterator it = this.f4628a.iterator();
        while (it.hasNext()) {
            ((C1485a) it.next()).m8146a();
        }
    }

    void m8158g() {
        this.f4632e = true;
    }

    boolean m8159h() {
        return this.f4632e;
    }
}
