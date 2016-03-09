package v3md.week5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BallView MyBall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBall = (BallView) findViewById(R.id.MyBall);
    }

    public void Up(View v){
        MyBall.ChangePosition(BallView.eDirection.Up, 10);
    }
    public void Down(View v){
        MyBall.ChangePosition(BallView.eDirection.Down, 10);
    }

    public void Left(View v){
        MyBall.ChangePosition(BallView.eDirection.Left, 10);
    }

    public void Right(View v){
        MyBall.ChangePosition(BallView.eDirection.Right, 10);
    }
}
