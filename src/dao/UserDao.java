package dao;

import bean.User;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public User getUser(String name, String password){
        User user = null;
        String sql = "select * from user ";
        try(Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            ps.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
