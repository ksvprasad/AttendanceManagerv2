package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class C0255m extends Fragment implements OnCancelListener, OnDismissListener {
    int f916a = 0;
    int f917b = 0;
    boolean f918c = true;
    boolean f919d = true;
    int f920e = -1;
    Dialog f921f;
    boolean f922g;
    boolean f923h;
    boolean f924i;

    public Dialog m1398a() {
        return this.f921f;
    }

    public void mo197a(Activity activity) {
        super.mo197a(activity);
        if (!this.f924i) {
            this.f923h = false;
        }
    }

    public void m1400a(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
            default:
                return;
        }
        dialog.requestWindowFeature(1);
    }

    public void mo198a(Bundle bundle) {
        super.mo198a(bundle);
        this.f919d = this.G == 0;
        if (bundle != null) {
            this.f916a = bundle.getInt("android:style", 0);
            this.f917b = bundle.getInt("android:theme", 0);
            this.f918c = bundle.getBoolean("android:cancelable", true);
            this.f919d = bundle.getBoolean("android:showsDialog", this.f919d);
            this.f920e = bundle.getInt("android:backStackId", -1);
        }
    }

    public void mo1651a(C0263r c0263r, String str) {
        this.f923h = false;
        this.f924i = true;
        C0250v a = c0263r.mo224a();
        a.mo191a((Fragment) this, str);
        a.mo187a();
    }

    void m1403a(boolean z) {
        if (!this.f923h) {
            this.f923h = true;
            this.f924i = false;
            if (this.f921f != null) {
                this.f921f.dismiss();
                this.f921f = null;
            }
            this.f922g = true;
            if (this.f920e >= 0) {
                m1204l().mo226a(this.f920e, 1);
                this.f920e = -1;
                return;
            }
            C0250v a = m1204l().mo224a();
            a.mo190a(this);
            if (z) {
                a.mo192b();
            } else {
                a.mo187a();
            }
        }
    }

    public int m1404b() {
        return this.f917b;
    }

    public LayoutInflater mo199b(Bundle bundle) {
        if (!this.f919d) {
            return super.mo199b(bundle);
        }
        this.f921f = mo1652c(bundle);
        if (this.f921f == null) {
            return (LayoutInflater) this.C.m1430g().getSystemService("layout_inflater");
        }
        m1400a(this.f921f, this.f916a);
        return (LayoutInflater) this.f921f.getContext().getSystemService("layout_inflater");
    }

    public void m1406b(boolean z) {
        this.f919d = z;
    }

    public Dialog mo1652c(Bundle bundle) {
        return new Dialog(m1200j(), m1404b());
    }

    public void mo200c() {
        super.mo200c();
        if (!this.f924i && !this.f923h) {
            this.f923h = true;
        }
    }

    public void mo201d() {
        super.mo201d();
        if (this.f921f != null) {
            this.f922g = false;
            this.f921f.show();
        }
    }

    public void mo202d(Bundle bundle) {
        super.mo202d(bundle);
        if (this.f919d) {
            View r = m1210r();
            if (r != null) {
                if (r.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f921f.setContentView(r);
            }
            this.f921f.setOwnerActivity(m1200j());
            this.f921f.setCancelable(this.f918c);
            this.f921f.setOnCancelListener(this);
            this.f921f.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f921f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public void mo203e() {
        super.mo203e();
        if (this.f921f != null) {
            this.f921f.hide();
        }
    }

    public void mo204e(Bundle bundle) {
        super.mo204e(bundle);
        if (this.f921f != null) {
            Bundle onSaveInstanceState = this.f921f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.f916a != 0) {
            bundle.putInt("android:style", this.f916a);
        }
        if (this.f917b != 0) {
            bundle.putInt("android:theme", this.f917b);
        }
        if (!this.f918c) {
            bundle.putBoolean("android:cancelable", this.f918c);
        }
        if (!this.f919d) {
            bundle.putBoolean("android:showsDialog", this.f919d);
        }
        if (this.f920e != -1) {
            bundle.putInt("android:backStackId", this.f920e);
        }
    }

    public void mo205f() {
        super.mo205f();
        if (this.f921f != null) {
            this.f922g = true;
            this.f921f.dismiss();
            this.f921f = null;
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f922g) {
            m1403a(true);
        }
    }
}
