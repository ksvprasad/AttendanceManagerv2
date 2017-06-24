package dotinc.attendancemanager2.Utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ae.C0204d;
import android.util.Log;
import dotinc.attendancemanager2.MainActivity;
import dotinc.attendancemanager2.R;
import java.util.Random;

public class ReminderBroadcastReciever extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.d("option_noti", "here_broad");
        int nextInt = new Random().nextInt();
        PendingIntent activity = PendingIntent.getActivity(context, nextInt, new Intent(context, MainActivity.class), 134217728);
        Intent intent2 = new Intent(context, CancelIntent.class);
        intent2.putExtra("notificationId", nextInt);
        PendingIntent.getActivity(context, nextInt, intent2, 134217728);
        Log.d("option_not_rem", String.valueOf(nextInt));
        C0204d a = new C0204d(context).m1253a((int) R.mipmap.ic_launcher).m1256a((CharSequence) "Attendance Manager").m1258b("Did you mark today's attendance?").m1257a(true);
        a.m1255a(activity);
        ((NotificationManager) context.getSystemService("notification")).notify(nextInt, a.m1252a());
    }
}
