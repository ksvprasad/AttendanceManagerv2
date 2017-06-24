package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
public final class dw implements eb {
    private final dx f4482a;

    public dw(dx dxVar) {
        this.f4482a = dxVar;
    }

    public void mo997a(la laVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            C1324b.m7234d("App event with no name parameter.");
        } else {
            this.f4482a.mo961a(str, (String) map.get("info"));
        }
    }
}
