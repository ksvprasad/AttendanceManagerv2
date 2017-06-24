package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0571g.C0569a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class C0570f extends BaseAdapter implements C0569a, Filterable {
    protected boolean f1384a;
    protected boolean f1385b;
    protected Cursor f1386c;
    protected Context f1387d;
    protected int f1388e;
    protected C0567a f1389f;
    protected DataSetObserver f1390g;
    protected C0571g f1391h;
    protected FilterQueryProvider f1392i;

    private class C0567a extends ContentObserver {
        final /* synthetic */ C0570f f1382a;

        public C0567a(C0570f c0570f) {
            this.f1382a = c0570f;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            this.f1382a.m3072b();
        }
    }

    private class C0568b extends DataSetObserver {
        final /* synthetic */ C0570f f1383a;

        private C0568b(C0570f c0570f) {
            this.f1383a = c0570f;
        }

        public void onChanged() {
            this.f1383a.f1384a = true;
            this.f1383a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f1383a.f1384a = false;
            this.f1383a.notifyDataSetInvalidated();
        }
    }

    public C0570f(Context context, Cursor cursor, boolean z) {
        m3067a(context, cursor, z ? 1 : 2);
    }

    public Cursor mo473a() {
        return this.f1386c;
    }

    public Cursor mo474a(CharSequence charSequence) {
        return this.f1392i != null ? this.f1392i.runQuery(charSequence) : this.f1386c;
    }

    public abstract View mo492a(Context context, Cursor cursor, ViewGroup viewGroup);

    void m3067a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f1385b = true;
        } else {
            this.f1385b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f1386c = cursor;
        this.f1384a = z;
        this.f1387d = context;
        this.f1388e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1389f = new C0567a(this);
            this.f1390g = new C0568b();
        } else {
            this.f1389f = null;
            this.f1390g = null;
        }
        if (z) {
            if (this.f1389f != null) {
                cursor.registerContentObserver(this.f1389f);
            }
            if (this.f1390g != null) {
                cursor.registerDataSetObserver(this.f1390g);
            }
        }
    }

    public void mo475a(Cursor cursor) {
        Cursor b = m3070b(cursor);
        if (b != null) {
            b.close();
        }
    }

    public abstract void mo821a(View view, Context context, Cursor cursor);

    public Cursor m3070b(Cursor cursor) {
        if (cursor == this.f1386c) {
            return null;
        }
        Cursor cursor2 = this.f1386c;
        if (cursor2 != null) {
            if (this.f1389f != null) {
                cursor2.unregisterContentObserver(this.f1389f);
            }
            if (this.f1390g != null) {
                cursor2.unregisterDataSetObserver(this.f1390g);
            }
        }
        this.f1386c = cursor;
        if (cursor != null) {
            if (this.f1389f != null) {
                cursor.registerContentObserver(this.f1389f);
            }
            if (this.f1390g != null) {
                cursor.registerDataSetObserver(this.f1390g);
            }
            this.f1388e = cursor.getColumnIndexOrThrow("_id");
            this.f1384a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f1388e = -1;
        this.f1384a = false;
        notifyDataSetInvalidated();
        return cursor2;
    }

    public View mo493b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo492a(context, cursor, viewGroup);
    }

    protected void m3072b() {
        if (this.f1385b && this.f1386c != null && !this.f1386c.isClosed()) {
            this.f1384a = this.f1386c.requery();
        }
    }

    public CharSequence mo476c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public int getCount() {
        return (!this.f1384a || this.f1386c == null) ? 0 : this.f1386c.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1384a) {
            return null;
        }
        this.f1386c.moveToPosition(i);
        if (view == null) {
            view = mo493b(this.f1387d, this.f1386c, viewGroup);
        }
        mo821a(view, this.f1387d, this.f1386c);
        return view;
    }

    public Filter getFilter() {
        if (this.f1391h == null) {
            this.f1391h = new C0571g(this);
        }
        return this.f1391h;
    }

    public Object getItem(int i) {
        if (!this.f1384a || this.f1386c == null) {
            return null;
        }
        this.f1386c.moveToPosition(i);
        return this.f1386c;
    }

    public long getItemId(int i) {
        return (this.f1384a && this.f1386c != null && this.f1386c.moveToPosition(i)) ? this.f1386c.getLong(this.f1388e) : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1384a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f1386c.moveToPosition(i)) {
            if (view == null) {
                view = mo492a(this.f1387d, this.f1386c, viewGroup);
            }
            mo821a(view, this.f1387d, this.f1386c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
