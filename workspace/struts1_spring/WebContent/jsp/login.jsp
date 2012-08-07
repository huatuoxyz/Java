<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<title>ログイン画面</title>
<body>
  <html:form action="/login">
    ログインID : <input type="text" name="userId" value="spring" /><br/>
    パスワード : <input type="password" name="password" value="spring" /><br/>
    <html:submit value="送信"/>
  </html:form> 
</body>
</html>
