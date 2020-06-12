<%--
  Created by IntelliJ IDEA.
  User: haiya
  Date: 2020/6/9
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--${requestScope.itemMap}<br/>--%>
    <%--利用@ModelAttribute来初始化下拉框--%>
    <select id="item" name="item">
        <c:forEach items="${requestScope.itemMap}" var="m">
            <%--<option value="请选择" selected="selected"></option>--%>
            <option value="${m.key}" <c:if test="${m.key == 1}"><c:out value="selected"></c:out></c:if>>
                ${m.value}
            </option>
        </c:forEach>
    </select>
    <jsp:include page="requestmapping-demo.jsp"></jsp:include>
</body>
</html>
