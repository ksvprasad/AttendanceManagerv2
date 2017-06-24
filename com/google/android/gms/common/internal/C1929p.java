package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.p031b.mw;

public abstract class C1929p implements OnClickListener {

    class C19301 extends C1929p {
        final /* synthetic */ Intent f6491a;
        final /* synthetic */ Activity f6492b;
        final /* synthetic */ int f6493c;

        C19301(Intent intent, Activity activity, int i) {
            this.f6491a = intent;
            this.f6492b = activity;
            this.f6493c = i;
        }

        public void mo1712a() {
            if (this.f6491a != null) {
                this.f6492b.startActivityForResult(this.f6491a, this.f6493c);
            }
        }
    }

    class C19312 extends C1929p {
        final /* synthetic */ Intent f6494a;
        final /* synthetic */ mw f6495b;
        final /* synthetic */ int f6496c;

        C19312(Intent intent, mw mwVar, int i) {
            this.f6494a = intent;
            this.f6495b = mwVar;
            this.f6496c = i;
        }

        @TargetApi(11)
        public void mo1712a() {
            if (this.f6494a != null) {
                this.f6495b.startActivityForResult(this.f6494a, this.f6496c);
            }
        }
    }

    public static C1929p m10885a(Activity activity, Intent intent, int i) {
        return new C19301(intent, activity, i);
    }

    public static C1929p m10886a(mw mwVar, Intent intent, int i) {
        return new C19312(intent, mwVar, i);
    }

    public abstract void mo1712a();

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo1712a();
            dialogInterface.dismiss();
        } catch (Throwable e) {
            Log.e("DialogRedirect", "Can't redirect to app settings for Google Play services", e);
        }
    }
}
