package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public final class fo {
    public final List<fm> f4811a;
    public final long f4812b;
    public final List<String> f4813c;
    public final List<String> f4814d;
    public final List<String> f4815e;
    public final List<String> f4816f;
    public final boolean f4817g;
    public final String f4818h;
    public final long f4819i;
    public final String f4820j;
    public final int f4821k;
    public final int f4822l;
    public final long f4823m;
    public final boolean f4824n;
    public int f4825o;
    public int f4826p;

    public fo(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (C1324b.m7229a(2)) {
            String str2 = "Mediation Response JSON: ";
            String valueOf = String.valueOf(jSONObject.toString(2));
            jv.m9152e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            fm fmVar = new fm(jSONArray.getJSONObject(i2));
            arrayList.add(fmVar);
            if (i < 0 && m8317a(fmVar)) {
                i = i2;
            }
        }
        this.f4825o = i;
        this.f4826p = jSONArray.length();
        this.f4811a = Collections.unmodifiableList(arrayList);
        this.f4818h = jSONObject.getString("qdata");
        this.f4822l = jSONObject.optInt("fs_model_type", -1);
        this.f4823m = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f4812b = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f4813c = C1319u.m7198t().m8369a(optJSONObject, "click_urls");
            this.f4814d = C1319u.m7198t().m8369a(optJSONObject, "imp_urls");
            this.f4815e = C1319u.m7198t().m8369a(optJSONObject, "nofill_urls");
            this.f4816f = C1319u.m7198t().m8369a(optJSONObject, "remote_ping_urls");
            this.f4817g = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f4819i = optLong > 0 ? optLong * 1000 : -1;
            RewardItemParcel a = RewardItemParcel.m7096a(optJSONObject.optJSONArray("rewards"));
            if (a == null) {
                this.f4820j = null;
                this.f4821k = 0;
            } else {
                this.f4820j = a.f3908b;
                this.f4821k = a.f3909c;
            }
            this.f4824n = optJSONObject.optBoolean("use_displayed_impression", false);
            return;
        }
        this.f4812b = -1;
        this.f4813c = null;
        this.f4814d = null;
        this.f4815e = null;
        this.f4816f = null;
        this.f4819i = -1;
        this.f4820j = null;
        this.f4821k = 0;
        this.f4824n = false;
        this.f4817g = false;
    }

    public fo(List<fm> list, long j, List<String> list2, List<String> list3, List<String> list4, List<String> list5, boolean z, String str, long j2, int i, int i2, String str2, int i3, int i4, long j3, boolean z2) {
        this.f4811a = list;
        this.f4812b = j;
        this.f4813c = list2;
        this.f4814d = list3;
        this.f4815e = list4;
        this.f4816f = list5;
        this.f4817g = z;
        this.f4818h = str;
        this.f4819i = j2;
        this.f4825o = i;
        this.f4826p = i2;
        this.f4820j = str2;
        this.f4821k = i3;
        this.f4822l = i4;
        this.f4823m = j3;
        this.f4824n = z2;
    }

    private boolean m8317a(fm fmVar) {
        for (String equals : fmVar.f4792c) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
