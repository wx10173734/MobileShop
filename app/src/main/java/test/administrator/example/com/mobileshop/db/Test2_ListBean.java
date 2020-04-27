package test.administrator.example.com.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Test2_ListBean implements Serializable {
    private static final long serialVersionUID = 2L;

        @Id
        private Long list_id;
        private String des;
        private String link_tel;
        private String type_def;
        private String name;
        private int id;
        private String link_name;
        private String no_prefix;





        @Generated(hash = 656876817)
        public Test2_ListBean(Long list_id, String des, String link_tel,
                String type_def, String name, int id, String link_name,
                String no_prefix) {
            this.list_id = list_id;
            this.des = des;
            this.link_tel = link_tel;
            this.type_def = type_def;
            this.name = name;
            this.id = id;
            this.link_name = link_name;
            this.no_prefix = no_prefix;
        }





        @Generated(hash = 353120550)
        public Test2_ListBean() {
        }



       

    @Override
    public String toString() {
        return "Test2_ListBean{" +
                "list_id=" + list_id +
                ", des='" + des + '\'' +
                ", link_tel='" + link_tel + '\'' +
                ", type_def='" + type_def + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", link_name='" + link_name + '\'' +
                ", no_prefix='" + no_prefix + '\'' +
                '}';
    }





    public Long getList_id() {
        return this.list_id;
    }





    public void setList_id(Long list_id) {
        this.list_id = list_id;
    }





    public String getDes() {
        return this.des;
    }





    public void setDes(String des) {
        this.des = des;
    }





    public String getLink_tel() {
        return this.link_tel;
    }





    public void setLink_tel(String link_tel) {
        this.link_tel = link_tel;
    }





    public String getType_def() {
        return this.type_def;
    }





    public void setType_def(String type_def) {
        this.type_def = type_def;
    }





    public String getName() {
        return this.name;
    }





    public void setName(String name) {
        this.name = name;
    }





    public int getId() {
        return this.id;
    }





    public void setId(int id) {
        this.id = id;
    }





    public String getLink_name() {
        return this.link_name;
    }





    public void setLink_name(String link_name) {
        this.link_name = link_name;
    }





    public String getNo_prefix() {
        return this.no_prefix;
    }





    public void setNo_prefix(String no_prefix) {
        this.no_prefix = no_prefix;
    }



}
