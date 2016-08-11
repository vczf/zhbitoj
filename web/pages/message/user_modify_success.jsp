<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/17
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp" />
    <meta http-equiv="refresh" content="2;url=/user?<s:property value="#session.USER_NAME"/>">
</head>
<body>
    <s:include value="/elements/user_body.jsp" />

    <h3>用户信息修改成功<a href="/user?<s:property value="#session.USER_NAME"/> "></a></h3>
</body>
</html>
