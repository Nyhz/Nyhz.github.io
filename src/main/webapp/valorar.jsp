<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/head.jsp"/>
<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/navbar.jsp"/>

<div class="valorar_peliculas">
	<h3>Cambia tu valoración de ${valoracion.nombre}</h3>
	<br>
	<form action="valoracion-editar" method="post">
		
		<input type="hidden" name="id_multimedia" value="${valoracion.id_multimedia}" readonly>
		
		<label for="puntuacionpelicula">Elige una puntuación del 0 al 10:</label>
		<br>
		<br> 
		<input type="range" id="puntuacionpelicula"
			name="puntuacion" min="0" max="10" value="${valoracion.puntuacion}" step="1"
			oninput="amount.value=puntuacion.value">
		<output name="amount" id="amount" for="puntuacion">${valoracion.puntuacion}</output>
		<br>
		<br> 
		<label for="comentariopelicula">Comentario (opcional)</label>
		<br> 
		<textarea rows="5" cols="40" name="comentario">${valoracion.comentario }</textarea>
		<br>
		<input type="submit" value="Enviar">
	</form>
</div>

<footer class="container-footer-valorar">
	<div class="info">
       <h3>Datos de contacto</h3>
       	<p><i class="fas fa-envelope-open-text"></i>  Email de contacto - addicted@addicted.com </p>
   	</div>
  		<div class="rrss">
       	<h3>Nuestras Redes Sociales</h3>
      		 <div class="mediaIcons">
            <a href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram-square"></i></a>
            <a href="https://www.facebook.com/" target="_blank"><i class="fab fa-facebook-square"></i></a>
            <a href="https://www.twitter.com/danywtf/" target="_blank"><i class="fab fa-twitter-square"></i></a>
      		 </div>
	    	</div>
		</footer>
	</body>
</html>