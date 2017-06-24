package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.C0255m;
import android.support.v4.app.C0263r;
import com.google.android.gms.common.internal.C1896c;

public class C1883f extends C0255m {
    private Dialog ai = null;
    private OnCancelListener aj = null;

    public static C1883f m10657a(Dialog dialog, OnCancelListener onCancelListener) {
        C1883f c1883f = new C1883f();
        Dialog dialog2 = (Dialog) C1896c.m10791a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c1883f.ai = dialog2;
        if (onCancelListener != null) {
            c1883f.aj = onCancelListener;
        }
        return c1883f;
    }

    public void mo1651a(C0263r c0263r, String str) {
        super.mo1651a(c0263r, str);
    }

    public Dialog mo1652c(Bundle bundle) {
        if (this.ai == null) {
            m1406b(false);
        }
        return this.ai;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.aj != null) {
            this.aj.onCancel(dialogInterface);
        }
    }
}
