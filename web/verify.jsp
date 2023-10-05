<%-- 
    Document   : verify
    Created on : Oct 5, 2023, 6:28:06 PM
    Author     : Alpha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
        <span>We already send a verification code to your email.</span>
        <form action="verifyCode" method="post">
            <input type="text" name="authcode">
             <input type="submit" name="verify">
        </form>
    </body>
</html>
