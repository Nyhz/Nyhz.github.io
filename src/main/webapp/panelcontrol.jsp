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
       	<input id="btnbuscar" type="submit" value="Buscar">
	</form>
   	</div>
   
    <div class="table-responsive-lg">
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
	            <td><a href="usuario-editar?id=${pIteracion.id}"><i class="fas fa-edit"></i></a></td>
	            <td><a onclick="confirmarEliminacion('${pIteracion.user_name}')" href="usuario-eliminar?id=${pIteracion.id}"><i class="far fa-trash-alt"></i></a></td>
               </tr>
            </c:forEach>
           </table>
           
       <script>
      	
      	function confirmarEliminacion(nombre){
      		
      		if ( window.confirm("¿ Quieres Eliminar a " + nombre + " ?") ){
      			console.debug('Eliminamos');
      		}else {
      			event.preventDefault(); // prevenir que el ancla haga su funcion
      			console.debug('No Eliminamos');
      		}
      		
      	}
      
      </script>
      </div>
   </main>
<jsp:include page="plantillas/footer.jsp"/>