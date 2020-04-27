package test.administrator.example.com.mobileshop.entity;

import java.util.List;

public class BankEntity {
    private boolean flag;
    private String errorMsg;
    private List<ListBean> list;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
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
        /**
         * parent_id : 0
         * name : 常州市新北区人民法院
         * id : 81
         * name_py : changzhoushixinbeiqurenminfayuan
         */

        private int parent_id;
        private String name;
        private int id;
        private String name_py;

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
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

        public String getName_py() {
            return name_py;
        }

        public void setName_py(String name_py) {
            this.name_py = name_py;
        }

        @Override
        public String toString() {
            return "Test2_ListBean{" +
                    "parent_id=" + parent_id +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", name_py='" + name_py + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BankEntity{" +
                "flag=" + flag +
                ", errorMsg='" + errorMsg + '\'' +
                ", list=" + list +
                '}';
    }
}
