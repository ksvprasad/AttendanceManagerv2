package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.ad.C1063a;
import com.google.android.gms.ads.internal.client.ae.C1065a;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C1323a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.dp;
import com.google.android.gms.p031b.dq;
import com.google.android.gms.p031b.dr;
import com.google.android.gms.p031b.ds;

public class C1096i extends C1065a {
    private ac f3218a;

    private class C1095a extends C1063a {
        final /* synthetic */ C1096i f3217a;

        class C10941 implements Runnable {
            final /* synthetic */ C1095a f3216a;

            C10941(C1095a c1095a) {
                this.f3216a = c1095a;
            }

            public void run() {
                if (this.f3216a.f3217a.f3218a != null) {
                    try {
                        this.f3216a.f3217a.f3218a.mo1007a(1);
                    } catch (Throwable e) {
                        C1324b.m7235d("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        }

        private C1095a(C1096i c1096i) {
            this.f3217a = c1096i;
        }

        public void mo1011a(AdRequestParcel adRequestParcel) {
            C1324b.m7230b("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
            C1323a.f3964a.post(new C10941(this));
        }

        public boolean mo1012a() {
            return false;
        }

        public String mo1013b() {
            return null;
        }
    }

    public ad mo1014a() {
        return new C1095a();
    }

    public void mo1015a(ac acVar) {
        this.f3218a = acVar;
    }

    public void mo1016a(ak akVar) {
    }

    public void mo1017a(NativeAdOptionsParcel nativeAdOptionsParcel) {
    }

    public void mo1018a(dp dpVar) {
    }

    public void mo1019a(dq dqVar) {
    }

    public void mo1020a(String str, ds dsVar, dr drVar) {
    }
}
