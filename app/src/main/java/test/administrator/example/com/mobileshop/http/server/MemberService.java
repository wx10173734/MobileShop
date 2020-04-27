package test.administrator.example.com.mobileshop.http.server;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import test.administrator.example.com.mobileshop.entity.HttpResult;
import test.administrator.example.com.mobileshop.entity.MemberEntity;
import test.administrator.example.com.mobileshop.entity.TestEntity;

/**
 * 用户登录和注册对加密型要求高
 * 因为服务器接口用的是Post方法,这边请求也是Post方法
 * 因此我们再写接口类的时候需要根据我们服务端的对应的接口请求方式进行编写。
 */
public interface MemberService {

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

}
