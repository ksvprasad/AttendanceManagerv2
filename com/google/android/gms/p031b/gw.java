package com.google.android.gms.p031b;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.gx.C1199a;
import com.google.android.gms.p031b.gy.C1562a;
import com.google.android.gms.p033a.C1001b;
import com.google.android.gms.p033a.C1003c;

@id
public final class gw extends C1003c<gy> {
    public gw() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public gx m8684a(Activity activity) {
        try {
            return C1199a.m6650a(((gy) m5715a(activity)).mo1428a(C1001b.m5713a((Object) activity)));
        } catch (Throwable e) {
            C1324b.m7235d("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            C1324b.m7235d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected gy m8685a(IBinder iBinder) {
        return C1562a.m8701a(iBinder);
    }

    protected /* synthetic */ Object mo1043b(IBinder iBinder) {
        return m8685a(iBinder);
    }
}
