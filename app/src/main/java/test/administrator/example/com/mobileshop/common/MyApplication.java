package test.administrator.example.com.mobileshop.common;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;

import test.administrator.example.com.mobileshop.db.GreenDaoManager;
import test.administrator.example.com.mobileshop.http.HttpMethods;

/**
 * 只创建了Application，不去引用也是无效的，需要在AndroidManifest.xml中引用
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化mContext;
        mContext = getApplicationContext();

        //GreenDao 全局初始化,只初始化一次,防止多次初始化
        GreenDaoManager.getInstance();

        //全局初始化Retrofit公共类
        HttpMethods.getInstance();

        //全局初始化图片加载管理类
        ImageLoaderManager.getInstance();
    }
    public static Context getContext(){
        return mContext;
    }
}
