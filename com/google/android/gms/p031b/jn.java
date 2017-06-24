package com.google.android.gms.p031b;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public class jn {
    private final long f5468a;
    private final List<String> f5469b = new ArrayList();
    private final Map<String, C1635b> f5470c = new HashMap();
    private String f5471d;
    private String f5472e;
    private boolean f5473f = false;

    class C1634a {
        final /* synthetic */ jn f5463a;
        private final List<String> f5464b;
        private final Bundle f5465c;

        public C1634a(jn jnVar, List<String> list, Bundle bundle) {
            this.f5463a = jnVar;
            this.f5464b = list;
            this.f5465c = bundle;
        }
    }

    class C1635b {
        final List<C1634a> f5466a = new ArrayList();
        final /* synthetic */ jn f5467b;

        C1635b(jn jnVar) {
            this.f5467b = jnVar;
        }

        public void m9097a(C1634a c1634a) {
            this.f5466a.add(c1634a);
        }
    }

    public jn(String str, long j) {
        this.f5472e = str;
        this.f5468a = j;
        m9098a(str);
    }

    private void m9098a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("status", -1) != 1) {
                    this.f5473f = false;
                    C1324b.m7234d("App settings could not be fetched successfully.");
                    return;
                }
                this.f5473f = true;
                this.f5471d = jSONObject.optString("app_id");
                JSONArray optJSONArray = jSONObject.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        m9099a(optJSONArray.getJSONObject(i));
                    }
                }
            } catch (Throwable e) {
                C1324b.m7235d("Exception occurred while processing app setting json", e);
                C1319u.m7186h().m9117a(e, true);
            }
        }
    }

    private void m9099a(JSONObject jSONObject) {
        String optString = jSONObject.optString("format");
        CharSequence optString2 = jSONObject.optString("ad_unit_id");
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
            if ("interstitial".equalsIgnoreCase(optString)) {
                this.f5469b.add(optString2);
            } else if ("rewarded".equalsIgnoreCase(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("ad_networks");
                    if (optJSONArray != null) {
                        int i = 0;
                        while (i < optJSONArray.length()) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("adapters");
                            if (optJSONArray2 != null) {
                                List arrayList = new ArrayList();
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    arrayList.add(optJSONArray2.getString(i2));
                                }
                                jSONObject2 = jSONObject2.optJSONObject("data");
                                if (jSONObject2 != null) {
                                    Bundle bundle = new Bundle();
                                    Iterator keys = jSONObject2.keys();
                                    while (keys.hasNext()) {
                                        optString = (String) keys.next();
                                        bundle.putString(optString, jSONObject2.getString(optString));
                                    }
                                    C1634a c1634a = new C1634a(this, arrayList, bundle);
                                    C1635b c1635b = this.f5470c.containsKey(optString2) ? (C1635b) this.f5470c.get(optString2) : new C1635b(this);
                                    c1635b.m9097a(c1634a);
                                    this.f5470c.put(optString2, c1635b);
                                    i++;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    public long m9100a() {
        return this.f5468a;
    }

    public boolean m9101b() {
        return this.f5473f;
    }

    public String m9102c() {
        return this.f5472e;
    }

    public String m9103d() {
        return this.f5471d;
    }
}
