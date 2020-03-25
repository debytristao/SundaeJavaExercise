
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <title>Home</title>
    </head>
    <body class="p-4">        
        <%@include file="WEB-INF/jspf/navigation.jspf" %>
        <h2>Sundaes Application - Create Sundae</h2>
        <form method="post">
            <table class="table">  
                <tr>
                    <td>Subtotal<br />
                    <input type="text" name="txtSundaeSubTotal" />
                    </td>
                </tr>
                <tr>
                    <td>
                    Toppings<br />
                    <c:forEach items="${ vm.getToppings() }" var="topping">
                        <input type="radio" name="chkToppings" value="${ topping.id }"/> ${ topping.name }
                    </c:forEach>
                    </td>
                </tr> 
                         
            </table>
            
            <input class="btn btn-primary" type="submit" value="Create" name="action" />
        </form>
        
      
        
        <c:if test="${error.errors != null}">
                    <ul class="alert alert-danger">
                        <c:forEach items="${error.errors}" var = "err">
                            <li>${err}</li>
                        </c:forEach>
                    </ul>
        </c:if> 
        
    </body>
</html>