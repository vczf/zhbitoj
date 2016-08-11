<%--
  Created by IntelliJ IDEA.
  User: czf
  Date: 16-6-16
  Time: 下午11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <s:include value="/elements/user_head.jsp" />
</head>
<body>
    <s:include value="/elements/user_body.jsp"/>
    <div class="container">
        <div class="edit-userinfo">
            <h3 class="page-title">用户修改</h3>
            <form action="/user/user_edit" method="POST" class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="control-label col-sm-5" for="nick">昵称</label>
                    <div class="col-sm-7">
                        <input class="form-control" id="nick" name="nick" type="text" value="<s:property value="#request.user.nick"/> ">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5" for="nick">签名</label>
                    <div class="col-sm-7">
                        <input class="form-control" id="note" name="note" type="text" value="<s:property value="#request.user.note"/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5" for="newpwd">修改密码</label>
                    <div class="col-sm-7">
                        <input class="form-control" id="newpwd" name="newpassword" type="password" value="" placeholder="无输入则不修改">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5" for="repwd">重复密码</label>
                    <div class="col-sm-7">
                        <input class="form-control" id="repwd" name="confirm" type="password" value="" placeholder="两次输入密码必须相同">
                        <div class="has-error"><s:property value="#fieldErrors['comfirm'][0]"/> </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5" for="school">学校</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="school" id="school" type="text" value="<s:property value="#request.user.studentId"/>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-5" for="email">邮箱</label>
                    <div class="col-sm-7">
                        <input class="form-control" name="email" id="email" type="email" value="<s:property value="#request.user.email"/>">

                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-7">
                        <input type="submit" value="保存修改" class="btn-primary btn" id="submit">
                    </div>
                </div>
            </form>
            <s:debug></s:debug>
            <script type="text/javascript" data-turbolinks-eval="true">
                $(function(){
                    $("input.pop").popover({
                        trigger: 'focus',
                        offset: 10
                    })
                });
                $(function(){
                    $('#submit').click(function(){
                        var pwd = $('#password').val();
                        if (pwd.length == 0) {
                            $('#password').popover('show');
                            return false;
                        }
                        if ($('#newpwd').val() != $('#repwd').val()){
                            $('#repwd').popover({
                                container: 'body',
                                content: '密码不相同',
                                offset: 10,
                                trigger: 'focus'
                            }).popover('show');
                            return false;
                        }
                        return true;
                    })
                });
            </script>
        </div>
    </div>


</body>
</html>
