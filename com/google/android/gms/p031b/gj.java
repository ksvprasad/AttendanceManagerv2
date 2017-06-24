package com.google.android.gms.p031b;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.C0978c;
import com.google.ads.mediation.C0983d;
import com.google.ads.mediation.C0984f;
import com.google.ads.mediation.C0988h;
import com.google.ads.mediation.C0994i;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.C1308a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.fy.C1537a;
import com.google.android.gms.p033a.C0998a;
import com.google.android.gms.p033a.C1001b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@id
public final class gj<NETWORK_EXTRAS extends C0994i, SERVER_PARAMETERS extends C0988h> extends C1537a {
    private final C0978c<NETWORK_EXTRAS, SERVER_PARAMETERS> f4927a;
    private final NETWORK_EXTRAS f4928b;

    public gj(C0978c<NETWORK_EXTRAS, SERVER_PARAMETERS> c0978c, NETWORK_EXTRAS network_extras) {
        this.f4927a = c0978c;
        this.f4928b = network_extras;
    }

    private SERVER_PARAMETERS m8599a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                C1324b.m7235d("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class c = this.f4927a.mo922c();
        if (c == null) {
            return null;
        }
        C0988h c0988h = (C0988h) c.newInstance();
        c0988h.m5707a(hashMap);
        return c0988h;
    }

    public C0998a mo1349a() {
        if (this.f4927a instanceof C0983d) {
            try {
                return C1001b.m5713a(((C0983d) this.f4927a).mo923d());
            } catch (Throwable th) {
                C1324b.m7235d("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4927a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1350a(C0998a c0998a) {
    }

    public void mo1351a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, C1308a c1308a, String str2) {
    }

    public void mo1352a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, fz fzVar) {
        mo1353a(c0998a, adRequestParcel, str, null, fzVar);
    }

    public void mo1353a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, String str2, fz fzVar) {
        if (this.f4927a instanceof C0984f) {
            C1324b.m7227a("Requesting interstitial ad from adapter.");
            try {
                ((C0984f) this.f4927a).mo920a(new gk(fzVar), (Activity) C1001b.m5714a(c0998a), m8599a(str, adRequestParcel.f3091g, str2), gl.m8627a(adRequestParcel), this.f4928b);
            } catch (Throwable th) {
                C1324b.m7235d("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4927a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1354a(C0998a c0998a, AdRequestParcel adRequestParcel, String str, String str2, fz fzVar, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void mo1355a(C0998a c0998a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, fz fzVar) {
        mo1356a(c0998a, adSizeParcel, adRequestParcel, str, null, fzVar);
    }

    public void mo1356a(C0998a c0998a, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, fz fzVar) {
        if (this.f4927a instanceof C0983d) {
            C1324b.m7227a("Requesting banner ad from adapter.");
            try {
                ((C0983d) this.f4927a).mo919a(new gk(fzVar), (Activity) C1001b.m5714a(c0998a), m8599a(str, adRequestParcel.f3091g, str2), gl.m8626a(adSizeParcel), gl.m8627a(adRequestParcel), this.f4928b);
            } catch (Throwable th) {
                C1324b.m7235d("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f4927a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public void mo1357a(AdRequestParcel adRequestParcel, String str) {
    }

    public void mo1358a(AdRequestParcel adRequestParcel, String str, String str2) {
    }

    public void mo1359b() {
        if (this.f4927a instanceof C0984f) {
            C1324b.m7227a("Showing interstitial from adapter.");
            try {
                ((C0984f) this.f4927a).mo924e();
            } catch (Throwable th) {
                C1324b.m7235d("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f4927a.getClass().getCanonicalName());
            C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public void mo1360c() {
        try {
            this.f4927a.mo918a();
        } catch (Throwable th) {
            C1324b.m7235d("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void mo1361d() {
        throw new RemoteException();
    }

    public void mo1362e() {
        throw new RemoteException();
    }

    public void mo1363f() {
    }

    public boolean mo1364g() {
        return true;
    }

    public gb mo1365h() {
        return null;
    }

    public gc mo1366i() {
        return null;
    }

    public Bundle mo1367j() {
        return new Bundle();
    }

    public Bundle mo1368k() {
        return new Bundle();
    }

    public Bundle mo1369l() {
        return new Bundle();
    }
}
