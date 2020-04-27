package test.administrator.example.com.mobileshop.utils;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaUtil {
    /**
     * 创建观察者的两种方法
     * 方法一:
     */
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {

        }
    };

    /**
     * 方法二和方法一几乎一样
     */
    Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {

        }
    };
    /**
     * 创建被观察者方法,修改默认菜蔬,然后重新通过快捷键导入对应的方法大即可
     */
    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("hello1");
            subscriber.onNext("hello2");
            subscriber.onNext("hello3");
            //以上三局给任务定义一个名字,根据名字的先后设置的名字,进行任务的执行
            subscriber.onCompleted();
        }
    });


}
