package nhom17.iuh.ailatrieuphu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class CauTraLoiNTActivity extends AppCompatActivity {
    private TextView lblTraLoi;
    private int luachon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cau_tra_loi_nt);
        lblTraLoi = (TextView)findViewById(R.id.lbl_TL);
        getBundle();
    }
    public void getBundle(){
        Intent intent =getIntent();
        Bundle bundle=intent.getBundleExtra("QQQ");
        int luachon =bundle.getInt("LUACHON");
        char c = bundle.getChar("HIENDAPAN");
        if(luachon == 1)
            lblTraLoi.setText("Tao ĐOÁN đáp án là: "+c+ "\n" +"Ý m thế nào!!! ");
        if(luachon == 2)
            lblTraLoi.setText("Tao chắc chắn đáp án là: " +c + " \n" +
                    "Đùa thôi, Ahihi !!!! ");
        if(luachon == 3)
            lblTraLoi.setText("Ta tuyên bố, đáp án là: "+c+"Tin tao đi ^^");

    }
}
