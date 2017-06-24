package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.Log;
import java.io.File;

public class C1982o {
    @TargetApi(21)
    public static File m11123a(Context context) {
        return C1979l.m11117k() ? context.getNoBackupFilesDir() : C1982o.m11124a(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File m11124a(File file) {
        synchronized (C1982o.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                String str = "SupportV4Utils";
                String str2 = "Unable to create no-backup dir ";
                String valueOf = String.valueOf(file.getPath());
                Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                file = null;
            }
        }
        return file;
    }
}
