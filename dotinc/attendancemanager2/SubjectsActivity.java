package dotinc.attendancemanager2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0778a;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.daimajia.swipe.p028d.C0952a.C0951a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p043a.C2290j;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SubjectsActivity extends C0633d {
    private LinearLayout f7700A;
    private CoordinatorLayout f7701B;
    private C0778a f7702C;
    private C2259c f7703D;
    private C2312b f7704E;
    private C2260d f7705F;
    private Typeface f7706G;
    private Typeface f7707H;
    private Typeface f7708I;
    private ArrayList<EditText> f7709J;
    private ArrayList<String> f7710K;
    private ArrayList<String> f7711L;
    private boolean f7712M;
    private boolean f7713N;
    private RecyclerView f7714m;
    private FloatingActionButton f7715n;
    private TextView f7716o;
    private TextView f7717p;
    private TextView f7718q;
    private TextView f7719r;
    private TextView f7720s;
    private LinearLayout f7721t;
    private LinearLayout f7722u;
    private View f7723v;
    private ImageView f7724w;
    private ImageView f7725x;
    private ArrayList<C2312b> f7726y;
    private EditText f7727z;

    class C22481 implements OnClickListener {
        final /* synthetic */ SubjectsActivity f7691a;

        class C22461 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22481 f7689a;

            C22461(C22481 c22481) {
                this.f7689a = c22481;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                String trim = this.f7689a.f7691a.f7727z.getText().toString().trim();
                if (this.f7689a.f7691a.m12686a(trim) == 0 && trim.length() != 0) {
                    this.f7689a.f7691a.f7704E.m12883a(trim);
                    this.f7689a.f7691a.f7703D.m12728a(this.f7689a.f7691a.f7704E);
                    this.f7689a.f7691a.f7726y.clear();
                    this.f7689a.f7691a.f7726y.addAll(this.f7689a.f7691a.f7703D.m12727a());
                    this.f7689a.f7691a.m12687b(this.f7689a.f7691a.f7726y.size());
                    this.f7689a.f7691a.f7702C.m4399c();
                } else if (trim.length() == 0) {
                    this.f7689a.f7691a.m12688b("Subject cannot be empty");
                } else {
                    this.f7689a.f7691a.m12688b("Subject already entered");
                }
            }
        }

        class C22472 implements DialogInterface.OnClickListener {
            final /* synthetic */ C22481 f7690a;

            C22472(C22481 c22481) {
                this.f7690a = c22481;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }

        C22481(SubjectsActivity subjectsActivity) {
            this.f7691a = subjectsActivity;
        }

        public void onClick(View view) {
            if (VERSION.SDK_INT >= 21) {
                this.f7691a.m12680l();
                return;
            }
            Builder builder = new Builder(this.f7691a);
            View inflate = this.f7691a.getLayoutInflater().inflate(R.layout.add_subject, null);
            this.f7691a.f7727z = (EditText) inflate.findViewById(R.id.subject_name);
            this.f7691a.f7727z.setTypeface(this.f7691a.f7707H);
            builder.setView(inflate);
            builder.setPositiveButton("Ok", new C22461(this));
            builder.setNegativeButton("Cancel", new C22472(this));
            builder.create().show();
        }
    }

    class C22514 implements Runnable {
        final /* synthetic */ SubjectsActivity f7696a;

        C22514(SubjectsActivity subjectsActivity) {
            this.f7696a = subjectsActivity;
        }

        public void run() {
            this.f7696a.f7715n.m650a();
        }
    }

    class C22525 implements Runnable {
        final /* synthetic */ SubjectsActivity f7697a;

        C22525(SubjectsActivity subjectsActivity) {
            this.f7697a = subjectsActivity;
        }

        public void run() {
            this.f7697a.f7715n.m650a();
        }
    }

    private void m12678k() {
        this.f7706G = Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf");
        this.f7707H = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans-bold.ttf");
        this.f7708I = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf");
        this.f7718q = (TextView) findViewById(R.id.empty_text);
        this.f7718q.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        C2258b.m12716a(this.f7718q, getResources().getString(R.string.subjects_help), 40);
        this.f7715n = (FloatingActionButton) findViewById(R.id.add_subjects);
        this.f7715n.m652b();
        this.f7716o = (TextView) findViewById(R.id.subject_layout_title);
        this.f7716o.setTypeface(this.f7706G);
        this.f7717p = (TextView) findViewById(R.id.swipe_help_text);
        this.f7717p.setTypeface(this.f7708I);
        this.f7722u = (LinearLayout) findViewById(R.id.help_text);
        this.f7723v = findViewById(R.id.view1);
        this.f7720s = (TextView) findViewById(R.id.titleView);
        this.f7720s.setTypeface(this.f7706G);
        this.f7719r = (TextView) findViewById(R.id.mul_sub_help);
        this.f7719r.setTypeface(this.f7708I);
        this.f7713N = getIntent().getBooleanExtra("Settings", false);
        this.f7703D = new C2259c(this);
        this.f7705F = new C2260d(this);
        this.f7700A = (LinearLayout) findViewById(R.id.empty_view);
        this.f7721t = (LinearLayout) findViewById(R.id.subjects_view);
        this.f7709J = new ArrayList();
        this.f7710K = new ArrayList();
        this.f7711L = new ArrayList();
        this.f7701B = (CoordinatorLayout) findViewById(R.id.root);
        this.f7724w = (ImageView) findViewById(R.id.done);
        this.f7725x = (ImageView) findViewById(R.id.removeEdit);
        this.f7704E = new C2312b();
        this.f7726y = this.f7703D.m12727a();
        this.f7714m = (RecyclerView) findViewById(R.id.subjects);
        this.f7714m.setHasFixedSize(true);
        this.f7714m.setLayoutManager(new LinearLayoutManager(this));
        this.f7702C = new C2290j(this, this.f7726y);
        ((C2290j) this.f7702C).m5581a(C0951a.Single);
        m12687b(this.f7726y.size());
        m12681m();
    }

    private void m12680l() {
        final View findViewById = findViewById(R.id.add_multiple_subjects);
        int left = findViewById.getLeft() + findViewById.getRight();
        int bottom = findViewById.getBottom();
        Animator createCircularReveal;
        if (findViewById.getVisibility() == 4) {
            createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, left, bottom, 0.0f, (float) Math.max(left, bottom + 1000));
            createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator());
            findViewById.setVisibility(0);
            createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
                final /* synthetic */ SubjectsActivity f7693b;

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    this.f7693b.addEditText(findViewById);
                    this.f7693b.f7722u.setVisibility(0);
                    this.f7693b.f7715n.setImageResource(R.mipmap.ic_done_white_36dp);
                    this.f7693b.f7715n.setBackgroundTintList(this.f7693b.getResources().getColorStateList(R.color.colorPrimaryDark));
                    this.f7693b.f7715n.setRippleColor(this.f7693b.getResources().getColor(R.color.colorPrimary));
                    this.f7693b.f7715n.setImageTintList(this.f7693b.getResources().getColorStateList(R.color.white));
                    this.f7693b.f7715n.m650a();
                    this.f7693b.f7712M = true;
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    this.f7693b.f7709J.clear();
                    this.f7693b.f7721t.removeAllViews();
                    this.f7693b.f7724w.setVisibility(8);
                }
            });
            createCircularReveal.start();
            this.f7715n.m652b();
        } else if (findViewById.getVisibility() != 0) {
        } else {
            if (this.f7709J.isEmpty()) {
                m12685q();
                return;
            }
            m12682n();
            if (!m12683o()) {
                m12688b("Remove subjects with same name");
            } else if (this.f7709J.isEmpty() || !m12684p()) {
                this.f7703D.m12734b(this.f7710K);
                createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, left, bottom, (float) (findViewById.getHeight() + 1000), (float) null);
                createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator());
                createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
                    final /* synthetic */ SubjectsActivity f7695b;

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        ((InputMethodManager) this.f7695b.getSystemService("input_method")).hideSoftInputFromWindow(this.f7695b.getCurrentFocus().getWindowToken(), 2);
                        findViewById.setVisibility(4);
                        this.f7695b.f7715n.setImageResource(R.mipmap.ic_add_white_36dp);
                        this.f7695b.f7715n.setBackgroundTintList(this.f7695b.getResources().getColorStateList(R.color.colorPrimaryDark));
                        this.f7695b.f7715n.setRippleColor(this.f7695b.getResources().getColor(R.color.colorPrimary));
                        this.f7695b.f7715n.setImageTintList(this.f7695b.getResources().getColorStateList(R.color.white));
                        this.f7695b.f7715n.m650a();
                        this.f7695b.f7712M = false;
                        this.f7695b.f7726y.clear();
                        this.f7695b.m12687b(this.f7695b.f7726y.size());
                        this.f7695b.f7726y.addAll(this.f7695b.f7703D.m12727a());
                        this.f7695b.m12687b(this.f7695b.f7726y.size());
                        this.f7695b.f7702C.m4399c();
                    }
                });
                createCircularReveal.start();
                this.f7715n.m652b();
            } else {
                m12688b("Subject name cannot be blank");
            }
        }
    }

    private void m12681m() {
        for (int i = 0; i < this.f7726y.size(); i++) {
            this.f7711L.add(((C2312b) this.f7726y.get(i)).m12888d());
        }
    }

    private void m12682n() {
        this.f7710K.clear();
        if (!this.f7709J.isEmpty()) {
            for (int i = 0; i < this.f7709J.size(); i++) {
                this.f7710K.add(((EditText) this.f7709J.get(i)).getText().toString().trim());
            }
        }
    }

    private boolean m12683o() {
        ArrayList arrayList = new ArrayList();
        this.f7711L.clear();
        m12681m();
        arrayList.addAll(this.f7711L);
        arrayList.addAll(this.f7710K);
        Set hashSet = new HashSet(this.f7711L);
        hashSet.addAll(this.f7710K);
        return hashSet.size() == arrayList.size();
    }

    private boolean m12684p() {
        Iterator it = this.f7709J.iterator();
        while (it.hasNext()) {
            if (((EditText) it.next()).getText().toString().trim().matches("")) {
                return true;
            }
        }
        return false;
    }

    private void m12685q() {
        final View findViewById = findViewById(R.id.add_multiple_subjects);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(findViewById, findViewById.getLeft() + findViewById.getRight(), findViewById.getBottom(), (float) (findViewById.getHeight() + 1000), (float) 0);
        createCircularReveal.setDuration(500).setInterpolator(new DecelerateInterpolator());
        createCircularReveal.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ SubjectsActivity f7699b;

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                findViewById.setVisibility(4);
                this.f7699b.f7715n.setImageResource(R.mipmap.ic_add_white_36dp);
                this.f7699b.f7715n.setBackgroundTintList(this.f7699b.getResources().getColorStateList(R.color.white));
                this.f7699b.f7715n.setRippleColor(this.f7699b.getResources().getColor(R.color.backgroundColor));
                this.f7699b.f7715n.setImageTintList(this.f7699b.getResources().getColorStateList(R.color.colorPrimaryDark));
                this.f7699b.f7715n.m650a();
                this.f7699b.m12687b(this.f7699b.f7726y.size());
                this.f7699b.f7712M = false;
            }
        });
        createCircularReveal.start();
        this.f7715n.m652b();
    }

    public int m12686a(String str) {
        for (int i = 0; i < this.f7726y.size(); i++) {
            if (((C2312b) this.f7726y.get(i)).m12888d().equals(str)) {
                return 1;
            }
        }
        return 0;
    }

    public void addEditText(View view) {
        View editText = new EditText(this);
        editText.setId(this.f7709J.size() + 1);
        editText.setHint("Enter subject " + (this.f7709J.size() + 1));
        editText.setTextSize(2, 20.0f);
        editText.setPadding(25, 25, 25, 25);
        editText.setSingleLine(true);
        editText.setFilters(new InputFilter[]{new LengthFilter(25)});
        editText.setBackground(getResources().getDrawable(R.drawable.item_border));
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(16, 15, 16, 15);
        editText.setLayoutParams(layoutParams);
        editText.requestFocus();
        editText.setTypeface(this.f7707H);
        this.f7721t.addView(editText);
        this.f7709J.add(editText);
        if (this.f7725x.getVisibility() == 8) {
            this.f7725x.setVisibility(0);
        }
    }

    public void m12687b(int i) {
        if (i == 0) {
            this.f7700A.setVisibility(0);
            this.f7716o.setVisibility(8);
            this.f7723v.setVisibility(8);
            this.f7724w.setVisibility(8);
            this.f7717p.setVisibility(8);
            this.f7714m.setVisibility(8);
            if (VERSION.SDK_INT >= 21) {
                this.f7715n.setImageResource(R.mipmap.ic_add_white_36dp);
                this.f7715n.setBackgroundTintList(getResources().getColorStateList(R.color.white));
                this.f7715n.setRippleColor(getResources().getColor(R.color.backgroundColor));
                this.f7715n.setImageTintList(getResources().getColorStateList(R.color.colorPrimaryDark));
                new Handler().postDelayed(new C22514(this), 500);
                return;
            }
            return;
        }
        this.f7700A.setVisibility(8);
        this.f7716o.setVisibility(0);
        this.f7723v.setVisibility(0);
        this.f7724w.setVisibility(0);
        this.f7717p.setVisibility(0);
        this.f7714m.setVisibility(0);
        if (VERSION.SDK_INT >= 21) {
            this.f7715n.setImageResource(R.mipmap.ic_add_white_36dp);
            this.f7715n.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimaryDark));
            this.f7715n.setRippleColor(getResources().getColor(R.color.colorPrimary));
            this.f7715n.setImageTintList(getResources().getColorStateList(R.color.white));
            new Handler().postDelayed(new C22525(this), 500);
        }
    }

    public void m12688b(String str) {
        Snackbar.m706a(this.f7701B, str, 0).m724a();
    }

    public void doneAddSubjects(View view) {
        if (this.f7713N) {
            finish();
        } else {
            startActivity(new Intent(this, WeeklySubjectsActivity.class));
        }
    }

    public void onBackPressed() {
        if (this.f7712M) {
            m12685q();
        } else {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_subjects);
        m12678k();
        this.f7714m.setAdapter(this.f7702C);
        if (VERSION.SDK_INT < 21) {
            this.f7715n.m650a();
        }
        this.f7715n.setOnClickListener(new C22481(this));
    }

    public void removeEditText(View view) {
        this.f7721t.removeViewAt(this.f7709J.size() - 1);
        this.f7709J.remove(this.f7709J.size() - 1);
        if (!this.f7710K.isEmpty()) {
            this.f7710K.remove(this.f7710K.size() - 1);
        }
        if (this.f7709J.size() == 0) {
            this.f7725x.setVisibility(8);
        }
    }

    public void showHelp(View view) {
        if (this.f7722u.getVisibility() == 8) {
            this.f7722u.setVisibility(0);
        } else {
            this.f7722u.setVisibility(8);
        }
    }
}
