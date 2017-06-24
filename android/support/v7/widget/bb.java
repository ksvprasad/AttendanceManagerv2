package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p010b.C0195a;
import android.support.v4.widget.C0594t;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0688f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class bb extends C0594t implements OnClickListener {
    private final SearchManager f2561j = ((SearchManager) this.d.getSystemService("search"));
    private final SearchView f2562k;
    private final SearchableInfo f2563l;
    private final Context f2564m;
    private final WeakHashMap<String, ConstantState> f2565n;
    private final int f2566o;
    private boolean f2567p = false;
    private int f2568q = 1;
    private ColorStateList f2569r;
    private int f2570s = -1;
    private int f2571t = -1;
    private int f2572u = -1;
    private int f2573v = -1;
    private int f2574w = -1;
    private int f2575x = -1;

    private static final class C0859a {
        public final TextView f2556a;
        public final TextView f2557b;
        public final ImageView f2558c;
        public final ImageView f2559d;
        public final ImageView f2560e;

        public C0859a(View view) {
            this.f2556a = (TextView) view.findViewById(16908308);
            this.f2557b = (TextView) view.findViewById(16908309);
            this.f2558c = (ImageView) view.findViewById(16908295);
            this.f2559d = (ImageView) view.findViewById(16908296);
            this.f2560e = (ImageView) view.findViewById(C0688f.edit_query);
        }
    }

    public bb(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2562k = searchView;
        this.f2563l = searchableInfo;
        this.f2566o = searchView.getSuggestionCommitIconResId();
        this.f2564m = context;
        this.f2565n = weakHashMap;
    }

    private Drawable m5176a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2565n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2565n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2564m.getResources());
        } else {
            Drawable b = m5183b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2565n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m5177a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2564m.getPackageName() + "/" + parseInt;
            b = m5185b(str2);
            if (b != null) {
                return b;
            }
            b = C0195a.m1224a(this.f2564m, parseInt);
            m5182a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m5185b(str);
            if (b != null) {
                return b;
            }
            b = m5184b(Uri.parse(str));
            m5182a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String m5178a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    public static String m5179a(Cursor cursor, String str) {
        return m5178a(cursor, cursor.getColumnIndex(str));
    }

    private void m5180a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void m5181a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m5182a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2565n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m5183b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable m5184b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m5193a(uri);
            }
            openInputStream = this.f2564m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m5185b(String str) {
        ConstantState constantState = (ConstantState) this.f2565n.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private CharSequence m5186b(CharSequence charSequence) {
        if (this.f2569r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0683a.textColorSearchUrl, typedValue, true);
            this.f2569r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2569r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m5187d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    private Drawable m5188e(Cursor cursor) {
        if (this.f2573v == -1) {
            return null;
        }
        Drawable a = m5177a(cursor.getString(this.f2573v));
        return a == null ? m5190g(cursor) : a;
    }

    private Drawable m5189f(Cursor cursor) {
        return this.f2574w == -1 ? null : m5177a(cursor.getString(this.f2574w));
    }

    private Drawable m5190g(Cursor cursor) {
        Drawable a = m5176a(this.f2563l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor m5191a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public Cursor mo474a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f2562k.getVisibility() != 0 || this.f2562k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m5191a(this.f2563l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    Drawable m5193a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public View mo492a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo492a(context, cursor, viewGroup);
        a.setTag(new C0859a(a));
        ((ImageView) a.findViewById(C0688f.edit_query)).setImageResource(this.f2566o);
        return a;
    }

    public void m5195a(int i) {
        this.f2568q = i;
    }

    public void mo475a(Cursor cursor) {
        if (this.f2567p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo475a(cursor);
            if (cursor != null) {
                this.f2570s = cursor.getColumnIndex("suggest_text_1");
                this.f2571t = cursor.getColumnIndex("suggest_text_2");
                this.f2572u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2573v = cursor.getColumnIndex("suggest_icon_1");
                this.f2574w = cursor.getColumnIndex("suggest_icon_2");
                this.f2575x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void mo821a(View view, Context context, Cursor cursor) {
        C0859a c0859a = (C0859a) view.getTag();
        int i = this.f2575x != -1 ? cursor.getInt(this.f2575x) : 0;
        if (c0859a.f2556a != null) {
            m5181a(c0859a.f2556a, m5178a(cursor, this.f2570s));
        }
        if (c0859a.f2557b != null) {
            CharSequence a = m5178a(cursor, this.f2572u);
            a = a != null ? m5186b(a) : m5178a(cursor, this.f2571t);
            if (TextUtils.isEmpty(a)) {
                if (c0859a.f2556a != null) {
                    c0859a.f2556a.setSingleLine(false);
                    c0859a.f2556a.setMaxLines(2);
                }
            } else if (c0859a.f2556a != null) {
                c0859a.f2556a.setSingleLine(true);
                c0859a.f2556a.setMaxLines(1);
            }
            m5181a(c0859a.f2557b, a);
        }
        if (c0859a.f2558c != null) {
            m5180a(c0859a.f2558c, m5188e(cursor), 4);
        }
        if (c0859a.f2559d != null) {
            m5180a(c0859a.f2559d, m5189f(cursor), 8);
        }
        if (this.f2568q == 2 || (this.f2568q == 1 && (i & 1) != 0)) {
            c0859a.f2560e.setVisibility(0);
            c0859a.f2560e.setTag(c0859a.f2556a.getText());
            c0859a.f2560e.setOnClickListener(this);
            return;
        }
        c0859a.f2560e.setVisibility(8);
    }

    public CharSequence mo476c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m5179a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2563l.shouldRewriteQueryFromData()) {
            a = m5179a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2563l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m5179a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo492a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0859a) a.getTag()).f2556a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m5187d(mo473a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m5187d(mo473a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2562k.m4626a((CharSequence) tag);
        }
    }
}
