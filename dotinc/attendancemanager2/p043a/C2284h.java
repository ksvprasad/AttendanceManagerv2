package dotinc.attendancemanager2.p043a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import dotinc.attendancemanager2.R;
import java.util.ArrayList;

public class C2284h extends ArrayAdapter<String> {
    ArrayList<String> f7858a;
    ArrayList<Integer> f7859b;
    Context f7860c;

    public C2284h(Context context, ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        super(context, R.layout.settings_single_row, R.id.options, arrayList);
        this.f7858a = arrayList;
        this.f7860c = context;
        this.f7859b = arrayList2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f7860c.getSystemService("layout_inflater")).inflate(R.layout.settings_single_row, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.options);
        ImageView imageView = (ImageView) view.findViewById(R.id.sett_icon);
        textView.setText("" + ((String) this.f7858a.get(i)));
        textView.setTypeface(Typeface.createFromAsset(this.f7860c.getAssets(), "fonts/oxygen-regular.ttf"));
        imageView.setImageResource(((Integer) this.f7859b.get(i)).intValue());
        return view;
    }
}
