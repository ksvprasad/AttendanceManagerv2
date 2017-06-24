package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.common.internal.C1902i;
import java.util.Map;
import java.util.concurrent.Future;

@id
public class er implements eb {
    public void mo997a(la laVar, Map<String, String> map) {
        ep x = C1319u.m7202x();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                C1324b.m7234d("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (x.m8060b(laVar)) {
                C1324b.m7234d("Precache task already running.");
                return;
            }
            C1902i.m10816a(laVar.mo1515h());
            Future future = (Future) new eo(laVar, laVar.mo1515h().f3282a.mo1307a(laVar, parseInt, str2), str).mo1107e();
        } else if (!x.m8058a(laVar)) {
            C1324b.m7234d("Precache abort but no preload task running.");
        }
    }
}
