package com.realimage.administrator.moviesticket;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    Paint paint;
    Path path;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(150,150,100,paint);
    }
}
/*
    ObjectAnimator darkerFade = ObjectAnimator.ofInt(view, "alpha", 0, 255);
darkerFade.setDuration(1000);
        ObjectAnimator lighterFade = ObjectAnimator.ofInt(view, "rotation", 0, 360);
        lighterFade.setDuration(1000);
        mAnim.playSequentially(darkerFade, lighterFade);
        mAnim.addListener(new AnimatorListenerAdapter() {
@Override
public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        mAnim.start();
        }
        });
        mAnim.start();
*/
