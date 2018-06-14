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

public class OrderItemAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int num = Integer.parseInt(req.getParameter("num"));
        int pid = Integer.parseInt(req.getParameter("pid"));
        Product product = new ProductDao().getById(pid);
        OrderItem orderItem = new OrderItem();

        orderItem.setNum(num);
        orderItem.setProduct(product);
        List<OrderItem> orderItems = (List<OrderItem>) req.getSession().getAttribute("ois");
        if (null == orderItems){
            orderItems = new ArrayList<>();
            req.getSession().setAttribute("ois",orderItems);
        }
        boolean found = false;
        for (OrderItem oi:orderItems){//判断如果session里有相同记录，就加1，否则新增一条数据
            if (oi.getProduct().getId() == orderItem.getProduct().getId()){
                oi.setNum(orderItem.getNum()+oi.getNum());
                found = true;
                break;
            }
        }
        if (!found){

            orderItems.add(orderItem);
        }
        resp.sendRedirect("/listOrderItem");
    }
}
