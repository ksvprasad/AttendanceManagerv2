package android.support.v4.p010b;

import android.support.v4.p015g.C0372c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class C0303h<D> {
    int f1051a;
    C0284b<D> f1052b;
    C0283a<D> f1053c;
    boolean f1054d;
    boolean f1055e;
    boolean f1056f;
    boolean f1057g;
    boolean f1058h;

    public interface C0283a<D> {
    }

    public interface C0284b<D> {
    }

    public String m1692a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0372c.m1911a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m1693a() {
        this.f1054d = true;
        this.f1056f = false;
        this.f1055e = false;
        m1698b();
    }

    public void m1694a(int i, C0284b<D> c0284b) {
        if (this.f1052b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1052b = c0284b;
        this.f1051a = i;
    }

    public void m1695a(C0283a<D> c0283a) {
        if (this.f1053c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f1053c = c0283a;
    }

    public void m1696a(C0284b<D> c0284b) {
        if (this.f1052b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1052b != c0284b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1052b = null;
        }
    }

    public void m1697a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1051a);
        printWriter.print(" mListener=");
        printWriter.println(this.f1052b);
        if (this.f1054d || this.f1057g || this.f1058h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1054d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f1057g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f1058h);
        }
        if (this.f1055e || this.f1056f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f1055e);
            printWriter.print(" mReset=");
            printWriter.println(this.f1056f);
        }
    }

    protected void m1698b() {
    }

    public void m1699b(C0283a<D> c0283a) {
        if (this.f1053c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1053c != c0283a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1053c = null;
        }
    }

    public void m1700c() {
        this.f1054d = false;
        m1701d();
    }

    protected void m1701d() {
    }

    public void m1702e() {
        m1703f();
        this.f1056f = true;
        this.f1054d = false;
        this.f1055e = false;
        this.f1057g = false;
        this.f1058h = false;
    }

    protected void m1703f() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0372c.m1911a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f1051a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
