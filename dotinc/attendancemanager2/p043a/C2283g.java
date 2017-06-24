package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.RecyclerView.C0801u;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import dotinc.attendancemanager2.R;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.p045c.C2312b;
import java.util.ArrayList;

public class C2283g extends C0778a<C2282a> {
    private Context f7853a;
    private ArrayList<C2312b> f7854b;
    private ArrayList<C2312b> f7855c;
    private boolean[] f7856d;
    private C2259c f7857e;

    class C2282a extends C0801u {
        EditText f7848l;
        EditText f7849m;
        TextView f7850n;
        TextView f7851o;
        final /* synthetic */ C2283g f7852p;

        public C2282a(C2283g c2283g, View view) {
            this.f7852p = c2283g;
            super(view);
            Log.d("option_prev", "holder");
            this.f7848l = (EditText) view.findViewById(R.id.prev_attended);
            this.f7848l.setTypeface(Typeface.createFromAsset(c2283g.f7853a.getAssets(), "fonts/oxygen-regular.ttf"));
            this.f7849m = (EditText) view.findViewById(R.id.prev_total);
            this.f7849m.setTypeface(Typeface.createFromAsset(c2283g.f7853a.getAssets(), "fonts/oxygen-regular.ttf"));
            this.f7850n = (TextView) view.findViewById(R.id.subject_name);
            this.f7850n.setTypeface(Typeface.createFromAsset(c2283g.f7853a.getAssets(), "fonts/oxygen-bold.ttf"));
            this.f7851o = (TextView) view.findViewById(R.id.errorText);
            this.f7851o.setTypeface(Typeface.createFromAsset(c2283g.f7853a.getAssets(), "fonts/josefin_sans_regular.ttf"));
        }
    }

    public C2283g(Context context, ArrayList<C2312b> arrayList) {
        Log.d("option_prev", "cons");
        this.f7853a = context;
        this.f7854b = arrayList;
        this.f7855c = arrayList;
        this.f7856d = new boolean[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            this.f7856d[i] = true;
        }
        this.f7857e = new C2259c(context);
    }

    public int mo1796a() {
        return this.f7854b.size();
    }

    public /* synthetic */ C0801u mo1797a(ViewGroup viewGroup, int i) {
        return m12816c(viewGroup, i);
    }

    public void m12815a(final C2282a c2282a, final int i) {
        c2282a.f7850n.setText(((C2312b) this.f7854b.get(i)).m12888d());
        c2282a.f7848l.setText("" + ((C2312b) this.f7854b.get(i)).m12884b());
        c2282a.f7849m.setText("" + ((C2312b) this.f7854b.get(i)).m12881a());
        c2282a.f7848l.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ C2283g f7844c;

            public void afterTextChanged(Editable editable) {
                Log.d("options", editable.toString() + "" + i);
                C2312b c2312b = (C2312b) this.f7844c.f7855c.get(i);
                String obj = editable.toString();
                if (obj.equals("")) {
                    c2282a.f7851o.setVisibility(8);
                    this.f7844c.f7856d[i] = false;
                } else if (obj.startsWith("0")) {
                    c2282a.f7851o.setVisibility(0);
                    c2282a.f7851o.setText("Number cannot start with 0");
                    this.f7844c.f7856d[i] = false;
                } else {
                    int parseInt = Integer.parseInt(obj);
                    Log.d("option_attended_past_e", String.valueOf(parseInt));
                    if (parseInt > c2312b.m12881a()) {
                        c2282a.f7851o.setVisibility(0);
                        ((C2312b) this.f7844c.f7855c.get(i)).m12885b(parseInt);
                        c2282a.f7851o.setText("Attended cannot be greater than total");
                        this.f7844c.f7856d[i] = false;
                        return;
                    }
                    ((C2312b) this.f7844c.f7855c.get(i)).m12885b(parseInt);
                    c2282a.f7851o.setVisibility(8);
                    this.f7844c.f7856d[i] = true;
                    Log.d("option_attended_past_ef", String.valueOf(((C2312b) this.f7844c.f7855c.get(i)).m12884b()));
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        c2282a.f7849m.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ C2283g f7847c;

            public void afterTextChanged(Editable editable) {
                Log.d("options", editable.toString() + "" + i);
                C2312b c2312b = (C2312b) this.f7847c.f7855c.get(i);
                String obj = editable.toString();
                if (obj.equals("")) {
                    c2282a.f7851o.setVisibility(8);
                    this.f7847c.f7856d[i] = false;
                    return;
                }
                int parseInt = Integer.parseInt(obj);
                if (obj.startsWith("0")) {
                    c2282a.f7851o.setVisibility(0);
                    c2282a.f7851o.setText("Number cannot start with 0");
                    this.f7847c.f7856d[i] = false;
                } else if (parseInt >= c2312b.m12884b()) {
                    ((C2312b) this.f7847c.f7855c.get(i)).m12882a(parseInt);
                    c2282a.f7851o.setVisibility(8);
                    this.f7847c.f7856d[i] = true;
                } else {
                    c2282a.f7851o.setVisibility(0);
                    c2282a.f7851o.setText("Total can't be less than attended");
                    this.f7847c.f7856d[i] = false;
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    public C2282a m12816c(ViewGroup viewGroup, int i) {
        Log.d("option_prev", "view");
        return new C2282a(this, LayoutInflater.from(this.f7853a).inflate(R.layout.custom_prev_attendance, viewGroup, false));
    }

    public boolean m12817d() {
        for (int i = 0; i < this.f7854b.size(); i++) {
            ((C2312b) this.f7854b.get(i)).m12885b(0);
            ((C2312b) this.f7854b.get(i)).m12882a(0);
        }
        this.f7857e.m12731a(this.f7854b);
        return true;
    }

    public ArrayList<C2312b> m12818e() {
        Object obj = null;
        for (int i = 0; i < this.f7854b.size(); i++) {
            if (!this.f7856d[i]) {
                break;
            }
        }
        obj = 1;
        return obj == null ? null : this.f7855c;
    }
}
