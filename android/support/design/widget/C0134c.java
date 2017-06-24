package android.support.design.widget;

import android.graphics.Outline;

class C0134c extends C0133b {
    C0134c() {
    }

    public void getOutline(Outline outline) {
        copyBounds(this.b);
        outline.setOval(this.b);
    }
}
