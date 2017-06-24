package dotinc.attendancemanager2.p044b;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import dotinc.attendancemanager2.DetailedAnalysisActivity;
import dotinc.attendancemanager2.GoToDateActivity;
import dotinc.attendancemanager2.GoToDateOldActivity;
import dotinc.attendancemanager2.OverallAttendanceActivity;
import dotinc.attendancemanager2.PredictorActivity;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2258b;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class C2305d extends Fragment {
    int f7914a;
    private TextView ai;
    private OnDateSetListener aj = new C23045(this);
    int f7915b;
    int f7916c;
    SimpleDateFormat f7917d;
    Date f7918e;
    Calendar f7919f;
    private TextView f7920g;
    private TextView f7921h;
    private TextView f7922i;

    class C23001 implements OnClickListener {
        final /* synthetic */ C2305d f7909a;

        C23001(C2305d c2305d) {
            this.f7909a = c2305d;
        }

        public void onClick(View view) {
            C2258b.m12717a("Checked Detailed Analysis", C2258b.m12720b(this.f7909a.m1198i(), "USER_NAME", ""), C2258b.m12720b(this.f7909a.m1198i(), "USER_IMAGE_ID", "0"), this.f7909a.m1198i());
            this.f7909a.m1163a(new Intent(this.f7909a.m1200j(), DetailedAnalysisActivity.class));
        }
    }

    class C23012 implements OnClickListener {
        final /* synthetic */ C2305d f7910a;

        C23012(C2305d c2305d) {
            this.f7910a = c2305d;
        }

        public void onClick(View view) {
            C2258b.m12717a("Checked Go To Date ", C2258b.m12720b(this.f7910a.m1198i(), "USER_NAME", ""), C2258b.m12720b(this.f7910a.m1198i(), "USER_IMAGE_ID", "0"), this.f7910a.m1198i());
            if (VERSION.SDK_INT >= 21) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(this.f7910a.m1200j(), R.style.DialogTheme, this.f7910a.aj, this.f7910a.f7914a, this.f7910a.f7915b, this.f7910a.f7916c);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
                return;
            }
            this.f7910a.m1163a(new Intent(this.f7910a.m1200j(), GoToDateOldActivity.class));
        }
    }

    class C23023 implements OnClickListener {
        final /* synthetic */ C2305d f7911a;

        C23023(C2305d c2305d) {
            this.f7911a = c2305d;
        }

        public void onClick(View view) {
            C2258b.m12717a("Checked Overall Attendance", C2258b.m12720b(this.f7911a.m1198i(), "USER_NAME", ""), C2258b.m12720b(this.f7911a.m1198i(), "USER_IMAGE_ID", "0"), this.f7911a.m1198i());
            this.f7911a.m1163a(new Intent(this.f7911a.m1200j(), OverallAttendanceActivity.class));
        }
    }

    class C23034 implements OnClickListener {
        final /* synthetic */ C2305d f7912a;

        C23034(C2305d c2305d) {
            this.f7912a = c2305d;
        }

        public void onClick(View view) {
            C2258b.m12717a("Checked Predictor", C2258b.m12720b(this.f7912a.m1198i(), "USER_NAME", ""), C2258b.m12720b(this.f7912a.m1198i(), "USER_IMAGE_ID", "0"), this.f7912a.m1198i());
            this.f7912a.m1163a(new Intent(this.f7912a.m1200j(), PredictorActivity.class));
        }
    }

    class C23045 implements OnDateSetListener {
        final /* synthetic */ C2305d f7913a;

        C23045(C2305d c2305d) {
            this.f7913a = c2305d;
        }

        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str = i3 + "-" + (i2 + 1) + "-" + i;
            try {
                this.f7913a.f7918e = this.f7913a.f7917d.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String format = new SimpleDateFormat("EE").format(this.f7913a.f7918e);
            Intent intent = new Intent(this.f7913a.m1200j(), GoToDateActivity.class);
            intent.putExtra("date", str);
            intent.putExtra("day_name", format);
            this.f7913a.m1163a(intent);
        }
    }

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_second, viewGroup, false);
        this.f7920g = (TextView) inflate.findViewById(R.id.detailed_analysis);
        this.f7920g.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7921h = (TextView) inflate.findViewById(R.id.go_to_date);
        this.f7921h.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7922i = (TextView) inflate.findViewById(R.id.complete_attendance);
        this.f7922i.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.ai = (TextView) inflate.findViewById(R.id.predictor);
        this.ai.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7919f = Calendar.getInstance();
        this.f7914a = this.f7919f.get(1);
        this.f7915b = this.f7919f.get(2);
        this.f7916c = this.f7919f.get(5);
        this.f7917d = new SimpleDateFormat("d-M-yyyy");
        return inflate;
    }

    public void mo202d(Bundle bundle) {
        super.mo202d(bundle);
        this.f7920g.setOnClickListener(new C23001(this));
        this.f7921h.setOnClickListener(new C23012(this));
        this.f7922i.setOnClickListener(new C23023(this));
        this.ai.setOnClickListener(new C23034(this));
    }
}
