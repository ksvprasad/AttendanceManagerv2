package dotinc.attendancemanager2.p043a;

import android.support.v4.app.C0263r;
import android.support.v4.app.C0274u;
import android.support.v4.app.Fragment;
import java.util.ArrayList;

public class C2275d extends C0274u {
    private ArrayList<Fragment> f7820a;

    public C2275d(C0263r c0263r, ArrayList<Fragment> arrayList) {
        super(c0263r);
        this.f7820a = arrayList;
    }

    public Fragment mo1800a(int i) {
        return (Fragment) this.f7820a.get(i);
    }

    public int mo879b() {
        return this.f7820a.size();
    }
}
