package android.support.v4.p004c.p005a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p004c.p005a.C0325j.C0323a;

class C0329l extends C0325j {

    private static class C0328a extends C0323a {
        C0328a(C0323a c0323a, Resources resources) {
            super(c0323a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0329l(this, resources);
        }
    }

    C0329l(Drawable drawable) {
        super(drawable);
    }

    C0329l(C0323a c0323a, Resources resources) {
        super(c0323a, resources);
    }

    C0323a mo265b() {
        return new C0328a(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }
}
