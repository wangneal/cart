package dao;

import bean.Product;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> ListProduct(){
        List<Product> products = new ArrayList<>();
        String sql = "select * from product";
        try(Connection c = DBUtil.getCon(); PreparedStatement ps = c.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product product = new Product();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                products.add(product);
            }
            c.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getById(int id){
        Product product = null;
        String sql = "select * from product where id=" + id;

        try(Connection c = DBUtil.getCon();PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
            }
            ps.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public static void main(String[] args) {
        System.out.println(new ProductDao().ListProduct().size());
    }
}
