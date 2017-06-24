package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.p010b.C0195a;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.RecyclerView.C0801u;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.SwipeLayout.C0932b;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p045c.C2312b;
import java.math.BigDecimal;
import java.util.ArrayList;

public class C2277e extends C0778a<C2276a> {
    private Context f7828a;
    private ArrayList<C2312b> f7829b;
    private LayoutInflater f7830c;
    private C2256a f7831d;
    private C2259c f7832e;

    static class C2276a extends C0801u {
        private TextView f7821l;
        private TextView f7822m;
        private TextView f7823n;
        private TextView f7824o;
        private TextView f7825p;
        private SwipeLayout f7826q;
        private ImageView f7827r;

        public C2276a(View view) {
            super(view);
            this.f7821l = (TextView) view.findViewById(R.id.subject_name);
            this.f7822m = (TextView) view.findViewById(R.id.attended);
            this.f7823n = (TextView) view.findViewById(R.id.total);
            this.f7824o = (TextView) view.findViewById(R.id.sub_perc);
            this.f7825p = (TextView) view.findViewById(R.id.sub_detail);
            this.f7826q = (SwipeLayout) view.findViewById(R.id.swipe);
            this.f7827r = (ImageView) view.findViewById(R.id.check_mark);
        }
    }

    public C2277e(Context context, ArrayList<C2312b> arrayList) {
        this.f7828a = context;
        this.f7829b = arrayList;
        this.f7830c = LayoutInflater.from(context);
        this.f7831d = new C2256a(context);
        this.f7832e = new C2259c(context);
    }

    private void m12797a(int i, int i2, float f, C2276a c2276a) {
        int i3;
        int i4;
        int parseInt = Integer.parseInt(C2258b.m12720b(this.f7828a, "ATTENDANCE_CRITERIA", String.valueOf(0)));
        if (f >= ((float) parseInt)) {
            i3 = 1;
            i4 = i;
        } else if (i == 0 && i2 == 0) {
            i3 = 2;
            i4 = i;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (f < ((float) parseInt)) {
            i3 = 3;
            i4++;
            i2++;
            c2276a.f7824o.setTextColor(C0195a.m1227c(this.f7828a, R.color.absentColor));
            f = (((float) i4) / ((float) i2)) * 100.0f;
        }
        switch (i3) {
            case 1:
                c2276a.f7825p.setVisibility(0);
                c2276a.f7824o.setTextColor(C0195a.m1227c(this.f7828a, R.color.attendedColor));
                c2276a.f7825p.setText(this.f7828a.getResources().getString(R.string.on_track_message));
                return;
            case 2:
                c2276a.f7825p.setVisibility(4);
                return;
            case 3:
                c2276a.f7825p.setVisibility(0);
                i3 = i4 - i;
                if (i3 == 1) {
                    c2276a.f7825p.setText(Html.fromHtml("Attend next <b><font color='#E64A19'>" + i3 + "</font></b> class"));
                    return;
                } else {
                    c2276a.f7825p.setText(Html.fromHtml("Attend next <b><font color='#E64A19'>" + i3 + "</font></b> classes"));
                    return;
                }
            default:
                return;
        }
    }

    public int mo1796a() {
        return this.f7829b.size();
    }

    public /* synthetic */ C0801u mo1797a(ViewGroup viewGroup, int i) {
        return m12802c(viewGroup, i);
    }

    public void m12801a(C2276a c2276a, int i) {
        int c = ((C2312b) this.f7829b.get(i)).m12886c();
        Log.d("subject", ((C2312b) this.f7829b.get(i)).m12888d());
        int b = this.f7832e.m12732b(c) + this.f7831d.m12706b(c);
        c = this.f7832e.m12726a(c) + this.f7831d.m12709c(c);
        c2276a.f7827r.setVisibility(8);
        c2276a.f7821l.setText(((C2312b) this.f7829b.get(i)).m12888d());
        c2276a.f7821l.setTypeface(Typeface.createFromAsset(this.f7828a.getAssets(), "fonts/oxygen-bold.ttf"));
        c2276a.f7822m.setText(this.f7828a.getResources().getString(R.string.attended) + ": " + b);
        c2276a.f7822m.setTypeface(Typeface.createFromAsset(this.f7828a.getAssets(), "fonts/oxygen-regular.ttf"));
        c2276a.f7823n.setText(this.f7828a.getResources().getString(R.string.total) + ": " + c);
        c2276a.f7823n.setTypeface(Typeface.createFromAsset(this.f7828a.getAssets(), "fonts/oxygen-regular.ttf"));
        c2276a.f7825p.setTypeface(Typeface.createFromAsset(this.f7828a.getAssets(), "fonts/josefin_sans_regular.ttf"));
        c2276a.f7824o.setTypeface(Typeface.createFromAsset(this.f7828a.getAssets(), "fonts/josefin_sans-bold.ttf"));
        float f = (((float) b) / ((float) c)) * 100.0f;
        m12797a(b, c, f, c2276a);
        if (Float.isNaN(f)) {
            c2276a.f7824o.setText("0");
        } else {
            c2276a.f7824o.setText(" " + new BigDecimal(String.format("%.1f", new Object[]{Float.valueOf(f)})).stripTrailingZeros().toPlainString());
        }
        c2276a.f7826q.m5564a(C0932b.Right, null);
        c2276a.f7826q.m5564a(C0932b.Left, null);
    }

    public C2276a m12802c(ViewGroup viewGroup, int i) {
        return new C2276a(this.f7830c.inflate(R.layout.custom_main_row, viewGroup, false));
    }
}
