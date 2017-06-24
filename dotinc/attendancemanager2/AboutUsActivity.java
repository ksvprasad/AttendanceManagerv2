package dotinc.attendancemanager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.p018a.C0633d;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import dotinc.attendancemanager2.Utils.C2258b;

public class AboutUsActivity extends C0633d {
    private TextView f7396m;
    private TextView f7397n;
    private TextView f7398o;
    private Button f7399p;
    private Context f7400q;

    class C21941 implements OnClickListener {
        final /* synthetic */ AboutUsActivity f7395a;

        C21941(AboutUsActivity aboutUsActivity) {
            this.f7395a = aboutUsActivity;
        }

        public void onClick(View view) {
            C2258b.m12717a("Rated through the app", C2258b.m12720b(this.f7395a.f7400q, "USER_NAME", ""), C2258b.m12720b(this.f7395a.f7400q, "USER_IMAGE_ID", "0"), this.f7395a.f7400q);
            this.f7395a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=dotinc.attendancemanager2")));
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_about_us);
        this.f7400q = this;
        C2258b.m12717a("Opened About Us", C2258b.m12720b(this.f7400q, "USER_NAME", ""), C2258b.m12720b(this.f7400q, "USER_IMAGE_ID", "0"), this.f7400q);
        this.f7396m = (TextView) findViewById(R.id.app_name);
        this.f7399p = (Button) findViewById(R.id.rateUs);
        this.f7399p.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7396m.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-bold.ttf"));
        this.f7397n = (TextView) findViewById(R.id.app_ver);
        this.f7397n.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/oxygen-regular.ttf"));
        this.f7398o = (TextView) findViewById(R.id.company);
        this.f7398o.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/josefin_sans_regular.ttf"));
        this.f7399p.setOnClickListener(new C21941(this));
    }
}
