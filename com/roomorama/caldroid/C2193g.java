package com.roomorama.caldroid;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.p024a.C0916a.C0913c;
import java.util.List;

public class C2193g extends ArrayAdapter<String> {
    LayoutInflater f7394a;

    public C2193g(Context context, int i, List<String> list, int i2) {
        super(context, i, list);
        this.f7394a = m12502a(getContext(), i2);
    }

    private LayoutInflater m12502a(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).cloneInContext(new ContextThemeWrapper(context, i));
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) this.f7394a.inflate(C0913c.weekday_textview, null);
        textView.setText((String) getItem(i));
        return textView;
    }

    public boolean isEnabled(int i) {
        return false;
    }
}
