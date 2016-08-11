<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/19
  Time: 下午5:22
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <s:include value="/elements/user_head.jsp" />
</head>
<body>
    <s:include value="/elements/user_body.jsp" />

    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>编号</th>
                <th>比赛名称</th>
                <th>结束时间</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody>
            <s:set value="#request.current" var="current" />
            <s:iterator value="#request.contests" var="item">
                <tr>
                    <td><s:property value="#item.contest_id" /> </td>
                    <td><a href="/contest/show?contestId=<s:property value="#item.contest_id"/> ">
                        <s:property value="#item.title" />
                    </a></td>
                    <td>
                        <s:date name="#item.end_time" format="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>

                        <%--问题 实体之间是怎么进行比较的?--%>
                        <s:if test="%{#item.status()==-1}">
                            <span class="label label-success">Registering</span>
                        </s:if>
                        <s:elseif test="%{#item.status()==1}">
                            <span class="label label-warning">End</span>
                        </s:elseif>
                        <s:else>
                            <span class="label label-danger">
                                Running
                                </span>
                        </s:else>
                    </td>
                </tr>

            </s:iterator>

            </tbody>
        </table>
        <ul class="pager double-side-pager">

            <%--上一页--%>
            <s:if test="%{page > 1}">
                <li class="previous"><a href="/contest/list?page=<s:property value="%{page-1}"/> ">← 上一页</a></li>
            </s:if>

            <%--下一页--%>
            <s:set value="#request.maxPage" var="maxPage"/>
            <s:if test="%{page < #maxPage}">
                <li class="next"><a href="/contest/list?page=<s:property value="%{page+1}"/>">下一页 →</a></li>
            </s:if>

        </ul>
    </div>
</body>
</html>
