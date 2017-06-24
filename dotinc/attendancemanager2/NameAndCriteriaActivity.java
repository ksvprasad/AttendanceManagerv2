package dotinc.attendancemanager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.C0236e;
import android.support.v4.p015g.C0381h;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.appyvet.rangebar.RangeBar;
import com.appyvet.rangebar.RangeBar.C0920a;
import dotinc.attendancemanager2.Utils.C2258b;

public class NameAndCriteriaActivity extends C0633d {
    private static int f7576A;
    private static int f7577B;
    private Boolean f7578C;
    private String f7579D;
    private Context f7580m;
    private ImageView f7581n;
    private EditText f7582o;
    private RangeBar f7583p;
    private TextView f7584q;
    private TextView f7585r;
    private TextView f7586s;
    private FloatingActionButton f7587t;
    private CardView f7588u;
    private CardView f7589v;
    private Animation f7590w;
    private CoordinatorLayout f7591x;
    private Typeface f7592y;
    private Typeface f7593z;

    class C22241 implements Runnable {
        final /* synthetic */ NameAndCriteriaActivity f7571a;

        C22241(NameAndCriteriaActivity nameAndCriteriaActivity) {
            this.f7571a = nameAndCriteriaActivity;
        }

        public void run() {
            this.f7571a.f7587t.m650a();
        }
    }

    class C22252 implements OnClickListener {
        final /* synthetic */ NameAndCriteriaActivity f7572a;

        C22252(NameAndCriteriaActivity nameAndCriteriaActivity) {
            this.f7572a = nameAndCriteriaActivity;
        }

        public void onClick(View view) {
            if (this.f7572a.f7588u.getVisibility() != 0 || this.f7572a.f7589v.getVisibility() == 0) {
                if (this.f7572a.f7589v.getVisibility() == 0) {
                    NameAndCriteriaActivity.f7577B = Integer.parseInt(C2258b.m12720b(this.f7572a.f7580m, "ATTENDANCE_CRITERIA", String.valueOf(0)));
                    if (this.f7572a.f7582o.getText().toString().equals("") && NameAndCriteriaActivity.f7577B == 0) {
                        this.f7572a.m12593a(this.f7572a.getResources().getString(R.string.enter_name_criteria));
                    } else if (this.f7572a.f7582o.getText().toString().equals("")) {
                        this.f7572a.m12593a(this.f7572a.getResources().getString(R.string.enter_name));
                    } else if (NameAndCriteriaActivity.f7577B == 0) {
                        this.f7572a.m12593a(this.f7572a.getResources().getString(R.string.enter_criteria));
                    } else if (this.f7572a.f7578C.booleanValue()) {
                        C2258b.m12715a(this.f7572a.f7580m, "USER_NAME", this.f7572a.f7582o.getText().toString().trim());
                        this.f7572a.finish();
                    } else if (VERSION.SDK_INT >= 21) {
                        C2258b.m12715a(this.f7572a.f7580m, "USER_NAME", this.f7572a.f7582o.getText().toString().trim());
                        this.f7572a.m12597c(new Intent(this.f7572a.f7580m, ShowNameCardActivity.class));
                    } else {
                        C2258b.m12715a(this.f7572a.f7580m, "USER_NAME", this.f7572a.f7582o.getText().toString().trim());
                        this.f7572a.startActivity(new Intent(this.f7572a, ShowNameCardActivity.class));
                    }
                }
            } else if (this.f7572a.f7582o.getText().toString().trim().equals("")) {
                this.f7572a.m12593a(this.f7572a.getResources().getString(R.string.enter_name));
                this.f7572a.f7582o.setText("");
            } else {
                C2258b.m12715a(this.f7572a.f7580m, "USER_NAME", this.f7572a.f7582o.getText().toString().trim());
                this.f7572a.m12589a(this.f7572a.f7589v);
            }
        }
    }

    class C22263 implements C0920a {
        final /* synthetic */ NameAndCriteriaActivity f7573a;

        C22263(NameAndCriteriaActivity nameAndCriteriaActivity) {
            this.f7573a = nameAndCriteriaActivity;
        }

        public void mo1794a(RangeBar rangeBar, int i, int i2, String str, String str2) {
            this.f7573a.f7584q.setText(str2 + "%");
            C2258b.m12715a(this.f7573a.f7580m, "ATTENDANCE_CRITERIA", str2);
        }
    }

    private void m12589a(final CardView cardView) {
        new Handler().postDelayed(new Runnable(this) {
            final /* synthetic */ NameAndCriteriaActivity f7575b;

            public void run() {
                cardView.setVisibility(0);
                cardView.startAnimation(this.f7575b.f7590w);
                if (this.f7575b.f7588u.getVisibility() == 0 && this.f7575b.f7589v.getVisibility() == 8) {
                    C2258b.m12716a(this.f7575b.f7585r, "What's your Name?", 45);
                } else if (this.f7575b.f7589v.getVisibility() == 0) {
                    C2258b.m12716a(this.f7575b.f7586s, "Attendance Criteria", 45);
                }
            }
        }, 100);
    }

    private void m12593a(String str) {
        Snackbar.m706a(this.f7591x, str, 0).m724a();
    }

    private void m12597c(Intent intent) {
        View findViewById = findViewById(R.id.user_img);
        View findViewById2 = findViewById(R.id.user_name);
        View findViewById3 = findViewById(R.id.selected_perc);
        this.f7581n.setTransitionName("user_image_transition");
        C0381h a = C0381h.m1933a(findViewById, "user_image_transition");
        C0381h a2 = C0381h.m1933a(findViewById2, "user_name_transition");
        C0381h a3 = C0381h.m1933a(findViewById3, "user_perc_transition");
        startActivity(intent, C0236e.m1328a(this, a, a2, a3).mo183a());
    }

    private void m12606l() {
        this.f7580m = this;
        this.f7592y = Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf");
        this.f7593z = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans-bold.ttf");
        this.f7581n = (ImageView) findViewById(R.id.user_img);
        this.f7582o = (EditText) findViewById(R.id.user_name);
        this.f7582o.setTypeface(this.f7593z);
        this.f7583p = (RangeBar) findViewById(R.id.rangebar);
        this.f7584q = (TextView) findViewById(R.id.selected_perc);
        this.f7584q.setTypeface(this.f7593z);
        this.f7585r = (TextView) findViewById(R.id.query_text);
        this.f7585r.setTypeface(this.f7592y);
        this.f7586s = (TextView) findViewById(R.id.attendance_query);
        this.f7586s.setTypeface(this.f7592y);
        this.f7587t = (FloatingActionButton) findViewById(R.id.fab);
        this.f7587t.m652b();
        this.f7591x = (CoordinatorLayout) findViewById(R.id.root);
        this.f7588u = (CardView) findViewById(R.id.name_card);
        this.f7589v = (CardView) findViewById(R.id.percentage_card);
        f7576A = Integer.parseInt(C2258b.m12720b(this.f7580m, "USER_IMAGE_ID", String.valueOf(0)));
        this.f7578C = Boolean.valueOf(getIntent().getBooleanExtra("Settings", false));
        CharSequence b = C2258b.m12720b(this.f7580m, "USER_NAME", "");
        if (!b.equals("")) {
            this.f7582o.setText(b);
        }
        this.f7590w = AnimationUtils.loadAnimation(this, R.anim.bottom_to_up);
        new Handler().postDelayed(new C22241(this), 500);
        if (VERSION.SDK_INT >= 21) {
            this.f7579D = getIntent().getStringExtra("transitionName");
            this.f7581n.setTransitionName(this.f7579D);
        }
    }

    private void m12607m() {
        this.f7583p.setTickColor(getResources().getColor(R.color.tickColor));
        this.f7583p.setConnectingLineColor(getResources().getColor(R.color.colorPrimaryDark));
        this.f7583p.setPinColor(getResources().getColor(R.color.colorPrimaryDark));
        this.f7583p.setSelectorColor(getResources().getColor(R.color.colorPrimaryDark));
        this.f7583p.setConnectingLineWeight(5.0f);
        f7577B = Integer.parseInt(C2258b.m12720b(this.f7580m, "ATTENDANCE_CRITERIA", String.valueOf(0)));
        if (f7577B != 0) {
            this.f7584q.setText(f7577B + "%");
            this.f7583p.setSeekPinByIndex(f7577B / 5);
            return;
        }
        this.f7584q.setText("0%");
        this.f7583p.setSeekPinByIndex(0);
    }

    private void m12608n() {
        if (f7576A == 1) {
            this.f7581n.setImageResource(R.drawable.user_male);
        } else if (f7576A == 2) {
            this.f7581n.setImageResource(R.drawable.user_female);
        }
    }

    public void onBackPressed() {
        if (VERSION.SDK_INT >= 21) {
            this.f7581n.setTransitionName(this.f7579D);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_name_and_criteria);
        m12606l();
        m12608n();
        m12607m();
        m12589a(this.f7588u);
        this.f7587t.setOnClickListener(new C22252(this));
        this.f7583p.setOnRangeBarChangeListener(new C22263(this));
    }
}
