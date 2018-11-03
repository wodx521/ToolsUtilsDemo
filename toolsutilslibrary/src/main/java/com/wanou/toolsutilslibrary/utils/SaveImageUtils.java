package com.wanou.toolsutilslibrary.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author wodx521
 * @date on 2018/8/14
 */
public class SaveImageUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void initSaveImage(Application application) {
        context = application;
    }

    /**
     * 这个方法只能保存view中显示的绘制图片，图片不是原图
     *
     * @param view     要保存的view
     * @param filePath 存储文件路径
     */
    public static void saveBitmapCache(View view, String filePath) {
        //开启绘制缓存
        view.setDrawingCacheEnabled(true);
        Bitmap imageBitmap = view.getDrawingCache();
        FileOutputStream outStream = null;
        File file = new File(filePath);
        //如果是目录不允许保存
        if (file.isDirectory()) {
            return;
        }
        try {
            outStream = new FileOutputStream(file);
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            imageBitmap.recycle();
            //关闭绘制缓存
            view.setDrawingCacheEnabled(false);
        }
    }

    /**
     * 只能保存ImageView中的图片,且只能获取静态图
     *
     * @param imageView 要保存图片的ImageView
     * @param filePath  文件路径
     */
    public static void saveImageViewBitmap(ImageView imageView, String filePath) {
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        FileOutputStream outStream = null;
        File file = new File(filePath);
        // 如果是目录不允许保存
        if (file.isDirectory()) {
            return;
        }
        try {
            outStream = new FileOutputStream(file);
            Drawable current = drawable.getCurrent();
            Bitmap bitmap = ((BitmapDrawable) current).getBitmap();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        }
    }

    /**
     * 可保存所有view显示的内容,讲view内容绘制成bitmap并保存
     *
     * @param view     要保存图片的View
     * @param filePath 文件路径
     */
    public static void saveViewBitmap(View view, String filePath) {
        // 创建对应大小的bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),
                Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        //存储
        FileOutputStream outStream = null;
        File file = new File(filePath);
        //如果是目录不允许保存
        if (file.isDirectory()) {
            return;
        }
        try {
            outStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bitmap.recycle();
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
        }
    }
}
