package com.google.android.gms.p031b;

import android.content.Context;
import com.google.android.gms.ads.internal.C1319u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@id
public class ft {
    public List<String> m8369a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        List arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void m8370a(Context context, String str, jl jlVar, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll2.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", jlVar.f5440r.f4818h).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", C1319u.m7186h().m9107a()).replaceAll("@gw_seqnum@", jlVar.f5431i).replaceAll("@gw_adnetstatus@", jlVar.f5443u);
                if (jlVar.f5437o != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", jlVar.f5437o.f4791b).replaceAll("@gw_allocid@", jlVar.f5437o.f4793d);
                }
                Future future = (Future) new ki(context, str, replaceAll2).mo1107e();
            }
        }
    }
}
