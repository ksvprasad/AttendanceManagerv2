package dotinc.attendancemanager2.Utils;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CancelIntent extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("notificationId", 0);
        Log.d("option_not_ca", String.valueOf(intExtra));
        ((NotificationManager) context.getSystemService("notification")).cancel(intExtra);
    }
}
