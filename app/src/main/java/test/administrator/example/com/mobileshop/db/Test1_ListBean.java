package test.administrator.example.com.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Test1_ListBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long test1_id;
    private String csrq;
    private String create_time;
    private String modify_time;
    private String mobile;
    private int modify_by;
    private String dept_bm;
    private String is_delete;
    private String create_by;
    private String is_dept_manager;
    private String xb_dm;
    private String nickname;
    private String tel;
    private int id;
    private String sfzjhm;
    private int dept_id;
    private String qtbz_dm;
    private int order_id;
    private String email;
    private String username;
    private String status;






    @Generated(hash = 1353545797)
    public Test1_ListBean(Long test1_id, String csrq, String create_time,
            String modify_time, String mobile, int modify_by, String dept_bm,
            String is_delete, String create_by, String is_dept_manager,
            String xb_dm, String nickname, String tel, int id, String sfzjhm,
            int dept_id, String qtbz_dm, int order_id, String email,
            String username, String status) {
        this.test1_id = test1_id;
        this.csrq = csrq;
        this.create_time = create_time;
        this.modify_time = modify_time;
        this.mobile = mobile;
        this.modify_by = modify_by;
        this.dept_bm = dept_bm;
        this.is_delete = is_delete;
        this.create_by = create_by;
        this.is_dept_manager = is_dept_manager;
        this.xb_dm = xb_dm;
        this.nickname = nickname;
        this.tel = tel;
        this.id = id;
        this.sfzjhm = sfzjhm;
        this.dept_id = dept_id;
        this.qtbz_dm = qtbz_dm;
        this.order_id = order_id;
        this.email = email;
        this.username = username;
        this.status = status;
    }






    @Generated(hash = 1494205387)
    public Test1_ListBean() {
    }






    @Override
    public String toString() {
        return "Test1_ListBean{" +
                "test1_id=" + test1_id +
                ", csrq='" + csrq + '\'' +
                ", create_time=" + create_time +
                ", modify_time='" + modify_time + '\'' +
                ", mobile='" + mobile + '\'' +
                ", modify_by=" + modify_by +
                ", dept_bm='" + dept_bm + '\'' +
                ", is_delete='" + is_delete + '\'' +
                ", create_by=" + create_by +
                ", is_dept_manager='" + is_dept_manager + '\'' +
                ", xb_dm='" + xb_dm + '\'' +
                ", nickname='" + nickname + '\'' +
                ", tel='" + tel + '\'' +
                ", id=" + id +
                ", sfzjhm='" + sfzjhm + '\'' +
                ", dept_id=" + dept_id +
                ", qtbz_dm='" + qtbz_dm + '\'' +
                ", order_id=" + order_id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", status='" + status + '\'' +
                '}';
    }






    public Long getTest1_id() {
        return this.test1_id;
    }






    public void setTest1_id(Long test1_id) {
        this.test1_id = test1_id;
    }






    public String getCsrq() {
        return this.csrq;
    }






    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }






    public String getCreate_time() {
        return this.create_time;
    }






    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }






    public String getModify_time() {
        return this.modify_time;
    }






    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }






    public String getMobile() {
        return this.mobile;
    }






    public void setMobile(String mobile) {
        this.mobile = mobile;
    }






    public int getModify_by() {
        return this.modify_by;
    }






    public void setModify_by(int modify_by) {
        this.modify_by = modify_by;
    }






    public String getDept_bm() {
        return this.dept_bm;
    }






    public void setDept_bm(String dept_bm) {
        this.dept_bm = dept_bm;
    }






    public String getIs_delete() {
        return this.is_delete;
    }






    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }






    public String getCreate_by() {
        return this.create_by;
    }






    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }






    public String getIs_dept_manager() {
        return this.is_dept_manager;
    }






    public void setIs_dept_manager(String is_dept_manager) {
        this.is_dept_manager = is_dept_manager;
    }






    public String getXb_dm() {
        return this.xb_dm;
    }






    public void setXb_dm(String xb_dm) {
        this.xb_dm = xb_dm;
    }






    public String getNickname() {
        return this.nickname;
    }






    public void setNickname(String nickname) {
        this.nickname = nickname;
    }






    public String getTel() {
        return this.tel;
    }






    public void setTel(String tel) {
        this.tel = tel;
    }






    public int getId() {
        return this.id;
    }






    public void setId(int id) {
        this.id = id;
    }






    public String getSfzjhm() {
        return this.sfzjhm;
    }






    public void setSfzjhm(String sfzjhm) {
        this.sfzjhm = sfzjhm;
    }






    public int getDept_id() {
        return this.dept_id;
    }






    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }






    public String getQtbz_dm() {
        return this.qtbz_dm;
    }






    public void setQtbz_dm(String qtbz_dm) {
        this.qtbz_dm = qtbz_dm;
    }






    public int getOrder_id() {
        return this.order_id;
    }






    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }






    public String getEmail() {
        return this.email;
    }






    public void setEmail(String email) {
        this.email = email;
    }






    public String getUsername() {
        return this.username;
    }






    public void setUsername(String username) {
        this.username = username;
    }






    public String getStatus() {
        return this.status;
    }






    public void setStatus(String status) {
        this.status = status;
    }




}
