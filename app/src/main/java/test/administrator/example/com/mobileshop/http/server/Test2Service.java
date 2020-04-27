package test.administrator.example.com.mobileshop.http.server;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import test.administrator.example.com.mobileshop.db.Test2;
import test.administrator.example.com.mobileshop.entity.BankEntity;
import test.administrator.example.com.mobileshop.entity.TestEntity;

public interface Test2Service {
    @GET("api/basic/getCorpList")
     Call<Test2> getTest2List(

     );
}
