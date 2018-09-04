package nhom17.iuh.ailatrieuphu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class KhanGiaActivity extends AppCompatActivity {
    private TextView txt1,txt2,txt3,txt4;
    private ProgressBar bar1,bar2,bar3,bar4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_khan_gia);
        txt1=(TextView)findViewById(R.id.textView5);
        txt2=(TextView)findViewById(R.id.textView6);
        txt3=(TextView)findViewById(R.id.textView7);
        txt4=(TextView)findViewById(R.id.textView8);
        bar1=(ProgressBar)findViewById(R.id.progressBar3);
        bar2=(ProgressBar)findViewById(R.id.progressBar4);
        bar3=(ProgressBar)findViewById(R.id.progressBar5);
        bar4=(ProgressBar)findViewById(R.id.progressBar6);
        getBundle();
    }
    public void getBundle()
    {
        Intent intent =getIntent();
        Bundle bundle=intent.getBundleExtra(MainActivity.BUNDLE);
        int ketqua=bundle.getInt(MainActivity.KETQUA);
        Random rd =new Random();
        if(ketqua==1)
        {
            int gt=rd.nextInt(51)+50;
            txt1.setText("Đáp án A: "+gt+"%");
            bar1.setProgress(gt);
            txt2.setText("Đáp án B: "+((100-gt)/5)+"%");
            bar2.setProgress((100-gt)/5);
            txt3.setText("Đáp án C: "+((100-gt)/2)+"%");
            bar3.setProgress((100-gt)/3);
            txt4.setText("Đáp án D: "+((100-gt)/3)+"%");
            bar4.setProgress((100-gt)/2);
        }
        else if(ketqua==2)
        {
            int gt=rd.nextInt(51)+50;
            txt1.setText("Đáp án A: "+((100-gt)/5)+"%");
            bar1.setProgress((100-gt)/5);
            txt2.setText("Đáp án B: "+gt+"%");
            bar2.setProgress(gt);
            txt3.setText("Đáp án C: "+((100-gt)/2)+"%");
            bar3.setProgress((100-gt)/3);
            txt4.setText("Đáp án D: "+((100-gt)/3)+"%");
            bar4.setProgress((100-gt)/2);
        }
        else if(ketqua==3)
        {
            int gt=rd.nextInt(51)+50;
            txt1.setText("Đáp án A: "+((100-gt)/2)+"%");
            bar1.setProgress((100-gt)/3);
            txt2.setText("Đáp án B: "+((100-gt)/5)+"%");
            bar2.setProgress((100-gt)/5);
            txt3.setText("Đáp án C: "+gt+"%");
            bar3.setProgress(gt);
            txt4.setText("Đáp án D: "+((100-gt)/3)+"%");
            bar4.setProgress((100-gt)/2);
        }
        else if(ketqua==4)
        {
            int gt=rd.nextInt(51)+50;
            txt1.setText("Đáp án A: "+((100-gt)/2)+"%");
            bar1.setProgress((100-gt)/3);
            txt2.setText("Đáp án B: "+((100-gt)/5)+"%");
            bar2.setProgress((100-gt)/5);
            txt3.setText("Đáp án C: "+((100-gt)/3)+"%");
            bar3.setProgress((100-gt)/2);
            txt4.setText("Đáp án D: "+gt+"%");
            bar4.setProgress(gt);
        }

    }
}
