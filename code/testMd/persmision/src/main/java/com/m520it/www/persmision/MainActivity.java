package com.m520it.www.persmision;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int sd_p = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        int read_status = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int write_status = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //如果说我的应用还没有获取到读的权限或者写的权限
        if (read_status != PackageManager.PERMISSION_GRANTED || write_status != PackageManager.PERMISSION_GRANTED) {

            //申请权限
            requestPermision(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE});
        } else {
            //有权限
            AddFile();
        }
    }

    public void requestPermision(final String[] permisons) {
        ArrayList<String> shouldShow = new ArrayList<>();

        //查询某个权限之前是否被拒绝过
        for (int i = 0; i < permisons.length; i++) {
            //如果之前被拒了,
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permisons[i])) {
                shouldShow.add(permisons[i]);
            }

        }

        if (shouldShow.size() > 0) {
            //return true
            //用户曾经点击了拒绝，应用需要向用户解释为何需要这个权限
            showMessageOKCancel("欧巴我需要权限将文件写入SD卡，请同意", new AlertDialog.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        ActivityCompat.requestPermissions(MainActivity.this,
                                permisons,
                                sd_p);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            ActivityCompat.requestPermissions(this,
                    permisons,
                    sd_p);
        }


    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .show();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case sd_p:
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Log.i("it520", "permissions = " + permissions[i]);
                        gotoSetting();
                        return;
                    }
                }
                AddFile();
                break;

        }
    }

    public void gotoSetting() {
        Toast.makeText(this, "您好！我们需要使用缓存权限", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", this.getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
    }

    //写一个文件的逻辑代码
    public void AddFile() {
        File file = Environment.getExternalStorageDirectory();
        File sdCache = new File(file, "test");
        if (!sdCache.exists()) {
            sdCache.mkdirs();
        }

        File content = new File(sdCache, "content3.txt");
        if (!content.exists()) {
            try {
                content.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        try {
            bufferedWriter.write("i am so hand some,!!!!!!!!!!!!!!");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
