package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0690h;
import android.support.v7.p019b.C0694a.C0693k;
import android.support.v7.view.menu.C0052m.C0050a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0050a {
    private C0730h f1788a;
    private ImageView f1789b;
    private RadioButton f1790c;
    private TextView f1791d;
    private CheckBox f1792e;
    private TextView f1793f;
    private Drawable f1794g;
    private int f1795h;
    private Context f1796i;
    private boolean f1797j;
    private int f1798k;
    private Context f1799l;
    private LayoutInflater f1800m;
    private boolean f1801n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f1799l = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0693k.MenuView, i, 0);
        this.f1794g = obtainStyledAttributes.getDrawable(C0693k.MenuView_android_itemBackground);
        this.f1795h = obtainStyledAttributes.getResourceId(C0693k.MenuView_android_itemTextAppearance, -1);
        this.f1797j = obtainStyledAttributes.getBoolean(C0693k.MenuView_preserveIconSpacing, false);
        this.f1796i = context;
        obtainStyledAttributes.recycle();
    }

    private void m3743b() {
        this.f1789b = (ImageView) getInflater().inflate(C0690h.abc_list_menu_item_icon, this, false);
        addView(this.f1789b, 0);
    }

    private void m3744c() {
        this.f1790c = (RadioButton) getInflater().inflate(C0690h.abc_list_menu_item_radio, this, false);
        addView(this.f1790c);
    }

    private void m3745d() {
        this.f1792e = (CheckBox) getInflater().inflate(C0690h.abc_list_menu_item_checkbox, this, false);
        addView(this.f1792e);
    }

    private LayoutInflater getInflater() {
        if (this.f1800m == null) {
            this.f1800m = LayoutInflater.from(this.f1799l);
        }
        return this.f1800m;
    }

    public void mo27a(C0730h c0730h, int i) {
        this.f1788a = c0730h;
        this.f1798k = i;
        setVisibility(c0730h.isVisible() ? 0 : 8);
        setTitle(c0730h.m3861a((C0050a) this));
        setCheckable(c0730h.isCheckable());
        m3747a(c0730h.m3874f(), c0730h.m3870d());
        setIcon(c0730h.getIcon());
        setEnabled(c0730h.isEnabled());
    }

    public void m3747a(boolean z, char c) {
        int i = (z && this.f1788a.m3874f()) ? 0 : 8;
        if (i == 0) {
            this.f1793f.setText(this.f1788a.m3872e());
        }
        if (this.f1793f.getVisibility() != i) {
            this.f1793f.setVisibility(i);
        }
    }

    public boolean mo28a() {
        return false;
    }

    public C0730h getItemData() {
        return this.f1788a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f1794g);
        this.f1791d = (TextView) findViewById(C0688f.title);
        if (this.f1795h != -1) {
            this.f1791d.setTextAppearance(this.f1796i, this.f1795h);
        }
        this.f1793f = (TextView) findViewById(C0688f.shortcut);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1789b != null && this.f1797j) {
            LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1789b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        if (z || this.f1790c != null || this.f1792e != null) {
            CompoundButton compoundButton;
            CompoundButton compoundButton2;
            if (this.f1788a.m3875g()) {
                if (this.f1790c == null) {
                    m3744c();
                }
                compoundButton = this.f1790c;
                compoundButton2 = this.f1792e;
            } else {
                if (this.f1792e == null) {
                    m3745d();
                }
                compoundButton = this.f1792e;
                compoundButton2 = this.f1790c;
            }
            if (z) {
                compoundButton.setChecked(this.f1788a.isChecked());
                int i = z ? 0 : 8;
                if (compoundButton.getVisibility() != i) {
                    compoundButton.setVisibility(i);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f1792e != null) {
                this.f1792e.setVisibility(8);
            }
            if (this.f1790c != null) {
                this.f1790c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1788a.m3875g()) {
            if (this.f1790c == null) {
                m3744c();
            }
            compoundButton = this.f1790c;
        } else {
            if (this.f1792e == null) {
                m3745d();
            }
            compoundButton = this.f1792e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1801n = z;
        this.f1797j = z;
    }

    public void setIcon(Drawable drawable) {
        int i = (this.f1788a.m3877i() || this.f1801n) ? 1 : 0;
        if (i == 0 && !this.f1797j) {
            return;
        }
        if (this.f1789b != null || drawable != null || this.f1797j) {
            if (this.f1789b == null) {
                m3743b();
            }
            if (drawable != null || this.f1797j) {
                ImageView imageView = this.f1789b;
                if (i == 0) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1789b.getVisibility() != 0) {
                    this.f1789b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1789b.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1791d.setText(charSequence);
            if (this.f1791d.getVisibility() != 0) {
                this.f1791d.setVisibility(0);
            }
        } else if (this.f1791d.getVisibility() != 8) {
            this.f1791d.setVisibility(8);
        }
    }
}
