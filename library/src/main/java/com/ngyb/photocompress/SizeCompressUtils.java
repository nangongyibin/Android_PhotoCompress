package com.ngyb.photocompress;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：尺寸压缩
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/27 13:45
 */
public class SizeCompressUtils {

    /**
     * 尺寸压缩
     *
     * @param bitmap 需要压缩Bitmap图片对象
     * @param file   压缩后图片保存的地址
     * @param ratio  尺寸压缩倍数，值越大，图片尺寸越小
     * @param config 默认用ARGB_8888——代表32位ARGB位图
     * @param format 压缩后的图片的格式 默认Bitmap.CompressFormat.JPEG
     */
    public static void sizeCompress(Bitmap bitmap, File file, int ratio, Bitmap.Config config, Bitmap.CompressFormat format) {
        if (config == null) {
            //默认用ARGB_8888——代表32位ARGB位图
            config = Bitmap.Config.ARGB_8888;
        }
        //压缩Bitmap到对应尺寸
        //创建位图
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth() / ratio, bitmap.getHeight() / 2, config);
        // 创建Rect
        Rect rect = new Rect(0, 0, bitmap.getWidth() / ratio, bitmap.getHeight() / ratio);
        // 创建画布
        Canvas canvas = new Canvas(bitmap);
        // 画图
        canvas.drawBitmap(result, null, rect, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (format == null) {
            //默认Bitmap.CompressFormat.JPEG
            format = Bitmap.CompressFormat.JPEG;
        }
        //将压缩后的图片数据写入到ByteArrayOutputStream
        result.compress(format, 100, baos);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            // 把缓冲区中的数据强行输出
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
