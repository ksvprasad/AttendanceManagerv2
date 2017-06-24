package android.support.v7.widget;

import android.graphics.Outline;

class C0863c extends C0858b {
    public C0863c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1931d) {
            if (this.a.f1930c != null) {
                this.a.f1930c.getOutline(outline);
            }
        } else if (this.a.f1928a != null) {
            this.a.f1928a.getOutline(outline);
        }
    }
}
