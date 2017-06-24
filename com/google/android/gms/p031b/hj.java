package com.google.android.gms.p031b;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.he.C1230a;
import com.google.android.gms.p031b.hf.C1570a;
import com.google.android.gms.p033a.C1001b;
import com.google.android.gms.p033a.C1003c;

@id
public final class hj extends C1003c<hf> {
    public hj() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public he m8729a(Activity activity) {
        try {
            return C1230a.m6821a(((hf) m5715a(activity)).mo1430a(C1001b.m5713a((Object) activity)));
        } catch (Throwable e) {
            C1324b.m7235d("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            C1324b.m7235d("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected hf m8730a(IBinder iBinder) {
        return C1570a.m8717a(iBinder);
    }

    protected /* synthetic */ Object mo1043b(IBinder iBinder) {
        return m8730a(iBinder);
    }
}
