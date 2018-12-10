<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

 <form  align="right" action="newaddress">
    <input type="submit" value="ADD COUNTRY" />
</form>
<h3 align="center">ADMIN PAGE</h3>
<div align="center">

	<h5>USERS LIST</h5>

<table style="width:2%"  border="10">
  <tr>
  
    
    <th>city</th>
    <th>state</th>
    <th>country</th>
   
    </tr>
		
			<c:forEach var="listValue" items="${addresslists}">
			
			
			
			
			<tr>
			 
			
				<td>${listValue.city}</td>
				<td>${listValue.state}</td>
				<td>${listValue.country}</td>
			
				</tr>
				
				</c:forEach>
				
			
	
</table>
    </div>
    
   

</body>
</html>