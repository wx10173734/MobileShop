package test.administrator.example.com.mobileshop.db;

import android.content.Context;
import android.util.Log;

import java.util.List;

import test.administrator.example.com.mobileshop.gen.CategoryDao;
import test.administrator.example.com.mobileshop.gen.Test1_ListBeanDao;
import test.administrator.example.com.mobileshop.gen.Test2_ListBeanDao;

public class DbUtils {
    private Context context;
    private CategoryDao categoryDao;
    private Test1_ListBeanDao test1Dao;
    private Test2_ListBeanDao listdao;

    public DbUtils(Context context) {
        this.context = context;
        categoryDao = GreenDaoManager.getInstance().getSession().getCategoryDao();
        test1Dao = GreenDaoManager.getInstance().getSession().getTest1_ListBeanDao();
        listdao = GreenDaoManager.getInstance().getSession().getTest2_ListBeanDao();

    }

    /**
     * 插入数据
     */
    public void add() {
        Category category;
        for (int i = 0; i < 10; i++) {
            int count = i + 1;
            category = new Category(null, "增加商品" + i, "1", 1, count, 12, 112, 1, "123212");
            categoryDao.insert(category);
        }
    }

    public void add_test1(String csrq, String create_time,
                          String modify_time, String mobile, int modify_by, String dept_bm,
                          String is_delete, String create_by, String is_dept_manager,
                          String xb_dm, String nickname, String tel, int id, String sfzjhm,
                          int dept_id, String qtbz_dm, int order_id, String email,
                          String username, String status) {
        Test1_ListBean t1_listbean;
        t1_listbean = new Test1_ListBean(null,csrq,  create_time,
                 modify_time,  mobile,  modify_by,  dept_bm,
                 is_delete,  create_by,  is_dept_manager,
                 xb_dm,  nickname,  tel,  id,  sfzjhm,
         dept_id,  qtbz_dm,  order_id,  email,
                 username,  status);
        test1Dao.insert(t1_listbean);

    }

    public void add_test2(String des, String link_tel,
                          String type_def, String name, int id, String link_name,
                          String no_prefix) {
        Test2_ListBean t2_listBean;
        t2_listBean = new Test2_ListBean(null, des,  link_tel,
                 type_def,  name,  id,  link_name,
                 no_prefix
                );
        listdao.insert(t2_listBean);

    }


    /**
     * 查询所有数据
     *
     * @return
     */
    public List<Category> selectAllData() {
        List<Category> categoryList = categoryDao.loadAll();
        for (Category cate : categoryList) {
            Log.i("======", "========" + cate.getName() + "====" + cate.toString());
        }
        return categoryList;
    }

    public List<Test1_ListBean> selectAllData_test1() {
        List<Test1_ListBean> t1_listbeans = test1Dao.loadAll();
        for (Test1_ListBean t1_listbean : t1_listbeans) {
            Log.i("======", "===test1数据查询结果=====" + t1_listbean.toString());
        }
        return t1_listbeans;
    }

    public List<Test2_ListBean> selectAllData_test2() {
        List<Test2_ListBean> t2_listBeans = listdao.loadAll();
        for (Test2_ListBean t2_listBean : t2_listBeans) {
            Log.i("======", "===test2数据查询结果=====" + t2_listBean.toString());
        }
        return t2_listBeans;
    }

    /**
     * 根据自增ID来查询
     *
     * @param id
     * @return
     */
    public Category selectByID(Long id) {
        return categoryDao.load(id);
    }

    /**
     * 删除指定ID数据
     */
    public void deleteDataByID(Long id) {
        categoryDao.deleteByKey(id);
    }

    /**
     * 数据库数据更新
     * 注:以前操作数据库更新时候,都是根据SQL语言,指定更新对应字段,这边使用了框架
     * 框架会帮我们检索我们上传的对应类中那些字段有所改变,然后进行更新
     *
     * @param category
     */
    public void update(Category category) {
        categoryDao.update(category);

    }

    public void delete_test1() {
        test1Dao.deleteAll();
    }

    public void detele_test2(){
        listdao.deleteAll();
    }
}
