<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/17
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp" />
    <meta http-equiv="refresh" content="3;url=/contest/problem_list?contestId=<s:property value="contestId"/>">
</head>
<body>
<s:include value="/elements/user_body.jsp" />

<h3>比赛中没有该题目,3秒后跳转. <a href="/contest/problem_list?contestId=<s:property value="contestId"/> "></a></h3>
</body>
</html>