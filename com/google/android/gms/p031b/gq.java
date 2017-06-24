package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
public class gq {
    private final la f4975a;
    private final boolean f4976b;
    private final String f4977c;

    public gq(la laVar, Map<String, String> map) {
        this.f4975a = laVar;
        this.f4977c = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.f4976b = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        } else {
            this.f4976b = true;
        }
    }

    public void m8656a() {
        if (this.f4975a == null) {
            C1324b.m7234d("AdWebView is null");
            return;
        }
        int b = "portrait".equalsIgnoreCase(this.f4977c) ? C1319u.m7185g().mo1465b() : "landscape".equalsIgnoreCase(this.f4977c) ? C1319u.m7185g().mo1463a() : this.f4976b ? -1 : C1319u.m7185g().mo1480c();
        this.f4975a.mo1504b(b);
    }
}
