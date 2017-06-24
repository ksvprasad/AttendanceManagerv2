package com.google.android.gms.p031b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import java.io.File;

public class C1412d {
    public static ks m7883a(Context context) {
        return C1412d.m7884a(context, null);
    }

    public static ks m7884a(Context context, of ofVar) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = new StringBuilder(String.valueOf(packageName).length() + 12).append(packageName).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
        } catch (NameNotFoundException e) {
        }
        if (ofVar == null) {
            ofVar = VERSION.SDK_INT >= 9 ? new og() : new od(AndroidHttpClient.newInstance(str));
        }
        ks ksVar = new ks(new ny(file), new nr(ofVar));
        ksVar.m9372a();
        return ksVar;
    }
}
