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
<s:form>
  <s:label name="employee.name" label="氏名"/>
  <s:label name="employee.nameKana" label="氏名（カナ）"/>
  <s:label name="employee.birthday" label="生年月日"/>
  <s:label name="employee.nyuushabi" label="入社日"/>
  <s:label name="employee.saraly" label="給与"/>
  <s:label name="employee.url" label="ホームページ"/>
  <s:label name="employee.email" label="メールアドレス"/>
  <s:label name="employee.yuubinBangou" label="郵便番号"/>
</s:form>
</div>
</body>
</html>