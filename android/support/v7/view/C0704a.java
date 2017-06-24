package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ar;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0684b;
import android.support.v7.p019b.C0694a.C0686d;
import android.support.v7.p019b.C0694a.C0689g;
import android.support.v7.p019b.C0694a.C0693k;
import android.view.ViewConfiguration;

public class C0704a {
    private Context f1699a;

    private C0704a(Context context) {
        this.f1699a = context;
    }

    public static C0704a m3646a(Context context) {
        return new C0704a(context);
    }

    public int m3647a() {
        return this.f1699a.getResources().getInteger(C0689g.abc_max_action_buttons);
    }

    public boolean m3648b() {
        return VERSION.SDK_INT >= 19 || !ar.m2641b(ViewConfiguration.get(this.f1699a));
    }

    public int m3649c() {
        return this.f1699a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m3650d() {
        return this.f1699a.getApplicationInfo().targetSdkVersion >= 16 ? this.f1699a.getResources().getBoolean(C0684b.abc_action_bar_embed_tabs) : this.f1699a.getResources().getBoolean(C0684b.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m3651e() {
        TypedArray obtainStyledAttributes = this.f1699a.obtainStyledAttributes(null, C0693k.ActionBar, C0683a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0693k.ActionBar_height, 0);
        Resources resources = this.f1699a.getResources();
        if (!m3650d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0686d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m3652f() {
        return this.f1699a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m3653g() {
        return this.f1699a.getResources().getDimensionPixelSize(C0686d.abc_action_bar_stacked_tab_max_width);
    }
}
