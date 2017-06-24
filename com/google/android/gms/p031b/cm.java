package com.google.android.gms.p031b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@id
public class cm {
    private final Collection<cl> f4347a = new ArrayList();
    private final Collection<cl<String>> f4348b = new ArrayList();
    private final Collection<cl<String>> f4349c = new ArrayList();

    public List<String> m7810a() {
        List<String> arrayList = new ArrayList();
        for (cl c : this.f4348b) {
            String str = (String) c.m7801c();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public void m7811a(cl clVar) {
        this.f4347a.add(clVar);
    }

    public List<String> m7812b() {
        List<String> a = m7810a();
        for (cl c : this.f4349c) {
            String str = (String) c.m7801c();
            if (str != null) {
                a.add(str);
            }
        }
        return a;
    }

    public void m7813b(cl<String> clVar) {
        this.f4348b.add(clVar);
    }

    public void m7814c(cl<String> clVar) {
        this.f4349c.add(clVar);
    }
}
