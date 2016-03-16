package v3md.week5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Martijn on 16-3-2016.
 */
public class DpadView extends View {

    Bitmap MyDpad;
    Paint myPaint = new Paint();
    float fDpadX = 0f, fDpadY = 0f, fMiddenX = 0f, fMiddenY = 0f;
    MainActivity activity;

    public DpadView(Context context) {
        super(context);

        MyDpad = BitmapFactory.decodeResource(getResources(), R.drawable.dpad);
        myPaint.setColor(0xff000000);
        myPaint.setTextSize(16);

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int x = (int) event.getX();
                int y = (int) event.getY();

                btnClicked buttonClicked = GetbuttonClicked(x, y);

                if(buttonClicked == btnClicked.TOP){
                    activity.Up();
                }else  if(buttonClicked == btnClicked.BOTTOM){
                    activity.Down();
                }else  if(buttonClicked == btnClicked.LEFT){
                    activity.Left();
                }else  if(buttonClicked == btnClicked.RIGHT){
                    activity.Right();
                }else if(buttonClicked == btnClicked.CENTER){
                    activity.Center();
                }

                Log.i("OnTouch: ", "X: " + x + " Y: " + y);
                return false;
            }
        });
    }

    enum btnClicked{
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        CENTER,
        NOTHING
    }
    private btnClicked GetbuttonClicked(int x, int y){
        btnClicked buttonClicked;

        if(x >= 486 && x <= 592 && y >= 22 && y <= 137){
            buttonClicked = btnClicked.TOP;
        }else if(x >= 601 && x <= 725 && y >= 144 && y <= 252){
            buttonClicked = btnClicked.RIGHT;
        } else if(x >= 491 && x <= 599 && y >= 259 && y <=369){
            buttonClicked = btnClicked.BOTTOM;
        }else if(x >= 355 && x <= 486 && y >= 147 && y <= 247){
            buttonClicked = btnClicked.LEFT;
        } else if(x >= 486 && x <= 596 && y >= 147 && y <= 257){
            buttonClicked = btnClicked.CENTER;
        }else{
            buttonClicked = btnClicked.NOTHING;
        }

        return buttonClicked;

    }
    public DpadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void onDraw(Canvas c){
        c.drawBitmap(MyDpad, fDpadX, fDpadY, myPaint);
    }

    public void setMainActivity(MainActivity activity){
        this.activity = activity;
    }


    public void onMeasure(int specX, int specY){
        int sizeX = MeasureSpec.getSize(specX);
        int sizeY = MeasureSpec.getSize(specY);
        int modeX = MeasureSpec.getMode(specX);
        int modeY = MeasureSpec.getMode(specY);
        int x = 150;
        int y = 400;

        if(modeX == MeasureSpec.EXACTLY ) x = sizeX;
        if(modeY == MeasureSpec.EXACTLY ) y = sizeY;

        Log.i("onMeasure", "ModeX: " + modeX + " ModeY: " + modeY);

        setMeasuredDimension(x, y);
    }

    public void onSizeChanged(int w, int h, int oldw, int oldh){
        fMiddenX = w/2;
        fMiddenY = h/2;

        float iPlaceX, iPlaceY;

        if(oldw != 0 && oldh != 0){
            iPlaceX = fDpadX / (float) oldw;
            fDpadX = (float) w * iPlaceX;

            iPlaceY = fDpadY / (float) oldh;
            fDpadY = (float) h * iPlaceY;
        }
        else{
            fDpadX = fMiddenX;
            fDpadX = fDpadX - (MyDpad.getWidth() / 2);

            fDpadY = fMiddenY;
            fDpadY = fDpadY - (MyDpad.getHeight() / 2);

        }
        // Ball op dezelfde locatie zetten t.o.v. daarvoor


        invalidate();
    }


}
