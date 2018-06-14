package dao;

import bean.Order;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao {
    public void insert(Order order){
        String sql = "insert into order_ values(null,?)";
        try(Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,order.getUser().getId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                order.setId(id);
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
