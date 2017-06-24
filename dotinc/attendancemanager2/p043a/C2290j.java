package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.p018a.C0632c.C0629a;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.SwipeLayout.C0932b;
import com.daimajia.swipe.SwipeLayout.C0935e;
import com.daimajia.swipe.p026a.C0943a;
import com.daimajia.swipe.p027b.C0950b;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.SubjectsActivity;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;

public class C2290j extends C0943a<C2289a> {
    protected C0950b f7872b = new C0950b(this);
    private Context f7873c;
    private ArrayList<C2312b> f7874d;
    private LayoutInflater f7875e;
    private C2259c f7876f;
    private EditText f7877g;
    private C2260d f7878h;
    private C2256a f7879i;

    static class C2289a extends C0801u {
        private TextView f7868l;
        private SwipeLayout f7869m;
        private ImageButton f7870n;
        private ImageButton f7871o;

        public C2289a(View view) {
            super(view);
            this.f7868l = (TextView) view.findViewById(R.id.subject);
            this.f7869m = (SwipeLayout) view.findViewById(R.id.swipe);
            this.f7870n = (ImageButton) view.findViewById(R.id.edit);
            this.f7871o = (ImageButton) view.findViewById(R.id.delete_subject);
        }
    }

    public C2290j(Context context, ArrayList<C2312b> arrayList) {
        this.f7873c = context;
        this.f7874d = arrayList;
        this.f7875e = LayoutInflater.from(context);
        this.f7876f = new C2259c(context);
        this.f7878h = new C2260d(context);
        this.f7879i = new C2256a(context);
    }

    public int mo1796a() {
        return this.f7874d.size();
    }

    public /* synthetic */ C0801u mo1797a(ViewGroup viewGroup, int i) {
        return m12837c(viewGroup, i);
    }

    public void m12836a(C2289a c2289a, final int i) {
        c2289a.f7868l.setText(((C2312b) this.f7874d.get(i)).m12888d());
        c2289a.f7868l.setTypeface(Typeface.createFromAsset(this.f7873c.getAssets(), "fonts/josefin_sans-bold.ttf"));
        c2289a.f7869m.setShowMode(C0935e.PullOut);
        c2289a.f7869m.m5564a(C0932b.Left, c2289a.f7869m.findViewById(R.id.right_swipe));
        c2289a.f7869m.m5564a(C0932b.Right, c2289a.f7869m.findViewById(R.id.left_swipe));
        this.f7872b.m5600a(c2289a.a, i);
        c2289a.f7871o.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2290j f7863b;

            public void onClick(View view) {
                this.f7863b.f7876f.m12729a(((C2312b) this.f7863b.f7874d.get(i)).m12888d());
                this.f7863b.f7878h.m12739a(((C2312b) this.f7863b.f7874d.get(i)).m12886c());
                this.f7863b.f7879i.m12712d(((C2312b) this.f7863b.f7874d.get(i)).m12886c());
                this.f7863b.f7874d.remove(i);
                ((SubjectsActivity) this.f7863b.f7873c).m12687b(this.f7863b.f7874d.size());
                this.f7863b.m4400c(i);
                this.f7863b.m4386a(i, this.f7863b.f7874d.size());
                this.f7863b.f7872b.m5596a();
            }
        });
        c2289a.f7870n.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ C2290j f7867b;

            public void onClick(View view) {
                C0629a c0629a = new C0629a(this.f7867b.f7873c);
                View inflate = this.f7867b.f7875e.inflate(R.layout.add_subject, null);
                this.f7867b.f7877g = (EditText) inflate.findViewById(R.id.subject_name);
                this.f7867b.f7877g.setTypeface(Typeface.createFromAsset(this.f7867b.f7873c.getAssets(), "fonts/josefin_sans-bold.ttf"));
                this.f7867b.f7877g.setText(((C2312b) this.f7867b.f7874d.get(i)).m12888d());
                final String d = ((C2312b) this.f7867b.f7874d.get(i)).m12888d();
                c0629a.m3311b(inflate);
                c0629a.m3309a(this.f7867b.f7873c.getResources().getString(R.string.option_ok), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ C22882 f7865b;

                    public void onClick(DialogInterface dialogInterface, int i) {
                        String trim = this.f7865b.f7867b.f7877g.getText().toString().trim();
                        if (((SubjectsActivity) this.f7865b.f7867b.f7873c).m12686a(trim) == 0) {
                            this.f7865b.f7867b.f7876f.m12730a(trim, d);
                            this.f7865b.f7867b.f7878h.m12741a(trim, d);
                            this.f7865b.f7867b.f7874d.clear();
                            this.f7865b.f7867b.f7874d.addAll(this.f7865b.f7867b.f7876f.m12727a());
                            this.f7865b.f7867b.m4399c();
                            this.f7865b.f7867b.f7872b.m5596a();
                            return;
                        }
                        ((SubjectsActivity) this.f7865b.f7867b.f7873c).m12688b(this.f7865b.f7867b.f7873c.getResources().getString(R.string.subject_entry_same));
                        this.f7865b.f7867b.f7872b.m5596a();
                    }
                });
                c0629a.m3314b().show();
            }
        });
    }

    public int a_(int i) {
        return R.id.swipe;
    }

    public C2289a m12837c(ViewGroup viewGroup, int i) {
        return new C2289a(this.f7875e.inflate(R.layout.custom_subjects, viewGroup, false));
    }
}
