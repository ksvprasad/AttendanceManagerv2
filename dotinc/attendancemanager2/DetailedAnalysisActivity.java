package dotinc.attendancemanager2;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0250v;
import android.support.v4.p010b.C0195a;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.ads.C1026c.C1022a;
import com.google.android.gms.ads.NativeExpressAdView;
import com.roomorama.caldroid.C2187a;
import com.roomorama.caldroid.C2189c;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p043a.C2266a;
import dotinc.attendancemanager2.p045c.C2311a;
import dotinc.attendancemanager2.p045c.C2312b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DetailedAnalysisActivity extends C0633d {
    private C2256a f7411A;
    private SimpleDateFormat f7412B;
    private int f7413C;
    private C2187a f7414D;
    private Toolbar f7415m;
    private Spinner f7416n;
    private LinearLayout f7417o;
    private Context f7418p;
    private TextView f7419q;
    private TextView f7420r;
    private TextView f7421s;
    private TextView f7422t;
    private TextView f7423u;
    private TextView f7424v;
    private ArrayList<String> f7425w;
    private ArrayList<C2312b> f7426x;
    private C2259c f7427y;
    private ArrayList<C2311a> f7428z;

    class C21961 implements OnItemSelectedListener {
        final /* synthetic */ DetailedAnalysisActivity f7409a;

        C21961(DetailedAnalysisActivity detailedAnalysisActivity) {
            this.f7409a = detailedAnalysisActivity;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f7409a.m12513b(((C2312b) this.f7409a.f7426x.get(i)).m12886c());
            this.f7409a.f7413C = ((C2312b) this.f7409a.f7426x.get(i)).m12886c();
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class C21972 extends C2189c {
        final /* synthetic */ DetailedAnalysisActivity f7410a;

        C21972(DetailedAnalysisActivity detailedAnalysisActivity) {
            this.f7410a = detailedAnalysisActivity;
        }

        public void mo1789a() {
            super.mo1789a();
            Button O = this.f7410a.f7414D.m12447O();
            Button P = this.f7410a.f7414D.m12448P();
            TextView Q = this.f7410a.f7414D.m12449Q();
            if (VERSION.SDK_INT >= 21) {
                O.setBackgroundTintList(C0195a.m1226b(this.f7410a.f7418p, R.color.colorPrimaryDark));
                P.setBackgroundTintList(C0195a.m1226b(this.f7410a.f7418p, R.color.colorPrimaryDark));
                Q.setTextColor(C0195a.m1226b(this.f7410a.f7418p, R.color.colorPrimaryDark));
            }
            Q.setTypeface(Typeface.createFromAsset(this.f7410a.getAssets(), "fonts/oxygen-bold.ttf"));
        }

        public void mo1790a(Date date, View view) {
            String format = this.f7410a.f7412B.format(date);
            this.f7410a.f7419q.setText("Total Lectures:" + this.f7410a.f7411A.m12710c(this.f7410a.f7413C, format));
            this.f7410a.f7420r.setVisibility(0);
            this.f7410a.f7420r.setText("Attended Lectures:" + this.f7410a.f7411A.m12699a(this.f7410a.f7413C, format));
            this.f7410a.f7421s.setVisibility(0);
            this.f7410a.f7421s.setText("Bunked Lectures:" + this.f7410a.f7411A.m12707b(this.f7410a.f7413C, format));
        }
    }

    private void m12513b(int i) {
        this.f7428z = this.f7411A.m12701a(i);
        m12523n();
    }

    private void m12521l() {
        int i = 0;
        this.f7415m = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7415m);
        m3337g().mo585b(false);
        m3337g().mo582a(true);
        this.f7416n = (Spinner) findViewById(R.id.spinner_nav);
        this.f7417o = (LinearLayout) findViewById(R.id.display_root);
        this.f7418p = this;
        this.f7427y = new C2259c(this.f7418p);
        this.f7411A = new C2256a(this.f7418p);
        this.f7426x = this.f7427y.m12727a();
        this.f7412B = new SimpleDateFormat("d-M-yyyy");
        this.f7425w = new ArrayList();
        this.f7419q = (TextView) findViewById(R.id.tot_class);
        this.f7419q.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7419q.setText("Click on date for attendance");
        this.f7421s = (TextView) findViewById(R.id.bunk_class);
        this.f7421s.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7421s.setVisibility(8);
        this.f7420r = (TextView) findViewById(R.id.att_class);
        this.f7420r.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7420r.setVisibility(8);
        this.f7422t = (TextView) findViewById(R.id.present_view_text);
        this.f7422t.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7423u = (TextView) findViewById(R.id.absent_view_text);
        this.f7423u.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7424v = (TextView) findViewById(R.id.no_class_text);
        this.f7424v.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        while (i < this.f7426x.size()) {
            this.f7425w.add(((C2312b) this.f7426x.get(i)).m12888d());
            i++;
        }
        ((NativeExpressAdView) findViewById(R.id.adView)).mo926a(new C1022a().m5773a());
    }

    private void m12522m() {
        for (int i = 0; i < this.f7428z.size(); i++) {
            try {
                String c = ((C2311a) this.f7428z.get(i)).m12878c();
                Log.d("option_date", c);
                Date parse = this.f7412B.parse(c);
                if (((C2311a) this.f7428z.get(i)).m12880d() == 1) {
                    this.f7414D.m12462a((int) R.color.attendedColor, parse);
                    this.f7414D.m12467b(R.color.white, parse);
                } else if (((C2311a) this.f7428z.get(i)).m12880d() == 0) {
                    this.f7414D.m12462a((int) R.color.absentColor, parse);
                    this.f7414D.m12467b(R.color.white, parse);
                } else if (((C2311a) this.f7428z.get(i)).m12880d() == -1) {
                    this.f7414D.m12462a((int) R.color.noClassColor, parse);
                    this.f7414D.m12467b(R.color.white, parse);
                }
            } catch (ParseException e) {
                e.printStackTrace();
                Log.d("option_error_detailed", e.toString());
            }
        }
    }

    private void m12523n() {
        this.f7414D = new C2187a();
        Bundle bundle = new Bundle();
        Calendar instance = Calendar.getInstance();
        bundle.putInt("month", instance.get(2) + 1);
        bundle.putInt("year", instance.get(1));
        bundle.putBoolean("enableSwipe", true);
        bundle.putBoolean("sixWeeksInCalendar", true);
        this.f7414D.m1194g(bundle);
        this.f7414D.m12466a(new Date());
        m12522m();
        m12524o();
        C0250v a = m1461f().mo224a();
        a.mo193b(R.id.display_root, this.f7414D);
        a.mo187a();
    }

    private void m12524o() {
        this.f7414D.m12465a(new C21972(this));
    }

    public void m12525k() {
        this.f7416n.setAdapter(new C2266a(this, this.f7425w));
        this.f7416n.setOnItemSelectedListener(new C21961(this));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detailed_analysis);
        m12521l();
        m12525k();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.go_to_date_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
