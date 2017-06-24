package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.C1180n;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.p031b.hr.C1578a;
import com.google.android.gms.p031b.hs.C1042a;
import com.google.android.gms.p031b.jl.C1632a;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@id
public class hv extends hr {
    fl f5069g;
    protected fs f5070h;
    private fx f5071i;
    private fo f5072j;
    private final cy f5073k;
    private final la f5074l;
    private boolean f5075m;

    hv(Context context, C1632a c1632a, fx fxVar, C1042a c1042a, cy cyVar, la laVar) {
        super(context, c1632a, c1042a);
        this.f5071i = fxVar;
        this.f5072j = c1632a.f5410c;
        this.f5073k = cyVar;
        this.f5074l = laVar;
    }

    private static String m8775a(fs fsVar) {
        String str = fsVar.f4851b.f4793d;
        int b = hv.m8778b(fsVar.f4850a);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(b).append(".").append(fsVar.f4856g).toString();
    }

    private static String m8776a(List<fs> list) {
        String str = "";
        if (list == null) {
            return str.toString();
        }
        String str2 = str;
        for (fs fsVar : list) {
            if (!(fsVar == null || fsVar.f4851b == null || TextUtils.isEmpty(fsVar.f4851b.f4793d))) {
                str2 = String.valueOf(str2);
                str = String.valueOf(hv.m8775a(fsVar));
                str2 = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(str).length()).append(str2).append(str).append("_").toString();
            }
        }
        return str2.substring(0, Math.max(0, str2.length() - 1));
    }

    private static int m8778b(int i) {
        switch (i) {
            case -1:
                return 4;
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            default:
                return 6;
        }
    }

    private void m8779c() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        jz.f5567a.post(new Runnable(this) {
            final /* synthetic */ hv f5068b;

            public void run() {
                synchronized (this.f5068b.d) {
                    this.f5068b.f5075m = C1180n.m6570a(this.f5068b.f5074l, this.f5068b.f5070h, countDownLatch);
                }
            }
        });
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.d) {
                if (!this.f5075m) {
                    throw new C1578a("View could not be prepared", 0);
                } else if (this.f5074l.mo1530r()) {
                    throw new C1578a("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new C1578a(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    protected jl mo1437a(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.e.f5408a;
        return new jl(adRequestInfoParcel.f3741c, this.f5074l, this.f.f3782d, i, this.f.f3784f, this.f.f3788j, this.f.f3790l, this.f.f3789k, adRequestInfoParcel.f3747i, this.f.f3786h, this.f5070h != null ? this.f5070h.f4851b : null, this.f5070h != null ? this.f5070h.f4852c : null, this.f5070h != null ? this.f5070h.f4853d : AdMobAdapter.class.getName(), this.f5072j, this.f5070h != null ? this.f5070h.f4854e : null, this.f.f3787i, this.e.f5411d, this.f.f3785g, this.e.f5413f, this.f.f3792n, this.f.f3793o, this.e.f5415h, null, this.f.f3767C, this.f.f3768D, this.f.f3769E, this.f5072j != null ? this.f5072j.f4824n : false, this.f.f3771G, this.f5069g != null ? hv.m8776a(this.f5069g.mo1346b()) : null, this.f.f3774J);
    }

    protected void mo1438a(long j) {
        boolean z;
        ListIterator listIterator;
        synchronized (this.d) {
            this.f5069g = m8782b(j);
        }
        List arrayList = new ArrayList(this.f5072j.f4811a);
        Bundle bundle = this.e.f5408a.f3741c.f3097m;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((fm) listIterator.next()).f4792c.contains(str)) {
                            listIterator.remove();
                        }
                    }
                }
                this.f5070h = this.f5069g.mo1344a(arrayList);
                switch (this.f5070h.f4850a) {
                    case 0:
                        if (this.f5070h.f4851b != null && this.f5070h.f4851b.f4801l != null) {
                            m8779c();
                            return;
                        }
                        return;
                    case 1:
                        throw new C1578a("No fill from any mediation ad networks.", 3);
                    default:
                        throw new C1578a("Unexpected mediation result: " + this.f5070h.f4850a, 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((fm) listIterator.next()).f4792c.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        this.f5070h = this.f5069g.mo1344a(arrayList);
        switch (this.f5070h.f4850a) {
            case 0:
                if (this.f5070h.f4851b != null) {
                    return;
                }
                return;
            case 1:
                throw new C1578a("No fill from any mediation ad networks.", 3);
            default:
                throw new C1578a("Unexpected mediation result: " + this.f5070h.f4850a, 0);
        }
    }

    fl m8782b(long j) {
        if (this.f5072j.f4822l != -1) {
            return new fu(this.b, this.e.f5408a, this.f5071i, this.f5072j, this.f.f3798t, this.f.f3766B, j, ((Long) cq.aK.m7801c()).longValue(), 2);
        }
        return new fv(this.b, this.e.f5408a, this.f5071i, this.f5072j, this.f.f3798t, this.f.f3766B, j, ((Long) cq.aK.m7801c()).longValue(), this.f5073k);
    }

    public void mo1109b() {
        synchronized (this.d) {
            super.mo1109b();
            if (this.f5069g != null) {
                this.f5069g.mo1345a();
            }
        }
    }
}
