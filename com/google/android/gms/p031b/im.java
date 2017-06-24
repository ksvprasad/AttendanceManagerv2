package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.p031b.il.C1609a;
import java.util.WeakHashMap;

@id
public final class im {
    private WeakHashMap<Context, C1610a> f5299a = new WeakHashMap();

    private class C1610a {
        public final long f5296a = C1319u.m7187i().mo1723a();
        public final il f5297b;
        final /* synthetic */ im f5298c;

        public C1610a(im imVar, il ilVar) {
            this.f5298c = imVar;
            this.f5297b = ilVar;
        }

        public boolean m8969a() {
            return ((Long) cq.aw.m7801c()).longValue() + this.f5296a < C1319u.m7187i().mo1723a();
        }
    }

    public il m8970a(Context context) {
        C1610a c1610a = (C1610a) this.f5299a.get(context);
        il a = (c1610a == null || c1610a.m8969a() || !((Boolean) cq.av.m7801c()).booleanValue()) ? new C1609a(context).m8968a() : new C1609a(context, c1610a.f5297b).m8968a();
        this.f5299a.put(context, new C1610a(this, a));
        return a;
    }
}
