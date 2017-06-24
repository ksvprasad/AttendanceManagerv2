package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.C1962c.C1960a;
import com.google.android.gms.common.util.C1969b;
import com.google.android.gms.common.util.C1980m;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C1959b {
    private static final Object f6566a = new Object();
    private static C1959b f6567b;
    private static Integer f6568h;
    private final List<String> f6569c;
    private final List<String> f6570d;
    private final List<String> f6571e;
    private final List<String> f6572f;
    private C1964e f6573g;
    private C1964e f6574i;

    private C1959b() {
        if (C1959b.m11049c() == C1963d.f6586b) {
            this.f6569c = Collections.EMPTY_LIST;
            this.f6570d = Collections.EMPTY_LIST;
            this.f6571e = Collections.EMPTY_LIST;
            this.f6572f = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) C1960a.f6576b.m10145a();
        this.f6569c = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1960a.f6577c.m10145a();
        this.f6570d = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1960a.f6578d.m10145a();
        this.f6571e = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) C1960a.f6579e.m10145a();
        this.f6572f = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.f6573g = new C1964e(1024, ((Long) C1960a.f6580f.m10145a()).longValue());
        this.f6574i = new C1964e(1024, ((Long) C1960a.f6580f.m10145a()).longValue());
    }

    public static C1959b m11039a() {
        synchronized (f6566a) {
            if (f6567b == null) {
                f6567b = new C1959b();
            }
        }
        return f6567b;
    }

    private static String m11040a(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(C1959b.m11042a(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    private String m11041a(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private static String m11042a(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder((String.valueOf(valueOf).length() + 13) + String.valueOf(valueOf2).length()).append(valueOf).append(".").append(valueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    private void m11043a(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        Parcelable connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((C1959b.m11049c() & C1963d.f6590f) == 0 || i == 13)) {
            str6 = C1959b.m11040a(3, 5);
        }
        long j = 0;
        if ((C1959b.m11049c() & C1963d.f6592h) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(C1963d.f6585a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void m11044a(Context context, String str, String str2, Intent intent, int i) {
        String str3 = null;
        if (m11048b() && this.f6573g != null) {
            String str4;
            String str5;
            if (i != 4 && i != 1) {
                ServiceInfo b = C1959b.m11047b(context, intent);
                if (b == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = b.processName;
                str5 = b.name;
                str3 = C1980m.m11119a();
                if (m11046a(str3, str2, str4, str5)) {
                    this.f6573g.m11056a(str);
                } else {
                    return;
                }
            } else if (this.f6573g.m11057b(str)) {
                str5 = null;
                str4 = null;
            } else {
                return;
            }
            m11043a(context, str, i, str3, str2, str4, str5);
        }
    }

    private boolean m11045a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : C1969b.m11071a(context, component.getPackageName());
    }

    private boolean m11046a(String str, String str2, String str3, String str4) {
        return (this.f6569c.contains(str) || this.f6570d.contains(str2) || this.f6571e.contains(str3) || this.f6572f.contains(str4) || (str3.equals(str) && (C1959b.m11049c() & C1963d.f6591g) != 0)) ? false : true;
    }

    private static ServiceInfo m11047b(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), C1959b.m11040a(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), C1959b.m11040a(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    private boolean m11048b() {
        return false;
    }

    private static int m11049c() {
        if (f6568h == null) {
            try {
                f6568h = Integer.valueOf(C1969b.m11070a() ? ((Integer) C1960a.f6575a.m10145a()).intValue() : C1963d.f6586b);
            } catch (SecurityException e) {
                f6568h = Integer.valueOf(C1963d.f6586b);
            }
        }
        return f6568h.intValue();
    }

    @SuppressLint({"UntrackedBindService"})
    public void m11050a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        m11044a(context, m11041a(serviceConnection), null, null, 1);
    }

    public void m11051a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        m11044a(context, m11041a(serviceConnection), str, intent, 3);
    }

    public boolean m11052a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m11053a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m11053a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (m11045a(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            m11044a(context, m11041a(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void m11054b(Context context, ServiceConnection serviceConnection) {
        m11044a(context, m11041a(serviceConnection), null, null, 4);
    }
}
