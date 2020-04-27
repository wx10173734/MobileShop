package test.administrator.example.com.mobileshop.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;

public class Test2  {
    private String flag;
    private String errorMsg;
    private List<ListBean> list;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }


    public static class ListBean {
        private String des;
        private String link_tel;
        private String type_def;
        private String name;
        private int id;
        private String link_name;
        private String no_prefix;

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getLink_tel() {
            return link_tel;
        }

        public void setLink_tel(String link_tel) {
            this.link_tel = link_tel;
        }

        public String getType_def() {
            return type_def;
        }

        public void setType_def(String type_def) {
            this.type_def = type_def;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink_name() {
            return link_name;
        }

        public void setLink_name(String link_name) {
            this.link_name = link_name;
        }

        public String getNo_prefix() {
            return no_prefix;
        }

        public void setNo_prefix(String no_prefix) {
            this.no_prefix = no_prefix;
        }

        @Override
        public String toString() {
            return "Test2_ListBean{" +
                    "des='" + des + '\'' +
                    ", link_tel='" + link_tel + '\'' +
                    ", type_def='" + type_def + '\'' +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", link_name='" + link_name + '\'' +
                    ", no_prefix='" + no_prefix + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Test2{" +
                "flag=" + flag +
                ", errorMsg='" + errorMsg + '\'' +
                ", list=" + list +
                '}';
    }
}
