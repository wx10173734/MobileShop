package test.administrator.example.com.mobileshop.http;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Member;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import test.administrator.example.com.mobileshop.common.Constants;
import test.administrator.example.com.mobileshop.entity.HttpResult;
import test.administrator.example.com.mobileshop.http.server.GoodsService;
import test.administrator.example.com.mobileshop.http.server.MemberService;

public class HttpMethods {
    protected static final String BASE_URL = Constants.BASE_URL;
    private static final int DEFAULT_TIMEOUT = 5;
    protected static final String TAG = "HttpMethods";
    private Retrofit retrofit;
    private static HttpMethods mInstance;
    protected static MemberService memberService;

    public HttpMethods() {
        if (mInstance == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            memberService = retrofit.create(MemberService.class);
        }
    }

    public static HttpMethods getInstance() {
        if (mInstance == null) {
            synchronized (HttpMethods.class) {
                if (mInstance == null) {
                    mInstance = new HttpMethods();
                }
            }
        }
        return mInstance;
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     *            <p>
     *            Func1 是 RxJava 的一个接口，用于包装含有一个参数的方法，其包装的方法具有返回值
     */
    public static class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
        @Override
        public T call(HttpResult<T> httpResult) {
            Log.i(TAG, "status:" + httpResult.getStatus());
            Log.i(TAG, "msg:" + httpResult.getMsg());
            Log.i(TAG, "data:" + httpResult.getData());
            return httpResult.getData();
        }
    }


    //公共部分
    public static <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
