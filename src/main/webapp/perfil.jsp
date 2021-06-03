<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="plantillas/head.jsp"/>
<jsp:include page="plantillas/header.jsp"/>
<jsp:include page="plantillas/navbar.jsp"/>

<main>
    <div class="user_info">
        <div class="user_avatar">
            <img src="https://randomuser.me/api/portraits/men/79.jpg" alt="Avatar del usuario">
        </div>

        <div class="user_name">
            <h2>Bienvenido USERNAME</h2>
            <p>Email - username@hotmail.com</p>
            <p>Miembro desde - 28 - 05 - 2021</p>
            <p></p>
        </div>
    </div>

    <button class="tablink" onclick="openPage('Home', this, 'grey')">Peliculas</button>
    <button class="tablink" onclick="openPage('News', this, 'grey')">Series</button>

        
    <div id="Home" class="tabcontent">
      <div class="valorar_peliculas">
        <h3>Valora una película:</h3>
        <form action="#">
          <label for="titulopelicula">Título de la película:</label><br>
          <input type="text" id="titulopelicula" name="titulopelicula" required><br>
          <label for="puntuacionpelicula">Elige una puntuación del 0 al 10:</label><br><br>
          <input type="range" id="puntuacionpelicula" 
          name="rangeInput" min="0" max="10" value="5" step="1"
          oninput="amount.value=rangeInput.value">
          <output name="amount" id="amount" for="rangeInput">5</output><br><br><br>
          <label for="comentariopelicula">Comentario (opcional)</label><br>
          <input type="text" id="comentariopelicula" name="comentariopelicula" maxlength="100" placeholder="Máximo 100 caracteres"><br>
          <input type="submit" value="Enviar">
        </form>
      </div>

      <div class="peliculas_container">
      <h3 id="peliculas_titulo">Tus peliculas valoradas</h3>
        <table class="peliculas_valoradas">
          <tr>
            <th>Nombre</th>
            <th>Puntuación</th>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
          <tr>
            <td>Pelicula1</td>
            <td>10</td>
          </tr>
        </table>
      </div>
    </div>
    
    <div id="News" class="tabcontent">
      <div class="valorar_series">
        <h3>Valora una serie:</h3>
        <form action="#">
          <label for="tituloserie">Título de la serie:</label><br>
          <input type="text" id="tituloserie" name="titulopelicula" required><br>
          <label for="puntuacionserie">Elige una puntuación del 0 al 10:</label><br><br>
          <input type="range" id="puntuacionserie" 
          name="rangeInput" min="0" max="10" value="5" step="1"
          oninput="amount2.value=rangeInput.value">
          <output name="amount2" id="amount2" for="rangeInput">5</output><br><br><br>
          <label for="comentarioserie">Comentario (opcional)</label><br>
          <input type="text" id="comentarioserie" name="comentariopelicula" maxlength="100" placeholder="Máximo 100 caracteres"><br>
          <input type="submit" value="Enviar">
        </form>
      </div>


      <div class="series_container">
      <h3 id="series_titulo">Tus series valoradas</h3>
      <table class="series_valoradas">
        <tr>
          <th>Nombre</th>
          <th>Puntuación</th>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
        <tr>
          <td>Serie1</td>
          <td>10</td>
        </tr>
      </table>
    </div>
  </div>
</main>
    
<jsp:include page="plantillas/footer.jsp"/>