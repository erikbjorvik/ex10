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

<table border="0">
	<c:forEach items="${produkter}" var="produkt">
		<tr>
			<td>
				<h1><c:out value="${produkt.navn}" /></h1>
			</td>
		</tr>
		
		<tr>
			<td>
				<img src="images/<c:out value="${produkt.bilde}" />" alt="BILDE: <c:out value="${produkt.navn}" />" height="200px" />
			</td>
			
			<td>
				<fmt:message key="navn" />: <c:out value="${produkt.navn}" /><br />
				<fmt:message key="pris" />: <c:out value="${produkt.prisEuro}" />
				<p><fmt:message key="beskrivelse" />: <c:out value="${produkt.beskrivelse}" /></p>
				
				<form method="POST" action="Kurv">
					<input type="hidden" name="produkt" value="${produkt.nummer}" />
					<input type="submit" value="<fmt:message key="handlevogn" />" />
				</form>
			</td>
		</tr>	
	
	</c:forEach>
</table>

<jsp:include page="meny.jsp" />

</body>
</html>