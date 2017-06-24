package com.roomorama.caldroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.p024a.C0916a.C0913c;

public class C2191e extends Fragment {
    private GridView f7387a;
    private C2188b f7388b;
    private OnItemClickListener f7389c;
    private OnItemLongClickListener f7390d;
    private int f7391e = 0;
    private int f7392f = 0;

    private void m12493a() {
        if (this.f7388b != null) {
            this.f7387a.setAdapter(this.f7388b);
        }
        if (this.f7389c != null) {
            this.f7387a.setOnItemClickListener(this.f7389c);
        }
        if (this.f7390d != null) {
            this.f7387a.setOnItemLongClickListener(this.f7390d);
        }
    }

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f7391e == 0) {
            this.f7391e = C0913c.date_grid_fragment;
        }
        if (this.f7392f == 0 && this.f7388b != null) {
            this.f7392f = this.f7388b.m12479b();
        }
        if (this.f7387a == null) {
            this.f7387a = (GridView) C2187a.m12444a(m1200j(), layoutInflater, this.f7392f).inflate(this.f7391e, viewGroup, false);
            m12493a();
        } else {
            ViewGroup viewGroup2 = (ViewGroup) this.f7387a.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.f7387a);
            }
        }
        return this.f7387a;
    }

    public void m12495a(int i) {
        this.f7391e = i;
    }

    public void m12496a(OnItemClickListener onItemClickListener) {
        this.f7389c = onItemClickListener;
    }

    public void m12497a(OnItemLongClickListener onItemLongClickListener) {
        this.f7390d = onItemLongClickListener;
    }

    public void m12498a(C2188b c2188b) {
        this.f7388b = c2188b;
    }
}
