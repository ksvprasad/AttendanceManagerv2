package com.google.android.gms.p031b;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C1004a.C0996b;
import com.google.android.gms.ads.internal.C1319u;
import java.util.Map;

@id
public class gr extends gu {
    private final Map<String, String> f4982a;
    private final Context f4983b;

    class C15572 implements OnClickListener {
        final /* synthetic */ gr f4981a;

        C15572(gr grVar) {
            this.f4981a = grVar;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4981a.m8636b("User canceled the download.");
        }
    }

    public gr(la laVar, Map<String, String> map) {
        super(laVar, "storePicture");
        this.f4982a = map;
        this.f4983b = laVar.mo1513f();
    }

    Request m8658a(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        C1319u.m7185g().mo1464a(request);
        return request;
    }

    String m8659a(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public void m8660a() {
        if (this.f4983b == null) {
            m8636b("Activity context is not available");
        } else if (C1319u.m7183e().m9245e(this.f4983b).m7786c()) {
            final String str = (String) this.f4982a.get("iurl");
            if (TextUtils.isEmpty(str)) {
                m8636b("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                final String a = m8659a(str);
                if (C1319u.m7183e().m9240c(a)) {
                    Resources o = C1319u.m7186h().m9136o();
                    Builder d = C1319u.m7183e().m9242d(this.f4983b);
                    d.setTitle(o != null ? o.getString(C0996b.store_picture_title) : "Save image");
                    d.setMessage(o != null ? o.getString(C0996b.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                    d.setPositiveButton(o != null ? o.getString(C0996b.accept) : "Accept", new OnClickListener(this) {
                        final /* synthetic */ gr f4980c;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            try {
                                ((DownloadManager) this.f4980c.f4983b.getSystemService("download")).enqueue(this.f4980c.m8658a(str, a));
                            } catch (IllegalStateException e) {
                                this.f4980c.m8636b("Could not store picture.");
                            }
                        }
                    });
                    d.setNegativeButton(o != null ? o.getString(C0996b.decline) : "Decline", new C15572(this));
                    d.create().show();
                    return;
                }
                r1 = "Image type not recognized: ";
                str = String.valueOf(a);
                m8636b(str.length() != 0 ? r1.concat(str) : new String(r1));
            } else {
                r1 = "Invalid image url: ";
                str = String.valueOf(str);
                m8636b(str.length() != 0 ? r1.concat(str) : new String(r1));
            }
        } else {
            m8636b("Feature is not supported by the device.");
        }
    }
}
