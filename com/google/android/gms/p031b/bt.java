package com.google.android.gms.p031b;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.C1142h;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.bq.C1383a;
import com.google.android.gms.p031b.bq.C1386d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@id
public class bt implements bu {
    private final Object f4256a = new Object();
    private final WeakHashMap<jl, bq> f4257b = new WeakHashMap();
    private final ArrayList<bq> f4258c = new ArrayList();
    private final Context f4259d;
    private final VersionInfoParcel f4260e;
    private final ff f4261f;

    public bt(Context context, VersionInfoParcel versionInfoParcel, ff ffVar) {
        this.f4259d = context.getApplicationContext();
        this.f4260e = versionInfoParcel;
        this.f4261f = ffVar;
    }

    public bq m7655a(AdSizeParcel adSizeParcel, jl jlVar) {
        return m7656a(adSizeParcel, jlVar, jlVar.f5424b.mo1503b());
    }

    public bq m7656a(AdSizeParcel adSizeParcel, jl jlVar, View view) {
        return m7659a(adSizeParcel, jlVar, new C1386d(view, jlVar), null);
    }

    public bq m7657a(AdSizeParcel adSizeParcel, jl jlVar, View view, fg fgVar) {
        return m7659a(adSizeParcel, jlVar, new C1386d(view, jlVar), fgVar);
    }

    public bq m7658a(AdSizeParcel adSizeParcel, jl jlVar, C1142h c1142h) {
        return m7659a(adSizeParcel, jlVar, new C1383a(c1142h), null);
    }

    public bq m7659a(AdSizeParcel adSizeParcel, jl jlVar, bx bxVar, fg fgVar) {
        bq bqVar;
        synchronized (this.f4256a) {
            if (m7661a(jlVar)) {
                bqVar = (bq) this.f4257b.get(jlVar);
            } else {
                if (fgVar != null) {
                    bqVar = new bv(this.f4259d, adSizeParcel, jlVar, this.f4260e, bxVar, fgVar);
                } else {
                    bqVar = new bw(this.f4259d, adSizeParcel, jlVar, this.f4260e, bxVar, this.f4261f);
                }
                bqVar.m7625a((bu) this);
                this.f4257b.put(jlVar, bqVar);
                this.f4258c.add(bqVar);
            }
        }
        return bqVar;
    }

    public void mo1260a(bq bqVar) {
        synchronized (this.f4256a) {
            if (!bqVar.m7636f()) {
                this.f4258c.remove(bqVar);
                Iterator it = this.f4257b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == bqVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean m7661a(jl jlVar) {
        boolean z;
        synchronized (this.f4256a) {
            bq bqVar = (bq) this.f4257b.get(jlVar);
            z = bqVar != null && bqVar.m7636f();
        }
        return z;
    }

    public void m7662b(jl jlVar) {
        synchronized (this.f4256a) {
            bq bqVar = (bq) this.f4257b.get(jlVar);
            if (bqVar != null) {
                bqVar.mo1263d();
            }
        }
    }

    public void m7663c(jl jlVar) {
        synchronized (this.f4256a) {
            bq bqVar = (bq) this.f4257b.get(jlVar);
            if (bqVar != null) {
                bqVar.m7644n();
            }
        }
    }

    public void m7664d(jl jlVar) {
        synchronized (this.f4256a) {
            bq bqVar = (bq) this.f4257b.get(jlVar);
            if (bqVar != null) {
                bqVar.m7645o();
            }
        }
    }

    public void m7665e(jl jlVar) {
        synchronized (this.f4256a) {
            bq bqVar = (bq) this.f4257b.get(jlVar);
            if (bqVar != null) {
                bqVar.m7646p();
            }
        }
    }
}
