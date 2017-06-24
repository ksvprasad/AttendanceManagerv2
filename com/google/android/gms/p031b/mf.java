package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.C1767c.C1733c;
import com.google.android.gms.common.api.C1767c.C1742b;
import com.google.android.gms.common.api.C1864a;
import com.google.android.gms.common.internal.C1896c;

public class mf implements C1742b, C1733c {
    public final C1864a<?> f5854a;
    private final int f5855b;
    private mo f5856c;

    public mf(C1864a<?> c1864a, int i) {
        this.f5854a = c1864a;
        this.f5855b = i;
    }

    private void m9792a() {
        C1896c.m10791a(this.f5856c, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void mo1574a(int i) {
        m9792a();
        this.f5856c.m9991a(i);
    }

    public void mo1575a(Bundle bundle) {
        m9792a();
        this.f5856c.m9992a(bundle);
    }

    public void m9795a(mo moVar) {
        this.f5856c = moVar;
    }

    public void mo1564a(ConnectionResult connectionResult) {
        m9792a();
        this.f5856c.m9995a(connectionResult, this.f5854a, this.f5855b);
    }
}
