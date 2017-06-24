package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p018a.C0634f;
import java.lang.ref.WeakReference;

public class bj extends Resources {
    private final WeakReference<Context> f2619a;

    public bj(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2619a = new WeakReference(context);
    }

    public static boolean m5278a() {
        return C0634f.m3345j() && VERSION.SDK_INT <= 20;
    }

    final Drawable m5279a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2619a.get();
        return context != null ? C0893m.m5425a().m5450a(context, this, i) : super.getDrawable(i);
    }
}
