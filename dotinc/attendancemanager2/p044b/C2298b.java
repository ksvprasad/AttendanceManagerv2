package dotinc.attendancemanager2.p044b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import dotinc.attendancemanager2.MainActivity;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.WeeklySubjectsActivity;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;

public class C2298b extends Fragment {
    private static TextView f7901d;
    private static TextView f7902e;
    ArrayList<C2312b> f7903a;
    C2259c f7904b;
    private TextView f7905c;
    private ImageView f7906f;

    class C22971 implements OnClickListener {
        final /* synthetic */ C2298b f7900a;

        C22971(C2298b c2298b) {
            this.f7900a = c2298b;
        }

        public void onClick(View view) {
            C2258b.m12717a("Checked Timetable", C2258b.m12720b(this.f7900a.m1198i(), "USER_NAME", ""), C2258b.m12720b(this.f7900a.m1198i(), "USER_IMAGE_ID", "0"), this.f7900a.m1198i());
            Intent intent = new Intent(this.f7900a.m1200j(), WeeklySubjectsActivity.class);
            intent.putExtra("view_timetable", 1);
            this.f7900a.m1163a(intent);
        }
    }

    private void m12852b(Context context) {
        f7901d.setText(C2258b.m12720b(context, "USER_NAME", ""));
    }

    private void m12853c(Context context) {
        int parseInt = Integer.parseInt(C2258b.m12720b(context, "USER_IMAGE_ID", String.valueOf(0)));
        if (parseInt == 1) {
            this.f7906f.setImageResource(R.drawable.user_male);
        } else if (parseInt == 2) {
            this.f7906f.setImageResource(R.drawable.user_female);
        }
    }

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_header, viewGroup, false);
        this.f7905c = (TextView) inflate.findViewById(R.id.time_table_btn);
        this.f7905c.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans_regular.ttf"));
        f7901d = (TextView) inflate.findViewById(R.id.name_text);
        f7901d.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans-bold.ttf"));
        f7902e = (TextView) inflate.findViewById(R.id.overall_perc);
        f7902e.setTypeface(Typeface.createFromAsset(m1200j().getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7906f = (ImageView) inflate.findViewById(R.id.user_img);
        this.f7904b = new C2259c(m1200j());
        this.f7903a = new ArrayList();
        this.f7903a = this.f7904b.m12727a();
        ((MainActivity) m1200j()).m12584l();
        return inflate;
    }

    public void m12855a(double d, double d2) {
        if (d2 == 0.0d && d == 0.0d) {
            f7902e.setText("No classes yet");
            return;
        }
        double d3 = (d / d2) * 100.0d;
        f7902e.setText("Overall: " + String.format("%.1f", new Object[]{Double.valueOf(d3)}) + "%");
    }

    public void mo202d(Bundle bundle) {
        super.mo202d(bundle);
        m12853c(m1200j());
        m12852b(m1200j());
        this.f7905c.setOnClickListener(new C22971(this));
    }
}
