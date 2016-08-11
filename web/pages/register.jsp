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
        .forget-password {
            display: inline-block;
            margin-left: 30px;
            padding: 8px 12px 4px;
        }
    </style>
</head>
<body>
<s:include value="/elements/user_body.jsp" />

<div class="container">
    <h2 class="page-title">用户注册</h2>
    <form role="form" class="form-horizontal col-sm-6 col-sm-offset-2" action="/register_post"  method="post">
        <div class="form-group">
            <label class="col-sm-5 control-label">用户名</label>
            <div class="col-sm-7">
                <input class="form-control" id="userName" name="user.userName" type="text" placeholder="3 至 15 字，字母,数字,下划线"/>

                    <div class="has-error">
                        <s:property value="fieldErrors['user.userName'][0]"/>
                    </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label">昵称</label>
            <div class="col-sm-7">
                <input class="form-control" id="nick" name="user.nick" type="text" placeholder="3 至 15 字,必填"/>
                <div class="has-error"><s:property value="fieldErrors['user.nick'][0]"/> </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label" >签名</label>
            <div class="col-sm-7">
                <input class="form-control" id="note" name="user.note" type="text" placeholder="50 字以下"/>
                    <div class="has-error"><s:property value="fieldErrors['user.note'][0]"/> </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label" >密码</label>
            <div class="col-sm-7">
                <input class="form-control" id="password" name="user.password" type="password" placeholder="6到20 字，必填"/>
                    <div class="has-error"><s:property value="fieldErrors['user.password'][0]"/> </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label" for="confirm">重复密码</label>
            <div class="col-sm-7">
                <input class="form-control" id="confirm" name="confirm" type="password" placeholder="必填"/>
                    <div class="has-error"><s:property value="fieldErrors.confirm[0]"/> </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label" for="school">学校</label>
            <div class="col-sm-7">
                <input class="form-control" name="user.studentId" id="school" type="text" placeholder="30 字以下"/>
                    <div class="has-error"><s:property value="'fieldErrors['user.studentId'][0]'"/> </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-5 control-label" for="email">邮箱</label>
            <div class="col-sm-7">
                <input class="form-control" name="user.email" id="email" type="email" placeholder="30 字以下，必填"/>
                    <div class="has-error"><s:property value="fieldErrors['user.email'][0]"/> </div>
            </div>
        </div>
       <div class="form-group">
            <div class="col-sm-offset-5 col-sm-7">
                <input type="submit" class="btn btn-primary col-sm-8" value="注册"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>