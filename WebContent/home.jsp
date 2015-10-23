<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<a href="SetLanguage?SetLang=nb-NO">Norsk</a> 
<a href="SetLanguage?SetLang=en-US">English</a> 
<a href="SetLanguage?SetLang=es-ES">Espanol</a> 

<p>
<c:out value="${velkommen}" />
</p>

</body>
</html>