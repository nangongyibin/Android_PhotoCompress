package com.ngyb.photocompress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：采样率压缩
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/27 14:14
 */
public class SamplingRateCompressUtils {

    /**
     * 采样率压缩
     *
     * @param pathName     图片的路径
     * @param inSampleSize 采样率的值
     * @param format       压缩后的图片的格式 默认Bitmap.CompressFormat.JPEG
     */
    public static void samplingRateCompress(String pathName, int inSampleSize, Bitmap.CompressFormat format, File file) {
        // 创建BitmapFactory.Options
        BitmapFactory.Options options = new BitmapFactory.Options();
        // 默认值为false，如果设置成true，那么在解码的时候就不会返回Bitmap,即Bitmap =null
        options.inJustDecodeBounds = false;
        // 改变Bitmap的分辨率大小
        options.inSampleSize = inSampleSize;
        Bitmap bitmap = BitmapFactory.decodeFile(pathName, options);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (format == null) {
            //默认Bitmap.CompressFormat.JPEG
            format = Bitmap.CompressFormat.JPEG;
        }
        //将压缩后的图片数据写入到ByteArrayOutputStream
        bitmap.compress(format, 100, baos);
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
