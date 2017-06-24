package com.google.ads.mediation;

import android.os.Bundle;
import android.support.annotation.Keep;
import com.google.android.gms.ads.mediation.C0959c;
import com.google.android.gms.ads.mediation.C0960g;
import com.google.android.gms.ads.mediation.C0961e;

@Keep
public final class AdUrlAdapter extends C0962a implements C0959c, C0961e, C0960g {
    public String getAdUnitId(Bundle bundle) {
        return "adurl";
    }

    protected Bundle zza(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle2);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }
}
