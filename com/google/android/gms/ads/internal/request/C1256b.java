package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.C1249a;
import com.google.android.gms.ads.internal.request.C1251a.C1041a;
import com.google.android.gms.ads.internal.request.C1259c.C1255a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.aj;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.fo;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jl.C1632a;
import com.google.android.gms.p031b.ju;
import com.google.android.gms.p031b.jy;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.kb;
import com.google.android.gms.p031b.kt;
import com.google.android.gms.p031b.ku;
import org.json.JSONObject;

@id
public class C1256b extends ju implements C1255a {
    kb f3825a;
    AdResponseParcel f3826b;
    fo f3827c;
    private final C1041a f3828d;
    private final C1249a f3829e;
    private final Object f3830f = new Object();
    private final Context f3831g;
    private final aj f3832h;
    private AdRequestInfoParcel f3833i;
    private Runnable f3834j;

    class C12521 implements Runnable {
        final /* synthetic */ C1256b f3821a;

        C12521(C1256b c1256b) {
            this.f3821a = c1256b;
        }

        public void run() {
            synchronized (this.f3821a.f3830f) {
                if (this.f3821a.f3825a == null) {
                    return;
                }
                this.f3821a.mo1109b();
                this.f3821a.m6899a(2, "Timed out waiting for ad response.");
            }
        }
    }

    @id
    static final class C1254a extends Exception {
        private final int f3824a;

        public C1254a(String str, int i) {
            super(str);
            this.f3824a = i;
        }

        public int m6896a() {
            return this.f3824a;
        }
    }

    public C1256b(Context context, C1249a c1249a, aj ajVar, C1041a c1041a) {
        this.f3828d = c1041a;
        this.f3831g = context;
        this.f3829e = c1249a;
        this.f3832h = ajVar;
    }

    private void m6899a(int i, String str) {
        if (i == 3 || i == -1) {
            C1324b.m7232c(str);
        } else {
            C1324b.m7234d(str);
        }
        if (this.f3826b == null) {
            this.f3826b = new AdResponseParcel(i);
        } else {
            this.f3826b = new AdResponseParcel(i, this.f3826b.f3789k);
        }
        this.f3828d.mo959a(new C1632a(this.f3833i != null ? this.f3833i : new AdRequestInfoParcel(this.f3829e, null, -1), this.f3826b, this.f3827c, null, i, -1, this.f3826b.f3792n, null));
    }

    protected AdSizeParcel m6903a(AdRequestInfoParcel adRequestInfoParcel) {
        int i;
        if (this.f3826b.f3765A) {
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.f3742d.f3110h) {
                if (adSizeParcel.f3112j) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.f3742d.f3110h);
                }
            }
        }
        if (this.f3826b.f3791m == null) {
            throw new C1254a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f3826b.f3791m.split("x");
        if (split.length != 2) {
            String str = "Invalid ad size format from the ad response: ";
            String valueOf = String.valueOf(this.f3826b.f3791m);
            throw new C1254a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel2 : adRequestInfoParcel.f3742d.f3110h) {
                float f = this.f3831g.getResources().getDisplayMetrics().density;
                i = adSizeParcel2.f3108f == -1 ? (int) (((float) adSizeParcel2.f3109g) / f) : adSizeParcel2.f3108f;
                int i2 = adSizeParcel2.f3105c == -2 ? (int) (((float) adSizeParcel2.f3106d) / f) : adSizeParcel2.f3105c;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel2, adRequestInfoParcel.f3742d.f3110h);
                }
            }
            str = "The ad size from the ad response was not one of the requested sizes: ";
            valueOf = String.valueOf(this.f3826b.f3791m);
            throw new C1254a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        } catch (NumberFormatException e) {
            str = "Invalid ad size number from the ad response: ";
            valueOf = String.valueOf(this.f3826b.f3791m);
            throw new C1254a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
        }
    }

    kb m6904a(VersionInfoParcel versionInfoParcel, kt<AdRequestInfoParcel> ktVar) {
        return C1259c.m6911a(this.f3831g, versionInfoParcel, ktVar, this);
    }

    public void mo1108a() {
        C1324b.m7227a("AdLoaderBackgroundTask started.");
        this.f3834j = new C12521(this);
        jz.f5567a.postDelayed(this.f3834j, ((Long) cq.aJ.m7801c()).longValue());
        final kt kuVar = new ku();
        long b = C1319u.m7187i().mo1724b();
        jy.m9180a(new Runnable(this) {
            final /* synthetic */ C1256b f3823b;

            public void run() {
                synchronized (this.f3823b.f3830f) {
                    this.f3823b.f3825a = this.f3823b.m6904a(this.f3823b.f3829e.f3707j, kuVar);
                    if (this.f3823b.f3825a == null) {
                        this.f3823b.m6899a(0, "Could not start the ad request service.");
                        jz.f5567a.removeCallbacks(this.f3823b.f3834j);
                    }
                }
            }
        });
        this.f3833i = new AdRequestInfoParcel(this.f3829e, this.f3832h.m7432a().mo1102a(this.f3831g), b);
        kuVar.mo1328a(this.f3833i);
    }

    public void mo1173a(AdResponseParcel adResponseParcel) {
        C1324b.m7227a("Received ad response.");
        this.f3826b = adResponseParcel;
        long b = C1319u.m7187i().mo1724b();
        synchronized (this.f3830f) {
            this.f3825a = null;
        }
        C1319u.m7186h().m9120b(this.f3831g, this.f3826b.f3772H);
        try {
            if (this.f3826b.f3783e == -2 || this.f3826b.f3783e == -3) {
                JSONObject jSONObject;
                m6908c();
                AdSizeParcel a = this.f3833i.f3742d.f3110h != null ? m6903a(this.f3833i) : null;
                C1319u.m7186h().m9119a(this.f3826b.f3800v);
                if (!TextUtils.isEmpty(this.f3826b.f3796r)) {
                    try {
                        jSONObject = new JSONObject(this.f3826b.f3796r);
                    } catch (Throwable e) {
                        C1324b.m7231b("Error parsing the JSON for Active View.", e);
                    }
                    this.f3828d.mo959a(new C1632a(this.f3833i, this.f3826b, this.f3827c, a, -2, b, this.f3826b.f3792n, jSONObject));
                    jz.f5567a.removeCallbacks(this.f3834j);
                    return;
                }
                jSONObject = null;
                this.f3828d.mo959a(new C1632a(this.f3833i, this.f3826b, this.f3827c, a, -2, b, this.f3826b.f3792n, jSONObject));
                jz.f5567a.removeCallbacks(this.f3834j);
                return;
            }
            throw new C1254a("There was a problem getting an ad response. ErrorCode: " + this.f3826b.f3783e, this.f3826b.f3783e);
        } catch (C1254a e2) {
            m6899a(e2.m6896a(), e2.getMessage());
            jz.f5567a.removeCallbacks(this.f3834j);
        }
    }

    public void mo1109b() {
        synchronized (this.f3830f) {
            if (this.f3825a != null) {
                this.f3825a.mo1106d();
            }
        }
    }

    protected void m6908c() {
        if (this.f3826b.f3783e != -3) {
            if (TextUtils.isEmpty(this.f3826b.f3781c)) {
                throw new C1254a("No fill from ad server.", 3);
            }
            C1319u.m7186h().m9109a(this.f3831g, this.f3826b.f3799u);
            if (this.f3826b.f3786h) {
                try {
                    this.f3827c = new fo(this.f3826b.f3781c);
                    C1319u.m7186h().m9121b(this.f3827c.f4817g);
                } catch (Throwable e) {
                    C1324b.m7231b("Could not parse mediation config.", e);
                    String str = "Could not parse mediation config: ";
                    String valueOf = String.valueOf(this.f3826b.f3781c);
                    throw new C1254a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), 0);
                }
            }
            C1319u.m7186h().m9121b(this.f3826b.f3776L);
            if (!TextUtils.isEmpty(this.f3826b.f3773I) && ((Boolean) cq.bQ.m7801c()).booleanValue()) {
                C1324b.m7227a("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager b = C1319u.m7185g().mo1482b(this.f3831g);
                if (b != null) {
                    b.setCookie("googleads.g.doubleclick.net", this.f3826b.f3773I);
                }
            }
        }
    }
}
