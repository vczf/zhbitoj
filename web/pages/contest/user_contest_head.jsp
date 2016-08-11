<%--
  Created by IntelliJ IDEA.
  User: czf
  Date: 16-6-19
  Time: 下午3:00
  To change this template use File | Settings | File Templates.
--%>

        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="s" uri="/struts-tags" %>
        <h3 class="page-title"><s:property value="#request.contest.title"/> </h3>
        <div class="contest-info">
            开始于：
            <span class="label label-success">
                <s:date name="#request.contest.start_time" format="yyyy-MM-dd HH:mm:ss"/>
            </span>
            结束于：
            <span class="label label-danger">
                <s:date name="#request.contest.end_time" format="yyyy-MM-dd HH:mm:ss"/>
            </span>
            刷新时间：
            <span class="label label-warning">
                <s:date name="#request.current" format="yyyy-MM-dd HH:mm:ss"/>
            </span>
        </div>