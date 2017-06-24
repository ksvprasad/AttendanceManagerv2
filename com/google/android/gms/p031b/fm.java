package com.google.android.gms.p031b;

import com.google.android.gms.ads.internal.C1319u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public final class fm {
    public final String f4790a;
    public final String f4791b;
    public final List<String> f4792c;
    public final String f4793d;
    public final String f4794e;
    public final List<String> f4795f;
    public final List<String> f4796g;
    public final List<String> f4797h;
    public final String f4798i;
    public final List<String> f4799j;
    public final List<String> f4800k;
    public final String f4801l;
    public final String f4802m;
    public final String f4803n;
    public final List<String> f4804o;
    public final String f4805p;

    public fm(String str, String str2, List<String> list, String str3, String str4, List<String> list2, List<String> list3, String str5, String str6, List<String> list4, List<String> list5, String str7, String str8, String str9, List<String> list6, String str10, List<String> list7) {
        this.f4790a = str;
        this.f4791b = str2;
        this.f4792c = list;
        this.f4793d = str3;
        this.f4794e = str4;
        this.f4795f = list2;
        this.f4796g = list3;
        this.f4798i = str5;
        this.f4799j = list4;
        this.f4800k = list5;
        this.f4801l = str7;
        this.f4802m = str8;
        this.f4803n = str9;
        this.f4804o = list6;
        this.f4805p = str10;
        this.f4797h = list7;
    }

    public fm(JSONObject jSONObject) {
        String str = null;
        this.f4791b = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f4792c = Collections.unmodifiableList(arrayList);
        this.f4793d = jSONObject.optString("allocation_id", null);
        this.f4795f = C1319u.m7198t().m8369a(jSONObject, "clickurl");
        this.f4796g = C1319u.m7198t().m8369a(jSONObject, "imp_urls");
        this.f4797h = C1319u.m7198t().m8369a(jSONObject, "fill_urls");
        this.f4799j = C1319u.m7198t().m8369a(jSONObject, "video_start_urls");
        this.f4800k = C1319u.m7198t().m8369a(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.f4790a = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.f4798i = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.f4794e = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.f4801l = jSONObject.optString("html_template", null);
        this.f4802m = jSONObject.optString("ad_base_url", null);
        optJSONObject = jSONObject.optJSONObject("assets");
        this.f4803n = optJSONObject != null ? optJSONObject.toString() : null;
        this.f4804o = C1319u.m7198t().m8369a(jSONObject, "template_ids");
        optJSONObject = jSONObject.optJSONObject("ad_loader_options");
        if (optJSONObject != null) {
            str = optJSONObject.toString();
        }
        this.f4805p = str;
    }
}
