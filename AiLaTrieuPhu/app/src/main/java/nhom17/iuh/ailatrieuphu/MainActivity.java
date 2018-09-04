package nhom17.iuh.ailatrieuphu;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btn_TrangChu,btn_KhanGia,btn50_50,btnNg_than;
    private TextView lb_Cauhoi,lbl_tongTien;
    private Button btn_DAA,btn_DAB,btn_DAC,btn_DAD;
    private CheckBox chkAmThanh;
    private  Button btn_Cautieptheo;
    private ArrayList<CauHoi> dsCauHoi =new ArrayList<CauHoi>();
    private String[] caudatraloi;
    private int cauhoiso=1;
    private  int id_cauhoi;
    private  boolean chienthang=false;
    private double tongTien=0;
    public static final String KETQUA="KETQUA";
    public static final String BUNDLE="BUNDLE";
    MediaPlayer nhacnen= new MediaPlayer();
    public int[] arrayCauhoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        btn_TrangChu=(ImageButton)findViewById(R.id.btn_Main_TrangChu);
        btn_KhanGia=(ImageButton)findViewById(R.id.btn_KhanGia);
        btn50_50=(ImageButton)findViewById(R.id.btn_5050);
        btnNg_than=(ImageButton)findViewById(R.id.btn_NguoiThan);
        lb_Cauhoi=(TextView)findViewById(R.id.lb_CauHoi);
        lbl_tongTien=(TextView)findViewById(R.id.lbl_Tien);
        chkAmThanh = (CheckBox)findViewById(R.id.chkAmThanh);

        btn_DAA=(Button)findViewById(R.id.btn_DapAn1);
        btn_DAB=(Button)findViewById(R.id.btn_DapAn2);
        btn_DAC=(Button)findViewById(R.id.btn_DapAn3);
        btn_DAD=(Button)findViewById(R.id.btn_DapAn4);
        btn_Cautieptheo=(Button)findViewById(R.id.btn_Main_Cauke);
        btn_TrangChu.setOnClickListener(this);
        btn_KhanGia.setOnClickListener(this);
        btn50_50.setOnClickListener(this);
        btnNg_than.setOnClickListener(this);
        btn_DAA.setOnClickListener(this);
        btn_DAB.setOnClickListener(this);
        btn_DAC.setOnClickListener(this);
        btn_DAD.setOnClickListener(this);
        btn_Cautieptheo.setOnClickListener(this);

//        int[] numArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
//        shuffleArray(numArray);

        LoadData();
        DualieulenUI(cauhoiso);
        nhacnen = MediaPlayer.create(this,R.raw.nhacnenn);
        nhacnen.start();

        chkAmThanh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b)
                    nhacnen.stop();
                else{
                    try {
                        nhacnen.prepare();
                        nhacnen.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        nhacnen.pause();
//    }

    @Override
    public void onClick(View view) {
    int id=view.getId();
    switch (id)
    {
        case R.id.btn_DapAn1:
            btn_DAA.setBackgroundColor(Color.parseColor("#E41E26"));
            KiemtraketQuavaLammoi(cauhoiso,1,dsCauHoi.get(id_cauhoi).getDapAn());
            break;
        case R.id.btn_DapAn2:
            btn_DAB.setBackgroundColor(Color.parseColor("#E41E26"));
            KiemtraketQuavaLammoi(cauhoiso,2,dsCauHoi.get(id_cauhoi).getDapAn());
            break;
        case R.id.btn_DapAn3:
            btn_DAC.setBackgroundColor(Color.parseColor("#E41E26"));
            KiemtraketQuavaLammoi(cauhoiso,3,dsCauHoi.get(id_cauhoi).getDapAn());
            break;
        case R.id.btn_DapAn4:
            btn_DAD.setBackgroundColor(Color.parseColor("#E41E26"));
            KiemtraketQuavaLammoi(cauhoiso,4,dsCauHoi.get(id_cauhoi).getDapAn());
            break;
        case R.id.btn_Main_TrangChu:
            nhacnen.stop();
            finish();
            Intent myIntentMain = new Intent(this, TrangChuActivity.class);
            startActivity(myIntentMain);
            break;
        case R.id.btn_KhanGia:
            GuiBundle(dsCauHoi.get(id_cauhoi).getDapAn());
            btn_KhanGia.setVisibility(View.INVISIBLE);
            break;
        case R.id.btn_Main_Cauke:
            cauhoiso++;
            if (cauhoiso==5)
            {
                Toast.makeText(MainActivity.this,"Đây là một trong ba mốc quan trọng!!",Toast.LENGTH_LONG).show();
            }
            if (cauhoiso==10)
            {
                Toast.makeText(MainActivity.this,"Đây là một trong ba mốc quan trọng!!!",Toast.LENGTH_LONG).show();
            }
            if (cauhoiso==15)
            {
                Toast.makeText(MainActivity.this,"Đây là câu hỏi cuối cùng, hãy cố gắng!!!",Toast.LENGTH_LONG).show();
                chienthang =true;
            }
            btn_Cautieptheo.setVisibility(View.GONE);
            DualieulenUI(cauhoiso);
            Khoanut(false);
            break;
        case R.id.btn_5050:
            if(dsCauHoi.get(id_cauhoi).getDapAn()==1)
            {
                btn_DAB.setVisibility(View.INVISIBLE);
                btn_DAB.setClickable(false);
                btn_DAC.setVisibility(View.INVISIBLE);
                btn_DAC.setClickable(false);
            }
            if(dsCauHoi.get(id_cauhoi).getDapAn()==2)
            {
                btn_DAA.setVisibility(View.INVISIBLE);
                btn_DAA.setClickable(false);
                btn_DAC.setVisibility(View.INVISIBLE);
                btn_DAC.setClickable(false);
            }
            if(dsCauHoi.get(id_cauhoi).getDapAn()==3)
            {
                btn_DAA.setVisibility(View.INVISIBLE);
                btn_DAA.setClickable(false);
                btn_DAD.setVisibility(View.INVISIBLE);
                btn_DAD.setClickable(false);
            }
            if(dsCauHoi.get(id_cauhoi).getDapAn()==4)
            {
                btn_DAB.setVisibility(View.INVISIBLE);
                btn_DAB.setClickable(false);
                btn_DAA.setVisibility(View.INVISIBLE);
                btn_DAA.setClickable(false);
            }
            btn50_50.setVisibility(View.INVISIBLE);
            break;
        case R.id.btn_NguoiThan:
            GuiBundleNguoiThan();
            btnNg_than.setVisibility(View.INVISIBLE);
            break;
        }
    }
    public void LoadData()
    {
        //Đọc câu hỏi từ file
        InputStream input = getResources().openRawResource(R.raw.data);
        Scanner sc =new Scanner(input);
        String data="";
        while (sc.hasNextLine())
            data+=sc.nextLine()+"-";
        sc.close();
        //Đẩy câu hỏi vào mảng câu hỏi
        String[] a = data.split("-");
        for(int run =0;run<a.length;run=run+7)
        {
            dsCauHoi.add(new CauHoi(Integer.parseInt(a[run+0]), a[run+1],
                    a[run+2], a[run+3], a[run+4],a[run+5],Integer.parseInt(a[run+6])));
        }
    }
    public void DualieulenUI(int cauhoiso)
    {
        btn50_50.setEnabled(true);
        btnNg_than.setEnabled(true);
        btn_KhanGia.setEnabled(true);
        btn_DAA.setVisibility(View.VISIBLE);
        btn_DAB.setVisibility(View.VISIBLE);
        btn_DAC.setVisibility(View.VISIBLE);
        btn_DAD.setVisibility(View.VISIBLE);
        btn_DAA.setClickable(true);
        btn_DAB.setClickable(true);
        btn_DAC.setClickable(true);
        btn_DAD.setClickable(true);
        btn_DAA.setBackgroundColor(Color.parseColor("#D6D7D7"));
        btn_DAB.setBackgroundColor(Color.parseColor("#D6D7D7"));
        btn_DAC.setBackgroundColor(Color.parseColor("#D6D7D7"));
        btn_DAD.setBackgroundColor(Color.parseColor("#D6D7D7"));
        lbl_tongTien.setText(tongTien+"00 VNĐ");
        id_cauhoi=phatSinhCauHoi();
        lb_Cauhoi.setText("Câu hỏi "+cauhoiso+": "+dsCauHoi.get(id_cauhoi).getNoidung()+"");
        btn_DAA.setText("A."+ dsCauHoi.get(id_cauhoi).getA());
        btn_DAB.setText("B."+ dsCauHoi.get(id_cauhoi).getB());
        btn_DAC.setText("C."+ dsCauHoi.get(id_cauhoi).getC());
        btn_DAD.setText("D."+ dsCauHoi.get(id_cauhoi).getD());
    }
    public void KiemtraketQuavaLammoi(int cauhoiso,int luachon,int ketqua)
    {
        if(ketqua==luachon)
        {
            if(luachon==1)
            {
                btn_DAA.setBackgroundColor(Color.parseColor("#17BE45"));
                Khoanut(true);
                if(cauhoiso==0)
                    tongTien = tongTien+100;
                if(cauhoiso>0 && cauhoiso <4)
                    tongTien = tongTien+200;
                if(cauhoiso==4)
                    tongTien = 1000000;
                if(cauhoiso>4 && cauhoiso<15)
                    tongTien = tongTien+2000;
                if(cauhoiso>=15)
                    tongTien = tongTien*2;
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
                btn_Cautieptheo.setVisibility(View.VISIBLE);

            }
            else if(luachon==2)
            {
                btn_DAB.setBackgroundColor(Color.parseColor("#17BE45"));
                Khoanut(true);
                if(cauhoiso==0)
                    tongTien = tongTien+100;
                if(cauhoiso>0 && cauhoiso <4)
                    tongTien = tongTien+200;
                if(cauhoiso==4)
                    tongTien = 1000000;
                if(cauhoiso>4 && cauhoiso<15)
                    tongTien = tongTien+2000;
                if(cauhoiso>=15)
                    tongTien = tongTien*2;
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
               btn_Cautieptheo.setVisibility(View.VISIBLE);
            }
            else if(luachon==3)
            {
                btn_DAC.setBackgroundColor(Color.parseColor("#17BE45"));
                Khoanut(true);
                if(cauhoiso==0)
                    tongTien = tongTien+100;
                if(cauhoiso>0 && cauhoiso <4)
                    tongTien = tongTien+200;
                if(cauhoiso==4)
                    tongTien = 1000;
                if(cauhoiso>4 && cauhoiso<15)
                    tongTien = tongTien+2000;
                if(cauhoiso>=15)
                    tongTien = tongTien*2;
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
                btn_Cautieptheo.setVisibility(View.VISIBLE);

            }
            else if(luachon==4)
            {
                btn_DAD.setBackgroundColor(Color.parseColor("#17BE45"));
                //Khoanut(true);
                if(cauhoiso==0)
                    tongTien = tongTien+100;
                if(cauhoiso>0 && cauhoiso <4)
                    tongTien = tongTien+200;
                if(cauhoiso==4)
                    tongTien = 1000000;
                if(cauhoiso>4 && cauhoiso<15)
                    tongTien = tongTien+2000;
                if(cauhoiso>=15)
                    tongTien = tongTien*2;
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
                btn_Cautieptheo.setVisibility(View.VISIBLE);
            }
////            Toast.makeText(MainActivity.this,"Đây là câu trả lời đúng, xin chúc mừng",Toast.LENGTH_SHORT).show();
//            cauhoiso++;
//            //btn_Cautieptheo.setVisibility(View.GONE);
//            DualieulenUI(cauhoiso);
//            // Khoanut(false);
//          //  break;
            if (chienthang==true){
                Toast.makeText(MainActivity.this,"Chúc mừng, bạn đã trở thành triệu phú. TRÒ CHƠI KẾT THÚC!!",Toast.LENGTH_LONG).show();
                GuiDialog(tongTien);
            }
        }
        else
        {
            int i =dsCauHoi.get(cauhoiso).getDapAn();
            if(i==1)
            {
                btn_DAA.setBackgroundColor(Color.parseColor("#17BE45"));
                if(cauhoiso<4)
                    tongTien=0;
                if(cauhoiso>=4 && cauhoiso<9)
                    tongTien=1000000;
                if(cauhoiso>=9 && cauhoiso<14)
                    tongTien=10000000;
                if(cauhoiso>=14 && cauhoiso<19)
                    tongTien=20000000;
                nhacnen.stop();
                GuiDialog(tongTien);
                Khoanut(true);
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);

            }
            else if(i==2)
            {
                btn_DAB.setBackgroundColor(Color.parseColor("#17BE45"));
                if(cauhoiso<4)
                    tongTien=0;
                if(cauhoiso>=4 && cauhoiso<9)
                    tongTien=1000;
                if(cauhoiso>=9 && cauhoiso<14)
                    tongTien=10000;
                if(cauhoiso>=14 && cauhoiso<19)
                    tongTien=20000;
                nhacnen.stop();
                GuiDialog(tongTien);
                Khoanut(true);
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
            }
            else if(i==3)
            {
                btn_DAC.setBackgroundColor(Color.parseColor("#17BE45"));
                if(cauhoiso<4)
                    tongTien=0;
                if(cauhoiso>=4 && cauhoiso<9)
                    tongTien=1000;
                if(cauhoiso>=9 && cauhoiso<14)
                    tongTien=10000;
                if(cauhoiso>=14 && cauhoiso<19)
                    tongTien=20000;
                nhacnen.stop();
                GuiDialog(tongTien);
                Khoanut(true);
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
            }
            else if(i==4)
            {
                btn_DAD.setBackgroundColor(Color.parseColor("#17BE45"));
                if(cauhoiso<4)
                    tongTien=0;
                if(cauhoiso>=4 && cauhoiso<9)
                    tongTien=1000;
                if(cauhoiso>=9 && cauhoiso<14)
                    tongTien=10000;
                if(cauhoiso>=14 && cauhoiso<19)
                    tongTien=20000;
                nhacnen.stop();
                GuiDialog(tongTien);
                Khoanut(true);
                btn50_50.setEnabled(false);
                btnNg_than.setEnabled(false);
                btn_KhanGia.setEnabled(false);
            }
        }
    }
    public void Khoanut(boolean b)
    {
        btn_DAA.setEnabled(!b);
        btn_DAB.setEnabled(!b);
        btn_DAC.setEnabled(!b);
        btn_DAD.setEnabled(!b);
        btn_TrangChu.setEnabled(!b);

    }
    public void ThongBaoThua()
    {
        Dialog dialog =new Dialog(MainActivity.this);
        dialog.setTitle("Bạn đã thua :v");
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_dialog);
        Button btn_Ok=(Button)dialog.findViewById(R.id.btn_Dialog_OK);
        //Button btn_NO=(Button)dialog.findViewById(R.id.btn_Dialog_No);
        dialog.show();
        btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(MainActivity.this,"Ha ha ha!",Toast.LENGTH_LONG).show();
                Intent khangiaIntent=new Intent(MainActivity.this,TrangChuActivity.class);
                startActivity(khangiaIntent);
            }
        });
    }
    public void GuiBundle(int kq)
    {
        Intent khangiaIntent=new Intent(this,KhanGiaActivity.class);
        Bundle bundle =new Bundle();
        bundle.putInt(KETQUA,kq);
        khangiaIntent.putExtra(BUNDLE,bundle);
        startActivity(khangiaIntent);
    }
    public void GuiBundleNguoiThan()
    {
        Intent chienIntent =  new Intent(MainActivity.this, NguoiThanActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("DAPAN11",dsCauHoi.get(id_cauhoi).getDapAn());
        chienIntent.putExtra("chienpro",bundle);
        startActivity(chienIntent);
    }

    public void GuiDialog(double tongTien)
    {
        Intent dialogIntent=new Intent(this,DialogActivity.class);
        Bundle bundle =new Bundle();
        bundle.putDouble("THONGBAO",tongTien);
        dialogIntent.putExtra("TIEN",bundle);
        startActivity(dialogIntent);
    }
    public int phatSinhCauHoi(){
        Random rand = new Random();
        int a = rand.nextInt(29)+1;
        return a;
    }
}
