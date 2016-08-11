<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp"/>
    <style>
        .page-title, .contest-info {
            text-align: center;
            margin-bottom: 10px;
        }

        .detail dd {
            margin: 1em 20px 1em;
            font-size: 1.465em;
        }

        .detail dt {
            font-size: 18px;
        }

        #fn-nav {
            text-align: center;
        }

        #fn-nav li {
            float: none;
        }

    </style>
</head>
<body>
<s:include value="/elements/user_body.jsp"/>
<div class="container">
    <%--别名--%>
    <s:set var="problem" value="#request.problem"/>
    <h1 class="page-title"><s:property value="#problem.problemId"/> - <s:property value="#problem.title"/></h1>
    <div class="contest-info">
        <p>
            时间限制：<span class="label label-warning"><s:property value="#problem.timeLimit"/>ms</span>
            内存限制：<span class="label label-danger"><s:property value="#problem.memoryLimit"/>kb</span><br/>
        </p>
        <div>
            <s:property value="#problem.submit"/> 次提交 <s:property value="#problem.ac"/> 次通过
        </div>
    </div>
    <dl class="detail">
        <dt>题目描述</dt>
        <%--<dd id="problem-desc"><s:property value="#problem.description" escape="false"/></dd>--%>
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
        <li><a href="/problems?page=1">返 回</a></li>
        <li><a href="/submit?problemId=<s:property value="pid" />">提 交</a></li>
    </ul>
</div>
</body>
<script type="text/javascript">
    $("dd#problem-desc").html("<s:property value="#problem.description" escape="false"/>");
    $("dd#problem-input").html("<s:property value="#problem.input" escape="false"/>");
    $("dd#problem-output").html("<s:property value="#problem.output" escape="false"/>");
</script>
</html>