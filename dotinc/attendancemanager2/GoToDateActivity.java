package dotinc.attendancemanager2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.daimajia.swipe.p028d.C0952a.C0951a;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p043a.C2274c;
import dotinc.attendancemanager2.p045c.C2312b;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class GoToDateActivity extends C0633d {
    private ArrayList<C2312b> f7466A;
    private ArrayList<String> f7467B;
    private int f7468C;
    private String f7469D;
    private ArrayList<C2313c> f7470E;
    private ArrayList<C2313c> f7471F;
    private RelativeLayout f7472G;
    private TextView f7473H;
    private CardView f7474I;
    private TextView f7475J;
    private TextView f7476K;
    private C2256a f7477L;
    private C0778a f7478M;
    private C2260d f7479N;
    private C2313c f7480O;
    private C2259c f7481P;
    private String f7482Q;
    private String f7483R;
    private Boolean f7484S = Boolean.valueOf(false);
    private Boolean f7485T = Boolean.valueOf(false);
    private Toolbar f7486m;
    private RecyclerView f7487n;
    private RecyclerView f7488o;
    private CoordinatorLayout f7489p;
    private RelativeLayout f7490q;
    private AppBarLayout f7491r;
    private CollapsingToolbarLayout f7492s;
    private FloatingActionButton f7493t;
    private TextView f7494u;
    private TextView f7495v;
    private TextView f7496w;
    private TextView f7497x;
    private TextView f7498y;
    private TextView f7499z;

    class C21981 implements OnClickListener {
        final /* synthetic */ GoToDateActivity f7452a;

        C21981(GoToDateActivity goToDateActivity) {
            this.f7452a = goToDateActivity;
        }

        public void onClick(View view) {
            if (VERSION.SDK_INT >= 21) {
                this.f7452a.m12549p();
                return;
            }
            Intent intent = new Intent(this.f7452a, ExtraClassActivity.class);
            intent.putExtra("date", this.f7452a.f7483R);
            intent.putExtra("day_selected", this.f7452a.f7469D);
            this.f7452a.startActivity(intent);
        }
    }

    class C22003 implements Runnable {
        final /* synthetic */ GoToDateActivity f7455a;

        C22003(GoToDateActivity goToDateActivity) {
            this.f7455a = goToDateActivity;
        }

        public void run() {
            this.f7455a.f7493t.setImageResource(R.mipmap.ic_add_white_36dp);
            this.f7455a.f7493t.m650a();
        }
    }

    class C22044 implements OnLongClickListener {
        final /* synthetic */ GoToDateActivity f7459a;

        class C22011 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22044 f7456a;

            C22011(C22044 c22044) {
                this.f7456a = c22044;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7456a.f7459a.f7477L.m12705a(this.f7456a.f7459a.f7471F, 1, this.f7456a.f7459a.f7483R);
                this.f7456a.f7459a.f7478M.m4399c();
            }
        }

        class C22022 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22044 f7457a;

            C22022(C22044 c22044) {
                this.f7457a = c22044;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7457a.f7459a.f7477L.m12705a(this.f7457a.f7459a.f7471F, 0, this.f7457a.f7459a.f7483R);
                this.f7457a.f7459a.f7478M.m4399c();
            }
        }

        class C22033 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22044 f7458a;

            C22033(C22044 c22044) {
                this.f7458a = c22044;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7458a.f7459a.f7477L.m12705a(this.f7458a.f7459a.f7471F, -1, this.f7458a.f7459a.f7483R);
                this.f7458a.f7459a.f7478M.m4399c();
            }
        }

        C22044(GoToDateActivity goToDateActivity) {
            this.f7459a = goToDateActivity;
        }

        public boolean onLongClick(View view) {
            if (!this.f7459a.f7484S.booleanValue()) {
                if (VERSION.SDK_INT >= 21) {
                    if (this.f7459a.f7485T.booleanValue() || this.f7459a.f7471F.size() == 0) {
                        this.f7459a.m12550a("You don't have any classes today");
                    } else {
                        this.f7459a.m12547n();
                    }
                } else if (this.f7459a.f7471F.size() == 0) {
                    this.f7459a.m12550a("You don't have any classes today");
                } else {
                    Builder builder = new Builder(this.f7459a);
                    builder.setTitle("Attended all the subjects?");
                    builder.setPositiveButton("Attended all", new C22011(this));
                    builder.setNegativeButton("Bunked all", new C22022(this));
                    builder.setNeutralButton("No class", new C22033(this));
                    builder.create().show();
                }
            }
            return true;
        }
    }

    class C22055 implements Runnable {
        final /* synthetic */ GoToDateActivity f7460a;

        C22055(GoToDateActivity goToDateActivity) {
            this.f7460a = goToDateActivity;
        }

        public void run() {
            this.f7460a.f7493t.setImageResource(R.mipmap.ic_clear_white_36dp);
            this.f7460a.f7493t.m650a();
        }
    }

    class C22077 implements Runnable {
        final /* synthetic */ GoToDateActivity f7463a;

        C22077(GoToDateActivity goToDateActivity) {
            this.f7463a = goToDateActivity;
        }

        public void run() {
            this.f7463a.f7493t.setImageResource(R.mipmap.ic_add_white_36dp);
            this.f7463a.f7493t.m650a();
        }
    }

    class C22088 extends AnimatorListenerAdapter {
        final /* synthetic */ GoToDateActivity f7464a;

        C22088(GoToDateActivity goToDateActivity) {
            this.f7464a = goToDateActivity;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f7464a.f7474I.setVisibility(4);
            if (this.f7464a.f7470E.size() == 0) {
                this.f7464a.f7472G.setVisibility(0);
            } else {
                this.f7464a.f7472G.setVisibility(4);
            }
        }
    }

    class C22099 implements Runnable {
        final /* synthetic */ GoToDateActivity f7465a;

        C22099(GoToDateActivity goToDateActivity) {
            this.f7465a = goToDateActivity;
        }

        public void run() {
            this.f7465a.f7493t.setImageResource(R.mipmap.ic_done_white_36dp);
            this.f7465a.f7493t.m650a();
        }
    }

    private void m12532b(String str) {
        this.f7494u.setText(str);
    }

    private int m12533c(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case 70909:
                if (str.equals("Fri")) {
                    i = 4;
                    break;
                }
                break;
            case 77548:
                if (str.equals("Mon")) {
                    i = 0;
                    break;
                }
                break;
            case 82886:
                if (str.equals("Sat")) {
                    i = 5;
                    break;
                }
                break;
            case 83500:
                if (str.equals("Sun")) {
                    i = 6;
                    break;
                }
                break;
            case 84065:
                if (str.equals("Thu")) {
                    i = 3;
                    break;
                }
                break;
            case 84452:
                if (str.equals("Tue")) {
                    i = 1;
                    break;
                }
                break;
            case 86838:
                if (str.equals("Wed")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                m12532b(getResources().getString(R.string.monday));
                return 1;
            case 1:
                m12532b(getResources().getString(R.string.tuesday));
                return 2;
            case 2:
                m12532b(getResources().getString(R.string.wednesday));
                return 3;
            case 3:
                m12532b(getResources().getString(R.string.thursday));
                return 4;
            case 4:
                m12532b(getResources().getString(R.string.friday));
                return 5;
            case 5:
                m12532b(getResources().getString(R.string.saturday));
                return 6;
            case 6:
                m12532b(getResources().getString(R.string.sunday));
                return 7;
            default:
                return 0;
        }
    }

    private void m12544l() {
        this.f7480O.m12895c(this.f7468C);
        this.f7471F = this.f7479N.m12742b(this.f7480O);
        this.f7470E = this.f7481P.m12733b();
        for (int i = 0; i < this.f7471F.size(); i++) {
            for (int i2 = 0; i2 < this.f7470E.size(); i2++) {
                if (((C2313c) this.f7470E.get(i2)).m12894c().equals(((C2313c) this.f7471F.get(i)).m12894c())) {
                    this.f7470E.remove(i2);
                }
            }
        }
        this.f7488o.setAdapter(new C2274c(this, this.f7470E, this.f7483R, this.f7482Q));
    }

    private void m12546m() {
        String[] split = this.f7483R.split("-");
        String[] strArr = new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
        this.f7496w.setText(split[0]);
        this.f7495v.setText(strArr[Integer.parseInt(split[1]) - 1]);
        this.f7497x.setText(split[2]);
    }

    @TargetApi(21)
    private void m12547n() {
        View findViewById = findViewById(R.id.full_att_layout);
        this.f7485T = Boolean.valueOf(true);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth(), 0, 0.0f, (float) Math.max(findViewById.getWidth(), findViewById.getHeight() + 1000));
        createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
        findViewById.setVisibility(0);
        createCircularReveal.start();
        this.f7493t.m652b();
        new Handler().postDelayed(new C22055(this), 300);
    }

    @TargetApi(21)
    private void m12548o() {
        final View findViewById = findViewById(R.id.full_att_layout);
        this.f7485T = Boolean.valueOf(false);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth(), 0, (float) findViewById.getWidth(), (float) null);
        createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
        createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ GoToDateActivity f7462b;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                findViewById.setVisibility(8);
            }
        });
        createCircularReveal.start();
        this.f7493t.m652b();
        new Handler().postDelayed(new C22077(this), 300);
    }

    @TargetApi(21)
    private void m12549p() {
        final View findViewById = findViewById(R.id.extra_class_layout);
        int width = findViewById.getWidth();
        if (this.f7485T.booleanValue()) {
            m12548o();
        } else if (this.f7484S.booleanValue()) {
            r1 = ViewAnimationUtils.createCircularReveal(findViewById, width, 0, (float) (findViewById.getHeight() + 1000), (float) null);
            r1.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
            r1.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ GoToDateActivity f7450b;

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    findViewById.setVisibility(4);
                    if (this.f7450b.f7471F.size() == 0) {
                        this.f7450b.f7474I.setVisibility(0);
                    }
                }
            });
            r1.start();
            this.f7493t.m652b();
            this.f7484S = Boolean.valueOf(false);
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ GoToDateActivity f7451a;

                {
                    this.f7451a = r1;
                }

                public void run() {
                    this.f7451a.f7493t.setImageResource(R.mipmap.ic_add_white_36dp);
                    this.f7451a.f7493t.m650a();
                }
            }, 300);
        } else {
            r1 = ViewAnimationUtils.createCircularReveal(findViewById, width, 0, 0.0f, (float) Math.max(findViewById.getWidth(), findViewById.getHeight() + 1000));
            r1.setDuration(1000).setInterpolator(new DecelerateInterpolator(1.0f));
            r1.addListener(new C22088(this));
            this.f7484S = Boolean.valueOf(true);
            findViewById.setVisibility(0);
            r1.start();
            this.f7493t.m652b();
            new Handler().postDelayed(new C22099(this), 300);
        }
    }

    public void m12550a(String str) {
        Snackbar.m706a(this.f7489p, str, -1).m724a();
    }

    public void attendAll(View view) {
        this.f7477L.m12705a(this.f7471F, 1, this.f7483R);
        this.f7478M.m4399c();
        m12548o();
    }

    public void bunkedAll(View view) {
        this.f7477L.m12705a(this.f7471F, 0, this.f7483R);
        this.f7478M.m4399c();
        m12548o();
    }

    void m12551k() {
        Intent intent = getIntent();
        this.f7469D = intent.getStringExtra("day_name");
        this.f7483R = intent.getStringExtra("date");
        this.f7482Q = "GoToDateActivity";
        this.f7486m = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7486m);
        m3337g().mo585b(false);
        m3337g().mo582a(true);
        this.f7498y = (TextView) findViewById(R.id.extra_class_text);
        this.f7498y.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7499z = (TextView) findViewById(R.id.full_att_text);
        this.f7499z.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7490q = (RelativeLayout) findViewById(R.id.extra_class_layout);
        this.f7489p = (CoordinatorLayout) findViewById(R.id.root);
        this.f7491r = (AppBarLayout) findViewById(R.id.appbar_layout);
        this.f7492s = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        this.f7474I = (CardView) findViewById(R.id.root_empty_view);
        this.f7475J = (TextView) findViewById(R.id.root_empty_title);
        this.f7475J.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7476K = (TextView) findViewById(R.id.root_empty_footer);
        this.f7476K.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7472G = (RelativeLayout) findViewById(R.id.empty_view_extra);
        this.f7473H = (TextView) findViewById(R.id.empty_text_extra);
        this.f7473H.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7494u = (TextView) findViewById(R.id.day);
        this.f7494u.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7495v = (TextView) findViewById(R.id.month);
        this.f7495v.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7496w = (TextView) findViewById(R.id.date);
        this.f7496w.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7497x = (TextView) findViewById(R.id.year);
        this.f7497x.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7493t = (FloatingActionButton) findViewById(R.id.fab);
        this.f7487n = (RecyclerView) findViewById(R.id.recycler_view);
        this.f7487n.setLayoutManager(new LinearLayoutManager(this));
        this.f7487n.setHasFixedSize(true);
        this.f7488o = (RecyclerView) findViewById(R.id.extra_class_recycler_view);
        this.f7488o.setLayoutManager(new LinearLayoutManager(this));
        this.f7488o.setHasFixedSize(true);
        this.f7466A = new ArrayList();
        this.f7467B = new ArrayList();
        this.f7470E = new ArrayList();
        this.f7480O = new C2313c();
        this.f7477L = new C2256a(this);
        this.f7479N = new C2260d(this);
        this.f7481P = new C2259c(this);
        this.f7471F = new ArrayList();
        this.f7468C = m12533c(this.f7469D);
        this.f7480O.m12895c(this.f7468C);
        this.f7471F = this.f7479N.m12742b(this.f7480O);
        if (this.f7471F.isEmpty()) {
            this.f7474I.setVisibility(0);
        } else {
            this.f7474I.setVisibility(4);
        }
        m12546m();
        m12544l();
        if (this.f7470E.size() == 0) {
            this.f7472G.setVisibility(0);
        } else {
            this.f7472G.setVisibility(4);
        }
    }

    public void noClassAll(View view) {
        this.f7477L.m12705a(this.f7471F, -1, this.f7483R);
        this.f7478M.m4399c();
        m12548o();
    }

    public void onBackPressed() {
        if (this.f7484S.booleanValue()) {
            final View findViewById = findViewById(R.id.extra_class_layout);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth(), 0, (float) (findViewById.getHeight() + 1000), (float) null);
            createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
            createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ GoToDateActivity f7454b;

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    findViewById.setVisibility(4);
                    if (this.f7454b.f7471F.size() == 0) {
                        this.f7454b.f7474I.setVisibility(0);
                    }
                    this.f7454b.f7472G.setVisibility(4);
                }
            });
            createCircularReveal.start();
            this.f7493t.m652b();
            this.f7484S = Boolean.valueOf(false);
            new Handler().postDelayed(new C22003(this), 300);
        } else if (this.f7485T.booleanValue()) {
            m12548o();
        } else {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_go_to_date);
        m12551k();
        m12544l();
        this.f7478M = new C2274c(this, this.f7471F, this.f7483R, this.f7482Q);
        ((C2274c) this.f7478M).m5581a(C0951a.Single);
        this.f7487n.setAdapter(this.f7478M);
        this.f7493t.setOnClickListener(new C21981(this));
        this.f7493t.setOnLongClickListener(new C22044(this));
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
