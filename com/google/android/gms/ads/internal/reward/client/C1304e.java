package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.p029d.C1028a;
import com.google.android.gms.p031b.id;

@id
public class C1304e implements C1028a {
    private final C1292a f3905a;

    public C1304e(C1292a c1292a) {
        this.f3905a = c1292a;
    }

    public String mo1209a() {
        String str = null;
        if (this.f3905a != null) {
            try {
                str = this.f3905a.mo1188a();
            } catch (Throwable e) {
                C1324b.m7235d("Could not forward getType to RewardItem", e);
            }
        }
        return str;
    }

    public int mo1210b() {
        int i = 0;
        if (this.f3905a != null) {
            try {
                i = this.f3905a.mo1189b();
            } catch (Throwable e) {
                C1324b.m7235d("Could not forward getAmount to RewardItem", e);
            }
        }
        return i;
    }
}
