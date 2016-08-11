<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp" />

    <style>
        .page-title,.contest-info{
            text-align: center;
            margin-bottom: 10px;
        }
        .detail dd{
            margin: 1em 20px 1em;
            font-size: 1.465em;
        }
        .detail dt{
            font-size: 18px;
        }
        #fn-nav {
            text-align: center;
        }
        #fn-nav li{
            float:none;
        }
    </style>
</head>
<body>

<s:set var="resultName" value="{
    'Queuing',
    'Rejudging',
    'Compiling',
    'Running',
    'Accepted',
    'Presentation Error',
    'Wrong Answer',
    'Time Limit Exceeded',
    'Memory Limit Exceeded',
    'Output Limit Exceeded',
    'Runtime Error',
    'Compilation Error',
    'Runtime Error<br/>STACK_OVERFLOW',
    'RunTimeError<br/>DIVIDE_BY_ZERO ',
    'RunTimeError<br/>ACCESS_VIOLATION',
    'Out of Contest Time '}"
/>

<s:include value="/elements/user_body.jsp" />
<s:set value="#request.source" var="source" />
<s:set value="#request.solution" var="solution"/>
<div class="container">
    <div class="row solution">
        <ul class="list-group solution-info col-sm-2">
            <li class="list-group-item">
                <span class="badge"><s:property value="#solution.problemId"/> </span>
                题号    </li>
            <li class="list-group-item">
                <span class="badge"><s:property value="#solution.userName"/> </span>
                用户    </li>
            <li class="list-group-item">
                <span class="badge">
                    <s:if test="#solution.language==0">
                        C
                    </s:if>
                    <s:elseif test="#solution.language==1">
                        C++
                    </s:elseif>
                </span>
                语言    </li>
            <li class="list-group-item">
                <span class="badge">
                    <s:property value="#resultName[#solution.result]"/>
                </span>
                结果    </li>
            <li class="list-group-item">
                <span class="badge">
                    <s:property value="#solution.runTime" /> ms</span>
                耗时    </li>
            <li class="list-group-item">
                <span class="badge">
                    <s:property value="#solution.runMemory"/>kb</span>
                内存    </li>
        </ul>
<pre class="prettyprint linenums solution-code col-sm-10">
<s:property value="#source.source" escape="true"/>
</pre>
    </div>
</div>
</body>
</html>