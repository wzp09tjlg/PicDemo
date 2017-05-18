package com.example.wuzp.picdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * 这里的demo 主要是尝试将图片放置到不同的drawble下边，然后使用bitmapfactory加载进来，图片的大小。
 * 之前没有注意 直接将图片放置在drawable文件夹中 运行时加载会耗费很大的内存。
 * 将图片分别放置到drawable-hdpi,drawable-xhdpi,drawable-xxhdpi 中可以看到在运行时
 * 加载进来的图片所占内存的大小，图片的长宽等信息。
 * 图片原本大小 48*48  (504b)
 *                   图片放置的位置    加载进来图片长宽  图片大小
 *                   drawable          144*144           20736   (20.25Kb)
 *                   drawable-hdpi     96*96             9216    (9Kb)
 *                   drawable-xhdpi    72*72             5184    (5.06Kb)
 *                   drawable-xxhdpi   48*48             2304    (2.25Kb)
 * */
public class MainActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        img = (ImageView)findViewById(R.id.img);
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.scan_back, options);
        img.setImageBitmap(bitmap);
        int sum = options.outWidth * options.outHeight;
        int width = options.outWidth;
        int height = options.outHeight;

        Log.e("wuzp","w:" + width + "  h:" + height + "  sum:" + sum);
    }
}
