package dotinc.attendancemanager2;

import android.os.Bundle;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.ads.C1026c.C1022a;
import com.google.android.gms.ads.NativeExpressAdView;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p043a.C2277e;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;

public class OverallAttendanceActivity extends C0633d {
    private RecyclerView f7594m;
    private Toolbar f7595n;
    private ArrayList<C2312b> f7596o;
    private C2259c f7597p;
    private C2277e f7598q;

    private void m12609k() {
        this.f7595n = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7595n);
        m3337g().mo581a(getResources().getString(R.string.overall_attendance_activity));
        m3337g().mo582a(true);
        this.f7597p = new C2259c(this);
        this.f7596o = this.f7597p.m12727a();
        this.f7594m = (RecyclerView) findViewById(R.id.subjects);
        this.f7594m.setHasFixedSize(true);
        this.f7594m.setLayoutManager(new LinearLayoutManager(this));
        this.f7598q = new C2277e(this, this.f7596o);
        this.f7594m.setAdapter(this.f7598q);
        ((NativeExpressAdView) findViewById(R.id.adView)).mo926a(new C1022a().m5773a());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_overall_attendance);
        m12609k();
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
