<%--
  Created by IntelliJ IDEA.
  User: haiya
  Date: 2020/6/8
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- a标签 右对齐
        1. 需要将行内标签转换为块级元素，即display: block;
        2. 文字右对齐text-align: right;
    --%>
    <a href="${pageContext.request.contextPath}/logout" style="display: block;text-align: right;">退出</a>
    <br/>
    ${msg}<br/>


</body>
</html>
