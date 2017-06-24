package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.p031b.nn;

public class ad {
    private static Object f6431a = new Object();
    private static boolean f6432b;
    private static String f6433c;
    private static int f6434d;

    public static String m10783a(Context context) {
        m10785c(context);
        return f6433c;
    }

    public static int m10784b(Context context) {
        m10785c(context);
        return f6434d;
    }

    private static void m10785c(Context context) {
        synchronized (f6431a) {
            if (f6432b) {
                return;
            }
            f6432b = true;
            try {
                Bundle bundle = nn.m10162b(context).m10159a(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f6433c = bundle.getString("com.google.app.id");
                f6434d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }
}
