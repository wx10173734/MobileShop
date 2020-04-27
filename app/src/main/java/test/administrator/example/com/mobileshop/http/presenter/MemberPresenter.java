package test.administrator.example.com.mobileshop.http.presenter;

import rx.Observable;
import rx.Subscriber;
import test.administrator.example.com.mobileshop.entity.TestEntity;
import test.administrator.example.com.mobileshop.http.HttpMethods;

public class MemberPresenter extends HttpMethods {
    /**
     *用户注册
     * @param subscriber
     *
     */
    public static void register(Subscriber<TestEntity> subscriber, String username, String password){
        Observable observable = memberService.register(username,password)
                .map(new HttpResultFunc<TestEntity>());//创建被观察者
        toSubscribe(observable,subscriber);//订阅
    }

    /**内部使用几乎一样,调用的方法不一样
     * 用户登录
     * @param subscriber
     * @param username
     * @param password
     */
    public static void login(Subscriber<TestEntity> subscriber,String username,String password){
        Observable observable = memberService.login(username,password)
                .map(new HttpResultFunc<TestEntity>());//创建被观察者
        toSubscribe(observable,subscriber);//订阅
    }

}
