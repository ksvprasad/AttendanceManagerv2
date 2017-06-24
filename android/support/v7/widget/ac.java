package android.support.v7.widget;

import android.content.Context;
import android.view.View;

class ac implements af {
    ac() {
    }

    private av m4854i(ad adVar) {
        return (av) adVar.mo698c();
    }

    public float mo774a(ad adVar) {
        return m4854i(adVar).m5132a();
    }

    public void mo775a() {
    }

    public void mo776a(ad adVar, float f) {
        m4854i(adVar).m5133a(f);
    }

    public void mo777a(ad adVar, int i) {
        m4854i(adVar).m5135a(i);
    }

    public void mo778a(ad adVar, Context context, int i, float f, float f2, float f3) {
        adVar.mo695a(new av(i, f));
        View d = adVar.mo699d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        mo780b(adVar, f3);
    }

    public float mo779b(ad adVar) {
        return mo783d(adVar) * 2.0f;
    }

    public void mo780b(ad adVar, float f) {
        m4854i(adVar).m5134a(f, adVar.mo696a(), adVar.mo697b());
        m4866f(adVar);
    }

    public float mo781c(ad adVar) {
        return mo783d(adVar) * 2.0f;
    }

    public void mo782c(ad adVar, float f) {
        adVar.mo699d().setElevation(f);
    }

    public float mo783d(ad adVar) {
        return m4854i(adVar).m5136b();
    }

    public float mo784e(ad adVar) {
        return adVar.mo699d().getElevation();
    }

    public void m4866f(ad adVar) {
        if (adVar.mo696a()) {
            float a = mo774a(adVar);
            float d = mo783d(adVar);
            int ceil = (int) Math.ceil((double) aw.m5139b(a, d, adVar.mo697b()));
            int ceil2 = (int) Math.ceil((double) aw.m5137a(a, d, adVar.mo697b()));
            adVar.mo694a(ceil, ceil2, ceil, ceil2);
            return;
        }
        adVar.mo694a(0, 0, 0, 0);
    }

    public void mo785g(ad adVar) {
        mo780b(adVar, mo774a(adVar));
    }

    public void mo786h(ad adVar) {
        mo780b(adVar, mo774a(adVar));
    }
}
