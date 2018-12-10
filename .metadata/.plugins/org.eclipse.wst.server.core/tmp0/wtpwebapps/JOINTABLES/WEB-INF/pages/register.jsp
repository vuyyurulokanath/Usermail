<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>New/Edit</title>
</head>
<body>
    <div class="form">
    
    <h1 align="center">enter details</h1>
    
    
    
     <form:form action="saveuser" method="POST" modelAttribute="user" enctype="multipart/form-data">
    <table align="center">
    
  
    
    
            <form:hidden path="id"/>
            
            <tr>
            
                <td>First name:</td>
                <td><input  type="text" name="firstname" value=${user.firstname}></td>
            </tr>
            
            <tr> 
                <td>Last name:</td>
                <td><input type="text" name="lastname" value=${user.lastname}></td>
            </tr>
            
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age" value=${user.age}></td>
            </tr>
            
              
            
            <tr>
                <td>Role:</td>
                <td><input  name="role" value=user></td>
            </tr>
            

<tr>
                <td>Password:</td>
                <td><input type="text" name="password"value=${user.password}></td>
            </tr>
            
            
            <tr>
                <td>User name:</td>
                <td><input type="text" name="username" value=${user.username}></td>
            </tr>
     
            
			<tr><td>address:</td>
			 
			<td> <select id="address" name="address" required>
                    <option value="top">${user.address.city} ,${user.address.state},${user.address.country}</option>
                    <c:forEach items="${addresslists}" var="list">
                    <option value="${list.id}">${list.city},${list.state},${list.country}</option>
                    </c:forEach>
                </select></td>
				</tr>
			
			 <tr>
                    <td> choose image :</td>
                    <td><input type="file" name="file" value=${user.data}/></td>
                </tr>
			
			
                <td colspan="2" align="center"><input type="submit" value="save"></td>
            </tr>
            
			
			
				
			
	

    </table>
    </form:form>
   </div>

</body>
</html>