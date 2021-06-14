<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/head.jsp"/>
<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/navbar.jsp"/>

<main>
    <div class="user_info">
        <div class="user_avatar">
            <img src="${usuario_logeado.user_avatar}" alt="Avatar del usuario">
        </div>

        <div class="user_name">
            <h2>Bienvenido ${usuario_logeado.user_name}</h2>
            <p>Email - ${usuario_logeado.user_email}</p>
            <p>Miembro desde - ${usuario_logeado.fecha_creacion}</p>
        </div>
    </div>

    <button class="tablink" onclick="openPage('Home', this, 'grey')">Peliculas</button>
    <button class="tablink" onclick="openPage('News', this, 'grey')">Series</button>

        
    <div id="Home" class="tabcontent">
      <div class="valorar_peliculas">
        <h3>Valora una película:</h3>
        <form action="perfil" method="post">
        <label for="listapeliculas">Título de la película</label>
        <br>
		<select id="listapeliculas" name="id">
			<c:forEach var="pIteracion" items="${listapeliculas}">
		 		<option value="${pIteracion.id}">${pIteracion.multimediaNombre}</option>
		  	</c:forEach>
		</select>
		<br>
		<br>
          
          <label for="puntuacionpelicula">Elige una puntuación del 0 al 10:</label><br><br>
          <input type="range" id="puntuacionpelicula" 
          name="puntuacion" min="0" max="10" value="5" step="1"
          oninput="amount.value=puntuacion.value">
          <output name="amount" id="amount" for="puntuacion">5</output><br><br><br>
          <label for="comentariopelicula">Comentario (opcional)</label><br>
          <input type="text" id="comentariopelicula" name="comentario" maxlength="100" placeholder="Máximo 100 caracteres"><br>
          <input type="submit" value="Enviar">
        </form>
      </div>

      <div class="peliculas_container">
      <h3 id="peliculas_titulo">Tus peliculas valoradas</h3>
        <table class="peliculas_valoradas">
          <tr>
            <th>Nombre</th>
            <th>Puntuación</th>
            <th>Editar puntuación</th>
          </tr>
  <c:forEach var="pIteracion" items="${peliculas}">
      <tr>
        <td>${pIteracion.multimediaNombre}</td>
        <td>${pIteracion.multimediaNotaMedia}</td>
        <td><a href="valoracion-editar?id_multimedia=${pIteracion.id}"><i class="fas fa-edit"></i></a></td>
      </tr>
     </c:forEach>
        </table>
      </div>
    </div>
    
    <div id="News" class="tabcontent">
      <div class="valorar_series">
        <h3>Valora una serie:</h3>
        <form action="perfil" method="post">
        <label for="listaseries">Título de la serie</label>
        <br>
		<select id="listaseries" name="id">
			<c:forEach var="pIteracion" items="${listaseries}">
		 		<option value="${pIteracion.id}">${pIteracion.multimediaNombre}</option>
		  	</c:forEach>
		</select>
		<br>
		<br>
         <label for="puntuacionserie">Elige una puntuación del 0 al 10:</label><br><br>
         <input type="range" id="puntuacionserie" 
         name="puntuacion" min="0" max="10" value="5" step="1"
         oninput="amount.value=puntuacion.value">
         <output name="amount" id="amount" for="puntuacion">5</output><br><br><br>
         <label for="comentarioserie">Comentario (opcional)</label><br>
         <input type="text" id="comentarioserie" name="comentario" maxlength="100" placeholder="Máximo 100 caracteres"><br>
         <input type="submit" value="Enviar">
       </form>
     </div>


      <div class="series_container">
      <h3 id="series_titulo">Tus series valoradas</h3>
      <table class="series_valoradas">
        <tr>
          <th>Nombre</th>
          <th>Puntuación</th>
          <th>Editar puntuación</th>
        </tr>
  <c:forEach var="pIteracion" items="${series}">
      <tr>
        <td>${pIteracion.multimediaNombre}</td>
        <td>${pIteracion.multimediaNotaMedia}</td>
        <td><a href="valoracion-editar?id_multimedia=${pIteracion.id}"><i class="fas fa-edit"></i></a></td>
      </tr>
     </c:forEach>
      </table>
    </div>
  </div>
</main>
    
<jsp:include page="plantillas/footer.jsp"/>