package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
public class ee implements eb {
    private final ef f4531a;

    public ee(ef efVar) {
        this.f4531a = efVar;
    }

    public void mo997a(la laVar, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.f4531a.mo1114b(equals);
                this.f4531a.mo1111a(equals2, parseFloat);
            }
        } catch (Throwable e) {
            C1324b.m7231b("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.f4531a.mo1114b(equals);
        this.f4531a.mo1111a(equals2, parseFloat);
    }
}
