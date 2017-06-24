package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0763h;
import android.support.v7.widget.RecyclerView.C0798r;
import android.view.View;

class ay {
    static int m5162a(C0798r c0798r, as asVar, View view, View view2, C0763h c0763h, boolean z) {
        if (c0763h.m4204t() == 0 || c0798r.m4540e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(c0763h.m4167d(view) - c0763h.m4167d(view2)) + 1;
        }
        return Math.min(asVar.mo815f(), asVar.mo809b(view2) - asVar.mo807a(view));
    }

    static int m5163a(C0798r c0798r, as asVar, View view, View view2, C0763h c0763h, boolean z, boolean z2) {
        if (c0763h.m4204t() == 0 || c0798r.m4540e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (c0798r.m4540e() - Math.max(c0763h.m4167d(view), c0763h.m4167d(view2))) - 1) : Math.max(0, Math.min(c0763h.m4167d(view), c0763h.m4167d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(asVar.mo809b(view2) - asVar.mo807a(view))) / ((float) (Math.abs(c0763h.m4167d(view) - c0763h.m4167d(view2)) + 1)))) + ((float) (asVar.mo810c() - asVar.mo807a(view))));
    }

    static int m5164b(C0798r c0798r, as asVar, View view, View view2, C0763h c0763h, boolean z) {
        if (c0763h.m4204t() == 0 || c0798r.m4540e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0798r.m4540e();
        }
        return (int) ((((float) (asVar.mo809b(view2) - asVar.mo807a(view))) / ((float) (Math.abs(c0763h.m4167d(view) - c0763h.m4167d(view2)) + 1))) * ((float) c0798r.m4540e()));
    }
}
