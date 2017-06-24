package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.firebase.C2112a;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class C1659k implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final C1659k f5573a = new C1659k();
    private final AtomicBoolean f5574b = new AtomicBoolean();
    private boolean f5575c;

    private C1659k() {
    }

    public static void m9258a(Application application) {
        application.registerActivityLifecycleCallbacks(f5573a);
        application.registerComponentCallbacks(f5573a);
        f5573a.f5575c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.f5574b.compareAndSet(true, false)) {
            C2112a.m12092a(false);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (this.f5574b.compareAndSet(true, false)) {
            C2112a.m12092a(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i) {
        if (i == 20 && this.f5574b.compareAndSet(false, true)) {
            C2112a.m12092a(true);
        }
    }
}
