package com.github.wheatphp.blog;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;//表示数据库连接的对象

        Statement stmt = null;//表示数据库更新操作

        ResultSet result = null;//表示接受数据库查询到的结果

        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/icp_bss?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "bss_product", "bss_product_2019");

        String sql = "select * from product_item_define limit 1";

        stmt = conn.createStatement();

        result = stmt.executeQuery(sql);

        ResultSetMetaData metaData = result.getMetaData();
        Map<String, String> map = new HashMap<>();

        if (result.next()) {
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                map.put(metaData.getColumnName(i + 1), result.getString(metaData.getColumnName(i + 1)));
            }
        }
        System.out.println(map);

    }
}
