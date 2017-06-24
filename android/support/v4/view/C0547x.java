package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public class C0547x {
    private final View f1291a;
    private ViewParent f1292b;
    private boolean f1293c;
    private int[] f1294d;

    public C0547x(View view) {
        this.f1291a = view;
    }

    public void m2909a(boolean z) {
        if (this.f1293c) {
            ag.m2558z(this.f1291a);
        }
        this.f1293c = z;
    }

    public boolean m2910a() {
        return this.f1293c;
    }

    public boolean m2911a(float f, float f2) {
        return (!m2910a() || this.f1292b == null) ? false : au.m2668a(this.f1292b, this.f1291a, f, f2);
    }

    public boolean m2912a(float f, float f2, boolean z) {
        return (!m2910a() || this.f1292b == null) ? false : au.m2669a(this.f1292b, this.f1291a, f, f2, z);
    }

    public boolean m2913a(int i) {
        if (m2916b()) {
            return true;
        }
        if (m2910a()) {
            View view = this.f1291a;
            for (ViewParent parent = this.f1291a.getParent(); parent != null; parent = parent.getParent()) {
                if (au.m2670a(parent, view, this.f1291a, i)) {
                    this.f1292b = parent;
                    au.m2671b(parent, view, this.f1291a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean m2914a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m2910a() || this.f1292b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f1291a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            au.m2666a(this.f1292b, this.f1291a, i, i2, i3, i4);
            if (iArr != null) {
                this.f1291a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m2915a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m2910a() || this.f1292b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f1291a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f1294d == null) {
                    this.f1294d = new int[2];
                }
                iArr = this.f1294d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            au.m2667a(this.f1292b, this.f1291a, i, i2, iArr);
            if (iArr2 != null) {
                this.f1291a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m2916b() {
        return this.f1292b != null;
    }

    public void m2917c() {
        if (this.f1292b != null) {
            au.m2665a(this.f1292b, this.f1291a);
            this.f1292b = null;
        }
    }
}
