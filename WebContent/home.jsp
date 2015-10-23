<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${language}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="lang"  />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

</head>
<body>
<a href="SetLanguage?SetLang=nb-NO">Norsk</a> 
<a href="SetLanguage?SetLang=en-US">English</a> 
<a href="SetLanguage?SetLang=es-ES">Espanol</a> 

<h1>Kaffekopper AS</h1>
<img src="images/coffee.png" alt="Kaffekopper AS" />
<p>
<fmt:message key="forside_vlkm" />
</p>


</body>
</html>