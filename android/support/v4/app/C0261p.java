package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.p015g.C0369j;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class C0261p {
    private final C0257q<?> f952a;

    private C0261p(C0257q<?> c0257q) {
        this.f952a = c0257q;
    }

    public static final C0261p m1462a(C0257q<?> c0257q) {
        return new C0261p(c0257q);
    }

    Fragment m1463a(String str) {
        return this.f952a.f929d.m1540b(str);
    }

    public C0263r m1464a() {
        return this.f952a.m1432i();
    }

    public View m1465a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f952a.f929d.mo225a(view, str, context, attributeSet);
    }

    public void m1466a(Configuration configuration) {
        this.f952a.f929d.m1527a(configuration);
    }

    public void m1467a(Parcelable parcelable, List<Fragment> list) {
        this.f952a.f929d.m1529a(parcelable, (List) list);
    }

    public void m1468a(Fragment fragment) {
        this.f952a.f929d.m1533a(this.f952a, this.f952a, fragment);
    }

    public void m1469a(C0369j<String, C0282x> c0369j) {
        this.f952a.m1417a((C0369j) c0369j);
    }

    public void m1470a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f952a.m1425b(str, fileDescriptor, printWriter, strArr);
    }

    public void m1471a(boolean z) {
        this.f952a.m1420a(z);
    }

    public boolean m1472a(Menu menu) {
        return this.f952a.f929d.m1537a(menu);
    }

    public boolean m1473a(Menu menu, MenuInflater menuInflater) {
        return this.f952a.f929d.m1538a(menu, menuInflater);
    }

    public boolean m1474a(MenuItem menuItem) {
        return this.f952a.f929d.m1539a(menuItem);
    }

    public void m1475b() {
        this.f952a.f929d.m1562i();
    }

    public void m1476b(Menu menu) {
        this.f952a.f929d.m1545b(menu);
    }

    public boolean m1477b(MenuItem menuItem) {
        return this.f952a.f929d.m1547b(menuItem);
    }

    public Parcelable m1478c() {
        return this.f952a.f929d.m1561h();
    }

    public List<Fragment> m1479d() {
        return this.f952a.f929d.m1560g();
    }

    public void m1480e() {
        this.f952a.f929d.m1563j();
    }

    public void m1481f() {
        this.f952a.f929d.m1564k();
    }

    public void m1482g() {
        this.f952a.f929d.m1565l();
    }

    public void m1483h() {
        this.f952a.f929d.m1566m();
    }

    public void m1484i() {
        this.f952a.f929d.m1567n();
    }

    public void m1485j() {
        this.f952a.f929d.m1568o();
    }

    public void m1486k() {
        this.f952a.f929d.m1569p();
    }

    public void m1487l() {
        this.f952a.f929d.m1571r();
    }

    public void m1488m() {
        this.f952a.f929d.m1572s();
    }

    public boolean m1489n() {
        return this.f952a.f929d.m1556e();
    }

    public void m1490o() {
        this.f952a.m1434k();
    }

    public void m1491p() {
        this.f952a.m1435l();
    }

    public void m1492q() {
        this.f952a.m1436m();
    }

    public C0369j<String, C0282x> m1493r() {
        return this.f952a.m1437n();
    }
}
