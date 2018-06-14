package servlet;

import bean.OrderItem;
import bean.Product;
import dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int id = Integer.parseInt(req.getParameter("id"));//拿到pid
        List<OrderItem> orderItems = (List<OrderItem>) req.getSession().getAttribute("ois");//拿到session中的数据
        List<OrderItem> delteOrder = new ArrayList<>();
        if (id != 0){
            for (OrderItem oi: orderItems){
                if (oi.getProduct().getId()==id){
                    delteOrder.add(oi);
                }
            }
        }
        orderItems.removeAll(delteOrder);
        resp.sendRedirect("/listOrderItem");
    }
}
