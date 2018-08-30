<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Welcome ${dateAndTime}</h1>
<c:forEach var="i" begin="1" end="10">
    <p>${i}</p>
</c:forEach>