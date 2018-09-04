package nhom17.iuh.ailatrieuphu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class NguoiThanActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton imgbtn1,imgbtn2,imgbtn3;
    private int luaChon;
    char c = 'Q';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_nguoi_than);
        imgbtn1 = (ImageButton)findViewById(R.id.imgbtn_1);
        imgbtn2 = (ImageButton)findViewById(R.id.imgbtn_2);
        imgbtn3 = (ImageButton)findViewById(R.id.imgbtn_3);
        imgbtn1.setOnClickListener(this);
        imgbtn2.setOnClickListener(this);
        imgbtn3.setOnClickListener(this);

        Intent intent =getIntent();
        Bundle bundle=intent.getBundleExtra("chienpro");
        int ketqua = bundle.getInt("DAPAN11");
        if (ketqua==1) {
            c = 'A';
        }
        if (ketqua==2) {
            c = 'B';
        }
        if (ketqua==3) {
            c = 'C';
        }
        if (ketqua==4) {
            c = 'D';
        }

    }
    public void GuiLuaChon(int luaChon, char c)
    {
        Intent dialogIntent=new Intent(this,CauTraLoiNTActivity.class);
        Bundle bundle =new Bundle();
        bundle.putInt("LUACHON",luaChon);
        bundle.putChar("HIENDAPAN",c);
        dialogIntent.putExtra("QQQ",bundle);
        startActivity(dialogIntent);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent = getIntent();
        switch(id)
        {
            case R.id.imgbtn_1:
                luaChon=1;
                GuiLuaChon(luaChon,c);
                finish();
                break;
            case R.id.imgbtn_2:
                luaChon=2;
                GuiLuaChon(luaChon,c);
                finish();
                break;
            case R.id.imgbtn_3:
                luaChon=3;
                GuiLuaChon(luaChon,c);
                finish();
                break;

        }
    }
}
