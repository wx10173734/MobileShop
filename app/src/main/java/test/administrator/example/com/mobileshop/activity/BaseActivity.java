package test.administrator.example.com.mobileshop.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import test.administrator.example.com.mobileshop.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}

//    public void showGoods(int goodsId){
//        Intent intent =new Intent(this,GoodsActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);//依旧设置为启动时不使用动画
//        intent.putExtra("goodsId",goodsId);
//        startActivity(intent);
//    }