package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1043a;
import com.google.android.gms.ads.internal.C1245q;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.p031b.jl.C1632a;

@id
public class hs {

    public interface C1042a {
        void mo966b(jl jlVar);
    }

    public kb m8766a(Context context, C1043a c1043a, C1632a c1632a, aj ajVar, la laVar, fx fxVar, C1042a c1042a, cy cyVar) {
        kb hvVar;
        AdResponseParcel adResponseParcel = c1632a.f5409b;
        if (adResponseParcel.f3786h) {
            hvVar = new hv(context, c1632a, fxVar, c1042a, cyVar, laVar);
        } else if (!adResponseParcel.f3798t) {
            hvVar = adResponseParcel.f3794p ? new hq(context, c1632a, laVar, c1042a) : (((Boolean) cq.f4381V.m7801c()).booleanValue() && C1979l.m11114h() && !C1979l.m11116j() && laVar != null && laVar.mo1518k().f3107e) ? new hu(context, c1632a, laVar, c1042a) : new ht(context, c1632a, laVar, c1042a);
        } else if (c1043a instanceof C1245q) {
            hvVar = new hw(context, (C1245q) c1043a, c1632a, ajVar, c1042a);
        } else {
            String valueOf = String.valueOf(c1043a != null ? c1043a.getClass().getName() : "null");
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 65).append("Invalid NativeAdManager type. Found: ").append(valueOf).append("; Required: NativeAdManager.").toString());
        }
        String str = "AdRenderer: ";
        String valueOf2 = String.valueOf(hvVar.getClass().getName());
        C1324b.m7227a(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
        hvVar.mo1107e();
        return hvVar;
    }

    public kb m8767a(Context context, C1632a c1632a, iw iwVar) {
        kb jcVar = new jc(context, c1632a, iwVar);
        String str = "AdRenderer: ";
        String valueOf = String.valueOf(jcVar.getClass().getName());
        C1324b.m7227a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        jcVar.mo1107e();
        return jcVar;
    }
}
