package android.support.v4.p010b.p011a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class C0291a {
    public static Drawable m1680a(Resources resources, int i, Theme theme) {
        return VERSION.SDK_INT >= 21 ? C0292b.m1681a(resources, i, theme) : resources.getDrawable(i);
    }
}
