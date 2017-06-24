package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.C1896c;

@id
public class ch {
    private final Context f4342a;

    public ch(Context context) {
        C1896c.m10791a((Object) context, (Object) "Context can not be null");
        this.f4342a = context;
    }

    public static boolean m7782e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public boolean m7783a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m7784a(intent);
    }

    public boolean m7784a(Intent intent) {
        C1896c.m10791a((Object) intent, (Object) "Intent can not be null");
        return !this.f4342a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean m7785b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m7784a(intent);
    }

    public boolean m7786c() {
        return ch.m7782e() && this.f4342a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean m7787d() {
        return true;
    }

    @TargetApi(14)
    public boolean m7788f() {
        return VERSION.SDK_INT >= 14 && m7784a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
