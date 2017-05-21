package com.pukingminion.cadbury;

import android.graphics.Paint;

/**
 * Created by Samarth on 15/05/17.
 */

interface ShapeGenerator {

    ShapeView setColor(int color);

    ShapeView setNumberOfSides(int sides);

    ShapeView setRadius(int radius);

    ShapeView setxC(float xC);

    ShapeView setyC(float yC);

    ShapeView setShape(ShapeSelector shapeSelector);

    ShapeView setPaintStyle(Paint.Style paintStyle);
}
