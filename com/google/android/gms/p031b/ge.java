package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C1330k;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C1308a;
import com.google.android.gms.ads.internal.reward.mediation.client.C1311b;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.mediation.C0957b;
import com.google.android.gms.ads.mediation.C0959c;
import com.google.android.gms.ads.mediation.C0960g;
import com.google.android.gms.ads.mediation.C0961e;
import com.google.android.gms.ads.mediation.C0965i;
import com.google.android.gms.ads.mediation.C0966j;
import com.google.android.gms.ads.mediation.C0968k;
import com.google.android.gms.ads.mediation.C1348m;
import com.google.android.gms.ads.p029d.p030a.C0958a;
import com.google.android.gms.p031b.fy.C1537a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@id
public final class ge extends C1537a {
    private final C0957b f4912a;
    private gf f4913b;

    public ge(C0957b c0957b) {
        this.f4912a = c0957b;
    }

    private Bundle m8520a(String str, int i, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    valueOf = (String) keys.next();
                    bundle2.putString(valueOf, jSONObject.getString(valueOf));
                }
                bundle = bundle2;
            }
            if (this.f4912a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            C1324b.m7235d("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0998a mo1349a() {
        if (this.f4912a instanceof C0959c) {
            try {
                return C1001b.m5713a(((C0959c) this.f4912a).getBannerView());
            } catch (Throwable th) {
                C1324b.m7235d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1350a(C0998a c0998a) {
        try {
            ((C1348m) this.f4912a).m7298a((Context) C1001b.m5714a(c0998a));
        } catch (Throwable th) {
            C1324b.m7228a("Could not inform adapter of changed context", th);
        }
    }

    public void mo1351a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, C1308a c1308a, String str2) {
        if (this.f4912a instanceof C0958a) {
            C1324b.m7227a("Initialize rewarded video adapter.");
            try {
                C0958a c0958a = (C0958a) this.f4912a;
                c0958a.initialize((Context) C1001b.m5714a(c0998a), new gd(adRequestParcel.f3086b == -1 ? null : new Date(adRequestParcel.f3086b), adRequestParcel.f3088d, adRequestParcel.f3089e != null ? new HashSet(adRequestParcel.f3089e) : null, adRequestParcel.f3095k, adRequestParcel.f3090f, adRequestParcel.f3091g, adRequestParcel.f3102r), str, new C1311b(c1308a), m8520a(str2, adRequestParcel.f3091g, null), adRequestParcel.f3097m != null ? adRequestParcel.f3097m.getBundle(c0958a.getClass().getName()) : null);
            } catch (Throwable th) {
                C1324b.m7235d("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1352a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, fz fzVar) {
        mo1353a(c0998a, adRequestParcel, str, null, fzVar);
    }

    public void mo1353a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, String str2, fz fzVar) {
        if (this.f4912a instanceof C0961e) {
            C1324b.m7227a("Requesting interstitial ad from adapter.");
            try {
                C0961e c0961e = (C0961e) this.f4912a;
                c0961e.requestInterstitialAd((Context) C1001b.m5714a(c0998a), new gf(fzVar), m8520a(str, adRequestParcel.f3091g, str2), new gd(adRequestParcel.f3086b == -1 ? null : new Date(adRequestParcel.f3086b), adRequestParcel.f3088d, adRequestParcel.f3089e != null ? new HashSet(adRequestParcel.f3089e) : null, adRequestParcel.f3095k, adRequestParcel.f3090f, adRequestParcel.f3091g, adRequestParcel.f3102r), adRequestParcel.f3097m != null ? adRequestParcel.f3097m.getBundle(c0961e.getClass().getName()) : null);
            } catch (Throwable th) {
                C1324b.m7235d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1354a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, String str2, fz fzVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        if (this.f4912a instanceof C0960g) {
            try {
                C0960g c0960g = (C0960g) this.f4912a;
                gi giVar = new gi(adRequestParcel.f3086b == -1 ? null : new Date(adRequestParcel.f3086b), adRequestParcel.f3088d, adRequestParcel.f3089e != null ? new HashSet(adRequestParcel.f3089e) : null, adRequestParcel.f3095k, adRequestParcel.f3090f, adRequestParcel.f3091g, nativeAdOptionsParcel, list, adRequestParcel.f3102r);
                Bundle bundle = adRequestParcel.f3097m != null ? adRequestParcel.f3097m.getBundle(c0960g.getClass().getName()) : null;
                this.f4913b = new gf(fzVar);
                c0960g.requestNativeAd((Context) C1001b.m5714a(c0998a), this.f4913b, m8520a(str, adRequestParcel.f3091g, str2), giVar, bundle);
            } catch (Throwable th) {
                C1324b.m7235d("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1355a(C0998a c0998a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, fz fzVar) {
        mo1356a(c0998a, adSizeParcel, adRequestParcel, str, null, fzVar);
    }

    public void mo1356a(C0998a c0998a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, fz fzVar) {
        if (this.f4912a instanceof C0959c) {
            C1324b.m7227a("Requesting banner ad from adapter.");
            try {
                C0959c c0959c = (C0959c) this.f4912a;
                c0959c.requestBannerAd((Context) C1001b.m5714a(c0998a), new gf(fzVar), m8520a(str, adRequestParcel.f3091g, str2), C1330k.m7257a(adSizeParcel.f3108f, adSizeParcel.f3105c, adSizeParcel.f3104b), new gd(adRequestParcel.f3086b == -1 ? null : new Date(adRequestParcel.f3086b), adRequestParcel.f3088d, adRequestParcel.f3089e != null ? new HashSet(adRequestParcel.f3089e) : null, adRequestParcel.f3095k, adRequestParcel.f3090f, adRequestParcel.f3091g, adRequestParcel.f3102r), adRequestParcel.f3097m != null ? adRequestParcel.f3097m.getBundle(c0959c.getClass().getName()) : null);
            } catch (Throwable th) {
                C1324b.m7235d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1357a(AdRequestParcel adRequestParcel, String str) {
        mo1358a(adRequestParcel, str, null);
    }

    public void mo1358a(AdRequestParcel adRequestParcel, String str, String str2) {
        if (this.f4912a instanceof C0958a) {
            C1324b.m7227a("Requesting rewarded video ad from adapter.");
            try {
                C0958a c0958a = (C0958a) this.f4912a;
                c0958a.loadAd(new gd(adRequestParcel.f3086b == -1 ? null : new Date(adRequestParcel.f3086b), adRequestParcel.f3088d, adRequestParcel.f3089e != null ? new HashSet(adRequestParcel.f3089e) : null, adRequestParcel.f3095k, adRequestParcel.f3090f, adRequestParcel.f3091g, adRequestParcel.f3102r), m8520a(str, adRequestParcel.f3091g, str2), adRequestParcel.f3097m != null ? adRequestParcel.f3097m.getBundle(c0958a.getClass().getName()) : null);
            } catch (Throwable th) {
                C1324b.m7235d("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1359b() {
        if (this.f4912a instanceof C0961e) {
            C1324b.m7227a("Showing interstitial from adapter.");
            try {
                ((C0961e) this.f4912a).showInterstitial();
            } catch (Throwable th) {
                C1324b.m7235d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1360c() {
        try {
            this.f4912a.onDestroy();
        } catch (Throwable th) {
            C1324b.m7235d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1361d() {
        try {
            this.f4912a.onPause();
        } catch (Throwable th) {
            C1324b.m7235d("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1362e() {
        try {
            this.f4912a.onResume();
        } catch (Throwable th) {
            C1324b.m7235d("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1363f() {
        if (this.f4912a instanceof C0958a) {
            C1324b.m7227a("Show rewarded video ad from adapter.");
            try {
                ((C0958a) this.f4912a).showVideo();
            } catch (Throwable th) {
                C1324b.m7235d("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public boolean mo1364g() {
        if (this.f4912a instanceof C0958a) {
            C1324b.m7227a("Check if adapter is initialized.");
            try {
                return ((C0958a) this.f4912a).isInitialized();
            } catch (Throwable th) {
                C1324b.m7235d("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public gb mo1365h() {
        C0965i a = this.f4913b.m8542a();
        return a instanceof C0966j ? new gg((C0966j) a) : null;
    }

    public gc mo1366i() {
        C0965i a = this.f4913b.m8542a();
        return a instanceof C0968k ? new gh((C0968k) a) : null;
    }

    public Bundle mo1367j() {
        if (this.f4912a instanceof ll) {
            return ((ll) this.f4912a).m9630a();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
        C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle mo1368k() {
        if (this.f4912a instanceof lm) {
            return ((lm) this.f4912a).getInterstitialAdapterInfo();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.f4912a.getClass().getCanonicalName());
        C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public Bundle mo1369l() {
        return new Bundle();
    }
}
