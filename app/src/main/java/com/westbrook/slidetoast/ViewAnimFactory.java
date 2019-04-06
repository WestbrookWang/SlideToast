package com.westbrook.slidetoast;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class ViewAnimFactory {


    private View view;

    private ViewAnimListener listener;

    private WindowManager windowManager;

    private WindowManager.LayoutParams params;

    /**
     * 改变大小
     *
     * @param width
     */
    public void setWidth(int width) {
        view.getLayoutParams().width = width;

        view.requestLayout();

        listener.onWidth(width);
    }

    public void setAlpha(float alpha){
        view.setAlpha(alpha);
        view.requestLayout();

        Log.e("alpha------>",alpha+"");
    }

    public void setWindowManager(WindowManager windowManager, WindowManager.LayoutParams params){
        this.windowManager = windowManager;
        this.params = params;
    }

    public void setY(int y){

        params.y = y;

        windowManager.updateViewLayout(view,params);

    }


    public void setListener(ViewAnimListener listener){
        this.listener = listener;
    }

    public int getWidth(){

        return view.getLayoutParams().width;

    }

    public void setView(View view) {
        this.view = view;
    }

    public void setHeight(int height) {
        view.getLayoutParams().height = height;
    }



    public interface ViewAnimListener{

        void onWidth(int width);

    }

}
