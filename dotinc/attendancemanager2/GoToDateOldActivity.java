package dotinc.attendancemanager2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.prolificinteractive.materialcalendarview.C2151i;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GoToDateOldActivity extends C0633d {
    private Toolbar f7501m;
    private MaterialCalendarView f7502n;
    private SimpleDateFormat f7503o;

    class C22101 implements C2151i {
        final /* synthetic */ GoToDateOldActivity f7500a;

        C22101(GoToDateOldActivity goToDateOldActivity) {
            this.f7500a = goToDateOldActivity;
        }

        public void mo1792a(MaterialCalendarView materialCalendarView, CalendarDay calendarDay) {
            int d = calendarDay.m12216d();
            int c = calendarDay.m12215c() + 1;
            String str = d + "-" + c + "-" + calendarDay.m12212b();
            Date date = new Date();
            try {
                date = this.f7500a.f7503o.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String format = new SimpleDateFormat("EE").format(date);
            Intent intent = new Intent(this.f7500a, GoToDateActivity.class);
            intent.putExtra("date", str);
            intent.putExtra("day_name", format);
            this.f7500a.startActivity(intent);
        }
    }

    private void m12554k() {
        this.f7501m = (Toolbar) findViewById(R.id.toolbar);
        m3331a(this.f7501m);
        m3337g().mo582a(true);
        m3337g().mo581a((CharSequence) "Go to Date");
        this.f7503o = new SimpleDateFormat("d-M-yyyy");
        this.f7502n = (MaterialCalendarView) findViewById(R.id.calendarView);
        this.f7502n.setMaximumDate(new Date());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_go_to_date_old);
        m12554k();
        Calendar instance = Calendar.getInstance();
        this.f7502n.setCurrentDate(instance.getTime());
        this.f7502n.setSelectedDate(instance.getTime());
        this.f7502n.setOnDateChangedListener(new C22101(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.go_to_date_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
