<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/19
  Time: 下午6:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<ul class="nav nav-pills contest-nav" id="fn-nav">
    <li ><a href="/contest/problem_list?contestId=<s:property value="contestId"/>">题目</a></li>
    <li ><a href="/contest/ranking?contestId=<s:property value="contestId"/>">排名</a></li>
    <li ><a href="/contest/status?contestId=<s:property value="contestId"/> ">状态</a></li>
</ul>
