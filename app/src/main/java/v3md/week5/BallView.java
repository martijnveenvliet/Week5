package v3md.week5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Martijn on 9-3-2016.
 */
public class BallView extends View {

    Bitmap MyBall;
    Paint myPaint = new Paint();
    float fBallX = 0f, fBallY = 0f, fMiddenX = 0f, fMiddenY = 0f, fScreenSizeX = 0f, fScreenSizeY = 0f;

    public BallView(Context context) {
        super(context);
        MyBall = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        myPaint.setColor(0xff000000);
        myPaint.setTextSize(16);


    }

    public BallView(Context context, AttributeSet attrs) {
        super(context);
        MyBall = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        myPaint.setColor(0xff000000);
        myPaint.setTextSize(16);
    }

    public void onDraw(Canvas c){
        c.drawBitmap(MyBall, fBallX, fBallY, myPaint);
    }

    public enum eDirection  {
        Up,
        Down,
        Left,
        Right,
        BackToCentre
    }

    public void ChangePosition(eDirection direction, int distance){

        switch(direction){
            case Down:
                if(fBallY + distance > fScreenSizeY){
                    break;
                }
                fBallY =  fBallY + distance;
                break;
            case Up:
                if(fBallY - distance < 0){
                    break;
                }
                fBallY = fBallY  - distance;
                break;
            case Left:
                if(fBallX - distance < 0){
                    break;
                }
                fBallX = fBallX - distance;
                break;
            case Right:
                if(fBallX + distance > fScreenSizeX){
                    break;
                }
                fBallX = fBallX +  distance;
                break;
            case BackToCentre:
                fBallY = fMiddenY;
                fBallX = fMiddenX;
        }

        invalidate();

    }


    public void onMeasure(int specX, int specY){
        int specx = MeasureSpec.getSize(specX);
        int specy = MeasureSpec.getSize(specY);

        int modeX = MeasureSpec.getMode(specX);
        int modeY = MeasureSpec.getMode(specY);

        int x = 150;
        int y = 150;

        if(modeX == MeasureSpec.EXACTLY ) x =  specx;
        if(modeY == MeasureSpec.EXACTLY ) y =  specy;


        fScreenSizeX = x;
        fScreenSizeY = y;
        
        Log.i("onMeasure", "ModeX: " + modeX + " ModeY: " + modeY);

        setMeasuredDimension(x, y);
    }

    public void onSizeChanged(int w, int h, int oldw, int oldh){
        fMiddenX = w/2;
        fMiddenY = h/2;

        float iPlaceX, iPlaceY;

        if(oldw != 0 && oldh != 0){
            iPlaceX = fBallX / (float) oldw;
            fBallX = (float) w * iPlaceX;

            iPlaceY = fBallY / (float) oldh;
            fBallY = (float) h * iPlaceY;
        }
        else{
            fBallX = fMiddenX;
            fBallX = fBallX - (MyBall.getWidth() / 2);

            fBallY = fMiddenY;
            fBallY = fBallY - (MyBall.getHeight() / 2);
        }
        // Ball op dezelfde locatie zetten t.o.v. daarvoor


        invalidate();
    }



}
