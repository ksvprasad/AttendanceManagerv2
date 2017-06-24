package com.google.android.gms.p031b;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.C1004a.C0996b;
import com.google.android.gms.ads.internal.C1319u;
import java.util.Map;

@id
public class gn extends gu {
    private final Map<String, String> f4948a;
    private final Context f4949b;
    private String f4950c;
    private long f4951d;
    private long f4952e;
    private String f4953f;
    private String f4954g;

    class C15531 implements OnClickListener {
        final /* synthetic */ gn f4944a;

        C15531(gn gnVar) {
            this.f4944a = gnVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C1319u.m7183e().m9214a(this.f4944a.f4949b, this.f4944a.m8644b());
        }
    }

    class C15542 implements OnClickListener {
        final /* synthetic */ gn f4945a;

        C15542(gn gnVar) {
            this.f4945a = gnVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4945a.m8636b("Operation denied by user.");
        }
    }

    public gn(la laVar, Map<String, String> map) {
        super(laVar, "createCalendarEvent");
        this.f4948a = map;
        this.f4949b = laVar.mo1513f();
        m8641c();
    }

    private String m8640a(String str) {
        return TextUtils.isEmpty((CharSequence) this.f4948a.get(str)) ? "" : (String) this.f4948a.get(str);
    }

    private void m8641c() {
        this.f4950c = m8640a("description");
        this.f4953f = m8640a("summary");
        this.f4951d = m8642e("start_ticks");
        this.f4952e = m8642e("end_ticks");
        this.f4954g = m8640a("location");
    }

    private long m8642e(String str) {
        String str2 = (String) this.f4948a.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void m8643a() {
        if (this.f4949b == null) {
            m8636b("Activity context is not available.");
        } else if (C1319u.m7183e().m9245e(this.f4949b).m7788f()) {
            Builder d = C1319u.m7183e().m9242d(this.f4949b);
            Resources o = C1319u.m7186h().m9136o();
            d.setTitle(o != null ? o.getString(C0996b.create_calendar_title) : "Create calendar event");
            d.setMessage(o != null ? o.getString(C0996b.create_calendar_message) : "Allow Ad to create a calendar event?");
            d.setPositiveButton(o != null ? o.getString(C0996b.accept) : "Accept", new C15531(this));
            d.setNegativeButton(o != null ? o.getString(C0996b.decline) : "Decline", new C15542(this));
            d.create().show();
        } else {
            m8636b("This feature is not available on the device.");
        }
    }

    @TargetApi(14)
    Intent m8644b() {
        Intent data = new Intent("android.intent.action.EDIT").setData(Events.CONTENT_URI);
        data.putExtra("title", this.f4950c);
        data.putExtra("eventLocation", this.f4954g);
        data.putExtra("description", this.f4953f);
        if (this.f4951d > -1) {
            data.putExtra("beginTime", this.f4951d);
        }
        if (this.f4952e > -1) {
            data.putExtra("endTime", this.f4952e);
        }
        data.setFlags(268435456);
        return data;
    }
}
