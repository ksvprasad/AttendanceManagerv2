package com.google.android.gms.p031b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
public final class dz implements eb {
    private long m7985a(long j) {
        return (j - C1319u.m7187i().mo1723a()) + C1319u.m7187i().mo1724b();
    }

    private void m7986b(la laVar, Map<String, String> map) {
        String str = (String) map.get("label");
        String str2 = (String) map.get("start_label");
        String str3 = (String) map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            C1324b.m7234d("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            C1324b.m7234d("No timestamp given for CSI tick.");
        } else {
            try {
                long a = m7985a(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                laVar.mo1543y().m7860a(str, str2, a);
            } catch (Throwable e) {
                C1324b.m7235d("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void m7987c(la laVar, Map<String, String> map) {
        String str = (String) map.get("value");
        if (TextUtils.isEmpty(str)) {
            C1324b.m7234d("No value given for CSI experiment.");
            return;
        }
        cy a = laVar.mo1543y().m7858a();
        if (a == null) {
            C1324b.m7234d("No ticker for WebView, dropping experiment ID.");
        } else {
            a.m7865a("e", str);
        }
    }

    private void m7988d(la laVar, Map<String, String> map) {
        String str = (String) map.get("name");
        String str2 = (String) map.get("value");
        if (TextUtils.isEmpty(str2)) {
            C1324b.m7234d("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            C1324b.m7234d("No name given for CSI extra.");
        } else {
            cy a = laVar.mo1543y().m7858a();
            if (a == null) {
                C1324b.m7234d("No ticker for WebView, dropping extra parameter.");
            } else {
                a.m7865a(str, str2);
            }
        }
    }

    public void mo997a(la laVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            m7986b(laVar, map);
        } else if ("experiment".equals(str)) {
            m7987c(laVar, map);
        } else if ("extra".equals(str)) {
            m7988d(laVar, map);
        }
    }
}
