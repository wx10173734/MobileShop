package test.administrator.example.com.mobileshop.activity;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.administrator.example.com.mobileshop.R;
import test.administrator.example.com.mobileshop.common.Constants;
import test.administrator.example.com.mobileshop.db.DbUtils;
import test.administrator.example.com.mobileshop.db.Test1;
import test.administrator.example.com.mobileshop.db.Test2;
import test.administrator.example.com.mobileshop.entity.BankEntity;
import test.administrator.example.com.mobileshop.entity.HttpResult;
import test.administrator.example.com.mobileshop.entity.TestEntity;
import test.administrator.example.com.mobileshop.fragment.NavigationFragment;
import test.administrator.example.com.mobileshop.http.ProgressDialogSubscribe;
//import test.administrator.example.com.mobileshop.http.presenter.MemberPresenter;
import test.administrator.example.com.mobileshop.http.presenter.MemberPresenter;
import test.administrator.example.com.mobileshop.http.server.GoodsService;
import test.administrator.example.com.mobileshop.http.server.MemberService;
import test.administrator.example.com.mobileshop.http.server.Test2Service;
import test.administrator.example.com.mobileshop.http.server.TestService;
import test.administrator.example.com.mobileshop.utils.Person;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NavigationFragment navigationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
        添加主容器
         */
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        navigationFragment = new NavigationFragment();
        transaction.add(R.id.main_fragment, navigationFragment);
        transaction.commit();
        /**
        调用OkHttp测试方法
         */
//        testGet40http();
//        testPost40htpp();

        /**
         * Gson的简单使用
         */
//        testJson(Tools.getAssetsFile(this, "testjson1.txt"));
        //testJsonArr(Tools.getAssetsFile(this, "testjson2.txt"));

        /**
         * 测试Retrofit
         */
        //testGetGoodsDetail();
        //testGetTestDetail();
//        testGetTest1();
//        testGetTest2();
        /**
         * 使用公共封装类
         */
        MemberPresenter.register(new Subscriber<TestEntity>() {
            @Override
            public void onCompleted() {
                Log.i("===","1===onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("===","2==="+e.getMessage());
            }

            @Override
            public void onNext(TestEntity testEntity) {
                Log.i("===","3==="+testEntity.toString());
            }
        },"admin","123456");

        MemberPresenter.login(new ProgressDialogSubscribe<TestEntity>(this) {
            @Override
            public void onNext(TestEntity testEntity) {
                Log.i("===","sucess==="+testEntity.toString());
            }
        },"admin","123456");
    }

    public void showGoods(int goodsId){

    }
    /**
     * 底部标签切换
     * @param tab
     */
    public void changeTab(int tab){
        switch (tab){
            case 1:
                this.navigationFragment.setTabSelection(R.id.tab_item_home);
                break;
            case 2:
                this.navigationFragment.setTabSelection(R.id.tab_item_category);
                break;
            case 3:
                this.navigationFragment.setTabSelection(R.id.tab_item_cart);
                break;
            case 4:
                this.navigationFragment.setTabSelection(R.id.tab_item_personal);
                break;
        }
    }

    /**
     * 优化操作,如果当前activity设置的启动模式为SingleTask，如果当前系统已存在此Activity，则当再次通过Intent
     * 来启动时,不会在调用OnCreate,取而代之的则是下面的onNewIntent方法,好处是对activity重复启动的保护措施
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        String action = intent.getStringExtra("action");
        if ("toIndex".equals(action)){
            changeTab(1);
        }
    }
    /**
     * 点击返回按钮的监听
     * 需要修改NavigationFragment中的参数,private改成public
     */
    @Override
    public void onBackPressed() {
      if (navigationFragment.currentId!=R.id.tab_item_home){
          changeTab(1);
          return;
      }
          super.onBackPressed();
    }
    /**
     * Retrofit+Rxjava的联合封装
     * 1、引入依赖
     * 2、添加MemberService接口
     * 3、实现公共封装类
     * 4、实现对应的业务类，也是我们的是实际调用方法
     * 5、使用公共方法
     * 6、封装一个带有加载进度的订阅者
     */

    /**
     * Rxjava框架的学习,Rxjava 是一个优雅的处理异步操作的框架,，4个基础概念
     * 被观察者:相当于Button控件
     * 观察者:相当于我们onClickListener监听
     * 订阅:相当于setOnClickListener
     * 事件:相当于onClick
     */

    /**
     * Retrofit网络请求框架的学习,是基于OkHttp的用于请求RESTful风格接口的HTTP请求框架
     * 1、引用依赖
     * 2、添加商品数据实体类
     * 3、创建对应的网络接口
     * 4、测试框架的功能，为了方便测试和后期使用,添加常量数据类
     */

    //由于Retrofit是基于OkHttp的,里面部分方法可能会冲突,为了测试,将之前的okthhp的方法暂时注释
    private void testGetGoodsDetail(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)//设置访问地址
                .addConverterFactory(GsonConverterFactory.create())//设置解析方式为Gson
                .build();
        GoodsService service = retrofit.create(GoodsService.class);
        retrofit2.Call<BankEntity> call= service.getGoodsList(2);//调用我们之前写的api接口,需要传递对应的数据page
        //跟Okhttp请求类似
        call.enqueue(new retrofit2.Callback<BankEntity>() {
            @Override
            public void onResponse(retrofit2.Call<BankEntity> call, retrofit2.Response<BankEntity> response) {
                //List<BankEntity> list =response.body();
                //Log.i("==","==="+response.body());
                if (response.body() != null ){
                    String title = response.body().toString();
                    Log.i("========>","===请求成功===>"+title);
                }else{
                    Log.i("========>","===请求成功===>数据为空");
                }

            }

            @Override
            public void onFailure(retrofit2.Call<BankEntity> call, Throwable t) {
                Log.i("-----------","----请求失败----"+t.getMessage());
            }
        });

    }
//    private void testGetTestDetail(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Constants.BASE_URL)//设置访问地址
//                .addConverterFactory(GsonConverterFactory.create())//设置解析方式为Gson
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        MemberService service = retrofit.create(MemberService.class);
//        service.register("admin","123456")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<TestEntity>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.i("+===","onCompleted====");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.i("+===","error===="+e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(TestEntity testEntity) {
//                        Log.i("+===","===="+testEntity.toString());
//                    }
//                });
//        service.login("admin","123")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<TestEntity>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(TestEntity testEntity) {
//                        Log.i("+===","===="+testEntity.toString());
//                    }
//                });
//    }




    /**
     * 1、GreenDao数据库框架的学习使用
     * 2、添加了实体类后,我们来添加依赖,GreenDao在添加依赖时细节比其他库会多一点。
     * 3、通过快捷方式我们自动生成了GreenDao所需的文件,下面我们来写全局配置类
     * 4、添加一个测试类,来测试数据库功能是否正常
     */


        /**
           Gson解析json数据方法
           添加person实体对象和解析方法
            */
        /**
        将json数据转换成对象
         */
    public void testJson(String jsonString) {
//         {
//             "status":0,
//                 "msg":"请求数据成功",
//                 "data":{
//             "id":1,
//                     "name":"晓明",
//                     "address":"常州信息"
//         }
//         }
        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        Gson gson = new Gson();

        Person p = gson.fromJson(jsonObject.get("data"), Person.class);
        Log.i("-----", "=====" + p.toString());


    }

     /**
    将json数据转换成List
     */
     public void testJsonArr(String jsonStr){
         JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
         Gson gson = new Gson();
         List<Person> personList = gson.fromJson(jsonObject.getAsJsonArray("data"),new TypeToken<List<Person>>(){}.getType());
         /**
          * 测试是否转换正确
          */
         for (int i =0;i<personList.size();i++){
             Log.i("=======",i+"======"+personList.get(i).toString());
         }
     }

    /**
     * 取出一个Json数据中的某一个字段
     */
    public void testJsonOneData(String jsonStr){
        JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
        String name = jsonObject.get("data").getAsJsonObject().get("name").getAsString();
        Log.i("=======","=====只输出了name字段的数据==="+name);
    }



    public void testGet40http() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder() //构建Request对象
                .url("https://www.baidu.com") //请求URL
                .get() //请求方式
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("------", "请求失败" + e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("----", "请求成功======>" + response.body().string());
            }
        });

    }

    public void testPost40htpp() {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                //以下的ADD方法是请求是所需要的所有参数,需要根据实际情况来,这边为测试登录用
                .add("id", "154")
                .add("name", "Jack")
                .add("password", "jack123456")
                .build();

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("------", "--------请求失败" + e.getMessage());

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("----", "------请求成功======>" + response.body().string());
            }
        });
    }









}
