package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import dotinc.attendancemanager2.R;
import java.util.ArrayList;

public class C2266a extends ArrayAdapter<String> {
    private Context f7775a;
    private ArrayList<String> f7776b;
    private LayoutInflater f7777c = ((LayoutInflater) this.f7775a.getSystemService("layout_inflater"));

    public C2266a(Context context, ArrayList<String> arrayList) {
        super(context, R.layout.spinner_row, arrayList);
        this.f7775a = context;
        this.f7776b = arrayList;
    }

    public View m12757a(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f7777c.inflate(R.layout.spinner_row, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tvCategory)).setText(((String) this.f7776b.get(i)).toString());
        return inflate;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return m12757a(i, view, viewGroup);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return m12757a(i, view, viewGroup);
    }
}
