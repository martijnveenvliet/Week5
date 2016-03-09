package v3md.week5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private BallView MyBall;
    private EditText etDistance;

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


    private int getDistance(){
        etDistance=  (EditText) findViewById(R.id.etDistance);

        return Integer.parseInt(etDistance.getText().toString());

    }

    public void Up(View v){
        MyBall.ChangePosition(BallView.eDirection.Up, getDistance());
    }
    public void Down(View v){
        MyBall.ChangePosition(BallView.eDirection.Down, getDistance());
    }

    public void Left(View v){
        MyBall.ChangePosition(BallView.eDirection.Left, getDistance());
    }

    public void Right(View v){
        MyBall.ChangePosition(BallView.eDirection.Right, getDistance());
    }

    public void Centre(View v){
        MyBall.ChangePosition(BallView.eDirection.BackToCentre, getDistance());
    }
}
