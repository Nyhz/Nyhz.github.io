<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/head.jsp"/>
<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/navbar.jsp"/>
            
<main>
   	<div class="filtro_usuarios">
   	<form action="usuario-filtrar" method="get">
       	<label for="nombre">Filtro de búsqueda <i class="fas fa-search"></i></label>
       	<input type="text" 
              name="filtro"
              value="${filtro}"
              placeholder="Introduce username / email">   
       	<input type="submit" value="Buscar">
	</form>
   	</div>
   
    <div class="tabla_usuarios_container">
        <table class="tabla_usuarios">
            <caption>Lista de usuarios</caption>
            <tr>
                <th>ID</th>
                <th>Avatar</th>
                <th>Nombre de usuario</th>
                <th>Email</th>
                <th>Rol</th>
                <th>Fecha de alta</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach var="pIteracion" items="${usuarios}">
               <tr>
                <td>${pIteracion.id}</td>
                <td><img src="${pIteracion.user_avatar}" alt="imagen avatar usuario" class="avatar"/></td>
                <td>${pIteracion.user_name}</td>
                <td>${pIteracion.user_email}</td>
                <td>${pIteracion.rol}</td>
                <td>${pIteracion.fecha_creacion}</td>
                <td>EDITAR</td>
                <td>ELIMINAR</td>
               </tr>
            </c:forEach>
           </table>
       </div>
   </main>
<jsp:include page="plantillas/footer.jsp"/>