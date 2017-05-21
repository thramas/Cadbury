package com.pukingminion.cadbury;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samarth on 15/05/17.
 */

public class ShapeView extends View implements ShapeGenerator {
    Paint paint;
    private int color;
    private float xC;
    private float yC;
    private int radius;
    private ShapeSelector shapeSelector;
    private Paint.Style paintStyle = Paint.Style.FILL_AND_STROKE;
    private int numberOfSides = 3;

    public ShapeView(Context context) {
        this(context, null);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShapeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(this.color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (shapeSelector == ShapeSelector.CIRCLE) {
            canvas.drawCircle(this.xC, this.yC, this.radius, this.paint);
        } else {
            getPathForTriangle(canvas);
        }
    }

    private void getPathForTriangle(Canvas canvas) {
        double interiorAngle = (2.0 * Math.PI) / (double) this.numberOfSides;
        paint.setStrokeWidth(4);
        paint.setStyle(this.paintStyle);
        paint.setAntiAlias(true);

        int xPoint = (int) this.xC;
        int yPoint = (int) this.yC;

        float[] pointsArray = new float[4 * this.numberOfSides];
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < this.numberOfSides; i++) {
            Point point = new Point((int) (xPoint + radius * Math.sin(i * interiorAngle)), (int) (yPoint + radius * Math.cos(i * interiorAngle)));
            pointList.add(point);
            Log.d("points", point.x + " ," + point.y);
        }

        int i = 0;
        int counter = 0;

        while (i < this.numberOfSides) {
            if (i < this.numberOfSides - 1) {
                pointsArray[counter++] = pointList.get(i).x;    //x1
                pointsArray[counter++] = pointList.get(i).y;  //y1
                pointsArray[counter++] = pointList.get(i + 1).x;    //x2
                pointsArray[counter++] = pointList.get(i + 1).y;    //y2
            } else {
                pointsArray[counter++] = pointList.get(i).x;    //x1
                pointsArray[counter++] = pointList.get(i).y;  //y1
                pointsArray[counter++] = pointList.get(0).x;    //x2
                pointsArray[counter++] = pointList.get(0).y;    //y2
            }
            i++;
        }

        canvas.drawLines(pointsArray, paint);
    }

    @Override
    public ShapeView setColor(int color) {
        this.color = color;
        paint = new Paint();

        paint.setColor(this.color);
        return this;
    }

    @Override
    public ShapeView setNumberOfSides(int sides) {
        this.numberOfSides = sides;
        return this;
    }

    @Override
    public ShapeView setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    @Override
    public ShapeView setxC(float xC) {
        this.xC = xC;
        return this;
    }

    @Override
    public ShapeView setyC(float yC) {
        this.yC = yC;
        return this;
    }

    @Override
    public ShapeView setShape(ShapeSelector shapeSelector) {
        this.shapeSelector = shapeSelector;
        return this;
    }

    @Override
    public ShapeView setPaintStyle(Paint.Style paintStyle) {
        this.paintStyle = paintStyle;
        return this;
    }
}

