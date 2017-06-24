package android.support.v4.app;

import android.app.AppOpsManager;
import android.content.Context;

class C0243h {
    public static int m1339a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public static String m1340a(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
