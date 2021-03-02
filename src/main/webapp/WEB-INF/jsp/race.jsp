<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<-- i have no fcking idea how this shat works !-->
<!DOCTYPE html>
<html>
    <body>
        <table>
          <tr>
               <th>Horse_id</th>
               <th>Horse_color</th>
          </tr>
              <c:forEach var="{id}" items="${raceObj}">
                      <tr>
                       <th>${raceObj.horses.id}</th>
                          <th>${raceObj.horses.color}</th>
                      </tr>
           </c:forEach>
        </table>
    </body>
</html>

