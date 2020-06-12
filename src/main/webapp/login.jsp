<%--
  Created by IntelliJ IDEA.
  User: haiya
  Date: 2020/6/9
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table align="center" cellspacing="0" border="1">
            <tr>
                <td>用户名：<input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码：<input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
