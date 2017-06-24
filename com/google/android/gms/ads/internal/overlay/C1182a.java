package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.p031b.id;
import com.google.android.gms.p031b.jv;

@id
public class C1182a {
    public boolean m6595a(Context context, Intent intent, C1040p c1040p) {
        try {
            String str = "Launching an intent: ";
            String valueOf = String.valueOf(intent.toURI());
            jv.m9152e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            C1319u.m7183e().m9214a(context, intent);
            if (c1040p != null) {
                c1040p.mo975m();
            }
            return true;
        } catch (ActivityNotFoundException e) {
            C1324b.m7234d(e.getMessage());
            return false;
        }
    }

    public boolean m6596a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, C1040p c1040p) {
        if (adLauncherIntentInfoParcel == null) {
            C1324b.m7234d("No intent data for launcher overlay.");
            return false;
        } else if (adLauncherIntentInfoParcel.f3473i != null) {
            return m6595a(context, adLauncherIntentInfoParcel.f3473i, c1040p);
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.f3467c)) {
                C1324b.m7234d("Open GMSG did not contain a URL.");
                return false;
            }
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.f3468d)) {
                intent.setData(Uri.parse(adLauncherIntentInfoParcel.f3467c));
            } else {
                intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.f3467c), adLauncherIntentInfoParcel.f3468d);
            }
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f3469e)) {
                intent.setPackage(adLauncherIntentInfoParcel.f3469e);
            }
            if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f3470f)) {
                String[] split = adLauncherIntentInfoParcel.f3470f.split("/", 2);
                if (split.length < 2) {
                    String str = "Could not parse component name from open GMSG: ";
                    String valueOf = String.valueOf(adLauncherIntentInfoParcel.f3470f);
                    C1324b.m7234d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                    return false;
                }
                intent.setClassName(split[0], split[1]);
            }
            Object obj = adLauncherIntentInfoParcel.f3471g;
            if (!TextUtils.isEmpty(obj)) {
                int parseInt;
                try {
                    parseInt = Integer.parseInt(obj);
                } catch (NumberFormatException e) {
                    C1324b.m7234d("Could not parse intent flags.");
                    parseInt = 0;
                }
                intent.addFlags(parseInt);
            }
            return m6595a(context, intent, c1040p);
        }
    }
}
