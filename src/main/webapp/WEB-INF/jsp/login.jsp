<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>login</title>
    </head>

<style>
button{
           display: block;
           color: white;
           background-color: #90EE90;
           height: 25px;
           width: 25%;
           margin: auto;
      }

.input-text-wrap
{
    margin-top: 10px;
    margin-bottom: 10px;
}

.center {
  position: absolute;
  top:50%;
  left: 50%;
  width:150px;
  height:150px;
  margin-top: -75px;
  margin-left: -75px;
}

.form_btn {
  width: 100px;
}

body {
  background-color: #E0FFFF ;
}

.header{
margin-left:30px
}
</style>



<body>
        <div class = "center">
            <div class = "header">Авторизация</div>
            <form action="/login" method="POST" class ="login_form">
                <div class="input-text-wrap"><input type="text" class="input-text" name="login" placeholder="Логин"></div>
                <div class="input-text-wrap"><input type="password" class="input-text" name="password" placeholder="Пароль"></div>
                  <c:forEach var="error" items="${errorMsg}">
                     <div >${error.defaultMessage}</div>
                  </c:forEach>
                <button class="form_btn">login</button>
            </form>
        </div>
    </body>
</html>
