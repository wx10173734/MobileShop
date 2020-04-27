package test.administrator.example.com.mobileshop.db;

import test.administrator.example.com.mobileshop.common.MyApplication;
import test.administrator.example.com.mobileshop.gen.DaoMaster;
import test.administrator.example.com.mobileshop.gen.DaoSession;

public class GreenDaoManager {
    private static GreenDaoManager mInstance;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    public GreenDaoManager(){
        if(mInstance == null){
            /**
             * 初始化并设置数据库名,其中缺少 MyApplication 全局类
             */
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(),
                    "mydb",null);
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public  static GreenDaoManager getInstance(){
        if (mInstance == null){
            synchronized (GreenDaoManager.class){
                if(mInstance == null){
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }
    public static DaoMaster getMaster(){
        return mDaoMaster;
    }
    public static DaoSession getSession(){
        return mDaoSession;
    }
    public  static  DaoSession getNewSession(){
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
