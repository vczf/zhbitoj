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
    <style>
        .btn {
            padding: 4px 8px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<jsp:include page="/elements/user_body.jsp"/>
<div class="container">

    <s:include value="/pages/contest/user_contest_head.jsp"/>
    <s:include value="/pages/contest/user_contest_manu.jsp"/>

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
    <s:set var="languages" value="{'C','C++'}"/>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>编号</th>
            <th>题号</th>
            <th>用户</th>
            <th>结果</th>
            <th>耗时</th>
            <th>内存</th>
            <th>语言</th>
            <th>长度</th>
            <th>时间</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="#request.status" var="item">
            <tr>
                <td>
                    <s:property value="#item.solutionId"/>
                </td>
                <td>
                    <a href="/contest/problem_show?contestId=<s:property value="contestId"/>&problemId=<s:property value="#item.problemId"/>"><s:property
                            value="#item.problemId"/></a></td>
                <td>
                    <a href="/user/info?userName=<s:property value="#item.userName" />">
                        <s:property value="#item.userName"/>
                    </a>
                </td>
                <td>
                    <s:set name="result_class" value="'btn-danger'"/>
                    <s:if test="#item.result==11">
                        <s:set name="result_class" value="'btn-warning'"/>
                    </s:if>
                    <s:if test="#item.result==4">
                        <s:set name="result_class" value="'btn-success'"/>
                    </s:if>
                    <s:if test="#item.result<=1">
                        <s:set name="result_class" value="'btn-default'"/>
                    </s:if>
                    <s:if test="#item.result==11">
                        <a href="/ce?solutionId=<s:property value="#item.solutionId" /> ">
                            <span class="btn btn-warning">
                                <s:property value="#resultName[#item.result]" escape="false"/>
                            </span>
                        </a>
                    </s:if>
                    <s:else>
                         <span class="btn <s:property value="#result_class"/> ">
                                <s:property value="#resultName[#item.result]" escape="false"/>
                         </span>
                    </s:else>
                </td>
                <td><s:property value="#item.runTime"/>ms</td>
                <td><s:property value="#item.runMemory"/>kb</td>
                <td><s:property value="#languages[#item.language]"/></td>
                <td>
                    <s:if test="#session.USER_ROLE>0 || #session.USER_NAME==#item.userName">
                        <a href="/source?id=<s:property value="#item.solutionId" />" title="click view details">
                            <s:property value="#item.codeLength"/>B
                        </a>
                    </s:if>
                    <s:else>
                        <s:property value="#item.codeLength"/>B
                    </s:else>
                </td>
                <td>
                    <s:date name="#item.inDate" format="yyyy-MM-dd HH:mm:ss"/>
                </td>

            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>

</body>
</html>
