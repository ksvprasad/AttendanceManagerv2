package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@id
@TargetApi(14)
public class ca implements ActivityLifecycleCallbacks {
    private Activity f4303a;
    private Context f4304b;
    private final Object f4305c = new Object();

    public ca(Application application, Context context) {
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            m7741a((Activity) context);
        }
        this.f4304b = context;
    }

    private void m7741a(Activity activity) {
        synchronized (this.f4305c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f4303a = activity;
            }
        }
    }

    public Activity m7742a() {
        return this.f4303a;
    }

    public Context m7743b() {
        return this.f4304b;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDestroyed(android.app.Activity r3) {
        /*
        r2 = this;
        r1 = r2.f4305c;
        monitor-enter(r1);
        r0 = r2.f4303a;	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r2.f4303a;	 Catch:{ all -> 0x0016 }
        r0 = r0.equals(r3);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0014;
    L_0x0011:
        r0 = 0;
        r2.f4303a = r0;	 Catch:{ all -> 0x0016 }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        goto L_0x0008;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.b.ca.onActivityDestroyed(android.app.Activity):void");
    }

    public void onActivityPaused(Activity activity) {
        m7741a(activity);
    }

    public void onActivityResumed(Activity activity) {
        m7741a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        m7741a(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}
