package android.support.v4.p004c.p005a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p004c.p005a.C0325j.C0323a;

class C0331m extends C0329l {

    private static class C0330a extends C0323a {
        C0330a(C0323a c0323a, Resources resources) {
            super(c0323a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0331m(this, resources);
        }
    }

    C0331m(Drawable drawable) {
        super(drawable);
    }

    C0331m(C0323a c0323a, Resources resources) {
        super(c0323a, resources);
    }

    C0323a mo265b() {
        return new C0330a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
