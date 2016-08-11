<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/19
  Time: 下午1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp" />
</head>
<body>
    <s:include value="/elements/user_body.jsp" />

    <div class="container">
        <div class="user-profile">
            <div class="span8">
                <!--<img src="#userimage" alt="user image"/>-->
                <h2><s:property value="#request.user.nick"/> - <s:property value="#request.user.note"/> </h2>
            </div>
            <div class="row basic-info">
                <div class="col-sm-7 user-card">
                    <ul class="nav nav-pills nav-stacked">
                        <li><a><i class="glyphicon glyphicon-home"></i> <s:property value="#request.user.studentId"/> </a></li>
                        <li><a><i class="glyphicon glyphicon-envelope"></i><s:property value="#request.user.email"/> </a></li>
                        <li><a><i class="glyphicon glyphicon-time">
                        </i> 注册时间:<s:date name="#request.user.regTime" format="yyyy-MM-dd HH:mm:ss"/></a></li>

                    </ul>
                </div>
                <div class="col-sm-5 user-stats">
                    <ul class="nav nav-pills">
                        <li class="accept" value="<s:property value="#ac"/>" id="通过"><s:property value="#ac"/></li>
                        <li class="failed" id="失败" value="<s:property value="#wa"/>"><s:property value="#wa"/></li>
                        <li class="submit" value="<s:property value="%{#wa+#ac}"/>" id="提交"><s:property value="%{#wa+#ac}"/></li>
                    </ul>
                    <script type="text/javascript">
                        $('div.user-stats li').mouseenter(function (e) {
                            var ele = $(this);
                            ele.text(ele.attr('id'));
                        }).mouseleave(function (e) {
                            var ele = $(this);
                            ele.text(ele.attr('value'));
                        })
                    </script>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
