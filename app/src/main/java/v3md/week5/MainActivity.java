package v3md.week5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private BallView MyBall;
    private EditText etDistance;
    private DpadView MyDpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBall = new BallView(this);
        MyDpad = new DpadView(this);

        MyDpad.setMainActivity(this);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);

        MyBall.setLayoutParams(new LinearLayout.LayoutParams(-1, 100, 1f));
        MyDpad.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        layout.addView(MyBall);
        layout.addView(MyDpad);

        if (MyBall == null) {
            Log.e(" MyBall", "MyBall is null");
        }
    }


    private int getDistance(){
//        etDistance=  (EditText) findViewById(R.id.etDistance);

//        return Integer.parseInt(etDistance.getText().toString());
        return 100;
    }

    public void Up(){
        MyBall.ChangePosition(BallView.eDirection.Up, getDistance());
    }
    public void Down(){
        MyBall.ChangePosition(BallView.eDirection.Down, getDistance());
    }

    public void Left(){
        MyBall.ChangePosition(BallView.eDirection.Left, getDistance());
    }

    public void Right(){
        MyBall.ChangePosition(BallView.eDirection.Right, getDistance());
    }

    public void Center(){
        MyBall.ChangePosition(BallView.eDirection.BackToCentre, getDistance());
    }
}
