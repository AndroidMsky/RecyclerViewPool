package com.example.recyclerviewpool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by air on 2019/3/12.
 */
public class FloorView extends ImageView {
    private Bitmap[] bitmaps=new Bitmap[0];
    public FloorView(Context context) {
        super(context);
        init();
    }

    public FloorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FloorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i]= BitmapFactory.decodeResource(getResources(),R.drawable.pic1);
        }
        Log.e("lmtlmt","init");

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.e("lmtlmt","onAttachedToWindow");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e("lmtlmt","onDetachedFromWindow");
    }
}
