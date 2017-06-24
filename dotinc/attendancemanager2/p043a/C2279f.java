package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.p010b.C0195a;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.p045c.C2312b;
import java.math.BigDecimal;
import java.util.ArrayList;

public class C2279f extends C0778a<C0801u> {
    Context f7836a;
    int f7837b;
    int f7838c;
    private LayoutInflater f7839d;
    private ArrayList<C2312b> f7840e;
    private C2256a f7841f;

    static class C2278a extends C0801u {
        private TextView f7833l;
        private TextView f7834m;
        private TextView f7835n;

        public C2278a(View view) {
            super(view);
            this.f7833l = (TextView) view.findViewById(R.id.subject_name);
            this.f7834m = (TextView) view.findViewById(R.id.current_percentage);
            this.f7835n = (TextView) view.findViewById(R.id.predicted_percentage);
        }
    }

    public C2279f(Context context, int i, int i2, ArrayList<C2312b> arrayList) {
        this.f7836a = context;
        this.f7837b = i;
        this.f7838c = i2;
        this.f7840e = arrayList;
        this.f7839d = LayoutInflater.from(context);
        this.f7841f = new C2256a(context);
    }

    public int mo1796a() {
        return this.f7840e.size();
    }

    public C0801u mo1797a(ViewGroup viewGroup, int i) {
        return new C2278a(this.f7839d.inflate(R.layout.custom_predictor, viewGroup, false));
    }

    public void mo1798a(C0801u c0801u, int i) {
        C2278a c2278a = (C2278a) c0801u;
        c2278a.f7833l.setTypeface(Typeface.createFromAsset(this.f7836a.getAssets(), "fonts/oxygen-bold.ttf"));
        c2278a.f7834m.setTypeface(Typeface.createFromAsset(this.f7836a.getAssets(), "fonts/josefin_sans-bold.ttf"));
        c2278a.f7835n.setTypeface(Typeface.createFromAsset(this.f7836a.getAssets(), "fonts/josefin_sans-bold.ttf"));
        c2278a.f7833l.setText(((C2312b) this.f7840e.get(i)).m12888d());
        int c = ((C2312b) this.f7840e.get(i)).m12886c();
        int b = this.f7841f.m12706b(c);
        c = this.f7841f.m12709c(c);
        float f = (((float) b) / ((float) c)) * 100.0f;
        if (Float.isNaN(f)) {
            c2278a.f7834m.setText("0%");
        } else {
            BigDecimal bigDecimal = new BigDecimal(String.format("%.1f", new Object[]{Float.valueOf(f)}));
            if (f >= ((float) Integer.parseInt(C2258b.m12720b(this.f7836a, "ATTENDANCE_CRITERIA", "0")))) {
                c2278a.f7834m.setTextColor(C0195a.m1227c(this.f7836a, R.color.attendedColor));
                c2278a.f7834m.setText(bigDecimal.stripTrailingZeros().toPlainString() + "%");
            } else {
                c2278a.f7834m.setTextColor(C0195a.m1227c(this.f7836a, R.color.absentColor));
                c2278a.f7834m.setText(bigDecimal.stripTrailingZeros().toPlainString() + "%");
            }
        }
        float f2;
        BigDecimal bigDecimal2;
        if (this.f7837b == 1) {
            f2 = (((float) (b + this.f7838c)) / ((float) (c + this.f7838c))) * 100.0f;
            if (Float.isNaN(f2)) {
                c2278a.f7835n.setText("0%");
                return;
            }
            bigDecimal2 = new BigDecimal(String.format("%.1f", new Object[]{Float.valueOf(f2)}));
            if (f2 >= ((float) Integer.parseInt(C2258b.m12720b(this.f7836a, "ATTENDANCE_CRITERIA", "0")))) {
                c2278a.f7835n.setTextColor(C0195a.m1227c(this.f7836a, R.color.attendedColor));
                c2278a.f7835n.setText(bigDecimal2.stripTrailingZeros().toPlainString() + "%");
                return;
            }
            c2278a.f7835n.setTextColor(C0195a.m1227c(this.f7836a, R.color.absentColor));
            c2278a.f7835n.setText(bigDecimal2.stripTrailingZeros().toPlainString() + "%");
            return;
        }
        f2 = (((float) b) / ((float) (c + this.f7838c))) * 100.0f;
        if (Float.isNaN(f2)) {
            c2278a.f7835n.setText("0%");
            return;
        }
        bigDecimal2 = new BigDecimal(String.format("%.1f", new Object[]{Float.valueOf(f2)}));
        if (f2 >= ((float) Integer.parseInt(C2258b.m12720b(this.f7836a, "ATTENDANCE_CRITERIA", "0")))) {
            c2278a.f7835n.setTextColor(C0195a.m1227c(this.f7836a, R.color.attendedColor));
            c2278a.f7835n.setText(bigDecimal2.stripTrailingZeros().toPlainString() + "%");
            return;
        }
        c2278a.f7835n.setTextColor(C0195a.m1227c(this.f7836a, R.color.absentColor));
        c2278a.f7835n.setText(bigDecimal2.stripTrailingZeros().toPlainString() + "%");
    }
}
