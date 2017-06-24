package dotinc.attendancemanager2.p043a;

import android.os.Bundle;
import android.support.v4.app.C0263r;
import android.support.v4.app.C0274u;
import android.support.v4.app.Fragment;
import dotinc.attendancemanager2.p044b.C2310g;
import java.util.ArrayList;

public class C2294l extends C0274u {
    private ArrayList<Fragment> f7895a;
    private String[] f7896b;
    private int f7897c;

    public C2294l(C0263r c0263r, ArrayList<Fragment> arrayList, String[] strArr, int i) {
        super(c0263r);
        this.f7895a = arrayList;
        this.f7896b = strArr;
        this.f7897c = i;
    }

    public Fragment mo1800a(int i) {
        C2310g c2310g = (C2310g) this.f7895a.get(i);
        Bundle bundle = new Bundle();
        bundle.putInt("pageNumber", i + 1);
        bundle.putInt("view_timetable", this.f7897c);
        c2310g.m1194g(bundle);
        return c2310g;
    }

    public int mo879b() {
        return this.f7895a.size();
    }

    public CharSequence mo1801c(int i) {
        return this.f7896b[i];
    }
}
