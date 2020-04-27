package test.administrator.example.com.mobileshop.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import test.administrator.example.com.mobileshop.R;
import test.administrator.example.com.mobileshop.common.Constants;
import test.administrator.example.com.mobileshop.common.ImageLoaderManager;

public class AdActivity extends AppCompatActivity {
    private ImageView adImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        adImage = findViewById(R.id.ad_image);
        loadAd("https://caiping520.top/ico.jpg");
        Button skipBtn = findViewById(R.id.skip_button);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip();
            }
        });
    }

    /**
     * 加载广告
     *
     * @param url
     */
    public void loadAd(String url) {
        /**
         * 对图片加载过程加入监听,用于监听图片加载过程
         */
        ImageLoader.getInstance().displayImage(url, adImage, ImageLoaderManager.product_options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            /**
             * 加载失败
             * @param imageUri
             * @param view
             * @param failReason
             */
            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                skip();
            }

            /**
             * 加载成功
             * @param imageUri
             * @param view
             * @param loadedImage
             */
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                adImage.setImageBitmap(loadedImage);
                timer();//增加用户的体验效果
            }

            /**
             * 加载关闭
             * @param imageUri
             * @param view
             */
            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                skip();
            }
        });
    }

    /**
     * 跳过功能
     */
    public void skip(){
         startActivity(new Intent(this,MainActivity.class));
         finish();
    }

    /**
     * 3秒等待后跳过
     */
    public void timer(){
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(msg.what == -1){
                    skip();
                }
            }
        };
        //写线程时候不要忘记start() 启动线程,不然无效果
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(Constants.AD_TIME_SECOND);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(-1);
            }
        }.start();
    }
}
