<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/head.jsp"/>
<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/navbar.jsp"/>

<!-- **************** TABLAS ****************** -->
<main>
  <div class="container_tablas">
    <table class="top10_peliculas">
      <caption>Top 10 películas</caption>
      <tr>
        <th>Nombre</th>
        <th>Puntuación</th>
      </tr>
  <c:forEach var="pIteracion" items="${peliculas}">
      <tr>
        <td>${pIteracion.multimediaNombre}</td>
        <td>${pIteracion.multimediaNotaMedia}</td>
      </tr>
     </c:forEach>
    </table>

    <table class="top10_series">
      <caption>Top 10 series</caption>
      <tr>
        <th>Nombre</th>
        <th>Puntuación</th>
      </tr>
  <c:forEach var="pIteracion" items="${series}">
      <tr>
        <td>${pIteracion.multimediaNombre}</td>
        <td>${pIteracion.multimediaNotaMedia}</td>
      </tr>
     </c:forEach>
    </table>
  </div>

	<!-- *********************** NOTICIAS ********************** -->
	<div class="titulo_noticias">
		<h2>Noticias sobre cine y series</h2>
	</div>
	<div class="container_noticias">
	  	<div class="noticias_1">
	    <h3>Noticia 1</h3>
		    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ab veritatis tempore, impedit inventore incidunt distinctio asperiores, numquam neque quod dolorum illo porro repellat! Laborum commodi ea nisi quia inventore minima!</p>
		    <p>Suscipit nulla sit laudantium nostrum architecto, perferendis optio voluptate quo quis nam fugiat non, fuga impedit dolore eaque doloremque ad, vero qui id iste atque. Ad, sit! Eveniet, optio laborum.</p>
		    <p>Mollitia aperiam consequatur ratione laboriosam consectetur corrupti, eveniet accusantium culpa est quas, quo aut veniam perferendis dolor. Nobis, fugiat minima magni, dolor placeat dolore incidunt molestiae assumenda vero recusandae facilis.</p>
	 	</div>
	  	<div class="noticias_2">
	    <h3>Noticia 2</h3>
		    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ab veritatis tempore, impedit inventore incidunt distinctio asperiores, numquam neque quod dolorum illo porro repellat! Laborum commodi ea nisi quia inventore minima!</p>
		    <p>Suscipit nulla sit laudantium nostrum architecto, perferendis optio voluptate quo quis nam fugiat non, fuga impedit dolore eaque doloremque ad, vero qui id iste atque. Ad, sit! Eveniet, optio laborum.</p>
		    <p>Mollitia aperiam consequatur ratione laboriosam consectetur corrupti, eveniet accusantium culpa est quas, quo aut veniam perferendis dolor. Nobis, fugiat minima magni, dolor placeat dolore incidunt molestiae assumenda vero recusandae facilis.</p>
	  	</div>
	  	<div class="noticias_3">
	    <h3>Noticia 3</h3>
	    	<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ab veritatis tempore, impedit inventore incidunt distinctio asperiores, numquam neque quod dolorum illo porro repellat! Laborum commodi ea nisi quia inventore minima!</p>
	    	<p>Suscipit nulla sit laudantium nostrum architecto, perferendis optio voluptate quo quis nam fugiat non, fuga impedit dolore eaque doloremque ad, vero qui id iste atque. Ad, sit! Eveniet, optio laborum.</p>
	    	<p>Mollitia aperiam consequatur ratione laboriosam consectetur corrupti, eveniet accusantium culpa est quas, quo aut veniam perferendis dolor. Nobis, fugiat minima magni, dolor placeat dolore incidunt molestiae assumenda vero recusandae facilis.</p>
	  	</div>
	</div>
</main>

<jsp:include page="plantillas/footer.jsp"/>