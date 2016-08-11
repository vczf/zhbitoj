<%--
  Created by IntelliJ IDEA.
  User: czf
  Date: 16-6-16
  Time: 下午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<div class="navbar navbar-inverse" role="navigation">--%>
<div class="navbar">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">ZHBITOJ</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse bs-navbar-collapse" >
            <ul class="nav navbar-nav">
                <li><a href="/index">主页</a></li>
                <li><a href="/problems">问题</a></li>
                <li><a href="/status">状态</a></li>
                <li><a href="/contest/list">比赛</a></li>
                <li><a href="/faqs">FAQ</a></li>
            </ul>
            <s:if test="#session.USER_NAME==null">
                <ul class="nav navbar-nav navbar-right nav-controls">
                    <li><a href="/login" data-no-turbolink>登录</a></li>
                    <li><a href="/register" data-no-turbolink>注册</a></li>
                </ul>
            </s:if>
            <s:else>
                <ul class="nav navbar-nav navbar-right nav-controls">
                    <li><a href="/user/info?userName=<s:property value="#session.USER_NAME"/> "
                           title="<s:property value="#session.LOGIN_USER"/>">
                        <s:property value="#session.NICK_NAME"/>
                    </a></li>
                        <%--上面写用户的地址--%>
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">More <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/user/edit_show">Edit Profile</a></li>
                            <li class="divider"></li>
                            <li><a href="/logout" data-no-turbolink="">Logout</a></li>
                                <%--这里你也懂得--%>
                        </ul>
                    </li>
                </ul>
            </s:else>
        </div><!--/.nav-collapse -->
    </div>
</nav>
    </div>


