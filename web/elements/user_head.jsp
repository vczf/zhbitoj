<%--
  Created by IntelliJ IDEA.
  User: czf
  Date: 16-6-16
  Time: 下午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


    <%
        String path=request.getContextPath();
    %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>ZHBITOJ</title>
    <link href="<%=path%>/bootstrap/css/custom.css" rel="stylesheet" />
    <link href="<%=path%>/bootstrap/css/bootstrap-theme.css" rel="stylesheet" />
    <link href="<%=path%>/bootstrap/css/style.css" rel="stylesheet" />
    <link href="<%=path%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=path%>/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=path%>/bootstrap/js/jquery.min.js"></script>
    <script type="text/javascript"src="<%=path%>/bootstrap/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(function () {
            if(location.pathname!='/')
            $(".nav li").has("a[href='"+location.pathname+"']").addClass("active");
        });
    </script>