<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/9/12
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/normalize/7.0.0/normalize.css">
    <link href="css/input.css" rel="stylesheet" type="text/css" media="all" />
  </head>
  <body onload="createCode()">
  <div class="form">
    <form action="AddServlet" method="post">
      <table border="0" cellspacing="5" cellpadding="5" >
        <tr>
        <td><label for="username">用户名:</label></td>
        <!-- 为每个需要的元素添加required -->
        <td><input type="text" id="username" class="required" name="username"/></td>
        </tr>
        <tr>
        <td><label for="password">密码:</label></td>
        <!-- 为每个需要的元素添加required -->
        <td><input type="password" id="password" class="required" name="password"/></td>
        </tr>
        <tr>
        <td><label for="email">邮箱:</label></td>
        <td><input type="text" id="email" class="required" name="email"/></td>
        </tr>
        <tr>
          <td>验证码：</td><td><input style="float:left;" type="text" id="inputCode" /></td><td>请输入验证码</td>
        </tr>
        <tr>
          <td></td><td> <div class="code" id="checkCode" onclick="createCode()" ></div></td>
          <td><a  href="#" onclick="createCode()">看不清换一张</a></td>
        </tr>
        <tr>
          <td></td>
        <td><input type="submit" value="提交" id="send" onclick="validateCode();">
        &nbsp;&nbsp;<input type="reset" value="重置" id="res"></td>
          <td></td>
        </tr>
      </table>
    </form>
  </div>
  <script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>
  <script language="javascript" type="text/javascript" src="js/validatecode.js"></script>
  </body>
</html>
