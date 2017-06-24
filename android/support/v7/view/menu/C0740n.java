package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p012d.p013a.C0335a;
import android.support.v4.p012d.p013a.C0336b;
import android.support.v4.p012d.p013a.C0337c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class C0740n {
    public static Menu m3922a(Context context, C0335a c0335a) {
        if (VERSION.SDK_INT >= 14) {
            return new C0741o(context, c0335a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m3923a(Context context, C0336b c0336b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0737j(context, c0336b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0735i(context, c0336b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m3924a(Context context, C0337c c0337c) {
        if (VERSION.SDK_INT >= 14) {
            return new C0743q(context, c0337c);
        }
        throw new UnsupportedOperationException();
    }
}
