package android.support.v7.p018a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ag;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C0551b;
import android.support.v7.p019b.C0694a.C0683a;
import android.support.v7.p019b.C0694a.C0688f;
import android.support.v7.p019b.C0694a.C0693k;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class C0628b {
    private TextView f1477A;
    private TextView f1478B;
    private View f1479C;
    private ListAdapter f1480D;
    private int f1481E = -1;
    private int f1482F;
    private int f1483G;
    private int f1484H;
    private int f1485I;
    private int f1486J;
    private int f1487K;
    private int f1488L = 0;
    private Handler f1489M;
    private final OnClickListener f1490N = new C06151(this);
    private final Context f1491a;
    private final C0631l f1492b;
    private final Window f1493c;
    private CharSequence f1494d;
    private CharSequence f1495e;
    private ListView f1496f;
    private View f1497g;
    private int f1498h;
    private int f1499i;
    private int f1500j;
    private int f1501k;
    private int f1502l;
    private boolean f1503m = false;
    private Button f1504n;
    private CharSequence f1505o;
    private Message f1506p;
    private Button f1507q;
    private CharSequence f1508r;
    private Message f1509s;
    private Button f1510t;
    private CharSequence f1511u;
    private Message f1512v;
    private NestedScrollView f1513w;
    private int f1514x = 0;
    private Drawable f1515y;
    private ImageView f1516z;

    class C06151 implements OnClickListener {
        final /* synthetic */ C0628b f1412a;

        C06151(C0628b c0628b) {
            this.f1412a = c0628b;
        }

        public void onClick(View view) {
            Message obtain = (view != this.f1412a.f1504n || this.f1412a.f1506p == null) ? (view != this.f1412a.f1507q || this.f1412a.f1509s == null) ? (view != this.f1412a.f1510t || this.f1412a.f1512v == null) ? null : Message.obtain(this.f1412a.f1512v) : Message.obtain(this.f1412a.f1509s) : Message.obtain(this.f1412a.f1506p);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.f1412a.f1489M.obtainMessage(1, this.f1412a.f1492b).sendToTarget();
        }
    }

    public static class C0625a {
        public int f1437A;
        public boolean f1438B = false;
        public boolean[] f1439C;
        public boolean f1440D;
        public boolean f1441E;
        public int f1442F = -1;
        public OnMultiChoiceClickListener f1443G;
        public Cursor f1444H;
        public String f1445I;
        public String f1446J;
        public OnItemSelectedListener f1447K;
        public C0624a f1448L;
        public boolean f1449M = true;
        public final Context f1450a;
        public final LayoutInflater f1451b;
        public int f1452c = 0;
        public Drawable f1453d;
        public int f1454e = 0;
        public CharSequence f1455f;
        public View f1456g;
        public CharSequence f1457h;
        public CharSequence f1458i;
        public DialogInterface.OnClickListener f1459j;
        public CharSequence f1460k;
        public DialogInterface.OnClickListener f1461l;
        public CharSequence f1462m;
        public DialogInterface.OnClickListener f1463n;
        public boolean f1464o;
        public OnCancelListener f1465p;
        public OnDismissListener f1466q;
        public OnKeyListener f1467r;
        public CharSequence[] f1468s;
        public ListAdapter f1469t;
        public DialogInterface.OnClickListener f1470u;
        public int f1471v;
        public View f1472w;
        public int f1473x;
        public int f1474y;
        public int f1475z;

        public interface C0624a {
            void m3259a(ListView listView);
        }

        public C0625a(Context context) {
            this.f1450a = context;
            this.f1464o = true;
            this.f1451b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void m3260b(final C0628b c0628b) {
            ListAdapter simpleCursorAdapter;
            final ListView listView = (ListView) this.f1451b.inflate(c0628b.f1484H, null);
            if (!this.f1440D) {
                int m = this.f1441E ? c0628b.f1486J : c0628b.f1487K;
                simpleCursorAdapter = this.f1444H != null ? new SimpleCursorAdapter(this.f1450a, m, this.f1444H, new String[]{this.f1445I}, new int[]{16908308}) : this.f1469t != null ? this.f1469t : new C0627c(this.f1450a, m, 16908308, this.f1468s);
            } else if (this.f1444H == null) {
                simpleCursorAdapter = new ArrayAdapter<CharSequence>(this, this.f1450a, c0628b.f1485I, 16908308, this.f1468s) {
                    final /* synthetic */ C0625a f1426b;

                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (this.f1426b.f1439C != null && this.f1426b.f1439C[i]) {
                            listView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                };
            } else {
                final C0628b c0628b2 = c0628b;
                Object c06212 = new CursorAdapter(this, this.f1450a, this.f1444H, false) {
                    final /* synthetic */ C0625a f1429c;
                    private final int f1430d;
                    private final int f1431e;

                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1430d));
                        listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1431e) == 1);
                    }

                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return this.f1429c.f1451b.inflate(c0628b2.f1485I, viewGroup, false);
                    }
                };
            }
            if (this.f1448L != null) {
                this.f1448L.m3259a(listView);
            }
            c0628b.f1480D = simpleCursorAdapter;
            c0628b.f1481E = this.f1442F;
            if (this.f1470u != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0625a f1433b;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.f1433b.f1470u.onClick(c0628b.f1492b, i);
                        if (!this.f1433b.f1441E) {
                            c0628b.f1492b.dismiss();
                        }
                    }
                });
            } else if (this.f1443G != null) {
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ C0625a f1436c;

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (this.f1436c.f1439C != null) {
                            this.f1436c.f1439C[i] = listView.isItemChecked(i);
                        }
                        this.f1436c.f1443G.onClick(c0628b.f1492b, i, listView.isItemChecked(i));
                    }
                });
            }
            if (this.f1447K != null) {
                listView.setOnItemSelectedListener(this.f1447K);
            }
            if (this.f1441E) {
                listView.setChoiceMode(1);
            } else if (this.f1440D) {
                listView.setChoiceMode(2);
            }
            c0628b.f1496f = listView;
        }

        public void m3261a(C0628b c0628b) {
            if (this.f1456g != null) {
                c0628b.m3298b(this.f1456g);
            } else {
                if (this.f1455f != null) {
                    c0628b.m3295a(this.f1455f);
                }
                if (this.f1453d != null) {
                    c0628b.m3293a(this.f1453d);
                }
                if (this.f1452c != 0) {
                    c0628b.m3297b(this.f1452c);
                }
                if (this.f1454e != 0) {
                    c0628b.m3297b(c0628b.m3301c(this.f1454e));
                }
            }
            if (this.f1457h != null) {
                c0628b.m3299b(this.f1457h);
            }
            if (this.f1458i != null) {
                c0628b.m3292a(-1, this.f1458i, this.f1459j, null);
            }
            if (this.f1460k != null) {
                c0628b.m3292a(-2, this.f1460k, this.f1461l, null);
            }
            if (this.f1462m != null) {
                c0628b.m3292a(-3, this.f1462m, this.f1463n, null);
            }
            if (!(this.f1468s == null && this.f1444H == null && this.f1469t == null)) {
                m3260b(c0628b);
            }
            if (this.f1472w != null) {
                if (this.f1438B) {
                    c0628b.m3294a(this.f1472w, this.f1473x, this.f1474y, this.f1475z, this.f1437A);
                    return;
                }
                c0628b.m3302c(this.f1472w);
            } else if (this.f1471v != 0) {
                c0628b.m3291a(this.f1471v);
            }
        }
    }

    private static final class C0626b extends Handler {
        private WeakReference<DialogInterface> f1476a;

        public C0626b(DialogInterface dialogInterface) {
            this.f1476a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1476a.get(), message.what);
                    return;
                case 1:
                    ((DialogInterface) message.obj).dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    private static class C0627c extends ArrayAdapter<CharSequence> {
        public C0627c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public C0628b(Context context, C0631l c0631l, Window window) {
        this.f1491a = context;
        this.f1492b = c0631l;
        this.f1493c = window;
        this.f1489M = new C0626b(c0631l);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0693k.AlertDialog, C0683a.alertDialogStyle, 0);
        this.f1482F = obtainStyledAttributes.getResourceId(C0693k.AlertDialog_android_layout, 0);
        this.f1483G = obtainStyledAttributes.getResourceId(C0693k.AlertDialog_buttonPanelSideLayout, 0);
        this.f1484H = obtainStyledAttributes.getResourceId(C0693k.AlertDialog_listLayout, 0);
        this.f1485I = obtainStyledAttributes.getResourceId(C0693k.AlertDialog_multiChoiceItemLayout, 0);
        this.f1486J = obtainStyledAttributes.getResourceId(C0693k.AlertDialog_singleChoiceItemLayout, 0);
        this.f1487K = obtainStyledAttributes.getResourceId(C0693k.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        c0631l.m3323a(1);
    }

    private ViewGroup m3263a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void m3268a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f1497g != null ? this.f1497g : this.f1498h != 0 ? LayoutInflater.from(this.f1491a).inflate(this.f1498h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && C0628b.m3270a(inflate))) {
            this.f1493c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1493c.findViewById(C0688f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f1503m) {
                frameLayout.setPadding(this.f1499i, this.f1500j, this.f1501k, this.f1502l);
            }
            if (this.f1496f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m3269a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f1493c.findViewById(C0688f.scrollIndicatorUp);
        View findViewById2 = this.f1493c.findViewById(C0688f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ag.m2512a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1495e != null) {
                this.f1513w.setOnScrollChangeListener(new C0551b(this) {
                    final /* synthetic */ C0628b f1415c;

                    public void mo510a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        C0628b.m3273b(nestedScrollView, findViewById, view2);
                    }
                });
                this.f1513w.post(new Runnable(this) {
                    final /* synthetic */ C0628b f1418c;

                    public void run() {
                        C0628b.m3273b(this.f1418c.f1513w, findViewById, view2);
                    }
                });
            } else if (this.f1496f != null) {
                this.f1496f.setOnScrollListener(new OnScrollListener(this) {
                    final /* synthetic */ C0628b f1421c;

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        C0628b.m3273b(absListView, findViewById, view2);
                    }

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }
                });
                this.f1496f.post(new Runnable(this) {
                    final /* synthetic */ C0628b f1424c;

                    public void run() {
                        C0628b.m3273b(this.f1424c.f1496f, findViewById, view2);
                    }
                });
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    static boolean m3270a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0628b.m3270a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int m3271b() {
        return this.f1483G == 0 ? this.f1482F : this.f1488L == 1 ? this.f1483G : this.f1482F;
    }

    private static void m3273b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ag.m2527b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ag.m2527b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m3274b(ViewGroup viewGroup) {
        if (this.f1479C != null) {
            viewGroup.addView(this.f1479C, 0, new LayoutParams(-1, -2));
            this.f1493c.findViewById(C0688f.title_template).setVisibility(8);
            return;
        }
        this.f1516z = (ImageView) this.f1493c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1494d) ? 1 : 0) != 0) {
            this.f1477A = (TextView) this.f1493c.findViewById(C0688f.alertTitle);
            this.f1477A.setText(this.f1494d);
            if (this.f1514x != 0) {
                this.f1516z.setImageResource(this.f1514x);
                return;
            } else if (this.f1515y != null) {
                this.f1516z.setImageDrawable(this.f1515y);
                return;
            } else {
                this.f1477A.setPadding(this.f1516z.getPaddingLeft(), this.f1516z.getPaddingTop(), this.f1516z.getPaddingRight(), this.f1516z.getPaddingBottom());
                this.f1516z.setVisibility(8);
                return;
            }
        }
        this.f1493c.findViewById(C0688f.title_template).setVisibility(8);
        this.f1516z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m3276c() {
        View findViewById = this.f1493c.findViewById(C0688f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0688f.topPanel);
        View findViewById3 = findViewById.findViewById(C0688f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0688f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0688f.customPanel);
        m3268a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0688f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0688f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0688f.buttonPanel);
        ViewGroup a = m3263a(findViewById5, findViewById2);
        ViewGroup a2 = m3263a(findViewById6, findViewById3);
        ViewGroup a3 = m3263a(findViewById7, findViewById4);
        m3277c(a2);
        m3279d(a3);
        m3274b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById3 = a2.findViewById(C0688f.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z2 && this.f1513w != null) {
            this.f1513w.setClipToPadding(true);
        }
        if (!z) {
            findViewById3 = this.f1496f != null ? this.f1496f : this.f1513w;
            if (findViewById3 != null) {
                m3269a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f1496f;
        if (listView != null && this.f1480D != null) {
            listView.setAdapter(this.f1480D);
            int i = this.f1481E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void m3277c(ViewGroup viewGroup) {
        this.f1513w = (NestedScrollView) this.f1493c.findViewById(C0688f.scrollView);
        this.f1513w.setFocusable(false);
        this.f1513w.setNestedScrollingEnabled(false);
        this.f1478B = (TextView) viewGroup.findViewById(16908299);
        if (this.f1478B != null) {
            if (this.f1495e != null) {
                this.f1478B.setText(this.f1495e);
                return;
            }
            this.f1478B.setVisibility(8);
            this.f1513w.removeView(this.f1478B);
            if (this.f1496f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1513w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1513w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1496f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m3279d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f1504n = (Button) viewGroup.findViewById(16908313);
        this.f1504n.setOnClickListener(this.f1490N);
        if (TextUtils.isEmpty(this.f1505o)) {
            this.f1504n.setVisibility(8);
            i = 0;
        } else {
            this.f1504n.setText(this.f1505o);
            this.f1504n.setVisibility(0);
            i = 1;
        }
        this.f1507q = (Button) viewGroup.findViewById(16908314);
        this.f1507q.setOnClickListener(this.f1490N);
        if (TextUtils.isEmpty(this.f1508r)) {
            this.f1507q.setVisibility(8);
        } else {
            this.f1507q.setText(this.f1508r);
            this.f1507q.setVisibility(0);
            i |= 2;
        }
        this.f1510t = (Button) viewGroup.findViewById(16908315);
        this.f1510t.setOnClickListener(this.f1490N);
        if (TextUtils.isEmpty(this.f1511u)) {
            this.f1510t.setVisibility(8);
        } else {
            this.f1510t.setText(this.f1511u);
            this.f1510t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void m3290a() {
        this.f1492b.setContentView(m3271b());
        m3276c();
    }

    public void m3291a(int i) {
        this.f1497g = null;
        this.f1498h = i;
        this.f1503m = false;
    }

    public void m3292a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1489M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1511u = charSequence;
                this.f1512v = message;
                return;
            case -2:
                this.f1508r = charSequence;
                this.f1509s = message;
                return;
            case -1:
                this.f1505o = charSequence;
                this.f1506p = message;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m3293a(Drawable drawable) {
        this.f1515y = drawable;
        this.f1514x = 0;
        if (this.f1516z == null) {
            return;
        }
        if (drawable != null) {
            this.f1516z.setVisibility(0);
            this.f1516z.setImageDrawable(drawable);
            return;
        }
        this.f1516z.setVisibility(8);
    }

    public void m3294a(View view, int i, int i2, int i3, int i4) {
        this.f1497g = view;
        this.f1498h = 0;
        this.f1503m = true;
        this.f1499i = i;
        this.f1500j = i2;
        this.f1501k = i3;
        this.f1502l = i4;
    }

    public void m3295a(CharSequence charSequence) {
        this.f1494d = charSequence;
        if (this.f1477A != null) {
            this.f1477A.setText(charSequence);
        }
    }

    public boolean m3296a(int i, KeyEvent keyEvent) {
        return this.f1513w != null && this.f1513w.m2951a(keyEvent);
    }

    public void m3297b(int i) {
        this.f1515y = null;
        this.f1514x = i;
        if (this.f1516z == null) {
            return;
        }
        if (i != 0) {
            this.f1516z.setVisibility(0);
            this.f1516z.setImageResource(this.f1514x);
            return;
        }
        this.f1516z.setVisibility(8);
    }

    public void m3298b(View view) {
        this.f1479C = view;
    }

    public void m3299b(CharSequence charSequence) {
        this.f1495e = charSequence;
        if (this.f1478B != null) {
            this.f1478B.setText(charSequence);
        }
    }

    public boolean m3300b(int i, KeyEvent keyEvent) {
        return this.f1513w != null && this.f1513w.m2951a(keyEvent);
    }

    public int m3301c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1491a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m3302c(View view) {
        this.f1497g = view;
        this.f1498h = 0;
        this.f1503m = false;
    }
}
