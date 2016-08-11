<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/16
  Time: 下午12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp"/>
    <meta http-equiv="refresh" content="2;url=/index">
</head>
<body>
<s:include value="/elements/user_body.jsp"/>
<h3>恭喜,注册成功,正在跳转到<a href="/index">首页</a></h3>
</body>
</html>
