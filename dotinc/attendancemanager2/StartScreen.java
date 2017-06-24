package dotinc.attendancemanager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.p010b.C0195a;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0399i;
import android.support.v7.p018a.C0633d;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.ProgressPageIndicator;
import dotinc.attendancemanager2.p043a.C2285i;
import dotinc.attendancemanager2.p044b.C2296a;
import dotinc.attendancemanager2.p044b.C2299c;
import dotinc.attendancemanager2.p044b.C2306e;
import java.util.ArrayList;

public class StartScreen extends C0633d {
    private Context f7681m;
    private ViewPager f7682n;
    private ArrayList<Fragment> f7683o;
    private String[] f7684p;
    private TextView f7685q;
    private Button f7686r;
    private ProgressPageIndicator f7687s;
    private Animation f7688t;

    class C22441 implements OnClickListener {
        final /* synthetic */ StartScreen f7679a;

        C22441(StartScreen startScreen) {
            this.f7679a = startScreen;
        }

        public void onClick(View view) {
            this.f7679a.startActivity(new Intent(this.f7679a.f7681m, ChooseAvatarActivity.class));
        }
    }

    private class C2245a extends C0399i {
        final /* synthetic */ StartScreen f7680a;

        private C2245a(StartScreen startScreen) {
            this.f7680a = startScreen;
        }

        public void mo109b(int i) {
            this.f7680a.f7685q.setText(this.f7680a.f7684p[i]);
            switch (i) {
                case 0:
                    this.f7680a.f7687s.m12697a(this.f7680a.f7682n, 0);
                    this.f7680a.f7687s.setFillColor(C0195a.m1227c(this.f7680a.f7681m, R.color.noClassColor));
                    break;
                case 1:
                    this.f7680a.f7687s.m12697a(this.f7680a.f7682n, 1);
                    this.f7680a.f7687s.setFillColor(C0195a.m1227c(this.f7680a.f7681m, R.color.absentColor));
                    this.f7680a.f7686r.setVisibility(8);
                    break;
                case 2:
                    this.f7680a.f7687s.m12697a(this.f7680a.f7682n, 2);
                    this.f7680a.f7687s.setFillColor(C0195a.m1227c(this.f7680a.f7681m, R.color.attendedColor));
                    this.f7680a.f7686r.setBackgroundColor(C0195a.m1227c(this.f7680a.f7681m, R.color.attendedColor));
                    this.f7680a.f7686r.setText("LET'S START!");
                    this.f7680a.f7686r.setTextColor(C0195a.m1227c(this.f7680a.f7681m, R.color.white));
                    this.f7680a.f7686r.setVisibility(0);
                    this.f7680a.f7686r.startAnimation(this.f7680a.f7688t);
                    break;
            }
            super.mo109b(i);
        }
    }

    private void m12664k() {
        this.f7682n = (ViewPager) findViewById(R.id.start_screen_pager);
        this.f7683o = new ArrayList();
        this.f7683o.add(new C2296a());
        this.f7683o.add(new C2299c());
        this.f7683o.add(new C2306e());
        this.f7684p = getResources().getStringArray(R.array.viewpager_desc);
        this.f7687s = (ProgressPageIndicator) findViewById(R.id.pageIndicator);
        this.f7685q = (TextView) findViewById(R.id.help_text);
        this.f7685q.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans-bold.ttf"));
        this.f7685q.setText(this.f7684p[0]);
        this.f7688t = AnimationUtils.loadAnimation(this.f7681m, R.anim.bottom_to_up);
        this.f7688t.setDuration(500);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_start_screen);
        this.f7681m = this;
        if (C2258b.m12720b(this.f7681m, "COMPLETED", "").matches("completed")) {
            startActivity(new Intent(this.f7681m, MainActivity.class));
            finish();
        }
        m12664k();
        this.f7682n.setAdapter(new C2285i(m1461f(), this.f7683o));
        this.f7682n.m2004a(new C2245a());
        this.f7687s.m12697a(this.f7682n, 0);
        this.f7687s.setFillColor(C0195a.m1227c(this.f7681m, R.color.noClassColor));
        this.f7686r = (Button) findViewById(R.id.start_btn);
        this.f7686r.setAllCaps(false);
        this.f7686r.setOnClickListener(new C22441(this));
    }
}
