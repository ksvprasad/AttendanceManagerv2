package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
class en implements eb {
    en() {
    }

    private int m8051a(Map<String, String> map) {
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        return (parseInt < 0 || 3 < parseInt) ? 0 : parseInt;
    }

    public void mo997a(la laVar, Map<String, String> map) {
        Throwable e;
        if (((Boolean) cq.aE.m7801c()).booleanValue()) {
            lf lfVar;
            lf z = laVar.mo1544z();
            if (z == null) {
                try {
                    z = new lf(laVar, Float.parseFloat((String) map.get("duration")));
                    laVar.mo1499a(z);
                    lfVar = z;
                } catch (NullPointerException e2) {
                    e = e2;
                    C1324b.m7231b("Unable to parse videoMeta message.", e);
                    C1319u.m7186h().m9117a(e, true);
                    return;
                } catch (NumberFormatException e3) {
                    e = e3;
                    C1324b.m7231b("Unable to parse videoMeta message.", e);
                    C1319u.m7186h().m9117a(e, true);
                    return;
                }
            }
            lfVar = z;
            lfVar.m9612a(Float.parseFloat((String) map.get("currentTime")), m8051a(map), "1".equals(map.get("muted")));
        }
    }
}
