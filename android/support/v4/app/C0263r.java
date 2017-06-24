package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class C0263r {

    public interface C0262a {
        void m1494a();
    }

    public abstract SavedState mo221a(Fragment fragment);

    public abstract Fragment mo222a(Bundle bundle, String str);

    public abstract Fragment mo223a(String str);

    public abstract C0250v mo224a();

    public abstract void mo226a(int i, int i2);

    public abstract void mo227a(Bundle bundle, String str, Fragment fragment);

    public abstract void mo228a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract boolean mo229b();

    public abstract boolean mo230c();
}
