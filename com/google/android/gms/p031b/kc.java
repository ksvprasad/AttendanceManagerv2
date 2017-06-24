package com.google.android.gms.p031b;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.C1319u;
import com.google.android.gms.ads.internal.util.client.C1324b;
import java.util.Map;

@id
public class kc {
    private final Context f5582a;
    private String f5583b;
    private final float f5584c;
    private float f5585d;
    private float f5586e;
    private float f5587f;
    private int f5588g;

    class C16712 implements OnClickListener {
        final /* synthetic */ kc f5581a;

        C16712(kc kcVar) {
            this.f5581a = kcVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public kc(Context context) {
        this.f5588g = 0;
        this.f5582a = context;
        this.f5584c = context.getResources().getDisplayMetrics().density;
    }

    public kc(Context context, String str) {
        this(context);
        this.f5583b = str;
    }

    private void m9309a() {
        if (this.f5582a instanceof Activity) {
            final Object b = kc.m9310b(this.f5583b);
            Builder builder = new Builder(this.f5582a);
            builder.setMessage(b);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new OnClickListener(this) {
                final /* synthetic */ kc f5580b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    C1319u.m7183e().m9214a(this.f5580b.f5582a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", b), "Share via"));
                }
            });
            builder.setNegativeButton("Close", new C16712(this));
            builder.create().show();
            return;
        }
        C1324b.m7232c("Can not create dialog without Activity Context");
    }

    static String m9310b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "No debug information";
        }
        Uri build = new Uri.Builder().encodedQuery(str.replaceAll("\\+", "%20")).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map a = C1319u.m7183e().m9209a(build);
        for (String str2 : a.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) a.get(str2)).append("\n\n");
        }
        Object trim = stringBuilder.toString().trim();
        return TextUtils.isEmpty(trim) ? "No debug information" : trim;
    }

    void m9311a(int i, float f, float f2) {
        if (i == 0) {
            this.f5588g = 0;
            this.f5585d = f;
            this.f5586e = f2;
            this.f5587f = f2;
        } else if (this.f5588g == -1) {
        } else {
            if (i == 2) {
                if (f2 > this.f5586e) {
                    this.f5586e = f2;
                } else if (f2 < this.f5587f) {
                    this.f5587f = f2;
                }
                if (this.f5586e - this.f5587f > 30.0f * this.f5584c) {
                    this.f5588g = -1;
                    return;
                }
                if (this.f5588g == 0 || this.f5588g == 2) {
                    if (f - this.f5585d >= 50.0f * this.f5584c) {
                        this.f5585d = f;
                        this.f5588g++;
                    }
                } else if ((this.f5588g == 1 || this.f5588g == 3) && f - this.f5585d <= -50.0f * this.f5584c) {
                    this.f5585d = f;
                    this.f5588g++;
                }
                if (this.f5588g == 1 || this.f5588g == 3) {
                    if (f > this.f5585d) {
                        this.f5585d = f;
                    }
                } else if (this.f5588g == 2 && f < this.f5585d) {
                    this.f5585d = f;
                }
            } else if (i == 1 && this.f5588g == 4) {
                m9309a();
            }
        }
    }

    public void m9312a(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        for (int i = 0; i < historySize; i++) {
            m9311a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i));
        }
        m9311a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    public void m9313a(String str) {
        this.f5583b = str;
    }
}
