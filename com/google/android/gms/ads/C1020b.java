package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.C1088e;
import com.google.android.gms.ads.internal.client.C1103o;
import com.google.android.gms.ads.internal.client.C1108t;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.client.ad;
import com.google.android.gms.ads.internal.client.ae;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p032b.C1016b;
import com.google.android.gms.ads.p032b.C1018d.C0974a;
import com.google.android.gms.ads.p032b.C1019e.C0975a;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.du;
import com.google.android.gms.p031b.dv;
import com.google.android.gms.p031b.fw;

public class C1020b {
    private final C1108t f2996a;
    private final Context f2997b;
    private final ad f2998c;

    public static class C1011a {
        private final Context f2984a;
        private final ae f2985b;

        C1011a(Context context, ae aeVar) {
            this.f2984a = context;
            this.f2985b = aeVar;
        }

        public C1011a(Context context, String str) {
            this((Context) C1896c.m10791a((Object) context, (Object) "context cannot be null"), C1120y.m6295b().m6287a(context, str, new fw()));
        }

        public C1011a m5729a(C0970a c0970a) {
            try {
                this.f2985b.mo1015a(new C1103o(c0970a));
            } catch (Throwable e) {
                C1324b.m7235d("Failed to set AdListener.", e);
            }
            return this;
        }

        public C1011a m5730a(C1016b c1016b) {
            try {
                this.f2985b.mo1017a(new NativeAdOptionsParcel(c1016b));
            } catch (Throwable e) {
                C1324b.m7235d("Failed to specify native ad options", e);
            }
            return this;
        }

        public C1011a m5731a(C0974a c0974a) {
            try {
                this.f2985b.mo1018a(new du(c0974a));
            } catch (Throwable e) {
                C1324b.m7235d("Failed to add app install ad listener", e);
            }
            return this;
        }

        public C1011a m5732a(C0975a c0975a) {
            try {
                this.f2985b.mo1019a(new dv(c0975a));
            } catch (Throwable e) {
                C1324b.m7235d("Failed to add content ad listener", e);
            }
            return this;
        }

        public C1020b m5733a() {
            try {
                return new C1020b(this.f2984a, this.f2985b.mo1014a());
            } catch (Throwable e) {
                C1324b.m7231b("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    C1020b(Context context, ad adVar) {
        this(context, adVar, C1108t.m6240a());
    }

    C1020b(Context context, ad adVar, C1108t c1108t) {
        this.f2997b = context;
        this.f2998c = adVar;
        this.f2996a = c1108t;
    }

    private void m5764a(C1088e c1088e) {
        try {
            this.f2998c.mo1011a(this.f2996a.m6241a(this.f2997b, c1088e));
        } catch (Throwable e) {
            C1324b.m7231b("Failed to load ad.", e);
        }
    }

    public void m5765a(C1026c c1026c) {
        m5764a(c1026c.m5790a());
    }
}
