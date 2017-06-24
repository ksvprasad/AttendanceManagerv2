package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@id
public class eg implements eb {
    final HashMap<String, kn<JSONObject>> f4532a = new HashMap();

    public Future<JSONObject> m8026a(String str) {
        Future knVar = new kn();
        this.f4532a.put(str, knVar);
        return knVar;
    }

    public void mo997a(la laVar, Map<String, String> map) {
        m8028a((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public void m8028a(String str, String str2) {
        C1324b.m7227a("Received ad from the cache.");
        kn knVar = (kn) this.f4532a.get(str);
        if (knVar == null) {
            C1324b.m7230b("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            knVar.m8236b(new JSONObject(str2));
        } catch (Throwable e) {
            C1324b.m7231b("Failed constructing JSON object from value passed from javascript", e);
            knVar.m8236b(null);
        } finally {
            this.f4532a.remove(str);
        }
    }

    public void m8029b(String str) {
        kn knVar = (kn) this.f4532a.get(str);
        if (knVar == null) {
            C1324b.m7230b("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!knVar.isDone()) {
            knVar.cancel(true);
        }
        this.f4532a.remove(str);
    }
}
