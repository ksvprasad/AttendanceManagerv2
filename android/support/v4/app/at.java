package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p010b.C0195a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class at implements Iterable<Intent> {
    private static final C0229b f859a;
    private final ArrayList<Intent> f860b = new ArrayList();
    private final Context f861c;

    public interface C0228a {
        Intent mo516a();
    }

    interface C0229b {
    }

    static class C0230c implements C0229b {
        C0230c() {
        }
    }

    static class C0231d implements C0229b {
        C0231d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f859a = new C0231d();
        } else {
            f859a = new C0230c();
        }
    }

    private at(Context context) {
        this.f861c = context;
    }

    public static at m1317a(Context context) {
        return new at(context);
    }

    public at m1318a(Activity activity) {
        Intent intent = null;
        if (activity instanceof C0228a) {
            intent = ((C0228a) activity).mo516a();
        }
        Intent a = intent == null ? C0290z.m1674a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f861c.getPackageManager());
            }
            m1319a(component);
            m1320a(a);
        }
        return this;
    }

    public at m1319a(ComponentName componentName) {
        int size = this.f860b.size();
        try {
            Intent a = C0290z.m1675a(this.f861c, componentName);
            while (a != null) {
                this.f860b.add(size, a);
                a = C0290z.m1675a(this.f861c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public at m1320a(Intent intent) {
        this.f860b.add(intent);
        return this;
    }

    public void m1321a() {
        m1322a(null);
    }

    public void m1322a(Bundle bundle) {
        if (this.f860b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f860b.toArray(new Intent[this.f860b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0195a.m1225a(this.f861c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f861c.startActivity(intent);
        }
    }

    public Iterator<Intent> iterator() {
        return this.f860b.iterator();
    }
}
