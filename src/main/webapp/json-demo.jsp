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
    <%--返回值是String类型--%>
    <a href="${pageContext.request.contextPath}/json/responseString">返回值是String类型</a>
    <br/>
    <%--返回值是POJO类型--%>
    <a href="${pageContext.request.contextPath}/json/responsePojo">返回值是POJO类型</a>
    <br/>

</body>
</html>
