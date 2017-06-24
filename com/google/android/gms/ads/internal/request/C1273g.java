package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.C1259c.C1255a;
import com.google.android.gms.ads.internal.request.C1271l.C1272a;
import com.google.android.gms.p031b.id;
import java.lang.ref.WeakReference;

@id
public final class C1273g extends C1272a {
    private final WeakReference<C1255a> f3875a;

    public C1273g(C1255a c1255a) {
        this.f3875a = new WeakReference(c1255a);
    }

    public void mo1184a(AdResponseParcel adResponseParcel) {
        C1255a c1255a = (C1255a) this.f3875a.get();
        if (c1255a != null) {
            c1255a.mo1173a(adResponseParcel);
        }
    }
}
