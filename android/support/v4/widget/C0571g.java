package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class C0571g extends Filter {
    C0569a f1393a;

    interface C0569a {
        Cursor mo473a();

        Cursor mo474a(CharSequence charSequence);

        void mo475a(Cursor cursor);

        CharSequence mo476c(Cursor cursor);
    }

    C0571g(C0569a c0569a) {
        this.f1393a = c0569a;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f1393a.mo476c((Cursor) obj);
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        Cursor a = this.f1393a.mo474a(charSequence);
        FilterResults filterResults = new FilterResults();
        if (a != null) {
            filterResults.count = a.getCount();
            filterResults.values = a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor a = this.f1393a.mo473a();
        if (filterResults.values != null && filterResults.values != a) {
            this.f1393a.mo475a((Cursor) filterResults.values);
        }
    }
}
