package dotinc.attendancemanager2.p044b;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import dotinc.attendancemanager2.MainActivity;
import dotinc.attendancemanager2.R;

public class C2309f extends Fragment {
    private ImageView f7927a;
    private Button f7928b;
    private Button f7929c;
    private int f7930d = 0;

    class C23071 implements OnClickListener {
        final /* synthetic */ C2309f f7925a;

        C23071(C2309f c2309f) {
            this.f7925a = c2309f;
        }

        public void onClick(View view) {
            this.f7925a.f7930d = this.f7925a.f7930d + 1;
            switch (this.f7925a.f7930d) {
                case 1:
                    this.f7925a.f7929c.setVisibility(0);
                    this.f7925a.f7927a.setImageResource(R.drawable.tutorial2);
                    return;
                case 2:
                    this.f7925a.f7927a.setImageResource(R.drawable.tutorial3);
                    return;
                case 3:
                    this.f7925a.f7927a.setImageResource(R.drawable.tutorial4);
                    return;
                case 4:
                    this.f7925a.f7927a.setImageResource(R.drawable.tutorial5);
                    this.f7925a.f7928b.setText("Got it!");
                    return;
                case 5:
                    this.f7925a.m1200j().m1461f().mo224a().mo190a(this.f7925a).mo187a();
                    ((MainActivity) this.f7925a.m1200j()).m12585m();
                    return;
                default:
                    return;
            }
        }
    }

    class C23082 implements OnClickListener {
        final /* synthetic */ C2309f f7926a;

        C23082(C2309f c2309f) {
            this.f7926a = c2309f;
        }

        public void onClick(View view) {
            this.f7926a.f7930d = this.f7926a.f7930d - 1;
            switch (this.f7926a.f7930d) {
                case 0:
                    this.f7926a.f7929c.setVisibility(8);
                    this.f7926a.f7927a.setImageResource(R.drawable.tutorial1);
                    return;
                case 1:
                    this.f7926a.f7927a.setImageResource(R.drawable.tutorial2);
                    this.f7926a.f7928b.setText("Next");
                    return;
                case 2:
                    this.f7926a.f7927a.setImageResource(R.drawable.tutorial3);
                    this.f7926a.f7928b.setText("Next");
                    return;
                case 3:
                    this.f7926a.f7927a.setImageResource(R.drawable.tutorial4);
                    this.f7926a.f7928b.setText("Next");
                    return;
                default:
                    return;
            }
        }
    }

    public View mo1786a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tutorial, viewGroup, false);
        this.f7927a = (ImageView) inflate.findViewById(R.id.image);
        this.f7928b = (Button) inflate.findViewById(R.id.next_btn);
        this.f7929c = (Button) inflate.findViewById(R.id.prev_btn);
        return inflate;
    }

    public void mo202d(Bundle bundle) {
        super.mo202d(bundle);
        this.f7928b.setOnClickListener(new C23071(this));
        this.f7929c.setOnClickListener(new C23082(this));
    }
}
