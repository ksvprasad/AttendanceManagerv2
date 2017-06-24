package android.support.v7.p018a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class C0634f {
    private static int f1525a = -1;
    private static boolean f1526b = false;

    C0634f() {
    }

    public static C0634f m3341a(Activity activity, C0630e c0630e) {
        return C0634f.m3343a(activity, activity.getWindow(), c0630e);
    }

    public static C0634f m3342a(Dialog dialog, C0630e c0630e) {
        return C0634f.m3343a(dialog.getContext(), dialog.getWindow(), c0630e);
    }

    private static C0634f m3343a(Context context, Window window, C0630e c0630e) {
        int i = VERSION.SDK_INT;
        return i >= 23 ? new C0644j(context, window, c0630e) : i >= 14 ? new C0642i(context, window, c0630e) : i >= 11 ? new C0640h(context, window, c0630e) : new C0639k(context, window, c0630e);
    }

    public static int m3344i() {
        return f1525a;
    }

    public static boolean m3345j() {
        return f1526b;
    }

    public abstract C0614a mo532a();

    public abstract View mo539a(int i);

    public abstract void mo541a(Configuration configuration);

    public abstract void mo542a(Bundle bundle);

    public abstract void mo544a(Toolbar toolbar);

    public abstract void mo545a(View view);

    public abstract void mo546a(View view, LayoutParams layoutParams);

    public abstract void mo533a(CharSequence charSequence);

    public abstract MenuInflater mo534b();

    public abstract void mo550b(int i);

    public abstract void mo551b(Bundle bundle);

    public abstract void mo552b(View view, LayoutParams layoutParams);

    public abstract void mo555c();

    public abstract void mo535c(Bundle bundle);

    public abstract boolean mo556c(int i);

    public abstract void mo557d();

    public abstract void mo558e();

    public abstract void mo536f();

    public abstract void mo559g();

    public abstract boolean mo537h();
}
