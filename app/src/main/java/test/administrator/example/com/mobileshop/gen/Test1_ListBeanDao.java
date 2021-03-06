package test.administrator.example.com.mobileshop.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import test.administrator.example.com.mobileshop.db.Test1_ListBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEST1__LIST_BEAN".
*/
public class Test1_ListBeanDao extends AbstractDao<Test1_ListBean, Long> {

    public static final String TABLENAME = "TEST1__LIST_BEAN";

    /**
     * Properties of entity Test1_ListBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Test1_id = new Property(0, Long.class, "test1_id", true, "_id");
        public final static Property Csrq = new Property(1, String.class, "csrq", false, "CSRQ");
        public final static Property Create_time = new Property(2, String.class, "create_time", false, "CREATE_TIME");
        public final static Property Modify_time = new Property(3, String.class, "modify_time", false, "MODIFY_TIME");
        public final static Property Mobile = new Property(4, String.class, "mobile", false, "MOBILE");
        public final static Property Modify_by = new Property(5, int.class, "modify_by", false, "MODIFY_BY");
        public final static Property Dept_bm = new Property(6, String.class, "dept_bm", false, "DEPT_BM");
        public final static Property Is_delete = new Property(7, String.class, "is_delete", false, "IS_DELETE");
        public final static Property Create_by = new Property(8, String.class, "create_by", false, "CREATE_BY");
        public final static Property Is_dept_manager = new Property(9, String.class, "is_dept_manager", false, "IS_DEPT_MANAGER");
        public final static Property Xb_dm = new Property(10, String.class, "xb_dm", false, "XB_DM");
        public final static Property Nickname = new Property(11, String.class, "nickname", false, "NICKNAME");
        public final static Property Tel = new Property(12, String.class, "tel", false, "TEL");
        public final static Property Id = new Property(13, int.class, "id", false, "ID");
        public final static Property Sfzjhm = new Property(14, String.class, "sfzjhm", false, "SFZJHM");
        public final static Property Dept_id = new Property(15, int.class, "dept_id", false, "DEPT_ID");
        public final static Property Qtbz_dm = new Property(16, String.class, "qtbz_dm", false, "QTBZ_DM");
        public final static Property Order_id = new Property(17, int.class, "order_id", false, "ORDER_ID");
        public final static Property Email = new Property(18, String.class, "email", false, "EMAIL");
        public final static Property Username = new Property(19, String.class, "username", false, "USERNAME");
        public final static Property Status = new Property(20, String.class, "status", false, "STATUS");
    }


    public Test1_ListBeanDao(DaoConfig config) {
        super(config);
    }
    
    public Test1_ListBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEST1__LIST_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: test1_id
                "\"CSRQ\" TEXT," + // 1: csrq
                "\"CREATE_TIME\" TEXT," + // 2: create_time
                "\"MODIFY_TIME\" TEXT," + // 3: modify_time
                "\"MOBILE\" TEXT," + // 4: mobile
                "\"MODIFY_BY\" INTEGER NOT NULL ," + // 5: modify_by
                "\"DEPT_BM\" TEXT," + // 6: dept_bm
                "\"IS_DELETE\" TEXT," + // 7: is_delete
                "\"CREATE_BY\" TEXT," + // 8: create_by
                "\"IS_DEPT_MANAGER\" TEXT," + // 9: is_dept_manager
                "\"XB_DM\" TEXT," + // 10: xb_dm
                "\"NICKNAME\" TEXT," + // 11: nickname
                "\"TEL\" TEXT," + // 12: tel
                "\"ID\" INTEGER NOT NULL ," + // 13: id
                "\"SFZJHM\" TEXT," + // 14: sfzjhm
                "\"DEPT_ID\" INTEGER NOT NULL ," + // 15: dept_id
                "\"QTBZ_DM\" TEXT," + // 16: qtbz_dm
                "\"ORDER_ID\" INTEGER NOT NULL ," + // 17: order_id
                "\"EMAIL\" TEXT," + // 18: email
                "\"USERNAME\" TEXT," + // 19: username
                "\"STATUS\" TEXT);"); // 20: status
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEST1__LIST_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Test1_ListBean entity) {
        stmt.clearBindings();
 
        Long test1_id = entity.getTest1_id();
        if (test1_id != null) {
            stmt.bindLong(1, test1_id);
        }
 
        String csrq = entity.getCsrq();
        if (csrq != null) {
            stmt.bindString(2, csrq);
        }
 
        String create_time = entity.getCreate_time();
        if (create_time != null) {
            stmt.bindString(3, create_time);
        }
 
        String modify_time = entity.getModify_time();
        if (modify_time != null) {
            stmt.bindString(4, modify_time);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(5, mobile);
        }
        stmt.bindLong(6, entity.getModify_by());
 
        String dept_bm = entity.getDept_bm();
        if (dept_bm != null) {
            stmt.bindString(7, dept_bm);
        }
 
        String is_delete = entity.getIs_delete();
        if (is_delete != null) {
            stmt.bindString(8, is_delete);
        }
 
        String create_by = entity.getCreate_by();
        if (create_by != null) {
            stmt.bindString(9, create_by);
        }
 
        String is_dept_manager = entity.getIs_dept_manager();
        if (is_dept_manager != null) {
            stmt.bindString(10, is_dept_manager);
        }
 
        String xb_dm = entity.getXb_dm();
        if (xb_dm != null) {
            stmt.bindString(11, xb_dm);
        }
 
        String nickname = entity.getNickname();
        if (nickname != null) {
            stmt.bindString(12, nickname);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(13, tel);
        }
        stmt.bindLong(14, entity.getId());
 
        String sfzjhm = entity.getSfzjhm();
        if (sfzjhm != null) {
            stmt.bindString(15, sfzjhm);
        }
        stmt.bindLong(16, entity.getDept_id());
 
        String qtbz_dm = entity.getQtbz_dm();
        if (qtbz_dm != null) {
            stmt.bindString(17, qtbz_dm);
        }
        stmt.bindLong(18, entity.getOrder_id());
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(19, email);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(20, username);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(21, status);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Test1_ListBean entity) {
        stmt.clearBindings();
 
        Long test1_id = entity.getTest1_id();
        if (test1_id != null) {
            stmt.bindLong(1, test1_id);
        }
 
        String csrq = entity.getCsrq();
        if (csrq != null) {
            stmt.bindString(2, csrq);
        }
 
        String create_time = entity.getCreate_time();
        if (create_time != null) {
            stmt.bindString(3, create_time);
        }
 
        String modify_time = entity.getModify_time();
        if (modify_time != null) {
            stmt.bindString(4, modify_time);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(5, mobile);
        }
        stmt.bindLong(6, entity.getModify_by());
 
        String dept_bm = entity.getDept_bm();
        if (dept_bm != null) {
            stmt.bindString(7, dept_bm);
        }
 
        String is_delete = entity.getIs_delete();
        if (is_delete != null) {
            stmt.bindString(8, is_delete);
        }
 
        String create_by = entity.getCreate_by();
        if (create_by != null) {
            stmt.bindString(9, create_by);
        }
 
        String is_dept_manager = entity.getIs_dept_manager();
        if (is_dept_manager != null) {
            stmt.bindString(10, is_dept_manager);
        }
 
        String xb_dm = entity.getXb_dm();
        if (xb_dm != null) {
            stmt.bindString(11, xb_dm);
        }
 
        String nickname = entity.getNickname();
        if (nickname != null) {
            stmt.bindString(12, nickname);
        }
 
        String tel = entity.getTel();
        if (tel != null) {
            stmt.bindString(13, tel);
        }
        stmt.bindLong(14, entity.getId());
 
        String sfzjhm = entity.getSfzjhm();
        if (sfzjhm != null) {
            stmt.bindString(15, sfzjhm);
        }
        stmt.bindLong(16, entity.getDept_id());
 
        String qtbz_dm = entity.getQtbz_dm();
        if (qtbz_dm != null) {
            stmt.bindString(17, qtbz_dm);
        }
        stmt.bindLong(18, entity.getOrder_id());
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(19, email);
        }
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(20, username);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(21, status);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Test1_ListBean readEntity(Cursor cursor, int offset) {
        Test1_ListBean entity = new Test1_ListBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // test1_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // csrq
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // create_time
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // modify_time
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // mobile
            cursor.getInt(offset + 5), // modify_by
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // dept_bm
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // is_delete
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // create_by
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // is_dept_manager
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // xb_dm
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // nickname
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // tel
            cursor.getInt(offset + 13), // id
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // sfzjhm
            cursor.getInt(offset + 15), // dept_id
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // qtbz_dm
            cursor.getInt(offset + 17), // order_id
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // email
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // username
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20) // status
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Test1_ListBean entity, int offset) {
        entity.setTest1_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCsrq(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCreate_time(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setModify_time(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMobile(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setModify_by(cursor.getInt(offset + 5));
        entity.setDept_bm(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setIs_delete(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCreate_by(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIs_dept_manager(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setXb_dm(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setNickname(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setTel(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setId(cursor.getInt(offset + 13));
        entity.setSfzjhm(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setDept_id(cursor.getInt(offset + 15));
        entity.setQtbz_dm(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setOrder_id(cursor.getInt(offset + 17));
        entity.setEmail(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setUsername(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setStatus(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Test1_ListBean entity, long rowId) {
        entity.setTest1_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Test1_ListBean entity) {
        if(entity != null) {
            return entity.getTest1_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Test1_ListBean entity) {
        return entity.getTest1_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
