package android.support.v4.p010b;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.C0242g;

public final class C0304i {
    public static int m1704a(Context context, String str) {
        return C0304i.m1705a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int m1705a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0242g.m1338a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0242g.m1337a(context, a, str2) != 0 ? -2 : 0;
    }
}
