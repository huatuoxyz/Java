<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen" href="<s:url value="/stylesheets/style.css"/>" />
	<title><s:property value="title"/></title>
</head>
<body>
<div id="container">
<h1>Annotation</h1>
  
<h3>1. Actionクラスにアノテーションってのを書くことで、struts.xmlの記述を省略することができる。</h3>
  
<pre>
@Namespace("/sample02")
@Result(name="success", value="/jsp/sample02/hello.jsp")
public class SayHelloAction {
    public String execute() {
    	return "success";
    }
}
</pre>

<h3>2. web.xmlのフィルター設定に、このクラスのパッケージ名を書かないといけない。</h3>
<pre>
  &lt;filter&gt;
    &lt;filter-name&gt;struts2&lt;/filter-name&gt;
    &lt;filter-class&gt;org.apache.struts2.dispatcher.FilterDispatcher&lt;/filter-class&gt;
    &lt;init-param&gt;
      &lt;param-name&gt;actionPackages&lt;/param-name&gt;
      &lt;param-value&gt;struts2&lt;/param-value&gt;
    &lt;/init-param&gt;
  &lt;/filter&gt;
</pre>

<h3>3. クラス名は「****Action」でないといけない。</h3>
<p>HelloAction → hello.action</p>

<h3>4. successは省略できる</h3>
二つは同じ結果
<pre>
@Result(name="success", value="/jsp/sample02/hello.jsp")
@Result("/jsp/sample02/hello.jsp")
</pre>

</div>
</body>
</html>
