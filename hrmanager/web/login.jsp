<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="scripts/lib/require/require.js"></script>
<script src="scripts/require-config.js"></script>
<script>
require([ 'jquery',
    'bootstrap'
], function($) {
    $(function(){
        $('#main-model').modal({backdrop: 'static'});
        $('#main-model').modal('show');
        $('#j_username').focus();
        $('#login').click(function(){
            $('form').submit();
        });
        $('#rest').click(function(){
            $('form').reset();
        });
    });
});
</script>
</head>
<body>
<div id="container">
    <div id="logo">
        <h5>Human Resource Management System</h5>
    </div>
    <div id="menu">


    </div>
    <div id="page">
        <div id="main-model" class="modal hide fade">
            <div class="modal-header">
                <h3>LOGIN</h3>
            </div>
            <div class="modal-body" style="min-width: 300px; min-height: 300px;">
             
                <c:if test="${not empty error}">
                    <div class="errorblock">
                        Your login attempt was not successful, try again.<br /> Caused :
                        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                    </div>
                </c:if>
            
             
                <form name='f' class="form-horizontal login-form" action="<c:url value='j_spring_security_check' />"
                    method='POST'>
                    <div class="control-group">
                        <label class="control-label" for="j_username">NAME</label>
                        <div class="controls">
							<div class="input-prepend">
							  <span class="add-on"><i class="icon-user"></i></span>
							  <input type="text" id="j_username" name="j_username" placeholder="User Name">
							</div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="j_password">PASSWORD</label>
                        <div class="controls">
							<div class="input-prepend">
							  <span class="add-on"><i class="icon-certificate"></i></span>
							  <input type="password" id="j_password" name="j_password" placeholder="User Password" value="">
							</div>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <a class="btn" href="#" id="login">Login</a>
                            <a class="btn" href="#" id="reset">Reset</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="footer">
    </div>
</div>

</body>
</html>