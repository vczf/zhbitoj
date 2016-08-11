<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp" />
    
    <style>
        .problem-search{
            float: right;
        }
    </style>
</head>
<body>
<s:include value="/elements/user_body.jsp" />
<div class="container">
    <ul class="pagination problem-pagination" id="page">
        <s:iterator value="new int[pageNumber]" status="i">
            <li>
                <a href="/problems?page=<s:property value="#i.index+1"/> ">
                    <s:property value="#i.index+1"/>
                </a>
            </li>
        </s:iterator>
    </ul>
    <div class="problem-search">
        <form class="form-inline well" role="form" action="/problems_search" method="GET">
            <div class="form-group">
                <label class="sr-only" for="text">搜索文本</label>
                <input placeholder="搜索" name="text" id="text" class="form-control"/>
            </div>
            <div class="form-group">
                <label class="sr-only" >类型</label>
                <select name="type" class="form-control">
                    <option value="title">标题</option>
                    <option value="source">来源</option>
                </select>
            </div>
            <input type="submit" value="搜索" class="btn btn-default">
        </form>
    </div>
<table class="table table-striped">
    <thead>
    <tr>
        <th>题号</th>
        <th>标题</th>
        <th>正确/提交</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="#request.problems" var="item">
        <tr <s:if test="#item.hide==true">class="info"</s:if> >
            <td class="pid "><s:property value="#item.problemId" />
                <s:if test="#item.hide==true">
                <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                </s:if>
            </td>
            <td class="ptitle">
                <a href="/problems/problems_detail?pid=<s:property value="#item.problemId" />"><s:property value="#item.title" /></a></td>
            <td><s:property value="#item.ac"/>/<s:property value="#item.submit" /></td>
        </tr>

    </s:iterator>
    </tbody>
</table>

</div>
</div>
</body>
</html>