<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Welcome to Addicted.TO</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mob-navbar" aria-label="Toggle">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mob-navbar">
                <ul class="navbar-nav mb-2 mb-lg-0 mx-auto">
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'index') ? 'active' : '' }" aria-current="page" href="index?page=index">Home</a>
                    </li>
                    
                     <!--  VISIBLE SOLO PARA NO REGISTRADOS -->
                    <c:if test="${usuario_logeado == null}">
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'registro') ? 'active' : '' }" href="registro.jsp?page=registro">Registro</a>
                    </li>
                    </c:if>
                    
                    <!--  VISIBLE SOLO PARA USERS NORMALES -->
                    <c:if test="${usuario_logeado.rol > 0}">
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'perfil') ? 'active' : '' }" href="perfil?page=perfil">Mi perfil</a>
                    </li>
                    </c:if>
                    
                     <!--  VISIBLE SOLO PARA ADMINS -->
                    <c:if test="${usuario_logeado.rol == 1}">
                    <li class="nav-item">
                        <a class="nav-link ${ (param.page eq 'usuarios') ? 'active' : '' }" href="usuarios?page=usuarios">Panel Control</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Javadoc/index.html">JavaDoc</a>
                    </li>
                    </c:if>
                </ul>
                
                <c:if test="${usuario_logeado == null}">
                <form class="d-flex" action="login" method="post">
                    <input class="form-control me-2" type="text" name="user_name" id="user_name" placeholder="Username" />
                    <input class="form-control me-2" type="password" name="user_password" id="user_name" placeholder="Password" />
                    <button class="btn btn-light" type="submit">Login</button>
                </form>
                </c:if>
                
                <c:if test="${usuario_logeado != null}">
                <div class="d-flex nav-item">
			           <a class="nav-link">Bienvenido, ${usuario_logeado.user_name}</a>
			           <a class="nav-link" 
			              href="logout">Cerrar Sesión</a>
			   </div>
		        </c:if>
            </div>
            </div>
    </nav>
    
    <p id="mensajeregistro">${mensaje}</p>
    <p id="mensajeregistro">${mensajelogin}</p>