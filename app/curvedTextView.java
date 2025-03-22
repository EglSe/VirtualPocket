package com.example.vpocket;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView; // Import AppCompatTextView

public class curvedTextView extends AppCompatTextView { // Extend AppCompatTextView

    private Path path;
    private Paint paint;

    public curvedTextView(Context context) {
        super(context);
        init();
    }

    public curvedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public curvedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        path = new Path();
        paint = new Paint();
        paint.setColor(getCurrentTextColor());
        paint.setTextSize(getTextSize());
        paint.setAntiAlias(true);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // Kreipiamės į kreivę, kad tekstas būtų išlenktas
        int width = getWidth();
        int height = getHeight();
        path.addArc(0, height / 2 - 100, width, height / 2 + 100, 180, 180);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Piešiame tekstą pagal kreivę
        canvas.drawTextOnPath(getText().toString(), path, 0, 0, paint);
    }
}
