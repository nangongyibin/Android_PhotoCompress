package com.ngyb.photocompress;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/27 12:24
 */
public class QualityCompressUtils {

    /**
     * 质量压缩
     * 设置Btimap  options属性，降低图片的质量，图片的像素不会少
     *
     * @param bitmap  需要压缩Bitmap图片对象
     * @param file    压缩后图片保存的地址
     * @param format  压缩后的图片的格式
     * @param quality 0-100 100代表不压缩
     */
    public static void qualityCompress(Bitmap bitmap, File file, Bitmap.CompressFormat format, int quality) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //将压缩后的数据存放到ByteArrayOutputStream中
        bitmap.compress(format, quality, baos);
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
