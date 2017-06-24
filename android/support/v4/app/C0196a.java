package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p010b.C0195a;

public class C0196a extends C0195a {

    public interface C0194a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public static void m1228a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0235d.m1326a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m1229a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0235d.m1327a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m1230a(final Activity activity, final String[] strArr, final int i) {
        if (VERSION.SDK_INT >= 23) {
            C0233b.m1324a(activity, strArr, i);
        } else if (activity instanceof C0194a) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        iArr[i] = packageManager.checkPermission(strArr[i], packageName);
                    }
                    ((C0194a) activity).onRequestPermissionsResult(i, strArr, iArr);
                }
            });
        }
    }
}
