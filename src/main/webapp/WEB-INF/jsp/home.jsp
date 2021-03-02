<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <body>
        <table>
          <tr>
               <th>Race_id</th>
               <th>Race_date</th>
          </tr>
              <c:forEach var="race" items="${races}">
                      <tr>
                      <form action="/race" method="GET">
                       <th>  <button name="id" value="id">${race.id}</button></th>
                       </form>
                          <th>${race.date}</th>
                      </tr>
           </c:forEach>
        </table>
    </body>
</html>