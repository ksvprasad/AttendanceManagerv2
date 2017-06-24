package com.google.android.gms.p031b;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@id
public class fi implements fh {
    private final fg f4788a;
    private final HashSet<SimpleEntry<String, eb>> f4789b = new HashSet();

    public fi(fg fgVar) {
        this.f4788a = fgVar;
    }

    public void mo1331a() {
        Iterator it = this.f4789b.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            String str = "Unregistering eventhandler: ";
            String valueOf = String.valueOf(((eb) simpleEntry.getValue()).toString());
            jv.m9152e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f4788a.mo1324b((String) simpleEntry.getKey(), (eb) simpleEntry.getValue());
        }
        this.f4789b.clear();
    }

    public void mo1319a(String str, eb ebVar) {
        this.f4788a.mo1319a(str, ebVar);
        this.f4789b.add(new SimpleEntry(str, ebVar));
    }

    public void mo1320a(String str, String str2) {
        this.f4788a.mo1320a(str, str2);
    }

    public void mo1321a(String str, JSONObject jSONObject) {
        this.f4788a.mo1321a(str, jSONObject);
    }

    public void mo1324b(String str, eb ebVar) {
        this.f4788a.mo1324b(str, ebVar);
        this.f4789b.remove(new SimpleEntry(str, ebVar));
    }

    public void mo1325b(String str, JSONObject jSONObject) {
        this.f4788a.mo1325b(str, jSONObject);
    }
}
