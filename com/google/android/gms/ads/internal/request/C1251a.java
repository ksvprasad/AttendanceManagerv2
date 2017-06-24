package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C1249a;
import com.google.android.gms.p031b.aj;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.ju;
import java.util.concurrent.Future;

@id
public class C1251a {

    public interface C1041a {
        void mo959a(C1632a c1632a);
    }

    public ju m6895a(Context context, C1249a c1249a, aj ajVar, C1041a c1041a) {
        ju c1290n = c1249a.f3699b.f3087c.getBundle("sdk_less_server_data") != null ? new C1290n(context, c1249a, c1041a) : new C1256b(context, c1249a, ajVar, c1041a);
        Future future = (Future) c1290n.mo1107e();
        return c1290n;
    }
}
