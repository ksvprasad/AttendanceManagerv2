package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.p031b.cq;
import com.google.android.gms.p031b.eb;
import com.google.android.gms.p031b.ff;
import com.google.android.gms.p031b.fg;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jn;
import com.google.android.gms.p031b.jz;
import com.google.android.gms.p031b.kt.C1161c;
import com.google.android.gms.p031b.kt.C1687b;
import com.google.android.gms.p031b.la;
import java.util.Map;
import org.json.JSONObject;

@id
public class C1164g {
    public final eb f3399a = new C11601(this);
    private final Object f3400b = new Object();
    private Context f3401c;

    class C11601 implements eb {
        final /* synthetic */ C1164g f3391a;

        C11601(C1164g c1164g) {
            this.f3391a = c1164g;
        }

        public void mo997a(la laVar, Map<String, String> map) {
            laVar.mo1324b("/appSettingsFetched", (eb) this);
            synchronized (this.f3391a.f3400b) {
                if (map != null) {
                    if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                        C1319u.m7186h().m9108a(this.f3391a.f3401c, (String) map.get("appSettingsJson"));
                    }
                }
            }
        }
    }

    private static boolean m6477a(jn jnVar) {
        if (jnVar == null) {
            return true;
        }
        boolean z = (((C1319u.m7187i().mo1723a() - jnVar.m9100a()) > ((Long) cq.by.m7801c()).longValue() ? 1 : ((C1319u.m7187i().mo1723a() - jnVar.m9100a()) == ((Long) cq.by.m7801c()).longValue() ? 0 : -1)) > 0) || !jnVar.m9101b();
        return z;
    }

    public void m6479a(Context context, VersionInfoParcel versionInfoParcel, boolean z, jn jnVar, String str, String str2) {
        if (!C1164g.m6477a(jnVar)) {
            return;
        }
        if (context == null) {
            C1324b.m7234d("Context not provided to fetch application settings");
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            C1324b.m7234d("App settings could not be fetched. Required parameters missing");
        } else {
            this.f3401c = context;
            final ff a = C1319u.m7183e().m9201a(context, versionInfoParcel);
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            final Context context2 = context;
            jz.f5567a.post(new Runnable(this) {
                final /* synthetic */ C1164g f3398f;

                class C11621 implements C1161c<fg> {
                    final /* synthetic */ C11632 f3392a;

                    C11621(C11632 c11632) {
                        this.f3392a = c11632;
                    }

                    public void m6474a(fg fgVar) {
                        fgVar.mo1319a("/appSettingsFetched", this.f3392a.f3398f.f3399a);
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (!TextUtils.isEmpty(str3)) {
                                jSONObject.put("app_id", str3);
                            } else if (!TextUtils.isEmpty(str4)) {
                                jSONObject.put("ad_unit_id", str4);
                            }
                            jSONObject.put("is_init", z2);
                            jSONObject.put("pn", context2.getPackageName());
                            fgVar.mo1321a("AFMA_fetchAppSettings", jSONObject);
                        } catch (Throwable e) {
                            fgVar.mo1324b("/appSettingsFetched", this.f3392a.f3398f.f3399a);
                            C1324b.m7231b("Error requesting application settings", e);
                        }
                    }

                    public /* synthetic */ void mo1101a(Object obj) {
                        m6474a((fg) obj);
                    }
                }

                public void run() {
                    a.m8299a().mo1327a(new C11621(this), new C1687b());
                }
            });
        }
    }
}
