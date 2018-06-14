<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/8
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
    <h1 align="center">购物车</h1>
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>商品名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>小计</td>
            <td>操作</td>
        </tr>
        <c:choose>
            <c:when test="${not empty ois}">
                <c:forEach var="ois" items="${ois}" varStatus="oi">
                    <tr>
                        <td>${ois.product.name}</td>
                        <td>${ois.product.price}</td>
                        <td>${ois.num}</td>
                        <td>${ois.product.price*ois.num}</td>
                        <td><a href="/deleteOrderItem?id=${ois.product.id}">删除</a> </td>

                    </tr>
                </c:forEach>

            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>
        <c:if test="${!empty ois}">
            <tr>
                <td colspan="4" align="right">
                    <a href="createOrder">生成订单</a>
                </td>
            </tr>
        </c:if>

    </table>
</body>
</html>
