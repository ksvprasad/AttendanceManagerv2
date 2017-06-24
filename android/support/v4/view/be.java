package android.support.v4.view;

import android.view.WindowInsets;

class be extends bd {
    private final WindowInsets f1277a;

    be(WindowInsets windowInsets) {
        this.f1277a = windowInsets;
    }

    public int mo441a() {
        return this.f1277a.getSystemWindowInsetLeft();
    }

    public bd mo442a(int i, int i2, int i3, int i4) {
        return new be(this.f1277a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public int mo443b() {
        return this.f1277a.getSystemWindowInsetTop();
    }

    public int mo444c() {
        return this.f1277a.getSystemWindowInsetRight();
    }

    public int mo445d() {
        return this.f1277a.getSystemWindowInsetBottom();
    }

    public boolean mo446e() {
        return this.f1277a.isConsumed();
    }

    public bd mo447f() {
        return new be(this.f1277a.consumeSystemWindowInsets());
    }

    WindowInsets m2773g() {
        return this.f1277a;
    }
}
