package test.administrator.example.com.mobileshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.administrator.example.com.mobileshop.R;

public class SplashActivity extends AppCompatActivity {
    /**
     * 使用快捷键添加部分系统方法
     */
    private static final String TAG = "SplashActivity";
    private ImageView mSplashItem_iv;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    public void initView(){
        mSplashItem_iv=findViewById(R.id.splash_loading_item);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_loading);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /**
                 * 动画结束后的操作
                 */
                startActivity(new Intent(SplashActivity.this,AdActivity.class));
                /**
                 * 添加屏幕切换动画
                 */
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashItem_iv.setAnimation(animation);//为控件添加动画

    }
}
