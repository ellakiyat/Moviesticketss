package com.realimage.administrator.moviesticket;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageButton;
/*
* The view class is basic building for user interface components
* view occupies rectangular space on the screen, it draws a view it take care of the user interaction between the user and view.
* customview extending one of the view subclasses or view class
* we include a constructor, which will create customview from our xml layout file
* */
public class CircleButton extends ImageButton {
    //these are all constants varaible
 private static final int PRESSED_COLOR_LIGHTUP = 255 / 25;
    private static final int PRESSED_RING_ALPHA = 75;
    private static final int DEFAULT_PRESSED_RING_WIDTH_DIP = 4;
    private static final int ANIMATION_TIME_ID = android.R.integer.config_shortAnimTime;
    private int centerY;
    private int centerX;
    private int outerRadius;
    private int pressedRingRadius;
    private Paint circlePaint;
    private Paint focusPaint;
    private float animationProgress;
    private int pressedRingWidth;
    private int defaultColor = Color.BLACK;
    private int pressedColor;
    private ObjectAnimator pressedAnimator;

    public CircleButton(Context context) {
        super(context);
        init(context, null);
    }

    public CircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (circlePaint != null) {
            circlePaint.setColor(pressed ? pressedColor : defaultColor);
        }
        if (pressed) {
            showPressedRing();
        } else {
            hidePressedRing();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, pressedRingRadius + animationProgress, focusPaint);
        canvas.drawCircle(centerX, centerY, outerRadius - pressedRingWidth, circlePaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;
        outerRadius = Math.min(w, h) / 2;
        pressedRingRadius = outerRadius - pressedRingWidth - pressedRingWidth / 2;
    }

    public float getAnimationProgress() {
        return animationProgress;
    }

    public void setAnimationProgress(float animationProgress) {
        this.animationProgress = animationProgress;
        this.invalidate();
    }

    public void setColor(int color) {
        this.defaultColor = color;
        this.pressedColor = getHighlightColor(color, PRESSED_COLOR_LIGHTUP);
        circlePaint.setColor(defaultColor);
        focusPaint.setColor(defaultColor);
        focusPaint.setAlpha(PRESSED_RING_ALPHA);
        this.invalidate();
    }

    private void hidePressedRing() {
        pressedAnimator.setFloatValues(pressedRingWidth, 0f);
        pressedAnimator.start();
    }

    private void showPressedRing() {
        pressedAnimator.setFloatValues(animationProgress, pressedRingWidth);
        pressedAnimator.start();
    }

    // context--------The context where the customview is used
    /* attributeset---The constructor get the attributes from res/values/attrs.xml  file
       Paint - object that contains the color and style information for our view
    */
    private void init(Context context, AttributeSet attrs) {
        this.setFocusable(true);
       /* this.setScaleType(ScaleType.CENTER_INSIDE);
        setClickable(true);*/
        //Anti-alias produces a smooth edge
        //This work because each time ondraw is called, the canvas is cleared and everything has to be redrawn.
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        focusPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        focusPaint.setStyle(Paint.Style.STROKE);
        pressedRingWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_PRESSED_RING_WIDTH_DIP, getResources()
                .getDisplayMetrics());
        int color = Color.BLACK;
        if (attrs != null) {
            //A typed array of the attribute values from the attrs.xml file
            //obtainStyledAttributes -- return a typed array of the attributes value from the attr.xml file
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleButton);
            color = a.getColor(R.styleable.CircleButton_cb_color, color);
            pressedRingWidth = (int) a.getDimension(R.styleable.CircleButton_cb_pressedRingWidth, pressedRingWidth);
            //The recycle() causes the allocated memory to be returned to the available pool immediately and will not stay until garbage collection
            //shared resource so we need to recycle it
            a.recycle();
        }
        setColor(color);
        focusPaint.setStrokeWidth(pressedRingWidth);
        final int pressedAnimationTime = getResources().getInteger(ANIMATION_TIME_ID);
        pressedAnimator = ObjectAnimator.ofFloat(this, "animationProgress", 0f, 0f);
        pressedAnimator.setDuration(pressedAnimationTime);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(this, "rotation", 360f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(this, "rotation", 360f);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
        set1.setDuration(2000);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(
                ObjectAnimator.ofFloat(this, "scaleX", 0f, 1f)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(this, "scaleY", 0f, 1f)
                        .setDuration(2000)
        );
        ObjectAnimator fadeout = ObjectAnimator.ofFloat(this, "alpha", 1f, .2F);
        fadeout.setDuration(2000);
        ObjectAnimator fadein = ObjectAnimator.ofFloat(this, "alpha", .2f, 1f);
        fadein.setDuration(2000);
        final AnimatorSet set3 = new AnimatorSet();
        set3.play(fadein).after(fadeout);
        set3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                set3.start();
            }
        });
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(this, "translationY", -200f);
        animator1.setRepeatCount(0);
        animator1.setDuration(1000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "translationY", 100f);
        animator2.setRepeatCount(0);
        animator2.setDuration(1000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(this, "translationY", 0f);
        animator3.setRepeatCount(0);
        animator3.setDuration(1000);
        //sequencial animation
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).before(animator2);
        set.play(animator2).before(animator3);
        ObjectAnimator rota = ObjectAnimator.ofFloat(this,"rotation",0,360);
        rota.setDuration(2000);
        final AnimatorSet rot = new AnimatorSet();
        rot.play(rota);
        rot.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                rot.start();
            }
        });
        AnimatorSet set5 = new AnimatorSet();
        set5.playSequentially(set1, set2, set3,set,rot);
        set5.start();
    }
    private int getHighlightColor(int color, int amount) {
        return Color.argb(Math.min(255, Color.alpha(color)), Math.min(255, Color.red(color) + amount),
                Math.min(255, Color.green(color) + amount), Math.min(255, Color.blue(color) + amount));
    }
}
/* Note the following
* our constructor receive two parameters,
* */