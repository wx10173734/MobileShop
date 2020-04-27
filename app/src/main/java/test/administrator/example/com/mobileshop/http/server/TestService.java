package test.administrator.example.com.mobileshop.http.server;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import test.administrator.example.com.mobileshop.db.Test1;
import test.administrator.example.com.mobileshop.entity.BankEntity;
import test.administrator.example.com.mobileshop.entity.HttpResult;
import test.administrator.example.com.mobileshop.entity.TestEntity;

public interface TestService {
    //用户注册接口
    @FormUrlEncoded
    @POST("api/user/checklogin")
    Observable<HttpResult<TestEntity>> register(
            @Field("username") String uname,
            @Field("password") String password
            //@Field("email") String email

    );
    //用户登录接口
    @FormUrlEncoded
    @POST("api/user/checklogin")
    Observable<HttpResult<TestEntity>> login(
            @Field("username") String uname,
            @Field("password") String password
    );

    /**
     * 其他方式的注解
     * @Path 注解:所有在网址中的参数
     * @Query 注解:URL问号后面的参数
     * @QueryMap注解:相当于多个@Query
     * @Filed注解: 用于Post请求文件，提交单个数据
     * @Body注解:相当于多个@Field，以对象形式提交
     *
     * Post请求方式在使用的时候一定要添加@FormUrlEncoded注解,绝对不能忘记
     */
}
