package com.westbrook.slidetoast;

import android.animation.ObjectAnimator;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private View slideView;

    WindowManager windowManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

        slideView = View.inflate(this,R.layout.slide_view,null);

        slideView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("------->","click");
            }
        });

        windowManager = getWindowManager();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showSlideView();

            }
        });

    }



    private void showSlideView(){


        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_FULLSCREEN,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.y = 200;
//        params.x = 100;

        windowManager.addView(slideView, params);




        ViewAnimFactory viewAnimFactory = new ViewAnimFactory();

        viewAnimFactory.setView(slideView);

        viewAnimFactory.setWindowManager(windowManager,params);


        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(viewAnimFactory,"y", 200,0);

        objectAnimator.setDuration(500);

        objectAnimator.start();

    }


}
