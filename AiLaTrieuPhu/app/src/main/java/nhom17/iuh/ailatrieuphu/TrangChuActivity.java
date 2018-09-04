package nhom17.iuh.ailatrieuphu;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class TrangChuActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_batdau;
    //private int id_amThanh;
    MediaPlayer nhacnhen= new MediaPlayer();
    //SoundPool amthanhBatDau = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_trang_chu);
        btn_batdau=(Button)findViewById(R.id.btn_TrangChu_BatDau);
        btn_batdau.setOnClickListener(this);

        nhacnhen =MediaPlayer.create(this, R.raw.moman);
        nhacnhen.start();
//        id_amThanh=amthanhBatDau.load(this,R.raw.moman,1);
//        amthanhBatDau.play(id_amThanh,3.0f,3.0f,1,0,3.0f);
    }

    @Override
    protected void onPause() {
        super.onPause();
        nhacnhen.release();
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id)
        {
            case R.id.btn_TrangChu_BatDau:
            {
                Intent myIntent = new Intent(this,MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        }
    }

}
