package android.support.v4.p010b;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class C0305j extends BroadcastReceiver {
    private static final SparseArray<WakeLock> f1059a = new SparseArray();
    private static int f1060b = 1;

    public static ComponentName m1706a(Context context, Intent intent) {
        synchronized (f1059a) {
            int i = f1060b;
            f1060b++;
            if (f1060b <= 0) {
                f1060b = 1;
            }
            intent.putExtra("android.support.content.wakelockid", i);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:" + startService.flattenToShortString());
            newWakeLock.setReferenceCounted(false);
            newWakeLock.acquire(60000);
            f1059a.put(i, newWakeLock);
            return startService;
        }
    }

    public static boolean m1707a(Intent intent) {
        int intExtra = intent.getIntExtra("android.support.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        synchronized (f1059a) {
            WakeLock wakeLock = (WakeLock) f1059a.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                f1059a.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiver", "No active wake lock id #" + intExtra);
            return true;
        }
    }
}
