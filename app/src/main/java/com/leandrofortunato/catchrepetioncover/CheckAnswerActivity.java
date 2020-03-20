package com.leandrofortunato.catchrepetioncover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckAnswerActivity extends AppCompatActivity {
    int[] picsArray = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5};
    TextView txtResult;
    int countNum;
    int imageIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_answer);
        imageIndex = getIntent().getExtras().getInt( "com.collegelasalle.leandro.myfirstgame.picIndex");
        countNum = getIntent().getExtras().getInt( "com.collegelasalle.leandro.myfirstgame.shownNum");

        Log.i("test","picIndex: "+ imageIndex);
        Log.i("test","shownNum: " +countNum);

        ImageView imgView2 = (ImageView)findViewById(R.id.imgView2);
        imgView2.setImageResource(picsArray[imageIndex]);
        imgView2.setVisibility(View.VISIBLE);

        txtResult = (TextView)findViewById((R.id.txtResult));
        Button clickCheck = (Button)findViewById(R.id.btnCheck);
        clickCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TextView txtAnswer = (TextView)findViewById(R.id.txtNumber);
                int answer= Integer.parseInt(txtAnswer.getText().toString());
                if (answer == countNum) {
                    txtResult.setText("Congratulation...You have such a good memory!");
                    txtResult.setTextColor(Color.parseColor("#16d404"));
                    txtResult.setTextAppearance();
                } else {
                    txtResult.setText("Sorry...You almost did it");
                    txtResult.setTextColor(Color.parseColor("#c9020f"));
                }
            }
        });
    }
}
