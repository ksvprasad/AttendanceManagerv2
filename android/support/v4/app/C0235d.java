package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class C0235d {
    public static void m1326a(Activity activity) {
        activity.finishAffinity();
    }

    public static void m1327a(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }
}
