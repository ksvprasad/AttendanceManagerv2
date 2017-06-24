package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.p010b.C0195a;
import android.support.v7.widget.RecyclerView.C0801u;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.SwipeLayout.C0932b;
import com.daimajia.swipe.SwipeLayout.C0935e;
import com.daimajia.swipe.p026a.C0943a;
import com.daimajia.swipe.p027b.C0950b;
import dotinc.attendancemanager2.ExtraClassActivity;
import dotinc.attendancemanager2.GoToDateActivity;
import dotinc.attendancemanager2.MainActivity;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p045c.C2311a;
import dotinc.attendancemanager2.p045c.C2313c;
import java.math.BigDecimal;
import java.util.ArrayList;

public class C2274c extends C0943a<C2273a> {
    protected C0950b f7807b;
    private Context f7808c;
    private ArrayList<C2313c> f7809d;
    private ArrayList<C2311a> f7810e;
    private LayoutInflater f7811f;
    private C2256a f7812g;
    private C2259c f7813h;
    private C2311a f7814i = new C2311a();
    private String f7815j;
    private C2313c f7816k;
    private String f7817l;
    private int f7818m;
    private int f7819n;

    static class C2273a extends C0801u {
        private TextView f7796l;
        private TextView f7797m;
        private TextView f7798n;
        private TextView f7799o;
        private TextView f7800p;
        private SwipeLayout f7801q;
        private TextView f7802r;
        private TextView f7803s;
        private TextView f7804t;
        private TextView f7805u;
        private ImageView f7806v;

        public C2273a(View view) {
            super(view);
            this.f7796l = (TextView) view.findViewById(R.id.subject_name);
            this.f7797m = (TextView) view.findViewById(R.id.attended);
            this.f7798n = (TextView) view.findViewById(R.id.total);
            this.f7799o = (TextView) view.findViewById(R.id.sub_perc);
            this.f7800p = (TextView) view.findViewById(R.id.sub_detail);
            this.f7801q = (SwipeLayout) view.findViewById(R.id.swipe);
            this.f7802r = (TextView) view.findViewById(R.id.attended_class);
            this.f7803s = (TextView) view.findViewById(R.id.bunk_class);
            this.f7804t = (TextView) view.findViewById(R.id.no_class);
            this.f7805u = (TextView) view.findViewById(R.id.reset_attendance);
            this.f7806v = (ImageView) view.findViewById(R.id.check_mark);
        }
    }

    public C2274c(Context context, ArrayList<C2313c> arrayList, String str, String str2) {
        this.f7808c = context;
        this.f7809d = arrayList;
        this.f7815j = str;
        this.f7817l = str2;
        this.f7811f = LayoutInflater.from(context);
        this.f7812g = new C2256a(context);
        this.f7813h = new C2259c(context);
        this.f7810e = new ArrayList();
        this.f7816k = new C2313c();
        this.f7819n = 2;
        this.f7818m = Integer.parseInt(C2258b.m12720b(context, "ATTENDANCE_CRITERIA", String.valueOf(0)));
        this.f7807b = new C0950b(this);
    }

    private int m12772a(int i, int i2, float f) {
        int i3 = 0;
        while (f > ((float) this.f7818m)) {
            i2++;
            i3++;
            f = (((float) i) / ((float) i2)) * 100.0f;
        }
        return i3 - 1;
    }

    private void m12775a(int i, int i2, float f, C2273a c2273a) {
        int i3;
        int i4;
        int parseInt = Integer.parseInt(C2258b.m12720b(this.f7808c, "BREAK", String.valueOf(0)));
        if (this.f7818m == 100) {
            this.f7818m = 99;
        }
        if (f >= ((float) this.f7818m)) {
            c2273a.f7799o.setTextColor(C0195a.m1227c(this.f7808c, R.color.attendedColor));
            if (parseInt == 1) {
                parseInt = m12772a(i, i2, f);
                if (parseInt == 0) {
                    i3 = 5;
                    i4 = i;
                } else {
                    i3 = 4;
                    i4 = i;
                }
            } else {
                parseInt = 0;
                i3 = 1;
                i4 = i;
            }
        } else if (i == 0 && i2 == 0) {
            i3 = 2;
            i4 = i;
            parseInt = 0;
        } else {
            parseInt = 0;
            i3 = 0;
            i4 = i;
        }
        while (f < ((float) this.f7818m)) {
            i3 = 3;
            i4++;
            i2++;
            c2273a.f7799o.setTextColor(C0195a.m1227c(this.f7808c, R.color.absentColor));
            f = (((float) i4) / ((float) i2)) * 100.0f;
        }
        switch (i3) {
            case 1:
                c2273a.f7800p.setVisibility(0);
                c2273a.f7799o.setTextColor(C0195a.m1227c(this.f7808c, R.color.attendedColor));
                c2273a.f7800p.setText(this.f7808c.getResources().getString(R.string.on_track_message));
                return;
            case 2:
                c2273a.f7800p.setVisibility(4);
                return;
            case 3:
                c2273a.f7800p.setVisibility(0);
                parseInt = i4 - i;
                if (parseInt == 1) {
                    c2273a.f7800p.setText(Html.fromHtml("Attend next <b><font color='#E57373'>" + parseInt + "</font></b> class"));
                    return;
                } else {
                    c2273a.f7800p.setText(Html.fromHtml("Attend next <b><font color='#E57373'>" + parseInt + "</font></b> classes"));
                    return;
                }
            case 4:
                if (parseInt >= 1) {
                    c2273a.f7800p.setText(Html.fromHtml("You have <b><font color='#8BC34A'>" + parseInt + "</font></b> Bunks"));
                    return;
                }
                return;
            case 5:
                c2273a.f7800p.setText("You have no free bunks");
                return;
            default:
                return;
        }
    }

    private void m12776a(int i, int i2, String str) {
        this.f7814i.m12877b(((C2313c) this.f7809d.get(i2)).m12892b());
        this.f7814i.m12874a(i2);
        this.f7814i.m12879c(i);
        this.f7814i.m12875a(this.f7815j);
        this.f7810e.add(this.f7814i);
        this.f7812g.m12704a(this.f7814i);
        m4399c();
        this.f7807b.m5596a();
        m12780a(str);
    }

    private void m12777a(int i, C2273a c2273a, int i2) {
        this.f7812g.m12703a(i, this.f7815j, i2);
        m4399c();
        this.f7807b.m5596a();
        m12780a(this.f7808c.getResources().getString(R.string.reset_attendance));
    }

    private void m12780a(String str) {
        if (this.f7817l.equals("MainActivity")) {
            ((MainActivity) this.f7808c).m12582a(str);
            ((MainActivity) this.f7808c).m12584l();
        } else if (this.f7817l.equals("ExtraClassActivity")) {
            ((ExtraClassActivity) this.f7808c).m12529a(str);
        } else {
            ((GoToDateActivity) this.f7808c).m12550a(str);
        }
    }

    public int mo1796a() {
        return this.f7809d.size();
    }

    public /* synthetic */ C0801u mo1797a(ViewGroup viewGroup, int i) {
        return m12787c(viewGroup, i);
    }

    public void m12786a(final C2273a c2273a, final int i) {
        final int b = ((C2313c) this.f7809d.get(i)).m12892b();
        this.f7816k.m12893b(b);
        this.f7814i.m12875a(this.f7815j);
        this.f7819n = this.f7812g.m12700a(this.f7815j, i, b);
        if (this.f7819n == 1) {
            c2273a.f7806v.setImageResource(R.mipmap.ic_action_checked_done);
            c2273a.f7806v.setColorFilter(C0195a.m1227c(this.f7808c, R.color.attendedColor));
        } else if (this.f7819n == 0) {
            c2273a.f7806v.setImageResource(R.mipmap.ic_action_navigation_cancel);
            c2273a.f7806v.setColorFilter(C0195a.m1227c(this.f7808c, R.color.absentColor));
        } else if (this.f7819n == -1) {
            c2273a.f7806v.setImageResource(R.mipmap.ic_action_content_remove_circle);
            c2273a.f7806v.setColorFilter(C0195a.m1227c(this.f7808c, R.color.noClassColor));
        } else {
            c2273a.f7806v.setImageResource(R.mipmap.ic_check_circle_black_36dp);
            c2273a.f7806v.setColorFilter(C0195a.m1227c(this.f7808c, R.color.backgroundColor));
        }
        this.f7819n = 2;
        int b2 = this.f7813h.m12732b(b) + this.f7812g.m12706b(b);
        int a = this.f7813h.m12726a(b) + this.f7812g.m12709c(b);
        Log.d("option_attended_main", String.valueOf(b2));
        float f = 100.0f * (((float) b2) / ((float) a));
        m12775a(b2, a, f, c2273a);
        c2273a.f7801q.setShowMode(C0935e.PullOut);
        c2273a.f7801q.m5564a(C0932b.Right, c2273a.f7801q.findViewById(R.id.bottom_wrapper));
        c2273a.f7801q.m5564a(C0932b.Left, c2273a.f7801q.findViewById(R.id.bottom_wrapper1));
        this.f7807b.m5600a(c2273a.a, i);
        c2273a.f7796l.setText(((C2313c) this.f7809d.get(i)).m12894c());
        c2273a.f7796l.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/oxygen-bold.ttf"));
        c2273a.f7797m.setText(this.f7808c.getResources().getString(R.string.attended) + ": " + b2);
        c2273a.f7797m.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/oxygen-regular.ttf"));
        c2273a.f7798n.setText(this.f7808c.getResources().getString(R.string.total) + ": " + a);
        c2273a.f7798n.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/oxygen-regular.ttf"));
        c2273a.f7800p.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/josefin_sans_regular.ttf"));
        c2273a.f7799o.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/josefin_sans-bold.ttf"));
        c2273a.f7802r.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/josefin_sans_regular.ttf"));
        c2273a.f7803s.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/josefin_sans_regular.ttf"));
        c2273a.f7804t.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/josefin_sans_regular.ttf"));
        c2273a.f7805u.setTypeface(Typeface.createFromAsset(this.f7808c.getAssets(), "fonts/josefin_sans_regular.ttf"));
        if (Float.isNaN(f)) {
            c2273a.f7799o.setText("0");
        } else {
            c2273a.f7799o.setText(" " + new BigDecimal(String.format("%.1f", new Object[]{Float.valueOf(f)})).stripTrailingZeros().toPlainString());
        }
        c2273a.f7802r.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2274c f7786c;

            public void onClick(View view) {
                this.f7786c.m12776a(1, i, "Attended " + ((C2313c) this.f7786c.f7809d.get(i)).m12894c() + " class");
                this.f7786c.f7819n = this.f7786c.f7812g.m12700a(this.f7786c.f7815j, i, b);
            }
        });
        c2273a.f7803s.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2274c f7789c;

            public void onClick(View view) {
                this.f7789c.m12776a(0, i, "Bunked " + ((C2313c) this.f7789c.f7809d.get(i)).m12894c() + " class");
                this.f7789c.f7819n = this.f7789c.f7812g.m12700a(this.f7789c.f7815j, i, b);
            }
        });
        c2273a.f7804t.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2274c f7791b;

            public void onClick(View view) {
                this.f7791b.m12776a(-1, i, "No " + ((C2313c) this.f7791b.f7809d.get(i)).m12894c() + " class");
            }
        });
        c2273a.f7805u.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2274c f7795d;

            public void onClick(View view) {
                this.f7795d.m12777a(b, c2273a, i);
            }
        });
    }

    public int a_(int i) {
        return R.id.swipe;
    }

    public C2273a m12787c(ViewGroup viewGroup, int i) {
        return new C2273a(this.f7811f.inflate(R.layout.custom_main_row, viewGroup, false));
    }
}
