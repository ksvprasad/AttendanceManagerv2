package com.google.android.gms.p031b;

import android.location.Location;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.C1347l;
import com.google.android.gms.ads.p032b.C1016b;
import com.google.android.gms.ads.p032b.C1016b.C1015a;
import java.util.Date;
import java.util.List;
import java.util.Set;

@id
public final class gi implements C1347l {
    private final Date f4918a;
    private final int f4919b;
    private final Set<String> f4920c;
    private final boolean f4921d;
    private final Location f4922e;
    private final int f4923f;
    private final NativeAdOptionsParcel f4924g;
    private final List<String> f4925h;
    private final boolean f4926i;

    public gi(Date date, int i, Set<String> set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.f4918a = date;
        this.f4919b = i;
        this.f4920c = set;
        this.f4922e = location;
        this.f4921d = z;
        this.f4923f = i2;
        this.f4924g = nativeAdOptionsParcel;
        this.f4925h = list;
        this.f4926i = z2;
    }

    public Date mo1398a() {
        return this.f4918a;
    }

    public int mo1399b() {
        return this.f4919b;
    }

    public Set<String> mo1400c() {
        return this.f4920c;
    }

    public Location mo1401d() {
        return this.f4922e;
    }

    public int mo1402e() {
        return this.f4923f;
    }

    public boolean mo1403f() {
        return this.f4921d;
    }

    public boolean mo1404g() {
        return this.f4926i;
    }

    public C1016b mo1423h() {
        return this.f4924g == null ? null : new C1015a().m5743a(this.f4924g.f3298b).m5742a(this.f4924g.f3299c).m5745b(this.f4924g.f3300d).m5744a();
    }

    public boolean mo1424i() {
        return this.f4925h != null && this.f4925h.contains("2");
    }

    public boolean mo1425j() {
        return this.f4925h != null && this.f4925h.contains("1");
    }
}
