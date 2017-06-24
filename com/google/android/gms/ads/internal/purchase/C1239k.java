package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;

@id
public class C1239k {
    private final String f3667a;

    public C1239k(String str) {
        this.f3667a = str;
    }

    public String m6854a() {
        return C1319u.m7183e().m9243d();
    }

    public boolean m6855a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String b = C1319u.m7193o().m6851b(intent);
        String c = C1319u.m7193o().m6853c(intent);
        if (b == null || c == null) {
            return false;
        }
        if (!str.equals(C1319u.m7193o().m6848a(b))) {
            C1324b.m7234d("Developer payload not match.");
            return false;
        } else if (this.f3667a == null || C1240l.m6857a(this.f3667a, b, c)) {
            return true;
        } else {
            C1324b.m7234d("Fail to verify signature.");
            return false;
        }
    }
}
