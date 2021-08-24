package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer=1;//0 minato 1kakashi
    String winer="";

    int gamestate[]={2,2,2,2,2,2,2,2,2};
    int winningPos[][]={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};
    public void dropin(View view) {
        ImageView counter = (ImageView) view;
        String y = counter.getTag().toString();
        Log.i("Tag", String.valueOf(y));
        //Toast.makeText(this,"Num"+y,Toast.LENGTH_LONG).show();
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappedCounter] == 2 ) {
            gamestate[tappedCounter] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 1) {
                counter.setImageResource(R.drawable.kakashi);
                activePlayer = 0;
            } else {
                counter.setImageResource(R.drawable.minato);
                activePlayer = 1;
            }
            counter.animate().translationYBy(1500).rotation(1500).setDuration(1000);
            for (int[] i : winningPos) {
                if (gamestate[i[0]] == gamestate[i[1]] && gamestate[i[1]] == gamestate[i[2]] && gamestate[i[0]] != 2) {
                    int u = gamestate[i[1]];
                    if (u == 1) winer = "Kakashi";
                    else winer = "Minato";
                    Toast.makeText(this, "Winner is " + winer, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}