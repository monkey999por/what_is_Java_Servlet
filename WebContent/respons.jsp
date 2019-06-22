<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.values.ChatValues" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./WebContent/lib/index.css">

<title>タイトルだお！</title>
</head>

<body style="background-color: #1f1300; color: white" >
<h1 style="font-weight: 700; font-style: oblique; color: green" >ヘッダーを追加するお!(^ω^)</h1>

<div class="descreption" >
<div style="font-weight: 700; font-style: oblique; font-size: 150%; color: #d048ff">descreption</div>
	--Web アプリケーションマッピングに関連付けられたパス接頭辞を指定します。<br>
	--Web サーバの URL ネーム空間のルートディレクトリにあるデフォルトのアプリケーションの場合、<br>
	--コンテキストパスは空の文字列になります。デフォルト以外のアプリケーションの場合、コンテキス<br>
	--トパスは、スラッシュ (/) で始まりますが、スラッシュで終了しません。たとえば、/techniques は<br>
	--/techniques を含んでいるリクエストを techniques アプリケーションへマッピングします。<br>
	--request.getContextPath メソッドは、コンテキストパスを示す文字列を返します。<br>
</div>
<br>

<form method="post"  action="<%=request.getContextPath() %>/ChatServlet">
	<span style="color: #7e6000">結果表示あり</span><input type="checkbox"  name="isDisplay" checked="checked" /> <span style="color: #7e6000">※未実装</span>
	<br>
		<!-- ---------------------User------------------------------ -->
		User Name <span style="margin-right: 23px"></span> :    
		<input type="text" name="user_name" /><br>		
		<!-- ---------------------Message------------------------------ -->
		Add Message<span style="margin-right: 7px"></span> :
		<input type="text" name="message" /><br>
		<!-- ---------------------Submit------------------------------ -->
		Start Request<span style="margin-right: 1px"></span> :
		<input type="submit" value="↷ Request " id="_submit"/>
</form>

<p style="font-weight: 700; font-style: oblique; font-size: 150%; color: #65edc4">chat room</p>
<p>-------------------------------------------------------------</p>

<%try{ %>
	<% ChatValues chatValues = (ChatValues) session.getAttribute("chatValues"); %>
	<%try{ %>
		<%=chatValues.disply_str %>
	<%}catch(Exception e){ %>
		<p style = "color: red">リソースがありません</p>
	<% }%>
<%}catch(Exception e){ %>
<% }%>

</body>
</html>