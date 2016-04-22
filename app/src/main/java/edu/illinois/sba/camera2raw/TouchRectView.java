package edu.illinois.sba.camera2raw;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by meowchen on 7/1/15.
 */

public class TouchRectView extends View {
    private Rect rect = null;
    private Paint paint;

    public TouchRectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public Rect getRect() { return rect; }

    public void setRectPaint(Rect rect, Paint paint) {
        this.rect = rect;
        this.paint = paint;
    }

    @Override
    public void onDraw(Canvas canvas) {
        if (rect != null) {
            Log.d("xxx", "on draw");
            canvas.drawRect(
                    rect.left, rect.top, rect.right, rect.bottom,
                    paint);
        }
    }

}