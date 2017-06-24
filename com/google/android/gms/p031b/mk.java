package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1857g;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.api.C1864a.C1721c;
import com.google.android.gms.p031b.mc.C1714a;
import java.util.Collections;

public class mk implements mm {
    private final mo f5918a;

    public mk(mo moVar) {
        this.f5918a = moVar;
    }

    public <A extends C1721c, R extends C1857g, T extends C1714a<R, A>> T mo1587a(T t) {
        this.f5918a.f5954g.f5923a.add(t);
        return t;
    }

    public void mo1588a() {
        this.f5918a.m10004g();
        this.f5918a.f5954g.f5926d = Collections.emptySet();
    }

    public void mo1589a(int i) {
    }

    public void mo1590a(Bundle bundle) {
    }

    public void mo1591a(ConnectionResult connectionResult, C1864a<?> c1864a, int i) {
    }

    public <A extends C1721c, T extends C1714a<? extends C1857g, A>> T mo1592b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public boolean mo1593b() {
        return true;
    }

    public void mo1594c() {
        this.f5918a.m10002e();
    }
}
