package dotinc.attendancemanager2;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p043a.C2283g;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;

public class PrevAttendanceActivity extends C0633d {
    private RecyclerView f7621m;
    private Context f7622n;
    private ImageView f7623o;
    private ArrayList<C2312b> f7624p;
    private ArrayList<C2312b> f7625q;
    private C2259c f7626r;
    private C2283g f7627s;
    private CoordinatorLayout f7628t;
    private Button f7629u;
    private Typeface f7630v;
    private Typeface f7631w;

    class C22301 implements OnClickListener {
        final /* synthetic */ PrevAttendanceActivity f7619a;

        C22301(PrevAttendanceActivity prevAttendanceActivity) {
            this.f7619a = prevAttendanceActivity;
        }

        public void onClick(View view) {
            this.f7619a.m12625m();
        }
    }

    class C22312 implements OnClickListener {
        final /* synthetic */ PrevAttendanceActivity f7620a;

        C22312(PrevAttendanceActivity prevAttendanceActivity) {
            this.f7620a = prevAttendanceActivity;
        }

        public void onClick(View view) {
            if (this.f7620a.f7627s.m12817d()) {
                Snackbar.m706a(this.f7620a.f7628t, "All past entries cleared", 0).m724a();
                this.f7620a.finish();
            }
        }
    }

    void m12623k() {
        this.f7622n = this;
        this.f7623o = (ImageView) findViewById(R.id.tickmark);
        this.f7629u = (Button) findViewById(R.id.clear);
        this.f7621m = (RecyclerView) findViewById(R.id.prev_att_recycler);
        this.f7621m.setHasFixedSize(true);
        this.f7621m.setLayoutManager(new LinearLayoutManager(this.f7622n));
        this.f7626r = new C2259c(this);
        this.f7624p = this.f7626r.m12727a();
        this.f7628t = (CoordinatorLayout) findViewById(R.id.root);
        this.f7630v = Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf");
        this.f7631w = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf");
        ((TextView) findViewById(R.id.page_title)).setTypeface(this.f7630v);
        ((TextView) findViewById(R.id.help_text)).setTypeface(this.f7631w);
    }

    void m12624l() {
        this.f7627s = new C2283g(this.f7622n, this.f7624p);
        this.f7621m.setAdapter(this.f7627s);
    }

    void m12625m() {
        this.f7625q = this.f7627s.m12818e();
        if (this.f7625q == null) {
            Snackbar.m706a(this.f7628t, "Please fill in valid entries!", 0).m724a();
            return;
        }
        this.f7626r.m12731a(this.f7625q);
        finish();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_prev_attendance);
        m12623k();
        m12624l();
        this.f7623o.setOnClickListener(new C22301(this));
        this.f7629u.setOnClickListener(new C22312(this));
    }
}
