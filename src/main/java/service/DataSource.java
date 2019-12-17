package service;

import entiy.treeNode;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import java.sql.SQLException;
import java.util.List;

public class DataSource {

    private static int flog=0;


    //查询所有数据
    public static List<Object[]> getData() throws SQLException {
        String sql = "select * from nodetree";
        List<Object[]> data = new QueryRunner().query(DBUtil.getConnection(),sql, new ArrayListHandler());
        DbUtils.commitAndCloseQuietly(DBUtil.getConnection());
        System.out.println("getData执行，查询所有数据成功！");
        return data;
    }

    /*
    public static List getOneData(int data) throws SQLException {
        entiy.treeNode node = new entiy.treeNode();
        String sql = String.format("select * from data where da=%d",data);
        System.out.println("getData执行Sql");
        QueryRunner runner=new QueryRunner();

        List list=(List)runner.query(service.DBUtil.getConnection(),sql,new BeanListHandler(entiy.treeNode.class));
        return list;

    }

    public static void insertData(List<entiy.treeNode> list) throws SQLException {
        delete();
        String sql;
        sql = "insert into  data values(?,?,?)";
        Object[][] objects = new Object[list.size()][];
        System.out.println("insertData执行Sql");
        
        for (int i = 0; i < list.size(); i++) {
            objects[i]=new Object[]{list.get(i).id,list.get(i).da,list.get(i).fatherId};

        }
        new QueryRunner().batch(service.DBUtil.getConnection(),sql,objects);
    }
     */
    //插入一条数据
    public static int insertOneData(treeNode node) throws SQLException {
        System.out.println("id: "+node.id+"  data: "+node.da+" father: "+node.fatherId);
        String sql;
        sql = String.format("insert into  nodetree (data,father)values(%s,%s)",node.da,node.fatherId);
        flog = new QueryRunner().update(DBUtil.getConnection(),sql);
        if(flog==1)
            System.out.println("insertOneData执行，插入成功！");

        return flog;
    }
    //删除所有数据
    public static void delete() throws SQLException {
        String sql = "truncate table nodetree";
        new QueryRunner().update(DBUtil.getConnection(),sql);

    }
    //删除一条数据
    public static int deleteOne(String data) throws SQLException {
        String sql = String.format("delete from nodetree where data=?");
        flog = new QueryRunner().update(DBUtil.getConnection(),sql,data);
        if(flog==1)
            System.out.println("deleteOne执行，删除成功！");
        return flog;
    }

    //更新（插入）一条数据
    public static int update(String oldData,String newData) throws SQLException {
        String sql;
        sql = String.format("UPDATE nodetree SET  data=? WHERE data=?");
        String []strings = {newData,oldData};
        flog = new QueryRunner().update(DBUtil.getConnection(),sql,strings);
        if(flog==1)
            System.out.println("update执行，修改成功！");
        return flog;
    }

    //修改data的同时修改father
    public static int update_father(String oldData,String newData) throws SQLException {
        String sql;
        sql = String.format("UPDATE nodetree SET  father=? WHERE father=?");
        String []strings = {newData,oldData};
        flog = new QueryRunner().update(DBUtil.getConnection(),sql,strings);
        if(flog==1)
            System.out.println("update执行，修改成功！");
        return flog;
    }
}
