<%--
  Created by IntelliJ IDEA.
  User: czf
  Date: 16-6-19
  Time: 下午3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp"/>
</head>
<body>
    <s:include value="/elements/user_body.jsp"/>
    <div class="container">
        <s:include value="/pages/contest/user_contest_head.jsp"/>
        <s:include  value="/pages/contest/user_contest_manu.jsp"/>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>题号</th>
                <th>题目标题</th>
            </tr>
            </thead>
            <tbody>
                <% char ch='A';%>
                <s:iterator value="#request.problemList" var="item" status="i" >
                    <tr>
                        <td>
                            <%=ch++%>
                        </td>
                        <td>
                            <a href="/contest/problem_show?contestId=<s:property value="contestId"/>&problemId=<s:property value="#item.problemid"/> ">
                                <s:property value="#item.title" />
                            </a>
                        </td>

                    </tr>
                </s:iterator>

            </tbody>
        </table>
    </div>

</body>
</html>
