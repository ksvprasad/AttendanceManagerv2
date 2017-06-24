package com.google.android.gms.p031b;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@id
public final class ii {
    private String f5200A;
    private List<String> f5201B;
    private String f5202C;
    private boolean f5203D;
    private String f5204E;
    private final AdRequestInfoParcel f5205F;
    private String f5206a;
    private String f5207b;
    private String f5208c;
    private List<String> f5209d;
    private String f5210e;
    private String f5211f;
    private List<String> f5212g;
    private long f5213h = -1;
    private boolean f5214i = false;
    private final long f5215j = -1;
    private List<String> f5216k;
    private long f5217l = -1;
    private int f5218m = -1;
    private boolean f5219n = false;
    private boolean f5220o = false;
    private boolean f5221p = false;
    private boolean f5222q = true;
    private String f5223r = "";
    private boolean f5224s = false;
    private boolean f5225t = false;
    private RewardItemParcel f5226u;
    private List<String> f5227v;
    private List<String> f5228w;
    private boolean f5229x = false;
    private AutoClickProtectionConfigurationParcel f5230y;
    private boolean f5231z = false;

    public ii(AdRequestInfoParcel adRequestInfoParcel) {
        this.f5205F = adRequestInfoParcel;
    }

    private void m8915A(Map<String, List<String>> map) {
        Object a = ii.m8918a(map, "X-Afma-Auto-Protection-Configuration");
        if (a == null || TextUtils.isEmpty(a)) {
            Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.f5210e)) {
                buildUpon.appendQueryParameter("debugDialog", this.f5210e);
            }
            boolean booleanValue = ((Boolean) cq.f4395j.m7801c()).booleanValue();
            String[] strArr = new String[1];
            String valueOf = String.valueOf(buildUpon.toString());
            String valueOf2 = String.valueOf("navigationURL");
            strArr[0] = new StringBuilder((String.valueOf(valueOf).length() + 18) + String.valueOf(valueOf2).length()).append(valueOf).append("&").append(valueOf2).append("={NAVIGATION_URL}").toString();
            this.f5230y = new AutoClickProtectionConfigurationParcel(booleanValue, Arrays.asList(strArr));
            return;
        }
        try {
            this.f5230y = AutoClickProtectionConfigurationParcel.m6890a(new JSONObject(a));
        } catch (Throwable e) {
            C1324b.m7235d("Error parsing configuration JSON", e);
            this.f5230y = new AutoClickProtectionConfigurationParcel();
        }
    }

    private void m8916B(Map<String, List<String>> map) {
        this.f5200A = ii.m8918a(map, "Set-Cookie");
    }

    private void m8917C(Map<String, List<String>> map) {
        this.f5202C = ii.m8918a(map, "X-Afma-Safe-Browsing");
    }

    static String m8918a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long m8919b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                C1324b.m7234d(new StringBuilder((String.valueOf(str).length() + 36) + String.valueOf(str2).length()).append("Could not parse float from ").append(str).append(" header: ").append(str2).toString());
            }
        }
        return -1;
    }

    private void m8920b(Map<String, List<String>> map) {
        this.f5206a = ii.m8918a(map, "X-Afma-Ad-Size");
    }

    static List<String> m8921c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m8922c(Map<String, List<String>> map) {
        this.f5204E = ii.m8918a(map, "X-Afma-Ad-Slot-Size");
    }

    private void m8923d(Map<String, List<String>> map) {
        List c = ii.m8921c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f5209d = c;
        }
    }

    private boolean m8924d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void m8925e(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.f5210e = (String) list.get(0);
        }
    }

    private void m8926f(Map<String, List<String>> map) {
        List c = ii.m8921c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f5212g = c;
        }
    }

    private void m8927g(Map<String, List<String>> map) {
        long b = ii.m8919b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f5213h = b;
        }
    }

    private void m8928h(Map<String, List<String>> map) {
        this.f5211f = ii.m8918a(map, "X-Afma-ActiveView");
    }

    private void m8929i(Map<String, List<String>> map) {
        this.f5220o = "native".equals(ii.m8918a(map, "X-Afma-Ad-Format"));
    }

    private void m8930j(Map<String, List<String>> map) {
        this.f5219n |= m8924d(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void m8931k(Map<String, List<String>> map) {
        this.f5214i |= m8924d(map, "X-Afma-Mediation");
    }

    private void m8932l(Map<String, List<String>> map) {
        this.f5203D |= m8924d(map, "X-Afma-Render-In-Browser");
    }

    private void m8933m(Map<String, List<String>> map) {
        List c = ii.m8921c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f5216k = c;
        }
    }

    private void m8934n(Map<String, List<String>> map) {
        long b = ii.m8919b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f5217l = b;
        }
    }

    private void m8935o(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.f5218m = C1319u.m7185g().mo1465b();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.f5218m = C1319u.m7185g().mo1463a();
            }
        }
    }

    private void m8936p(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.f5221p = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m8937q(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.f5222q = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m8938r(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.f5223r = (String) list.get(0);
        }
    }

    private void m8939s(Map<String, List<String>> map) {
        String a = ii.m8918a(map, "X-Afma-Fluid");
        if (a != null && a.equals("height")) {
            this.f5224s = true;
        }
    }

    private void m8940t(Map<String, List<String>> map) {
        this.f5225t = "native_express".equals(ii.m8918a(map, "X-Afma-Ad-Format"));
    }

    private void m8941u(Map<String, List<String>> map) {
        this.f5226u = RewardItemParcel.m7095a(ii.m8918a(map, "X-Afma-Rewards"));
    }

    private void m8942v(Map<String, List<String>> map) {
        if (this.f5227v == null) {
            this.f5227v = ii.m8921c(map, "X-Afma-Reward-Video-Start-Urls");
        }
    }

    private void m8943w(Map<String, List<String>> map) {
        if (this.f5228w == null) {
            this.f5228w = ii.m8921c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
    }

    private void m8944x(Map<String, List<String>> map) {
        this.f5229x |= m8924d(map, "X-Afma-Use-Displayed-Impression");
    }

    private void m8945y(Map<String, List<String>> map) {
        this.f5231z |= m8924d(map, "X-Afma-Auto-Collect-Location");
    }

    private void m8946z(Map<String, List<String>> map) {
        List c = ii.m8921c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.f5201B = c;
        }
    }

    public AdResponseParcel m8947a(long j) {
        return new AdResponseParcel(this.f5205F, this.f5207b, this.f5208c, this.f5209d, this.f5212g, this.f5213h, this.f5214i, -1, this.f5216k, this.f5217l, this.f5218m, this.f5206a, j, this.f5210e, this.f5211f, this.f5219n, this.f5220o, this.f5221p, this.f5222q, false, this.f5223r, this.f5224s, this.f5225t, this.f5226u, this.f5227v, this.f5228w, this.f5229x, this.f5230y, this.f5231z, this.f5200A, this.f5201B, this.f5202C, this.f5203D, this.f5204E);
    }

    public void m8948a(String str, Map<String, List<String>> map, String str2) {
        this.f5207b = str;
        this.f5208c = str2;
        m8949a((Map) map);
    }

    public void m8949a(Map<String, List<String>> map) {
        m8920b(map);
        m8922c(map);
        m8923d(map);
        m8925e(map);
        m8926f(map);
        m8927g(map);
        m8931k(map);
        m8933m(map);
        m8934n(map);
        m8935o(map);
        m8928h(map);
        m8936p(map);
        m8930j(map);
        m8929i(map);
        m8937q(map);
        m8938r(map);
        m8939s(map);
        m8940t(map);
        m8941u(map);
        m8942v(map);
        m8943w(map);
        m8944x(map);
        m8945y(map);
        m8916B(map);
        m8915A(map);
        m8946z(map);
        m8917C(map);
        m8932l(map);
    }
}
