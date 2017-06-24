package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.C1088e;
import com.google.android.gms.ads.internal.client.C1088e.C1087a;
import com.google.android.gms.ads.mediation.C0957b;
import java.util.Date;

public final class C1026c {
    public static final String f3013a = C1088e.f3162a;
    private final C1088e f3014b;

    public static final class C1022a {
        private final C1087a f2999a = new C1087a();

        public C1022a() {
            this.f2999a.m6111b(C1026c.f3013a);
        }

        public C1022a m5767a(int i) {
            this.f2999a.m6105a(i);
            return this;
        }

        public C1022a m5768a(Location location) {
            this.f2999a.m6106a(location);
            return this;
        }

        public C1022a m5769a(Class<? extends C0957b> cls, Bundle bundle) {
            this.f2999a.m6107a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f2999a.m6113c(C1026c.f3013a);
            }
            return this;
        }

        public C1022a m5770a(String str) {
            this.f2999a.m6108a(str);
            return this;
        }

        public C1022a m5771a(Date date) {
            this.f2999a.m6109a(date);
            return this;
        }

        public C1022a m5772a(boolean z) {
            this.f2999a.m6110a(z);
            return this;
        }

        public C1026c m5773a() {
            return new C1026c();
        }

        public C1022a m5774b(String str) {
            this.f2999a.m6111b(str);
            return this;
        }

        public C1022a m5775b(boolean z) {
            this.f2999a.m6112b(z);
            return this;
        }
    }

    private C1026c(C1022a c1022a) {
        this.f3014b = new C1088e(c1022a.f2999a);
    }

    public C1088e m5790a() {
        return this.f3014b;
    }
}
