package dao;

import bean.OrderItem;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDao {
    public void insert(OrderItem oi) {

        String sql = "insert into orderitem values(null,?,?,?)";
        try (Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql);){

            ps.setInt(1,oi.getProduct().getId());
            ps.setInt(2,oi.getNum());

            ps.setInt(3,oi.getOrder().getId());

            ps.execute();

            ps.close();

            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
