package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class C0536q {
    public static MenuItem m2866a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static View m2867a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static void m2868a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m2869b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
