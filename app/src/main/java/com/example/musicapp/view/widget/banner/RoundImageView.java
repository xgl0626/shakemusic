package com.example.musicapp.view.widget.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author 徐国林
 * @data 2020/5/3
 * @decription
 */
public class RoundImageView extends AppCompatImageView {


    float width, height;

    public RoundImageView(Context context) {
        this(context, null);
        init(context, null);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (width >= 40 && height > 40) {
            Path path = new Path();
            //四个圆角
            path.moveTo(40, 0);
            path.lineTo(width - 40, 0);
            path.quadTo(width, 0, width, 40);
            path.lineTo(width, height - 40);
            path.quadTo(width, height, width - 40, height);
            path.lineTo(40, height);
            path.quadTo(0, height, 0, height - 40);
            path.lineTo(0, 40);
            path.quadTo(0, 0, 40, 0);

            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

}