package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class aa {
    public static Intent m1231a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static String m1232a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }

    public static boolean m1233a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m1234b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
