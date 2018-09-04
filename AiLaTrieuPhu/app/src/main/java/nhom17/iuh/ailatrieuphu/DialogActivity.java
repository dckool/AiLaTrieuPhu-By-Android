package nhom17.iuh.ailatrieuphu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView lbl_Tien;
    private Button btn_Ok;
    private double tien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        lbl_Tien=(TextView)findViewById(R.id.lbl_dialog_tien);
        getBundle();
        lbl_Tien.setText(tien+"00 VNĐ");
        btn_Ok= (Button)findViewById(R.id.btn_Dialog_OK);
        btn_Ok.setOnClickListener(this);
    }
    public void getBundle()
    {
        Intent intent =getIntent();
        Bundle bundle=intent.getBundleExtra("TIEN");
        tien=bundle.getDouble("THONGBAO");
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_Dialog_OK)
        {
            finish();
            Intent myIntentMain = new Intent(this, TrangChuActivity.class);
            startActivity(myIntentMain);
        }

    }
}
