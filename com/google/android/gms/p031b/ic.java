package com.google.android.gms.p031b;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@id
public class ic implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler f5150a;
    private UncaughtExceptionHandler f5151b;
    private Context f5152c;
    private VersionInfoParcel f5153d;

    public ic(Context context, VersionInfoParcel versionInfoParcel, UncaughtExceptionHandler uncaughtExceptionHandler, UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.f5150a = uncaughtExceptionHandler;
        this.f5151b = uncaughtExceptionHandler2;
        this.f5152c = context;
        this.f5153d = versionInfoParcel;
    }

    public static ic m8868a(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        if (context == null || thread == null || versionInfoParcel == null) {
            return null;
        }
        if (!ic.m8869a(context)) {
            return null;
        }
        UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        UncaughtExceptionHandler icVar = new ic(context, versionInfoParcel, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof ic)) {
            return (ic) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(icVar);
            return icVar;
        } catch (Throwable e) {
            C1324b.m7233c("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private static boolean m8869a(Context context) {
        return ((Boolean) cq.f4392g.m7801c()).booleanValue();
    }

    private Throwable m8870b(Throwable th) {
        if (((Boolean) cq.f4393h.m7801c()).booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th2 = null;
        while (!linkedList.isEmpty()) {
            Throwable th3;
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            int i = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (m8873a(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    i = 1;
                } else if (m8875b(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (i != 0) {
                th3 = th2 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th2);
                th3.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th3 = th2;
            }
            th2 = th3;
        }
        return th2;
    }

    String m8871a(Class cls, Throwable th, boolean z) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", VERSION.RELEASE).appendQueryParameter("api", String.valueOf(VERSION.SDK_INT)).appendQueryParameter("device", C1319u.m7183e().m9246e()).appendQueryParameter("js", this.f5153d.f3957b).appendQueryParameter("appid", this.f5152c.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", cq.m7827a())).appendQueryParameter("trapped", String.valueOf(z)).toString();
    }

    public void m8872a(Throwable th, boolean z) {
        if (ic.m8869a(this.f5152c)) {
            Throwable b = m8870b(th);
            if (b != null) {
                Class cls = th.getClass();
                List arrayList = new ArrayList();
                arrayList.add(m8871a(cls, b, z));
                C1319u.m7183e().m9223a(arrayList, C1319u.m7186h().m9129h());
            }
        }
    }

    protected boolean m8873a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith((String) cq.f4394i.m7801c())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(id.class);
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = "Fail to check class type for class ";
            String valueOf = String.valueOf(str);
            C1324b.m7228a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return false;
        }
    }

    protected boolean m8874a(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (m8873a(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || r2) {
            z = false;
        }
        return z;
    }

    protected boolean m8875b(String str) {
        return TextUtils.isEmpty(str) ? false : str.startsWith("android.") || str.startsWith("java.");
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (m8874a(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                m8872a(th, true);
                return;
            }
            m8872a(th, false);
        }
        if (this.f5150a != null) {
            this.f5150a.uncaughtException(thread, th);
        } else if (this.f5151b != null) {
            this.f5151b.uncaughtException(thread, th);
        }
    }
}
