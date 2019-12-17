package service;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static String url = "jdbc:mysql://localhost:3306/tree?useSSL=FALSE&serverTimezone=UTC&useUnicode=" +
            "true&characterEncoding=UTF8&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String psd = "root";

    private static String Driver = "com.mysql.cj.jdbc.Driver";

    // 连接数据库
    public static Connection getConnection() {
        Connection conn = null;
        if (conn == null) {
            try {
                DbUtils.loadDriver(Driver);
                conn = DriverManager.getConnection(url, user, psd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

}
