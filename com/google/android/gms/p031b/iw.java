package com.google.android.gms.p031b;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.ads.mediation.C0962a;
import com.google.android.gms.ads.internal.C1050b;
import com.google.android.gms.ads.internal.C1122d;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.C1896c;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p033a.C1001b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@id
public class iw extends C1050b implements iz {
    private static final fw f5308l = new fw();
    private final Map<String, jd> f5309m = new HashMap();
    private boolean f5310n;

    public iw(Context context, C1122d c1122d, AdSizeParcel adSizeParcel, fx fxVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, null, fxVar, versionInfoParcel, c1122d);
    }

    private C1632a m8999b(C1632a c1632a) {
        jv.m9152e("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = ig.m8898a(c1632a.f5409b).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C0962a.AD_UNIT_ID_PARAMETER, c1632a.f5408a.f3743e);
            fm fmVar = new fm(jSONObject, null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), null, null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), null, Collections.emptyList(), Collections.emptyList(), null, null, null, null, null, Collections.emptyList());
            return new C1632a(c1632a.f5408a, c1632a.f5409b, new fo(Arrays.asList(new fm[]{fmVar}), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, null, 0, -1, -1, false), c1632a.f5411d, c1632a.f5412e, c1632a.f5413f, c1632a.f5414g, c1632a.f5415h);
        } catch (Throwable e) {
            C1324b.m7231b("Unable to generate ad state for non-mediated rewarded video.", e);
            return m9000c(c1632a);
        }
    }

    private C1632a m9000c(C1632a c1632a) {
        return new C1632a(c1632a.f5408a, c1632a.f5409b, null, c1632a.f5411d, 0, c1632a.f5413f, c1632a.f5414g, c1632a.f5415h);
    }

    public void m9001D() {
        C1896c.m10797b("showAd must be called on the main UI thread.");
        if (m9002E()) {
            this.f5310n = true;
            jd c = m9015c(this.f.f3997j.f5439q);
            if (c != null && c.m9070a() != null) {
                try {
                    c.m9070a().mo1363f();
                    return;
                } catch (Throwable e) {
                    C1324b.m7235d("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        C1324b.m7234d("The reward video has not loaded.");
    }

    public boolean m9002E() {
        C1896c.m10797b("isLoaded must be called on the main UI thread.");
        return this.f.f3994g == null && this.f.f3995h == null && this.f.f3997j != null && !this.f5310n;
    }

    public void mo1448F() {
        mo1049a(this.f.f3997j, false);
        m5908q();
    }

    public void mo1449G() {
        if (!(this.f.f3997j == null || this.f.f3997j.f5437o == null)) {
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, this.f.f3997j, this.f.f3989b, false, this.f.f3997j.f5437o.f4799j);
        }
        m5910s();
    }

    public void mo1450H() {
        mo1115o();
    }

    public void mo1451I() {
        mo915e();
    }

    public void mo1452J() {
        m5907p();
    }

    public void m9008a(Context context) {
        for (jd a : this.f5309m.values()) {
            try {
                a.m9070a().mo1350a(C1001b.m5713a((Object) context));
            } catch (Throwable e) {
                C1324b.m7231b("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void m9009a(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        C1896c.m10797b("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.f3900c)) {
            C1324b.m7234d("Invalid ad unit id. Aborting.");
            return;
        }
        this.f5310n = false;
        this.f.f3989b = rewardedVideoAdRequestParcel.f3900c;
        super.mo964a(rewardedVideoAdRequestParcel.f3899b);
    }

    public void mo1002a(final C1632a c1632a, cy cyVar) {
        if (c1632a.f5412e != -2) {
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ iw f5307b;

                public void run() {
                    this.f5307b.mo966b(new jl(c1632a, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.f.f3998k = c1632a;
        if (c1632a.f5410c == null) {
            this.f.f3998k = m8999b(c1632a);
        }
        this.f.f3978E = 0;
        this.f.f3995h = C1319u.m7182d().m8767a(this.f.f3990c, this.f.f3998k, this);
    }

    protected boolean mo1112a(AdRequestParcel adRequestParcel, jl jlVar, boolean z) {
        return false;
    }

    public boolean mo982a(jl jlVar, jl jlVar2) {
        return true;
    }

    public void mo965b() {
        C1896c.m10797b("destroy must be called on the main UI thread.");
        for (String str : this.f5309m.keySet()) {
            String str2;
            try {
                jd jdVar = (jd) this.f5309m.get(str2);
                if (!(jdVar == null || jdVar.m9070a() == null)) {
                    jdVar.m9070a().mo1360c();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to destroy adapter: ";
                str2 = String.valueOf(str2);
                C1324b.m7234d(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void mo1453b(RewardItemParcel rewardItemParcel) {
        if (!(this.f.f3997j == null || this.f.f3997j.f5437o == null)) {
            C1319u.m7198t().m8370a(this.f.f3990c, this.f.f3992e.f3957b, this.f.f3997j, this.f.f3989b, false, this.f.f3997j.f5437o.f4800k);
        }
        if (!(this.f.f3997j == null || this.f.f3997j.f5440r == null || TextUtils.isEmpty(this.f.f3997j.f5440r.f4820j))) {
            rewardItemParcel = new RewardItemParcel(this.f.f3997j.f5440r.f4820j, this.f.f3997j.f5440r.f4821k);
        }
        m5877a(rewardItemParcel);
    }

    public jd m9015c(String str) {
        jd jdVar;
        Throwable th;
        String str2;
        String valueOf;
        jd jdVar2 = (jd) this.f5309m.get(str);
        if (jdVar2 != null) {
            return jdVar2;
        }
        try {
            jdVar = new jd(("com.google.ads.mediation.admob.AdMobAdapter".equals(str) ? f5308l : this.j).mo1347a(str), this);
            try {
                this.f5309m.put(str, jdVar);
                return jdVar;
            } catch (Throwable e) {
                th = e;
                str2 = "Fail to instantiate adapter ";
                valueOf = String.valueOf(str);
                C1324b.m7235d(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
                return jdVar;
            }
        } catch (Throwable e2) {
            th = e2;
            jdVar = jdVar2;
            str2 = "Fail to instantiate adapter ";
            valueOf = String.valueOf(str);
            if (valueOf.length() == 0) {
            }
            C1324b.m7235d(valueOf.length() == 0 ? new String(str2) : str2.concat(valueOf), th);
            return jdVar;
        }
    }

    public void c_() {
        C1896c.m10797b("resume must be called on the main UI thread.");
        for (String str : this.f5309m.keySet()) {
            String str2;
            try {
                jd jdVar = (jd) this.f5309m.get(str2);
                if (!(jdVar == null || jdVar.m9070a() == null)) {
                    jdVar.m9070a().mo1362e();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to resume adapter: ";
                str2 = String.valueOf(str2);
                C1324b.m7234d(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }

    public void mo969d() {
        C1896c.m10797b("pause must be called on the main UI thread.");
        for (String str : this.f5309m.keySet()) {
            String str2;
            try {
                jd jdVar = (jd) this.f5309m.get(str2);
                if (!(jdVar == null || jdVar.m9070a() == null)) {
                    jdVar.m9070a().mo1361d();
                }
            } catch (RemoteException e) {
                String str3 = "Fail to pause adapter: ";
                str2 = String.valueOf(str2);
                C1324b.m7234d(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }
    }
}
