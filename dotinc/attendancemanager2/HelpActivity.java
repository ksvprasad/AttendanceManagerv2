package dotinc.attendancemanager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.p043a.C2268b;
import java.util.ArrayList;

public class HelpActivity extends C0633d {
    Toolbar f7504m;
    RecyclerView f7505n;
    ArrayList<String> f7506o;
    ArrayList<String> f7507p;
    C2268b f7508q;
    private Context f7509r;

    private void m12555k() {
        this.f7506o.add("Setting up Time Table");
        this.f7507p.add(getResources().getString(R.string.setting_up_timetable));
        this.f7506o.add("Adding Attendance");
        this.f7507p.add(getResources().getString(R.string.adding_attendance));
        this.f7506o.add("Adding Extra classes");
        this.f7507p.add(getResources().getString(R.string.adding_extraClasses));
        this.f7506o.add("Shortcut to add all attendance");
        this.f7507p.add(getResources().getString(R.string.shortcut_add_attendance));
        this.f7506o.add("Go to a specific date");
        this.f7507p.add(getResources().getString(R.string.gotodate));
        this.f7506o.add("Detailed analysis");
        this.f7507p.add(getResources().getString(R.string.detailed_analysis));
        this.f7506o.add("Predictor");
        this.f7507p.add(getResources().getString(R.string.predictor));
        this.f7508q = new C2268b(this, this.f7506o, this.f7507p);
        this.f7505n.setAdapter(this.f7508q);
    }

    private void m12556l() {
        this.f7504m = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7504m);
        m3337g().mo581a((CharSequence) "Help");
        m3337g().mo582a(true);
        this.f7505n = (RecyclerView) findViewById(R.id.help_recycler);
        this.f7505n.setHasFixedSize(true);
        this.f7505n.setLayoutManager(new LinearLayoutManager(this));
        this.f7506o = new ArrayList();
        this.f7507p = new ArrayList();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_help);
        m12556l();
        m12555k();
        this.f7509r = this;
        C2258b.m12717a("Checked Help section", C2258b.m12720b(this.f7509r, "USER_NAME", ""), C2258b.m12720b(this.f7509r, "USER_IMAGE_ID", "0"), this.f7509r);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
        } else if (itemId == R.id.help) {
            if (itemId == 16908332) {
                finish();
            } else if (itemId == R.id.help) {
                startActivity(new Intent(this, FeedbackActivity.class));
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
