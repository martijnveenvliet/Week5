package v3md.week5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Martijn on 9-3-2016.
 */
public class BallView extends View {

    Bitmap MyBall;
    Paint myPaint = new Paint();
    float fBallX = 0f, fBallY = 0f, fMiddenX = 0f, fMiddenY = 0f;

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
                fBallY =  fBallY + distance;
                break;
            case Up:
                fBallY = fBallY  - distance;
                break;
            case Left:
                fBallX = fBallX - distance;
                break;
            case Right:
                fBallX = fBallX +  distance;
                break;
            case BackToCentre:
                fBallY = fMiddenY;
                fBallX = fMiddenX;
        }

        invalidate();

    }


    public void onMeasure(int specX, int specY){
        int sizeX = MeasureSpec.getSize(specX);
        int sizeY = MeasureSpec.getSize(specY);
        int modeX = MeasureSpec.getMode(specX);
        int modeY = MeasureSpec.getMode(specY);
        int x = 150;
        int y = 150;
        if(modeX == MeasureSpec.EXACTLY || modeX == MeasureSpec.AT_MOST) x = sizeX;
        if(modeY == MeasureSpec.EXACTLY || modeY == MeasureSpec.AT_MOST) y = sizeY;
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
            fBallY = fMiddenY;
        }
        // Ball op dezelfde locatie zetten t.o.v. daarvoor


        invalidate();
    }



}
