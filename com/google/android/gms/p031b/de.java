package com.google.android.gms.p031b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import java.util.List;

@id
public class de implements ah {
    private CustomTabsSession f4449a;
    private CustomTabsClient f4450b;
    private CustomTabsServiceConnection f4451c;
    private C1416a f4452d;

    public interface C1416a {
    }

    public static boolean m7894a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || resolveActivity == null) {
            return false;
        }
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            if (resolveActivity.activityInfo.name.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name)) {
                return resolveActivity.activityInfo.packageName.equals(af.m7424a(context));
            }
        }
        return false;
    }

    public CustomTabsSession m7895a() {
        if (this.f4450b == null) {
            this.f4449a = null;
        } else if (this.f4449a == null) {
            this.f4449a = this.f4450b.newSession(null);
        }
        return this.f4449a;
    }

    public void m7896a(Activity activity) {
        if (this.f4451c != null) {
            activity.unbindService(this.f4451c);
            this.f4450b = null;
            this.f4449a = null;
            this.f4451c = null;
        }
    }

    public void m7897a(C1416a c1416a) {
        this.f4452d = c1416a;
    }

    public void m7898b(Activity activity) {
        if (this.f4450b == null) {
            String a = af.m7424a(activity);
            if (a != null) {
                this.f4451c = new ag(this);
                CustomTabsClient.bindCustomTabsService(activity, a, this.f4451c);
            }
        }
    }
}
