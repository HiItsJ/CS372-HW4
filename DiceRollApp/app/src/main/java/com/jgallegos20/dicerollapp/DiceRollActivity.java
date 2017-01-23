package com.jgallegos20.dicerollapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DiceRollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ImageView img_dice1 = (ImageView)findViewById(R.id.imageView6);
                img_dice1.setImageResource(R.drawable.dice1);
                ImageView img_dice2 = (ImageView)findViewById(R.id.imageView7);
                img_dice2.setImageResource(R.drawable.dice2);
                ImageView img_dice3 = (ImageView)findViewById(R.id.imageView8);
                img_dice1.setImageResource(R.drawable.dice3);
                ImageView img_dice4 = (ImageView)findViewById(R.id.imageView9);
                img_dice1.setImageResource(R.drawable.dice4);
            }
        });
    }
}
