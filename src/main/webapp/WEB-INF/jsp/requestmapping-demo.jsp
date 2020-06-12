<%--
  Created by IntelliJ IDEA.
  User: haiya
  Date: 2020/5/20
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数绑定演示demo</title>
</head>
<body>

    <br/>
    <!-- @RequestMapping中method属性的示例 -->
    <a href="${pageContext.request.contextPath}/item/findItem">查询商品（默认方式）</a>
    <br/>
    <form action="${pageContext.request.contextPath}/item/findItem" method="post">
        <input type="submit" value="查询商品（POST方式）">
    </form>
    <br/>
    <a href="${pageContext.request.contextPath}/item/findItem">查询商品（GET方式）</a>
    <br/>

    <!-- @RequestMapping中param属性的示例 -->
    <a href="${pageContext.request.contextPath}/item/removeItem?name=iPhone6&price>5000">删除商品，金额大于5000</a>
    <br/>
    <a href="${pageContext.request.contextPath}/item/removeItem?name=iPhone6&price>6000">删除商品，金额大于7000</a>
    <br/>
</body>
</html>
