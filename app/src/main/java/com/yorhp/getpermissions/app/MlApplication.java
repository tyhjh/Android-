package com.yorhp.getpermissions.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;
import com.yorhp.getpermissions.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Tyhj on 2017/5/23.
 */

public class MlApplication extends Application {
    private static MlApplication instance;
    public static final boolean ISDEBUG = true;
    public static ArrayList<Activity> activities=new ArrayList<>();
    public static String rootDir;

    public static String wxAppId="wxd0c9b5829b5491bb";

    public void onCreate() {
        super.onCreate();
        instance = this;
        initPicasso();
        initDir();
    }

    //Picasso初始化
    private void initPicasso() {
        Picasso picasso = new Picasso.Builder(this)
                .memoryCache(new LruCache(10 << 20))//设置内存缓存大小10M
                //.indicatorsEnabled(false) //设置左上角标记，主要用于测试
                .build();
        Picasso.setSingletonInstance(picasso);
    }

    //文件夹初始化
    public void initDir() {
        File f1 = new File(Environment.getExternalStorageDirectory() + getApplicationContext().getString(R.string.path_savaphotopath));
        if (!f1.exists()) {
            f1.mkdirs();
        }
        rootDir= Environment.getExternalStorageDirectory()+getApplicationContext().getString(R.string.path_savaphotopath);
    }

    //打印初始化
    public static void log(String key, String value) {
        if (ISDEBUG)
            Log.e(key, value+"");
    }

    public static Context getAppContexts() {
        return instance;
    }

    public static void closeAllActivity(){
        int leanth=activities.size();
        for(int i=0;i<leanth;i++){
            activities.get(i).finish();
        }
    }
}


//
//                               _oo0oo_
//                             o8888888o
//                              88" . "88
//                               (|  -_-  |)
//                              0\  =  /0
//                            ___/`---'\___
//                          .' \\|          |// '.
//                        / \\|||     :    |||// \
//                      / _ |||||    -:-   ||||| - \
//                     |   | \\\     -    /// |   |
//                     | \_ |  ''\ --- /''  |_ / |
//                     \  .- \__  '-'  ___/-. /
//                     ___'. .'  /--.--\  `. .'___
//              ."" '<  `.___\_<|>_/___.' >' "".
//            | | :  `- \ `.;` \     _    / `;.` / - ` : | |
//            \  \   `_.   \_  __\ /__  _/   .-`  /  /
// =====`-.____`.___ \_____/___.-`___.-'=====
//                             `=---='
//
//
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//
