package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView.C0778a;
import android.support.v7.widget.RecyclerView.C0801u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import dotinc.attendancemanager2.R;
import java.util.ArrayList;

public class C2268b extends C0778a<C0801u> {
    private Context f7780a;
    private ArrayList<String> f7781b;
    private ArrayList<String> f7782c;
    private LayoutInflater f7783d;

    static class C2267a extends C0801u {
        TextView f7778l;
        TextView f7779m;

        public C2267a(View view) {
            super(view);
            this.f7778l = (TextView) view.findViewById(R.id.topic);
            this.f7779m = (TextView) view.findViewById(R.id.description);
        }
    }

    public C2268b(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.f7780a = context;
        this.f7781b = arrayList;
        this.f7782c = arrayList2;
        this.f7783d = LayoutInflater.from(context);
    }

    public int mo1796a() {
        return this.f7781b.size();
    }

    public C0801u mo1797a(ViewGroup viewGroup, int i) {
        return new C2267a(this.f7783d.inflate(R.layout.custom_helper, viewGroup, false));
    }

    public void mo1798a(C0801u c0801u, int i) {
        C2267a c2267a = (C2267a) c0801u;
        c2267a.f7778l.setText((CharSequence) this.f7781b.get(i));
        c2267a.f7778l.setTypeface(Typeface.createFromAsset(this.f7780a.getAssets(), "fonts/oxygen-bold.ttf"));
        c2267a.f7779m.setText((CharSequence) this.f7782c.get(i));
        c2267a.f7779m.setTypeface(Typeface.createFromAsset(this.f7780a.getAssets(), "fonts/josefin_sans_regular.ttf"));
    }
}
