package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class bg extends au {
    private final WeakReference<Context> f2593a;

    public bg(Context context, Resources resources) {
        super(resources);
        this.f2593a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f2593a.get();
        if (!(drawable == null || context == null)) {
            C0893m.m5425a();
            C0893m.m5431a(context, i, drawable);
        }
        return drawable;
    }
}
