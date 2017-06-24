package dotinc.attendancemanager2.p044b;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0778a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.daimajia.swipe.p028d.C0952a.C0951a;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p043a.C2293k;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class C2310g extends Fragment {
    public C0778a f7931a;
    private ImageView ai;
    public C2313c f7932b;
    public C2260d f7933c;
    public ArrayList<C2313c> f7934d;
    public int f7935e;
    public int f7936f;
    private RecyclerView f7937g;
    private RelativeLayout f7938h;
    private TextView f7939i;

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_weekly_subjects, viewGroup, false);
        this.f7937g = (RecyclerView) inflate.findViewById(R.id.week_sub_recyclerview);
        this.f7937g.setLayoutManager(new LinearLayoutManager(m1198i()));
        this.f7937g.setHasFixedSize(true);
        this.f7938h = (RelativeLayout) inflate.findViewById(R.id.empty_view);
        this.f7939i = (TextView) inflate.findViewById(R.id.empty_text);
        this.f7939i.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/oxygen-bold.ttf"));
        this.ai = (ImageView) inflate.findViewById(R.id.empty_image);
        Bundle h = m1196h();
        this.f7935e = h.getInt("pageNumber", 1);
        this.f7936f = h.getInt("view_timetable");
        if (this.f7936f == 1) {
            this.ai.setImageResource(R.drawable.rest_image);
            this.f7939i.setText("Enjoy your day off :)");
        }
        return inflate;
    }

    public void m12871a(int i) {
        if (i == 0) {
            this.f7938h.setVisibility(0);
        } else {
            this.f7938h.setVisibility(8);
        }
    }

    public void mo202d(Bundle bundle) {
        super.mo202d(bundle);
        this.f7933c = new C2260d(m1200j());
        this.f7932b = new C2313c();
        this.f7932b.m12895c(this.f7935e);
        this.f7934d = this.f7933c.m12742b(this.f7932b);
        this.f7931a = new C2293k(m1200j(), this.f7934d, this.f7932b, this, this.f7936f, this.f7935e);
        ((C2293k) this.f7931a).m5581a(C0951a.Single);
        this.f7937g.setAdapter(this.f7931a);
        m12871a(this.f7934d.size());
    }
}
