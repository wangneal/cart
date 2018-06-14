package servlet;

import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDao;
import dao.OrderItemDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderCreateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        User u = (User)request.getSession().getAttribute("user");
        if (null == u){
            response.sendRedirect("/login.jsp");
            return;
        }
        Order o = new Order();
        o.setUser(u);
        new OrderDao().insert(o);
        List<OrderItem> orderItems = (List<OrderItem>) request.getSession().getAttribute("ois");
        for (OrderItem oi:orderItems){
            oi.setOrder(o);
            new OrderItemDao().insert(oi);
        }
        orderItems.clear();

        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println("订单创建成功");
    }
}
