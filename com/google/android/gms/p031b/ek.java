package com.google.android.gms.p031b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
public class ek implements eb {
    private final C1172a f4542a;

    public interface C1172a {
        void mo1110I();

        void mo1113b(RewardItemParcel rewardItemParcel);
    }

    public ek(C1172a c1172a) {
        this.f4542a = c1172a;
    }

    public static void m8044a(la laVar, C1172a c1172a) {
        laVar.mo1519l().m9466a("/reward", new ek(c1172a));
    }

    private void m8045a(Map<String, String> map) {
        RewardItemParcel rewardItemParcel;
        try {
            int parseInt = Integer.parseInt((String) map.get("amount"));
            String str = (String) map.get("type");
            if (!TextUtils.isEmpty(str)) {
                rewardItemParcel = new RewardItemParcel(str, parseInt);
                this.f4542a.mo1113b(rewardItemParcel);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Unable to parse reward amount.", e);
        }
        rewardItemParcel = null;
        this.f4542a.mo1113b(rewardItemParcel);
    }

    private void m8046b(Map<String, String> map) {
        this.f4542a.mo1110I();
    }

    public void mo997a(la laVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            m8045a(map);
        } else if ("video_start".equals(str)) {
            m8046b(map);
        }
    }
}
