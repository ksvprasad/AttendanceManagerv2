package dotinc.attendancemanager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.C0196a;
import android.support.v7.p018a.C0633d;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2256a;
import dotinc.attendancemanager2.Utils.C2258b;
import dotinc.attendancemanager2.Utils.C2259c;
import dotinc.attendancemanager2.Utils.C2260d;
import java.io.File;

public class ShowNameCardActivity extends C0633d {
    private C2259c f7662A;
    private C2256a f7663B;
    private C2260d f7664C;
    private Context f7665m;
    private ImageView f7666n;
    private ImageView f7667o;
    private TextView f7668p;
    private TextView f7669q;
    private ProgressBar f7670r;
    private TextView f7671s;
    private TextView f7672t;
    private TextView f7673u;
    private TextView f7674v;
    private Typeface f7675w;
    private Typeface f7676x;
    private Typeface f7677y;
    private Typeface f7678z;

    class C22411 implements Runnable {
        final /* synthetic */ ShowNameCardActivity f7659a;

        C22411(ShowNameCardActivity showNameCardActivity) {
            this.f7659a = showNameCardActivity;
        }

        public void run() {
            if (this.f7659a.m12652m()) {
                this.f7659a.m12655p();
                return;
            }
            this.f7659a.startActivity(new Intent(this.f7659a.f7665m, SubjectsActivity.class).setFlags(268468224));
            this.f7659a.finish();
        }
    }

    class C22422 implements Runnable {
        final /* synthetic */ ShowNameCardActivity f7660a;

        C22422(ShowNameCardActivity showNameCardActivity) {
            this.f7660a = showNameCardActivity;
        }

        public void run() {
            if (this.f7660a.m12652m()) {
                this.f7660a.m12655p();
                return;
            }
            this.f7660a.startActivity(new Intent(this.f7660a.f7665m, SubjectsActivity.class).setFlags(268468224));
            this.f7660a.finish();
        }
    }

    class C22433 implements Runnable {
        final /* synthetic */ ShowNameCardActivity f7661a;

        C22433(ShowNameCardActivity showNameCardActivity) {
            this.f7661a = showNameCardActivity;
        }

        public void run() {
            this.f7661a.m12654o();
            this.f7661a.f7667o.setImageResource(R.mipmap.ic_cloud_done_white_36dp);
            this.f7661a.f7671s.setText("Import Successful");
            this.f7661a.f7670r.setVisibility(8);
            this.f7661a.f7673u.setText("Let's Start");
            this.f7661a.f7673u.setVisibility(0);
        }
    }

    private void m12650k() {
        this.f7665m = this;
        this.f7675w = Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf");
        this.f7676x = Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf");
        this.f7677y = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans-bold.ttf");
        this.f7678z = Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf");
        this.f7666n = (ImageView) findViewById(R.id.user_img);
        this.f7668p = (TextView) findViewById(R.id.user_name);
        this.f7668p.setTypeface(this.f7677y);
        this.f7669q = (TextView) findViewById(R.id.user_perc);
        this.f7669q.setTypeface(this.f7678z);
        this.f7670r = (ProgressBar) findViewById(R.id.progress_bar);
        this.f7670r.getIndeterminateDrawable().setColorFilter(-1, Mode.MULTIPLY);
        this.f7671s = (TextView) findViewById(R.id.check_data_text);
        this.f7671s.setTypeface(this.f7676x);
        this.f7672t = (TextView) findViewById(R.id.import_data);
        this.f7672t.setTypeface(this.f7675w);
        this.f7667o = (ImageView) findViewById(R.id.restore_image);
        this.f7673u = (TextView) findViewById(R.id.fresh_start);
        this.f7673u.setTypeface(this.f7675w);
        this.f7674v = (TextView) findViewById(R.id.or_text);
        this.f7674v.setTypeface(this.f7676x);
        this.f7662A = new C2259c(this.f7665m);
        this.f7663B = new C2256a(this.f7665m);
        this.f7664C = new C2260d(this.f7665m);
        this.f7662A.m12727a();
    }

    private void m12651l() {
        if (Integer.parseInt(C2258b.m12720b(this.f7665m, "USER_IMAGE_ID", String.valueOf(0))) == 1) {
            this.f7666n.setImageResource(R.drawable.user_male);
        } else {
            this.f7666n.setImageResource(R.drawable.user_female);
        }
        this.f7668p.setText(C2258b.m12720b(this.f7665m, "USER_NAME", ""));
        this.f7669q.setText("Attendance Criteria: " + C2258b.m12720b(this.f7665m, "ATTENDANCE_CRITERIA", String.valueOf(0)) + "%");
        this.f7670r.setVisibility(0);
        if (VERSION.SDK_INT >= 23) {
            m12653n();
        } else {
            new Handler().postDelayed(new C22411(this), 2500);
        }
    }

    private boolean m12652m() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        String[] strArr = new String[]{"attendance_track", "subject_name", "timetable_database"};
        return new File(new StringBuilder().append(externalStorageDirectory).append("/AttendanceManager/").append(strArr[0]).toString()).exists() && new File(externalStorageDirectory + "/AttendanceManager/" + strArr[1]).exists() && new File(externalStorageDirectory + "/AttendanceManager/" + strArr[2]).exists();
    }

    private boolean m12653n() {
        if (VERSION.SDK_INT < 23) {
            Log.d("perm", "Permission is granted");
            return true;
        } else if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            Log.d("perm", "Permission is granted");
            return true;
        } else {
            Log.d("perm", "Permission is revoked");
            C0196a.m1230a(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 1);
            return false;
        }
    }

    private void m12654o() {
        this.f7662A.m12737e();
        this.f7663B.m12711c();
        this.f7664C.m12745c();
        this.f7662A.close();
        this.f7663B.close();
        this.f7664C.close();
    }

    private void m12655p() {
        this.f7670r.setVisibility(8);
        this.f7671s.setText("BINGO! Backup Found");
        this.f7672t.setVisibility(0);
        this.f7673u.setVisibility(0);
        this.f7667o.setVisibility(0);
        this.f7674v.setVisibility(0);
    }

    public void freshStart(View view) {
        startActivity(new Intent(this.f7665m, SubjectsActivity.class).setFlags(268468224));
        finish();
    }

    public void importToDatabase(View view) {
        this.f7672t.setVisibility(8);
        this.f7670r.setVisibility(0);
        this.f7673u.setVisibility(8);
        this.f7674v.setVisibility(8);
        this.f7671s.setText("Importing data...");
        new Handler().postDelayed(new C22433(this), 1000);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_show_name_card);
        m12650k();
        m12651l();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr[0] == 0) {
            new Handler().postDelayed(new C22422(this), 2500);
            return;
        }
        startActivity(new Intent(this.f7665m, SubjectsActivity.class).setFlags(268468224));
        finish();
    }
}
