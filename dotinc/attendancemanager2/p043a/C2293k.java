package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.SwipeLayout.C0932b;
import com.daimajia.swipe.SwipeLayout.C0935e;
import com.daimajia.swipe.p026a.C0943a;
import com.daimajia.swipe.p027b.C0950b;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.WeeklySubjectsActivity;
import dotinc.attendancemanager2.p044b.C2310g;
import dotinc.attendancemanager2.p045c.C2312b;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class C2293k extends C0943a<C2292a> {
    protected C0950b f7885b = new C0950b(this);
    private Context f7886c;
    private LayoutInflater f7887d;
    private ArrayList<C2313c> f7888e;
    private ArrayList<C2312b> f7889f = new ArrayList();
    private C2260d f7890g;
    private C2313c f7891h;
    private int f7892i;
    private int f7893j;
    private C2310g f7894k;

    static class C2292a extends C0801u {
        private TextView f7882l;
        private SwipeLayout f7883m;
        private ImageButton f7884n;

        public C2292a(View view) {
            super(view);
            this.f7883m = (SwipeLayout) view.findViewById(R.id.swipe);
            this.f7882l = (TextView) view.findViewById(R.id.timetable_subject);
            this.f7884n = (ImageButton) view.findViewById(R.id.delete_subject);
        }
    }

    public C2293k(Context context, ArrayList<C2313c> arrayList, C2313c c2313c, C2310g c2310g, int i, int i2) {
        this.f7886c = context;
        this.f7891h = c2313c;
        this.f7894k = c2310g;
        this.f7888e = arrayList;
        this.f7892i = i;
        this.f7893j = i2;
        this.f7887d = LayoutInflater.from(context);
        this.f7890g = new C2260d(context);
    }

    private void m12842d(int i) {
        C2313c c2313c = new C2313c();
        c2313c.m12895c(this.f7893j);
        c2313c.m12891a(((C2313c) this.f7888e.get(i)).m12894c());
        c2313c.m12893b(((C2313c) this.f7888e.get(i)).m12892b());
        c2313c.m12890a(((C2313c) this.f7888e.get(i)).m12889a());
        this.f7890g.m12744c(c2313c);
        String c = ((C2313c) this.f7888e.get(i)).m12894c();
        this.f7888e.remove(i);
        m4400c(i);
        m4386a(i, this.f7888e.size());
        this.f7885b.m5596a();
        this.f7894k.m12871a(this.f7888e.size());
        ((WeeklySubjectsActivity) this.f7886c).m12754a(c + " Deleted");
        ((WeeklySubjectsActivity) this.f7886c).m12756l();
    }

    public int mo1796a() {
        return this.f7888e.size();
    }

    public /* synthetic */ C0801u mo1797a(ViewGroup viewGroup, int i) {
        return m12847c(viewGroup, i);
    }

    public void m12846a(C2292a c2292a, final int i) {
        c2292a.f7882l.setText(((C2313c) this.f7888e.get(i)).m12894c());
        c2292a.f7882l.setTypeface(Typeface.createFromAsset(this.f7886c.getAssets(), "fonts/josefin_sans-bold.ttf"));
        c2292a.f7883m.setShowMode(C0935e.PullOut);
        if (this.f7892i == 0) {
            c2292a.f7883m.m5564a(C0932b.Left, c2292a.f7883m.findViewById(R.id.right_swipe));
            c2292a.f7883m.m5564a(C0932b.Right, null);
        } else {
            c2292a.f7883m.m5564a(C0932b.Left, null);
            c2292a.f7883m.m5564a(C0932b.Right, null);
        }
        this.f7885b.m5600a(c2292a.a, i);
        c2292a.f7884n.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2293k f7881b;

            public void onClick(View view) {
                this.f7881b.m12842d(i);
            }
        });
    }

    public int a_(int i) {
        return R.id.swipe;
    }

    public C2292a m12847c(ViewGroup viewGroup, int i) {
        return new C2292a(this.f7887d.inflate(R.layout.custom_timetable, viewGroup, false));
    }
}
