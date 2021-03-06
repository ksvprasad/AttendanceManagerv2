package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

public class C1965f {
    public static String m11058a(WakeLock wakeLock, String str) {
        Object obj;
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str)) {
            obj = "";
        }
        String valueOf2 = String.valueOf(obj);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static String m11059a(String str) {
        return "com.google.android.gms".equals(str) ? null : str;
    }

    static List<String> m11060a(List<String> list) {
        return (list != null && list.size() == 1 && "com.google.android.gms".equals(list.get(0))) ? null : list;
    }
}
