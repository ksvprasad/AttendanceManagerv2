package android.support.v4.p010b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;

public class C0195a {
    public static final Drawable m1224a(Context context, int i) {
        return VERSION.SDK_INT >= 21 ? C0293b.m1682a(context, i) : context.getResources().getDrawable(i);
    }

    public static boolean m1225a(Context context, Intent[] intentArr, Bundle bundle) {
        int i = VERSION.SDK_INT;
        if (i >= 16) {
            C0296e.m1686a(context, intentArr, bundle);
            return true;
        } else if (i < 11) {
            return false;
        } else {
            C0295d.m1685a(context, intentArr);
            return true;
        }
    }

    public static final ColorStateList m1226b(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0294c.m1683a(context, i) : context.getResources().getColorStateList(i);
    }

    public static final int m1227c(Context context, int i) {
        return VERSION.SDK_INT >= 23 ? C0294c.m1684b(context, i) : context.getResources().getColor(i);
    }
}
