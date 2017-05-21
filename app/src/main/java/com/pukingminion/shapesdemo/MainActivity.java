package com.pukingminion.shapesdemo;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import com.pukingminion.cadbury.DisplayUtilities;
import com.pukingminion.cadbury.ShapeSelector;
import com.pukingminion.cadbury.ShapeView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayUtilities.setDensity(this);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.parent_layout);

        ShapeView shapeView = new ShapeView(this)
                .setShape(ShapeSelector.TRIANLE)
                .setColor(Color.RED)
                .setRadius(DisplayUtilities.dp(20))
                .setNumberOfSides(3)
                .setPaintStyle(Paint.Style.FILL)
                .setxC(500)
                .setyC(500);

        linearLayout.addView(shapeView);


    }
}
