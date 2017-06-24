package dotinc.attendancemanager2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.C0196a;
import android.support.v7.p018a.C0632c;
import android.support.v7.p018a.C0632c.C0629a;
import android.support.v7.p018a.C0633d;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.C1026c.C1022a;
import com.google.android.gms.ads.NativeExpressAdView;
import com.rey.material.widget.Switch;
import com.rey.material.widget.Switch.C2179a;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import dotinc.attendancemanager2.p043a.C2284h;
import java.io.File;
import java.util.ArrayList;

public class SettingsActivity extends C0633d implements OnItemClickListener {
    private Context f7649m;
    private ListView f7650n;
    private Toolbar f7651o;
    private Switch f7652p;
    private TextView f7653q;
    private RelativeLayout f7654r;
    private C2256a f7655s;
    private C2260d f7656t;
    private C2259c f7657u;
    private ProgressDialog f7658v;

    class C22321 implements C2179a {
        final /* synthetic */ SettingsActivity f7632a;

        C22321(SettingsActivity settingsActivity) {
            this.f7632a = settingsActivity;
        }

        public void mo1795a(Switch switchR, boolean z) {
            if (z) {
                this.f7632a.m12638l();
            } else {
                C2258b.m12715a(this.f7632a.f7649m, "BREAK", String.valueOf(0));
            }
        }
    }

    class C22332 implements OnClickListener {
        final /* synthetic */ SettingsActivity f7633a;

        C22332(SettingsActivity settingsActivity) {
            this.f7633a = settingsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7633a.f7652p.setChecked(false);
            dialogInterface.dismiss();
        }
    }

    class C22343 implements OnClickListener {
        final /* synthetic */ SettingsActivity f7634a;

        C22343(SettingsActivity settingsActivity) {
            this.f7634a = settingsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C2258b.m12715a(this.f7634a.f7649m, "BREAK", String.valueOf(1));
            this.f7634a.f7652p.setChecked(true);
        }
    }

    class C22354 implements OnClickListener {
        final /* synthetic */ SettingsActivity f7635a;

        C22354(SettingsActivity settingsActivity) {
            this.f7635a = settingsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    class C22365 implements OnClickListener {
        final /* synthetic */ SettingsActivity f7636a;

        C22365(SettingsActivity settingsActivity) {
            this.f7636a = settingsActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7636a.f7655s.m12702a();
            this.f7636a.f7657u.m12735c();
        }
    }

    private void m12629a(String str) {
        this.f7658v.setMessage(str);
        this.f7658v.show();
    }

    private void m12637k() {
        this.f7651o = (Toolbar) findViewById(R.id.app_bar);
        m3331a(this.f7651o);
        m3337g().mo582a(true);
        m3337g().mo589e(true);
        m3337g().mo581a(getResources().getString(R.string.settings_activity));
        this.f7649m = this;
        this.f7654r = (RelativeLayout) findViewById(R.id.root);
        this.f7653q = (TextView) findViewById(R.id.bunk_text);
        this.f7653q.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7653q.setText("Need a Break?");
        this.f7658v = new ProgressDialog(this.f7649m);
        this.f7655s = new C2256a(this.f7649m);
        this.f7656t = new C2260d(this.f7649m);
        this.f7657u = new C2259c(this.f7649m);
        this.f7652p = (Switch) findViewById(R.id.onOff);
        if (Integer.parseInt(C2258b.m12720b(this.f7649m, "BREAK", String.valueOf(-1))) == 1) {
            this.f7652p.setChecked(true);
        }
        ((NativeExpressAdView) findViewById(R.id.adView)).mo926a(new C1022a().m5773a());
    }

    private void m12638l() {
        C0629a c0629a = new C0629a(this.f7649m);
        View inflate = LayoutInflater.from(this.f7649m).inflate(R.layout.custom_need_break, null);
        c0629a.m3311b(inflate);
        c0629a.m3310a(false);
        TextView textView = (TextView) inflate.findViewById(R.id.need_break_help);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        textView.setText(getResources().getString(R.string.need_break_text));
        c0629a.m3313b("No", new C22332(this));
        c0629a.m3309a((CharSequence) "Yes, Please!", new C22343(this));
        c0629a.m3314b().show();
    }

    private void m12639m() {
        this.f7650n = (ListView) findViewById(R.id.settings_list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R.string.edit_name_criteria));
        arrayList.add("Add past attendance");
        arrayList.add(getResources().getString(R.string.edit_subjects));
        arrayList.add(getResources().getString(R.string.edit_timetable));
        arrayList.add(getResources().getString(R.string.import_export));
        arrayList.add(getResources().getString(R.string.reset_attendance));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(R.mipmap.ic_edit_black_24dp));
        arrayList2.add(Integer.valueOf(R.mipmap.ic_edit_black_24dp));
        arrayList2.add(Integer.valueOf(R.mipmap.ic_library_books_black_24dp));
        arrayList2.add(Integer.valueOf(R.mipmap.ic_date_range_black_24dp));
        arrayList2.add(Integer.valueOf(R.mipmap.ic_backup_black_24dp));
        arrayList2.add(Integer.valueOf(R.mipmap.ic_settings_backup_restore_black_24dp));
        this.f7650n.setAdapter(new C2284h(this, arrayList, arrayList2));
        this.f7650n.setOnItemClickListener(this);
    }

    private boolean m12640n() {
        if (VERSION.SDK_INT < 23) {
            Log.d("perm", "Permission is granted");
            return true;
        } else if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            Log.d("perm", "Permission is granted");
            return true;
        } else {
            Log.d("perm", "Permission is revoked");
            C0196a.m1230a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
            return false;
        }
    }

    private void m12641o() {
        File file = new File(Environment.getExternalStorageDirectory() + "/AttendanceManager");
        C0629a c0629a;
        View inflate;
        ImageButton imageButton;
        ImageButton imageButton2;
        final C0632c c;
        if (file.exists() || file.mkdir()) {
            c0629a = new C0629a(this.f7649m);
            inflate = LayoutInflater.from(this.f7649m).inflate(R.layout.custom_import_export_dialog, null);
            c0629a.m3311b(inflate);
            imageButton = (ImageButton) inflate.findViewById(R.id.import_data);
            imageButton2 = (ImageButton) inflate.findViewById(R.id.export);
            ((TextView) inflate.findViewById(R.id.export_text)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
            ((TextView) inflate.findViewById(R.id.import_text)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
            c = c0629a.m3315c();
            imageButton.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ SettingsActivity f7642b;

                public void onClick(View view) {
                    c.dismiss();
                    this.f7642b.m12629a("Importing data from SD card");
                    final boolean e = this.f7642b.f7657u.m12737e();
                    final boolean c = this.f7642b.f7656t.m12745c();
                    final boolean c2 = this.f7642b.f7655s.m12711c();
                    new Handler().postDelayed(new Runnable(this) {
                        final /* synthetic */ C22386 f7640d;

                        public void run() {
                            this.f7640d.f7642b.f7658v.dismiss();
                            if (e && c && c2) {
                                Snackbar.m706a(this.f7640d.f7642b.f7654r, "Import Successful", 0).m724a();
                            } else {
                                Snackbar.m706a(this.f7640d.f7642b.f7654r, "Failed to import", 0).m724a();
                            }
                        }
                    }, 2500);
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ SettingsActivity f7648b;

                public void onClick(View view) {
                    c.dismiss();
                    this.f7648b.m12629a("Exporting to SD card");
                    final boolean d = this.f7648b.f7657u.m12736d();
                    final boolean b = this.f7648b.f7656t.m12743b();
                    final boolean b2 = this.f7648b.f7655s.m12708b();
                    new Handler().postDelayed(new Runnable(this) {
                        final /* synthetic */ C22407 f7646d;

                        public void run() {
                            this.f7646d.f7648b.f7658v.dismiss();
                            if (d && b && b2) {
                                Snackbar.m706a(this.f7646d.f7648b.f7654r, "Export successful", 0).m724a();
                            } else {
                                Snackbar.m706a(this.f7646d.f7648b.f7654r, "Failed to export", 0).m724a();
                            }
                        }
                    }, 2500);
                }
            });
            c.show();
        } else {
            c0629a = new C0629a(this.f7649m);
            inflate = LayoutInflater.from(this.f7649m).inflate(R.layout.custom_import_export_dialog, null);
            c0629a.m3311b(inflate);
            imageButton = (ImageButton) inflate.findViewById(R.id.import_data);
            imageButton2 = (ImageButton) inflate.findViewById(R.id.export);
            ((TextView) inflate.findViewById(R.id.export_text)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
            ((TextView) inflate.findViewById(R.id.import_text)).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
            c = c0629a.m3315c();
            imageButton.setOnClickListener(/* anonymous class already generated */);
            imageButton2.setOnClickListener(/* anonymous class already generated */);
            c.show();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_settings);
        m12637k();
        m12639m();
        this.f7652p.setOnCheckedChangeListener(new C22321(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.go_to_date_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                startActivity(new Intent(this, NameAndCriteriaActivity.class).putExtra("Settings", true));
                return;
            case 1:
                startActivity(new Intent(this, PrevAttendanceActivity.class));
                return;
            case 2:
                startActivity(new Intent(this, SubjectsActivity.class).putExtra("Settings", true));
                return;
            case 3:
                startActivity(new Intent(this, WeeklySubjectsActivity.class).putExtra("Settings", true));
                return;
            case 4:
                if (m12640n()) {
                    m12641o();
                    return;
                }
                return;
            case 5:
                C0629a c0629a = new C0629a(this.f7649m);
                c0629a.m3308a(getResources().getString(R.string.reset_attendance));
                c0629a.m3312b(getResources().getString(R.string.reset_attendance_message));
                c0629a.m3313b(getResources().getString(R.string.option_no), new C22354(this));
                c0629a.m3309a(getResources().getString(R.string.option_yes), new C22365(this));
                c0629a.m3314b().show();
                return;
            default:
                return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr[0] == 0) {
            m12641o();
        }
    }
}
