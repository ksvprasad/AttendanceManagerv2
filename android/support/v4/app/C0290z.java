package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.p010b.C0301f;
import android.util.Log;

public final class C0290z {
    private static final C0287a f1049a;

    interface C0287a {
        Intent mo240a(Activity activity);

        String mo241a(Context context, ActivityInfo activityInfo);

        boolean mo242a(Activity activity, Intent intent);

        void mo243b(Activity activity, Intent intent);
    }

    static class C0288b implements C0287a {
        C0288b() {
        }

        public Intent mo240a(Activity activity) {
            String b = C0290z.m1677b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return C0290z.m1678b((Context) activity, componentName) == null ? C0301f.m1690a(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public String mo241a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            return string == null ? null : string.charAt(0) == '.' ? context.getPackageName() + string : string;
        }

        public boolean mo242a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void mo243b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    static class C0289c extends C0288b {
        C0289c() {
        }

        public Intent mo240a(Activity activity) {
            Intent a = aa.m1231a(activity);
            return a == null ? m1672b(activity) : a;
        }

        public String mo241a(Context context, ActivityInfo activityInfo) {
            String a = aa.m1232a(activityInfo);
            return a == null ? super.mo241a(context, activityInfo) : a;
        }

        public boolean mo242a(Activity activity, Intent intent) {
            return aa.m1233a(activity, intent);
        }

        Intent m1672b(Activity activity) {
            return super.mo240a(activity);
        }

        public void mo243b(Activity activity, Intent intent) {
            aa.m1234b(activity, intent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1049a = new C0289c();
        } else {
            f1049a = new C0288b();
        }
    }

    public static Intent m1674a(Activity activity) {
        return f1049a.mo240a(activity);
    }

    public static Intent m1675a(Context context, ComponentName componentName) {
        String b = C0290z.m1678b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return C0290z.m1678b(context, componentName2) == null ? C0301f.m1690a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean m1676a(Activity activity, Intent intent) {
        return f1049a.mo242a(activity, intent);
    }

    public static String m1677b(Activity activity) {
        try {
            return C0290z.m1678b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m1678b(Context context, ComponentName componentName) {
        return f1049a.mo241a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void m1679b(Activity activity, Intent intent) {
        f1049a.mo243b(activity, intent);
    }
}
