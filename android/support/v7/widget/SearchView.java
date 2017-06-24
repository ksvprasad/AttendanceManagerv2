package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.widget.C0570f;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0686d;
import android.support.v7.view.C0705c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends ao implements C0705c {
    static final C0804a f2210a = new C0804a();
    private static final boolean f2211b = (VERSION.SDK_INT >= 8);
    private boolean f2212A;
    private boolean f2213B;
    private int f2214C;
    private boolean f2215D;
    private CharSequence f2216E;
    private boolean f2217F;
    private int f2218G;
    private SearchableInfo f2219H;
    private Bundle f2220I;
    private Runnable f2221J;
    private final Runnable f2222K;
    private Runnable f2223L;
    private final WeakHashMap<String, ConstantState> f2224M;
    private final SearchAutoComplete f2225c;
    private final View f2226d;
    private final View f2227e;
    private final ImageView f2228f;
    private final ImageView f2229g;
    private final ImageView f2230h;
    private final ImageView f2231i;
    private final ImageView f2232j;
    private final Drawable f2233k;
    private final int f2234l;
    private final int f2235m;
    private final Intent f2236n;
    private final Intent f2237o;
    private final CharSequence f2238p;
    private C0806c f2239q;
    private C0805b f2240r;
    private OnFocusChangeListener f2241s;
    private C0807d f2242t;
    private OnClickListener f2243u;
    private boolean f2244v;
    private boolean f2245w;
    private C0570f f2246x;
    private boolean f2247y;
    private CharSequence f2248z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C08021();
        boolean f2199a;

        static class C08021 implements Creator<SavedState> {
            C08021() {
            }

            public SavedState m4598a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m4599a(int i) {
                return new SavedState[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4598a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4599a(i);
            }
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2199a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2199a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f2199a));
        }
    }

    public static class SearchAutoComplete extends C0803g {
        private int f2204a;
        private SearchView f2205b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0683a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2204a = getThreshold();
        }

        public boolean enoughToFilter() {
            return this.f2204a <= 0 || super.enoughToFilter();
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f2205b.m4630d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2205b.clearFocus();
                        this.f2205b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f2205b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m4609a(getContext())) {
                    SearchView.f2210a.m4601a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f2205b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f2204a = i;
        }
    }

    private static class C0804a {
        private Method f2206a;
        private Method f2207b;
        private Method f2208c;
        private Method f2209d;

        C0804a() {
            try {
                this.f2206a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2206a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f2207b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2207b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f2208c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f2208c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f2209d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f2209d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m4600a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f2206a != null) {
                try {
                    this.f2206a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m4601a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f2208c != null) {
                try {
                    this.f2208c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        void m4602b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f2207b != null) {
                try {
                    this.f2207b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

    public interface C0805b {
        boolean m4603a();
    }

    public interface C0806c {
        boolean m4604a(String str);
    }

    public interface C0807d {
    }

    private Intent m4605a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2216E);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f2220I != null) {
            intent.putExtra("app_data", this.f2220I);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f2211b) {
            intent.setComponent(this.f2219H.getSearchActivity());
        }
        return intent;
    }

    private void m4606a(int i, String str, String str2) {
        getContext().startActivity(m4605a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private void m4608a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f2245w = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f2225c.getText());
        this.f2228f.setVisibility(i2);
        m4611b(z3);
        this.f2226d.setVisibility(z ? 8 : 0);
        if (!(this.f2232j.getDrawable() == null || this.f2244v)) {
            i = 0;
        }
        this.f2232j.setVisibility(i);
        m4616h();
        if (z3) {
            z2 = false;
        }
        m4612c(z2);
        m4615g();
    }

    static boolean m4609a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence m4610b(CharSequence charSequence) {
        if (!this.f2244v || this.f2233k == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f2225c.getTextSize()) * 1.25d);
        this.f2233k.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f2233k), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m4611b(boolean z) {
        int i = 8;
        if (this.f2247y && m4614f() && hasFocus() && (z || !this.f2215D)) {
            i = 0;
        }
        this.f2229g.setVisibility(i);
    }

    private void m4612c(boolean z) {
        int i;
        if (this.f2215D && !m4629c() && z) {
            i = 0;
            this.f2229g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f2231i.setVisibility(i);
    }

    @TargetApi(8)
    private boolean m4613e() {
        if (this.f2219H == null || !this.f2219H.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f2219H.getVoiceSearchLaunchWebSearch()) {
            intent = this.f2236n;
        } else if (this.f2219H.getVoiceSearchLaunchRecognizer()) {
            intent = this.f2237o;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean m4614f() {
        return (this.f2247y || this.f2215D) && !m4629c();
    }

    private void m4615g() {
        int i = 8;
        if (m4614f() && (this.f2229g.getVisibility() == 0 || this.f2231i.getVisibility() == 0)) {
            i = 0;
        }
        this.f2227e.setVisibility(i);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0686d.abc_search_view_preferred_width);
    }

    private void m4616h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f2225c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f2244v || this.f2217F)) {
            i = 0;
        }
        ImageView imageView = this.f2230h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f2230h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m4617i() {
        post(this.f2222K);
    }

    private void m4618k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2225c;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m4610b(queryHint));
    }

    @TargetApi(8)
    private void m4619l() {
        int i = 1;
        this.f2225c.setThreshold(this.f2219H.getSuggestThreshold());
        this.f2225c.setImeOptions(this.f2219H.getImeOptions());
        int inputType = this.f2219H.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f2219H.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f2225c.setInputType(inputType);
        if (this.f2246x != null) {
            this.f2246x.mo475a(null);
        }
        if (this.f2219H.getSuggestAuthority() != null) {
            this.f2246x = new bb(getContext(), this, this.f2219H, this.f2224M);
            this.f2225c.setAdapter(this.f2246x);
            bb bbVar = (bb) this.f2246x;
            if (this.f2212A) {
                i = 2;
            }
            bbVar.m5195a(i);
        }
    }

    private void m4620m() {
        CharSequence text = this.f2225c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f2239q == null || !this.f2239q.m4604a(text.toString())) {
                if (this.f2219H != null) {
                    m4606a(0, null, text.toString());
                }
                setImeVisibility(false);
                m4621n();
            }
        }
    }

    private void m4621n() {
        this.f2225c.dismissDropDown();
    }

    private void m4622o() {
        if (!TextUtils.isEmpty(this.f2225c.getText())) {
            this.f2225c.setText("");
            this.f2225c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f2244v) {
        } else {
            if (this.f2240r == null || !this.f2240r.m4603a()) {
                clearFocus();
                m4608a(true);
            }
        }
    }

    private void m4623p() {
        m4608a(false);
        this.f2225c.requestFocus();
        setImeVisibility(true);
        if (this.f2243u != null) {
            this.f2243u.onClick(this);
        }
    }

    private void m4624q() {
        f2210a.m4600a(this.f2225c);
        f2210a.m4602b(this.f2225c);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f2221J);
            return;
        }
        removeCallbacks(this.f2221J);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f2225c.setText(charSequence);
        this.f2225c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void mo648a() {
        if (!this.f2217F) {
            this.f2217F = true;
            this.f2218G = this.f2225c.getImeOptions();
            this.f2225c.setImeOptions(this.f2218G | 33554432);
            this.f2225c.setText("");
            setIconified(false);
        }
    }

    void m4626a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void m4627a(CharSequence charSequence, boolean z) {
        this.f2225c.setText(charSequence);
        if (charSequence != null) {
            this.f2225c.setSelection(this.f2225c.length());
            this.f2216E = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m4620m();
        }
    }

    public void mo649b() {
        m4627a((CharSequence) "", false);
        clearFocus();
        m4608a(true);
        this.f2225c.setImeOptions(this.f2218G);
        this.f2217F = false;
    }

    public boolean m4629c() {
        return this.f2245w;
    }

    public void clearFocus() {
        this.f2213B = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f2225c.clearFocus();
        this.f2213B = false;
    }

    void m4630d() {
        m4608a(m4629c());
        m4617i();
        if (this.f2225c.hasFocus()) {
            m4624q();
        }
    }

    public int getImeOptions() {
        return this.f2225c.getImeOptions();
    }

    public int getInputType() {
        return this.f2225c.getInputType();
    }

    public int getMaxWidth() {
        return this.f2214C;
    }

    public CharSequence getQuery() {
        return this.f2225c.getText();
    }

    public CharSequence getQueryHint() {
        return this.f2248z != null ? this.f2248z : (!f2211b || this.f2219H == null || this.f2219H.getHintId() == 0) ? this.f2238p : getContext().getText(this.f2219H.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f2235m;
    }

    int getSuggestionRowLayout() {
        return this.f2234l;
    }

    public C0570f getSuggestionsAdapter() {
        return this.f2246x;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f2222K);
        post(this.f2223L);
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int i2) {
        if (m4629c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f2214C <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f2214C, size);
                    break;
                }
            case 0:
                if (this.f2214C <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f2214C;
                    break;
                }
            case 1073741824:
                if (this.f2214C > 0) {
                    size = Math.min(this.f2214C, size);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            m4608a(savedState.f2199a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2199a = m4629c();
        return savedState;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m4617i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f2213B || !isFocusable()) {
            return false;
        }
        if (m4629c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f2225c.requestFocus(i, rect);
        if (requestFocus) {
            m4608a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2220I = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m4622o();
        } else {
            m4623p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f2244v != z) {
            this.f2244v = z;
            m4608a(z);
            m4618k();
        }
    }

    public void setImeOptions(int i) {
        this.f2225c.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f2225c.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f2214C = i;
        requestLayout();
    }

    public void setOnCloseListener(C0805b c0805b) {
        this.f2240r = c0805b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f2241s = onFocusChangeListener;
    }

    public void setOnQueryTextListener(C0806c c0806c) {
        this.f2239q = c0806c;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f2243u = onClickListener;
    }

    public void setOnSuggestionListener(C0807d c0807d) {
        this.f2242t = c0807d;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2248z = charSequence;
        m4618k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f2212A = z;
        if (this.f2246x instanceof bb) {
            ((bb) this.f2246x).m5195a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2219H = searchableInfo;
        if (this.f2219H != null) {
            if (f2211b) {
                m4619l();
            }
            m4618k();
        }
        boolean z = f2211b && m4613e();
        this.f2215D = z;
        if (this.f2215D) {
            this.f2225c.setPrivateImeOptions("nm");
        }
        m4608a(m4629c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f2247y = z;
        m4608a(m4629c());
    }

    public void setSuggestionsAdapter(C0570f c0570f) {
        this.f2246x = c0570f;
        this.f2225c.setAdapter(this.f2246x);
    }
}
