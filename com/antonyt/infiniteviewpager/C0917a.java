package com.antonyt.infiniteviewpager;

import android.os.Parcelable;
import android.support.v4.view.ab;
import android.view.View;
import android.view.ViewGroup;

public class C0917a extends ab {
    private ab f2785a;

    public C0917a(ab abVar) {
        this.f2785a = abVar;
    }

    public Parcelable mo231a() {
        return this.f2785a.mo231a();
    }

    public Object mo232a(ViewGroup viewGroup, int i) {
        return this.f2785a.mo232a(viewGroup, i % m5487d());
    }

    public void mo233a(Parcelable parcelable, ClassLoader classLoader) {
        this.f2785a.mo233a(parcelable, classLoader);
    }

    public void mo234a(ViewGroup viewGroup) {
        this.f2785a.mo234a(viewGroup);
    }

    public void mo235a(ViewGroup viewGroup, int i, Object obj) {
        this.f2785a.mo235a(viewGroup, i % m5487d(), obj);
    }

    public boolean mo236a(View view, Object obj) {
        return this.f2785a.mo236a(view, obj);
    }

    public int mo879b() {
        return Integer.MAX_VALUE;
    }

    public void mo237b(ViewGroup viewGroup) {
        this.f2785a.mo237b(viewGroup);
    }

    public int m5487d() {
        return this.f2785a.mo879b();
    }
}
