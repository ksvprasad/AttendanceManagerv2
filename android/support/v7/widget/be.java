package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.p018a.C0634f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class be extends ContextWrapper {
    private static final ArrayList<WeakReference<be>> f2586a = new ArrayList();
    private Resources f2587b;
    private final Theme f2588c;

    private be(Context context) {
        super(context);
        if (bj.m5278a()) {
            this.f2588c = getResources().newTheme();
            this.f2588c.setTo(context.getTheme());
            return;
        }
        this.f2588c = null;
    }

    public static Context m5206a(Context context) {
        if (!m5207b(context)) {
            return context;
        }
        Context context2;
        int size = f2586a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f2586a.get(i);
            context2 = weakReference != null ? (be) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new be(context);
        f2586a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m5207b(Context context) {
        return ((context instanceof be) || (context.getResources() instanceof bg) || (context.getResources() instanceof bj)) ? false : !C0634f.m3345j() || VERSION.SDK_INT <= 20;
    }

    public Resources getResources() {
        if (this.f2587b == null) {
            this.f2587b = this.f2588c == null ? new bg(this, super.getResources()) : new bj(this, super.getResources());
        }
        return this.f2587b;
    }

    public Theme getTheme() {
        return this.f2588c == null ? super.getTheme() : this.f2588c;
    }

    public void setTheme(int i) {
        if (this.f2588c == null) {
            super.setTheme(i);
        } else {
            this.f2588c.applyStyle(i, true);
        }
    }
}
