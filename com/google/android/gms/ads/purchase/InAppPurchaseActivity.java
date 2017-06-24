package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.C1120y;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.he;

public class InAppPurchaseActivity extends Activity {
    private he f4028a;

    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.f4028a != null) {
                this.f4028a.mo1166a(i, i2, intent);
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4028a = C1120y.m6295b().m6290a((Activity) this);
        if (this.f4028a == null) {
            C1324b.m7234d("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f4028a.mo1165a();
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    protected void onDestroy() {
        try {
            if (this.f4028a != null) {
                this.f4028a.mo1167b();
            }
        } catch (Throwable e) {
            C1324b.m7235d("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
