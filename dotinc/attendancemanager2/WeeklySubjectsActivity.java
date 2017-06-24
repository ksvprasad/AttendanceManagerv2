package dotinc.attendancemanager2;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0399i;
import android.support.v7.p018a.C0633d;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p043a.C2294l;
import dotinc.attendancemanager2.p044b.C2310g;
import dotinc.attendancemanager2.p045c.C2312b;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class WeeklySubjectsActivity extends C0633d {
    private static int f7751F = 1;
    private C2259c f7752A;
    private C2260d f7753B;
    private C2294l f7754C;
    private int f7755D;
    private int f7756E = 0;
    private Boolean f7757G;
    private CoordinatorLayout f7758H;
    private ImageView f7759I;
    private Context f7760m;
    private TabLayout f7761n;
    private ViewPager f7762o;
    private TextView f7763p;
    private TextView f7764q;
    private FloatingActionButton f7765r;
    private View f7766s;
    private String[] f7767t;
    private ArrayList<Fragment> f7768u;
    private ArrayList<C2313c> f7769v;
    private ArrayList<C2312b> f7770w;
    private ArrayList<String> f7771x;
    private Typeface f7772y;
    private Typeface f7773z;

    class C22611 implements Runnable {
        final /* synthetic */ WeeklySubjectsActivity f7747a;

        C22611(WeeklySubjectsActivity weeklySubjectsActivity) {
            this.f7747a = weeklySubjectsActivity;
        }

        public void run() {
            this.f7747a.f7765r.m650a();
        }
    }

    class C22622 implements OnClickListener {
        final /* synthetic */ WeeklySubjectsActivity f7748a;

        C22622(WeeklySubjectsActivity weeklySubjectsActivity) {
            this.f7748a = weeklySubjectsActivity;
        }

        public void onClick(View view) {
            this.f7748a.m12753m();
        }
    }

    class C22633 implements OnItemClickListener {
        final /* synthetic */ WeeklySubjectsActivity f7749a;

        C22633(WeeklySubjectsActivity weeklySubjectsActivity) {
            this.f7749a = weeklySubjectsActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f7749a.m12752c(i);
        }
    }

    private class C2264a extends C0399i {
        final /* synthetic */ WeeklySubjectsActivity f7750a;

        private C2264a(WeeklySubjectsActivity weeklySubjectsActivity) {
            this.f7750a = weeklySubjectsActivity;
        }

        public void mo109b(int i) {
            super.mo109b(i);
            WeeklySubjectsActivity.f7751F = i + 1;
            this.f7750a.f7769v.clear();
        }
    }

    private void m12752c(int i) {
        String str = ((String) this.f7771x.get(i)).toString();
        int c = ((C2312b) this.f7770w.get(i)).m12886c();
        C2313c c2313c = new C2313c();
        c2313c.m12893b(c);
        c2313c.m12895c(f7751F);
        c2313c.m12891a(str);
        this.f7769v = this.f7753B.m12742b(c2313c);
        c2313c.m12890a(this.f7769v.size());
        this.f7753B.m12740a(c2313c);
        this.f7762o.setAdapter(this.f7754C);
        this.f7762o.setCurrentItem(f7751F - 1);
        m12754a(str + " Added");
        m12756l();
    }

    private void m12753m() {
        Builder builder = new Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.subjects_list, null);
        ListView listView = (ListView) inflate.findViewById(R.id.subjectList);
        this.f7770w.clear();
        this.f7770w = this.f7752A.m12727a();
        this.f7771x.clear();
        for (int i = 0; i < this.f7770w.size(); i++) {
            this.f7771x.add(((C2312b) this.f7770w.get(i)).m12888d().toString());
        }
        listView.setAdapter(new ArrayAdapter(this, 17367043, this.f7771x));
        builder.setView(inflate);
        listView.setOnItemClickListener(new C22633(this));
        builder.create().show();
    }

    public void m12754a(String str) {
        Snackbar.m706a(this.f7758H, str, -1).m724a();
    }

    public void doneAddTimetable(View view) {
        if (this.f7757G.booleanValue() || this.f7756E == 1) {
            finish();
            return;
        }
        if (this.f7756E != 1) {
            C2258b.m12715a(this.f7760m, "COMPLETED", "completed");
        }
        startActivity(new Intent(this, MainActivity.class).setFlags(268468224));
        finish();
    }

    void m12755k() {
        this.f7760m = this;
        this.f7772y = Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf");
        this.f7773z = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf");
        Intent intent = getIntent();
        this.f7756E = intent.getIntExtra("view_timetable", 0);
        this.f7757G = Boolean.valueOf(intent.getBooleanExtra("Settings", false));
        this.f7763p = (TextView) findViewById(R.id.page_title);
        this.f7763p.setTypeface(this.f7772y);
        this.f7764q = (TextView) findViewById(R.id.help_text);
        this.f7764q.setTypeface(this.f7773z);
        this.f7765r = (FloatingActionButton) findViewById(R.id.add_subjects);
        this.f7759I = (ImageView) findViewById(R.id.tickmark_timetable);
        this.f7765r.m652b();
        this.f7766s = findViewById(R.id.view1);
        if (this.f7756E == 1) {
            this.f7763p.setText(getResources().getString(R.string.timetable_activity));
            this.f7764q.setVisibility(8);
            this.f7766s.setVisibility(8);
        } else {
            this.f7763p.setText(getResources().getString(R.string.weekly_subjects));
        }
        this.f7755D = intent.getIntExtra("timetableFlag", 0);
        this.f7761n = (TabLayout) findViewById(R.id.tab_layout);
        this.f7762o = (ViewPager) findViewById(R.id.pager);
        this.f7758H = (CoordinatorLayout) findViewById(R.id.main_content);
        this.f7765r = (FloatingActionButton) findViewById(R.id.add_subjects);
        this.f7768u = new ArrayList();
        for (int i = 0; i < 7; i++) {
            this.f7768u.add(new C2310g());
        }
        this.f7767t = getResources().getStringArray(R.array.tabs);
        this.f7754C = new C2294l(m1461f(), this.f7768u, this.f7767t, this.f7756E);
        this.f7762o.setAdapter(this.f7754C);
        this.f7761n.setTabsFromPagerAdapter(this.f7754C);
        this.f7761n.setupWithViewPager(this.f7762o);
        this.f7762o.m2004a(new C2264a());
        this.f7770w = new ArrayList();
        this.f7752A = new C2259c(this);
        this.f7753B = new C2260d(this);
        this.f7771x = new ArrayList();
        this.f7769v = new ArrayList();
    }

    public void m12756l() {
        if (this.f7753B.m12738a() == 0) {
            this.f7759I.setVisibility(4);
        } else {
            this.f7759I.setVisibility(0);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_weekly_subjects);
        m12755k();
        m12756l();
        if (this.f7756E == 1) {
            this.f7765r.setVisibility(4);
        } else {
            new Handler().postDelayed(new C22611(this), 500);
        }
        this.f7765r.setOnClickListener(new C22622(this));
    }
}
