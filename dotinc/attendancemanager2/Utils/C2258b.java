package dotinc.attendancemanager2.Utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.TextView;
import com.google.firebase.p038a.C2111a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class C2258b {
    private static Handler f7741a;
    private static CharSequence f7742b;
    private static int f7743c;
    private static long f7744d;
    private static Runnable f7745e;

    static /* synthetic */ int m12713a() {
        int i = f7743c;
        f7743c = i + 1;
        return i;
    }

    public static String m12714a(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        String str = "\n\n---------------------------------------\n";
        return str + "\n\nModel: " + Build.MODEL + "\nOS: " + VERSION.RELEASE + "\nAppVersion: " + packageInfo.versionName + str;
    }

    public static void m12715a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("ATTENDANCE_MANAGER", 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void m12716a(final TextView textView, String str, long j) {
        f7741a = new Handler();
        f7743c = 0;
        f7742b = str;
        f7744d = j;
        f7745e = new Runnable() {
            public void run() {
                textView.setText(C2258b.f7742b.subSequence(0, C2258b.m12713a()));
                if (C2258b.f7743c <= C2258b.f7742b.length()) {
                    C2258b.f7741a.postDelayed(C2258b.f7745e, C2258b.f7744d);
                }
            }
        };
        textView.setText("");
        f7741a.removeCallbacks(f7745e);
        f7741a.postDelayed(f7745e, f7744d);
    }

    public static void m12717a(String str, String str2, String str3, Context context) {
        C2111a a = C2111a.m12085a(context);
        Bundle bundle = new Bundle();
        bundle.putString("item_name", str);
        bundle.putString("character", str2);
        if (str3.equals("1")) {
            bundle.putString("value", "Male");
        } else {
            bundle.putString("value", "Female");
        }
        a.m12086a("select_content", bundle);
    }

    public static boolean m12718a(String str) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File dataDirectory = Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                String str2 = "//data//dotinc.attendancemanager2//databases//" + str;
                String str3 = "/AttendanceManager/" + str;
                File file = new File(dataDirectory, str2);
                File file2 = new File(externalStorageDirectory, str3);
                Object channel = new FileInputStream(file).getChannel();
                FileChannel channel2 = new FileOutputStream(file2).getChannel();
                channel2.transferFrom(channel, 0, channel.size());
                channel.close();
                channel2.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String m12720b(Context context, String str, String str2) {
        return context.getSharedPreferences("ATTENDANCE_MANAGER", 0).getString(str, str2);
    }

    public static boolean m12721b(String str) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File dataDirectory = Environment.getDataDirectory();
            if (externalStorageDirectory.canWrite()) {
                String str2 = "//data//dotinc.attendancemanager2//databases//" + str;
                String str3 = "/AttendanceManager/" + str;
                File file = new File(dataDirectory, str2);
                Object channel = new FileInputStream(new File(externalStorageDirectory, str3)).getChannel();
                FileChannel channel2 = new FileOutputStream(file).getChannel();
                channel2.transferFrom(channel, 0, channel.size());
                channel.close();
                channel2.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
