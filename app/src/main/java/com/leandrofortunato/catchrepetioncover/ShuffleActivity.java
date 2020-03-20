package com.leandrofortunato.catchrepetioncover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class ShuffleActivity extends AppCompatActivity {
    int count = 0 ;
    int [] shownPics = new int[5];
    int[] picsArray = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5};
    ImageView ImgView;
    TextView txtRemaining;
    int max= 5; //Integer.parseInt(txtNumber.getText().toString());
    int min=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle);
        ImgView = (ImageView)findViewById((R.id.imgView));
        txtRemaining = (TextView)findViewById(R.id.txtRemaining);
        ImgView.setImageResource(R.drawable.pic1);

        new CountDownTimer(10000, 1000){
                 @Override
                 public void onTick(long millisUntilFinished){
                 if (count % 2 == 0) {

                  int picIndex = new Random().nextInt(max-min)+min;
                  shownPics[picIndex]++;
                  ImgView.setVisibility(View.VISIBLE);
                  ImgView.setImageResource(picsArray[picIndex]);
            }else {
                ImgView.setVisibility(View.INVISIBLE);
                     //ImgView.setImageResource(R.drawable.pic1);
            }
            count++;
            txtRemaining.setText( "Remaining Time:" + (millisUntilFinished/1000));

            }
            @Override
            public  void onFinish(){
                int picIndex = new Random().nextInt(max-min)+min;
                int shownNum =  shownPics[picIndex];
                Log.i("test",picIndex+"");
                Log.i("test",shownNum+"");
                Intent answerActivity = new Intent(getApplicationContext(), CheckAnswerActivity.class);
                answerActivity.putExtra("com.collegelasalle.leandro.myfirstgame.picIndex",picIndex);
                answerActivity.putExtra("com.collegelasalle.leandro.myfirstgame.shownNum",shownNum);
                startActivity(answerActivity);
            }
             }.start();

    }
}
