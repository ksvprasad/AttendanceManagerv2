package com.google.android.gms.p031b;

import android.location.Location;
import com.google.android.gms.ads.mediation.C1331a;
import java.util.Date;
import java.util.Set;

@id
public final class gd implements C1331a {
    private final Date f4905a;
    private final int f4906b;
    private final Set<String> f4907c;
    private final boolean f4908d;
    private final Location f4909e;
    private final int f4910f;
    private final boolean f4911g;

    public gd(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.f4905a = date;
        this.f4906b = i;
        this.f4907c = set;
        this.f4909e = location;
        this.f4908d = z;
        this.f4910f = i2;
        this.f4911g = z2;
    }

    public Date mo1398a() {
        return this.f4905a;
    }

    public int mo1399b() {
        return this.f4906b;
    }

    public Set<String> mo1400c() {
        return this.f4907c;
    }

    public Location mo1401d() {
        return this.f4909e;
    }

    public int mo1402e() {
        return this.f4910f;
    }

    public boolean mo1403f() {
        return this.f4908d;
    }

    public boolean mo1404g() {
        return this.f4911g;
    }
}
