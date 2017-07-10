package com.hernanbosqued.toolbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

public class RoundedConstraintLayout extends ConstraintLayout {
    private static final float BORDER_WIDTH_PROPORTIONAL_MULTIPLIER = .05f;
    private float cornerRadius;
    private Paint paint;

    public RoundedConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        final Path path = new Path();
        path.addRoundRect(new RectF(0, 0, getWidth(), getHeight()), getHeight() * BORDER_WIDTH_PROPORTIONAL_MULTIPLIER, getHeight() * BORDER_WIDTH_PROPORTIONAL_MULTIPLIER, Path.Direction.CW);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.clipPath(path);
        canvas.drawPath(path, paint);
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int viewUpdatedWidth, int viewUpdatedHeight, int viewOldWidth, int viewOldHeight) {
        super.onSizeChanged(viewUpdatedWidth, viewUpdatedHeight, viewOldWidth, viewOldHeight);
        if (viewUpdatedWidth != viewOldWidth || viewUpdatedHeight != viewOldHeight) {
            cornerRadius = viewUpdatedWidth * BORDER_WIDTH_PROPORTIONAL_MULTIPLIER;
        }
    }
}
