package test.administrator.example.com.mobileshop.http.server;

import android.app.backup.BackupManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import test.administrator.example.com.mobileshop.entity.BankEntity;
import test.administrator.example.com.mobileshop.entity.TestEntity;
import test.administrator.example.com.mobileshop.utils.GoodsEntity;

public interface GoodsService {
    @GET("getDepartmentList")//设置该接口为Get请求方式,请求接口名为goods，需要传递数据为page，count;
     Call<BankEntity> getGoodsList(
             @Query("corp_id") int corp_id
//             @Query("count") int count
     );

    @FormUrlEncoded
    @POST("getDepartmentList/find") //通过注解方式设置post请求方式, 比get方式多一个注解,  @FormUrlEncoded不能漏
    Call<List<BankEntity>> addReviews(
        @Field("input") String keywords
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
