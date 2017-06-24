package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C1131a;
import com.google.android.gms.ads.internal.formats.C1134c;
import com.google.android.gms.ads.internal.formats.C1137d;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.p031b.hy.C1593a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@id
public class hz implements C1593a<C1137d> {
    private final boolean f5140a;
    private final boolean f5141b;

    public hz(boolean z, boolean z2) {
        this.f5140a = z;
        this.f5141b = z2;
    }

    public /* synthetic */ C1136a mo1443a(hy hyVar, JSONObject jSONObject) {
        return m8845b(hyVar, jSONObject);
    }

    public C1137d m8845b(hy hyVar, JSONObject jSONObject) {
        List<kq> a = hyVar.m8838a(jSONObject, "images", true, this.f5140a, this.f5141b);
        Future a2 = hyVar.m8837a(jSONObject, "app_icon", true, this.f5140a);
        Future b = hyVar.m8842b(jSONObject);
        List arrayList = new ArrayList();
        for (kq kqVar : a) {
            arrayList.add((C1134c) kqVar.get());
        }
        return new C1137d(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (df) a2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (C1131a) b.get(), new Bundle());
    }
}
