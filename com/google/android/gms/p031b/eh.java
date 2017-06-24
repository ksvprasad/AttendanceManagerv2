package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1123e;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.util.C1971d;
import java.util.Map;

@id
public class eh implements eb {
    static final Map<String, Integer> f4533a = C1971d.m11076a("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    private final C1123e f4534b;
    private final gp f4535c;

    public eh(C1123e c1123e, gp gpVar) {
        this.f4534b = c1123e;
        this.f4535c = gpVar;
    }

    public void mo997a(la laVar, Map<String, String> map) {
        int intValue = ((Integer) f4533a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.f4534b == null || this.f4534b.m6301b()) {
            switch (intValue) {
                case 1:
                    this.f4535c.m8649a((Map) map);
                    return;
                case 3:
                    new gr(laVar, map).m8660a();
                    return;
                case 4:
                    new gn(laVar, map).m8643a();
                    return;
                case 5:
                    new gq(laVar, map).m8656a();
                    return;
                case 6:
                    this.f4535c.m8650a(true);
                    return;
                default:
                    C1324b.m7232c("Unknown MRAID command called.");
                    return;
            }
        }
        this.f4534b.m6300a(null);
    }
}
