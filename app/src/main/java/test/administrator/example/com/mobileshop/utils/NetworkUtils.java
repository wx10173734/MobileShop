package test.administrator.example.com.mobileshop.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import java.nio.channels.ConnectionPendingException;

/**
 * 公共网络状态判断方法,提供给整个项目使用
 */
public class NetworkUtils {
    public static boolean isNetworkAvailable(Activity act){
        Context context = act.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null){
            return false;
        }else {
            NetworkInfo[] networkInfoArr = connectivityManager.getAllNetworkInfo();
            /**
             * 空保护
             */
            if (networkInfoArr != null && networkInfoArr.length>0){
                for (int i = 0 ;i< networkInfoArr.length;i++){
                    /**
                     * 判断网络是否为连接状态
                     */
                    if (networkInfoArr[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
