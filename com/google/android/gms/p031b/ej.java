package com.google.android.gms.p031b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@id
public class ej implements eb {
    private final Object f4540a = new Object();
    private final Map<String, C1453a> f4541b = new HashMap();

    public interface C1453a {
        void m8041a(String str);

        void m8042a(JSONObject jSONObject);
    }

    public void mo997a(la laVar, Map<String, String> map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("result");
        synchronized (this.f4540a) {
            C1453a c1453a = (C1453a) this.f4541b.remove(str);
            if (c1453a == null) {
                str2 = "Received result for unexpected method invocation: ";
                str = String.valueOf(str);
                C1324b.m7234d(str.length() != 0 ? str2.concat(str) : new String(str2));
            } else if (!TextUtils.isEmpty(str2)) {
                c1453a.m8041a(str3);
            } else if (str4 == null) {
                c1453a.m8041a("No result.");
            } else {
                try {
                    c1453a.m8042a(new JSONObject(str4));
                } catch (JSONException e) {
                    c1453a.m8041a(e.getMessage());
                }
            }
        }
    }
}
