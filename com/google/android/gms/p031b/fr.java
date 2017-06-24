package com.google.android.gms.p031b;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.C1106r;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.mediation.C0957b;
import com.google.android.gms.ads.p032b.C1016b;
import com.google.android.gms.ads.p032b.C1016b.C1015a;
import com.google.android.gms.p031b.fs.C1530a;
import com.google.android.gms.p031b.ga.C1528a;
import com.google.android.gms.p033a.C1001b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class fr implements C1530a {
    private final String f4833a;
    private final fx f4834b;
    private final long f4835c;
    private final fo f4836d;
    private final fm f4837e;
    private AdRequestParcel f4838f;
    private final AdSizeParcel f4839g;
    private final Context f4840h;
    private final Object f4841i = new Object();
    private final VersionInfoParcel f4842j;
    private final boolean f4843k;
    private final NativeAdOptionsParcel f4844l;
    private final List<String> f4845m;
    private final boolean f4846n;
    private fy f4847o;
    private int f4848p = -2;
    private ga f4849q;

    class C15292 extends C1528a {
        final /* synthetic */ int f4832a;

        C15292(int i) {
            this.f4832a = i;
        }

        public int mo1341a() {
            return this.f4832a;
        }
    }

    public fr(Context context, String str, fx fxVar, fo foVar, fm fmVar, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.f4840h = context;
        this.f4834b = fxVar;
        this.f4837e = fmVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.f4833a = m8351b();
        } else {
            this.f4833a = str;
        }
        this.f4836d = foVar;
        this.f4835c = foVar.f4812b != -1 ? foVar.f4812b : 10000;
        this.f4838f = adRequestParcel;
        this.f4839g = adSizeParcel;
        this.f4842j = versionInfoParcel;
        this.f4843k = z;
        this.f4846n = z2;
        this.f4844l = nativeAdOptionsParcel;
        this.f4845m = list;
    }

    private long m8342a(long j, long j2, long j3, long j4) {
        while (this.f4848p == -2) {
            m8352b(j, j2, j3, j4);
        }
        return C1319u.m7187i().mo1724b() - j;
    }

    private String m8345a(String str) {
        if (!(str == null || !m8360e() || m8353b(2))) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.remove("cpm_floor_cents");
                str = jSONObject.toString();
            } catch (JSONException e) {
                C1324b.m7234d("Could not remove field. Returning the original value");
            }
        }
        return str;
    }

    private void m8346a(fq fqVar) {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.f4833a)) {
            if (this.f4838f.f3097m == null) {
                this.f4838f = new C1106r(this.f4838f).m6236a(new Bundle()).m6234a();
            }
            Bundle bundle = this.f4838f.f3097m.getBundle(this.f4833a);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", this.f4837e.f4791b);
            this.f4838f.f3097m.putBundle(this.f4833a, bundle);
        }
        String a = m8345a(this.f4837e.f4798i);
        try {
            if (this.f4842j.f3959d < 4100000) {
                if (this.f4839g.f3107e) {
                    this.f4847o.mo1352a(C1001b.m5713a(this.f4840h), this.f4838f, a, fqVar);
                } else {
                    this.f4847o.mo1355a(C1001b.m5713a(this.f4840h), this.f4839g, this.f4838f, a, (fz) fqVar);
                }
            } else if (this.f4843k) {
                this.f4847o.mo1354a(C1001b.m5713a(this.f4840h), this.f4838f, a, this.f4837e.f4790a, fqVar, this.f4844l, this.f4845m);
            } else if (this.f4839g.f3107e) {
                this.f4847o.mo1353a(C1001b.m5713a(this.f4840h), this.f4838f, a, this.f4837e.f4790a, (fz) fqVar);
            } else if (!this.f4846n) {
                this.f4847o.mo1356a(C1001b.m5713a(this.f4840h), this.f4839g, this.f4838f, a, this.f4837e.f4790a, fqVar);
            } else if (this.f4837e.f4801l != null) {
                this.f4847o.mo1354a(C1001b.m5713a(this.f4840h), this.f4838f, a, this.f4837e.f4790a, fqVar, new NativeAdOptionsParcel(fr.m8350b(this.f4837e.f4805p)), this.f4837e.f4804o);
            } else {
                this.f4847o.mo1356a(C1001b.m5713a(this.f4840h), this.f4839g, this.f4838f, a, this.f4837e.f4790a, fqVar);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not request ad from mediation adapter.", e);
            mo1342a(5);
        }
    }

    private static C1016b m8350b(String str) {
        C1015a c1015a = new C1015a();
        if (str == null) {
            return c1015a.m5744a();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c1015a.m5745b(jSONObject.optBoolean("multiple_images", false));
            c1015a.m5743a(jSONObject.optBoolean("only_urls", false));
            c1015a.m5742a(fr.m8354c(jSONObject.optString("native_image_orientation", "any")));
        } catch (Throwable e) {
            C1324b.m7235d("Exception occurred when creating native ad options", e);
        }
        return c1015a.m5744a();
    }

    private String m8351b() {
        try {
            if (!TextUtils.isEmpty(this.f4837e.f4794e)) {
                return this.f4834b.mo1348b(this.f4837e.f4794e) ? "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter" : "com.google.ads.mediation.customevent.CustomEventAdapter";
            }
        } catch (RemoteException e) {
            C1324b.m7234d("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private void m8352b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        elapsedRealtime = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || elapsedRealtime <= 0) {
            C1324b.m7232c("Timed out waiting for adapter.");
            this.f4848p = 3;
            return;
        }
        try {
            this.f4841i.wait(Math.min(j5, elapsedRealtime));
        } catch (InterruptedException e) {
            this.f4848p = -1;
        }
    }

    private boolean m8353b(int i) {
        try {
            Bundle l = this.f4843k ? this.f4847o.mo1369l() : this.f4839g.f3107e ? this.f4847o.mo1368k() : this.f4847o.mo1367j();
            if (l == null) {
                return false;
            }
            return (l.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            C1324b.m7234d("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static int m8354c(String str) {
        return "landscape".equals(str) ? 2 : "portrait".equals(str) ? 1 : 0;
    }

    private ga m8356c() {
        if (this.f4848p != 0 || !m8360e()) {
            return null;
        }
        try {
            if (!(!m8353b(4) || this.f4849q == null || this.f4849q.mo1341a() == 0)) {
                return this.f4849q;
            }
        } catch (RemoteException e) {
            C1324b.m7234d("Could not get cpm value from MediationResponseMetadata");
        }
        return fr.m8357c(m8362f());
    }

    private static ga m8357c(int i) {
        return new C15292(i);
    }

    private fy m8358d() {
        String str = "Instantiating mediation adapter: ";
        String valueOf = String.valueOf(this.f4833a);
        C1324b.m7232c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        if (!this.f4843k) {
            if (((Boolean) cq.aH.m7801c()).booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.f4833a)) {
                return m8365a(new AdMobAdapter());
            }
            if (((Boolean) cq.aI.m7801c()).booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.f4833a)) {
                return m8365a(new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.f4833a)) {
                return new ge(new gm());
            }
        }
        try {
            return this.f4834b.mo1347a(this.f4833a);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Could not instantiate mediation adapter: ";
            valueOf = String.valueOf(this.f4833a);
            C1324b.m7228a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return null;
        }
    }

    private boolean m8360e() {
        return this.f4836d.f4822l != -1;
    }

    private int m8362f() {
        if (this.f4837e.f4798i == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f4837e.f4798i);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.f4833a)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = m8353b(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            C1324b.m7234d("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public fs m8364a(long j, long j2) {
        fs fsVar;
        synchronized (this.f4841i) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final fq fqVar = new fq();
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ fr f4831b;

                public void run() {
                    synchronized (this.f4831b.f4841i) {
                        if (this.f4831b.f4848p != -2) {
                            return;
                        }
                        this.f4831b.f4847o = this.f4831b.m8358d();
                        if (this.f4831b.f4847o == null) {
                            this.f4831b.mo1342a(4);
                        } else if (!this.f4831b.m8360e() || this.f4831b.m8353b(1)) {
                            fqVar.m8330a(this.f4831b);
                            this.f4831b.m8346a(fqVar);
                        } else {
                            String f = this.f4831b.f4833a;
                            C1324b.m7234d(new StringBuilder(String.valueOf(f).length() + 56).append("Ignoring adapter ").append(f).append(" as delayed impression is not supported").toString());
                            this.f4831b.mo1342a(2);
                        }
                    }
                }
            });
            fq fqVar2 = fqVar;
            fsVar = new fs(this.f4837e, this.f4847o, this.f4833a, fqVar2, this.f4848p, m8356c(), m8342a(elapsedRealtime, this.f4835c, j, j2));
        }
        return fsVar;
    }

    protected fy m8365a(C0957b c0957b) {
        return new ge(c0957b);
    }

    public void m8366a() {
        synchronized (this.f4841i) {
            try {
                if (this.f4847o != null) {
                    this.f4847o.mo1360c();
                }
            } catch (Throwable e) {
                C1324b.m7235d("Could not destroy mediation adapter.", e);
            }
            this.f4848p = -1;
            this.f4841i.notify();
        }
    }

    public void mo1342a(int i) {
        synchronized (this.f4841i) {
            this.f4848p = i;
            this.f4841i.notify();
        }
    }

    public void mo1343a(int i, ga gaVar) {
        synchronized (this.f4841i) {
            this.f4848p = i;
            this.f4849q = gaVar;
            this.f4841i.notify();
        }
    }
}
