<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>

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

    <s:set var="resultNameMin" value="{
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
    'RE:STACK_OVERFLOW',
    'RE:DIVIDE_BY_ZERO ',
    'RE:ACCESS_VIOLATION',
    'Out of Contest Time '}"
    />

    <s:set var="languages" value="{'C','C++'}"/>


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
        .btn{
            padding :4px 8px;
            font-size:16px;
        }

    </style>


</head>
<body>


<s:include value="/elements/user_body.jsp"/>

<div class="container">
    <div>
        <div id="search-form">
            <form class="form-inline status-filter" role="form" action="status_search">
                <div class="form-group">
                    <label class="sr-only">题号</label>
                    <input placeholder="题号" name="problemId" id="pid" class="form-control"/>
                </div>
                <div class="form-group">
                    <label class="sr-only">用户</label>
                    <input placeholder="用户" name="userName" id="uid" class="form-control"/>
                </div>
                <div class="form-group">
                    <label class="sr-only">语言</label>
                    <select name="language" class="form-control">
                        <option value="-1" selected="selected">语言</option>
                        <option value="0">C</option>
                        <option value="1">C++</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="sr-only">结果</label>
                    <select name="result" class="form-control">
                        <option value="-1" selected="selected">结果</option>

                        <s:iterator var="result" value="#resultNameMin" status="rowstatus">
                            <option value="<s:property value="#rowstatus.count-1"/>">
                                <s:property value="#result"/>
                            </option>
                        </s:iterator>

                    </select>
                </div>
                <input type="submit" value="筛选" class="btn btn-default">
            </form>
        </div>
    </div>
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
        <s:set value="#request.status" var="statuses"/>

        <s:iterator var="item" value="#statuses">
            <tr>
                <td>
                    <s:property value="#item.solutionId"/>
                </td>
                <td>
                    <a href="problems_detail?pid=<s:property value="#item.problemId" />"><s:property
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
    <nav>
        <ul class="pager">
            <s:if test="%{page > 1}">
                <li class="previous"><a href="/status?page=<s:property value="%{page-1}"/> ">← 上一页</a></li>
            </s:if>

            <%--下一页--%>
            <s:set value="#request.maxPage" var="maxPage"/>
            <s:if test="%{page < #maxPage}">
                <li class="next"><a href="/status?page=<s:property value="%{page+1}"/>">下一页 →</a></li>
            </s:if>
        </ul>
    </nav>
</div>
<%--<s:property value="'adsfaasfadf<br/>nadfadf'" escape="false"/>--%>
</body>

</html>

