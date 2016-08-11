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

        .forget-password {
            display: inline-block;
            margin-left: 30px;
            padding: 8px 12px 4px;
        }
    </style>
</head>
<body>

<s:include value="/elements/user_body.jsp"/>

<div class="container">
    <h2 class="page-title">用户登录</h2>
    <form role="form" class="form-horizontal col-sm-6 col-sm-offset-2" action="/login_post" method="post">
        <s:if test="hasFieldErrors()">
        <div class="alert alert-danger col-sm-offset-2" role="alert">
            <s:property value="fieldErrors.loginError[0]"/>
        </div>
        </s:if>
        <div class="form-group">
            <label for="username" class="control-label col-sm-4">用户名</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="username" name="userName" placeholder="用户名" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="control-label col-sm-4">密码</label>
            <div class="col-sm-8">
                <input type="password" name="password" class="form-control" id="password" placeholder="密码"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-8">
                <button type="submit" class="btn btn-primary col-sm-4">登录</button>
                <a href="#" class="forget-password">忘记密码</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>