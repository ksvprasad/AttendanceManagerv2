package dotinc.attendancemanager2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.C0078e;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.C0250v;
import android.support.v4.app.Fragment;
import android.support.v4.p010b.C0195a;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0399i;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.daimajia.swipe.p028d.C0952a.C0951a;
import com.google.android.gms.ads.C0970a;
import com.google.android.gms.ads.C1026c.C1022a;
import com.google.android.gms.ads.NativeExpressAdView;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.Utils.ProgressPageIndicator;
import dotinc.attendancemanager2.p043a.C2274c;
import dotinc.attendancemanager2.p043a.C2275d;
import dotinc.attendancemanager2.p044b.C2298b;
import dotinc.attendancemanager2.p044b.C2305d;
import dotinc.attendancemanager2.p044b.C2309f;
import dotinc.attendancemanager2.p045c.C2312b;
import dotinc.attendancemanager2.p045c.C2313c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends C0633d {
    private ProgressPageIndicator f7533A;
    private FloatingActionButton f7534B;
    private C2309f f7535C;
    private CardView f7536D;
    private TextView f7537E;
    private TextView f7538F;
    private RelativeLayout f7539G;
    private TextView f7540H;
    private ArrayList<C2313c> f7541I;
    private ArrayList<C2313c> f7542J;
    private ArrayList<C2312b> f7543K;
    private ArrayList<String> f7544L;
    private int f7545M;
    private C2256a f7546N;
    private C2260d f7547O;
    private C2313c f7548P;
    private C2259c f7549Q;
    private String f7550R;
    private Date f7551S;
    private String f7552T;
    private C0778a f7553U;
    private C0778a f7554V;
    private Boolean f7555W = Boolean.valueOf(false);
    private Boolean f7556X = Boolean.valueOf(false);
    public C0250v f7557m;
    private Context f7558n;
    private Toolbar f7559o;
    private RecyclerView f7560p;
    private RecyclerView f7561q;
    private CoordinatorLayout f7562r;
    private RelativeLayout f7563s;
    private AppBarLayout f7564t;
    private TextView f7565u;
    private TextView f7566v;
    private CollapsingToolbarLayout f7567w;
    private ViewPager f7568x;
    private ArrayList<Fragment> f7569y;
    private C2298b f7570z;

    class C22111 extends C0970a {
        final /* synthetic */ MainActivity f7517a;

        C22111(MainActivity mainActivity) {
            this.f7517a = mainActivity;
        }

        public void mo910a() {
            super.mo910a();
            this.f7517a.findViewById(R.id.adView_card).setVisibility(0);
        }

        public void mo911a(int i) {
            super.mo911a(i);
            this.f7517a.findViewById(R.id.adView_card).setVisibility(8);
        }
    }

    class C22122 implements Runnable {
        final /* synthetic */ MainActivity f7518a;

        C22122(MainActivity mainActivity) {
            this.f7518a = mainActivity;
        }

        public void run() {
            this.f7518a.f7534B.setImageResource(R.mipmap.ic_add_white_36dp);
            this.f7518a.f7534B.m650a();
        }
    }

    class C22144 implements Runnable {
        final /* synthetic */ MainActivity f7521a;

        C22144(MainActivity mainActivity) {
            this.f7521a = mainActivity;
        }

        public void run() {
            this.f7521a.f7534B.setImageResource(R.mipmap.ic_add_white_36dp);
            this.f7521a.f7534B.m650a();
        }
    }

    class C22177 implements OnClickListener {
        final /* synthetic */ MainActivity f7526a;

        C22177(MainActivity mainActivity) {
            this.f7526a = mainActivity;
        }

        public void onClick(View view) {
            if (VERSION.SDK_INT >= 21) {
                this.f7526a.m12580s();
                return;
            }
            Intent intent = new Intent(this.f7526a, ExtraClassActivity.class);
            intent.putExtra("day_selected", new SimpleDateFormat("EEE").format(Long.valueOf(new Date().getTime())));
            intent.putExtra("date", this.f7526a.f7550R);
            this.f7526a.startActivity(intent);
        }
    }

    class C22218 implements OnLongClickListener {
        final /* synthetic */ MainActivity f7530a;

        class C22181 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22218 f7527a;

            C22181(C22218 c22218) {
                this.f7527a = c22218;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7527a.f7530a.f7546N.m12705a(this.f7527a.f7530a.f7542J, 1, this.f7527a.f7530a.f7550R);
                this.f7527a.f7530a.f7554V.m4399c();
            }
        }

        class C22192 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22218 f7528a;

            C22192(C22218 c22218) {
                this.f7528a = c22218;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7528a.f7530a.f7546N.m12705a(this.f7528a.f7530a.f7542J, 0, this.f7528a.f7530a.f7550R);
                this.f7528a.f7530a.f7554V.m4399c();
            }
        }

        class C22203 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22218 f7529a;

            C22203(C22218 c22218) {
                this.f7529a = c22218;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f7529a.f7530a.f7546N.m12705a(this.f7529a.f7530a.f7542J, -1, this.f7529a.f7530a.f7550R);
                this.f7529a.f7530a.f7554V.m4399c();
            }
        }

        C22218(MainActivity mainActivity) {
            this.f7530a = mainActivity;
        }

        public boolean onLongClick(View view) {
            if (!this.f7530a.f7555W.booleanValue()) {
                if (VERSION.SDK_INT >= 21) {
                    if (this.f7530a.f7556X.booleanValue() || this.f7530a.f7542J.size() == 0) {
                        this.f7530a.m12582a("You don't have any classes today");
                    } else {
                        this.f7530a.m12578q();
                    }
                } else if (this.f7530a.f7542J.size() == 0) {
                    this.f7530a.m12582a("You don't have any classes today");
                } else {
                    Builder builder = new Builder(this.f7530a);
                    builder.setTitle("Attended all the subjects?");
                    builder.setPositiveButton("Attended all", new C22181(this));
                    builder.setNegativeButton("Bunked all", new C22192(this));
                    builder.setNeutralButton("No class", new C22203(this));
                    builder.create().show();
                }
            }
            return true;
        }
    }

    class C22229 implements Runnable {
        final /* synthetic */ MainActivity f7531a;

        C22229(MainActivity mainActivity) {
            this.f7531a = mainActivity;
        }

        public void run() {
            this.f7531a.f7534B.setImageResource(R.mipmap.ic_clear_white_36dp);
            this.f7531a.f7534B.setBackgroundTintList(ColorStateList.valueOf(C0195a.m1227c(this.f7531a.f7558n, R.color.colorPrimaryDark)));
            this.f7531a.f7534B.m650a();
        }
    }

    private class C2223a extends C0399i {
        final /* synthetic */ MainActivity f7532a;

        private C2223a(MainActivity mainActivity) {
            this.f7532a = mainActivity;
        }

        public void mo109b(int i) {
            switch (i) {
                case 0:
                    this.f7532a.f7533A.m12697a(this.f7532a.f7568x, 0);
                    this.f7532a.f7533A.setFillColor(this.f7532a.getResources().getColor(17170443));
                    break;
                case 1:
                    this.f7532a.f7533A.m12697a(this.f7532a.f7568x, 1);
                    this.f7532a.f7533A.setFillColor(this.f7532a.getResources().getColor(17170443));
                    break;
            }
            super.mo109b(i);
        }
    }

    private void m12562b(String str) {
        m3337g().mo581a((CharSequence) str);
    }

    private void m12576o() {
        this.f7548P.m12895c(this.f7545M);
        this.f7542J = this.f7547O.m12742b(this.f7548P);
        this.f7541I = this.f7549Q.m12733b();
        for (int i = 0; i < this.f7542J.size(); i++) {
            for (int i2 = 0; i2 < this.f7541I.size(); i2++) {
                if (((C2313c) this.f7541I.get(i2)).m12894c().equals(((C2313c) this.f7542J.get(i)).m12894c())) {
                    this.f7541I.remove(i2);
                }
            }
        }
        this.f7553U = new C2274c(this, this.f7541I, this.f7550R, this.f7552T);
        ((C2274c) this.f7553U).m5581a(C0951a.Single);
        this.f7561q.setAdapter(this.f7553U);
    }

    private int m12577p() {
        String format = new SimpleDateFormat("EEE").format(Long.valueOf(new Date().getTime()));
        int i = -1;
        switch (format.hashCode()) {
            case 70909:
                if (format.equals("Fri")) {
                    i = 4;
                    break;
                }
                break;
            case 77548:
                if (format.equals("Mon")) {
                    i = 0;
                    break;
                }
                break;
            case 82886:
                if (format.equals("Sat")) {
                    i = 5;
                    break;
                }
                break;
            case 83500:
                if (format.equals("Sun")) {
                    i = 6;
                    break;
                }
                break;
            case 84065:
                if (format.equals("Thu")) {
                    i = 3;
                    break;
                }
                break;
            case 84452:
                if (format.equals("Tue")) {
                    i = 1;
                    break;
                }
                break;
            case 86838:
                if (format.equals("Wed")) {
                    i = 2;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                m12562b(getResources().getString(R.string.monday));
                return 1;
            case 1:
                m12562b(getResources().getString(R.string.tuesday));
                return 2;
            case 2:
                m12562b(getResources().getString(R.string.wednesday));
                return 3;
            case 3:
                m12562b(getResources().getString(R.string.thursday));
                return 4;
            case 4:
                m12562b(getResources().getString(R.string.friday));
                return 5;
            case 5:
                m12562b(getResources().getString(R.string.saturday));
                return 6;
            case 6:
                m12562b(getResources().getString(R.string.sunday));
                return 7;
            default:
                return 1;
        }
    }

    @TargetApi(21)
    private void m12578q() {
        View findViewById = findViewById(R.id.full_att_layout);
        this.f7556X = Boolean.valueOf(true);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth(), 0, 0.0f, (float) Math.max(findViewById.getWidth(), findViewById.getHeight() + 1000));
        createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
        findViewById.setVisibility(0);
        createCircularReveal.start();
        this.f7534B.m652b();
        new Handler().postDelayed(new C22229(this), 300);
    }

    @TargetApi(21)
    private void m12579r() {
        final View findViewById = findViewById(R.id.full_att_layout);
        this.f7556X = Boolean.valueOf(false);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth(), 0, (float) findViewById.getWidth(), (float) null);
        createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
        createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ MainActivity f7511b;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                findViewById.setVisibility(8);
            }
        });
        createCircularReveal.start();
        this.f7534B.m652b();
        new Handler().postDelayed(new Runnable(this) {
            final /* synthetic */ MainActivity f7512a;

            {
                this.f7512a = r1;
            }

            public void run() {
                this.f7512a.f7534B.setBackgroundTintList(ColorStateList.valueOf(C0195a.m1227c(this.f7512a.f7558n, R.color.colorPrimaryDark)));
                this.f7512a.f7534B.setImageResource(R.mipmap.ic_add_white_36dp);
                this.f7512a.f7534B.m650a();
            }
        }, 300);
    }

    @TargetApi(21)
    private void m12580s() {
        final View findViewById = findViewById(R.id.extra_class_layout);
        int width = findViewById.getWidth();
        if (this.f7556X.booleanValue()) {
            m12579r();
        } else if (this.f7555W.booleanValue()) {
            r1 = ViewAnimationUtils.createCircularReveal(findViewById, width, 0, (float) (findViewById.getHeight() + 1000), (float) null);
            r1.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
            r1.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ MainActivity f7516b;

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    findViewById.setVisibility(4);
                    this.f7516b.findViewById(R.id.adView_card).setVisibility(0);
                    if (this.f7516b.f7542J.size() == 0) {
                        this.f7516b.f7536D.setVisibility(0);
                    }
                }
            });
            r1.start();
            this.f7534B.m652b();
            this.f7555W = Boolean.valueOf(false);
            new Handler().postDelayed(new C22122(this), 300);
        } else {
            findViewById(R.id.adView_card).setVisibility(8);
            r1 = ViewAnimationUtils.createCircularReveal(findViewById, width, 0, 0.0f, (float) Math.max(findViewById.getWidth(), findViewById.getHeight() + 1000));
            r1.setDuration(1000).setInterpolator(new DecelerateInterpolator(1.0f));
            r1.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ MainActivity f7513a;

                {
                    this.f7513a = r1;
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    this.f7513a.f7536D.setVisibility(4);
                    this.f7513a.findViewById(R.id.adView_card).setVisibility(8);
                    if (this.f7513a.f7541I.size() == 0) {
                        this.f7513a.f7539G.setVisibility(0);
                    } else {
                        this.f7513a.f7539G.setVisibility(4);
                    }
                }
            });
            this.f7555W = Boolean.valueOf(true);
            findViewById.setVisibility(0);
            r1.start();
            this.f7534B.m652b();
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ MainActivity f7514a;

                {
                    this.f7514a = r1;
                }

                public void run() {
                    this.f7514a.f7534B.setImageResource(R.mipmap.ic_done_white_36dp);
                    this.f7514a.f7534B.m650a();
                }
            }, 300);
        }
    }

    private void m12581t() {
        this.f7535C = new C2309f();
        this.f7557m = m1461f().mo224a();
        this.f7557m.mo189a(R.id.root, this.f7535C, "fragment").mo187a();
        this.f7564t.setVisibility(8);
        C0078e c0078e = (C0078e) this.f7534B.getLayoutParams();
        c0078e.m552a(-1);
        this.f7534B.setLayoutParams(c0078e);
        this.f7534B.setVisibility(8);
    }

    public void m12582a(String str) {
        Snackbar.m706a(this.f7562r, str, -1).m724a();
    }

    public void attendAll(View view) {
        this.f7546N.m12705a(this.f7542J, 1, this.f7550R);
        this.f7554V.m4399c();
        m12579r();
    }

    public void bunkedAll(View view) {
        this.f7546N.m12705a(this.f7542J, 0, this.f7550R);
        this.f7554V.m4399c();
        m12579r();
    }

    void m12583k() {
        this.f7559o = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7559o);
        this.f7558n = this;
        this.f7549Q = new C2259c(this);
        this.f7565u = (TextView) findViewById(R.id.extra_class_text);
        this.f7565u.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7566v = (TextView) findViewById(R.id.full_att_text);
        this.f7566v.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7536D = (CardView) findViewById(R.id.root_empty_view);
        this.f7537E = (TextView) findViewById(R.id.root_empty_title);
        this.f7537E.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7538F = (TextView) findViewById(R.id.root_empty_footer);
        this.f7538F.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7539G = (RelativeLayout) findViewById(R.id.empty_view_extra);
        this.f7540H = (TextView) findViewById(R.id.empty_text_extra);
        this.f7540H.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7563s = (RelativeLayout) findViewById(R.id.extra_class_layout);
        this.f7552T = "MainActivity";
        this.f7551S = new Date();
        this.f7550R = new SimpleDateFormat("d-M-yyyy").format(this.f7551S);
        this.f7562r = (CoordinatorLayout) findViewById(R.id.root);
        this.f7564t = (AppBarLayout) findViewById(R.id.appbar_layout);
        this.f7567w = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        this.f7534B = (FloatingActionButton) findViewById(R.id.fab);
        this.f7568x = (ViewPager) findViewById(R.id.pager);
        this.f7533A = (ProgressPageIndicator) findViewById(R.id.pageIndicator);
        this.f7560p = (RecyclerView) findViewById(R.id.recycler_view);
        this.f7560p.setLayoutManager(new LinearLayoutManager(this));
        this.f7560p.setHasFixedSize(true);
        this.f7561q = (RecyclerView) findViewById(R.id.extra_class_recycler_view);
        this.f7561q.setLayoutManager(new LinearLayoutManager(this));
        this.f7561q.setHasFixedSize(true);
        this.f7543K = new ArrayList();
        this.f7544L = new ArrayList();
        this.f7569y = new ArrayList();
        this.f7570z = new C2298b();
        this.f7569y.add(this.f7570z);
        this.f7569y.add(new C2305d());
        this.f7541I = new ArrayList();
        this.f7548P = new C2313c();
        this.f7546N = new C2256a(this);
        this.f7547O = new C2260d(this);
        this.f7545M = m12577p();
        this.f7548P.m12895c(this.f7545M);
        this.f7542J = this.f7547O.m12742b(this.f7548P);
        if (this.f7542J.isEmpty()) {
            this.f7536D.setVisibility(0);
        } else {
            this.f7536D.setVisibility(4);
        }
        this.f7554V = new C2274c(this, this.f7542J, this.f7550R, this.f7552T);
        ((C2274c) this.f7554V).m5581a(C0951a.Single);
        this.f7560p.setAdapter(this.f7554V);
        m12576o();
        if (this.f7541I.size() == 0) {
            this.f7539G.setVisibility(0);
        } else {
            this.f7539G.setVisibility(4);
        }
        NativeExpressAdView nativeExpressAdView = (NativeExpressAdView) findViewById(R.id.adView);
        nativeExpressAdView.mo926a(new C1022a().m5773a());
        nativeExpressAdView.setAdListener(new C22111(this));
    }

    public void m12584l() {
        double d = 0.0d;
        this.f7543K = this.f7549Q.m12727a();
        double d2 = 0.0d;
        for (int i = 0; i < this.f7543K.size(); i++) {
            int c = ((C2312b) this.f7543K.get(i)).m12886c();
            d2 += (double) (this.f7546N.m12706b(c) + this.f7549Q.m12732b(c));
            d += (double) (this.f7549Q.m12726a(c) + this.f7546N.m12709c(c));
        }
        this.f7570z.m12855a(d2, d);
    }

    public void m12585m() {
        C2258b.m12715a(this.f7558n, "FIRST_TIME", String.valueOf(2));
        this.f7564t.setVisibility(0);
        C0078e c0078e = (C0078e) this.f7534B.getLayoutParams();
        c0078e.m552a((int) R.id.appbar_layout);
        this.f7534B.setLayoutParams(c0078e);
        this.f7534B.setVisibility(0);
        m12583k();
        m12586n();
    }

    void m12586n() {
        Builder builder = new Builder(this.f7558n);
        View inflate = LayoutInflater.from(this.f7558n).inflate(R.layout.custom_dialog, null);
        builder.setView(inflate);
        builder.setCancelable(false);
        Button button = (Button) inflate.findViewById(R.id.yes);
        Button button2 = (Button) inflate.findViewById(R.id.no);
        final AlertDialog create = builder.create();
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainActivity f7523b;

            public void onClick(View view) {
                this.f7523b.startActivity(new Intent(this.f7523b.f7558n, PrevAttendanceActivity.class));
                create.dismiss();
            }
        });
        button2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainActivity f7525b;

            public void onClick(View view) {
                create.dismiss();
            }
        });
        create.show();
    }

    public void noClassAll(View view) {
        this.f7546N.m12705a(this.f7542J, -1, this.f7550R);
        this.f7554V.m4399c();
        m12579r();
    }

    public void onBackPressed() {
        if (this.f7555W.booleanValue()) {
            final View findViewById = findViewById(R.id.extra_class_layout);
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getWidth(), 0, (float) (findViewById.getHeight() + 1000), (float) null);
            createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator(1.0f));
            createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ MainActivity f7520b;

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    findViewById.setVisibility(4);
                    if (this.f7520b.f7542J.size() == 0) {
                        this.f7520b.f7536D.setVisibility(0);
                    }
                    this.f7520b.f7539G.setVisibility(4);
                }
            });
            createCircularReveal.start();
            this.f7534B.m652b();
            this.f7555W = Boolean.valueOf(false);
            new Handler().postDelayed(new C22144(this), 300);
        } else if (this.f7556X.booleanValue()) {
            m12579r();
        } else {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        m12583k();
        if (Integer.parseInt(C2258b.m12720b(this.f7558n, "FIRST_TIME", String.valueOf(0))) == 0) {
            m12581t();
        } else if (Integer.parseInt(C2258b.m12720b(this.f7558n, "FIRST_TIME", String.valueOf(0))) == 1) {
            C2258b.m12715a(this.f7558n, "FIRST_TIME", String.valueOf(2));
            m12586n();
        }
        this.f7568x.setAdapter(new C2275d(m1461f(), this.f7569y));
        this.f7568x.m2004a(new C2223a());
        this.f7533A.setViewPager(this.f7568x);
        this.f7534B.setOnClickListener(new C22177(this));
        this.f7534B.setOnLongClickListener(new C22218(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_page_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.help:
                startActivity(new Intent(this.f7558n, HelpActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(this.f7558n, SettingsActivity.class));
                break;
            case R.id.about_us:
                startActivity(new Intent(this.f7558n, AboutUsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onResume() {
        super.onResume();
        m12583k();
    }
}
