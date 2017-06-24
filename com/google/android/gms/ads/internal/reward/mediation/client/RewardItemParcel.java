package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.ads.p029d.C1028a;
import com.google.android.gms.common.internal.C1895b;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.p031b.id;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@id
public final class RewardItemParcel extends AbstractSafeParcelable {
    public static final C1312c CREATOR = new C1312c();
    public final int f3907a;
    public final String f3908b;
    public final int f3909c;

    public RewardItemParcel(int i, String str, int i2) {
        this.f3907a = i;
        this.f3908b = str;
        this.f3909c = i2;
    }

    public RewardItemParcel(C1028a c1028a) {
        this(1, c1028a.mo1209a(), c1028a.mo1210b());
    }

    public RewardItemParcel(String str, int i) {
        this(1, str, i);
    }

    public static RewardItemParcel m7095a(String str) {
        RewardItemParcel rewardItemParcel = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                rewardItemParcel = m7096a(new JSONArray(str));
            } catch (JSONException e) {
            }
        }
        return rewardItemParcel;
    }

    public static RewardItemParcel m7096a(JSONArray jSONArray) {
        return (jSONArray == null || jSONArray.length() == 0) ? null : new RewardItemParcel(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public JSONArray m7097a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rb_type", this.f3908b);
        jSONObject.put("rb_amount", this.f3909c);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel) obj;
        return C1895b.m10789a(this.f3908b, rewardItemParcel.f3908b) && C1895b.m10789a(Integer.valueOf(this.f3909c), Integer.valueOf(rewardItemParcel.f3909c));
    }

    public int hashCode() {
        return C1895b.m10787a(this.f3908b, Integer.valueOf(this.f3909c));
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1312c.m7127a(this, parcel, i);
    }
}
