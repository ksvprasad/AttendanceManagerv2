package com.google.android.gms.ads.p029d.p030a;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.C0957b;
import com.google.android.gms.ads.mediation.C1331a;

public interface C0958a extends C0957b {
    void initialize(Context context, C1331a c1331a, String str, C1027b c1027b, Bundle bundle, Bundle bundle2);

    boolean isInitialized();

    void loadAd(C1331a c1331a, Bundle bundle, Bundle bundle2);

    void showVideo();
}
