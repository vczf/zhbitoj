<%--
  Created by IntelliJ IDEA.
  User: Cyril
  Date: 16/6/21
  Time: 下午4:37
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
    <s:include value="/pages/contest/user_contest_manu.jsp"/>

    <s:set var="problem" value="#request.problem"/>

    <div class=" col-sm-10 col-sm-offset-1">
        <h1 class="page-title"><s:property value="#problem.title"/></h1>
        <div class="contest-info">
            <p>
                时间限制：<span class="label label-warning"><s:property value="#problem.timeLimit"/>ms</span>
                内存限制：<span class="label label-danger"><s:property value="#problem.memoryLimit"/>kb</span><br/>
            </p>
        </div>
        <dl class="detail">
            <dt>题目描述</dt>
            <dd id="problem-desc"></dd>
            <dt>输入</dt>
            <dd id="problem-input"></dd>
            <dt>输出</dt>
            <dd id="problem-output"></dd>
            <dt>样例输入</dt>
            <dd>
                <pre><s:property value="#problem.sampleInput"/></pre>
            </dd>
            <dt>样例输出</dt>
            <dd>
                <pre><s:property value="#problem.sampleOutput"/></pre>
            </dd>
            <dt>提示</dt>
            <dd><s:property value="#problem.hint"/></dd>
            <dt>来源</dt>
            <dd><s:property value="#problem.source"/></dd>
        </dl>

        <ul id="fn-nav" class="nav nav-pills" style="font-size: 1.3em;">
            <li><a href="/contest/problem_list?contestId=<s:property value="contestId"/>">返 回</a></li>
            <li><a href="/submit?problemId=<s:property value="problemId" />&contestId=<s:property value="contestId"/> ">提
                交</a></li>
        </ul>

    </div>
</div>
</body>
<script type="text/javascript">
    $("dd#problem-desc").html("<s:property value="#problem.description" escape="false"/>");
    $("dd#problem-input").html("<s:property value="#problem.input" escape="false"/>");
    $("dd#problem-output").html("<s:property value="#problem.output" escape="false"/>");
</script>
</html>
