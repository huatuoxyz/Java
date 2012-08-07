<%@page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>バリデーション</title>
	<link rel="stylesheet" type="text/css" href="<s:url value="/stylesheets/style.css"/>">
</head>
<body>
<div id="container">

<h1>Struts2 Validation</h1>

<hr/>

<h1>バリデーション</h1>
<h2>入力フォーム</h2>
<s:form action="/sample05/validation.action" method="post">
  <s:textfield name="employee.name" label="氏名"/>
  <s:textfield name="employee.nameKana" label="氏名（カナ）"/>
  <s:textfield name="employee.birthday" label="生年月日"/>
  <s:textfield name="employee.nyuushabi" label="入社日"/>
  <s:textfield name="employee.saraly" label="給与"/>
  <s:textfield name="employee.url" label="ホームページ"/>
  <s:textfield name="employee.email" label="メールアドレス"/>
  <s:textfield name="employee.yuubinBangou" label="郵便番号"/>
  <s:submit value="送信"/>
  <s:submit method="noValidation" value="チェックなしで送信"/>
</s:form>
</div>
</body>
</html>
