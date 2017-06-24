package dotinc.attendancemanager2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.daimajia.swipe.p028d.C0952a.C0951a;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p043a.C2274c;
import dotinc.attendancemanager2.p045c.C2313c;
import java.util.ArrayList;

public class ExtraClassActivity extends C0633d {
    private ArrayList<C2313c> f7429A;
    private Toolbar f7430m;
    private RecyclerView f7431n;
    private String f7432o;
    private int f7433p;
    private CoordinatorLayout f7434q;
    private C2256a f7435r;
    private C2260d f7436s;
    private C2313c f7437t;
    private C2259c f7438u;
    private RelativeLayout f7439v;
    private TextView f7440w;
    private String f7441x;
    private C0778a f7442y;
    private ArrayList<C2313c> f7443z;

    private int m12526b(String str) {
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
                setTitle(getResources().getString(R.string.monday));
                return 1;
            case 1:
                setTitle(getResources().getString(R.string.tuesday));
                return 2;
            case 2:
                setTitle(getResources().getString(R.string.wednesday));
                return 3;
            case 3:
                setTitle(getResources().getString(R.string.thursday));
                return 4;
            case 4:
                setTitle(getResources().getString(R.string.friday));
                return 5;
            case 5:
                setTitle(getResources().getString(R.string.saturday));
                return 6;
            case 6:
                setTitle(getResources().getString(R.string.sunday));
                return 1;
            default:
                return 1;
        }
    }

    private void m12527k() {
        this.f7430m = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7430m);
        m3337g().mo582a(true);
        Intent intent = getIntent();
        this.f7432o = intent.getStringExtra("date");
        this.f7441x = intent.getStringExtra("day_selected");
        this.f7433p = m12526b(this.f7441x);
        this.f7431n = (RecyclerView) findViewById(R.id.extra_subjects);
        this.f7431n.setLayoutManager(new LinearLayoutManager(this));
        this.f7431n.setHasFixedSize(true);
        this.f7439v = (RelativeLayout) findViewById(R.id.empty_view_extra_goto);
        this.f7440w = (TextView) findViewById(R.id.empty_text_extra_goto);
        this.f7440w.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7435r = new C2256a(this);
        this.f7436s = new C2260d(this);
        this.f7437t = new C2313c();
        this.f7438u = new C2259c(this);
        this.f7434q = (CoordinatorLayout) findViewById(R.id.root);
        this.f7443z = this.f7436s.m12742b(this.f7437t);
        m12528l();
        if (this.f7429A.size() == 0) {
            this.f7439v.setVisibility(0);
        } else {
            this.f7439v.setVisibility(4);
        }
    }

    private void m12528l() {
        this.f7437t.m12895c(this.f7433p);
        this.f7443z = this.f7436s.m12742b(this.f7437t);
        this.f7429A = this.f7438u.m12733b();
        for (int i = 0; i < this.f7443z.size(); i++) {
            for (int i2 = 0; i2 < this.f7429A.size(); i2++) {
                if (((C2313c) this.f7429A.get(i2)).m12894c().equals(((C2313c) this.f7443z.get(i)).m12894c())) {
                    this.f7429A.remove(i2);
                }
            }
        }
        this.f7442y = new C2274c(this, this.f7429A, this.f7432o, "ExtraClassActivity");
        ((C2274c) this.f7442y).m5581a(C0951a.Single);
        this.f7431n.setAdapter(this.f7442y);
    }

    public void m12529a(String str) {
        Snackbar.m706a(this.f7434q, str, -1).m724a();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_extra_class);
        m12527k();
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
