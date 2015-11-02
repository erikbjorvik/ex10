<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${language}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="lang" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="hjem" /></title>
</head>
<body>
<jsp:include page="spraakValg.jsp" />

<table border="1">
	<tr>
		<td>Navn</td><td>Beskrivelse</td><td>Pris</td><td>Antall</td><td>Totalt</td>
	</tr>
	
	<c:forEach items="${produkter}" var="produkt">
		<tr>
			<td><c:out value="${produkt.navn}" /></td>
			<td><c:out value="${produkt.beskrivelse}" /></td>
			<td><c:out value="${produkt.pris}" /></td>
			<td><c:out value="${produkt.antall}" /></td>
			<td>-</td>
		</tr>	
	
	</c:forEach>
</table>

<jsp:include page="meny.jsp" />

</body>
</html>