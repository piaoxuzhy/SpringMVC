<%--
  Created by IntelliJ IDEA.
  User: haiya
  Date: 2020/6/8
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/rest/user/1/haiya/女">用户查询</a>
    <br/>
    <br/>
    <form action="${pageContext.request.contextPath}/rest/user" method="post">
        id：<input type="text" name="id" /><br/>
        用户名：<input type="text" name="username" /><br/>
        性别：<input type="text" name="sex" /><br/>
        <input type="submit" value="用户注册">
    </form>
    <br/>
    <br/>
</body>
</html>
