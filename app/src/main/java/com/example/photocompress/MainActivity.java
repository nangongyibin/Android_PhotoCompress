package com.example.photocompress;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ngyb.photocompress.QualityCompressUtils;
import com.ngyb.photocompress.SamplingRateCompressUtils;
import com.ngyb.photocompress.SizeCompressUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 7219);
    }

    public void pc1(View view) {
        String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "1.jpg";
        Log.e(TAG, "pc1: " + path);
        SizeCompressUtils.sizeCompress(BitmapFactory.decodeResource(getResources(), R.mipmap.example), new File(path), 5, Bitmap.Config.ARGB_8888, Bitmap.CompressFormat.JPEG);

    }

    public void pc2(View view) {
        String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "11.jpg";
        Log.e(TAG, "pc2: " + path);
        QualityCompressUtils.qualityCompress(BitmapFactory.decodeResource(getResources(), R.mipmap.example),
                new File(path),
                Bitmap.CompressFormat.JPEG,
                50);
    }

    public void pc3(View view) {
        String path111 = Environment.getExternalStorageDirectory().getPath() + File.separator + "a.jpg";

        String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "111.jpg";
        Log.e(TAG, "pc3: " + path);
        SamplingRateCompressUtils.samplingRateCompress(path111,8,Bitmap.CompressFormat.JPEG,new File(path));
    }
}
