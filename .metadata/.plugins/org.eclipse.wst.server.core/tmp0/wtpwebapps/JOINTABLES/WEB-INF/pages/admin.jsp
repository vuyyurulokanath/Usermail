<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

 <form  align="right" action="newaddress">
    <input type="submit" value="ADD COUNTRY" />
</form>
<form  align="right" action="newuser">
    <input type="submit" value="ADD USER" />
</form>
<h3 align="center">ADMIN PAGE</h3>
<div align="center">

	<h5>USERS LIST</h5>

<table style="width:2%"  border="10">
  <tr>
  
    <th>USER NAME</th>
    <th>FIRST NAME</th> 
    <th>LAST NAME</th>
    <th>AGE</th>
    <th>role</th>
    <th>password</th>
    <th>city</th>
    <th>state</th>
    <th>country</th>
    <th>image</th>
    <th>EDIT</th>
    <th>DELETE</th>
    </tr>
		
			<c:forEach var="listValue" items="${lists}">
			<c:if test="${listValue.role=='user'}">
			
			
			
			<tr>
			 
				
				<td>${listValue.username} </td>
				<td>${listValue.firstname}</td>
				<td>${listValue.lastname} </td>
				<td>${listValue.age}</td>
				<td>${listValue.role}</td>
				<td>${listValue.password}</td>
				<td>${listValue.address.city}</td>
				<td>${listValue.address.state}</td>
				<td>${listValue.address.country}</td>
				<td><img height="40" width="45" src="data:image/jpeg;base64,${listValue.imageData}"/></td>
				
				<td><a href="edituser?id=${listValue.id}">Edit</a></td>
			
			<td><a href="<c:url value='/remove/${listValue.id}' />" >Delete</a></td>
				
				</tr>
				</c:if>
				</c:forEach>
				
			
	
</table>
    </div>
    
   

</body>
</html>