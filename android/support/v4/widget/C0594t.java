package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class C0594t extends C0570f {
    private int f1401j;
    private int f1402k;
    private LayoutInflater f1403l;

    public C0594t(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1402k = i;
        this.f1401j = i;
        this.f1403l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View mo492a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1403l.inflate(this.f1401j, viewGroup, false);
    }

    public View mo493b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1403l.inflate(this.f1402k, viewGroup, false);
    }
}
