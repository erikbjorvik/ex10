<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="WEB-INF/tlds/dat152.tld" prefix="dat152" %>
<hr >
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="lang"  />
<p>
<a href="Home"><fmt:message key="hjem" /></a> 
<a href="Products"><fmt:message key="produkter" /></a> 
</p>

<i>© Høgskolen i Bergen <dat152:copyright nummer="2008" /></i>