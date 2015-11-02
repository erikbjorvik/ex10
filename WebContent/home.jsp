<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="lang"  />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="hjem" /></title>

</head>
<body>
<jsp:include page="spraakValg.jsp" />

<h1>Kaffekopper AS</h1>
<img src="images/coffee.png" alt="Kaffekopper AS" />
<p><fmt:message key="forside_vlkm" /></p>

<jsp:include page="meny.jsp" />

</body>
</html>