<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: czf
  Date: 16-6-19
  Time: 下午3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp"/>
</head>
<body>
    <s:include value="/elements/user_body.jsp"/>
    <div class="container">
        <s:include value="/pages/contest/user_contest_head.jsp"/>
        <div id="contest-desc" class="col-sm-6 col-sm-offset-3"  style=" font-size:1.2em;margin-top: 40px;">
            <div style="height: 300px;background-color:#f5f5f5; border: 1px solid #ccc; border-radius: 4px;padding: 10px;">
                <p>
                    <s:property value="#request.contest.description" />
                </p>
            </div>
            <ul id="fn-nav" class="nav nav-pills" >
                <li><a href="/contest/list?page=1" >返 回</a></li>

                <%--根据状态确定按钮--%>
                <s:if test="%{#request.contest.status()==-1 && #request.auth == false}">
                    <li>
                        <a href="/contest/register?contestId=<s:property value="contestId"/>">
                            报名参赛
                        </a>
                    </li>
                </s:if>
                <s:elseif test="#request.contest.status()==-1">
                    <li>比赛未开始</li>
                </s:elseif>
                <s:elseif test="%{(#request.contest.status()==0 && #request.auth == true)||#session.USER_ROLE==1}">
                    <li>
                        <a href="/contest/problem_list?contestId=<s:property value="contestId"/> ">
                        进入比赛
                        </a>
                    </li>

                </s:elseif>
                <s:elseif test="#request.contest.status()==0">
                    <li>比赛进行中</li>
                </s:elseif>
                <s:if test="#request.contest.status()==1">
                    <li>比赛结束</li>
                </s:if>
            </ul>
        </div>
    </div>

</body>
</html>
