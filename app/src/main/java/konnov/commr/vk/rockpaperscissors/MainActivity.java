package konnov.commr.vk.rockpaperscissors;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final int ROCK = 1;
    public final int PAPER = 2;
    public final int SCISSORS = 3;

    TextView scoreOutput;
    TextView whoWon;
    ImageView rockPic;
    ImageView paperPic;
    ImageView scissorsPic;
    static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whoWon = (TextView) findViewById(R.id.who_won_text);
        scoreOutput = (TextView) findViewById(R.id.score_text_view);
        rockPic = (ImageView) findViewById(R.id.rock);
        paperPic = (ImageView) findViewById(R.id.paper);
        scissorsPic = (ImageView) findViewById(R.id.scissors);

        rockPic.setOnClickListener(this);
        paperPic.setOnClickListener(this);
        scissorsPic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.rock:
                mainGame(ROCK);
                break;
            case R.id.paper:
                mainGame(PAPER);
                break;
            case R.id.scissors:
                mainGame(SCISSORS);
                break;
            default:break;
        }
    }

    public void mainGame(int playerSelect){
        Random random = new Random();
        int computerTurn = 1 + random.nextInt(3);
        if(playerSelect == 1) {
            switch (computerTurn) {
                case 1:
                    whoWon.setText(R.string.rock_rock);
                    scoreOutput.setText(getString(R.string.score, score));
                    break;
                case 2:
                    whoWon.setText(R.string.rock_paper);
                    score--;
                    scoreOutput.setText(getString(R.string.score, score));
                    break;
                case 3:
                    whoWon.setText(R.string.rock_scissors);
                    score++;
                    scoreOutput.setText(getString(R.string.score, score));
            }
        }

        if(playerSelect == 2) {
            switch (computerTurn) {
                case 1:
                    whoWon.setText(R.string.paper_rock);
                    score++;
                    scoreOutput.setText(getString(R.string.score, score));
                    break;
                case 2:
                    whoWon.setText(R.string.paper_paper);
                    scoreOutput.setText(getString(R.string.score, score));
                    break;
                case 3:
                    whoWon.setText(R.string.paper_scissors);
                    score--;
                    scoreOutput.setText(getString(R.string.score, score));
            }
        }

        if(playerSelect == 3){
            switch (computerTurn){
                case 1:
                    whoWon.setText(R.string.scissors_rock);
                    score--;
                    scoreOutput.setText(getString(R.string.score, score));
                    break;
                case 2:
                    whoWon.setText(R.string.scissors_paper);
                    score++;
                    scoreOutput.setText(getString(R.string.score, score));
                    break;
                case 3:
                    whoWon.setText(R.string.scissors_scissors);
                    scoreOutput.setText(getString(R.string.score, score));
            }
        }
    }
}
