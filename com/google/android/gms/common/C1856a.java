package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.C1896c;

@TargetApi(11)
public class C1856a extends DialogFragment {
    private Dialog f6328a = null;
    private OnCancelListener f6329b = null;

    public static C1856a m10551a(Dialog dialog, OnCancelListener onCancelListener) {
        C1856a c1856a = new C1856a();
        Dialog dialog2 = (Dialog) C1896c.m10791a((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c1856a.f6328a = dialog2;
        if (onCancelListener != null) {
            c1856a.f6329b = onCancelListener;
        }
        return c1856a;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.f6329b != null) {
            this.f6329b.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f6328a == null) {
            setShowsDialog(false);
        }
        return this.f6328a;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
