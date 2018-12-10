<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit</title>
</head>
<body>
    <div class="form">
    ${image}
    <form:form action="saveaddress" method="POST" modelAttribute="add">
    <table align="center">
    
    <h1 align="center">Enter user details</h1>
    
    
            <form:hidden path="id"/>
            
           
            <tr>
                <td>City:</td>
                <td><input type="text" name="city" required></td>
            </tr>
            
            <tr>
                <td>State:</td>
                <td><input type="text" name="state" required></td>
            </tr>
            
            
            <tr>
                <td>Country:</td>
                <td><input type="text" name="country" required></td>
            </tr>
            
            
            
            
            
            
           
            
            </tr>
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="save"></td>
            </tr>
            
            
            </table>
    
    </form:form>
    </div>