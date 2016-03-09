package v3md.week5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private BallView MyBall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBall = new BallView(this);


        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout.addView(MyBall);

        if (MyBall == null) {
            Log.e(" MyBall", "MyBall is null");
        }
    }



    public void Up(View v){
        Log.e(" Main", "Up");
        MyBall.ChangePosition(BallView.eDirection.Up, 10);
    }
    public void Down(View v){
        Log.e(" Main", "Down");
        MyBall.ChangePosition(BallView.eDirection.Down, 10);
    }

    public void Left(View v){
        Log.e(" Main", "Left");
        MyBall.ChangePosition(BallView.eDirection.Left, 10);
    }

    public void Right(View v){
        Log.e(" Main", "Right");
        MyBall.ChangePosition(BallView.eDirection.Right, 10);
    }
}
