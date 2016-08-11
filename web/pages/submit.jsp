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
        form.submit {
            width: 100%;
            max-width: 600px;
            margin: 10px auto 50px;
        }
    </style>
</head>
<body>

<s:include value="/elements/user_body.jsp" />

<div class="container">


    <s:if test="contestId!=null && contestId!=''">
        <form role="form" class="form-horizontal submit" action="/contest/submit_post?contestId=<s:property value="contestId" />" method="post">
        <input name="contestId" type="hidden" value="<s:property value="contestId" />" />   <!-- 不够细心 -->
    </s:if>

    <s:else>
        <form role="form" class="form-horizontal submit" action="/submit_post" method="post">
    </s:else>

    <fieldset>
            <div class="form-group">
                <%--@declare id="pid"--%><label class="control-label col-sm-3" for="pid">题号</label>
                <div class="col-sm-9">
                    <input class="form-control" name="problemId" value="<s:property value="problemId"/>">
                    <s:if test="fieldErrors.problemId!=null">
                        <div class="has-error"><s:property value="fieldErrors.problemId[0]"/> </div>
                    </s:if>
                </div>
            </div>
            <div class="form-group">
                <%--@declare id="language"--%><label for="language" class="control-label col-sm-3">语言</label>
                <div class="col-sm-9">
                    <select name="language" class="form-control">
                        <option value="0" selected>
                            C
                        </option>
                        <option value="1" >
                            C++
                        </option>
                    </select>
                </div>
            </div>
        </fieldset>
        <div class="form-group">
            <textarea class="form-control" cols="50" rows="20" name="source" maxlength="65535" spellcheck="false"><s:property value="source"/></textarea>
            <s:if test="fieldErrors.source!=null">
                <div class="has-error"><s:property value="fieldErrors.source[0]"/> </div>
            </s:if>

        </div>
        <div class="form-group" id="fn-nav">
            <div>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>