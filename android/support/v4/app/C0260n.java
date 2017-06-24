package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.C0196a.C0194a;
import android.support.v4.app.C0233b.C0232a;
import android.support.v4.p015g.C0369j;
import android.support.v4.p015g.C0386k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class C0260n extends C0254l implements C0194a, C0232a {
    final Handler f940a = new C02561(this);
    final C0261p f941b = C0261p.m1462a(new C0258a(this));
    boolean f942c;
    boolean f943d;
    boolean f944e;
    boolean f945f;
    boolean f946g;
    boolean f947h;
    boolean f948i;
    int f949j;
    boolean f950k;
    C0386k<String> f951l;

    class C02561 extends Handler {
        final /* synthetic */ C0260n f925a;

        C02561(C0260n c0260n) {
            this.f925a = c0260n;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.f925a.f944e) {
                        this.f925a.m1455a(false);
                        return;
                    }
                    return;
                case 2:
                    this.f925a.m1457b();
                    this.f925a.f941b.m1489n();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    class C0258a extends C0257q<C0260n> {
        final /* synthetic */ C0260n f936a;

        public C0258a(C0260n c0260n) {
            this.f936a = c0260n;
            super(c0260n);
        }

        public View mo167a(int i) {
            return this.f936a.findViewById(i);
        }

        public void mo206a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            this.f936a.m1454a(fragment, intent, i, bundle);
        }

        public void mo207a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f936a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean mo168a() {
            Window window = this.f936a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean mo208a(Fragment fragment) {
            return !this.f936a.isFinishing();
        }

        public LayoutInflater mo209b() {
            return this.f936a.getLayoutInflater().cloneInContext(this.f936a);
        }

        public void mo210b(Fragment fragment) {
            this.f936a.m1453a(fragment);
        }

        public void mo211c() {
            this.f936a.mo517d();
        }

        public boolean mo212d() {
            return this.f936a.getWindow() != null;
        }

        public int mo213e() {
            Window window = this.f936a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }
    }

    static final class C0259b {
        Object f937a;
        List<Fragment> f938b;
        C0369j<String, C0282x> f939c;

        C0259b() {
        }
    }

    private static String m1448a(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m1449a(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0260n.m1448a(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    m1449a(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private int m1450b(Fragment fragment) {
        if (this.f951l.m1946b() >= 65534) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.f951l.m1953f(this.f949j) >= 0) {
            this.f949j = (this.f949j + 1) % 65534;
        }
        int i = this.f949j;
        this.f951l.m1948b(i, fragment.f766q);
        this.f949j = (this.f949j + 1) % 65534;
        return i;
    }

    final View mo214a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f941b.m1465a(view, str, context, attributeSet);
    }

    public final void mo215a(int i) {
        if (!this.f948i && i != -1 && (-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void m1453a(Fragment fragment) {
    }

    public void m1454a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.f950k = true;
        if (i == -1) {
            try {
                C0196a.m1229a(this, intent, -1, bundle);
            } finally {
                this.f950k = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            C0196a.m1229a(this, intent, ((m1450b(fragment) + 1) << 16) + (65535 & i), bundle);
            this.f950k = false;
        }
    }

    void m1455a(boolean z) {
        if (!this.f945f) {
            this.f945f = true;
            this.f946g = z;
            this.f940a.removeMessages(1);
            m1460e();
        }
    }

    protected boolean m1456a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void m1457b() {
        this.f941b.m1483h();
    }

    public Object m1458c() {
        return null;
    }

    public void mo517d() {
        if (VERSION.SDK_INT >= 11) {
            C0234c.m1325a(this);
        } else {
            this.f947h = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= 11) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f942c);
            printWriter.print("mResumed=");
            printWriter.print(this.f943d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f944e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f945f);
            this.f941b.m1470a(str2, fileDescriptor, printWriter, strArr);
            this.f941b.m1464a().mo228a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m1449a(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.f942c);
            printWriter.print("mResumed=");
            printWriter.print(this.f943d);
            printWriter.print(" mStopped=");
            printWriter.print(this.f944e);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.f945f);
            this.f941b.m1470a(str2, fileDescriptor, printWriter, strArr);
            this.f941b.m1464a().mo228a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            m1449a(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    void m1460e() {
        this.f941b.m1471a(this.f946g);
        this.f941b.m1486k();
    }

    public C0263r m1461f() {
        return this.f941b.m1464a();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f941b.m1475b();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.f951l.m1944a(i4);
            this.f951l.m1950c(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f941b.m1463a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.mo1619a(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.f941b.m1464a().mo230c()) {
            a_();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f941b.m1466a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.f941b.m1468a(null);
        super.onCreate(bundle);
        C0259b c0259b = (C0259b) getLastNonConfigurationInstance();
        if (c0259b != null) {
            this.f941b.m1469a(c0259b.f939c);
        }
        if (bundle != null) {
            this.f941b.m1467a(bundle.getParcelable("android:support:fragments"), c0259b != null ? c0259b.f938b : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f949j = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f951l = new C0386k(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f951l.m1948b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f951l == null) {
            this.f951l = new C0386k();
            this.f949j = 0;
        }
        this.f941b.m1480e();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= 11 ? super.onCreatePanelMenu(i, menu) | this.f941b.m1473a(menu, getMenuInflater()) : true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        m1455a(false);
        this.f941b.m1487l();
        this.f941b.m1491p();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f941b.m1488m();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.f941b.m1474a(menuItem);
            case 6:
                return this.f941b.m1477b(menuItem);
            default:
                return false;
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f941b.m1475b();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.f941b.m1476b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f943d = false;
        if (this.f940a.hasMessages(2)) {
            this.f940a.removeMessages(2);
            m1457b();
        }
        this.f941b.m1484i();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f940a.removeMessages(2);
        m1457b();
        this.f941b.m1489n();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.f947h) {
            this.f947h = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return m1456a(view, menu) | this.f941b.m1472a(menu);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.f951l.m1944a(i3);
            this.f951l.m1950c(i3);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a = this.f941b.m1463a(str);
            if (a == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
            } else {
                a.m1158a(i & 65535, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.f940a.sendEmptyMessage(2);
        this.f943d = true;
        this.f941b.m1489n();
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f944e) {
            m1455a(true);
        }
        Object c = m1458c();
        List d = this.f941b.m1479d();
        C0369j r = this.f941b.m1493r();
        if (d == null && r == null && c == null) {
            return null;
        }
        C0259b c0259b = new C0259b();
        c0259b.f937a = c;
        c0259b.f938b = d;
        c0259b.f939c = r;
        return c0259b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable c = this.f941b.m1478c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.f951l.m1946b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f949j);
            int[] iArr = new int[this.f951l.m1946b()];
            String[] strArr = new String[this.f951l.m1946b()];
            for (int i = 0; i < this.f951l.m1946b(); i++) {
                iArr[i] = this.f951l.m1951d(i);
                strArr[i] = (String) this.f951l.m1952e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f944e = false;
        this.f945f = false;
        this.f940a.removeMessages(1);
        if (!this.f942c) {
            this.f942c = true;
            this.f941b.m1481f();
        }
        this.f941b.m1475b();
        this.f941b.m1489n();
        this.f941b.m1490o();
        this.f941b.m1482g();
        this.f941b.m1492q();
    }

    public void onStateNotSaved() {
        this.f941b.m1475b();
    }

    protected void onStop() {
        super.onStop();
        this.f944e = true;
        this.f940a.sendEmptyMessage(1);
        this.f941b.m1485j();
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.f950k || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
}
