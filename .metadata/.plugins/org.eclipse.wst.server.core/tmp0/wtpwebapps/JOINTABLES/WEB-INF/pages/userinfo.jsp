<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
    <html>
<body>

   <h1> welcome <td>${user.username}</td></h1>
<h3 align="center">User details</h3>
<div align="center">

	
 
    
    
<table style="width:2%"  border="10">
  <tr>
    <th>USER NAME</th>
    <th>FIRST NAME</th> 
    <th>LAST NAME</th>
    <th>AGE</th
    ><th>ROLE</th>
    <th>PASSWORD</th>
    <th>CITY</th>
    <th>STATE</th>
    <th>COUNTRY</th>
    <th>image</th>
    
  
    
  </tr>
		
			<c:if test="${user.role  == 'user'}">
			
			<tr>
			 
				<td>${user.username} </td>
				<td>${user.firstname}</td>
				<td>${user.lastname} </td>
				<td>${user.age}</td>
				<td>${user.role}</td>
				<td>${user.password}</td>
				<td>${user.address.city}</td>
				<td>${user.address.state}</td>
				<td>${user.address.country}</td>
				<td><img height="100" width="100" src="data:image/jpeg;base64,${user.imageData}"/></td>
				
		
			
			
				
				</tr>
			</c:if>
	
</table>

	</div>
</body>
</html>