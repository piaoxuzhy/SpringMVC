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
    <!-- request请求的内容类型主要分为：K/V类型、Multipart类型、JSON类型 -->
    <!-- 将request请求参数，绑定到简单类型（基本类型和String类型）方法参数 -->

    <!-- 1.直接绑定 -->
    <a href="${pageContext.request.contextPath}/parameterBinding/simpleParam?id=1&name=lisi">简单参数绑定</a>
    <br/>
    <!-- 2.RequestParam绑定 -->
    <a href="${pageContext.request.contextPath}/parameterBinding/requestParam?uid=1">RequestParam参数绑定</a>
    <br/>
    <!-- 3.POJO绑定
        将request请求参数，绑定到POJO类型(简单POJO和包装POJO的)方法参数
    -->
    <form action="${pageContext.request.contextPath}/parameterBinding/pojoParam" method="post">
        名称：<input type="text" name="name"><br />
        价格：<input type="text" name="price"><br />
        <input type="submit" value="保存">
    </form>
    <br/>

    <!-- 4.String Date 绑定-->
    <a href="${pageContext.request.contextPath}/parameterBinding/stringDateParam?birthday=2020-05-21">使用String接收日期数据</a>
    <br/>
    <!-- 5.Date 绑定-->
    <a href="${pageContext.request.contextPath}/parameterBinding/dateParam?birthday=2020-05-21 11:00:00">使用Date接收日期数据</a>
    <br/>

    <!-- 将request请求参数，绑定到[元素是简单类型的集合或数组]参数 -->
    <!-- 使用数组接收 -->
    <a href="${pageContext.request.contextPath}/parameterBinding/simpleArrayParam?id=1&id=2&id=3">通过数组接收批量数据</a>
    <br/>
    <!-- 使用List接收 -->
    <a href="${pageContext.request.contextPath}/parameterBinding/simpleListParam?id=1&id=2&id=3">通过List接收批量数据</a>
    <br/>
    <!-- 使用Bean的List属性接收 -->
    <a href="${pageContext.request.contextPath}/parameterBinding/simpleListInPojoParam?uid=1&uid=2&uid=3">通过POJO（List）接收批量数据</a>
    <br/><br/><br/><br/><br/><br/>

    <%--将Request参数绑定到【元素是POJO类型的List集合或者map集合】参数--%>
    <form action="${pageContext.request.contextPath}/parameterBinding/listAndMapInPojoParam" method="post">
        用户名称：<input type="text" name="username"/> <br/>
        用户性别：<input type="text" name="sex"/><br/>
        <!-- itemList[集合下标]：集合下标必须从0开始 -->
        <!-- 辅助理解：先将name属性封装到一个Item对象中，再将该Item对象放入itemList集合的指定下标处 -->
        购买商品1名称：<input type="text" name="itemList[0].name" /><br/>
        购买商品1价格：<input type="text" name="itemList[0].price"><br/>
        购买商品2名称：<input type="text" name="itemList[1].name" /><br/>
        购买商品2价格：<input type="text" name="itemList[1].price"><br/>
        <!-- itemMap['item3']：其中的item3、item4就是Map集合的key -->
        <!-- 辅助理解：先将name属性封装到一个Item对象中，再将该Item对象作为value放入itemMap集合的指定key处 -->
        购买商品3名称：<input type="text" name="itemMap['item3'].name" /><br/>
        购买商品3价格：<input type="text" name="itemMap['item3'].price" /><br/>
        购买商品4名称：<input type="text" name="itemMap['item4'].name" /><br/>
        购买商品4价格：<input type="text" name="itemMap['item4'].price" /><br/>
        <input type="submit" value="保存" />
    </form>
    <br/><br/><br/><br/><br/><br/>

    <form action="${pageContext.request.contextPath}/parameterBinding/fileupload" method="post" enctype="multipart/form-data">
        文件名：<input type="file" name="uploadFile" /><br/>
        <input type="submit" value="保存" />
    </form>
</body>
</html>
