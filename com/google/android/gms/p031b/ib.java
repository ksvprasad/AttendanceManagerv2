package com.google.android.gms.p031b;

import android.support.v4.p015g.C0369j;
import com.google.android.gms.ads.internal.formats.C1131a;
import com.google.android.gms.ads.internal.formats.C1134c;
import com.google.android.gms.ads.internal.formats.C1141f;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.hy.C1593a;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public class ib implements C1593a<C1141f> {
    private final boolean f5149a;

    public ib(boolean z) {
        this.f5149a = z;
    }

    private <K, V> C0369j<K, V> m8863a(C0369j<K, Future<V>> c0369j) {
        C0369j<K, V> c0369j2 = new C0369j();
        for (int i = 0; i < c0369j.size(); i++) {
            c0369j2.put(c0369j.m1900b(i), ((Future) c0369j.m1901c(i)).get());
        }
        return c0369j2;
    }

    private void m8864a(hy hyVar, JSONObject jSONObject, C0369j<String, Future<C1134c>> c0369j) {
        c0369j.put(jSONObject.getString("name"), hyVar.m8839a(jSONObject, "image_value", this.f5149a));
    }

    private void m8865a(JSONObject jSONObject, C0369j<String, String> c0369j) {
        c0369j.put(jSONObject.getString("name"), jSONObject.getString("string_value"));
    }

    public /* synthetic */ C1136a mo1443a(hy hyVar, JSONObject jSONObject) {
        return m8867b(hyVar, jSONObject);
    }

    public C1141f m8867b(hy hyVar, JSONObject jSONObject) {
        C0369j c0369j = new C0369j();
        C0369j c0369j2 = new C0369j();
        Future b = hyVar.m8842b(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                m8865a(jSONObject2, c0369j2);
            } else if ("image".equals(string)) {
                m8864a(hyVar, jSONObject2, c0369j);
            } else {
                String str = "Unknown custom asset type: ";
                String valueOf = String.valueOf(string);
                C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        }
        return new C1141f(jSONObject.getString("custom_template_id"), m8863a(c0369j), c0369j2, (C1131a) b.get());
    }
}
