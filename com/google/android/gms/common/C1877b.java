package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.C0260n;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.C1004a.C0996b;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.C1928o;
import com.google.android.gms.common.internal.C1929p;
import com.google.android.gms.common.util.C1973f;
import com.google.android.gms.common.util.C1979l;
import com.google.android.gms.p031b.mr;
import com.google.android.gms.p031b.mr.C1736a;
import com.google.android.gms.p031b.mw;

public class C1877b extends C1876j {
    public static final int f6383a = C1876j.f6382b;
    private static final C1877b f6384c = new C1877b();

    C1877b() {
    }

    public static C1877b m10617a() {
        return f6384c;
    }

    public int mo1643a(Context context) {
        return super.mo1643a(context);
    }

    public Dialog m10619a(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        return m10621a((Context) activity, i, C1929p.m10885a(activity, mo1646a((Context) activity, i, "d"), i2), onCancelListener);
    }

    public Dialog m10620a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String h = C1881l.m10649h(activity);
        builder.setMessage(activity.getResources().getString(C0996b.common_google_play_services_updating_text, new Object[]{h}));
        builder.setTitle(C0996b.common_google_play_services_updating_title);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        m10627a(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    @TargetApi(14)
    Dialog m10621a(Context context, int i, C1929p c1929p, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (C1973f.m11091a(context) && i == 2) {
            i = 42;
        }
        if (C1979l.m11110d()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(context, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(context);
        }
        builder.setMessage(C1928o.m10879a(context, i, C1881l.m10649h(context)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        CharSequence c = C1928o.m10884c(context, i);
        if (c != null) {
            builder.setPositiveButton(c, c1929p);
        }
        c = C1928o.m10878a(context, i);
        if (c != null) {
            builder.setTitle(c);
        }
        return builder.create();
    }

    public PendingIntent mo1644a(Context context, int i, int i2) {
        return super.mo1644a(context, i, i2);
    }

    public PendingIntent mo1645a(Context context, int i, int i2, String str) {
        return super.mo1645a(context, i, i2, str);
    }

    public PendingIntent m10624a(Context context, ConnectionResult connectionResult) {
        if (connectionResult.m10546a()) {
            return connectionResult.m10549d();
        }
        int c = connectionResult.m10548c();
        if (C1973f.m11091a(context) && c == 2) {
            c = 42;
        }
        return mo1644a(context, c, 0);
    }

    public Intent mo1646a(Context context, int i, String str) {
        return super.mo1646a(context, i, str);
    }

    public mr m10626a(Context context, C1736a c1736a) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        BroadcastReceiver mrVar = new mr(c1736a);
        context.registerReceiver(mrVar, intentFilter);
        mrVar.m10066a(context);
        if (m10613a(context, "com.google.android.gms")) {
            return mrVar;
        }
        c1736a.mo1573a();
        mrVar.m10065a();
        return null;
    }

    @TargetApi(11)
    void m10627a(Activity activity, Dialog dialog, String str, OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof C0260n;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            C1883f.m10657a(dialog, onCancelListener).mo1651a(((C0260n) activity).m1461f(), str);
        } else if (C1979l.m11106a()) {
            C1856a.m10551a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public void m10628a(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent a = m10624a(context, connectionResult);
        if (a != null) {
            C1882e.m10655a(connectionResult.m10548c(), context, GoogleApiActivity.m10552a(context, a, i));
        }
    }

    public final boolean mo1647a(int i) {
        return super.mo1647a(i);
    }

    public boolean m10630a(Activity activity, mw mwVar, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m10621a((Context) activity, i, C1929p.m10886a(mwVar, mo1646a((Context) activity, i, "d"), i2), onCancelListener);
        if (a == null) {
            return false;
        }
        m10627a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public boolean mo1648a(Context context, int i) {
        return super.mo1648a(context, i);
    }

    public int mo1649b(Context context) {
        return super.mo1649b(context);
    }

    @Deprecated
    public Intent mo1650b(int i) {
        return super.mo1650b(i);
    }

    public boolean m10634b(Activity activity, int i, int i2, OnCancelListener onCancelListener) {
        Dialog a = m10619a(activity, i, i2, onCancelListener);
        if (a == null) {
            return false;
        }
        m10627a(activity, a, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
