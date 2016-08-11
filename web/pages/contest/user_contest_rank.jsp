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
    <jsp:include page="/elements/user_head.jsp"/>
</head>
<body>
    <jsp:include page="/elements/user_body.jsp"/>
    <div class="container">
        <s:include value="/pages/contest/user_contest_head.jsp"/>
        <s:include  value="/pages/contest/user_contest_manu.jsp"/>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>用户名</th>
                <th>通过题数</th>
                <th>累计时间</th>
                <%char startIndex='A';%>
                <s:iterator value="#request.problems" var="peoblem" status="i">
                    <th>
                        <%=startIndex++%>
                    </th>
                </s:iterator>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="#request.ranking" var="player" status="i">
                <tr>
                    <td><s:property value="#i.count"/></td>
                    <td><s:property value="#player.userName"/> </td>
                    <td><s:property value="#player.score"/> </td>
                    <td>
                        <s:property value="#player.intToTime()"/>
                    </td>
                    <% /*
                    <td>
                        -/-
                    </td>
                    <td>
                        01:04:55
                    </td>
                    <td>
                        (-1)
                    </td>
                    */ %>
                    <s:iterator value="#request.problems" var="problem">
                        <td>
                            <s:set var="box" value="#player.problemScore[#problem.problemid]"/>
                            <s:if test="#box==null">
                                -/-
                            </s:if>
                            <s:else>
                                <s:property value="#box"/>
                            </s:else>
                        </td>
                    </s:iterator>
                </tr>
            </tr>
            </s:iterator>

            </tbody>
        </table>
    </div>

</body>
</html>
