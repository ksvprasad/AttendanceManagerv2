package com.google.android.gms.p031b;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.C1131a;
import com.google.android.gms.ads.internal.formats.C1134c;
import com.google.android.gms.ads.internal.formats.C1139e;
import com.google.android.gms.ads.internal.formats.C1142h.C1136a;
import com.google.android.gms.p031b.hy.C1593a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@id
public class ia implements C1593a<C1139e> {
    private final boolean f5147a;
    private final boolean f5148b;

    public ia(boolean z, boolean z2) {
        this.f5147a = z;
        this.f5148b = z2;
    }

    public /* synthetic */ C1136a mo1443a(hy hyVar, JSONObject jSONObject) {
        return m8862b(hyVar, jSONObject);
    }

    public C1139e m8862b(hy hyVar, JSONObject jSONObject) {
        List<kq> a = hyVar.m8838a(jSONObject, "images", true, this.f5147a, this.f5148b);
        Future a2 = hyVar.m8837a(jSONObject, "secondary_image", false, this.f5147a);
        Future b = hyVar.m8842b(jSONObject);
        List arrayList = new ArrayList();
        for (kq kqVar : a) {
            arrayList.add((C1134c) kqVar.get());
        }
        return new C1139e(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (df) a2.get(), jSONObject.getString("call_to_action"), jSONObject.getString("advertiser"), (C1131a) b.get(), new Bundle());
    }
}
